/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqCDFZ extends Equip{
    public EquiqCDFZ(){
        this(1);
    }
    
    public EquiqCDFZ(int l){
        super();
        level=l;
        id=40113;
        eid=id;
        star=4;
        type=0;
        name="长刀-缝针";
        att_born=251;
        attGrowth=26.36;
        slot=3;
        hideProperty[0]=264;
    }
}
