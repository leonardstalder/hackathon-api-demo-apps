package de.zalando.shop.test.swing.model;

import java.util.List;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import de.zalando.shop.test.dto.AttributeDTO;
import de.zalando.shop.test.dto.AttributeDTOList;
import de.zalando.shop.test.dto.DTOList;

/**
 * A model for the tree of categories.
 *
 * @author  rnascimento
 */
public class AttributeTreeModel implements TreeModel {

    private static final RootClass ROOT = new RootClass();

    private AttributeDTOList attributes;

    private EventListenerList listeners;

    public AttributeTreeModel() {
        this.attributes = new AttributeDTOList();
        this.listeners = new EventListenerList();
    }

    public void setAttributes(final AttributeDTOList newAttributes) {
        this.attributes = newAttributes;
        if (this.attributes == null) {
            this.attributes = new AttributeDTOList();
        }

        TreeModelEvent evnt = new TreeModelEvent(this, new Object[] {ROOT});
        for (TreeModelListener listener : listeners.getListeners(TreeModelListener.class)) {
            listener.treeStructureChanged(evnt);
        }
    }

    @Override
    public Object getRoot() {
        return ROOT;
    }

    @Override
    public Object getChild(final Object parent, final int index) {
        if (parent == null || !(parent instanceof RootClass || parent instanceof AttributeDTO)) {
            return null;
        }

        if (parent instanceof RootClass) {
            List<AttributeDTO> dtos = attributes.getData();
            if (index < 0 || index >= dtos.size()) {
                return null;
            }

            return dtos.get(index);
        }

        AttributeDTO attribute = (AttributeDTO) (parent);
        if (index < 0 || index >= attribute.getValues().getCount()) {
            return null;
        }

        return attribute.getValues().getData().get(index);
    }

    @Override
    public int getChildCount(final Object parent) {
        if (parent == null || !(parent instanceof RootClass || parent instanceof AttributeDTO)) {
            return 0;
        }

        if (parent instanceof RootClass) {
            return attributes.getCount();
        }

        AttributeDTO attribute = (AttributeDTO) (parent);
        return attribute.getValues().getCount();
    }

    @Override
    public boolean isLeaf(final Object node) {
        if (node instanceof RootClass) {
            return (attributes.getCount() == 0);
        }

        if (node instanceof AttributeDTO) {
            return ((AttributeDTO) node).getValues().getCount() == 0;
        }

        return true;
    }

    @Override
    public void valueForPathChanged(final TreePath path, final Object newValue) {
        throw new UnsupportedOperationException("No direct tree changes allowed.");
    }

    @Override
    public int getIndexOfChild(final Object parent, final Object child) {
        if (parent == null || !(parent instanceof RootClass || parent instanceof AttributeDTO)) {
            return -1;
        }

        DTOList<?> dtoList;
        if (parent instanceof RootClass) {
            dtoList = attributes;
        } else {
            AttributeDTO attribute = (AttributeDTO) (parent);
            dtoList = attribute.getValues();
        }

        for (int k = 0; k < dtoList.getCount(); k++) {
            if (dtoList.getData().get(k).equals(child)) {
                return k;
            }
        }

        return -1;
    }

    @Override
    public void addTreeModelListener(final TreeModelListener l) {
        if (l != null) {
            listeners.add(TreeModelListener.class, l);
        }
    }

    @Override
    public void removeTreeModelListener(final TreeModelListener l) {
        if (l != null) {
            listeners.remove(TreeModelListener.class, l);
        }
    }

    private static final class RootClass {

        @Override
        public String toString() {
            return "Attributes";
        }

    }
}
