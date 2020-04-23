/*finalizado*/
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //cria conexao com banco de dados
    String serverName = "remotemysql.com"; //caminho do servidor BD
    String mydatabase = "wqlc7LHLWH"; //nome do banco de dados
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "wqlc7LHLWH"; //nome do usuario do bd
    String password = "r3SIPULcYY"; //senha do banco
    
    public Connection conexao;
  
    public Conexao() throws SQLException {
        conexao = DriverManager.getConnection(url, username, password);
    }
}