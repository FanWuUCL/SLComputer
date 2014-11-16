/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqRD extends Equiq{
    public EquiqRD(){
        this(1);
    }
    
    public EquiqRD(int l){
        super();
        level=l;
        id=40129;
        star=3;
        type=0;
        name="忍笛";
        att_born=105;
        attGrowth=11.03;
        slot=2;
        hideProperty[0]=105;
    }
}
