/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSMMJ extends Equip{
    public EquiqSMMJ(){
        this(1);
    }
    
    public EquiqSMMJ(int l){
        super();
        level=l;
        id=45133;
        star=5;
        type=1;
        name="神秘面具";
        att_born=269;
        def_born=370;
        attGrowth=29.52;
        defGrowth=41.2;
        slot=4;
        hideProperty[2]=5;
    }
}
