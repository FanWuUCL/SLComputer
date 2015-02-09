/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLLZP extends Equip{
    public EquiqLLZP(){
        this(1);
    }
    
    public EquiqLLZP(int l){
        super();
        level=l;
        id=45114;
        eid=id;
        star=3;
        type=1;
        name="龙鳞之袍";
        def_born=150;
        defGrowth=15.75;
        slot=2;
        hideProperty[2]=2;
    }
}
