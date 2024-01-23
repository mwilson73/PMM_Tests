package PMM.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Retry implements IRetryAnalyzer, IAnnotationTransformer {

    public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
                          Method testMethod) {
        testannotation.setRetryAnalyzer(Retry.class);
    }

    int counter = 0;
    int retryLimit = 1; //as per need




    @Override
    public boolean retry(ITestResult result) {

        if(counter < retryLimit)
        {
            counter++;
            return true;
        }

        return false;
    }


}
