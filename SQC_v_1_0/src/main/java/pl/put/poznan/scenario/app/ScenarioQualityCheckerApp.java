package pl.put.poznan.scenario.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenario.rest"})
public class ScenarioQualityCheckerApp {

    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityCheckerApp.class, args);
        System.out.println("\nSCENARIO QUALITY CHECKER\n");
    }
}
