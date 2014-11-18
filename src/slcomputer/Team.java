/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

/**
 *
 * @author J
 */
public class Team {
    public int number;
    public Hero[] heros;
    public int[] pet;
    // for the sake of simplicity, 0 means level 1
    public int[] petLevel;
    
    public int numberMax;
    // 尾兽和建筑增益
    public double powerAtt;
    public double powerDef;
    public double[] powerUpbyProperty;
    // 技能加成，包括尾兽提供的和试炼每3层的增益, 0表示没有加成 1表示加成100%
    public double skillPower;
    public double skillRatePlus;
    public double skillRateMultiply;
    // 十尾提供的尾兽技能几率加成
    public double petSkillRate;
    // 爱心小屋
    public int backNumber;
    public Hero[] backHeros;
    
    public Team(){
        number=0;
        numberMax=0;
        heros=new Hero[20];
        pet=new int[5];
        petLevel=new int[5];
        pet[0]=pet[1]=pet[2]=pet[3]=pet[4]=0;
        petLevel[0]=petLevel[2]=petLevel[3]=petLevel[4]=petLevel[1]=0;
        // 前五只尾兽对技能的加成，50表示加50%, 顺序为 雷 土 水 火 风
        powerAtt=0;
        powerDef=0;
        powerUpbyProperty=new double[5];
        powerUpbyProperty[0]=powerUpbyProperty[1]=powerUpbyProperty[2]=powerUpbyProperty[3]=powerUpbyProperty[4]=0;
        // 0表示没有加成 1表示加成100%
        skillPower=0;
        skillRatePlus=0;
        skillRateMultiply=0;
        petSkillRate=0;
        backNumber=0;
        backHeros=new Hero[10];
        for(int i=0; i<backHeros.length; i++){
            backHeros[i]=null;
        }
    }
    
    // 复制阵容，返回一个新的对象
    public Team copy(){
        Team copy=new Team();
        if(numberMax>0){
            int i;
            copy.numberMax=numberMax;
            copy.number=copy.numberMax;
            for(i=0; i<copy.numberMax; i++){
                copy.heros[i]=heros[i].copy();
            }
            for(i=0; i<5; i++){
                copy.pet[i]=pet[i];
                copy.petLevel[i]=petLevel[i];
                copy.powerUpbyProperty[i]=powerUpbyProperty[i];
            }
            copy.powerAtt=powerAtt;
            copy.powerDef=powerDef;
            copy.skillPower=skillPower;
            copy.skillRatePlus=skillRatePlus;
            copy.skillRateMultiply=skillRateMultiply;
            copy.petSkillRate=petSkillRate;
            copy.backNumber=backNumber;
            for(i=0; i<backNumber; i++){
                copy.backHeros[i]=backHeros[i].copy();
            }
        }
        return copy;
    }
    
    public int retriveTough(Hero h){
        double t=200000/(100-h.resist)-2000;
        t=t-(h.tough_born+(h.level-1)*h.toughGrowth);
        return (int)t;
    }
    
