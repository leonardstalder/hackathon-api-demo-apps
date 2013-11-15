package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.ArticleDetailDTO;
import de.zalando.shop.test.swing.model.ArticleDetailModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a fetch of brand information.
 *
 * @author  rnascimento
 */
public class ReadArticleDetailsAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public ReadArticleDetailsAction(final ArticleDetailModel articleDetailModel,
            final DomainComboModel domainComboModel) {
        super("Read article details");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
        putValue("ARTICLEDETAILMODEL", articleDetailModel);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
    }

    private ArticleDetailModel getArticleDetailModel() {
        return (ArticleDetailModel) getValue("ARTICLEDETAILMODEL");
    }

    private DomainComboModel getDomainComboModel() {
        return (DomainComboModel) getValue("DOMAINCOMBOMODEL");
    }

    @Override
    protected void asyncActionPerformed(final ActionEvent e) {
        String domainName = getDomainComboModel().getSelectedDomain();
        if (domainName == null) {
            return;
        }

        String articleSKU = getArticleDetailModel().getArticleSKU();
        if (articleSKU == null || articleSKU.trim().length() == 0) {
            return;
        }

        ArticleDetailDTO result = Utils.restRequest(Utils.parseShopAddress("article/" + domainName + "/" + articleSKU),
                ArticleDetailDTO.class);
        getArticleDetailModel().setArticleDetail(result);
    }

}
