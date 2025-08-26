package eu.senla.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public final class SuiteXmlTransformer implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        String threadCount = System.getProperty("thread-count", "5");
        String parallel = System.getProperty("parallel", "classes");
        System.out.println("11111111 - " + threadCount);

        for (XmlSuite suite : suites) {
            suite.setThreadCount(Integer.parseInt(threadCount));
            suite.setParallel(XmlSuite.ParallelMode.getValidParallel(parallel));
        }
    }

}
