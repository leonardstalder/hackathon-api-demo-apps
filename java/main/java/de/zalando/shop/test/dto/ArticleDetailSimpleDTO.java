package de.zalando.shop.test.dto;

/**
 * DTO with information about a Simple of an article.
 *
 * @author  rnascimento
 */
public class ArticleDetailSimpleDTO {

    private String sku;

    private String ean;

    private String size;

    private boolean stockAvailable;

    private String addToBasketUrl;

    public ArticleDetailSimpleDTO() {
        this.sku = null;
        this.ean = null;
        this.size = null;
        this.stockAvailable = false;
        this.addToBasketUrl = null;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(final String ean) {
        this.ean = ean;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public boolean isStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(final boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public String getAddToBasketUrl() {
        return addToBasketUrl;
    }

    public void setAddToBasketUrl(final String addToBasketUrl) {
        this.addToBasketUrl = addToBasketUrl;
    }
}
