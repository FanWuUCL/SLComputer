/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqKL extends Equiq{
    public EquiqKL(){
        this(1);
    }
    
    public EquiqKL(int l){
        super();
        level=l;
        id=45120;
        star=4;
        type=1;
        name="傀儡";
        def_born=188;
        defGrowth=19.74;
        slot=3;
        hideProperty[2]=3;
    }
}
