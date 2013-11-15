package de.zalando.shop.test.swing.model;

import java.awt.Image;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.zalando.shop.test.dto.BrandDTO;
import de.zalando.shop.test.dto.BrandDTOList;
import de.zalando.shop.test.util.Utils;

/**
 * A table model for brands.
 *
 * @author  rnascimento
 */
public class BrandTableModel implements TableModel {

    public static final int COLUMN_NAME = 0;

    public static final int COLUMN_URL_KEY = 1;

    public static final int COLUMN_BRAND_CODE = 2;

    public static final int COLUMN_LOGO = 3;

    public static final int COLUMN_DESCRIPTION = 4;

    private BrandDTOList brands;

    private EventListenerList listeners;

    private boolean showBrandImages;

    public BrandTableModel(final boolean showBrandImages) {
        this.showBrandImages = showBrandImages;
        brands = new BrandDTOList();
        listeners = new EventListenerList();
    }

    public void setBrands(final BrandDTOList newBrands) {
        if (newBrands != null) {
            this.brands = newBrands;
        } else {
            this.brands = new BrandDTOList();
        }

        TableModelEvent event = new TableModelEvent(this);
        for (TableModelListener listener : listeners.getListeners(TableModelListener.class)) {
            listener.tableChanged(event);
        }
    }

    @Override
    public int getRowCount() {
        return brands.getCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        switch (columnIndex) {

            case COLUMN_NAME :
                return "Name";

            case COLUMN_URL_KEY :
                return "URL Key";

            case COLUMN_BRAND_CODE :
                return "Brand Code";

            case COLUMN_LOGO :
                return "Logo";

            case COLUMN_DESCRIPTION :
                return "Description";
        }

        return "";
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        return (columnIndex == COLUMN_LOGO) ? (showBrandImages ? Image.class : String.class) : String.class;
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        if (rowIndex >= 0 && rowIndex < brands.getCount()) {
            if (columnIndex >= 0 && columnIndex <= 4) {
                BrandDTO dto = brands.getData().get(rowIndex);
                switch (columnIndex) {

                    case COLUMN_BRAND_CODE :
                        return dto.getBrandCode();

                    case COLUMN_DESCRIPTION :
                        return dto.getDescription();

                    case COLUMN_LOGO :
                        if (showBrandImages) {
                            if (dto.getLogo() == null) {
                                if (dto.getLogoURL() != null && dto.getLogoURL().trim().length() > 0) {
                                    dto.setLogo(Utils.loadImage(dto.getLogoURL()));
                                }
                            }

                            return dto.getLogo();
                        } else {
                            return dto.getLogoURL();
                        }

                    case COLUMN_NAME :
                        return dto.getName();

                    case COLUMN_URL_KEY :
                        return dto.getUrlKey();
                }
            }
        }

        return null;
    }

    @Override
    public void setValueAt(final Object aValue, final int rowIndex, final int columnIndex) {
        throw new UnsupportedOperationException("No change allowed");
    }

    @Override
    public void addTableModelListener(final TableModelListener l) {
        listeners.add(TableModelListener.class, l);
    }

    @Override
    public void removeTableModelListener(final TableModelListener l) {
        listeners.remove(TableModelListener.class, l);
    }

}
