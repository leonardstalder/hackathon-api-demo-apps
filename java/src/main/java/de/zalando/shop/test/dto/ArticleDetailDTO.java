package de.zalando.shop.test.dto;

/**
 * A DTO to hold information about article details.
 *
 * @author  rnascimento
 */
public class ArticleDetailDTO {

    private String sku;

    private String urlKey;

    private String name;

    private String description;

    private float averageRating;

    private String brandCode;

    private String color;

    private String colorFamily;

    private float price;

    private float priceOriginal;

    private ArticleDetailAttributeDTOList attributes;

    private StringDTOList category;

    private ArticleDetailImagesDTO images;

    private StringDTOList otherColors;

    private ArticleDetailSimpleDTOList simples;

    private ArticleDetailReviewDTOList reviews;

    public ArticleDetailDTO() {
        this.sku = null;
        this.urlKey = null;
        this.name = null;
        this.description = null;
        this.averageRating = 0f;
        this.brandCode = null;
        this.color = null;
        this.colorFamily = null;
        this.price = 0f;
        this.priceOriginal = 0f;
        this.attributes = null;
        this.category = null;
        this.images = null;
        this.otherColors = null;
        this.simples = null;
        this.reviews = null;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(final String urlKey) {
        this.urlKey = urlKey;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(final float averageRating) {
        this.averageRating = averageRating;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(final String brandCode) {
        this.brandCode = brandCode;
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

    public ArticleDetailAttributeDTOList getAttributes() {
        return attributes;
    }

    public void setAttributes(final ArticleDetailAttributeDTOList attributes) {
        this.attributes = attributes;
    }

    public StringDTOList getCategory() {
        return category;
    }

    public void setCategory(final StringDTOList category) {
        this.category = category;
    }

    public ArticleDetailImagesDTO getImages() {
        return images;
    }

    public void setImages(final ArticleDetailImagesDTO images) {
        this.images = images;
    }

    public StringDTOList getOtherColors() {
        return otherColors;
    }

    public void setOtherColors(final StringDTOList otherColors) {
        this.otherColors = otherColors;
    }

    public ArticleDetailSimpleDTOList getSimples() {
        return simples;
    }

    public void setSimples(final ArticleDetailSimpleDTOList simples) {
        this.simples = simples;
    }

    public ArticleDetailReviewDTOList getReviews() {
        return reviews;
    }

    public void setReviews(final ArticleDetailReviewDTOList reviews) {
        this.reviews = reviews;
    }
}
