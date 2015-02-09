/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqYWMJ extends Equip{
    public EquiqYWMJ(){
        this(1);
    }
    
    public EquiqYWMJ(int l){
        super();
        level=l;
        id=45145;
        eid=id;
        star=5;
        type=1;
        name="月纹面具";
        att_born=293;
        def_born=420;
        attGrowth=32.23;
        defGrowth=46.2;
        slot=4;
        hideProperty[2]=6;
    }
}
