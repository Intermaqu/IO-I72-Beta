package pl.put.poznan.scenario.objects;

import java.util.List;

public class Scenario {
    private String title;
    private List<String> actors;
    private List<String> system_actors;
    private List<String> steps;

    public Scenario(){}

    public Scenario(String tit, List<String> act, List<String> sysact, List<String> st){
        this.title=tit;
        this.actors=act;
        this.system_actors=sysact;
        this.steps=st;
    }

    public String getTitle(){
        return title;
    }

    public List<String> getActors(){
        return actors;
    }

    public List<String> getSystemActors(){
        return system_actors;
    }

    public List<String> getSteps(){
        return steps;
    }

    public void setTitle(String tit){
        this.title=tit;
    }

    public void setActors(List<String> act){
        this.actors=act;
    }

    public void setSystemActors(List<String> sysact){
        this.system_actors=sysact;
    }

    public void setSteps(List<String> st){
        this.steps=st;
    }
}
