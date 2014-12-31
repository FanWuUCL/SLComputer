/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpWG extends Equip{
    public EqpWG(){
        super();
        level=1;
        id=42138;
        star=4;
        type=33;
        name="蜈蚣";
        tough_born=224;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=11.2;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpWG(int l){
        this();
        level=l;
    }
}
