/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqLDXZ extends Equip{
    public EquiqLDXZ(){
        this(1);
    }
    
    public EquiqLDXZ(int l){
        super();
        level=l;
        id=40133;
        star=5;
        type=0;
        name="六道锡杖";
        att_born=370;
        attGrowth=41.2;
        def_born=269;
        defGrowth=29.52;
        slot=4;
        hideProperty[2]=5;
    }
}
