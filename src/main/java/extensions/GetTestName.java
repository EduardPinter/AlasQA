package extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.MDC;

public class GetTestName implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        final String fullyQualifiedTestName = context.getTestClass().get().getSimpleName() + "-"
                + context.getTestMethod().get().getName()
                + "-"
                + context.getDisplayName();

        MDC.put("methodName", fullyQualifiedTestName);

        final String fullMethodName = context.getTestClass().get().getSimpleName() + "-"
                + context.getTestMethod().get().getName();
        MDC.put("folderName", fullMethodName);

        // using this method for creation of custom logs with testName using test/resources/logback.xml file

    }

}

