/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqAYZF extends Equiq{
    public EquiqAYZF(){
        this(1);
    }
    
    public EquiqAYZF(int l){
        super();
        level=l;
        id=45121;
        star=5;
        type=1;
        name="暗影之服";
        def_born=323;
        defGrowth=33.92;
        slot=4;
        hideProperty[2]=4;
    }
}
