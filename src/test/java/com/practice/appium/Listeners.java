package com.practice.appium;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic.Base_Class;


	public class Listeners implements ITestListener{
		ExtentHtmlReporter reporter; // This class is used to set path and do some config
		ExtentReports reports; //Attach the reporter and set system info
		ExtentTest test; //To create the entries in the class

		

		public void onStart(ITestContext arg0) {
			
//			Java_Utility jv=new Java_Utility();
//			String date = jv.date();
//			String time = jv.time();
			reporter=new ExtentHtmlReporter("../appium-21/ExtentReport/reports.html");
			reporter.config().setDocumentTitle("Appium-21");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setReportName("Smoke");
			
			reports=new ExtentReports();
			reports.attachReporter(reporter);
			
			reports.setSystemInfo("BuildNo", "1.2");
			reports.setSystemInfo("Env", "QA");
			reports.setSystemInfo("Platform", "Windows");
			
		}
		
		public void onTestStart(ITestResult result) {
			test=reports.createTest(result.getMethod().getMethodName());
			
		}


		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult result) {
			test.log(Status.FAIL, result.getName()+"is Failed");
			test.log(Status.FAIL, result.getThrowable());
			
			
			try
			{
				String path = Base_Class.getscreenshot(result.getName());
				test.addScreenCaptureFromPath(path);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");
			
		}

		
		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS, result.getMethod().getMethodName()+"is Passed");
			
		}
		
		public void onFinish(ITestContext arg0) {
			reports.flush();
			
		}
		

		

	}


