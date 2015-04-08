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
import javax.swing.SwingUtilities;
import slcomputer.dialogs.JDialogAutoProgress;
import slcomputer.dialogs.JDialogChooseBuff;
import slcomputer.invokelater.Report;
import slcomputer.invokelater.UpdateSelection;

/**
 *
 * @author J
 */
public class SocketAuto implements Runnable{
    private JDialogAutoProgress dialogProgress;
    
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
    
    private static final int MAX_NUMBER=20;
    private String[] names;
    private Skill[] skillNames;
    private int[] skillActTimes;
    
    public SocketAuto(){
        names=new String[MAX_NUMBER];
        skillNames=new Skill[MAX_NUMBER*2];
        skillActTimes=new int[MAX_NUMBER*4];
        for(int i=0; i<MAX_NUMBER; i++){
            names[i]=null;
            skillNames[i*2]=null;
            skillNames[i*2+1]=null;
        }
    }
    
    public void setParameters(int level, double r, int hppt, int hppm, int hpmt, int hpmm, int ept, int epm, int emt, int emm, int sleep){
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
        sleepTime=sleep;
        if(sleepTime<100){
            sleepTime=100;
        }
    }
    
    public static byte[] communicate(BufferedOutputStream os, BufferedInputStream is, int command, byte[] extra){
        if(os==null || is==null){
            return null;
        }
        int extralength=extra.length;
        int length=extralength+22;
        byte[] data=SocketMaster.transform(length, (int)(SocketMaster.arguments[4])==0?2008000:2008000, SocketMaster.globalCer, command, extralength, extra);
        byte[] para=new byte[12];
        para[0]=0x53; para[1]=0x74; para[2]=0x61; para[3]=0x72; para[4]=0x74;
        para[5]=0x45; para[6]=0x6e; para[7]=0x64;
        para[8]=(byte)((command >> 24) & 0xff);
        para[9]=(byte)((command >> 16) & 0xff);
        para[10]=(byte)((command >> 8) & 0xff);
        para[11]=(byte)(command & 0xff);
        if((int)(SocketMaster.arguments[4])!=0){
            SocketMaster.encrypt(data);
            SocketMaster.encrypt(para);
        }
        else{
            SocketMaster.encrypt(data);
            SocketMaster.encrypt(para);
        }
        byte[] recvData;
        try {
            os.write(data);
            os.flush();
            recvData=SocketMaster.findEnd(is, para);
        } catch (IOException ex) {
            recvData=null;
        }
        if(recvData!=null){
            if((int)(SocketMaster.arguments[4])!=0){
                SocketMaster.decrypt(recvData);
            }
            else{
                SocketMaster.decrypt(recvData);
            }
        }
        return recvData;
    }
    
    public void linkBuff(int moreBuff, int index, int[] more){
        switch(moreBuff){
            case 3:
                more[0]=index;
                break;
            case 2:
                more[1]=index;
                break;
            case 1:
                more[2]=index;
                break;
        }
    }
    
    public int autoBuff(){
        int ret;
        int[] buff=new int[5];
        buff[0]=buffDefP-100;
        buff[1]=buffEffectP;
        buff[2]=-buffDefM;
        buff[3]=-buffEffectM;
        buff[4]=0;
        int[] target=new int[5];
        target[0]=HPPTarget;
        target[1]=EffectPTarget;
        target[2]=HPMTarget;
        target[3]=EffectMTarget;
        target[4]=0;
        int[] max=new int[5];;
        max[0]=HPPMax;
        max[1]=EffectPMax;
        max[2]=HPMMax;
        max[3]=EffectMMax;
        max[4]=0;
        int[] more={4, 4, 4};
        linkBuff(moreHPP, 0, more);
        linkBuff(moreEffectP, 1, more);
        linkBuff(moreHPM, 2, more);
        linkBuff(moreEffectM, 3, more);
        linkBuff(moreKill, 4, more);
        int star=SocketMaster.starTotal-SocketMaster.starUsed;
        int buffBelowTarget;
        for(buffBelowTarget=0; buffBelowTarget<4; buffBelowTarget++){
            if(buff[buffBelowTarget]<target[buffBelowTarget]){
                break;
            }
        }
        if(buff[more[0]]<target[more[0]] && star>=30){
            ret=more[0];
        }
        else if(buff[more[1]]<target[more[1]] && star>=15){
            ret=more[1];
        }
        else if(buff[more[0]]<max[more[0]] && star>=30){
            ret=more[0];
        }
        else if(buff[more[1]]<max[more[1]] && star>=15){
            ret=more[1];
        }
        else if(buff[more[2]]<max[more[2]]){
            ret=more[2];
        }
        else if(more[0]==4 && buffBelowTarget==4 && star>=30){
            ret=4;
        }
        else{
            ret=more[2];
        }
        String log="";
        for(int i=0; i<3; i++){
            switch(more[i]){
                case 0:
                    log+="0:加攻防 ";
                    break;
                case 1:
                    log+="1:加忍术 ";
                    break;
                case 2:
                    log+="2:减攻防 ";
                    break;
                case 3:
                    log+="3:减忍术 ";
                    break;
                case 4:
                    log+="4:秒杀 ";
                    break;
            }
        }
        
        log+="\n选择： "+ret;
        SLComputer.log(log);
        return ret;
    }
    
