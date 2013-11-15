package de.zalando.shop.test.swing.model;

import de.zalando.shop.test.dto.ArticleDetailDTO;

/**
 * Interface to be implemented by the class that acts as a model for article details. The model should both provide data
 * about the fields of the form and accept data with the results.
 *
 * @author  rnascimento
 */
public interface ArticleDetailModel {

    /**
     * @return  The article SKU provided by the user.
     */
    String getArticleSKU();

    void setArticleDetail(ArticleDetailDTO articleDetail);
}
