package com.alura.challenge.vista;

import com.alura.challenge.dto.Request;
import com.alura.challenge.modelos.Moneda;
import com.alura.challenge.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    List<Moneda> monedasConvertidas = new ArrayList<>();
    Service service = new Service();
    Request request;
    Double cantidad;
    public void banner() {
        System.out.println("----------------------------------------");
        System.out.println("Bienvenid@ al Conversor de Monedas");
        System.out.println("----------------------------------------");
    }

    public void opciones(){
        System.out.println("""
                Seleccione una opción:
                1. Dolar -> Peso Argentino
                2. Dolar -> Sol Peruano
                3. Dolar -> Real Brasileño
                4. Dolar -> Euro
                5. Peso Argentino -> Dolar
                6. Sol Peruano -> Dolar
                7. Real Brasileño -> Dolar
                8. Euro -> Dolar
                9. Ver historial de conversiones
                10. Salir
                """);
        System.out.println("----------------------------------------");
    }

    public int controlarEntrada(){
        System.out.print("Ingrese una opción: ");
        int opcion = scan.nextInt();
        return opcion;
    }

    public String verificarMoneda(String moneda, Double cantidad, Request request){
        Double cambio = request.conversion_rates().get(moneda);
        Moneda monedaOriginal = new Moneda("USD", cantidad);
        monedaOriginal.calcularConvertido(cambio, moneda);
        monedasConvertidas.add(monedaOriginal);
        return monedaOriginal.toString();
    }

    public void verificarConversion(String origen, String codigo_conversion){
        request = service.consult(origen);
        System.out.print("Ingrese la cantidad de dolares a convertir: ");
        cantidad = scan.nextDouble();
        if (cantidad>0){
            System.out.println(verificarMoneda(codigo_conversion, cantidad, request));
        }else{
            System.out.println("Cantidad no válida");
        }
    }

    public void controlarOpciones(){
        int opcion = controlarEntrada();
        while(opcion != 10){
            switch (opcion){
                case 1:
                    // Dolar -> Peso Argentino
                    verificarConversion("USD", "ARS");
                    break;
                case 2:
                    // Dolar -> Sol Peruano
                    verificarConversion("USD", "PEN");
                    break;
                case 3:
                    // Dolar -> Real Brasileño
                    verificarConversion("USD", "BRL");
                    break;
                case 4:
                    // Dolar -> Euro
                    verificarConversion("USD", "EUR");
                    break;
                case 5:
                    // Peso Argentino -> Dolar
                    verificarConversion("ARS", "USD");
                    break;
                case 6:
                    // Sol Peruano -> Dolar
                    verificarConversion("PEN", "USD");
                    break;
                case 7:
                    // Real Brasileño -> Dolar
                    verificarConversion("BRL", "USD");
                    break;
                case 8:
                    // Euro -> Dolar
                    verificarConversion("EUR", "USD");
                    break;
                case 9:
                    mostrarHistorial();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            opciones();
            opcion = controlarEntrada();
        }
        System.out.println("Gracias por usar el conversor de monedas!");
    }

    public void mostrarHistorial(){
        System.out.println("Historial de conversiones: ");
        for (Moneda moneda : monedasConvertidas) {
            System.out.println(moneda.toString());
        }
    }

}
