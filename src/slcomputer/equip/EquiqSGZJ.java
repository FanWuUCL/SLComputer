/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSGZJ extends Equip{
    public EquiqSGZJ(){
        this(1);
    }
    
    public EquiqSGZJ(int l){
        super();
        level=l;
        id=40139;
        star=5;
        type=0;
        name="尸骨之剑";
        att_born=366;
        attGrowth=40.5;
        slot=4;
        hideProperty[0]=416;
    }
}
