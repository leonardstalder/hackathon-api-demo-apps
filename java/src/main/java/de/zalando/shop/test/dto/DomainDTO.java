package de.zalando.shop.test.dto;

/**
 * DTO that holds information about a shop domain.
 *
 * @author  rnascimento
 */
public class DomainDTO {

    private String url;

    private String mobileUrl;

    private String locale;

    private String basketUrl;

    private String currencyCode;

    public DomainDTO() {
        this.url = null;
        this.mobileUrl = null;
        this.locale = null;
        this.basketUrl = null;
        this.currencyCode = null;
    }

    @Override
    public String toString() {
        return this.url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(final String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }

    public String getBasketUrl() {
        return basketUrl;
    }

    public void setBasketUrl(final String basketUrl) {
        this.basketUrl = basketUrl;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(final String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
