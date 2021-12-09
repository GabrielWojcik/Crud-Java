package com.unifaesp.myapp;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

public class base64Teste {
    public static void main(String[] args){
        String nome = "Unifaesp centro universitario";
        String enconded = Base64.encodeBase64String(nome.getBytes());
        System.out.println(enconded);
    }
}
