/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import java.awt.Dimension;
import slcomputer.equip.Equip;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author J
 */
public class JDialogHeroChooser extends javax.swing.JDialog {

    /**
     * Creates new form JDialogHeroChooser
     */
    public JDialogHeroChooser(java.awt.Frame parent, boolean modal, int index, JButton button) {
        super(parent, modal);
        this.index=index;
        source=button;
        initComponents();
        if(SLComputer.dreamMode){
            setIconImage(new ImageIcon("TP/meng.png").getImage());
        }
        else{
            setIconImage(new ImageIcon("TP/jian.png").getImage());
        }
        jListHeros.setModel(new DefaultComboBoxModel(SLComputer.allHero));
        jComboBoxWeapon.setModel(new DefaultComboBoxModel(SLComputer.allEquiqAtt));
        jComboBoxShield.setModel(new DefaultComboBoxModel(SLComputer.allEquiqDef));
        jComboBoxPact.setModel(new DefaultComboBoxModel(SLComputer.allEqpTf));
        jComboBoxProperty.setSelectedIndex(1);
        jTextFieldResist.setText("0");
        Hero h=SLComputer.myTeam.heros[index];
        int i, j;
        if(h!=null){
            for(i=0; i<SLComputer.allHero.length; i++){
                if(h.id==SLComputer.allHero[i].id){
                    jListHeros.setSelectedIndex(i);
                    break;
                }
            }
            jTextFieldHero.setText(""+h.level);
            for(i=0; i<SLComputer.allEquiqAtt.length; i++){
                if(h.weapon.id==SLComputer.allEquiqAtt[i].id){
                    jComboBoxWeapon.setSelectedIndex(i);
                    break;
                }
            }
            jTextFieldWeapon.setText(""+h.weapon.level);
            jComboBoxWD0.setSelectedIndex(h.weapon.diamond[0]);
            jComboBoxWDLevel0.setSelectedIndex(h.weapon.diamondLevel[0]);
            jComboBoxWD1.setSelectedIndex(h.weapon.diamond[1]);
            jComboBoxWDLevel1.setSelectedIndex(h.weapon.diamondLevel[1]);
            jComboBoxWD2.setSelectedIndex(h.weapon.diamond[2]);
            jComboBoxWDLevel2.setSelectedIndex(h.weapon.diamondLevel[2]);
            jComboBoxWD3.setSelectedIndex(h.weapon.diamond[3]);
            jComboBoxWDLevel3.setSelectedIndex(h.weapon.diamondLevel[3]);
            for(j=0; j<3; j++){
                if(h.weapon.hideProperty[j]!=0){
                    break;
                }
            }
            switch(j){
                case 0:
                    jCheckBoxWProperty.setText("攻击提高"+(int)h.weapon.hideProperty[0]);
                    break;
                case 1:
                    jCheckBoxWProperty.setText("防御提高"+(int)h.weapon.hideProperty[1]);
                    break;
                default:
                    jCheckBoxWProperty.setText("忍术几率提高"+(int)h.weapon.hideProperty[2]+"%");
                    break;
            }
            if(j<3){
                jCheckBoxWProperty.setEnabled(true);
                jCheckBoxWProperty.setSelected(h.weapon.propertyEnabled);
            }
            else{
                jCheckBoxWProperty.setSelected(false);
                jCheckBoxWProperty.setEnabled(false);
            }
            for(i=0; i<SLComputer.allEquiqDef.length; i++){
                if(h.shield.id==SLComputer.allEquiqDef[i].id){
                    jComboBoxShield.setSelectedIndex(i);
                    break;
                }
            }
            jTextFieldShield.setText(""+h.shield.level);
            jComboBoxSD0.setSelectedIndex(h.shield.diamond[0]);
            jComboBoxSDLevel0.setSelectedIndex(h.shield.diamondLevel[0]);
            jComboBoxSD1.setSelectedIndex(h.shield.diamond[1]);
            jComboBoxSDLevel1.setSelectedIndex(h.shield.diamondLevel[1]);
            jComboBoxSD2.setSelectedIndex(h.shield.diamond[2]);
            jComboBoxSDLevel2.setSelectedIndex(h.shield.diamondLevel[2]);
            jComboBoxSD3.setSelectedIndex(h.shield.diamond[3]);
            jComboBoxSDLevel3.setSelectedIndex(h.shield.diamondLevel[3]);
            for(j=0; j<3; j++){
                if(h.shield.hideProperty[j]!=0){
                    break;
                }
            }
            switch(j){
                case 0:
                    jCheckBoxSProperty.setText("攻击提高"+(int)h.shield.hideProperty[0]);
                    break;
                case 1:
                    jCheckBoxSProperty.setText("防御提高"+(int)h.shield.hideProperty[1]);
                    break;
                default:
                    jCheckBoxSProperty.setText("忍术几率提高"+(int)h.shield.hideProperty[2]+"%");
                    break;
            }
            if(j<3){
                jCheckBoxSProperty.setEnabled(true);
                jCheckBoxSProperty.setSelected(h.shield.propertyEnabled);
            }
            else{
                jCheckBoxSProperty.setSelected(false);
                jCheckBoxSProperty.setEnabled(false);
            }
            for(i=0; i<SLComputer.allEqpTf.length; i++){
                if(h.pact.id==SLComputer.allEqpTf[i].id){
                    jComboBoxPact.setSelectedIndex(i);
                    break;
                }
            }
            jTextFieldPact.setText(""+h.pact.level);
            jComboBoxPD0.setSelectedIndex(h.pact.diamond[0]);
            jComboBoxPDLevel0.setSelectedIndex(h.pact.diamondLevel[0]);
            jComboBoxPD1.setSelectedIndex(h.pact.diamond[1]);
            jComboBoxPDLevel1.setSelectedIndex(h.pact.diamondLevel[1]);
            jComboBoxPD2.setSelectedIndex(h.pact.diamond[2]);
            jComboBoxPDLevel2.setSelectedIndex(h.pact.diamondLevel[2]);
            jComboBoxPD3.setSelectedIndex(h.pact.diamond[3]);
            jComboBoxPDLevel3.setSelectedIndex(h.pact.diamondLevel[3]);
            for(j=0; j<3; j++){
                if(h.pact.hideProperty[j]!=0){
                    break;
                }
            }
            switch(j){
                case 0:
                    jCheckBoxPProperty.setText("攻击提高"+(int)h.pact.hideProperty[0]);
                    break;
                case 1:
                    jCheckBoxPProperty.setText("防御提高"+(int)h.pact.hideProperty[1]);
                    break;
                default:
                    jCheckBoxPProperty.setText("忍术几率提高"+(int)h.pact.hideProperty[2]+"%");
                    break;
            }
            if(j<3){
                jCheckBoxPProperty.setEnabled(true);
                jCheckBoxPProperty.setSelected(h.pact.propertyEnabled);
            }
            else{
                jCheckBoxPProperty.setSelected(false);
                jCheckBoxPProperty.setEnabled(false);
            }
            jComboBoxProperty.setSelectedIndex(propertyToIndex(h.property_battle));
            double powerFromPet=0;
            if(h.property_battle==20){
                for(i=0; i<SLComputer.myTeam.powerUpbyProperty.length; i++){
                    if(powerFromPet<SLComputer.myTeam.powerUpbyProperty[i]){
                        powerFromPet=SLComputer.myTeam.powerUpbyProperty[i];
                    }
                }
            }
            else{
                powerFromPet=SLComputer.myTeam.powerUpbyProperty[h.property_battle%5];
            }
            jTextFieldPotential.setText(""+(int)h.potential);
            jTextFieldResist.setText(""+h.resist);
            
            jTextFieldAtt.setText(""+(int)h.attSet);
            jTextFieldDef.setText(""+(int)h.defSet);
            jTextFieldWeaponAtt.setText(""+(int)h.weaponAttSet);
            jTextFieldWeaponDef.setText(""+(int)h.weaponDefSet);
            jTextFieldWeaponTf.setText(""+(int)h.weaponTfSet);
            jTextFieldWeaponEff.setText(""+h.weaponEffSet);
            jTextFieldShieldAtt.setText(""+(int)h.shieldAttSet);
            jTextFieldShieldDef.setText(""+(int)h.shieldDefSet);
            jTextFieldShieldTf.setText(""+(int)h.shieldTfSet);
            jTextFieldShieldEff.setText(""+h.shieldEffSet);
            jTextFieldPactAtt.setText(""+(int)h.pactAttSet);
            jTextFieldPactDef.setText(""+(int)h.pactDefSet);
            jTextFieldPactTf.setText(""+(int)h.pactTfSet);
            jTextFieldPactEff.setText(""+h.pactEffSet);
            
            fillSkills(jComboBoxSkill1, h.backupSkills);
            
            if(h.skillIndex1>=0){
                jComboBoxSkill1.setSelectedIndex(h.skillIndex1+1);
                //jTextAreaSkill1.setText(h.backupSkills[h.skillIndex1].description(SLComputer.myTeam.skillPower*100+h.powerRatio, powerFromPet/100, 0, SLComputer.myTeam.skillRateMultiply+h.rateRatio/100));
            }
            fillSkills(jComboBoxSkill2, h.backupSkills);
            if(h.skillIndex2>=0){
                jComboBoxSkill2.setSelectedIndex(h.skillIndex2+1);
                //jTextAreaSkill2.setText(h.backupSkills[h.skillIndex2].description(SLComputer.myTeam.skillPower*100+h.powerRatio, powerFromPet/100, 0, SLComputer.myTeam.skillRateMultiply+h.rateRatio/100));
            }
        }
        else{
            jComboBoxWeaponActionPerformed(null);
            jComboBoxShieldActionPerformed(null);
            jComboBoxPactActionPerformed(null);
            jListHeros.setSelectedIndex(0);
        }
        if(SLComputer.dreamMode){
            jTextFieldAtt.setEnabled(false);
            jTextFieldDef.setEnabled(false);
            jTextFieldWeaponAtt.setEnabled(false);
            jTextFieldWeaponDef.setEnabled(false);
            jTextFieldWeaponTf.setEnabled(false);
            jTextFieldWeaponEff.setEnabled(false);
            jTextFieldShieldAtt.setEnabled(false);
            jTextFieldShieldDef.setEnabled(false);
            jTextFieldShieldTf.setEnabled(false);
            jTextFieldShieldEff.setEnabled(false);
            jTextFieldPactAtt.setEnabled(false);
            jTextFieldPactDef.setEnabled(false);
            jTextFieldPactTf.setEnabled(false);
            jTextFieldPactEff.setEnabled(false);
        }
        else{
            jTextFieldHero.setEnabled(false);
            jTextFieldPotential.setEnabled(false);
            jTextFieldWeapon.setEnabled(false);
            jComboBoxWD0.setEnabled(false);
            jComboBoxWDLevel0.setEnabled(false);
            jComboBoxWD1.setEnabled(false);
            jComboBoxWDLevel1.setEnabled(false);
            jComboBoxWD2.setEnabled(false);
            jComboBoxWDLevel2.setEnabled(false);
            jComboBoxWD3.setEnabled(false);
            jComboBoxWDLevel3.setEnabled(false);
            jTextFieldShield.setEnabled(false);
            jComboBoxSD0.setEnabled(false);
            jComboBoxSDLevel0.setEnabled(false);
            jComboBoxSD1.setEnabled(false);
            jComboBoxSDLevel1.setEnabled(false);
            jComboBoxSD2.setEnabled(false);
            jComboBoxSDLevel2.setEnabled(false);
            jComboBoxSD3.setEnabled(false);
            jComboBoxSDLevel3.setEnabled(false);
            jTextFieldPact.setEnabled(false);
            jComboBoxPD0.setEnabled(false);
            jComboBoxPDLevel0.setEnabled(false);
            jComboBoxPD1.setEnabled(false);
            jComboBoxPDLevel1.setEnabled(false);
            jComboBoxPD2.setEnabled(false);
            jComboBoxPDLevel2.setEnabled(false);
            jComboBoxPD3.setEnabled(false);
            jComboBoxPDLevel3.setEnabled(false);
        }
        Dimension d=getPreferredSize();
        Rectangle b=SLComputer.mf.getBounds();
        setBounds(b.x+b.width/3-d.width/2, b.y+b.height/3-d.height/2, d.width, d.height);
        setVisible(true);
    }
    
