/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqABMJ extends Equip{
    public EquiqABMJ(){
        this(1);
    }
    
    public EquiqABMJ(int l){
        super();
        level=l;
        id=45115;
        eid=id;
        star=4;
        type=1;
        name="暗部面具";
        def_born=226;
        defGrowth=23.73;
        slot=3;
        hideProperty[1]=236;
    }
}
