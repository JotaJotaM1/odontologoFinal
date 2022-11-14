package com.dh.app.odontologo.service;

import com.dh.app.odontologo.model.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OdontologoServicioTest {

    OdontologoServicio odontologoServicio = new OdontologoServicio();
    @BeforeEach
    void prepararDatos(){

        Odontologo odontologo1 = new Odontologo(1L, "Mosquera", "James", "James");
        Odontologo odontologo2 = new Odontologo(2L, "Rozo", "Maria", "20611472");

        odontologoServicio.crearTablaBD();
        odontologoServicio.agregar(odontologo1);
        odontologoServicio.agregar(odontologo2);

    }

    @Test
    void ProbarListadoOdontologos(){

        prepararDatos();
        assertEquals(2, odontologoServicio.listarOdontologos().size());

    }

}