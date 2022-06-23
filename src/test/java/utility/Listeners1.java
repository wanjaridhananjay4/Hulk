package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import test.BaseTest;

public class Listeners1 extends BaseTest implements ITestListener{
	
	ScreenShot sc;

	public void onTestFailure(ITestResult result) {
		
		sc=new ScreenShot();
		
		try {
			sc.captureScreen(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
