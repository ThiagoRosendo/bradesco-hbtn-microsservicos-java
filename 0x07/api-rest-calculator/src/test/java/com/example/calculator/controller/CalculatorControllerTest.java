package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        mvc.perform(get("/calculator/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bem-vindo à API Calculadora! Use os endpoints para realizar cálculos."));
    }

    @Test
    void addNumbers() throws Exception {
        mvc.perform(get("/calculator/addNumbers")
                        .param("number1", "10.0")
                        .param("number2", "5.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("A soma de 10.0 e 5.0 é: 15.0"));
    }

    @Test
    void subNumbers() throws Exception {
        mvc.perform(get("/calculator/subNumbers")
                        .param("number1", "10.0")
                        .param("number2", "4.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("A subtração de 10.0 por 4.0 é: 6.0"));
    }

    @Test
    void divideNumbers() throws Exception {
        mvc.perform(get("/calculator/divideNumbers")
                        .param("number1", "10.0")
                        .param("number2", "2.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("A divisão de 10.0 por 2.0 é: 5.0"));
    }

    @Test
    void factorial() throws Exception {
        mvc.perform(get("/calculator/factorial")
                        .param("factorial", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("O fatorial de 5 é: 120"));
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        mvc.perform(get("/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15")
                        .param("localDate2", "2020-03-29"))
                .andExpect(status().isOk())
                .andExpect(content().string("A diferença entre 2020-03-15 e 2020-03-29 é de 14 dias."));
    }

    @Test
    void integerToBinary() throws Exception {
        mvc.perform(get("/calculator/integerToBinary")
                        .param("number1", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("O número 20 em binário é: 10100"));
    }

    @Test
    void integerToHexadecimal() throws Exception {
        mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "170"))
                .andExpect(status().isOk())
                .andExpect(content().string("O número 170 em hexadecimal é: AA"));
    }
}