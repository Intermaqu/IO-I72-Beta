package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;

    /**
    *   Klasa sluzaca do zliczania liczby krokow ktore nie zawieraja aktora.
    *   Klasa jest rozszerzeniem klasy CountVisit.
    *   Klasa sklada sie z 4 metod i 1 zmiennej ktora przechowuje liczbe krokow nie zawierajacych aktora.
    * */


public class CountStepsForNoActor extends CountVisit{
    private int stepsNum = 0;

    /**
    *
    * Metoda sluzaca do inkrementowania zmiennej przechowujacych liczbe krokow w przypadku kiedy podany na wejsciu
    * krok nie zawiera aktora. Na wejsciu przyjmuje obiekt Step i nie zwraca nic na wyjsciu.
    *
    * @param step   Obiekt Step ktory jest zliczany za pomoca zmiennej stepsNum w przypadku braku aktora
    *
    */

    @Override
    public void increment(Step step) {
        if(noActor(step))
            stepsNum++;
    }

    /**
     *
     * Metoda ktora nie przyjmuje argumentow na wejsciu.
     * Zwraca zmienna stepsNum typu int zawierajaca liczbe krokow bez aktora.
     *
     * @return stepsNum  Zmienna typu int przechowujaca liczbe krokow bez aktora
     *
     */
public int getNumberOfSteps(){
    return stepsNum;

}

    /**
    *
    * Metoda sluzaca do sprawdzenia czy podany na wejsciu krok posiada aktora.
    * Metoda zwraca zmienna typu Boolean.
    *
    * @param step   Obiekt Step dla ktorego sprawdzana jest obecnosc aktora
    * @return Boolean W przypadku braku aktora zwracana wartosc true, w przypadku obecnosci aktora false
    *
    */

    private boolean noActor(Step step) {
        if(step.getActor().equals(""))
            return true;
        return false;
    }

    /**
    *
    * Metoda sluzaca do resetowania wartosci zmiennej stepsNum ustalajac jej wartosc na 0.
    * Metoda nie przyjmuje argumentow wejsciowych ani nie zwraca nic na wyjsciu
    *
    */

    @Override
    public void resetCount() {
        stepsNum = 0;
    }
}