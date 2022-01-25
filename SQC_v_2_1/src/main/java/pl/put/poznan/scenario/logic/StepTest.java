package pl.put.poznan.scenario.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.scenario.logic.CountVisit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {
    public Step step;
    @BeforeEach
    public void setUp()
    {
        this.step = new Step();

    }

    @Test
    public void testGetNumber(){
        step.setNumber(1);
        assertEquals(1, step.getNumber());
    }

    @Test
    public void testGetActor(){
        step.setActor("Actor");
        assertEquals("Actor", step.getActor());
    }

    @Test
    public void testGetContents(){
        step.setContents(List.of("Jakis Kontent"));
        assertEquals(List.of("Jakis Kontent"), step.getContents());

    }

}