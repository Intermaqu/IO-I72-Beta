package pl.put.poznan.scenario.objects;

import pl.put.poznan.scenario.logic.CountVisit;
import pl.put.poznan.scenario.logic.DisplayVisit;
import pl.put.poznan.scenario.logic.ScenarioPrinter;
import pl.put.poznan.scenario.objects.Step;
import java.util.List;

public class Scenario {
    private String title;
    private List<String> actors;
    private List<String> systemActors;
    private List<Step> steps;

    public Scenario(){}
    
    public void permissionToCount(CountVisit visit){
        for(Step step : steps){
            step.permissionToCount(visit);
        }
    }
    public void permissionToDisplay(DisplayVisit visit)
    {
        if(visit instanceof ScenarioPrinter)
            ((ScenarioPrinter)visit).setScenarioText(this.title +"\n");
        for(Step step : steps)
        {
            step.permissionToDisplay(visit, "", 0);
        }
    }

    public String getTitle(){
        return title;
    }

    public List<String> getActors(){
        return actors;
    }

    public List<String> getSystemActors(){
        return systemActors;
    }

    public List<Step> getSteps(){
        return steps;
    }

    public void setTitle(String t){
        this.title=t;
    }

    public void setActors(List<String> a){
        this.actors=a;
    }

    public void setSystemActors(List<String> sa){
        this.systemActors=sa;
    }

    public void setSteps(List<Step> s){
        this.steps=s;
    }
}
