package com.manipulasiString.controller;

import com.manipulasiString.DTO.ManipulasiDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class ManipulasiString {

    @GetMapping("/manipulasi")
    public String manipulasi() {
        String text = "bastian.setyo1234";

        StringBuilder sb = new StringBuilder(); // penampung
        for (int i = 0; i < text.length(); i++) { // menghitung dan mencek satu persatu
            char ch = text.charAt(i); // dari length diubah ke karakter lagi sesuai urutan
            if (Character.isLetter(ch) || Character.isWhitespace(ch)) // pengkondisian jika ch karakter atau spasi
                sb.append(ch); //tambahkan karakter dalam urutan
        }
        return sb.toString();
    }

    @PostMapping("/manipulasi2")
    public String manipulasi2(@RequestBody ManipulasiDto input) {
        String text;
        text = input.getInput();
        StringBuilder sb = new StringBuilder(); // penampung
        for (int i = 0; i < text.length(); i++) { // menghitung dan mencek satu persatu
            char ch = text.charAt(i); // dari length diubah ke karakter lagi sesuai urutan
            if (Character.isLetter(ch)) // pengkondisian jika ch karakter atau spasi
                sb.append(ch); //tambahkan karakter dalam urutan
            else if (Character.isDigit(ch) && Boolean.TRUE.equals(input.getIsBilangan())) {
                sb.append(ch);
            } else if (Boolean.TRUE.equals(input.getIsLain())) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
