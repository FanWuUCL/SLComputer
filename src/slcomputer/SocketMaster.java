/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import slcomputer.invokelater.UpdateSelection;
import slcomputer.dialogs.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import slcomputer.invokelater.Emphasize;

/**
 *
 * @author J
 */
public class SocketMaster implements Runnable{
    public static final int c_login=0x0002756c;
    public static final int c_loginp=0x00027561;
    public static final int c_login2=0x0002616c;
    public static final int c_news=0x00026d61;
    public static final int c_addFateEnemy=0x00026663;
    public static final int c_revenge=0x00026362; // id+模式（3搜索抢碎片，6报仇，7宿敌抢碎片）+被抢者id+（可能）碎片id+（可能）碎片数量+(uint)-1
    public static final int c_hire=0x00026867; // id+0/1/2/3+0, 返回包格式：byte[0..42]+(int)是否激活下一级+byte8+(int)heroId+(int)属性+"end",总长66 bytes
    public static final int c_recieveLetter=0x00026d69; // id+int
    public static final int c_recievePetPieces=0x00026773; // id
    public static final int c_harvest=0x00026267; // id+3/4/5/6+0/1
    public static final int c_messege=0x0002666d; // id+recieverID+msgLength+msg
    public static final int c_guess=0x00026165; // id+0+770101+0/1
    public static final int c_monster_check=0x0002616b; // id, returned value: [35..38]
    public static final int c_monster_strengthen=0x00026177;  // id+0, use festival_extra
    public static final int c_reward=0x00026763; // id+8（兑奖码长度）+兑奖码
    public static final int c_festival_check=0x00026161; // id, my score=[51..54] or [55..58], 第一名名字长度=[83..86], highest score=[87+名字长度..90+名字长度], 传说忍者id=[67..70]
    public static final int c_train=0x00026874; // id+heroIndex+0/1/2/3(普训攻击/普训防御/特训攻击/特训防御)
    public static final int c_use=0x00026965; // id+itemid+number, 第一个忍蛋忍者=[83..86]
    public static final int c_festival=0x00026162; // id+0/1, 0:350钻, 1:每10次免费一次
    public static final int c_gem_trade=0x00026f62; // id+gemId+number, 用use_extra
    public static final int c_story_enquiry=0x00027474; // id+chapterNo(3表示第三章)
    public static final int c_story_play=0x00027465; // id+section，用festival_extra
    public static final int c_story_boss=0x0002746c; // id+0+section, 用use_extra
    public static final int c_mail_check=0x00026d6c; // id
    public static final int c_mail_read=0x00026d73; // id+0/1
    public static final int c_regular_query=0x00026862; // id, 每隔一段时间自动询问一次
    public static final int c_union_assignment=0x00026a65; // id+章数(01:第一章)+节数(00:第一节), 用use_extra
    public static final int c_union_renew_assignment=0x00026a72; // id, 用monster_check_extra
    public static final int c_union_query_assignment=0x00026a6c; // id, 用monster_check_extra
    public static final int c_guaguaka=0x00026567; // id, 用monster_check_extra
    public static final int c_replace=0x00026870; // id+heroPos+place(1代表第一个忍者位置)+0, 用guess_extra
    public static final int c_sacrifice_heros=0x00026875; // id+heroPos+number+(heroPos)*number
    public static final int c_union_buy_assignment=0x00026c78;    //id+0/1/2/3, 用festival_extra
    public static final int c_union_census=0x00026c71;    // id, 用monster_check_extra
    public static final int c_bb_q0=0x00026370;   // id, 用monster_check_extra
    public static final int c_bb_q1=0x00026363;   // id+0攻击/1防御试炼, 用festival_extra
    public static final int c_bb_q2=0x00026366;   // id+0/1/2/3/4, 用festival_extra
    public static final int c_bb_battle=0x00026378; // id+0困难/1普通/2容易，用
    public static int startSignal;
    public static final int commandCooldown=6000;
    public static Socket clientStatic;
    public static BufferedOutputStream osStatic;
    public static BufferedInputStream isStatic;
    public static String globalIP;
    public static int globalPort;
    public static int globalCer;
    public static int globalID;
    public static String globalName;
    public static int globalIndex;
    public static boolean globalReady;
    public static int cmdGlobal;
    public static int starUsed, starTotal;
    public static int mode;
    // usr, psd, fwq, saveAcc, 平台
    public static Object[] arguments=new Object[5];
    public static String usrSave;
    public static boolean onWork=false;

    public static byte[] transform(int length, int version, int certification, int command, int extralength, byte[] extra){
        byte[] data=new byte[34+extralength];
        int i;
        for(i=0; i<data.length; i++){
            data[i]=0;
        }
        data[0]='S'; data[1]='t'; data[2]='a'; data[3]='r'; data[4]='t';
        data[5]=(byte)((length & 0xff000000)>>24);
        data[6]=(byte)((length & 0xff0000)>>16);
        data[7]=(byte)((length & 0xff00)>>8);
        data[8]=(byte)(length & 0xff);
        // app 0x 00 1e 98 08
        data[9]=(byte)((version & 0xff000000)>>24);
        data[10]=(byte)((version & 0xff0000)>>16);
        data[11]=(byte)((version & 0xff00)>>8);
        data[12]=(byte)(version & 0xff);
        /* 混服 0x 00 1e 9b f0 */
        //data[12]=(byte)0x69;
        data[13]=(byte)((certification>>24) & 0xff);
        data[14]=(byte)((certification>>16) & 0xff);
        data[15]=(byte)((certification>>8) & 0xff);
        data[16]=(byte)(certification & 0xff);
        data[23]=(byte)((command>>24) & 0xff);
        data[24]=(byte)((command>>16) & 0xff);
        data[25]=(byte)((command>>8) & 0xff);
        data[26]=(byte)(command & 0xff);
        data[27]=(byte)((extralength>>24) & 0xff);
        data[28]=(byte)((extralength>>16) & 0xff);
        data[29]=(byte)((extralength>>8) & 0xff);
        data[30]=(byte)(extralength & 0xff);
        for(i=0; i<extralength; i++){
            data[31+i]=extra[i];
        }
        data[31+extralength]='E'; data[32+extralength]='n'; data[33+extralength]='d';
        return data;
    }
    
