package pl.put.poznan.scenario.rest;

import pl.put.poznan.scenario.logic.*;
import pl.put.poznan.scenario.objects.*;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonSyntaxException;

@RestController
public class ScenarioQualityCheckerController{

    @RequestMapping(method = RequestMethod.GET, path = "{filename}")
    public Scenario cheackJson(@PathVariable String filename){
        String JSONfile = new JSONReader().toString(filename);
        if(JSONfile == "")
            return null;
        if (JSONfile == "{}") {
            return null;
        }
        Scenario scenario;
        try{
            scenario = JSONtoObject.getObject(JSONfile);
            return scenario;
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    public int countAllSteps(@PathVariable String filename){
        Scenario scenario = cheackJson(filename);
        CountVisit visit = new CountAllSteps();
        scenario.permissionToCount(visit);
        int result = ((CountAllSteps) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{filenane}")
    public int countKeyWordsSteps(@PathVariable String filename) {
        Scenario scenario = cheackJson(filename);
        CountVisit visit = new CountStepsForKeywords();
        scenario.permissionToCount(visit);
        int result = ((CountStepsForKeywords) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }
}



