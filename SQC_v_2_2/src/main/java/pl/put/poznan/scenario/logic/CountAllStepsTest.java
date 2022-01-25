package pl.put.poznan.scenario.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.objects.Step;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CountAllStepsTest {



    CountAllSteps a;
    Step step;
    @BeforeEach
    public void setUp()
    {
        this.a = new CountAllSteps();
        this.step = new Step();
    }

    @Test
    public void testIncrement(){
        a.increment(step);
        assertEquals(1, a.getNumberOfSteps());
    }

    @Test
    public void testResetCount()
    {
        assertEquals(0, a.getNumberOfSteps());
        a.increment(step);
        assertEquals(1, a.getNumberOfSteps());
        a.resetCount();
        assertEquals(0, a.getNumberOfSteps());
    }

    @Test
    public void testGetNumber(){
        assertEquals(0, a.getNumberOfSteps());
    }

}