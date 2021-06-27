package view;

import java.sql.*;
import connection.ConnectionFactory;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class TelaDeposito extends javax.swing.JFrame {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public TelaDeposito() {
        initComponents();
        con = ConnectionFactory.getConnection();
        this.setLocationRelativeTo(null);
        
        Color lblBotao = new Color(36, 135, 174);        
        btnConfirmar.setBackground(lblBotao);
        
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        Color lbl = new Color(36, 135, 174);
        lblDeposito.setOpaque(true);
        lblDeposito.setBackground(lbl);
        lblValor.setOpaque(true);
        lblValor.setBackground(lbl);
        lblTipo.setOpaque(true);
        lblTipo.setBackground(lbl);
    }

    public boolean TelaDeposito(String valor, String conta, String tipoConta) {

        String sql = "UPDATE usuarios SET saldoPoup = ? WHERE numconta = ? LIMIT 1";
        String sql2 = "SELECT * FROM usuarios WHERE numconta = ?";
        String aux = "saldoPoup";
        double saldo = 0;
        double saldoAtualizado = 0;

        if (tipoConta.equals("Conta Corrente")) {
            sql = "UPDATE usuarios SET saldoCor = ? WHERE numconta = ? LIMIT 1";
            aux = "saldoCor";
        }
        try {
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, conta);
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
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
            JOptionPane.showMessageDialog(null, "Operação Realizada com sucesso!");
            //As linha abaixo "Limpam" os campos após a operação
            txtValorDeposito.setText(null);
            txtNumCont.setText(null);
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        lblDeposito = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValorDeposito = new javax.swing.JTextField();
        txtNumCont = new javax.swing.JTextField();
        cboTipoConta = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TELA DE DEPÓSITO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(197, 225, 236));

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText(" Tipo de Conta: ");

        lblDeposito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDeposito.setForeground(new java.awt.Color(255, 255, 255));
        lblDeposito.setText(" Depósito na conta: ");

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText(" Valor do Depósito: ");

        txtValorDeposito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtNumCont.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        cboTipoConta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cboTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Poupança", "Conta Corrente" }));

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblValor)
                        .addComponent(lblDeposito)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboTipoConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumCont)
                    .addComponent(txtValorDeposito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumCont, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(686, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // Chamada ao método depositar
        String tipoConta = cboTipoConta.getSelectedItem().toString();
        
        //System.out.println("Tipo de conta: "+ tipoConta);teste
       
        TelaDeposito(txtValorDeposito.getText(), txtNumCont.getText(),tipoConta);
    }//GEN-LAST:event_btnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeposito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cboTipoConta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDeposito;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtNumCont;
    private javax.swing.JTextField txtValorDeposito;
    // End of variables declaration//GEN-END:variables
}
