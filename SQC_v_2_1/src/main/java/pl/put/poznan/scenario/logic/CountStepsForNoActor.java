package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

public class CountStepsForNoActor extends CountVisit{
    private int stepsNum = 0;

    @Override
    public void increment(Step step) {
        if(noActor(step))
            stepsNum++;
    }
    public int getNumberOfSteps(){
        return stepsNum;

    }
    private boolean noActor(Step step) {
        if(step.getActor().equals(""))
            return true;
        return false;
    }

    @Override
    public void resetCount() {
        stepsNum = 0;
    }
}