    // att=(att_born+(level-1)*attGrowth+(potentialAll-potential))*(1+allYuan)*(1+0.01*powerAtt/Def)*(base+usrEx)+equip
    // 试炼高层提供的忍术几率 exSkillRate%
    public double compute(int mode, double base, double usrExAtt, double usrExDef, double extraBodyskill, boolean dreamMode){
        double sum=0;
        if(number==0 || numberMax==0){
            return 0;
        }
        int i, j;
        double d;
        for(i=0; i<number; i++){
            heros[i].yuanAtt=0;
            heros[i].yuanDef=0;
        }
        for(i=0; i<number; i++){
            d=heros[i].yuan1(this)+heros[i].yuan2(this)+heros[i].yuan3(this)+heros[i].yuan4(this);
            if(heros[i].attOrDef==1){
                heros[i].yuanAtt+=d;
            }
            else{
                heros[i].yuanDef+=d;
            }
        }
        double loveAtt=0;
        double loveDef=0;
        for(i=0; i<backNumber; i++){
            if(i<5){
                d=5;
            }
            else{
                d=7;
            }
            d=d+backHeros[i].property_battle/10;
            loveAtt+=backHeros[i].att*d*0.01;
            loveDef+=backHeros[i].def*d*0.01;
        }
        // 八门遁甲
        int bmAtt=0;
        int bmDef=0;
        int bmEq=0;
        if(mode>1){
            if(number>=9){  // 开门
                bmAtt+=2;
                //System.out.println("开门 开！");
                if(number>=10){ // 休门
                    bmDef+=2; //System.out.println("休门 开！");
                    if(number>=11){ // 生门
                        bmEq+=3; //System.out.println("生门 开！");
                        if(number>=12){ // 伤门
                            bmAtt+=3;
                            bmDef+=3; //System.out.println("伤门 开！");
                            int n4=0;
                            int n6=0;
                            for(i=0; i<number; i++){
                                j=retriveTough(heros[i]);
                                if(j>495){
                                    n4++;
                                    if(j>1045){
                                        n6++;
                                    }
                                }
                            }
                            //System.out.println("n4="+n4+", n6="+n6);
                            if(n4>=6){   // 杜门
                                bmAtt+=3; //System.out.println("杜门 开！");
                                if(n4>=8){  // 景门
                                    bmDef+=3; //System.out.println("景门 开！");
                                    if(n6>=12){ // 惊门
                                        bmEq+=3; //System.out.println("惊门 开！");
                                        if(n6>=14){ // 死门
                                            bmAtt+=3;
                                            bmDef+=3; //System.out.println("死门 开！");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // 对手值=(初始值+成长值*（等级-1)+已点潜力)*(1+缘加成%)*(尾兽+建筑)*(层数-减益)+装备属性+爱心小屋
        // mode: 0 返回敌人攻击值, 1 返回敌人防御值, 2 返回己方攻击值, 3 返回己方防御值
        for(i=0; i<number; i++){
            if(dreamMode){
                heros[i].att=(int)(heros[i].att_born+(heros[i].level-1)*heros[i].attGrowth);
                heros[i].def=(int)(heros[i].def_born+(heros[i].level-1)*heros[i].defGrowth);
                if(heros[i].att_born>heros[i].def_born){
                    d=(heros[i].att+heros[i].def)*0.6-heros[i].potential;
                    if(d>0){
                        heros[i].att+=(int)d;
                    }
                }
                else{
                    d=(heros[i].att+heros[i].def)*0.6-heros[i].potential;
                    if(d>0){
                        heros[i].def+=(int)d;
                    }
                }
                heros[i].att=(int)(heros[i].att);
                heros[i].att*=(1+heros[i].yuanAtt);
                heros[i].att*=(1+(powerAtt+bmAtt)/100);
                heros[i].att*=Math.abs(base+usrExAtt);
                heros[i].att=(int)(heros[i].att);
                heros[i].att+=(int)loveAtt;
                heros[i].def=(int)(heros[i].def);
                heros[i].def*=(1+heros[i].yuanDef);
                heros[i].def*=(1+(powerDef+bmDef)/100);
                heros[i].def*=Math.abs(base+usrExDef);
                heros[i].def=(int)(heros[i].def);
                heros[i].def+=(int)loveDef;
            }
            else{
                heros[i].att=(heros[i].attSet-heros[i].weaponAttSet-heros[i].shieldAttSet-loveAtt)*Math.abs(base+usrExAtt)+heros[i].weaponAttSet+heros[i].shieldAttSet+loveAtt;
                heros[i].def=(heros[i].defSet-heros[i].weaponDefSet-heros[i].shieldDefSet-loveDef)*Math.abs(base+usrExDef)+heros[i].weaponDefSet+heros[i].shieldDefSet+loveDef;
                heros[i].att=(int)heros[i].att;
                heros[i].def=(int)heros[i].def;
            }
            double bodyskill;
            if(extraBodyskill>0){
                //System.out.println("bodyskill="+extraBodyskill);
                if(heros[i].star==6){
                    bodyskill=heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill;
                    //heros[i].resist=(heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill)*0.043;
                    heros[i].resist=1/(20/bodyskill+0.01);
                }
                else if(heros[i].star==5){
                    bodyskill=heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill;
                    //heros[i].resist=(heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill)*0.045;
                    heros[i].resist=1/(20/bodyskill+0.01);
                }
                else{
                    bodyskill=heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill;
                    //heros[i].resist=(heros[i].tough_born+(heros[i].level-1)*heros[i].toughGrowth+extraBodyskill)*0.05;
                    heros[i].resist=1/(20/bodyskill+0.01);
                }
            }
            heros[i].powerRatio=0;
            heros[i].rateRatio=0;
            if(dreamMode){
                if(heros[i].weapon!=null){
                    heros[i].weapon.att=(int)(heros[i].weapon.att_born+(heros[i].weapon.level-1)*heros[i].weapon.attGrowth);
                    heros[i].weapon.def=(int)(heros[i].weapon.def_born+(heros[i].weapon.level-1)*heros[i].weapon.defGrowth);
                    heros[i].weapon.skillPower=0;
                    for(j=0; j<4; j++){
                        switch(heros[i].weapon.diamond[j]){
                            case 1:
                                heros[i].weapon.att+=heros[i].weapon.red[heros[i].weapon.diamondLevel[j]];
                                break;
                            case 2:
                                heros[i].weapon.def+=heros[i].weapon.blue[heros[i].weapon.diamondLevel[j]];
                                break;
                            case 3:
                                heros[i].weapon.skillPower+=heros[i].weapon.yellow[heros[i].weapon.diamondLevel[j]];
                                break;
                            default:
                        }
                    }
                    if(heros[i].weapon.propertyEnabled){
                        heros[i].weapon.att+=heros[i].weapon.hideProperty[0];
                        heros[i].weapon.def+=heros[i].weapon.hideProperty[1];
                        heros[i].rateRatio+=heros[i].weapon.hideProperty[2];
                    }
                    heros[i].weapon.att=(int)(heros[i].weapon.att*(1+(double)bmEq/100));
                    heros[i].weapon.def=(int)(heros[i].weapon.def*(1+(double)bmEq/100));
                    heros[i].att+=heros[i].weapon.att;
                    heros[i].def+=heros[i].weapon.def;
                    heros[i].powerRatio+=heros[i].weapon.skillPower;
                }
                if(heros[i].shield!=null){
                    heros[i].shield.att=(int)(heros[i].shield.att_born+(heros[i].shield.level-1)*heros[i].shield.attGrowth);
                    heros[i].shield.def=(int)(heros[i].shield.def_born+(heros[i].shield.level-1)*heros[i].shield.defGrowth);
                    heros[i].shield.skillPower=0;
                    for(j=0; j<4; j++){
                        switch(heros[i].shield.diamond[j]){
                            case 1:
                                heros[i].shield.att+=heros[i].shield.red[heros[i].shield.diamondLevel[j]];
                                break;
                            case 2:
                                heros[i].shield.def+=heros[i].shield.blue[heros[i].shield.diamondLevel[j]];
                                break;
                            case 3:
                                heros[i].shield.skillPower+=heros[i].shield.yellow[heros[i].shield.diamondLevel[j]];
                                break;
                            default:
                        }
                    }
                    if(heros[i].shield.propertyEnabled){
                        heros[i].shield.att+=heros[i].shield.hideProperty[0];
                        heros[i].shield.def+=heros[i].shield.hideProperty[1];
                        heros[i].rateRatio+=heros[i].shield.hideProperty[2];
                    }
                    heros[i].shield.att=(int)(heros[i].shield.att*(1+(double)bmEq/100));
                    heros[i].shield.def=(int)(heros[i].shield.def*(1+(double)bmEq/100));
                    heros[i].att+=heros[i].shield.att;
                    heros[i].def+=heros[i].shield.def;
                    heros[i].powerRatio+=heros[i].shield.skillPower;
                }
            }
            else{
                heros[i].weapon.att=heros[i].weaponAttSet;
                heros[i].weapon.def=heros[i].weaponDefSet;
                heros[i].shield.att=heros[i].shieldAttSet;
                heros[i].shield.def=heros[i].shieldDefSet;
                heros[i].powerRatio=heros[i].weaponEffSet+heros[i].shieldEffSet;
                if(heros[i].weapon!=null && heros[i].weapon.propertyEnabled){
                    heros[i].rateRatio+=heros[i].weapon.hideProperty[2];
                }
                if(heros[i].shield!=null && heros[i].shield.propertyEnabled){
                    heros[i].rateRatio+=heros[i].shield.hideProperty[2];
                }
            }
            // mode: 0 计算攻击值, 1 计算防御值
            if(mode%2==0){
                sum+=heros[i].att;
            }
            else if(mode%2==1){
                sum+=heros[i].def;
            }
        }
        return sum;
    }
    
    // 一个伪统计攻击/防御总值的方法，单纯把现有的att/def加和，不重新计算att/def
    // mode: 0 计算攻击总值，1 计算防御总值
    public double sumUp(int mode){
        double attSum=0;
        double defSum=0;
        int i;
        for(i=0; i<number; i++){
            attSum+=heros[i].att;
            defSum+=heros[i].def;
        }
        if(mode==0){
            return attSum;
        }
        else{
            return defSum;
        }
    }
    
    // 根据尾兽类型和等级，给出加成的数字，但是这个数字是加到哪的，不管
    public static double petBenefit(int pet, int level){
        if(pet==0){
            return 0;
        }
        if(pet<6 || pet==10){
            return (level+1)*5;
        }
        if(pet==7){
            return level+1;
        }
        return (level+1)*2;
    }
    
    // 根据祭坛等级，尾兽类型，给出尾兽加成的修正比例
    public static double sacLevelBenefit(int pos, int pet, int sacLevel){
        double r=1;
        switch(sacLevel){
            case 9:
            case 8:
                if(pet==9 || pet==10){
                    r+=0.2;
                }
            case 7:
                if(pet==8){
                    r+=0.2;
                }
            case 6:
            case 5:
                if(pet==7){
                    r+=0.2;
                }
            case 4:
            case 3:
                if(pet==3 || pet==6){
                    r+=0.2;
                }
            case 2:
                if(pet==1 || pet==5){
                    r+=0.2;
                }
            case 1:
                if(pet==2 || pet ==4){
                    r+=0.2;
                }
            default:
        }
        return r;
    }
    
    @Override
    public String toString(){
        if(numberMax==0) {
            return "";
        }
        else {
            return heros[0].toString();
        }
    }
}