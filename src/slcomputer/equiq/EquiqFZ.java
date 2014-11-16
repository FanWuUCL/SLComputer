/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqFZ extends Equiq{
    public EquiqFZ(){
        this(1);
    }
    
    public EquiqFZ(int l){
        super();
        level=l;
        id=40109;
        star=3;
        type=0;
        name="飞针";
        att_born=110;
        attGrowth=11.15;
        slot=2;
        hideProperty[0]=120;
    }
}
