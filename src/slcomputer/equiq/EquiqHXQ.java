/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqHXQ extends Equiq{
    public EquiqHXQ(){
        this(1);
    }
    
    public EquiqHXQ(int l){
        super();
        level=l;
        id=45110;
        star=4;
        type=1;
        name="呼吸器";
        def_born=218;
        defGrowth=22.89;
        slot=3;
        hideProperty[2]=3;
    }
}
