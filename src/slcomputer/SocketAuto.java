/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import slcomputer.dialogs.JDialogAutoProgress;
import slcomputer.dialogs.JDialogChooseBuff;

/**
 *
 * @author J
 */
public class SocketAuto implements Runnable{
    private JDialogAutoProgress dialogProgress;
    
    private int maxLevel;
    private int rate;
    private int HPPTarget;
    private int HPPMax;
    private int HPMTarget;
    private int HPMMax;
    private int EffectPTarget;
    private int EffectPMax;
    private int EffectMTarget;
    private int EffectMMax;
    
    private int challengeTimes;
    private int bestQX;
    private int bestFY;
    private int challengeMax;
    private int rank;
    private int level;
    private int myNumber;
    private int enemyHard;
    private int enemyNumber;
    private int enemyNormal;
    private int enemyEasy;
    private int killFirst;
    private int moreBuff;
    private int buffDefP;
    private int buffAttP;
    private int buffEffectP;
    private int buffDefM;
    private int buffAttM;
    private int buffEffectM;
    private int moreHPP;
    private int moreEffectP;
    private int moreHPM;
    private int moreEffectM;
    private int moreKill;
    private int lastNightLevel;
    private int globalIndex;
    
    public void setParameters(int level, int r, int hppt, int hppm, int hpmt, int hpmm, int ept, int epm, int emt, int emm){
        maxLevel=level;
        rate=r;
        HPPTarget=hppt;
        HPPMax=hppm;
        HPMTarget=hpmt;
        HPMMax=hpmm;
        EffectPTarget=ept;
        EffectPMax=epm;
        EffectMTarget=emt;
        EffectMMax=emm;
    }
    
    public static byte[] communicate(BufferedOutputStream os, BufferedInputStream is, int command, byte[] extra){
        if(os==null || is==null){
            return null;
        }
        int extralength=extra.length;
        int length=extralength+22;
        byte[] data=SocketMaster.transform(length, SocketMaster.globalCer, command, extralength, extra);
        byte[] recvData;
        try {
            os.write(data);
            os.flush();
            recvData=SocketMaster.findEnd(is, command);
        } catch (IOException ex) {
            recvData=null;
        }
        return recvData;
    }
    
    public int autoBuff(){
        // TODO
        return 0;
    }
    
    public int autoHardness(){
        // TODO
        return 0;
    }
    
    public boolean globalQueryBB(){
        if(!SocketMaster.globalReady || SocketMaster.clientStatic==null || SocketMaster.osStatic==null || SocketMaster.isStatic==null){
            return false;
        }
        
        int command=SocketMaster.c_bb_q1;
        byte[] extra=SocketMaster.festival_extra(SocketMaster.globalID, SocketMaster.mode);
        byte[] recvData=communicate(SocketMaster.osStatic, SocketMaster.isStatic, command, extra);
        if(recvData==null || recvData.length<168){
            return false;
        }
        int pos=8;
        SocketMaster.mode=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(SocketMaster.mode!=0 && SocketMaster.mode!=1){
            return false;
        }
        challengeTimes=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        bestQX=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        bestFY=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        challengeMax=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        rank=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        SocketMaster.starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        SocketMaster.starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        moreHPP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreHPM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreKill=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        lastNightLevel=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;

        return true;
    }
    
