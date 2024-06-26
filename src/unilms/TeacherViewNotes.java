/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unilms;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tushar
 */
public class TeacherViewNotes extends javax.swing.JFrame {

    /**
     * Creates new form TeacherViewNotes
     */
    String teachername = GlobalClass.loggedinteacher;
    ImageIcon ic = new ImageIcon("src/Uni Lms.png");

    ArrayList<NotesDetails> al;
    mytablemodel4 tm4;
    public TeacherViewNotes() {
        initComponents();
        try
        {
            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"teachersetname").queryString("id", teachername).asString(); 
            if(response.getStatus()==200)
            {
            String anss = response.getBody();
//            System.out.println(anss);

            StringTokenizer st3 = new StringTokenizer(anss, ";;;");
            while (st3.hasMoreTokens()) {
                String tname,dep;
                tname = st3.nextToken();
                tname= tname.toUpperCase();
                dep = st3.nextToken();

//              photo1 = st3.nextToken(); 

             name.setText(tname+"!");
             department.setText(dep);

            }
         
            }
        }
        
        catch (Exception ex) 
        {
                ex.printStackTrace();
       }  
        fetchcourse();
        al = new ArrayList<>();
        tm4 = new mytablemodel4();
        jTable1.setModel(tm4);
        setSize(1235, 900);
        setResizable(false);
        setLocationRelativeTo(null);     
    }
    
    
    private void fetchnotes()
    {
        try
        {
            String dept = department.getText();
            String course = ccb.getSelectedItem().toString();
            String sem = semcb.getSelectedItem().toString();
            
            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"teacherviewnotes")
                    .queryString("id",teachername)
                    .queryString("dept",dept)
                    .queryString("course",course)
                    .queryString("sem",sem)
                    .asString();
            
            
            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans,"$$");
            al.clear();
            
            while(st.hasMoreTokens())
            {
                String vnotes = st.nextToken();
                StringTokenizer st2 = new StringTokenizer(vnotes,";;;");
                
                String notesid = st2.nextToken();
                String cn = st2.nextToken();
                String semester = st2.nextToken();
                String title = st2.nextToken();
                String details = st2.nextToken();
                String type = st2.nextToken();
                String file = st2.nextToken();
                String date = st2.nextToken();
                
                
                al.add(new NotesDetails(notesid, cn, semester, title, details, type, file, date));
                
            }
            tm4.fireTableDataChanged();
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        
    }
    
    class mytablemodel4 extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 8;
        }

         public String getColumnName(int j) {
            String c[] = {"Notes Id", "Course Name", "Semester", "Title","Details","type"
            ,"Date and Time", "File Location"};
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {

            if (j == 0) {
                return al.get(i).notes;
            } else if (j == 1) {
                return al.get(i).cn;
            } else if (j == 2) {
                return al.get(i).semester;
            } 
            else if (j==3)
            {
                return al.get(i).title;
            }
            else if(j==4)
            {
                return al.get(i).details;
            }
            else if(j==5)
            {
                return al.get(i).type;
            }
            else if(j==6)
            {
                return al.get(i).file;
            }
            else {
                return al.get(i).date;
            }

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
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        department = new javax.swing.JLabel();
        ccb = new javax.swing.JComboBox<>();
        semcb = new javax.swing.JComboBox<>();
        fetchbt = new javax.swing.JButton();
        deletebt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 270, 1140, 480);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(510, -10, 130, 50);

        name.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        name.setForeground(new java.awt.Color(51, 51, 51));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("CHANDPREET SINGH!");
        jPanel1.add(name);
        name.setBounds(390, 20, 370, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Department of");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(450, 60, 250, 40);

        department.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        department.setForeground(new java.awt.Color(51, 51, 51));
        department.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        department.setText("jLabel2");
        jPanel1.add(department);
        department.setBounds(450, 100, 250, 40);

        ccb.setBackground(new java.awt.Color(255, 255, 255));
        ccb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ccb.setForeground(new java.awt.Color(51, 51, 51));
        ccb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        ccb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ccbItemStateChanged(evt);
            }
        });
        jPanel1.add(ccb);
        ccb.setBounds(190, 180, 380, 40);

        semcb.setBackground(new java.awt.Color(255, 255, 255));
        semcb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        semcb.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(semcb);
        semcb.setBounds(580, 180, 380, 40);

        fetchbt.setBackground(new java.awt.Color(255, 255, 255));
        fetchbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-view-48.png"))); // NOI18N
        fetchbt.setBorder(null);
        fetchbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fetchbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchbtActionPerformed(evt);
            }
        });
        jPanel1.add(fetchbt);
        fetchbt.setBounds(970, 160, 60, 60);

        deletebt.setBackground(new java.awt.Color(255, 255, 255));
        deletebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-delete-64.png"))); // NOI18N
        deletebt.setBorder(null);
        deletebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtActionPerformed(evt);
            }
        });
        jPanel1.add(deletebt);
        deletebt.setBounds(580, 766, 64, 64);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Select Course");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 160, 130, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Select Semester");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(580, 160, 130, 20);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Download");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1040, 220, 60, 17);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/download-floppy-data.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1040, 160, 60, 60);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Show");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(970, 220, 60, 17);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/back.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(0, 0, 50, 50);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delete");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(580, 830, 60, 16);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Back");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(-3, 50, 60, 16);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(920, 0, 300, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1220, 870);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        private void fetchcourse()
    {
        System.out.println("Hello im function");
         new Thread(new Runnable() {
            @Override
            public void run() {

                String depart = department.getText();
                try {
                    ccb.removeAllItems();

                    HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"getcourse").queryString("depart", depart).asString();

                    //  System.out.println(ans4);
                    if (response.getStatus() == 200) {
                        ccb.removeAllItems();
                        String ans4 = response.getBody();

                        StringTokenizer st4 = new StringTokenizer(ans4, "#$#");
                        while (st4.hasMoreTokens()) {

                            ccb.addItem(st4.nextToken());
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();
    }
    
    private void fetchsemester()
    {
        System.out.println("called");
      new Thread(new Runnable() {
            @Override
            public void run() {
                String course = ccb.getSelectedItem().toString();
                System.out.println("course---"+course);
                String de = department.getText();
                try {
                    HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"getsemester").queryString("course", course).queryString("de", de).asString();
                    if (response.getStatus() == 200) {
                        semcb.removeAllItems();
                        String ans5 = response.getBody();

                        StringTokenizer st5 = new StringTokenizer(ans5, "#$#$");
                        while (st5.hasMoreTokens()) {

                            semcb.addItem(st5.nextToken());
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();  
    }
    private void ccbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ccbItemStateChanged
        // TODO add your handling code
        fetchsemester();
    }//GEN-LAST:event_ccbItemStateChanged

    private void fetchbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchbtActionPerformed
        // TODO add your handling code here:
        fetchnotes();
    }//GEN-LAST:event_fetchbtActionPerformed

    private void deletebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtActionPerformed
        // TODO add your handling code here:
        
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Row Selected");

        } else 
        {
            int sel = JOptionPane.showConfirmDialog(this, "Are You Sure You Want to Delete", "Uni LMS Delete Confirm Dialog Box", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, ic);
            if(sel==JOptionPane.YES_OPTION)
            {
            
            String notes = al.get(row).notes;


//            System.out.println(row);
//            System.out.println(course);
//            System.out.println(se);
//            System.out.println(de);
            try {
                HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"teacherdeletenotes")
                        .queryString("notesid", notes).asString();

                if (response.getStatus() == 200) {
                    String feedback3 = response.getBody();
                    if (feedback3.equals("Notes Deleted !!!")) {
                        JOptionPane.showMessageDialog(this, "Notes Deleted");
                        fetchnotes();

                    } else {
                        System.out.println(response.getStatusText());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
            else
            {
                JOptionPane.showMessageDialog(this, "Delete Cancelled");
            }
        }
        
    }//GEN-LAST:event_deletebtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if (index == -1) {

        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    FileOutputStream fos = null;
                    try {
                        String filepath = al.get(index).file;
                        HttpResponse<InputStream> HttpResponse = Unirest.get(GlobalClass.serverAddress+"getresource/" + filepath).asBinary();
                        String filename = filepath.substring(filepath.lastIndexOf("/"));
                        InputStream is = HttpResponse.getBody();
                        fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + filename);
                        String downloadfile = System.getProperty("user.home") + "/Downloads/" + filename;
                        System.out.println("path---------  "+downloadfile);
                        long contentlength = Integer.parseInt(HttpResponse.getHeaders().getFirst("Content-Length"));
                        byte b[] = new byte[10000];
                        int r;
                        long count = 0;
                        while (true) {
                            r = is.read(b, 0, 10000);
                            fos.write(b, 0, r);
                            count = count + r;
                            int per = (int) (count * 100 / contentlength);
                            if (count == contentlength) {
                                break;
                            }
                        }
                        fos.close();
//                        JOptionPane.showMessageDialog(rootPane, "file downloaded");
                        JOptionPane.showMessageDialog(rootPane, "File Downloaded", "UNI LMS Teacher View Notes", JOptionPane.PLAIN_MESSAGE, ic);
                        Desktop.getDesktop().open(new File(downloadfile));
                    } catch (Exception ex) {
                        ex.printStackTrace();

                    } finally {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }).start();
        }
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
            java.util.logging.Logger.getLogger(TeacherViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherViewNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ccb;
    private javax.swing.JButton deletebt;
    private javax.swing.JLabel department;
    private javax.swing.JButton fetchbt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox<String> semcb;
    // End of variables declaration//GEN-END:variables
}
