package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.BrandDTOList;
import de.zalando.shop.test.dto.CategoryDTOList;
import de.zalando.shop.test.swing.model.BrandComboModel;
import de.zalando.shop.test.swing.model.CategoryComboModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action to fill the category and brand combos on the search tab.
 *
 * @author  rnascimento
 */
public class FillSearchCombosAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public FillSearchCombosAction(final DomainComboModel domainComboModel, final CategoryComboModel categoryComboModel,
            final BrandComboModel brandComboModel) {
        super("Populate categories and brands");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
        putValue("CATEGORYCOMBOMODEL", categoryComboModel);
        putValue("BRANDCOMBOMODEL", brandComboModel);
    }

    private BrandComboModel getBrandComboModel() {
        return (BrandComboModel) getValue("BRANDCOMBOMODEL");
    }

    private CategoryComboModel getCategoryComboModel() {
        return (CategoryComboModel) getValue("CATEGORYCOMBOMODEL");
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

        BrandDTOList brands = Utils.restRequest(Utils.parseShopAddress("brands/" + domainName), BrandDTOList.class);
        CategoryDTOList categories = Utils.restRequest(Utils.parseShopAddress("categories/" + domainName),
                CategoryDTOList.class);
        getBrandComboModel().setBrands(brands);
        getCategoryComboModel().setCategories(categories);
        if (categories != null && categories.getCount() > 0) {
            getCategoryComboModel().setSelectedItem(categories.getData().iterator().next());
        }
    }

}
