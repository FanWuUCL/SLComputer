/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqBZZF extends Equip{
    public EquiqBZZF(){
        this(1);
    }
    
    public EquiqBZZF(int l){
        super();
        level=l;
        id=45135;
        eid=id;
        star=5;
        type=1;
        name="孢子之服";
        def_born=338;
        defGrowth=35.49;
        slot=4;
        hideProperty[2]=4;
    }
}
