package com.alura.challenge.modelos;

import java.time.LocalDate;

public class Moneda {
    String code;
    Double amount;
    Moneda monedaConvertida;
    LocalDate horaRegistro;

    public Moneda(String code, Double amount) {
        this.code = code;
        this.amount = amount;
        this.horaRegistro = LocalDate.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Moneda getMonedaConvertida() {
        return monedaConvertida;
    }

    public void setMonedaConvertida(Moneda monedaConvertida) {
        this.monedaConvertida = monedaConvertida;
    }

    public void calcularConvertido(Double cambio, String codigo){
        Double resultado = cambio * this.amount;
        this.setMonedaConvertida(new Moneda(codigo, resultado));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("--------------")
                .append("\nMoneda Ingresada: ").append("\nCodigo - ").append(code).append(
                        "\nMonto a convertir - ").append(amount)
                .append("\nMoneda Convertida:").append("\nCodigo - ").append(monedaConvertida.getCode()).append("\nMonto " +
                        "a convertir - ").append(String.format("%2f",monedaConvertida.getAmount()))
                .append("\nFecha de Conversion: ").append(horaRegistro).append("\n--------------");
        return str.toString();

    }
}
