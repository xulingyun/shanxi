package test;

import java.io.IOException;

import javax.microedition.lcdui.Image;

public class Resource {

	// public final static int[] MonsterBlood = { 100, 10, 500, 10, 200, 20,
	// 700,
	// 20, 300, 30, 900, 30, 450, 50, 1200, 50, 400, 40, 400, 40, 2400,
	// 40, 400, 40, 400, 40, 5500, 0, 2000, 0, 2500, 0, 3000, 0, 3500, 0,
	// 4000, 0, 4500, 0, 500, 0, 400, 0 };

	public final static int[] MonsterBlood = { 100, 20, 150, 25, 100, 20, 300,
			25, 150, 18, 300, 20, 200, 25, 400, 30, 150, 20, 150, 25, 150, 20,
			150, 30, 150, 30, 1500, 0, 2000, 0, 2500, 0, 3000, 0, 3500, 0,
			4000, 0, 4500, 0, 500, 0, 400, 25 };

	public final static int[] stoneXY = { 10, -100, 0, 90, -200, 0, 180, -340,
			0, 120, -360, 0, 40, -400, 0 };

	public final static int[] stoneXY1 = { 270, -150, 0, 90, -250, 0, 200,
			-350, 0 };

	public final static int[] stoneXY2 = { 20, 60, 0, 150, 80, 0, 70, 150, 0 };
	public final static int[] MonsterAttack = { 15, 1, 10, 1, 25, 1, 20, 1, 35,
			1, 30, 1, 50, 1, 45, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0, 150,
			0, 350, 0, 400, 0, 450, 0, 0, 0, 600, 0, 700, 0, 60, 0 };
	public final static int[] MonsterSpeed = { 10, 10, 10, 10, 10, 10, 10, 10,
			10, 10, 10, 10, 20, 15, 15, 15, 15, 10, 15, 15, 15, 10 };
	public final static int[] MonsterLevel = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	public final static int[] MonsterImgIndex = { 97, 98, 99, 100, 101, 102,
			103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115,
			116, 117, 137 };

	public static byte[] heroAndSoldierLevel = { 1, 1, 1, 1, 0, 0, 0, 0, 0 };
	public static byte[] isBelongMyOfHero = { 1, 0, 0, 0, 0, 0 };

	public final static long[] heroMoney = { 5000, 10000, 20000, 25000, 50000,
			50000 };

	public final static long[] soldierMoney = { 0, 0, 0, 0, 1000, 5000, 5000,
			10000, 10000 };

	public static byte[] guanqiaLevel = { 0, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1 };

	// public final static byte[] guanqiaLevel = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	// 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
	// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
	// -1, -1, -1, -1, -1, -1 };

	public final static int[][] heroValue = {
			{ 400, 4, 1000, 100, 1, 4000, 100, 15 },
			{ 500, 5, 2000, 110, 1, 4000, 10, 3 },
			{ 600, 6, 3000, 120, 1, 5000, 120, 15 },
			{ 700, 7, 4000, 130, 1, 8000, 200, 30 },
			{ 800, 8, 5000, 140, 1, 5000, 200, 15 },
			{ 800, 9, 6000, 150, 1, 5000, 150, 20, 250, 25 } };
	public final static int[][] soldierValue = { { 50, 1000, 5, 1000, 0, 0 },
			{ 55, 3500, 5, 3500 }, { 45, 3000, 3, 3000, 5, 1 },
			{ 45, 2000, 5, 2000, 0, 0 }, { 55, 2500, 3, 2500 },
			{ 50, 4000, 5, 4000, 6, 1 }, { 55, 5000, 3, 5000 },
			{ 65, 5000, 5, 5000 }, { 70, 5000, 3, 5000, 20, 1 } };
	public static int[] goodsPrice = { 1000, 1000, 1000 };
	public static byte[] goodsNums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public final static int[] prop2Localtion = { 150, -150, 0, 0, 250, -150, 0,
			0, 350, -50, 0, 0, 300, 100, 0, 0, 200, 100, 0, 0, 200, 50, 0, 0,
			250, -100, 0, 0 };
	public final static long[] guanqiaMoneyAndJingyan = { 400, 50, 300, 40 };
	public final static long[] TongMoneyAndJingyan = { 500, 100, 500, 40 };

