package de.zalando.shop.test.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.zalando.shop.test.dto.SearchResultArticleDTO;
import de.zalando.shop.test.dto.SearchResultClassificationDTO;
import de.zalando.shop.test.dto.SearchResultClassificationKnownTermDTO;
import de.zalando.shop.test.dto.SearchResultDTO;
import de.zalando.shop.test.dto.SearchResultFacetDTO;
import de.zalando.shop.test.dto.SearchResultFacetDataDTO;
import de.zalando.shop.test.swing.action.FillSearchCombosAction;
import de.zalando.shop.test.swing.action.SearchAction;
import de.zalando.shop.test.swing.model.BrandComboModel;
import de.zalando.shop.test.swing.model.CategoryComboModel;
import de.zalando.shop.test.swing.model.DomainComboModel;
import de.zalando.shop.test.swing.model.SearchModel;
import de.zalando.shop.test.swing.model.SortComboModel;

/**
 * A panel that presents information about an article.
 *
 * @author  rnascimento
 */
public class SearchPanel extends JPanel implements SearchModel {

    private static final long serialVersionUID = 1L;

    private GridBagLayout mainLayout;

    private JLabel domainSelectionLabel;

    private JComboBox<String> domainSelectionCombo;

    private DomainComboModel domainComboModel;

    private JPanel domainSelectionPanel;

    private GridBagLayout domainSelectionLayout;

    private JButton searchButton;

    private SearchAction searchAction;

    private JButton fillCombosButton;

    private FillSearchCombosAction fillCombosAction;

    private JLabel categorySelectionLabel;

    private JComboBox<String> categorySelectionCombo;

    private CategoryComboModel categoryComboModel;

    private JLabel brandSelectionLabel;

    private JComboBox<String> brandSelectionCombo;

    private BrandComboModel brandComboModel;

    private JLabel sortSelectionLabel;

    private JComboBox<String> sortSelectionCombo;

    private SortComboModel sortComboModel;

    private JLabel fullTextSearchLabel;

    private JTextField fullTextSearchTextField;

    private JLabel pageNumberLabel;

    private JTextField pageNumberTextField;

    private JLabel pageSizeLabel;

    private JTextField pageSizeTextField;

    private JPanel pageParametersPanel;

    private GridBagLayout pageParametersLayout;

    private JEditorPane reportLabel;

    private JScrollPane reportScroll;

