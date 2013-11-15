package de.zalando.shop.test.swing.model;

import javax.swing.ComboBoxModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import de.zalando.shop.test.dto.BrandDTO;
import de.zalando.shop.test.dto.BrandDTOList;

/**
 * A model for combo boxes to choose a brand.
 *
 * @author  rnascimento
 */
public class BrandComboModel implements ComboBoxModel<String> {

    private BrandDTOList brands;

    private BrandDTO selectedBrand;

    private EventListenerList listeners;

    public BrandComboModel() {
        this.brands = new BrandDTOList();
        this.selectedBrand = null;
        this.listeners = new EventListenerList();
    }

    public void setBrands(final BrandDTOList newBrands) {
        int oldIndex = this.brands.getCount() - 1;
        if (newBrands != null) {
            this.brands = newBrands;
        } else {
            this.brands = new BrandDTOList();
        }

        ListDataEvent evnt = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, Math.max(0, oldIndex));
        for (ListDataListener listener : listeners.getListeners(ListDataListener.class)) {
            listener.contentsChanged(evnt);
        }
    }

    public String getSelectedBrand() {
        if (this.selectedBrand == null) {
            return null;
        }

        return this.selectedBrand.getUrlKey();
    }

    @Override
    public void setSelectedItem(final Object anItem) {
        if (anItem == null || !(anItem instanceof BrandDTO || anItem instanceof String)) {
            return;
        }

        String name = (anItem instanceof BrandDTO) ? (((BrandDTO) anItem).getName()) : ((String) anItem);
        for (BrandDTO dto : brands.getData()) {
            if (dto.getName().equals(name)) {
                this.selectedBrand = dto;
                return;
            }
        }

        this.selectedBrand = null;
    }

    @Override
    public Object getSelectedItem() {
        return selectedBrand == null ? null : selectedBrand.getName();
    }

    @Override
    public int getSize() {
        return this.brands.getCount();
    }

    @Override
    public String getElementAt(final int index) {
        if (index < 0 || index >= this.brands.getCount()) {
            return null;
        }

        return this.brands.getData().get(index).getName();
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
