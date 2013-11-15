package de.zalando.shop.test.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import de.zalando.shop.test.swing.action.ExitAction;
import de.zalando.shop.test.swing.action.ReadDomainDataAction;
import de.zalando.shop.test.swing.model.DomainTableModel;

/**
 * Application main frame.
 *
 * @author  rnascimento
 */
public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private static MainFrame instance;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }

        return instance;
    }

    private GridBagLayout mainLayout;

    private AttributesPanel attributesPanel;

    private BrandsPanel brandsPanel;

    private CategoriesPanel categoriesPanel;

    private ArticleDetailsPanel articleDetailsPanel;

    private SearchPanel searchPanel;

    private JTable domainTable;

    private JScrollPane domainTableScroll;

    private JLabel labelShopAddress;

    private JButton loadDomainButton;

    private JTabbedPane tabs;

    private JTextField textShopAddress;

    private JMenuBar mainMenuBar;

    private JMenu fileMenu;

    private ReadDomainDataAction readDomainDataAction;

    private ExitAction exitAction;

    private DomainTableModel domainTableModel;

    private MainFrame() {
        initComponents();
    }

    private void initComponents() {
        setSize(500, 400);
        setTitle("Hackathon test application");

        getContentPane().setLayout(getMainLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        getContentPane().add(getLabelShopAddress(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 5);
        getContentPane().add(getTextShopAddress(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 5);
        getContentPane().add(getLoadDomainButton(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        getContentPane().add(getTabs(), gridBagConstraints);

        this.setJMenuBar(getMainMenuBar());

        pack();
    }

    private AttributesPanel getAttributesPanel() {
        if (attributesPanel == null) {
            attributesPanel = new AttributesPanel();
            getDomainTableModel().addTableModelListener(attributesPanel.getDomainComboModel());
        }

        return attributesPanel;
    }

    private BrandsPanel getBrandsPanel() {
        if (brandsPanel == null) {
            brandsPanel = new BrandsPanel();
            getDomainTableModel().addTableModelListener(brandsPanel.getDomainComboModel());
        }

        return brandsPanel;
    }

    private CategoriesPanel getCategoriesPanel() {
        if (categoriesPanel == null) {
            categoriesPanel = new CategoriesPanel();
            getDomainTableModel().addTableModelListener(categoriesPanel.getDomainComboModel());
        }

        return categoriesPanel;
    }

    private ArticleDetailsPanel getArticleDetailsPanel() {
        if (articleDetailsPanel == null) {
            articleDetailsPanel = new ArticleDetailsPanel();
            getDomainTableModel().addTableModelListener(articleDetailsPanel.getDomainComboModel());
        }

        return articleDetailsPanel;
    }

    private SearchPanel getSearchPanel() {
        if (searchPanel == null) {
            searchPanel = new SearchPanel();
            getDomainTableModel().addTableModelListener(searchPanel.getDomainComboModel());
        }

        return searchPanel;
    }

    private GridBagLayout getMainLayout() {
        if (mainLayout == null) {
            mainLayout = new GridBagLayout();
        }

        return mainLayout;
    }

    private JTable getDomainTable() {
        if (domainTable == null) {
            domainTable = new JTable();
            domainTable.setModel(getDomainTableModel());
        }

        return domainTable;
    }

    private JScrollPane getDomainTableScroll() {
        if (domainTableScroll == null) {
            domainTableScroll = new JScrollPane();
            domainTableScroll.setViewportView(getDomainTable());
        }

        return domainTableScroll;
    }

    private JLabel getLabelShopAddress() {
        if (labelShopAddress == null) {
            labelShopAddress = new JLabel();
            labelShopAddress.setText("Shop address:");
        }

        return labelShopAddress;
    }

    private JButton getLoadDomainButton() {
        if (loadDomainButton == null) {
            loadDomainButton = new JButton();
            loadDomainButton.setAction(getReadDomainDataAction());
        }

        return loadDomainButton;
    }

    private JTabbedPane getTabs() {
        if (tabs == null) {
            tabs = new JTabbedPane();
            tabs.addTab("Domains", getDomainTableScroll());
            tabs.addTab("Brands", getBrandsPanel());
            tabs.addTab("Attributes", getAttributesPanel());
            tabs.addTab("Categories", getCategoriesPanel());
            tabs.addTab("Article Details", getArticleDetailsPanel());
            tabs.addTab("Search", getSearchPanel());
        }

        return tabs;
    }

    private JTextField getTextShopAddress() {
        if (textShopAddress == null) {
            textShopAddress = new JTextField();
        }

        return textShopAddress;
    }

    private JMenuBar getMainMenuBar() {
        if (mainMenuBar == null) {
            mainMenuBar = new JMenuBar();
            mainMenuBar.add(getFileMenu());
        }

        return mainMenuBar;
    }

    private JMenu getFileMenu() {
        if (fileMenu == null) {
            fileMenu = new JMenu();
            fileMenu.setText("File");
            fileMenu.setMnemonic(KeyEvent.VK_F);
            fileMenu.add(getReadDomainDataAction());
            fileMenu.addSeparator();
            fileMenu.add(getExitAction());
        }

        return fileMenu;
    }

    public String getShopAddress() {
        return getTextShopAddress().getText();
    }

    public void setShopAddress(final String newAddress) {
        getTextShopAddress().setText(newAddress);
    }

    private ReadDomainDataAction getReadDomainDataAction() {
        if (readDomainDataAction == null) {
            readDomainDataAction = new ReadDomainDataAction(getDomainTableModel());
        }

        return readDomainDataAction;
    }

    private ExitAction getExitAction() {
        if (exitAction == null) {
            exitAction = new ExitAction();
        }

        return exitAction;
    }

    public DomainTableModel getDomainTableModel() {
        if (domainTableModel == null) {
            domainTableModel = new DomainTableModel();
        }

        return domainTableModel;
    }
}
