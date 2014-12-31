/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqGYZP extends Equip{
    public EquiqGYZP(){
        this(1);
    }
    
    public EquiqGYZP(int l){
        super();
        level=l;
        id=45140;
        star=5;
        type=1;
        name="勾玉之袍";
        att_born=293;
        attGrowth=32.23;
        def_born=420;
        defGrowth=46.2;
        slot=4;
        hideProperty[2]=6;
    }
}