    public SearchPanel() {
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
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridwidth = 2;
        add(getDomainSelectionPanel(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getCategorySelectionLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getCategorySelectionCombo(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getBrandSelectionLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getBrandSelectionCombo(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1f;
        add(getPageParametersPanel(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getSortSelectionLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getSortSelectionCombo(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getFullTextSearchLabel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = line;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(getFullTextSearchTextField(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getSearchButton(), gridBagConstraints);

        line++;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = line;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1f;
        gridBagConstraints.weighty = 1f;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 5, 5);
        add(getReportScroll(), gridBagConstraints);
    }

    @Override
    public String getUserSelectedCategory() {
        return getCategoryComboModel().getSelectedCategory();
    }

    @Override
    public String getUserSelectedBrand() {
        return getBrandComboModel().getSelectedBrand();
    }

    @Override
    public String getUserSuppliedPage() {
        return getPageNumberTextField().getText();
    }

    @Override
    public String getUserSuppliedPageSize() {
        return getPageSizeTextField().getText();
    }

    @Override
    public String getUserSelectedSort() {
        return getSortComboModel().getSelectedOption();
    }

    @Override
    public String getUserSuppliedFullTextSearchKey() {
        return getFullTextSearchTextField().getText();
    }

    @Override
    public void setSearchResults(final SearchResultDTO searchResult) {

        if (searchResult != null) {
            StringBuilder searchReport = new StringBuilder();
            searchReport.append("<html>");
            searchReport.append("<head><style>");
            searchReport.append("span {");
            searchReport.append("font-weight: bold;");
            searchReport.append("}");
            searchReport.append("h5 {");
            searchReport.append("font-weight: bold;");
            searchReport.append("font-size: large;");
            searchReport.append("}");
            searchReport.append("</style></head>");
            searchReport.append("<body>");
            searchReport.append("<h5>");
            searchReport.append((searchResult.getSearchResults().getCount() == 0
                    ? "No" : searchResult.getSearchResults().getCount()));
            searchReport.append(" article");
            searchReport.append((searchResult.getSearchResults().getCount() == 1 ? "" : "s"));
            searchReport.append(" found.</h5>");

            if (searchResult.getSearchResults().getCount() > 0) {
                searchReport.append("<p><span class='fieldName'>");
                searchReport.append("Articles:");
                searchReport.append("</span></p>");
                searchReport.append("<table class='dataTable' border='1'>");
                searchReport.append("<thead>");
                searchReport.append("<tr>");
                searchReport.append("<th>SKU</th>");
                searchReport.append("<th>Name</th>");
                searchReport.append("<th>URL Key</th>");
                searchReport.append("<th>Brand Code</th>");
                searchReport.append("<th>Price</th>");
                searchReport.append("<th>Color</th>");
                searchReport.append("<th>Other Colors</th>");
                searchReport.append("<th>Attributes</th>");

                // searchReport.append("<th>Image</th>");
                searchReport.append("</tr>");
                searchReport.append("</thead>");
                searchReport.append("<tbody>");

                boolean even = false;
                for (SearchResultArticleDTO article : searchResult.getSearchResults().getData()) {
                    searchReport.append("<tr");
                    if (even) {
                        searchReport.append(" class='even'");
                    }

                    even = !even;
                    searchReport.append(">");
                    searchReport.append("<td>");
                    searchReport.append(article.getSku());
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    searchReport.append(article.getName());
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    searchReport.append(article.getUrlKey());
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    searchReport.append(article.getBrandCode());
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    searchReport.append(article.getPrice());
                    searchReport.append(" (original ");
                    searchReport.append(article.getPriceOriginal());
                    searchReport.append(")");
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    searchReport.append(article.getColor());
                    searchReport.append(" (family ");
                    searchReport.append(article.getColorFamily());
                    searchReport.append(")");
                    searchReport.append("</td>");
                    searchReport.append("<td>");
                    if (article.getOtherColors() != null && article.getOtherColors().getCount() > 0) {
                        boolean first = true;
                        for (String otherColor : article.getOtherColors().getData()) {
                            if (first) {
                                first = false;
                            } else {
                                searchReport.append("<br />");
                            }

                            searchReport.append(otherColor);
                        }
                    } else {
                        searchReport.append("&nbsp;");
                    }

                    searchReport.append("</td>");
                    searchReport.append("<td>");

                    boolean foundAttribute = false;
                    if (article.isNewArticle()) {
                        if (foundAttribute) {
                            searchReport.append(", ");
                        }

                        foundAttribute = true;
                        searchReport.append("New");
                    }

                    if (article.isSale()) {
                        if (foundAttribute) {
                            searchReport.append(", ");
                        }

                        foundAttribute = true;
                        searchReport.append("Sale");
                    }

                    if (article.isKids()) {
                        if (foundAttribute) {
                            searchReport.append(", ");
                        }

                        foundAttribute = true;
                        searchReport.append("Kids");
                    }

                    if (article.isOverSize()) {
                        if (foundAttribute) {
                            searchReport.append(", ");
                        }

                        foundAttribute = true;
                        searchReport.append("Oversize");
                    }

                    if (!foundAttribute) {
                        searchReport.append("&nbsp;");
                    }

                    searchReport.append("</td>");

// if(article.getimageUrl !== null && article.getimageUrl !== undefined && article.getimageUrl.length > 0) {
// searchReport.append("<td class='articleimage'>");
// searchReport.append("<a href='");
// searchReport.append(article.getimageUrl);
// searchReport.append("' target='_new'><img src='");
// searchReport.append(article.getimageUrl);
// searchReport.append("' /></a>");
// searchReport.append("</td>");
// } else {
// searchReport.append("<td>&nbsp;</td>");
// }
                    searchReport.append("</tr>");
                }

                searchReport.append("</tbody>");
                searchReport.append("</table>");
            }

            if (searchResult.getSearchFacets() != null && searchResult.getSearchFacets().getCount() > 0) {
                searchReport.append("<p><span class='fieldName'>");
                searchReport.append("Facets:");
                searchReport.append("</span></p>");
                searchReport.append("<table class='dataTable' border='1'>");
                searchReport.append("<thead>");
                searchReport.append("<tr>");
                searchReport.append("<th>Attribute</th>");
                searchReport.append("<th>Quantities</th>");
                searchReport.append("</tr>");
                searchReport.append("</thead>");
                searchReport.append("<tbody>");

                boolean even = false;
                for (SearchResultFacetDTO facet : searchResult.getSearchFacets().getData()) {
                    searchReport.append("<tr");
                    if (even) {
                        searchReport.append(" class='even'");
                    }

                    even = !even;
                    searchReport.append(">");
                    searchReport.append("<td>");
                    searchReport.append(facet.getAttributeKey());
                    searchReport.append("</td>");
                    searchReport.append("<td><span class='scrollable'>");
                    if (facet.getQuantities() != null && facet.getQuantities().getCount() > 0) {
                        boolean first = true;
                        for (SearchResultFacetDataDTO facetData : facet.getQuantities().getData()) {
                            if (first) {
                                first = false;
                            } else {
                                searchReport.append("<br />");
                            }

                            searchReport.append(facetData.getLabel());
                            searchReport.append(" (");
                            searchReport.append(facetData.getKey());
                            searchReport.append("): ");
                            searchReport.append(facetData.getArticleCount());
                        }
                    } else {
                        searchReport.append("&nbsp;");
                    }

                    searchReport.append("</span></td>");
                    searchReport.append("</tr>");
                }

                searchReport.append("</tbody>");
                searchReport.append("</table>");
            }

            if (searchResult.getFullTextSearchClassification() != null) {

                SearchResultClassificationDTO classificationData = searchResult.getFullTextSearchClassification();
                if ((classificationData.getUnknownTerms() != null
                            && classificationData.getUnknownTerms().getCount() > 0)
                        || (classificationData.getKnownTerms() != null
                            && classificationData.getKnownTerms().getCount() > 0)) {
                    searchReport.append("<p><span class='fieldName'>");
                    searchReport.append("Full text search classification:");
                    searchReport.append("</span></p>");
                    searchReport.append("<table class='dataTable' border='1'>");
                    searchReport.append("<thead>");
                    searchReport.append("<tr>");
                    searchReport.append("<th>Term</th>");
                    searchReport.append("<th>Classification</th>");
                    searchReport.append("</tr>");
                    searchReport.append("</thead>");
                    searchReport.append("<tbody>");

                    boolean even = false;
                    if (classificationData.getUnknownTerms() != null
                            && classificationData.getUnknownTerms().getCount() > 0) {
                        for (String unknownTerm : classificationData.getUnknownTerms().getData()) {
                            searchReport.append("<tr");
                            if (even) {
                                searchReport.append(" class='even'");
                            }

                            even = !even;
                            searchReport.append(">");
                            searchReport.append("<td>");
                            searchReport.append(unknownTerm);
                            searchReport.append("</td>");
                            searchReport.append("<td>Unknown</td>");
                            searchReport.append("</tr>");
                        }
                    }

                    if (classificationData.getKnownTerms() != null
                            && classificationData.getKnownTerms().getCount() > 0) {
                        for (SearchResultClassificationKnownTermDTO knownTerm
                                : classificationData.getKnownTerms().getData()) {
                            searchReport.append("<tr");
                            if (even) {
                                searchReport.append(" class='even'");
                            }

                            even = !even;
                            searchReport.append(">");
                            searchReport.append("<td>");
                            searchReport.append(knownTerm.getParsedTerm());
                            searchReport.append("</td>");
                            searchReport.append("<td>Matched: ");
                            searchReport.append(knownTerm.getMatchedTerm());
                            searchReport.append(" (");
                            searchReport.append(knownTerm.getMatchType());
                            searchReport.append(")</td>");
                            searchReport.append("</tr>");
                        }
                    }

                    searchReport.append("</tbody>");
                    searchReport.append("</table>");
                }
            }

            searchReport.append("</body></html>");

            getReportLabel().setText(searchReport.toString());
        } else {
            getReportLabel().setText("");
        }
    }

    private GridBagLayout getMainLayout() {
        if (mainLayout == null) {
            mainLayout = new GridBagLayout();
        }

        return mainLayout;
    }

    private JPanel getDomainSelectionPanel() {
        if (domainSelectionPanel == null) {
            domainSelectionPanel = new JPanel();
            domainSelectionPanel.setLayout(getDomainSelectionLayout());

            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 5);
            domainSelectionPanel.add(getDomainSelectionLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 5);
            gridBagConstraints.weightx = 1f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            domainSelectionPanel.add(getDomainSelectionCombo(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            domainSelectionPanel.add(getFillCombosButton(), gridBagConstraints);

        }

        return domainSelectionPanel;
    }

    private GridBagLayout getDomainSelectionLayout() {
        if (domainSelectionLayout == null) {
            domainSelectionLayout = new GridBagLayout();
        }

        return domainSelectionLayout;
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

    private JButton getSearchButton() {
        if (searchButton == null) {
            searchButton = new JButton();
            searchButton.setAction(getSearchAction());
        }

        return searchButton;
    }

    private SearchAction getSearchAction() {
        if (searchAction == null) {
            searchAction = new SearchAction(this, getDomainComboModel());
        }

        return searchAction;
    }

    private JButton getFillCombosButton() {
        if (fillCombosButton == null) {
            fillCombosButton = new JButton();
            fillCombosButton.setAction(getFillCombosAction());
        }

        return fillCombosButton;
    }

    private FillSearchCombosAction getFillCombosAction() {
        if (fillCombosAction == null) {
            fillCombosAction = new FillSearchCombosAction(getDomainComboModel(), getCategoryComboModel(),
                    getBrandComboModel());
        }

        return fillCombosAction;
    }

    public DomainComboModel getDomainComboModel() {
        if (domainComboModel == null) {
            domainComboModel = new DomainComboModel();
        }

        return domainComboModel;
    }

    private JLabel getCategorySelectionLabel() {
        if (categorySelectionLabel == null) {
            categorySelectionLabel = new JLabel();
            categorySelectionLabel.setText("Category: ");
        }

        return categorySelectionLabel;
    }

    private JComboBox<String> getCategorySelectionCombo() {
        if (categorySelectionCombo == null) {
            categorySelectionCombo = new JComboBox<>();
            categorySelectionCombo.setModel(getCategoryComboModel());
        }

        return categorySelectionCombo;
    }

    private CategoryComboModel getCategoryComboModel() {
        if (categoryComboModel == null) {
            categoryComboModel = new CategoryComboModel();
        }

        return categoryComboModel;
    }

    private JLabel getBrandSelectionLabel() {
        if (brandSelectionLabel == null) {
            brandSelectionLabel = new JLabel();
            brandSelectionLabel.setText("Brand: ");
        }

        return brandSelectionLabel;
    }

    private JComboBox<String> getBrandSelectionCombo() {
        if (brandSelectionCombo == null) {
            brandSelectionCombo = new JComboBox<>();
            brandSelectionCombo.setModel(getBrandComboModel());
        }

        return brandSelectionCombo;
    }

    private BrandComboModel getBrandComboModel() {
        if (brandComboModel == null) {
            brandComboModel = new BrandComboModel();
        }

        return brandComboModel;
    }

    private JLabel getSortSelectionLabel() {
        if (sortSelectionLabel == null) {
            sortSelectionLabel = new JLabel();
            sortSelectionLabel.setText("Sort: ");
        }

        return sortSelectionLabel;
    }

    private JComboBox<String> getSortSelectionCombo() {
        if (sortSelectionCombo == null) {
            sortSelectionCombo = new JComboBox<>();
            sortSelectionCombo.setModel(getSortComboModel());
        }

        return sortSelectionCombo;
    }

    private SortComboModel getSortComboModel() {
        if (sortComboModel == null) {
            sortComboModel = new SortComboModel();
        }

        return sortComboModel;
    }

    private JLabel getFullTextSearchLabel() {
        if (fullTextSearchLabel == null) {
            fullTextSearchLabel = new JLabel();
            fullTextSearchLabel.setText("Textual Search: ");
        }

        return fullTextSearchLabel;
    }

    private JTextField getFullTextSearchTextField() {
        if (fullTextSearchTextField == null) {
            fullTextSearchTextField = new JTextField();
        }

        return fullTextSearchTextField;
    }

    private JPanel getPageParametersPanel() {
        if (pageParametersPanel == null) {
            pageParametersPanel = new JPanel();
            pageParametersPanel.setLayout(getPageParametersLayout());

            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 5);
            pageParametersPanel.add(getPageNumberLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 5);
            gridBagConstraints.weightx = 0.5f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            pageParametersPanel.add(getPageNumberTextField(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 5);
            pageParametersPanel.add(getPageSizeLabel(), gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.weightx = 0.5f;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            pageParametersPanel.add(getPageSizeTextField(), gridBagConstraints);
        }

        return pageParametersPanel;
    }

    private GridBagLayout getPageParametersLayout() {
        if (pageParametersLayout == null) {
            pageParametersLayout = new GridBagLayout();
        }

        return pageParametersLayout;
    }

    private JLabel getPageNumberLabel() {
        if (pageNumberLabel == null) {
            pageNumberLabel = new JLabel();
            pageNumberLabel.setText("Page: ");
        }

        return pageNumberLabel;
    }

    private JTextField getPageNumberTextField() {
        if (pageNumberTextField == null) {
            pageNumberTextField = new JTextField();
            pageNumberTextField.setText("1");
        }

        return pageNumberTextField;
    }

    private JLabel getPageSizeLabel() {
        if (pageSizeLabel == null) {
            pageSizeLabel = new JLabel();
            pageSizeLabel.setText("Page Size: ");
        }

        return pageSizeLabel;
    }

    private JTextField getPageSizeTextField() {
        if (pageSizeTextField == null) {
            pageSizeTextField = new JTextField();
            pageSizeTextField.setText("100");
        }

        return pageSizeTextField;
    }

    private JScrollPane getReportScroll() {
        if (reportScroll == null) {
            reportScroll = new JScrollPane();
            reportScroll.setViewportView(getReportLabel());
        }

        return reportScroll;
    }

    private JEditorPane getReportLabel() {
        if (reportLabel == null) {
            reportLabel = new JEditorPane("text/html", "");
            reportLabel.setEditable(false);
        }

        return reportLabel;
    }
}