	public final static String[] shopInfo = { "Ѫƿ", "�ָ�Ӣ��40%��Ѫ������ս����ʹ�ã�",
			"������", "ʹ������ʧ30%��Ѫ������ս����ʹ�ã�", "����", "ʿ���Ĺ�������������30�룩", "˫�����鿨",
			"ս��ʤ����õľ��鷭����", "˫����ҿ�", "ս��ʤ����õĽ�ҷ�����", "����ʯ", "ʹ�ú�����10��������",
			"��������", "ͨ����ս��ʧ�ܱ�����ʧ��", "����֮��", "��������ʿ��10%��������", "���Ի���",
			"����Ӣ��20���������", "����г��", "����Ӣ��20%������", "������", "�һ�10000��ҡ�" };

	public final static String[] heroSkillInfo = { "��һ�����ϵ����е�������˺�", "����������",
			"��һ�����ϵĵ�������˺���������3��", "�ָ�Ӣ������", "��ȫ���ĵ�������˺�", "��ȫ���ĵ�������˺������ָ�Ӣ������" };

	public final static String[] heroSkillName = { "�ϳ�֮��", "��ܼӻ�", "���겨��",
			"ʥ����", "��������", "������Ϯ" };

	public final static String[] heroName = { "�ֻ�֮��-����", "Ѹ������-������", "ս�����ݡ��ֵ�",
			"����֮��-���", "����֮��-����˿", "����ʦ-�ɫ" };

	public final static String[] soldierNameAndSomething = { "����", "��ս",
			"����ͨ�ı��֡�", "���", "��ս", "�������д�͸Ч����", "����", "Զ��", "���������ж�Ч����", "����",
			"��ս", "���Դ�ϵ���ʩ����", "��ʦ", "Զ��", "�������л�ѪЧ����", "��սʿ", "��ս",
			"�������н���Ч��", "ħ��ʦ", "Զ��", "�ٻ����򹥻����ˡ�", "�̿�", "��ս", "���������������Ρ�",
			"��ǹ��", "Զ��", "��һ�����ʲ���������" };

	public final static String[] soldierNameUp = { "����", "��ʿ", "������", "���",
			"��ʿ", "�������", "����", "������", "����", "����", "������", "��������", "��ʦ", "���",
			"��������", "��սʿ", "����", "������ʿ", "ħ��ʦ", "��ħ��ʦ", "ħ��ʦ", "�̿�", "��ɱ��",
			"����ͳ��", "��ǹ��", "ӥ��", "�ѻ���" };

