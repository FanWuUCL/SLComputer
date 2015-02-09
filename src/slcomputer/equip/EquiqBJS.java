/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqBJS extends Equip{
    public EquiqBJS(){
        this(1);
    }
    
    public EquiqBJS(int l){
        super();
        level=l;
        id=40126;
        eid=id;
        star=5;
        type=0;
        name="芭蕉扇";
        att_born=275;
        attGrowth=28.88;
        slot=4;
        hideProperty[2]=4;
    }
}
