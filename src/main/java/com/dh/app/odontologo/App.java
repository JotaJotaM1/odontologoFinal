package com.dh.app.odontologo;

import com.dh.app.odontologo.model.Odontologo;
import com.dh.app.odontologo.service.OdontologoServicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {

   private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        OdontologoServicio odontologoServicio = new OdontologoServicio();

        odontologoServicio.crearTablaBD();

        Odontologo odontologo1 = new Odontologo();
        odontologo1.setId(1L);
        odontologo1.setNombre("James");
        odontologo1.setApellido("Mosquera");
        odontologo1.setMatricula("1143824");

        Odontologo odontologo2= new Odontologo();
        odontologo2.setId(2L);
        odontologo2.setNombre("Maria");
        odontologo2.setApellido("Rozo");
        odontologo2.setMatricula("20611472");

        Odontologo odontologo3 = new Odontologo();
        odontologo3.setId(3L);
        odontologo3.setNombre("Leidy");
        odontologo3.setApellido("Lozano");
        odontologo3.setMatricula("1145672");

        Odontologo o1 = odontologoServicio.crear(odontologo1);
        Odontologo o2 = odontologoServicio.crear(odontologo2);
        Odontologo o3 = odontologoServicio.crear(odontologo3);

        odontologoServicio.listarOdontologos().forEach(odontologo -> logger.info(odontologo.toString()));


    }



}

