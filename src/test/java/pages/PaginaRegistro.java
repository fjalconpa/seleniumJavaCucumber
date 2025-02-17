package pages;

import java.util.List;

public class PaginaRegistro extends BasePage {

    private String planDrowDown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public PaginaRegistro(){
        super(driver);
    }

    public List<String> returnPlanDropDownvalues(){
        return getDropDownValues(planDrowDown);
    }
}
