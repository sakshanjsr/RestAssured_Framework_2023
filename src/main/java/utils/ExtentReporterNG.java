package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject(String finename , String reportName, String documentTitle) {
		
		String path = finename;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path) ;
		sparkReporter.config().setReportName(reportName);
		sparkReporter.config().setDocumentTitle(documentTitle);
		sparkReporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Saket Shankar");
		
		return extent;
		
	}
	
	public static String getReportNameWithTimestamp() {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String formattedTime = dt.format(localDateTime);
		String reportName = "TestReport" + formattedTime + ".html";
		return reportName;
	}
	
	public static void logPassDetails(String log) {
		Listners.extentTestThreadLocal.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}
	
	public static void logFailDetails(String log) {
		Listners.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}
	
	public static void logInfoDetails(String log) {
		Listners.extentTestThreadLocal.get().info(MarkupHelper.createLabel(log, ExtentColor.CYAN));
	}
	
	public static void logWarningDetails(String log) {
		Listners.extentTestThreadLocal.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
	}
	
	public static void logInfo(String JSON) {
		Listners.extentTestThreadLocal.get().info(MarkupHelper.createCodeBlock(JSON, CodeLanguage.JSON));
	}
	
	public static void logHeaders(List<Header> headerList) {
		String[][] arrayHeaders = headerList.stream().map(header -> new String[] {header.getName(),header.getValue()})
				.toArray(String[][]:: new);
		Listners.extentTestThreadLocal.get().info(MarkupHelper.createTable(arrayHeaders));
	}
	
	

}
