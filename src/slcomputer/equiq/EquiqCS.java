/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqCS extends Equiq{
    public EquiqCS(){
        this(1);
    }
    
    public EquiqCS(int l){
        super();
        level=l;
        id=40104;
        star=3;
        type=0;
        name="吹矢";
        att_born=130;
        attGrowth=13.65;
        slot=2;
        hideProperty[2]=2;
    }
}