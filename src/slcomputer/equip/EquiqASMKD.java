/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqASMKD extends Equip{
    public EquiqASMKD(){
        this(1);
    }
    
    public EquiqASMKD(int l){
        super();
        level=l;
        id=40135;
        eid=id;
        star=5;
        type=0;
        name="阿斯玛狂刀";
        att_born=338;
        attGrowth=38.2;
        slot=4;
        hideProperty[2]=4;
    }
}
