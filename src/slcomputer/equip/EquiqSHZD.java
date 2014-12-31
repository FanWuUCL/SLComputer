/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSHZD extends Equip{
    public EquiqSHZD(){
        this(1);
    }
    
    public EquiqSHZD(int l){
        super();
        level=l;
        id=45134;
        star=5;
        type=1;
        name="守鹤之盾";
        def_born=353;
        defGrowth=37.07;
        slot=4;
        hideProperty[1]=424;
    }
}
