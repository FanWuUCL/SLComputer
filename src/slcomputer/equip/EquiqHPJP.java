/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHPJP extends Equip{
    public EquiqHPJP(){
        this(1);
    }
    
    public EquiqHPJP(int l){
        super();
        level=l;
        id=40137;
        eid=id;
        star=5;
        type=0;
        name="琥珀净瓶";
        att_born=410;
        def_born=283;
        attGrowth=46.1;
        defGrowth=31.54;
        slot=4;
        hideProperty[0]=432;
    }
}
