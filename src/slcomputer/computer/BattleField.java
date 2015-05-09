/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.computer;

import slcomputer.heros.Hero;

/**
 *
 * @author J
 */
public class BattleField {
    public javax.swing.JTextPane output;
    private boolean conditionAttDup;
    private boolean conditionDefDup;
    private double flagAttWeaken;
    private double flagDefWeaken;
    public String allMsg;
    // a condition which is true if current attack hero.att is bigger than current defend hero.def, false otherwise
    private boolean conditionAttStronger;
    // 尾兽技能相关
    private int petIndexAtt;
    private int petIndexDef;
    private int activePetAtt;
    private int activePetDef;
    private boolean isActive3Att;
    private boolean isActive6Att;
    private boolean isActive7Att;
    private boolean isActive3Def;
    private boolean isActive6Def;
    private boolean isActive7Def;
    private int petCacheAtt;
    private int petCacheDef;
    private boolean[] attSkillable;
    private boolean[] defSkillable;
    private boolean[] attPoisoned;
    private boolean[] defPoisoned;
    // 0: attacker首忍者stay dead, 1: defender首忍者stay dead
    private int stayDead;
    private double anil;
    public static final double petRate[]={0.19, 0.24, 0.28, 0.33, 0.37, 0.42, 0.46, 0.51, 0.55, 0.60,
                                        0.065, 0.08, 0.095, 0.11, 0.125, 0.14, 0.155, 0.17, 0.185, 0.20,
                                        0.19, 0.24, 0.28, 0.33, 0.37, 0.42, 0.46, 0.51, 0.55, 0.60,
                                        0.081, 0.1, 0.119, 0.138, 0.156, 0.175, 0.194, 0.213, 0.231, 0.25,
                                        0.19, 0.24, 0.28, 0.33, 0.37, 0.42, 0.46, 0.51, 0.55, 0.60,
                                        0.291, 0.359, 0.426, 0.494, 0.561, 0.629, 0.696, 0.763, 0.831, 0.9,
                                        0.19, 0.24, 0.28, 0.33, 0.37, 0.42, 0.46, 0.51, 0.55, 0.60,
                                        0.12, 0.148, 0.176, 0.204, 0.231, 0.259, 0.287, 0.315, 0.34, 0.37,
                                        0.16, 0.2, 0.235, 0.275, 0.31, 0.35, 0.385, 0.425, 0.46, 0.5,
                                        0.13, 0.16, 0.19, 0.22, 0.25, 0.28, 0.31, 0.34, 0.37, 0.40};
    public static final double petPower[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                        1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2,
                                        0.32, 0.4, 0.47, 0.55, 0.62, 0.7, 0.77, 0.85, 0.92, 1,
                                        0.291, 0.359, 0.426, 0.494, 0.561, 0.629, 0.696, 0.763, 0.831, 0.9,
                                        0.19, 0.24, 0.28, 0.33, 0.37, 0.42, 0.46, 0.51, 0.55, 0.60,
                                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                        0.16, 0.2, 0.235, 0.275, 0.31, 0.35, 0.385, 0.425, 0.46, 0.5,
                                        0.32, 0.4, 0.47, 0.55, 0.62, 0.7, 0.77, 0.85, 0.92, 1,
                                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final double pet4Left[]={0.23, 0.3, 0.37, 0.45, 0.52, 0.6, 0.67, 0.75, 0.82, 0.9};
    // debug
    public static int times=0;
    
    public BattleField(javax.swing.JTextPane jTA){
        output=jTA;
        output.setContentType("text/plain");
        attSkillable=new boolean[20];
        defSkillable=new boolean[20];
        attPoisoned=new boolean[20];
        defPoisoned=new boolean[20];
    }
    
    public void sendMsg(String s){
        allMsg=allMsg+s+"\n";
    }
    
    public void showValue(Hero a, Hero d){
        String s=a.name+" "+Hero.propertyToString(a.property_battle)+" "+(int)a.att_battle+ " VS "
                +(int)d.def_battle+" "+Hero.propertyToString(d.property_battle)+" "+d.name;
        sendMsg(s);
    }
    
    // 根据技能，时机和概率，决定是否发动
    public Skill activate(Skill skill, int t, int isDef, double exRate, double exRatePlus, boolean[] status, int number){
        if(skill==null || skill.timming()!=t){
            return null;
        }
        int i, j;
        // 阴封印
        if(skill.type==30){
            return skill;
        }
        // 怪力型技能
        if(skill.type==4){
            if(isDef==0 && conditionDefDup){
                return skill;
            }
            if(isDef==1 && conditionAttDup){
                return skill;
            }
            return null;
        }
        double x=(skill.x+100*exRatePlus)*(1+exRate);
        //System.out.println(skill.name+": "+x);
        // 夺取差值型技能
        if(skill.type==14){
            if(isDef==0 /*&& !conditionAttStronger*/ && Math.random()*100<x){
                return skill;
            }
            if(isDef==1 /*&& conditionAttStronger*/ && Math.random()*100<x){
                return skill;
            }
            return null;
        }
        // 轮回天生型技能
        if(skill.type==19){
            j=0;
            for(i=0; i<number; i++){
                if(i==0 && isDef==stayDead){
                    continue;
                }
                if(!status[i]){
                    x*=0.9;
                    j=1;
                }
            }
            if(j==0){
                return null;
            }
        }
        // 秽土转生 或 明神门
        if(skill.type==20 || skill.type==3){
            j=0;
            for(i=0; i<number; i++){
                if(i==0 && isDef==stayDead){
                    continue;
                }
                if(!status[i]){
                    j=1;
                    break;
                }
            }
            if(j==0){
                return null;
            }
        }
        if(Math.random()*100<x){
            return skill;
        }
        return null;
    }
    
    // 实际技能效果修正
    public double realSkillPower(Skill S, Team t, Hero h, double resist){
        double realPower;
        realPower = S.y/(double)100;
        int i;
        double tmp;
        if(h.property_battle==20){
            tmp=t.powerUpbyProperty[0];
            for(i=1; i<5; i++){
                if(t.powerUpbyProperty[i]>tmp){
                    tmp=t.powerUpbyProperty[i];
                }
            }
        }
        else{
            tmp=t.powerUpbyProperty[h.property_battle%10];
        }
        if(t.skillPower+h.powerRatio/100>0){
            realPower=(realPower+t.skillPower+h.powerRatio/100)*(1+tmp/100);
        }
        realPower=(int)(realPower*100)*(1-resist/100)/100;
        return (realPower<0? 0:realPower);
    }
    
    // 技能生效，who：0进攻方发动技能，1防御方发动技能
    public void effect(Skill skill, int who, Team attTeam, Team defTeam, Hero attHero, Hero defHero, boolean[] attStatus, boolean[] defStatus){
        int i, j;
        double diff;
        switch(skill.type){
            // 加自身的B%到自身
            case 0:
            case 4:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*attHero.att_battle;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*defHero.def_battle;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 加敌人的B%到自身
            case 1:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*defHero.def_battle;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*attHero.att_battle;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 加自身装备的B%到自身
            case 2:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*(attHero.weapon.att+attHero.shield.att);
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*(defHero.shield.def+attHero.weapon.def);
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 加任一阵亡友方的B%到自身
            case 3:
                int alive=0;
                if(who==0){
                    for(i=0; i<attTeam.number; i++){
                        if(!attStatus[i]){
                            if(!(i==0 && stayDead==0)){
                                alive++;
                            }
                        }
                    }
                    j=(int)(Math.random()*alive);
                    if(stayDead==0){
                        i=1;
                    }
                    else{
                        i=0;
                    }
                    while(j>=0){
                        if(!attStatus[i++]){
                            j--;
                        }
                    }
                    i--;
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*attTeam.heros[i].att;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    for(i=0; i<defTeam.number; i++){
                        if(!defStatus[i]){
                            if(!(i==0 && stayDead==1)){
                                alive++;
                            }
                        }
                    }
                    j=(int)(Math.random()*alive);
                    if(stayDead==1){
                        i=1;
                    }
                    else{
                        i=0;
                    }
                    while(j>=0){
                        if(!defStatus[i++]){
                            j--;
                        }
                    }
                    i--;
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*defTeam.heros[i].def;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 加自身的B%到自身，次回合减少到剩余的C%
            case 5:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*attHero.att_battle;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    flagAttWeaken*=skill.z/100;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*defHero.def_battle;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    flagDefWeaken*=skill.z/100;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 减敌人的B%
            case 7:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*defHero.def_battle;
                    //if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*attHero.att_battle;
                    //if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 死亡后 减B%自身初始值给敌人
            case 10:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, 0)*attHero.att;
                    defHero.def_battle-=diff;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, 0)*defHero.def;
                    attHero.att_battle-=diff;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 加自身的B%，减敌人的B%
            case 13:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*attHero.att_battle;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*defHero.def_battle;
                    //if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*defHero.def_battle;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*attHero.att_battle;
                    //if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 夺取差值的B%
            case 14:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*(defHero.def_battle-attHero.att_battle);
                    if(diff<1) diff=0;
                    //if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                    attHero.att_battle+=diff;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*(attHero.att_battle-defHero.def_battle);
                    if(diff<1) diff=0;
                    //if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    defHero.def_battle+=diff;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 复制忍术
            case 15:
                break;
            // 无效忍术
            case 16:
                break;
            // 复活全队，恢复到初始值的B%
            case 19:
                if(who==0){
                    for(i=0; i<attTeam.number; i++){
                        if(i==0 && stayDead==0){
                            continue;
                        }
                        if(!attStatus[i]){
                            if(attPoisoned[i]){
                                sendMsg(attTeam.heros[i].name+" 中毒，无法复活！");
                            }
                            else{
                                attStatus[i]=true;
                                attSkillable[i]=true;
                                attTeam.heros[i].att_battle=realSkillPower(skill, attTeam, attHero, defHero.resist)*attTeam.heros[i].att;
                                sendMsg(attTeam.heros[i].name+" 复活！");
                            }
                        }
                    }
                }
                else{
                    for(i=0; i<defTeam.number; i++){
                        if(i==0 && stayDead==1){
                            continue;
                        }
                        if(!defStatus[i]){
                            if(defPoisoned[i]){
                                sendMsg(defTeam.heros[i].name+" 中毒，无法复活！");
                            }
                            else{
                                defStatus[i]=true;
                                defSkillable[i]=true;
                                defTeam.heros[i].def_battle=realSkillPower(skill, defTeam, defHero, attHero.resist)*defTeam.heros[i].def;
                                sendMsg(defTeam.heros[i].name+" 复活！");
                            }
                        }
                    }
                }
                break;
            // 复活单体，恢复到初始值的B%
            case 20:
                alive=0;
                if(who==0){
                    for(i=0; i<attTeam.number; i++){
                        if(!attStatus[i]){
                            if(!(i==0 && stayDead==0)){
                                alive++;
                            }
                        }
                    }
                    j=(int)(Math.random()*alive);
                    if(stayDead==0){
                        i=1;
                    }
                    else{
                        i=0;
                    }
                    while(j>=0){
                        if(!attStatus[i++]){
                            j--;
                        }
                    }
                    if(attPoisoned[--i]){
                        sendMsg(attTeam.heros[i].name+" 中毒，无法复活！");
                    }
                    else{
                        attStatus[i]=true;
                        attSkillable[i]=true;
                        attTeam.heros[i].att_battle=realSkillPower(skill, attTeam, attHero, defHero.resist)*attTeam.heros[i].att;
                        sendMsg(attTeam.heros[i].name+" 复活！");
                    }
                }
                else{
                    for(i=0; i<defTeam.number; i++){
                        if(!defStatus[i]){
                            if(!(i==0 && stayDead==1)){
                                alive++;
                            }
                        }
                    }
                    j=(int)(Math.random()*alive);
                    if(stayDead==1){
                        i=1;
                    }
                    else{
                        i=0;
                    }
                    while(j>=0){
                        if(!defStatus[i++]){
                            j--;
                        }
                    }
                    if(defPoisoned[--i]){
                        sendMsg(defTeam.heros[i].name+" 中毒，无法复活！");
                    }
                    else{
                        defStatus[i]=true;
                        defSkillable[i]=true;
                        defTeam.heros[i].def_battle=realSkillPower(skill, defTeam, defHero, attHero.resist)*defTeam.heros[i].def;
                        sendMsg(defTeam.heros[i].name+" 复活！");
                    }
                }
                break;
            // 加自身初始值的B%
            case 21:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*attHero.att;
                    if(diff<1) diff=0;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*defHero.def;
                    if(diff<1) diff=0;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 减敌人装备的B%
            case 22:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*(defHero.shield.def+defHero.weapon.def);
                    //if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*(attHero.weapon.att+attHero.shield.def);
                    //if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 中毒
            case 31:
                if(who==0){
                    for(i=0; i<defTeam.number; i++){
                        if(defTeam.heros[i]==defHero){
                            break;
                        }
                    }
                    if(i<defTeam.number){
                        defPoisoned[i]=true;
                    }
                }
                else{
                    for(i=0; i<attTeam.number; i++){
                        if(attTeam.heros[i]==attHero){
                            break;
                        }
                    }
                    if(i<attTeam.number){
                        attPoisoned[i]=true;
                    }
                }
                break;
            // 轮回眼（恢复碰撞伤害）
            case 32:
                if(who==0){
                    diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*anil;
                    diff=diff<1?0:diff;
                    attHero.att_battle+=diff;
                    sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                }
                else{
                    diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*anil;
                    diff=diff<1?0:diff;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                }
                break;
            // 嘴遁
            case 33:
                if(who==0){
                    if(attHero.star>defHero.star && attHero.att_battle>defHero.def_battle){
                        diff=defHero.def_battle-1;
                    }
                    else{
                        diff=realSkillPower(skill, attTeam, attHero, defHero.resist)*defHero.def_battle;
                    }
                    //if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    if(attHero.star<defHero.star && attHero.att_battle<defHero.def_battle){
                        diff=attHero.att_battle-1;
                    }
                    else{
                        diff=realSkillPower(skill, defTeam, defHero, attHero.resist)*attHero.att_battle;
                    }
                    //if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            // 阴封印
            case 30:
            // 封印术
            case 34:
                if(who==0){
                    for(i=0; i<defTeam.number; i++){
                        if(defHero==defTeam.heros[i]){
                            break;
                        }
                    }
                    if(i>=defTeam.number){
                        System.out.println("Code shouldn't be reached.");
                        break;
                    }
                    defSkillable[i]=false;
                    sendMsg(defHero.name+" 不能发动技能");
                }
                else{
                    for(i=0; i<attTeam.number; i++){
                        if(attHero==attTeam.heros[i]){
                            break;
                        }
                    }
                    if(i>=attTeam.number){
                        System.out.println("Code shouldn't be reached.");
                        break;
                    }
                    attSkillable[i]=false;
                    sendMsg(attHero.name+" 不能发动技能");
                }
                break;
            // 神树降诞
            case 35:
                if(who==0){
                    diff=defHero.def_battle-1;
                    defHero.def_battle-=diff;
                    //if(defHero.def_battle<0) defHero.def_battle=0;
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                else{
                    diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    //if(attHero.att_battle<0) attHero.att_battle=0;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                break;
            default:
                System.out.println("effect(): code should never be reached. type="+skill.type);
        }
        if(attHero.att_battle>defHero.def_battle){
            conditionAttStronger=true;
        }
        else{
            conditionAttStronger=false;
        }
    }
    
    // 检查队伍存活状态，只要有人存活则返回第一个存活者编号，否则返回-1
    private int checkStatus(boolean[] status){
        int i;
        for(i=0; i<status.length; i++){
            if(status[i]){
                return i;
            }
        }
        return -1;
    }
    
    // 检查属性相克，返回双方属性加成比例%
    private int[] checkProperty(int p1, int p2){
        int[] result=new int[2];
        result[0]=result[1]=0;
        int pl1=p1/10;
        int pp1=p1%10;
        int pl2=p2/10;
        int pp2=p2%10;
        // 全 VS 全
        if(pl1==2 && pl2==2){
            return result;
        }
        int winner=0;
        // 确定谁克制谁
        if(pl1==2){
            winner=1;
        }
        else if(pl2==2){
            winner=-1;
        }
        else{
            if(pp1-pp2==4 || pp1-pp2==-1){
                winner=1;
            }
            else if(pp1-pp2==1 || pp1-pp2==-4){
                winner=-1;
            }
        }
        if(winner==0){
            return result;
        }
        result[0]=15*winner;
        result[1]=-15*winner;
        // 确定双方加成比例
        if(pl1==2){
            result[0]+=15;
        }
        else if(pl1==1){
            result[0]+=10;
        }
        if(pl2==2){
            result[1]+=15;
        }
        else if(pl2==1){
            result[1]+=10;
        }
        return result;
    }
    
    // 取下一个准备放技能的尾兽
    private int getNextPet(int index, int[] pets){
        int i;
        for(i=index+1; i<pets.length; i++){
            if(pets[i]>0){
                break;
            }
        }
        return i;
    }
    
    private double petSkillRate(int pet, int level){
        return petRate[(pet-1)*10+level];
    }
    
    private double petSkillPower(int pet, int level){
        return petPower[(pet-1)*10+level];
    }
    
    private String petName(int pet){
        switch(pet){
            case 1:
                return "守鹤";
            case 2:
                return "又旅";
            case 3:
                return "矶抚";
            case 4:
                return "孙悟空";
            case 5:
                return "穆王";
            case 6:
                return "犀犬";
            case 7:
                return "重明";
            case 8:
                return "牛鬼";
            case 9:
                return "九摩诃";
            case 10:
                return "神树";
            default:
                return "";
        }
    }
    
    private String petSkillName(int pet){
        switch(pet){
            case 1:
                return "守鹤之盾";
            case 2:
                return "还魂之苍焰";
            case 3:
                return "惊涛骇浪";
            case 4:
                return "熔遁花果山";
            case 5:
                return "百豪之光";
            case 6:
                return "酸性腐液";
            case 7:
                return "秘术神光";
            case 8:
                return "极尾兽玉";
            case 9:
                return "超究尾兽玉";
            case 10:
                return "神树降诞";
            default:
                return "";
        }
    }
    
    // return : 1 attacker wins, 0 defender wins, 2 even(meaning attacker wins)
    // killFirst: 1 强袭模式去掉首忍者， 0 防卫模式去掉首忍者
    public int battle(Team attacker, Team defender, int killFirst){
        
        //if(output!=null){
        allMsg="     进攻方                VS                防御方\n";
        //}
        boolean[] attStatus=new boolean[20];
        boolean[] defStatus=new boolean[20];
        int i, j;
        // init conditions
        conditionAttDup=false;
        conditionDefDup=false;
        stayDead=killFirst;
        for(i=0; i<20; i++){
            if(i<attacker.number && (i!=0 || killFirst!=0)){
                attStatus[i]=true;
                attSkillable[i]=true;
                attPoisoned[i]=false;
                attacker.heros[i].att_battle=attacker.heros[i].att;
                if(!conditionAttDup){
                    for(j=i+1; j<attacker.number; j++){
                        if(attacker.heros[i].id==attacker.heros[j].id){
                            conditionAttDup=true;
                            break;
                        }
                    }
                }
            }
            else{
                attStatus[i]=false;
                attSkillable[i]=false;
                attPoisoned[i]=false;
            }
            if(i<defender.number && (i!=0 || killFirst!=1)){
                defStatus[i]=true;
                defSkillable[i]=true;
                defPoisoned[i]=false;
                defender.heros[i].def_battle=defender.heros[i].def;
                if(!conditionDefDup){
                    for(j=i+1; j<defender.number; j++){
                        if(defender.heros[i].hid==defender.heros[j].hid){
                            conditionDefDup=true;
                            break;
                        }
                    }
                }
            }
            else{
                defStatus[i]=false;
                defSkillable[i]=false;
                defPoisoned[i]=false;
            }
        }
        // init pet status
        petIndexAtt=getNextPet(-1, attacker.pet);
        petIndexDef=getNextPet(-1, defender.pet);
        activePetAtt=0;
        activePetDef=0;
        isActive3Att=false;
        isActive6Att=false;
        isActive7Att=false;
        isActive3Def=false;
        isActive6Def=false;
        isActive7Def=false;
        petCacheAtt=20;
        petCacheDef=20;
        double petSkillPowerAtt=0, petSkillPowerDef=0;
        double petSkillPowerAtt2=0, petSkillPowerDef2=0;
        double pet3PowerAtt=0, pet3PowerDef=0;
        int[] pc;
        String s;
        double tmpDouble;
        i=checkStatus(attStatus);
        j=checkStatus(defStatus);
        Hero attHero=null, defHero=null;
        boolean attSkilled, defSkilled;
        Skill attSkill, defSkill;
        int k, l, death;
        double diff;
        while(i>=0 && j>=0){
            attHero=attacker.heros[i];
            defHero=defender.heros[j];
            anil=0;
            showValue(attHero, defHero);
            if(attHero.att_battle>defHero.def_battle){
                conditionAttStronger=true;
            }
            else{
                conditionAttStronger=false;
            }
            flagAttWeaken=1;
            flagDefWeaken=1;
            // 尾兽技能
            if(petIndexAtt<attacker.pet.length && Math.random()<petSkillRate(attacker.pet[petIndexAtt], attacker.petLevel[petIndexAtt])*(1+attacker.petSkillRate/100)){
                activePetAtt=attacker.pet[petIndexAtt];
                petSkillPowerAtt=petSkillPower(activePetAtt, attacker.petLevel[petIndexAtt]);
                petSkillPowerAtt2=pet4Left[attacker.petLevel[petIndexAtt]];
                sendMsg(petName(activePetAtt)+"--"+petSkillName(activePetAtt)+" >>>");
                petIndexAtt=getNextPet(petIndexAtt, attacker.pet);
            }
            // 进攻方即时尾兽技能生效
            if(activePetAtt==2){
                death=0;
                for(k=0; k<attacker.number; k++){
                    if(!attStatus[k]){
                        death++;
                    }
                }
                if(death>0){
                    l=(int)(Math.random()*death);
                    k=0;
                    while(l>=0){
                        if(!attStatus[k++]){
                            l--;
                        }
                    }
                    attStatus[--k]=true;
                    attacker.heros[k].att_battle=petSkillPowerAtt*attacker.heros[k].att;
                    sendMsg(attacker.heros[k].name+" 复活！");
                }
                activePetAtt=0;
            }
            else if(activePetAtt==3){
                isActive3Att=true;
                if(pet3PowerAtt==0){
                    pet3PowerAtt=petSkillPowerAtt;
                }
            }
            else if(activePetAtt==4){
                diff=petSkillPowerAtt*attHero.att_battle;
                attHero.att_battle+=diff;
                flagAttWeaken*=petSkillPowerAtt2;
                sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                activePetAtt=0;
            }
            else if(activePetAtt==5){
                diff=petSkillPowerAtt*attHero.att_battle;
                attHero.att_battle+=diff;
                sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                activePetAtt=0;
            }
            else if(activePetAtt==6){
                isActive6Att=true;
            }
            else if(activePetAtt==7){
                petCacheAtt=attHero.property_battle;
                attHero.property_battle=20;
                activePetAtt=0;
                isActive7Att=true;
            }
            else if(activePetAtt==8){
                diff=petSkillPowerAtt*defHero.def_battle;
                if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                defHero.def_battle-=diff;
                sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                activePetAtt=0;
            }
            else if(activePetAtt==9 && !conditionAttStronger){
                diff=petSkillPowerAtt*(defHero.def_battle-attHero.att_battle);
                if(diff<0) diff=0;
                if(defHero.def_battle<=diff) diff=defHero.def_battle-1;
                attHero.att_battle+=diff;
                defHero.def_battle-=diff;
                sendMsg(attHero.name+" +"+(int)diff+" "+(int)attHero.att_battle);
                sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                activePetAtt=0;
            }
            else if(activePetAtt==10){
                defHero.def_battle=0;
            }
            if(activePetAtt!=10){
                if(attHero.att_battle>defHero.def_battle){
                    conditionAttStronger=true;
                }
                else{
                    conditionAttStronger=false;
                }
                if(petIndexDef<defender.pet.length && Math.random()<petSkillRate(defender.pet[petIndexDef], defender.petLevel[petIndexDef])*(1+defender.petSkillRate/100)){
                    activePetDef=defender.pet[petIndexDef];
                    petSkillPowerDef=petSkillPower(activePetDef, defender.petLevel[petIndexDef]);
                    petSkillPowerDef2=pet4Left[defender.petLevel[petIndexDef]];
                    if(activePetAtt==1 && (activePetDef==2 || activePetDef==3 || activePetDef==4 || activePetDef==5 || activePetDef==8 || activePetDef==9 || activePetDef==10)){
                        activePetDef=0;
                        sendMsg("    免疫                 <<< "+petSkillName(activePetDef)+"--"+petName(activePetDef));
                    }
                    else{
                        sendMsg("                           <<< "+petSkillName(activePetDef)+"--"+petName(activePetDef));
                    }
                    petIndexDef=getNextPet(petIndexDef, defender.pet);
                }
                // 防御方即时尾兽技能生效
                if(activePetDef==2){
                    death=0;
                    for(k=0; k<defender.number; k++){
                        if(!defStatus[k]){
                            death++;
                        }
                    }
                    if(death>0){
                        l=(int)(Math.random()*death);
                        k=0;
                        while(l>=0){
                            if(!defStatus[k++]){
                                l--;
                            }
                        }
                        defStatus[--k]=true;
                        defender.heros[k].def_battle=petSkillPowerDef*defender.heros[k].def;
                        sendMsg(defender.heros[k].name+" 复活！");
                    }
                    activePetDef=0;
                }
                else if(activePetDef==3){
                    isActive3Def=true;
                    if(pet3PowerDef==0){
                        pet3PowerDef=petSkillPowerDef;
                    }
                }
                else if(activePetDef==4){
                    diff=petSkillPowerDef*defHero.def_battle;
                    defHero.def_battle+=diff;
                    flagDefWeaken*=petSkillPowerDef2;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                    activePetDef=0;
                }
                else if(activePetDef==5){
                    diff=petSkillPowerDef*defHero.def_battle;
                    defHero.def_battle+=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                    activePetDef=0;
                }
                else if(activePetDef==6){
                    isActive6Def=true;
                }
                else if(activePetDef==7){
                    petCacheDef=defHero.property_battle;
                    defHero.property_battle=20;
                    activePetDef=0;
                    isActive7Def=true;
                }
                else if(activePetDef==8){
                    diff=petSkillPowerDef*attHero.att_battle;
                    if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    attHero.att_battle-=diff;
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                    activePetDef=0;
                }
                else if(activePetDef==9 && conditionAttStronger){
                    diff=petSkillPowerDef*(attHero.att_battle-defHero.def_battle);
                    if(diff<0) diff=0;
                    if(attHero.att_battle<=diff) diff=attHero.att_battle-1;
                    defHero.def_battle+=diff;
                    attHero.att_battle-=diff;
                    sendMsg(defHero.name+" +"+(int)diff+" "+(int)defHero.def_battle);
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                    activePetDef=0;
                }
                else if(activePetDef==10){
                    attHero.att_battle=0;
                }
                if(activePetDef!=10){
                    if(attHero.att_battle>defHero.def_battle){
                        conditionAttStronger=true;
                    }
                    else{
                        conditionAttStronger=false;
                    }
                    attSkilled=defSkilled=false;
                    attSkill=defSkill=null;
                    // 判断进攻方是否发动技能
                    if(attSkillable[i] && (attSkill=activate(attHero.skill1, 0, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))==null){
                        attSkill=activate(attHero.skill2, 0, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number);
                    }
                    if(activePetDef==1){
                        attSkill=null;
                    }
                    // 判断防御方是否发动技能
                    if(defSkillable[j] && (defSkill=activate(defHero.skill1, 0, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))==null){
                        defSkill=activate(defHero.skill2, 0, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number);
                    }
                    if(activePetAtt==1){
                        defSkill=null;
                    }
                    // 判断是否发动被动技能
                    Skill tmpSkill=null;
                    if(attSkill!=null){
                        if(defSkillable[j] && (tmpSkill=activate(defHero.skill1, 1, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))==null){
                            //tmpSkill=activate(defHero.skill2, 1, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number);
                        }
                    }
                    if(tmpSkill!=null){
                        defSkill=tmpSkill;
                    }
                    tmpSkill=null;
                    if(defSkill!=null && defSkill.type!=15 && defSkill.type!=16){
                        if(attSkillable[i] && (tmpSkill=activate(attHero.skill1, 1, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))==null){
                            //tmpSkill=activate(attHero.skill2, 1, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number);
                        }
                    }
                    if(tmpSkill!=null){
                        attSkill=tmpSkill;
                    }
                    tmpSkill=null;
                    if(activePetDef==1 && attSkill!=null && attSkill.type==15){
                        attSkill=null;
                    }
                    if(activePetAtt==1 && defSkill!=null && defSkill.type==15){
                        attSkill=null;
                    }
                    // 技能效果
                    if(attSkill!=null && attSkill.timming()==0){
                        if(attSkill.type!=14 || (attSkill.type==14 && !conditionAttStronger)){
                            sendMsg(attHero.name+" 发动 "+attSkill.name);
                            if(defSkill==null || defSkill.type!=16){
                                effect(attSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                            }   
                        }
                    }
                    if(defSkill!=null && defSkill.timming()==0){
                        if(defSkill.type!=14 || (defSkill.type==14 && conditionAttStronger)){
                            sendMsg(defHero.name+" 发动 "+defSkill.name);
                            if(attSkill==null || attSkill.type!=16){
                                effect(defSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                            }
                        }
                    }
                    if(attSkill!=null && attSkill.timming()==1){
                        sendMsg(attHero.name+" 发动 "+attSkill.name);
                        if(attSkill.type==15 && defSkill!=null){
                            effect(defSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                        }
                    }
                    if(defSkill!=null && defSkill.timming()==1){
                        sendMsg(defHero.name+" 发动 "+defSkill.name);
                        if(defSkill.type==15 && attSkill!=null){
                            effect(attSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                        }
                    }
                    
                    
                    /*
                    // 若进攻方发动技能，判断防御方是否发动被动技能
                    if(attSkill!=null){
                        attSkilled=true;
                        if(activePetDef==1){
                            sendMsg(attHero.name+" 发动 "+attSkill.name+" (守鹤之盾 免疫)");
                        }
                        else{
                            sendMsg(attHero.name+" 发动 "+attSkill.name);
                            if(defSkillable[j] && (defSkill=activate(defHero.skill1, 1, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))==null){
                                defSkill=activate(defHero.skill2, 1, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number);
                            }
                            if(defSkill!=null){
                                defSkilled=true;
                            }
                            // 进攻方技能生效
                            if(!defSkilled || (defSkilled && defSkill.type!=16)){
                                effect(attSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                                // copy 忍术
                                if(defSkilled){
                                    sendMsg(defHero.name+" 复制 "+attSkill.name);
                                    effect(attSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                                }
                            }
                            else{
                                sendMsg(defHero.name+" 发动 "+defSkill.name);
                            }
                        }
                    }
                    if(!defSkilled){
                        // 判断防御方是否发动技能
                        if(defSkillable[j] && (defSkill=activate(defHero.skill1, 0, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))==null){
                            defSkill=activate(defHero.skill2, 0, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number);
                        }
                        // 若防御方发动技能，判断进攻方是否发动被动技能
                        if(defSkill!=null){
                            defSkilled=true;
                            if(activePetAtt==1){
                                sendMsg(defHero.name+" 发动 "+defSkill.name+" (守鹤之盾 免疫)");
                            }
                            else{
                                sendMsg(defHero.name+" 发动 "+defSkill.name);
                                if(!attSkilled && attSkillable[i]){
                                    if((attSkill=activate(attHero.skill1, 1, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))==null){
                                        attSkill=activate(attHero.skill2, 1, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number);
                                    }
                                    if(attSkill!=null){
                                        attSkilled=true;
                                    }
                                }
                                // 防御方技能生效
                                if(attSkill==null || attSkill.type!=16){
                                    effect(defSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                                    // copy 忍术
                                    if(attSkill!=null && attSkill.timming()==1){
                                        sendMsg(attHero.name+" 复制 "+defSkill.name);
                                        effect(defSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                                    }
                                }
                                else{
                                    sendMsg(attHero.name+" 发动 "+attSkill.name);
                                }
                            }
                        }
                    }
                    */
                    if(attSkill!=null || defSkill!=null) showValue(attHero, defHero);
                    // 属性效果
                    if(attHero.att_battle<0) attHero.att_battle=0;
                    if(defHero.def_battle<0) defHero.def_battle=0;
                    pc=checkProperty(attHero.property_battle, defHero.property_battle);
                    if((isActive6Att && pc[0]<0) || (isActive6Def && pc[1]<0)){
                        pc[0]=pc[1]=0;
                    }
                    if(pc[0]!=0 || pc[1]!=0){
                        attHero.att_battle*=(1+pc[0]/(double)100);
                        //if(attHero.att_battle<1) attHero.att_battle=1;
                        defHero.def_battle*=(1+pc[1]/(double)100);
                        //if(defHero.def_battle<1) defHero.def_battle=1;
                        s=Hero.propertyToString(attHero.property_battle)+(pc[0]>0?" +":" ")+pc[0]+"%";
                        if(pc[0]>0){
                            s+=" --> ";
                        }
                        else{
                            s+=" <-- ";
                        }
                        s+=(pc[1]>0?"+":"")+pc[1]+"% "+Hero.propertyToString(defHero.property_battle);
                        sendMsg(s);
                        showValue(attHero, defHero);
                    }
                    if(attHero.att_battle<1) attHero.att_battle=1;
                    if(defHero.def_battle<1) defHero.def_battle=1;
                    // 数值相减
                    tmpDouble=attHero.att_battle>defHero.def_battle? defHero.def_battle:attHero.att_battle;
                    anil=tmpDouble;
                    attHero.att_battle-=tmpDouble;
                    defHero.def_battle-=tmpDouble;
                }
                else{
                    //activePetDef=0;
                    //sendMsg(attHero.name+" 阵亡");
                }
            }
            else{
                //activePetAtt=0;
                //sendMsg(defHero.name+" 阵亡");
            }
            // 回血
            if(attHero.att_battle>0){
                if(attSkillable[i] && ((attSkill=activate(attHero.skill1, 3, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))!=null
                        || (attSkill=activate(attHero.skill2, 3, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))!=null)){
                    sendMsg(attHero.name+" 发动 "+attSkill.name);
                    effect(attSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                }
                if(flagAttWeaken!=1){
                    tmpDouble=attHero.att_battle*(1-flagAttWeaken);
                    attHero.att_battle-=tmpDouble;
                    sendMsg(attHero.name+(tmpDouble>=0?" -":" ")+(int)tmpDouble+" "+(int)(attHero.att_battle));
                }
            }
            if(defHero.def_battle>0){
                if(defSkillable[j] && ((defSkill=activate(defHero.skill1, 3, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))!=null
                        || (defSkill=activate(defHero.skill2, 3, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))!=null)){
                    sendMsg(defHero.name+" 发动 "+defSkill.name);
                    effect(defSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                }
                if(flagDefWeaken!=1){
                    tmpDouble=defHero.def_battle*(1-flagDefWeaken);
                    defHero.def_battle-=tmpDouble;
                    sendMsg(defHero.name+(tmpDouble>=0?" -":" ")+(int)tmpDouble+" "+(int)(defHero.def_battle));
                }
            }
            if(attHero.att_battle<=0){
                attStatus[i]=false;
                sendMsg(attHero.name+" 阵亡");
                // 自爆
                if(petCacheAtt!=20){
                    attHero.property_battle=petCacheAtt;
                    petCacheAtt=20;
                }
                activePetAtt=0;
                if(attSkillable[i] && ((attSkill=activate(attHero.skill1, 2, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))!=null
                        || (attSkill=activate(attHero.skill2, 2, 0, attacker.skillRateMultiply+attHero.rateRatio/100, attacker.skillRatePlus, attStatus, attacker.number))!=null)){
                    sendMsg(attHero.name+" 发动 "+attSkill.name);
                    effect(attSkill, 0, attacker, defender, attHero, defHero, attStatus, defStatus);
                }
            }
            if(defHero.def_battle<=0){
                defStatus[j]=false;
                sendMsg(defHero.name+" 阵亡");
                // 自爆
                if(petCacheDef!=20){
                    defHero.property_battle=petCacheDef;
                    petCacheDef=20;
                }
                activePetDef=0;
                if(defSkillable[j] && ((defSkill=activate(defHero.skill1, 2, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))!=null
                        || (defSkill=activate(defHero.skill2, 2, 1, defender.skillRateMultiply+defHero.rateRatio/100, defender.skillRatePlus, defStatus, defender.number))!=null)){
                    sendMsg(defHero.name+" 发动 "+defSkill.name);
                    effect(defSkill, 1, attacker, defender, attHero, defHero, attStatus, defStatus);
                }
            }
            // 三尾效果
            if(attHero.att_battle<=0){
                attStatus[i]=false;
                if(isActive3Att){
                    diff=pet3PowerAtt*defHero.def_battle;
                    defHero.def_battle-=diff;
                    sendMsg(petSkillName(3)+" 生效");
                    sendMsg(defHero.name+" -"+(int)diff+" "+(int)defHero.def_battle);
                }
                if(petCacheAtt!=20){
                    attHero.property_battle=petCacheAtt;
                    petCacheAtt=20;
                }
                isActive3Att=false;
                isActive6Att=false;
                isActive7Att=false;
                i=checkStatus(attStatus);
            }
            if(defHero.def_battle<=0){
                defStatus[j]=false;
                if(isActive3Def){
                    diff=pet3PowerDef*attHero.att_battle;
                    attHero.att_battle-=diff;
                    sendMsg(petSkillName(3)+" 生效");
                    sendMsg(attHero.name+" -"+(int)diff+" "+(int)attHero.att_battle);
                }
                if(petCacheDef!=20){
                    defHero.property_battle=petCacheDef;
                    petCacheDef=20;
                }
                isActive3Def=false;
                isActive6Def=false;
                isActive7Def=false;
                j=checkStatus(defStatus);
            }
            if(i>=0 && attHero==attacker.heros[i] && attHero.att_battle<=0){
                attStatus[i]=false;
                sendMsg(attHero.name+" 阵亡");
                if(petCacheAtt!=20){
                    attHero.property_battle=petCacheAtt;
                    petCacheAtt=20;
                }
                activePetAtt=0;
                isActive3Att=false;
                isActive6Att=false;
                isActive7Att=false;
                i=checkStatus(attStatus);
            }
            // 守鹤之盾消失
            if(activePetAtt==1){
                activePetAtt=0;
            }
            if(activePetDef==1){
                activePetDef=0;
            }
        }
        if(i<0){
            if(j<0){
                return 2;
            }
            if(petCacheDef!=20){
                defHero.property_battle=petCacheDef;
                petCacheDef=20;
            }
            return 0;
        }
        if(petCacheAtt!=20){
            attHero.property_battle=petCacheAtt;
            petCacheAtt=20;
        }
        return 1;
    }
}
