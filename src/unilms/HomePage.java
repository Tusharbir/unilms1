/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

//hello from chand

//hello from navish

/**
 *
 * @author tushar
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        setSize(855, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Uni LMS Home Screen");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adminbt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        teacherbt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        studentbt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 10, 300, 120);

        adminbt.setBackground(new java.awt.Color(255, 255, 255));
        adminbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-admin-settings-male-96.png"))); // NOI18N
        adminbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbtActionPerformed(evt);
            }
        });
        jPanel1.add(adminbt);
        adminbt.setBounds(120, 180, 120, 100);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Mongolian Baiti", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(600, 290, 90, 40);

        teacherbt.setBackground(new java.awt.Color(255, 255, 255));
        teacherbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/teacher.png"))); // NOI18N
        teacherbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherbtActionPerformed(evt);
            }
        });
        jPanel1.add(teacherbt);
        teacherbt.setBounds(350, 180, 120, 100);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Mongolian Baiti", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 290, 90, 40);

        studentbt.setBackground(new java.awt.Color(255, 255, 255));
        studentbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/student icon.png"))); // NOI18N
        studentbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentbtActionPerformed(evt);
            }
        });
        jPanel1.add(studentbt);
        studentbt.setBounds(590, 180, 110, 100);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Mongolian Baiti", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Teacher");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(360, 290, 90, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentbtActionPerformed
        // TODO add your handling code here:
        StudentLoginPage obj = new StudentLoginPage();
        obj.setVisible(true);
    }//GEN-LAST:event_studentbtActionPerformed

    private void adminbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminbtActionPerformed
        // TODO add your handling code here:
        AdminLoginScreen obj = new AdminLoginScreen();
        obj.setVisible(true);
    }//GEN-LAST:event_adminbtActionPerformed

    private void teacherbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherbtActionPerformed
        // TODO add your handling code here:
        TeacherLoginPage obj = new TeacherLoginPage();
        obj.setVisible(true);
    }//GEN-LAST:event_teacherbtActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton studentbt;
    private javax.swing.JButton teacherbt;
    // End of variables declaration//GEN-END:variables
}