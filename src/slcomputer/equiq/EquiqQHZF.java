/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqQHZF extends Equiq{
    public EquiqQHZF(){
        this(1);
    }
    
    public EquiqQHZF(int l){
        super();
        level=l;
        id=45128;
        star=4;
        type=1;
        name="漆黑之服";
        def_born=248;
        defGrowth=26.04;
        slot=3;
        hideProperty[1]=260;
    }
}
