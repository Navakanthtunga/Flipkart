package com.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericLib {
	static public String sDirPath = System.getProperty("user.dir");
	public static String sConfigFile = sDirPath+"\\ConfigData.properties";
	
	public static String getCongigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}
	public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
		Date date = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String sdate = sdf.format(date);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = GenericLib.sDirPath+"\\screenshots\\"+screenShotName+"_"+sdate+"_test.png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
}
