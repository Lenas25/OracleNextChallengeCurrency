package com.alura.challenge;

import com.alura.challenge.vista.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.banner();
        menu.opciones();
        menu.controlarOpciones();
    }
}