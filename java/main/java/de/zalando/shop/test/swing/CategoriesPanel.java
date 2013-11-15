package de.zalando.shop.test.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import de.zalando.shop.test.swing.action.ReadCategoryDataAction;
import de.zalando.shop.test.swing.model.CategoryTreeModel;
import de.zalando.shop.test.swing.model.DomainComboModel;

/**
 * The panel about attributes.
 *
 * @author  rnascimento
 */
public class CategoriesPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private GridBagLayout mainLayout;

    private JLabel domainSelectionLabel;

    private JComboBox<String> domainSelectionCombo;

    private JButton readCategoriesButton;

    private JScrollPane categoryTreeScroll;

    private JTree categoryTree;

    private CategoryTreeModel categoryTreeModel;

    private ReadCategoryDataAction readCategoryDataAction;

    private DomainComboModel domainComboModel;

    public CategoriesPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(getMainLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        add(getDomainSelectionLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 0, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getDomainSelectionCombo(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 0, 5, 5);
        add(getReadCategoriesButton(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.weighty = 1f;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(getCategoryTreeScroll(), gridBagConstraints);
    }

    private GridBagLayout getMainLayout() {
        if (mainLayout == null) {
            mainLayout = new GridBagLayout();
        }

        return mainLayout;
    }

    private JLabel getDomainSelectionLabel() {
        if (domainSelectionLabel == null) {
            domainSelectionLabel = new JLabel();
            domainSelectionLabel.setText("Domain: ");
        }

        return domainSelectionLabel;
    }

    private JComboBox<String> getDomainSelectionCombo() {
        if (domainSelectionCombo == null) {
            domainSelectionCombo = new JComboBox<>();
            domainSelectionCombo.setModel(getDomainComboModel());
        }

        return domainSelectionCombo;
    }

    private JButton getReadCategoriesButton() {
        if (readCategoriesButton == null) {
            readCategoriesButton = new JButton();
            readCategoriesButton.setAction(getReadCategoryDataAction());
        }

        return readCategoriesButton;
    }

    private JScrollPane getCategoryTreeScroll() {
        if (categoryTreeScroll == null) {
            categoryTreeScroll = new JScrollPane();
            categoryTreeScroll.setViewportView(getCategoryTree());
        }

        return categoryTreeScroll;
    }

    private JTree getCategoryTree() {
        if (categoryTree == null) {
            categoryTree = new JTree();
            categoryTree.setModel(getCategoryTreeModel());
        }

        return categoryTree;
    }

    public CategoryTreeModel getCategoryTreeModel() {
        if (categoryTreeModel == null) {
            categoryTreeModel = new CategoryTreeModel();
        }

        return categoryTreeModel;
    }

    public DomainComboModel getDomainComboModel() {
        if (domainComboModel == null) {
            domainComboModel = new DomainComboModel();
        }

        return domainComboModel;
    }

    private ReadCategoryDataAction getReadCategoryDataAction() {
        if (readCategoryDataAction == null) {
            readCategoryDataAction = new ReadCategoryDataAction(getCategoryTreeModel(), getDomainComboModel());
        }

        return readCategoryDataAction;
    }

}
