package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Scenario;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JSONtoObject {
    public static Scenario getObject(String scenarioJSON) throws JsonSyntaxException{
        Gson gson = new Gson();
        return gson.fromJson(scenarioJSON,Scenario.class);
    }
}
