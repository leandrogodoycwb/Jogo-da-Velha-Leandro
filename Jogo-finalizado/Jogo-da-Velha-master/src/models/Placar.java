/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*finalizado*/
package models;

import controllers.Jogador;
import controllers.Jogar;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Placar extends Jogador{
    
    public void mostrarPlacar(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        Conexao con = new Conexao();
        Statement st = con.conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
            String vitoria = rs.getString("vitorias");
            String derrota = rs.getString("derrotas");   
            System.out.println("Vitórias: " + vitoria + "\nDerrotas: " + derrota);//mostra os dados da tabela jogador no console
            Jogar jogo = new Jogar();
            jogo.entrarJogo(jogador);
        }
    }
        
    public void vitoria(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        Conexao con = new Conexao();
        Statement st = con.conexao.createStatement();
        st.executeUpdate("UPDATE jogador SET vitorias = vitorias + 1 WHERE nome_jogador = '" 
                + jogador.getNome()+"'");
        
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
            String vitoria = rs.getString("vitorias");
            String derrota = rs.getString("derrotas");   
            System.out.println("Vitórias: " + vitoria + "\nDerrotas: " + derrota);//mostra os dados da tabela jogador no console
            Jogar jogo = new Jogar();
            jogo.entrarJogo(jogador);
        }
    }
    
    public void derrota(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        Conexao con = new Conexao();
        Statement st = con.conexao.createStatement();
        st.executeUpdate("UPDATE jogador SET `derrotas` = `derrotas` + 1 where `nome_jogador` = '" 
                + jogador.getNome()+"'");
        
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
            String vitoria = rs.getString("vitorias");
            String derrota = rs.getString("derrotas");   
            System.out.println("Vitórias: " + vitoria + "\nDerrotas: " + derrota);//mostra os dados da tabela jogador no console
            Jogar jogo = new Jogar();
            jogo.entrarJogo(jogador);
        }
    }
}