package pages;


public class PaginaPrincipal extends BasePage{

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";
    
    // Constructor de la clase
    public PaginaPrincipal(){
        super(driver);
    }

    // Método para navegar a la página principal www.freerangetester.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickOnSectionNavigationBar(String section) {
        // Reemplazar el marcador de posición en sectionLink con el valor de la variable
        // section
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlan() {
        // Reemplazar el marcador de posición en sectionLink con el valor de la variable
        // section
        clickElement(elegirPlanButton);
    }

}
