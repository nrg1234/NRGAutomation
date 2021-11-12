package Stepdefinitions.Siebel;


import Pages.Siebel.BAApprovescreditinSiebel;
import Utilities.CommonFunctions;
import Utilities.ExcelUtil;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;


public class Enrollment  {
    String optyID;
    String password;

    BAApprovescreditinSiebel siebel;
    CommonFunctions encrypted = new CommonFunctions();

    @Then("SIEBEL : Approves Credit")
    public void Ba_approves_credit_in_siebel() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            siebel.BAApprovescreditinSiebel(currentrow, optyID);
            System.out.println("credit has been Successfully approved in Siebel");
            break;
        }
    }


}

