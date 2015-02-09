/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqTZMJGG extends Equip{
    public EquiqTZMJGG(){
        this(1);
    }
    
    public EquiqTZMJGG(int l){
        super();
        level=l;
        id=40140;
        eid=id;
        star=5;
        type=0;
        name="天之麻迦古弓";
        att_born=380;
        attGrowth=42.5;
        def_born=273;
        defGrowth=32.55;
        slot=4;
        hideProperty[0]=416;
    }
}
