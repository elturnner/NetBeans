/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pichau
 */
public class UsuariosDAOTest {
    
    public UsuariosDAOTest() {
    }

    @Test
    public void subtraiSaldo() {
        
        UsuariosDAO dao = new UsuariosDAO();
        String valor = "10";
        String conta = "111";
        String tipoConta = "Conta Corrente";
        
        if(dao.retiraSaldo(valor, conta, tipoConta)){
            System.out.println("Saldo atualizado com sucesso!");
        }else{
            fail("Erro ao Salvar");
        }        
        
    }
    
    @Test
    public void checaSaldo() {
        
        UsuariosDAO dao = new UsuariosDAO();
        String valor = "5000";
        String conta = "555555";
        
        if(dao.checkSaldo(valor, conta)){
            System.out.println("Você tem saldo Suficiente!");
        }else{
            System.out.println("Você não possui Saldo Suficiente!");
        }        
        
    }
    @Test
    public void checaContas() {
        
        UsuariosDAO dao = new UsuariosDAO();
        String contaDest = "999999";
        String contaRem = "555555";
        
        if(dao.checkNumConta(contaDest, contaRem)){
            System.out.println("As duas Contas Existem!");
        }else{
            System.out.println("Uma das contas n existem!");
        }        
        
    }
    
    @Test
    public void adicionaSaldo() {
        
        UsuariosDAO dao = new UsuariosDAO();
        String valor = "100";
        String conta = "111";
        String tipoConta = "Conta Corrente";
        
        if(dao.addSaldo(valor, conta, tipoConta)){
            System.out.println("Saldo atualizado com sucesso!");
        }else{
            fail("Erro ao Salvar");
        }        
        
    }
    
}
