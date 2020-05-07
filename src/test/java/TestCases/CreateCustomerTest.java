package TestCases;

import Utils.ApiHeper;
import org.testng.annotations.Test;

import java.io.*;


public class CreateCustomerTest {

        public static ApiHeper apiHeper = new ApiHeper();

       @Test
       //thi stets verifies  post request to create a customer
        public static void testCreateCustomer(){
          apiHeper.performPostRequestUsingConstants();
        }


        @Test
        public static void testCreateCustomerInStripe() throws IOException {
             apiHeper.performPostRequest();
             apiHeper.validateResponseCode(201);
        }



}

