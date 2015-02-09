/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqZZP extends Equip{
    public EquiqZZP(){
        this(1);
    }
    
    public EquiqZZP(int l){
        super();
        level=l;
        id=45119;
        eid=id;
        star=4;
        type=1;
        name="者之袍";
        def_born=196;
        defGrowth=20.58;
        slot=3;
        hideProperty[1]=200;
    }
}
