package pl.put.poznan.scenario.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.objects.Step;
import pl.put.poznan.scenario.logic.CountStepsForKeywords;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountStepsForKeywordsTest {
    public Step step;
    public CountStepsForKeywords a = new CountStepsForKeywords();
    @BeforeEach
    public void setUp(){
        this.step = new Step();
        this.a = new CountStepsForKeywords();
    }

    @Test
    public void testCheckWord(){
        this.step.setContents(List.of("IF"));
        CountStepsForKeywords x = new CountStepsForKeywords();
        x.increment(this.step);
        assertEquals(1, x.getNumberOfSteps());
    }

    @Test
    public void testReset(){
        this.step.setContents(List.of("IF"));
        a.increment(step);
        a.resetCount();
        assertEquals(0, a.getNumberOfSteps());
    }

    @Test
    public void testNOfStps(){
        assertEquals(0,a.getNumberOfSteps());
    }
}