/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqJZ extends Equip{
    public EquiqJZ(){
        this(1);
    }
    
    public EquiqJZ(int l){
        super();
        level=l;
        id=40108;
        eid=id;
        star=3;
        type=0;
        name="卷轴";
        att_born=115;
        attGrowth=12.08;
        slot=2;
        hideProperty[2]=2;
    }
}
