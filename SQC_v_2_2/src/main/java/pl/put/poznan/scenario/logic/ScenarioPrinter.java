package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

    /**
    *   Klasa sluzaca do wypisania na ekran uzytkownika scenariusza w postaci tekstu z numeracja krokow.
    *   Klasa jest rozszerzeniem klasy DisplayVisit.
    *   Jest to duzo wygodniejszy i czytelniejszy format dla uzytkownika niz scenariusz w pliku JSON.
    *   Klasa sklada sie z 4 metod, z ktorych dwie sluza do zapisywania wartosci do zmiennej oraz pobierania tej wartosci.
    *   Kolejna metoda sluzy do przygotowania tekstu scenariusza, a ostatnia resetuje wartosc zmiennej.
    */

public class ScenarioPrinter extends DisplayVisit{
    private String scenarioText = "";

    /**
    *
    * Metoda ktora nie przyjmuje argumentow na wejsciu.
    * Zwraca zmienna scenarioText typu String zawierajaca cenariusz w formie tekstu.
    *
    * @return scenarioText  Zmienna zawierajaca scenariusz w formie tekstu z numeracja krokow
    *
    */

    public String getScenarioText() {
        return scenarioText;
    }

    /**
    *
    * Metoda ktora przypisuje wartosc do zmiennej scenarioText.
    * Metoda jest typu void wiec nic nie zwraca.
    *
    * @param scenarioText   String zawierajacy przygotowany w formie tekstu scenariusz
    *
    */

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    /**
    *
    * Metoda ktora sluzy do przygotowania scenariusza w formie tekstu.
    * Dziala na zmiennej klasy scenarioText dopisujac do niej kolejne fragmenty scenariusza.
    * Metoda przyjmuje 3 prarametry.
    * Metoda jest typu void wiec nic nie zwraca.
    *
    * @param step   Obiekt Step zawierajacy dane na temat poszczegolnych krokow scenariusza
    * @param parentNum   String zawierajacy numer danego kroku lub podkroku
    * @param level   int zawierajacy poziom zaglebienia w scenariuszu
    **/
    public void display(Step step, String parentNum, int level)
    {
        for(int i=0; i<level; i++)
            scenarioText += "    ";
        scenarioText += parentNum + " ";
        for(int i=0; i < step.getContents().size(); i++)
            scenarioText += step.getContents().get(i) + " ";
        scenarioText += "\n";
    }

    /**
     *
     * Metoda ktora sluzy do resetowania wartosci zmiennej scenarioText.
     * Metoda ustawia wartosc zmiennej jako pusty String.
     * Metoda nie przyjmuje argumentow na wejsciu ani nic nie zwraca.
     *
     */

    @Override
    public void resetDisplay() {
        scenarioText = "";
    }

}