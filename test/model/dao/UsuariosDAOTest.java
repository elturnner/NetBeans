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
    public void atualizar() {
        
        UsuariosDAO dao = new UsuariosDAO();
        String valor = "3333";
        String conta = "555555";
        
        if(dao.updateSaldo(valor, conta)){
            System.out.println("Saldo atualizado com sucesso!");
        }else{
            fail("Erro ao Salvar");
        }
        
        
    }
    
}
