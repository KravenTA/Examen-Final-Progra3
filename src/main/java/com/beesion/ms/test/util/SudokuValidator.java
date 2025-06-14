package com.beesion.ms.test.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que valida un tablero de Sudoku según las reglas especificadas.
 * Principios SOLID aplicados:
 * - Single Responsibility: La clase tiene una única responsabilidad, validar el tablero de Sudoku.
 * - Open-Closed: Es extensible para agregar nuevas validaciones sin modificar el código existente.
 */
public class SudokuValidator {

    /**
     * Valida si un tablero de Sudoku es válido.
     * @param board Tablero de Sudoku representado como una matriz 9x9.
     * @return true si el tablero es válido, false en caso contrario.
     */
    public boolean isValidSudoku(char[][] board) {
        return areRowsValid(board) && areColumnsValid(board) && areSubgridsValid(board);
    }

    private boolean areRowsValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isUnitValid(board[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] column = new char[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            if (!isUnitValid(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean areSubgridsValid(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                char[] subgrid = new char[9];
                int index = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        subgrid[index++] = board[i][j];
                    }
                }
                if (!isUnitValid(subgrid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUnitValid(char[] unit) {
        Set<Character> seen = new HashSet<>();
        for (char c : unit) {
            if (c != '.' && !seen.add(c)) {
                return false;
            }
        }
        return true;
    }
}