/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqYGZJ extends Equip{
    public EquiqYGZJ(){
        this(1);
    }
    
    public EquiqYGZJ(int l){
        super();
        level=l;
        id=45106;
        star=3;
        type=1;
        name="玉钢之甲";
        def_born=130;
        defGrowth=13.65;
        slot=2;
        hideProperty[1]=150;
    }
}
