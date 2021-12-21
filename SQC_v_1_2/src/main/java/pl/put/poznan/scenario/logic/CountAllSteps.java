package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

public class CountAllSteps extends CountVisit {
    private int stepNum = 0;

    public int getNumberOfSteps(){
        return stepNum;
    }

    public void increment(Step step){
        stepNum++;
    }

    public void resetCount(){
        stepNum = 0;
    }
}
