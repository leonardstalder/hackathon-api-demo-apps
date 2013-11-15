package de.zalando.shop.test.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.zalando.shop.test.dto.ArticleDetailDTO;
import de.zalando.shop.test.dto.ArticleDetailImagesDTO;
import de.zalando.shop.test.swing.action.ReadArticleDetailsAction;
import de.zalando.shop.test.swing.model.ArticleAttributeTableModel;
import de.zalando.shop.test.swing.model.ArticleDetailModel;
import de.zalando.shop.test.swing.model.ArticleReviewTableModel;
import de.zalando.shop.test.swing.model.ArticleSimpleTableModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.util.Utils;

/**
 * A panel that presents information about an article.
 *
 * @author  rnascimento
 */
public class ArticleDetailsPanel extends JPanel implements ArticleDetailModel {

    private static final long serialVersionUID = 1L;

    private GridBagLayout mainLayout;

    private JLabel domainSelectionLabel;

    private JComboBox<String> domainSelectionCombo;

    private JLabel skuLabel;

    private JTextField skuTextField;

    private JButton readArticleDetailsButton;

    private ReadArticleDetailsAction readArticleDetailsAction;

    private DomainComboModel domainComboModel;

    private JTabbedPane detailsTab;

    private ArticleGeneralTabPanel generalInfoTabPanel;

    private JScrollPane descriptionTabScroll;

    private JTextArea descriptionTextArea;

    private JScrollPane categoriesTabScroll;

    private JTextArea categoriesTextArea;

    private JScrollPane attributesTableTabScroll;

    private JTable attributesTable;

    private ImagesPanel imagesTabPanel;

    private JScrollPane simplesTableTabScroll;

    private JTable simplesTable;

    private JScrollPane reviewsTableTabScroll;

    private JTable reviewsTable;

    private ArticleAttributeTableModel attributesTableModel;

    private ArticleReviewTableModel reviewsTableModel;

    private ArticleSimpleTableModel simplesTableModel;

