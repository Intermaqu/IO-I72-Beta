package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

public class ScenarioPrinter extends DisplayVisit{
    private String scenarioText = "";

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    public void display(Step step, String parentNum, int level)
    {
        for(int i=0; i<level; i++)
            scenarioText += "    ";
        scenarioText += parentNum + " ";
        for(int i=0; i < step.getContents().size(); i++)
            scenarioText += step.getContents().get(i) + " ";
        scenarioText += "\n";
    }

    @Override
    public void resetDisplay() {
        scenarioText = "";
    }

}