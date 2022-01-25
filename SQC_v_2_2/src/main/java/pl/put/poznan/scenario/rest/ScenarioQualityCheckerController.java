package pl.put.poznan.scenario.rest;

import pl.put.poznan.scenario.logic.*;
import pl.put.poznan.scenario.objects.*;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonSyntaxException;

/**
 *   Klasa Restowa ktora jest kontrolerem calej aplikacji. Laczy cala logike.
 *   Posiada aktualnie 6 metody z ktorych 3 zwracaja ilosc krokow, 1 sluzy
 *   do sprawdzenia poprawnosci wczytanego pliku a 2 do wyswietlenia czesci badz calego scenariusza.
 *   * */

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
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json i zmienna klasy Scenario
     * Zwraca ilosc wszystkich krokow w scenariuszu
     *
     * @param   filename  Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @param   stats     Obiek klasy Statistics ktora zlicza ilosc wywolan wszystkich metod
     * @return  result    Ilosc wszystkich krokow w scenariuszu
     *
     * */
    public int countAllSteps(@PathVariable String filename, Statistics stats){
        stats.incrementCountAllSteps();
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountAllSteps();
        scenario.permissionToCount(visit);
        int result = ((CountAllSteps) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json i zmienna klasy Scenario
     * Zwraca ilosc krokow ze slowami kluczowymi
     *
     * @param   filename  Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @param   stats     Obiek klasy Statistics ktora zlicza ilosc wywolan wszystkich metod
     * @return  result    Ilosc wszystkich krokow ktore posiadaja slowa kluczowe {IF, ELSE, FOR EACH}
     *
     * */

    @RequestMapping(method = RequestMethod.GET, path = "{filename}")
    public int countKeyWordsSteps(@PathVariable String filename, Statistics stats) {
        stats.incrementCountStepsForNoKeyword();
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountStepsForKeywords();
        scenario.permissionToCount(visit);
        int result = ((CountStepsForKeywords) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json i zmienna klasy Scenario
     * Zwraca ilosc krokow ze scenariusza w ktorych Aktor jest pustym stringiem (Nie ma aktora)
     *
     * @param filename   Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @param stats      Obiek klasy Statistics ktora zlicza ilosc wywolan wszystkich metod
     * @return result    Ilosc wszystkich krokow scenariusza ktore nie posiadaja slowa aktora
     *
     */

    public int countStepsNoActor(@PathVariable String filename, Statistics stats) {
        stats.incrementCountStepsForNoActor();
        Scenario scenario = checkJson(filename);
        CountVisit visit = new CountStepsForNoActor();
        scenario.permissionToCount(visit);
        int result = ((CountStepsForNoActor) visit).getNumberOfSteps();
        visit.resetCount();
        return result;
    }

    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json i zmiennaa klasy Scenario
     * Zwraca String ktory zawiera caly scenariusz w formie drzewiastej
     *
     * @param filename   Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @param stats      Obiek klasy Statistics ktora zlicza ilosc wywolan wszystkich metod
     * @return result    Scenariusz skonwertowany z JSON do String i sformatowany w formie listy zagniezdzonej
     *
     */
    public String printScenario(@PathVariable String filename, Statistics stats) {
        stats.incrementScenarioPrinter();
        Scenario scenario = checkJson(filename);
        DisplayVisit visit = new ScenarioPrinter();
        scenario.permissionToDisplay(visit);
        String result = ((ScenarioPrinter) visit).getScenarioText();
        visit.resetDisplay();
        return result;
    }
    /**
     *
     * Metoda ktora na wejsciu przyjmuje nazwe pliku z rozszerzenie .json i zmienna klasy Scenario
     * Zwraca String ktory zawiera indeksy krokow scenariusza ze slowami kluczowymi
     *
     * @param filename   Nazwa pliku w formacie JSON z scenariuszem do przetworzenia
     * @param stats      Obiek klasy Statistics ktora zlicza ilosc wywolan wszystkich metod
     * @return result    Indeksy krokow i slowa kluczowe jako String ktory przy wyswietleniu tworzy liste zagniezdzona.
     *
     */

    public String findStepsWithKeywords(@PathVariable String filename, Statistics stats) {
        stats.incrementFindStepsWithKeywords();
        Scenario scenario = checkJson(filename);
        DisplayVisit visit = new FindStepsWithKeywords();
        scenario.permissionToDisplay(visit);
        String result = ((FindStepsWithKeywords) visit).getScenarioText();
        visit.resetDisplay();
        return result;
    }
}



