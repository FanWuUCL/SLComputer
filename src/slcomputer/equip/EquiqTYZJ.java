/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqTYZJ extends Equip{
    public EquiqTYZJ(){
        this(1);
    }
    
    public EquiqTYZJ(int l){
        super();
        level=l;
        id=45108;
        star=3;
        type=1;
        name="踏云足具";
        def_born=105;
        defGrowth=11.03;
        slot=2;
        hideProperty[2]=2;
    }
}
