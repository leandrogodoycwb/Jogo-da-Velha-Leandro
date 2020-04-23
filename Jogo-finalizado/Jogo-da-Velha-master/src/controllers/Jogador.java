/*finalizado*/
package controllers;

public class Jogador {
    private String nome;
    private String senha;
    private String conf_senha;
    private int senhaConvertida;
    
    public void setNome(String nome){
        this.nome = nome;
    }
          
    public String getNome() {
        return nome;
    }   
    
    public void setSenha(String senha) {
        this.senha = senha;
        this.senhaConvertida = senha.length();
        setSenhaConvertida(senhaConvertida);
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setConf_Senha(String conf_senha){
        this.conf_senha = conf_senha;
    }
    
    public String getConf_Senha() {
        return conf_senha;
    }
    
    public void setSenhaConvertida(int senhaConvertida){
        this.senhaConvertida = senhaConvertida;
    }
    
    public int getSenhaConvertida() {
        return senhaConvertida;
    }
}