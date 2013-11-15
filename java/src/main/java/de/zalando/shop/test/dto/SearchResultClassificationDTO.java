package de.zalando.shop.test.dto;

/**
 * A DTO that holds information about the text classification on search results.
 *
 * @author  rnascimento
 */
public class SearchResultClassificationDTO {

    private StringDTOList unknownTerms;

    private SearchResultClassificationKnownTermDTOList knownTerms;

    public SearchResultClassificationDTO() {
        this.unknownTerms = null;
        this.knownTerms = null;
    }

    public StringDTOList getUnknownTerms() {
        return unknownTerms;
    }

    public void setUnknownTerms(final StringDTOList unknownTerms) {
        this.unknownTerms = unknownTerms;
    }

    public SearchResultClassificationKnownTermDTOList getKnownTerms() {
        return knownTerms;
    }

    public void setKnownTerms(final SearchResultClassificationKnownTermDTOList knownTerms) {
        this.knownTerms = knownTerms;
    }
}
