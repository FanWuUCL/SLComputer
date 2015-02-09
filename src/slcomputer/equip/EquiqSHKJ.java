/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSHKJ extends Equip{
    public EquiqSHKJ(){
        this(1);
    }
    
    public EquiqSHKJ(int l){
        super();
        level=l;
        id=45126;
        eid=id;
        star=4;
        type=1;
        name="水虎铠甲";
        def_born=263;
        defGrowth=27.62;
        slot=3;
        hideProperty[1]=272;
    }
}
