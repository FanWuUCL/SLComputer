/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpZMXR extends Equip{
    public EqpZMXR(){
        super();
        level=1;
        id=42142;
        star=5;
        type=33;
        name="志麻仙人";
        att_born=235;
        def_born=235;
        tough_born=350;
        attGrowth=25.85;
        defGrowth=25.85;
        toughGrowth=17.5;
        slot=4;
        hideProperty[2]=3;
    }
    
    public EqpZMXR(int l){
        this();
        level=l;
    }
}