    private void fillSkills(javax.swing.JComboBox combo, Skill[] sk){
        int i;
        String s;
        combo.removeAllItems();
        combo.addItem("无");
        for(i=0; i<sk.length; i++){
            if(sk[i]==null){
                break;
            }
            switch(sk[i].level){
                case 4:
                    s="S";
                    break;
                case 3:
                    s="A";
                    break;
                case 2:
                    s="B";
                    break;
                case 1:
                    s="C";
                    break;
                case 0:
                    s="D";
                    break;
                default:
                    s="";
                    break;
            }
            combo.addItem(sk[i].name+s);
            combo.setSelectedIndex(0);
        }
    }
    
    private int indexToProperty(int index){
        if(index<5){
            return index;
        }
        if(index<10){
            return index+5;
        }
        return 20;
    }
    
    private int propertyToIndex(int property){
        if(property<5){
            return property;
        }
        if(property<15){
            return property-5;
        }
        return 10;
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
        jButtonOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListHeros = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldResist = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxWeapon = new javax.swing.JComboBox();
        jTextFieldWeapon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxWD0 = new javax.swing.JComboBox();
        jComboBoxWDLevel0 = new javax.swing.JComboBox();
        jComboBoxWD1 = new javax.swing.JComboBox();
        jComboBoxWDLevel1 = new javax.swing.JComboBox();
        jComboBoxWD2 = new javax.swing.JComboBox();
        jComboBoxWDLevel2 = new javax.swing.JComboBox();
        jComboBoxWD3 = new javax.swing.JComboBox();
        jComboBoxWDLevel3 = new javax.swing.JComboBox();
        jCheckBoxWProperty = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldWeaponAtt = new javax.swing.JTextField();
        jTextFieldWeaponDef = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldWeaponEff = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldWeaponTf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxShield = new javax.swing.JComboBox();
        jTextFieldShield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSD0 = new javax.swing.JComboBox();
        jComboBoxSD1 = new javax.swing.JComboBox();
        jComboBoxSD2 = new javax.swing.JComboBox();
        jComboBoxSD3 = new javax.swing.JComboBox();
        jComboBoxSDLevel0 = new javax.swing.JComboBox();
        jComboBoxSDLevel1 = new javax.swing.JComboBox();
        jComboBoxSDLevel2 = new javax.swing.JComboBox();
        jComboBoxSDLevel3 = new javax.swing.JComboBox();
        jCheckBoxSProperty = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldShieldAtt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldShieldDef = new javax.swing.JTextField();
        jTextFieldShieldEff = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldShieldTf = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxSkill1 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSkill2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabelPic = new javax.swing.JLabel();
        jLabelStar = new javax.swing.JLabel();
        jLabelHeroAtt = new javax.swing.JLabel();
        jLabelHeroDef = new javax.swing.JLabel();
        jLabelHeroAttGrowth = new javax.swing.JLabel();
        jLabelHeroDefGrowth = new javax.swing.JLabel();
        jLabelHeroGroup = new javax.swing.JLabel();
        jTextFieldHero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxProperty = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPotential = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldAtt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDef = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxPact = new javax.swing.JComboBox();
        jTextFieldPact = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxPD0 = new javax.swing.JComboBox();
        jComboBoxPD1 = new javax.swing.JComboBox();
        jComboBoxPD2 = new javax.swing.JComboBox();
        jComboBoxPD3 = new javax.swing.JComboBox();
        jComboBoxPDLevel0 = new javax.swing.JComboBox();
        jComboBoxPDLevel1 = new javax.swing.JComboBox();
        jComboBoxPDLevel2 = new javax.swing.JComboBox();
        jComboBoxPDLevel3 = new javax.swing.JComboBox();
        jCheckBoxPProperty = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldPactAtt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldPactDef = new javax.swing.JTextField();
        jTextFieldPactEff = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldPactTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("选取忍者");

        jLabel1.setText("忍者");

        jButtonOK.setText("确定");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jListHeros.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListHeros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListHeros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListHerosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListHeros);

