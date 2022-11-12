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
        odontologo1.setNombre("Daniel");
        odontologo1.setApellido("Jimenez");
        odontologo1.setMatricula("1036640");

        Odontologo odontologo2= new Odontologo();
        odontologo2.setId(2L);
        odontologo2.setNombre("Astrid");
        odontologo2.setApellido("Morales");
        odontologo2.setMatricula("42792792");

        Odontologo odontologo3 = new Odontologo();
        odontologo3.setId(3L);
        odontologo3.setNombre("Elkin");
        odontologo3.setApellido("Jimenez");
        odontologo3.setMatricula("985212");

        Odontologo o1 = odontologoServicio.crear(odontologo1);
        Odontologo o2 = odontologoServicio.crear(odontologo2);
        Odontologo o3 = odontologoServicio.crear(odontologo3);

        odontologoServicio.listarOdontologos().forEach(odontologo -> logger.info(odontologo.toString()));


    }



}

