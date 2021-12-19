package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

import java.util.List;

public class CountStepsForNoActor {
    private int stepNum = 0;

    public int getStepNum(){
        return stepNum;
    }

    private static boolean isActor(Step step){
        List<String> content = step.getContents();
        if(step.getActor().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void increment(Step step){
        if(!isActor(step)){
            stepNum++;
        }
    }

    public void resetCount(){
        stepNum = 0;
    }
}
