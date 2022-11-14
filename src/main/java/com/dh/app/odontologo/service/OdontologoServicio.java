package com.dh.app.odontologo.service;

import com.dh.app.odontologo.model.Odontologo;
import com.dh.app.odontologo.repository.impl.OdontologoRepositorioH2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class OdontologoServicio {
    private static final Logger logger = LogManager.getLogger(OdontologoServicio.class);

    private OdontologoRepositorioH2 odontologoRepositorioH2;

    public OdontologoServicio() {
        this.odontologoRepositorioH2 = new OdontologoRepositorioH2();
    }

    public void crearTablaBD(){
        try{
            odontologoRepositorioH2.crearTabla();
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    public Odontologo agregar(Odontologo odontologo){
        return odontologoRepositorioH2.crear(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoRepositorioH2.listarOdontologos();
    }



}
