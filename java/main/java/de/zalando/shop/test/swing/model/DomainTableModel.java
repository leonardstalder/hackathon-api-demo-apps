package de.zalando.shop.test.swing.model;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.zalando.shop.test.dto.DomainDTO;
import de.zalando.shop.test.dto.DomainDTOList;

/**
 * A table model for domains.
 *
 * @author  rnascimento
 */
public class DomainTableModel implements TableModel {

    public static final int COLUMN_URL = 0;

    public static final int COLUMN_MOBILE_URL = 1;

    public static final int COLUMN_LOCALE = 2;

    public static final int COLUMN_BASKET_URL = 3;

    public static final int COLUMN_CURRENCY_CODE = 4;

    private DomainDTOList domains;

    private EventListenerList listeners;

    public DomainTableModel() {
        domains = new DomainDTOList();
        listeners = new EventListenerList();
    }

    public void setDomains(final DomainDTOList newDomains) {
        if (newDomains != null) {
            this.domains = newDomains;
        } else {
            this.domains = new DomainDTOList();
        }

        TableModelEvent event = new TableModelEvent(this);
        for (TableModelListener listener : listeners.getListeners(TableModelListener.class)) {
            listener.tableChanged(event);
        }
    }

    public DomainDTOList getDomains() {
        return domains;
    }

    @Override
    public int getRowCount() {
        return domains.getCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        switch (columnIndex) {

            case COLUMN_URL :
                return "URL";

            case COLUMN_MOBILE_URL :
                return "Mobile URL";

            case COLUMN_LOCALE :
                return "Locale";

            case COLUMN_BASKET_URL :
                return "Basket URL";

            case COLUMN_CURRENCY_CODE :
                return "Currency Code";
        }

        return "";
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        if (rowIndex >= 0 && rowIndex < domains.getCount()) {
            if (columnIndex >= 0 && columnIndex <= 4) {
                DomainDTO dto = domains.getData().get(rowIndex);
                switch (columnIndex) {

                    case COLUMN_BASKET_URL :
                        return dto.getBasketUrl();

                    case COLUMN_CURRENCY_CODE :
                        return dto.getCurrencyCode();

                    case COLUMN_LOCALE :
                        return dto.getLocale();

                    case COLUMN_MOBILE_URL :
                        return dto.getMobileUrl();

                    case COLUMN_URL :
                        return dto.getUrl();
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
