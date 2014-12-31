/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpSZXR extends Equip{
    public EqpSZXR(){
        super();
        level=1;
        id=42141;
        star=5;
        type=33;
        name="深作仙人";
        att_born=230;
        def_born=230;
        tough_born=340;
        attGrowth=25.3;
        defGrowth=25.3;
        toughGrowth=17;
        slot=4;
        hideProperty[2]=3;
    }
    
    public EqpSZXR(int l){
        this();
        level=l;
    }
}
