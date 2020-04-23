/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*finalizado*/
package controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import models.Placar;

/**
 *
 * @author Luiz_
 */
public class Jogo{
    
        private final String[][] matriz = { {"7","8","9"},
                                      {"4","5","6"},
                                      {"1","2","3"}};

        public String Mostrar(){
            for(int li=0; li<3; li++) {
                for (int col = 0; col < 3; col++) {
                    System.out.printf("    "+ matriz[li][col]);
                }
                System.out.println("\n");
            }
            return null;
        }

        public boolean Valida(String pos){
            for(int li=0; li<3; li++) {
                for (int col = 0; col < 3; col++) {
                    if(matriz[li][col].equals(pos) )
                        return true;
                }
            }
            return false;
        }

        public void Jogada(String pos, String jgd){
            switch (pos) {
                case "7":
                    matriz[0][0] = jgd;
                    break;
                case "8":
                    matriz[0][1] = jgd;
                    break;
                case "9":
                    matriz[0][2] = jgd;
                    break;
                case "4":
                    matriz[1][0] = jgd;
                    break;
                case "5":
                    matriz[1][1] = jgd;
                    break;
                case "6":
                    matriz[1][2] = jgd;
                    break;
                case "1":
                    matriz[2][0] = jgd;
                    break;
                case "2":
                    matriz[2][1] = jgd;
                    break;
                case "3":
                    matriz[2][2] = jgd;
                    break;
                default:
                    break;
            }
        }

        public String Ganhou(int jogadas, controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException{
            String[] poss = new String[8];  //Possibilidades
            String vencedor = "null";
            if (jogadas == 9){
               vencedor = "-----------DEU VELHA-------------";
               return vencedor; 
            }
            //horizontais
            poss[0] = matriz[0][0] + matriz[0][1] + matriz[0][2];
            poss[1] = matriz[1][0] + matriz[1][1] + matriz[1][2];
            poss[2] = matriz[2][0] + matriz[2][1] + matriz[2][2];
            //verticais
            poss[3] = matriz[0][0] + matriz[1][0] + matriz[2][0];
            poss[4] = matriz[0][1] + matriz[1][1] + matriz[2][1];
            poss[5] = matriz[0][2] + matriz[1][2] + matriz[2][2];
            //diagonais
            poss[6] = matriz[2][0] + matriz[1][1] + matriz[0][2];
            poss[7] = matriz[0][0] + matriz[1][1] + matriz[2][2];

            for (String pos : poss) {
                if (pos.equals("XXX")) {
                    vencedor = "Jogador 1";
                    System.out.println(jogador.getNome() + " Venceu !\n");
                    Placar placar = new Placar();
                    placar.vitoria(jogador);
                } else if (pos.equals("OOO")) {
                    vencedor = "Jogador 2";
                    System.out.println(jogador.getNome() + " Perdeu !\n");
                    Placar placar = new Placar();
                    placar.derrota(jogador);
                }
            }
                return vencedor;
        }
}

