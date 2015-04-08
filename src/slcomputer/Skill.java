/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

/**
 *
 * @author J
 */
public class Skill {
    public int id;
    public String name;
    public int type;
    public int level;
    public double x;
    public double y;
    public double z;
    
    // 发动技能的时机: 0 主动技, 1 被动技, 2 自爆, 3 回血, -1 非法类型
    public int timming(){
        // 非法类型
        if(type<0 || (type>22 && type<29) || type>35 || type==6 || type==8 || type==9 || type==11
                || type==12 || type==17 || type==18){
            return -1;
        }
        // 回血类
        if(type==21 || type==32){
            return 3;
        }
        // 自爆，阴封印
        if(type==10 || type==30){
            return 2;
        }
        // 被动
        if(type==15 || type==16){
            return 1;
        }
        // 主动
        return 0;
    }
    
    public String description(double powerPlus, double powerMul, double ratePlus, double rateMul){
        String s;
        //System.out.println(powerPlus+", "+powerMul+", "+ratePlus+", "+rateMul);
        switch(type){
            case 0:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率增加自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 1:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率复制当前对阵忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值增加到自身";
                break;
            case 2:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率增加自己武器和防具<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 3:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率将我方任意一名阵亡忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值增加到自身";
                break;
            case 4:
                s="战斗中如果对方有重复的忍者上阵则增加自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 5:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率增加自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值，次回合攻防值减少为剩余值的<font color=#FF0000>"+z+"</font>％";
                break;
            case 6:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率增加自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值，并增加我方任意{@3|ORANGE|Bold|9}名未上阵忍者{@4|ORANGE|Bold|9}％的攻防值";
                break;
            case 7:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率减少当前对阵忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 8:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率减少当前对阵忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值，并减少敌方任意{@3|ORANGE|Bold|9}名未上阵忍者{@4|ORANGE|Bold|9}％的攻防值";
                break;
            case 9:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率减少敌方尾兽<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的战斗加成效果";
                break;
            case 10:
                s="战斗阵亡后有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率对当前对阵忍者造成大量伤害，伤害上限为战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％";
                break;
            case 11:
                s="战斗阵亡后有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率对当前对阵忍者造成大量伤害，伤害上限为战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％（攻击战有效）";
                break;
            case 12:
                s="战斗阵亡后有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率对当前对阵忍者造成大量伤害，伤害上限为战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％（防守战有效）";
                break;
            case 13:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率增加自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值，并减少当前对阵忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 14:
                s="战斗中如果当前对阵忍者的攻防值比自己高，则有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率直接夺取差值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％增加到自身";
                break;
            case 15:
                s="复制忍术，战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率复制当前对阵忍者已触发的忍术";
                break;
            case 16:
                s="战斗中如果当前对阵忍者已触发忍术，则有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率使其忍术无效化";
                break;
            case 17:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率降低当前对阵忍者<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的忍术触发几率，并降低敌方任意{@3|ORANGE|Bold|9}名未上阵忍者{@4|ORANGE|Bold|9}％的忍术触发几率";
                break;
            case 18:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率提高自己<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的忍术触发几率，并提高我方任意{@3|ORANGE|Bold|9}名未上阵忍者{@4|ORANGE|Bold|9}％的忍术触发几率";
                break;
            case 19:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率复活我方全部阵亡忍者，复活的人数越多几率越低，被复活的忍者恢复到战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％";
                break;
            case 20:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率复活我方任意一名阵亡忍者，被复活的忍者恢复到战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％";
                break;
            case 21:
                s="战斗胜利后有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率恢复自己战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％";
                break;
            case 22:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率减少当前对阵忍者武器和防具<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值";
                break;
            case 29:
                s="战斗胜利后当攻防值降低到初始上阵的<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％以下时，可恢复自己战场初始攻防值的<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％";
                break;
            case 30:
                s="当忍者阵亡后，对方忍者将不能再释放忍术";
                break;
            case 31:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率使得对方中毒，中毒的忍者死后不可被复活。";
                break;
            case 32:
                s="战斗胜利后我方恢复造成碰撞伤害的<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的攻防值。";
                break;
            case 33:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率触发该忍术，当对方人物攻防值,星级都比我方低时，可让敌方变为1点攻防值，否则就降低敌方<font color=#FF0000>"+(int)((y+powerPlus)*(1+powerMul))+"</font>％的攻防值。";
                break;
            case 34:
                s="战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率触发该忍术，可使得对方人物不能再释放忍术。";
                break;
            case 35:
                s="辉夜姬化身神树，战斗中有<font color=#FF0000>"+(int)((x+ratePlus)*(1+rateMul))+"</font>％的几率将敌方忍者攻防值降为1。";
                break;
            default:
                s="Unknow Skill Type.";
                break;
        }
        return s;
    }
}
