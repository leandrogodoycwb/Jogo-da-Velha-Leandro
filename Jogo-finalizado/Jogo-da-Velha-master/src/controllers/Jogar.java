/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*finalizado*/
package controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import models.Cadastrar;
import models.Logar;

/**
 *
 * @author Luiz_
 */
public class Jogar {
    
    public void menuJogo() throws SQLException, NoSuchAlgorithmException{
        
        Jogador jogador = new Jogador();//instancia um objeto jogador
        Scanner nome = new Scanner(System.in);//instancia um objeto escolha
        Scanner escolha = new Scanner(System.in);//instancia um objeto escolha
        Scanner senha = new Scanner(System.in);//instacia um objeto senha
        Scanner conf_senha = new Scanner(System.in);//instancia um objeto conf_senha
        Scanner termo = new Scanner(System.in);
        Logar login = new Logar();
        Cadastrar cadastro = new Cadastrar();
        
        String x = null;
        while(!"3".equals(x)){
            System.out.println("\n");
            System.out.println("JOGO DA VELHA");
            System.out.println("Cadastrar ( 1 )");
            System.out.println("Jogar ( 2 )");
            System.out.println("Sair ( 3 )");
            x = escolha.nextLine();
            
            switch(x) {
                case "1":
                    String y = null;
                    System.out.println("\nPor questões de segurança sua senha será enviado"
                            + " ao banco de dados de forma\ncriptografada, esse termo foi criado"
                            + " para sua própria segurança contra invasão\nao banco de dados e"
                            + " vazamento de informações, você está de acordo?\nSe sim digite --> aceito <--"
                            + " se não digite --> discordo <--");
                            y = termo.nextLine();
                    switch(y){
                        case "aceito": 
                            System.out.println("Digite seu nome: ");
                            jogador.setNome(nome.nextLine());//joga o nome pra dentro do metodo SETNOME
                            System.out.println("Digite sua senha: ");
                            jogador.setSenha(senha.nextLine());//joga a senha pra dentro do metodo SETSENHA1
                            System.out.println("Confirme sua senha: ");
                            jogador.setConf_Senha(conf_senha.nextLine());//joga a senha pra dentro do metoddo SETSENHA2
                            cadastro.recebeDados(jogador);
                            break;
                        
                        case "discordo":
                            menuJogo();
                            break;
                            
                        default: 
                            System.out.println("\nPor favor, digite conforme as opções\n"
                                    + "aceito <-- Para continuar com o cadastro\n"
                                    + "discordo <-- Para finalizar");
                    }
                     
                    break;
                    
                case "2":
                     System.out.println("---------- Login -----------\n");
                     System.out.println("Nome: ");
                     jogador.setNome(nome.nextLine());
                     System.out.println("Senha: ");
                     jogador.setSenha(senha.nextLine());
                     login.Autenticar(jogador);       
                    break;
                    
                case "3":
                        exit();
                    break;
                    
                default: 
                    System.out.println("\nPor favor, digite conforme as opções do menu\n"
                            + "1 <-- Para cadastrar\n"
                            + "2 <-- Para logar\n"
                            + "3 <-- Para sair");
            }
        }
    }
    
    public void entrarJogo(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException{
       
        Scanner ler = new  Scanner(System.in);
        Jogo jogar = new Jogo();
        String posicao;
        int valida = 0, jogada = 0;
        
        do{
            System.out.println("quer jogar contra player ou contra pc?");
            System.out.println("Player ( 1 )");
            System.out.println("PC ( 2 )");
            System.out.println("Sair( 3 )");
            valida = ler.nextInt();
            if(valida == 3){
                menuJogo();
            }

        }while(valida != 1 && valida != 2);

    if(valida == 1){     
        
        System.out.println("Jogo começou");
        jogar.Mostrar();
      
            while(true){
            do{
                System.out.println(jogador.getNome() + " insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                    System.out.println("Jogada inválida");
                    System.out.println(jogador.getNome() + " insira posição: ");
                    posicao = ler.next();
                    valida = 0;
                }
                jogar.Jogada(posicao, "X");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
                jogada++;
                valida = 0;
                jogar.Mostrar();
            
            if(!jogar.Ganhou(jogada, jogador).equals("null")){
                break;
            }
               
            do{
                System.out.println("Jogador 2 insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                    System.out.println("Jogada inválida");
                    System.out.println("Jogador 2 insira posição: ");
                    posicao = ler.next();
                    valida = 0;
                }
                jogar.Jogada(posicao, "O");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
            jogada++;
            valida = 0;
            jogar.Mostrar();
                
            if(!jogar.Ganhou(jogada, jogador).equals("null")){
                break;
            }
               
        }  
            entrarJogo(jogador);
        
        
            }else {
                System.out.println("Jogo começou");
                jogar.Mostrar();
          
            while(true){
                       
            do{
                System.out.println(jogador.getNome() + " insira posição: ");
                posicao = ler.next();
                while(!jogar.Valida(posicao)){
                    System.out.println("Jogada inválida");
                    System.out.println(jogador.getNome() + " insira posição: ");
                    posicao = ler.next();
                    valida = 0;
                }
                jogar.Jogada(posicao, "X");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
            
                jogada++;
                valida = 0;
                jogar.Mostrar();
            
            if(!jogar.Ganhou(jogada, jogador).equals("null")){
                break;
            }
               
            do{
                posicao =  Integer.toString((int)(Math.random() * 10));
                while(!jogar.Valida(posicao)){
                    posicao =  Integer.toString((int)(Math.random() * 10));
                    valida = 0;
                }
                jogar.Jogada(posicao, "O");
                valida = 1;
                
            }while(valida == 0); //fim jog 1
                System.out.println("A máquina jogou: \n");
                jogada++;
                valida = 0;
                jogar.Mostrar();
                
            if(!jogar.Ganhou(jogada, jogador).equals("null")){
                break;
            }  
        }   
            entrarJogo(jogador);
            }
    }
}
