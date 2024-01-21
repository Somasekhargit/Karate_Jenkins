import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRunner {

    @Test
    public void tests(){

        Results results = Runner.path("classpath:features").parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());

    }

    public static void generateReport(String outputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(outputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("./src/test/java/reports"), "karate-api-automation");
        new ReportBuilder(jsonPaths, config).generateReports();
    }
}