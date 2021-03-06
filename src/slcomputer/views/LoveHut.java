/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.views;

import slcomputer.heros.Hero;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import slcomputer.main.SLComputer;

/**
 *
 * @author J
 */
public class LoveHut extends javax.swing.JDialog {

    /**
     * Creates new form LoveHut
     */
    public LoveHut(java.awt.Frame parent, boolean modal, Hero backHeros[]) {
        super(parent, modal);
        initComponents();
        TableColumn columnProperty = jTableHeros.getColumnModel().getColumn(2);
        String propertyOptions[]={"影忍", "超忍", "普通"};
        columnProperty.setCellEditor(new DefaultCellEditor(new JComboBox(propertyOptions)));
        Vector<Hero> heroOptions=new Vector<Hero>();
        for(int i=0; i<SLComputer.allHero.length; i++){
            if(SLComputer.allHero[i].id==SLComputer.allHero[i].hid){
                heroOptions.add(SLComputer.allHero[i]);
            }
        }
        columnProperty=jTableHeros.getColumnModel().getColumn(1);
        columnProperty.setCellEditor(new DefaultCellEditor(new JComboBox(heroOptions)));
        model=jTableHeros.getModel();
        heros=backHeros;
        int i;
        for(i=0; i<heros.length; i++){
            if(heros[i]!=null){
                model.setValueAt(heros[i], i, 1);
                if(heros[i].property_battle<10){
                    model.setValueAt(propertyOptions[2], i, 2);
                }
                else if(heros[i].property_battle<20){
                    model.setValueAt(propertyOptions[1], i, 2);
                }
                else{
                    model.setValueAt(propertyOptions[0], i, 2);
                }
                model.setValueAt((int)heros[i].att, i, 3);
                model.setValueAt((int)heros[i].def, i, 4);
            }
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHeros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("爱心小屋");

        jTableHeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null},
                { new Integer(2), null, null, null, null},
                { new Integer(3), null, null, null, null},
                { new Integer(4), null, null, null, null},
                { new Integer(5), null, null, null, null},
                { new Integer(6), null, null, null, null},
                { new Integer(7), null, null, null, null},
                { new Integer(8), null, null, null, null},
                { new Integer(9), null, null, null, null},
                { new Integer(10), null, null, null, null},
                { new Integer(11), null, null, null, null},
                { new Integer(12), null, null, null, null},
                { new Integer(13), null, null, null, null},
                { new Integer(14), null, null, null, null},
                { new Integer(15), null, null, null, null}
            },
            new String [] {
                "位置", "忍者", "属性", "攻击", "防御"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableHeros);

        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i;
        Hero h;
        String s;
        Object value;
        for(i=0; i<heros.length; i++){
            h=((Hero)model.getValueAt(i, 1));
            if(h==null || h.id==0){
                break;
            }
            heros[i]=h.dup();
            s=(String)model.getValueAt(i, 2);
            if(s==null || s.equals("普通")){
                heros[i].property_battle=0;
            }
            else if(s.equals("超忍")){
                heros[i].property_battle=10;
            }
            else{
                heros[i].property_battle=20;
            }
            value=model.getValueAt(i, 3);
            if(value==null){
                heros[i].att=100;
            }
            else{
                heros[i].att=(int)value;
            }
            value=model.getValueAt(i, 4);
            if(value==null){
                heros[i].def=100;
            }
            else{
                heros[i].def=(int)value;
            }
        }
        for(;i<heros.length; i++){
            heros[i]=null;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHeros;
    // End of variables declaration//GEN-END:variables
    private Hero heros[];
    TableModel model;
}
