/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.dialogs;

import java.awt.Dimension;
import java.awt.Rectangle;
import slcomputer.SLComputer;

/**
 *
 * @author J
 */
public class JDialogAutoProgress extends javax.swing.JDialog implements Runnable {

    /**
     * Creates new form JDialogAutoProgress
     */
    public JDialogAutoProgress(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        stopFlag=false;
        status=0;
        Dimension d=getPreferredSize();
        Rectangle b=parent.getBounds();
        setBounds(b.x+b.width/3-d.width/2, b.y+b.height/2-d.height/2, d.width, d.height);
    }
    
    public void run(){
        setVisible(true);
    }
    
    public void append(String line){
        jTextAreaProgress.append(line+"\n");
        jTextAreaProgress.setCaretPosition(jTextAreaProgress.getText().length());
    }
    
    public boolean stop(){
        return stopFlag;
    }
    
    public void setStop(){
        stopFlag=true;
        jButtonStop.setText("退出");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaProgress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("试炼进度");

        jButtonStop.setText("中止");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jTextAreaProgress.setEditable(false);
        jTextAreaProgress.setColumns(20);
        jTextAreaProgress.setLineWrap(true);
        jTextAreaProgress.setRows(5);
        jTextAreaProgress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaProgress);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonStop)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if(!stopFlag){
            setStop();
        }
        else{
            if(status!=0){
                SLComputer.cleanLogin();
            }
            dispose();
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private boolean stopFlag;
    public int status;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaProgress;
    // End of variables declaration//GEN-END:variables
}
