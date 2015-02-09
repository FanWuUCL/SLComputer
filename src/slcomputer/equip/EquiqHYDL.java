/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHYDL extends Equip{
    public EquiqHYDL(){
        this(1);
    }
    
    public EquiqHYDL(int l){
        super();
        level=l;
        id=45136;
        eid=id;
        star=5;
        type=1;
        name="火影斗笠";
        att_born=276;
        def_born=390;
        attGrowth=30.53;
        defGrowth=43.65;
        slot=4;
        hideProperty[2]=5;
    }
}
