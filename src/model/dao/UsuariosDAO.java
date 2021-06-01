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
    
        public boolean updateSaldo(String valor, String conta){
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE usuarios SET saldoPoup = ? WHERE numconta = ? LIMIT 1";
        PreparedStatement stmt = null;        
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, valor);
            stmt.setString(2, conta);
            stmt.executeUpdate();
            return true;
  
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);                    
        }             
    }
    
}
