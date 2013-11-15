package de.zalando.shop.test.swing.model;

import javax.swing.ComboBoxModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import de.zalando.shop.test.dto.DomainDTO;
import de.zalando.shop.test.dto.DomainDTOList;

/**
 * A model for combo boxes to choose a domain.
 *
 * @author  rnascimento
 */
public class DomainComboModel implements ComboBoxModel<String>, TableModelListener {

    private DomainDTOList domains;

    private DomainDTO selectedDomain;

    private EventListenerList listeners;

    public DomainComboModel() {
        this.domains = new DomainDTOList();
        this.selectedDomain = null;
        this.listeners = new EventListenerList();
    }

    public void setDomains(final DomainDTOList newDomains) {
        int oldIndex = this.domains.getCount() - 1;
        if (newDomains != null) {
            this.domains = newDomains;
        } else {
            this.domains = new DomainDTOList();
        }

        ListDataEvent evnt = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, Math.max(0, oldIndex));
        for (ListDataListener listener : listeners.getListeners(ListDataListener.class)) {
            listener.contentsChanged(evnt);
        }
    }

    public String getSelectedDomain() {
        if (this.selectedDomain == null) {
            return null;
        }

        return this.selectedDomain.getUrl();
    }

    @Override
    public void setSelectedItem(final Object anItem) {
        if (anItem == null || !(anItem instanceof DomainDTO || anItem instanceof String)) {
            return;
        }

        String url = (anItem instanceof DomainDTO) ? (((DomainDTO) anItem).getUrl()) : ((String) anItem);
        for (DomainDTO dto : domains.getData()) {
            if (dto.getUrl().equals(url)) {
                this.selectedDomain = dto;
                return;
            }
        }

        this.selectedDomain = null;
    }

    @Override
    public Object getSelectedItem() {
        return selectedDomain;
    }

    @Override
    public int getSize() {
        return this.domains.getCount();
    }

    @Override
    public String getElementAt(final int index) {
        if (index < 0 || index >= this.domains.getCount()) {
            return null;
        }

        return this.domains.getData().get(index).getUrl();
    }

    @Override
    public void addListDataListener(final ListDataListener l) {
        listeners.add(ListDataListener.class, l);
    }

    @Override
    public void removeListDataListener(final ListDataListener l) {
        listeners.remove(ListDataListener.class, l);
    }

    @Override
    public void tableChanged(final TableModelEvent e) {
        if (e.getSource() instanceof DomainTableModel) {
            DomainDTOList newDomains = ((DomainTableModel) e.getSource()).getDomains();
            this.setDomains(newDomains);
            if (newDomains.getCount() > 0) {
                this.selectedDomain = newDomains.getData().iterator().next();
            }
        }
    }
}
