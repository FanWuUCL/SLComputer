/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLYFJJ extends Equip{
    public EquiqLYFJJ(){
        this(1);
    }
    
    public EquiqLYFJJ(int l){
        super();
        level=l;
        id=40122;
        star=4;
        type=0;
        name="龙眼伏击剑";
        att_born=196;
        attGrowth=20.58;
        slot=3;
        hideProperty[0]=216;
    }
}
