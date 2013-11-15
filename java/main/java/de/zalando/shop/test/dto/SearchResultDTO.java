package de.zalando.shop.test.dto;

/**
 * A DTO to hold information about search results.
 *
 * @author  rnascimento
 */
public class SearchResultDTO {

    private SearchResultClassificationDTO fullTextSearchClassification;

    private SearchResultFacetDTOList searchFacets;

    private SearchResultArticleDTOList searchResults;

    public SearchResultDTO() {
        this.fullTextSearchClassification = null;
        this.searchFacets = null;
        this.searchResults = null;
    }

    public SearchResultClassificationDTO getFullTextSearchClassification() {
        return fullTextSearchClassification;
    }

    public void setFullTextSearchClassification(final SearchResultClassificationDTO fullTextSearchClassification) {
        this.fullTextSearchClassification = fullTextSearchClassification;
    }

    public SearchResultFacetDTOList getSearchFacets() {
        return searchFacets;
    }

    public void setSearchFacets(final SearchResultFacetDTOList searchFacets) {
        this.searchFacets = searchFacets;
    }

    public SearchResultArticleDTOList getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(final SearchResultArticleDTOList searchResults) {
        this.searchResults = searchResults;
    }
}
