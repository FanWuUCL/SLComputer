/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHHL extends Equip{
    public EquiqHHL(){
        this(1);
    }
    
    public EquiqHHL(int l){
        super();
        level=l;
        id=40125;
        star=5;
        type=0;
        name="红葫芦";
        att_born=294;
        attGrowth=30.87;
        slot=4;
        hideProperty[0]=374;
    }
}
