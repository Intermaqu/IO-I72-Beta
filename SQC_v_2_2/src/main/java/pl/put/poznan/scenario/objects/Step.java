package pl.put.poznan.scenario.objects;

import pl.put.poznan.scenario.logic.CountVisit;
import pl.put.poznan.scenario.logic.DisplayVisit;
import java.util.List;

public class Step {
    private Integer number;
    private String actor;
    private List<String> contents;
    private List<Step> subSteps;

    public Step(){}

    public void permissionToCount(CountVisit visit){
        visit.increment(this);
        if(!this.subSteps.isEmpty()){
            for(Step step : subSteps){
                step.permissionToCount(visit);
            }
        }
    }
    public void permissionToDisplay(DisplayVisit visit, String num, int level)
    {
        num += this.number+".";
        visit.display(this, num, level);
        if(!this.subSteps.isEmpty()) {
            level++;
            for (Step step : subSteps)
                step.permissionToDisplay(visit, num, level);
        }
    }

    public Integer getNumber(){
        return number;
    }

    public String getActor(){
        return actor;
    }

    public List<String> getContents(){
        return contents;
    }

    public List<Step> getSubsteps(){
        return subSteps;
    }

    public void setNumber(Integer n){
        this.number=n;
    }

    public void setActor(String a){
        this.actor=a;
    }

    public void setContents(List<String> c){
        this.contents=c;
    }

    public void setSubsteps(List<Step> s){
        this.subSteps=s;
    }
}
