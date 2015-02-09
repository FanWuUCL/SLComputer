/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqKQSZJ extends Equip{
    public EquiqKQSZJ(){
        this(1);
    }
    
    public EquiqKQSZJ(int l){
        super();
        level=l;
        id=40121;
        eid=id;
        star=4;
        type=0;
        name="孔雀双子剑";
        att_born=203;
        attGrowth=21.32;
        slot=3;
        hideProperty[0]=224;
    }
}
