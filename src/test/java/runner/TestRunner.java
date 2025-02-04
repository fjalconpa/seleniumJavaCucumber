package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", // Directorio de nuestros archivos .feature
    glue = "steps", // paquete donde tenemos nuestras clases definiendo los steps escritos en el feature file
    plugin = { "pretty", "html:target/cucumber-reports" } // Genera un reporte en HTML
)

public class TestRunner {

    
}
