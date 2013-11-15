package de.zalando.shop.test.swing.model;

import java.util.Date;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import de.zalando.shop.test.dto.ArticleDetailReviewDTO;
import de.zalando.shop.test.dto.ArticleDetailReviewDTOList;

/**
 * A table model for article reviews.
 *
 * @author  rnascimento
 */
public class ArticleReviewTableModel implements TableModel {

    public static final int COLUMN_ARTICLE_SKU = 0;

    public static final int COLUMN_AUTHOR = 1;

    public static final int COLUMN_CITY = 2;

    public static final int COLUMN_DATE = 3;

    public static final int COLUMN_RATING = 4;

    public static final int COLUMN_SUBJECT = 5;

    public static final int COLUMN_TEXT = 6;

    private ArticleDetailReviewDTOList reviews;

    private EventListenerList listeners;

    public ArticleReviewTableModel() {
        reviews = new ArticleDetailReviewDTOList();
        listeners = new EventListenerList();
    }

    public void setArticleReviews(final ArticleDetailReviewDTOList newReviews) {
        if (newReviews != null) {
            this.reviews = newReviews;
        } else {
            this.reviews = new ArticleDetailReviewDTOList();
        }

        TableModelEvent event = new TableModelEvent(this);
        for (TableModelListener listener : listeners.getListeners(TableModelListener.class)) {
            listener.tableChanged(event);
        }
    }

    public ArticleDetailReviewDTOList getArticleReviews() {
        return reviews;
    }

    @Override
    public int getRowCount() {
        return reviews.getCount();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        switch (columnIndex) {

            case COLUMN_ARTICLE_SKU :
                return "Article SKU";

            case COLUMN_AUTHOR :
                return "Author";

            case COLUMN_CITY :
                return "City";

            case COLUMN_DATE :
                return "Date";

            case COLUMN_RATING :
                return "Rating";

            case COLUMN_SUBJECT :
                return "Subject";

            case COLUMN_TEXT :
                return "Text";
        }

        return "";
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        if (columnIndex == COLUMN_DATE) {
            return Date.class;
        }

        if (columnIndex == COLUMN_RATING) {
            return Float.class;
        }

        return String.class;
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        if (rowIndex >= 0 && rowIndex < reviews.getCount()) {
            if (columnIndex >= 0 && columnIndex <= 6) {
                ArticleDetailReviewDTO dto = reviews.getData().get(rowIndex);
                switch (columnIndex) {

                    case COLUMN_ARTICLE_SKU :
                        return dto.getArticleSku();

                    case COLUMN_AUTHOR :
                        return dto.getAuthor();

                    case COLUMN_CITY :
                        return dto.getCity();

                    case COLUMN_DATE :
                        return (dto.getDate() <= 0) ? null : new Date(dto.getDate());

                    case COLUMN_RATING :
                        return dto.getRating();

                    case COLUMN_SUBJECT :
                        return dto.getSubject();

                    case COLUMN_TEXT :
                        return dto.getText();
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
