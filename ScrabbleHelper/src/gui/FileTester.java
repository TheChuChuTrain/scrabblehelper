/*
 * FileTester.java
 *
 * Created on November 12, 2007, 5:53 PM
 */
package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

/**
 *
 * @author  Nick
 */
public class FileTester extends javax.swing.JFrame {

    /** Creates new form FileTester */
    public FileTester() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Resource to search for:  ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jTextArea1.setText("");
        BufferedReader r = null;
        try {
            String text = jTextField1.getText();
            URL url = ClassLoader.getSystemClassLoader().getResource(text);//GEN-LAST:event_jTextField1ActionPerformed
            if (url == null) {
                jTextArea1.append("URL == null\n");
                return;
            }
            Object content = url.getContent();
            if (content == null) {
                jTextArea1.append("Content is null\n");
                return;
            }
            InputStreamReader isr = new InputStreamReader((InputStream)content);
            if (isr == null) {
                jTextArea1.append("NULL ISR\n");
            } else {
                char[] cbuf = new char[15];
                jTextArea1.append("isr.toString() == " + isr.toString() + "\n");
                //int eger = isr.read();
                //isr.read(cbuf);
                //jTextArea1.append("Int result: " + eger + "\n");
                r = new BufferedReader(isr);
                jTextArea1.append(r.readLine());
            }
            r = new BufferedReader(isr);
            //r = new BufferedReader(new InputStreamReader(url.openStream()));
            String temp;
            while ((temp = r.readLine()) != null) {
                jTextArea1.append(temp + "\n");
            }
        } catch (Exception ex) {
            StringWriter w = new StringWriter();
            PrintWriter pw = new PrintWriter(w);
            ex.printStackTrace(pw);
            jTextArea1.append(w.toString());
        } finally {
            try {
                jTextArea1.append("\n\nDone.  " + System.currentTimeMillis());
                r.close();
            } catch (IOException ex) {
                jTextArea1.append(ex.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        new FileTester().setVisible(true);
                    }
                });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}