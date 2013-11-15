package de.zalando.shop.test.swing.model;

import de.zalando.shop.test.dto.SearchResultDTO;

/**
 * Interface to be implemented by the class that acts as a model for search. The model should both provide data about
 * the fields of the form and accept data with the results.
 *
 * @author  rnascimento
 */
public interface SearchModel {

    String getUserSelectedCategory();

    String getUserSelectedBrand();

    String getUserSuppliedPage();

    String getUserSuppliedPageSize();

    String getUserSelectedSort();

    String getUserSuppliedFullTextSearchKey();

    void setSearchResults(SearchResultDTO searchResult);
}
