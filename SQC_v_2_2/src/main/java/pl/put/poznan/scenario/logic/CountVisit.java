package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

abstract public class CountVisit {
    public abstract void increment(Step step);
    public abstract void resetCount();
}
