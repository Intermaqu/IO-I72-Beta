package pl.put.poznan.scenario.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.scenario.logic.*;
import pl.put.poznan.scenario.objects.*;
import pl.put.poznan.scenario.rest.ScenarioQualityCheckerController;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenario.rest"})
public class ScenarioQualityCheckerApp {

    public static void main(String[] args) throws IOException {
        String file = "Aukcja.json";
        SpringApplication.run(ScenarioQualityCheckerApp.class, args);
        ScenarioQualityCheckerController s = new ScenarioQualityCheckerController();

        Path res = Paths.get(Paths.get(".").normalize().toAbsolutePath() + "\\src\\resources");
        Path filePath = Paths.get(res+ "\\" +file);
        String filePathString = filePath.toString();

        System.out.println(s.countAllSteps(filePathString));
        //System.out.println(s.countKeyWordsSteps(filePathString));
    }
}
