/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLDY extends Equip{
    public EquiqLDY(){
        this(1);
    }
    
    public EquiqLDY(int l){
        super();
        level=l;
        id=40116;
        star=4;
        type=0;
        name="雷刀-牙";
        att_born=238;
        attGrowth=24.99;
        slot=3;
        hideProperty[0]=248;
    }
}
