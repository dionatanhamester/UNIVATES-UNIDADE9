/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.text.View;

/**
 *
 * @author Dionatan
 */
public class CaixaDeDialogo {
    
    final public static char ERRO = 'e';
    final public static char INFO = 'i';
    final public static char ALERTA = 'a';
    final public static char PERGUNTA = 'p';
    
    private static CaixaDeDialogo instancia = new CaixaDeDialogo();
    
    private CaixaDeDialogo() {
        // construtor vazio e privado
    }
    
    /**
     * Instancia a Caixa de Diálogo
     * @return 
     */
    public static CaixaDeDialogo obterInstancia() {
        return (instancia);
    }      
    
    /**
     * Apresenta uma mensagem na tela do usuário
     * @param jframe
     * @param frase
     * @param tipo 
     */
    public void exibirMensagem(JFrame jframe,String frase, char tipo) {
        exibirMensagem(jframe, frase, "Mensagem", tipo );
    }
    
    /**
     * Apresenta uma mensagem na tela do usuário com ajuste na forma de apresentação ( erro, info, advertencia ou pergunta )
     * @param jframe
     * @param frase
     * @param boxFrase
     * @param tipo 
     */
    public void exibirMensagem(JFrame jframe, String frase, String boxFrase, char tipo) {
        /* Erro 'e'
         * Informativa 'i'
         * Advertência 'a'
         * Pergunta 'p'
         */
        //JOptionPane.showMessageDialog(null,"Está conectado","Mensagem",JOptionPane.WARNING_MESSAGE);
        String iconTypes = "eiap";
        JOptionPane.showMessageDialog(jframe, frase, boxFrase, iconTypes.indexOf(tipo) );
    }
     
    /**
     * Solicita a confirmação de uma açao para o usuário
     * @param jframe
     * @param frase
     * @return 
     */
    public boolean pedirConfirmacao(JFrame jframe, String frase ) {
        return( pedirConfirmacao(jframe, frase, "Confirmação", 'p' ));
    }
    
        
    /**
     * Solicitação a confirmação de uma ação para o usuário
     * @param jframe
     * @param frase
     * @param boxFrase
     * @param tipo
     * @return 
     */
    public boolean pedirConfirmacao(JFrame jframe, String frase, String boxFrase, char tipo ) {
        String[] opcoes = { "Sim", "Não" };
        int opcaoPadrao = 0;
        String iconTypes = "eiap";
                
        int escolha = JOptionPane.showOptionDialog(jframe,frase,boxFrase,JOptionPane.YES_NO_OPTION,iconTypes.indexOf(tipo),null,opcoes,opcoes[opcaoPadrao]);        
        return (escolha == 0);
    }   
}