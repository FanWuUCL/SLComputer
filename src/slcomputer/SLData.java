/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

/**
 *
 * @author J
 */
public class SLData {
    public int maxLevel;
    public double[][] basePlus;
    public double[][] bodySkill;
    public double[] skillPower;
    public double[] skillRate;
    public Team[] teamsHard;
    public Team[] teamsNorm;
    public Team[] teamsEasy;
    
    public SLData(){
        maxLevel=0;
        basePlus=new double[160][3];
        bodySkill=new double[160][3];
        skillPower=new double[160];
        skillRate=new double[160];
    }
}
