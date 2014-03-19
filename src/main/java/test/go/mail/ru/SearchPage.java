package test.go.mail.ru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by max on 19.03.14.
 */
public class SearchPage {
    private WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchPage putText(String query){
        webDriver.findElement(By.id("q")).sendKeys(query);
        return this;
    }

    public void submit(){
        webDriver.findElement(By.id("q")).submit();
    }

    public String getICode(){
        return webDriver.findElement(By.id("icode")).getText();
    }

    public String getOCode(){
        return webDriver.findElement(By.id("ocode")).getText();
    }

    public String getIVal(){
        return webDriver.findElement(By.id("ival")).getAttribute("value");
    }

    public String getOVal(){
        return webDriver.findElement(By.id("oval")).getText();
    }

}
