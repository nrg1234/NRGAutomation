package Utilities;

/**
 * @author jxavier Constant Declaration
 */
public class ConstantVariables {

    public static final int implicitWait = 20;
    public static final int explicitWait = 20;
    public static final int pageLoadWait = 30;
    public static final int shortWait = 2;
    public static final String sample_query = "SELECT * from Opportunity ";

    enum Browsers {
        ie("ie"), edge("edge"), chrome("chrome"), firefox("firefox"), headless("headless");

        private final String browser;

        Browsers(String browser) {
            this.browser = browser;
        }

        public String getBrowser() {
            return browser;
        }
    }


    //    public Integer getPort() {            return port;        }
    }
