/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLSZJ extends Equip{
    public EquiqLSZJ(){
        this(1);
    }
    
    public EquiqLSZJ(int l){
        super();
        level=l;
        id=40119;
        star=4;
        type=0;
        name="雷神之剑";
        att_born=218;
        attGrowth=22.89;
        slot=3;
        hideProperty[0]=232;
    }
}
