package de.zalando.shop.test.dto;

import java.util.Objects;

/**
 * DTO that holds information about an attribute value.
 *
 * @author  rnascimento
 */
public class AttributeValueDTO {

    private String key;

    private String label;

    public AttributeValueDTO() {
        this.key = null;
        this.label = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.key);
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

        final AttributeValueDTO other = (AttributeValueDTO) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return label + " (" + key + ")";
    }
}
