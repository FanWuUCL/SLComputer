/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSDPMD extends Equip{
    public EquiqSDPMD(){
        this(1);
    }
    
    public EquiqSDPMD(int l){
        super();
        level=l;
        id=40117;
        eid=id;
        star=4;
        type=0;
        name="双刀-平目碟";
        att_born=233;
        attGrowth=24.47;
        slot=3;
        hideProperty[2]=3;
    }
}
