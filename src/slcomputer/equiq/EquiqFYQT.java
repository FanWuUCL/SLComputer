/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqFYQT extends Equiq{
    public EquiqFYQT(){
        this(1);
    }
    
    public EquiqFYQT(int l){
        super();
        level=l;
        id=40105;
        star=3;
        type=0;
        name="封印拳套";
        att_born=125;
        attGrowth=13.13;
        slot=2;
        hideProperty[0]=150;
    }
}
