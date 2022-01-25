package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

       /**
        *   Klasa sluzaca do zliczania lacznej liczby krokow w scenariuszu lacznie z podscenariuszami.
        *   Klasa jest rozszerzeniem klasy CountVisit.
        *   Klasa sklada sie z 3 metod i 1 zmiennej ktora przechowuje liczbe krokow.
        *
        *
        */

public class CountAllSteps extends CountVisit {
    private int stepNum = 0;

    /**
     * Metoda ktora nie przyjmuje argumentow na wejsciu.
     * Zwraca zmienna stepNum typu int zawierajaca liczbe krokow.
     *
     * @return stepNum  Zmienna zawierajaca laczna liczbe krokow
     *
     */

    public int getNumberOfSteps(){
        return stepNum;
    }

    /**
     * Metoda przyjmujaca na wejsciu obiekt Step. Sluzy do inkrementowania wartosci zmiennej step.
     * Metoda ze wzgledu na swoja funkcjonalnosc nie zwraca nic na wyjsciu.
     *
     * @param step   Obiekt Step ktory jest zliczany za pomoca zmiennej stepNum
     *
     */

    public void increment(Step step){
        stepNum++;
    }

    /*
     * Metoda sluzaca do resetowania wartosci zmiennej stepNum ustalajac jej wartosc na 0.
     * Metoda nie przyjmuje argumentow wejsciowych ani nie zwraca nic na wyjsciu
     */

    public void resetCount(){
        stepNum = 0;
    }
}