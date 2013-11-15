package de.zalando.shop.test;

import javax.swing.WindowConstants;

import org.apache.log4j.BasicConfigurator;

import de.zalando.shop.test.swing.MainFrame;

/**
 * The executable class of the project.
 *
 * @author  rnascimento
 */
public class HackathonTestApplication {

    public static void main(final String[] args) {
        BasicConfigurator.configure();

        MainFrame application = MainFrame.getInstance();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setShopAddress("http://www.zalando.de");
        application.setVisible(true);
    }
}