	public static String[] AttainmentName = { "ţ��С��", "�����ԭ", "��ԭ������", "�ص�ð��",
			"�����μ�", "����ѩ��", "��ѩ֮��", "����ս��", "����֮��", "̽����", "�ٽ�����", "��ʤ��",
			"��������", "����é®", "С������", "�Ʋ��ɵ�", "ս��֮��", "ɱ¾ʢ��", "�����", "һ�ﵱǧ",
			"���֮��", "ħ��֮��", "���ҽ��", "��ս��ʿ", "��װ��ʿ", "��������", "�籩֮��", "����֮��",
			"Ұ����", "���淨ʦ", "�̿�����", "�ѻ�ר��" };
	public static String[] AttainmentCondition = { "�������ָ����", "���������ǲ�ԭ��boss1",
			"���������ǲ�ԭ��boss2", "����Թ���½��boss1", "����Թ���½��boss2", "���ܱ�˪��½��boss1",
			"���ܱ�˪��½��boss2", "��������֮����boss1", "��������֮����boss2", "��ͨ������10��ȡ��ʤ��",
			"��ͨ������20��ȡ��ʤ��", "��ͨ������30��ȡ��ʤ��", "��ͨ������40��ȡ��ʤ��",
			"�������ǲ�ԭ�����йؿ�ȡ��3������", "��Թ��ؿߵ����йؿ�ȡ��3������", "�ڱ�˪��½�����йؿ�ȡ��3������",
			"������֮�������йؿ�ȡ��3������", "Ӣ��1����20��", "Ӣ��2����20��", "Ӣ��3����20��", "Ӣ��4����20��",
			"Ӣ��5����20��", "Ӣ��6����20��", "��������20��", "��ʿ����20��", "��������20��", "��������20��",
			"��ʦ����20��", "��սʿ����20��", "ħ��������20��", "�̿�����20��", "��ǹ������20��" };
	public static String[] someUpGreatInfoH = { "", "���������5���������",
			"���������10���������", "���������20���������", "ͨ��Թ��ؿߺ������", "�޾�֮��30��������" };
	public static String[] someUpGreatInfoS = { "", "", "", "", "ͨ�������ǲ�ԭ��",
			"ͨ�������ǲ�ԭ��", "ͨ��Թ��ؿߣ�", "ͨ��Թ��ؿߣ�", "ͨ�ر�˪��½��" };
	public static byte[] isFinishAttainment = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int[] AttainmentMoney = { 5000, 5000, 5000, 5000, 5000,
			10000, 10000, 10000, 10000, 5000, 5000, 10000, 10000, 10000, 10000,
			10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
			10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000 };
	public static int tongtiantafloor = 0;
	public static byte[] count_c_t = { 1, 1 };
	public static byte saveSelectHero = 0;
	public static byte[] savaSelcetSoldier = { 0, 1, 2, 3 };
	public static long resumeNengliangTime;

