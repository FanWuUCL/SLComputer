/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqDDJJ extends Equip{
    public EquiqDDJJ(){
        this(1);
    }
    
    public EquiqDDJJ(int l){
        super();
        level=l;
        id=40112;
        star=4;
        type=0;
        name="大刀-鲛肌";
        att_born=256;
        attGrowth=26.88;
        slot=3;
        hideProperty[0]=272;
    }
}
