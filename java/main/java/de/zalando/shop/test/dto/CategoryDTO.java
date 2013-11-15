package de.zalando.shop.test.dto;

import java.util.Objects;

/**
 * DTO that holds information about a category.
 *
 * @author  rnascimento
 */
public class CategoryDTO {

    private int depth;

    private String name;

    private String urlKey;

    private String parentUrlKey;

    public CategoryDTO() {
        this.depth = 0;
        this.name = null;
        this.urlKey = null;
        this.parentUrlKey = null;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(final int depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(final String urlKey) {
        this.urlKey = urlKey;
    }

    public String getParentUrlKey() {
        return parentUrlKey;
    }

    public void setParentUrlKey(final String parentUrlKey) {
        this.parentUrlKey = parentUrlKey;
    }

    @Override
    public String toString() {
        return name + " (" + urlKey + ") - depth " + depth;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.urlKey);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final CategoryDTO other = (CategoryDTO) obj;
        if (!Objects.equals(this.urlKey, other.urlKey)) {
            return false;
        }

        return true;
    }
}
