/*
 * Version 2.0
 * 第一次公开版本，大体实现了设想的所有功能，最重要的是模拟试炼
 * 
 * Version 2.1
 * 1. 高层试炼的敌方技能加成终于实装啦，现在能正确的模拟出高层试炼的恐怖白眼以及几乎100%的触发几率了
 * 2. 尾兽现在有等级了,并且尾兽的效果也实装了有木有，而且主尾兽和其他尾兽的区别也完成了（我真是越来越佩服自己了），但是尾兽的战斗技能还没做，因为作者玩的APP平台还没更新。。。
 * 3. 现在每个难度下会分别显示出攻击/防御的总数值了，可以方便地进行比较。
 * 并且己方的总攻击/防御数值也会显示出来，但是是全队的总攻击和防御值哦，因为不同难度的试炼上阵的人数是不一定的，所以不方便显示出前N个人的总攻击/防御。
 * 4. 改进了一个很无聊的小功能，右边文本框的模拟结果中显示哪边是进攻方，哪边是防御方
 * 
 * Version 2.2
 * 1.自来也等人的缘加成BUG修复了，以前所有需要队里大于n个XX忍者类型的缘都是按大于n计算的，但是有人反馈等于n的时候也会开缘，因此这个版本修复了这个BUG。
 * 2.找到了一个非常严重的BUG，在点击普通难度或菜鸟难度或试炼终结者按钮时，程序忘了读取己方上阵忍者数，因此默认是全员上阵，所以在计算胜率的时候是非常不准的，尤其是1V1的时候，胜率几乎都是100%，作者本人已经被这个BUG坑过了，为了不让大家也像作者一样被坑，只好赶工提前把这个版本发布了。现在程序能正确的读取上阵人数并且准确计算胜率了（假如没有其他BUG的话。。。）。
 * 3.根据吧友提醒，试炼的时候己方的缘加成是按阵容里的所有成员计算的，也就是说10人阵里，虽然最多上10个忍者，但是缘加成是算14人的，因此现在己方阵容上限提升到了14人。
 * 4.有吧友反映窗口太大了，其实我早就意识到了这个问题，担心万一有的人的电脑分辨率不够高，会点不到下面的按钮，所以这次改版大幅度修改了界面，为了节省空间，不得已使用了Tab，大体上影响不大吧。。。说实话我还没有完全摆好各组件的位置，有些按钮的位置我还是很不爽，争取下次改进。
 * 5.放作战建筑的位置已经设置好了，但是由于之前说的第二点，偶已经来不及完成作战建筑的功能了，只好留在下次更新的时候完善。
 * 6.试炼每3层的增益中可以选择增加自己或降低敌方的忍术效果，这个功能已经实装，和增加/减少攻防类似，填的数字就是你在试炼选难度时下方显示的数字。
 * 
 * Version 2.3
 * 1.APP喜迎1.7，尾兽祭坛取消主副尾兽的区别了。
 * 2.试炼层数旁边添加了两个按钮，可以用来方便的对试炼层数+1，-1了。
 * 3.每个难度下点挑战后可以显示对手和自己阵容的攻防总值了，由于地方太拥挤了，不得不把“攻击”或“防御”字样去掉了，作者假设大家都知道显示的数值是攻击值还是防御值。。。
 * 4.完成了作战建筑的功能，作战建筑的等级只需要输入一次哦，会自动存储的，但是每次重启都会默认所有作战建筑都是停止运转的，别忘了启动哦。
 * 5."试炼终结者"按钮移到了更方便点击的位置。（tips：直接点试炼终结者也会刷新一次敌人和自己的阵容哦，另外只有点了试炼终结者才会计算胜率。。。）
 * 6.增加了忍者和装备的颜色提示，根据星级会显示不同的颜色，这样在选忍者的时候更容易找到了有木有？
 * 7.修复了一个不起眼的BUG，查看第n层试炼敌人的忍术效果和触发几率时实际显示的是n+1层的。
 * 8.减少敌人的忍术效果后，现在不会出现负的效果了。。。。
 * 9.轮回天生和秽土转生不会再在没有人死亡的时候也触发了，并且轮回天生的触发几率会根据已死亡忍术稍微降低点了。
 * 10.修复了一个己方技能效果异常NB的BUG。
 * 
 * Version 2.4
 * 1. 为了方便更改各难度下的上阵人数，现在3个难度下的己方人数及普通难度的敌方人数始终保持一致。
 * 2. 敌方忍者的数值计算貌似更加精确了。
 * 3. 每个难度下现在共有4个备选阵容了，1V1 3V3什么的一键切换下阵容就好了，不用重新输入忍者啦。并且点复制阵容就会复制你当前使用的阵容，切换到另一个阵容后点粘贴阵容，叮叮，阵容就妥妥的复制过去了有木有，不过你如果不点击一下显示阵容或挑战的话这个阵容是不会被储存的哦，因为我默认这个阵容和你已有的阵容是相同的，那么就没必要存这个多余的阵容啦。悄悄地告诉你，复制粘贴阵容是可以跨强袭/防卫模式的哦。
 * 4. 初步完成了尾兽实战技能的实装，BUG什么的还不好说，如果你发现了关于尾兽技能的BUG，请悄悄告诉楼主。。。
 * 5. 貌似主打防御试炼的人占大多数（其实是因为楼主自己主打防御。。。），所以现在打开工具的时候默认选择的是护卫模式。
 * 6. 添加了使用说明。
 * 7. 自来也等人的装备缘BUG修复了。
 * 8. 修复了若干个估计都没有人关心的BUG。
 * 
 * Version 2.5
 * 1. 添加了菜单栏，提供一些参数给大家自己设置。模拟次数：可以自己选择计算胜率时模拟多少次战斗，模拟次数越多胜率越准确；智能选取人数：选择敌我双方上阵人数时会智能进行调整。
 * 2. 略微调整了下5星忍者的潜力值算法，试试看误差小点没？
 * 3. 修复了强袭试炼七尾导致全员变全属性的问题。
 * 4. 战斗后加血技能不再受尾兽加成了。
 * 5. 所有忍者数据改为从文件中读取，除了id和name。
 * 
 * Version 3.0
 * 1. (重要)暂时不提供计算胜率的功能，1.8版本还有很多数据需要测试，考虑到当前的模拟不准可能导致计算胜率偏差过大而误导大家，暂时取消了一键计算胜率功能，但是你可以通过点击挑战查看一次模拟挑战信息，如果发现数值偏差过大的地方，欢迎发信告诉我。
 * 2. 数据库更新到了1.8版本。
 * 3. 己方上阵人数上限提高到了15人，试炼增加了12人阵信息。
 * 4. 选择己方忍者的同时，可以输入镶嵌宝石信息，以及是否激活了此装备的镶嵌奖励。
 * 5. 所有自定义的数据全部移动到了usr/文件夹下，包括你的所有阵容信息，建筑信息。以后更新新版本时只需要拷贝usr/文件夹即可。
 * 6. 修复了一个建筑信息没有存储的BUG。
 * 7. 添加了一个launch.bat文件，用windows的朋友试试看双击这个文件能不能打开试炼终结者。
 * 
 * Version 3.1
 * 1. 修复了宝石相关以及技能几率相关BUG。
 * 2. 添加了1.9相关逗比忍者和两个新传说装备的数据。
 * 
 * Version 3.2
 * 1. 数据更新到2.1版本。
 * 2. 忍者选择界面修改，可以输入每个忍者的忍术抗性和洗练后的技能。
 * 3. 忍术抗性（体术）实装。(误差多少还是有点的，基本影响不大)
 * 4. 修改了一些战斗机制，如一尾现在能防住三尾了。
 * 5. 现在只免费开放一个阵容位置，另外三个阵容位置暂时不能使用。从下个版本开始，后三个阵容位置需要付费使用。
 * 
 * Version 3.3
 * 1. 十尾可以上阵了。
 * 2. 主界面调整为宽屏。
 * 3. 修正了忍术触发几率的BUG，这个BUG曾导致100层后胜率仍然经常99%。
 * 4. 添加了30星的秒杀敌首忍者选项。
 * 5. 更新了4月21日修改的新缘。
 * 
 * Version 3.4
 * 1. 修正了装备增加的技能几率的算法。修复了只能计算到120层的BUG。不同星的同一忍者上阵会触发怪力类技能。百豪等加血类技能能正确受到各种效果加成了。选中秒杀敌首忍者后，首忍者不会再被秽土转生或轮回天生错误地复活了。
 * 2. 鼠标停留在忍者大图上可以看到该忍者加成后的技能几率和效果，但是注意对面忍者是有忍术抗性的，显示出来的技能效果达100%也不会把对面打成1血，打成1血大概需要105%左右的效果。
 * 3. 旗舰版新增功能：排兵布阵。可以在任意一个阵容下调整忍者的位置，和游戏内的换位功能一样。
 * 4. 新增八门凯的数据。
 * 5. 更新了若干个技能的数值。（官方偷偷改了一些数据没告诉你们）
 * 6. “修正”了战斗机制，游戏里面任何忍者被技能打成1血后，除了夺取差值类技能，就算把对面也打成1血，自己2血，依旧会同归于尽。因此试炼终结者里的这些血量统统显示为0。（鼬神的别天神类技能有待测试）
 * 7. 封印术效果实装。
 * 
 * Version 3.5
 * 1. 自爆类技能貌似不受忍术抗性的影响？
 * 2. 默认自动存储作战建筑开启情况，每次启动的时候就不用重新开启了。此功能可以在设置菜单里取消。
 * 3. 数据更新至2.2.
 * 4. 增加新试炼的体术抗性数据，并显示在右方胜率上方。（注：APP还没更新2.2，有些数据暂时测不了，所以不能保证模拟出来的忍术效果100%准确）
 * 
 * Version 3.6
 * 1. 修正了体术抗性的计算方式。
 * 2. 默认设置里勾选了梦想模式，这个就是以前一直用的模式，这个模式下可以任意修改装备上的宝石，自动根据宝石等信息计算数值。但是该模式下需要填写的内容比较繁琐，所以当取消梦想模式后，可以直接填写忍者和装备的攻防数值，照着游戏里显示的数值填写即可，记得填写的是开启作战建筑后的数值。在选择忍者界面，会根据不同模式关闭不需要填写的内容。
 * 3. 数据更新，新增足球忍者资料。
 * 
 * Version 3.7
 * 1. 界面优化。
 * 2. 再次修正试炼各层的体术，现在应该能正确显示每层增加的体术了。
 * 2. 修复非梦想模式（现在又叫“简约模式”）不计算星星增益的BUG。
 * 3. 梦想模式和简约模式之间的切换更加显眼。
 * 4. 数据更新至2.3。
 * 5. 新增爱心小屋。
 * 6. 优化忍者信息的显示，鼠标悬停己方忍者上时可以显示该忍者的开缘情况，悬停在敌方忍者上可以看到大玉螺旋丸/地爆天星类技能需要达到多少效果才能打成1血（这个效果是加成后的，即鼠标悬停己方忍者看到的数值）。
 * 7. 修复一些小bug。
 * 8. 优化使用说明。
 * 
 * Version 3.8
 * 1. 数据更新至2.4。
 * 2. 更新使用说明。
 * 3. 添加八门遁甲的加成，不需要手动填写，程序会自动根据阵容计算开到第几门。
 * 4. （新功能预告）自动打试炼功能正在逐渐完善中。
 * 
 * Version 3.9
 * 1. 秽土柱间的明神门类技能实装。
 * 2. 数据更新至2.5。
 * 3. 阴封印和嘴遁类技能效果实装。
 * 4. 更新作者信息。
 * 
 * Version 4.0
 * 1. 120层以上第三个忍者修正成影忍。
 * 2. 优化潜力点的计算，请各位微调过剩余潜力点的朋友把剩余潜力点改回游戏里显示的数值。
 * 3. ！！！(vip)账号功能正式面世，通过菜单的账号->登陆功能，可以在此工具内登陆你的游戏账号，成功登陆后每个难度下的“挑战”按钮将有新的功能，点击任一“挑战”按钮将直接对应游戏里打对应难度的试炼，同时buff和下一层各难度队长和人数会自动更新。如果菜单里选中了观看战斗，还会在右侧文本框里显示战斗详情（但是不会自动计算下一层的胜率），取消观看战斗则会在每一层挑战成功后自动计算下一层的胜率。
 * 4. (vip)登陆的时候可以选择记住账号，你的账号将会以加密的方式存放在本地。
 * 5. (vip)终于可以自动试炼了，只需要设置一些参数用于指导你倾向的加buff和选难度的规则，就可以完全交给终结者帮你打试炼。当然前提是你不用换阵。
 * 6. 既然vip有更好的功能体验，那么以前的vip功能现在可以开放给免费用户了。现在免费版开放全部备选阵容及排兵布阵功能。
 * 7. 如果你是用launch运行终结者的，那么你将在程序初始化的时候看到一点小动画，你可以通过替换TP/loading.gif文件来更改成你喜欢的loading动画。
 * 
 * Version 4.1
 * 1. 数据更新至2.6，添加宝物装备栏，宝物数据实装。
 * 2. 修正同忍者不同星双buff加成。
 * 3. 显示八门开启情况（根据自动计算的结果）。
 * 
 * Version 4.2
 * 1. 数据更新至2.7。
 * 2. 更新战斗逻辑，优化技能数值计算。
 * 3. 中毒技能实装，轮回眼技能实装，神树降诞技能实装。
 * 4. 修复bug。
 * 
 * Version 4.3
 * 1. 数据更新至2.8。
 * 2. 修复已知bug。
 * 3. 每次自动试炼结束后统计技能触发情况。
 * 
 * Version 4.4
 * 1. 数据更新至2.9。
 * 2. 增加开宝箱功能。
 * 3. 试炼模式的进入方式略微修改，试炼结束不会自动注销，点进入试炼后可以直接开始下一次试炼。
 */
package slcomputer.main;

import slcomputer.utils.AccountInfo;
import slcomputer.runnable.SocketMaster;
import slcomputer.views.MainFrame;
import slcomputer.heros.Hero;
import slcomputer.computer.Team;
import slcomputer.computer.Skill;
import slcomputer.computer.SLData;
import slcomputer.computer.BattleField;
import slcomputer.equip.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import slcomputer.heros.*;
import slcomputer.invokelater.Emphasize;
import slcomputer.utils.DesUtils;


/**
 *
 * @author J
 */
