package com.unifaesp.myapp;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.awt.SystemColor.info;

//Esta classe mapeia todas as chamadas http (GET, POST, DELETE, PUT...)
@RestController
public class MainController {
    private Object JSONObject;

    //localhost:8080
    @GetMapping("/")
    public String index(){
        return  "My SpringBoot App";
    }

    //localhost:8080/teste
    @GetMapping("/teste")
    public String teste(){
        return "Voce chamou um teste";
    }

    //localhost: 8080/api/valor
    @PostMapping("/api/valor")
    public String valor(@RequestBody String info){
        return "Informação recebida: " + info;


    }
    @GetMapping("/status")
    public String status(){
        OperatingSystemMXBean op = ManagementFactory.getOperatingSystemMXBean();
        String teste01 = op.getName();
        System.out.println("{'teste01-'}");
        System.out.println("op.getName()" +  op.getName());

        return op.getArch() + " - " +  op.getAvailableProcessors()  + " - " +op.getName();
    }
    @GetMapping("/config")
    public String json(){
        JSONObject myjson = new JSONObject();
        myjson.put("ARQUITETURA DO PROCESSADOR", "amd64");
        myjson.put("QUANTIDADE DE NUCLEOS DO PROCESSADOR", 8);
        myjson.put("SISTEMA OPERACIONAL", "windows 11");
        String configuracao = Base64.getEncoder().encodeToString(myjson.toString().getBytes());

        return  configuracao;
    }

    @PostMapping("/config/validacao")
        public String validacao (@RequestBody String texto) {
        if(texto == JSONObject){
            return  "success : true" + texto;
        } else{
            return  "success: false" + texto;
        }

    }

    @PostMapping("/config/teste12")
        public  String validacao2(@RequestBody JSONObject info){
        //JSONObject myjson2 = new JSONObject();
        //myjson2.put("TESTE", "teste");
        return  "Isto é um teste " + info;
    }







    //@GetMapping("/json")
    //public String json(){
      //  JSONObject myJson = new JSONObject();
      //  myJson.put("nome", "Joao");
     //   myJson.put("sobrenome", "Silva");
     //   myJson.put("idade",23);
     //   return myJson.toString();
   // }
}

