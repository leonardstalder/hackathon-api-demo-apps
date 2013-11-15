package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.AttributeDTOList;
import de.zalando.shop.test.swing.model.AttributeTreeModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a fetch of brand information.
 *
 * @author  rnascimento
 */
public class ReadAttributeDataAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public ReadAttributeDataAction(final AttributeTreeModel attributeTreeModel,
            final DomainComboModel domainComboModel) {
        super("Read attributes");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
        putValue("ATTRIBUTETREEMODEL", attributeTreeModel);
        putValue("DOMAINCOMBOMODEL", domainComboModel);
    }

    private AttributeTreeModel getAttributeTreeModel() {
        return (AttributeTreeModel) getValue("ATTRIBUTETREEMODEL");
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

        AttributeDTOList result = Utils.restRequest(Utils.parseShopAddress("attributes/" + domainName),
                AttributeDTOList.class);
        getAttributeTreeModel().setAttributes(result);
    }

}
