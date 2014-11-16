/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqLHZP extends Equiq{
    public EquiqLHZP(){
        this(1);
    }
    
    public EquiqLHZP(int l){
        super();
        level=l;
        id=45109;
        star=3;
        type=1;
        name="灵猴之袍";
        def_born=145;
        defGrowth=15.23;
        slot=2;
        hideProperty[1]=180;
    }
}
