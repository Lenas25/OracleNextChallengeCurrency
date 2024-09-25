package com.alura.challenge.dto;

import java.util.Map;

public record Request(String result,
                      String base_code,
                      Map<String, Double> conversion_rates) {
}
