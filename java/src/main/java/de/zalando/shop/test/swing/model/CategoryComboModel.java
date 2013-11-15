package de.zalando.shop.test.swing.model;

import javax.swing.ComboBoxModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import de.zalando.shop.test.dto.CategoryDTO;
import de.zalando.shop.test.dto.CategoryDTOList;

/**
 * A model for combo boxes to choose a category.
 *
 * @author  rnascimento
 */
public class CategoryComboModel implements ComboBoxModel<String> {

    private CategoryDTOList categories;

    private CategoryDTO selectedCategory;

    private EventListenerList listeners;

    public CategoryComboModel() {
        this.categories = new CategoryDTOList();
        this.selectedCategory = null;
        this.listeners = new EventListenerList();
    }

    public void setCategories(final CategoryDTOList newCategories) {
        int oldIndex = this.categories.getCount() - 1;
        if (newCategories != null) {
            this.categories = newCategories;
        } else {
            this.categories = new CategoryDTOList();
        }

        ListDataEvent evnt = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, Math.max(0, oldIndex));
        for (ListDataListener listener : listeners.getListeners(ListDataListener.class)) {
            listener.contentsChanged(evnt);
        }
    }

    public String getSelectedCategory() {
        if (this.selectedCategory == null) {
            return null;
        }

        return this.selectedCategory.getUrlKey();
    }

    @Override
    public void setSelectedItem(final Object anItem) {
        if (anItem == null || !(anItem instanceof CategoryDTO || anItem instanceof String)) {
            return;
        }

        String name = (anItem instanceof CategoryDTO) ? (((CategoryDTO) anItem).getName()) : ((String) anItem);
        for (CategoryDTO dto : categories.getData()) {
            if (dto.getName().equals(name)) {
                this.selectedCategory = dto;
                return;
            }
        }

        this.selectedCategory = null;
    }

    @Override
    public Object getSelectedItem() {
        return selectedCategory == null ? null : selectedCategory.getName();
    }

    @Override
    public int getSize() {
        return this.categories.getCount();
    }

    @Override
    public String getElementAt(final int index) {
        if (index < 0 || index >= this.categories.getCount()) {
            return null;
        }

        return this.categories.getData().get(index).getName();
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
