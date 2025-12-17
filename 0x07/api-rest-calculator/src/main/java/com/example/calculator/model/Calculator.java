package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        validateNotNull(number1, number2);
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        validateNotNull(number1, number2);
        return number1 - number2;
    }

    public Double divide(Double number1, Double number2) {
        validateNotNull(number1, number2);
        if (number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer n) {
        if (n == null) throw new NullPointerException("Número é obrigatório.");
        if (n < 0) throw new IllegalArgumentException("Número deve ser positivo.");

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public Integer integerToBinary(Integer integer) {
        if (integer == null) return null;
        return Integer.valueOf(Integer.toBinaryString(integer));
    }

    public String integerToHexadecimal(Integer integer) {
        if (integer == null) return null;
        return Integer.toHexString(integer).toUpperCase();
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new NullPointerException("As datas são obrigatórias.");
        }
        return (int) Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }

    // Método auxiliar para evitar repetição de código
    private void validateNotNull(Double n1, Double n2) {
        if (n1 == null || n2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }
}