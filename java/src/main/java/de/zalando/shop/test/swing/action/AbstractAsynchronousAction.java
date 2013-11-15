package de.zalando.shop.test.swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

/**
 * Action that performs a fetch of brand information.
 *
 * @author  rnascimento
 */
public abstract class AbstractAsynchronousAction extends AbstractAction {

    protected AbstractAsynchronousAction(final String name) {
        super(name);
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        SwingUtilities.invokeLater(new ActionRunnable(e));
    }

    protected abstract void asyncActionPerformed(final ActionEvent e);

    private class ActionRunnable implements Runnable {

        private ActionEvent e;

        public ActionRunnable(final ActionEvent e) {
            this.e = e;
        }

        @Override
        public void run() {
            asyncActionPerformed(e);
        }

    }
}
