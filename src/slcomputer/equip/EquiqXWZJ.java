/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqXWZJ extends Equip{
    public EquiqXWZJ(){
        this(1);
    }
    
    public EquiqXWZJ(int l){
        super();
        level=l;
        id=45123;
        eid=id;
        star=5;
        type=1;
        name="玄武足具";
        def_born=293;
        defGrowth=30.77;
        slot=4;
        hideProperty[1]=374;
    }
}
