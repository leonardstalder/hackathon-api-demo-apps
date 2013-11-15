package de.zalando.shop.test.dto;

import java.awt.Image;

/**
 * DTO that holds information about a brand.
 *
 * @author  rnascimento
 */
public class BrandDTO {

    private String urlKey;

    private String name;

    private String logoURL;

    private String brandCode;

    private String description;

    private Image logo;

    public BrandDTO() {
        this.urlKey = null;
        this.name = null;
        this.logoURL = null;
        this.brandCode = null;
        this.description = null;
        this.logo = null;
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

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(final String logoURL) {
        this.logoURL = logoURL;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(final String brandCode) {
        this.brandCode = brandCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(final Image logo) {
        this.logo = logo;
    }
}
