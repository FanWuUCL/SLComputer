/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqBDFM extends Equip{
    public EquiqBDFM(){
        this(1);
    }
    
    public EquiqBDFM(int l){
        super();
        level=l;
        id=40115;
        star=4;
        type=0;
        name="爆刀-飞沫";
        att_born=242;
        attGrowth=25.41;
        slot=3;
        hideProperty[0]=256;
    }
}
