package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import org.apache.commons.lang3.StringEscapeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zalando.shop.test.dto.SearchResultDTO;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.swing.model.SearchModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a search on articles.
 *
 * @author  rnascimento
 */
public class SearchAction extends AbstractAsynchronousAction {

    private static final Logger LOG = LoggerFactory.getLogger(SearchAction.class);

    private static final long serialVersionUID = 1L;

    public SearchAction(final SearchModel searchModel, final DomainComboModel domainComboModel) {
        super("Search");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        putValue("SEARCHMODEL", searchModel);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
    }

    private SearchModel getSearchModel() {
        return (SearchModel) getValue("SEARCHMODEL");
    }

    private DomainComboModel getDomainComboModel() {
        return (DomainComboModel) getValue("DOMAINCOMBOMODEL");
    }

    @Override
    protected void asyncActionPerformed(final ActionEvent e) {
        String url = parseUserForm();
        if (url == null) {
            return;
        }

        LOG.info("New Search: " + url);

        SearchResultDTO result = Utils.restRequest(url, SearchResultDTO.class);
        getSearchModel().setSearchResults(result);
    }

    private String parseUserForm() {
        String domainName = getDomainComboModel().getSelectedDomain();
        if (domainName == null) {
            return null;
        }

        StringBuilder resultURL = new StringBuilder();
        resultURL.append(Utils.parseShopAddress("search/" + domainName));

        SearchModel searchModel = getSearchModel();
        if (searchModel.getUserSelectedCategory() == null
                || searchModel.getUserSelectedCategory().trim().length() == 0) {
            return null;
        }

        resultURL.append("/");
        resultURL.append(searchModel.getUserSelectedCategory());
        if (searchModel.getUserSelectedBrand() != null && searchModel.getUserSelectedBrand().trim().length() > 0) {
            resultURL.append("/");
            resultURL.append(searchModel.getUserSelectedBrand());
        }

        boolean firstParameter = true;
        int pageNumber = 1;
        try {
            pageNumber = Integer.parseInt(searchModel.getUserSuppliedPage());
        } catch (Exception e) {
            // Nothing
        }

        if (pageNumber > 1) {
            firstParameter = false;
            resultURL.append("?page=");
            resultURL.append(pageNumber);
        }

        int pageSize = 100;
        try {
            pageSize = Integer.parseInt(searchModel.getUserSuppliedPageSize());
        } catch (Exception e) {
            // Nothing
        }

        if (pageSize > 0 && pageSize != 100) {
            resultURL.append(firstParameter ? "?" : "&");
            firstParameter = false;
            resultURL.append("page_size=");
            resultURL.append(pageSize);
        }

        if (searchModel.getUserSelectedSort() != null && searchModel.getUserSelectedSort().trim().length() > 0
                && !searchModel.getUserSelectedSort().equals("default")) {
            resultURL.append(firstParameter ? "?" : "&");
            firstParameter = false;
            resultURL.append("sort=");
            resultURL.append(searchModel.getUserSelectedSort());
        }

        if (searchModel.getUserSuppliedFullTextSearchKey() != null
                && searchModel.getUserSuppliedFullTextSearchKey().trim().length() > 0) {
            resultURL.append(firstParameter ? "?" : "&");
            resultURL.append("q=");
            resultURL.append(StringEscapeUtils.escapeHtml4(searchModel.getUserSuppliedFullTextSearchKey()));
        }

        return resultURL.toString();
    }
}
