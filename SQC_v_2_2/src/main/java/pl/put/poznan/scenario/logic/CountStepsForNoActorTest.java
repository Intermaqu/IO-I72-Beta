package pl.put.poznan.scenario.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.objects.Step;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountStepsForNoActorTest {
    private Step step;
    private CountStepsForNoActor a;
    @BeforeEach
    public void setUp(){
        this.step = new Step();
        this.a = new CountStepsForNoActor();
    }

    @Test
    public void testNoActor(){
        this.step.setActor("");
        int n = a.getNumberOfSteps();
        a.increment(this.step);
        assertEquals(n+1, a.getNumberOfSteps());
    }

    @Test
    public void testReset(){
        this.step.setActor("");
        a.increment(step);
        a.resetCount();
        assertEquals(0, a.getNumberOfSteps());
    }
    @Test
    public void testGetNumber(){
        assertEquals(0, a.getNumberOfSteps());
    }
}