    public static byte[] findEnd(BufferedInputStream is, byte[] para){
        int cmd=((para[8]&0xff)<<24) | ((para[9]&0xff)<<16) | ((para[10]&0xff)<<8) | (para[11]&0xff);
        byte[] ret=null;
        int i=0, tmp, time, sleepunit=10, timeout=10*1000/sleepunit, available=0;
        //waitFrame=new JFrameWait();
        try {
            while(i++<10){
                byte[] wrap=new byte[32];
                if(is.read(wrap, 0, 31)!=31){
                    for(int j=0; j<31; j++){
                        //System.out.print(wrap[j]+" ");
                    }
                    //System.out.println("Certification has changed.");
                    return null;
                }
                if(!(wrap[0]==para[0] && wrap[1]==para[1] && wrap[2]==para[2] && wrap[3]==para[3] && wrap[4]==para[4])){
                    System.out.println("Can't find Start.");
                    return null;
                }
                int recvCmd=((wrap[23]&0xff)<<24) | ((wrap[24]&0xff)<<16) | ((wrap[25]&0xff)<<8) | (wrap[26]&0xff);
                int length=decrypt(wrap, 27);
                if(recvCmd!=cmd){
                    tmp=0;
                    time=0;
                    while(tmp<length){
                        while(time<timeout && (available=is.available())==0){
                            Thread.sleep(sleepunit);
                            time++;
                        }
                        if(available<0 || time>=timeout){
                            System.out.println("Package lost.");
                            return null;
                        }
                        if(available>length-tmp){
                            available=length-tmp;
                        }
                        tmp+=is.skip(available);
                    }
                    is.read(wrap, 0, 3);
                    if(!(wrap[0]==para[5] && wrap[1]==para[6] && wrap[2]==para[7])){
                        System.out.println("Can't find End.");
                        return null;
                    }
                }
                else{
                    ret=new byte[length];
                    tmp=0;
                    time=0;
                    while(tmp<length){
                        while(time<timeout && (available=is.available())==0){
                            Thread.sleep(sleepunit);
                            time++;
                        }
                        if(available<0 || time>=timeout){
                            System.out.println("Package lost.");
                            return null;
                        }
                        if(available>length-tmp){
                            available=length-tmp;
                        }
                        tmp+=is.read(ret, tmp, available);
                    }
                    is.read(wrap, 0, 3);
                    if(!(wrap[0]==para[5] && wrap[1]==para[6] && wrap[2]==para[7])){
                        System.out.println("Can't find End.");
                        return null;
                    }
                    break;
                }
            }
            if(i>10){
                System.out.println("Can't find return package for command "+cmd);
            }
        } catch (Exception ex) {
            System.out.println("Some error occured.");
        }
        return ret;
    }
    
    /**
     * login数据封包
     * @param usr user name
     * @param mode 直接登录时为0，选择子账号时为1
     * @param platform 平台：0 app, 1 and91
     * @return 
     */
    public static byte[] login_extra(String usr, int mode, int platform){
        String pss;
        switch(platform){
            case 1: // android 91，小米，安卓官方
                pss="android_e78377e2b5d2b00e";
                break;
            case 2: // 苹果91
                pss="8F2B6ECD-54B8-4746-BE67-2FDA84588174";
                break;
            case 3: // 快用
                if(mode==0){
                    cmdGlobal=c_loginp;
                    if(usr.startsWith("381986154")){
                        return login_extra(usr, "Wangsh51920", platform);
                    }
                    else if(usr.startsWith("9091")){
                        return login_extra(usr, "21494029", platform);
                    }
                    else return login_extra(usr, "21494029", platform);
                }
                else{
                    cmdGlobal=c_login;
                    pss="8F2B6ECD-54B8-4746-BE67-2FDA84588174";
                }
                break;
            case 0: // app
            default:
                if(mode==0){
                    usr="EMAIL-"+usr;
                }
                pss="8F2B6ECD-54B8-4746-BE67-2FDA84588174";
                break;
        }
        
        int usrL=usr.length();
        int pssL=pss.length();
        byte[] extra=new byte[usrL+pssL+16];
        extra[0]=extra[1]=extra[2]=extra[3]=0;
        extra[4]=(byte)((mode >> 24) & 0xff);
        extra[5]=(byte)((mode >> 16) & 0xff);
        extra[6]=(byte)((mode >> 8) & 0xff);
        extra[7]=(byte)(mode & 0xff);
        extra[8]=(byte)((usrL >> 24) & 0xff);
        extra[9]=(byte)((usrL >> 16) & 0xff);
        extra[10]=(byte)((usrL >> 8) & 0xff);
        extra[11]=(byte)(usrL & 0xff);
        int i;
        for(i=0; i<usrL; i++){
            extra[12+i]=(byte)(usr.charAt(i));
        }
        extra[12+usrL]=(byte)((pssL >> 24) & 0xff);
        extra[13+usrL]=(byte)((pssL >> 16) & 0xff);
        extra[14+usrL]=(byte)((pssL >> 8) & 0xff);
        extra[15+usrL]=(byte)(pssL & 0xff);
        for(i=0; i<pssL; i++){
            extra[16+usrL+i]=(byte)(pss.charAt(i));
        }
        return extra;
    }
    
    /**
     * login数据封包，带密码
     * @param usr user name
     * @param pss password
     * @param platform 平台：0 app, 1 and91
     * @return 
     */
    public static byte[] login_extra(String usr, String pss, int platform){
        int usrL=usr.length();
        int pssL=pss.length();
        byte[] extra=new byte[usrL+pssL+20];
        extra[0]=extra[1]=extra[2]=extra[3]=extra[4]=extra[5]=extra[6]=extra[7]=extra[8]=extra[9]=extra[10]=extra[11]=0;
        extra[12]=(byte)((usrL >> 24) & 0xff);
        extra[13]=(byte)((usrL >> 16) & 0xff);
        extra[14]=(byte)((usrL >> 8) & 0xff);
        extra[15]=(byte)(usrL & 0xff);
        int i;
        for(i=0; i<usrL; i++){
            extra[16+i]=(byte)(usr.charAt(i));
        }
        extra[16+usrL]=(byte)((pssL >> 24) & 0xff);
        extra[17+usrL]=(byte)((pssL >> 16) & 0xff);
        extra[18+usrL]=(byte)((pssL >> 8) & 0xff);
        extra[19+usrL]=(byte)(pssL & 0xff);
        for(i=0; i<pssL; i++){
            extra[20+usrL+i]=(byte)(pss.charAt(i));
        }
        return extra;
    }
    
