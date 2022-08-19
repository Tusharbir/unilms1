package unilms;

public class Server extends javax.swing.JFrame {

    MyServer obj;

    public Server() {
        initComponents();
        setSize(760, 420);
        setLocationRelativeTo(null);
        st2.setEnabled(false);
        setResizable(false);
        setTitle("Uni LMS Server Screen");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        st2 = new javax.swing.JButton();
        st1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(logo);
        logo.setBounds(220, 20, 300, 110);

        st2.setBackground(new java.awt.Color(51, 51, 51));
        st2.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        st2.setForeground(new java.awt.Color(255, 255, 255));
        st2.setText("Stop Server");
        st2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st2ActionPerformed(evt);
            }
        });
        jPanel1.add(st2);
        st2.setBounds(270, 280, 200, 60);

        st1.setBackground(new java.awt.Color(51, 51, 51));
        st1.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        st1.setForeground(new java.awt.Color(255, 255, 255));
        st1.setText("Start Server");
        st1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st1ActionPerformed(evt);
            }
        });
        jPanel1.add(st1);
        st1.setBounds(270, 180, 200, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 760, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void st1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st1ActionPerformed
        // TODO add your handling code here:
        try {
            obj = new MyServer(9000);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        st2.setEnabled(true);
        st1.setEnabled(false);
    }//GEN-LAST:event_st1ActionPerformed

    private void st2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st2ActionPerformed
        obj.shutdown();
        st1.setEnabled(true);
        st2.setEnabled(false);

    }//GEN-LAST:event_st2ActionPerformed

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton st1;
    private javax.swing.JButton st2;
    // End of variables declaration//GEN-END:variables
}
