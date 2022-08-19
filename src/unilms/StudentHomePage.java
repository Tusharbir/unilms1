/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author tushar
 */
public class StudentHomePage extends javax.swing.JFrame {

    /**
     * Creates new form StudentHomePage
     */
    String studentname = GlobalClass.loggedinstudent;
    ImageIcon loading = new ImageIcon("icons8-chat-128.png");
    JLabel lb2;
    
    public StudentHomePage() {
        initComponents();
        try {

            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentsetname").queryString("id", studentname).asString();
            if (response.getStatus() == 200) {
                String anss = response.getBody();
//            System.out.println(anss);

                StringTokenizer st = new StringTokenizer(anss, ";;;");
                
                    String sname;
                    sname = st.nextToken();
                    System.out.println("~~~~~~~~~~~~~~~~~~~"+sname);
                    sname = sname.toUpperCase();

                    name.setText(sname + "!");

                

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        setSize(1155, 738);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Uni LMS Student Home Page");

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
        TitlePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        ChangePasswordPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewbt = new javax.swing.JButton();
        LogoutPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ChangePasswordPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        changebt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        viewnotes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));
        TitlePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TitlePanel.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-username-500 (1).png"))); // NOI18N
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TitlePanel.add(jLabel4);
        jLabel4.setBounds(10, 0, 50, 60);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("WELCOME");
        TitlePanel.add(jLabel1);
        jLabel1.setBounds(70, 0, 110, 60);

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("jLabel2");
        TitlePanel.add(name);
        name.setBounds(180, 0, 260, 60);

        jPanel1.add(TitlePanel);
        TitlePanel.setBounds(0, 0, 440, 60);

        ChangePasswordPanel.setBackground(new java.awt.Color(0, 0, 0));
        ChangePasswordPanel.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-more-info-50.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 0, 50, 50);

        ChangePasswordPanel.add(jPanel4);
        jPanel4.setBounds(10, 0, 50, 50);

        viewbt.setBackground(new java.awt.Color(0, 0, 0));
        viewbt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        viewbt.setForeground(new java.awt.Color(255, 255, 255));
        viewbt.setText("View Profile");
        viewbt.setBorder(null);
        viewbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewbt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbtActionPerformed(evt);
            }
        });
        ChangePasswordPanel.add(viewbt);
        viewbt.setBounds(60, 0, 130, 50);

        jPanel1.add(ChangePasswordPanel);
        ChangePasswordPanel.setBounds(950, 560, 190, 50);

        LogoutPanel.setBackground(new java.awt.Color(0, 0, 0));
        LogoutPanel.setLayout(null);

        jButton3.setBackground(java.awt.SystemColor.windowText);
        jButton3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Logout");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        LogoutPanel.add(jButton3);
        jButton3.setBounds(60, 0, 130, 40);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-logout-26.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabel5);
        jLabel5.setBounds(10, 0, 40, 40);

        LogoutPanel.add(jPanel6);
        jPanel6.setBounds(10, 0, 50, 40);

        jPanel1.add(LogoutPanel);
        LogoutPanel.setBounds(950, 660, 190, 40);

        ChangePasswordPanel1.setBackground(new java.awt.Color(0, 0, 0));
        ChangePasswordPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-sign-in-form-password-50.png"))); // NOI18N
        jPanel5.add(jLabel6);
        jLabel6.setBounds(0, 0, 50, 50);

        ChangePasswordPanel1.add(jPanel5);
        jPanel5.setBounds(10, 0, 50, 50);

        changebt.setBackground(new java.awt.Color(0, 0, 0));
        changebt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        changebt.setForeground(new java.awt.Color(255, 255, 255));
        changebt.setText("Change Password");
        changebt.setBorder(null);
        changebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changebt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        changebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changebtActionPerformed(evt);
            }
        });
        ChangePasswordPanel1.add(changebt);
        changebt.setBounds(60, 0, 130, 50);

        jPanel1.add(ChangePasswordPanel1);
        ChangePasswordPanel1.setBounds(950, 610, 190, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(830, 10, 300, 100);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Query Forum");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(720, 390, 150, 30);

        viewnotes.setBackground(new java.awt.Color(255, 255, 255));
        viewnotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-notes-128.png"))); // NOI18N
        viewnotes.setBorder(null);
        viewnotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewnotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewnotesActionPerformed(evt);
            }
        });
        jPanel1.add(viewnotes);
        viewnotes.setBounds(260, 250, 150, 140);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-assignment-128 (2).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(490, 250, 150, 140);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("View Notes");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(270, 390, 130, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-chat-128.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(720, 250, 150, 140);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("View Assignments");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(490, 390, 150, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbtActionPerformed
        // TODO add your handling code here:

//        System.out.println("i am first");
        try {
            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentviewprofile").queryString("id", studentname).asString();
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        StudentViewProfile obj = new StudentViewProfile();
        obj.setVisible(true);
    }//GEN-LAST:event_viewbtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        GlobalClass.loggedinstudent = "";

    }//GEN-LAST:event_jButton3ActionPerformed

    private void changebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changebtActionPerformed
        // TODO add your handling code here:

        //        String Name = name.getText();
        //        System.out.println(Name);
        StudentChangePasssword obj = new StudentChangePasssword();
        obj.setVisible(true);
    }//GEN-LAST:event_changebtActionPerformed

    private void viewnotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewnotesActionPerformed
        // TODO add your handling code here:
        StudentViewNotes obj = new StudentViewNotes();
        obj.setVisible(true);
    }//GEN-LAST:event_viewnotesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StudentViewAssignment obj = new StudentViewAssignment();
        obj.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
//        QueryForumLoading object = new QueryForumLoading();
//        object.setVisible(true);
        
        
        
        
        StudentChat obj = new StudentChat();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChangePasswordPanel;
    private javax.swing.JPanel ChangePasswordPanel1;
    private javax.swing.JPanel LogoutPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton changebt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel name;
    private javax.swing.JButton viewbt;
    private javax.swing.JButton viewnotes;
    // End of variables declaration//GEN-END:variables
}
