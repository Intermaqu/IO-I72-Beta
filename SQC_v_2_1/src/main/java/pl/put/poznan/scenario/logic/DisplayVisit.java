package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

abstract public class DisplayVisit {
    public abstract void display(Step step, String parentNum, int level);
    public abstract void resetDisplay();
}