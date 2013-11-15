package de.zalando.shop.test.dto;

import java.util.Objects;

/**
 * A DTO with information about an attribute.
 *
 * @author  rnascimento
 */
public class AttributeDTO {

    private String key;

    private String label;

    private AttributeValueDTOList values;

    public AttributeDTO() {
        this.key = null;
        this.label = null;
        this.values = null;
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

    public AttributeValueDTOList getValues() {
        return values;
    }

    public void setValues(final AttributeValueDTOList values) {
        this.values = values;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.key);
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

        final AttributeDTO other = (AttributeDTO) obj;
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
