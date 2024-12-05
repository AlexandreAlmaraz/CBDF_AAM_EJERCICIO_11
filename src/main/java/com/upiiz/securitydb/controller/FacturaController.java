package com.upiiz.securitydb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/facturas")

public class FacturaController {
    @GetMapping("/listar")
    public String listarFacturas(){ return "listado de facturas";}

    @GetMapping("/listar/{id}")
    public String listarFacturas(@PathVariable int id){
        return "Listado de facturas"+id;
    }

    @PostMapping("/crear")
    public String createFacturas(){
        return "Creación de facturas";
    }

    @PutMapping("/actualizar/{id}")
    public String updateFacturas(@PathVariable int id){
        return "Actualización de facturas"+id;
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteFacturas(@PathVariable int id){
        return "Eliminar de facturas"+id;
    }
}
