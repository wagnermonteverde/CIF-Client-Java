package br.com.rnp.ocs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Wagner Ap. Monteverde
 * @author Rafael Silvério 
 * Interface de consultas ao banco de dados do OCS
 * 
 */
public class OcsClientmanager {
	
	public OcsClientmanager(){
		
	}
	
    /**
     * 
     * @return String com lista de sistemas
     * operarionais e versões dos mesmos
     * obs: temos que verificar como 
     * vamos retornar acredito que pode ser no formato
     * JSON :  [{"os":Ubuntu,"versao":14.05},{"os":Ubuntu,"versao":14.05}],
     * temos que definir o que o luiz e o rodrigo querem antes de
     * implentar  o formato de saida por enquanto retorna uma String com quebras de linha
     * 
     * 
     * */
	
	public String getOperatingSystemsVersions() {
		
		StringBuilder retorno = new StringBuilder();
		
		try {
			
			/**
			 * Única instanciação da conexão com o banco de dados.
			 */
			ConnectionFactory connection = new ConnectionFactory("localhost",3306,"root","");
			connection.openConnection();
			
			Statement stmt = connection.conn.createStatement();

			/**
			 * @param ResultSet executa a query 'select' no banco de dados
			 */
			ResultSet rs = stmt.executeQuery("SELECT OSNAME,OSVERSION FROM hardware");

			
			
			/**
			 * @param while para imprimir o resultado na tela
			 */
			while (rs.next()) {
				
				String nome = rs.getString(1);
				String versao = rs.getString(2);
				
				
				/**  Concatena no tipo Stringbuilder um tipo de String bem legal :)*/
				
				retorno.append("Sistema Operacional: [" + nome
						+ "] - Versão: [" + versao + "] \n");
				
				
				/**  imprime no console*/
				
				
			}
			
			/**
			 * fecha a conexão com o banco de dados
			 */
			connection.closeConnection();
			
			System.out.println(retorno);
			return retorno.toString();
			
		} catch (SQLException e) {
            System.out.println("Problemas na colsulta: "+ e.getMessage());
			return null;
		}
	}
}
