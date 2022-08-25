package Utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author jxavier common utility for random number/string and formatting
 */
public class CommonUtil {

    private static Logger log = Logger.getLogger(CommonUtil.class);

    /**
     * @param digits
     * @return returns random number of specified length
     */
    public static String getRandomNumber(Integer digits) {
        String randomNumber;
        int minimum = (int) Math.pow(10, digits - 1);
        int maximum = (int) Math.pow(10, digits) - 1;
        Random random = new Random();
        randomNumber = new DecimalFormat("#").format((minimum + random.nextInt((maximum - minimum) + 1)));
//        log.info("Random number - " + randomNumber);
        return randomNumber;
    }

    /**
     * @param length
     * @return returns random alpha string of specified length
     */
    public static String getRandomAlphaString(Integer length) {
        String randomString = null;
        randomString = RandomStringUtils.randomAlphabetic(length);
        log.info("Random alpha string - " + randomString);
        return randomString;
    }

    /**
     * @param length
     * @return returns random alpha-numeric string of specified length
     */
    public static String getRandomAlphaNumericString(Integer length) {
        String randomString = null;
        randomString = RandomStringUtils.randomAlphanumeric(length);
        log.info("Random alpha-numeric string - " + randomString);
        return randomString;
    }

    /**
     * @param site
     * @return formats the site value in S00000 format
     */
    public static String formatSite(String site) {
        if (!site.matches("^[A-Z]{1}\\d{5}")) {
            if (site.matches("\\d{4}")) {
                site = "0" + site;
            }
            site = "S" + site;
        }
        log.info("Site - " + site);
        return site;
    }

    public static List<Map<String, Object>> sortListOfMapByKeyValue(List<Map<String, Object>> list, String key, String order) {
        Comparator<Map<String, Object>> c
                = Comparator.comparing((Map<String, Object> m) -> m.get(key).toString());
        list.sort(c);
        if (order.toLowerCase().contains("desc"))
            list.sort(c.reversed());
        return list;
    }

    /**
     * @param format
     * @return returns current date in specified format
     */
    public static String getCurrentDate(String format) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        String date = LocalDate.now().format(dateFormat);
        return date;
    }

    /**
     * @return returns current date and time
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().toString();
    }

    /**
     * @param noOfDays, format
     * @return returns future date in specified format
     */
    public static String getFutureDate(Integer noOfDays, String format) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        String date = LocalDate.now().plusDays(noOfDays).format(dateFormat);
        return date;
    }

    /**
     * @param noOfDays, format
     * @return returns future date in specified format
     */
    public static String getPastDate(Integer noOfDays, String format) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        String date = LocalDate.now().minusDays(noOfDays).format(dateFormat);
        return date;
    }

    public static void writeListToTextFile(String path, List<String> content) throws IOException {
        String fileName = getCurrentDateTime();
        fileName = fileName.replace(":", "").split("\\.")[0];
        String filePath = path.replace(".txt", "_" + fileName + ".txt");
        FileWriter fileWriter = new FileWriter(filePath, true);
        for (String line : content) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void writeListOfMapToTextFile(String path, List<Map<String, Object>> fileContent) throws IOException {
        List<String> content = convertListOfMapToList(fileContent);
        String fileName = getCurrentDateTime();
        fileName = fileName.replace(":", "").split("\\.")[0];
        String filePath = path.replace(".txt", "_" + fileName + ".txt");
        FileWriter fileWriter = new FileWriter(filePath, true);
        for (String line : content) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static List<String> convertListOfMapToList(List<Map<String, Object>> data) {
        List<String> list = new ArrayList<>();
        String value = "";
        for (Map<String, Object> map : data) {
            value = "";
            for (String key : map.keySet()) {
                value = value + map.get(key) + "\t";
            }
            list.add(value);
        }
        return list;
    }

    public static String formatDecimalPlace(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("###.00");
        return decimalFormat.format(value);
    }

    public static String formatDecimalPlace(String value) {
        DecimalFormat decimalFormat = new DecimalFormat("###.00");
        return decimalFormat.format(Double.valueOf(value));
    }

}
