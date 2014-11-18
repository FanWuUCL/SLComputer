/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Equiq {
    public int id;
    public int star;
    // 攻击0, 防御1
    public int type;
    public String name;
    public int att_born;
    public int def_born;
    public double attGrowth;
    public double defGrowth;
    public int level;
    public double att;
    public double def;
    public double att_battle;
    public double def_battle;
    // 忍术效果提升 skillPower%
    public double skillPower;
    // 插槽数目
    public int slot;
    // 插槽奖励
    public double[] hideProperty;
    public boolean propertyEnabled;
    // 宝石：0 未镶嵌，1 红宝石，2 蓝宝石，3 黄宝石
    public int[] diamond;
    public int[] diamondLevel;
    public final int[] red={30, 45, 68, 102, 153, 230, 345, 518, 777, 1166};
    public final int[] blue={30, 45, 68, 102, 153, 230, 345, 518, 777, 1166};
    public final double[] yellow={0.25, 0.5, 0.75, 1, 1.5, 2, 2.5, 3, 4, 5};
    
    public Equiq(){
        id=0;
        star=0;
        type=0;
        name="未装备";
        att_born=0;
        def_born=0;
        attGrowth=0;
        defGrowth=0;
        slot=0;
        hideProperty=new double[3];
        hideProperty[0]=hideProperty[1]=hideProperty[2]=0;
        propertyEnabled=false;
        diamond=new int[4];
        diamondLevel=new int[4];
        int i;
        for(i=0; i<4; i++){
            diamond[i]=diamondLevel[i]=0;
        }
    }
    
    // 返回此类的一个新对象，并且复制所有内容
    public Equiq copy(){
        Equiq e=dup();
        e.level=level;
        e.att=att;
        e.def=def;
        e.skillPower=skillPower;
        e.propertyEnabled=propertyEnabled;
        for(int i=0; i<4; i++){
            e.diamond[i]=diamond[i];
            e.diamondLevel[i]=diamondLevel[i];
        }
        return e;
    }
    
    // 返回此类的一个新对象
    public Equiq dup(){
        Equiq e=null;
        try {
            e=this.getClass().newInstance();
        } catch (Exception ex) {
            Logger.getLogger(Equiq.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    @Override
    public String toString(){
        String s="<html><font color=";
        switch(star){
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