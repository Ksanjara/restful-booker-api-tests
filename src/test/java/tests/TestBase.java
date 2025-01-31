package tests;

import api.Steps;
import data.TestData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static config.ProjectConfigCreator.config;

public class TestBase {
    Steps steps = new Steps();
    TestData testData = new TestData();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = config.baseApiUri();
    }
}
