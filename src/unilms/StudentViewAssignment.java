/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

/**
 *
 * @author tushar
 */
public class StudentViewAssignment extends javax.swing.JFrame {

    /**
     * Creates new form StudentViewAssignment
     */
    String studentname = GlobalClass.loggedinstudent;
    ArrayList<StudentAssignementDetails> al;

    

    public StudentViewAssignment() {
        initComponents();

        try {
            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentsetname").queryString("id", studentname).asString();
            if (response.getStatus() == 200) {
                String anss = response.getBody();
//            System.out.println(anss);

                StringTokenizer st3 = new StringTokenizer(anss, ";;;");
                while (st3.hasMoreTokens()) {
                    String tname, dep, course, sem;
                    tname = st3.nextToken();

                    dep = st3.nextToken();

                    course = st3.nextToken();
                    course = course.toUpperCase();
                    sem = st3.nextToken();

//              photo1 = st3.nextToken(); 
                    department.setText(dep);
                    courselb.setText(course);
                    semlb.setText(sem);

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setSize(1025, 818);
        viewAssignment();
        setResizable(false);
        setTitle("Uni LMS Student View Assignments");
//        AssignmentPanel.setPreferredSize(new Dimension());
//        setIconImage(logo);
        setLocationRelativeTo(null);
    }

    private void viewAssignment() {
        try {

            String dept = department.getText();
            System.out.println(dept);
            String course = courselb.getText().toLowerCase();
            String sem = semlb.getText();

            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentviewassignment")
                    .queryString("depart", dept)
                    .queryString("course", course)
                    .queryString("sem", sem)
                    .asString();

            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "$$");
            int k = st.countTokens();
//            al.clear();

            AssignmentPanel obj[] = new AssignmentPanel[k];
            jPanel2.setPreferredSize(new Dimension(700, 220 * k));
            int x = 180, y = 10, i = 0;

            while (st.hasMoreTokens()) {
                String vnotes = st.nextToken();
                obj[i] = new AssignmentPanel();

                StringTokenizer st2 = new StringTokenizer(vnotes, ";;;");

                String id = st2.nextToken();
                String title = st2.nextToken();
                String details = st2.nextToken();

                String name = st2.nextToken();
                String date = st2.nextToken();
                String date2 = st2.nextToken();

                obj[i].title.setText(title);
                obj[i].sdlb.setText(date2);
                obj[i].btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//logic;
                    ViewAssignmentDetails obj = new ViewAssignmentDetails(id,name);
                    obj.setVisible(true);
                    }
                });
                obj[i].setBounds(x, y, 437, 190);
                jPanel2.add(obj[i]);
                y += 220;

//                al.add(new StudentAssignementDetails(id, title, details, name, date, date2));
                i++;
            }
            jPanel2.repaint();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        department = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        courselb = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        semlb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);
        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 220, 780, 430);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Department of");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(370, 30, 250, 40);

        department.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        department.setForeground(new java.awt.Color(255, 255, 255));
        department.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        department.setText("jLabel2");
        jPanel1.add(department);
        department.setBounds(370, 70, 250, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Course:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 160, 90, 20);

        courselb.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        courselb.setForeground(new java.awt.Color(255, 255, 255));
        courselb.setText("Course");
        jPanel1.add(courselb);
        courselb.setBounds(290, 160, 90, 20);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Semester:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(590, 160, 110, 20);

        semlb.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        semlb.setForeground(new java.awt.Color(255, 255, 255));
        semlb.setText("Semester");
        jPanel1.add(semlb);
        semlb.setBounds(700, 160, 110, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms (1).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(680, 670, 320, 110);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/back.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(0, 0, 50, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 50, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1010, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
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
            java.util.logging.Logger.getLogger(StudentViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentViewAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentViewAssignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courselb;
    private javax.swing.JLabel department;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel semlb;
    // End of variables declaration//GEN-END:variables
}
