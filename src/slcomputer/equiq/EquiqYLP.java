/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqYLP extends Equiq{
    public EquiqYLP(){
        this(1);
    }
    
    public EquiqYLP(int l){
        super();
        level=l;
        id=45111;
        star=3;
        type=1;
        name="医疗袍";
        def_born=140;
        defGrowth=14.7;
        slot=2;
        hideProperty[1]=165;
    }
}
