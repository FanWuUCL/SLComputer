/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqZZHS extends Equip{
    public EquiqZZHS(){
        this(1);
    }
    
    public EquiqZZHS(int l){
        super();
        level=l;
        id=45117;
        eid=id;
        star=4;
        type=1;
        name="者之护手";
        def_born=211;
        defGrowth=22.16;
        slot=3;
        hideProperty[2]=3;
    }
}
