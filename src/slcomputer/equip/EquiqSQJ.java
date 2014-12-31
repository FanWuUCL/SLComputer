/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSQJ extends Equip{
    public EquiqSQJ(){
        this(1);
    }
    
    public EquiqSQJ(int l){
        super();
        level=l;
        id=40127;
        star=5;
        type=0;
        name="十拳剑";
        att_born=263;
        attGrowth=27.62;
        slot=4;
        hideProperty[0]=340;
    }
}
