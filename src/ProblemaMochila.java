import java.util.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProblemaMochila {

    class Elemento {
        String nombre;
        double valor;
        double peso;
        Elemento(String n, double v, double p) {
            nombre=n;
            valor =v;
            peso  =p;
        }
        public String toString() {
            return String.format("%-15s %,12.2f %,12.2f", nombre, valor, peso);
        }
    }


    Vector<Elemento> almacen = new Vector<Elemento>();
    Vector<Elemento> mochila = new Vector<Elemento>();
    final double  pesoMaximo;

    public ProblemaMochila(int pm) {
        pesoMaximo = pm;
        cargarDatos();
    }

    @Test
    public void cargarDatos() {

        almacen.add(new Elemento("TV",        300, 15));
        almacen.add(new Elemento("PS3",       100,  3));
        almacen.add(new Elemento("Libro Java", 10,  1));
        almacen.add(new Elemento("DVD Player",  5,  0.5));
        almacen.add(new Elemento("Blu-Ray",    50,  0.5));
        almacen.add(new Elemento("Balon",      30,  0.5));
        almacen.add(new Elemento("iPod",      150,  1));
        almacen.add(new Elemento("Printer",    20,  4));
        almacen.add(new Elemento("VideoBeam", 200,  4));
        almacen.add(new Elemento("LapTop",     20,  3));
        almacen.add(new Elemento("iPad",      150,  2));
        almacen.add(new Elemento("PC",        100,  5));
        almacen.add(new Elemento("BlackBerry",150,  0.5));

        assertNotNull("Error almacen vacio", almacen);
    }

    @Test
    public void mostrarMochila() {
        double pesoMochila=0;
        double valorMochila=0;
        System.out.println();
        for(Elemento e: mochila) {
            System.out.println(e);
            pesoMochila+=e.peso;
            valorMochila+=e.valor;
        }
        System.out.println("------");
        System.out.printf("Peso  = %,12.2f %n", pesoMochila);
        System.out.printf("Valor = %,12.2f %n", valorMochila);
    }

    @Test
    public void resolverProblema() {
        // Comparador para ordenar los elementos del almacen por valor
        Comparator cmp = new Comparator<Elemento>() {
            public int compare(Elemento x, Elemento y) {
                return (int) (x.valor - y.valor);
            }
        };
        Collections.sort(almacen,cmp);  // ordena usando el comparador anterior
        Collections.reverse(almacen);   // reversa el orden de los elementos

        double pesoMochila=0;
        int    posicion=0;
        while(pesoMochila<pesoMaximo && posicion < almacen.size()) {
            Elemento tmp = almacen.get(posicion);
            if(pesoMochila + tmp.peso <= pesoMaximo) {
                mochila.add(tmp);
                pesoMochila+=tmp.peso;
            }
            posicion++;
        }

    }
    public static void main(String[] args) {
        // Crear una mochila que soporta hasta 20 Kg. de peso
        ProblemaMochila pm = new ProblemaMochila(20);
        pm.resolverProblema();
        pm.mostrarMochila();
    }
}
