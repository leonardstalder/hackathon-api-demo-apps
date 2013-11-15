package de.zalando.shop.test.dto;

import java.awt.Image;

/**
 * A DTO with information about an article on a search result.
 *
 * @author  rnascimento
 */
public class SearchResultArticleDTO {

    private String sku;

    private String name;

    private String urlKey;

    private String brandCode;

    private float price;

    private float priceOriginal;

    private String imageURL;

    private Image image;

    private boolean newArticle;

    private boolean sale;

    private boolean kids;

    private boolean overSize;

    private String color;

    private String colorFamily;

    private StringDTOList otherColors;

    public SearchResultArticleDTO() {
        this.sku = null;
        this.name = null;
        this.urlKey = null;
        this.brandCode = null;
        this.price = 0f;
        this.priceOriginal = 0f;
        this.imageURL = null;
        this.image = null;
        this.newArticle = false;
        this.sale = false;
        this.kids = false;
        this.overSize = false;
        this.color = null;
        this.colorFamily = null;
        this.otherColors = null;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(final String urlKey) {
        this.urlKey = urlKey;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(final String brandCode) {
        this.brandCode = brandCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    public float getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(final float priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(final String imageURL) {
        this.imageURL = imageURL;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(final Image image) {
        this.image = image;
    }

    public boolean isNewArticle() {
        return newArticle;
    }

    public void setNewArticle(final boolean newArticle) {
        this.newArticle = newArticle;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(final boolean sale) {
        this.sale = sale;
    }

    public boolean isKids() {
        return kids;
    }

    public void setKids(final boolean kids) {
        this.kids = kids;
    }

    public boolean isOverSize() {
        return overSize;
    }

    public void setOverSize(final boolean overSize) {
        this.overSize = overSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColorFamily() {
        return colorFamily;
    }

    public void setColorFamily(final String colorFamily) {
        this.colorFamily = colorFamily;
    }

    public StringDTOList getOtherColors() {
        return otherColors;
    }

    public void setOtherColors(final StringDTOList otherColors) {
        this.otherColors = otherColors;
    }
}
