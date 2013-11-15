package de.zalando.shop.test.dto;

import java.awt.Image;

/**
 * A DTO with a collection of images of an article.
 *
 * @author  rnascimento
 */
public class ArticleDetailImagesDTO {

    private String detailUrl;

    private String largeUrl;

    private String selectorUrl;

    private Image detail;

    private Image large;

    private Image selector;

    public ArticleDetailImagesDTO() {
        this.detailUrl = null;
        this.largeUrl = null;
        this.selectorUrl = null;
        this.detail = null;
        this.large = null;
        this.selector = null;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(final String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(final String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getSelectorUrl() {
        return selectorUrl;
    }

    public void setSelectorUrl(final String selectorUrl) {
        this.selectorUrl = selectorUrl;
    }

    public Image getDetail() {
        return detail;
    }

    public void setDetail(final Image detail) {
        this.detail = detail;
    }

    public Image getLarge() {
        return large;
    }

    public void setLarge(final Image large) {
        this.large = large;
    }

    public Image getSelector() {
        return selector;
    }

    public void setSelector(final Image selector) {
        this.selector = selector;
    }
}
