/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.computer;

/**
 *
 * @author J
 */
public class SLData {
    static public int MAXLEVEL=180;
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
        basePlus=new double[MAXLEVEL][3];
        bodySkill=new double[MAXLEVEL][3];
        skillPower=new double[MAXLEVEL];
        skillRate=new double[MAXLEVEL];
    }
}
