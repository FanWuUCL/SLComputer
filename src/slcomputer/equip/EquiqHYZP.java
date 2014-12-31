/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHYZP extends Equip{
    public EquiqHYZP(){
        this(1);
    }
    
    public EquiqHYZP(int l){
        super();
        level=l;
        id=45137;
        star=5;
        type=1;
        name="火影之袍";
        att_born=283;
        def_born=410;
        attGrowth=31.54;
        defGrowth=46.1;
        slot=4;
        hideProperty[1]=446;
    }
}
