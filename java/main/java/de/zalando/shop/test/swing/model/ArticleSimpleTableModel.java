package de.zalando.shop.test.swing.model;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.zalando.shop.test.dto.ArticleDetailSimpleDTO;
import de.zalando.shop.test.dto.ArticleDetailSimpleDTOList;

/**
 * A table model for article simples.
 *
 * @author  rnascimento
 */
public class ArticleSimpleTableModel implements TableModel {

    public static final int COLUMN_SKU = 0;

    public static final int COLUMN_EAN = 1;

    public static final int COLUMN_SIZE = 2;

    public static final int COLUMN_STOCK_AVAILABLE = 3;

    public static final int COLUMN_ADD_TO_BASKET_URL = 4;

    private ArticleDetailSimpleDTOList simples;

    private EventListenerList listeners;

    public ArticleSimpleTableModel() {
        simples = new ArticleDetailSimpleDTOList();
        listeners = new EventListenerList();
    }

    public void setArticleSimples(final ArticleDetailSimpleDTOList newSimples) {
        if (newSimples != null) {
            this.simples = newSimples;
        } else {
            this.simples = new ArticleDetailSimpleDTOList();
        }

        TableModelEvent event = new TableModelEvent(this);
        for (TableModelListener listener : listeners.getListeners(TableModelListener.class)) {
            listener.tableChanged(event);
        }
    }

    public ArticleDetailSimpleDTOList getArticleSimples() {
        return simples;
    }

    @Override
    public int getRowCount() {
        return simples.getCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        switch (columnIndex) {

            case COLUMN_ADD_TO_BASKET_URL :
                return "Add to basket URL";

            case COLUMN_EAN :
                return "EAN";

            case COLUMN_SIZE :
                return "Size";

            case COLUMN_SKU :
                return "SKU";

            case COLUMN_STOCK_AVAILABLE :
                return "Stock";
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
        if (rowIndex >= 0 && rowIndex < simples.getCount()) {
            if (columnIndex >= 0 && columnIndex <= 4) {
                ArticleDetailSimpleDTO dto = simples.getData().get(rowIndex);
                switch (columnIndex) {

                    case COLUMN_ADD_TO_BASKET_URL :
                        return dto.getAddToBasketUrl();

                    case COLUMN_EAN :
                        return dto.getEan();

                    case COLUMN_SIZE :
                        return dto.getSize();

                    case COLUMN_SKU :
                        return dto.getSku();

                    case COLUMN_STOCK_AVAILABLE :
                        return dto.isStockAvailable() ? "Available" : "Not available";
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