    public int autoHardness(){
        double[] rates=SLComputer.mf.finalComputerSilent(SocketMaster.mode, level+1, buffDefP-100, buffEffectP, -buffDefM, -buffEffectM, killFirst, 
                enemyHard, enemyNormal, enemyEasy, enemyNumber, myNumber, 2*myNumber-enemyNumber);
        int i, select;
        for(i=0; i<rates.length; i++){
            if(rates[i]>=rate){
                break;
            }
        }
        if(i<rates.length){
            select=i;
        }
        else{
            select=0;
            for(i=1; i<rates.length; i++){
                if(rates[i]>rates[select]){
                    select=i;
                }
            }
        }
        SLComputer.log("Select:"+select);
        return select;
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
    
    public int mappingName(String name){
        int i;
        for(i=0; i<names.length; i++){
            if(names[i]!=null && names[i].equals(name)){
                return i;
            }
        }
        return names.length-1;
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
        int nameIndex, skillNameIndex;
        boolean attStronger;
        Skill skill;
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
        switch(hardness){
            case 0:
                report+=" 困难";
                break;
            case 1:
                report+=" 普通";
                break;
            case 2:
                report+=" 容易";
                break;
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
            if(SocketMaster.mode==0){
                if(names[i]==null){
                    names[i]=attTeam[i].name;
                }
            }
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
            if(SocketMaster.mode==1){
                if(names[i]==null){
                    names[i]=defTeam[i].name;
                }
            }
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
        boolean skilled, attSkilled, defSkilled;
        boolean shiwei;
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
            if(SocketMaster.mode==0){
                nameIndex=mappingName(attHero.name);
            }
            else{
                nameIndex=mappingName(defHero.name);
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
                skill=SocketMaster.referenceSkill(j);
                skillDetail0+=attName+" >>> "+skill.name+"\n";
                if(skill.name.equals("神树降诞")){
                    shiwei=true;
                }
                skilled=true;
            }
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(j!=0){
                skill=SocketMaster.referenceSkill(j);
                skillDetail1+="     "+skill.name+" <<< "+defName+"\n";
                if(skill.name.equals("神树降诞")){
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
            attSkilled=defSkilled=false;
            skillNameIndex=-1;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skill=SocketMaster.referenceSkill(x);
                skillDetail0+=attHero.name+" 发动 "+skill.name+"\n";
                skilled=true;
                attSkilled=true;
                if(SocketMaster.mode==0){
                    if(skillNames[2*nameIndex]==null || skillNames[2*nameIndex].id==skill.id){
                        skillNameIndex=2*nameIndex;
                    }
                    else if(skillNames[2*nameIndex+1]==null || skillNames[2*nameIndex+1].id==skill.id){
                        skillNameIndex=2*nameIndex+1;
                    }
                    else{
                        System.out.println("Code should never be reached. Skill name: "+skill.name);
                        skillNameIndex=-1;
                    }
                    if(skillNameIndex>=0){
                        if(skillNames[skillNameIndex]==null){
                            skillNames[skillNameIndex]=skill;
                            skillActTimes[skillNameIndex*2]=0;
                            skillActTimes[skillNameIndex*2+1]=shiwei?0:-1;
                        }
                        else if(!shiwei){
                            skillActTimes[skillNameIndex*2]++;
                        }
                    }
                }
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skill=SocketMaster.referenceSkill(x);
                skillDetail1+=defHero.name+" 发动 "+skill.name+"\n";
                skilled=true;
                defSkilled=true;
                if(SocketMaster.mode==1){
                    if(skillNames[2*nameIndex]==null || skillNames[2*nameIndex].id==skill.id){
                        skillNameIndex=2*nameIndex;
                    }
                    else if(skillNames[2*nameIndex+1]==null || skillNames[2*nameIndex+1].id==skill.id){
                        skillNameIndex=2*nameIndex+1;
                    }
                    else{
                        System.out.println("Code should never be reached. Skill name: "+skill.name);
                        skillNameIndex=-1;
                    }
                    if(skillNameIndex>=0){
                        if(skillNames[skillNameIndex]==null){
                            skillNames[skillNameIndex]=skill;
                            skillActTimes[skillNameIndex*2]=0;
                            skillActTimes[skillNameIndex*2+1]=shiwei?0:-1;
                        }
                        else if(!shiwei){
                            skillActTimes[skillNameIndex*2]++;
                        }
                    }
                }
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
            // 统计各技能是否可以在此时发动
            if(!shiwei && nameIndex>=0 && SocketMaster.mode==0){
                if(skillNames[nameIndex*2]!=null){
                    x=skillNames[nameIndex*2].timming();
                    if(x==0){
                        if(skillNames[nameIndex*2].type==14){   // 夺取差值类技能
                            if(attHero.hp<defHero.hp){
                                skillActTimes[nameIndex*4+1]++;
                            }
                        }
                        else{
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                    else if(x==1){
                        if(defSkilled){
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                }
                if(skillNames[nameIndex*2+1]!=null){
                    x=skillNames[nameIndex*2+1].timming();
                    if(x==0){
                        if(skillNames[nameIndex*2+1].type==14){   // 夺取差值类技能
                            if(attHero.hp<defHero.hp){
                                skillActTimes[nameIndex*4+3]++;
                            }
                        }
                        else{
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                    else if(x==1){
                        if(defSkilled){
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                }
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"")+x+"\n";
                attHero.hp+=x;
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x>0?"+":"")+x+"\n";
                defHero.hp+=x;
            }
            // 统计各技能是否可以在此时发动
            if(!shiwei && nameIndex>=0 && SocketMaster.mode==1){
                if(skillNames[nameIndex*2]!=null){
                    x=skillNames[nameIndex*2].timming();
                    if(x==0){
                        if(skillNames[nameIndex*2].type==14){   // 夺取差值类技能
                            if(attHero.hp>defHero.hp){
                                skillActTimes[nameIndex*4+1]++;
                            }
                        }
                        else{
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                    else if(x==1){
                        if(attSkilled){
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                }
                if(skillNames[nameIndex*2+1]!=null){
                    x=skillNames[nameIndex*2+1].timming();
                    if(x==0){
                        if(skillNames[nameIndex*2+1].type==14){   // 夺取差值类技能
                            if(attHero.hp>defHero.hp){
                                skillActTimes[nameIndex*4+3]++;
                            }
                        }
                        else{
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                    else if(x==1){
                        if(attSkilled){
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                }
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
            int xydiff=x-y;
            // 统计各技能是否可以在此时发动
            if(!shiwei && nameIndex>=0){
                if(skillNames[nameIndex*2]!=null){
                    x=skillNames[nameIndex*2].timming();
                    if(x==2){
                        if(SocketMaster.mode==0 && xydiff<0 || SocketMaster.mode==1 && xydiff>0){
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                    else if(x==3){
                        if(SocketMaster.mode==0 && xydiff>0 || SocketMaster.mode==1 && xydiff<0){
                            skillActTimes[nameIndex*4+1]++;
                        }
                    }
                }
                if(skillNames[nameIndex*2+1]!=null){
                    x=skillNames[nameIndex*2+1].timming();
                    if(x==2){
                        if(SocketMaster.mode==0 && xydiff<0 || SocketMaster.mode==1 && xydiff>0){
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                    else if(x==3){
                        if(SocketMaster.mode==0 && xydiff>0 || SocketMaster.mode==1 && xydiff<0){
                            skillActTimes[nameIndex*4+3]++;
                        }
                    }
                }
            }
            
            // 战后技能
            skillDetail0="";
            skillDetail1="";
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skill=SocketMaster.referenceSkill(x);
                skillDetail0+=attHero.name+" 发动 "+skill.name+"\n";
                if(SocketMaster.mode==0){
                    if(skillNames[2*nameIndex]==null || skillNames[2*nameIndex].id==skill.id){
                        skillNameIndex=2*nameIndex;
                    }
                    else if(skillNames[2*nameIndex+1]==null || skillNames[2*nameIndex+1].id==skill.id){
                        skillNameIndex=2*nameIndex+1;
                    }
                    else{
                        System.out.println("Code should never be reached. Skill name: "+skill.name);
                        skillNameIndex=-1;
                    }
                    if(skillNameIndex>=0){
                        if(skillNames[skillNameIndex]==null){
                            skillNames[skillNameIndex]=skill;
                            skillActTimes[skillNameIndex*2]=0;
                            skillActTimes[skillNameIndex*2+1]=0;
                        }
                        else if(!shiwei){
                            skillActTimes[skillNameIndex*2]++;
                        }
                    }
                }
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skill=SocketMaster.referenceSkill(x);
                skillDetail1+=defHero.name+" 发动 "+skill.name+"\n";
                if(SocketMaster.mode==1){
                    if(skillNames[2*nameIndex]==null || skillNames[2*nameIndex].id==skill.id){
                        skillNameIndex=2*nameIndex;
                    }
                    else if(skillNames[2*nameIndex+1]==null || skillNames[2*nameIndex+1].id==skill.id){
                        skillNameIndex=2*nameIndex+1;
                    }
                    else{
                        System.out.println("Code should never be reached. Skill name: "+skill.name);
                        skillNameIndex=-1;
                    }
                    if(skillNameIndex>=0){
                        if(skillNames[skillNameIndex]==null){
                            skillNames[skillNameIndex]=skill;
                            skillActTimes[skillNameIndex*2]=0;
                            skillActTimes[skillNameIndex*2+1]=0;
                        }
                        else if(!shiwei){
                            skillActTimes[skillNameIndex*2]++;
                        }
                    }
                }
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
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                System.out.println("Sleep interupted.");
            }
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
                report+="\n攻防+"+(buffDefP-100)+"% 攻防-"+(-buffDefM)+"% 忍术+"+buffEffectP+"% 忍术-"+(-buffEffectM)+"% 星星:"+(SocketMaster.starTotal-SocketMaster.starUsed);
            }
            
        }
        else{
            battleDetails+="失败...\n";
            report+="失败...";
            report(report, false);
            return 1;
        }
        report(report, true);
        return 0;
    }
    
    public String skillStatistics(){
        String stat="技能几率统计：\n";
        for(int i=0; i<names.length; i++){
            if(names[i]!=null){
                stat+=names[i]+"\n";
                if(skillNames[i*2]!=null){
                    stat+="    "+skillNames[i*2].name+"\t"+skillActTimes[i*4]+"/"+skillActTimes[i*4+1];
                    if(skillActTimes[i*4+1]>0){
                        stat+="  "+(double)skillActTimes[i*4]/skillActTimes[i*4+1]*100;
                        if(stat.indexOf(".")>0){
                            stat=stat.substring(0, stat.lastIndexOf(".")+2);
                        }
                        stat+="%";
                    }
                    stat+="\n";
                }
                if(skillNames[i*2+1]!=null){
                    stat+="    "+skillNames[i*2+1].name+"\t"+skillActTimes[i*4+2]+"/"+skillActTimes[i*4+3];
                    if(skillActTimes[i*4+3]>0){
                        stat+="  "+(double)skillActTimes[i*4+2]/skillActTimes[i*4+3]*100;
                        if(stat.indexOf(".")>0){
                            stat=stat.substring(0, stat.lastIndexOf(".")+2);
                        }
                        stat+="%";
                    }
                    stat+="\n";
                }
            }
        }
        return stat;
    }
    
    public void report(String msg, boolean status){
        Report r=new Report(dialogProgress, msg, status);
        SwingUtilities.invokeLater(r);
    }
    
    @Override
    public void run(){
        dialogProgress=new JDialogAutoProgress(SLComputer.mf, true);
        new Thread(dialogProgress).start();
        int status=0;
        if(!globalQueryBB()){
            SocketMaster.connectionBroken();
            return;
        }
        while(dialogProgress!=null && !dialogProgress.stop() && status==0 && level<maxLevel){
            status=battle(autoHardness());
        }
        if(dialogProgress!=null){
            dialogProgress.status=status;
        }
        if(status<=1){
            report("自动试炼结束\n\n"+skillStatistics(), false);
        }
        else{
            report("连接中断", false);
        }
        SocketMaster.updateSelection(SocketMaster.mode, level, buffDefP, buffDefM, buffEffectP, buffEffectM,
                    killFirst, enemyHard, enemyNormal, enemyEasy, myNumber, enemyNumber, "", true);
        SLComputer.mf.setAutoBBSetting(maxLevel, rate, HPPTarget, HPMTarget, EffectPTarget, EffectMTarget, 
            HPPMax, HPMMax, EffectPMax, EffectMMax, sleepTime);
    }
}