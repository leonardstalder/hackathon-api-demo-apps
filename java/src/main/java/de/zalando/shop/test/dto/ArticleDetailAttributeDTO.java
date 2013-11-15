package de.zalando.shop.test.dto;

/**
 * A DTO with information about an attribute of an article.
 *
 * @author  rnascimento
 */
public class ArticleDetailAttributeDTO {

    private String attributeKey;

    private String attributeLabel;

    private StringDTOList value;

    public ArticleDetailAttributeDTO() {
        this.attributeKey = null;
        this.attributeLabel = null;
        this.value = null;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(final String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public String getAttributeLabel() {
        return attributeLabel;
    }

    public void setAttributeLabel(final String attributeLabel) {
        this.attributeLabel = attributeLabel;
    }

    public StringDTOList getValue() {
        return value;
    }

    public void setValue(final StringDTOList value) {
        this.value = value;
    }

}
