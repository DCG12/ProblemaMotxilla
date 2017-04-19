import java.awt.*;
import java.lang.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



public class Calculadora {

    // Constants
    final int MAX_DIGITS = 5;
    final int MODE_ENTRADA = 0;
    final int MODE_RESULTAT = 1;

    //Variables
    int mode;
    int valor1;
    int valor2;
    String operacio;
    boolean inicialitza_resultat;

    private static String text_resultat;

    public Calculadora(boolean gui) {

//Inicialització de les variables.
        inicialitza();
    }

    public void inicialitza() {
        operacio = "null";
        valor1 = 0;
        valor2 = 0;
        mode = MODE_ENTRADA;
        inicialitza_resultat = true;
    }

    public String getResultatString (){
        return text_resultat;
    }

    public void setResultatString(String s){
        text_resultat = s;
    }

    public int getResultatInt() {
        String resultat = text_resultat;
        return Integer.parseInt(resultat);
    }

    public void afageixNouDigit(int digit){
        if (inicialitza_resultat)
            setResultatString("");

        String inputString = getResultatString();

        if (inputString.indexOf("0") == 0){
            inputString = inputString.substring(1);
        }

        if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_DIGITS){
            setResultatString(inputString + digit);
        }

        mode = MODE_ENTRADA;
        inicialitza_resultat = false;
    }

    public void executarOperador(String new_operacio) {

        int resultat;

        if (operacio.equals("null"))
        {
            resultat = getResultatInt();
            valor1 = resultat;
        }

        else
        {
            valor2 = getResultatInt();
            resultat = executarOperacio();
            mostraResultat(resultat);
            valor1 = resultat;
        }

        inicialitza_resultat = true;
        operacio = new_operacio;
    }

    public void executarIgual(){
        int resultat = 0;

        valor2 = getResultatInt();
        resultat = executarOperacio();
        mostraResultat(resultat);

        operacio = "null";
    }

    public int executarOperacio() {
        int resultat = 0;

        if (operacio.equals("/"))
        {

            if (valor2 == 0)
            {
                System.out.println( "No es pot dividir per cero");
                operacio = "null";
                valor1 = 0;
                mode = MODE_ENTRADA;
                inicialitza_resultat = true;
            }
            else
                resultat = valor1 / valor2;
        }

        if (operacio.equals("*"))
            resultat = valor1 * valor2;

        if (operacio.equals("-"))
            resultat = valor1 - valor2;

        if (operacio.equals("+"))
            resultat = valor1 + valor2;

        return resultat;
    }

    public void mostraResultat(int resultat){
        setResultatString(Integer.toString(resultat));
        valor1 = resultat;
        mode = MODE_RESULTAT;
        inicialitza_resultat = true;
    }

    public static void main(String args[]) {
        Calculadora calculadora = new Calculadora(true);
    }

}