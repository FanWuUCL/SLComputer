/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqBCJ extends Equiq{
    public EquiqBCJ(){
        this(1);
    }
    
    public EquiqBCJ(int l){
        super();
        level=l;
        id=45131;
        star=5;
        type=1;
        name="八咫镜";
        att_born=255;
        def_born=330;
        attGrowth=25.5;
        defGrowth=36.3;
        slot=4;
        hideProperty[2]=5;
    }
}
