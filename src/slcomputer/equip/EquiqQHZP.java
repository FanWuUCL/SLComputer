/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqQHZP extends Equip{
    public EquiqQHZP(){
        this(1);
    }
    
    public EquiqQHZP(int l){
        super();
        level=l;
        id=45130;
        eid=id;
        star=4;
        type=1;
        name="漆黑之袍";
        def_born=233;
        defGrowth=24.47;
        slot=3;
        hideProperty[2]=3;
    }
}
