package org.example.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExReports {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> ex=new ThreadLocal<>();

    public void init(){
if(extent==null){
    extent=new ExtentReports();
    ExtentSparkReporter spark=new ExtentSparkReporter("TestOutPut/ExtentReprts.html");
spark.config().setReportName("EcommerceAutomation Test Report");
spark.config().setDocumentTitle("Test Title");
extent.attachReporter(spark);
}
    }
public static void flushReport(){
    if (extent != null) {
extent.flush();
    }
    }
public static void createtest(String testname){
        ExtentTest test=extent.createTest(testname);
        ex.set(test);
}
public static ExtentTest gettest(){
return ex.get();
}
public static void removetest(){
        ex.remove();
}
}



