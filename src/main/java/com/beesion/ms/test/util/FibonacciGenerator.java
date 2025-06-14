package com.beesion.ms.test.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la generación de la secuencia de Fibonacci.
 * Principios SOLID aplicados:
 * - Single Responsibility: La clase tiene una única responsabilidad, generar la secuencia de Fibonacci.
 * - Open-Closed: Es extensible para agregar nuevas funcionalidades sin modificar el código existente.
 */
public class FibonacciGenerator {

    /**
     * Genera la secuencia de Fibonacci.
     * @param signature Arreglo de firma inicial con dos elementos.
     * @param n Número de elementos de la secuencia a generar.
     * @return Lista con la secuencia de Fibonacci generada.
     */
    public List<Integer> generateFibonacci(int[] signature, int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<Integer> sequence = new ArrayList<>();
        for (int num : signature) {
            sequence.add(num);
        }

        while (sequence.size() < n) {
            int nextValue = sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2);
            sequence.add(nextValue);
        }

        return sequence.subList(0, n);
    }
}