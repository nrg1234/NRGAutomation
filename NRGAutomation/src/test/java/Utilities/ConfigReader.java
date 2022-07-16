package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author jxavier loads and returns config property instance
 */
public class ConfigReader {

	private Properties prop;
	private Logger log = Logger.getLogger(ConfigReader.class);

	/**
	 * load properties and return config property instance
	 * 
	 * @return
	 */
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("./src/test/resources/Config/configuration.properties");
			prop.load(inputStream);

			for (String propertyName : prop.stringPropertyNames()) {
				String systemPropertyValue = System.getProperty(propertyName);
				if (systemPropertyValue != null) {
					prop.setProperty(propertyName, systemPropertyValue);
				}
			}
		} catch (FileNotFoundException e) {
			log.error("Configuration Property file initialization error. " + e.getStackTrace());
		} catch (IOException e) {
			log.error("Configuration Property file initialization error. " + e.getStackTrace());
		}
		return prop;
	}

}
