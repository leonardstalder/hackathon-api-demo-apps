package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Action to leave the application.
 *
 * @author  rnascimento
 */
public class ExitAction extends AbstractAction {

    private static final long serialVersionUID = 1L;

    public ExitAction() {
        super("Exit");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        System.exit(0);
    }

}
