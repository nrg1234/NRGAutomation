package Utilities;

/**
 * @author jxavier Constant Declaration
 */
public class ConstantVariables {

    public static final int implicitWait = 20;
    public static final int explicitWait = 20;
    public static final int pageLoadWait = 30;
    public static final int shortWait = 2;
    public static final String stg_mas_dr_customer_query = "SELECT * FROM wm_csd_dr_staging_ks_db_environment.stg_mas_dr_customer\r\n"
            + "WHERE library='ARDTA.library_name' and cmpy_cd='company_code' and service_nm='service_name' ALLOW FILTERING;";
    public static final String stg_mas_dr_customer_by_id_query = "SELECT * FROM wm_csd_dr_staging_ks_db_environment.stg_mas_dr_customer\r\n"
            + "WHERE mas_cus_uniq_id='mas_customer_id' ALLOW FILTERING;";
    public static final String ro_site_library_query = "SELECT * FROM erl_rt_optimizer.ro_site_library \r\n"
            + "WHERE library_nm = 'ARDTA.library_name' and company_cd ='company_code' ALLOW FILTERING;";
    public static final String mas_dr_cust_service_query = "SELECT * FROM wm_csd_ks_db_environment.mas_dr_cust_service\r\n"
            + "WHERE mas_unique_id='mas_customer_unique_id' ALLOW FILTERING;";
    public static final String mas_dr_ro_cust_service_query = "SELECT * FROM wm_csd_ks_db_environment.mas_dr_ro_cust_service\r\n"
            + "WHERE mas_unique_id='mas_customer_unique_id' ALLOW FILTERING;";
    public static final String mas_dr_ro_cust_service_by_site_query = "SELECT * FROM wm_csd_ks_db_environment.mas_dr_ro_cust_service\r\n"
            + "WHERE site='site_value' AND active_flag='Y'\n"
            + "AND geocode_status_cd='M' AND mas_service_unique_id='1' ALLOW FILTERING;";
    public static final String stg_ro_od_transactions_query = "SELECT * FROM wm_csd_dr_staging_ks_db_environment.stg_ro_od_transactions \r\n"
            + "WHERE site='site_value' AND trans_dt='transaction_date' AND loc_type='location_type' ALLOW FILTERING;";
    public static final String job_log_summary_nrt_query = "SELECT * FROM wm_csd_ks_qat.job_log_summary WHERE site = 'site_value' AND job_dt='transaction_date' \r\n"
            + "AND job_nm='Build-NRT-OD-RO-Job-At-Enterprise-Level-Attinity' ALLOW FILTERING;";
    public static final String wm_csd_ro_od_matrix_by_origin_query = "SELECT * FROM wm_csd_ks_qat.wm_csd_ro_od_matrix\n" +
            "WHERE site='site_value' AND orig_id='od_loc_id' ALLOW FILTERING;";
    public static final String wm_csd_ro_od_matrix_by_destination_query = "SELECT * FROM wm_csd_ks_qat.wm_csd_ro_od_matrix\n" +
            "WHERE site='site_value' AND dest_id='od_loc_id' ALLOW FILTERING;";

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

    enum CassandraConnection {
        qa("j_xavier", "fRTFXrGPATQ5Fp6p", "10.163.101.117", 9042), qa2("j_xavier", "fRTFXrGPATQ5Fp6p",
                "10.163.101.117", 9042), qat("j_xavier", "fRTFXrGPATQ5Fp6p", "10.163.101.117", 9042);

        private final String username;
        private final String password;
        private final String host;
        private final Integer port;

        CassandraConnection(String username, String password, String host, Integer port) {
            this.username = username;
            this.password = password;
            this.host = host;
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getHost() {
            return host;
        }

        public Integer getPort() {
            return port;
        }
    }
}
