import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testExecutarOperacioSuma() {

        Calculadora calculadora;
        calculadora = new Calculadora(false);

        int resultat_actual, resultat_esperat;

        calculadora.operacio = "+";
        calculadora.valor1 = 5;
        calculadora.valor2 = 10;

        resultat_actual = calculadora.executarOperacio();
        resultat_esperat = 5 + 10;

        assertEquals("Error en la suma!", resultat_esperat, resultat_actual, 0);
    }

    @Test
    public void testExecutarOperacioResta() {

        Calculadora calculadora;
        calculadora = new Calculadora(false);

        int resultat_actual, resultat_esperat;

        calculadora.operacio = "-";
        calculadora.valor1 = 5;
        calculadora.valor2 = 10;

        resultat_actual = calculadora.executarOperacio();
        resultat_esperat = 5 - 10;

        assertEquals("Error en la resta!", resultat_esperat, resultat_actual, 0);
    }

    @Test
    public void testExecutarOperacioMultiplicacio() {

        Calculadora calculadora;
        calculadora = new Calculadora(false);

        int resultat_actual, resultat_esperat;

        calculadora.operacio = "*";
        calculadora.valor1 = 5;
        calculadora.valor2 = 10;

        resultat_actual = calculadora.executarOperacio();
        resultat_esperat = 5 * 10;

        assertEquals("Error en la multiplicació!", resultat_esperat, resultat_actual, 0);
    }

    @Test
    public void testExecutarOperacioDivisio() {

        Calculadora calculadora;
        calculadora = new Calculadora(false);

        int resultat_actual, resultat_esperat;

        calculadora.operacio = "/";
        calculadora.valor1 = 5;
        calculadora.valor2 = 10;

        resultat_actual = calculadora.executarOperacio();
        resultat_esperat = 5 / 10;

        assertEquals("Error en la divisió!", resultat_esperat, resultat_actual, 0);
    }

    @Test(expected=ArithmeticException.class)
    public void testExecutarOperacioDivisioZero() {

        Calculadora calculadora;
        calculadora = new Calculadora(false);

        int resultat_actual, resultat_esperat;

        calculadora.operacio = "/";
        calculadora.valor1 = 5;
        calculadora.valor2 = 0;

        resultat_actual = calculadora.executarOperacio();
        resultat_esperat = 5 / 0;

        assertEquals("Error en la divisió!", resultat_esperat, resultat_actual, 0);
    }

}
