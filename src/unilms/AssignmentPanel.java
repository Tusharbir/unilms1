/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package unilms;

/**
 *
 * @author tushar
 */
public class AssignmentPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignmentPanel
     */
    public AssignmentPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        tnlb = new javax.swing.JLabel();
        sdlb = new javax.swing.JLabel();
        btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(69, 85, 96));
        setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf-file (1).png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 40, 50, 60);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Submission Date:");
        add(jLabel2);
        jLabel2.setBounds(90, 90, 140, 21);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Teacher Name:");
        add(jLabel3);
        jLabel3.setBounds(90, 60, 130, 21);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Title:");
        add(jLabel4);
        jLabel4.setBounds(90, 30, 130, 21);

        title.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("Assignment No:");
        add(title);
        title.setBounds(240, 30, 220, 21);

        tnlb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tnlb.setForeground(new java.awt.Color(255, 255, 255));
        tnlb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tnlb.setText("Teacher Name:");
        add(tnlb);
        tnlb.setBounds(240, 60, 220, 21);

        sdlb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sdlb.setForeground(new java.awt.Color(255, 255, 255));
        sdlb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sdlb.setText("Submission Date:");
        add(sdlb);
        sdlb.setBounds(240, 90, 220, 21);

        btn.setBackground(java.awt.SystemColor.windowText);
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/read.png"))); // NOI18N
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btn);
        btn.setBounds(190, 130, 50, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("View Assignment");
        add(jLabel5);
        jLabel5.setBounds(170, 170, 90, 16);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel sdlb;
    public javax.swing.JLabel title;
    public javax.swing.JLabel tnlb;
    // End of variables declaration//GEN-END:variables
}
