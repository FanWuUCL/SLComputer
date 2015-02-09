/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqDDDG extends Equip{
    public EquiqDDDG(){
        this(1);
    }
    
    public EquiqDDDG(int l){
        super();
        level=l;
        id=40114;
        eid=id;
        star=4;
        type=0;
        name="钝刀-兜割";
        att_born=247;
        attGrowth=25.94;
        slot=3;
        hideProperty[2]=3;
    }
}
