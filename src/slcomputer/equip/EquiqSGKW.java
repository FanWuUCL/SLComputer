/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSGKW extends Equip{
    public EquiqSGKW(){
        this(1);
    }
    
    public EquiqSGKW(int l){
        super();
        level=l;
        id=40136;
        eid=id;
        star=5;
        type=0;
        name="闪光苦无";
        att_born=390;
        def_born=276;
        attGrowth=43.65;
        defGrowth=30.53;
        slot=4;
        hideProperty[2]=6;
    }
}
