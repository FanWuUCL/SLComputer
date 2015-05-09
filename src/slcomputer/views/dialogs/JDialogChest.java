/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.views.dialogs;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import slcomputer.main.SLComputer;
import slcomputer.runnable.SocketMaster;

/**
 *
 * @author J
 */
public class JDialogChest extends javax.swing.JDialog {

    /**
     * Creates new form JDialogChest
     */
    public JDialogChest(java.awt.Frame parent, boolean modal, int g, int s, int c) {
        super(parent, modal);
        initComponents();
        jCheckBoxGolden.setText("金钥匙*"+g);
        jCheckBoxSilver.setText("银钥匙*"+s);
        jCheckBoxCopper.setText("铜钥匙*"+c);
        Dimension d=getPreferredSize();
        Rectangle b=parent.getBounds();
        setBounds(b.x+b.width/3-d.width/2, b.y+b.height/2-d.height/2, d.width, d.height);
        setVisible(true);
    }
    
    public void progress(String str, int p, int g, int s, int c){
        jTextAreaShow.setText(str);
        jProgressBar1.setValue(p);
        jCheckBoxGolden.setText("金钥匙*"+g);
        jCheckBoxSilver.setText("银钥匙*"+s);
        jCheckBoxCopper.setText("铜钥匙*"+c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxGolden = new javax.swing.JCheckBox();
        jCheckBoxSilver = new javax.swing.JCheckBox();
        jCheckBoxCopper = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButtonOpen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaShow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("开宝箱");

        jCheckBoxGolden.setText("金钥匙");

        jCheckBoxSilver.setText("银钥匙");

        jCheckBoxCopper.setText("铜钥匙");

        jProgressBar1.setStringPainted(true);

        jButtonOpen.setText("开");
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jTextAreaShow.setColumns(20);
        jTextAreaShow.setRows(5);
        jScrollPane1.setViewportView(jTextAreaShow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCopper)
                            .addComponent(jCheckBoxGolden)
                            .addComponent(jCheckBoxSilver))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxGolden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxSilver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxCopper))
                    .addComponent(jButtonOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        int num=0;
        if(jCheckBoxCopper.isSelected()){
            num+=SocketMaster.character.numCopperKey;
        }
        if(jCheckBoxSilver.isSelected()){
            num+=SocketMaster.character.numSilverKey;
        }
        if(jCheckBoxGolden.isSelected()){
            num+=SocketMaster.character.numGoldenKey;
        }
        if(num<=0){
            JOptionPane.showMessageDialog(SLComputer.mf, "无钥匙可开。", "钥匙", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        SocketMaster.cmdGlobal=SocketMaster.c_chest_open;
        SocketMaster.arguments[0]=jCheckBoxCopper.isSelected();
        SocketMaster.arguments[1]=jCheckBoxSilver.isSelected();
        SocketMaster.arguments[2]=jCheckBoxGolden.isSelected();
        SocketMaster.arguments[3]=this;
        SocketMaster.arguments[4]=num;
        SocketMaster sm=new SocketMaster();
        new Thread(sm).start();
    }//GEN-LAST:event_jButtonOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JCheckBox jCheckBoxCopper;
    private javax.swing.JCheckBox jCheckBoxGolden;
    private javax.swing.JCheckBox jCheckBoxSilver;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaShow;
    // End of variables declaration//GEN-END:variables
}
