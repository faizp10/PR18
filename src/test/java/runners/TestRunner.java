package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.TestCases;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCases.class
})
public class TestRunner {
}
