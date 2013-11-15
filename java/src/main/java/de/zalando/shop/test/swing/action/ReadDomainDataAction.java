package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import de.zalando.shop.test.dto.DomainDTOList;
import de.zalando.shop.test.swing.model.DomainTableModel;
import de.zalando.shop.test.util.Utils;

/**
 * Action that performs a fetch of domain information.
 *
 * @author  rnascimento
 */
public class ReadDomainDataAction extends AbstractAsynchronousAction {

    private static final long serialVersionUID = 1L;

    public ReadDomainDataAction(final DomainTableModel domainTableModel) {
        super("Read domain information");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue("DOMAINTABLEMODEL", domainTableModel);
    }

    private DomainTableModel getDomainTableModel() {
        return (DomainTableModel) getValue("DOMAINTABLEMODEL");
    }

    @Override
    protected void asyncActionPerformed(final ActionEvent e) {
        DomainDTOList result = Utils.restRequest(Utils.parseShopAddress("domains"), DomainDTOList.class);
        getDomainTableModel().setDomains(result);
    }

}
