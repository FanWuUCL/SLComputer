/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqXRZP extends Equip{
    public EquiqXRZP(){
        this(1);
    }
    
    public EquiqXRZP(int l){
        super();
        level=l;
        id=45124;
        eid=id;
        star=5;
        type=1;
        name="仙人之袍";
        def_born=278;
        defGrowth=29.19;
        slot=4;
        hideProperty[2]=4;
    }
}
