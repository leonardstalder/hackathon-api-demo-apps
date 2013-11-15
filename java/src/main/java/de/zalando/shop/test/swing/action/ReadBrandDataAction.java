package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.BrandDTOList;
import de.zalando.shop.test.swing.model.BrandTableModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a fetch of brand information.
 *
 * @author  rnascimento
 */
public class ReadBrandDataAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public ReadBrandDataAction(final BrandTableModel brandTableModel, final DomainComboModel domainComboModel) {
        super("Read brands");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_B);
        putValue("BRANDTABLEMODEL", brandTableModel);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
    }

    private BrandTableModel getBrandTableModel() {
        return (BrandTableModel) getValue("BRANDTABLEMODEL");
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

        BrandDTOList result = Utils.restRequest(Utils.parseShopAddress("brands/" + domainName), BrandDTOList.class);
        getBrandTableModel().setBrands(result);
    }

}
