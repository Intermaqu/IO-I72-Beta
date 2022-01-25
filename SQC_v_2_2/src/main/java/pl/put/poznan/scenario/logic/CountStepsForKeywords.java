package pl.put.poznan.scenario.logic;

import pl.put.poznan.scenario.objects.Step;
import java.util.List;

        /**
        *   Klasa sluzaca do zliczania liczby krokow ktore nie zawieraja slow kluczowych.
        *   Klasa jest rozszerzeniem klasy CountVisit.
        *   Klasa sklada sie z 4 metod i 1 zmiennej ktora przechowuje liczbe krokow nie zawierajacych slow kluczowych.
        * */

public class CountStepsForKeywords extends CountVisit {
    private int stepNum = 0;

    /**
    *
    * Metoda ktora nie przyjmuje argumentow na wejsciu.
    * Zwraca zmienna stepNum typu int zawierajaca liczbe krokow bez slow kluczowych.
    *
    * @return stepNum  Zmienna typu int przechowujaca liczbe krokow bez slow kluczowych
    *
    */

    public int getNumberOfSteps(){
        return stepNum;
    }

    /**
     *
     * Metoda sluzaca do sprawdzenia czy podany na wejsciu krok zawiera slowa kluczowe.
     * W tym celu metoda pobiera tresc danego kroku i sprawdza czy zawiera on jedno ze slow kluczowych.
     * Zwraca zmienna typu Boolean w zaleznosci od wyniku poszukiwan slow kluczowych.
     *
     * @param step   Obiekt Step dla ktorego sprawdzana jest obecnosc slow kluczowych
     * @return Boolean W przypadku obecnosci slow kluczowych zwracana wartosc true, w przypadku ich braku false
     *
     */
private static boolean isKeyword(Step step){
    List<String> content = step.getContents();
    if(content.get(0).equals("IF")){
        return true;
    }
    if(content.get(0).equals("ELSE")){
        return true;
    }
    if(content.get(0).equals("FOR EACH")){
        return true;
    }
    return false;
}

    /**
    *
    * Metoda sluzaca do inkrementowania zmiennej przechowujacych liczbe krokow ktore nie zawieraja slow kluczowych.
    * Na wejsciu przyjmuje obiekt Step i nie zwraca nic na wyjsciu.
    *
    * @param step   Obiekt Step ktory jest zliczany za pomoca zmiennej stepNum w przypadku braku slow kluczowych
    *
    */

    public void increment(Step step){
        if(isKeyword(step)){
            stepNum++;
        }
    }

    /**
    *
    * Metoda sluzaca do resetowania wartosci zmiennej stepNum ustalajac jej wartosc na 0.
    * Metoda nie przyjmuje argumentow wejsciowych ani nie zwraca nic na wyjsciu
    *
    */

    public void resetCount(){
        stepNum = 0;
    }
}