    public static byte[] news_extra(int myId){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 3, (byte)0x61, (byte)0x70, (byte)0x70};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        return extra;
    }
    
    public static byte[] addFateEnemy_extra(int myId, int enemyId){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[8]=(byte)((enemyId>>24) & 0xff);
        extra[9]=(byte)((enemyId>>16) & 0xff);
        extra[10]=(byte)((enemyId>>8) & 0xff);
        extra[11]=(byte)(enemyId & 0xff);
        return extra;
    }
    
    public static byte[] revenge_extra(int att, int type, int def, int pieceId){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff};
        extra[0]=(byte)((att>>24) & 0xff);
        extra[1]=(byte)((att>>16) & 0xff);
        extra[2]=(byte)((att>>8) & 0xff);
        extra[3]=(byte)(att & 0xff);
        extra[4]=(byte)((type>>24) & 0xff);
        extra[5]=(byte)((type>>16) & 0xff);
        extra[6]=(byte)((type>>8) & 0xff);
        extra[7]=(byte)(type & 0xff);
        extra[8]=(byte)((def>>24) & 0xff);
        extra[9]=(byte)((def>>16) & 0xff);
        extra[10]=(byte)((def>>8) & 0xff);
        extra[11]=(byte)(def & 0xff);
        extra[12]=(byte)((pieceId>>24) & 0xff);
        extra[13]=(byte)((pieceId>>16) & 0xff);
        extra[14]=(byte)((pieceId>>8) & 0xff);
        extra[15]=(byte)(pieceId & 0xff);
        return extra;
    }
    
    public static byte[] sendMsg_extra(int sender, int reciever, String msg){
        byte[] msgBytes=new byte[1];
        try {
            msgBytes=msg.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SocketMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] extra=new byte[12+msgBytes.length];
        extra[0]=(byte)((sender>>24) & 0xff);
        extra[1]=(byte)((sender>>16) & 0xff);
        extra[2]=(byte)((sender>>8) & 0xff);
        extra[3]=(byte)(sender & 0xff);
        extra[4]=(byte)((reciever>>24) & 0xff);
        extra[5]=(byte)((reciever>>16) & 0xff);
        extra[6]=(byte)((reciever>>8) & 0xff);
        extra[7]=(byte)(reciever & 0xff);
        extra[8]=(byte)((msgBytes.length>>24) & 0xff);
        extra[9]=(byte)((msgBytes.length>>16) & 0xff);
        extra[10]=(byte)((msgBytes.length>>8) & 0xff);
        extra[11]=(byte)(msgBytes.length & 0xff);
        for(int i=0; i<msgBytes.length; i++){
            extra[12+i]=msgBytes[i];
        }
        return extra;
    }
    
    // type 0 收钱， 1 收体力或精力
    public static byte[] harvest_extra(int myId, int pos, int type){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((pos>>24) & 0xff);
        extra[5]=(byte)((pos>>16) & 0xff);
        extra[6]=(byte)((pos>>8) & 0xff);
        extra[7]=(byte)(pos & 0xff);
        extra[8]=(byte)((type>>24) & 0xff);
        extra[9]=(byte)((type>>16) & 0xff);
        extra[10]=(byte)((type>>8) & 0xff);
        extra[11]=(byte)(type & 0xff);
        return extra;
    }
    
    public static byte[] guess_extra(int myId, int mode, int card, int oddOrEven){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((mode>>24) & 0xff);
        extra[5]=(byte)((mode>>16) & 0xff);
        extra[6]=(byte)((mode>>8) & 0xff);
        extra[7]=(byte)(mode & 0xff);
        extra[8]=(byte)((card>>24) & 0xff);
        extra[9]=(byte)((card>>16) & 0xff);
        extra[10]=(byte)((card>>8) & 0xff);
        extra[11]=(byte)(card & 0xff);
        extra[12]=(byte)((oddOrEven>>24) & 0xff);
        extra[13]=(byte)((oddOrEven>>16) & 0xff);
        extra[14]=(byte)((oddOrEven>>8) & 0xff);
        extra[15]=(byte)(oddOrEven & 0xff);
        return extra;
    }
    
    public static byte[] hire_extra(int myId, int level, int x){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((level>>24) & 0xff);
        extra[5]=(byte)((level>>16) & 0xff);
        extra[6]=(byte)((level>>8) & 0xff);
        extra[7]=(byte)(level & 0xff);
        extra[8]=(byte)((x>>24) & 0xff);
        extra[9]=(byte)((x>>16) & 0xff);
        extra[10]=(byte)((x>>8) & 0xff);
        extra[11]=(byte)(x & 0xff);
        return extra;
    }
    
    public static byte[] monster_check_extra(int myId){
        byte[] extra={0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        return extra;
    }
    
    // id+0x65+0+0+0+0xffffffff
    public static byte[] monster_attack_extra(int myId){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, (byte)0x65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        return extra;
    }
    
    public static byte[] train_extra(int myId, int heroIndex, int n, int times){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((heroIndex>>24) & 0xff);
        extra[5]=(byte)((heroIndex>>16) & 0xff);
        extra[6]=(byte)((heroIndex>>8) & 0xff);
        extra[7]=(byte)(heroIndex & 0xff);
        extra[8]=(byte)((n>>24) & 0xff);
        extra[9]=(byte)((n>>16) & 0xff);
        extra[10]=(byte)((n>>8) & 0xff);
        extra[11]=(byte)(n & 0xff);
        extra[12]=(byte)((times>>24) & 0xff);
        extra[13]=(byte)((times>>16) & 0xff);
        extra[14]=(byte)((times>>8) & 0xff);
        extra[15]=(byte)(times & 0xff);
        return extra;
    }
    
    public static byte[] use_extra(int myId, int itemId, int number){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((itemId>>24) & 0xff);
        extra[5]=(byte)((itemId>>16) & 0xff);
        extra[6]=(byte)((itemId>>8) & 0xff);
        extra[7]=(byte)(itemId & 0xff);
        extra[8]=(byte)((number>>24) & 0xff);
        extra[9]=(byte)((number>>16) & 0xff);
        extra[10]=(byte)((number>>8) & 0xff);
        extra[11]=(byte)(number & 0xff);
        return extra;
    }
    
    public static byte[] festival_extra(int myId, int i){
        byte[] extra={0, 0, 0, 0, 0, 0, 0, 0};
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((i>>24) & 0xff);
        extra[5]=(byte)((i>>16) & 0xff);
        extra[6]=(byte)((i>>8) & 0xff);
        extra[7]=(byte)(i & 0xff);
        return extra;
    }
    
    public static byte[] sacrifice_heros_extra(int myId, int pos, int[] sacPos){
        byte[] extra=new byte[12+sacPos.length*4];
        extra[0]=(byte)((myId>>24) & 0xff);
        extra[1]=(byte)((myId>>16) & 0xff);
        extra[2]=(byte)((myId>>8) & 0xff);
        extra[3]=(byte)(myId & 0xff);
        extra[4]=(byte)((pos>>24) & 0xff);
        extra[5]=(byte)((pos>>16) & 0xff);
        extra[6]=(byte)((pos>>8) & 0xff);
        extra[7]=(byte)(pos & 0xff);
        extra[8]=(byte)((sacPos.length>>24) & 0xff);
        extra[9]=(byte)((sacPos.length>>16) & 0xff);
        extra[10]=(byte)((sacPos.length>>8) & 0xff);
        extra[11]=(byte)(sacPos.length & 0xff);
        for(int i=0; i<sacPos.length; i++){
            extra[12+i*4]=(byte)((sacPos[i]>>24) & 0xff);
            extra[13+i*4]=(byte)((sacPos[i]>>16) & 0xff);
            extra[14+i*4]=(byte)((sacPos[i]>>8) & 0xff);
            extra[15+i*4]=(byte)(sacPos[i] & 0xff);
        }
        return extra;
    }
   
    public static boolean globalLoginSocket(String usr, int accIndex, boolean verbose){
        try{
            
            clientStatic=new Socket(globalIP, globalPort);

            osStatic=new BufferedOutputStream(clientStatic.getOutputStream());

            isStatic=new BufferedInputStream(clientStatic.getInputStream());

            globalCer=0;
            // 获取令牌
            int[] arrCer=new int[2];
            String[] arrName=new String[1];
            loginAccount(osStatic, isStatic, usr, accIndex, arrCer, arrName, verbose);
            globalCer=arrCer[0];
            globalID=arrCer[1];
            globalName=arrName[0];
            globalReady=true;
        }catch(Exception e) {
            globalReady=false;
        }
        return globalReady;
    }
    
    public static boolean loginSocket(String usr, int accIndex, String ipAddr, int port, int[] cer, String[] name, boolean verbose){
        
        try{
            
            clientStatic=new Socket(ipAddr, port);

            osStatic=new BufferedOutputStream(clientStatic.getOutputStream());

            isStatic=new BufferedInputStream(clientStatic.getInputStream());

            // 获取令牌
            int[] arrCer=new int[2];
            String[] arrName=new String[1];
            loginAccount(osStatic, isStatic, usr, accIndex, arrCer, arrName, verbose);
            cer[0]=arrCer[0];
            cer[1]=arrCer[1];
            name[0]=arrName[0];

        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean loginAccount(BufferedOutputStream os, BufferedInputStream is, String usr, int accIndex, int[] cer, String[] name, boolean verbose) throws Exception{
        cer[0]=0;
        int i, j, k, max;
        byte[] extra=login_extra(usr, 0, (int)arguments[4]);
        byte[] recvData=communicate(os, is, cmdGlobal, extra);
        if(recvData==null){
            throw new Exception();
        }
        if(recvData.length<24){
            if(verbose){
                System.out.println(usr+" login fails.");
            }
            throw new Exception();
        }
        i=((recvData[0]&0xff)<<24) | ((recvData[1]&0xff)<<16) | ((recvData[2]&0xff)<<8) | (recvData[3]&0xff);
        if(i>16){
            int number=((recvData[4]&0xff)<<24) | ((recvData[5]&0xff)<<16) | ((recvData[6]&0xff)<<8) | (recvData[7]&0xff);
            if(number<2 || number>83){
                throw new Exception();
            }
            int[] accID=new int[number];
            String[] accName=new String[number];
            int[] accLevel=new int[number];
            String[] accUsr=new String[number];
            j=12;
            max=0;
            for(i=0; i<number; i++){
                accID[i]=(recvData[j] & 0xff) << 24 | (recvData[j+1] & 0xff) << 16 | (recvData[j+2] & 0xff) << 8 | recvData[j+3] & 0xff;
                j+=4;
                k=(recvData[j] & 0xff) << 24 | (recvData[j+1] & 0xff) << 16 | (recvData[j+2] & 0xff) << 8 | recvData[j+3] & 0xff;
                j+=4;
                accName[i]=new String(recvData, j, k, "UTF-8");
                j+=k;
                accLevel[i]=(recvData[j] & 0xff) << 24 | (recvData[j+1] & 0xff) << 16 | (recvData[j+2] & 0xff) << 8 | recvData[j+3] & 0xff;
                j+=4;
                if(accLevel[i]>accLevel[max]){
                    max=i;
                }
                k=(recvData[j] & 0xff) << 24 | (recvData[j+1] & 0xff) << 16 | (recvData[j+2] & 0xff) << 8 | recvData[j+3] & 0xff;
                j+=4;
                accUsr[i]=new String(recvData, j, k, "UTF-8");
                j+=k;
                j+=4;
                accName[i]="ID "+accID[i]+": "+accName[i]+" "+accLevel[i]+"级";
            }
            globalIndex=999;
            if(accIndex==1000){
                accIndex=max;
            }
            while(accIndex<0 || accIndex>=number){
//                System.out.println("Choose your account");
//                for(i=0; i<number; i++){
//                    System.out.println(i+": ID "+accID[i]+"\t"+accName[i]+"\tlevel "+accLevel[i]+"\t"+accUsr[i]);
//                }
//                Scanner scanner=new Scanner(System.in);
//                accIndex=scanner.nextInt();
//                if(accIndex==999){
//                    System.exit(0);
//                }
                new CharactorChooser(null, true, accName);
                accIndex=globalIndex;
                if(accIndex==999){
                    throw new Exception();
                }
            }
            extra=login_extra(accUsr[accIndex], 1, (int)arguments[4]);
            recvData=communicate(os, is, cmdGlobal, extra);
            if(recvData==null){
                throw new Exception();
            }
            if(recvData.length<24){
                if(verbose){
                    System.out.println(usr+" login fails.");
                }
                throw new Exception();
            }
        }
        cer[0] = (recvData[4] & 0xff) << 24 | (recvData[5] & 0xff) << 16 | (recvData[6] & 0xff) << 8 | recvData[7] & 0xff;
        cer[1] = (recvData[16] & 0xff) << 24 | (recvData[17] & 0xff) << 16 | (recvData[18] & 0xff) << 8 | recvData[19] & 0xff;
        i=((recvData[24]&0xff)<<24) | ((recvData[25]&0xff)<<16) | ((recvData[26]&0xff)<<8) | (recvData[27]&0xff);
        name[0]=new String(recvData, 28, i, "UTF-8");
        if(verbose){
            i=36+i;
            int level=(recvData[i] & 0xff) << 24 | (recvData[i+1] & 0xff) << 16 | (recvData[i+2] & 0xff) << 8 | recvData[i+3] & 0xff;
            i+=12;
            int diamond=(recvData[i] & 0xff) << 24 | (recvData[i+1] & 0xff) << 16 | (recvData[i+2] & 0xff) << 8 | recvData[i+3] & 0xff;
            i+=4;
            int gold=(recvData[i] & 0xff) << 24 | (recvData[i+1] & 0xff) << 16 | (recvData[i+2] & 0xff) << 8 | recvData[i+3] & 0xff;
            System.out.println("ID "+cer[1]+": "+name[0]+" is prepared.");
            System.out.println("Level: "+level+", Diamond: "+diamond+", Gold: "+gold);
        }
        return true;
    }
    
    public static void setGlobalIP(int i){
        switch(i){
            case 1:     // app 2
                globalIP="112.124.41.217";
                globalPort=8010;
                break;
            case 2:     // app 3
                globalIP="121.199.24.70";
                globalPort=8000;
                break;
            case 3:     // app 5
                globalIP="121.199.30.204";
                globalPort=8000;
                break;
            case 4:     // app 9
                globalIP="121.199.30.204";
                globalPort=8010;
                break;
            case 5:     // app 11
                globalIP="121.199.30.204";
                globalPort=8020;
                break;
            case 6:     // app 13
                globalIP="121.199.24.70";
                globalPort=8010;
                break;
            case 7:     // app 21
                globalIP="121.199.24.70";
                globalPort=8020;
                break;
            case 8:
                    globalIP="115.29.230.178";
                    globalPort=8000;
                    break;
            case 9:
                    globalIP="112.124.23.169";
                    globalPort=8000;
                    break;
            case 10:
                    globalIP="112.124.5.199";
                    globalPort=8020;
                    break;
            case 11:
                    globalIP="112.124.5.199";
                    globalPort=8030;
                    break;
            case 12:
                    globalIP="112.124.5.199";
                    globalPort=8040;
                    break;
            case 13:
                    globalIP="112.124.5.199";
                    globalPort=8050;
                    break;
            case 14:
                    globalIP="115.29.230.178";
                    globalPort=8010;
                    break;
            case 15:
                    globalIP="121.199.29.109";
                    globalPort=8000;
                    break;
            case 16:
                    globalIP="121.199.29.109";
                    globalPort=8010;
                    break;
            case 17:
                    globalIP="121.199.29.109";
                    globalPort=8020;
                    break;
            case 18:
                    globalIP="121.199.29.109";
                    globalPort=8030;
                    break;
            case 19:
                    globalIP="115.29.9.49";
                    globalPort=8000;
                    break;
            case 20:
                    globalIP="115.29.9.48";
                    globalPort=8000;
                    break;
            case 21:
                    globalIP="115.29.9.49";
                    globalPort=8010;
                    break;
            case 22:
                    globalIP="112.124.23.169";
                    globalPort=8010;
                    break;
            case 23:
                    globalIP="115.29.234.133";
                    globalPort=8000;
                    break;
            case 24:
                    globalIP="115.29.234.133";
                    globalPort=8010;
                    break;
            case 25:
                    globalIP="115.29.9.48";
                    globalPort=8010;
                    break;
            case 26:
                    globalIP="115.29.9.48";
                    globalPort=8020;
                    break;
            case 27:
                    globalIP="115.29.190.63";
                    globalPort=8000;
                    break;
            case 28:
                    globalIP="115.29.234.133";
                    globalPort=8020;
                    break;
            case 29:
                    globalIP="115.29.190.63";
                    globalPort=8010;
                    break;
            case 30:
                    globalIP="115.29.9.48";
                    globalPort=8030;
                    break;
            case 31:
                    globalIP="115.29.9.49";
                    globalPort=8020;
                    break;
            case 32:
                    globalIP="115.29.9.49";
                    globalPort=8030;
                    break;
            case 33:
                    globalIP="115.29.234.133";
                    globalPort=8030;
                    break;
            case 34:
                    globalIP="218.244.146.146";
                    globalPort=8000;
                    break;
            case 35:
                    globalIP="218.244.146.146";
                    globalPort=8010;
                    break;
            case 36:
                    globalIP="112.124.23.169";
                    globalPort=8020;
                    break;
            case 37:
                    globalIP="218.244.146.146";
                    globalPort=8020;
                    break;
            case 38:
                    globalIP="114.215.198.67";
                    globalPort=8000;
                    break;
            case 39:
                    globalIP="114.215.198.67";
                    globalPort=8010;
                    break;
            case 40:
                    globalIP="114.215.198.67";
                    globalPort=8020;
                    break;
            case 41:
                    globalIP="114.215.198.67";
                    globalPort=8030;
                    break;
            case 42:
                    globalIP="114.215.198.67";
                    globalPort=8040;
                    break;
            case 43:
                    globalIP="115.29.230.178";
                    globalPort=8020;
                    break;
            case 44:
                    globalIP="115.29.190.63";
                    globalPort=8020;
                    break;
            case 45:
                    globalIP="115.29.230.178";
                    globalPort=8030;
                    break;
            case 46:
                    globalIP="115.29.190.63";
                    globalPort=8030;
                    break;
            case 47:
                    globalIP="115.29.9.49";
                    globalPort=8040;
                    break;
            case 48:
                    globalIP="115.29.234.133";
                    globalPort=8040;
                    break;
            case 49:
                    globalIP="115.29.190.63";
                    globalPort=8040;
                    break;
            case 50:
                    globalIP="115.29.9.48";
                    globalPort=8040;
                    break;
            case 51:
                    globalIP="115.29.224.81";
                    globalPort=8000;
                    break;
            case 52:
                    globalIP="218.244.141.250";
                    globalPort=8000;
                    break;
            case 53:
                    globalIP="115.29.224.81";
                    globalPort=8010;
                    break;
            case 54:
                    globalIP="218.244.141.250";
                    globalPort=8010;
                    break;
            case 55:
                    globalIP="218.244.146.146";
                    globalPort=8030;
                    break;
            case 56:    // 混157
                    globalIP="115.29.224.81";
                    globalPort=8020;
                    break;
            case 57:
                    globalIP="218.244.141.250";
                    globalPort=8020;
                    break;
            case 58:    // 混159
                    globalIP="115.29.224.81";
                    globalPort=8030;
                    break;
            case 0:
            default:
                globalIP="112.124.41.217";
                globalPort=8000;
        }
    }
    
    public static byte tran26(byte b){
        int i=b & 0xff;
        int j=i%8;
        i=i/8;
        j=(3-j/2)*2+j%2;
        return (byte)(i*8+j);
    }
    
    public static void encrypt(byte[] data){
        int i, b;
        for(i=0; i<data.length; i++){
            data[i]=tran26(data[i]);
        }
    }
    
    public static void decrypt(byte[] data){
        int i, b;
        for(i=0; i<data.length; i++){
            data[i]=tran26(data[i]);
        }
    }
    
    public static int decrypt(byte[] data, int pos){
        byte[] numByte=new byte[4];
        for(int i=0; i<numByte.length; i++){
            if((int)arguments[4]!=0){
                numByte[i]=tran26(data[pos+i]);
            }
            else{
                numByte[i]=tran26(data[pos+i]);
            }
        }
        return ((numByte[0]&0xff)<<24) | ((numByte[1]&0xff)<<16) | ((numByte[2]&0xff)<<8) | (numByte[3]&0xff);
    }
    
    public static byte[] communicate(BufferedOutputStream os, BufferedInputStream is, int command, byte[] extra){
        if(os==null || is==null){
            return null;
        }
        int extralength=extra.length;
        int length=extralength+22;
        byte[] data=transform(length, (int)arguments[4]==0?2008000:2008000, globalCer, command, extralength, extra);
        byte[] para=new byte[12];
        para[0]=0x53; para[1]=0x74; para[2]=0x61; para[3]=0x72; para[4]=0x74;
        para[5]=0x45; para[6]=0x6e; para[7]=0x64;
        para[8]=(byte)((command >> 24) & 0xff);
        para[9]=(byte)((command >> 16) & 0xff);
        para[10]=(byte)((command >> 8) & 0xff);
        para[11]=(byte)(command & 0xff);
        if((int)arguments[4]!=0){
            encrypt(data);
            encrypt(para);
        }
        else{
            encrypt(data);
            encrypt(para);
        }
        byte[] recvData;
        JWindowWait waitWindow=new JWindowWait();
        waitWindow.start();
        try {
            os.write(data);
            os.flush();
            recvData=findEnd(is, para);
        } catch (IOException ex) {
            recvData=null;
        }
        if(recvData!=null){
            if((int)arguments[4]!=0){
                decrypt(recvData);
            }
            else{
                decrypt(recvData);
            }
        }
        waitWindow.closeDiag();
        return recvData;
    }
    
    public boolean globalQueryBB(){
        if(!globalReady || clientStatic==null || osStatic==null || isStatic==null){
            return false;
        }
        int command=c_bb_q0;
        byte[] extra=monster_check_extra(globalID);
        byte[] recvData=communicate(osStatic, isStatic, command, extra);
        if(recvData==null || recvData.length<36){
            return false;
        }
        int pos, challengeTimes, bestQX, bestFY, challengeMax, rank;
        pos=8;
        mode=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(mode!=0 && mode!=1){
            // 选择强袭或防御试炼
            challengeTimes=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            bestQX=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            bestFY=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            challengeMax=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            rank=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            globalIndex=-1;
            new JDialogChooseMode(SLComputer.mf, true, rank, challengeTimes, challengeMax, bestQX, bestFY);
            if(globalIndex!=0 && globalIndex!=1){
                return false;
            }
            mode=globalIndex;
        }
        command=c_bb_q1;
        extra=festival_extra(globalID, mode);
        recvData=communicate(osStatic, isStatic, command, extra);
        if(recvData==null || recvData.length<168){
            return false;
        }
        int level, myNumber, enemyNumber, enemyHard, enemyNormal, enemyEasy, killFirst, moreBuff, 
                buffAttP, buffAttM, buffDefP, buffDefM, buffEffectP, buffEffectM,
                moreHPP, moreHPM, moreEffectP, moreEffectM, moreKill, lastNightLevel;
        pos=8;
        mode=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(mode!=0 && mode!=1){
            return false;
        }
        challengeTimes=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        bestQX=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        bestFY=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        challengeMax=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        rank=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=4;
        moreHPP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreHPM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        moreKill=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        lastNightLevel=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;

        if(moreBuff>0){
            // 选择Buff
            globalIndex=-1;
            new JDialogChooseBuff(SLComputer.mf, true, mode, starUsed, starTotal, moreHPP, moreEffectP, moreHPM, moreEffectM, moreKill, lastNightLevel);
            if(globalIndex<0 || globalIndex>4){
                return false;
            }
            command=c_bb_q2;
            extra=festival_extra(globalID, globalIndex);
            recvData=communicate(osStatic, isStatic, command, extra);
            if(recvData==null || recvData.length<160){
                return false;
            }
            pos=28;
            if(mode!=(((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff))){
                return false;
            } pos+=4;
            level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            
        }
        updateSelection(mode, level, buffDefP, buffDefM, buffEffectP, buffEffectM,
                killFirst, enemyHard, enemyNormal, enemyEasy, myNumber, enemyNumber, "", true);
        return true;
    }
    
    public static HeroLight referenceHero(HeroLight[] team, int ref){
        for(int i=0; i<team.length; i++){
            if(team[i].ref==ref){
                return team[i];
            }
        }
        return null;
    }
    
    public static Skill referenceSkill(int id){
        for(Skill sk:SLComputer.skills){
            if(sk.id==id){
                return sk;
            }
        }
        return new Skill();
    }
    
    public int battle(int hardness){
        if(!globalReady || clientStatic==null || osStatic==null || isStatic==null){
            return 2;
        }
        int command=c_bb_battle;
        byte[] extra=festival_extra(globalID, hardness);
        byte[] recvData=communicate(osStatic, isStatic, command, extra);
        if(recvData==null || recvData.length<76){
            return 2;
        }
        int i, j, x, y, pos, length, starGain;
        String battleDetails, skillDetail0, skillDetail1, attName, defName;
        HeroLight[] attTeam, defTeam;
        HeroLight attHero, defHero;
        int rounds;
        pos=8;
        starGain=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=8;
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        try {
            attName=new String(recvData, pos, length, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            attName="unsupportedEncoding";
        }
        pos+=length;
        pos+=4; // 角色等级
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        try {
            defName=new String(recvData, pos, length, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            defName="unsupportedEncoding";
        }
        pos+=length;
        battleDetails=attName+"   VS   "+defName+"\n";
        pos+=8; // 角色等级
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        attTeam=new HeroLight[length];
        for(i=0; i<length; i++){
            pos+=4;
            attTeam[i]=new HeroLight();
            attTeam[i].ref=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attTeam[i].setName(j);
            attTeam[i].id=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attTeam[i].setProperty(attTeam[i].id);
            pos+=4;
            attTeam[i].hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
        }
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        defTeam=new HeroLight[length];
        for(i=0; i<length; i++){
            pos+=4;
            defTeam[i]=new HeroLight();
            defTeam[i].ref=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defTeam[i].setName(j);
            defTeam[i].id=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defTeam[i].setProperty(defTeam[i].id);
            pos+=4; // 忍者等级
            defTeam[i].hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4; // 6星+几
        }
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 进攻方尾兽排布
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 防守方尾兽排布
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 进攻方作战建筑
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        pos+=16*length; // 防守方作战建筑
        rounds=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        boolean skilled;
        boolean shiwei;
        String skillName;
        for(i=0; i<rounds; i++){
            pos+=8;
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            attHero=referenceHero(attTeam, j);
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero=referenceHero(defTeam, j);
            if(attHero==null || defHero==null){
                System.out.println("Can't find reference hero in the team.");
                return 3;
            }
            pos+=4;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            battleDetails+=attHero.name+" "+attHero.property+" "+hp(attHero.hp)+" VS "+hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            pos+=4;
            skilled=false;
            shiwei=false;
            // 尾兽技能
            skillDetail0="";
            skillDetail1="";
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(j!=0){
                skillName=referenceSkill(j).name;
                skillDetail0+=attName+" >>> "+skillName+"\n";
                if(skillName.equals("神树降诞")){
                    shiwei=true;
                }
                skilled=true;
            }
            j=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(j!=0){
                skillName=referenceSkill(j).name;
                skillDetail1+="     "+skillName+" <<< "+defName+"\n";
                if(skillName.equals("神树降诞")){
                    shiwei=true;
                }
                skilled=true;
            }
            pos+=4;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail0+=referenceHero(attTeam, x).name+" 复活！\n";
            }
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail1+=referenceHero(defTeam, x).name+" 复活！\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"-")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x<0?"+":"-")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"-")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x<0?"+":"-")+x+"\n";
            }
            battleDetails+=skillDetail0+skillDetail1;
            pos+=12;
            // 主动技能
            skillDetail0="";
            skillDetail1="";
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" 发动 "+referenceSkill(x).name+"\n";
                skilled=true;
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" 发动 "+referenceSkill(x).name+"\n";
                skilled=true;
            }
            pos+=4;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail0+=referenceHero(attTeam, x).name+" 复活！\n";
            }
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            for(j=0; j<length; j++){
                x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                skillDetail1+=referenceHero(defTeam, x).name+" 复活！\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            if(!shiwei){
                battleDetails+=skillDetail0+skillDetail1;
            }
            pos+=12;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(skilled && !shiwei){
                battleDetails+=attHero.name+" "+attHero.property+" "+hp(attHero.hp)+" VS "+hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            }
            pos+=4;
            // 属性相克
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            y=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(attHero.hp!=x || defHero.hp!=y){
                battleDetails+=attHero.property+" "+(x-attHero.hp>=0?"+"+(x-attHero.hp):(x-attHero.hp))+((x-attHero.hp)>0?" ---> ":" <--- ")+((y-defHero.hp)>=0?"+"+(y-defHero.hp):""+(y-defHero.hp))+" "+defHero.property+"\n";
                attHero.hp=x;
                defHero.hp=y;
                battleDetails+=attHero.name+" "+attHero.property+" "+hp(attHero.hp)+" VS "+hp(defHero.hp)+" "+defHero.property+" "+defHero.name+"\n";
            }
            pos+=4;
            // 战后技能
            skillDetail0="";
            skillDetail1="";
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" 发动 "+referenceSkill(x).name+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" 发动 "+referenceSkill(x).name+"\n";
            }
            pos+=8;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=attHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail1+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            x=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(x!=0){
                skillDetail0+=defHero.name+" "+(x>0?"+":"")+x+"\n";
            }
            pos+=12;
            attHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            defHero.hp=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            if(attHero.hp>0){
                battleDetails+=skillDetail0;
            }
            if(defHero.hp>0){
                battleDetails+=skillDetail1;
            }
            if(attHero.hp==0){
                battleDetails+=skillDetail0;
                battleDetails+=attHero.name+" 死亡\n";
            }
            if(defHero.hp==0){
                battleDetails+=skillDetail1;
                battleDetails+=defHero.name+" 死亡\n";
            }
        }
        // 每5关奖励
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(length==6){
            pos+=24;
        }
        else if(length==7){
            pos+=20;
            length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=20*length+4;
        }
        else{
            System.out.println("Award part unexpected item count: "+length);
            return 3;
        }
        // 试炼概况
        pos+=28;
        // 试炼详情
        length=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
        if(length>0){
            length=starGain/(3-hardness);
            switch(length){
                case 3:
                    battleDetails+="完胜！\n";
                    break;
                case 2:
                    battleDetails+="胜利！\n";
                    break;
                case 1:
                    battleDetails+="险胜！\n";
                    break;
                default:
                    battleDetails+="未知数据："+hardness+"\n";
            }
            battleDetails+="获得星星："+starGain+"\n";
            int level, myNumber, enemyNumber, enemyHard, enemyNormal, enemyEasy, killFirst, moreBuff,
                    buffDefP, buffAttP, buffEffectP, buffDefM, buffAttM, buffEffectM;
            int moreHPP, moreEffectP, moreHPM, moreEffectM, moreKill, lastNightLevel;
            mode=(((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff)); pos+=4;
            level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=8;
            buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            pos+=4;
            moreHPP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreHPM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            moreKill=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            lastNightLevel=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
            updateSelection(mode, level, buffDefP, buffDefM, buffEffectP, buffEffectM,
                killFirst, enemyHard, enemyNormal, enemyEasy, myNumber, enemyNumber, battleDetails, true);
            if(moreBuff>0){
                // 选择Buff
                globalIndex=-1;
                new JDialogChooseBuff(SLComputer.mf, true, mode, starUsed, starTotal, moreHPP, moreEffectP, moreHPM, moreEffectM, moreKill, lastNightLevel);
                if(globalIndex<0 || globalIndex>4){
                    return 2;
                }
                command=c_bb_q2;
                extra=festival_extra(globalID, globalIndex);
                recvData=communicate(osStatic, isStatic, command, extra);
                if(recvData==null || recvData.length<160){
                    return 2;
                }
                pos=28;
                if(mode!=(((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff))){
                    return 2;
                } pos+=4;
                level=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                myNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                enemyHard=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                enemyNumber=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                enemyNormal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                enemyEasy=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                killFirst=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                moreBuff=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=4;
                starUsed=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                starTotal=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                pos+=8;
                buffDefP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffAttP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffEffectP=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffDefM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffAttM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                buffEffectM=((recvData[pos]&0xff)<<24) | ((recvData[pos+1]&0xff)<<16) | ((recvData[pos+2]&0xff)<<8) | (recvData[pos+3]&0xff); pos+=4;
                updateSelection(mode, level, buffDefP, buffDefM, buffEffectP, buffEffectM,
                    killFirst, enemyHard, enemyNormal, enemyEasy, myNumber, enemyNumber, battleDetails, true);
            }
            
        }
        else{
            battleDetails+="失败...\n";
            updateSelection(-1, -1, -1, -1, -1, -1,
                0, 0, 0, 0, 0, 0, battleDetails, false);
            return 1;
        }
        return 0;
    }
    
    public static String hp(int hp){
        if(hp/100000==0){
            return ""+hp;
        }
        return hp/10000+"万";
    }
    
    public static void updateSelection(int mode, int level, int buffDefP, int buffDefM, int buffEffectP, int buffEffectM,
            int killFirst, int enemyHard, int enemyNormal, int enemyEasy, int myNumber, int enemyNumber, String battleDetails, boolean win){
        UpdateSelection update=new UpdateSelection();
        update.mode=mode;
        update.level=level;
        update.buffHPP=buffDefP-100;
        update.buffHPM=-buffDefM;
        update.buffEffectP=buffEffectP;
        update.buffEffectM=-buffEffectM;
        update.buffKill=killFirst;
        update.enemyEasy=enemyEasy%100;
        update.enemyNorm=enemyNormal%100;
        update.enemyHard=enemyHard%100;
        update.myNumber=myNumber;
        update.enemyNumber=enemyNumber;
        update.battle=battleDetails;
        update.win=win;
        SwingUtilities.invokeLater(update);
    }
    
    public static void connectionBroken(){
        SLComputer.cleanLogin();
        JOptionPane.showMessageDialog(SLComputer.mf, "连接超时，被动中断，或用户操作不当导致主动中断，请重新登录", "连接中断", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void run() {
        if(onWork){
            return;
        }
        onWork=true;
        switch(cmdGlobal){
            case c_login:
                if(globalLoginSocket((String)arguments[0], -1, false) && (boolean)arguments[3]){
                    SLComputer.updateAcc(usrSave, (String)arguments[1], (int)arguments[2]);
                }
                if(globalReady){
                    //SLComputer.mf.setTitle(SLComputer.mf.getTitle()+" ("+globalName+" 已登陆)");
                    Emphasize buttons=new Emphasize(true);
                    SwingUtilities.invokeLater(buttons);
                    JOptionPane.showMessageDialog(SLComputer.mf, globalName+" 已登陆，从现在开始点击任一挑战按钮将视为游戏内挑战对应难度试炼。\n若要退出此模式请用菜单栏里的注销。",
                            "登陆成功", JOptionPane.INFORMATION_MESSAGE);
                    if(globalQueryBB()){
                        // 准备完成，开始试炼
                    }
                    else{
                        connectionBroken();
                    }
                }
                else{
                    SLComputer.cleanLogin();
                    JOptionPane.showMessageDialog(SLComputer.mf, "可能由于网络等原因登陆失败，请重新尝试。", "登陆失败", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case c_bb_battle:
                int ret=battle((int)arguments[0]);
                if(ret==1){
                    SLComputer.cleanLogin();
                    JOptionPane.showMessageDialog(SLComputer.mf, "挑战失败，返回普通模式。若要再次尝试请重新登录。", "结束", JOptionPane.ERROR_MESSAGE);
                }
                else if(ret>1){
                    connectionBroken();
                }
                break;
            default:
        }
        onWork=false;
    }
}
