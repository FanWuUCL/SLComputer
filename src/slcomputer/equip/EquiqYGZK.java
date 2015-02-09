/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqYGZK extends Equip{
    public EquiqYGZK(){
        this(1);
    }
    
    public EquiqYGZK(int l){
        super();
        level=l;
        id=45105;
        eid=id;
        star=3;
        type=1;
        name="玉钢之盔";
        def_born=125;
        defGrowth=13.13;
        slot=2;
        hideProperty[1]=135;
    }
}
