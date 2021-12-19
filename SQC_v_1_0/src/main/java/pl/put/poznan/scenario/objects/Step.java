package pl.put.poznan.scenario.objects;

import java.util.List;

public class Step {
    private int number;
    private String actor;
    private List<String> contents;
    private List<String> substeps;

    public Step(){}

    public Step(int num, String act, List<String> con, List<String> sub){
        this.number=num;
        this.actor=act;
        this.contents=con;
        this.substeps=sub;
    }

    public int getNumber(){
        return number;
    }

    public String getActor(){
        return actor;
    }

    public List<String> getContents(){
        return contents;
    }

    public List<String> getSubsteps(){
        return substeps;
    }

    public void setNumber(int num){
        this.number=num;
    }

    public void setActor(String act){
        this.actor=act;
    }

    public void setContents(List<String> con){
        this.contents=con;
    }

    public void setSubsteps(List<String> sub){
        this.substeps=sub;
    }
}
