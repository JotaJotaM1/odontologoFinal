package com.dh.app.odontologo.util;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UtilitarioH2 {
    // Ruta de la db
    public static final String H2_URL = "jdbc:h2:~/clinica";


    final static Logger logger = LogManager.getLogger(UtilitarioH2.class);

    // Definir Conexion
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(H2_URL);
    }

    // Ejecutar consulta SQL sin paràmetros
    public void executeSQL(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    // Ejecutar consulta SQL sin paràmetros
    public ResultSet executeQuery(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void executeUpdate(PreparedStatement ps) {
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

}
