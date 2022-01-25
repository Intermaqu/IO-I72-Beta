package pl.put.poznan.scenario.rest;

import pl.put.poznan.scenario.logic.*;
import pl.put.poznan.scenario.objects.*;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonSyntaxException;

/**
 *   Klasa Restowa ktora jest kontrolerem calej aplikacji. Laczy cala logike.
 *   Posiada aktualnie 3 metody z ktorych 2 zwracaja ilosc krokow a jedna sluzy
 *   do sprawdzenia poprawnosci wczytanego pliku. Klasa bedzie rozbudowywana
 * */

@RestController
public class ScenarioQualityCheckerController{



    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json
     * Zwraca obiekt scenariusz gdy plik jest zgodny ze standardem JSON
     *
     * @param filename   Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @return scenario  Obiekt scenariusz czyli przetworzony JSON
     *
     */

    public Scenario checkJson(@PathVariable String filename){



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

    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json
     * Zwraca ilosc wszystkich krokow w scenariuszu
     *
     * @param   filename  Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @return  result    Ilosc wszystkich krokow w scenariuszu
     *
     * */
    public int countAllSteps(@PathVariable String filename){
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountAllSteps();
        scenario.permissionToCount(visit);
        int result = ((CountAllSteps) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json
     * Zwraca ilosc krokow ze slowami kluczowymi
     *
     * @param   filename  Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @return  result    Ilosc wszystkich krokow ktore posiadaja slowa kluczowe {IF, ELSE, FOR EACH}
     *
     * */

    @RequestMapping(method = RequestMethod.GET, path = "{filename}")
    public int countKeyWordsSteps(@PathVariable String filename) {
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountStepsForKeywords();
        scenario.permissionToCount(visit);
        int result = ((CountStepsForKeywords) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    public int countStepsNoActor(@PathVariable String filename) {
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountStepsForNoActor();
        scenario.permissionToCount(visit);
        int result = ((CountStepsForNoActor) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }
    public String printScenario(@PathVariable String filename) {
        Scenario scenario = checkJson(filename);
        DisplayVisit visit = new ScenarioPrinter();
        scenario.permissionToDisplay(visit);
        String result = ((ScenarioPrinter) visit).getScenarioText();
        visit.resetDisplay();
        return result;
    }
}



