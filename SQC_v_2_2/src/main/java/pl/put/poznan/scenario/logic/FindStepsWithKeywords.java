package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

import java.util.List;

public class FindStepsWithKeywords extends DisplayVisit{
    private String KeywordSteps = "Indexes of steps containing keywords: \n";

    public String getScenarioText() {
        return KeywordSteps;
    }

    public void setScenarioText(String scenarioText) {
        this.KeywordSteps = scenarioText;
    }

    public void display(Step step, String parentNum, int level)
    {
        List<String> content = step.getContents();
        if(content.get(0).equals("IF")){
            KeywordSteps += parentNum + " ";
            KeywordSteps += "IF\n";
        }
        if(content.get(0).equals("ELSE")){
            KeywordSteps += parentNum + " ";
            KeywordSteps += "ELSE\n";
        }
        if(content.get(0).equals("FOR EACH")){
            KeywordSteps += parentNum + " ";
            KeywordSteps += "FOR EACH\n";
        }

    }

    public void resetDisplay() {
        KeywordSteps = "Indexes of steps containing keywords: \n";
    }
}