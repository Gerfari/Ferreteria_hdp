
package com.ues.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    private static Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static final PreparedStatement ps = null;
    private static final String url = "jdbc:postgresql://localhost:5432/Ferreteria_HDP";//cambiar name
    private static final String usuario = "postgres";
    private static final String password = "root";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            // Obtener la conexion
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectando a la DB");
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
        return con;
    }
    public static void cerrarConexiones() {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el statement" + e);
            }
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la base" + e);
            }
        }
    }
}
