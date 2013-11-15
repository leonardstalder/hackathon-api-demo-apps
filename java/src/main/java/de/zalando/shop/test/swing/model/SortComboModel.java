package de.zalando.shop.test.swing.model;

import javax.swing.ComboBoxModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataListener;

/**
 * A model for combo boxes to choose a sort field.
 *
 * @author  rnascimento
 */
public class SortComboModel implements ComboBoxModel<String> {

    private static final String[][] SORT_OPTIONS;

    static {
        String[][] options = new String[][] {
            new String[] {"default", "Default"}, new String[] {"activation_date", "Activation Date (Ascending)"},
            new String[] {"price_asc", "Price (Ascending)"}, new String[] {"price_desc", "Price (Descending)"},
            new String[] {"sale", "Sale first"}, new String[] {"rating", "Rating (Ascending)"},
        };
        SORT_OPTIONS = options;
    }

    private String[] selectedOption;

    private EventListenerList listeners;

    public SortComboModel() {
        this.selectedOption = SORT_OPTIONS[0];
        this.listeners = new EventListenerList();
    }

    public String getSelectedOption() {
        if (this.selectedOption == null) {
            return "default";
        }

        return this.selectedOption[0];
    }

    @Override
    public void setSelectedItem(final Object anItem) {
        if (anItem == null || !(anItem instanceof String)) {
            return;
        }

        for (String[] entry : SORT_OPTIONS) {
            if (entry[1].equals(anItem)) {
                selectedOption = entry;
                return;
            }
        }

        this.selectedOption = SORT_OPTIONS[0];
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedOption[1];
    }

    @Override
    public int getSize() {
        return SORT_OPTIONS.length;
    }

    @Override
    public String getElementAt(final int index) {
        if (index < 0 || index >= SORT_OPTIONS.length) {
            return null;
        }

        return SORT_OPTIONS[index][1];
    }

    @Override
    public void addListDataListener(final ListDataListener l) {
        listeners.add(ListDataListener.class, l);
    }

    @Override
    public void removeListDataListener(final ListDataListener l) {
        listeners.remove(ListDataListener.class, l);
    }
}