public class SLComputer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initPublic();
        initSLTeams();
        //Utility.readTask();
        mf=new MainFrame();
        //change();
    }
    
    public static MainFrame mf;
    public static Hero[] allHero;
    public static int num6StarHero;
    public static Equip[] allEquiqAtt;
    public static Equip[] allEquiqDef;
    public static Equip[] allEqpTf;
    public static SLData QXSL;
    public static SLData FYSL;
    public static Team myTeam;
    public static Team[] backupTeams;
    public static Team teamCache;
    public static BattleField bf;
    public static Skill[] skills;
    public static int sacLevel; 
    public static int[] buildingLevel;
    public static int[] buildingEffect;
    public static int accNumber;
    public static Vector<AccountInfo> accounts;
    public static byte[] zhengzhi={105, 110, 116, 101, 103, 114, 105, 116, 121};
    public static DesUtils des;
    // configure
    public static int sNumber;
    public static boolean smartNumber;
    public static boolean smartNumber_bk;
    public static boolean saveBE;
    public static boolean dreamMode;
    public static boolean watchBattle;
    
    public static final int major=4;
    public static final int minor=4;
    public static final int vip=64;
    public static final String testVersion=".1";
    public static final int debug=1;
    public static BufferedWriter logger=null;
    public static final String usage="使用说明：\n"
            + "1. 在左上方选取试炼模式。\n"
            + "2. 在模式下方填写试炼层数，或用左右箭头修改。\n"
            + "3. 再右边一点可以填写消耗星星获得的增益效果，填写你在试炼选难度时下方显示的整数。\n"
            + "4. 选择各难度下敌我双方人数，三个难度下我方人数是自动保持一致的。\n"
            + "5. 点击“计算”按钮，可以显示出敌方阵容以及详细攻/防数值。\n"
            + "6. 下半部分可以填写你自己的阵容，包括尾兽祭坛和作战建筑。作战建筑没有或未开启选择“停止运转”即可。\n"
            + "7. 按从左往右的顺序依次点击[未选取]按钮可以选择忍者，需要填写相应的装备和等级，忍者属性，剩余潜力点，忍术抗性以及洗练过的技能，若未点过任何潜力点填写10000即可。（点了潜力点的默认潜力点没加错地方。。。若计算结果不准，请适当微调单个忍者的剩余潜力点）\n"
            + "8. 每个模式下支持保存4组阵容（免费版只支持1组），复制/粘贴阵容可以快速地帮你产生一个相同的阵容。所有阵容在每次刷新显示的时候都会自动保存。\n"
            + "9. 敌我阵容都输入完成后，点击各难度下的“挑战”按钮可以在右上方显示一次模拟战斗，但是不会计算胜率。\n"
            + "10. 敌我阵容都输入完成后，点击“试炼终结者”按钮将会每个难度模拟战斗100次（模拟次数可在设置中调整）并计算胜率，一键解决试炼难度选择问题！\n"
            + "11. 点击 排兵布阵 按钮可以进入忍者换位模式，该模式下可以交换阵容内任意两个忍者的位置，再次点击 排兵布阵 按钮退出该模式。（此功能只对旗舰版用户开放）\n"
            + "12. 设置里可以选择梦想模式（默认）或非梦想模式，梦想模式下我的阵容里的每个忍者都需要填写忍者等级、剩余潜力、装备等级、宝石等详细信息，但是填写完后每次更改建筑等级或战斗建筑开启档次，忍者的攻防都会相应更改。非梦想模式下直接填写每个忍者和装备的攻防即可，但是这个数值不会随着建筑等级和作战建筑开启档次不同而改变。\n"
            + "13. 爱心小屋在主界面右下角，这里可以放置爱心小屋里的忍者，爱心小屋的忍者可以给主阵容忍者开缘并且提供一定的攻防数值，需要填写忍者名字，属性和每个爱心小屋忍者的攻防值。\n"
            + "14. 用菜单中的账号功能可以登录你的账号，一边查阵容一边就在本工具内把试炼打了，轻松加愉快。\n"
            + "15. 登陆账号后，单个的挑战按键将变为直接打该难度下的试炼，等同于游戏里直接点某个难度打试炼，打完后所有数据会自动刷新并自动计算下一层各难度的胜率"
                + "（如果菜单里选择了观看战斗，则不会自动计算胜率，而是显示战斗详情，需要自行点一次试炼终结者计算胜率）。本工具暂时不支持调整阵容，若要调整阵容，请用手机登陆游戏进行调整。\n"
            + "16. 如果不需要换阵容无脑打试炼的话，本工具可以提供自动打试炼的功能，会根据胜率自动打胜率最高的。\n"
            + "17. 自动试炼前需要设置一些参数，用于指导自动试炼时选难度和加buff的策略，每个参数的含义可以通过“查看策略”按钮了解详情。\n"
            + "\n每次版本更新的时候，请把SLComputer/usr文件夹复制到新版本的对应位置，就可以把以前的阵容全部搬到新版本来了。\n";

    // 作者信息，若你对本程序做了任何的修改，请保留下面的信息
    public static final String author="关于作者：\n"
            + "此工具由百度贴吧<lightning2>开发，并通过百度贴吧发布，任何转载请注明【转载】。"
            + "本作者不对任何通过其他方式获取的此工具负责。\n"
            //+ "若想购买旗舰版，请参考此帖： http://tieba.baidu.com/p/3401419635 。\n"
            + "BUG提交：\n"
            + "如果你发现了程序的bug，欢迎发邮件到lightning2a@126.com，并请附上相关截图或文字信息。"
            + "如果你有好的建议或意见，也可以通过邮件联系我。谢谢支持！\n"
            + "                                lightning2\n"
            + "                              2015年1月20日\n";
    /*
    public static void change(){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("login.txt")),"UTF-8"));
            BufferedWriter bw=new BufferedWriter(new FileWriter(new File("login2.txt")));
            String line, acc1, acc2;
            while((line=br.readLine())!=null){
                if(line.indexOf(",")>0){
                    int a, b, c;
                    a=line.indexOf("\"");
                    b=line.indexOf(",");
                    c=line.lastIndexOf("\"");
                    acc1=line.substring(a+1, b-1);
                    acc2=line.substring(b+3, c);
                    if(acc1.equals(acc2)){
                        acc2="EMAIL-"+des.decrypt(acc1);
                        acc2=des.encrypt(acc2);
                    }
                    acc2=des.decrypt(acc2);
                    char cha=(char)(60-EnigmaUtil.checksum(acc2));
                    if(cha>'9') cha=(char)(cha-10);
                    acc2=des.encrypt(acc2+cha);
                    line=line.substring(0, b+3)+acc2+line.substring(c);
                }
                bw.write(line+"\n");
            }
            bw.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public static void log(String msg){
        if(debug==0){
            return;
        }
        if(logger==null){
            try {
                logger=new BufferedWriter(new FileWriter(new File("debug.txt")));
            } catch (IOException ex) {
                return;
            }
        }
        try {
            logger.write(msg+"\n");
            logger.flush();
        } catch (IOException ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Hero dupHeroById(int id){
        int i;
        if(id==12261 || id==12263){
            id=id-1000;
        }
        for(i=0; i<allHero.length; i++){
            if(allHero[i].id==id){
                return allHero[i].dup();
            }
        }
        System.out.println("Warning: couldn't find hero "+id+".");
        return null;
    }
    
    public static Equip dupAttEqById(int id){
        if(id==0){
            return new Equip();
        }
        int i;
        for(i=0; i<allEquiqAtt.length; i++){
            if(allEquiqAtt[i].id==id){
                return allEquiqAtt[i].dup();
            }
        }
        return null;
    }
    
    public static Equip dupDefEqById(int id){
        if(id==0){
            return new Equip();
        }
        int i;
        for(i=0; i<allEquiqDef.length; i++){
            if(allEquiqDef[i].id==id){
                return allEquiqDef[i].dup();
            }
        }
        return null;
    }
    
    public static Equip dupTfEqById(int id){
        if(id==0){
            return new Equip();
        }
        int i;
        for(i=0; i<allEqpTf.length; i++){
            if(allEqpTf[i].id==id){
                return allEqpTf[i].dup();
            }
        }
        return null;
    }
    
    public static Equip findEquipById(int id){
        if(id==0){
            return null;
        }
        int i;
        for(i=0; i<allEquiqAtt.length; i++){
            if(allEquiqAtt[i].id==id){
                return allEquiqAtt[i];
            }
        }
        for(i=0; i<allEquiqDef.length; i++){
            if(allEquiqDef[i].id==id){
                return allEquiqDef[i];
            }
        }
        for(i=0; i<allEqpTf.length; i++){
            if(allEqpTf[i].id==id){
                return allEqpTf[i];
            }
        }
        return null;
    }
    
    public static Equip findEquipByName(String name){
        if(name==null){
            return null;
        }
        int i;
        for(i=allEquiqAtt.length-1; i>=0; i--){
            if(allEquiqAtt[i].name.equals(name)){
                return allEquiqAtt[i];
            }
        }
        for(i=allEquiqDef.length-1; i>=0; i--){
            if(allEquiqDef[i].name.equals(name)){
                return allEquiqDef[i];
            }
        }
        for(i=allEqpTf.length-1; i>=0; i--){
            if(allEqpTf[i].name.equals(name)){
                return allEqpTf[i];
            }
        }
        return null;
    }
    
    public static Skill findSkill(int id){
        int i;
        for(i=0; i<skills.length; i++){
            if(skills[i].id==id){
                return skills[i];
            }
        }
        System.out.println("Warning: Cannot find skill "+id);
        return null;
    }
    
    public static void saveTeamToFile(Team t){
        int i;
        if(t.numberMax==0){
            return;
        }
        for(i=0; i<backupTeams.length; i++){
            if(backupTeams[i]==t){
                break;
            }
        }
        File f=new File("usr/team"+i);
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter(f));
            br.write(""+t.numberMax+"\n");
            for(i=0; i<5; i++){
                br.write(""+t.pet[i]+"\n");
                br.write(""+t.petLevel[i]+"\n");
            }
            for(i=0; i<t.numberMax; i++){
                br.write(""+t.heros[i].id+"\n");
                br.write(""+t.heros[i].level+"\n");
                if(t.heros[i].weapon!=null){
                    br.write(""+t.heros[i].weapon.id+"\n");
                    br.write(""+t.heros[i].weapon.level+"\n");
                    br.write("diamond\n");
                    br.write(t.heros[i].weapon.diamond[0]+"\n");
                    br.write(t.heros[i].weapon.diamondLevel[0]+"\n");
                    br.write(t.heros[i].weapon.diamond[1]+"\n");
                    br.write(t.heros[i].weapon.diamondLevel[1]+"\n");
                    br.write(t.heros[i].weapon.diamond[2]+"\n");
                    br.write(t.heros[i].weapon.diamondLevel[2]+"\n");
                    br.write(t.heros[i].weapon.diamond[3]+"\n");
                    br.write(t.heros[i].weapon.diamondLevel[3]+"\n");
                    br.write(t.heros[i].weapon.propertyEnabled+"\n");
                    br.write("step\n");
                    br.write(t.heros[i].weapon.step+"\n");
                }
                else{
                    br.write("0\n1\n");
                }
                if(t.heros[i].shield!=null){
                    br.write(""+t.heros[i].shield.id+"\n");
                    br.write(""+t.heros[i].shield.level+"\n");
                    br.write("diamond\n");
                    br.write(t.heros[i].shield.diamond[0]+"\n");
                    br.write(t.heros[i].shield.diamondLevel[0]+"\n");
                    br.write(t.heros[i].shield.diamond[1]+"\n");
                    br.write(t.heros[i].shield.diamondLevel[1]+"\n");
                    br.write(t.heros[i].shield.diamond[2]+"\n");
                    br.write(t.heros[i].shield.diamondLevel[2]+"\n");
                    br.write(t.heros[i].shield.diamond[3]+"\n");
                    br.write(t.heros[i].shield.diamondLevel[3]+"\n");
                    br.write(t.heros[i].shield.propertyEnabled+"\n");
                    br.write("step\n");
                    br.write(t.heros[i].shield.step+"\n");
                }
                else{
                    br.write("0\n1\n");
                }
                if(t.heros[i].pact!=null){
                    br.write(""+t.heros[i].pact.id+"\n");
                    br.write(""+t.heros[i].pact.level+"\n");
                    br.write("diamond\n");
                    br.write(t.heros[i].pact.diamond[0]+"\n");
                    br.write(t.heros[i].pact.diamondLevel[0]+"\n");
                    br.write(t.heros[i].pact.diamond[1]+"\n");
                    br.write(t.heros[i].pact.diamondLevel[1]+"\n");
                    br.write(t.heros[i].pact.diamond[2]+"\n");
                    br.write(t.heros[i].pact.diamondLevel[2]+"\n");
                    br.write(t.heros[i].pact.diamond[3]+"\n");
                    br.write(t.heros[i].pact.diamondLevel[3]+"\n");
                    br.write(t.heros[i].pact.propertyEnabled+"\n");
                    br.write("step\n");
                    br.write(t.heros[i].pact.step+"\n");
                }
                else{
                    br.write("0\n1\n");
                }
                br.write("resist\n");
                br.write(t.heros[i].resist+"\n");
                br.write("skills\n");
                br.write(t.heros[i].skillIndex1+"\n");
                br.write(t.heros[i].skillIndex2+"\n");
                br.write("set\n");
                br.write(t.heros[i].attSet+"\n");
                br.write(t.heros[i].defSet+"\n");
                br.write(t.heros[i].weaponAttSet+"\n");
                br.write(t.heros[i].weaponDefSet+"\n");
                br.write(t.heros[i].weaponEffSet+"\n");
                br.write(t.heros[i].shieldAttSet+"\n");
                br.write(t.heros[i].shieldDefSet+"\n");
                br.write(t.heros[i].shieldEffSet+"\n");
                br.write(""+t.heros[i].property_battle+"\n");
                br.write(""+t.heros[i].potential+"\n");
            }
            br.write("loveHut\n");
            br.write(t.backNumber+"\n");
            for(i=0; i<t.backNumber; i++){
                br.write(t.backHeros[i].id+"\n");
                br.write(t.backHeros[i].property_battle+"\n");
                br.write(t.backHeros[i].att+"\n");
                br.write(t.backHeros[i].def+"\n");
            }
            //br.write(sacLevel+"\n");
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readTeamFromFile(Team t, int index){
        if(t==null){
            t=new Team();
        }
        File f=new File("usr/team"+index);
        if(!f.isFile() || !f.exists()){
            return;
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=br.readLine();
            int i, tmp=0;
            tmp=Integer.parseInt(s);
            t.number=t.numberMax=tmp;
            for(i=0; i<5; i++){
                s=br.readLine();
                t.pet[i]=Integer.parseInt(s);
                s=br.readLine();
                t.petLevel[i]=Integer.parseInt(s);
            }
            for(i=0; i<t.numberMax; i++){
                s=br.readLine();
                tmp=Integer.parseInt(s);
                t.heros[i]=dupHeroById(tmp);
                s=br.readLine();
                t.heros[i].level=Integer.parseInt(s);
                s=br.readLine();
                tmp=Integer.parseInt(s);
                t.heros[i].weapon=dupAttEqById(tmp);
                s=br.readLine();
                t.heros[i].weapon.level=Integer.parseInt(s);
                s=br.readLine();
                // read diamond information
                if(s.indexOf("diamond")>=0){
                    s=br.readLine();
                    t.heros[i].weapon.diamond[0]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamondLevel[0]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamond[1]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamondLevel[1]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamond[2]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamondLevel[2]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamond[3]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.diamondLevel[3]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].weapon.propertyEnabled=Boolean.parseBoolean(s);
                    s=br.readLine();
                }
                // read step information
                if(s.indexOf("step")>=0){
                    s=br.readLine();
                    t.heros[i].weapon.step=Integer.parseInt(s);
                    s=br.readLine();
                }
                tmp=Integer.parseInt(s);
                t.heros[i].shield=dupDefEqById(tmp);
                s=br.readLine();
                t.heros[i].shield.level=Integer.parseInt(s);
                s=br.readLine();
                // read diamond information
                if(s.indexOf("diamond")>=0){
                    s=br.readLine();
                    t.heros[i].shield.diamond[0]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamondLevel[0]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamond[1]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamondLevel[1]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamond[2]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamondLevel[2]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamond[3]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.diamondLevel[3]=Integer.parseInt(s);
                    s=br.readLine();
                    t.heros[i].shield.propertyEnabled=Boolean.parseBoolean(s);
                    s=br.readLine();
                }
                // read step information
                if(s.indexOf("step")>=0){
                    s=br.readLine();
                    t.heros[i].shield.step=Integer.parseInt(s);
                    s=br.readLine();
                }
                if(s.indexOf("resist")<0){
                    tmp=Integer.parseInt(s);
                    t.heros[i].pact=dupTfEqById(tmp);
                    s=br.readLine();
                    t.heros[i].pact.level=Integer.parseInt(s);
                    s=br.readLine();
                    // read diamond information
                    if(s.indexOf("diamond")>=0){
                        s=br.readLine();
                        t.heros[i].pact.diamond[0]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamondLevel[0]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamond[1]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamondLevel[1]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamond[2]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamondLevel[2]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamond[3]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.diamondLevel[3]=Integer.parseInt(s);
                        s=br.readLine();
                        t.heros[i].pact.propertyEnabled=Boolean.parseBoolean(s);
                        s=br.readLine();
                    }
                    // read step information
                    if(s.indexOf("step")>=0){
                        s=br.readLine();
                        t.heros[i].pact.step=Integer.parseInt(s);
                        s=br.readLine();
                    }
                }
                else{
                    t.heros[i].pact=new EqpHJPK();
                }
                if(s.indexOf("resist")>=0){
                    s=br.readLine();
                    t.heros[i].resist=Double.parseDouble(s);
                    s=br.readLine();
                }
                if(s.indexOf("skills")>=0){
                    s=br.readLine();
                    t.heros[i].skillIndex1=Integer.parseInt(s);
                    if(t.heros[i].skillIndex1>=0){
                        t.heros[i].skill1=t.heros[i].backupSkills[t.heros[i].skillIndex1];
                    }
                    s=br.readLine();
                    t.heros[i].skillIndex2=Integer.parseInt(s);
                    if(t.heros[i].skillIndex2>=0){
                        t.heros[i].skill2=t.heros[i].backupSkills[t.heros[i].skillIndex2];
                    }
                    s=br.readLine();
                }
                if(s.indexOf("set")>=0){
                    s=br.readLine();
                    t.heros[i].attSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].defSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].weaponAttSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].weaponDefSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].weaponEffSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].shieldAttSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].shieldDefSet=Double.parseDouble(s);
                    s=br.readLine();
                    t.heros[i].shieldEffSet=Double.parseDouble(s);
                    s=br.readLine();
                }
                t.heros[i].property_battle=Integer.parseInt(s);
                s=br.readLine();
                t.heros[i].potential=Double.parseDouble(s);
            }
            s=br.readLine();
            if(s!=null && s.indexOf("loveHut")>=0){
                s=br.readLine();
                t.backNumber=Integer.parseInt(s);
                for(i=0; i<t.backNumber; i++){
                    s=br.readLine();
                    tmp=Integer.parseInt(s);
                    t.backHeros[i]=dupHeroById(tmp);
                    s=br.readLine();
                    t.backHeros[i].property_battle=Integer.parseInt(s);
                    s=br.readLine();
                    t.backHeros[i].att=Double.parseDouble(s);
                    s=br.readLine();
                    t.backHeros[i].def=Double.parseDouble(s);
                }
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveBuildingsToFile(){
        int i;
        File f=new File("usr/buildings");
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter(f));
            br.write(12+"\n");
            for(i=0; i<6; i++){
                br.write(i+"\n");
                br.write(buildingLevel[i]+"\n");
            }
            if(saveBE){
                for(i=6; i<12; i++){
                    br.write(i+"\n");
                    br.write(buildingEffect[i-6]+"\n");
                }
            }
            else{
                for(i=6; i<12; i++){
                    br.write(i+"\n");
                    br.write(0+"\n");
                }
            }
            br.write(-1+"\n");
            br.write(sacLevel+"\n");
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readBuildingsFromFile(){
        File f=new File("usr/buildings");
        if(!f.isFile() || !f.exists()){
            for(int k=0; k<6; k++){
                buildingLevel[k]=0;
                buildingEffect[k]=0;
            }
            return;
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=br.readLine();
            int i, j, tmp;
            j=Integer.parseInt(s);
            for(i=0; i<j+1; i++){
                s=br.readLine();
                tmp=Integer.parseInt(s);
                s=br.readLine();
                if(tmp>=0){
                    if(tmp<6){
                        buildingLevel[tmp]=Integer.parseInt(s);
                    }
                    else if(tmp<12){
                        buildingEffect[tmp-6]=Integer.parseInt(s);
                    }
                }
                else{
                    sacLevel=Integer.parseInt(s);
                }
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveConfigToFile(){
        int i;
        File f=new File("usr/config");
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter(f));
            br.write("sNumber:"+sNumber+"\n");
            br.write("smartNumber:"+smartNumber+"\n");
            br.write("saveBE:"+saveBE+"\n");
            br.write("dreamMode:"+dreamMode+"\n");
            br.write("watchBattle:"+watchBattle+"\n");
            br.write("end\n");
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readConfigFromFile(){
        sNumber=0;
        smartNumber=true;
        saveBE=true;
        dreamMode=true;
        watchBattle=false;
        File f=new File("usr/config");
        if(!f.isFile() || !f.exists()){
            return;
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=br.readLine();
            int i, j, tmp=0;
            while(s!=null && s.indexOf("end")<0){
                if((i=s.indexOf("sNumber"))>=0){
                    sNumber=Integer.parseInt(s.substring(s.indexOf(":")+1));
                }
                else if((i=s.indexOf("smartNumber"))>=0){
                    smartNumber=Boolean.parseBoolean(s.substring(s.indexOf(":")+1));
                }
                else if((i=s.indexOf("saveBE"))>=0){
                    saveBE=Boolean.parseBoolean(s.substring(s.indexOf(":")+1));
                }
                else if((i=s.indexOf("dreamMode"))>=0){
                    dreamMode=Boolean.parseBoolean(s.substring(s.indexOf(":")+1));
                }
                else if((i=s.indexOf("watchBattle"))>=0){
                    watchBattle=Boolean.parseBoolean(s.substring(s.indexOf(":")+1));
                }
                s=br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveAccToFile(){
        if(des==null){
            return;
        }
        int i=0;
        File f=new File("usr/accounts");
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter(f));
            for(AccountInfo s:accounts){
                if(i++==0){
                    continue;
                }
                if(!s.usr.equals("")){
                    String encoded="";
                    try{
                        encoded=s.convert();
                    }
                    catch(Exception e){
                        continue;
                    }
                    br.write(encoded+"\n");
                }
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readAccFromFile() throws Exception{
        accNumber=0;
        accounts=new Vector<AccountInfo>();
        AccountInfo ai=new AccountInfo();
        accounts.add(ai);
        des=new DesUtils(new String(zhengzhi));
        File f=new File("usr/accounts");
        if(!f.isFile() || !f.exists()){
            return;
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=br.readLine();
            String[] split;
            while(s!=null){
                if(!s.equals("")){
                    ai=new AccountInfo();
                    try{
                        split=des.decrypt(s).split(":");
                    }catch(Exception e){
                        s=br.readLine();
                        continue;
                    }
                    if(split.length>=1){
                        ai.usr=split[0];
                        if(split.length>=2){
                            ai.fwq=Integer.parseInt(split[1]);
                            if(split.length>=3){
                                ai.psd=des.decrypt(split[2]);
                            }
                        }
                    }
                    accounts.add(ai);
                    if(accNumber==0){
                        accounts.elementAt(0).setAll(ai.usr, ai.psd, ai.fwq);
                    }
                    accNumber++;
                }
                s=br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateAcc(String usr, String psd, int fwq){
        int index=0;
        for(AccountInfo acc:accounts){
            if(index!=0){
                if(acc.usr.equals(usr) && acc.fwq==fwq){
                    if(!acc.psd.equals(psd)){
                        acc.psd=psd;
                        saveAccToFile();
                    }
                    return;
                }
            }
            index++;
        }
        AccountInfo account=new AccountInfo();
        account.usr=usr;
        account.psd=psd;
        account.fwq=fwq;
        accounts.add(account);
        saveAccToFile();
    }
    
    public static void cleanBB(boolean remainLogin){
        Emphasize buttons=new Emphasize(remainLogin, false);
        SwingUtilities.invokeLater(buttons);
        SocketMaster.globalBBReady=false;
    }
    
    public static void cleanLogin(){
        SocketMaster.globalCer=0;
        SocketMaster.globalID=0;
        SocketMaster.globalName="";
        smartNumber=smartNumber_bk;
        cleanBB(false);
        try{
            if(SocketMaster.isStatic!=null){
                SocketMaster.isStatic.close();
                SocketMaster.isStatic=null;
            }
            if(SocketMaster.osStatic!=null){
                SocketMaster.osStatic.close();
                SocketMaster.osStatic=null;
            }
            if(SocketMaster.clientStatic!=null){
                SocketMaster.clientStatic.close();
                SocketMaster.clientStatic=null;
            }
        }catch(Exception e){
            SocketMaster.isStatic=null;
            SocketMaster.osStatic=null;
            SocketMaster.clientStatic=null;
        }
        SocketMaster.globalReady=false;
    }
    
    public static double toughExp2Tough(double exp){
        double tough=0;
        if(exp>=9000){
            tough=2750;
        }
        else if(exp>=7000){
            tough=2250;
        }
        else if(exp>=5300){
            tough=1800;
        }
        else if(exp>=3900){
            tough=1400;
        }
        else if(exp>=2750){
            tough=1050;
        }
        else if(exp>=1850){
            tough=750;
        }
        else if(exp>=1150){
            tough=500;
        }
        else if(exp>=650){
            tough=300;
        }
        else if(exp>=300){
            tough=150;
        }
        else if(exp>=100){
            tough=50;
        }
        return tough;
    }
    
    public static void initSLTeams(){
        QXSL=new SLData();
        FYSL=new SLData();
        FYSL.teamsHard=new Team[32];
        FYSL.teamsNorm=new Team[32];
        FYSL.teamsEasy=new Team[22];
        QXSL.teamsHard=new Team[31];
        QXSL.teamsNorm=new Team[32];
        QXSL.teamsEasy=new Team[22];
        File f=new File("bb_1.json");
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            String line;
            int k, i, j;
            while((line=br.readLine())!=null){
                k=line.indexOf("basePlus");
                if(k>=0){
                    line=br.readLine();
                    line=line.trim();
                    FYSL.basePlus[FYSL.maxLevel][0]=Double.parseDouble(line.substring(0, line.length()-1));
                    line=br.readLine();
                    line=line.trim();
                    FYSL.basePlus[FYSL.maxLevel][1]=Double.parseDouble(line.substring(0, line.length()-1));
                    line=br.readLine();
                    line=line.trim();
                    FYSL.basePlus[FYSL.maxLevel][2]=Double.parseDouble(line);
                    line=br.readLine();
                    line=br.readLine();
                    i=line.indexOf(":");
                    j=line.indexOf(",");
                    FYSL.skillPower[FYSL.maxLevel]=Double.parseDouble(line.substring(i+1, j));
                    line=br.readLine();
                    i=line.indexOf(":");
                    j=line.indexOf(",");
                    FYSL.skillRate[FYSL.maxLevel]=Double.parseDouble(line.substring(i+1, j));
                }
                else if(line.indexOf("bodySkillPlus")>=0){
                    line=br.readLine();
                    line=line.trim();
                    FYSL.bodySkill[FYSL.maxLevel][0]=toughExp2Tough(Double.parseDouble(line.substring(0, line.length()-1)));
                    line=br.readLine();
                    line=line.trim();
                    FYSL.bodySkill[FYSL.maxLevel][1]=toughExp2Tough(Double.parseDouble(line.substring(0, line.length()-1)));
                    line=br.readLine();
                    line=line.trim();
                    FYSL.bodySkill[FYSL.maxLevel++][2]=toughExp2Tough(Double.parseDouble(line));
                    //System.out.println("Level "+FYSL.maxLevel);
                    //System.out.println(FYSL.bodySkill[FYSL.maxLevel-1][0]+"\t"+FYSL.bodySkill[FYSL.maxLevel-1][1]+"\t"+FYSL.bodySkill[FYSL.maxLevel-1][2]);
                }
            }
            //System.out.println("FYSL maxLevel="+FYSL.maxLevel);
            br.close();
            f=new File("bb_0.json");
            br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            while((line=br.readLine())!=null){
                k=line.indexOf("basePlus");
                if(k>=0){
                    line=br.readLine();
                    line=line.trim();
                    QXSL.basePlus[QXSL.maxLevel][0]=Double.parseDouble(line.substring(0, line.length()-1));
                    line=br.readLine();
                    line=line.trim();
                    QXSL.basePlus[QXSL.maxLevel][1]=Double.parseDouble(line.substring(0, line.length()-1));
                    line=br.readLine();
                    line=line.trim();
                    QXSL.basePlus[QXSL.maxLevel][2]=Double.parseDouble(line);
                    line=br.readLine();
                    line=br.readLine();
                    i=line.indexOf(":");
                    j=line.indexOf(",");
                    QXSL.skillPower[QXSL.maxLevel]=Double.parseDouble(line.substring(i+1, j));
                    line=br.readLine();
                    i=line.indexOf(":");
                    j=line.indexOf(",");
                    QXSL.skillRate[QXSL.maxLevel]=Double.parseDouble(line.substring(i+1, j));
                }
                else if(line.indexOf("bodySkillPlus")>=0){
                    line=br.readLine();
                    line=line.trim();
                    QXSL.bodySkill[QXSL.maxLevel][0]=toughExp2Tough(Double.parseDouble(line.substring(0, line.length()-1)));
                    line=br.readLine();
                    line=line.trim();
                    QXSL.bodySkill[QXSL.maxLevel][1]=toughExp2Tough(Double.parseDouble(line.substring(0, line.length()-1)));
                    line=br.readLine();
                    line=line.trim();
                    QXSL.bodySkill[QXSL.maxLevel++][2]=toughExp2Tough(Double.parseDouble(line));
                }
            }
            //System.out.println("QXSL maxLevel="+QXSL.maxLevel);
            br.close();
            f=new File("bb_npc.json");
            br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            Team[] tmpTeam;
            int teamIndex;
            while((line=br.readLine())!=null){
                k=line.indexOf("\"");
                if(k<0){
                    continue;
                }
                tmpTeam=null;
                teamIndex=Integer.parseInt(line.substring(k+1, k+7));
                i=teamIndex/100;
                j=teamIndex%100-1;
                switch(i){
                    case 8150:
                        tmpTeam=FYSL.teamsHard;
                        break;
                    case 8250:
                        tmpTeam=FYSL.teamsNorm;
                        break;
                    case 8350:
                        tmpTeam=FYSL.teamsEasy;
                        break;
                    case 8450:
                        tmpTeam=QXSL.teamsHard;
                        break;
                    case 8550:
                        tmpTeam=QXSL.teamsNorm;
                        break;
                    case 8650:
                        tmpTeam=QXSL.teamsEasy;
                        break;
                    default:
                        break;
                }
                if(tmpTeam==null){
                    continue;
                }
                line=br.readLine();
                tmpTeam[j]=new Team();
                Hero tmpHero;
                while(line.indexOf("],")<0){
                    line=br.readLine();     // hero id
                    line=line.trim();
                    k=Integer.parseInt(line.substring(0, line.indexOf(",")));
                    tmpHero=dupHeroById(k);
                    line=br.readLine();     // hero level
                    line=br.readLine();     // weapon id
                    line=line.trim();
                    k=Integer.parseInt(line.substring(0, line.indexOf(",")));
                    tmpHero.weapon=dupAttEqById(k);
                    line=br.readLine();     // weapon level
                    line=br.readLine();     // shield id
                    line=line.trim();
                    k=Integer.parseInt(line.substring(0, line.indexOf(",")));
                    tmpHero.shield=dupDefEqById(k);
                    line=br.readLine();     // shield level
                    if(line.indexOf(",")>0){
                        line=br.readLine();
                    }
                    tmpTeam[j].heros[tmpTeam[j].numberMax++]=tmpHero;
                    line=br.readLine();     // "]"
                    line=br.readLine();     // "[" or "],"
                }
                //System.out.println("number: "+tmpTeam[j].numberMax);
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void initPublic(){
        File f=new File("usr");
        if(!f.exists() || f.isFile()){
            f.mkdir();
        }
        int heroNumber=457;
        int equipAttNumber=93;
        int equipDefNumber=90;
        int eqpTfNumber=90;
        int backupNumber=8;
        int i;
        allHero=new Hero[heroNumber+1];
        allEquiqAtt=new Equip[equipAttNumber+1];
        allEquiqDef=new Equip[equipDefNumber+1];
        allEqpTf=new Equip[eqpTfNumber+1];
        // Heros
        i=0;
        allHero[i++]=new HeroQSZJ_6(1);  // 五星升六星开始：千手柱间
        allHero[i++]=new HeroQSFJ_6(1);
        allHero[i++]=new HeroBFSM_6(1);
        allHero[i++]=new HeroZLY_6(1);
        allHero[i++]=new HeroYZBY_6(1);
        allHero[i++]=new HeroDSW_6(1);
        allHero[i++]=new HeroQSGS_6(1);
        allHero[i++]=new HeroYFRZ_6(1);
        allHero[i++]=new HeroYZBDT_6(1);
        allHero[i++]=new HeroXWCM_6(1);
        allHero[i++]=new HeroZCTZ_6(1);
        allHero[i++]=new HeroZMM_6(1);
        allHero[i++]=new HeroSJYBZ_6(1);
        allHero[i++]=new HeroYZBB_6(1);
        allHero[i++]=new HeroSDLY_6(1);
        allHero[i++]=new HeroDSD_6(1);
        allHero[i++]=new HeroMJN_6(1);
        allHero[i++]=new HeroSWRZL_6(1);
        allHero[i++]=new HeroJMKMR_6(1);
        allHero[i++]=new HeroXZZZ_6(1);
        allHero[i++]=new HeroJJ_6(1);
        allHero[i++]=new HeroYJ_6(1);
        allHero[i++]=new HeroXY_6(1);
        allHero[i++]=new HeroFYWAL_6(1);
        allHero[i++]=new HeroABGJ_6(1);
        allHero[i++]=new HeroABZBZ_6(1);
        allHero[i++]=new HeroSDRZ_6(1);
        allHero[i++]=new HeroXRZJ_6(1);
        allHero[i++]=new HeroSanC_6(1);
        allHero[i++]=new HeroJWSM_6(1);
        allHero[i++]=new HeroFHXX_6(1);
        allHero[i++]=new HeroFHNT_6(1);
        allHero[i++]=new HeroBWQLB_6(1);
        allHero[i++]=new HeroLYA_6(1);
        allHero[i++]=new HeroTYDX_6(1);
        allHero[i++]=new HeroCT_6(1);
        allHero[i++]=new HeroMRTT_6(1);
        allHero[i++]=new HeroSMTT_6(1);
        allHero[i++]=new HeroZSY_6(1);
        allHero[i++]=new HeroXRZLY_6(1);
        allHero[i++]=new HeroYZBZS_6(1);
        allHero[i++]=new HeroLDB_6(1);
        allHero[i++]=new HeroXWSH_6(1);
        allHero[i++]=new HeroYZBQN_6(1);
        allHero[i++]=new HeroSNKKX_6(1);
        allHero[i++]=new HeroBMK_6(1);
        allHero[i++]=new HeroRZSJ_6(1);
        allHero[i++]=new HeroRZKJL_6(1);
        allHero[i++]=new HeroSHGJ_6(1);
        allHero[i++]=new HeroZYZW_6(1);
        allHero[i++]=new HeroZYJML_6(1);
        allHero[i++]=new HeroWS_6(1);
        allHero[i++]=new HeroYM_6(1);
        allHero[i++]=new HeroSZXR_6(1);
        allHero[i++]=new HeroZMXR_6(1);
        allHero[i++]=new HeroSanDFY_6(1);
        allHero[i++]=new HeroSRLW_6(1);
        allHero[i++]=new HeroSRNC_6(1);
        allHero[i++]=new HeroBHGS_6(1);
        allHero[i++]=new HeroZJi_6(1);
        allHero[i++]=new HeroTLY_6(1);
        allHero[i++]=new HeroS_6(1);
        allHero[i++]=new HeroYC_6(1);
        allHero[i++]=new HeroBLH_6(1);
        allHero[i++]=new HeroD_6(1);
        allHero[i++]=new HeroZQRZ_6(1);
        allHero[i++]=new HeroLDPE_6(1);
        allHero[i++]=new HeroLHCM_6(1);
        allHero[i++]=new HeroHTZJ_6(1);
        allHero[i++]=new HeroHTFJ_6(1);
        allHero[i++]=new HeroHTYF_6(1);
        allHero[i++]=new HeroHTSM_6(1);
        allHero[i++]=new HeroHTJD_6(1);
        allHero[i++]=new HeroHTQD_6(1);
        allHero[i++]=new HeroHTASM_6(1);
        allHero[i++]=new HeroHTDDL_6(1);
        allHero[i++]=new HeroHTX_6(1);
        allHero[i++]=new HeroBSFD_6(1);
        allHero[i++]=new HeroZYZZ_6(1);
        allHero[i++]=new HeroBLDSW_6(1);
        allHero[i++]=new HeroMYDT_6(1);
        allHero[i++]=new HeroSWKKX_6(1);
        allHero[i++]=new HeroYZBTD_6(1);
        allHero[i++]=new HeroQSFoJ_6(1);
        allHero[i++]=new HeroBHXY_6(1);
        allHero[i++]=new HeroXRMR_6(1);
        allHero[i++]=new HeroDHMXR_6(1);
        allHero[i++]=new HeroHTB_6(1);
        allHero[i++]=new HeroLYDLY_6(1);
        allHero[i++]=new HeroCDLY_6(1);
        allHero[i++]=new HeroEDLY_6(1);
        allHero[i++]=new HeroCDSY_6(1);
        allHero[i++]=new HeroSDSY_6(1);
        allHero[i++]=new HeroSYCSL_6(1);
        allHero[i++]=new HeroCDTY_6(1);
        allHero[i++]=new HeroHuangT_6(1);
        allHero[i++]=new HeroTYHT_6(1);
        allHero[i++]=new HeroCDFY_6(1);
        allHero[i++]=new HeroEDFY_6(1);
        allHero[i++]=new HeroHYMR_6(1);
        allHero[i++]=new HeroDTMHY_6(1);
        allHero[i++]=new HeroLDXR_6(1);
        allHero[i++]=new HeroDTMYC_6(1);
        allHero[i++]=new HeroAXL_6(1);
        allHero[i++]=new HeroYTL_6(1);
        allHero[i++]=new HeroXTMR_6(1);
        allHero[i++]=new HeroXYZZ_6(1);
        allHero[i++]=new HeroCJRZ_6(1);
        allHero[i++]=new HeroMYZZ_6(1);
        allHero[i++]=new HeroDTMSR_6(1);
        allHero[i++]=new HeroXZY_6(1);
        allHero[i++]=new HeroHYKKX_6(1);
        allHero[i++]=new HeroQMKKX_6(1);  // 四星升六星开始：旗木卡卡西
        allHero[i++]=new HeroYFASM_6(1);
        allHero[i++]=new HeroGSGJ_6(1);
        allHero[i++]=new HeroMKK_6(1);
        allHero[i++]=new HeroTDZBZ_6(1);
        allHero[i++]=new HeroPE_6(1);
        allHero[i++]=new HeroXN_6(1);
        allHero[i++]=new HeroJ_6(1);
        allHero[i++]=new HeroDH_6(1);
        allHero[i++]=new HeroMJ_6(1);
        allHero[i++]=new HeroQDPP_6(1);
        allHero[i++]=new HeroCSL_6(1);
        allHero[i++]=new HeroA_6(1);
        allHero[i++]=new HeroQLB_6(1);
        allHero[i++]=new HeroYSD_6(1);
        allHero[i++]=new HeroHYJML_6(1);
        allHero[i++]=new HeroX_6(1);
        allHero[i++]=new HeroDDL_6(1);
        allHero[i++]=new HeroFD_6(1);
        allHero[i++]=new HeroJD_6(1);
        allHero[i++]=new HeroXWJXN_6(1);
        allHero[i++]=new HeroW_6(1);
        allHero[i++]=new HeroEDSY_6(1);
        allHero[i++]=new HeroSDFY_6(1);
        allHero[i++]=new HeroLTCDX_6(1);
        allHero[i++]=new HeroEWYMR_6(1);
        allHero[i++]=new HeroSC_6(1);
        allHero[i++]=new HeroLZ_6(1);
        allHero[i++]=new HeroF_6(1);
        allHero[i++]=new HeroYG_6(1);
        allHero[i++]=new HeroFu_6(1);
        allHero[i++]=new HeroQMSM_6(1);
        allHero[i++]=new HeroYNZW_6(1);
        allHero[i++]=new HeroLQYYL_6(1);
        allHero[i++]=new HeroLSCW_6(1);
        allHero[i++]=new HeroGDMY_6(1);
        allHero[i++]=new HeroWLSB_6(1);
        allHero[i++]=new HeroHTG_6(1);
        allHero[i++]=new HeroTCYSR_6(1);
        allHero[i++]=new HeroYZBZZ_6(1);
        allHero[i++]=new HeroCYY_6(1);
        allHero[i++]=new HeroXWMR_6(1);
        allHero[i++]=new HeroWAL_6(1);
        allHero[i++]=new HeroQJSTF_6(1);
        allHero[i++]=new HeroLYXB_6(1);
        allHero[i++]=new HeroHYCX_6(1);
        allHero[i++]=new HeroDXBY_6(1);
        allHero[i++]=new HeroHT_6(1);
        allHero[i++]=new HeroTTai_6(1);
        allHero[i++]=new HeroSNYBX_6(1);
        allHero[i++]=new HeroHL_6(1);
        allHero[i++]=new HeroKY_6(1);
        allHero[i++]=new HeroHMWT_6(1);
        allHero[i++]=new HeroHMG_6(1);
        allHero[i++]=new HeroHMJ_6(1);
        allHero[i++]=new HeroFY_6(1);
        allHero[i++]=new HeroSJY_6(1);
        allHero[i++]=new HeroXWBR_6(1);
        num6StarHero=i;
        allHero[i++]=new HeroQSZJ(1);  // 五星开始：千手柱间
        allHero[i++]=new HeroQSFJ(1);
        allHero[i++]=new HeroBFSM(1);
        allHero[i++]=new HeroZLY(1);
        allHero[i++]=new HeroYZBY(1);
        allHero[i++]=new HeroDSW(1);
        allHero[i++]=new HeroQSGS(1);
        allHero[i++]=new HeroYFRZ(1);
        allHero[i++]=new HeroYZBDT(1);
        allHero[i++]=new HeroXWCM(1);
        allHero[i++]=new HeroZCTZ(1);
        allHero[i++]=new HeroZMM(1);
        allHero[i++]=new HeroSJYBZ(1);
        allHero[i++]=new HeroYZBB(1);
        allHero[i++]=new HeroSDLY(1);
        allHero[i++]=new HeroDSD(1);
        allHero[i++]=new HeroMJN(1);
        allHero[i++]=new HeroSWRZL(1);
        allHero[i++]=new HeroJMKMR(1);
        allHero[i++]=new HeroXZZZ(1);
        allHero[i++]=new HeroJJ(1);
        allHero[i++]=new HeroYJ(1);
        allHero[i++]=new HeroXY(1);
        allHero[i++]=new HeroFYWAL(1);
        allHero[i++]=new HeroABGJ(1);
        allHero[i++]=new HeroABZBZ(1);
        allHero[i++]=new HeroSDRZ(1);
        allHero[i++]=new HeroXRZJ(1);
        allHero[i++]=new HeroSanC(1);
        allHero[i++]=new HeroJWSM(1);
        allHero[i++]=new HeroFHXX(1);
        allHero[i++]=new HeroFHNT(1);
        allHero[i++]=new HeroBWQLB(1);
        allHero[i++]=new HeroLYA(1);
        allHero[i++]=new HeroTYDX(1);
        allHero[i++]=new HeroCT(1);
        allHero[i++]=new HeroMRTT(1);
        allHero[i++]=new HeroSMTT(1);
        allHero[i++]=new HeroZSY(1);
        allHero[i++]=new HeroXRZLY(1);
        allHero[i++]=new HeroYZBZS(1);
        allHero[i++]=new HeroLDB(1);
        allHero[i++]=new HeroXWSH(1);
        allHero[i++]=new HeroYZBQN(1);
        allHero[i++]=new HeroSNKKX(1);
        allHero[i++]=new HeroBMK(1);
        allHero[i++]=new HeroRZSJ(1);
        allHero[i++]=new HeroRZKJL(1);
        allHero[i++]=new HeroSHGJ(1);
        allHero[i++]=new HeroZYZW(1);
        allHero[i++]=new HeroZYJML(1);
        allHero[i++]=new HeroWS(1);
        allHero[i++]=new HeroYM(1);
        allHero[i++]=new HeroSZXR(1);
        allHero[i++]=new HeroZMXR(1);
        allHero[i++]=new HeroSanDFY(1);
        allHero[i++]=new HeroSRLW(1);
        allHero[i++]=new HeroSRNC(1);
        allHero[i++]=new HeroBHGS(1);
        allHero[i++]=new HeroZJi(1);
        allHero[i++]=new HeroTLY(1);
        allHero[i++]=new HeroS(1);
        allHero[i++]=new HeroYC(1);
        allHero[i++]=new HeroBLH(1);
        allHero[i++]=new HeroD(1);
        allHero[i++]=new HeroZQRZ(1);
        allHero[i++]=new HeroLDPE(1);
        allHero[i++]=new HeroLHCM(1);
        allHero[i++]=new HeroHTZJ(1);
        allHero[i++]=new HeroHTFJ(1);
        allHero[i++]=new HeroHTYF(1);
        allHero[i++]=new HeroHTSM(1);
        allHero[i++]=new HeroHTJD(1);
        allHero[i++]=new HeroHTQD(1);
        allHero[i++]=new HeroHTASM(1);
        allHero[i++]=new HeroHTDDL(1);
        allHero[i++]=new HeroHTX(1);
        allHero[i++]=new HeroBSFD(1);
        allHero[i++]=new HeroZYZZ(1);
        allHero[i++]=new HeroBLDSW(1);
        allHero[i++]=new HeroMYDT(1);
        allHero[i++]=new HeroSWKKX(1);
        allHero[i++]=new HeroYZBTD(1);
        allHero[i++]=new HeroQSFoJ(1);
        allHero[i++]=new HeroBHXY(1);
        allHero[i++]=new HeroXRMR(1);
        allHero[i++]=new HeroDHMXR(1);
        allHero[i++]=new HeroHTB(1);
        allHero[i++]=new HeroLYDLY(1);
        allHero[i++]=new HeroCDLY(1);
        allHero[i++]=new HeroEDLY(1);
        allHero[i++]=new HeroCDSY(1);
        allHero[i++]=new HeroSDSY(1);
        allHero[i++]=new HeroSYCSL(1);
        allHero[i++]=new HeroCDTY(1);
        allHero[i++]=new HeroHuangT(1);
        allHero[i++]=new HeroTYHT(1);
        allHero[i++]=new HeroCDFY(1);
        allHero[i++]=new HeroEDFY(1);
        allHero[i++]=new HeroHYMR(1);
        allHero[i++]=new HeroDTMHY(1);
        allHero[i++]=new HeroLDXR(1);
        allHero[i++]=new HeroDTMYC(1);
        allHero[i++]=new HeroAXL(1);
        allHero[i++]=new HeroYTL(1);
        allHero[i++]=new HeroXTMR(1);
        allHero[i++]=new HeroXYZZ(1);
        allHero[i++]=new HeroCJRZ(1);
        allHero[i++]=new HeroMYZZ(1);
        allHero[i++]=new HeroDTMSR(1);
        allHero[i++]=new HeroXZY(1);
        allHero[i++]=new HeroHYKKX(1);
        allHero[i++]=new HeroQMKKX_5(1);  // 四星升五星开始：旗木卡卡西
        allHero[i++]=new HeroYFASM_5(1);
        allHero[i++]=new HeroGSGJ_5(1);
        allHero[i++]=new HeroMKK_5(1);
        allHero[i++]=new HeroTDZBZ_5(1);
        allHero[i++]=new HeroPE_5(1);
        allHero[i++]=new HeroXN_5(1);
        allHero[i++]=new HeroJ_5(1);
        allHero[i++]=new HeroDH_5(1);
        allHero[i++]=new HeroMJ_5(1);
        allHero[i++]=new HeroQDPP_5(1);
        allHero[i++]=new HeroCSL_5(1);
        allHero[i++]=new HeroA_5(1);
        allHero[i++]=new HeroQLB_5(1);
        allHero[i++]=new HeroYSD_5(1);
        allHero[i++]=new HeroHYJML_5(1);
        allHero[i++]=new HeroX_5(1);
        allHero[i++]=new HeroDDL_5(1);
        allHero[i++]=new HeroFD_5(1);
        allHero[i++]=new HeroJD_5(1);
        allHero[i++]=new HeroXWJXN_5(1);
        allHero[i++]=new HeroW_5(1);
        allHero[i++]=new HeroEDSY_5(1);
        allHero[i++]=new HeroSDFY_5(1);
        allHero[i++]=new HeroLTCDX_5(1);
        allHero[i++]=new HeroEWYMR_5(1);
        allHero[i++]=new HeroSC_5(1);
        allHero[i++]=new HeroLZ_5(1);
        allHero[i++]=new HeroF_5(1);
        allHero[i++]=new HeroYG_5(1);
        allHero[i++]=new HeroFu_5(1);
        allHero[i++]=new HeroQMSM_5(1);
        allHero[i++]=new HeroYNZW_5(1);
        allHero[i++]=new HeroLQYYL_5(1);
        allHero[i++]=new HeroLSCW_5(1);
        allHero[i++]=new HeroGDMY_5(1);
        allHero[i++]=new HeroWLSB_5(1);
        allHero[i++]=new HeroHTG_5(1);
        allHero[i++]=new HeroTCYSR_5(1);
        allHero[i++]=new HeroYZBZZ_5(1);
        allHero[i++]=new HeroCYY_5(1);
        allHero[i++]=new HeroXWMR_5(1);
        allHero[i++]=new HeroWAL_5(1);
        allHero[i++]=new HeroQJSTF_5(1);
        allHero[i++]=new HeroLYXB_5(1);
        allHero[i++]=new HeroHYCX_5(1);
        allHero[i++]=new HeroDXBY_5(1);
        allHero[i++]=new HeroHT_5(1);
        allHero[i++]=new HeroTTai_5(1);
        allHero[i++]=new HeroSNYBX_5(1);
        allHero[i++]=new HeroHL_5(1);
        allHero[i++]=new HeroKY(1);
        allHero[i++]=new HeroHMWT(1);
        allHero[i++]=new HeroHMG_5(1);
        allHero[i++]=new HeroHMJ_5(1);
        allHero[i++]=new HeroFY_5(1);
        allHero[i++]=new HeroSJY_5(1);
        allHero[i++]=new HeroXWBR_5(1);
        allHero[i++]=new HeroQMKKX(1);  // 四星开始：旗木卡卡西
        allHero[i++]=new HeroYFASM(1);
        allHero[i++]=new HeroGSGJ(1);
        allHero[i++]=new HeroMKK(1);
        allHero[i++]=new HeroTDZBZ(1);
        allHero[i++]=new HeroPE(1);
        allHero[i++]=new HeroXN(1);
        allHero[i++]=new HeroJ(1);
        allHero[i++]=new HeroDH(1);
        allHero[i++]=new HeroMJ(1);
        allHero[i++]=new HeroQDPP(1);
        allHero[i++]=new HeroCSL(1);
        allHero[i++]=new HeroA(1);
        allHero[i++]=new HeroQLB(1);
        allHero[i++]=new HeroYSD(1);
        allHero[i++]=new HeroHYJML(1);
        allHero[i++]=new HeroX(1);
        allHero[i++]=new HeroDDL(1);
        allHero[i++]=new HeroFD(1);
        allHero[i++]=new HeroJD(1);
        allHero[i++]=new HeroXWJXN(1);
        allHero[i++]=new HeroW(1);
        allHero[i++]=new HeroEDSY(1);
        allHero[i++]=new HeroSDFY(1);
        allHero[i++]=new HeroLTCDX(1);
        allHero[i++]=new HeroEWYMR(1);
        allHero[i++]=new HeroSC(1);
        allHero[i++]=new HeroLZ(1);
        allHero[i++]=new HeroF(1);
        allHero[i++]=new HeroYG(1);
        allHero[i++]=new HeroFu(1);
        allHero[i++]=new HeroQMSM(1);
        allHero[i++]=new HeroYNZW(1);
        allHero[i++]=new HeroLQYYL(1);
        allHero[i++]=new HeroLSCW(1);
        allHero[i++]=new HeroGDMY(1);
        allHero[i++]=new HeroWLSB(1);
        allHero[i++]=new HeroHTG(1);
        allHero[i++]=new HeroTCYSR(1);
        allHero[i++]=new HeroYZBZZ(1);
        allHero[i++]=new HeroCYY(1);
        allHero[i++]=new HeroXWMR(1);
        allHero[i++]=new HeroWAL(1);
        allHero[i++]=new HeroQJSTF(1);
        allHero[i++]=new HeroLYXB(1);
        allHero[i++]=new HeroHYCX(1);
        allHero[i++]=new HeroDXBY(1);
        allHero[i++]=new HeroHT(1);
        allHero[i++]=new HeroTTai(1);
        allHero[i++]=new HeroSNYBX(1);
        allHero[i++]=new HeroHL(1);
        allHero[i++]=new HeroHMG(1);
        allHero[i++]=new HeroHMJ(1);
        allHero[i++]=new HeroFY(1);
        allHero[i++]=new HeroSJY(1);
        allHero[i++]=new HeroXWBR(1);
        allHero[i++]=new HeroGDSY(1);  // 三星开始：鬼灯水月
        allHero[i++]=new HeroTCZW(1);
        allHero[i++]=new HeroXRH(1);
        allHero[i++]=new HeroRXNC(1);
        allHero[i++]=new HeroXL(1);
        allHero[i++]=new HeroZJ(1);
        allHero[i++]=new HeroKJL(1);
        allHero[i++]=new HeroSJ(1);
        allHero[i++]=new HeroQ(1);
        allHero[i++]=new HeroDLY(1);
        allHero[i++]=new HeroYSXHD(1);
        allHero[i++]=new HeroYYL(1);
        allHero[i++]=new HeroSHMY(1);
        allHero[i++]=new HeroZQXC(1);
        allHero[i++]=new HeroNLLW(1);
        allHero[i++]=new HeroQDDC(1);
        allHero[i++]=new HeroQZY(1);
        allHero[i++]=new HeroRXCT(1);
        allHero[i++]=new HeroLLK(1);
        allHero[i++]=new HeroYNZN(1);
        allHero[i++]=new HeroB(1);
        allHero[i++]=new HeroTT(1);
        allHero[i++]=new HeroYNY(1);
        allHero[i++]=new HeroRXRZ(1);
        allHero[i++]=new HeroX2(1);
        allHero[i++]=new HeroJTJY(1);
        allHero[i++]=new HeroSZHY(1);
        allHero[i++]=new HeroNLLJ(1);
        allHero[i++]=new HeroQDDZ(1);
        allHero[i++]=new HeroYZBFY(1);
        allHero[i++]=new HeroYZBMQ(1);
        allHero[i++]=new HeroRXRC(1);
        allHero[i++]=new HeroJTD(1);
        allHero[i++]=new HeroNLJN(1);
        allHero[i++]=new HeroQZH(1);
        allHero[i++]=new HeroQZZ(1);
        allHero[i++]=new HeroSCQY(1);
        allHero[i++]=new HeroBZLT(1);
        allHero[i++]=new HeroBZHXJ(1);
        allHero[i++]=new HeroHBS(1);
        allHero[i++]=new HeroGTW(1);
        allHero[i++]=new HeroZJYJ(1);
        allHero[i++]=new HeroDYY(1);
        allHero[i++]=new HeroCLF(1);
        allHero[i++]=new HeroBRQ(1);
        allHero[i++]=new HeroRZG(1);
        allHero[i++]=new HeroBJ(1);
        allHero[i++]=new HeroHYYLK(1);
        allHero[i++]=new HeroSZJY(1);
        allHero[i++]=new HeroCW(1);
        allHero[i++]=new HeroHW(1);
        allHero[i++]=new HeroMY(1);
        allHero[i++]=new HeroSMLS(1);
        allHero[i++]=new HeroGXDMT(1);
        allHero[i++]=new HeroGXDYT(1);
        allHero[i++]=new HeroHJ(1);
        allHero[i++]=new HeroMYXR(1);
        allHero[i++]=new HeroYRXR(1);
        allHero[i++]=new HeroSRXR(1);
        allHero[i++]=new HeroWRXR(1);
        allHero[i++]=new HeroYunRXR(1);
        //System.out.println("heroNumber="+i);
        allHero[heroNumber]=new Hero();
        // Att equipment
        i=0;
        allEquiqAtt[i++]=new EquiqQXJ_6(1);   // 五星升六星
        allEquiqAtt[i++]=new EquiqHHL_6(1);
        allEquiqAtt[i++]=new EquiqBJS_6(1);
        allEquiqAtt[i++]=new EquiqSQJ_6(1);
        allEquiqAtt[i++]=new EquiqHYZS_6(1);
        allEquiqAtt[i++]=new EquiqMDHZ_6(1);
        allEquiqAtt[i++]=new EquiqTZM_6(1);
        allEquiqAtt[i++]=new EquiqLDXZ_6(1);
        allEquiqAtt[i++]=new EquiqGWSXS_6(1);
        allEquiqAtt[i++]=new EquiqASMKD_6(1);
        allEquiqAtt[i++]=new EquiqSGKW_6(1);
        allEquiqAtt[i++]=new EquiqHPJP_6(1);
        allEquiqAtt[i++]=new EquiqSZFY_6(1);
        allEquiqAtt[i++]=new EquiqSGZJ_6(1);
        allEquiqAtt[i++]=new EquiqTZMJGG_6(1);
        allEquiqAtt[i++]=new EquiqQDY_6(1);
        allEquiqAtt[i++]=new EquiqXFJZ_6(1);
        allEquiqAtt[i++]=new EquiqSSLD_6(1);
        allEquiqAtt[i++]=new EquiqYTLZS_6(1);
        allEquiqAtt[i++]=new EquiqAXLZL_6(1);
        allEquiqAtt[i++]=new EquiqSWSLJ_6(1);
        allEquiqAtt[i++]=new EquiqBYZR_6(1);
        allEquiqAtt[i++]=new EquiqZSDD_6(1);  // 四星升六星
        allEquiqAtt[i++]=new EquiqDDJJ_6(1);
        allEquiqAtt[i++]=new EquiqCDFZ_6(1);
        allEquiqAtt[i++]=new EquiqDDDG_6(1);
        allEquiqAtt[i++]=new EquiqBDFM_6(1);
        allEquiqAtt[i++]=new EquiqLDY_6(1);
        allEquiqAtt[i++]=new EquiqSDPMD_6(1);
        allEquiqAtt[i++]=new EquiqJGRYB_6(1);
        allEquiqAtt[i++]=new EquiqLSZJ_6(1);
        allEquiqAtt[i++]=new EquiqCTJ_6(1);
        allEquiqAtt[i++]=new EquiqKQSZJ_6(1);
        allEquiqAtt[i++]=new EquiqLYFJJ_6(1);
        allEquiqAtt[i++]=new EquiqHJS_6(1);
        allEquiqAtt[i++]=new EquiqQXJ(1);   // 五星
        allEquiqAtt[i++]=new EquiqHHL(1);
        allEquiqAtt[i++]=new EquiqBJS(1);
        allEquiqAtt[i++]=new EquiqSQJ(1);
        allEquiqAtt[i++]=new EquiqHYZS(1);
        allEquiqAtt[i++]=new EquiqMDHZ(1);
        allEquiqAtt[i++]=new EquiqTZM(1);
        allEquiqAtt[i++]=new EquiqLDXZ(1);
        allEquiqAtt[i++]=new EquiqGWSXS(1);
        allEquiqAtt[i++]=new EquiqASMKD(1);
        allEquiqAtt[i++]=new EquiqSGKW(1);
        allEquiqAtt[i++]=new EquiqHPJP(1);
        allEquiqAtt[i++]=new EquiqSZFY(1);
        allEquiqAtt[i++]=new EquiqSGZJ(1);
        allEquiqAtt[i++]=new EquiqTZMJGG(1);
        allEquiqAtt[i++]=new EquiqQDY(1);
        allEquiqAtt[i++]=new EquiqXFJZ(1);
        allEquiqAtt[i++]=new EquiqSSLD(1);
        allEquiqAtt[i++]=new EquiqYTLZS(1);
        allEquiqAtt[i++]=new EquiqAXLZL(1);
        allEquiqAtt[i++]=new EquiqSWSLJ(1);
        allEquiqAtt[i++]=new EquiqBYZR(1);
        allEquiqAtt[i++]=new EquiqZSDD_5(1);  // 四星升五星
        allEquiqAtt[i++]=new EquiqDDJJ_5(1);
        allEquiqAtt[i++]=new EquiqCDFZ_5(1);
        allEquiqAtt[i++]=new EquiqDDDG_5(1);
        allEquiqAtt[i++]=new EquiqBDFM_5(1);
        allEquiqAtt[i++]=new EquiqLDY_5(1);
        allEquiqAtt[i++]=new EquiqSDPMD_5(1);
        allEquiqAtt[i++]=new EquiqJGRYB_5(1);
        allEquiqAtt[i++]=new EquiqLSZJ_5(1);
        allEquiqAtt[i++]=new EquiqCTJ_5(1);
        allEquiqAtt[i++]=new EquiqKQSZJ_5(1);
        allEquiqAtt[i++]=new EquiqLYFJJ_5(1);
        allEquiqAtt[i++]=new EquiqHJS_5(1);
        allEquiqAtt[i++]=new EquiqZSDD(1);  // 四星
        allEquiqAtt[i++]=new EquiqDDJJ(1);
        allEquiqAtt[i++]=new EquiqCDFZ(1);
        allEquiqAtt[i++]=new EquiqDDDG(1);
        allEquiqAtt[i++]=new EquiqBDFM(1);
        allEquiqAtt[i++]=new EquiqLDY(1);
        allEquiqAtt[i++]=new EquiqSDPMD(1);
        allEquiqAtt[i++]=new EquiqJGRYB(1);
        allEquiqAtt[i++]=new EquiqLSZJ(1);
        allEquiqAtt[i++]=new EquiqCTJ(1);
        allEquiqAtt[i++]=new EquiqKQSZJ(1);
        allEquiqAtt[i++]=new EquiqLYFJJ(1);
        allEquiqAtt[i++]=new EquiqHJS(1);
        allEquiqAtt[i++]=new EquiqCS(1);    // 三星
        allEquiqAtt[i++]=new EquiqFYQT(1);
        allEquiqAtt[i++]=new EquiqRZ(1);
        allEquiqAtt[i++]=new EquiqQBF(1);
        allEquiqAtt[i++]=new EquiqJZ(1);
        allEquiqAtt[i++]=new EquiqFZ(1);
        allEquiqAtt[i++]=new EquiqXXSYL(1);
        allEquiqAtt[i++]=new EquiqQB(1);
        allEquiqAtt[i++]=new EquiqRD(1);
        allEquiqAtt[i++]=new EquiqHJKW(1);
        //System.out.println("Total "+i+" weapons");
        allEquiqAtt[equipAttNumber]=new Equip();
        // Def equipment
        i=0;
        allEquiqDef[i++]=new EquiqAYZF_6(1);  // 五星升六星
        allEquiqDef[i++]=new EquiqBMHS_6(1);
        allEquiqDef[i++]=new EquiqXWZJ_6(1);
        allEquiqDef[i++]=new EquiqXRZP_6(1);
        allEquiqDef[i++]=new EquiqRKL_6(1);
        allEquiqDef[i++]=new EquiqBCJ_6(1);
        allEquiqDef[i++]=new EquiqBCQGY_6(1);
        allEquiqDef[i++]=new EquiqSMMJ_6(1);
        allEquiqDef[i++]=new EquiqSHZD_6(1);
        allEquiqDef[i++]=new EquiqBZZF_6(1);
        allEquiqDef[i++]=new EquiqHYDL_6(1);
        allEquiqDef[i++]=new EquiqHYZP_6(1);
        allEquiqDef[i++]=new EquiqNTZH_6(1);
        allEquiqDef[i++]=new EquiqSJYKL_6(1);
        allEquiqDef[i++]=new EquiqGYZP_6(1);
        allEquiqDef[i++]=new EquiqSYDL_6(1);
        allEquiqDef[i++]=new EquiqFYDL_6(1);
        allEquiqDef[i++]=new EquiqTYDL_6(1);
        allEquiqDef[i++]=new EquiqLYDL_6(1);
        allEquiqDef[i++]=new EquiqYWMJ_6(1);
        allEquiqDef[i++]=new EquiqXZNHZK_6(1);
        allEquiqDef[i++]=new EquiqKKXMZ_6(1);
        allEquiqDef[i++]=new EquiqABMJ_6(1);  // 四星升六星
        allEquiqDef[i++]=new EquiqZZY_6(1);
        allEquiqDef[i++]=new EquiqZZHS_6(1);
        allEquiqDef[i++]=new EquiqZZZJ_6(1);
        allEquiqDef[i++]=new EquiqZZP_6(1);
        allEquiqDef[i++]=new EquiqKL_6(1);
        allEquiqDef[i++]=new EquiqSHKJ_6(1);
        allEquiqDef[i++]=new EquiqQHCM_6(1);
        allEquiqDef[i++]=new EquiqQHZF_6(1);
        allEquiqDef[i++]=new EquiqQHZJ_6(1);
        allEquiqDef[i++]=new EquiqQHZP_6(1);
        allEquiqDef[i++]=new EquiqHXQ_6(1);
        allEquiqDef[i++]=new EquiqAYZF(1);  // 五星
        allEquiqDef[i++]=new EquiqBMHS(1);
        allEquiqDef[i++]=new EquiqXWZJ(1);
        allEquiqDef[i++]=new EquiqXRZP(1);
        allEquiqDef[i++]=new EquiqRKL(1);
        allEquiqDef[i++]=new EquiqBCJ(1);
        allEquiqDef[i++]=new EquiqBCQGY(1);
        allEquiqDef[i++]=new EquiqSMMJ(1);
        allEquiqDef[i++]=new EquiqSHZD(1);
        allEquiqDef[i++]=new EquiqBZZF(1);
        allEquiqDef[i++]=new EquiqHYDL(1);
        allEquiqDef[i++]=new EquiqHYZP(1);
        allEquiqDef[i++]=new EquiqNTZH(1);
        allEquiqDef[i++]=new EquiqSJYKL(1);
        allEquiqDef[i++]=new EquiqGYZP(1);
        allEquiqDef[i++]=new EquiqSYDL(1);
        allEquiqDef[i++]=new EquiqFYDL(1);
        allEquiqDef[i++]=new EquiqTYDL(1);
        allEquiqDef[i++]=new EquiqLYDL(1);
        allEquiqDef[i++]=new EquiqYWMJ(1);
        allEquiqDef[i++]=new EquiqXZNHZK(1);
        allEquiqDef[i++]=new EquiqKKXMZ(1);
        allEquiqDef[i++]=new EquiqABMJ_5(1);  // 四星升五星
        allEquiqDef[i++]=new EquiqZZY_5(1);
        allEquiqDef[i++]=new EquiqZZHS_5(1);
        allEquiqDef[i++]=new EquiqZZZJ_5(1);
        allEquiqDef[i++]=new EquiqZZP_5(1);
        allEquiqDef[i++]=new EquiqKL_5(1);
        allEquiqDef[i++]=new EquiqSHKJ_5(1);
        allEquiqDef[i++]=new EquiqQHCM_5(1);
        allEquiqDef[i++]=new EquiqQHZF_5(1);
        allEquiqDef[i++]=new EquiqQHZJ_5(1);
        allEquiqDef[i++]=new EquiqQHZP_5(1);
        allEquiqDef[i++]=new EquiqHXQ_5(1);
        allEquiqDef[i++]=new EquiqABMJ(1);  // 四星
        allEquiqDef[i++]=new EquiqZZY(1);
        allEquiqDef[i++]=new EquiqZZHS(1);
        allEquiqDef[i++]=new EquiqZZZJ(1);
        allEquiqDef[i++]=new EquiqZZP(1);
        allEquiqDef[i++]=new EquiqKL(1);
        allEquiqDef[i++]=new EquiqSHKJ(1);
        allEquiqDef[i++]=new EquiqQHCM(1);
        allEquiqDef[i++]=new EquiqQHZF(1);
        allEquiqDef[i++]=new EquiqQHZJ(1);
        allEquiqDef[i++]=new EquiqQHZP(1);
        allEquiqDef[i++]=new EquiqHXQ(1);
        allEquiqDef[i++]=new EquiqYGZK(1);  // 三星
        allEquiqDef[i++]=new EquiqYGZJ(1);
        allEquiqDef[i++]=new EquiqYGHS(1);
        allEquiqDef[i++]=new EquiqTYZJ(1);
        allEquiqDef[i++]=new EquiqLHZP(1);
        allEquiqDef[i++]=new EquiqYLP(1);
        allEquiqDef[i++]=new EquiqMJHS(1);
        allEquiqDef[i++]=new EquiqJFZJ(1);
        allEquiqDef[i++]=new EquiqLLZP(1);
        allEquiqDef[i++]=new EquiqHJHS(1);
        //System.out.println("Total "+i+" shields");
        allEquiqDef[equipDefNumber]=new Equip();
        // Tf equipment
        i=0;
        allEqpTf[i++]=new EqpMM_6();  // 五星升六星
        allEqpTf[i++]=new EqpTY_6();
        allEqpTf[i++]=new EqpYDWS_6();
        allEqpTf[i++]=new EqpEDWS_6();
        allEqpTf[i++]=new EqpHMWT_6();
        allEqpTf[i++]=new EqpBSXR_6();
        allEqpTf[i++]=new EqpSZXR_6();
        allEqpTf[i++]=new EqpZMXR_6();
        allEqpTf[i++]=new EqpDHMXR_6();
        allEqpTf[i++]=new EqpYM_6();
        allEqpTf[i++]=new EqpWDMX_6();
        allEqpTf[i++]=new EqpQS_6();
        allEqpTf[i++]=new EqpLY_6();  // 四星升六星
        allEqpTf[i++]=new EqpSTS_6();
        allEqpTf[i++]=new EqpHMJian_6();
        allEqpTf[i++]=new EqpHMG_6();
        allEqpTf[i++]=new EqpTBHM_6();
        allEqpTf[i++]=new EqpSJY_6();
        allEqpTf[i++]=new EqpJX_6();
        allEqpTf[i++]=new EqpBSL_6();
        allEqpTf[i++]=new EqpDYZQ_6();
        allEqpTf[i++]=new EqpBCN_6();
        allEqpTf[i++]=new EqpGN_6();
        allEqpTf[i++]=new EqpXN_6();
        allEqpTf[i++]=new EqpXM_6();
        allEqpTf[i++]=new EqpWG_6();
        allEqpTf[i++]=new EqpS_6();
        allEqpTf[i++]=new EqpMM();  // 五星
        allEqpTf[i++]=new EqpTY();
        allEqpTf[i++]=new EqpYDWS();
        allEqpTf[i++]=new EqpEDWS();
        allEqpTf[i++]=new EqpHMWT();
        allEqpTf[i++]=new EqpBSXR();
        allEqpTf[i++]=new EqpSZXR();
        allEqpTf[i++]=new EqpZMXR();
        allEqpTf[i++]=new EqpDHMXR();
        allEqpTf[i++]=new EqpYM();
        allEqpTf[i++]=new EqpWDMX();
        allEqpTf[i++]=new EqpQS();
        allEqpTf[i++]=new EqpLY_5();  // 四星升五星
        allEqpTf[i++]=new EqpSTS_5();
        allEqpTf[i++]=new EqpHMJian_5();
        allEqpTf[i++]=new EqpHMG_5();
        allEqpTf[i++]=new EqpTBHM_5();
        allEqpTf[i++]=new EqpSJY_5();
        allEqpTf[i++]=new EqpJX_5();
        allEqpTf[i++]=new EqpBSL_5();
        allEqpTf[i++]=new EqpDYZQ_5();
        allEqpTf[i++]=new EqpBCN_5();
        allEqpTf[i++]=new EqpGN_5();
        allEqpTf[i++]=new EqpXN_5();
        allEqpTf[i++]=new EqpXM_5();
        allEqpTf[i++]=new EqpWG_5();
        allEqpTf[i++]=new EqpS_5();
        allEqpTf[i++]=new EqpLY();  // 四星
        allEqpTf[i++]=new EqpSTS();
        allEqpTf[i++]=new EqpHMJian();
        allEqpTf[i++]=new EqpHMG();
        allEqpTf[i++]=new EqpTBHM();
        allEqpTf[i++]=new EqpSJY();
        allEqpTf[i++]=new EqpJX();
        allEqpTf[i++]=new EqpBSL();
        allEqpTf[i++]=new EqpDYZQ();
        allEqpTf[i++]=new EqpBCN();
        allEqpTf[i++]=new EqpGN();
        allEqpTf[i++]=new EqpXN();
        allEqpTf[i++]=new EqpXM();
        allEqpTf[i++]=new EqpWG();
        allEqpTf[i++]=new EqpS();
        allEqpTf[i++]=new EqpXB();  // 三星
        allEqpTf[i++]=new EqpBSK();
        allEqpTf[i++]=new EqpAJN();
        allEqpTf[i++]=new EqpGLK();
        allEqpTf[i++]=new EqpWH();
        allEqpTf[i++]=new EqpWLX();
        allEqpTf[i++]=new EqpBL();
        allEqpTf[i++]=new EqpPK();
        allEqpTf[i++]=new EqpHMJ();
        allEqpTf[i++]=new EqpHML();
        allEqpTf[i++]=new EqpHMLi();
        allEqpTf[i++]=new EqpHMY();
        allEqpTf[i++]=new EqpRG();
        allEqpTf[i++]=new EqpNG();
        allEqpTf[i++]=new EqpZZ();
        allEqpTf[i++]=new EqpHW();
        allEqpTf[i++]=new EqpHuiW();
        allEqpTf[i++]=new EqpCW();
        allEqpTf[i++]=new EqpTT();
        allEqpTf[i++]=new EqpHJPK();
        allEqpTf[i++]=new EqpHJTT();
        //System.out.println("Total "+i+" pact");
        allEqpTf[eqpTfNumber]=new Equip();
        // skills
        initSkill();
//        int flags[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        for(i=0; i<allHero.length; i++){
//            if(allHero[i].yuan1!=null && allHero[i].yuan1[1]==1){
//                System.out.print(allHero[i].name+" ");
//                for(int j=1; j<allHero[i].yuan1[0]; j++){
//                    System.out.print(allHero[i].yuan1[j]+" ");
//                }
//                System.out.println();
//                flags[allHero[i].yuan1[1]]=1;
//            }
//            if(allHero[i].yuan2!=null && allHero[i].yuan2[1]==1){
//                System.out.print(allHero[i].name+" ");
//                for(int j=1; j<allHero[i].yuan2[0]; j++){
//                    System.out.print(allHero[i].yuan2[j]+" ");
//                }
//                System.out.println();
//                flags[allHero[i].yuan2[1]]=1;
//            }
//            if(allHero[i].yuan3!=null && allHero[i].yuan3[1]==1){
//                System.out.print(allHero[i].name+" ");
//                for(int j=1; j<allHero[i].yuan3[0]; j++){
//                    System.out.print(allHero[i].yuan3[j]+" ");
//                }
//                System.out.println();
//                flags[allHero[i].yuan3[1]]=1;
//            }
//            if(allHero[i].yuan4!=null && allHero[i].yuan4[1]==1){
//                System.out.print(allHero[i].name+" ");
//                for(int j=1; j<allHero[i].yuan4[0]; j++){
//                    System.out.print(allHero[i].yuan4[j]+" ");
//                }
//                System.out.println();
//                flags[allHero[i].yuan4[1]]=1;
//            }
//        }
        // backupTeams
        backupTeams=new Team[backupNumber];
        for(i=0; i<backupNumber; i++){
            backupTeams[i]=new Team();
            readTeamFromFile(backupTeams[i], i);
        }
        myTeam=backupTeams[1];
        
        buildingLevel=new int[6];
        buildingEffect=new int[6];
        readBuildingsFromFile();
        readConfigFromFile();
        try {
            readAccFromFile();
        } catch (Exception ex) {
            System.out.println("Reading accounts fails.");
            des=null;
        }
        SocketMaster.onWork=false;
    }

    public static String yuanDescription(int yuan[]){
        String desc="   ";
        String AD, tmpS="";
        int p, pe;
        if(yuan[10]>0){
            AD="攻击力";
            p=yuan[10];
            pe=yuan[12];
        }
        else{
            AD="防御力";
            p=yuan[11];
            pe=yuan[13];
        }
        int i,j;
        switch(yuan[1]){
            case 0:
                desc+="与";
                for(i=2; i<yuan[0]; i++){
                    for(j=0; j<allHero.length; j++){
                        if(yuan[i]==allHero[j].hid){
                            desc=desc+"["+allHero[j].name+"]";
                            break;
                        }
                    }
                }
                desc+="同时上阵提高"+AD+p+"%";
                break;
            case 1:
                desc+="装备";
                for(i=2; i<yuan[0]; i++){
                    for(j=0; j<allEquiqAtt.length; j++){
                        if(yuan[i]==allEquiqAtt[j].id){
                            desc=desc+"["+allEquiqAtt[j].name+"]";
                            break;
                        }
                    }
                    if(j==allEquiqAtt.length){
                        for(j=0; j<allEquiqDef.length; j++){
                            if(yuan[i]==allEquiqDef[j].id){
                                desc=desc+"["+allEquiqDef[j].name+"]";
                                break;
                            }
                        }
                        if(j==allEquiqDef.length){
                            for(j=0; j<allEqpTf.length; j++){
                                if(yuan[i]==allEqpTf[j].id){
                                    desc=desc+"["+allEqpTf[j].name+"]";
                                    break;
                                }
                            }
                        }
                    }
                }
                desc+="提高"+AD+p+"%";
                break;
            case 2:
                desc+="尾兽祭坛中召唤";
                switch(yuan[2]){
                    case 80099: desc+="[神树]"; break;
                    case 80100: desc+="[九摩诃]"; break;
                    case 80101: desc+="[牛鬼]"; break;
                    case 80102: desc+="[重明]"; break;
                    case 80103: desc+="[犀犬]"; break;
                    case 80104: desc+="[穆王]"; break;
                    case 80105: desc+="[孙悟空]"; break;
                    case 80106: desc+="[矶抚]"; break;
                    case 80107: desc+="[又旅]"; break;
                    case 80108: desc+="[守鹤]"; break;
                }
                desc+="为尾兽时提高"+AD+p+"%";
                break;
            case 3:
                desc+="当阵容中存在大于或等于"+yuan[3]+"名";
                if(yuan[2]==0){
                    desc+="女";
                }
                else{
                    desc+="男";
                }
                desc+="忍者时，提高"+AD+p+"%";
                break;
            case 4:
                desc+="当阵容中存在至少"+yuan[4]+"名"+yuan[2];
                desc+="星及以上忍者时，提高"+AD+p+"%";
                break;
            case 5:
                desc+="当阵容中有其他";
                switch(yuan[2]){
                    case 0: tmpS="木叶忍者"; break;
                    case 1: tmpS="雾忍忍者"; break;
                    case 2: tmpS="岩忍忍者"; break;
                    case 3: tmpS="砂忍忍者"; break;
                    case 4: tmpS="雨忍忍者"; break;
                    case 5: tmpS="音忍忍者"; break;
                    case 6: tmpS="晓忍者"; break;
                    case 7: tmpS="云忍忍者"; break;
                    case 8: tmpS="泷忍忍者"; break;
                    case 9: tmpS="雪忍忍者"; break;
                    case 10: tmpS="忍兽"; break;
                    case 11: tmpS="秽土转生忍者"; break;
                    case 12: tmpS="忍宗忍者"; break;
                }
                desc=desc+tmpS+"时，提高"+AD+p+"%，同时其他上阵的"+tmpS+"提高"+AD+pe+"%";
                break;
            case 7:
                desc+="同时装备任意"+yuan[2]+"星及以上武器和防具时，提高"+AD+p+"%";
                break;
            case 8:
                desc+="当阵容中有大于1个此忍者同时上阵时，提高"+AD+p+"%";
                break;
            default:
        }
        return desc;
    }
    
    public static void initSkill(){
        int skillNumber=1802;
        skills=new Skill[skillNumber];
        int i=0, j, k;
        String s;
        File f=new File("skill.json");
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            while((s=br.readLine())!=null){
                j=s.indexOf("\"");
                if(j<0){
                    continue;
                }
                // id
                skills[i]=new Skill();
                skills[i].id=Integer.parseInt(s.substring(j+1, s.lastIndexOf("\"")));
                s=br.readLine();
                while((j=s.indexOf("name"))<0){
                    s=br.readLine();
                }
                // name
                skills[i].name=s.substring(j+8, s.lastIndexOf("\""));
                s=br.readLine();
                while((j=s.indexOf("type"))<0){
                    s=br.readLine();
                }
                // type
                skills[i].type=Integer.parseInt(s.substring(j+7, s.lastIndexOf(",")));
                //if(skills[i].timming()==-1) System.out.println("Unimplemented type: "+skills[i].type);
                s=br.readLine();
                while((j=s.indexOf("level"))<0){
                    s=br.readLine();
                }
                // level
                skills[i].level=Integer.parseInt(s.substring(j+8, s.lastIndexOf(",")));
                s=br.readLine();
                while((j=s.indexOf("x"))<0){
                    s=br.readLine();
                }
                // x
                skills[i].x=Double.parseDouble(s.substring(j+4, s.lastIndexOf(",")));
                s=br.readLine();
                while((j=s.indexOf("y"))<0){
                    s=br.readLine();
                }
                // y
                skills[i].y=Double.parseDouble(s.substring(j+4, s.lastIndexOf(",")));
                s=br.readLine();
                while((j=s.indexOf("z"))<0){
                    s=br.readLine();
                }
                // z
                skills[i].z=Double.parseDouble(s.substring(j+4, s.lastIndexOf(",")));
                // cycle
                s=br.readLine();
                s=br.readLine();
                i++;
            }
            br.close();
            //System.out.println("Read "+i+" skills in total.");
            // loading items
            f=new File("item.json");
            br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            Equip currEq;
            while((s=br.readLine())!=null){
                if(s.length()<3 || s.charAt(2)!='\"'){
                    continue;
                }
                // hero id
                j=Integer.parseInt(s.substring(3, 8));
                currEq=findEquipById(j);
                if(currEq==null){
                    //System.out.println("Cannot find item "+j);
                    continue;
                }
                //System.out.println(currEq.name);
                s=br.readLine();
                while(s.indexOf("star")<0){
                    s=br.readLine();
                }
                // star
                currEq.star=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("name")<0){
                    s=br.readLine();
                }
                // name
                currEq.name=s.substring(s.indexOf(":")+3, s.lastIndexOf(",")-1);
                //System.out.println(currEq.name+"\t"+currEq.star);
                s=br.readLine();
                while(s.indexOf("para1")<0){
                    s=br.readLine();
                }
                // att_born
                currEq.att_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("para2")<0){
                    s=br.readLine();
                }
                // def_born
                currEq.def_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("tough")<0){
                    s=br.readLine();
                }
                // tough_born
                currEq.tough_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("atkGrowth")<0){
                    s=br.readLine();
                }
                // atkGrowth
                currEq.attGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("defGrowth")<0){
                    s=br.readLine();
                }
                // defGrowth
                currEq.defGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("toughGrowth")<0){
                    s=br.readLine();
                }
                // toughGrowth
                currEq.toughGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("slot")<0){
                    s=br.readLine();
                }
                // slot
                currEq.slot=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("hideProperty")<0){
                    s=br.readLine();
                }
                // hideProperty
                if(s.endsWith("[")){
                    s=br.readLine();
                    currEq.hideProperty[0]=Double.parseDouble(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();
                    currEq.hideProperty[1]=Double.parseDouble(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();
                    currEq.hideProperty[2]=Double.parseDouble(s.trim());
                }
                s=br.readLine();
                while(s.indexOf("starStepEffect")<0){
                    s=br.readLine();
                }
                // starStepEffect
                if(s.endsWith("[")){
                    s=br.readLine();    // [
                    s=br.readLine();    // +1 效果
                    currEq.stepEffect[0][0]=Integer.parseInt(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();    // +1 效果
                    currEq.stepEffect[0][1]=Integer.parseInt(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();    // +1 效果
                    currEq.stepEffect[0][2]=Integer.parseInt(s.trim());
                    s=br.readLine();    // ],
                    s=br.readLine();    // [
                    s=br.readLine();    // +2 效果
                    currEq.stepEffect[1][0]=Integer.parseInt(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();    // +2 效果
                    currEq.stepEffect[1][1]=Integer.parseInt(s.substring(0, s.lastIndexOf(",")).trim());
                    s=br.readLine();    // +2 效果
                    currEq.stepEffect[1][2]=Integer.parseInt(s.trim());
                }
                else if(currEq.star>4){
                    Equip tmpEq=findEquipByName(currEq.name);
                    if(tmpEq==null || tmpEq.stepEffect[0][0]==0){
                        System.out.println("Code should be reached.");
                    }
                    currEq.stepEffect=tmpEq.stepEffect;
                }
            }
            f=new File("hero.json");
            br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            while((s=br.readLine())!=null){
                if(s.length()<3 || s.charAt(2)!='\"'){
                    continue;
                }
                // hero id
                j=Integer.parseInt(s.substring(3, 8));
                for(i=0; i<allHero.length; i++){
                    if(allHero[i].id==j){
                        break;
                    }
                }
                if(i>=allHero.length){
                    //System.out.println("Cannot find hero "+j);
                    continue;
                }
                //System.out.println(allHero[i].name);
                s=br.readLine();
                while(s.indexOf("description")<0){
                    s=br.readLine();
                }
                // description
                allHero[i].description=s.substring(s.indexOf(":")+3, s.lastIndexOf("\""));
                s=br.readLine();
                while(s.indexOf("star")<0){
                    s=br.readLine();
                }
                // star
                allHero[i].star=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("style")<0){
                    s=br.readLine();
                }
                // property
                allHero[i].property=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                if(allHero[i].property==-1){
                    allHero[i].property=20;
                }
                s=br.readLine();
                while(s.indexOf("atk")<0){
                    s=br.readLine();
                }
                // att_born
                allHero[i].att_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("def")<0){
                    s=br.readLine();
                }
                // def_born
                allHero[i].def_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                if(allHero[i].att_born>allHero[i].def_born){
                    allHero[i].attOrDef=1;
                }
                else{
                    allHero[i].attOrDef=0;
                }
                s=br.readLine();
                while(s.indexOf("atkGrowth")<0){
                    s=br.readLine();
                }
                // atkGrowth
                allHero[i].attGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("defGrowth")<0){
                    s=br.readLine();
                }
                // defGrowth
                allHero[i].defGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("tough")<0){
                    s=br.readLine();
                }
                // tough_born
                allHero[i].tough_born=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("toughGrowth")<0){
                    s=br.readLine();
                }
                // toughGrowth
                allHero[i].toughGrowth=Double.parseDouble(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("group")<0){
                    s=br.readLine();
                }
                // group
                allHero[i].style=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("gender")<0){
                    s=br.readLine();
                }
                // gender
                allHero[i].gender=Integer.parseInt(s.substring(s.indexOf(":")+2, s.lastIndexOf(",")));
                s=br.readLine();
                while(s.indexOf("skill0")<0){
                    s=br.readLine();
                }
                // skill 0
                if(s.indexOf("]")<0){
                    s=br.readLine();
                    if(s.length()>6 && s.charAt(6)=='['){
                        allHero[i].yuan1=new int[14];
                        allHero[i].yuan1[0]=1;
                        s=br.readLine();
                        allHero[i].yuanNames[0]=s.trim();
                        allHero[i].yuanNames[0]=allHero[i].yuanNames[0].substring(1, allHero[i].yuanNames[0].length()-2);
                        while(s.charAt(8)!='['){
                            s=br.readLine();
                        }
                        s=br.readLine();
                        while(s.charAt(8)!=']'){
                            if(s.indexOf(",")>0){
                                s=s.substring(0, s.indexOf(","));
                            }
                            allHero[i].yuan1[allHero[i].yuan1[0]++]=Integer.parseInt(s.trim());
                            //System.out.print(allHero[i].yuan1[allHero[i].yuan1[0]-1]+" ");
                            s=br.readLine();
                        }
                        //System.out.println(allHero[i].name);
                        while(s.charAt(8)!='['){
                            s=br.readLine();
                        }
                        s=br.readLine();
                        if(s.indexOf(",")>0){
                            s=s.substring(0, s.indexOf(","));
                        }
                        allHero[i].yuan1[10]=Integer.parseInt(s.trim());
                        s=br.readLine();
                        if(s.indexOf(",")>0){
                            s=s.substring(0, s.indexOf(","));
                        }
                        allHero[i].yuan1[11]=Integer.parseInt(s.trim());
                        s=br.readLine();
                        if(s.indexOf(",")>0){
                            s=s.substring(0, s.indexOf(","));
                        }
                        allHero[i].yuan1[12]=Integer.parseInt(s.trim());
                        s=br.readLine();
                        if(s.indexOf(",")>0){
                            s=s.substring(0, s.indexOf(","));
                        }
                        allHero[i].yuan1[13]=Integer.parseInt(s.trim());
                        allHero[i].yuanNames[0]+=yuanDescription(allHero[i].yuan1);
                        s=br.readLine();
                        s=br.readLine();
                        s=br.readLine();
                        if(s.length()>6 && s.charAt(6)=='['){
                            allHero[i].yuan2=new int[14];
                            allHero[i].yuan2[0]=1;
                            s=br.readLine();
                            allHero[i].yuanNames[1]=s.trim();
                            allHero[i].yuanNames[1]=allHero[i].yuanNames[1].substring(1, allHero[i].yuanNames[1].length()-2);
                            while(s.charAt(8)!='['){
                                s=br.readLine();
                            }
                            s=br.readLine();
                            while(s.charAt(8)!=']'){
                                if(s.indexOf(",")>0){
                                    s=s.substring(0, s.indexOf(","));
                                }
                                allHero[i].yuan2[allHero[i].yuan2[0]++]=Integer.parseInt(s.trim());
                                s=br.readLine();
                            }
                            while(s.charAt(8)!='['){
                                s=br.readLine();
                            }
                            s=br.readLine();
                            if(s.indexOf(",")>0){
                                s=s.substring(0, s.indexOf(","));
                            }
                            allHero[i].yuan2[10]=Integer.parseInt(s.trim());
                            s=br.readLine();
                            if(s.indexOf(",")>0){
                                s=s.substring(0, s.indexOf(","));
                            }
                            allHero[i].yuan2[11]=Integer.parseInt(s.trim());
                            s=br.readLine();
                            if(s.indexOf(",")>0){
                                s=s.substring(0, s.indexOf(","));
                            }
                            allHero[i].yuan2[12]=Integer.parseInt(s.trim());
                            s=br.readLine();
                            if(s.indexOf(",")>0){
                                s=s.substring(0, s.indexOf(","));
                            }
                            allHero[i].yuan2[13]=Integer.parseInt(s.trim());
                            allHero[i].yuanNames[1]+=yuanDescription(allHero[i].yuan2);
                            s=br.readLine();
                            s=br.readLine();
                            s=br.readLine();
                            if(s.length()>6 && s.charAt(6)=='['){
                                allHero[i].yuan3=new int[14];
                                allHero[i].yuan3[0]=1;
                                s=br.readLine();
                                allHero[i].yuanNames[2]=s.trim();
                                allHero[i].yuanNames[2]=allHero[i].yuanNames[2].substring(1, allHero[i].yuanNames[2].length()-2);
                                while(s.charAt(8)!='['){
                                    s=br.readLine();
                                }
                                s=br.readLine();
                                while(s.charAt(8)!=']'){
                                    if(s.indexOf(",")>0){
                                        s=s.substring(0, s.indexOf(","));
                                    }
                                    allHero[i].yuan3[allHero[i].yuan3[0]++]=Integer.parseInt(s.trim());
                                    s=br.readLine();
                                }
                                while(s.charAt(8)!='['){
                                    s=br.readLine();
                                }
                                s=br.readLine();
                                if(s.indexOf(",")>0){
                                    s=s.substring(0, s.indexOf(","));
                                }
                                allHero[i].yuan3[10]=Integer.parseInt(s.trim());
                                s=br.readLine();
                                if(s.indexOf(",")>0){
                                    s=s.substring(0, s.indexOf(","));
                                }
                                allHero[i].yuan3[11]=Integer.parseInt(s.trim());
                                s=br.readLine();
                                if(s.indexOf(",")>0){
                                    s=s.substring(0, s.indexOf(","));
                                }
                                allHero[i].yuan3[12]=Integer.parseInt(s.trim());
                                s=br.readLine();
                                if(s.indexOf(",")>0){
                                    s=s.substring(0, s.indexOf(","));
                                }
                                allHero[i].yuan3[13]=Integer.parseInt(s.trim());
                                allHero[i].yuanNames[2]+=yuanDescription(allHero[i].yuan3);
                                s=br.readLine();
                                s=br.readLine();
                                s=br.readLine();
                                if(s.length()>6 && s.charAt(6)=='['){
                                    allHero[i].yuan4=new int[14];
                                    allHero[i].yuan4[0]=1;
                                    s=br.readLine();
                                    allHero[i].yuanNames[3]=s.trim();
                                    allHero[i].yuanNames[3]=allHero[i].yuanNames[3].substring(1, allHero[i].yuanNames[3].length()-2);
                                    while(s.charAt(8)!='['){
                                        s=br.readLine();
                                    }
                                    s=br.readLine();
                                    while(s.charAt(8)!=']'){
                                        if(s.indexOf(",")>0){
                                            s=s.substring(0, s.indexOf(","));
                                        }
                                        allHero[i].yuan4[allHero[i].yuan4[0]++]=Integer.parseInt(s.trim());
                                        s=br.readLine();
                                    }
                                    while(s.charAt(8)!='['){
                                        s=br.readLine();
                                    }
                                    s=br.readLine();
                                    if(s.indexOf(",")>0){
                                        s=s.substring(0, s.indexOf(","));
                                    }
                                    allHero[i].yuan4[10]=Integer.parseInt(s.trim());
                                    s=br.readLine();
                                    if(s.indexOf(",")>0){
                                        s=s.substring(0, s.indexOf(","));
                                    }
                                    allHero[i].yuan4[11]=Integer.parseInt(s.trim());
                                    s=br.readLine();
                                    if(s.indexOf(",")>0){
                                        s=s.substring(0, s.indexOf(","));
                                    }
                                    allHero[i].yuan4[12]=Integer.parseInt(s.trim());
                                    s=br.readLine();
                                    if(s.indexOf(",")>0){
                                        s=s.substring(0, s.indexOf(","));
                                    }
                                    allHero[i].yuan4[13]=Integer.parseInt(s.trim());
                                    allHero[i].yuanNames[3]+=yuanDescription(allHero[i].yuan4);
                                    s=br.readLine();
                                    s=br.readLine();
                                    s=br.readLine();
                                }
                            }
                        }
                    }
                }
                s=br.readLine();
                while(s.indexOf("skill1")<0){
                    s=br.readLine();
                }
                // skill 1
                j=Integer.parseInt(s.substring(14, s.lastIndexOf(",")));
                if(j==0){
                    allHero[i].skill1=null;
                }
                else{
                    allHero[i].skill1=findSkill(j);
                    //System.out.print(": "+allHero[i].skill1.name);
                }
                s=br.readLine();
                while(s.indexOf("skill2")<0){
                    s=br.readLine();
                }
                // skill 2
                j=Integer.parseInt(s.substring(14, s.lastIndexOf(",")));
                if(j==0){
                    allHero[i].skill2=null;
                }
                else{
                    allHero[i].skill2=findSkill(j);
                    //System.out.print(", "+allHero[i].skill2.name);
                }
                s=br.readLine();
                while(s.indexOf("updatedSkills")<0){
                    s=br.readLine();
                }
                if(s.indexOf("]")<0){
                    // backupSkills
                    k=0;
                    s=br.readLine();    // [
                    while(s.length()>4 && s.charAt(4)!=']' && k<allHero[i].backupSkills.length){
                        s=br.readLine();
                        s=s.substring(0, s.lastIndexOf(",")).trim();
                        j=Integer.parseInt(s);
                        allHero[i].backupSkills[k++]=findSkill(j);
                        s=br.readLine();
                        s=br.readLine();
                        s=br.readLine();
                    }
                }
                //System.out.println(allHero[i].name+":"+k);
                for(k=0; k<allHero[i].backupSkills.length; k++){
                    if(allHero[i].backupSkills[k]==null){
                        break;
                    }
                    if(allHero[i].skill1!=null && allHero[i].skill1==allHero[i].backupSkills[k]){
                        allHero[i].skillIndex1=k;
                    }
                    if(allHero[i].skill2!=null && allHero[i].skill2==allHero[i].backupSkills[k]){
                        allHero[i].skillIndex2=k;
                    }
                }
                if(allHero[i].skill1!=null && allHero[i].skillIndex1<0){
                    if(k>=allHero[i].backupSkills.length){
                        System.out.println("Code shouldn't be reached: "+allHero[i].name+"'s skill1 not in the list.");
                    }
                    allHero[i].skillIndex1=k;
                    allHero[i].backupSkills[k++]=allHero[i].skill1;
                }
                if(allHero[i].skill2!=null && allHero[i].skillIndex2<0){
                    if(k>=allHero[i].backupSkills.length){
                        System.out.println("Code shouldn't be reached: "+allHero[i].name+"'s skill2 not in the list.");
                    }
                    allHero[i].skillIndex2=k;
                    allHero[i].backupSkills[k++]=allHero[i].skill2;
                }
            }
            /*
            File dir=new File("newclass");
            for(File newfile:dir.listFiles()){
                BufferedReader newbr=new BufferedReader(new FileReader(newfile));
                File cf=new File("cclass/"+newfile.getName());
                BufferedWriter newbw=new BufferedWriter(new FileWriter(cf));
                s=newbr.readLine();
                while(s.indexOf("id=")<0){
                    newbw.write(s+"\n");
                    s=newbr.readLine();
                }
                j=s.indexOf("id=");
                newbw.write(s.substring(0, j)+"e"+s.substring(j)+"\n");
                s=newbr.readLine();
                j=s.indexOf("eid=");
                newbw.write(s.substring(0, j)+"id=eid"+s.substring(j+6)+"\n");
                while((s=newbr.readLine())!=null){
                    newbw.write(s+"\n");
                }
                newbr.close();
                newbw.close();
            }
            * */
        } catch (Exception ex) {
            Logger.getLogger(SLComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
