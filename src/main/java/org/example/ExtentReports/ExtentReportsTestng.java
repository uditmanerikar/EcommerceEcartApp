package org.example.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestng {
    public static ExtentReports getreportObject(){
        String path = System.getProperty("user.dir") + "/ExtentReportsTestng/index.html";
        ExtentSparkReporter rep=new ExtentSparkReporter(path);
        rep.config().setReportName("AutomationEcart");
        rep.config().setDocumentTitle("Test Automation");

        ExtentReports extent=new ExtentReports();
        extent.attachReporter(rep);
        extent.setSystemInfo("user","Udit Uday Manerikar");
    return extent;
    }
}
