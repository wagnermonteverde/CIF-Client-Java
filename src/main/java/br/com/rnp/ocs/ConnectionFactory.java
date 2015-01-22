package br.com.rnp.ocs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.*;

/**
 * @author Wagner Ap. Monteverde
 * @author Rafael Silvério
 * Classe para conexão ao banco de dados do OCS
 */
public class ConnectionFactory {
	/**
	 * variavel global do tipo Connection, usada para abrir e fechar a conexão
	 */
	Connection conn;

	private String addressDB;
	private Integer port;
	private String user;
	private String pass;
	
	public ConnectionFactory(String addressDB, Integer port, String user, String pass){
		this.addressDB = addressDB;
		this.port = port;
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * 
	 * @param addressDB
	 * @param port
	 * @param user
	 * @param pass
	 * 
	 * Construtor da classe tem como parâmetros dados da conexão com o
	 * banco
	 * 
	 */
	public Connection openConnection(){
		try {
	        conn = DriverManager.getConnection(
	        		"jdbc:mysql://"+addressDB+":"+port+"/ocsweb?user="+user+"&password="+pass+"");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	/**
	 * 
	 * Metodo para fechar conexão com banco de dados
	 */
	public Connection closeConnection(){
		try{
		conn.close();
		}
		catch(SQLException e){
			System.out.println("Erro: " + e);
		}
		return conn;
	}
}