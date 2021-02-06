package pl.prestashop.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BuildConfiguration {

    static Properties testData;

    static {
        try {
            loadTestData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTestData() throws IOException {
        testData = new Properties();
        testData.load(new FileInputStream("src/test/resources/properties/testData.properties"));
    }

    public static String getTestData(String param) {
        return testData.getProperty(param);
    }
}