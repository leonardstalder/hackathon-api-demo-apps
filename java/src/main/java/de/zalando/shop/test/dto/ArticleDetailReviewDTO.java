package de.zalando.shop.test.dto;

/**
 * DTO with information about a review of an article.
 *
 * @author  rnascimento
 */
public class ArticleDetailReviewDTO {

    private String articleSku;

    private String author;

    private String city;

    private long date;

    private float rating;

    private String subject;

    private String text;

    public ArticleDetailReviewDTO() {
        this.articleSku = null;
        this.author = null;
        this.city = null;
        this.date = 0L;
        this.rating = 0f;
        this.subject = null;
        this.text = null;
    }

    public String getArticleSku() {
        return articleSku;
    }

    public void setArticleSku(final String articleSku) {
        this.articleSku = articleSku;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public long getDate() {
        return date;
    }

    public void setDate(final long date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(final float rating) {
        this.rating = rating;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
