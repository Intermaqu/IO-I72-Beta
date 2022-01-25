package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;
import java.util.List;

public class CountStepsForKeywords extends CountVisit {
    private int stepNum = 0;

    public int getNumberOfSteps(){
        return stepNum;
    }

    private static boolean isKeyword(Step step){
        List<String> content = step.getContents();
        if(content.get(0).equals("IF")){
            return true;
        }
        if(content.get(0).equals("ELSE")){
            return true;
        }
        if(content.get(0).equals("FOR EACH")){
            return true;
        }
        return false;
    }

    public void increment(Step step){
        if(isKeyword(step)){
            stepNum++;
        }
    }

    public void resetCount(){
        stepNum = 0;
    }
}