	public static short NUMS = 0;
	public static final short soldier0 = NUMS++;
	public static final short soldier1 = NUMS++;
	public static final short soldier2 = NUMS++;
	public static final short soldier3 = NUMS++;
	public static final short soldier4 = NUMS++;
	public static final short soldier5 = NUMS++;
	public static final short soldier6 = NUMS++;
	public static final short soldier7 = NUMS++;
	public static final short soldier8 = NUMS++;
	public static final short arrows = NUMS++;
	public static final short back0 = NUMS++;
	public static final short hero = NUMS++;
	public static final short selectbox1 = NUMS++;
	public static final short selectbox2 = NUMS++;
	public static final short select2 = NUMS++;
	public static final short star = NUMS++;
	public static final short number = NUMS++;
	public static final short money = NUMS++;
	public static final short newbox = NUMS++;
	public static final short newtext = NUMS++;
	public static final short chengjiupanel = NUMS++;
	// 20
	public static final short awardbutton = NUMS++;
	public static final short bg6 = NUMS++;
	public static final short bg10 = NUMS++;
	public static final short bg11 = NUMS++;
	public static final short bgleft = NUMS++;
	public static final short bgmiddle = NUMS++;
	public static final short bgright = NUMS++;
	public static final short biankuang = NUMS++;
	public static final short bingzhonginfo = NUMS++;
	public static final short button1 = NUMS++;
	public static final short button2 = NUMS++;
	public static final short buttonbg = NUMS++;
	public static final short buttontext1 = NUMS++;
	public static final short buttontext2 = NUMS++;
	public static final short buyandshengji = NUMS++;
	public static final short caifu = NUMS++;
	public static final short fire = NUMS++;
	public static final short grasslands = NUMS++;
	public static final short guanqia = NUMS++;
	public static final short guanqiapj = NUMS++;
	public static final short heroinfoall = NUMS++;
	public static final short guanqiatext = NUMS++;
	public static final short herobig = NUMS++;
	public static final short heroinfo = NUMS++;
	public static final short ice = NUMS++;
	public static final short leftright = NUMS++;
	public static final short login = NUMS++;
	public static final short logintext = NUMS++;
	public static final short myherotext = NUMS++;
	public static final short mysoldertext = NUMS++;
	public static final short newcomer = NUMS++;
	public static final short selecthero = NUMS++;
	public static final short numberbig = NUMS++;
	public static final short panel1 = NUMS++;
	public static final short pit = NUMS++;
	public static final short queding = NUMS++;
	public static final short selectforce = NUMS++;
	public static final short shopbag = NUMS++;
	public static final short shopbar = NUMS++;
	public static final short shopleft = NUMS++;
	public static final short shopmiddle = NUMS++;
	public static final short shopright = NUMS++;
	public static final short shopselect = NUMS++;
	public static final short shoptext = NUMS++;
	public static final short shopthingnum = NUMS++;
	public static final short shoptool = NUMS++;
	public static final short shopx1 = NUMS++;
	public static final short shopx2 = NUMS++;
	public static final short somewherename = NUMS++;
	public static final short titlebingzhong = NUMS++;
	public static final short titlehero = NUMS++;
	public static final short udanddown = NUMS++;
	public static final short wujin = NUMS++;
	public static final short awardtext = NUMS++;
	public static final short jbar = NUMS++;
	public static final short nbar = NUMS++;
	public static final short help1 = NUMS++;
	public static final short help2 = NUMS++;
	public static final short use = NUMS++;
	public static final short attainment_icon = NUMS++;
	public static final short attainment_finish = NUMS++;
	public static final short stopandgo = NUMS++;
	public static final short fight = NUMS++;
	public static final short lock = NUMS++;
	public static final short gongxini = NUMS++;
	public static final short daojishinum = NUMS++;
	public static final short upgreat = NUMS++;
	public static final short uparrow = NUMS++;
	// 75
	public static final short bg0 = NUMS++;
	public static final short bg1 = NUMS++;
	public static final short bg2 = NUMS++;
	public static final short bg3 = NUMS++;
	public static final short bg4 = NUMS++;
	public static final short bg5 = NUMS++;
	// 81
	public static final short monster1 = NUMS++;
	public static final short monster2 = NUMS++;
	public static final short monster3 = NUMS++;
	public static final short monster4 = NUMS++;
	public static final short monster5 = NUMS++;
	public static final short monster6 = NUMS++;
	public static final short monster7 = NUMS++;
	public static final short monster8 = NUMS++;
	public static final short monster9 = NUMS++;
	public static final short monster10 = NUMS++;
	public static final short monster11 = NUMS++;
	public static final short monster12 = NUMS++;
	public static final short monster13 = NUMS++;
	public static final short boss1 = NUMS++;
	public static final short boss2 = NUMS++;
	public static final short boss3 = NUMS++;
	public static final short boss4 = NUMS++;
	public static final short boss5 = NUMS++;
	public static final short boss6 = NUMS++;
	public static final short boss7 = NUMS++;
	public static final short boss8 = NUMS++;
	public static final short bloodmagic = NUMS++;
	public static final short bmbar = NUMS++;
	public static final short powerbar = NUMS++;
	public static final short powerbarbg = NUMS++;
	public static final short powerbg1 = NUMS++;
	public static final short powerbg2 = NUMS++;
	public static final short herobg = NUMS++;
	public static final short toolnumkey = NUMS++;
	public static final short zhandouleft = NUMS++;
	public static final short zhandoumiddle = NUMS++;
	public static final short zhandouright = NUMS++;
	public static final short monsterdie = NUMS++;
	public static final short attackhero = NUMS++;
	public static final short boss1attack = NUMS++;
	public static final short boss2attack = NUMS++;
	public static final short boss3attack1 = NUMS++;
	public static final short boss3attack2 = NUMS++;
	public static final short boss4attack = NUMS++;
	public static final short boss5attack = NUMS++;
	public static final short boss6m = NUMS++;
	public static final short boss6mattack = NUMS++;
	public static final short boss78attack = NUMS++;
	public static final short soldier21 = NUMS++;
	public static final short soldier22 = NUMS++;
	public static final short soldier31 = NUMS++;
	public static final short soldier32 = NUMS++;
	public static final short soldier81 = NUMS++;
	public static final short soldier91 = NUMS++;
	public static final short bullet1 = NUMS++;
	public static final short bullet2 = NUMS++;
	public static final short powerbg3 = NUMS++;
	public static final short bosspower1 = NUMS++;
	public static final short bosspower2 = NUMS++;
	public static final short bossblood1 = NUMS++;
	public static final short bossblood2 = NUMS++;
	public static final short hero1skill = NUMS++;
	public static final short attacknumber = NUMS++;
	public static final short baojibg = NUMS++;
	public static final short stopimg = NUMS++;
	public static final short hero4skill = NUMS++;
	public static final short boss87attack = NUMS++;
	public static final short hero3skill = NUMS++;
	public static final short hero5skill = NUMS++;
	public static final short hero6skill = NUMS++;
	public static final short soldier51 = NUMS++;
	public static final short soldier52 = NUMS++;
	public static final short soldier53 = NUMS++;
	public static final short soldier92 = NUMS++;
	public static final short soldier71 = NUMS++;
	public static final short soldier33 = NUMS++;
	public static final short hero2skill = NUMS++;
	public static final short shenglishibai = NUMS++;
	public static final short star1 = NUMS++;
	public static final short buff = NUMS++;
	public static final short herosay1 = NUMS++;
	public static final short herosay2 = NUMS++;
	public static final short shanmove = NUMS++;
	public static final short zhongdu = NUMS++;

