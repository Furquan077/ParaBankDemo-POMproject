package com.myPOM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtendReport() {
		
		ExtentReports extentReport = new ExtentReports();
		File sparkfile = new File("target/extentreport/report");
	
		ExtentSparkReporter spark = new ExtentSparkReporter(sparkfile);
		
		//config
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Parabank Test");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		spark.config().setReportName("Automated Parabank test report");
		
		extentReport.attachReporter(spark);
		
		Properties infoprop = new Properties();
		File infopath = new File("C:\\Users\\ADMIN\\eclipse-workspace\\myPOM_Project\\src\\main\\resources\\config.properties");		
		
		try {
			FileInputStream infofis = new FileInputStream(infopath);
			infoprop.load(infofis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//setSystemInfo
		extentReport.setSystemInfo("Application URL", infoprop.getProperty("URL"));
		extentReport.setSystemInfo("Browserused", infoprop.getProperty("browserName"));
		extentReport.setSystemInfo("Username", infoprop.getProperty("username"));
		extentReport.setSystemInfo("Password", infoprop.getProperty("password"));
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		
		return extentReport;
	}
	

}
