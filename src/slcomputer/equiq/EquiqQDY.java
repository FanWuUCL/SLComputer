/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqQDY extends Equiq{
    public EquiqQDY(){
        this(1);
    }
    
    public EquiqQDY(int l){
        super();
        level=l;
        id=40141;
        star=5;
        type=0;
        name="求道玉";
        att_born=420;
        attGrowth=46.2;
        def_born=293;
        defGrowth=32.23;
        slot=4;
        hideProperty[2]=6;
    }
}