    public ArticleDetailsPanel() {
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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getSkuLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getSkuTextField(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getReadArticleDetailsButton(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.weighty = 1f;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        add(getDetailsTab(), gridBagConstraints);
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

    private JLabel getSkuLabel() {
        if (skuLabel == null) {
            skuLabel = new JLabel();
            skuLabel.setText("SKU: ");
        }

        return skuLabel;
    }

    private JTextField getSkuTextField() {
        if (skuTextField == null) {
            skuTextField = new JTextField();
        }

        return skuTextField;
    }

    private JButton getReadArticleDetailsButton() {
        if (readArticleDetailsButton == null) {
            readArticleDetailsButton = new JButton();
            readArticleDetailsButton.setAction(getReadArticleDetailsAction());
        }

        return readArticleDetailsButton;
    }

    public DomainComboModel getDomainComboModel() {
        if (domainComboModel == null) {
            domainComboModel = new DomainComboModel();
        }

        return domainComboModel;
    }

    private ReadArticleDetailsAction getReadArticleDetailsAction() {
        if (readArticleDetailsAction == null) {
            readArticleDetailsAction = new ReadArticleDetailsAction(this, getDomainComboModel());
        }

        return readArticleDetailsAction;
    }

    private JTabbedPane getDetailsTab() {
        if (detailsTab == null) {
            detailsTab = new JTabbedPane();
            detailsTab.addTab("General Information", getGeneralInfoTabPanel());
            detailsTab.addTab("Description", getDescriptionTabScroll());
            detailsTab.addTab("Categories", getCategoriesTabScroll());
            detailsTab.addTab("Attributes", getAttributesTableTabScroll());
            detailsTab.addTab("Images", getImagesTabPanel());
            detailsTab.addTab("Simples", getSimplesTableTabScroll());
            detailsTab.addTab("Reviews", getReviewsTableTabScroll());
        }

        return detailsTab;
    }

    private ArticleGeneralTabPanel getGeneralInfoTabPanel() {
        if (generalInfoTabPanel == null) {
            generalInfoTabPanel = new ArticleGeneralTabPanel();
        }

        return generalInfoTabPanel;
    }

    private JScrollPane getAttributesTableTabScroll() {
        if (attributesTableTabScroll == null) {
            attributesTableTabScroll = new JScrollPane();
            attributesTableTabScroll.setViewportView(getAttributesTable());
        }

        return attributesTableTabScroll;
    }

    private JTable getAttributesTable() {
        if (attributesTable == null) {
            attributesTable = new JTable();
            attributesTable.setModel(getAttributesTableModel());
        }

        return attributesTable;
    }

    private JScrollPane getDescriptionTabScroll() {
        if (descriptionTabScroll == null) {
            descriptionTabScroll = new JScrollPane();
            descriptionTabScroll.setViewportView(getDescriptionTextArea());
        }

        return descriptionTabScroll;
    }

    private JTextArea getDescriptionTextArea() {
        if (descriptionTextArea == null) {
            descriptionTextArea = new JTextArea();
            descriptionTextArea.setEditable(false);
        }

        return descriptionTextArea;
    }

    private JScrollPane getCategoriesTabScroll() {
        if (categoriesTabScroll == null) {
            categoriesTabScroll = new JScrollPane();
            categoriesTabScroll.setViewportView(getCategoriesTextArea());
        }

        return categoriesTabScroll;
    }

    private JTextArea getCategoriesTextArea() {
        if (categoriesTextArea == null) {
            categoriesTextArea = new JTextArea();
            categoriesTextArea.setEditable(false);
        }

        return categoriesTextArea;
    }

    private ImagesPanel getImagesTabPanel() {
        if (imagesTabPanel == null) {
            imagesTabPanel = new ImagesPanel();
        }

        return imagesTabPanel;
    }

    private JScrollPane getSimplesTableTabScroll() {
        if (simplesTableTabScroll == null) {
            simplesTableTabScroll = new JScrollPane();
            simplesTableTabScroll.setViewportView(getSimplesTable());
        }

        return simplesTableTabScroll;
    }

    private JTable getSimplesTable() {
        if (simplesTable == null) {
            simplesTable = new JTable();
            simplesTable.setModel(getSimplesTableModel());
        }

        return simplesTable;
    }

    private JScrollPane getReviewsTableTabScroll() {
        if (reviewsTableTabScroll == null) {
            reviewsTableTabScroll = new JScrollPane();
            reviewsTableTabScroll.setViewportView(getReviewsTable());
        }

        return reviewsTableTabScroll;
    }

    private JTable getReviewsTable() {
        if (reviewsTable == null) {
            reviewsTable = new JTable();
            reviewsTable.setModel(getReviewsTableModel());
        }

        return reviewsTable;
    }

    private ArticleAttributeTableModel getAttributesTableModel() {
        if (attributesTableModel == null) {
            attributesTableModel = new ArticleAttributeTableModel();
        }

        return attributesTableModel;
    }

    private ArticleReviewTableModel getReviewsTableModel() {
        if (reviewsTableModel == null) {
            reviewsTableModel = new ArticleReviewTableModel();
        }

        return reviewsTableModel;
    }

    private ArticleSimpleTableModel getSimplesTableModel() {
        if (simplesTableModel == null) {
            simplesTableModel = new ArticleSimpleTableModel();
        }

        return simplesTableModel;
    }

    @Override
    public String getArticleSKU() {
        return getSkuTextField().getText().trim();
    }

    @Override
    public void setArticleDetail(final ArticleDetailDTO articleDetail) {
        getGeneralInfoTabPanel().setArticleDetail(articleDetail);
        getImagesTabPanel().setArticleDetail(articleDetail);
        if (articleDetail != null) {
            getAttributesTableModel().setArticleAttributes(articleDetail.getAttributes());
            getReviewsTableModel().setArticleReviews(articleDetail.getReviews());
            getSimplesTableModel().setArticleSimples(articleDetail.getSimples());
            getDescriptionTextArea().setText(articleDetail.getDescription() == null ? ""
                                                                                    : articleDetail.getDescription());

            StringBuilder categoriesList = new StringBuilder();
            if (articleDetail.getCategory() != null && articleDetail.getCategory().getCount() > 0) {
                for (String value : articleDetail.getCategory().getData()) {
                    categoriesList.append(value);
                    categoriesList.append("\n");
                }
            }

            getCategoriesTextArea().setText(categoriesList.toString());
        } else {
            getAttributesTableModel().setArticleAttributes(null);
            getReviewsTableModel().setArticleReviews(null);
            getSimplesTableModel().setArticleSimples(null);
            getDescriptionTextArea().setText("");
            getCategoriesTextArea().setText("");
        }
    }

    private static class ArticleGeneralTabPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private GridBagLayout mainLayout;

        private JLabel nameLabel;

        private JTextField nameTextField;

        private JLabel urlKeyLabel;

        private JTextField urlKeyTextField;

        private JLabel brandCodeLabel;

        private JTextField brandCodeTextField;

        private JLabel priceLabel;

        private JTextField priceTextField;

        private JLabel averageRatingLabel;

        private JTextField averageRatingTextField;

        private JLabel colorLabel;

        private JTextField colorTextField;

        private JLabel otherColorsLabel;

        private JScrollPane otherColorsScroll;

        private JTextArea otherColorsTextArea;

        public ArticleGeneralTabPanel() {
            initComponents();
        }

        private void initComponents() {
            setLayout(getMainLayout());

            int line = 0;

            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(5, 5, 5, 5);
            add(getNameLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(5, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getNameTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getUrlKeyLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getUrlKeyTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getBrandCodeLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getBrandCodeTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getPriceLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getPriceTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getAverageRatingLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getAverageRatingTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getColorLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            add(getColorTextField(), gridBagConstraints);

            line++;

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 5, 5, 5);
            add(getOtherColorsLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = line;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 5, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.weighty = 1f;
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            add(getOtherColorsScroll(), gridBagConstraints);
        }

        public void setArticleDetail(final ArticleDetailDTO articleDetail) {
            if (articleDetail != null) {
                getNameTextField().setText(articleDetail.getName());
                getUrlKeyTextField().setText(articleDetail.getUrlKey());
                getBrandCodeTextField().setText(articleDetail.getBrandCode());
                getPriceTextField().setText((articleDetail.getPrice() == articleDetail.getPriceOriginal())
                        ? String.format("%1.2f", articleDetail.getPrice())
                        : String.format("%1.2f (original %1.2f)", articleDetail.getPrice(),
                            articleDetail.getPriceOriginal()));
                getAverageRatingTextField().setText(String.format("%1.1f", articleDetail.getAverageRating()));
                getColorTextField().setText(String.format("%s (family %s)", articleDetail.getColor(),
                        articleDetail.getColorFamily()));

                StringBuilder otherColorsList = new StringBuilder();
                if (articleDetail.getOtherColors() != null && articleDetail.getOtherColors().getCount() > 0) {
                    for (String value : articleDetail.getOtherColors().getData()) {
                        otherColorsList.append(value);
                        otherColorsList.append("\n");
                    }
                }

                getOtherColorsTextArea().setText(otherColorsList.toString());
            } else {
                getNameTextField().setText("");
                getUrlKeyTextField().setText("");
                getBrandCodeTextField().setText("");
                getPriceTextField().setText("");
                getAverageRatingTextField().setText("");
                getColorTextField().setText("");
                getOtherColorsTextArea().setText("");
            }
        }

        private GridBagLayout getMainLayout() {
            if (mainLayout == null) {
                mainLayout = new GridBagLayout();
            }

            return mainLayout;
        }

        private JLabel getNameLabel() {
            if (nameLabel == null) {
                nameLabel = new JLabel();
                nameLabel.setText("Name: ");
            }

            return nameLabel;
        }

        private JTextField getNameTextField() {
            if (nameTextField == null) {
                nameTextField = new JTextField();
                nameTextField.setEditable(false);
            }

            return nameTextField;
        }

        private JLabel getUrlKeyLabel() {
            if (urlKeyLabel == null) {
                urlKeyLabel = new JLabel();
                urlKeyLabel.setText("URL Key: ");
            }

            return urlKeyLabel;
        }

        private JTextField getUrlKeyTextField() {
            if (urlKeyTextField == null) {
                urlKeyTextField = new JTextField();
                urlKeyTextField.setEditable(false);
            }

            return urlKeyTextField;
        }

        private JLabel getBrandCodeLabel() {
            if (brandCodeLabel == null) {
                brandCodeLabel = new JLabel();
                brandCodeLabel.setText("Brand Code: ");
            }

            return brandCodeLabel;
        }

        private JTextField getBrandCodeTextField() {
            if (brandCodeTextField == null) {
                brandCodeTextField = new JTextField();
                brandCodeTextField.setEditable(false);
            }

            return brandCodeTextField;
        }

        private JLabel getPriceLabel() {
            if (priceLabel == null) {
                priceLabel = new JLabel();
                priceLabel.setText("Price: ");
            }

            return priceLabel;
        }

        private JTextField getPriceTextField() {
            if (priceTextField == null) {
                priceTextField = new JTextField();
                priceTextField.setEditable(false);
            }

            return priceTextField;
        }

        private JLabel getAverageRatingLabel() {
            if (averageRatingLabel == null) {
                averageRatingLabel = new JLabel();
                averageRatingLabel.setText("Average Rating: ");
            }

            return averageRatingLabel;
        }

        private JTextField getAverageRatingTextField() {
            if (averageRatingTextField == null) {
                averageRatingTextField = new JTextField();
                averageRatingTextField.setEditable(false);
            }

            return averageRatingTextField;
        }

        private JLabel getColorLabel() {
            if (colorLabel == null) {
                colorLabel = new JLabel();
                colorLabel.setText("Color: ");
            }

            return colorLabel;
        }

        private JTextField getColorTextField() {
            if (colorTextField == null) {
                colorTextField = new JTextField();
                colorTextField.setEditable(false);
            }

            return colorTextField;
        }

        private JLabel getOtherColorsLabel() {
            if (otherColorsLabel == null) {
                otherColorsLabel = new JLabel();
                otherColorsLabel.setText("Other Colors: ");
            }

            return otherColorsLabel;
        }

        private JScrollPane getOtherColorsScroll() {
            if (otherColorsScroll == null) {
                otherColorsScroll = new JScrollPane();
                otherColorsScroll.setViewportView(getOtherColorsTextArea());
            }

            return otherColorsScroll;
        }

        private JTextArea getOtherColorsTextArea() {
            if (otherColorsTextArea == null) {
                otherColorsTextArea = new JTextArea();
                otherColorsTextArea.setEditable(false);
            }

            return otherColorsTextArea;
        }
    }

    private static class ImagesPanel extends JScrollPane {

        private static final long serialVersionUID = 1L;

        private JPanel mainPanel;

        private GridBagLayout mainLayout;

        private JLabel selectorLabel;

        private JLabel selectorImage;

        private JLabel detailLabel;

        private JLabel detailImage;

        private JLabel largeLabel;

        private JLabel largeImage;

        public ImagesPanel() {
            initComponents();
        }

        private void initComponents() {
            setViewportView(getMainPanel());
        }

        public void setArticleDetail(final ArticleDetailDTO articleDetail) {
            selectorImage.setText(" ");
            selectorImage.setIcon(null);
            detailImage.setText(" ");
            detailImage.setIcon(null);
            largeImage.setText(" ");
            largeImage.setIcon(null);
            if (articleDetail != null && articleDetail.getImages() != null) {
                ArticleDetailImagesDTO imageDTO = articleDetail.getImages();
                if (imageDTO.getDetailUrl() != null && imageDTO.getDetailUrl().trim().length() > 0) {
                    if (imageDTO.getDetail() == null) {
                        imageDTO.setDetail(Utils.loadImage(imageDTO.getDetailUrl()));
                    }

                    if (imageDTO.getDetail() != null) {
                        detailImage.setText("");
                        detailImage.setIcon(new ImageIcon(imageDTO.getDetail()));
                    }
                }

                if (imageDTO.getSelectorUrl() != null && imageDTO.getSelectorUrl().trim().length() > 0) {
                    if (imageDTO.getSelector() == null) {
                        imageDTO.setSelector(Utils.loadImage(imageDTO.getSelectorUrl()));
                    }

                    if (imageDTO.getSelector() != null) {
                        selectorImage.setText("");
                        selectorImage.setIcon(new ImageIcon(imageDTO.getSelector()));
                    }
                }

                if (imageDTO.getLargeUrl() != null && imageDTO.getLargeUrl().trim().length() > 0) {
                    if (imageDTO.getLarge() == null) {
                        imageDTO.setLarge(Utils.loadImage(imageDTO.getLargeUrl()));
                    }

                    if (imageDTO.getLarge() != null) {
                        largeImage.setText("");
                        largeImage.setIcon(new ImageIcon(imageDTO.getLarge()));
                    }
                }
            }
        }

        private JPanel getMainPanel() {
            if (mainPanel == null) {
                mainPanel = new JPanel();
                mainPanel.setLayout(getMainLayout());

                int line = 0;

                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.WEST;
                gridBagConstraints.insets = new Insets(5, 5, 5, 5);
                mainPanel.add(getSelectorLabel(), gridBagConstraints);

                line++;

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.NORTH;
                gridBagConstraints.insets = new Insets(0, 5, 5, 5);
                gridBagConstraints.weightx = 1f;
                gridBagConstraints.weighty = 0f;
                mainPanel.add(getSelectorImage(), gridBagConstraints);

                line++;

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.WEST;
                gridBagConstraints.insets = new Insets(0, 5, 5, 5);
                mainPanel.add(getDetailLabel(), gridBagConstraints);

                line++;

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.NORTH;
                gridBagConstraints.insets = new Insets(0, 5, 5, 5);
                gridBagConstraints.weightx = 1f;
                gridBagConstraints.weighty = 0f;
                mainPanel.add(getDetailImage(), gridBagConstraints);

                line++;

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.WEST;
                gridBagConstraints.insets = new Insets(0, 5, 5, 5);
                mainPanel.add(getLargeLabel(), gridBagConstraints);

                line++;

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = line;
                gridBagConstraints.anchor = GridBagConstraints.NORTH;
                gridBagConstraints.insets = new Insets(0, 5, 5, 5);
                gridBagConstraints.weightx = 1f;
                gridBagConstraints.weighty = 0f;
                mainPanel.add(getLargeImage(), gridBagConstraints);
            }

            return mainPanel;
        }

        private GridBagLayout getMainLayout() {
            if (mainLayout == null) {
                mainLayout = new GridBagLayout();
            }

            return mainLayout;
        }

        private JLabel getSelectorLabel() {
            if (selectorLabel == null) {
                selectorLabel = new JLabel();
                selectorLabel.setText("Selector:");
            }

            return selectorLabel;
        }

        private JLabel getSelectorImage() {
            if (selectorImage == null) {
                selectorImage = new JLabel();
                selectorImage.setText(" ");
            }

            return selectorImage;
        }

        private JLabel getDetailLabel() {
            if (detailLabel == null) {
                detailLabel = new JLabel();
                detailLabel.setText("Detail:");
            }

            return detailLabel;
        }

        private JLabel getDetailImage() {
            if (detailImage == null) {
                detailImage = new JLabel();
                detailImage.setText(" ");
            }

            return detailImage;
        }

        private JLabel getLargeLabel() {
            if (largeLabel == null) {
                largeLabel = new JLabel();
                largeLabel.setText("Large:");
            }

            return largeLabel;
        }

        private JLabel getLargeImage() {
            if (largeImage == null) {
                largeImage = new JLabel();
                largeImage.setText(" ");
            }

            return largeImage;
        }
    }
}
