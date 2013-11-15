package de.zalando.shop.test.swing.model;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.zalando.shop.test.dto.ArticleDetailAttributeDTO;
import de.zalando.shop.test.dto.ArticleDetailAttributeDTOList;

/**
 * A table model for article reviews.
 *
 * @author  rnascimento
 */
public class ArticleAttributeTableModel implements TableModel {

    public static final int COLUMN_KEY = 0;

    public static final int COLUMN_LABEL = 1;

    public static final int COLUMN_VALUES = 2;

    private ArticleDetailAttributeDTOList attributes;

    private EventListenerList listeners;

    public ArticleAttributeTableModel() {
        attributes = new ArticleDetailAttributeDTOList();
        listeners = new EventListenerList();
    }

    public void setArticleAttributes(final ArticleDetailAttributeDTOList newAttributes) {
        if (newAttributes != null) {
            this.attributes = newAttributes;
        } else {
            this.attributes = new ArticleDetailAttributeDTOList();
        }

        TableModelEvent event = new TableModelEvent(this);
        for (TableModelListener listener : listeners.getListeners(TableModelListener.class)) {
            listener.tableChanged(event);
        }
    }

    public ArticleDetailAttributeDTOList getArticleAttributes() {
        return attributes;
    }

    @Override
    public int getRowCount() {
        return attributes.getCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        switch (columnIndex) {

            case COLUMN_KEY :
                return "Key";

            case COLUMN_LABEL :
                return "Label";

            case COLUMN_VALUES :
                return "Values";
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
        if (rowIndex >= 0 && rowIndex < attributes.getCount()) {
            if (columnIndex >= 0 && columnIndex <= 2) {
                ArticleDetailAttributeDTO dto = attributes.getData().get(rowIndex);
                switch (columnIndex) {

                    case COLUMN_KEY :
                        return dto.getAttributeKey();

                    case COLUMN_LABEL :
                        return dto.getAttributeLabel();

                    case COLUMN_VALUES :
                        return convertAttributeValues(dto);
                }
            }
        }

        return null;
    }

    private String convertAttributeValues(final ArticleDetailAttributeDTO dto) {
        if (dto == null || dto.getValue() == null || dto.getValue().getCount() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String value : dto.getValue().getData()) {
            if (first) {
                first = false;
            } else {
                result.append(", ");
            }

            result.append(value);
        }

        return result.toString();
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
