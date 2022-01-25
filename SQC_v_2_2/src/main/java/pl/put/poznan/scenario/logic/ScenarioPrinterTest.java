package pl.put.poznan.scenario.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.objects.Step;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScenarioPrinterTest {
    private Step step;
    private ScenarioPrinter a;

    @BeforeEach
    public void setUp(){
        this.step = new Step();
        this.a = new ScenarioPrinter();
    }

    @Test
    public void testGetScenarioText(){
        assertEquals("", a.getScenarioText());
    }

    @Test
    public void testSetScenario(){
        a.setScenarioText("Testowe ustawienie");
        assertEquals("Testowe ustawienie", a.getScenarioText());
    }

    @Test
    public void testDisplay(){
        step.setContents(List.of("Testowy kontent"));
        a.display(step, "2", 1);
        assertEquals("    2 Testowy kontent \n", a.getScenarioText());

    }

    @Test
    public void testReset(){
        assertEquals("", a.getScenarioText());
        a.setScenarioText("Testowy");
        assertEquals("Testowy", a.getScenarioText());
        a.resetDisplay();
        assertEquals("", a.getScenarioText());

    }
}