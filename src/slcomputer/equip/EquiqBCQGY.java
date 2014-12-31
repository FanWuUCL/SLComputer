/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqBCQGY extends Equip{
    public EquiqBCQGY(){
        this(1);
    }
    
    public EquiqBCQGY(int l){
        super();
        level=l;
        id=45132;
        star=5;
        type=1;
        name="八咫琼勾玉";
        att_born=262;
        def_born=350;
        attGrowth=27.51;
        defGrowth=38.75;
        slot=4;
        hideProperty[2]=5;
    }
}
