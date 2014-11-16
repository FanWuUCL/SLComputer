/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqZSDD extends Equiq{
    public EquiqZSDD(){
        this(1);
    }
    
    public EquiqZSDD(int l){
        super();
        level=l;
        id=40111;
        star=4;
        type=0;
        name="断刀-斩首大刀";
        att_born=260;
        attGrowth=27.3;
        slot=3;
        hideProperty[2]=3;
    }
}
