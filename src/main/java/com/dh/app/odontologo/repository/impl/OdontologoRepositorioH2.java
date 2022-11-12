package com.dh.app.odontologo.repository.impl;

import com.dh.app.odontologo.model.Odontologo;
import com.dh.app.odontologo.repository.OperacionGenerica;
import com.dh.app.odontologo.util.UtilitarioH2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoRepositorioH2 implements OperacionGenerica<Odontologo> {

    private static final Logger logger = LogManager.getLogger(OdontologoRepositorioH2.class);

    private UtilitarioH2 utilDb;

    public OdontologoRepositorioH2() {
        this.utilDb = new UtilitarioH2();
    }

    @Override
    public Odontologo crear(Odontologo odontologo) {
        logger.info("Creando un nuevo DatosOdontologo: " + odontologo.toString());
        Connection connection;
        PreparedStatement ps;
        try {
            connection = utilDb.getConnection();
            ps = connection.prepareStatement("INSERT INTO ODONTOLOGO(id,matricula,nombre,apellido) VALUES(?,?,?,?)");
            ps.setLong(1, odontologo.getId());
            ps.setString(2, odontologo.getMatricula());
            ps.setString(3, odontologo.getNombre());
            ps.setString(4, odontologo.getApellido());

            utilDb.executeUpdate(ps);
        }catch(SQLException e){
            logger.info(e.getMessage());
        }
        return odontologo;

    }

    @Override
    public List<Odontologo> listarOdontologos() {
        logger.info("Listando odontologos");
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            Connection connection = utilDb.getConnection();
            ResultSet rs = utilDb.executeQuery(connection, "SELECT * FROM ODONTOLOGO");
            while (rs.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getLong("id" ));
                odontologo.setMatricula(rs.getString("matricula" ));
                odontologo.setNombre(rs.getString("nombre" ));
                odontologo.setApellido(rs.getString("apellido" ));
                odontologos.add(odontologo);
            }
        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }
        return odontologos;

    }

    public void crearTabla() throws SQLException {
        String sql_create_table = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO"
                + "("
                + "id INT PRIMARY KEY,"
                + "matricula VARCHAR(100) NOT NULL,"
                + "nombre VARCHAR(100) NOT NULL,"
                + "apellido VARCHAR(100) NOT NULL"
                + ")";

        logger.info("Se crea en este momento la tabla de Odontologos.");
        Connection conn = utilDb.getConnection();
        utilDb.executeSQL(conn,sql_create_table);

    }
}