    public int battle(int hardness){
        if(!SocketMaster.globalReady || SocketMaster.clientStatic==null || SocketMaster.osStatic==null || SocketMaster.isStatic==null){
            return 2;
        }
        int command=SocketMaster.c_bb_battle;
        byte[] extra=SocketMaster.festival_extra(SocketMaster.globalID, hardness);
        byte[] recvData=communicate(SocketMaster.osStatic, SocketMaster.isStatic, command, extra);
        if(recvData==null || recvData.length<76){
            return 2;
        }
        int i, j, x, y, pos, length, starGain;
        String report;
        String battleDetails, skillDetail0, skillDetail1, attName, defName;
        HeroLight[] attTeam, defTeam;
        HeroLight attHero, defHero;
        int rounds;
        pos=8;
        starGain=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        try {
            attName=new String(recvData, pos, length, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            attName="unsupportedEncoding";
        }
        pos+=length;
        pos+=4; // 角色等级
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        try {
            defName=new String(recvData, pos, length, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            defName="unsupportedEncoding";
        }
        pos+=length;
        battleDetails=attName+"   VS   "+defName+"\n";
        if(SocketMaster.mode==0){
            report=defName;
        }
        else{
            report=attName;
        }
        pos+=8; // 角色等级
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        attTeam=new HeroLight[length];
        for(i=0; i<length; i++){
            pos+=4;
            attTeam[i]=new HeroLight();
            attTeam[i].ref=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attTeam[i].setName(j);
            attTeam[i].id=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attTeam[i].setProperty(attTeam[i].id);
            pos+=4;
            attTeam[i].hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
        }
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        defTeam=new HeroLight[length];
        for(i=0; i<length; i++){
            pos+=4;
            defTeam[i]=new HeroLight();
            defTeam[i].ref=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defTeam[i].setName(j);
            defTeam[i].id=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defTeam[i].setProperty(defTeam[i].id);
            pos+=4; // 忍者等级
            defTeam[i].hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4; // 6星+几
        }
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 进攻方尾兽排布
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 防守方尾兽排布
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 进攻方作战建筑
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 防守方作战建筑
        rounds=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        boolean skilled;
        boolean shiwei;
        String skillName;
        for(i=0; i<rounds; i++){
            pos+=8;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attHero=SocketMaster.referenceHero(attTeam, j);
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero=SocketMaster.referenceHero(defTeam, j);
            if(attHero==null || defHero==null){
                System.out.println("Can't find reference hero in the team.");
                return 3;
            }
            pos+=4;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            battleDetails+=attHero.name+" "+attHero.property+" "+SocketMaster.hp(attHero.hp)+" VS "+SocketMaster.hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            pos+=4;
            skilled=false;
            shiwei=false;
            // 尾兽技能
            skillDetail0="";
            skillDetail1="";
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(j!=0){
                skillName=SocketMaster.referenceSkill(j);
                skillDetail0+=attName+" >>> "+skillName+"\n";
                if(skillName.equals("神树降诞")){
                    shiwei=true;
                }
                skilled=true;
            }
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(j!=0){
                skillName=SocketMaster.referenceSkill(j);
                skillDetail1+="     "+skillName+" <<< "+defName+"\n";
                if(skillName.equals("神树降诞")){
                    shiwei=true;
                }
                skilled=true;
            }
            pos+=4;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail0+=SocketMaster.referenceHero(attTeam, x).name+" 复活！\n";
            }
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail1+=SocketMaster.referenceHero(defTeam, x).name+" 复活！\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"-")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x<0?"+":"-")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"-")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x<0?"+":"-")+x+"\n";
            }
            battleDetails+=skillDetail0+skillDetail1;
            pos+=12;
            // 主动技能
            skillDetail0="";
            skillDetail1="";
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" 发动 "+SocketMaster.referenceSkill(x)+"\n";
                skilled=true;
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" 发动 "+SocketMaster.referenceSkill(x)+"\n";
                skilled=true;
            }
            pos+=4;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail0+=SocketMaster.referenceHero(attTeam, x).name+" 复活！\n";
            }
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail1+=SocketMaster.referenceHero(defTeam, x).name+" 复活！\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            if(!shiwei){
                battleDetails+=skillDetail0+skillDetail1;
            }
            pos+=12;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(skilled && !shiwei){
                battleDetails+=attHero.name+" "+attHero.property+" "+SocketMaster.hp(attHero.hp)+" VS "+SocketMaster.hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            }
            pos+=4;
            // 属性相克
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            y=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(attHero.hp!=x || defHero.hp!=y){
                battleDetails+=attHero.property+" "+(x-attHero.hp>=0?"+"+(x-attHero.hp):(x-attHero.hp))+((x-attHero.hp)>0?" ---> ":" <--- ")+((y-defHero.hp)>=0?"+"+(y-defHero.hp):""+(y-defHero.hp))+" "+defHero.property+"\n";
                attHero.hp=x;
                defHero.hp=y;
                battleDetails+=attHero.name+" "+attHero.property+" "+SocketMaster.hp(attHero.hp)+" VS "+SocketMaster.hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            }
            pos+=4;
            // 战后技能
            skillDetail0="";
            skillDetail1="";
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" 发动 "+SocketMaster.referenceSkill(x)+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" 发动 "+SocketMaster.referenceSkill(x)+"\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(attHero.hp>0){
                battleDetails+=skillDetail0;
            }
            if(defHero.hp>0){
                battleDetails+=skillDetail1;
            }
            if(attHero.hp==0){
                battleDetails+=skillDetail0;
                battleDetails+=attHero.name+" 死亡\n";
            }
            if(defHero.hp==0){
                battleDetails+=skillDetail1;
                battleDetails+=defHero.name+" 死亡\n";
            }
        }
        // 每5关奖励
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(length==6){
            pos+=24;
        }
        else if(length==7){
            pos+=20;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=20*length+4;
        }
        else{
            System.out.println("Award part unexpected item count: "+length);
            return 3;
        }
        // 试炼概况
        pos+=28;
        // 试炼详情
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(length>0){
            length=starGain/(3-hardness);
            switch(length){
                case 3:
                    battleDetails+="完胜！\n";
                    report+=" 完胜！";
                    break;
                case 2:
                    battleDetails+="胜利！\n";
                    report+=" 胜利！";
                    break;
                case 1:
                    battleDetails+="险胜！\n";
                    report+=" 险胜！";
                    break;
                default:
                    battleDetails+="未知数据："+hardness+"\n";
            }
            battleDetails+="获得星星："+starGain+"\n";
            SocketMaster.mode=(((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff)); pos+=4;
            level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            SocketMaster.starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            SocketMaster.starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            moreHPP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreHPM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreKill=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            lastNightLevel=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            
            if(moreBuff>0){
                // 选择Buff
                globalIndex=autoBuff();
                //new JDialogChooseBuff(SLComputer.mf, true, mode, starUsed, starTotal, moreHPP, moreEffectP, moreHPM, moreEffectM, moreKill, lastNightLevel);
                if(globalIndex<0 || globalIndex>4){
                    return 2;
                }
                command=SocketMaster.c_bb_q2;
                extra=SocketMaster.festival_extra(SocketMaster.globalID, globalIndex);
                recvData=communicate(SocketMaster.osStatic, SocketMaster.isStatic, command, extra);
                if(recvData==null || recvData.length<160){
                    return 2;
                }
                pos=28;
                if(SocketMaster.mode!=(((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff))){
                    return 2;
                } pos+=4;
                level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                SocketMaster.starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                SocketMaster.starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                
            }
            
        }
        else{
            battleDetails+="失败...\n";
            report+=" 失败...";
            return 1;
        }
        return 0;
    }
    
    @Override
    public void run(){
        dialogProgress=new JDialogAutoProgress(SLComputer.mf, true);
        new Thread(dialogProgress).start();
        int status=0;
        if(!globalQueryBB()){
            // TODO
            return;
        }
        while(!dialogProgress.stop() && status==0){
            status=battle(autoHardness());
        }
        // TODO
    }
}
