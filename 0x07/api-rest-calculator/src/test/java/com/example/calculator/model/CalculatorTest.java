package com.example.calculator.model;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void sumTest() {
        assertEquals(15.0, calc.sum(10.0, 5.0), "A soma de 10 + 5 deve ser 15");
        assertEquals(-2.0, calc.sum(-5.0, 3.0), "A soma de -5 + 3 deve ser -2");
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calc.sum(null, 5.0),
                "Deve lançar NullPointerException se o primeiro número for nulo");
    }

    @Test
    void subTest() {
        assertEquals(5.0, calc.sub(10.0, 5.0), "A subtração de 10 - 5 deve ser 5");
    }

    @Test
    void divideTest() {
        assertEquals(2.0, calc.divide(10.0, 5.0), "A divisão de 10 por 5 deve ser 2");
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10.0, 0.0),
                "Deve lançar ArithmeticException ao dividir por zero");
    }

    @Test
    void factorialTest() {
        assertEquals(120, calc.factorial(5), "O fatorial de 5 deve ser 120");
        assertEquals(1, calc.factorial(0), "O fatorial de 0 deve ser 1");
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(101, calc.integerToBinary(5), "O binário de 5 deve ser 101");
        assertEquals(10100, calc.integerToBinary(20), "O binário de 20 deve ser 10100");
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calc.integerToHexadecimal(1));
        assertEquals("AA", calc.integerToHexadecimal(170), "170 em Hexa deve ser AA");
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);

        assertEquals(14, calc.calculeDayBetweenDate(date1, date2),
                "A diferença entre as datas deve ser de 14 dias");
    }
}
