package listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestRunListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test success: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failed: {}", result.getName());
    }
}
