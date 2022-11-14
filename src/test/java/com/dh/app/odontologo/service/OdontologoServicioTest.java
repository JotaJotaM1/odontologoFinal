package com.dh.app.odontologo.service;

import com.dh.app.odontologo.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class OdontologoServicioTest {

    @Test
    void CrearOdontologoConParametros() {
        Odontologo odontologo1 = new Odontologo(1L, "Mosquera", "James", "James");
        Odontologo odontologo2 = new Odontologo(2L, "Rozo", "Maria", "20611472");


        Assertions.assertEquals("James", odontologo1.getNombre());
        Assertions.assertEquals("Maria", odontologo2.getNombre());

    }

    @Test
    void ProbarListadoOdontologos(){

        List<Odontologo>
        Odontologo odontologo1 = new Odontologo(1L, "Mosquera", "James", "James");
        Odontologo odontologo2 = new Odontologo(2L, "Rozo", "Maria", "20611472");



    }
}