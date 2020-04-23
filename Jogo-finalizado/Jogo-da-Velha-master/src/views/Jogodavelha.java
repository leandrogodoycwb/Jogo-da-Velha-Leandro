/*finalizado*/
package views;

import controllers.Jogar;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jogodavelha {
    
    public static void main(String[] args) {
        
        try {
            Jogar jogo = new Jogar();
            jogo.menuJogo();
            
        } catch (SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Jogodavelha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}        