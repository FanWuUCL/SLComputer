/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHYZS extends Equip{
    public EquiqHYZS(){
        this(1);
    }
    
    public EquiqHYZS(int l){
        super();
        level=l;
        id=40130;
        eid=id;
        star=5;
        type=0;
        name="火焰之扇";
        att_born=303;
        attGrowth=31.82;
        slot=4;
        hideProperty[0]=408;
    }
}
