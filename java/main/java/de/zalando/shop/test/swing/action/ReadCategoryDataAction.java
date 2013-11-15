package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.CategoryDTOList;
import de.zalando.shop.test.swing.model.CategoryTreeModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a fetch of brand information.
 *
 * @author  rnascimento
 */
public class ReadCategoryDataAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public ReadCategoryDataAction(final CategoryTreeModel categoryTreeModel, final DomainComboModel domainComboModel) {
        super("Read categories");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
        putValue("CATEGORYTREEMODEL", categoryTreeModel);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
    }

    private CategoryTreeModel getCategoryTreeModel() {
        return (CategoryTreeModel) getValue("CATEGORYTREEMODEL");
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

        CategoryDTOList result = Utils.restRequest(Utils.parseShopAddress("categories/" + domainName),
                CategoryDTOList.class);
        getCategoryTreeModel().setCategories(result);
    }

}
