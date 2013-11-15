package de.zalando.shop.test.dto;

/**
 * A DTO that holds information about a known term of the text classification on search results.
 *
 * @author  rnascimento
 */
public class SearchResultClassificationKnownTermDTO {

    private String parsedTerm;

    private String matchedTerm;

    private String matchType;

    public SearchResultClassificationKnownTermDTO() {
        this.parsedTerm = null;
        this.matchedTerm = null;
        this.matchType = null;
    }

    public String getParsedTerm() {
        return parsedTerm;
    }

    public void setParsedTerm(final String parsedTerm) {
        this.parsedTerm = parsedTerm;
    }

    public String getMatchedTerm() {
        return matchedTerm;
    }

    public void setMatchedTerm(final String matchedTerm) {
        this.matchedTerm = matchedTerm;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(final String matchType) {
        this.matchType = matchType;
    }
}
