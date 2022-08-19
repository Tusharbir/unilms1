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
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tushar
 */
public class ViewAssignmentDetails extends javax.swing.JFrame {

    /**
     * Creates new form ViewAssignmentDetails
     *
     * @param id
     */
    String date2;
    String id = "";
    String name = "";
    String filetype;
    File file;
    String studentname = GlobalClass.loggedinstudent;
    ImageIcon ic = new ImageIcon("src/Uni Lms.png");

    public ViewAssignmentDetails(String id, String name) {
        initComponents();
        this.id = id;
        this.name = name;
//        settings.set

        viewAssignmentDetails();

        setSize(990, 660);
        setResizable(false);
        setTitle("Uni LMS Student Assignment Submission");
        setLocationRelativeTo(null);

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
        assdate2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        asstitle = new javax.swing.JLabel();
        assdetails = new javax.swing.JLabel();
        assdate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        assid = new javax.swing.JLabel();
        downloadbt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        browsebt = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbphoto = new javax.swing.JLabel();
        lbpath = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        submitbt = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbpath1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Submission Date");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 100, 180, 30);

        assdate2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        assdate2.setForeground(new java.awt.Color(51, 51, 51));
        assdate2.setText("Assignment Id");
        jPanel1.add(assdate2);
        assdate2.setBounds(540, 130, 280, 24);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Details");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 310, 180, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Date Uploaded");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 410, 180, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Teacher Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 100, 160, 30);

        namelb.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        namelb.setForeground(new java.awt.Color(51, 51, 51));
        namelb.setText("Assignment Id");
        jPanel1.add(namelb);
        namelb.setBounds(80, 140, 270, 20);

        asstitle.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        asstitle.setForeground(new java.awt.Color(51, 51, 51));
        asstitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asstitle.setText("Title");
        jPanel1.add(asstitle);
        asstitle.setBounds(50, 0, 870, 60);

        assdetails.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        assdetails.setForeground(new java.awt.Color(51, 51, 51));
        assdetails.setText("Assignment Id");
        jPanel1.add(assdetails);
        assdetails.setBounds(80, 340, 280, 20);

        assdate.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        assdate.setForeground(new java.awt.Color(51, 51, 51));
        assdate.setText("Assignment Id");
        jPanel1.add(assdate);
        assdate.setBounds(80, 450, 270, 24);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Assignment Id");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 200, 180, 30);

        assid.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        assid.setForeground(new java.awt.Color(51, 51, 51));
        assid.setText("Assignment Id");
        jPanel1.add(assid);
        assid.setBounds(80, 240, 280, 20);

        downloadbt.setBackground(new java.awt.Color(255, 255, 255));
        downloadbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/download-floppy-data.png"))); // NOI18N
        downloadbt.setBorder(null);
        downloadbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downloadbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadbtActionPerformed(evt);
            }
        });
        jPanel1.add(downloadbt);
        downloadbt.setBounds(870, 90, 60, 60);

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(540, 160, 280, 10);

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(80, 170, 280, 10);

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(80, 270, 280, 10);

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(80, 370, 280, 10);

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(80, 480, 280, 10);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Download");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(870, 150, 60, 16);

        jLabel3.setFont(new java.awt.Font("Roboto Slab Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("SUBMISSION AREA");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(540, 230, 340, 40);

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(540, 270, 420, 10);

        browsebt.setBackground(new java.awt.Color(255, 255, 255));
        browsebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/icons8-browse-64.png"))); // NOI18N
        browsebt.setBorder(null);
        browsebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        browsebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsebtActionPerformed(evt);
            }
        });
        jPanel1.add(browsebt);
        browsebt.setBounds(810, 290, 70, 70);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Submit");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(680, 470, 80, 20);

        lbphoto.setForeground(java.awt.Color.white);
        lbphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbphoto);
        lbphoto.setBounds(540, 330, 32, 32);

        lbpath.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbpath.setForeground(new java.awt.Color(51, 51, 51));
        lbpath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbpath.setText("Back");
        jPanel1.add(lbpath);
        lbpath.setBounds(0, 40, 50, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Only PDF Files*");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(810, 360, 90, 20);

        submitbt.setBackground(new java.awt.Color(255, 255, 255));
        submitbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/upload.png"))); // NOI18N
        submitbt.setBorder(null);
        submitbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtActionPerformed(evt);
            }
        });
        jPanel1.add(submitbt);
        submitbt.setBounds(680, 400, 90, 70);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Select File");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(540, 290, 190, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/Uni Lms.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(670, 520, 310, 100);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unilms/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(0, 0, 50, 40);

        lbpath1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbpath1.setForeground(new java.awt.Color(51, 51, 51));
        lbpath1.setText("File Name Will Appear Here");
        jPanel1.add(lbpath1);
        lbpath1.setBounds(580, 330, 210, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 980, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadbtActionPerformed



            new Thread(new Runnable() {
                @Override
                public void run() {

                    FileOutputStream fos = null;
                    try {
                        HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentdownloadassignment")
                    .queryString("id", id)
                    .asString();

                        String ans = response.getBody();
                        String filepath = ans;
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
                        JOptionPane.showMessageDialog(rootPane, "File Downloaded", "UNI LMS Teacher View Assignment", JOptionPane.PLAIN_MESSAGE, ic);
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
        
    }//GEN-LAST:event_downloadbtActionPerformed

    private void browsebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsebtActionPerformed
        // TODO add your handling code here:

        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filterpdf = new FileNameExtensionFilter("Pdf Files", "pdf");
        //        FileNameExtensionFilter filteraudio = new FileNameExtensionFilter("Audio Files", "mp3");
        //        FileNameExtensionFilter filtervideo = new FileNameExtensionFilter("Video Files", "mp4");
        jfc.setAcceptAllFileFilterUsed(false);
        ImageIcon icon = null;

        jfc.setFileFilter(filterpdf);
        icon = new ImageIcon("src/pdf-file.png");
        filetype = "Pdf";

        int showOpenDialog = jfc.showOpenDialog(this);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            lbpath.setText(file.getName());
            lbphoto.setIcon(icon);
        }
    }//GEN-LAST:event_browsebtActionPerformed

    private void submitbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Date d = new Date();
            String date = sdf.format(d);

            Date d2 = sdf.parse(date2);
            if (d.compareTo(d2) > 0) {
                JOptionPane.showMessageDialog(rootPane, "error");
            } else {
                //send request 

                if (file != null) {

                    try {

                        HttpResponse<String> response = Unirest.post(GlobalClass.serverAddress+"studentsubmitassignment")
                                .queryString("assid", id)
                                .queryString("studentid", studentname)
                                .queryString("date", date)
                                .field("file", file).asString();

                        if (response.getStatus() == 200) {

                            String feedback5 = response.getBody();
                            if (feedback5.equals("Fails!!!")) {
                                //                        JOptionPane.showMessageDialog(this, "Fails!!!");
                                JOptionPane.showMessageDialog(this, """
                                                                                        !!! OOPS !!!
                                                                                        Error Occured
                                                                                        !!! Try Again !!!""", "Uni LMS Student Assignment Submission", JOptionPane.PLAIN_MESSAGE, ic);
                            } else {
                                //                       String output = "Your Output is";
                                //                        JOptionPane.showMessageDialog(this, "Your Student Id: " + feedback5 + "\n Your Password is: " + pass2);
                                JOptionPane.showMessageDialog(this, """
                                                                                        !!! Done !!!
                                                                                        Assignment Submitted
                                                                                        \nReference Submission Id Generated:""" + feedback5,
                                        "Uni LMS Teacher Add ASsignment", JOptionPane.PLAIN_MESSAGE, ic);

                                //                        department.setText(null);
                            }
                        } else {
                            System.out.println(response.getStatusText());
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, """
                                                                !!! OOPS !!!
                                                                Empty Field Exists
                                                                !!! All Fields are Required !!!""", "Uni LMS Teacher Add Notes", JOptionPane.PLAIN_MESSAGE, ic);
                }
            }
            //            SimpleDateFormat(");

            //            String select = buttonGroup1.getSelection().toString();
            //            System.out.println(select);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_submitbtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewAssignmentDetails() {
        try {

            HttpResponse<String> response = Unirest.get(GlobalClass.serverAddress+"studentviewassignmentdetails")
                    .queryString("id", id)
                    .asString();

            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "$$");

            while (st.hasMoreTokens()) {

                String vnotes = st.nextToken();
                StringTokenizer st2 = new StringTokenizer(vnotes, ";;;");

                String asid = st2.nextToken();
                String title = st2.nextToken();
                String details = st2.nextToken();
                

                String date = st2.nextToken();
                date2 = st2.nextToken();
                

                namelb.setText(name);
                assid.setText(asid);
                asstitle.setText(title);
                assdetails.setText(details);
                assdate.setText(date);
                assdate2.setText(date2);
                

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
            java.util.logging.Logger.getLogger(ViewAssignmentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAssignmentDetails("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assdate;
    private javax.swing.JLabel assdate2;
    private javax.swing.JLabel assdetails;
    private javax.swing.JLabel assid;
    private javax.swing.JLabel asstitle;
    private javax.swing.JButton browsebt;
    private javax.swing.JButton downloadbt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbpath;
    private javax.swing.JLabel lbpath1;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel namelb;
    private javax.swing.JButton submitbt;
    // End of variables declaration//GEN-END:variables
}
