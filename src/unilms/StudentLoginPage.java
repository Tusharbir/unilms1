/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tushar
 */
public class StudentLoginPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentLoginPage
     */
    ImageIcon ic = new ImageIcon("src/Uni Lms.png");

    public StudentLoginPage() 
    {
        initComponents();
        setSize(1063, 520);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Uni Lms Student Login Screen");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usertf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passtf = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        signbt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/PassIcon.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(570, 260, 30, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/user (1).png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(570, 170, 30, 30);

        usertf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usertf.setForeground(new java.awt.Color(51, 51, 51));
        usertf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usertf.setBorder(null);
        usertf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertfActionPerformed(evt);
            }
        });
        jPanel1.add(usertf);
        usertf.setBounds(610, 200, 320, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(610, 230, 320, 10);

        passtf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passtf.setForeground(new java.awt.Color(51, 51, 51));
        passtf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passtf.setBorder(null);
        passtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtfActionPerformed(evt);
            }
        });
        jPanel1.add(passtf);
        passtf.setBounds(610, 290, 320, 30);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(610, 320, 320, 3);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("EngraversGothic BT", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("LOGIN IN TO YOUR ACCOUNT");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(570, 80, 410, 29);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(570, 110, 340, 10);

        signbt.setBackground(new java.awt.Color(51, 51, 51));
        signbt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signbt.setForeground(new java.awt.Color(255, 255, 255));
        signbt.setText("Sign In");
        signbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signbtActionPerformed(evt);
            }
        });
        jPanel1.add(signbt);
        signbt.setBounds(710, 390, 130, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Login UNI Reszed.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 20, 420, 420);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(610, 260, 100, 30);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Cambria Math", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Username");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(610, 170, 100, 30);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Username and Password are Case Sensitive*");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(670, 340, 260, 18);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1080, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usertfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertfActionPerformed

    private void passtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtfActionPerformed

    private void signbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signbtActionPerformed
        // TODO add your handling code here:

        try
        {
            String u = usertf.getText();
            String p = passtf.getText();

            HttpResponse<String> response = Unirest.get("http://localhost:8080/studentlogin")
            .queryString("user",u).queryString("pass",p).asString();

            if(response.getStatus()==200)
            {
                String ans = response.getBody();

                if(ans.equals("Login Successfull !!!"))
                {
                    GlobalClass.loggedinstudent = u;
                    StudentHomePage obj = new StudentHomePage();
                    obj.setVisible(true);
                }

                else
                {
                    //                JOptionPane.showMessageDialog(this, "Incorrect Bhaji");
                    JOptionPane.showMessageDialog(this, """
                        !!! Error Occured !!!
                        Incorrect Credentials
                        !!! Try Again !!!""", "Uni LMS Student Login Screen", JOptionPane.PLAIN_MESSAGE, ic);
                        usertf.setText(null);
                        passtf.setText(null);

                    }

                }
                else
                {
                    System.out.println(response.getStatusText());
                    usertf.setText(null);
                    passtf.setText(null);
                }

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

    }//GEN-LAST:event_signbtActionPerformed

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
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField passtf;
    private javax.swing.JButton signbt;
    private javax.swing.JTextField usertf;
    // End of variables declaration//GEN-END:variables
}
