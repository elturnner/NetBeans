package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class UsuariosDAO {
    
    public boolean checkLogin(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE username = ? and senha = ?");
            stmt.setString(1, login);            
            stmt.setString(2, senha);

            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                check = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);                    
        }
        
        return check;
    }
    public boolean checkNumConta(String numContaDest, String numContaRem){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        boolean checkk = false;
        boolean checkFinal = false;


        int cont = 0;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE numconta = ?");
            stmt.setString(1, numContaDest);           
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                check = true;               
                
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE numconta = ?");
            stmt.setString(1, numContaRem);           
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                checkk = true;               
                
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt, rs);                    
        }
        
        if(check && checkk){
            checkFinal = true;
        }
                   
        return checkFinal;
    }
    
        public boolean retiraSaldo(String valor, String conta, String tipoConta){
        
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;        
        String sql = "UPDATE usuarios SET saldoPoup = ? WHERE numconta = ? LIMIT 1";
        String sql2 = "SELECT * FROM usuarios WHERE numconta = ?";
        String aux = "saldoPoup";
        double saldo = 0;
        double saldoAtualizado = 0;
        
        if(tipoConta.equals("Conta Corrente")){
            sql = "UPDATE usuarios SET saldoCor = ? WHERE numconta = ? LIMIT 1";
            aux = "saldoCor";
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, conta);
            rs = stmt.executeQuery();
            
            if(rs != null && rs.next()){
                saldo = rs.getDouble(aux);
            }
                       
            saldoAtualizado = saldo - Double.parseDouble(valor);           
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);            
        }                
        

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(saldoAtualizado));
            stmt.setString(2, conta);
            stmt.executeUpdate();
            return true;
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);                    
        }             
    }
        
        public boolean addSaldo(String valor, String conta, String tipoConta){
        
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;        
        String sql = "UPDATE usuarios SET saldoPoup = ? WHERE numconta = ? LIMIT 1";
        String sql2 = "SELECT * FROM usuarios WHERE numconta = ?";
        String aux = "saldoPoup";
        double saldo = 0;
        double saldoAtualizado = 0;
        
        if(tipoConta.equals("Conta Corrente")){
            sql = "UPDATE usuarios SET saldoCor = ? WHERE numconta = ? LIMIT 1";
            aux = "saldoCor";
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, conta);
            rs = stmt.executeQuery();
            
            if(rs != null && rs.next()){
                saldo = rs.getDouble(aux);
            }
                       
            saldoAtualizado = saldo + Double.parseDouble(valor);           
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);            
        }                
        

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(saldoAtualizado));
            stmt.setString(2, conta);
            stmt.executeUpdate();
            return true;
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);                    
        }             
    }
        
        
        public boolean checkSaldo(String valor, String conta, String tipoConta){
        
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        String sql2 = "SELECT * FROM usuarios WHERE numconta = ?";
        String aux = "saldoPoup";
        double saldo = 0;
        PreparedStatement stmt = null;
        
        if(tipoConta.equals("Conta Corrente")){            
            aux = "saldoCor";
        }

        try {
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, conta);
            rs = stmt.executeQuery();
            
            if(rs != null && rs.next()){
                saldo = rs.getDouble(aux);
            }
            if(saldo < Double.parseDouble(valor)){
                return false;
            }else{
                return true;
            }                       
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);                    
        }             
    }
    
}
