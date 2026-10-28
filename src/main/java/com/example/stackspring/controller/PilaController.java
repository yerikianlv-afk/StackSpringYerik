
package com.example.stackspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/pila")
public class PilaController {

    private final Stack<String> pila = new Stack<>();

    // Agregar un elemento (PUSH)
    @PostMapping
    public String agregar(@RequestParam String valor) {
        pila.push(valor);
        return "Se agrego: " + valor;
    }

    // Sacar el elemento de la cima (POP)
    @GetMapping("/pop")
    public String sacar() {
        if (pila.isEmpty()) {
            return "La pila esta vacia";
        }

        return "Se saco: " + pila.pop();
    }

    // Consultar la cima sin eliminarla (PEEK)
    @GetMapping("/peek")
    public String verCima() {
        if (pila.isEmpty()) {
            return "La pila esta vacia";
        }

        return "Elemento en la cima: " + pila.peek();
    }

    // Mostrar todos los elementos
    @GetMapping
    public List<String> verPila() {
        return new ArrayList<>(pila);
    }
}
