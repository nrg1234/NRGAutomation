package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * @author jxavier general utility contains selenium wrapper functions
 */
public class CommonFunctions {
static WebDriver driver;
	private Logger log = Logger.getLogger(CommonFunctions.class);

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 *            locates dropdown by locator and selects value by visible text
	 */
	public void selectDropdownByVisibleText(WebDriver driver, By locator, String value) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByVisibleText(value);
		} catch (Exception e) {
			log.error("Unable to select dropdown value. " + e);
			
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param index
	 *            locates dropdown by locator and selects value by option index
	 */
	public void selectDropdownByIndex(WebDriver driver, By locator, int index) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByIndex(index);
		} catch (Exception e) {
			log.error("Unable to select dropdown value. " + e);
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @param value
	 *            selects value in dropdown by visible text
	 */
	public void selectDropdownByVisibleText(WebDriver driver, WebElement element, String value) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait)).until(ExpectedConditions.visibilityOf(element));
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(value);
		} catch (Exception e) {
			log.error("Unable to select dropdown value. " + e);
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @param index
	 *            selects value in dropdown by option index
	 */
	public void selectDropdownByIndex(WebDriver driver, WebElement element, int index) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait)).until(ExpectedConditions.visibilityOf(element));
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
		} catch (Exception e) {
			log.error("Unable to select dropdown value. " + e);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 *            clicks on specific web element located by locator
	 */
	public void click(WebDriver driver, By locator) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWaitSiebel))
					.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.error("Unable to click on element. " + e);
		}
	}

	/**
	 * @param driver
	 * @param element
	 *            clicks on specific web element
	 */
	public void click(WebDriver driver, WebElement element) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			log.error("unable to click on element. " + e);
		}
	}
	


	/**
	 * @param driver
	 * @param element
	 * @param option
	 *            checks/unchecks checkbox based on element current state and
	 *            option passed
	 */
	public void clickCheckbox(WebDriver driver, WebElement element, String option) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.elementToBeClickable(element));
			if (!element.isSelected()
					&& (option.equalsIgnoreCase("check") || option.equalsIgnoreCase("select"))) {
				element.click();
				log.info("Checkbox is checked");
			} else if (element.isSelected() && (option.equalsIgnoreCase("check") || option.equalsIgnoreCase("select")))
				log.info("Checkbox already checked");
			else if (element.isSelected()
					&& (option.equalsIgnoreCase("uncheck") || option.equalsIgnoreCase("unselect"))) {
				element.click();
				log.info("Checkbox is unchecked");
			} else if (!element.isSelected()
					&& (option.equalsIgnoreCase("uncheck") || option.equalsIgnoreCase("unselect")))
				log.info("Checkbox already unchecked");
		} catch (Exception e) {
			log.error("Unable to check/uncheck checkbox. " + e.getStackTrace());

		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 *            sets text on web element (text field & text area) located by
	 *            locator
	 */
	public void setText(WebDriver driver, By locator, String value) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(value);
		} catch (Exception e) {
			log.error("Unable to set text on element. " + e);
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @param value
	 *            sets text on web element (text field & text area)
	 */
	public void setText(WebDriver driver, WebElement element, String value) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait)).until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			log.error("Unable to set text on element. " + e);
		}

	}

	/**
	 * @param driver
	 * @param locator
	 * @return gets text (inner html) from web element located by locator
	 */
	public String getText(WebDriver driver, By locator) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).getText().trim().replaceAll("[\r\n]+", " ");
		} catch (Exception e) {
			log.error("Unable to get text from element. " + e);
			return null;
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @return gets text (inner html) from web element
	 */
	public String getText(WebDriver driver, WebElement element) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait)).until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		} catch (Exception e) {
			log.error("Unable to get text from element. " + e);
			return null;
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @return gets value from web element (input element) located by locator
	 */
	public String getValue(WebDriver driver, By locator) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).getAttribute("value");
		} catch (Exception e) {
			log.error("Unable to get value from element. " + e);
			return null;
		}
	}

	/**
	 * @param driver
	 * @param element
	 * @return gets value from web element (input element)
	 */
	public String getValue(WebDriver driver, WebElement element) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait)).until(ExpectedConditions.visibilityOf(element));
			return element.getAttribute("value");
		} catch (Exception e) {
			log.error("Unable to get value from element. " + e);
			return null;
		}
	}

	/**
	 * @param driver
	 * @param elements
	 * @return gets selected option in a dropdown field
	 */
	public String getSelectedValue(WebDriver driver, List<WebElement> elements) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOf(elements.get(0)));
			for (WebElement element : elements) {
				if (element.getAttribute("selected").equals("selected"))
					return getText(driver, element);
			}
			return null;
		} catch (Exception e) {
			log.error("Unable to get selected value from element. " + e);
			return null;
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @return checks whether element present in dom
	 */
	public boolean isElementPresent(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Object obj = ((JavascriptExecutor) driver)
					.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;", element);
			if (obj.toString().contains("true")) {
				log.info("Element is displayed");
				return true;
			} else {
				log.error("Element is not displayed");
				return false;
			}
		} catch (NoSuchElementException e) {
			log.error("No such element found. " + e);
			return false;
		}
	}

	/**
	 * @param driver
	 * @param parentElement
	 * @param locator
	 * @return checks whether element present with reference to parent element
	 *         in dom
	 */
	public boolean isElementPresent(WebDriver driver, WebElement parentElement, By locator) {
		try {
			driver.manage().timeouts().implicitlyWait(ConstantVariables.shortWait, TimeUnit.SECONDS);
			Object obj = ((JavascriptExecutor) driver).executeScript(
					"return typeof(arguments[0]) != 'undefined' && arguments[0] != null;",
					parentElement.findElement(locator));
			if (obj.toString().contains("true")) {
				log.info("Element is displayed");
				return true;
			} else {
				log.error("Element is not displayed");
				return false;
			}
		} catch (NoSuchElementException e) {
			log.error("No such element found. " + e);
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(ConstantVariables.implicitWait, TimeUnit.SECONDS);
		}
	}

	/**
	 * @param driver
	 * @param parentElement
	 * @param locator
	 * @return checks whether element visibility with reference to parent
	 *         element in dom
	 */
	public boolean isElementVisible(WebDriver driver, WebElement parentElement, By locator) {
		try {
			driver.manage().timeouts().implicitlyWait(ConstantVariables.shortWait, TimeUnit.SECONDS);
			return parentElement.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			log.info("Element is not displayed");
			return false;
		} catch (TimeoutException e) {
			log.error("Element is not displayed. " + e);
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(ConstantVariables.implicitWait, TimeUnit.SECONDS);
		}
	}

	/**
	 * @param driver
	 * @return waits for dom state to be ready
	 */
	public Boolean waitforPageLoad(WebDriver driver) {
		try {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		} catch (Exception e) {
			log.error("Error in wait for page load. " + e);
			return false;
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @return explicitly waits for element to be visible
	 */
	public Boolean waitforElementVisible(WebDriver driver, By locator) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			log.error("Element is not displayed. " + e);
			return false;
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @return explicitly waits for element to be clickable
	 */
	public Boolean waitforElementClickable(WebDriver driver, By locator) {
		try {
			(new WebDriverWait(driver, ConstantVariables.explicitWait))
					.until(ExpectedConditions.elementToBeClickable(locator));
			return driver.findElement(locator).isEnabled();
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	/**
	 * @param driver
	 * @param locator
	 *            switches to a specific frame in dom
	 */
	public void switchToFrameByLocator(WebDriver driver, By locator) {
		try {
			driver.switchTo().frame(driver.findElement(locator));
		} catch (StaleElementReferenceException e) {
			log.error("Unable to switch to frame. ", e);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 *            switches to multiple frames in dom
	 */
	public void switchToFramesByLocator(WebDriver driver, By[] locator) {
		try {
			for (By frame : locator)
				driver.switchTo().frame(driver.findElement(frame));
		} catch (StaleElementReferenceException e) {
			log.error("Unable to switch to frame. ", e);
		}
	}

	/**
	 * @param driver
	 *            switches back to default content from frames
	 */
	public void switchToDefaultContent(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (StaleElementReferenceException e) {
			log.error("Unable to switch to default content. ", e);
		}
	}

	public String getLocatorFromWebElement(WebElement element) {
		return element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "");
	}

	public void shortWait() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void mediumWait() throws InterruptedException {
		Thread.sleep(23000);
	}
	
	public void midWait() throws InterruptedException {
		Thread.sleep(30000);
	}

	public void longWait() throws InterruptedException {
		Thread.sleep(60000);
	}
	
	public void intermediatewait() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void dealconversion() throws InterruptedException {
		Thread.sleep(90000);
	}
	
	public void waitforcontactgeneration() throws InterruptedException {
		Thread.sleep(600000);
	}
	
	
	
	

	/**
	 * @param //driver
	 *           Method to Scroll to an element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int yaxis = element.getLocation().getY();
		int height = element.getSize().getHeight();
		int scrollHeight = yaxis-height;
		js.executeScript("scroll(0, "+scrollHeight+");");
	}
	
	/**
	 * @param //driver
	 *           Waits till the Element becomes visible
	 */
	public void waitForvisibility(WebDriver driver, WebElement element,int seconds) {
		try {
			(new WebDriverWait (driver, seconds))
			.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		}catch(Exception e) {

		}
}
	public void waitForvisibility1(WebDriver driver,By opportunitiesTabsiebe,int seconds) {
		try {
			(new WebDriverWait (driver, seconds))
			.until(ExpectedConditions.visibilityOfElementLocated( opportunitiesTabsiebe));
		}catch(Exception e) {

		}
}
	
	public boolean waitFor(WebDriver driver,WebElement element,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
		/**
		 * @param //driver
		 *           Waits till the Element becomes invisible
		 */
		
		public void waitForinvisibility(WebDriver driver,WebElement element,int seconds) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
			}catch(Exception e) {

			}
	}

		/**
		 * @param //driver
		 *           This Method is to Import HU File using Robot
		 */
	
	    public void uploadFileWithRobot (String filePath) {
	        StringSelection stringSelection = new StringSelection(filePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	 
	        Robot robot = null;
	 
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	 
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
		
	
	    /**
		 * @param //driver
		 *          This Method is for capturing Screenshots
		 */
	    public static String getBase64Screenshot() throws IOException {
			String Base64StringOfScreenshot = "";
			TakesScreenshot screen=(TakesScreenshot)driver;
			File src=screen.getScreenshotAs(OutputType.FILE);

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
			String sDate = sdf.format(date);
			FileUtils.copyFile(src, new File("./Screenshots" + "image_" + sDate + ".png"));

			byte[] fileContent = FileUtils.readFileToByteArray(src);
			Base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			return Base64StringOfScreenshot;
		}

		public static byte[] getByteScreenshot() throws IOException {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[]filecontent=FileUtils.readFileToByteArray(src);
			return filecontent;
		}
		
		
		 /**
		 * @param //driver
		 *          This Method is for Encrypting the Password
		 */
		 public String Encryption() throws IOException {
		        ConfigReader config = new ConfigReader();
		        Properties prop = config.init_properties();
		        String encPass = prop.getProperty("SiebelPassword");
		        System.out.println(encPass);

		        byte[] decpass = Base64.getDecoder().decode(encPass);

		        String passNew = new String(decpass);
		        System.out.println(passNew);

		        //Storing and Returning the text into a String
		        final String encryptedpassword = passNew;
		        System.out.println(encryptedpassword);
		        return encryptedpassword;

		    }

}