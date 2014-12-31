/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpYDWS extends Equip{
    public EqpYDWS(){
        super();
        level=1;
        id=42128;
        star=5;
        type=33;
        name="一代万蛇";
        att_born=210;
        def_born=210;
        tough_born=300;
        attGrowth=23.1;
        defGrowth=23.1;
        toughGrowth=15;
        slot=3;
        hideProperty[2]=3;
    }
    
    public EqpYDWS(int l){
        this();
        level=l;
    }
}
