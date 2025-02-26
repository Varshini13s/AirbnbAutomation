package com.automation.steps;
import com.automation.pojo.CreateOrderPojo;
import com.automation.pojo.UpdateUserRequestPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.Constants;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

public class RequestSteps {


    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) throws IOException {
        RestAssuredUtils.clear();
        if (endPoint.contains("@id")) {
            endPoint = endPoint.replace("@id", ConfigReader.getConfigValue("registration.id"));
        }
        if (endPoint.contains("@username")) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(new File("src/test/resources/data/register_user.json"));
            endPoint = endPoint.replace("@username",node.get("username").asText());
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @Given("set request body from file {string}")
    public void set_request_body_from_file(String filePath) throws Exception {
        RestAssuredUtils.setBody(filePath);
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
    }

    @When("user performs delete call")
    public void user_performs_delete_call() {
        RestAssuredUtils.delete();
    }

    @When("user performs put call")
    public void user_performs_put_call() {
        RestAssuredUtils.put();
    }

    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredUtils.get();
    }

    @And("set request body from file {string} with {string} value {string}")
    public void setRequestBodyFromFileWithValue(String filePath, String fieldName, String value) throws Exception {
        String content = RestAssuredUtils.getDataFromJsonFile(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdateUserRequestPojo requestPojo = objectMapper.readValue(content, UpdateUserRequestPojo.class);
        Field field = UpdateUserRequestPojo.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        if (Constants.createBookingIntFields.contains(fieldName)) {
            field.set(requestPojo, Integer.valueOf(value));
        } else {
            field.set(requestPojo, value);
        }
        RestAssuredUtils.setBody(requestPojo);
        ConfigReader.setObject("request_pojo", requestPojo);
    }

    @And("set field {string} with value {string} as form data")
    public void setFieldWithValueAsFormData(String key, String value) {
        RestAssuredUtils.setFormParameter(key, value);
    }

    @And("set request body from file {string} using pojo")
    public void setRequestBodyFromFileUsingPojo(String fileName) throws FileNotFoundException, JsonProcessingException {
        String body = RestAssuredUtils.getDataFromJsonFile(fileName);
        ObjectMapper mapper = new ObjectMapper();
        CreateOrderPojo pojo = mapper.readValue(body, CreateOrderPojo.class);
        ConfigReader.setObject("create.order.pojo", pojo);
        RestAssuredUtils.setBody(pojo);
    }
}

