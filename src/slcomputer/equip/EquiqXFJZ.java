/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqXFJZ extends Equip{
    public EquiqXFJZ(){
        this(1);
    }
    
    public EquiqXFJZ(int l){
        super();
        level=l;
        id=40142;
        eid=id;
        star=5;
        type=0;
        name="仙法卷轴";
        att_born=410;
        def_born=283;
        attGrowth=46.1;
        defGrowth=31.54;
        slot=4;
        hideProperty[2]=6;
    }
}
