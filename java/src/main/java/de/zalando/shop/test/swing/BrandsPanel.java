package de.zalando.shop.test.swing;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import de.zalando.shop.test.swing.action.ReadBrandDataAction;
import de.zalando.shop.test.swing.model.BrandTableModel;
import de.zalando.shop.test.swing.model.DomainComboModel;

/**
 * The panel about brands.
 *
 * @author  rnascimento
 */
public class BrandsPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final boolean DISPLAY_BRAND_IMAGES = true;

    private GridBagLayout mainLayout;

    private JLabel domainSelectionLabel;

    private JComboBox<String> domainSelectionCombo;

    private JButton readBrandsButton;

    private JScrollPane brandTableScroll;

    private JTable brandTable;

    private BrandTableModel brandTableModel;

    private ReadBrandDataAction readBrandDataAction;

    private DomainComboModel domainComboModel;

    public BrandsPanel() {
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
        add(getReadBrandsButton(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.weighty = 1f;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(getBrandTableScroll(), gridBagConstraints);
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

    private JButton getReadBrandsButton() {
        if (readBrandsButton == null) {
            readBrandsButton = new JButton();
            readBrandsButton.setAction(getReadBrandDataAction());
        }

        return readBrandsButton;
    }

    private JScrollPane getBrandTableScroll() {
        if (brandTableScroll == null) {
            brandTableScroll = new JScrollPane();
            brandTableScroll.setViewportView(getBrandTable());
        }

        return brandTableScroll;
    }

    private JTable getBrandTable() {
        if (brandTable == null) {
            brandTable = new JTable();
            brandTable.setModel(getBrandTableModel());
            brandTable.setDefaultRenderer(Image.class, new ImageRenderer());
        }

        return brandTable;
    }

    public BrandTableModel getBrandTableModel() {
        if (brandTableModel == null) {
            brandTableModel = new BrandTableModel(DISPLAY_BRAND_IMAGES);
        }

        return brandTableModel;
    }

    public DomainComboModel getDomainComboModel() {
        if (domainComboModel == null) {
            domainComboModel = new DomainComboModel();
        }

        return domainComboModel;
    }

    private ReadBrandDataAction getReadBrandDataAction() {
        if (readBrandDataAction == null) {
            readBrandDataAction = new ReadBrandDataAction(getBrandTableModel(), getDomainComboModel());
        }

        return readBrandDataAction;
    }

    private static final class ImageRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        private JLabel jLabel;

        public ImageRenderer() {
            this.jLabel = null;
        }

        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean selected,
                final boolean focus, final int row, final int col) {
            if (jLabel == null) {
                jLabel = new JLabel();
                jLabel.setText("");
            }

            Image image = (Image) value;
            if (image != null) {
                jLabel.setIcon(new ImageIcon(image));
            } else {
                jLabel.setIcon(null);
            }

            return jLabel;
        }
    }
}
