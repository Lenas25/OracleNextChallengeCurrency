package com.alura.challenge;

import com.alura.challenge.modelos.Moneda;
import com.alura.challenge.service.Service;
import com.alura.challenge.vista.Menu;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.banner();
        menu.opciones();
        menu.controlarOpciones();
    }
}