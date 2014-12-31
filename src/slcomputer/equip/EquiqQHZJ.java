/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqQHZJ extends Equip{
    public EquiqQHZJ(){
        this(1);
    }
    
    public EquiqQHZJ(int l){
        super();
        level=l;
        id=45129;
        star=4;
        type=1;
        name="漆黑足具";
        def_born=241;
        defGrowth=25.31;
        slot=3;
        hideProperty[1]=248;
    }
}
