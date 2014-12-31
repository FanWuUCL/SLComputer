/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import slcomputer.equip.Equip;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Utility {
    public static void readTask(){
        File f1=new File("task.json");
        File f2=new File("task.txt");
        int i, j;
        double k;
        Hero h;
        Equip e;
        try {
            BufferedReader br=new BufferedReader(new FileReader(f1));
            BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
            String s=br.readLine();
            String t;
            while((s=br.readLine())!=null){
                if(s.indexOf("chapterId")<0){
                    continue;
                }
                t="第"+s.substring(s.lastIndexOf(":"), s.lastIndexOf(","))+" 章";
                s=br.readLine();
                while(s.indexOf("phaseName")<0){
                    s=br.readLine();
                }
                t+=s.substring(s.lastIndexOf(":"), s.lastIndexOf(","));
                s=br.readLine();
                while(s.indexOf("boss")<0){
                    s=br.readLine();
                }
                s=br.readLine();
                for(i=0; i<5; i++){
                    while(s.charAt(6)!='['){
                        s=br.readLine();
                    }
                    s=br.readLine();
                }
                s=s.trim();
                i=Integer.parseInt(s.substring(0, s.lastIndexOf(",")));
                s=br.readLine();
                s=s.trim();
                j=Integer.parseInt(s.substring(0, s.lastIndexOf(",")));
                s=br.readLine();
                s=s.trim();
                k=Double.parseDouble(s);
                if(i==0){
                    h=SLComputer.dupHeroById(j);
                    if(h!=null){
                        t=t+" "+h.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                else if(i==1){
                    e=SLComputer.dupAttEqById(j);
                    if(e!=null){
                        t=t+" "+e.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                else{
                    e=SLComputer.dupDefEqById(j);
                    if(e!=null){
                        t=t+" "+e.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                bw.write(t+"\r\n");
            }
            br.close();
            bw.close();
        } catch (Exception ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
