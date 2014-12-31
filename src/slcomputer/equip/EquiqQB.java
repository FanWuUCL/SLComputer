/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqQB extends Equip{
    public EquiqQB(){
        this(1);
    }
    
    public EquiqQB(int l){
        super();
        level=l;
        id=40128;
        star=3;
        type=0;
        name="千本";
        att_born=140;
        attGrowth=14.7;
        slot=2;
        hideProperty[0]=180;
    }
}
