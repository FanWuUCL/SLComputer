/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLYDL extends Equip{
    public EquiqLYDL(){
        this(1);
    }
    
    public EquiqLYDL(int l){
        super();
        level=l;
        id=45144;
        eid=id;
        star=5;
        type=1;
        name="雷影斗笠";
        att_born=0;
        attGrowth=0;
        def_born=326;
        defGrowth=34.1;
        slot=4;
        hideProperty[2]=4;
    }
}
