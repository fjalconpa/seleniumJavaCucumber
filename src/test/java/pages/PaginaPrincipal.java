package pages;

public class PaginaPrincipal extends BasePage{
    
    // Constructor de la clase
    public PaginaPrincipal(){
        super(driver);
    }

    // Método para navegar a la página principal www.freerangetester.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }
}
