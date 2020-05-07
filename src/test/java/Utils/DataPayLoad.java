package Utils;

import java.io.File;

public class DataPayLoad {


    public File newCustomerData(){
        File newCustomerData =  new File("./src/test/resources/testData/customerInfo.json");
        return newCustomerData;
    }

    public File newClinetData(){
        File newCustomerData =  new File("./src/test/resources/testData/ClientData.json");
        return newCustomerData;
    }
}
