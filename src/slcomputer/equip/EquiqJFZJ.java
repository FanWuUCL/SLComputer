/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqJFZJ extends Equip{
    public EquiqJFZJ(){
        this(1);
    }
    
    public EquiqJFZJ(int l){
        super();
        level=l;
        id=45113;
        eid=id;
        star=3;
        type=1;
        name="疾风足具";
        def_born=115;
        defGrowth=12.08;
        slot=2;
        hideProperty[1]=120;
    }
}
