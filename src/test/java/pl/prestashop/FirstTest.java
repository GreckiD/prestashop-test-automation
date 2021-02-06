package pl.prestashop;

import org.testng.annotations.Test;

import static pl.prestashop.config.BuildConfiguration.getTestData;

public class FirstTest extends BaseTest{

    private String url = getTestData("url");

    @Test
    public void test(){
        driver.get(url);
    }

}
