package view;

import java.sql.*;
import connection.ConnectionFactory;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ConsulSaldo extends javax.swing.JFrame {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ConsulSaldo() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = ConnectionFactory.getConnection();
        
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        Color lbl = new Color(36, 135, 174);
        lblCli.setOpaque(true);
        lblCli.setBackground(lbl);
        lblCliente.setOpaque(true);
        lblCliente.setBackground(lbl);
        lblConta.setOpaque(true);
        lblConta.setBackground(lbl);
        lblSaldoC.setOpaque(true);
        lblSaldoC.setBackground(lbl);
        lblSaldoP.setOpaque(true);
        lblSaldoP.setBackground(lbl);
        
        Color lblBotao = new Color(9, 24, 31);        
        jButton1.setBackground(lbl);
    }

    private void consultarSaldo() {
        String sql = "select * from usuarios where id = ? and numconta = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txtIdCliente.getText());
            stmt.setString(2, txtNumCont.getText());
            rs = stmt.executeQuery();
            if (rs.next()) {
                txtCliente.setText(rs.getString(2));
                txtSaldoPoup.setText(rs.getString(5));
                txtSaldoCc.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Cliente nao cadastrado ou dados incorretos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtSaldoCc = new javax.swing.JTextField();
        txtSaldoPoup = new javax.swing.JTextField();
        lblSaldoP = new javax.swing.JLabel();
        lblSaldoC = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtNumCont = new javax.swing.JTextField();
        lblConta = new javax.swing.JLabel();
        lblCli = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA SALDO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(197, 225, 236));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtSaldoCc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtSaldoPoup.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        lblSaldoP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSaldoP.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoP.setText(" Saldo da Poup: ");

        lblSaldoC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSaldoC.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoC.setText(" Saldo da C/C.: ");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText(" Nome do cliente: ");

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtNumCont.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        lblConta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblConta.setForeground(new java.awt.Color(255, 255, 255));
        lblConta.setText(" Nº Conta: ");

        lblCli.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCli.setForeground(new java.awt.Color(255, 255, 255));
        lblCli.setText(" ID Cliente: ");

        txtIdCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(36, 135, 174));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/midias/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(lblLogo)
                .addContainerGap(297, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblConta)
                    .addComponent(lblCli)
                    .addComponent(lblCliente)
                    .addComponent(lblSaldoP)
                    .addComponent(lblSaldoC))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSaldoPoup)
                    .addComponent(txtSaldoCc)
                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumCont, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoPoup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoCc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(686, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Chamada ao CONSULTA SALDO
        consultarSaldo();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsulSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulSaldo().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCli;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblConta;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSaldoC;
    private javax.swing.JLabel lblSaldoP;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNumCont;
    private javax.swing.JTextField txtSaldoCc;
    private javax.swing.JTextField txtSaldoPoup;
    // End of variables declaration//GEN-END:variables

}
