/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqSYDL extends Equiq{
    public EquiqSYDL(){
        this(1);
    }
    
    public EquiqSYDL(int l){
        super();
        level=l;
        id=45141;
        star=5;
        type=1;
        name="水影斗笠";
        att_born=0;
        attGrowth=0;
        def_born=326;
        defGrowth=34.1;
        slot=4;
        hideProperty[2]=4;
    }
}
