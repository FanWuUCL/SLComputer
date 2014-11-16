/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqQBF extends Equiq{
    public EquiqQBF(){
        this(1);
    }
    
    public EquiqQBF(int l){
        super();
        level=l;
        id=40107;
        star=3;
        type=0;
        name="起爆符";
        att_born=135;
        attGrowth=14.18;
        slot=2;
        hideProperty[0]=165;
    }
}
