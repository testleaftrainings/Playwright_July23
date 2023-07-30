package week4.day2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		System.out.println(testMethod.getName());
		if(testMethod.equals("run_EditLead"))
		annotation.setRetryAnalyzer(week4.day2.RetryFailedTests.class);
	}

}
