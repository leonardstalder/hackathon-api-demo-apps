package de.zalando.shop.test.dto;

/**
 * A DTO to hold information about facet data.
 *
 * @author  rnascimento
 */
public class SearchResultFacetDataDTO {

    private String key;

    private String label;

    private int articleCount;

    public SearchResultFacetDataDTO() {
        this.key = null;
        this.label = null;
        this.articleCount = 0;
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

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(final int articleCount) {
        this.articleCount = articleCount;
    }
}
