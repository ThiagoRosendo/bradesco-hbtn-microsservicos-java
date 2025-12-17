package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    // Injeção da lógica de negócio
    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem-vindo à API Calculadora! Use os endpoints para realizar cálculos.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.sum(n1, n2);
            return "A soma de " + n1 + " e " + n2 + " é: " + result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.sub(n1, n2);
            return "A subtração de " + n1 + " por " + n2 + " é: " + result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.divide(n1, n2);
            return "A divisão de " + n1 + " por " + n2 + " é: " + result;
        } catch (ArithmeticException | NullPointerException e) {
            return "Erro: " + e.getMessage();
        }
    }
}