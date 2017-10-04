package com.example.david.teamaura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	 	public Connection conexion=null;
	    public Statement sentencia=null;   		//Se usa para enviar sentencias SQL a la BD
	    public ResultSet resultado=null;   		//Contendr� los datos devueltos de una sentencia SQL
	    
	    public Conexion(){

	    }
	    public void conectarBD() {
			// Conectar con MySql
			String url = "jdbc:mysql://imperialskelly.sytes.net/app_teamaura";

			// Cargar el driver y se genera una nueva instancia y crear conexi�n
			try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conexion = DriverManager.getConnection(url, "root", "God@Is@Mysql97");
				// Crear sentencia
				sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	    public void cerrarConexionBD(){
	        try {
	            resultado.close();
	            sentencia.close();
	            conexion.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	               
	    }
}
