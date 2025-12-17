package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    // Injeção da lógica de negócio
    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String welcome() {
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

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        try {
            Integer result = calculator.factorial(factorial);
            return "O fatorial de " + factorial + " é: " + result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        try {
            int days = calculator.calculeDayBetweenDate(localDate1, localDate2);
            return "A diferença entre " + localDate1 + " e " + localDate2 + " é de " + days + " dias.";
        } catch (Exception e) {
            return "Erro ao calcular datas: " + e.getMessage();
        }
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        try {
            Integer binary = calculator.integerToBinary(n1);
            return "O número " + n1 + " em binário é: " + binary;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        try {
            String hex = calculator.integerToHexadecimal(n1);
            return "O número " + n1 + " em hexadecimal é: " + hex;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}