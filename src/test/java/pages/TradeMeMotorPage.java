package pages;

public class TradeMeMotorPage extends BasePage {

    private String makeDropDown = "//select[@name='selectedMake']";
    private String searchMakeButton = "//button[@type='submit']";
    private String resultsLabel = "//h3[@class='tm-search-header-result-count__heading ng-star-inserted']";

    public TradeMeMotorPage() {
        super(driver);
    }

    public void navigateToTradeMeMotor() {
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

    public int makeDropdownSize() {
        return dropDownSize(makeDropDown);
    }

    public void selectCarMake(String make) {
        selectFromDropdownByValue(makeDropDown, make);
    }

    public void clickSearchMake() {
        clickElement(searchMakeButton);
    }

    public String getResultsAmount() {
        return textFromElement(resultsLabel);
    }

}
