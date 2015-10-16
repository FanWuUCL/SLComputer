/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Equip {
    public int id;
    public int eid;
    public int star;
    // 攻击0, 防御1
    public int type;
    public String name;
    public int att_born;
    public int def_born;
    public int tough_born;
    public double attGrowth;
    public double defGrowth;
    public double toughGrowth;
    public int level;
    public double att;
    public double def;
    public double tough;
    public double att_battle;
    public double def_battle;
    // 忍术效果提升 skillPower%
    public double skillPower;
    // 插槽数目
    public int slot;
    // 插槽奖励
    public double[] hideProperty;
    public boolean propertyEnabled;
    // 宝石：0 未镶嵌，1 红宝石，2 蓝宝石，3 黄宝石，4 紫宝石，5 绿宝石，6 橙宝石，7 多彩宝石
    public int[] diamond;
    public int[] diamondLevel;
    public final int[] red={75, 102, 138, 187, 254, 345, 469, 637, 866, 1177, 1294, 1423, 1565, 1721, 1893, 2082, 2290, 2519, 2770, 3047};
    public final int[] blue={75, 102, 138, 187, 254, 345, 469, 637, 866, 1177, 1294, 1423, 1565, 1721, 1893, 2082, 2290, 2519, 2770, 3047};
    public final double[] yellow={0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10};
    public final double[] rainbow={10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200};
    // 进阶奖励
    public int stepEffect[][];
    public int step;
    
    public Equip(){
        id=0;
        eid=0;
        star=0;
        type=0;
        name="未装备";
        att_born=0;
        def_born=0;
        tough_born=0;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=0;
        slot=0;
        hideProperty=new double[3];
        hideProperty[0]=hideProperty[1]=hideProperty[2]=0;
        propertyEnabled=false;
        diamond=new int[4];
        diamondLevel=new int[4];
        int i, j;
        for(i=0; i<4; i++){
            diamond[i]=diamondLevel[i]=0;
        }
        stepEffect=new int[2][3];
        for(i=0; i<stepEffect.length; i++){
            for(j=0; j<stepEffect[0].length; j++){
                stepEffect[i][j]=0;
            }
        }
        step=0;
    }
    
    // 返回此类的一个新对象，并且复制所有内容
    public Equip copy(){
        Equip e=dup();
        e.level=level;
        e.att=att;
        e.def=def;
        e.tough=tough;
        e.skillPower=skillPower;
        e.propertyEnabled=propertyEnabled;
        e.step=step;
        for(int i=0; i<4; i++){
            e.diamond[i]=diamond[i];
            e.diamondLevel[i]=diamondLevel[i];
        }
        return e;
    }
    
    // 返回此类的一个新对象
    public Equip dup(){
        Equip e=null;
        try {
            e=this.getClass().newInstance();
            e.star=star;
            e.type=type;
            e.name=name;
            e.att_born=att_born;
            e.def_born=def_born;
            e.tough_born=tough_born;
            e.attGrowth=attGrowth;
            e.defGrowth=defGrowth;
            e.toughGrowth=toughGrowth;
            e.slot=slot;
            e.hideProperty=hideProperty;
            e.stepEffect=stepEffect;
        } catch (Exception ex) {
            Logger.getLogger(Equip.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    @Override
    public String toString(){
        String s="<html><font color=";
        switch(star){
            case 6:
                s+="#FF0000>";
                break;
            case 5:
                s+="#FF8000>";
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
}
