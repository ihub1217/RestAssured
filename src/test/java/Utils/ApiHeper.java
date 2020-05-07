package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ApiHeper {


    private Response response;
    private DataPayLoad dataPayload = new DataPayLoad();
    private Constants constants = new Constants();
    private JsonPath jsonPath;

    public void performPostRequest() throws IOException {

        Properties configProps = new Properties();
        FileInputStream configFile = new FileInputStream("./src/test/java/config/configuration.properties");
        configProps.load(configFile);

        response = given().header("contentType", "application/json").
                when()
                .body(dataPayload.newCustomerData())
                .post(configProps.getProperty("BASEUrl")+configProps.getProperty("basPath")+configProps.getProperty("Endpoint"));
    }

    public void performPostRequestUsingConstants(){

       response = given().header("contentType", "application/json").
                when()
                .body(dataPayload.newCustomerData())
                .post(constants.baseUrl+ constants.basePath+"/users");

    }

    public void validateResponseCode(int statusCode){
        Assert.assertEquals(statusCode, response.getStatusCode());
    }


    //This is generic method used to check the value which is coming from step definition is present in the response body.
    public void validateResponseBodyContainsValue(String field) {
        jsonPath = response.jsonPath();
        org.junit.Assert.assertNotNull(jsonPath.get(field));
    }

    //This is generic method used to check the value which is coming from step definition is not present in the response body.
    public void validateResponseBodyDoesNotContainedValue(String field) {
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        org.junit.Assert.assertFalse(bodyAsString.contains(field));
    }

    //This is generic method used to validate the actual and expected value for value provided in step definition or api.
    public void validatePropertyValueInResponseBody(String property, String propertyValue) {
        response.then().body(property, containsString(propertyValue));
    }

    //This is generic method to get the property value of field
    public String getValueFromResponseBody(String propertyKey) {
        jsonPath = new JsonPath(response.asString());
        return jsonPath.getString(propertyKey);
    }

    
}
