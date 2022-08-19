/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tushar
 */
public class StudentChat extends javax.swing.JFrame {

    /**
     * Creates new form StudentChat
     */
    String studentid = GlobalClass.loggedinstudent;
    String name;
    ImageIcon ic = new ImageIcon("src/Uni Lms.png");

    public StudentChat() {
        initComponents();
        setSize(1145, 710);

//        QueryForumLoading object = new QueryForumLoading();
//        object.setVisible(true);
//        
//        try
//        {
//            Thread.sleep(500);
//            object.dispose();
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
        //object.dispose();
      

        try {
            HttpResponse<String> response = Unirest.get("http://localhost:8080/studentsetname").queryString("id", studentid).asString();

            String anss = response.getBody();
            System.out.println(anss);

            StringTokenizer st3 = new StringTokenizer(anss, ";;;");
            while (st3.hasMoreTokens()) {
                name = st3.nextToken();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jChatArea.setContentType("text/html");
        setTitle("Uni LMS Student-Teacher Query Forum");
        setResizable(false);
        setLocationRelativeTo(null);

        loadchat();
        setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jChatArea = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        talb = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        submitbt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jChatArea.setEditable(false);
        jChatArea.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jChatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 160, 990, 320);

        talb.setBackground(new java.awt.Color(255, 255, 255));
        talb.setColumns(20);
        talb.setRows(5);
        jScrollPane2.setViewportView(talb);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(130, 550, 610, 110);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Post New Query");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 520, 190, 30);

        submitbt.setBackground(new java.awt.Color(255, 255, 255));
        submitbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/note (1).png"))); // NOI18N
        submitbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtActionPerformed(evt);
            }
        });
        jPanel1.add(submitbt);
        submitbt.setBounds(820, 550, 130, 110);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Query Forum");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 70, 210, 60);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-chat.gif"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 0, 180, 150);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Teacher Student");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(460, 20, 250, 60);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(840, 0, 290, 100);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 0, 50, 50);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Back");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 50, 50, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1130, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtActionPerformed
        // TODO add your handling code here:

        String question = talb.getText();
        if (!question.isEmpty()) {
            try {
                HttpResponse<String> response = Unirest.get("http://localhost:8080/studentaskquestion")
                        .queryString("id", studentid)
                        .queryString("name", name)
                        .queryString("question", question)
                        .asString();

                if (response.getStatus() == 200) {
                    String feedback5 = response.getBody();
                    if (feedback5.equals("Fails!!!")) {
                        //                        JOptionPane.showMessageDialog(this, "Fails!!!");
                        JOptionPane.showMessageDialog(this, """
                                !!! OOPS !!!
                                Error Occured
                                !!! Try Again !!!""", "Uni LMS Studnet Ask Question", JOptionPane.PLAIN_MESSAGE, ic);
                    } else {
                        loadchat();
                        //                       String output = "Your Output is";
                        //                        JOptionPane.showMessageDialog(this, "Your Student Id: " + feedback5 + "\n Your Password is: " + pass2);
                        JOptionPane.showMessageDialog(this, """
                                    !!! Done !!!
                                    Notes Added
                                    \nReference Id Generated:""" + feedback5,
                                "Uni LMS Student Ask Question", JOptionPane.PLAIN_MESSAGE, ic);

                        //                        department.setText(null);
                    }
                } else {
                    System.out.println(response.getStatusText());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_submitbtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadchat() {
        try {
            HttpResponse<String> response = Unirest.get("http://localhost:8080/studentfetchchat")
                    .queryString("id", studentid)
                    .asString();

            if (response.getStatus() == 200) {

                String ans4 = response.getBody();
                String chat = "";
                StringTokenizer st4 = new StringTokenizer(ans4, "#$#");
                while (st4.hasMoreTokens()) {
                    String st3 = st4.nextToken();
                    StringTokenizer st = new StringTokenizer(st3, ";;;");
                    String ques = st.nextToken();
                    String answer = st.nextToken();
                    String teachname = st.nextToken();
                    if (answer.equals("na")) {
                        chat += "<h1 align=\"left\" style=font-family:timesnewroman\"color:red;\"><b>Question:- </b>" + ques + "</h1>";
                        chat += "<h2 align=\"left\" style=\"color:black;\">Not Answered Yet !!</h2>";
                        chat += "<h1 style=\"color:black;\"><b>____________________________________________________</b></h1>";
                    } else {
                        chat += "<h1 align=\"left\" style=\"color:green;\"><b>Question:- </b>" + ques + "</h1>";
                        chat += "<h2 align=\"left\" style=\"color:blue;\"><i>Answer By:- </i>" + teachname + "</h2>";
                        chat += "<p align=\"left\" style=\"color:black;\">" + answer + "</p>";
                        chat += "<h1 style=\"color:black;\"><b>____________________________________________________</b></h1>";

                    }
                }
                jChatArea.setText(chat);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(StudentChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jChatArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton submitbt;
    private javax.swing.JTextArea talb;
    // End of variables declaration//GEN-END:variables
}
