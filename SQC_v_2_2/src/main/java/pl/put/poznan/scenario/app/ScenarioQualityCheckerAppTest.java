package pl.put.poznan.scenario.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.scenario.objects.*;
import pl.put.poznan.scenario.rest.ScenarioQualityCheckerController;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ScenarioQualityCheckerAppTest {
    Statistics stats = new Statistics();
    String file = "Aukcja.json";
    Path res = Paths.get(Paths.get(".").normalize().toAbsolutePath() + "\\src\\resources");
    Path filePath = Paths.get(res+ "\\" +file);
    String filePathString = filePath.toString();
    @Test
    public void testingMocks(){
        ScenarioQualityCheckerController mock = mock(ScenarioQualityCheckerController.class);
        when(mock.countAllSteps(filePathString,stats)).thenReturn(12);
        int result = mock.countAllSteps(filePathString, stats);
        verify(mock).countAllSteps(filePathString,stats);
        assertEquals(12, result);
    }
}
