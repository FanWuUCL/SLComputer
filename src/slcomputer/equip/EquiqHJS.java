/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHJS extends Equip{
    public EquiqHJS(){
        this(1);
    }
    
    public EquiqHJS(int l){
        super();
        level=l;
        id=40124;
        eid=id;
        star=4;
        type=0;
        name="愰金绳";
        att_born=188;
        attGrowth=19.74;
        slot=3;
        hideProperty[2]=3;
    }
}
