package pl.put.poznan.scenario.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.objects.Step;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindStepsWithKeywordsTest {
    private Step step;
    private FindStepsWithKeywords a;

    @BeforeEach
    public void setUp(){
        this.step = new Step();
        this.a = new FindStepsWithKeywords();
    }

    @Test
    public void testSetScenarioText(){
        this.a.setScenarioText("Ten tekst jest na test");
        assertEquals("Ten tekst jest na test", a.getScenarioText());
    }

    @Test
    public void testDisplay(){
        this.step.setContents(List.of("IF"));
        a.display(this.step, "2", 2);
        assertEquals("Indexes of steps containing keywords: \n2 IF\n", a.getScenarioText());
    }
    @Test
    public void testReset(){
        assertEquals("Indexes of steps containing keywords: \n", a.getScenarioText());
        a.setScenarioText("Testowy");
        assertEquals("Testowy", a.getScenarioText());
        a.resetDisplay();
        assertEquals("Indexes of steps containing keywords: \n", a.getScenarioText());

    }

    @Test
    public void testStartScenario(){
        assertEquals("Indexes of steps containing keywords: \n", a.getScenarioText());
    }
}