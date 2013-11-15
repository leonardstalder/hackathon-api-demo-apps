package de.zalando.shop.test.util;

import java.awt.Image;

import java.io.IOException;

import java.net.URL;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import de.zalando.shop.test.swing.MainFrame;

/**
 * Utilities for the application.
 *
 * @author  rnascimento
 */
public final class Utils {

    /**
     * If true, then the shop address should be appended with the Hackathon API subdomain on the URL. This depends on
     * how the API is deployed. Please ask Zalando technical staff if this should be the case. The subdomain is
     * '/hackathon-api'. So, with subdomain added to the URL, a call for the list of brands, for example, would be like
     * 'http://www.zalando.de/hackathon-api/brands/www.zalando.de'.
     */
    public static final boolean APPEND_API_SUBDOMAIN = false;

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    private Utils() {
        // Nothing
    }

    /**
     * Takes the shop address provided by the user on the GUI and attempts to adjust it to be used on Rest calls. These
     * adjustments include, for example, setting the protocol if it is not provided by the user.
     *
     * @param   operation  a Rest operation to be appended to the parsed shop address.
     *
     * @return  a Rest URL to the Hackathon API.
     */
    public static String parseShopAddress(final String operation) {
        String shopAddress = MainFrame.getInstance().getShopAddress();
        shopAddress = shopAddress.trim();
        if (!shopAddress.toLowerCase().startsWith("http")) {
            shopAddress = "http://" + shopAddress;
        }

        if (!shopAddress.endsWith("/")) {
            shopAddress = shopAddress + "/";
        }

        if (APPEND_API_SUBDOMAIN) {
            shopAddress = shopAddress + "hackathon-api/";
        }

        return shopAddress + operation;
    }

    /**
     * This method does the "magic" around calling the Hackathon API. It will call a certain Rest URL and transform the
     * results, supposedly JSON text, into DTOs that can be used directly by the application.
     *
     * @param   address      the URL to call.
     * @param   resultClass  the class of the DTO that matches the JSON returned by the Rest call.
     *
     * @return  the parsed DTO with the results of the Rest call.
     */
    public static <T> T restRequest(final String address, final Class<T> resultClass) {
        LOG.info("New Rest request to address {}", address);

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        AsyncHttpClient.BoundRequestBuilder builder = asyncHttpClient.prepareGet(address);

        /*
         * We set the "Accept" header in order to force the result to be JSON.
         */
        builder.addHeader("Accept", "application/json");

        try {
            Future<Response> future = builder.execute();

            /*
             * The rest request happens here
             */
            Response response = future.get(20, TimeUnit.SECONDS);
            String responseBody = response.getResponseBody();
            // LOG.debug(responseBody);

            /*
             * GSON "automagically" parses JSON into a sweet DTO
             */
            return new GsonBuilder().create().fromJson(responseBody, resultClass);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException | JsonSyntaxException e) {
            LOG.error("Could not retrieve and parse address: " + address, e);
            return null;
        }
    }

    /**
     * Loads an image.
     *
     * @param   urlString  the URL of the image
     *
     * @return  the image loaded from the URL
     */
    public static Image loadImage(final String urlString) {
        try {
            URL url = new URL(urlString);
            LOG.info("Loading image {}", urlString);
            return ImageIO.read(url.openStream());
        } catch (Exception e) {
            LOG.error("Could not load image " + urlString, e);
            return null;
        }
    }
}
