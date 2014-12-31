/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqQXJ extends Equip{
    public EquiqQXJ(){
        this(1);
    }
    
    public EquiqQXJ(int l){
        super();
        level=l;
        id=40123;
        star=5;
        type=0;
        name="七星剑";
        att_born=326;
        attGrowth=34.23;
        slot=4;
        hideProperty[2]=4;
    }
}
