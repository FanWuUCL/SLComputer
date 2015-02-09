/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqHJHS extends Equip{
    public EquiqHJHS(){
        this(1);
    }
    
    public EquiqHJHS(int l){
        super();
        level=l;
        id=45999;
        eid=id;
        star=3;
        type=1;
        name="黄金护手";
        def_born=1;
        defGrowth=1;
    }
}