	public static final short heroskillsrc = NUMS++;
	public static final short soldier121 = NUMS++;
	public static final short soldier122 = NUMS++;
	public static final short saybox = NUMS++;

	public static final byte isfirst = 0;

	public static final String[] PAGE_INDEX = { "PASS", "HOME_PAGE0",
			"GAME_PAGE" };

	private static final Image[] images = new Image[NUMS];

	static String[] somePic = { "/common/1.png", "/common/2.png",
			"/common/3.png", "/common/4.png", "/common/5.png", "/common/6.png",
			"/common/7.png", "/common/8.png", "/common/9.png",
			"/common/arrows.png", "/common/back0.png", "/common/hero.png",
			"/common/selectbox1.png", "/common/selectbox2.png",
			"/common/select2.png", "/common/star.png", "/common/number.png",
			"/common/money.png", "/common/newbox.png", "/common/newtext.png",
			"/common/chengjiupanel.png",

			"/firstpage/awardbutton.png", "/firstpage/bg6.jpg",
			"/firstpage/bg10.jpg", "/firstpage/bg11.jpg",
			"/firstpage/bgleft.jpg", "/firstpage/bgmiddle.jpg",
			"/firstpage/bgright.jpg", "/firstpage/biankuang.png",
			"/firstpage/bingzhonginfo.png", "/firstpage/button1.png",
			"/firstpage/button2.png", "/firstpage/buttonbg.png",
			"/firstpage/buttontext1.png", "/firstpage/buttontext2.png",
			"/firstpage/buyandshengji.png", "/firstpage/caifu.png",
			"/firstpage/fire.png", "/firstpage/grasslands.png",
			"/firstpage/guanqia.png", "/firstpage/guanqiapj.png",
			"/firstpage/heroinfoall.png", "/firstpage/guanqiatext.png",
			"/firstpage/herobig.png", "/firstpage/heroinfo.png",
			"/firstpage/ice.png", "/firstpage/leftright.png",
			"/firstpage/login.jpg", "/firstpage/logintext.png",
			"/firstpage/myherotext.png", "/firstpage/mysoldertext.png",
			"/firstpage/newcomer.png", "/firstpage/selecthero.png",
			"/firstpage/numberbig.png", "/firstpage/panel1.png",
			"/firstpage/pit.png", "/firstpage/queding.png",
			"/firstpage/selectforce.png", "/firstpage/shopbag.png",
			"/firstpage/shopbar.jpg", "/firstpage/shopleft.jpg",
			"/firstpage/shopmiddle.jpg", "/firstpage/shopright.jpg",
			"/firstpage/shopselect.png", "/firstpage/shoptext.png",
			"/firstpage/shopthingnum.png", "/firstpage/shoptool.png",
			"/firstpage/shopx1.png", "/firstpage/shopx2.png",
			"/firstpage/somewherename.png", "/firstpage/titlebingzhong.png",
			"/firstpage/titlehero.png", "/firstpage/udanddown.png",
			"/firstpage/wujin.png", "/firstpage/awardtext.png",
			"/firstpage/jbar.png", "/firstpage/nbar.png",
			"/firstpage/help1.png", "/firstpage/help2.png",
			"/firstpage/use.png", "/firstpage/attainment_icon.png",
			"/firstpage/attainment_finish.png", "/firstpage/stopandgo.png",
			"/firstpage/fight.png", "/firstpage/lock.png",
			"/firstpage/gongxini.png", "/firstpage/daojishinum.png",
			"/firstpage/upgreat.png", "/firstpage/uparrow.png",

			"/secondpage/bg0.jpg", "/secondpage/bg1.jpg",
			"/secondpage/bg2.jpg", "/secondpage/bg3.jpg",
			"/secondpage/bg4.jpg", "/secondpage/bg5.jpg",
			"/secondpage/monster1.png", "/secondpage/monster2.png",
			"/secondpage/monster3.png", "/secondpage/monster4.png",
			"/secondpage/monster5.png", "/secondpage/monster6.png",
			"/secondpage/monster7.png", "/secondpage/monster8.png",
			"/secondpage/monster9.png", "/secondpage/monster10.png",
			"/secondpage/monster11.png", "/secondpage/monster12.png",
			"/secondpage/monster13.png", "/secondpage/boss1.png",
			"/secondpage/boss2.png", "/secondpage/boss3.png",
			"/secondpage/boss4.png", "/secondpage/boss5.png",
			"/secondpage/boss6.png", "/secondpage/boss7.png",
			"/secondpage/boss8.png", "/secondpage/bloodmagic.png",
			"/secondpage/bmbar.png", "/secondpage/powerbar.png",
			"/secondpage/powerbarbg.png", "/secondpage/powerbg1.png",
			"/secondpage/powerbg2.png", "/secondpage/herobg.png",
			"/secondpage/toolnumkey.png", "/secondpage/zhandouleft.jpg",
			"/secondpage/zhandoumiddle.jpg", "/secondpage/zhandouright.jpg",
			"/secondpage/monsterdie.png", "/secondpage/attackhero.png",
			"/secondpage/boss1attack.png", "/secondpage/boss2attack.png",
			"/secondpage/boss3attack1.png", "/secondpage/boss3attack2.png",
			"/secondpage/boss4attack.png", "/secondpage/boss5attack.png",
			"/secondpage/boss6m.png", "/secondpage/boss6mattack.png",
			"/secondpage/boss78attack.png", "/secondpage/soldier21.png",
			"/secondpage/soldier22.png", "/secondpage/soldier31.png",
			"/secondpage/soldier32.png", "/secondpage/soldier81.png",
			"/secondpage/soldier91.png", "/secondpage/bullet1.png",
			"/secondpage/bullet2.png", "/secondpage/powerbg3.png",
			"/secondpage/bosspower1.png", "/secondpage/bosspower2.png",
			"/secondpage/bossblood1.png", "/secondpage/bossblood2.jpg",
			"/secondpage/hero1skill.png", "/secondpage/attacknumber.png",
			"/secondpage/baojibg.png", "/secondpage/stopimg.png",
			"/secondpage/hero4skill.png", "/secondpage/boss87attack.png",
			"/secondpage/hero3skill.png", "/secondpage/hero5skill.png",
			"/secondpage/hero6skill.png", "/secondpage/soldier51.png",
			"/secondpage/soldier52.png", "/secondpage/soldier53.png",
			"/secondpage/soldier92.png", "/secondpage/soldier71.png",
			"/secondpage/soldier33.png", "/secondpage/hero2skill.png",
			"/secondpage/shenglishibai.png", "/secondpage/star1.png",
			"/secondpage/buff.png", "/secondpage/herosay1.png",
			"/secondpage/herosay2.png", "/secondpage/shanmove.png",
			"/secondpage/zhongdu.png",

			"/secondpage/heroskillsrc.png", "/secondpage/soldier121.png",
			"/secondpage/soldier122.png", "/secondpage/saybox.png"

	};

	public static Image loadImage(int id) {
		if (images[id] == null) {
			try {
				images[id] = Image.createImage(somePic[id]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return images[id];
	}

	public static void clearIdPic() {

	}

}