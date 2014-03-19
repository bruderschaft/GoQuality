package test.go.mail.ru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by max on 19.03.14.
 */
public class SearchPageTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp() throws Exception {
        webDriver = new FirefoxDriver();
        webDriver.get("http://go.mail.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testPodmes(){
        SearchPage searchPage = new SearchPage(webDriver).putText("16 кг").putText(" в фунты");
        searchPage.submit();
        Assert.assertEquals(searchPage.getICode(), "килограмм", "не килограммы");
        Assert.assertEquals(searchPage.getIVal(), "16", "неправильное количество килограмм");
        Assert.assertEquals(searchPage.getOCode(), "фунта", "не фунты");
        Assert.assertEquals(searchPage.getOVal(), "35,27396", "неправильное количество фунтов");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriver.close();
    }
}
