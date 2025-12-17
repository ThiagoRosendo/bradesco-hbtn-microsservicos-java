package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.ExceptionService;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

   ExceptionService exceptionService;

   @GetMapping("/user-id/{id}")
   public String findUserById(@PathVariable int id) {

      String msg = "";
      if (id > 0 && id < 100){
         msg = "You have entered valid ID";
      } else {
         throw new UserIdException("You have entered valid ID");
      }

      return msg;
   }

   @GetMapping("/user-name/{userName}")
   public String findUserByName(@PathVariable String userName) {

      String msg = "";
      if (userName.length() > 3 && userName.length() < 15){
         msg = "You have entered valid USERNAME";
      } else {
         throw new UserNameException("You have entered invalid USERNAME");
      }
      return msg;
   }

   @GetMapping("/user-cpf/{cpf}")
   public String findUserByCPF(@PathVariable String cpf) {

      String msg = "";
      boolean isCPFValid = isCPF(cpf);

      if (isCPFValid){
         msg = "You have entered valid CPF";
      } else {
         throw new CPFException("You have entered invalid CPF");
      }

      return msg;
   }

   public boolean isCPF(String CPF) {
       return CPF.length() > 3 && CPF.length() < 15;
   }

}
