package de.zalando.shop.test.dto;

/**
 * A DTO that holds information about a facet on search results.
 *
 * @author  rnascimento
 */
public class SearchResultFacetDTO {

    private String attributeKey;

    private SearchResultFacetDataDTOList quantities;

    public SearchResultFacetDTO() {
        this.attributeKey = null;
        this.quantities = null;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(final String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public SearchResultFacetDataDTOList getQuantities() {
        return quantities;
    }

    public void setQuantities(final SearchResultFacetDataDTOList quantities) {
        this.quantities = quantities;
    }
}