        jLabel9.setText("抵抗");

        jTextFieldResist.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldResist.setText("10.1");
        jTextFieldResist.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel10.setText("%忍术效果");

        jLabel2.setText("武器");

        jComboBoxWeapon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWeaponActionPerformed(evt);
            }
        });

        jTextFieldWeapon.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldWeapon.setText("60");

        jLabel5.setText("级");

        jComboBoxWD0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxWDLevel0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxWD1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxWDLevel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxWD2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxWDLevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxWD3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxWDLevel3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jCheckBoxWProperty.setText("jCheckBox1");

        jLabel15.setText("攻");

        jLabel16.setText("防");

        jTextFieldWeaponAtt.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldWeaponAtt.setText("2000");
        jTextFieldWeaponAtt.setPreferredSize(new java.awt.Dimension(36, 20));

        jTextFieldWeaponDef.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldWeaponDef.setText("2000");
        jTextFieldWeaponDef.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel17.setText("%忍术效果");

        jTextFieldWeaponEff.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldWeaponEff.setText("5");
        jTextFieldWeaponEff.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel26.setText("体");

        jTextFieldWeaponTf.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldWeaponTf.setText("0");
        jTextFieldWeaponTf.setPreferredSize(new java.awt.Dimension(36, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addComponent(jComboBoxWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextFieldWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxWD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxWDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxWD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxWDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxWD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxWDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBoxWD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxWDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldWeaponAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldWeaponDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jCheckBoxWProperty))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextFieldWeaponEff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldWeaponTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxWDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxWDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxWDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxWDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxWProperty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldWeaponAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldWeaponDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldWeaponTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWeaponEff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("防具");

        jComboBoxShield.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxShield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxShieldActionPerformed(evt);
            }
        });

        jTextFieldShield.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldShield.setText("60");

        jLabel6.setText("级");

        jComboBoxSD0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxSD1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxSD2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxSD3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxSDLevel0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxSDLevel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxSDLevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxSDLevel3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jCheckBoxSProperty.setText("jCheckBox2");

        jLabel18.setText("攻");

        jTextFieldShieldAtt.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldShieldAtt.setText("2000");
        jTextFieldShieldAtt.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel19.setText("防");

        jTextFieldShieldDef.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldShieldDef.setText("2000");
        jTextFieldShieldDef.setPreferredSize(new java.awt.Dimension(36, 20));

        jTextFieldShieldEff.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldShieldEff.setText("5");
        jTextFieldShieldEff.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel20.setText("%忍术效果");

        jLabel27.setText("体");

        jTextFieldShieldTf.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldShieldTf.setText("0");
        jTextFieldShieldTf.setPreferredSize(new java.awt.Dimension(36, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
            .addComponent(jComboBoxShield, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextFieldShield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxSD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxSD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxSD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxSD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jCheckBoxSProperty)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldShieldAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldShieldDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextFieldShieldEff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldShieldTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSProperty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldShieldAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldShieldDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldShieldTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldShieldEff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("主要技能");

        jComboBoxSkill1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "无" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxSkill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSkill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("次要技能");

        jComboBoxSkill2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "无" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxSkill2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSkill2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(120, 382));

        jLabelHeroAtt.setText("初始攻击：");

        jLabelHeroDef.setText("初始防御：");

        jLabelHeroAttGrowth.setText("攻击成长：");

        jLabelHeroDefGrowth.setText("防御成长：");

        jLabelHeroGroup.setText("忍者类型");

        jTextFieldHero.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldHero.setText("60");

        jLabel4.setText("级");

        jLabel7.setText("属性");

        jComboBoxProperty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "雷", "土", "水", "火", "风", "超雷", "超土", "超水", "超火", "超风", "全" }));

        jLabel8.setText("剩余潜力");

        jTextFieldPotential.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPotential.setText("10000");

        jLabel13.setText("攻击数值");

        jTextFieldAtt.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldAtt.setText("2000");
        jTextFieldAtt.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel14.setText("防御数值");

        jTextFieldDef.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldDef.setText("2000");
        jTextFieldDef.setPreferredSize(new java.awt.Dimension(36, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHeroAtt)
                    .addComponent(jLabelHeroDef)
                    .addComponent(jLabelHeroAttGrowth)
                    .addComponent(jLabelHeroDefGrowth)
                    .addComponent(jLabelHeroGroup)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFieldHero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPotential, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDef, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeroAtt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeroDef)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeroAttGrowth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeroDefGrowth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeroGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPotential, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel21.setText("宝物");

        jComboBoxPact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPactActionPerformed(evt);
            }
        });

        jTextFieldPact.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPact.setText("60");

        jLabel22.setText("级");

        jComboBoxPD0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxPD1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxPD2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxPD3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "未镶嵌", "红宝石", "蓝宝石", "黄宝石" }));

        jComboBoxPDLevel0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxPDLevel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxPDLevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jComboBoxPDLevel3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        jCheckBoxPProperty.setText("jCheckBox2");

        jLabel23.setText("攻");

        jTextFieldPactAtt.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPactAtt.setText("2000");
        jTextFieldPactAtt.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel24.setText("防");

        jTextFieldPactDef.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPactDef.setText("2000");
        jTextFieldPactDef.setPreferredSize(new java.awt.Dimension(36, 20));

        jTextFieldPactEff.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPactEff.setText("5");
        jTextFieldPactEff.setPreferredSize(new java.awt.Dimension(36, 20));

        jLabel25.setText("%忍术效果");

        jLabel28.setText("体");

        jTextFieldPactTf.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldPactTf.setText("0");
        jTextFieldPactTf.setPreferredSize(new java.awt.Dimension(36, 20));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21)
            .addComponent(jComboBoxPact, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTextFieldPact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jComboBoxPD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jComboBoxPD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jComboBoxPD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jComboBoxPD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jCheckBoxPProperty)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPactAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPactDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTextFieldPactEff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPactTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPD0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPDLevel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPDLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPDLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPDLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxPProperty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextFieldPactAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldPactDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldPactTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPactEff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.getAccessibleContext().setAccessibleName("宝物");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldResist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(99, 99, 99)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldResist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jButtonOK)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        Hero h=((Hero) jListHeros.getSelectedValue()).dup();
        if(h==null){
            dispose();
        }
        int level;
        try{
            level = Integer.parseInt(jTextFieldHero.getText());
        }
        catch(Exception e){
            level=60;
        }
        try{
            h.potential = Double.parseDouble(jTextFieldPotential.getText());
        }
        catch(Exception e){
            h.potential=10000;
        }
        h.level=level;
        Equip weapon;
        Equip shield;
        Equip pact;
        weapon=((Equip)jComboBoxWeapon.getSelectedItem()).dup();
        shield=((Equip)jComboBoxShield.getSelectedItem()).dup();
        pact=((Equip)jComboBoxPact.getSelectedItem()).dup();
        try{
            level = Integer.parseInt(jTextFieldWeapon.getText());
        }
        catch(Exception e){
            level=60;
        }
        weapon.level=level;
        weapon.diamond[0]=jComboBoxWD0.getSelectedIndex();
        weapon.diamondLevel[0]=jComboBoxWDLevel0.getSelectedIndex();
        weapon.diamond[1]=jComboBoxWD1.getSelectedIndex();
        weapon.diamondLevel[1]=jComboBoxWDLevel1.getSelectedIndex();
        weapon.diamond[2]=jComboBoxWD2.getSelectedIndex();
        weapon.diamondLevel[2]=jComboBoxWDLevel2.getSelectedIndex();
        weapon.diamond[3]=jComboBoxWD3.getSelectedIndex();
        weapon.diamondLevel[3]=jComboBoxWDLevel3.getSelectedIndex();
        if(jCheckBoxWProperty.isEnabled()){
            weapon.propertyEnabled=jCheckBoxWProperty.isSelected();
        }
        try{
            level = Integer.parseInt(jTextFieldShield.getText());
        }
        catch(Exception e){
            level=60;
        }
        shield.level=level;
        shield.diamond[0]=jComboBoxSD0.getSelectedIndex();
        shield.diamondLevel[0]=jComboBoxSDLevel0.getSelectedIndex();
        shield.diamond[1]=jComboBoxSD1.getSelectedIndex();
        shield.diamondLevel[1]=jComboBoxSDLevel1.getSelectedIndex();
        shield.diamond[2]=jComboBoxSD2.getSelectedIndex();
        shield.diamondLevel[2]=jComboBoxSDLevel2.getSelectedIndex();
        shield.diamond[3]=jComboBoxSD3.getSelectedIndex();
        shield.diamondLevel[3]=jComboBoxSDLevel3.getSelectedIndex();
        if(jCheckBoxSProperty.isEnabled()){
            shield.propertyEnabled=jCheckBoxSProperty.isSelected();
        }
        try{
            level = Integer.parseInt(jTextFieldPact.getText());
        }
        catch(Exception e){
            level=60;
        }
        pact.level=level;
        pact.diamond[0]=jComboBoxPD0.getSelectedIndex();
        pact.diamondLevel[0]=jComboBoxPDLevel0.getSelectedIndex();
        pact.diamond[1]=jComboBoxPD1.getSelectedIndex();
        pact.diamondLevel[1]=jComboBoxPDLevel1.getSelectedIndex();
        pact.diamond[2]=jComboBoxPD2.getSelectedIndex();
        pact.diamondLevel[2]=jComboBoxPDLevel2.getSelectedIndex();
        pact.diamond[3]=jComboBoxPD3.getSelectedIndex();
        pact.diamondLevel[3]=jComboBoxPDLevel3.getSelectedIndex();
        if(jCheckBoxPProperty.isEnabled()){
            pact.propertyEnabled=jCheckBoxPProperty.isSelected();
        }
        h.weapon=weapon;
        h.shield=shield;
        h.pact=pact;
        h.property_battle=indexToProperty(jComboBoxProperty.getSelectedIndex());
        try{
            h.attSet=Double.parseDouble(jTextFieldAtt.getText());
        }
        catch(Exception e){
            h.attSet=100;
        }
        try{
            h.defSet=Double.parseDouble(jTextFieldDef.getText());
        }
        catch(Exception e){
            h.defSet=100;
        }
        try{
            h.weaponAttSet=Double.parseDouble(jTextFieldWeaponAtt.getText());
        }
        catch(Exception e){
            h.weaponAttSet=0;
        }
        try{
            h.weaponDefSet=Double.parseDouble(jTextFieldWeaponDef.getText());
        }
        catch(Exception e){
            h.weaponDefSet=0;
        }
        try{
            h.weaponTfSet=Double.parseDouble(jTextFieldWeaponTf.getText());
        }
        catch(Exception e){
            h.weaponTfSet=0;
        }
        try{
            h.weaponEffSet=Double.parseDouble(jTextFieldWeaponEff.getText());
        }
        catch(Exception e){
            h.weaponEffSet=100;
        }
        try{
            h.shieldAttSet=Double.parseDouble(jTextFieldShieldAtt.getText());
        }
        catch(Exception e){
            h.shieldAttSet=0;
        }
        try{
            h.shieldDefSet=Double.parseDouble(jTextFieldShieldDef.getText());
        }
        catch(Exception e){
            h.shieldDefSet=0;
        }
        try{
            h.shieldTfSet=Double.parseDouble(jTextFieldShieldTf.getText());
        }
        catch(Exception e){
            h.shieldTfSet=0;
        }
        try{
            h.shieldEffSet=Double.parseDouble(jTextFieldShieldEff.getText());
        }
        catch(Exception e){
            h.shieldEffSet=100;
        }
        try{
            h.pactAttSet=Double.parseDouble(jTextFieldPactAtt.getText());
        }
        catch(Exception e){
            h.pactAttSet=0;
        }
        try{
            h.pactDefSet=Double.parseDouble(jTextFieldPactDef.getText());
        }
        catch(Exception e){
            h.pactDefSet=0;
        }
        try{
            h.pactTfSet=Double.parseDouble(jTextFieldPactTf.getText());
        }
        catch(Exception e){
            h.pactTfSet=0;
        }
        try{
            h.pactEffSet=Double.parseDouble(jTextFieldPactEff.getText());
        }
        catch(Exception e){
            h.pactEffSet=100;
        }
        try{
            h.resist=Double.parseDouble(jTextFieldResist.getText());
        }
        catch(Exception e){
            h.resist=0;
        }
        h.skillIndex1=jComboBoxSkill1.getSelectedIndex()-1;
        h.skillIndex2=jComboBoxSkill2.getSelectedIndex()-1;
        if(h.skillIndex1<0){
            h.skill1=null;
        }
        else{
            h.skill1=h.backupSkills[h.skillIndex1];
        }
        if(h.skillIndex2<0){
            h.skill2=null;
        }
        else{
            h.skill2=h.backupSkills[h.skillIndex2];
        }
        SLComputer.myTeam.heros[index]=h;
        source.setText(h.toString());
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jComboBoxWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWeaponActionPerformed
        Equip weapon=(Equip) jComboBoxWeapon.getSelectedItem();
        int j;
        for(j=0; j<3; j++){
            if(weapon.hideProperty[j]!=0){
                break;
            }
        }
        switch(j){
            case 0:
                jCheckBoxWProperty.setText("攻击提高"+(int)weapon.hideProperty[0]);
                break;
            case 1:
                jCheckBoxWProperty.setText("防御提高"+(int)weapon.hideProperty[1]);
                break;
            default:
                jCheckBoxWProperty.setText("忍术几率提高"+(int)weapon.hideProperty[2]+"%");
                break;
        }
        if(j<3){
            jCheckBoxWProperty.setEnabled(true);
            jCheckBoxWProperty.setSelected(false);
        }
        else{
            jCheckBoxWProperty.setSelected(false);
            jCheckBoxWProperty.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxWeaponActionPerformed

    private void jComboBoxShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxShieldActionPerformed
        Equip shield=(Equip) jComboBoxShield.getSelectedItem();
        int j;
        for(j=0; j<3; j++){
            if(shield.hideProperty[j]!=0){
                break;
            }
        }
        switch(j){
            case 0:
                jCheckBoxSProperty.setText("攻击提高"+(int)shield.hideProperty[0]);
                break;
            case 1:
                jCheckBoxSProperty.setText("防御提高"+(int)shield.hideProperty[1]);
                break;
            default:
                jCheckBoxSProperty.setText("忍术几率提高"+(int)shield.hideProperty[2]+"%");
                break;
        }
        if(j<3){
            jCheckBoxSProperty.setEnabled(true);
            jCheckBoxSProperty.setSelected(false);
        }
        else{
            jCheckBoxSProperty.setSelected(false);
            jCheckBoxSProperty.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxShieldActionPerformed

    private void jListHerosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListHerosValueChanged
        Hero h=(Hero) jListHeros.getSelectedValue();
        jComboBoxProperty.setSelectedIndex(propertyToIndex(h.property));
        if(h.id==0){
            return;
        }
        jLabelHeroAtt.setText("初始攻击："+h.att_born);
        jLabelHeroDef.setText("初始防御："+h.def_born);
        jLabelHeroAttGrowth.setText("攻击成长："+h.attGrowth);
        jLabelHeroDefGrowth.setText("防御成长："+h.defGrowth);
        switch(h.style){
            case 0:
                jLabelHeroGroup.setText("木叶忍者");
                break;
            case 1:
                jLabelHeroGroup.setText("雾忍");
                break;
            case 2:
                jLabelHeroGroup.setText("岩忍");
                break;
            case 3:
                jLabelHeroGroup.setText("砂忍");
                break;
            case 4:
                jLabelHeroGroup.setText("雨忍");
                break;
            case 5:
                jLabelHeroGroup.setText("音忍");
                break;
            case 6:
                jLabelHeroGroup.setText("晓");
                break;
            case 7:
                jLabelHeroGroup.setText("云忍");
                break;
            case 8:
                jLabelHeroGroup.setText("泷忍");
                break;
            case 9:
                jLabelHeroGroup.setText("雪忍");
                break;
            case 10:
                jLabelHeroGroup.setText("忍兽");
                break;
            case 11:
                jLabelHeroGroup.setText("秽土转生");
                break;
            default:
                jLabelHeroGroup.setText("未知类型");
                break;
        }
        ImageIcon icon;
        icon=new ImageIcon("TP/"+h.hid+"_big.png.png");
        //System.out.println(jLabelPic.getWidth()+", "+jLabelPic.getHeight());
        icon.setImage(icon.getImage().getScaledInstance(-1, jLabelPic.getHeight(), Image.SCALE_DEFAULT));
        jLabelPic.setIcon(icon);
        ImageIcon starIcon=new ImageIcon("TP/star"+h.star+".png");
        starIcon.setImage(starIcon.getImage().getScaledInstance(-1, jLabelStar.getHeight(), Image.SCALE_DEFAULT));
        //System.out.println(jLabelStar.getWidth()+", "+jLabelStar.getHeight());
        jLabelStar.setIcon(starIcon);
        //jLabel11.setText(h.skill1.name);
        fillSkills(jComboBoxSkill1, h.backupSkills);
        if(h.skillIndex1>=0){
            jComboBoxSkill1.setSelectedIndex(h.skillIndex1+1);
        }
        fillSkills(jComboBoxSkill2, h.backupSkills);
        if(h.skillIndex2>=0){
            jComboBoxSkill2.setSelectedIndex(h.skillIndex2+1);
        }
    }//GEN-LAST:event_jListHerosValueChanged

    private void jComboBoxPactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPactActionPerformed
        Equip pact=(Equip) jComboBoxPact.getSelectedItem();
        int j;
        for(j=0; j<3; j++){
            if(pact.hideProperty[j]!=0){
                break;
            }
        }
        switch(j){
            case 0:
                jCheckBoxPProperty.setText("攻击提高"+(int)pact.hideProperty[0]);
                break;
            case 1:
                jCheckBoxPProperty.setText("防御提高"+(int)pact.hideProperty[1]);
                break;
            default:
                jCheckBoxPProperty.setText("忍术几率提高"+(int)pact.hideProperty[2]+"%");
                break;
        }
        if(j<3){
            jCheckBoxPProperty.setEnabled(true);
            jCheckBoxPProperty.setSelected(false);
        }
        else{
            jCheckBoxPProperty.setSelected(false);
            jCheckBoxPProperty.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxPactActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxPProperty;
    private javax.swing.JCheckBox jCheckBoxSProperty;
    private javax.swing.JCheckBox jCheckBoxWProperty;
    private javax.swing.JComboBox jComboBoxPD0;
    private javax.swing.JComboBox jComboBoxPD1;
    private javax.swing.JComboBox jComboBoxPD2;
    private javax.swing.JComboBox jComboBoxPD3;
    private javax.swing.JComboBox jComboBoxPDLevel0;
    private javax.swing.JComboBox jComboBoxPDLevel1;
    private javax.swing.JComboBox jComboBoxPDLevel2;
    private javax.swing.JComboBox jComboBoxPDLevel3;
    private javax.swing.JComboBox jComboBoxPact;
    private javax.swing.JComboBox jComboBoxProperty;
    private javax.swing.JComboBox jComboBoxSD0;
    private javax.swing.JComboBox jComboBoxSD1;
    private javax.swing.JComboBox jComboBoxSD2;
    private javax.swing.JComboBox jComboBoxSD3;
    private javax.swing.JComboBox jComboBoxSDLevel0;
    private javax.swing.JComboBox jComboBoxSDLevel1;
    private javax.swing.JComboBox jComboBoxSDLevel2;
    private javax.swing.JComboBox jComboBoxSDLevel3;
    private javax.swing.JComboBox jComboBoxShield;
    private javax.swing.JComboBox jComboBoxSkill1;
    private javax.swing.JComboBox jComboBoxSkill2;
    private javax.swing.JComboBox jComboBoxWD0;
    private javax.swing.JComboBox jComboBoxWD1;
    private javax.swing.JComboBox jComboBoxWD2;
    private javax.swing.JComboBox jComboBoxWD3;
    private javax.swing.JComboBox jComboBoxWDLevel0;
    private javax.swing.JComboBox jComboBoxWDLevel1;
    private javax.swing.JComboBox jComboBoxWDLevel2;
    private javax.swing.JComboBox jComboBoxWDLevel3;
    private javax.swing.JComboBox jComboBoxWeapon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelHeroAtt;
    private javax.swing.JLabel jLabelHeroAttGrowth;
    private javax.swing.JLabel jLabelHeroDef;
    private javax.swing.JLabel jLabelHeroDefGrowth;
    private javax.swing.JLabel jLabelHeroGroup;
    private javax.swing.JLabel jLabelPic;
    private javax.swing.JLabel jLabelStar;
    private javax.swing.JList jListHeros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAtt;
    private javax.swing.JTextField jTextFieldDef;
    private javax.swing.JTextField jTextFieldHero;
    private javax.swing.JTextField jTextFieldPact;
    private javax.swing.JTextField jTextFieldPactAtt;
    private javax.swing.JTextField jTextFieldPactDef;
    private javax.swing.JTextField jTextFieldPactEff;
    private javax.swing.JTextField jTextFieldPactTf;
    private javax.swing.JTextField jTextFieldPotential;
    private javax.swing.JTextField jTextFieldResist;
    private javax.swing.JTextField jTextFieldShield;
    private javax.swing.JTextField jTextFieldShieldAtt;
    private javax.swing.JTextField jTextFieldShieldDef;
    private javax.swing.JTextField jTextFieldShieldEff;
    private javax.swing.JTextField jTextFieldShieldTf;
    private javax.swing.JTextField jTextFieldWeapon;
    private javax.swing.JTextField jTextFieldWeaponAtt;
    private javax.swing.JTextField jTextFieldWeaponDef;
    private javax.swing.JTextField jTextFieldWeaponEff;
    private javax.swing.JTextField jTextFieldWeaponTf;
    // End of variables declaration//GEN-END:variables

    private int index;
    public JButton source;
}
