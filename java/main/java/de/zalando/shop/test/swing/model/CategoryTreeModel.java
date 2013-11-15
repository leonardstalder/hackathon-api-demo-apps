package de.zalando.shop.test.swing.model;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import de.zalando.shop.test.dto.CategoryDTO;
import de.zalando.shop.test.dto.CategoryDTOList;

/**
 * A model for the tree of categories.
 *
 * @author  rnascimento
 */
public class CategoryTreeModel implements TreeModel {

    private CategoryDTOList categories;

    private CategoryDTO root;

    private EventListenerList listeners;

    public CategoryTreeModel() {
        this.categories = new CategoryDTOList();
        this.root = null;
        this.listeners = new EventListenerList();
    }

    public void setCategories(final CategoryDTOList newCategories) {
        this.categories = newCategories;
        if (this.categories == null) {
            this.categories = new CategoryDTOList();
        }

        this.root = null;

        TreeModelEvent evnt = new TreeModelEvent(this, new Object[] {getRoot()});
        for (TreeModelListener listener : listeners.getListeners(TreeModelListener.class)) {
            listener.treeStructureChanged(evnt);
        }
    }

    @Override
    public Object getRoot() {
        if (root == null) {
            for (CategoryDTO dto : categories.getData()) {
                if (dto.getParentUrlKey() == null || dto.getParentUrlKey().trim().length() == 0) {
                    root = dto;
                    break;
                }
            }
        }

        return root;
    }

    @Override
    public Object getChild(final Object parent, final int index) {
        if (parent == null || !(parent instanceof CategoryDTO) || index < 0) {
            return null;
        }

        String key = ((CategoryDTO) parent).getUrlKey();
        int count = -1;
        for (CategoryDTO dto : categories.getData()) {
            if (key.equals(dto.getParentUrlKey())) {
                count++;
                if (count == index) {
                    return dto;
                }
            }
        }

        return null;
    }

    @Override
    public int getChildCount(final Object parent) {
        if (parent == null || !(parent instanceof CategoryDTO)) {
            return 0;
        }

        String key = ((CategoryDTO) parent).getUrlKey();
        int count = 0;
        for (CategoryDTO dto : categories.getData()) {
            if (key.equals(dto.getParentUrlKey())) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean isLeaf(final Object node) {
        if (node == null || !(node instanceof CategoryDTO)) {
            return true;
        }

        String key = ((CategoryDTO) node).getUrlKey();
        for (CategoryDTO dto : categories.getData()) {
            if (key.equals(dto.getParentUrlKey())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void valueForPathChanged(final TreePath path, final Object newValue) {
        throw new UnsupportedOperationException("No direct tree changes allowed.");
    }

    @Override
    public int getIndexOfChild(final Object parent, final Object child) {
        if (parent == null || !(parent instanceof CategoryDTO) || !(child instanceof CategoryDTO)) {
            return -1;
        }

        CategoryDTO parentDTO = (CategoryDTO) parent;
        CategoryDTO childDTO = (CategoryDTO) child;
        if (!parentDTO.getUrlKey().equals(childDTO.getParentUrlKey())) {
            return -1;
        }

        String key = parentDTO.getUrlKey();
        int count = -1;
        for (CategoryDTO dto : categories.getData()) {
            if (key.equals(dto.getParentUrlKey())) {
                count++;
                if (child.equals(dto)) {
                    return count;
                }
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

}
