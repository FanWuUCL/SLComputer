/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import slcomputer.dialogs.JDialogLogin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import slcomputer.dialogs.JDialogAutoBB;

/**
 *
 * @author J
 */
public class MainFrame extends javax.swing.JFrame {
    
    public static final int LABELW=100;
    public static final int LABELH=140;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("SLComputer "+SLComputer.major+"."+SLComputer.minor+SLComputer.testVersion+(SLComputer.vip>0 && SLComputer.vip%(SLComputer.major+SLComputer.minor)==0?" 旗舰":" 免费"));
        trialNumber=100;
        mapComponents();
        setAutoBBSetting(100, 99, 200, 0, 40, 40, 
            300, 0, 55, 50, 1000);
        jButtonFinalComputer.setText("<html><font color=#DF0101>试炼终结者</font></html>");
        SLComputer.bf=new BattleField(jTextPaneBattleField);
        jComboBoxCaptainHard.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsHard));
        jComboBoxCaptainNorm.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsNorm));
        jComboBoxCaptainEasy.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsEasy));
        int i;
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jComboBoxSacLevel.setSelectedIndex(SLComputer.sacLevel);
        // battle buildings
        for(i=0; i<6; i++){
            jComboBoxBBuildingLevel[i].setSelectedIndex(SLComputer.buildingLevel[i]);
        }
        ImageIcon icon;
        icon=new ImageIcon("TP/left.png");
        icon.setImage(icon.getImage().getScaledInstance(19, -1, Image.SCALE_DEFAULT));
        jButtonLeft.setIcon(icon);
        icon=new ImageIcon("TP/right.png");
        icon.setImage(icon.getImage().getScaledInstance(19, -1, Image.SCALE_DEFAULT));
        jButtonRight.setIcon(icon);
        
        switch(SLComputer.sNumber){
            case 1:
                jRadioButtonMenuItemSimulationTimes200.setSelected(true);
                break;
            case 2:
                jRadioButtonMenuItemSimulationTimes500.setSelected(true);
                break;
            case 3:
                jRadioButtonMenuItemSimulationTimes1000.setSelected(true);
                break;
            case 4:
                jRadioButtonMenuItemSimulationTimes3000.setSelected(true);
                break;
            case 5:
                jRadioButtonMenuItemSimulationTimes10000.setSelected(true);
                break;
            default:
                jRadioButtonMenuItemSimulationTimes100.setSelected(true);
                break;
        }
        jCheckBoxMenuItemSmartNumber.setSelected(SLComputer.smartNumber);
        jCheckBoxMenuItemSaveBE.setSelected(SLComputer.saveBE);
        jCheckBoxMenuItemDreamMode.setSelected(SLComputer.dreamMode);
        jMenuItemWatchBattle.setSelected(SLComputer.watchBattle);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getPreferredSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setVisible(true);
        jTextPaneBattleField.setText(SLComputer.usage+"\n"+SLComputer.author);
        jButtonMyTeam1.setForeground(Color.red);
        /* 收费内容 
        if(SLComputer.vip<=0 || SLComputer.vip%(SLComputer.major+SLComputer.minor)!=0){
            jButtonMyTeam2.setEnabled(false);
            jButtonMyTeam3.setEnabled(false);
            jButtonMyTeam4.setEnabled(false);
            jToggleButtonSwitch.setEnabled(false);
        }*/
        showMyTeam(false);
        switchEnabled=false;
        switchI=-1;
    }
    
    public void mapComponents(){
        int numberMax=jComboBoxEnemyNumberHard.getItemCount();
        jLabelEnemyHard=new javax.swing.JLabel[numberMax];
        jLabelEnemyNorm=new javax.swing.JLabel[numberMax];
        jLabelEnemyEasy=new javax.swing.JLabel[numberMax];
        int i;
        for(i=0; i<numberMax; i++){
            jLabelEnemyHard[i]=new javax.swing.JLabel();
            jLabelEnemyNorm[i]=new javax.swing.JLabel();
            jLabelEnemyEasy[i]=new javax.swing.JLabel();
        }
        numberMax=16;
        jLabelMyTeam=new javax.swing.JLabel[numberMax];
        for(i=0; i<numberMax; i++){
            jLabelMyTeam[i]=new javax.swing.JLabel();
        }
        jButtonHeroChoosers=new javax.swing.JButton[numberMax];
        jButtonHeroChoosers[0]=jButtonMyHero1;
        jButtonHeroChoosers[1]=jButtonMyHero2;
        jButtonHeroChoosers[2]=jButtonMyHero3;
        jButtonHeroChoosers[3]=jButtonMyHero4;
        jButtonHeroChoosers[4]=jButtonMyHero5;
        jButtonHeroChoosers[5]=jButtonMyHero6;
        jButtonHeroChoosers[6]=jButtonMyHero7;
        jButtonHeroChoosers[7]=jButtonMyHero8;
        jButtonHeroChoosers[8]=jButtonMyHero9;
        jButtonHeroChoosers[9]=jButtonMyHero10;
        jButtonHeroChoosers[10]=jButtonMyHero11;
        jButtonHeroChoosers[11]=jButtonMyHero12;
        jButtonHeroChoosers[12]=jButtonMyHero13;
        jButtonHeroChoosers[13]=jButtonMyHero14;
        jButtonHeroChoosers[14]=jButtonMyHero15;
        jButtonHeroChoosers[15]=jButtonMyHero16;
        for(i=0; i<numberMax; i++){
            jButtonHeroChoosers[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonHeroChooserActionPerformed(evt);
                }
            });
        }
        jComboBoxPets=new javax.swing.JComboBox[5];
        jComboBoxPets[0]=jComboBoxPet1;
        jComboBoxPets[1]=jComboBoxPet2;
        jComboBoxPets[2]=jComboBoxPet3;
        jComboBoxPets[3]=jComboBoxPet4;
        jComboBoxPets[4]=jComboBoxPet5;
        jComboBoxPetsLevel=new javax.swing.JComboBox[5];
        jComboBoxPetsLevel[0]=jComboBoxPetLevel1;
        jComboBoxPetsLevel[1]=jComboBoxPetLevel2;
        jComboBoxPetsLevel[2]=jComboBoxPetLevel3;
        jComboBoxPetsLevel[3]=jComboBoxPetLevel4;
        jComboBoxPetsLevel[4]=jComboBoxPetLevel5;
        
        // 作战建筑
        jRadioButtons=new javax.swing.JRadioButton[30];
        buttonGroup=new javax.swing.ButtonGroup[6];
        i=0;
        jRadioButtons[i++]=jRadioButtonQBW0;
        jRadioButtons[i++]=jRadioButtonQBW1;
        jRadioButtons[i++]=jRadioButtonQBW2;
        jRadioButtons[i++]=jRadioButtonQBW3;
        jRadioButtons[i++]=jRadioButtonQBW4;
        jRadioButtons[i++]=jRadioButtonYWT0;
        jRadioButtons[i++]=jRadioButtonYWT1;
        jRadioButtons[i++]=jRadioButtonYWT2;
        jRadioButtons[i++]=jRadioButtonYWT3;
        jRadioButtons[i++]=jRadioButtonYWT4;
        jRadioButtons[i++]=jRadioButtonYZW0;
        jRadioButtons[i++]=jRadioButtonYZW1;
        jRadioButtons[i++]=jRadioButtonYZW2;
        jRadioButtons[i++]=jRadioButtonYZW3;
        jRadioButtons[i++]=jRadioButtonYZW4;
        jRadioButtons[i++]=jRadioButtonZZS0;
        jRadioButtons[i++]=jRadioButtonZZS1;
        jRadioButtons[i++]=jRadioButtonZZS2;
        jRadioButtons[i++]=jRadioButtonZZS3;
        jRadioButtons[i++]=jRadioButtonZZS4;
        jRadioButtons[i++]=jRadioButtonBQK0;
        jRadioButtons[i++]=jRadioButtonBQK1;
        jRadioButtons[i++]=jRadioButtonBQK2;
        jRadioButtons[i++]=jRadioButtonBQK3;
        jRadioButtons[i++]=jRadioButtonBQK4;
        jRadioButtons[i++]=jRadioButtonBQK5;
        jRadioButtons[i++]=jRadioButtonBQK6;
        jRadioButtons[i++]=jRadioButtonBQK7;
        jRadioButtons[i++]=jRadioButtonBQK8;
        jRadioButtons[i++]=jRadioButtonBQK9;
        
        int j;
        for(i=0; i<6; i++){
            buttonGroup[i]=new javax.swing.ButtonGroup();
            for(j=0; j<5; j++){
                buttonGroup[i].add(jRadioButtons[i*5+j]);
            }
            buttonGroup[i].setSelected(jRadioButtons[i*5+SLComputer.buildingEffect[i]].getModel(), true);
        }
        
        jComboBoxBBuildingLevel=new javax.swing.JComboBox[6];
        i=0;
        jComboBoxBBuildingLevel[i++]=jComboBoxQBW;
        jComboBoxBBuildingLevel[i++]=jComboBoxYWT;
        jComboBoxBBuildingLevel[i++]=jComboBoxYZW;
        jComboBoxBBuildingLevel[i++]=jComboBoxZZS;
        jComboBoxBBuildingLevel[i++]=jComboBoxBQK1;
        jComboBoxBBuildingLevel[i++]=jComboBoxBQK2;
        
        simulationTimes=new javax.swing.ButtonGroup();
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes100);
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes200);
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes500);
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes1000);
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes3000);
        simulationTimes.add(jRadioButtonMenuItemSimulationTimes10000);
    }
    
    public void changeTeamCaptains(int mode){
        if(mode==0){
            jComboBoxCaptainHard.setModel(new DefaultComboBoxModel(SLComputer.QXSL.teamsHard));
            jComboBoxCaptainNorm.setModel(new DefaultComboBoxModel(SLComputer.QXSL.teamsNorm));
            jComboBoxCaptainEasy.setModel(new DefaultComboBoxModel(SLComputer.QXSL.teamsEasy));
        }
        else{
            jComboBoxCaptainHard.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsHard));
            jComboBoxCaptainNorm.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsNorm));
            jComboBoxCaptainEasy.setModel(new DefaultComboBoxModel(SLComputer.FYSL.teamsEasy));
        }
    }
    
    public String skillLevelToString(int level){
        switch(level){
            case 0:
                return "D";
            case 1:
                return "C";
            case 2:
                return "B";
            case 3:
                return "A";
            case 4:
                return "S";
            default:
                return "";
        }
    }
    
    // mode: 0 强袭部队 显示敌方防御值, 1 防御部队 显示敌方攻击值
    public void showEnemyTeam(int hardness, Team t, int mode){
        javax.swing.JPanel panel;
        javax.swing.JLabel[] labels;
        switch(hardness){
            case 0:
                panel=jPanelHard;
                labels=jLabelEnemyHard;
                break;
            case 1:
                panel=jPanelNorm;
                labels=jLabelEnemyNorm;
                break;
            case 2:
                panel=jPanelEasy;
                labels=jLabelEnemyEasy;
                break;
            default:
                System.out.println("showEnemyTeam(): code should never be reached.");
                return;
        }
        // clean
        panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panel.setPreferredSize(new Dimension(LABELW*t.number, LABELH));
        ImageIcon icon;
        int i;
        int showValue;
        String tooltip;
        for(i=0; i<t.number; i++){
            labels[i].setPreferredSize(new Dimension(LABELW, LABELH));
            icon=new ImageIcon("TP/"+t.heros[i].hid+"_big.png.png");
            if(icon.getIconWidth()==128){
                icon.setImage(icon.getImage().getScaledInstance(LABELW/2, -1, Image.SCALE_DEFAULT));
            }
            else{
                icon.setImage(icon.getImage().getScaledInstance(LABELW, -1, Image.SCALE_DEFAULT));
            }
            labels[i].setIcon(icon);
            labels[i].setVerticalAlignment(javax.swing.JLabel.TOP);
            labels[i].setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
            labels[i].setHorizontalAlignment(javax.swing.JLabel.CENTER);
            labels[i].setHorizontalTextPosition(javax.swing.JLabel.CENTER);
            if(mode==0){
                showValue=(int)(t.heros[i].def);
            }
            else{
                showValue=(int)(t.heros[i].att);
            }
            labels[i].setText("<html>"+t.heros[i].toStringWithoutHtml()+" "+Hero.propertyToString(t.heros[i].property_battle) +"<br>"+showValue+"</html>");
            tooltip="";
            if(t.heros[i].skill1!=null){
                tooltip+="<html>"+t.heros[i].skill1.name+skillLevelToString(t.heros[i].skill1.level)+"<br>"+t.heros[i].skill1.description(t.skillPower*100+t.heros[i].powerRatio, 0, t.skillRatePlus*100, t.skillRateMultiply+t.heros[i].rateRatio/100);
            }
            if(t.heros[i].skill2!=null){
                if(tooltip.equals("")){
                    tooltip+="<html>";
                }
                tooltip+="<br>"+t.heros[i].skill2.name+skillLevelToString(t.heros[i].skill2.level)+"<br>"+t.heros[i].skill2.description(t.skillPower*100+t.heros[i].powerRatio, 0, t.skillRatePlus*100, t.skillRateMultiply+t.heros[i].rateRatio/100);
            }
            if(!tooltip.equals("")){
                tooltip=tooltip+"<br><br>忍术效果达到<font color=#FF0000>"+(int)Math.ceil(10000/(100-t.heros[i].resist))+"</font>%时可以将该忍者打成1血";
                tooltip+="</html>";
            }
            labels[i].setToolTipText(tooltip);
            panel.add(labels[i]);
        }
        panel.validate();
        panel.repaint();
    }

    public void jButtonHeroChooserActionPerformed(java.awt.event.ActionEvent evt){
        int i;
        javax.swing.JButton button=(javax.swing.JButton)evt.getSource();
        for(i=0; i<jButtonHeroChoosers.length; i++){
            if(button==jButtonHeroChoosers[i]){
                break;
            }
        }
        if(i>=jButtonHeroChoosers.length){
            System.out.println("jButtonHeroChooserActionPerformed(): i is out of bound.");
            return;
        }
        if(switchEnabled){
            if(switchI<0 || switchI>=SLComputer.myTeam.numberMax){
                switchI=i;
                jButtonHeroChoosers[i].setBackground(Color.darkGray);
            }
            else{
                if(switchI!=i){
                    Hero tmpHero=SLComputer.myTeam.heros[switchI];
                    SLComputer.myTeam.heros[switchI]=SLComputer.myTeam.heros[i];
                    SLComputer.myTeam.heros[i]=tmpHero;
                    String tmpString=jButtonHeroChoosers[switchI].getText();
                    jButtonHeroChoosers[switchI].setText(jButtonHeroChoosers[i].getText());
                    jButtonHeroChoosers[i].setText(tmpString);
                }
                jButtonHeroChoosers[switchI].setBackground(Color.gray);
                switchI=-1;
            }
            return;
        }
        new JDialogHeroChooser(this, true, i, button);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxMode = new javax.swing.JComboBox();
        jTextFieldLevel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPlus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMinus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCaptainHard = new javax.swing.JComboBox();
        jComboBoxMyNumberHard = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxEnemyNumberHard = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBoxCaptainNorm = new javax.swing.JComboBox();
        jComboBoxMyNumberNorm = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jComboBoxEnemyNumberNorm = new javax.swing.JComboBox();
        jComboBoxCaptainEasy = new javax.swing.JComboBox();
        jComboBoxMyNumberEasy = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxEnemyNumberEasy = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelMyTeam = new javax.swing.JPanel();
        jButtonMyHero1 = new javax.swing.JButton();
        jButtonMyHero2 = new javax.swing.JButton();
        jButtonMyHero3 = new javax.swing.JButton();
        jButtonMyHero4 = new javax.swing.JButton();
        jButtonMyHero5 = new javax.swing.JButton();
        jButtonMyHero6 = new javax.swing.JButton();
        jButtonMyHero7 = new javax.swing.JButton();
        jButtonMyHero8 = new javax.swing.JButton();
        jButtonMyHero9 = new javax.swing.JButton();
        jButtonMyHero10 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButtonFinalComputer = new javax.swing.JButton();
        jButtonShowMyTeam = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPaneBattleField = new javax.swing.JTextPane();
        jButtonGoHard = new javax.swing.JButton();
        jButtonGoNorm = new javax.swing.JButton();
        jButtonGoEasy = new javax.swing.JButton();
        jLabelPHard = new javax.swing.JLabel();
        jLabelPNorm = new javax.swing.JLabel();
        jLabelPEasy = new javax.swing.JLabel();
        jLabelSumHard = new javax.swing.JLabel();
        jLabelSumNorm = new javax.swing.JLabel();
        jLabelSumEasy = new javax.swing.JLabel();
        jLabelMyDef = new javax.swing.JLabel();
        jLabelMyAtt = new javax.swing.JLabel();
        jComboBoxSacLevel = new javax.swing.JComboBox();
        jTabbedPaneEnemy = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelHard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelNorm = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelEasy = new javax.swing.JPanel();
        jTabbedPanePets = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxPet1 = new javax.swing.JComboBox();
        jComboBoxPetLevel1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxPet2 = new javax.swing.JComboBox();
        jComboBoxPetLevel2 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxPet3 = new javax.swing.JComboBox();
        jComboBoxPetLevel3 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jComboBoxPet4 = new javax.swing.JComboBox();
        jComboBoxPetLevel4 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxPet5 = new javax.swing.JComboBox();
        jComboBoxPetLevel5 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldSkillPlus = new javax.swing.JTextField();
        jTextFieldSkillMinus = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jComboBoxQBW = new javax.swing.JComboBox();
        jRadioButtonQBW0 = new javax.swing.JRadioButton();
        jRadioButtonQBW1 = new javax.swing.JRadioButton();
        jRadioButtonQBW2 = new javax.swing.JRadioButton();
        jRadioButtonQBW3 = new javax.swing.JRadioButton();
        jRadioButtonQBW4 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxYWT = new javax.swing.JComboBox();
        jRadioButtonYWT0 = new javax.swing.JRadioButton();
        jRadioButtonYWT1 = new javax.swing.JRadioButton();
        jRadioButtonYWT2 = new javax.swing.JRadioButton();
        jRadioButtonYWT3 = new javax.swing.JRadioButton();
        jRadioButtonYWT4 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jComboBoxYZW = new javax.swing.JComboBox();
        jRadioButtonYZW0 = new javax.swing.JRadioButton();
        jRadioButtonYZW1 = new javax.swing.JRadioButton();
        jRadioButtonYZW2 = new javax.swing.JRadioButton();
        jRadioButtonYZW3 = new javax.swing.JRadioButton();
        jRadioButtonYZW4 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jComboBoxZZS = new javax.swing.JComboBox();
        jRadioButtonZZS0 = new javax.swing.JRadioButton();
        jRadioButtonZZS1 = new javax.swing.JRadioButton();
        jRadioButtonZZS2 = new javax.swing.JRadioButton();
        jRadioButtonZZS3 = new javax.swing.JRadioButton();
        jRadioButtonZZS4 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jComboBoxBQK1 = new javax.swing.JComboBox();
        jRadioButtonBQK0 = new javax.swing.JRadioButton();
        jRadioButtonBQK1 = new javax.swing.JRadioButton();
        jRadioButtonBQK2 = new javax.swing.JRadioButton();
        jRadioButtonBQK3 = new javax.swing.JRadioButton();
        jRadioButtonBQK4 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jComboBoxBQK2 = new javax.swing.JComboBox();
        jRadioButtonBQK5 = new javax.swing.JRadioButton();
        jRadioButtonBQK6 = new javax.swing.JRadioButton();
        jRadioButtonBQK7 = new javax.swing.JRadioButton();
        jRadioButtonBQK8 = new javax.swing.JRadioButton();
        jRadioButtonBQK9 = new javax.swing.JRadioButton();
        jButtonMyHero11 = new javax.swing.JButton();
        jButtonMyHero12 = new javax.swing.JButton();
        jButtonMyHero13 = new javax.swing.JButton();
        jButtonMyHero14 = new javax.swing.JButton();
        jButtonMyHero15 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonLeft = new javax.swing.JButton();
        jButtonRight = new javax.swing.JButton();
        jButtonCopyTeam = new javax.swing.JButton();
        jButtonPasteTeam = new javax.swing.JButton();
        jButtonMyTeam1 = new javax.swing.JButton();
        jButtonMyTeam2 = new javax.swing.JButton();
        jButtonMyTeam3 = new javax.swing.JButton();
        jButtonMyTeam4 = new javax.swing.JButton();
        jCheckBoxKillFirst = new javax.swing.JCheckBox();
        jToggleButtonSwitch = new javax.swing.JToggleButton();
        jButtonLoveHut = new javax.swing.JButton();
        jButtonMyHero16 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSettings = new javax.swing.JMenu();
        jMenuSimulationTimes = new javax.swing.JMenu();
        jRadioButtonMenuItemSimulationTimes100 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSimulationTimes200 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSimulationTimes500 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSimulationTimes1000 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSimulationTimes3000 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSimulationTimes10000 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItemSmartNumber = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemSaveBE = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItemDreamMode = new javax.swing.JCheckBoxMenuItem();
        jMenuAccount = new javax.swing.JMenu();
        jMenuItemLogin = new javax.swing.JMenuItem();
        jMenuItemAutoBB = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemWatchBattle = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" SLComputer");
        setPreferredSize(new java.awt.Dimension(1160, 700));
        setResizable(false);

        jComboBoxMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "强袭", "护卫" }));
        jComboBoxMode.setSelectedIndex(1);
        jComboBoxMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeActionPerformed(evt);
            }
        });

        jTextFieldLevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldLevel.setText("1");

        jLabel1.setText("第");

        jLabel2.setText("层");

        jLabel3.setText("己方攻击/防御+");

        jTextFieldPlus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPlus.setText("0");

        jLabel4.setText("%");

        jLabel5.setText("敌方攻击/防御 -");

        jTextFieldMinus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMinus.setText("0");
        jTextFieldMinus.setMaximumSize(new java.awt.Dimension(24, 20));
        jTextFieldMinus.setMinimumSize(new java.awt.Dimension(24, 20));

        jLabel6.setText("%");

        jComboBoxCaptainHard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "山椒鱼半藏" }));

        jComboBoxMyNumberHard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        jComboBoxMyNumberHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMyNumberHardActionPerformed(evt);
            }
        });

        jLabel31.setText("VS");

        jComboBoxEnemyNumberHard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));
        jComboBoxEnemyNumberHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEnemyNumberHardActionPerformed(evt);
            }
        });

        jButton1.setText("计算");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxCaptainNorm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "山椒鱼半藏" }));

        jComboBoxMyNumberNorm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        jComboBoxMyNumberNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMyNumberNormActionPerformed(evt);
            }
        });

        jLabel32.setText("VS");

        jComboBoxEnemyNumberNorm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));
        jComboBoxEnemyNumberNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEnemyNumberNormActionPerformed(evt);
            }
        });

        jComboBoxCaptainEasy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "山椒鱼半藏" }));

        jComboBoxMyNumberEasy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        jComboBoxMyNumberEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMyNumberEasyActionPerformed(evt);
            }
        });

        jLabel33.setText("VS");

        jComboBoxEnemyNumberEasy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));
        jComboBoxEnemyNumberEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEnemyNumberEasyActionPerformed(evt);
            }
        });

        jLabel7.setText("高难队长");

        jLabel8.setText("普通队长");

        jLabel9.setText("菜鸟队长");

        jPanelMyTeam.setPreferredSize(new java.awt.Dimension(1440, 140));

        javax.swing.GroupLayout jPanelMyTeamLayout = new javax.swing.GroupLayout(jPanelMyTeam);
        jPanelMyTeam.setLayout(jPanelMyTeamLayout);
        jPanelMyTeamLayout.setHorizontalGroup(
            jPanelMyTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jPanelMyTeamLayout.setVerticalGroup(
            jPanelMyTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanelMyTeam);

        jButtonMyHero1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonMyHero1.setLabel("<未选取>");
        jButtonMyHero1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero2.setLabel("<未选取>");
        jButtonMyHero2.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero3.setLabel("<未选取>");
        jButtonMyHero3.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero4.setLabel("<未选取>");
        jButtonMyHero4.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero5.setLabel("<未选取>");
        jButtonMyHero5.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero6.setLabel("<未选取>");
        jButtonMyHero6.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero7.setLabel("<未选取>");
        jButtonMyHero7.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero8.setLabel("<未选取>");
        jButtonMyHero8.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero9.setLabel("<未选取>");
        jButtonMyHero9.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero10.setLabel("<未选取>");
        jButtonMyHero10.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jLabel13.setText("尾兽祭坛");

        jLabel14.setText("我的阵容");
        jLabel14.setToolTipText("");

        jButtonFinalComputer.setText("试炼终结者");
        jButtonFinalComputer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalComputerActionPerformed(evt);
            }
        });

        jButtonShowMyTeam.setText("显示阵容");
        jButtonShowMyTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowMyTeamActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jTextPaneBattleField);

        jButtonGoHard.setText("挑战");
        jButtonGoHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoHardActionPerformed(evt);
            }
        });

        jButtonGoNorm.setText("挑战");
        jButtonGoNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoNormActionPerformed(evt);
            }
        });

        jButtonGoEasy.setText("挑战");
        jButtonGoEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoEasyActionPerformed(evt);
            }
        });

        jLabelPHard.setText("胜率：");

        jLabelPNorm.setText("胜率：");

        jLabelPEasy.setText("胜率：");

        jLabelSumHard.setText("总攻击：");

        jLabelSumNorm.setText("总攻击：");

        jLabelSumEasy.setText("总攻击：");

        jLabelMyDef.setText("总防御：");

        jLabelMyAtt.setText("总攻击：");

        jComboBoxSacLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级祭坛", "2级祭坛", "3级祭坛", "4级祭坛", "5级祭坛", "6级祭坛", "7级祭坛", "8级祭坛", "9级祭坛", "10级祭坛" }));

        jPanelHard.setPreferredSize(new java.awt.Dimension(1440, 140));

        javax.swing.GroupLayout jPanelHardLayout = new javax.swing.GroupLayout(jPanelHard);
        jPanelHard.setLayout(jPanelHardLayout);
        jPanelHardLayout.setHorizontalGroup(
            jPanelHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jPanelHardLayout.setVerticalGroup(
            jPanelHardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelHard);

        jTabbedPaneEnemy.addTab("高难", jScrollPane1);

        jPanelNorm.setPreferredSize(new java.awt.Dimension(1440, 140));

        javax.swing.GroupLayout jPanelNormLayout = new javax.swing.GroupLayout(jPanelNorm);
        jPanelNorm.setLayout(jPanelNormLayout);
        jPanelNormLayout.setHorizontalGroup(
            jPanelNormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jPanelNormLayout.setVerticalGroup(
            jPanelNormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanelNorm);

        jTabbedPaneEnemy.addTab("普通", jScrollPane2);

        jPanelEasy.setPreferredSize(new java.awt.Dimension(1440, 140));

        javax.swing.GroupLayout jPanelEasyLayout = new javax.swing.GroupLayout(jPanelEasy);
        jPanelEasy.setLayout(jPanelEasyLayout);
        jPanelEasyLayout.setHorizontalGroup(
            jPanelEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jPanelEasyLayout.setVerticalGroup(
            jPanelEasyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanelEasy);

        jTabbedPaneEnemy.addTab("菜鸟", jScrollPane3);

        jTabbedPanePets.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jComboBoxPet1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<空>", "一尾守鹤", "二尾又旅", "三尾矶抚", "四尾孙悟空", "五尾穆王", "六尾犀犬", "七尾重明", "八尾牛鬼", "九尾九摩诃", "十尾神树" }));

        jComboBoxPetLevel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPet1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPetLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPetLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPanePets.addTab("<空>", jPanel1);

        jComboBoxPet2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<空>", "一尾守鹤", "二尾又旅", "三尾矶抚", "四尾孙悟空", "五尾穆王", "六尾犀犬", "七尾重明", "八尾牛鬼", "九尾九摩诃", "十尾神树" }));

        jComboBoxPetLevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPet2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPetLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPetLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPanePets.addTab("<空>", jPanel2);

        jComboBoxPet3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<空>", "一尾守鹤", "二尾又旅", "三尾矶抚", "四尾孙悟空", "五尾穆王", "六尾犀犬", "七尾重明", "八尾牛鬼", "九尾九摩诃", "十尾神树" }));

        jComboBoxPetLevel3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPet3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPetLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPetLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPanePets.addTab("<空>", jPanel3);

        jComboBoxPet4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<空>", "一尾守鹤", "二尾又旅", "三尾矶抚", "四尾孙悟空", "五尾穆王", "六尾犀犬", "七尾重明", "八尾牛鬼", "九尾九摩诃", "十尾神树" }));

        jComboBoxPetLevel4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPet4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPetLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPet4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPetLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPanePets.addTab("<空>", jPanel4);

        jComboBoxPet5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<空>", "一尾守鹤", "二尾又旅", "三尾矶抚", "四尾孙悟空", "五尾穆王", "六尾犀犬", "七尾重明", "八尾牛鬼", "九尾九摩诃", "十尾神树" }));

        jComboBoxPetLevel5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1级", "2级", "3级", "4级", "5级", "6级", "7级", "8级", "9级", "10级" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPet5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPetLevel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPet5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPetLevel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPanePets.addTab("<空>", jPanel5);

        jLabel15.setText("己方忍术效果+");

        jLabel16.setText("敌方忍术效果 -");

        jTextFieldSkillPlus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSkillPlus.setText("0");

        jTextFieldSkillMinus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSkillMinus.setText("0");

        jLabel17.setText("%");

        jLabel18.setText("%");

        jLabel19.setText("作战建筑");

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jComboBoxQBW.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonQBW0.setText("停止运转");

        jRadioButtonQBW1.setText("一档");

        jRadioButtonQBW2.setText("二档");

        jRadioButtonQBW3.setText("三档");

        jRadioButtonQBW4.setText("四档");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jRadioButtonQBW2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonQBW4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jRadioButtonQBW1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonQBW3))
                    .addComponent(jRadioButtonQBW0)
                    .addComponent(jComboBoxQBW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxQBW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonQBW0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonQBW1)
                    .addComponent(jRadioButtonQBW3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonQBW2)
                    .addComponent(jRadioButtonQBW4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("情报屋", jPanel6);

        jComboBoxYWT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonYWT0.setText("停止运转");

        jRadioButtonYWT1.setText("一档");

        jRadioButtonYWT2.setText("二档");

        jRadioButtonYWT3.setText("三档");

        jRadioButtonYWT4.setText("四档");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jRadioButtonYWT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonYWT4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jRadioButtonYWT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonYWT3))
                    .addComponent(jRadioButtonYWT0)
                    .addComponent(jComboBoxYWT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxYWT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonYWT0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonYWT1)
                    .addComponent(jRadioButtonYWT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonYWT2)
                    .addComponent(jRadioButtonYWT4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("远望塔", jPanel7);

        jComboBoxYZW.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonYZW0.setText("停止运转");

        jRadioButtonYZW1.setText("一档");

        jRadioButtonYZW2.setText("二档");

        jRadioButtonYZW3.setText("三档");

        jRadioButtonYZW4.setText("四档");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jRadioButtonYZW2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonYZW4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jRadioButtonYZW1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonYZW3))
                    .addComponent(jRadioButtonYZW0)
                    .addComponent(jComboBoxYZW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxYZW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonYZW0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonYZW1)
                    .addComponent(jRadioButtonYZW3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonYZW2)
                    .addComponent(jRadioButtonYZW4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("影之屋", jPanel8);

        jComboBoxZZS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonZZS0.setText("停止运转");

        jRadioButtonZZS1.setText("一档");

        jRadioButtonZZS2.setText("二档");

        jRadioButtonZZS3.setText("三档");

        jRadioButtonZZS4.setText("四档");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jRadioButtonZZS2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonZZS4))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jRadioButtonZZS1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonZZS3))
                    .addComponent(jRadioButtonZZS0)
                    .addComponent(jComboBoxZZS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxZZS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonZZS0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonZZS1)
                    .addComponent(jRadioButtonZZS3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonZZS2)
                    .addComponent(jRadioButtonZZS4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("作战室", jPanel9);

        jComboBoxBQK1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonBQK0.setText("停止运转");

        jRadioButtonBQK1.setText("一档");

        jRadioButtonBQK2.setText("二档");

        jRadioButtonBQK3.setText("三档");

        jRadioButtonBQK4.setText("四档");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBQK2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonBQK4))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBQK1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonBQK3))
                    .addComponent(jRadioButtonBQK0)
                    .addComponent(jComboBoxBQK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxBQK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBQK0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBQK1)
                    .addComponent(jRadioButtonBQK3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBQK2)
                    .addComponent(jRadioButtonBQK4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("兵器库", jPanel10);

        jComboBoxBQK2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "等级1", "等级2", "等级3", "等级4", "等级5", "等级6", "等级7", "等级8", "等级9", "等级10" }));

        jRadioButtonBQK5.setText("停止运转");

        jRadioButtonBQK6.setText("一档");

        jRadioButtonBQK7.setText("二档");

        jRadioButtonBQK8.setText("三档");

        jRadioButtonBQK9.setText("四档");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxBQK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBQK7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonBQK9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBQK6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonBQK8))
                    .addComponent(jRadioButtonBQK5))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxBQK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBQK5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBQK6)
                    .addComponent(jRadioButtonBQK8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonBQK7)
                    .addComponent(jRadioButtonBQK9))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("兵器库", jPanel11);

        jButtonMyHero11.setLabel("<未选取>");
        jButtonMyHero11.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero12.setLabel("<未选取>");
        jButtonMyHero12.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero13.setLabel("<未选取>");
        jButtonMyHero13.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero14.setLabel("<未选取>");
        jButtonMyHero14.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonMyHero15.setLabel("<未选取>");
        jButtonMyHero15.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButton2.setText("使用说明");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeftActionPerformed(evt);
            }
        });

        jButtonRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRightActionPerformed(evt);
            }
        });

        jButtonCopyTeam.setText("复制阵容");
        jButtonCopyTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyTeamActionPerformed(evt);
            }
        });

        jButtonPasteTeam.setText("粘贴阵容");
        jButtonPasteTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasteTeamActionPerformed(evt);
            }
        });

        jButtonMyTeam1.setText("阵容一");
        jButtonMyTeam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyTeam1ActionPerformed(evt);
            }
        });

        jButtonMyTeam2.setText("阵容二");
        jButtonMyTeam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyTeam2ActionPerformed(evt);
            }
        });

        jButtonMyTeam3.setText("阵容三");
        jButtonMyTeam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyTeam3ActionPerformed(evt);
            }
        });

        jButtonMyTeam4.setText("阵容四");
        jButtonMyTeam4.setToolTipText("");
        jButtonMyTeam4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMyTeam4ActionPerformed(evt);
            }
        });

        jCheckBoxKillFirst.setText("秒杀敌首忍者");
        jCheckBoxKillFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxKillFirstActionPerformed(evt);
            }
        });

        jToggleButtonSwitch.setText("排兵布阵");
        jToggleButtonSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSwitchActionPerformed(evt);
            }
        });

        jButtonLoveHut.setText("爱心小屋");
        jButtonLoveHut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoveHutActionPerformed(evt);
            }
        });

        jButtonMyHero16.setLabel("<未选取>");
        jButtonMyHero16.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jMenuSettings.setText("设置");

        jMenuSimulationTimes.setText("模拟次数");
        jMenuSimulationTimes.setToolTipText("改变计算胜率时模拟对战次数，模拟次数越高，胜率越准确，但是反应时间越慢。");

        jRadioButtonMenuItemSimulationTimes100.setSelected(true);
        jRadioButtonMenuItemSimulationTimes100.setText("100");
        jRadioButtonMenuItemSimulationTimes100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes100ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes100);

        jRadioButtonMenuItemSimulationTimes200.setSelected(true);
        jRadioButtonMenuItemSimulationTimes200.setText("200");
        jRadioButtonMenuItemSimulationTimes200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes200ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes200);

        jRadioButtonMenuItemSimulationTimes500.setSelected(true);
        jRadioButtonMenuItemSimulationTimes500.setText("500");
        jRadioButtonMenuItemSimulationTimes500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes500ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes500);

        jRadioButtonMenuItemSimulationTimes1000.setSelected(true);
        jRadioButtonMenuItemSimulationTimes1000.setText("1000");
        jRadioButtonMenuItemSimulationTimes1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes1000ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes1000);

        jRadioButtonMenuItemSimulationTimes3000.setSelected(true);
        jRadioButtonMenuItemSimulationTimes3000.setText("5000");
        jRadioButtonMenuItemSimulationTimes3000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes3000ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes3000);

        jRadioButtonMenuItemSimulationTimes10000.setSelected(true);
        jRadioButtonMenuItemSimulationTimes10000.setText("10000");
        jRadioButtonMenuItemSimulationTimes10000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSimulationTimes10000ActionPerformed(evt);
            }
        });
        jMenuSimulationTimes.add(jRadioButtonMenuItemSimulationTimes10000);

        jMenuSettings.add(jMenuSimulationTimes);
        jMenuSettings.add(jSeparator1);

        jCheckBoxMenuItemSmartNumber.setSelected(true);
        jCheckBoxMenuItemSmartNumber.setText("智能选取人数");
        jCheckBoxMenuItemSmartNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemSmartNumberActionPerformed(evt);
            }
        });
        jMenuSettings.add(jCheckBoxMenuItemSmartNumber);

        jCheckBoxMenuItemSaveBE.setSelected(true);
        jCheckBoxMenuItemSaveBE.setText("保存建筑信息");
        jCheckBoxMenuItemSaveBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemSaveBEActionPerformed(evt);
            }
        });
        jMenuSettings.add(jCheckBoxMenuItemSaveBE);

        jCheckBoxMenuItemDreamMode.setSelected(true);
        jCheckBoxMenuItemDreamMode.setText("梦想模式");
        jCheckBoxMenuItemDreamMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemDreamModeActionPerformed(evt);
            }
        });
        jMenuSettings.add(jCheckBoxMenuItemDreamMode);

        jMenuBar1.add(jMenuSettings);

        jMenuAccount.setText("账号");

        jMenuItemLogin.setText("登陆");
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogin);

        jMenuItemAutoBB.setText("自动试炼");
        jMenuItemAutoBB.setEnabled(false);
        jMenuItemAutoBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutoBBActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemAutoBB);

        jMenuItemLogout.setText("注销");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogout);
        jMenuAccount.add(jSeparator3);

        jMenuItemWatchBattle.setText("观看战斗");
        jMenuItemWatchBattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemWatchBattleActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemWatchBattle);
        jMenuAccount.add(jSeparator2);

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxCaptainHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxMyNumberHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel31)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxEnemyNumberHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonGoHard)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabelPHard))
                                            .addComponent(jLabelSumHard, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxCaptainNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxMyNumberNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel32)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxEnemyNumberNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelSumNorm)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonGoNorm)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabelPNorm)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonGoEasy)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabelPEasy))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxMyNumberEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel33)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxEnemyNumberEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelSumEasy)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(4, 4, 4)
                                                .addComponent(jComboBoxCaptainEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldSkillPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBoxKillFirst))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButtonFinalComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldSkillMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel18)
                                                    .addGap(208, 208, 208))))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTabbedPaneEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSacLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19)
                            .addComponent(jTabbedPanePets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonMyHero13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonMyHero5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonMyHero1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMyHero4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonMyHero9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMyHero10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMyHero11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelMyAtt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonLoveHut))
                                    .addComponent(jLabelMyDef))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButtonShowMyTeam)
                                    .addComponent(jButtonMyHero12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCopyTeam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPasteTeam)
                .addGap(18, 18, 18)
                .addComponent(jButtonMyTeam1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMyTeam2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMyTeam3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMyTeam4)
                .addGap(18, 18, 18)
                .addComponent(jToggleButtonSwitch)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldSkillPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jCheckBoxKillFirst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextFieldLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel16)
                                .addComponent(jTextFieldSkillMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7))
                                    .addComponent(jComboBoxCaptainHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMyNumberHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel31))
                                    .addComponent(jComboBoxEnemyNumberHard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabelSumHard)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonGoHard)
                                    .addComponent(jLabelPHard)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel8))
                                    .addComponent(jComboBoxCaptainNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMyNumberNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel32))
                                    .addComponent(jComboBoxEnemyNumberNorm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabelSumNorm)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonGoNorm)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabelPNorm))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel9))
                                    .addComponent(jComboBoxCaptainEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMyNumberEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel33))
                                    .addComponent(jComboBoxEnemyNumberEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabelSumEasy)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonGoEasy)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelPEasy)
                                            .addComponent(jButtonFinalComputer))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPaneEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jComboBoxSacLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTabbedPanePets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButtonCopyTeam)
                    .addComponent(jButtonPasteTeam)
                    .addComponent(jButtonMyTeam1)
                    .addComponent(jButtonMyTeam2)
                    .addComponent(jButtonMyTeam3)
                    .addComponent(jButtonMyTeam4)
                    .addComponent(jToggleButtonSwitch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMyHero1)
                            .addComponent(jButtonMyHero2)
                            .addComponent(jButtonMyHero3)
                            .addComponent(jButtonMyHero4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMyHero5)
                            .addComponent(jButtonMyHero6)
                            .addComponent(jButtonMyHero7)
                            .addComponent(jButtonMyHero8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMyHero9)
                            .addComponent(jButtonMyHero10)
                            .addComponent(jButtonMyHero11)
                            .addComponent(jButtonMyHero12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jButtonMyHero13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonMyHero14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonMyHero15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonMyHero16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMyAtt)
                            .addComponent(jButtonShowMyTeam)
                            .addComponent(jButtonLoveHut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMyDef)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPanePets.getAccessibleContext().setAccessibleName("<空>");
        jTabbedPane3.getAccessibleContext().setAccessibleName("影之屋");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeActionPerformed
        int i=jComboBoxMode.getSelectedIndex();
        //System.out.println(i+", "+j);
        changeTeamCaptains(i);
        SLComputer.myTeam=SLComputer.backupTeams[i];
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jComboBoxSacLevel.setSelectedIndex(SLComputer.sacLevel);
        jButtonMyTeam1.setForeground(Color.red);
        jButtonMyTeam2.setForeground(Color.darkGray);
        jButtonMyTeam3.setForeground(Color.darkGray);
        jButtonMyTeam4.setForeground(Color.darkGray);
        showMyTeam(false);
    }//GEN-LAST:event_jComboBoxModeActionPerformed

    public double BBuildingEffect(int index){
        if(index<0 || index >5){
            return 0;
        }
        javax.swing.ButtonModel bm=buttonGroup[index].getSelection();
        int i;
        for(i=0; i<5; i++){
            if(bm==jRadioButtons[index*5+i].getModel()){
                break;
            }
        }
        if(i>=5){
            System.out.println("BBuildingEffect(): out of range.");
            return 0;
        }
        double effect;
        if(index==4 || index==5){
            effect=0.5;
        }
        else{
            effect=1;
        }
        switch(i){
            case 0:
                return 0;
            case 2:
                effect*=2;
                break;
            case 3:
                effect*=2.5;
                break;
            case 4:
                effect*=3;
                break;
            default:
                break;
        }
        effect*=(jComboBoxBBuildingLevel[index].getSelectedIndex()+1);
        return effect;
    }
    
    public void computeEnemy(){
        Team t=null;
        SLData slData;
        int mode=jComboBoxMode.getSelectedIndex();
        if(mode==0){
            slData=SLComputer.QXSL;
        }
        else{
            slData=SLComputer.FYSL;
        }
        // 试炼每3层的减益
        double powerDown=0;
        double skillPowerDown=0;
        int level;
        try{
            level=Integer.parseInt(jTextFieldLevel.getText());
            if(level<1 || level>slData.maxLevel){
                System.out.println("Not valid SL level: "+level+".");
                level=1;
                jTextFieldLevel.setText(level+"");
            }
            powerDown=Double.parseDouble(jTextFieldMinus.getText())/100;
            skillPowerDown=Double.parseDouble(jTextFieldSkillMinus.getText())/100;
        }
        catch(Exception e){
            System.out.println(e);
            level=1;
            jTextFieldLevel.setText(level+"");
        }
        double enemySkillPower=slData.skillPower[level-1];
        double enemySkillRate=slData.skillRate[level-1];
        // 尾兽造成的技能几率减成
        double reducingSkillRate=0;
        //jLabelEnemySkillPower.setText("此层敌方忍术效果额外提升"+(int)(enemySkillPower*100)+"%");
        //jLabelEnemySkillRate.setText("此层敌方忍术几率额外提升"+(int)(enemySkillRate*100)+"%");
        jTextPaneBattleField.setText("第"+level+"层\n"
                + "敌方忍术效果额外提升"+(int)(enemySkillPower*100)+"%\n"
                + "敌方忍术几率额外提升"+(int)(enemySkillRate*100)+"%\n"
                + "敌方体术附加"+(int)slData.bodySkill[level-1][0]);
        enemySkillPower-=skillPowerDown;
        double powerAtt=0;
        double powerDef=0;
        int i, j;
        SLComputer.sacLevel=jComboBoxSacLevel.getSelectedIndex();
        for(i=0; i<5; i++){
            switch(jComboBoxPets[i].getSelectedIndex()){
                case 1:     // 一尾
                    jTabbedPanePets.setTitleAt(i, "守鹤");
                    //SLComputer.myTeam.powerUpbyProperty[1]=Team.petBenefit(1, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 1, SLComputer.sacLevel);
                    break;
                case 2:     // 二尾
                    jTabbedPanePets.setTitleAt(i, "又旅");
                    //SLComputer.myTeam.powerUpbyProperty[0]=Team.petBenefit(2, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 2, SLComputer.sacLevel);
                    break;
                case 3:     // 三尾
                    jTabbedPanePets.setTitleAt(i, "矶抚");
                    //SLComputer.myTeam.powerUpbyProperty[2]=Team.petBenefit(3, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 3, SLComputer.sacLevel);
                    break;
                case 4:     // 四尾
                    jTabbedPanePets.setTitleAt(i, "孙悟空");
                    //SLComputer.myTeam.powerUpbyProperty[3]=Team.petBenefit(4, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 4, SLComputer.sacLevel);
                    break;
                case 5:     // 五尾
                    jTabbedPanePets.setTitleAt(i, "穆王");
                    //SLComputer.myTeam.powerUpbyProperty[4]=Team.petBenefit(5, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 5, SLComputer.sacLevel);
                    break;
                case 8:     // 八尾
                    jTabbedPanePets.setTitleAt(i, "牛鬼");
                    //SLComputer.myTeam.powerDef=Team.petBenefit(8, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 8, SLComputer.sacLevel);
                    break;
                case 9:     // 九尾
                    jTabbedPanePets.setTitleAt(i, "九摩诃");
                    //SLComputer.myTeam.powerAtt=Team.petBenefit(9, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 9, SLComputer.sacLevel);
                    break;
                case 6:     // 六尾
                    jTabbedPanePets.setTitleAt(i, "犀犬");
                    powerAtt=-Team.petBenefit(6, jComboBoxPetsLevel[i].getSelectedIndex())*Team.sacLevelBenefit(i, 6, SLComputer.sacLevel);
                    break;
                case 7:     // 七尾
                    jTabbedPanePets.setTitleAt(i, "重明");
                    reducingSkillRate-=Team.petBenefit(7, jComboBoxPetsLevel[i].getSelectedIndex())*Team.sacLevelBenefit(i, 7, SLComputer.sacLevel)/100;
                    break;
                case 10:
                    jTabbedPanePets.setTitleAt(i, "神树");
                    break;
                default:
                    jTabbedPanePets.setTitleAt(i, "<空>");
                    break;
            }
        }
        // battle buildings
        for(i=0; i<6; i++){
            SLComputer.buildingLevel[i]=jComboBoxBBuildingLevel[i].getSelectedIndex();
            ButtonModel bm=buttonGroup[i].getSelection();
            for(j=0; j<5; j++){
                if(bm==jRadioButtons[i*5+j].getModel()){
                    break;
                }
            }
            if(j>=5){
                j=0;
                System.out.println("Warning: out of boundary");
            }
            SLComputer.buildingEffect[i]=j;
        }
        SLComputer.saveBuildingsToFile();
        powerAtt-=BBuildingEffect(2);
        powerDef-=BBuildingEffect(3);
        int hardness;
        int heroLevel;
        if(level<=10){
            heroLevel=1;
        }
        else if(level<=30){
            heroLevel=30;
        }
        else if(level<=120){
            heroLevel=50;
        }
        else{
            heroLevel=70;
        }
        double summary;
        for(hardness=0; hardness<3; hardness++){
            switch(hardness){
                case 0:
                    t=(Team)(jComboBoxCaptainHard.getSelectedItem());
                    t.number=jComboBoxEnemyNumberHard.getSelectedIndex()+1;
                    break;
                case 1:
                    t=(Team)(jComboBoxCaptainNorm.getSelectedItem());
                    t.number=jComboBoxEnemyNumberNorm.getSelectedIndex()+1;
                    break;
                case 2:
                    t=(Team)(jComboBoxCaptainEasy.getSelectedItem());
                    t.number=jComboBoxEnemyNumberEasy.getSelectedIndex()+1;
                    break;
                default:
                    System.out.println("jButton1ActionPerformed(): code should never be reached.");
                    return;
            }
            t.skillPower=enemySkillPower;
            t.skillRatePlus=enemySkillRate;
            t.skillRateMultiply=reducingSkillRate;
            t.powerAtt=powerAtt;
            t.powerDef=powerDef;
            for(i=0; i<t.number; i++){
                t.heros[i].level=heroLevel;
                if(t.heros[i].att_born>t.heros[i].def_born){
                    //t.heros[i].potential=(t.heros[i].att_born+(heroLevel-1)*t.heros[i].attGrowth)*1.05;
                    t.heros[i].potential=10000;
                }
                else{
                    //t.heros[i].potential=(t.heros[i].def_born+(heroLevel-1)*t.heros[i].defGrowth)*1.05;
                    t.heros[i].potential=10000;
                }
                if(i==0){
                    if(heroLevel>1){
                        t.heros[0].property_battle=20;
                    }
                    else{
                        t.heros[0].property_battle=t.heros[0].property;
                    }
                }
                else if(i==1){
                    if(heroLevel>30){
                        t.heros[1].property_battle=20;
                    }
                    else{
                        t.heros[1].property_battle=t.heros[1].property;
                    }
                }
                else if(i==2){
                    if(heroLevel>50){
                        t.heros[2].property_battle=20;
                    }
                    else{
                        t.heros[2].property_battle=t.heros[1].property;
                    }
                }
                else{
                    t.heros[i].property_battle=t.heros[i].property;
                }
                if(t.heros[i].weapon!=null){
                    t.heros[i].weapon.level=heroLevel;
                }
                if(t.heros[i].shield!=null){
                    t.heros[i].shield.level=heroLevel;
                }
            }
            summary=t.compute(1-mode, slData.basePlus[level-1][hardness], -powerDown*mode, -powerDown*(1-mode), slData.bodySkill[level-1][hardness], true);
            switch(hardness){
                case 0:
                    if(mode==0){
                        jLabelSumHard.setText(""+(int)summary);
                    }
                    else{
                        jLabelSumHard.setText(""+(int)summary);
                    }
                    break;
                case 1:
                    if(mode==0){
                        jLabelSumNorm.setText(""+(int)summary);
                    }
                    else{
                        jLabelSumNorm.setText(""+(int)summary);
                    }
                    break;
                default:
                    if(mode==0){
                        jLabelSumEasy.setText(""+(int)summary);
                    }
                    else{
                        jLabelSumEasy.setText(""+(int)summary);
                    }
                    break;
            }
            SLComputer.log(t.heros[0].name+" sum: "+summary);
            showEnemyTeam(hardness, t, mode);
        }
    }
    
    public void computeEnemySilent(int mode, int level, double HPM, double effectM, Team hardTeam, Team normTeam, Team easyTeam){
        Team t=null;
        SLData slData;
        if(mode==0){
            slData=SLComputer.QXSL;
        }
        else{
            slData=SLComputer.FYSL;
        }
        // 试炼每3层的减益
        double powerDown=HPM/100;
        double skillPowerDown=effectM/100;
        double enemySkillPower=slData.skillPower[level-1];
        double enemySkillRate=slData.skillRate[level-1];
        // 尾兽造成的技能几率减成
        double reducingSkillRate=0;
        enemySkillPower-=skillPowerDown;
        double powerAtt=0;
        double powerDef=0;
        int i, j;
        SLComputer.sacLevel=jComboBoxSacLevel.getSelectedIndex();
        for(i=0; i<5; i++){
            switch(jComboBoxPets[i].getSelectedIndex()){
                case 1:     // 一尾
                case 2:     // 二尾
                case 3:     // 三尾
                case 4:     // 四尾
                case 5:     // 五尾
                case 8:     // 八尾
                case 9:     // 九尾
                    break;
                case 6:     // 六尾
                    powerAtt=-Team.petBenefit(6, jComboBoxPetsLevel[i].getSelectedIndex())*Team.sacLevelBenefit(i, 6, SLComputer.sacLevel);
                    break;
                case 7:     // 七尾
                    reducingSkillRate-=Team.petBenefit(7, jComboBoxPetsLevel[i].getSelectedIndex())*Team.sacLevelBenefit(i, 7, SLComputer.sacLevel)/100;
                    break;
                case 10:
                    break;
                default:
                    break;
            }
        }
        // battle buildings
        for(i=0; i<6; i++){
            SLComputer.buildingLevel[i]=jComboBoxBBuildingLevel[i].getSelectedIndex();
            ButtonModel bm=buttonGroup[i].getSelection();
            for(j=0; j<5; j++){
                if(bm==jRadioButtons[i*5+j].getModel()){
                    break;
                }
            }
            if(j>=5){
                j=0;
                System.out.println("Warning: out of boundary");
            }
            SLComputer.buildingEffect[i]=j;
        }
        //SLComputer.saveBuildingsToFile();
        powerAtt-=BBuildingEffect(2);
        powerDef-=BBuildingEffect(3);
        int hardness;
        int heroLevel;
        if(level<=10){
            heroLevel=1;
        }
        else if(level<=30){
            heroLevel=30;
        }
        else if(level<=120){
            heroLevel=50;
        }
        else{
            heroLevel=70;
        }
        double summary;
        Team[] teams;
        for(hardness=0; hardness<3; hardness++){
            switch(hardness){
                case 0:
                    t=hardTeam;
                    break;
                case 1:
                    t=normTeam;
                    break;
                case 2:
                    t=easyTeam;
                    break;
                default:
                    System.out.println("computeEnemySilent(): code should never be reached.");
                    return;
            }
            t.skillPower=enemySkillPower;
            t.skillRatePlus=enemySkillRate;
            t.skillRateMultiply=reducingSkillRate;
            t.powerAtt=powerAtt;
            t.powerDef=powerDef;
            for(i=0; i<t.number; i++){
                t.heros[i].level=heroLevel;
                if(t.heros[i].att_born>t.heros[i].def_born){
                    t.heros[i].potential=10000;
                }
                else{
                    t.heros[i].potential=10000;
                }
                if(i==0){
                    if(heroLevel>1){
                        t.heros[0].property_battle=20;
                    }
                    else{
                        t.heros[0].property_battle=t.heros[0].property;
                    }
                }
                else if(i==1){
                    if(heroLevel>30){
                        t.heros[1].property_battle=20;
                    }
                    else{
                        t.heros[1].property_battle=t.heros[1].property;
                    }
                }
                else if(i==2){
                    if(heroLevel>50){
                        t.heros[2].property_battle=20;
                    }
                    else{
                        t.heros[2].property_battle=t.heros[1].property;
                    }
                }
                else{
                    t.heros[i].property_battle=t.heros[i].property;
                }
                if(t.heros[i].weapon!=null){
                    t.heros[i].weapon.level=heroLevel;
                }
                if(t.heros[i].shield!=null){
                    t.heros[i].shield.level=heroLevel;
                }
            }
            summary=t.compute(1-mode, slData.basePlus[level-1][hardness], -powerDown*mode, -powerDown*(1-mode), slData.bodySkill[level-1][hardness], true);
            SLComputer.log(t.heros[0].name+" sum: "+summary);
            //System.out.println("enemy"+hardness+" sum: "+summary);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        computeEnemy();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void showMyTeam(boolean save){
        int i, j;
        if(switchEnabled){
            jToggleButtonSwitch.doClick();
            return;
        }
        SLComputer.myTeam.skillPower=0;
        SLComputer.myTeam.skillRatePlus=0;
        SLComputer.myTeam.skillRateMultiply=0;
        SLComputer.myTeam.powerAtt=0;
        SLComputer.myTeam.powerDef=0;
        // 尾兽
        SLComputer.sacLevel=jComboBoxSacLevel.getSelectedIndex();
        for(i=0; i<5; i++){
            SLComputer.myTeam.powerUpbyProperty[i]=0;
        }
        for(i=0; i<5; i++){
            SLComputer.myTeam.pet[i]=jComboBoxPets[i].getSelectedIndex();
            SLComputer.myTeam.petLevel[i]=jComboBoxPetsLevel[i].getSelectedIndex();
            switch(SLComputer.myTeam.pet[i]){
                case 1:     // 一尾
                    jTabbedPanePets.setTitleAt(i, "守鹤");
                    SLComputer.myTeam.powerUpbyProperty[1]=Team.petBenefit(1, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 1, SLComputer.sacLevel);
                    break;
                case 2:     // 二尾
                    jTabbedPanePets.setTitleAt(i, "又旅");
                    SLComputer.myTeam.powerUpbyProperty[0]=Team.petBenefit(2, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 2, SLComputer.sacLevel);
                    break;
                case 3:     // 三尾
                    jTabbedPanePets.setTitleAt(i, "矶抚");
                    SLComputer.myTeam.powerUpbyProperty[2]=Team.petBenefit(3, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 3, SLComputer.sacLevel);
                    break;
                case 4:     // 四尾
                    jTabbedPanePets.setTitleAt(i, "孙悟空");
                    SLComputer.myTeam.powerUpbyProperty[3]=Team.petBenefit(4, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 4, SLComputer.sacLevel);
                    break;
                case 5:     // 五尾
                    jTabbedPanePets.setTitleAt(i, "穆王");
                    SLComputer.myTeam.powerUpbyProperty[4]=Team.petBenefit(5, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 5, SLComputer.sacLevel);
                    break;
                case 8:     // 八尾
                    jTabbedPanePets.setTitleAt(i, "牛鬼");
                    SLComputer.myTeam.powerDef=Team.petBenefit(8, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 8, SLComputer.sacLevel);
                    break;
                case 9:     // 九尾
                    jTabbedPanePets.setTitleAt(i, "九摩诃");
                    SLComputer.myTeam.powerAtt=Team.petBenefit(9, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 9, SLComputer.sacLevel);
                    break;
                case 6:
                    jTabbedPanePets.setTitleAt(i, "犀犬");
                    break;
                case 7:
                    jTabbedPanePets.setTitleAt(i, "重明");
                    break;
                case 10:
                    jTabbedPanePets.setTitleAt(i, "神树");
                    SLComputer.myTeam.petSkillRate=Team.petBenefit(10, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 10, SLComputer.sacLevel);
                    break;
                default:
                    jTabbedPanePets.setTitleAt(i, "<空>");
                    break;
            }
        }
        // battle buildings
        for(i=0; i<6; i++){
            SLComputer.buildingLevel[i]=jComboBoxBBuildingLevel[i].getSelectedIndex();
            ButtonModel bm=buttonGroup[i].getSelection();
            for(j=0; j<5; j++){
                if(bm==jRadioButtons[i*5+j].getModel()){
                    break;
                }
            }
            if(j>=5){
                j=0;
                System.out.println("Warning: out of boundary");
            }
            SLComputer.buildingEffect[i]=j;
        }
        SLComputer.saveBuildingsToFile();
        SLComputer.myTeam.powerAtt+=BBuildingEffect(0);
        SLComputer.myTeam.powerDef+=BBuildingEffect(1);
        SLComputer.myTeam.skillRateMultiply+=(BBuildingEffect(4)+BBuildingEffect(5))/100;
        // determine numberMax
        for(i=0; i<jButtonHeroChoosers.length; i++){
            if(SLComputer.myTeam.heros[i]==null || SLComputer.myTeam.heros[i].id==0){
                break;
            }
        }
        SLComputer.myTeam.numberMax=SLComputer.myTeam.number=i;
        double SLup;
        double SLSkillUp;
        try{
            SLup=Double.parseDouble(jTextFieldPlus.getText())/100;
        }catch(Exception e){
            SLup=0;
        }
        try{
            SLSkillUp=Double.parseDouble(jTextFieldSkillPlus.getText())/100;
        }catch(Exception e){
            SLSkillUp=0;
        }
        SLComputer.myTeam.skillPower+=SLSkillUp;
        int mode=jComboBoxMode.getSelectedIndex();
        double summary=SLComputer.myTeam.compute(mode+2, 1, SLup*(1-mode), SLup*mode, 0, SLComputer.dreamMode);
        SLComputer.log("My Team sum: "+summary);
        jLabelMyAtt.setText("总攻击："+(int)SLComputer.myTeam.sumUp(0));
        jLabelMyDef.setText("总防御："+(int)SLComputer.myTeam.sumUp(1));
        jPanelMyTeam.removeAll();
        jPanelMyTeam.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jPanelMyTeam.setPreferredSize(new Dimension(LABELW*SLComputer.myTeam.number, LABELH+19));
        ImageIcon icon;
        int showValueAtt, showValueDef;
        for(i=0; i<jButtonHeroChoosers.length; i++){
            if(i<SLComputer.myTeam.number){
                jButtonHeroChoosers[i].setText(SLComputer.myTeam.heros[i].toString());
            }
            else{
                jButtonHeroChoosers[i].setText("[未选取]");
            }
        }
        String tooltip, color;
        double powerFromPet;
        for(i=0; i<SLComputer.myTeam.number; i++){
            /* System.out.print(SLComputer.myTeam.heros[i].name);
            if(SLComputer.myTeam.heros[i].skill1!=null) System.out.print(": "+SLComputer.myTeam.heros[i].skill1.name);
            if(SLComputer.myTeam.heros[i].skill2!=null) System.out.print(", "+SLComputer.myTeam.heros[i].skill2.name);
            System.out.print("\n"); */
            jLabelMyTeam[i].setPreferredSize(new Dimension(LABELW, LABELH+19));
            icon=new ImageIcon("TP/"+SLComputer.myTeam.heros[i].hid+"_big.png.png");
            if(icon.getIconWidth()==128){
                icon.setImage(icon.getImage().getScaledInstance(LABELW/2, -1, Image.SCALE_DEFAULT));
            }
            else{
                icon.setImage(icon.getImage().getScaledInstance(LABELW, -1, Image.SCALE_DEFAULT));
            }
            jLabelMyTeam[i].setIcon(icon);
            jLabelMyTeam[i].setVerticalAlignment(javax.swing.JLabel.TOP);
            jLabelMyTeam[i].setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
            jLabelMyTeam[i].setHorizontalAlignment(javax.swing.JLabel.CENTER);
            jLabelMyTeam[i].setHorizontalTextPosition(javax.swing.JLabel.CENTER);
            showValueDef=(int)(SLComputer.myTeam.heros[i].def);
            showValueAtt=(int)(SLComputer.myTeam.heros[i].att);
            jLabelMyTeam[i].setText("<html>"+SLComputer.myTeam.heros[i].toStringWithoutHtml()+" "+Hero.propertyToString(SLComputer.myTeam.heros[i].property_battle)
                    +"<br>攻 "+showValueAtt+"<br>防 "+showValueDef+"</html>");
            tooltip="";
            powerFromPet=0;
            if(SLComputer.myTeam.heros[i].property_battle==20){
                for(j=0; j<SLComputer.myTeam.powerUpbyProperty.length; j++){
                    if(powerFromPet<SLComputer.myTeam.powerUpbyProperty[j]){
                        powerFromPet=SLComputer.myTeam.powerUpbyProperty[j];
                    }
                }
            }
            else{
                powerFromPet=SLComputer.myTeam.powerUpbyProperty[SLComputer.myTeam.heros[i].property_battle%5];
            }
            for(j=0; j<SLComputer.myTeam.heros[i].yuanNames.length; j++){
                if(SLComputer.myTeam.heros[i].yuanNames==null){
                    break;
                }
                if(SLComputer.myTeam.heros[i].yuanActivated[j]){
                    color="<font color=#FF4500>";
                }
                else{
                    color="<font color=#999999>";
                }
                if(tooltip.equals("")){
                    tooltip+="<html>缘：<br>"+color+SLComputer.myTeam.heros[i].yuanNames[j]+"</font>";
                }
                else{
                    tooltip+="<br>"+color+SLComputer.myTeam.heros[i].yuanNames[j]+"</font>";
                }
            }
            if(SLComputer.myTeam.heros[i].skill1!=null){
                if(tooltip.equals("")){
                    tooltip+="<html>";
                }
                else{
                    tooltip+="<br><br>";
                }
                tooltip+=SLComputer.myTeam.heros[i].skill1.name+skillLevelToString(SLComputer.myTeam.heros[i].skill1.level)
                        +"<br>"+SLComputer.myTeam.heros[i].skill1.description(SLComputer.myTeam.skillPower*100+SLComputer.myTeam.heros[i].powerRatio, powerFromPet/100, 0, SLComputer.myTeam.skillRateMultiply+SLComputer.myTeam.heros[i].rateRatio/100);
            }
            if(SLComputer.myTeam.heros[i].skill2!=null){
                if(tooltip.equals("")){
                    tooltip+="<html>";
                }
                else{
                    tooltip+="<br>";
                }
                tooltip+=SLComputer.myTeam.heros[i].skill2.name+skillLevelToString(SLComputer.myTeam.heros[i].skill2.level)
                        +"<br>"+SLComputer.myTeam.heros[i].skill2.description(SLComputer.myTeam.skillPower*100+SLComputer.myTeam.heros[i].powerRatio, powerFromPet/100, 0, SLComputer.myTeam.skillRateMultiply+SLComputer.myTeam.heros[i].rateRatio/100);
            }
            if(tooltip.equals("")){
                tooltip+="<html>";
            }
            else{
                tooltip+="<br>";
            }
            tooltip+="一些数据：<br>敌方忍术效果达到<font color=#FF0000>"+(int)(10000/(100-SLComputer.myTeam.heros[i].resist))+"</font>%时将被打成1血";
            tooltip+="<br>夺取差值类技能效果小于<font color=#FF0000>"+(int)(5000/(100-SLComputer.myTeam.heros[i].resist))+"</font>%时安全</html>";
            jLabelMyTeam[i].setToolTipText(tooltip);
            jPanelMyTeam.add(jLabelMyTeam[i]);
        }
        jPanelMyTeam.validate();
        jPanelMyTeam.repaint();
        if(save){
            SLComputer.saveTeamToFile(SLComputer.myTeam);
        }
    }
    
    public void showMyTeamSilent(int mode, double HPP, double effectP){
        int i, j;
        SLComputer.myTeam.skillPower=0;
        SLComputer.myTeam.skillRatePlus=0;
        SLComputer.myTeam.skillRateMultiply=0;
        SLComputer.myTeam.powerAtt=0;
        SLComputer.myTeam.powerDef=0;
        // 尾兽
        SLComputer.sacLevel=jComboBoxSacLevel.getSelectedIndex();
        for(i=0; i<5; i++){
            SLComputer.myTeam.powerUpbyProperty[i]=0;
        }
        for(i=0; i<5; i++){
            SLComputer.myTeam.pet[i]=jComboBoxPets[i].getSelectedIndex();
            SLComputer.myTeam.petLevel[i]=jComboBoxPetsLevel[i].getSelectedIndex();
            switch(SLComputer.myTeam.pet[i]){
                case 1:     // 一尾
                    SLComputer.myTeam.powerUpbyProperty[1]=Team.petBenefit(1, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 1, SLComputer.sacLevel);
                    break;
                case 2:     // 二尾
                    SLComputer.myTeam.powerUpbyProperty[0]=Team.petBenefit(2, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 2, SLComputer.sacLevel);
                    break;
                case 3:     // 三尾
                    SLComputer.myTeam.powerUpbyProperty[2]=Team.petBenefit(3, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 3, SLComputer.sacLevel);
                    break;
                case 4:     // 四尾
                    SLComputer.myTeam.powerUpbyProperty[3]=Team.petBenefit(4, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 4, SLComputer.sacLevel);
                    break;
                case 5:     // 五尾
                    SLComputer.myTeam.powerUpbyProperty[4]=Team.petBenefit(5, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 5, SLComputer.sacLevel);
                    break;
                case 8:     // 八尾
                    SLComputer.myTeam.powerDef=Team.petBenefit(8, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 8, SLComputer.sacLevel);
                    break;
                case 9:     // 九尾
                    SLComputer.myTeam.powerAtt=Team.petBenefit(9, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 9, SLComputer.sacLevel);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 10:
                    SLComputer.myTeam.petSkillRate=Team.petBenefit(10, SLComputer.myTeam.petLevel[i])*Team.sacLevelBenefit(i, 10, SLComputer.sacLevel);
                    break;
                default:
                    break;
            }
        }
        // battle buildings
        for(i=0; i<6; i++){
            SLComputer.buildingLevel[i]=jComboBoxBBuildingLevel[i].getSelectedIndex();
            ButtonModel bm=buttonGroup[i].getSelection();
            for(j=0; j<5; j++){
                if(bm==jRadioButtons[i*5+j].getModel()){
                    break;
                }
            }
            if(j>=5){
                j=0;
                System.out.println("Warning: out of boundary");
            }
            SLComputer.buildingEffect[i]=j;
        }
        SLComputer.myTeam.powerAtt+=BBuildingEffect(0);
        SLComputer.myTeam.powerDef+=BBuildingEffect(1);
        SLComputer.myTeam.skillRateMultiply+=(BBuildingEffect(4)+BBuildingEffect(5))/100;

        // determine numberMax
        for(i=0; i<jButtonHeroChoosers.length; i++){
            if(SLComputer.myTeam.heros[i]==null || SLComputer.myTeam.heros[i].id==0){
                break;
            }
        }
        SLComputer.myTeam.numberMax=SLComputer.myTeam.number=i;
        double SLup=HPP/100;
        double SLSkillUp=effectP/100;
        SLComputer.myTeam.skillPower+=SLSkillUp;
        double summary=SLComputer.myTeam.compute(mode+2, 1, SLup*(1-mode), SLup*mode, 0, SLComputer.dreamMode);
        SLComputer.log("My Team sum: "+summary);
    }
    
    private void jButtonShowMyTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowMyTeamActionPerformed
        showMyTeam(true);
    }//GEN-LAST:event_jButtonShowMyTeamActionPerformed

    public void goHard(){
        computeEnemy();
        jTabbedPaneEnemy.setSelectedIndex(0);
        showMyTeam(true);
        int mode=jComboBoxMode.getSelectedIndex();
        int number=jComboBoxMyNumberHard.getSelectedIndex()+1;
        if(number<SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=number;
        }
        int killFirst=-1;
        if(jCheckBoxKillFirst.isSelected()){
            if(mode==0){
                killFirst=1;
            }
            else{
                killFirst=0;
            }
        }
        jLabelSumHard.setText(jLabelSumHard.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        int result;
        SLComputer.bf.output=jTextPaneBattleField;
        if(mode==0){
            result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainHard.getSelectedItem()), killFirst);
            if(result==1 || result==2){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
        else{
            result=SLComputer.bf.battle((Team)(jComboBoxCaptainHard.getSelectedItem()), SLComputer.myTeam, killFirst);
            if(result==0){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
    }
    
    private void jButtonGoHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoHardActionPerformed
        if(SocketMaster.globalReady){
            SocketMaster.arguments[0]=0;
            SocketMaster sm=new SocketMaster();
            SocketMaster.cmdGlobal=SocketMaster.c_bb_battle;
            new Thread(sm).start();
            return;
        }
        goHard();
    }//GEN-LAST:event_jButtonGoHardActionPerformed

    public void goNorm(){
        computeEnemy();
        jTabbedPaneEnemy.setSelectedIndex(1);
        showMyTeam(true);
        int mode=jComboBoxMode.getSelectedIndex();
        int number=jComboBoxMyNumberNorm.getSelectedIndex()+1;
        if(number<SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=number;
        }
        int killFirst=-1;
        if(jCheckBoxKillFirst.isSelected()){
            if(mode==0){
                killFirst=1;
            }
            else{
                killFirst=0;
            }
        }
        jLabelSumNorm.setText(jLabelSumNorm.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        int result;
        SLComputer.bf.output=jTextPaneBattleField;
        if(mode==0){
            result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainNorm.getSelectedItem()), killFirst);
            if(result==1 || result==2){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
        else{
            result=SLComputer.bf.battle((Team)(jComboBoxCaptainNorm.getSelectedItem()), SLComputer.myTeam, killFirst);
            if(result==0){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
    }
    
    private void jButtonGoNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoNormActionPerformed
        if(SocketMaster.globalReady){
            SocketMaster.arguments[0]=1;
            SocketMaster sm=new SocketMaster();
            SocketMaster.cmdGlobal=SocketMaster.c_bb_battle;
            new Thread(sm).start();
            return;
        }
        goNorm();
    }//GEN-LAST:event_jButtonGoNormActionPerformed

    public void goEasy(){
        computeEnemy();
        jTabbedPaneEnemy.setSelectedIndex(2);
        showMyTeam(true);
        int mode=jComboBoxMode.getSelectedIndex();
        int number=jComboBoxMyNumberEasy.getSelectedIndex()+1;
        if(number<SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=number;
        }
        int killFirst=-1;
        if(jCheckBoxKillFirst.isSelected()){
            if(mode==0){
                killFirst=1;
            }
            else{
                killFirst=0;
            }
        }
        jLabelSumEasy.setText(jLabelSumEasy.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        int result;
        SLComputer.bf.output=jTextPaneBattleField;
        if(mode==0){
            result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainEasy.getSelectedItem()), killFirst);
            if(result==1 || result==2){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
        else{
            result=SLComputer.bf.battle((Team)(jComboBoxCaptainEasy.getSelectedItem()), SLComputer.myTeam, killFirst);
            if(result==0){
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"获胜！\n");
            }
            else{
                jTextPaneBattleField.setText(SLComputer.bf.allMsg+"失败...\n");
            }
        }
    }
    
    private void jButtonGoEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoEasyActionPerformed
        if(SocketMaster.globalReady){
            SocketMaster.arguments[0]=2;
            SocketMaster sm=new SocketMaster();
            SocketMaster.cmdGlobal=SocketMaster.c_bb_battle;
            new Thread(sm).start();
            return;
        }
        goEasy();
    }//GEN-LAST:event_jButtonGoEasyActionPerformed

    public double[] finalComputerSilent(int mode, int level, double HPP, double effectP, double HPM, double effectM, int killFirst,
            int hardTeamNum, int normTeamNum, int easyTeamNum,
            int hardNum, int normNum, int easyNum){
        SLComputer.bf.output=null;
        if(killFirst>0){
            killFirst=1-mode;
        }
        else{
            killFirst=-1;
        }
        int result, i;
        Team[] teams;
        Team hard, norm, easy;
        
        if(mode==0){
            teams=SLComputer.QXSL.teamsHard;
        }
        else{
            teams=SLComputer.FYSL.teamsHard;
        }
        hard=teams[hardTeamNum%100-1];
        hard.number=hardNum;
        
        if(mode==0){
            teams=SLComputer.QXSL.teamsNorm;
        }
        else{
            teams=SLComputer.FYSL.teamsNorm;
        }
        norm=teams[normTeamNum%100-1];
        norm.number=normNum;
        
        if(mode==0){
            teams=SLComputer.QXSL.teamsEasy;
        }
        else{
            teams=SLComputer.FYSL.teamsEasy;
        }
        easy=teams[easyTeamNum%100-1];
        easy.number=easyNum;
        
        computeEnemySilent(mode, level, HPM, effectM, hard, norm, easy);
        showMyTeamSilent(mode, HPP, effectP);
        switch(SLComputer.sNumber){
            case 1:
                trialNumber=200;
                break;
            case 2:
                trialNumber=500;
                break;
            case 3:
                trialNumber=1000;
                break;
            case 4:
                trialNumber=5000;
                break;
            case 5:
                trialNumber=10000;
                break;
            default:
                trialNumber=100;
                break;
        }
        int winTimes;
        String recommend;
        double[] rate={0, 0, 0};
        // 高难
        winTimes=0;
        SLComputer.myTeam.number=normNum;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, hard, killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle(hard, SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rate[0]=(winTimes*100)/(double)trialNumber;
        // 普通
        winTimes=0;
        SLComputer.myTeam.number=normNum;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, norm, killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle(norm, SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rate[1]=(winTimes*100)/(double)trialNumber;
        // 菜鸟
        winTimes=0;
        SLComputer.myTeam.number=normNum;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, easy, killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle(easy, SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rate[2]=(winTimes*100)/(double)trialNumber;
        
        SLComputer.log("困难 "+hard.heros[0].name+" "+normNum+"v"+hardNum+" "+rate[0]);
        SLComputer.log("普通 "+norm.heros[0].name+" "+normNum+"v"+normNum+" "+rate[1]);
        SLComputer.log("容易 "+easy.heros[0].name+" "+normNum+"v"+easyNum+" "+rate[2]);
        return rate;
    }
    
    public void finalComputer(){
        SLComputer.bf.output=null;
        computeEnemy();
        showMyTeam(true);
        int mode=jComboBoxMode.getSelectedIndex();
        int level=Integer.parseInt(jTextFieldLevel.getText());
        int killFirst=-1;
        if(jCheckBoxKillFirst.isSelected()){
            if(mode==0){
                killFirst=1;
            }
            else{
                killFirst=0;
            }
        }
        switch(SLComputer.sNumber){
            case 1:
                trialNumber=200;
                break;
            case 2:
                trialNumber=500;
                break;
            case 3:
                trialNumber=1000;
                break;
            case 4:
                trialNumber=5000;
                break;
            case 5:
                trialNumber=10000;
                break;
            default:
                trialNumber=100;
                break;
        }
        int winTimes;
        int result, i;
        String recommend;
        double rateHard, rateNorm, rateEasy;
        // 高难
        winTimes=0;
        SLComputer.myTeam.number=jComboBoxMyNumberHard.getSelectedIndex()+1;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        jLabelSumHard.setText(jLabelSumHard.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainHard.getSelectedItem()), killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle((Team)(jComboBoxCaptainHard.getSelectedItem()), SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rateHard=(winTimes*100)/(double)trialNumber;
        jLabelPHard.setText("胜率："+(int)(rateHard)+"%");
        // 普通
        winTimes=0;
        SLComputer.myTeam.number=jComboBoxMyNumberNorm.getSelectedIndex()+1;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        jLabelSumNorm.setText(jLabelSumNorm.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainNorm.getSelectedItem()), killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle((Team)(jComboBoxCaptainNorm.getSelectedItem()), SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rateNorm=(winTimes*100)/(double)trialNumber;
        jLabelPNorm.setText("胜率："+(int)(rateNorm)+"%");
        // 菜鸟
        winTimes=0;
        SLComputer.myTeam.number=jComboBoxMyNumberEasy.getSelectedIndex()+1;
        if(SLComputer.myTeam.number>SLComputer.myTeam.numberMax){
            SLComputer.myTeam.number=SLComputer.myTeam.numberMax;
        }
        jLabelSumEasy.setText(jLabelSumEasy.getText()+" (VS "+(int)SLComputer.myTeam.sumUp(mode)+")");
        for(i=0; i<trialNumber; i++){
            if(mode==0){
                result=SLComputer.bf.battle(SLComputer.myTeam, (Team)(jComboBoxCaptainEasy.getSelectedItem()), killFirst);
                if(result==1 || result==2){
                    winTimes++;
                }
            }
            else{
                result=SLComputer.bf.battle((Team)(jComboBoxCaptainEasy.getSelectedItem()), SLComputer.myTeam, killFirst);
                if(result==0){
                    winTimes++;
                }
            }
        }
        rateEasy=(winTimes*100)/(double)trialNumber;
        jLabelPEasy.setText("胜率："+(int)(rateEasy)+"%");
/*        if(rateHard>80){
            recommend="高难";
        }
        else if(rateNorm>80){
            recommend="普通";
        }
        else if(rateHard>=rateEasy && rateHard>=rateNorm){
            recommend="高难";
        }
        else if(rateNorm>=rateEasy && rateNorm>=rateHard){
            recommend="普通";
        }
        else{
            recommend="菜鸟";
        }
        * */
        DecimalFormat decimalFormat = new DecimalFormat("###.00");
        recommend="第"+level+"层\n"
                + "敌方忍术效果额外提升"+(int)(SLComputer.FYSL.skillPower[level-1]*100)+"%\n"
                + "敌方忍术几率额外提升"+(int)(SLComputer.FYSL.skillRate[level-1]*100)+"%\n"
                + "敌方体术附加"+(int)SLComputer.FYSL.bodySkill[level-1][0]+"\n"+
                "高难胜率："+decimalFormat.format(rateHard)+"%\n"+
                "普通胜率："+decimalFormat.format(rateNorm)+"%\n"+
                "菜鸟胜率："+decimalFormat.format(rateEasy)+"%\n\n";
        jTextPaneBattleField.setText(recommend);
    }
    
    private void jButtonFinalComputerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalComputerActionPerformed
        finalComputer();
    }//GEN-LAST:event_jButtonFinalComputerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //jTextAreaBattleField.setText(SLComputer.copyright+"\n");
        jTextPaneBattleField.setText(SLComputer.author+"\n"+SLComputer.usage);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeftActionPerformed
        int level;
        jCheckBoxKillFirst.setSelected(false);
        try{
            level=Integer.parseInt(jTextFieldLevel.getText());
        }
        catch(Exception e){
            return;
        }
        if(level>1){
            level--;
        }
        jTextFieldLevel.setText(level+"");
    }//GEN-LAST:event_jButtonLeftActionPerformed

    private void jButtonRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRightActionPerformed
        int level=1;
        jCheckBoxKillFirst.setSelected(false);
        try{
            level=Integer.parseInt(jTextFieldLevel.getText());
        }
        catch(Exception e){
            return;
        }
        if(level<SLComputer.QXSL.skillPower.length){
            level++;
        }
        jTextFieldLevel.setText(level+"");
    }//GEN-LAST:event_jButtonRightActionPerformed

    private void jComboBoxMyNumberNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMyNumberNormActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int index=jComboBoxMyNumberNorm.getSelectedIndex();
        //if(jComboBoxEnemyNumberNorm.getSelectedIndex()!=index){
            jComboBoxEnemyNumberNorm.setSelectedIndex(index);
        //}
    }//GEN-LAST:event_jComboBoxMyNumberNormActionPerformed

    private void jComboBoxEnemyNumberNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEnemyNumberNormActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int index=jComboBoxEnemyNumberNorm.getSelectedIndex();
        //if(index<14 && jComboBoxMyNumberEasy.getSelectedIndex()!=index){
            jComboBoxMyNumberEasy.setSelectedIndex(index);
        //}
    }//GEN-LAST:event_jComboBoxEnemyNumberNormActionPerformed

    private void jComboBoxMyNumberEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMyNumberEasyActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int index=jComboBoxMyNumberEasy.getSelectedIndex();
        //if(jComboBoxEnemyNumberEasy.getSelectedIndex()!=index){
            jComboBoxEnemyNumberEasy.setSelectedIndex(index);
        //}
        //if(jComboBoxMyNumberHard.getSelectedIndex()!=index){
            jComboBoxMyNumberHard.setSelectedIndex(index);
        //}
    }//GEN-LAST:event_jComboBoxMyNumberEasyActionPerformed

    private void jComboBoxMyNumberHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMyNumberHardActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int index=jComboBoxMyNumberHard.getSelectedIndex();
        //if(jComboBoxEnemyNumberHard.getSelectedIndex()!=index){
            jComboBoxEnemyNumberHard.setSelectedIndex(index);
        //}
        //if(jComboBoxMyNumberNorm.getSelectedIndex()!=index){
            jComboBoxMyNumberNorm.setSelectedIndex(index);
        //}
    }//GEN-LAST:event_jComboBoxMyNumberHardActionPerformed

    private void jButtonMyTeam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyTeam1ActionPerformed
        SLComputer.myTeam=SLComputer.backupTeams[jComboBoxMode.getSelectedIndex()];
        int i;
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jButtonMyTeam1.setForeground(Color.red);
        jButtonMyTeam2.setForeground(Color.darkGray);
        jButtonMyTeam3.setForeground(Color.darkGray);
        jButtonMyTeam4.setForeground(Color.darkGray);
        showMyTeam(false);
    }//GEN-LAST:event_jButtonMyTeam1ActionPerformed

    private void jButtonMyTeam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyTeam2ActionPerformed
        SLComputer.myTeam=SLComputer.backupTeams[jComboBoxMode.getSelectedIndex()+2];
        int i;
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jButtonMyTeam1.setForeground(Color.darkGray);
        jButtonMyTeam2.setForeground(Color.red);
        jButtonMyTeam3.setForeground(Color.darkGray);
        jButtonMyTeam4.setForeground(Color.darkGray);
        showMyTeam(false);
    }//GEN-LAST:event_jButtonMyTeam2ActionPerformed

    private void jButtonMyTeam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyTeam3ActionPerformed
        SLComputer.myTeam=SLComputer.backupTeams[jComboBoxMode.getSelectedIndex()+4];
        int i;
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jButtonMyTeam1.setForeground(Color.darkGray);
        jButtonMyTeam2.setForeground(Color.darkGray);
        jButtonMyTeam3.setForeground(Color.red);
        jButtonMyTeam4.setForeground(Color.darkGray);
        showMyTeam(false);
    }//GEN-LAST:event_jButtonMyTeam3ActionPerformed

    private void jButtonMyTeam4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMyTeam4ActionPerformed
        SLComputer.myTeam=SLComputer.backupTeams[jComboBoxMode.getSelectedIndex()+6];
        int i;
        for(i=0; i<5; i++){
            jComboBoxPets[i].setSelectedIndex(SLComputer.myTeam.pet[i]);
            jComboBoxPetsLevel[i].setSelectedIndex(SLComputer.myTeam.petLevel[i]);
        }
        jButtonMyTeam1.setForeground(Color.darkGray);
        jButtonMyTeam2.setForeground(Color.darkGray);
        jButtonMyTeam3.setForeground(Color.darkGray);
        jButtonMyTeam4.setForeground(Color.red);
        showMyTeam(false);
    }//GEN-LAST:event_jButtonMyTeam4ActionPerformed

    private void jButtonCopyTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopyTeamActionPerformed
        SLComputer.teamCache=SLComputer.myTeam.copy();
    }//GEN-LAST:event_jButtonCopyTeamActionPerformed

    private void jButtonPasteTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasteTeamActionPerformed
        if(SLComputer.teamCache==null){
            return;
        }
        int i;
        for(i=0; i<SLComputer.backupTeams.length; i++){
            if(SLComputer.myTeam==SLComputer.backupTeams[i]){
                break;
            }
        }
        if(i>=SLComputer.backupTeams.length){
            return;
        }
        SLComputer.backupTeams[i]=SLComputer.teamCache.copy();
        SLComputer.myTeam=SLComputer.backupTeams[i];
        showMyTeam(false);
    }//GEN-LAST:event_jButtonPasteTeamActionPerformed

    private void jCheckBoxMenuItemSmartNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemSmartNumberActionPerformed
        SLComputer.smartNumber=jCheckBoxMenuItemSmartNumber.isSelected();
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jCheckBoxMenuItemSmartNumberActionPerformed

    private void jRadioButtonMenuItemSimulationTimes100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes100ActionPerformed
        SLComputer.sNumber=0;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes100ActionPerformed

    private void jRadioButtonMenuItemSimulationTimes200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes200ActionPerformed
        SLComputer.sNumber=1;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes200ActionPerformed

    private void jRadioButtonMenuItemSimulationTimes500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes500ActionPerformed
        SLComputer.sNumber=2;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes500ActionPerformed

    private void jRadioButtonMenuItemSimulationTimes1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes1000ActionPerformed
        SLComputer.sNumber=3;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes1000ActionPerformed

    private void jComboBoxEnemyNumberHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEnemyNumberHardActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int i=jComboBoxEnemyNumberHard.getSelectedIndex();
        int j=jComboBoxMyNumberHard.getSelectedIndex();
        if(i>=j){
            i=j-(i-j);
            if(i>=0 && i<17){
                jComboBoxEnemyNumberEasy.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jComboBoxEnemyNumberHardActionPerformed

    private void jComboBoxEnemyNumberEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEnemyNumberEasyActionPerformed
        if(!SLComputer.smartNumber){
            return;
        }
        int i=jComboBoxEnemyNumberEasy.getSelectedIndex();
        int j=jComboBoxMyNumberEasy.getSelectedIndex();
        if(i<=j){
            i=j+(j-i);
            if(i>=0 && i<17){
                jComboBoxEnemyNumberHard.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_jComboBoxEnemyNumberEasyActionPerformed

    private void jRadioButtonMenuItemSimulationTimes3000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes3000ActionPerformed
        SLComputer.sNumber=4;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes3000ActionPerformed

    private void jRadioButtonMenuItemSimulationTimes10000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSimulationTimes10000ActionPerformed
        SLComputer.sNumber=5;
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jRadioButtonMenuItemSimulationTimes10000ActionPerformed

    private void jToggleButtonSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSwitchActionPerformed
        switchEnabled=jToggleButtonSwitch.isSelected();
        int i;
        if(switchEnabled){
            for(i=0; i<jButtonHeroChoosers.length; i++){
                if(i<SLComputer.myTeam.numberMax){
                    jButtonHeroChoosers[i].setBackground(Color.gray);
                    jButtonHeroChoosers[i].setToolTipText("<html>先选中任意一个上阵忍者，再点击想要交换位置的忍者即可交换位置。"
                            + "<br>再次点击“排兵布阵”退出此模式。</html>");
                }
                else{
                    jButtonHeroChoosers[i].setEnabled(false);
                }
            }
        }
        else{
            for(i=0; i<jButtonHeroChoosers.length; i++){
                jButtonHeroChoosers[i].setEnabled(true);
                jButtonHeroChoosers[i].setBackground(null);
                jButtonHeroChoosers[i].setToolTipText(null);
            }
            if(evt!=null){
                showMyTeam(true);
            }
        }
    }//GEN-LAST:event_jToggleButtonSwitchActionPerformed

    private void jCheckBoxMenuItemSaveBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemSaveBEActionPerformed
        SLComputer.saveBE=jCheckBoxMenuItemSaveBE.isSelected();
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jCheckBoxMenuItemSaveBEActionPerformed

    private void jCheckBoxMenuItemDreamModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemDreamModeActionPerformed
        SLComputer.dreamMode=jCheckBoxMenuItemDreamMode.isSelected();
        SLComputer.saveConfigToFile();
        new Animator();
    }//GEN-LAST:event_jCheckBoxMenuItemDreamModeActionPerformed

    private void jButtonLoveHutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoveHutActionPerformed
        new LoveHut(this, true, SLComputer.myTeam.backHeros);
        int i;
        for(i=0; i<SLComputer.myTeam.backHeros.length; i++){
            if(SLComputer.myTeam.backHeros[i]==null){
                break;
            }
        }
        SLComputer.myTeam.backNumber=i;
        javax.swing.JButton button=(javax.swing.JButton)evt.getSource();
        if(SLComputer.myTeam.backNumber>0){
            String tooltip="<html>";
            for(i=0; i<SLComputer.myTeam.backNumber; i++){
                tooltip+=SLComputer.myTeam.backHeros[i].toStringWithoutHtml()+" ";
            }
            tooltip+="</html>";
            button.setToolTipText(tooltip);
        }
        else{
            button.setToolTipText(null);
        }
    }//GEN-LAST:event_jButtonLoveHutActionPerformed

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        //JOptionPane.showMessageDialog(this, "该功能正在完善中……\n功能预览：可以在此登陆你的账号，然后直接在此工具内查阵容和打试炼，和在游戏内打试炼是一样的。\n如果不需要换阵的话，可以支持自动打试炼，无脑困难点到手酸的日子将一去不复返。\n旗舰版用户还会有神秘功能哦！", "敬请期待", JOptionPane.INFORMATION_MESSAGE);
        SLComputer.smartNumber_bk=SLComputer.smartNumber;
        new JDialogLogin(this, true);
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        if(SocketMaster.globalReady){
            JOptionPane.showMessageDialog(SLComputer.mf, SocketMaster.globalName+" 已登出。恢复普通模式。", "注销", JOptionPane.INFORMATION_MESSAGE);
        }
        SLComputer.cleanLogin();
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jCheckBoxKillFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxKillFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxKillFirstActionPerformed

    private void jMenuItemWatchBattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemWatchBattleActionPerformed
        SLComputer.watchBattle=jMenuItemWatchBattle.isSelected();
        SLComputer.saveConfigToFile();
    }//GEN-LAST:event_jMenuItemWatchBattleActionPerformed

    private void jMenuItemAutoBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutoBBActionPerformed
        new JDialogAutoBB(this, true, maxLevel, rate, HPPTarget, HPMTarget, EffectPTarget, EffectMTarget, 
                HPPMax, HPMMax, EffectPMax, EffectMMax, sleepTime);
    }//GEN-LAST:event_jMenuItemAutoBBActionPerformed

    // 设置模式
    public void setMode(int mode){
        if(mode==0 || mode==1){
            if(jComboBoxMode.getSelectedIndex()!=mode){
                jComboBoxMode.setSelectedIndex(mode);
            }
        }
    }
    
    // 设置层数，输入level=0 为第一层
    public void setLevel(int level){
        if(level>=0){
            jTextFieldLevel.setText(level+1+"");
        }
    }
    
    // 设置buff，所有数字将直接填写到对应位置，-1代表该buff不变
    public void setBuff(int hpP, int hpM, int effectP, int effectM, boolean killFirst){
        if(hpP>=0){
            jTextFieldPlus.setText(hpP+"");
        }
        if(hpM>=0){
            jTextFieldMinus.setText(hpM+"");
        }
        if(effectP>=0){
            jTextFieldSkillPlus.setText(effectP+"");
        }
        if(effectM>=0){
            jTextFieldSkillMinus.setText(effectM+"");
        }
        jCheckBoxKillFirst.setSelected(killFirst);
    }
    
    // 设置敌人队伍，输入应该至少为1
    public void setEnemy(int hard, int normal, int easy){
        if(hard>0 && hard<=jComboBoxCaptainHard.getItemCount()){
            jComboBoxCaptainHard.setSelectedIndex(hard-1);
        }
        if(normal>0 && normal<=jComboBoxCaptainNorm.getItemCount()){
            jComboBoxCaptainNorm.setSelectedIndex(normal-1);
        }
        if(easy>0 && easy<=jComboBoxCaptainEasy.getItemCount()){
            jComboBoxCaptainEasy.setSelectedIndex(easy-1);
        }
    }
    
    // 设置敌我数量，1代表上阵1人
    public void setNumbers(int myNumber, int enemyHardNumber){
        if(myNumber>0 && myNumber<=jComboBoxMyNumberHard.getItemCount()){
            jComboBoxMyNumberHard.setSelectedIndex(myNumber-1);
            //jComboBoxMyNumberNorm.setSelectedIndex(myNumber-1);
            //jComboBoxMyNumberEasy.setSelectedIndex(myNumber-1);
        }
        if(enemyHardNumber>0 && enemyHardNumber<=jComboBoxEnemyNumberHard.getItemCount()){
            jComboBoxEnemyNumberHard.setSelectedIndex(enemyHardNumber-1);
            //jComboBoxEnemyNumberNorm.setSelectedIndex(myNumber-1);
            //jComboBoxEnemyNumberEasy.setSelectedIndex(2*myNumber-enemyHardNumber-1);
        }
    }
    
    // 设置战斗详情
    public void setDetails(String detail){
        jTextPaneBattleField.setText(detail);
    }
    
    // 强调挑战按钮
    public void emphasizeBattleButtons(boolean emph){
        Color c;
        if(emph){
            c=Color.red;
        }
        else{
            c=Color.black;
        }
        jButtonGoHard.setForeground(c);
        jButtonGoNorm.setForeground(c);
        jButtonGoEasy.setForeground(c);
    }
    
    public void setSmartNumber(boolean sn){
        jCheckBoxMenuItemSmartNumber.setSelected(sn);
    }
    
    public boolean isSmartNumberMenuItemSelected(){
        return jCheckBoxMenuItemSmartNumber.isSelected();
    }
    
    public void enableAutoBB(boolean en){
        this.jMenuItemAutoBB.setEnabled(en);
    }
    
    public void setAutoBBSetting(int ml, double r, int HPPt, int HPMt, int EPt, int EMt, 
            int HPPm, int HPMm, int EPm, int EMm, int sleep){
        maxLevel=ml;
        rate=r;
        HPPTarget=HPPt;
        HPMTarget=HPMt;
        EffectPTarget=EPt;
        EffectMTarget=EMt;
        HPPMax=HPPm;
        HPMMax=HPMm;
        EffectPMax=EPm;
        EffectMMax=EMm;
        sleepTime=sleep;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCopyTeam;
    private javax.swing.JButton jButtonFinalComputer;
    private javax.swing.JButton jButtonGoEasy;
    private javax.swing.JButton jButtonGoHard;
    private javax.swing.JButton jButtonGoNorm;
    private javax.swing.JButton jButtonLeft;
    private javax.swing.JButton jButtonLoveHut;
    private javax.swing.JButton jButtonMyHero1;
    private javax.swing.JButton jButtonMyHero10;
    private javax.swing.JButton jButtonMyHero11;
    private javax.swing.JButton jButtonMyHero12;
    private javax.swing.JButton jButtonMyHero13;
    private javax.swing.JButton jButtonMyHero14;
    private javax.swing.JButton jButtonMyHero15;
    private javax.swing.JButton jButtonMyHero16;
    private javax.swing.JButton jButtonMyHero2;
    private javax.swing.JButton jButtonMyHero3;
    private javax.swing.JButton jButtonMyHero4;
    private javax.swing.JButton jButtonMyHero5;
    private javax.swing.JButton jButtonMyHero6;
    private javax.swing.JButton jButtonMyHero7;
    private javax.swing.JButton jButtonMyHero8;
    private javax.swing.JButton jButtonMyHero9;
    private javax.swing.JButton jButtonMyTeam1;
    private javax.swing.JButton jButtonMyTeam2;
    private javax.swing.JButton jButtonMyTeam3;
    private javax.swing.JButton jButtonMyTeam4;
    private javax.swing.JButton jButtonPasteTeam;
    private javax.swing.JButton jButtonRight;
    private javax.swing.JButton jButtonShowMyTeam;
    private javax.swing.JCheckBox jCheckBoxKillFirst;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemDreamMode;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemSaveBE;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemSmartNumber;
    private javax.swing.JComboBox jComboBoxBQK1;
    private javax.swing.JComboBox jComboBoxBQK2;
    private javax.swing.JComboBox jComboBoxCaptainEasy;
    private javax.swing.JComboBox jComboBoxCaptainHard;
    private javax.swing.JComboBox jComboBoxCaptainNorm;
    private javax.swing.JComboBox jComboBoxEnemyNumberEasy;
    private javax.swing.JComboBox jComboBoxEnemyNumberHard;
    private javax.swing.JComboBox jComboBoxEnemyNumberNorm;
    private javax.swing.JComboBox jComboBoxMode;
    private javax.swing.JComboBox jComboBoxMyNumberEasy;
    private javax.swing.JComboBox jComboBoxMyNumberHard;
    private javax.swing.JComboBox jComboBoxMyNumberNorm;
    private javax.swing.JComboBox jComboBoxPet1;
    private javax.swing.JComboBox jComboBoxPet2;
    private javax.swing.JComboBox jComboBoxPet3;
    private javax.swing.JComboBox jComboBoxPet4;
    private javax.swing.JComboBox jComboBoxPet5;
    private javax.swing.JComboBox jComboBoxPetLevel1;
    private javax.swing.JComboBox jComboBoxPetLevel2;
    private javax.swing.JComboBox jComboBoxPetLevel3;
    private javax.swing.JComboBox jComboBoxPetLevel4;
    private javax.swing.JComboBox jComboBoxPetLevel5;
    private javax.swing.JComboBox jComboBoxQBW;
    private javax.swing.JComboBox jComboBoxSacLevel;
    private javax.swing.JComboBox jComboBoxYWT;
    private javax.swing.JComboBox jComboBoxYZW;
    private javax.swing.JComboBox jComboBoxZZS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMyAtt;
    private javax.swing.JLabel jLabelMyDef;
    private javax.swing.JLabel jLabelPEasy;
    private javax.swing.JLabel jLabelPHard;
    private javax.swing.JLabel jLabelPNorm;
    private javax.swing.JLabel jLabelSumEasy;
    private javax.swing.JLabel jLabelSumHard;
    private javax.swing.JLabel jLabelSumNorm;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAutoBB;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JCheckBoxMenuItem jMenuItemWatchBattle;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JMenu jMenuSimulationTimes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelEasy;
    private javax.swing.JPanel jPanelHard;
    private javax.swing.JPanel jPanelMyTeam;
    private javax.swing.JPanel jPanelNorm;
    private javax.swing.JRadioButton jRadioButtonBQK0;
    private javax.swing.JRadioButton jRadioButtonBQK1;
    private javax.swing.JRadioButton jRadioButtonBQK2;
    private javax.swing.JRadioButton jRadioButtonBQK3;
    private javax.swing.JRadioButton jRadioButtonBQK4;
    private javax.swing.JRadioButton jRadioButtonBQK5;
    private javax.swing.JRadioButton jRadioButtonBQK6;
    private javax.swing.JRadioButton jRadioButtonBQK7;
    private javax.swing.JRadioButton jRadioButtonBQK8;
    private javax.swing.JRadioButton jRadioButtonBQK9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes100;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes1000;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes10000;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes200;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes3000;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSimulationTimes500;
    private javax.swing.JRadioButton jRadioButtonQBW0;
    private javax.swing.JRadioButton jRadioButtonQBW1;
    private javax.swing.JRadioButton jRadioButtonQBW2;
    private javax.swing.JRadioButton jRadioButtonQBW3;
    private javax.swing.JRadioButton jRadioButtonQBW4;
    private javax.swing.JRadioButton jRadioButtonYWT0;
    private javax.swing.JRadioButton jRadioButtonYWT1;
    private javax.swing.JRadioButton jRadioButtonYWT2;
    private javax.swing.JRadioButton jRadioButtonYWT3;
    private javax.swing.JRadioButton jRadioButtonYWT4;
    private javax.swing.JRadioButton jRadioButtonYZW0;
    private javax.swing.JRadioButton jRadioButtonYZW1;
    private javax.swing.JRadioButton jRadioButtonYZW2;
    private javax.swing.JRadioButton jRadioButtonYZW3;
    private javax.swing.JRadioButton jRadioButtonYZW4;
    private javax.swing.JRadioButton jRadioButtonZZS0;
    private javax.swing.JRadioButton jRadioButtonZZS1;
    private javax.swing.JRadioButton jRadioButtonZZS2;
    private javax.swing.JRadioButton jRadioButtonZZS3;
    private javax.swing.JRadioButton jRadioButtonZZS4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPaneEnemy;
    private javax.swing.JTabbedPane jTabbedPanePets;
    private javax.swing.JTextField jTextFieldLevel;
    private javax.swing.JTextField jTextFieldMinus;
    private javax.swing.JTextField jTextFieldPlus;
    private javax.swing.JTextField jTextFieldSkillMinus;
    private javax.swing.JTextField jTextFieldSkillPlus;
    private javax.swing.JTextPane jTextPaneBattleField;
    private javax.swing.JToggleButton jToggleButtonSwitch;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JLabel[] jLabelEnemyHard;
    public javax.swing.JLabel[] jLabelEnemyNorm;
    public javax.swing.JLabel[] jLabelEnemyEasy;
    public javax.swing.JLabel[] jLabelMyTeam;
    public javax.swing.JButton[] jButtonHeroChoosers;
    public javax.swing.JComboBox[] jComboBoxPets;
    public javax.swing.JComboBox[] jComboBoxPetsLevel;
    public javax.swing.ButtonGroup[] buttonGroup;
    public javax.swing.ButtonGroup simulationTimes;
    public javax.swing.JRadioButton[] jRadioButtons;
    public javax.swing.JComboBox[] jComboBoxBBuildingLevel;
    public int trialNumber;
    public boolean switchEnabled;
    public int switchI;
    
    // autobb setting
    private int maxLevel;
    private double rate;
    private int HPPTarget;
    private int HPPMax;
    private int HPMTarget;
    private int HPMMax;
    private int EffectPTarget;
    private int EffectPMax;
    private int EffectMTarget;
    private int EffectMMax;
    private int sleepTime;
}
