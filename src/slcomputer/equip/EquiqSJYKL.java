/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSJYKL extends Equip{
    public EquiqSJYKL(){
        this(1);
    }
    
    public EquiqSJYKL(int l){
        super();
        level=l;
        id=45139;
        star=5;
        type=1;
        name="山椒鱼傀儡";
        att_born=0;
        attGrowth=0;
        def_born=326;
        defGrowth=34.1;
        slot=4;
        hideProperty[1]=413;
    }
}
