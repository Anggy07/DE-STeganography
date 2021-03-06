/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author anggy
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    public view() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public String getMessage() {
        return message.getText();
    }

    public String getASCII() {
        return ascii.getText();
    }

    public String getSecretMessage() {
        return SecretMessage.getText();
    }

    public String getCoverData() {
        return CoverData.getText();
    }

    public String getStegoData() {
        return StegoData.getText();
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public void setASCII(String ascii) {
        this.ascii.setText(ascii);
    }

    public void setSecretMessage(String secret) {
        this.SecretMessage.setText(secret);
    }

    public void setCoverdata(String cover) {
        this.CoverData.setText(cover);
    }

    public void setStegodata(String stego) {
        this.StegoData.setText(stego);
    }
    public void addHide(ActionListener listener) {
        hide.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        hide = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        ascii = new javax.swing.JTextField();
        message = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        SecretMessage = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        StegoData = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CoverData = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Program Studi Sistem Informasi, Universitas Jember");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide.setText("Hide");
        hide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, 30));

        jLabel1.setFont(new java.awt.Font("Play", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stego data");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 90, -1));

        jLabel2.setFont(new java.awt.Font("Play", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Secret message :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, -1));

        jLabel4.setFont(new java.awt.Font("Play", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Message :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        jLabel5.setFont(new java.awt.Font("Play", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nilai ASCII :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));

        jLabel3.setFont(new java.awt.Font("Play", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cover Data");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, -1));
        getContentPane().add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 574, 130, 20));
        getContentPane().add(ascii, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 310, -1));
        getContentPane().add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 210, -1));

        SecretMessage.setColumns(20);
        SecretMessage.setRows(5);
        jScrollPane3.setViewportView(SecretMessage);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 410, 100));

        StegoData.setColumns(20);
        StegoData.setRows(5);
        jScrollPane2.setViewportView(StegoData);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 410, 240));

        CoverData.setColumns(20);
        CoverData.setRows(5);
        jScrollPane1.setViewportView(CoverData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 410, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setText("Program Studi Sistem Informasi, Universitas Jember");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 440, 20));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controller/kripto.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 900, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CoverData;
    private javax.swing.JTextArea SecretMessage;
    private javax.swing.JTextArea StegoData;
    private javax.swing.JLabel about;
    private javax.swing.JTextField ascii;
    private javax.swing.JLabel background;
    private javax.swing.JButton hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField message;
    // End of variables declaration//GEN-END:variables
}
