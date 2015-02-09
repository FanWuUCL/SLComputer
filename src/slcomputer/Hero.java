/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import slcomputer.equip.Equip;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Hero {
    public int hid;
    public int id;
    public int att_born;
    public int def_born;
    public double attGrowth;
    public double defGrowth;
    // 体术
    public int tough_born;
    public double toughGrowth;
    public double resist; // (resist%)
    public double tough;
    public String name;
    public String description;
    public int star;
    // 木叶0, 雾忍1, 岩忍2, 砂忍3, 雨忍4, 音忍5, 晓6, 云忍7, 泷忍8， 雪忍9， 忍兽10，秽土转生11，忍宗12
    public int style;
    public int gender;
    public int attOrDef;
    public double yuanAtt;
    public double yuanDef;
    // （装备提供的）忍术效果提升 powerRatio%
    public double powerRatio;
    // （装备提供的）忍术几率提升 rateRatio%
    public double rateRatio;
    public int level;
    public double potential;
    public double att;
    public double def;
    public double att_battle;
    public double def_battle;
    public Equip weapon;
    public Equip shield;
    public Equip pact;
    // 固有属性：雷0, 土1, 水2, 火3, 风4, 
    //      超雷10, 超土11, 超水12, 超火13, 超风14, 全20
    public int property;
    public int property_battle;
    public Skill skill1;
    public Skill skill2;
    public int skillIndex1;
    public int skillIndex2;
    public Skill[] backupSkills;
    // 直接输入模式
    public double attSet;
    public double defSet;
    public double weaponAttSet;
    public double weaponDefSet;
    public double weaponTfSet;
    public double weaponEffSet;
    public double shieldAttSet;
    public double shieldDefSet;
    public double shieldTfSet;
    public double shieldEffSet;
    public double pactAttSet;
    public double pactDefSet;
    public double pactTfSet;
    public double pactEffSet;
    // 缘
    public int[] yuan1;
    public int[] yuan2;
    public int[] yuan3;
    public int[] yuan4;
    public String yuanNames[];
    public boolean yuanActivated[];
    
    public Hero(){
        hid=0;
        id=0;
        att_born=1;
        def_born=1;
        attGrowth=1;
        defGrowth=1;
        tough_born=1;
        toughGrowth=1;
        tough=0;
        resist=0;
        name="[未选取]";
        description="无";
        star=0;
        style=0;
        gender=0;
        attOrDef=0;
        yuanAtt=0;
        yuanDef=0;
        powerRatio=0;
        level=1;
        weapon=null;
        shield=null;
        pact=null;
        property=3;
        potential=0;
        skill1=null;
        skill2=null;
        skillIndex1=-1;
        skillIndex2=-1;
        backupSkills=new Skill[20];
        int i;
        for(i=0; i<backupSkills.length; i++){
            backupSkills[i]=null;
        }
        attSet=100;
        defSet=100;
        weaponAttSet=0;
        weaponDefSet=0;
        weaponTfSet=0;
        weaponEffSet=0;
        shieldAttSet=0;
        shieldDefSet=0;
        shieldTfSet=0;
        shieldEffSet=0;
        pactAttSet=0;
        pactDefSet=0;
        pactTfSet=0;
        pactEffSet=0;
        yuan1=null;
        yuan2=null;
        yuan3=null;
        yuan4=null;
        yuanNames=new String[4];
        yuanActivated=new boolean[4];
        yuanNames[0]=yuanNames[1]=yuanNames[2]=yuanNames[3]=null;
        yuanActivated[0]=yuanActivated[1]=yuanActivated[2]=yuanActivated[3]=false;
    }
    
    // 返回此类的一个新对象，并且复制所有内容
    public Hero copy(){
        Hero h=dup();
        h.level=level;
        h.powerRatio=powerRatio;
        h.potential=potential;
        h.att=att;
        h.def=def;
        h.tough=tough;
        if(weapon!=null){
            h.weapon=weapon.copy();
        }
        else{
            h.weapon=null;
        }
        if(shield!=null){
            h.shield=shield.copy();
        }
        else{
            h.shield=null;
        }
        if(pact!=null){
            h.pact=pact.copy();
        }
        else{
            h.pact=null;
        }
        h.property_battle=property_battle;
        for(int i=0; i<yuanActivated.length; i++){
            h.yuanActivated[i]=yuanActivated[i];
        }
        return h;
    }
    
    // 返回此类的一个新对象
    public Hero dup(){
        Hero h=null;
        try {
            h=this.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
        }
        h.description=description;
        h.star=star;
        h.property=property;
        h.att_born=att_born;
        h.def_born=def_born;
        h.attOrDef=attOrDef;
        h.attGrowth=attGrowth;
        h.defGrowth=defGrowth;
        h.tough_born=tough_born;
        h.toughGrowth=toughGrowth;
        h.resist=resist;
        h.style=style;
        h.gender=gender;
        h.skill1=skill1;
        h.skill2=skill2;
        h.skillIndex1=skillIndex1;
        h.skillIndex2=skillIndex2;
        h.backupSkills=backupSkills;
        h.attSet=attSet;
        h.defSet=defSet;
        h.weaponAttSet=weaponAttSet;
        h.weaponDefSet=weaponDefSet;
        h.weaponTfSet=weaponTfSet;
        h.weaponEffSet=weaponEffSet;
        h.shieldAttSet=shieldAttSet;
        h.shieldDefSet=shieldDefSet;
        h.shieldTfSet=shieldTfSet;
        h.shieldEffSet=shieldEffSet;
        h.pactAttSet=pactAttSet;
        h.pactDefSet=pactDefSet;
        h.pactTfSet=pactTfSet;
        h.pactEffSet=pactEffSet;
        h.yuan1=yuan1;
        h.yuan2=yuan2;
        h.yuan3=yuan3;
        h.yuan4=yuan4;
        h.yuanNames=yuanNames;
        return h;
    }
    
    public static String propertyToString(int p){
        String s;
        switch(p){
            case 0:
                s="雷";
                break;
            case 1:
                s="土";
                break;
            case 2:
                s="水";
                break;
            case 3:
                s="火";
                break;
            case 4:
                s="风";
                break;
            case 10:
                s="超雷";
                break;
            case 11:
                s="超土";
                break;
            case 12:
                s="超水";
                break;
            case 13:
                s="超火";
                break;
            case 14:
                s="超风";
                break;
            case 20:
                s="全";
                break;
            default:
                s="??";
                break;
        }
        return s;
    }
    
    public double allYuan(Team team){
        return yuan1(team)+yuan2(team)+yuan3(team)+yuan4(team);
    }
    
    public double yuan1(Team team){
        return yuan(team, 1);
    }
    
    public double yuan2(Team team){
        return yuan(team, 2);
    }
    
    public double yuan3(Team team){
        return yuan(team, 3);
    }
    
    public double yuan4(Team team){
        return yuan(team, 4);
    }
    
    public double yuan(Team team, int index){
        int yuan[];
        yuanActivated[index-1]=true;
        switch(index){
            case 1:
                yuan=yuan1;
                break;
            case 2:
                yuan=yuan2;
                break;
            case 3:
                yuan=yuan3;
                break;
            case 4:
                yuan=yuan4;
                break;
            default:
                yuan=null;
        }
        if(yuan==null){
            yuanActivated[index-1]=false;
            return 0;
        }
        double ret=(yuan[10]+yuan[11])/(double)100;
        int i, j;
        int sum=0;
        switch(yuan[1]){
            case 0:
                for(i=2; i<yuan[0]; i++){
                    for(j=0; j<team.number; j++) {
                        if(team.heros[j].hid==yuan[i]){
                            sum++;
                            break;
                        }
                    }
                    if(j==team.number){
                        for(j=0; j<team.backNumber; j++){
                            if(team.backHeros[j].hid==yuan[i]){
                                sum++;
                                break;
                            }
                        }
                    }
                }
                if(sum==yuan[0]-2){
                    return ret;
                }
                break;
            case 1:
                if(!(weapon.eid==yuan[2] || shield.eid==yuan[2] || (pact!=null && pact.eid==yuan[2]))) {
                    sum=1;
                }
                if(yuan[0]>3){
                    if(!(weapon.eid==yuan[3] || shield.eid==yuan[3] || (pact!=null && pact.eid==yuan[3]))) {
                        sum=1;
                    }
                }
                if(yuan[0]>4){
                    if(!(weapon.eid==yuan[4] || shield.eid==yuan[4] || (pact!=null && pact.eid==yuan[4]))) {
                        sum=1;
                    }
                }
                if(sum==0){
                    return ret;
                }
                break;
            case 2:
                for(i=0; i<5; i++){
                    if(team.pet[i]==80109-yuan[2]){
                        return ret;
                    }
                }
                break;
            case 3:
                for(i=0; i<team.number; i++) {
                    if(team.heros[i].gender==yuan[2]){
                        sum++;
                    }
                }
                for(i=0; i<team.backNumber; i++){
                    if(team.backHeros[i].gender==yuan[2]){
                        sum++;
                    }
                }
                if(sum>=yuan[3]){
                    return ret;
                }
                break;
            case 4:
                for(i=0; i<team.number; i++) {
                    if(team.heros[i].star>=yuan[2]){
                        sum++;
                    }
                }
                for(i=0; i<team.backNumber; i++){
                    if(team.backHeros[i].star>=yuan[2]){
                        sum++;
                    }
                }
                if(sum>=yuan[4]){
                    return ret;
                }
                break;
            case 5: // 光环
                j=1;
                // 判断该忍者是不是第一次出现
                for(i=0; i<team.number; i++) {
                    if(team.heros[i]==this){
                        break;
                    }
                    if(team.heros[i].id==id && team.heros[i]!=this){
                        j++;
                    }
                }
                // 检查除了该忍者外是否有指定group的忍者
                for(i=0; i<team.number; i++) {
                    if(team.heros[i].style==yuan[2] && team.heros[i].hid!=this.hid){
                        sum=1;
                    }
                }
                if(sum!=1){
                    for(i=0; i<team.backNumber; i++) {
                        if(team.backHeros[i].style==yuan[2] && team.backHeros[i].hid!=this.hid){
                            sum=1;
                        }
                    }
                }
                // 如果是第一次出现该忍者，则给其他同group的忍者加成
                if(sum==1) {
                    if(j==1){
                        for(i=0; i<team.number; i++) {
                            if(team.heros[i].style==yuan[2] && team.heros[i].id!=this.id){
                                team.heros[i].yuanAtt+=yuan[12]/(double)100;
                                team.heros[i].yuanDef+=yuan[13]/(double)100;
                            }
                        }
                    }
                    return ret;
                }
                break;
            case 6:
            case 7:
                if(weapon.star>=yuan[2] && shield.star>=yuan[2]) {
                    return ret;
                }
                break;
            case 8:
                for(i=0; i<team.number; i++) {
                    if(team.heros[i].hid==this.hid){
                        sum++;
                    }
                }
                for(i=0; i<team.backNumber; i++) {
                    if(team.backHeros[i].hid==this.hid){
                        sum++;
                    }
                }
                if(sum>=2) {
                    return ret;
                }
                break;
            default:
        }
        yuanActivated[index-1]=false;
        return 0;
    }
    
    @Override
    public String toString(){
        String s="<html><font color=";
        switch(star){
            case 6:
                s+="#FFD700>";  // FFD700
                break;
            case 5:
                s+="#FF4500>";
                break;
            case 4:
                s+="#4B088A>";
                break;
            case 3:
                s+="#0431B4>";
                break;
            case 2:
                s+="#088A08>";
                break;
            case 1:
                s+="#585858>";
                break;
            default:
                s+="#000000>";
                break;
        }
        s=s+name+"</font></html>";
        return s;
    }
    
    public String toStringWithoutHtml(){
        String s="<font color=";
        switch(star){
            case 6:
                s+="#FFD700>";
                break;
            case 5:
                s+="#FF4500>";
                break;
            case 4:
                s+="#4B088A>";
                break;
            case 3:
                s+="#0431B4>";
                break;
            case 2:
                s+="#088A08>";
                break;
            case 1:
                s+="#585858>";
                break;
            default:
                s+="#000000>";
                break;
        }
        s=s+name+"</font>";
        return s;
    }
}
