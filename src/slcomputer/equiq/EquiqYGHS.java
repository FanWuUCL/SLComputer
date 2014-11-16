/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqYGHS extends Equiq{
    public EquiqYGHS(){
        this(1);
    }
    
    public EquiqYGHS(int l){
        super();
        level=l;
        id=45107;
        star=3;
        type=1;
        name="玉钢护手";
        def_born=120;
        defGrowth=12.6;
        slot=2;
        hideProperty[2]=2;
    }
}
