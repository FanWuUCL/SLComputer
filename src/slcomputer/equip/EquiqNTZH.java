/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqNTZH extends Equip{
    public EquiqNTZH(){
        this(1);
    }
    
    public EquiqNTZH(int l){
        super();
        level=l;
        id=45138;
        eid=id;
        star=5;
        type=1;
        name="黏土の鹤";
        att_born=0;
        attGrowth=0;
        def_born=313;
        defGrowth=32.88;
        slot=4;
        hideProperty[1]=408;
    }
}
