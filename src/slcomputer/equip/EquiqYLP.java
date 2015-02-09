/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqYLP extends Equip{
    public EquiqYLP(){
        this(1);
    }
    
    public EquiqYLP(int l){
        super();
        level=l;
        id=45111;
        eid=id;
        star=3;
        type=1;
        name="医疗袍";
        def_born=140;
        defGrowth=14.7;
        slot=2;
        hideProperty[1]=165;
    }
}
