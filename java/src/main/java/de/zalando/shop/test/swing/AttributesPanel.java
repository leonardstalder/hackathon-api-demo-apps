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

import de.zalando.shop.test.swing.action.ReadAttributeDataAction;
import de.zalando.shop.test.swing.model.AttributeTreeModel;
import de.zalando.shop.test.swing.model.DomainComboModel;

/**
 * The panel about attributes.
 *
 * @author  rnascimento
 */
public class AttributesPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private GridBagLayout mainLayout;

    private JLabel domainSelectionLabel;

    private JComboBox<String> domainSelectionCombo;

    private JButton readAttributesButton;

    private JScrollPane attributeTreeScroll;

    private JTree attributeTree;

    private AttributeTreeModel attributeTreeModel;

    private ReadAttributeDataAction readAttributeDataAction;

    private DomainComboModel domainComboModel;

    public AttributesPanel() {
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
        add(getReadAttributesButton(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.weighty = 1f;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(getAttributeTreeScroll(), gridBagConstraints);
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

    private JButton getReadAttributesButton() {
        if (readAttributesButton == null) {
            readAttributesButton = new JButton();
            readAttributesButton.setAction(getReadAttributeDataAction());
        }

        return readAttributesButton;
    }

    private JScrollPane getAttributeTreeScroll() {
        if (attributeTreeScroll == null) {
            attributeTreeScroll = new JScrollPane();
            attributeTreeScroll.setViewportView(getAttributeTree());
        }

        return attributeTreeScroll;
    }

    private JTree getAttributeTree() {
        if (attributeTree == null) {
            attributeTree = new JTree();
            attributeTree.setModel(getAttributeTreeModel());
        }

        return attributeTree;
    }

    public AttributeTreeModel getAttributeTreeModel() {
        if (attributeTreeModel == null) {
            attributeTreeModel = new AttributeTreeModel();
        }

        return attributeTreeModel;
    }

    public DomainComboModel getDomainComboModel() {
        if (domainComboModel == null) {
            domainComboModel = new DomainComboModel();
        }

        return domainComboModel;
    }

    private ReadAttributeDataAction getReadAttributeDataAction() {
        if (readAttributeDataAction == null) {
            readAttributeDataAction = new ReadAttributeDataAction(getAttributeTreeModel(), getDomainComboModel());
        }

        return readAttributeDataAction;
    }

}
