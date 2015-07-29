/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.utils;

import slcomputer.equip.Equip;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import slcomputer.heros.Hero;
import slcomputer.main.EnigmaUtil;
import slcomputer.main.SLComputer;
import slcomputer.utils.DesUtils;

/**
 *
 * @author J
 */
public class Utility {
    public static void readTask(){
        String name="hightask";
        File f1=new File(name+".json");
        File f2=new File(name+".txt");
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
                t="第"+s.substring(s.lastIndexOf(":")+1, s.lastIndexOf(","))+" 章";
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
                    name="忍者";
                    if(h!=null){
                        t=t+" "+h.star+"星"+name+" "+h.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                else if(i==1){
                    e=SLComputer.dupAttEqById(j);
                    name="武器";
                    if(e==null){
                        e=SLComputer.dupTfEqById(j);
                        name="宝物";
                    }
                    if(e!=null){
                        t=t+" "+e.star+"星"+name+" "+e.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                else if(i==2){
                    e=SLComputer.dupDefEqById(j);
                    name="防具";
                    if(e!=null){
                        t=t+" "+e.star+"星"+name+" "+e.name+" "+k+"%";
                    }
                    else{
                        t=t+" 你不关心的东西 "+k+"%";
                    }
                }
                else{
                    System.out.println("Unknow type: "+i);
                }
                bw.write(t+"\r\n");
            }
            br.close();
            bw.close();
        } catch (Exception ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String change(String s){
        char cha=(char)(60-EnigmaUtil.checksum(s));
        if(cha>'9') cha=(char)(cha-10);
        return s+cha;
    }
    
    public static void main(String[] args) {
        try {
            String test = "";
            //DesUtils des = new DesUtils(new String(SLComputer.zhengzhi));
            //System.out.println(des.encrypt("15270833387"));
            //System.out.println(des.encrypt(change("EMAIL-"+"3160884371@qq.com")));
            //System.out.println(des.encrypt(change("AND91_"+"545776187")));
            //System.out.println(des.encrypt(change("ANDZSY_"+"yhs1465735776")));
            //System.out.println(des.encrypt(change("IOS91_"+"543239579")));
            //System.out.println(des.encrypt(change("ANDWD_"+"122659963")));
            //System.out.println(des.encrypt(change("AND36_"+"1492050565")));
            //System.out.println(des.encrypt(change("ANDUC_"+"247262464")));
            //System.out.println(des.encrypt(change("IOSTB_"+"3510059")));
            //System.out.println(des.encrypt(change("ANDDK_"+"151730422")));
            //System.out.println(des.encrypt(change("ANDSN_"+"3687192672")));
            //System.out.println(des.encrypt(change("ANDTX_"+"D407B82F884125A1DDA9A167116DDB18")));
            //System.out.println(des.encrypt(change("ANDMI_12179991")));
            //System.out.println(des.decrypt("48eccc3144a6e6e219410fc72b583b77bf99942c097325e411002880726a9c04"));
            //System.out.println(EnigmaUtil.checksum(des.decrypt("48eccc3144a6e6e219410fc72b583b77bf99942c097325e411002880726a9c04")));
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
}
