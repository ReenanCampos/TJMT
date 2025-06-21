package com.projeto.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:postgresql://localhost:5432/solucao4";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "postgres";

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, SENHA);
	}
}
