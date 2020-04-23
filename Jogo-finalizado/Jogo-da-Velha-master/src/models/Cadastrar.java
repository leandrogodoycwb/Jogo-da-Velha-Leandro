/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
/*finalizado*/
package models;

import controllers.Jogador;
import controllers.Jogar;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiz_
 */
public class Cadastrar extends Jogador {
    
    public void recebeDados(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException{
              
        Conexao con = new Conexao();
            
        Statement st = con.conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '"
                        + jogador.getNome() +"'");//Select na tabela jogador
        while(rs.next()){
                String usuario = rs.getString("nome_jogador");
                if(jogador.getNome().equals(usuario)){
                    System.out.println("Nome de cadastro em uso!");
                    Jogar cadastro = new Jogar();
                    cadastro.menuJogo();
                } 
        }
                if (!jogador.getSenha().equals(jogador.getConf_Senha())){
                    //verifica se as variaveis senha1 e senha 2 sao iguais
                    System.out.println("SENHAS DIFERENTES");
                    Jogar cadastro = new Jogar();
                    cadastro.menuJogo();
                } else if (jogador.getSenhaConvertida() <= 5) {
                    //verifica se a senha é menor ou igual que 5
                    System.out.println("Sua senha deve conter mais que 5 digitos");
                    Jogar cadastro = new Jogar();
                    cadastro.menuJogo();
                } else {
                    MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            
                    byte[] senhabytes = jogador.getSenha().getBytes();
                    senhaCriptografada.update(senhabytes,0,senhabytes.length);
                    BigInteger i = new BigInteger(1,senhaCriptografada.digest());
                    String jujuba = String.format("%1$032X", i);
            
                    st.executeUpdate("insert into jogador "+// insere no banco
                        "(nome_jogador,senha,vitorias,derrotas)" +
                        " values ('" + jogador.getNome() + "', '" + jujuba + "',0,0)");
                    System.out.println("Cadastro realizado com sucesso");
                    Logar entrar = new Logar();
                    entrar.Autenticar(jogador);
                }
    }
}