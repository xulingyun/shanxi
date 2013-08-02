package test;

import hero.Hero;
import hero.IceDrow;
import hero.Monster;
import hero.MoveElementEffect;
import hero.Point;
import hero.Soldier;
import skill.Critical;
import test.PropManager;
import upgrade.Upgrade;
import map.Arrow;
import map.Bullet;
import map.Map;
import map.StrikeHero;
import my.Myself;

import cn.ohyeah.itvgame.model.GameRecord;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.game.ServiceWrapper;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.PopupConfirm;
import cn.ohyeah.stb.ui.PopupText;
import cn.ohyeah.stb.ui.TextView;
import cn.ohyeah.stb.util.BytesUtil;
import cn.ohyeah.stb.util.Collision;
import cn.ohyeah.stb.util.DateUtil;
import cn.ohyeah.stb.util.RandomValue;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;

import data.SaveAndGet;

public class GameEngine extends GameCanvasEngine {
	String page;
	CreatArray ca;
	Hero hero;
	Map map = new Map();
	MoveElementEffect mee = new MoveElementEffect();
	Hero newHero;
	Monster newMonster;
	Monster newMonster1;
	public PropManager pm;
	Point skill1Hero;
	Point skill1Hero1 = null;
	public Myself my;
	GameRecord record;
	public PlayerProp[] props;
	int[][][][][] mapArray;
	int[][] location = new int[4][9];
	int[] mainPageIndex = new int[5];
	int[] randomArray = new int[12];
	Soldier[][] idPic = new Soldier[7][4];
	Monster[][] monsterPic = new Monster[7][4];
	Point[] p = new Point[12];
	Soldier[] newSoldier = new Soldier[6];
	public static Image[] img = new Image[177];

	public static int randomSoldierSayLocaltion;
	public static int randomSoldierSayIndex;
	public static int add = -1;
	public static int count;
	long startAddTime;
	long saodangTime;
	long needMoney;
	long suggestAndStopStartTime;
	long suggestAndStopEndTime;
	long tongtiantaExp;
	long tongtiantaMoney;
	long winExp;
	long winMoney;
	long addArmorStartTime;
	long attainmentPanelStartTime;
	long prop3StartTime;
	int index;
	int indexSelect;
	int arrowIndex;
	int mainIndex;
	int gameIndex;
	int gameButtonSelect;
	int panle_x = 190;
	int panle_y = 130;
	int mapIndexOfIndex;
	int mainPage3Index;
	int mainPage4Index;
	int selectSoldierLocation;
	int selectSoldierindex;
	int winNum;
	int tempWinNum;
	int weiyiCount;
	int circleNum;
	int sumCircleNum;
	int stopCount;
	int win1;
	int selectShopSmallIndex;
	int saodangIndex;
	int temp_img_distance1 = 21;
	int temp_img_distance2 = temp_img_distance1 + 69;
	int tempMainPage0Index;
	int enterWay;
	int money = 0;
	int shopPage;
	int shopSum;
	int bossMoveindex = 0;
	int isLoadSold;
	int tempFloor = 0;
	int tongtiantaAndNormalBigGuanqia;
	int tongtiantaAndNormalSmallGuanqia;
	int tongtiantaIndex;
	int newGuideIndex = 0;
	int moveToUPAndDown = 0;
	int canGoodsIndex;
	int selectShopSmallIndexTemp;
	int shopArea;
	int starIndex;
	int suggestIndex;
	int diaobloodIndex = 0;
	int tempStar = 0;
	int prop2Index;
	int heroStateLength;
	int heroStateIndex;
	int boss5Random;
	int boss8StoneNum;
	int soldierATkTimes;
	int attainmentPanelIndex = 1;
	int UnfoldAttainmentIndex;
	int move_long_x;
	int move_long_y;
	int move_long_count;
	int WinAndFailIndex;
	int stopIndex;
	int randomHeroSayLocaltion;
	int randomHeroSayIndex;
	int[] useProp = new int[3];
	int shengjiIndex;
	SaveAndGet sag;
	long alertTime;
	long alertSumTime;
	public static boolean online;

	public static boolean state;
	boolean isSaodang;
	boolean startAddState = false;
	boolean startAward;
	boolean isAlertAward;
	boolean bossStart = false;
	boolean isTongtianta;
	boolean mayEnterButton;
	boolean isSuggest;
	boolean isAddArmor;
	public static boolean isNowSoldierSay;
	boolean isNowHeroSay;
	boolean isDoubleAtk;
	public static boolean stopState;
	boolean isHelp;
	boolean isUnfoldAttainment;
	boolean isEnhanceSoldierATK;
	boolean isEnhanceArmor;
	boolean isEnhanceBoold;
	boolean isDoubleExp;
	boolean isDoubleMoney;

	Vector soonDeathArray = new Vector();
	Vector deathArray = new Vector();
	Vector stickVector = new Vector();
	Vector monsterVector = new Vector();
	Vector heroSkillmonster = new Vector();
	Vector buttleArray = new Vector();
	Vector arrowArray = new Vector();
	Vector magicArray = new Vector();
	Vector slickballArray = new Vector();
	Vector firelockArray = new Vector();
	Vector criticalArray = new Vector();
	Vector criticalArray1 = new Vector();
	Vector criticalArray2 = new Vector();
	Vector IceDrowVector = new Vector();
	Vector v9a = new Vector();
	Vector v8a = new Vector();
	Vector v7a = new Vector();
	Vector v6a = new Vector();
	Vector v5a = new Vector();
	Vector v4a = new Vector();
	Vector v3a = new Vector();
	Vector v2a = new Vector();
	Vector v1a = new Vector();

	private void cleanGameVar() {
		v1a.removeAllElements();
		v2a.removeAllElements();
		v3a.removeAllElements();
		v4a.removeAllElements();
		v5a.removeAllElements();
		v6a.removeAllElements();
		v7a.removeAllElements();
		v8a.removeAllElements();
		v9a.removeAllElements();
		soonDeathArray.removeAllElements();
		monsterVector.removeAllElements();
		heroSkillmonster.removeAllElements();
		buttleArray.removeAllElements();
		arrowArray.removeAllElements();
		magicArray.removeAllElements();
		slickballArray.removeAllElements();
		firelockArray.removeAllElements();
		criticalArray.removeAllElements();
		criticalArray1.removeAllElements();
		criticalArray2.removeAllElements();
		IceDrowVector.removeAllElements();
		stickVector.removeAllElements();
		deathArray.removeAllElements();
		isNowSoldierSay = false;
		isNowHeroSay = false;
	}

	private void startEnertGame() {
		cleanGameVar();
		if (!isTongtianta) {
			if (my.getNengliang() >= 2) {
				my.setNengliang(my.getNengliang() - 2);
			} else {
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("你的能量不足，不能开始游戏！");
				alertTimeFn(pt);
				return;
			}
		}
		clearMainImg();
		loadGameImg();
		Map.toaString();
		mapArray = Map.getMap();
		mapIndexOfIndex = 0;
		getMonster();
		page = Resource.PAGE_INDEX[2];
		index = 0;
		count = 0;
		startAddTime = 0;
		indexSelect = -1;
		stopState = false;
		suggestAndStopEndTime = 0;
		boss8StoneNum = 0;
		for (int yu = 0; yu < 3; yu++) {
			useProp[yu] = 0;
		}
		suggestIndex = 0;
		suggestAndStopStartTime = System.currentTimeMillis();
		gameIndex = 4;
		isSuggest = true;
		heroStateLength = 0;
		heroStateIndex = 0;
		isNowHeroSay = false;
		isNowSoldierSay = false;
		soldierATkTimes = 1;
		tempStar = 0;
		add = -1;
		hero = new Hero("xulingyun", Resource.saveSelectHero,
				Resource.isBelongMyOfHero[Resource.saveSelectHero],
				Upgrade.upgradeHeroDefence(
						Resource.isBelongMyOfHero[Resource.saveSelectHero],
						Resource.saveSelectHero), 22, 452,
				Upgrade.upgradeHeroBlood(
						Resource.isBelongMyOfHero[Resource.saveSelectHero],
						Resource.saveSelectHero), 0, 0,
				Upgrade.upgradeHeroBlood(
						Resource.isBelongMyOfHero[Resource.saveSelectHero],
						Resource.saveSelectHero));
		if (isEnhanceBoold) {
			drawUseProp10();
		}
		if (isEnhanceArmor) {
			drawUseProp9();
		}
		if (isEnhanceSoldierATK) {
			drawUseProp8();
		}
		ca = new CreatArray(img, hero);
		idPic = ca.randomArray();
		ca.setIdPic(idPic);
		hero.setSrc(img[11]);
		win1 = 0;
	}

	protected GameEngine(MIDlet midlet) {
		super(midlet);
		setRelease(false);
		gameButtonSelect = 0;
		page = Resource.PAGE_INDEX[0];
		mainIndex = -1;
		keyState = new KeyState();
		arrowIndex = 0;
		selectSoldierLocation = 0;
		selectSoldierindex = 0;
		mainPage3Index = -1;
		mainPage4Index = 0;
		tempMainPage0Index = 7;
		Resource.saveSelectHero = 0;
		shopPage = 0;
		shopSum = 11;
		isEnhanceBoold = false;
		isEnhanceSoldierATK = false;
		isEnhanceArmor = false;
		isTongtianta = false;
		shengjiIndex = 6;
		online = true;
		img[0] = Resource.loadImage(Resource.soldier0);
		img[1] = Resource.loadImage(Resource.soldier1);
		img[2] = Resource.loadImage(Resource.soldier2);
		img[3] = Resource.loadImage(Resource.soldier3);
		img[4] = Resource.loadImage(Resource.soldier4);
		img[5] = Resource.loadImage(Resource.soldier5);
		img[6] = Resource.loadImage(Resource.soldier6);
		img[7] = Resource.loadImage(Resource.soldier7);
		img[8] = Resource.loadImage(Resource.soldier8);
		img[9] = Resource.loadImage(Resource.arrows);
		img[10] = Resource.loadImage(Resource.back0);
		img[11] = Resource.loadImage(Resource.hero);
		img[12] = Resource.loadImage(Resource.selectbox1);
		img[13] = Resource.loadImage(Resource.selectbox2);
		img[14] = Resource.loadImage(Resource.select2);
		img[15] = Resource.loadImage(Resource.star);
		img[16] = Resource.loadImage(Resource.number);
		img[17] = Resource.loadImage(Resource.money);
		img[18] = Resource.loadImage(Resource.newbox);
		img[19] = Resource.loadImage(Resource.newtext);
		img[20] = Resource.loadImage(Resource.chengjiupanel);
		loadMainImg();
		attainmentPanelStartTime = 0;
		isUnfoldAttainment = false;
		UnfoldAttainmentIndex = -1;
	}

	private void loadGameBg(int index) {
		if (index == 0) {
			img[temp_img_distance2 + 0] = Resource.loadImage(Resource.bg0);
		} else if (index == 1) {
			img[temp_img_distance2 + 1] = Resource.loadImage(Resource.bg1);
		} else if (index == 2) {
			img[temp_img_distance2 + 2] = Resource.loadImage(Resource.bg2);
		} else if (index == 3) {
			img[temp_img_distance2 + 3] = Resource.loadImage(Resource.bg3);
		} else if (index == 4) {
			img[temp_img_distance2 + 4] = Resource.loadImage(Resource.bg4);
		} else if (index == 5) {
			img[temp_img_distance2 + 5] = Resource.loadImage(Resource.bg5);
		}
	}

	public void loadGameImg() {
		img[temp_img_distance1 - 6 + 41] = Resource.loadImage(Resource.queding);
		img[temp_img_distance1 - 6 + 15] = Resource.loadImage(Resource.button1);
		img[temp_img_distance1 - 6 + 16] = Resource.loadImage(Resource.button2);
		img[temp_img_distance1 - 6 + 53] = Resource.loadImage(Resource.shopx2);
		img[temp_img_distance1 - 6 + 39] = Resource.loadImage(Resource.panel1);
		if (tongtiantaAndNormalBigGuanqia == 0)
			loadGameBg(tongtiantaAndNormalBigGuanqia);
		else if (tongtiantaAndNormalBigGuanqia < 7)
			loadGameBg(tongtiantaAndNormalBigGuanqia - 1);
		img[temp_img_distance2 + 7] = Resource.loadImage(Resource.monster1);
		img[temp_img_distance2 + 8] = Resource.loadImage(Resource.monster2);
		img[temp_img_distance2 + 9] = Resource.loadImage(Resource.monster3);
		img[temp_img_distance2 + 10] = Resource.loadImage(Resource.monster4);
		img[temp_img_distance2 + 11] = Resource.loadImage(Resource.monster5);
		img[temp_img_distance2 + 12] = Resource.loadImage(Resource.monster6);
		img[temp_img_distance2 + 13] = Resource.loadImage(Resource.monster7);
		img[temp_img_distance2 + 14] = Resource.loadImage(Resource.monster8);
		img[temp_img_distance2 + 15] = Resource.loadImage(Resource.monster9);
		img[temp_img_distance2 + 16] = Resource.loadImage(Resource.monster10);
		img[temp_img_distance2 + 17] = Resource.loadImage(Resource.monster11);
		img[temp_img_distance2 + 18] = Resource.loadImage(Resource.monster12);
		img[temp_img_distance2 + 19] = Resource.loadImage(Resource.monster13);
		img[temp_img_distance2 + 20] = Resource.loadImage(Resource.boss1);
		img[temp_img_distance2 + 21] = Resource.loadImage(Resource.boss2);
		img[temp_img_distance2 + 22] = Resource.loadImage(Resource.boss3);
		img[temp_img_distance2 + 23] = Resource.loadImage(Resource.boss4);
		img[temp_img_distance2 + 24] = Resource.loadImage(Resource.boss5);
		img[temp_img_distance2 + 25] = Resource.loadImage(Resource.boss6);
		img[temp_img_distance2 + 26] = Resource.loadImage(Resource.boss7);
		img[temp_img_distance2 + 27] = Resource.loadImage(Resource.boss8);
		img[temp_img_distance2 + 28] = Resource.loadImage(Resource.bloodmagic);
		img[temp_img_distance2 + 29] = Resource.loadImage(Resource.bmbar);
		img[temp_img_distance2 + 30] = Resource.loadImage(Resource.powerbar);
		img[temp_img_distance2 + 31] = Resource.loadImage(Resource.powerbarbg);
		img[temp_img_distance2 + 32] = Resource.loadImage(Resource.powerbg1);
		img[temp_img_distance2 + 33] = Resource.loadImage(Resource.powerbg2);
		img[temp_img_distance2 + 34] = Resource.loadImage(Resource.herobg);
		img[temp_img_distance2 + 35] = Resource.loadImage(Resource.toolnumkey);
		img[temp_img_distance2 + 36] = Resource.loadImage(Resource.zhandouleft);
		img[temp_img_distance2 + 37] = Resource
				.loadImage(Resource.zhandoumiddle);
		img[temp_img_distance2 + 38] = Resource
				.loadImage(Resource.zhandouright);
		img[temp_img_distance2 + 39] = Resource.loadImage(Resource.monsterdie);
		img[temp_img_distance2 + 40] = Resource.loadImage(Resource.attackhero);
		img[temp_img_distance2 + 41] = Resource.loadImage(Resource.boss1attack);
		img[temp_img_distance2 + 42] = Resource.loadImage(Resource.boss2attack);
		img[temp_img_distance2 + 43] = Resource
				.loadImage(Resource.boss3attack1);
		img[temp_img_distance2 + 44] = Resource
				.loadImage(Resource.boss3attack2);
		img[temp_img_distance2 + 45] = Resource.loadImage(Resource.boss4attack);
		img[temp_img_distance2 + 46] = Resource.loadImage(Resource.boss5attack);
		img[temp_img_distance2 + 47] = Resource.loadImage(Resource.boss6m);
		img[temp_img_distance2 + 48] = Resource
				.loadImage(Resource.boss6mattack);
		img[temp_img_distance2 + 49] = Resource
				.loadImage(Resource.boss78attack);
		img[temp_img_distance2 + 50] = Resource.loadImage(Resource.soldier21);
		img[temp_img_distance2 + 51] = Resource.loadImage(Resource.soldier22);
		img[temp_img_distance2 + 52] = Resource.loadImage(Resource.soldier31);
		img[temp_img_distance2 + 53] = Resource.loadImage(Resource.soldier32);
		img[temp_img_distance2 + 54] = Resource.loadImage(Resource.soldier81);
		img[temp_img_distance2 + 55] = Resource.loadImage(Resource.soldier91);
		img[temp_img_distance2 + 56] = Resource.loadImage(Resource.bullet1);
		img[temp_img_distance2 + 57] = Resource.loadImage(Resource.bullet2);
		img[temp_img_distance2 + 58] = Resource.loadImage(Resource.powerbg3);
		img[temp_img_distance2 + 59] = Resource.loadImage(Resource.bosspower1);
		img[temp_img_distance2 + 60] = Resource.loadImage(Resource.bosspower2);
		img[temp_img_distance2 + 61] = Resource.loadImage(Resource.bossblood1);
		img[temp_img_distance2 + 62] = Resource.loadImage(Resource.bossblood2);
		img[temp_img_distance2 + 63] = Resource.loadImage(Resource.hero1skill);
		img[temp_img_distance2 + 64] = Resource
				.loadImage(Resource.attacknumber);
		img[temp_img_distance2 + 65] = Resource.loadImage(Resource.baojibg);
		img[temp_img_distance2 + 66] = Resource.loadImage(Resource.stopimg);
		img[temp_img_distance2 + 67] = Resource.loadImage(Resource.hero4skill);
		img[temp_img_distance2 + 68] = Resource
				.loadImage(Resource.boss87attack);
		img[temp_img_distance2 + 69] = Resource.loadImage(Resource.hero3skill);
		img[temp_img_distance2 + 70] = Resource.loadImage(Resource.hero5skill);
		img[temp_img_distance2 + 71] = Resource.loadImage(Resource.hero6skill);
		img[temp_img_distance2 + 72] = Resource.loadImage(Resource.soldier51);
		img[temp_img_distance2 + 73] = Resource.loadImage(Resource.soldier52);
		img[temp_img_distance2 + 74] = Resource.loadImage(Resource.soldier53);
		img[temp_img_distance2 + 75] = Resource.loadImage(Resource.soldier92);
		img[temp_img_distance2 + 76] = Resource.loadImage(Resource.soldier71);
		img[temp_img_distance2 + 77] = Resource.loadImage(Resource.soldier33);
		img[temp_img_distance2 + 78] = Resource.loadImage(Resource.hero2skill);
		img[temp_img_distance2 + 79] = Resource
				.loadImage(Resource.shenglishibai);
		img[temp_img_distance2 + 80] = Resource.loadImage(Resource.star1);
		img[temp_img_distance2 + 81] = Resource.loadImage(Resource.buff);
		img[temp_img_distance2 + 82] = Resource.loadImage(Resource.herosay1);
		img[temp_img_distance2 + 83] = Resource.loadImage(Resource.herosay2);
		img[temp_img_distance2 + 84] = Resource.loadImage(Resource.shanmove);
		img[temp_img_distance2 + 85] = Resource.loadImage(Resource.zhongdu);
		img[temp_img_distance1 - 6 + 51] = Resource
				.loadImage(Resource.shoptool);
		img[temp_img_distance1 - 6 + 50] = Resource
				.loadImage(Resource.shopthingnum);
		img[temp_img_distance1 - 6 + 66] = Resource
				.loadImage(Resource.attainment_finish);
		img[temp_img_distance1 - 6 + 68] = Resource.loadImage(Resource.fight);
	}

	public void loadMainImg() {
		img[temp_img_distance1 + 0] = Resource.loadImage(Resource.awardbutton);
		img[temp_img_distance1 + 1] = Resource.loadImage(Resource.bg6);
		img[temp_img_distance1 + 2] = Resource.loadImage(Resource.bg10);
		img[temp_img_distance1 + 3] = Resource.loadImage(Resource.bg11);
		img[temp_img_distance1 - 6 + 10] = Resource.loadImage(Resource.bgleft);
		img[temp_img_distance1 - 6 + 11] = Resource
				.loadImage(Resource.bgmiddle);
		img[temp_img_distance1 - 6 + 12] = Resource.loadImage(Resource.bgright);
		img[temp_img_distance1 - 6 + 13] = Resource
				.loadImage(Resource.biankuang);
		img[temp_img_distance1 - 6 + 14] = Resource
				.loadImage(Resource.bingzhonginfo);
		img[temp_img_distance1 - 6 + 15] = Resource.loadImage(Resource.button1);
		img[temp_img_distance1 - 6 + 16] = Resource.loadImage(Resource.button2);
		img[temp_img_distance1 - 6 + 17] = Resource
				.loadImage(Resource.buttonbg);
		img[temp_img_distance1 - 6 + 18] = Resource
				.loadImage(Resource.buttontext1);
		img[temp_img_distance1 - 6 + 19] = Resource
				.loadImage(Resource.buttontext2);
		img[temp_img_distance1 - 6 + 20] = Resource
				.loadImage(Resource.buyandshengji);
		img[temp_img_distance1 - 6 + 21] = Resource.loadImage(Resource.caifu);
		img[temp_img_distance1 - 6 + 22] = Resource.loadImage(Resource.fire);
		img[temp_img_distance1 - 6 + 23] = Resource
				.loadImage(Resource.grasslands);
		img[temp_img_distance1 - 6 + 24] = Resource.loadImage(Resource.guanqia);
		img[temp_img_distance1 - 6 + 25] = Resource
				.loadImage(Resource.guanqiapj);
		img[temp_img_distance1 - 6 + 26] = Resource
				.loadImage(Resource.heroinfoall);
		img[temp_img_distance1 - 6 + 27] = Resource
				.loadImage(Resource.guanqiatext);
		img[temp_img_distance1 - 6 + 28] = Resource.loadImage(Resource.herobig);
		img[temp_img_distance1 - 6 + 29] = Resource
				.loadImage(Resource.heroinfo);
		img[temp_img_distance1 - 6 + 30] = Resource.loadImage(Resource.ice);
		img[temp_img_distance1 - 6 + 31] = Resource
				.loadImage(Resource.leftright);
		img[temp_img_distance1 - 6 + 32] = Resource.loadImage(Resource.login);
		img[temp_img_distance1 - 6 + 33] = Resource
				.loadImage(Resource.logintext);
		img[temp_img_distance1 - 6 + 34] = Resource
				.loadImage(Resource.myherotext);
		img[temp_img_distance1 - 6 + 35] = Resource
				.loadImage(Resource.mysoldertext);
		img[temp_img_distance1 - 6 + 36] = Resource
				.loadImage(Resource.newcomer);
		img[temp_img_distance1 - 6 + 37] = Resource
				.loadImage(Resource.selecthero);
		img[temp_img_distance1 - 6 + 38] = Resource
				.loadImage(Resource.numberbig);
		img[temp_img_distance1 - 6 + 39] = Resource.loadImage(Resource.panel1);
		img[temp_img_distance1 - 6 + 40] = Resource.loadImage(Resource.pit);
		img[temp_img_distance1 - 6 + 41] = Resource.loadImage(Resource.queding);
		img[temp_img_distance1 - 6 + 42] = Resource
				.loadImage(Resource.selectforce);
		img[temp_img_distance1 - 6 + 43] = Resource.loadImage(Resource.shopbag);
		img[temp_img_distance1 - 6 + 44] = Resource.loadImage(Resource.shopbar);
		img[temp_img_distance1 - 6 + 45] = Resource
				.loadImage(Resource.shopleft);
		img[temp_img_distance1 - 6 + 46] = Resource
				.loadImage(Resource.shopmiddle);
		img[temp_img_distance1 - 6 + 47] = Resource
				.loadImage(Resource.shopright);
		img[temp_img_distance1 - 6 + 48] = Resource
				.loadImage(Resource.shopselect);
		img[temp_img_distance1 - 6 + 49] = Resource
				.loadImage(Resource.shoptext);
		img[temp_img_distance1 - 6 + 50] = Resource
				.loadImage(Resource.shopthingnum);
		img[temp_img_distance1 - 6 + 51] = Resource
				.loadImage(Resource.shoptool);
		img[temp_img_distance1 - 6 + 52] = Resource.loadImage(Resource.shopx1);
		img[temp_img_distance1 - 6 + 53] = Resource.loadImage(Resource.shopx2);
		img[temp_img_distance1 - 6 + 54] = Resource
				.loadImage(Resource.somewherename);
		img[temp_img_distance1 - 6 + 55] = Resource
				.loadImage(Resource.titlebingzhong);
		img[temp_img_distance1 - 6 + 56] = Resource
				.loadImage(Resource.titlehero);
		img[temp_img_distance1 - 6 + 57] = Resource
				.loadImage(Resource.udanddown);
		img[temp_img_distance1 - 6 + 58] = Resource.loadImage(Resource.wujin);
		img[temp_img_distance1 - 6 + 59] = Resource
				.loadImage(Resource.awardtext);
		img[temp_img_distance1 - 6 + 60] = Resource.loadImage(Resource.jbar);
		img[temp_img_distance1 - 6 + 61] = Resource.loadImage(Resource.nbar);
		img[temp_img_distance1 - 6 + 62] = Resource.loadImage(Resource.help1);
		img[temp_img_distance1 - 6 + 63] = Resource.loadImage(Resource.help2);
		img[temp_img_distance1 - 6 + 64] = Resource.loadImage(Resource.use);
		img[temp_img_distance1 - 6 + 65] = Resource
				.loadImage(Resource.attainment_icon);
		img[temp_img_distance1 - 6 + 66] = Resource
				.loadImage(Resource.attainment_finish);
		img[temp_img_distance1 - 6 + 67] = Resource
				.loadImage(Resource.stopandgo);
		img[temp_img_distance1 - 6 + 68] = Resource.loadImage(Resource.fight);
		img[temp_img_distance1 - 6 + 69] = Resource.loadImage(Resource.lock);
		img[temp_img_distance1 - 6 + 70] = Resource
				.loadImage(Resource.gongxini);
		img[temp_img_distance1 - 6 + 71] = Resource
				.loadImage(Resource.daojishinum);
		img[temp_img_distance1 - 6 + 72] = Resource.loadImage(Resource.upgreat);
		img[temp_img_distance1 - 6 + 73] = Resource.loadImage(Resource.uparrow);
		img[temp_img_distance2 + 34] = Resource.loadImage(Resource.herobg);
	}

	public void clearMainImg() {
		for (int i = 21; i < temp_img_distance2; i++)
			img[i] = null;
	}

	public void clearGameImg() {
		for (int i = temp_img_distance1; i < img.length; i++)
			img[i] = null;
	}

	int wcs = 0;

	private void handleMainKey3(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (mainPage3Index == 0) {
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				if (my.getMoney() >= needMoney) {
					if (Resource.isBelongMyOfHero[mainPageIndex[3]] == 0) {
						if (mainPageIndex[3] == 1 && my.getLevel() < 5) {
							pt.setText(Resource.someUpGreatInfoH[mainPageIndex[3]]);
						} else if (mainPageIndex[3] == 2 && my.getLevel() < 10) {
							pt.setText(Resource.someUpGreatInfoH[mainPageIndex[3]]);
						} else if (mainPageIndex[3] == 3 && my.getLevel() < 10) {
							pt.setText(Resource.someUpGreatInfoH[mainPageIndex[3]]);
						} else if (mainPageIndex[3] == 4
								&& Resource.guanqiaLevel[19] <= 0) {
							pt.setText(Resource.someUpGreatInfoH[mainPageIndex[3]]);
						} else if (mainPageIndex[3] == 5
								&& Resource.tongtiantafloor < 30) {
							pt.setText(Resource.someUpGreatInfoH[mainPageIndex[3]]);
						} else {
							pt.setText("购买成功！");
							my.setMoney(my.getMoney() - needMoney);
							Resource.isBelongMyOfHero[mainPageIndex[3]]++;
						}
					} else {
						if (Resource.isBelongMyOfHero[mainPageIndex[3]] == 20) {
							pt.setText("亲，你的英雄等级已满，不能在升级了！");
						} else {
							pt.setText("升级成功！");
							my.setMoney(my.getMoney() - needMoney);
							Resource.isBelongMyOfHero[mainPageIndex[3]]++;
							if (Resource.isBelongMyOfHero[mainPageIndex[3]] == 20) {
								UnfoldAttainmentIndex = 17 + mainPageIndex[3];
								if (Resource.isFinishAttainment[UnfoldAttainmentIndex] != 1) {
									attainmentPanelStartTime = System
											.currentTimeMillis();
									isUnfoldAttainment = true;
									my.setMoney(my.getMoney()
											+ Resource.AttainmentMoney[UnfoldAttainmentIndex]);
									Resource.isFinishAttainment[UnfoldAttainmentIndex] = 1;
								}
							}
						}
					}
				} else {
					pt.setText("金币不足！");
				}
				alertTimeFn(pt);
			} else if (mainPage3Index == 1) {
				if (Resource.isBelongMyOfHero[mainPageIndex[3]] == 0) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("你尚未拥有该英雄！");
					alertTimeFn(pt);
				} else {
					Resource.saveSelectHero = (byte) mainPageIndex[3];
				}
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (mainPage3Index == -1) {
				if (mainPageIndex[3] > 0)
					mainPageIndex[3]--;
				else
					mainPageIndex[3] = 5;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (mainPage3Index == -1) {
				if (mainPageIndex[3] < 5)
					mainPageIndex[3]++;
				else
					mainPageIndex[3] = 0;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (mainPage3Index == 1) {
				mainPage3Index = 0;
			} else
				mainPage3Index = -1;
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (mainPage3Index == -1) {
				mainPage3Index = 0;
			} else if (mainPage3Index == 0) {
				mainPage3Index = 1;
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			if (enterWay == 0)
				mainIndex = 0;
			else
				mainIndex = 2;
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (isDebugMode()) {
				if (wcs < 21) {
					my.setLevel(my.getLevel() + 1);
				} else if (wcs == 21) {
					for (int oi = 0; oi < 25; oi++)
						Resource.guanqiaLevel[oi] = 3;
				} else {
					Resource.tongtiantafloor = 30;
				}
				wcs++;
			}
		}
	}

	private void alertTimeFn(PopupText pt) {
		alertTime = System.currentTimeMillis();
		pt.popup();
		alertSumTime = System.currentTimeMillis() - alertTime;
	}

	int nowUpgreadSoldierIndex;

	private void handleMainKey4(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (isLoadSold != -1)
				return;
			if (mainPage4Index == 1) {
				int num = changeSoldier();
				if (num == 2) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("兵种已满，请先卸载其它兵种。");
					alertTimeFn(pt);
				} else if (num == 3) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("你尚未拥有该兵种！");
					alertTimeFn(pt);
				}
			} else if (mainPage4Index == 0) {
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				if (Resource.heroAndSoldierLevel[selectSoldierindex] > 0) {// 升级
					if (my.getMoney() >= Upgrade.upgradeSoldierMoney(
							Resource.heroAndSoldierLevel[selectSoldierindex],
							selectSoldierindex + 1)) {
						if (Resource.heroAndSoldierLevel[selectSoldierindex] == 20) {
							pt.setText("亲，你的士兵等级已满，不能在升级了！");
						} else {
							pt.setText("升级成功！");
							nowUpgreadSoldierIndex = selectSoldierLocation;
							shengjiIndex = 0;
							my.setMoney(my.getMoney()
									- Upgrade
											.upgradeSoldierMoney(
													Resource.heroAndSoldierLevel[selectSoldierindex],
													selectSoldierindex + 1));
							Resource.heroAndSoldierLevel[selectSoldierindex]++;
							if (Resource.heroAndSoldierLevel[selectSoldierindex] == 20) {
								UnfoldAttainmentIndex = 23 + selectSoldierindex;
								if (Resource.isFinishAttainment[UnfoldAttainmentIndex] != 1) {
									attainmentPanelStartTime = System
											.currentTimeMillis();
									isUnfoldAttainment = true;
									my.setMoney(my.getMoney()
											+ Resource.AttainmentMoney[UnfoldAttainmentIndex]);
									Resource.isFinishAttainment[UnfoldAttainmentIndex] = 1;
								}
							}
						}
					} else {
						pt.setText("金币不足，升级失败！请到商店购买金币。");
					}
					alertTimeFn(pt);
				} else {// 购买
					if (my.getMoney() >= Resource.soldierMoney[selectSoldierindex]) {
						if (selectSoldierindex == 4
								&& Resource.guanqiaLevel[9] < 0) {
							pt.setText("通关索米亚草原！");
						} else if (selectSoldierindex == 5
								&& Resource.guanqiaLevel[9] < 0) {
							pt.setText("通关索米亚草原！");
						} else if (selectSoldierindex == 6
								&& Resource.guanqiaLevel[19] < 0) {
							pt.setText("通关怨灵地窟！");
						} else if (selectSoldierindex == 7
								&& Resource.guanqiaLevel[19] < 0) {
							pt.setText("通关怨灵地窟！");
						} else if (selectSoldierindex == 8
								&& Resource.guanqiaLevel[29] < 0) {
							pt.setText("通关冰霜大陆！");
						} else {
							pt.setText("购买成功！");
							my.setMoney(my.getMoney()
									- Resource.soldierMoney[selectSoldierindex]);
							Resource.heroAndSoldierLevel[selectSoldierindex]++;
						}
					} else {
						pt.setText("购买失败，金币不足！请到商店购买金币。");
					}
					alertTimeFn(pt);
				}
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (mainPage4Index == -1) {
				if (selectSoldierLocation > 0) {
					selectSoldierLocation--;
				}
				if (selectSoldierindex > 0) {
					selectSoldierindex--;
				}
			}
			if (mainPage4Index == 1) {
				mainPage4Index = 0;
			} else if (mainPage4Index == 0) {
				if (selectSoldierLocation > 0) {
					selectSoldierLocation--;
					mainPage4Index = 1;
				}
				if (selectSoldierindex > 0) {
					selectSoldierindex--;
					mainPage4Index = 1;
				}
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (mainPage4Index == 0) {
				mainPage4Index = 1;
			} else if (mainPage4Index == 1) {
				if (selectSoldierLocation < 3) {
					selectSoldierLocation++;
					mainPage4Index = 0;
				}
				if (selectSoldierindex < 8) {
					mainPage4Index = 0;
					selectSoldierindex++;
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			for (int i = 0; i < 4; i++) {
				if (Resource.savaSelcetSoldier[i] == -1) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("兵种不足四个！");
					alertTimeFn(pt);
					break;
				} else if (i == 3) {
					if (enterWay == 0) {
						mainIndex = 0;
					} else {
						mainIndex = 2;
					}
					mainPageIndex[4] = 0;
					selectSoldierLocation = 0;
					selectSoldierindex = 0;
				}

			}
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (isDebugMode()) {
				Resource.guanqiaLevel[pps] = 2;
				pps++;
			}
		}
	}

	int pps = 0;

	private void handleMainKey2(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (!isSaodang) {
				if (mainPageIndex[2] == 0) {
					startEnertGame();
				} else if (mainPageIndex[2] == 1 && !isTongtianta) {
					if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
							* 10 + tongtiantaAndNormalSmallGuanqia] == 3) {
						if (my.getNengliang() >= 2) {
							my.setNengliang(my.getNengliang() - 2);
							isSaodang = true;
							saodangTime = System.currentTimeMillis();
						} else {
							PopupText pt = UIResource.getInstance()
									.buildDefaultPopupText();
							pt.setText("你的能量不足，不能开始扫荡！");
							alertTimeFn(pt);
							return;
						}
					} else {
						PopupText pt = UIResource.getInstance()
								.buildDefaultPopupText();
						pt.setText("该关卡未获得3星评价，不能进行扫荡！");
						alertTimeFn(pt);
					}
				} else if (mainPageIndex[2] == 2) {
					enterWay = 1;
					mainIndex = 3;
				} else if (mainPageIndex[2] == 3) {
					enterWay = 1;
					mainIndex = 4;
					isLoadSold = -1;
				}
			} else {
				if (saodangIndex == 0) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否停止扫荡？");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						isSaodang = false;
						saodangTime = 0;
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else if (saodangIndex == 1) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否使用" + pm.props[12].getPrice() + "TV币进行加速扫荡？");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(147, 1, g);
						if (flag) {
							saodangTime = 300;
							if (isDoubleMoney) {
								winMoney = Upgrade
										.guanqiaMoney((tongtiantaAndNormalBigGuanqia - 1)
												* 10
												+ tongtiantaAndNormalSmallGuanqia) * 2;
							} else {
								winMoney = Upgrade
										.guanqiaMoney((tongtiantaAndNormalBigGuanqia - 1)
												* 10
												+ tongtiantaAndNormalSmallGuanqia);
							}

							if (isDoubleExp) {
								winExp = Upgrade
										.guanqiaExp((tongtiantaAndNormalBigGuanqia - 1)
												* 10
												+ tongtiantaAndNormalSmallGuanqia) * 2;
							} else {
								winExp = Upgrade
										.guanqiaExp((tongtiantaAndNormalBigGuanqia - 1)
												* 10
												+ tongtiantaAndNormalSmallGuanqia);
							}
							changeLeaderOfProperty(winMoney, winExp);
							isDoubleMoney = false;
							isDoubleExp = false;
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else if (saodangIndex == 2) {
					saodangIndex = 1;
					isSaodang = false;
					saodangTime = 0;
				}
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (!isSaodang) {
				if (isTongtianta) {
					if (mainPageIndex[2] == 2) {
						mainPageIndex[2]++;
					} else if (mainPageIndex[2] == 3) {
						mainPageIndex[2]--;
					}
				} else {
					if (mainPageIndex[2] == 0 || mainPageIndex[2] == 2) {
						mainPageIndex[2]++;
					} else if (mainPageIndex[2] == 1 || mainPageIndex[2] == 3) {
						mainPageIndex[2]--;
					}
				}
			} else if (isSaodang) {
				if (saodangIndex == 1)
					saodangIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (!isSaodang) {
				if (isTongtianta) {
					if (mainPageIndex[2] == 2) {
						mainPageIndex[2]++;
					} else if (mainPageIndex[2] == 3) {
						mainPageIndex[2]--;
					}
				} else {
					if (mainPageIndex[2] == 0 || mainPageIndex[2] == 2) {
						mainPageIndex[2]++;
					} else if (mainPageIndex[2] == 1 || mainPageIndex[2] == 3) {
						mainPageIndex[2]--;
					}
				}
			} else if (isSaodang) {
				if (saodangIndex == 0)
					saodangIndex = 1;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (!isSaodang) {

				if (isTongtianta) {
					if (mainPageIndex[2] == 0) {
						mainPageIndex[2] += 2;
					} else if (mainPageIndex[2] == 2 || mainPageIndex[2] == 3) {
						mainPageIndex[2] = 0;
					}
				} else {
					if (mainPageIndex[2] == 0 || mainPageIndex[2] == 1) {
						mainPageIndex[2] += 2;
					} else if (mainPageIndex[2] == 2 || mainPageIndex[2] == 3) {
						mainPageIndex[2] -= 2;
					}
				}
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (!isSaodang) {
				if (isTongtianta) {
					if (mainPageIndex[2] == 0) {
						mainPageIndex[2] += 2;
					} else if (mainPageIndex[2] == 2 || mainPageIndex[2] == 3) {
						mainPageIndex[2] = 0;
					}
				} else {
					if (mainPageIndex[2] == 0 || mainPageIndex[2] == 1) {
						mainPageIndex[2] += 2;
					} else if (mainPageIndex[2] == 2 || mainPageIndex[2] == 3) {
						mainPageIndex[2] -= 2;
					}
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			if (!isSaodang) {
				mainIndex = 1;
				mainPageIndex[2] = 0;
			}
		}
	}

	private void changeLeaderOfProperty(long money, long exp) {
		my.setMoney(my.getMoney() + money);
		my.setExp(my.getExp() + exp);
		while (my.getExp() >= Upgrade.upgradeLeaderExp(my.getLevel())) {
			my.setExp(my.getExp() - Upgrade.upgradeLeaderExp(my.getLevel()));
			my.setLevel(my.getLevel() + 1);
			my.setNengliang(my.getNengliang() + my.getNengliang() / 2);
			if (my.getNengliang() > Upgrade.upgradeLeaderNengliang((int) (my
					.getLevel()))) {
				my.setNengliang(Upgrade.upgradeLeaderNengliang((int) (my
						.getLevel())));
			}
		}
	}

	private void handleMainKey1(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (!isTongtianta) {
				tongtiantaAndNormalSmallGuanqia = mainPageIndex[1];
				if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
						* 10 + tongtiantaAndNormalSmallGuanqia] >= 0
						|| isDebugMode())
					mainIndex = 2;
			} else {
				if (Resource.count_c_t[1] == 1) {
					mainIndex = 2;
					if (tongtiantaIndex == 0) {
						tempFloor = 0;
						tongtiantaAndNormalBigGuanqia = 1;
						tongtiantaAndNormalSmallGuanqia = 0;
					} else {
						tongtiantaAndNormalBigGuanqia = Resource.tongtiantafloor / 10 + 1;
						tongtiantaAndNormalSmallGuanqia = Resource.tongtiantafloor % 10;
					}
				} else {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否花费" + pm.props[14].getPrice()
							+ "TV币购买无尽之钥道具一次进入通天塔的机会？");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(149, 1, g);
						if (flag) {
							Resource.count_c_t[1] = 1;
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				}
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (!isTongtianta) {
				if (mainPageIndex[1] > 0) {
					mainPageIndex[1]--;
					tongtiantaAndNormalSmallGuanqia--;
				}
			} else {
				if (tongtiantaIndex == 1)
					tongtiantaIndex = 0;
				else
					tongtiantaIndex = 1;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (!isTongtianta) {
				if (mainPageIndex[1] < 9) {
					mainPageIndex[1]++;
					tongtiantaAndNormalSmallGuanqia++;
				}
			} else {
				if (tongtiantaIndex == 1)
					tongtiantaIndex = 0;
				else
					tongtiantaIndex = 1;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (!isTongtianta) {
				if (mainPageIndex[1] < 5) {
					mainPageIndex[1] += 5;
					tongtiantaAndNormalSmallGuanqia += 5;
				} else {
					mainPageIndex[1] -= 5;
					tongtiantaAndNormalSmallGuanqia -= 5;
				}
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (!isTongtianta) {
				if (mainPageIndex[1] < 5) {
					mainPageIndex[1] += 5;
					tongtiantaAndNormalSmallGuanqia += 5;
				} else {
					mainPageIndex[1] -= 5;
					tongtiantaAndNormalSmallGuanqia -= 5;
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			if (!isTongtianta) {
				mainPageIndex[1] = 0;
				tongtiantaAndNormalSmallGuanqia = 0;
			} else {
				isTongtianta = false;
				tongtiantaIndex = 1;
			}
			mainIndex = 0;
		}
	}

	public void handleMainKey0(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			tongtiantaAndNormalBigGuanqia = mainPageIndex[0];
			if (mainPageIndex[0] < 5) {
				if (mainPageIndex[0] == 0) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("你已经不是新手了，请去其他关卡冒险吧！");
					alertTimeFn(pt);
					return;
				}
				isSaodang = false;
				saodangIndex = 1;
				mainPageIndex[1] = 0;
				tongtiantaAndNormalSmallGuanqia = 0;
				mainIndex = 1;
			} else if (mainPageIndex[0] == 5) {
				int temp_x = 25;
				int temp_y = 100;
				for (int r = 0; r < 12; r++) {
					if (r >= 0 && r < 4) {
						p[r] = new Point(temp_x + 35 + (r % 4) * 80,
								temp_y + 50, r);
					} else if (r >= 4 && r < 7) {
						p[r] = new Point(temp_x + 275, temp_y + 50
								+ ((r % 4) + 1) * 80, r);
					} else if (r >= 7 && r < 10) {
						p[r] = new Point(temp_x + 275 - (r - 6) * 80,
								temp_y + 290, r);
					} else if (r >= 10 && r < 12) {
						p[r] = new Point(temp_x + 35, temp_y + 290 - (r - 9)
								* 80, r);
					}
				}
				isAlertAward = false;
				tempWinNum = 0;
				sumCircleNum = 0;
				stopCount = -1;
				circleNum = 0;
				startAward = false;
				weiyiCount = 0;
				winNum = 0;
				mainIndex = 6;
			} else if (mainPageIndex[0] == 6) {
				if (Resource.guanqiaLevel[9] < 0) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("通关索米亚草原才能解锁！");
					isTongtianta = false;
					alertTimeFn(pt);
				} else {
					mainIndex = 1;
					tongtiantaIndex = 1;
					isTongtianta = true;
				}
			} else if (mainPageIndex[0] == 7) {
				enterWay = 0;
				mainIndex = 3;
			} else if (mainPageIndex[0] == 8) {
				enterWay = 0;
				mainIndex = 4;
			} else if (mainPageIndex[0] == 9) {
				shopArea = 1;
				mainIndex = 7;
				canGoodsIndex = 0;
				selectShopSmallIndex = 0;
			} else if (mainPageIndex[0] == 10) {
				attainmentPage = 0;
				mainIndex = 8;
			} else if (mainPageIndex[0] == 11) {
				online = false;
				sag.saveData();
				exit = true;
				for (int op = 0; op < img.length; op++) {
					img[op] = null;
				}
			} else if (mainPageIndex[0] == 12) {
				mainIndex = 12;
				isHelp = true;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (mainPageIndex[0] >= 1 && mainPageIndex[0] < 3) {
				mainPageIndex[0]--;
				tongtiantaAndNormalBigGuanqia--;
				arrowIndex = 0;
			} else if (mainPageIndex[0] >= 3 && mainPageIndex[0] < 5) {
				mainPageIndex[0]++;
				tongtiantaAndNormalBigGuanqia++;
				arrowIndex = 0;
			} else if (mainPageIndex[0] > 7 && mainPageIndex[0] <= 11) {
				mainPageIndex[0]--;
				tongtiantaAndNormalBigGuanqia--;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 7) {
				mainPageIndex[0] = 12;
				tongtiantaAndNormalBigGuanqia = 12;
				arrowIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (mainPageIndex[0] >= 0 && mainPageIndex[0] < 2) {
				mainPageIndex[0]++;
				tongtiantaAndNormalBigGuanqia++;
				arrowIndex = 0;
			} else if (mainPageIndex[0] > 3 && mainPageIndex[0] <= 5) {
				mainPageIndex[0]--;
				tongtiantaAndNormalBigGuanqia--;
				arrowIndex = 0;
			} else if (mainPageIndex[0] >= 7 && mainPageIndex[0] < 11) {
				mainPageIndex[0]++;
				tongtiantaAndNormalBigGuanqia++;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 12) {
				mainPageIndex[0] = 7;
				tongtiantaAndNormalBigGuanqia = 7;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (mainPageIndex[0] == 5) {
				mainPageIndex[0] = 0;
				tongtiantaAndNormalBigGuanqia = 0;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 4) {
				mainPageIndex[0] = 1;
				tongtiantaAndNormalBigGuanqia = 1;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 3) {
				mainPageIndex[0] = 2;
				tongtiantaAndNormalBigGuanqia = 2;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 2) {
				mainPageIndex[0] = 6;
				tongtiantaAndNormalBigGuanqia = 6;
				arrowIndex = 0;
			} else if (mainPageIndex[0] > 6) {
				int temp = tempMainPage0Index;
				tempMainPage0Index = mainPageIndex[0];
				mainPageIndex[0] = temp;
				tongtiantaAndNormalBigGuanqia = temp;
				arrowIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (mainPageIndex[0] == 0) {
				mainPageIndex[0] = 5;
				tongtiantaAndNormalBigGuanqia = 5;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 1) {
				mainPageIndex[0] = 4;
				tongtiantaAndNormalBigGuanqia = 4;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 2) {
				mainPageIndex[0] = 3;
				tongtiantaAndNormalBigGuanqia = 3;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 6) {
				mainPageIndex[0] = 2;
				tongtiantaAndNormalBigGuanqia = 2;
				arrowIndex = 0;
			} else if (mainPageIndex[0] == 3 || mainPageIndex[0] == 4
					|| mainPageIndex[0] == 5) {
				int temp = tempMainPage0Index;
				tempMainPage0Index = mainPageIndex[0];
				mainPageIndex[0] = temp;
				tongtiantaAndNormalBigGuanqia = temp;
				arrowIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (isDebugMode()) {
				my.setMoney(my.getMoney() + 1000000);
				my.setLevel(7);
				for (int opp = 0; opp < 35; opp++)
					Resource.guanqiaLevel[opp] = 2;
				Resource.tongtiantafloor = 32;
			}
		}
	}

	Bullet newBullet;

	private void handleNewGuide(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (newGuideIndex == 1) {
				newGuideIndex = 2;
				clearMainImg();
				loadGameImg();
				img[temp_img_distance1] = Resource.loadImage(Resource.bg0);
				newHero = new Hero("xulingyun", 0, 1, 10, 22, 452, 200, 10, 0,
						500);
				newHero.setSrc(img[11]);
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 3; j++) {
						if (i * 3 + j == 0 || i * 3 + j == 2 || i * 3 + j == 4) {
							newSoldier[i * 3 + j] = new Soldier("Soldier",
									img[1], 1, i + 2, j, 1, 0, 0, 0, 0, 0);
						} else {
							newSoldier[i * 3 + j] = new Soldier("Soldier",
									img[0], 1, i + 2, j, 0, 0, 0, 0, 0, 0);
						}
					}
				}
				newMonster = new Monster(10, 20, 0,
						img[Resource.MonsterImgIndex[0]], "Monster", 1, 2, 0,
						50, 0, 0, 50);
				newMonster1 = new Monster(10, 20, 0,
						img[Resource.MonsterImgIndex[0]], "Monster", 0, 2, 1,
						50, 0, 0, 50);
				newBullet = new Bullet(newMonster.getY() * 60 + 385,
						newMonster.getX() * 60 + 11,
						img[temp_img_distance2 + 56], newMonster);
				Resource.goodsNums[0] = 1;
				Resource.goodsNums[1] = 1;
				Resource.goodsNums[2] = 1;
			} else if (newGuideIndex >= 8 && newGuideIndex <= 10) {
				newGuideIndex++;
			} else if (newGuideIndex >= 13 && newGuideIndex < 40) {
				if (newGuideIndex == 27) {
					return;
				}
				newGuideIndex++;
				if (newGuideIndex == 16) {
					clearGameImg();
					loadMainImg();
				} else if (newGuideIndex == 26) {
					changeSoldier();
				} else if (newGuideIndex == 27) {
					changeSoldier();
				} else if (newGuideIndex == 30) {
					SaveAndGet.isFirstGame = false;
					mainIndex = 0;
					mainPageIndex[0] = 1;
					attainmentPanelStartTime = System.currentTimeMillis();
					isUnfoldAttainment = true;
					UnfoldAttainmentIndex = 0;
					my.setMoney(my.getMoney()
							+ Resource.AttainmentMoney[UnfoldAttainmentIndex]);
					Resource.isFinishAttainment[UnfoldAttainmentIndex] = 1;
				}
			} else if (newGuideIndex == 40) {
				mainIndex = 2;
			} else if (newGuideIndex == 50) {
				newGuideIndex = 10;
			} else if (newGuideIndex == 51) {
				newGuideIndex = 11;
			}
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (newGuideIndex == 3) {
				newGuideIndex = 4;
				useProp[0] = 1;
			}
		} else if (key.containsAndRemove(KeyCode.NUM2)) {
			if (newGuideIndex == 5) {
				newGuideIndex = 6;
				useProp[1] = 2;
			}
		} else if (key.containsAndRemove(KeyCode.NUM3)) {
			if (newGuideIndex == 7) {
				newGuideIndex = 8;
				useProp[2] = 3;
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (newGuideIndex == 10) {
				newGuideIndex = 50;
			} else if (newGuideIndex == 11) {
				newGuideIndex = 12;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (newGuideIndex == 10) {
				newGuideIndex = 50;
			} else if (newGuideIndex == 11) {
				newGuideIndex = 51;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (newGuideIndex == 10) {
				newGuideIndex = 50;
			} else if (newGuideIndex == 11) {
				newGuideIndex = 51;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (newGuideIndex == 10) {
				newGuideIndex = 50;
			} else if (newGuideIndex == 11) {
				newGuideIndex = 51;
			}
		}
	}

	private void drawNewGuide() {
		int newGuide_x = 100;
		int newGuide_y = 80;
		int leftpointx = 20;
		int toppointy = 110;
		if (newGuideIndex == 0) {
			g.drawImage(img[temp_img_distance1 - 6 + 32], 0, 0, 20);
			if (arrowIndex % 12 >= 0 && arrowIndex % 12 < 6) {
				g.drawImage(img[temp_img_distance1 - 6 + 33], 200, 480, 20);
			}
		} else if (newGuideIndex == 1
				|| (newGuideIndex >= 16 && newGuideIndex < 40)) {
			g.drawImage(img[temp_img_distance1 - 6 + 8], 0, 0, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 36], 10, 180, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 20, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 0, 85, 18, 0, 28,
					235, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 23], 210, 140, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 235, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 18, 85, 18, 0,
					243, 235, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 40], 450, 160, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 465, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 36, 85, 18, 0,
					473, 235, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 30], 510, 330, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 525, 395, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 54, 85, 18, 0,
					533, 400, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 22], 290, 320, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 305, 385, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 72, 85, 18, 0,
					313, 390, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 58], 500, 0, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 510, 125, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 90, 85, 18, 0,
					518, 130, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 21], 0, 350, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 10, 415, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 108, 85, 18, 0,
					18, 420, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 62], 20, 460, 20);
			roleInformation();
			setColour(0xffffff, Font.SIZE_MEDIUM);
			if (newGuideIndex == 1) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 25 * 0, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "冒险者，欢迎来到皇家军团的世界，点击确认键开始冒险。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 20, 190, 3, 0, 0);
			}
			if (newGuideIndex == 2) {
				arrowAnim(9, 20, 190, 3, 0, 0);
			} else if (newGuideIndex == 16) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "战斗胜利会获得经验。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 150, 25, 3, 0, 0);
			} else if (newGuideIndex == 17) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "战斗胜利会获得金币，金币可以用来升级士兵和英雄。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 320, 25, 3, 0, 0);
			} else if (newGuideIndex == 18) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "每次进入关卡都会消耗能量，升级可以提高能量的上限。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 150, 60, 3, 0, 0);
			} else if (newGuideIndex == 19) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "在英雄界面中可以招募，升级和替换英雄。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 215, 475, 3, 0, 0);
			} else if (newGuideIndex == 20) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "在兵营界面中可以招募，升级和替换士兵。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 305, 475, 3, 0, 0);
			} else if (newGuideIndex == 21) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "在商城中可以购买能量，金币以及各种增益道具。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 395, 475, 3, 0, 0);
			} else if (newGuideIndex == 22) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "完成成就会获得金币的奖励。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 485, 475, 3, 0, 0);
			} else if (newGuideIndex == 23) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g,
						"玩家每天可以在财富之地获得一次免费的抽奖，抽中的奖品存放在商城中。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 10, 370, 3, 0, 0);
			} else if (newGuideIndex == 24) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "每天可以免费挑战一次无尽之塔，爬得层数越高获得的奖励越多。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 520, 85, 3, 0, 0);
			} else if (newGuideIndex >= 25 && newGuideIndex <= 28) {
				g.drawImage(img[temp_img_distance1 - 6 + 9], 0, 0, 20);
				roleInformation();
				g.drawImage(img[temp_img_distance1 - 6 + 10], leftpointx,
						toppointy, 20);
				for (int s = 0; s < 18; s++) {
					g.drawImage(img[temp_img_distance1 - 6 + 11], leftpointx
							+ 46 + s * 30, toppointy, 20);
				}
				g.drawImage(img[temp_img_distance1 - 6 + 12], leftpointx + 556,
						toppointy, 20);

				g.drawRegion(img[temp_img_distance1 - 6 + 13], 0, 0, 82, 84, 0,
						leftpointx - 5, toppointy - 5, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 13], 82, 0, 81, 84,
						0, leftpointx + 526, toppointy - 5, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 55], leftpointx + 216,
						toppointy - 54, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 57], 0, 0, 54, 23, 0,
						leftpointx + 40, toppointy + 33, 20);
				for (int s = 0; s < 4; s++) {
					g.drawImage(img[14], leftpointx + 40, toppointy + 66 + 70
							* s, 20);
					if (s == selectSoldierLocation)
						g.drawImage(img[13], leftpointx + 39, toppointy + 66
								+ 70 * selectSoldierLocation, 20);
					g.drawRegion(img[selectSoldierindex + s
							- selectSoldierLocation],
							Resource.heroAndSoldierLevel[selectSoldierindex + s
									- selectSoldierLocation] / 7 * 62, 0, 62,
							62, 0, leftpointx + 40, toppointy + 66 + 70 * s, 20);
					if (shengjiIndex < 6 && selectSoldierLocation == s) {
						g.drawRegion(img[temp_img_distance1 - 6 + 72],
								57 * shengjiIndex, 0, 57, 71, 0,
								leftpointx + 40 + 2, toppointy + 66 - 8 + 70
										* s, 20);
						shengjiIndex++;
					}
					if (Resource.heroAndSoldierLevel[selectSoldierindex + s
							- selectSoldierLocation] == 0) {
						g.drawImage(img[temp_img_distance1 - 6 + 69],
								leftpointx + 54, toppointy + 81 + 70 * s, 20);
					}
					g.drawImage(img[temp_img_distance1 - 6 + 17],
							leftpointx + 145, toppointy + 66 + 70 * s, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47,
							29, 0, leftpointx + 110, toppointy + 66 + 70 * s,
							20);
					g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47,
							29, 0, leftpointx + 110, toppointy + 96 + 70 * s,
							20);
					g.drawImage(img[17], leftpointx + 245, toppointy + 66 + 70
							* s, 20);
					if (Resource.heroAndSoldierLevel[selectSoldierindex + s
							- selectSoldierLocation] > 0) {
						g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 20,
								40, 20, 0, leftpointx + 113, toppointy + 71
										+ 70 * s, 20);
						needMoney = Upgrade.upgradeSoldierMoney(
								Resource.heroAndSoldierLevel[selectSoldierindex
										+ s - selectSoldierLocation],
								selectSoldierindex + s - selectSoldierLocation
										+ 1);
						g.drawRegion(img[16], 0, 0, 12, 16, 0,
								leftpointx + 248 - 15, toppointy + 71 + 70 * s,
								20);
						g.drawRegion(img[16], 0, 0, 12, 16, 0,
								leftpointx + 248 - 15 - 12, toppointy + 71 + 70
										* s, 20);
						g.drawRegion(img[16],
								(int) (needMoney / 100 % 10) * 12, 0, 12, 16,
								0, leftpointx + 248 - 15 - 24, toppointy + 71
										+ 70 * s, 20);
						g.drawRegion(img[16],
								((int) (needMoney / 1000)) % 10 * 12, 0, 12,
								16, 0, leftpointx + 248 - 15 - 36, toppointy
										+ 71 + 70 * s, 20);
						if (needMoney >= 10000)
							g.drawRegion(img[16],
									((int) (needMoney / 10000)) % 10 * 12, 0,
									12, 16, 0, leftpointx + 248 - 15 - 48,
									toppointy + 71 + 70 * s, 20);
						if (needMoney >= 100000)
							g.drawRegion(img[16],
									((int) (needMoney / 100000)) * 12, 0, 12,
									16, 0, leftpointx + 248 - 15 - 60,
									toppointy + 71 + 70 * s, 20);
					} else {
						g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 0,
								40, 20, 0, leftpointx + 113, toppointy + 71
										+ 70 * s, 20);
						needMoney = Resource.soldierMoney[selectSoldierindex
								+ s - selectSoldierLocation];
						g.drawRegion(img[16], 0, 0, 12, 16, 0,
								leftpointx + 248 - 15, toppointy + 71 + 70 * s,
								20);
						g.drawRegion(img[16], 0, 0, 12, 16, 0,
								leftpointx + 248 - 15 - 12, toppointy + 71 + 70
										* s, 20);
						g.drawRegion(img[16],
								(int) (needMoney / 100 % 10) * 12, 0, 12, 16,
								0, leftpointx + 248 - 15 - 24, toppointy + 71
										+ 70 * s, 20);
						g.drawRegion(img[16],
								((int) (needMoney / 1000)) % 10 * 12, 0, 12,
								16, 0, leftpointx + 248 - 15 - 36, toppointy
										+ 71 + 70 * s, 20);
						if (needMoney >= 10000)
							g.drawRegion(img[16],
									((int) (needMoney / 10000)) % 10 * 12, 0,
									12, 16, 0, leftpointx + 248 - 15 - 48,
									toppointy + 71 + 70 * s, 20);
						if (needMoney >= 100000)
							g.drawRegion(img[16],
									((int) (needMoney / 100000)) * 12, 0, 12,
									16, 0, leftpointx + 248 - 15 - 60,
									toppointy + 71 + 70 * s, 20);
					}

					for (int ggg = 0; ggg < 4; ggg++) {
						if (Resource.savaSelcetSoldier[ggg] == selectSoldierindex
								+ s - selectSoldierLocation) {
							g.drawRegion(img[temp_img_distance1 - 6 + 18], 0,
									40, 40, 20, 0, leftpointx + 113, toppointy
											+ 101 + 70 * s, 20);
							break;
						} else if (ggg == 3) {
							g.drawRegion(img[temp_img_distance1 - 6 + 18], 0,
									20, 40, 20, 0, leftpointx + 113, toppointy
											+ 101 + 70 * s, 20);
						}
					}
				}
				DrawUtil.drawRect(g, leftpointx + 110, toppointy + 66 + 70
						* selectSoldierLocation + 30, 48, 30, 2, 0xff0000);
				arrowAnim(9, leftpointx + 115, toppointy + 66 + 70
						* selectSoldierLocation + 30, 3, 0, 0);
				g.drawRegion(img[temp_img_distance1 - 6 + 57], 0, 24, 54, 23,
						0, leftpointx + 40, toppointy + 346, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 39], leftpointx + 290,
						toppointy + 35, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 14], leftpointx + 300,
						toppointy + 47, 20);
				int bingzhong_x = leftpointx + 300;
				int bingzhong_y = toppointy + 25;
				setColour(0x000000, Font.SIZE_LARGE);
				if (Resource.heroAndSoldierLevel[selectSoldierindex] < 1) {
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3],
							bingzhong_x + 100, bingzhong_y + 26);
					TextView.showSingleLineText(
							g,
							(Resource.heroAndSoldierLevel[selectSoldierindex] + 1)
									+ "", bingzhong_x + 100, bingzhong_y + 52);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeSoldierAttack(
									Resource.heroAndSoldierLevel[selectSoldierindex] + 1,
									selectSoldierindex + 1)
									+ "", bingzhong_x + 100, bingzhong_y + 78);
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 1]
									+ "", bingzhong_x + 100, bingzhong_y + 104);
					TextView.showMultiLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 2],
							1, bingzhong_x + 100, bingzhong_y + 130, 250, 100);
				} else {
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3],
							bingzhong_x + 100, bingzhong_y + 26);
					TextView.showSingleLineText(g,
							Resource.heroAndSoldierLevel[selectSoldierindex]
									+ "", bingzhong_x + 100, bingzhong_y + 52);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeSoldierAttack(
									Resource.heroAndSoldierLevel[selectSoldierindex] + 1,
									selectSoldierindex + 1)
									+ "#R(+"
									+ Resource.soldierValue[selectSoldierindex][2]
									+ ")#K", bingzhong_x + 100,
							bingzhong_y + 78);
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 1]
									+ "", bingzhong_x + 100, bingzhong_y + 104);
					TextView.showMultiLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 2],
							1, bingzhong_x + 100, bingzhong_y + 130, 250, 100);
				}
				g.drawImage(img[temp_img_distance1 - 6 + 42], leftpointx + 396,
						toppointy + 265, 20);
				for (int s = 0; s < 4; s++) {
					g.drawImage(img[14], leftpointx + 300 + 70 * s,
							toppointy + 300, 20);
					if (Resource.savaSelcetSoldier[s] != -1) {
						if (isLoadSold == s) {
							drowChangeSoldierAnim(5);
							continue;
						}
						if (Resource.savaSelcetSoldier[s] == selectSoldierindex) {
							if (moveToUPAndDown == 0 || moveToUPAndDown == 1) {
								g.drawRegion(
										img[Resource.savaSelcetSoldier[s]],
										Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
										0, 62, 62, 0,
										leftpointx + 300 + 70 * s, toppointy
												+ 300 + (moveToUPAndDown + 1)
												* 2, 20);
								moveToUPAndDown++;
							} else {
								g.drawRegion(
										img[Resource.savaSelcetSoldier[s]],
										Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
										0, 62, 62, 0,
										leftpointx + 300 + 70 * s, toppointy
												+ 300 + (moveToUPAndDown - 4)
												* 2, 20);
								moveToUPAndDown++;
								if (moveToUPAndDown == 5) {
									moveToUPAndDown = 0;
								}
							}
						} else
							g.drawRegion(
									img[Resource.savaSelcetSoldier[s]],
									Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
									0, 62, 62, 0, leftpointx + 300 + 70 * s,
									toppointy + 300, 20);
					}
				}
				g.drawImage(img[18], newGuide_x + 100, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 209,
						newGuide_y + 70, 20);
				setColour(0xffffff, Font.SIZE_MEDIUM);
				if (newGuideIndex == 25) {
					TextView.showMultiLineText(g, "点击卸载可以把士兵移出部队！",
							TextView.STYLE_NORMAL, newGuide_x + 120,
							newGuide_y + 110, 280, 100);
				} else if (newGuideIndex == 26 || newGuideIndex == 27) {
					TextView.showMultiLineText(g, "点击出征可以把士兵添加到部队！",
							TextView.STYLE_NORMAL, newGuide_x + 120,
							newGuide_y + 110, 280, 100);
				} else if (newGuideIndex == 28) {
					TextView.showMultiLineText(g, "你已经学会了如何卸载和出征士兵了！",
							TextView.STYLE_NORMAL, newGuide_x + 120,
							newGuide_y + 110, 280, 100);
				}
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 310,
						newGuide_y + 195);
			} else if (newGuideIndex == 29) {
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "来吧，我们一起开始新的征程吧！",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
				arrowAnim(9, 520, 85, 3, 0, 0);
			}
		} else if (newGuideIndex >= 2) {
			g.drawImage(img[temp_img_distance1], 0, 0, 20);
			if (newSoldier != null) {
				if (newGuideIndex == 11 || newGuideIndex == 51)
					g.drawImage(img[13], newSoldier[1].getY() * 60 + 17,
							newSoldier[1].getX() * 60 + 11, 20);
				else
					g.drawImage(img[12], newSoldier[1].getY() * 60 + 17,
							newSoldier[1].getX() * 60 + 11, 20);
				for (int k = 0; k < 6; k++) {
					g.drawRegion(
							newSoldier[k].getSrc(),
							0,
							0,
							62,
							62,
							0,
							newSoldier[k].getY() * 60 + 17
									+ newSoldier[k].getOffX(),
							newSoldier[k].getX() * 60 + 11
									+ newSoldier[k].getOffY(), 20);
				}
				if (newMonster != null && newMonster1 != null) {
					g.drawRegion(newMonster.getSrc(), 0, 0, 60, 60, 0,
							385 + newMonster.getY() * 60,
							11 + newMonster.getX() * 60, 20);
					g.drawRegion(newMonster1.getSrc(), 0, 0, 60, 60, 0,
							385 + newMonster1.getY() * 60,
							11 + newMonster1.getX() * 60, 20);

				}
				drawHeroInfo1(newHero);
				setColour(0xffffff, Font.SIZE_MEDIUM);
				if (newGuideIndex >= 8) {
					g.drawRegion(img[temp_img_distance2 + 81], 3 * 24, 0, 24,
							24, 0, Hero.booldX, Hero.booldY - 25, 20);
				}
				if (newGuideIndex == 2) {
					g.drawRegion(newBullet.getSrc(), 0, 0, 32, 20, 0,
							newBullet.getX(), newBullet.getY(), 20);
					newBullet.setX(newBullet.getX() - 50);
					if (newBullet.getX() <= 0) {
						newGuideIndex = 3;
						newBullet = null;
					}
				} else if (newGuideIndex == 3) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(g,
							"血量马上见底了，快使用治疗药剂恢复血量。按数字键1使用治疗药剂。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击数字键'1'",
							newGuide_x + 240, newGuide_y + 195);
					arrowAnim(9, 450, 470, 3, 0, 0);
				} else if (newGuideIndex == 4) {
					if (useProp[0] == 1) {
						drawUseProp1(newHero);
					}
				} else if (newGuideIndex == 5) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(g,
							"怪物太厉害了，快使用狂暴术提升士兵的攻击力。按数字键2使用火球术。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击数字键'2'",
							newGuide_x + 240, newGuide_y + 195);
					arrowAnim(9, 510, 470, 3, 0, 0);
				} else if (newGuideIndex == 6) {
					if (useProp[1] == 2) {
						drawUseProp2();
					}
				} else if (newGuideIndex == 7) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(g,
							"怪物太厉害了，快使用狂暴术提升士兵的攻击力。按数字键3使用狂暴术。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击数字键'3'",
							newGuide_x + 240, newGuide_y + 195);
					arrowAnim(9, 570, 470, 3, 0, 0);
				} else if (newGuideIndex == 8) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(g, "英雄的buff状态会出现在英雄血条的正上方。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
							newGuide_y + 195);
				} else if (newGuideIndex == 9) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(
							g,
							"现在交换中间两个士兵的位置,就可以消灭怪物了！（按确定键选中士兵，让选择框变成黄色，然后按下键，交换士兵位置）。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
							newGuide_y + 195);
				} else if (newGuideIndex == 12) {
					if (newSoldier[1].getAnimIndex() < 5) {
						newSoldier[1]
								.setAnimIndex(newSoldier[1].getAnimIndex() + 1);
						newSoldier[4]
								.setAnimIndex(newSoldier[4].getAnimIndex() + 1);
						newSoldier[1].setOffY(newSoldier[1].getOffY() + 11);
						newSoldier[4].setOffY(newSoldier[4].getOffY() - 11);
					} else if (newSoldier[1].getAnimIndex() == 5) {
						newSoldier[1].setOffY(0);
						newSoldier[4].setOffY(0);
						Image imgs = newSoldier[4].getSrc();
						newSoldier[4].setSrc(newSoldier[1].getSrc());
						newSoldier[1].setSrc(imgs);
						for (int i = 0; i < 6; i++) {
							newSoldier[i].setAnimIndex(6);
						}
					} else {
						for (int i = 0; i < 6; i++) {
							newSoldier[i].setOffX(newSoldier[i].getOffX() + 20
									* (newSoldier[i].getAnimIndex() - 6));
							if (i < 3) {
								g.drawRegion(
										img[temp_img_distance2 + 50],
										53 * (newSoldier[i].getAnimIndex() - 6) % 4,
										0, 53, 53, 0, newSoldier[i].getY() * 60
												+ newSoldier[i].getOffX(),
										newSoldier[i].getX() * 60 + 20
												+ newSoldier[i].getOffY(), 20);
							}
							newSoldier[i].setAnimIndex(newSoldier[i]
									.getAnimIndex() + 1);
							if (newSoldier[0].getY() * 60 + 11
									+ newSoldier[i].getOffX() >= 640) {
								newSoldier = null;
								newGuideIndex = 13;
								break;
							}
						}
						if (newSoldier != null
								&& newSoldier[2].getAnimIndex() - 6 > 10) {
							if (newSoldier[2].getAnimIndex() - 6 == 10) {
								Critical c = new Critical(newMonster.getY(),
										newMonster.getX(), 50, newMonster);
								criticalArray1.addElement(c);
								newMonster = null;
							} else {
								if (criticalArray1 != null) {
									showHurtAnim(
											(Critical) criticalArray1
													.elementAt(0),
											0, criticalArray1, 1,
											temp_img_distance2 + 64);
								}
							}
						}
					}
				} else if (newGuideIndex == 50) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(
							g,
							"现在交换中间两个士兵的位置,就可以消灭怪物了！（按确定键选中士兵，让选择框变成黄色，然后按下键，交换士兵位置）。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
							newGuide_y + 195);
				} else if (newGuideIndex == 51) {
					g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
					g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0,
							newGuide_x + 169, newGuide_y + 70, 20);
					TextView.showMultiLineText(g, "按下键，交换士兵位置。",
							TextView.STYLE_NORMAL, newGuide_x + 80,
							newGuide_y + 110, 280, 100);
					TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
							newGuide_y + 195);
				}
			} else if (newGuideIndex == 13) {
				setColour(0xffffff, Font.SIZE_MEDIUM);
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "你消灭了敌人。", TextView.STYLE_NORMAL,
						newGuide_x + 80, newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
			} else if (newGuideIndex == 14) {
				setColour(0xffffff, Font.SIZE_MEDIUM);
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g,
						"士兵共有9种，分别有不同的技能和作用。从攻击方式上看，又可以分为近战和远战两种。",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
			} else if (newGuideIndex == 15) {
				setColour(0xffffff, Font.SIZE_MEDIUM);
				g.drawImage(img[18], newGuide_x + 60, newGuide_y + 60, 20);
				g.drawRegion(img[19], 0, 0 * 25, 91, 25, 0, newGuide_x + 169,
						newGuide_y + 70, 20);
				TextView.showMultiLineText(g, "想了解更多请观看帮助！",
						TextView.STYLE_NORMAL, newGuide_x + 80,
						newGuide_y + 110, 280, 100);
				TextView.showSingleLineText(g, "点击确认键", newGuide_x + 270,
						newGuide_y + 195);
			}
		}
		arrowIndex++;
		if (arrowIndex == 10000)
			arrowIndex = 0;
	}

	public void getMonster() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				if (mapArray[tongtiantaAndNormalBigGuanqia - 1][tongtiantaAndNormalSmallGuanqia][mapIndexOfIndex][i][j] != 0) {
					int index = mapArray[tongtiantaAndNormalBigGuanqia - 1][tongtiantaAndNormalSmallGuanqia][mapIndexOfIndex][i][j];
					monsterPic[i][j] = new Monster(
							Resource.MonsterSpeed[index - 1],
							Upgrade.upgradeMonsterAtk(
									Resource.MonsterAttack[(index - 1) * 2],
									(tongtiantaAndNormalBigGuanqia - 1) * 10
											+ tongtiantaAndNormalSmallGuanqia,
									Resource.MonsterAttack[(index - 1) * 2 + 1]),
							index,
							img[Resource.MonsterImgIndex[index - 1]],
							"Monster",
							Resource.MonsterLevel[index - 1],
							i,
							j,
							Upgrade.upgradeMonsterBoold(
									Resource.MonsterBlood[(index - 1) * 2],
									(tongtiantaAndNormalBigGuanqia - 1) * 10
											+ tongtiantaAndNormalSmallGuanqia,
									Resource.MonsterBlood[(index - 1) * 2 + 1]),
							1, 0, Upgrade.upgradeMonsterBoold(
									Resource.MonsterBlood[(index - 1) * 2],
									(tongtiantaAndNormalBigGuanqia - 1) * 10
											+ tongtiantaAndNormalSmallGuanqia,
									Resource.MonsterBlood[(index - 1) * 2 + 1]));
					monsterVector.addElement(monsterPic[i][j]);
					System.out.println("index=>" + index
							+ "*Resource.MonsterBlood[index* 2]=>"
							+ Resource.MonsterBlood[(index - 1) * 2]
							+ "*tongtiantaAndNormalSmallGuanqia=>"
							+ tongtiantaAndNormalSmallGuanqia
							+ "*Resource.MonsterBlood[index*2 + 1])=>"
							+ Resource.MonsterBlood[(index - 1) * 2 + 1] + "**"
							+ monsterPic[i][j].getHurtValue() + "**"
							+ monsterPic[i][j].getBloods());
				}
			}
		}
		mapIndexOfIndex++;
	}

	public void drawStar(int location, int x, int y) {
		g.drawRegion(img[temp_img_distance1 - 6 + 38], 0, 19 * location, 17,
				19, 0, x + 23 + location % 5 * 50, y + 25 + location / 5 * 85,
				20);
		if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1) * 10
				+ location] == -1) {
			g.drawRegion(img[temp_img_distance1 - 6 + 24], 141, 0, 47, 60, 0, x
					+ 10 + location % 5 * 50, y + 45 + location / 5 * 85, 20);
		} else {
			if (location == 4) {
				g.drawRegion(img[temp_img_distance1 - 6 + 24], 47, 0, 47, 60,
						0, x + 10 + location % 5 * 50, y + 45 + location / 5
								* 85, 20);
			} else if (location == 9) {
				g.drawRegion(img[temp_img_distance1 - 6 + 24], 94, 0, 47, 60,
						0, x + 10 + location % 5 * 50, y + 45 + location / 5
								* 85, 20);
			} else {
				g.drawRegion(img[temp_img_distance1 - 6 + 24], 0, 0, 47, 60, 0,
						x + 10 + location % 5 * 50, y + 45 + location / 5 * 85,
						20);
			}
			for (int yy = 0; yy < Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
					* 10 + location]; yy++) {
				g.drawImage(img[15], x + 14 + location % 5 * 50 + 14 * yy, y
						+ 50 + location / 5 * 85, 20);
			}
		}
	}

	int attainmentPage;

	private void drawAttainment(int leftpointx, int toppointy) {
		roleInformation();
		toppointy += 20;
		g.drawImage(img[temp_img_distance1 - 6 + 10], leftpointx, toppointy, 20);
		for (int s = 0; s < 18; s++) {
			g.drawImage(img[temp_img_distance1 - 6 + 11], leftpointx + 46 + s
					* 30, toppointy, 20);
		}
		g.drawImage(img[temp_img_distance1 - 6 + 12], leftpointx + 556,
				toppointy, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 13], 0, 0, 82, 84, 0,
				leftpointx - 5, toppointy - 5, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 13], 82, 0, 81, 84, 0,
				leftpointx + 526, toppointy - 5, 20);
		DrawUtil.drawRect(0x573c0f, g, 316, toppointy, 6, 370);
		DrawUtil.drawRect(0x573c0f, g, leftpointx + 35, toppointy + 126, 530, 4);
		DrawUtil.drawRect(0x573c0f, g, leftpointx + 35, toppointy + 252, 530, 4);
		g.drawImage(img[temp_img_distance1 - 6 + 65], 227, toppointy - 75, 20);
		if (attainmentPage != 0) {
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 0, 0, 23, 54, 0,
					leftpointx, toppointy + 172, 20);
		}
		if (attainmentPage != 5) {
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 24, 0, 23, 54, 0,
					leftpointx + 580, toppointy + 172, 20);
		}
		int attainmentNowPageNum = (Resource.AttainmentName.length - attainmentPage * 6) >= 6 ? 6
				: (Resource.AttainmentName.length - attainmentPage * 6);
		for (int i = 0; i < attainmentNowPageNum; i++) {
			if (Resource.isFinishAttainment[attainmentPage * 6 + i] == 1) {
				g.drawImage(img[temp_img_distance1 - 6 + 66], leftpointx + 35
						+ (i % 2) * 275, toppointy + 40 + i / 2 * 110, 20);
			}
			setColour(0xff0000, Font.SIZE_LARGE);
			TextView.showSingleLineText(g,
					Resource.AttainmentName[attainmentPage * 6 + i], leftpointx
							+ 130 + (i % 2) * 275,
					toppointy + 30 + i / 2 * 120, 150, 30,
					TextView.STYLE_ALIGN_CENTER);
			setColour(0x000000, Font.SIZE_MEDIUM);
			TextView.showMultiLineText(g,
					Resource.AttainmentCondition[attainmentPage * 6 + i], 0,
					leftpointx + 120 + (i % 2) * 275, toppointy + 60 + i / 2
							* 120, 165, 30);
			setColour(0xff0000, Font.SIZE_MEDIUM);
			TextView.showSingleLineText(g, "奖励"
					+ Resource.AttainmentMoney[attainmentPage * 6 + i] + "金币",
					leftpointx + 135 + (i % 2) * 275, toppointy + 90 + i / 2
							* 120, 150, 30, TextView.STYLE_ALIGN_CENTER);
		}
		g.drawImage(img[10], 500, 505, 20);
	}

	private void handleMainKey8(KeyState key) {
		if (key.containsAndRemove(KeyCode.NUM0)) {
			mainIndex = 0;
			attainmentPage = 0;
		}
		if (key.containsAndRemove(KeyCode.LEFT)) {
			if (attainmentPage > 0) {
				attainmentPage--;
			}
		}
		if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (attainmentPage < 5)
				attainmentPage++;
		}
	}

	public void drawMain() {
		if (isHelp) {
			g.drawImage(img[temp_img_distance1 - 6 + 63], 0, 0, 20);
			return;
		}
		int leftpointx = 20;
		int toppointy = 110;
		arrowIndex++;
		if (arrowIndex == 10000)
			arrowIndex = 0;
		if (mainIndex != -1) {
			addNengliang();
		}
		if (mainIndex == -1) {
			g.drawImage(img[temp_img_distance1 - 6 + 32], 0, 0, 20);
			if (arrowIndex % 12 >= 0 && arrowIndex % 12 < 6) {
				g.drawImage(img[temp_img_distance1 - 6 + 33], 200, 480, 20);
			}
		} else if (mainIndex == 0) {
			g.drawImage(img[temp_img_distance1 - 6 + 8], 0, 0, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 36], 10, 180, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 20, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 0, 85, 18, 0, 28,
					235, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 23], 210, 140, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 235, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 18, 85, 18, 0,
					243, 235, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 40], 450, 160, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 465, 230, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 36, 85, 18, 0,
					473, 235, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 30], 510, 330, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 525, 395, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 54, 85, 18, 0,
					533, 400, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 22], 290, 320, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 305, 385, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 72, 85, 18, 0,
					313, 390, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 58], 500, 0, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 510, 125, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 90, 85, 18, 0,
					518, 130, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 21], 0, 350, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 54], 10, 415, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 108, 85, 18, 0,
					18, 420, 20);

			g.drawImage(img[temp_img_distance1 - 6 + 62], 20, 460, 20);

			if (mainPageIndex[0] == 0) {
				arrowAnim(9, 20, 190, 0, 0, 0);
			} else if (mainPageIndex[0] == 1) {
				arrowAnim(9, 220, 140, 0, 0, 0);
			} else if (mainPageIndex[0] == 2) {
				arrowAnim(9, 460, 150, 0, 0, 0);
			} else if (mainPageIndex[0] == 3) {
				arrowAnim(9, 520, 320, 0, 0, 0);
			} else if (mainPageIndex[0] == 4) {
				arrowAnim(9, 320, 330, 0, 0, 0);
			} else if (mainPageIndex[0] == 5) {
				arrowAnim(9, 10, 350, 0, 0, 0);
			} else if (mainPageIndex[0] == 6) {
				arrowAnim(9, 520, 85, 0, 0, 0);
			} else if (mainPageIndex[0] == 7) {
				arrowAnim(9, 215, 475, 3, 0, 0);
			} else if (mainPageIndex[0] == 8) {
				arrowAnim(9, 305, 475, 3, 0, 0);
			} else if (mainPageIndex[0] == 9) {
				arrowAnim(9, 395, 475, 3, 0, 0);
			} else if (mainPageIndex[0] == 10) {
				arrowAnim(9, 485, 475, 3, 0, 0);
			} else if (mainPageIndex[0] == 11) {
				arrowAnim(9, 575, 475, 3, 0, 0);
			} else if (mainPageIndex[0] == 12) {
				arrowAnim(9, 50, 480, 3, 0, 0);
			}
			roleInformation();
		} else {
			g.drawImage(img[temp_img_distance1 - 6 + 9], 0, 0, 20);
			if (mainIndex == 1) {
				g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y,
						20);
				g.drawImage(img[temp_img_distance1 - 6 + 54], panle_x + 80,
						panle_y - 10, 20);
				if (!isTongtianta) {
					g.drawRegion(img[temp_img_distance1 - 6 + 27], 0,
							18 * mainPageIndex[0], 85, 18, 0, panle_x + 88,
							panle_y - 5, 20);
					for (int k = 0; k < 10; k++) {
						drawStar(k, panle_x, panle_y);
					}
					arrowAnim(9, panle_x, panle_y, 3,
							20 + tongtiantaAndNormalSmallGuanqia % 5 * 50,
							60 + tongtiantaAndNormalSmallGuanqia / 5 * 85);
					g.drawImage(img[10], panle_x + 180, panle_y + 190, 20);
				} else {
					g.drawRegion(img[temp_img_distance1 - 6 + 27], 0,
							18 * (mainPageIndex[0] - 1), 85, 18, 0,
							panle_x + 88, panle_y - 5, 20);
					TextView.showMultiLineText(g, "你的最高层为"
							+ (Resource.tongtiantafloor + 1) + "层，",
							TextView.STYLE_ALIGN_CENTER, panle_x + 10,
							panle_y + 30, 260, 60);
					TextView.showMultiLineText(
							g,
							"挑战胜利获得金币和经验的奖励。挑战的层数越高奖励越多。挑战失败之前获得的奖励减半。每天有一次免费挑战的机会。选择重新挑战，将从第一层开始战斗，选择继续游戏，将会从你以前在通天塔中获得的最高层开始战斗！",
							TextView.STYLE_ALIGN_CENTER, panle_x + 10,
							panle_y + 60, 240, 100);
					g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95,
							29, 0, panle_x + 40, panle_y + 185, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95,
							29, 0, panle_x + 160, panle_y + 185, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20, 80,
							20, 0, panle_x + 47, panle_y + 190, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 0, 80,
							20, 0, panle_x + 167, panle_y + 190, 20);
					DrawUtil.drawRect(g, panle_x + 40 + 120 * tongtiantaIndex,
							panle_y + 185, 95, 29, 2, 0xff0000);
				}
				roleInformation();
			} else if (mainIndex == 2) {
				g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y,
						20);
				g.drawImage(img[temp_img_distance1 - 6 + 54], panle_x + 10,
						panle_y - 5, 20);

				g.setColor(159, 125, 64);
				g.drawLine(panle_x + 10, panle_y + 22, 460, 152);
				g.drawRect(panle_x + 12, panle_y + 25, 110, 18);
				g.drawImage(img[temp_img_distance1 - 6 + 25], panle_x + 14,
						panle_y + 29, 20);
				for (int yy = 0; yy < Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
						* 10 + tongtiantaAndNormalSmallGuanqia]; yy++) {
					g.drawImage(img[15], panle_x + 75 + 14 * yy, panle_y + 29,
							20);
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
						panle_x + 140, panle_y + 23, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 18], 0, 20, 40, 20,
						0, panle_x + 142, panle_y + 25, 20);
				if (!isTongtianta) {
					g.drawRegion(img[temp_img_distance1 - 6 + 27], 0,
							18 * mainPageIndex[0], 85, 18, 0, panle_x + 20,
							panle_y, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47,
							29, 0, panle_x + 210, panle_y + 23, 20);
					g.drawRegion(img[temp_img_distance1 - 6 + 18], 0, 0, 40,
							20, 0, panle_x + 212, panle_y + 25, 20);
				} else {
					g.drawRegion(img[temp_img_distance1 - 6 + 27], 0,
							18 * mainPageIndex[0], 85, 18, 0, panle_x + 20,
							panle_y, 20);
				}
				g.drawLine(panle_x + 10, panle_y + 52, 460, 182);
				g.drawImage(img[temp_img_distance1 - 6 + 34], panle_x + 30,
						panle_y + 56, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 35], panle_x + 160,
						panle_y + 56, 20);
				g.drawImage(img[14], panle_x + 30, panle_y + 80, 20);
				g.drawRegion(img[11], 62 * Resource.saveSelectHero, 0, 62, 62,
						0, panle_x + 30, panle_y + 80, 20);
				for (int f = 0; f < 4; f++) {
					g.drawImage(img[14], panle_x + 130 + f % 2 * 65, panle_y
							+ 70 + f / 2 * 65, 20);
					g.drawRegion(
							img[Resource.savaSelcetSoldier[f]],
							Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[f]] / 7 * 62,
							0, 62, 62, 0, panle_x + 130 + f % 2 * 65, panle_y
									+ 70 + f / 2 * 65, 20);
				}
				g.drawImage(img[10], panle_x + 20, panle_y + 170, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
						panle_x + 40, panle_y + 205, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
						panle_x + 160, panle_y + 205, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 19], 0, 0, 80, 20, 0,
						panle_x + 47, panle_y + 210, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 19], 0, 20, 80, 20,
						0, panle_x + 167, panle_y + 210, 20);
				roleInformation();
				if (!isSaodang) {
					if (mainPageIndex[2] == 0)
						arrowAnim(9, panle_x, panle_y, 3, 149, 20);
					else if (mainPageIndex[2] == 1)
						arrowAnim(9, panle_x, panle_y, 3, 219, 20);
					else if (mainPageIndex[2] == 2)
						arrowAnim(9, panle_x, panle_y, 3, 54, 200);
					else if (mainPageIndex[2] == 3)
						arrowAnim(9, panle_x, panle_y, 3, 177, 200);
				}
				if (isSaodang) {
					setColour(0xffff00, Font.SIZE_MEDIUM);
					int dex = 200;
					int dey = 180;
					g.drawImage(img[18], dex, dey, 20);
					g.drawRegion(img[19], 0, 2 * 25, 91, 25, 0, dex + 109,
							dey + 10, 20);
					int dangqianmiao = (int) ((System.currentTimeMillis() - saodangTime) / 1000);
					if (dangqianmiao <= 180 && saodangTime != 180) {
						TextView.showSingleLineText(g, "正在扫荡中……", dex + 20,
								dey + 45, 270, 30, TextView.STYLE_ALIGN_CENTER);
						int fen = (180 - dangqianmiao) / 60;
						int miao = (180 - dangqianmiao) % 60;
						if (miao >= 10)
							TextView.showSingleLineText(g, "剩余时间：0" + fen + ":"
									+ miao, dex + 20, dey + 70, 270, 30,
									TextView.STYLE_ALIGN_CENTER);
						else {
							TextView.showSingleLineText(g, "剩余时间：0" + fen
									+ ":0" + miao, dex + 20, dey + 70, 270, 30,
									TextView.STYLE_ALIGN_CENTER);
						}
						g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0,
								47, 29, 0, dex + 100, dey + 120, 20);
						g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0,
								47, 29, 0, dex + 170, dey + 120, 20);
						g.drawRegion(img[temp_img_distance1 - 6 + 67], 0, 0,
								40, 20, 0, dex + 100 + 3, dey + 120 + 4, 20);
						g.drawRegion(img[temp_img_distance1 - 6 + 67], 0,
								20 * 1, 40, 20, 0, dex + 170 + 3,
								dey + 120 + 4, 20);
						DrawUtil.drawRect(g, dex + 100 + 70 * saodangIndex,
								dey + 120, 47, 29, 2, 0xff0000);
					} else {
						saodangIndex = 2;
						TextView.showSingleLineText(g, "扫荡完成！", dex + 20,
								dey + 45, 270, 30, TextView.STYLE_ALIGN_CENTER);
						TextView.showSingleLineText(g, "恭喜你获得" + winMoney
								+ "金币和" + winExp + "经验！", dex + 20, dey + 60,
								270, 30, TextView.STYLE_ALIGN_CENTER);
						g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0,
								47, 29, 0, dex + 140, dey + 120, 20);
						g.drawImage(img[temp_img_distance1 - 6 + 41],
								dex + 140 + 3, dey + 120 + 4, 20);
						DrawUtil.drawRect(g, dex + 140, dey + 120, 47, 29, 2,
								0xff0000);
					}
				}
			} else if (mainIndex == 3) {
				g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y,
						20);
				roleInformation();
				g.drawImage(img[temp_img_distance1 - 6 + 10], leftpointx,
						toppointy, 20);
				for (int s = 0; s < 18; s++) {
					g.drawImage(img[temp_img_distance1 - 6 + 11], leftpointx
							+ 46 + s * 30, toppointy, 20);
				}
				g.drawImage(img[temp_img_distance1 - 6 + 12], leftpointx + 556,
						toppointy, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 13], 0, 0, 82, 84, 0,
						leftpointx - 5, toppointy - 5, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 13], 82, 0, 81, 84,
						0, leftpointx + 526, toppointy - 5, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 56], leftpointx + 216,
						toppointy - 54, 20);
				for (int s = 0; s < 6; s++) {
					g.drawImage(img[14], leftpointx + 43 + 90 * s,
							toppointy + 40, 20);
					g.drawRegion(img[11], s * 62, 0, 62, 62, 0, leftpointx + 43
							+ 90 * s + 1, toppointy + 40 + 1, 20);
					if (Resource.saveSelectHero == s) {
						g.drawImage(img[temp_img_distance1 - 6 + 37],
								leftpointx + 43 + 90 * s + 44,
								toppointy + 40 + 44, 20);
					}
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 28],
						mainPageIndex[3] * 142, 0, 142, 161, 0,
						leftpointx + 70, toppointy + 130, 20);
				if (mainPageIndex[3] == 1 && my.getLevel() < 5) {
					DrawUtil.drawRect(0x000000, g, leftpointx + 70,
							toppointy + 230, 142, 30);
					setColour(0xffffff, Font.SIZE_SMALL);
					TextView.showSingleLineText(g,
							Resource.someUpGreatInfoH[mainPageIndex[3]],
							leftpointx + 75, toppointy + 230, 145, 30,
							TextView.STYLE_ALIGN_CENTER);
				} else if (mainPageIndex[3] == 2 && my.getLevel() < 10) {
					DrawUtil.drawRect(0x000000, g, leftpointx + 70,
							toppointy + 230, 142, 30);
					setColour(0xffffff, Font.SIZE_SMALL);
					TextView.showSingleLineText(g,
							Resource.someUpGreatInfoH[mainPageIndex[3]],
							leftpointx + 75, toppointy + 230, 145, 30,
							TextView.STYLE_ALIGN_CENTER);
				} else if (mainPageIndex[3] == 3 && my.getLevel() < 20) {
					DrawUtil.drawRect(0x000000, g, leftpointx + 70,
							toppointy + 230, 142, 30);
					setColour(0xffffff, Font.SIZE_SMALL);
					TextView.showSingleLineText(g,
							Resource.someUpGreatInfoH[mainPageIndex[3]],
							leftpointx + 75, toppointy + 230, 145, 30,
							TextView.STYLE_ALIGN_CENTER);
				} else if (mainPageIndex[3] == 4
						&& Resource.guanqiaLevel[19] <= 0) {
					DrawUtil.drawRect(0x000000, g, leftpointx + 70,
							toppointy + 230, 142, 30);
					setColour(0xffffff, Font.SIZE_SMALL);
					TextView.showSingleLineText(g,
							Resource.someUpGreatInfoH[mainPageIndex[3]],
							leftpointx + 75, toppointy + 230, 145, 30,
							TextView.STYLE_ALIGN_CENTER);
				} else if (mainPageIndex[3] == 5
						&& Resource.tongtiantafloor < 30) {
					DrawUtil.drawRect(0x000000, g, leftpointx + 70,
							toppointy + 230, 142, 30);
					setColour(0xffffff, Font.SIZE_SMALL);
					TextView.showSingleLineText(g,
							Resource.someUpGreatInfoH[mainPageIndex[3]],
							leftpointx + 75, toppointy + 230, 145, 30,
							TextView.STYLE_ALIGN_CENTER);
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
						leftpointx + 80, toppointy + 300, 20);
				if (Resource.isBelongMyOfHero[mainPageIndex[3]] != 20) {
					g.drawImage(img[temp_img_distance1 - 6 + 17],
							leftpointx + 130, toppointy + 300, 20);
					g.drawImage(img[17], leftpointx + 240, toppointy + 300 + 2,
							20);
				}
				if (Resource.isBelongMyOfHero[mainPageIndex[3]] > 0) {
					g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 20, 40,
							20, 0, leftpointx + 80 + 2, toppointy + 300 + 5, 20);
					if (Resource.isBelongMyOfHero[mainPageIndex[3]] != 20) {
						needMoney = Upgrade.upgradeHeroMoney(
								Resource.isBelongMyOfHero[mainPageIndex[3]],
								mainPageIndex[3]);
						drawNum(img[16], g, needMoney, leftpointx + 170 - 12,
								toppointy + 300 + 7, 10);
					}
				} else {
					g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 0, 40,
							20, 0, leftpointx + 80 + 2, toppointy + 300 + 5, 20);
					needMoney = Resource.heroMoney[mainPageIndex[3]];
					drawNum(img[16], g, needMoney, leftpointx + 170 - 12,
							toppointy + 300 + 7, 10);
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
						leftpointx + 80, toppointy + 330, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 18], 0, 20, 40, 20,
						0, leftpointx + 80 + 2, toppointy + 330 + 5, 20);
				if (mainPageIndex[3] < 6 && mainPage3Index == -1) {
					DrawUtil.drawRect(g, leftpointx + 43 + 90
							* mainPageIndex[3], toppointy + 40, 63, 63, 2,
							0xff0000);
				} else {
					if (mainPage3Index == 0) {
						DrawUtil.drawRect(g, leftpointx + 80, toppointy + 300,
								48, 30, 2, 0xff0000);
					} else if (mainPage3Index == 1) {
						DrawUtil.drawRect(g, leftpointx + 80, toppointy + 330,
								48, 30, 2, 0xff0000);
					}
				}
				g.drawImage(img[temp_img_distance1 - 6 + 39], leftpointx + 290,
						toppointy + 110, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 26], leftpointx + 300,
						toppointy + 120, 20);
				setColour(0x000000, Font.SIZE_MEDIUM);
				int shuoming_x = leftpointx + 360;
				int shuoming_y = toppointy + 126;
				if (Resource.isBelongMyOfHero[mainPageIndex[3]] == 0) {
					TextView.showSingleLineText(g,
							Resource.heroName[mainPageIndex[3]], shuoming_x,
							shuoming_y - 4);// 名字
					TextView.showSingleLineText(g,
							(Resource.isBelongMyOfHero[mainPageIndex[3]] + 1)
									+ "", shuoming_x, shuoming_y + 23);// 等级
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeHeroDefence(
									Resource.isBelongMyOfHero[mainPageIndex[3]] + 1,
									mainPageIndex[3])
									+ "", shuoming_x, shuoming_y + 50);// 防御
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeHeroBlood(
									Resource.isBelongMyOfHero[mainPageIndex[3]] + 1,
									mainPageIndex[3])
									+ "", shuoming_x, shuoming_y + 77);// 血量
					TextView.showSingleLineText(g,
							Resource.heroSkillName[mainPageIndex[3]],
							shuoming_x, shuoming_y + 104);// 技能名称
					TextView.showMultiLineText(g,
							Resource.heroSkillInfo[mainPageIndex[3]], 1,
							leftpointx + 320, shuoming_y + 130, 240, 60);// 技能描述
				} else {
					TextView.showSingleLineText(g,
							Resource.heroName[mainPageIndex[3]], shuoming_x,
							shuoming_y - 4);// 名字
					TextView.showSingleLineText(g,
							Resource.isBelongMyOfHero[mainPageIndex[3]] + "",
							shuoming_x, shuoming_y + 23);
					if (Resource.isBelongMyOfHero[mainPageIndex[3]] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 73],
								shuoming_x + 40, shuoming_y + 23, 20);
						setColour(0xff0000, Font.SIZE_MEDIUM);
						TextView.showSingleLineText(
								g,
								(Resource.isBelongMyOfHero[mainPageIndex[3]] + 1)
										+ "", shuoming_x + 80, shuoming_y + 23);
					}

					setColour(0x000000, Font.SIZE_MEDIUM);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeHeroDefence(
									Resource.isBelongMyOfHero[mainPageIndex[3]],
									mainPageIndex[3])
									+ "", shuoming_x, shuoming_y + 50);
					if (Resource.isBelongMyOfHero[mainPageIndex[3]] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 73],
								shuoming_x + 40, shuoming_y + 50, 20);
						setColour(0xff0000, Font.SIZE_MEDIUM);
						TextView.showSingleLineText(
								g,
								(Upgrade.upgradeHeroDefence(
										Resource.isBelongMyOfHero[mainPageIndex[3]],
										mainPageIndex[3]) + Resource.heroValue[mainPageIndex[3]][4])
										+ "", shuoming_x + 80, shuoming_y + 50);
					}
					setColour(0x000000, Font.SIZE_MEDIUM);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeHeroBlood(
									Resource.isBelongMyOfHero[mainPageIndex[3]],
									mainPageIndex[3])
									+ "", shuoming_x, shuoming_y + 77);
					if (Resource.isBelongMyOfHero[mainPageIndex[3]] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 73],
								shuoming_x + 40, shuoming_y + 77, 20);
						setColour(0xff0000, Font.SIZE_MEDIUM);
						TextView.showSingleLineText(
								g,
								(Upgrade.upgradeHeroBlood(
										Resource.isBelongMyOfHero[mainPageIndex[3]],
										mainPageIndex[3]) + Resource.heroValue[mainPageIndex[3]][3])
										+ "", shuoming_x + 80, shuoming_y + 77);
					}
					setColour(0x000000, Font.SIZE_MEDIUM);
					TextView.showSingleLineText(g,
							Resource.heroSkillName[mainPageIndex[3]],
							shuoming_x, shuoming_y + 104);
					TextView.showMultiLineText(g,
							Resource.heroSkillInfo[mainPageIndex[3]], 1,
							leftpointx + 320, shuoming_y + 130, 240, 60);
				}
				g.drawImage(img[10], panle_x + 300, panle_y + 320, 20);
			} else if (mainIndex == 4) {
				roleInformation();
				g.drawImage(img[temp_img_distance1 - 6 + 10], leftpointx,
						toppointy, 20);
				for (int s = 0; s < 18; s++) {
					g.drawImage(img[temp_img_distance1 - 6 + 11], leftpointx
							+ 46 + s * 30, toppointy, 20);
				}
				g.drawImage(img[temp_img_distance1 - 6 + 12], leftpointx + 556,
						toppointy, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 13], 0, 0, 82, 84, 0,
						leftpointx - 5, toppointy - 5, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 13], 82, 0, 81, 84,
						0, leftpointx + 526, toppointy - 5, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 55], leftpointx + 216,
						toppointy - 54, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 57], 0, 0, 54, 23, 0,
						leftpointx + 40, toppointy + 33, 20);
				for (int s = 0; s < 4; s++) {
					g.drawImage(img[14], leftpointx + 40, toppointy + 66 + 70
							* s, 20);
					if (s == selectSoldierLocation)
						g.drawImage(img[13], leftpointx + 39, toppointy + 66
								+ 70 * selectSoldierLocation, 20);
					g.drawRegion(img[selectSoldierindex + s
							- selectSoldierLocation],
							Resource.heroAndSoldierLevel[selectSoldierindex + s
									- selectSoldierLocation] / 7 * 62, 0, 62,
							62, 0, leftpointx + 40, toppointy + 66 + 70 * s, 20);
					if (shengjiIndex < 6 && nowUpgreadSoldierIndex == s) {
						g.drawRegion(img[temp_img_distance1 - 6 + 72],
								57 * shengjiIndex, 0, 57, 71, 0,
								leftpointx + 40 + 2, toppointy + 66 - 8 + 70
										* s, 20);
						shengjiIndex++;
					}
					if ((selectSoldierindex + s - selectSoldierLocation == 4 || selectSoldierindex
							+ s - selectSoldierLocation == 5)
							&& Resource.guanqiaLevel[9] <= 0) {
						g.drawImage(img[temp_img_distance1 - 6 + 69],
								leftpointx + 54, toppointy + 81 + 70 * s, 20);
					} else if ((selectSoldierindex + s - selectSoldierLocation == 6 || selectSoldierindex
							+ s - selectSoldierLocation == 7)
							&& Resource.guanqiaLevel[19] <= 0) {
						g.drawImage(img[temp_img_distance1 - 6 + 69],
								leftpointx + 54, toppointy + 81 + 70 * s, 20);
					} else if ((selectSoldierindex + s - selectSoldierLocation == 8)
							&& Resource.guanqiaLevel[29] <= 0) {
						g.drawImage(img[temp_img_distance1 - 6 + 69],
								leftpointx + 54, toppointy + 81 + 70 * s, 20);
					}

					if (Resource.heroAndSoldierLevel[selectSoldierindex + s
							- selectSoldierLocation] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 17],
								leftpointx + 145, toppointy + 66 + 70 * s, 20);
						g.drawImage(img[17], leftpointx + 250, toppointy + 66
								+ 70 * s, 20);
					}
					g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47,
							29, 0, leftpointx + 110, toppointy + 66 + 70 * s,
							20);
					g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47,
							29, 0, leftpointx + 110, toppointy + 96 + 70 * s,
							20);
					if (Resource.heroAndSoldierLevel[selectSoldierindex + s
							- selectSoldierLocation] > 0) {
						g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 20,
								40, 20, 0, leftpointx + 113, toppointy + 71
										+ 70 * s, 20);
						if (Resource.heroAndSoldierLevel[selectSoldierindex + s
								- selectSoldierLocation] != 20) {
							needMoney = Upgrade
									.upgradeSoldierMoney(
											Resource.heroAndSoldierLevel[selectSoldierindex
													+ s - selectSoldierLocation],
											selectSoldierindex + s
													- selectSoldierLocation + 1);
							drawNum(img[16], g, needMoney,
									leftpointx + 250 - 15 - 60, toppointy + 71
											+ 70 * s, 10);
						}
					} else {
						g.drawRegion(img[temp_img_distance1 - 6 + 20], 0, 0,
								40, 20, 0, leftpointx + 113, toppointy + 71
										+ 70 * s, 20);
						needMoney = Resource.soldierMoney[selectSoldierindex
								+ s - selectSoldierLocation];

						drawNum(img[16], g, needMoney,
								leftpointx + 250 - 15 - 60, toppointy + 71 + 70
										* s, 10);
					}

					for (int ggg = 0; ggg < 4; ggg++) {
						if (Resource.savaSelcetSoldier[ggg] == selectSoldierindex
								+ s - selectSoldierLocation) {
							g.drawRegion(img[temp_img_distance1 - 6 + 18], 0,
									40, 40, 20, 0, leftpointx + 113, toppointy
											+ 101 + 70 * s, 20);
							break;
						} else if (ggg == 3) {
							g.drawRegion(img[temp_img_distance1 - 6 + 18], 0,
									20, 40, 20, 0, leftpointx + 113, toppointy
											+ 101 + 70 * s, 20);
						}
					}
				}
				if (mainPage4Index == 0) {
					DrawUtil.drawRect(g, leftpointx + 110, toppointy + 66 + 70
							* selectSoldierLocation, 48, 30, 2, 0xff0000);

				} else if (mainPage4Index == 1) {
					DrawUtil.drawRect(g, leftpointx + 110, toppointy + 66 + 70
							* selectSoldierLocation + 30, 48, 30, 2, 0xff0000);
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 57], 0, 24, 54, 23,
						0, leftpointx + 40, toppointy + 346, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 39], leftpointx + 290,
						toppointy + 35, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 14], leftpointx + 300,
						toppointy + 47, 20);
				int bingzhong_x = leftpointx + 300;
				int bingzhong_y = toppointy + 25;
				setColour(0x000000, Font.SIZE_LARGE);
				if (Resource.heroAndSoldierLevel[selectSoldierindex] < 1) {
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3],
							bingzhong_x + 100, bingzhong_y + 26);
					TextView.showSingleLineText(
							g,
							(Resource.heroAndSoldierLevel[selectSoldierindex] + 1)
									+ "", bingzhong_x + 100, bingzhong_y + 52);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeSoldierAttack(
									Resource.heroAndSoldierLevel[selectSoldierindex] + 1,
									selectSoldierindex + 1)
									+ "", bingzhong_x + 100, bingzhong_y + 78);
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 1]
									+ "", bingzhong_x + 100, bingzhong_y + 104);
					TextView.showMultiLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 2],
							1, bingzhong_x + 100, bingzhong_y + 130, 220, 100);
				} else {
					TextView.showSingleLineText(
							g,
							Resource.soldierNameUp[selectSoldierindex
									* 3
									+ Resource.heroAndSoldierLevel[selectSoldierindex]
									/ 7], bingzhong_x + 100, bingzhong_y + 26);
					TextView.showSingleLineText(g,
							Resource.heroAndSoldierLevel[selectSoldierindex]
									+ "", bingzhong_x + 100, bingzhong_y + 52);
					if (Resource.heroAndSoldierLevel[selectSoldierindex] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 73],
								bingzhong_x + 140, bingzhong_y + 52, 20);
						setColour(0xff0000, Font.SIZE_MEDIUM);
						TextView.showSingleLineText(
								g,
								(Resource.heroAndSoldierLevel[selectSoldierindex] + 1)
										+ "", bingzhong_x + 180,
								bingzhong_y + 52);
					}
					setColour(0x000000, Font.SIZE_MEDIUM);
					TextView.showSingleLineText(
							g,
							Upgrade.upgradeSoldierAttack(
									Resource.heroAndSoldierLevel[selectSoldierindex] + 1,
									selectSoldierindex + 1)
									+ "", bingzhong_x + 100, bingzhong_y + 78);

					if (Resource.heroAndSoldierLevel[selectSoldierindex] != 20) {
						g.drawImage(img[temp_img_distance1 - 6 + 73],
								bingzhong_x + 140, bingzhong_y + 78, 20);
						setColour(0xff0000, Font.SIZE_MEDIUM);
						TextView.showSingleLineText(
								g,
								(Upgrade.upgradeSoldierAttack(
										Resource.heroAndSoldierLevel[selectSoldierindex] + 1,
										selectSoldierindex + 1) + Resource.soldierValue[selectSoldierindex][2])
										+ "", bingzhong_x + 180,
								bingzhong_y + 78);
					}
					setColour(0x000000, Font.SIZE_MEDIUM);
					TextView.showSingleLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 1]
									+ "", bingzhong_x + 100, bingzhong_y + 104);
					TextView.showMultiLineText(
							g,
							Resource.soldierNameAndSomething[selectSoldierindex * 3 + 2],
							1, bingzhong_x + 100, bingzhong_y + 130, 220, 100);
				}
				g.drawImage(img[temp_img_distance1 - 6 + 42], leftpointx + 396,
						toppointy + 265, 20);
				for (int s = 0; s < 4; s++) {
					g.drawImage(img[14], leftpointx + 300 + 70 * s,
							toppointy + 300, 20);
					if (Resource.savaSelcetSoldier[s] != -1) {
						if (isLoadSold == s) {
							drowChangeSoldierAnim(5);
							continue;
						}
						if (Resource.savaSelcetSoldier[s] == selectSoldierindex) {
							if (moveToUPAndDown == 0 || moveToUPAndDown == 1) {
								g.drawRegion(
										img[Resource.savaSelcetSoldier[s]],
										Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
										0, 62, 62, 0,
										leftpointx + 300 + 70 * s, toppointy
												+ 300 + (moveToUPAndDown + 1)
												* 2, 20);
								moveToUPAndDown++;
							} else {
								g.drawRegion(
										img[Resource.savaSelcetSoldier[s]],
										Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
										0, 62, 62, 0,
										leftpointx + 300 + 70 * s, toppointy
												+ 300 + (moveToUPAndDown - 4)
												* 2, 20);
								moveToUPAndDown++;
								if (moveToUPAndDown == 5) {
									moveToUPAndDown = 0;
								}
							}
						} else
							g.drawRegion(
									img[Resource.savaSelcetSoldier[s]],
									Resource.heroAndSoldierLevel[Resource.savaSelcetSoldier[s]] / 7 * 62,
									0, 62, 62, 0, leftpointx + 300 + 70 * s,
									toppointy + 300, 20);
					}
				}
				g.drawImage(img[10], panle_x + 300, panle_y + 340, 20);
			} else if (mainIndex == 6) {
				drawAward();
			} else if (mainIndex == 7) {
				drawShop();
			} else if (mainIndex == 8) {
				drawAttainment(leftpointx, toppointy);
			}
		}
	}

	private void roleInformation() {
		g.drawImage(img[temp_img_distance1 - 6 + 29], 0, 0, 20);
		setColour(0, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g, my.getLevel() + "", 100, 25);
		if (my.getExp() != 0) {
			g.drawRegion(img[temp_img_distance1 - 6 + 60], 0, 0, 2, 17, 0, 129,
					25, 20);
			long temp = Upgrade.upgradeLeaderExp(my.getLevel());
			float unit = (temp * 1.0f) / 50;
			int length = (int) (my.getExp() / unit);
			for (int i = 0; i < length - 1; i++) {
				g.drawRegion(img[temp_img_distance1 - 6 + 60], 2, 0, 2, 17, 0,
						131 + i * 2, 25, 20);
			}
		}
		setColour(0, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g,
				my.getExp() + "/" + Upgrade.upgradeLeaderExp(my.getLevel()),
				129, 25, 100, 19, TextView.STYLE_ALIGN_CENTER);
		setColour(0xffffff, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g, my.getMoney() + "", 300, 25, 100, 19,
				TextView.STYLE_ALIGN_CENTER);
		float unit = Upgrade.upgradeLeaderNengliang((int) my.getLevel()) * 1.0f / 100;
		if (my.getNengliang() != 0) {
			g.drawRegion(img[temp_img_distance1 - 6 + 61], 0, 0, 2, 17, 0, 129,
					59, 20);
			if (my.getNengliang() < Upgrade.upgradeLeaderNengliang(my
					.getLevel())) {
				for (int i = 0; i < ((my.getNengliang() - 1) / unit) / 2; i++) {
					g.drawRegion(img[temp_img_distance1 - 6 + 61], 2, 0, 2, 17,
							0, 131 + i * 2, 59, 20);
				}
			} else {
				for (int i = 0; i < 49; i++) {
					g.drawRegion(img[temp_img_distance1 - 6 + 61], 2, 0, 2, 17,
							0, 131 + i * 2, 59, 20);
				}
				g.drawRegion(img[temp_img_distance1 - 6 + 61], 4, 0, 2, 17, 0,
						227, 59, 20);
			}
		}
		setColour(0, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(
				g,
				my.getNengliang() + "/"
						+ Upgrade.upgradeLeaderNengliang(my.getLevel()), 129,
				60, 100, 17, TextView.STYLE_ALIGN_CENTER);
		if (!SaveAndGet.isFirstGame) {
			setColour(0xffffff, Font.SIZE_MEDIUM);
			g.drawImage(img[temp_img_distance1 - 6 + 71], 240, 60, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 71], 240 + 17, 60, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 71], 240 + 34, 60, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 71], 240 + 51, 60, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 71], 240 + 68, 60, 20);
			long dangqianTime = System.currentTimeMillis();
			long TimeDuan = dangqianTime - Resource.resumeNengliangTime;
			TextView.showSingleLineText(g, (15 * 60 * 1000 - TimeDuan) / 1000
					/ 60 / 10 + "", 240, 60, 15, 20,
					TextView.STYLE_ALIGN_CENTER);
			TextView.showSingleLineText(g, (15 * 60 * 1000 - TimeDuan) / 1000
					/ 60 % 10 + "", 240 + 17, 60, 15, 20,
					TextView.STYLE_ALIGN_CENTER);
			TextView.showSingleLineText(g, "：", 240 + 36, 60, 15, 20,
					TextView.STYLE_ALIGN_CENTER);
			TextView.showSingleLineText(g, (15 * 60 * 1000 - TimeDuan) / 1000
					% 60 / 10 + "", 240 + 51, 60, 15, 20,
					TextView.STYLE_ALIGN_CENTER);
			TextView.showSingleLineText(g, (15 * 60 * 1000 - TimeDuan) / 1000
					% 60 % 10 + "", 240 + 68, 60, 15, 20,
					TextView.STYLE_ALIGN_CENTER);
		}
	}

	public int probability() {
		int i = RandomValue.getRandInt(0, 100);
		int winNums;
		if (i >= 0 && i < 20) {
			winNums = 0;
		} else if (i >= 20 && i < 21) {
			winNums = 1;
		} else if (i >= 21 && i < 31) {
			winNums = 2;
		} else if (i >= 31 && i < 32) {
			winNums = 3;
		} else if (i >= 32 && i < 52) {
			winNums = 4;
		} else if (i >= 52 && i < 53) {
			winNums = 5;
		} else if (i >= 53 && i < 68) {
			winNums = 6;
		} else if (i >= 68 && i < 72) {
			winNums = 7;
		} else if (i >= 72 && i < 97) {
			winNums = 8;
		} else if (i >= 97 && i < 98) {
			winNums = 9;
		} else if (i >= 98 && i < 99) {
			winNums = 10;
		} else {
			winNums = 11;
		}
		return winNums;
	}

	private void handleRewardKey(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (startAward)
				return;
			else {
				if (isAlertAward) {
					if (Resource.count_c_t[0] == 1) {
						Resource.count_c_t[0] = 0;
					}
					isAlertAward = false;
				} else {
					if (Resource.count_c_t[0] == 0) {
						PopupConfirm pc = UIResource.getInstance()
								.buildDefaultPopupConfirm();
						pc.setText("是否花费" + pm.props[11].getPrice()
								+ "TV币购买抽奖道具！");
						alertTime = System.currentTimeMillis();
						if (pc.popup() == 0) {
							boolean flag = pm.buyProp(146, 1, g);
							if (flag) {
								startAward = true;
								winNum = probability();
								int temp = winNum - tempWinNum;
								if (temp < 0) {
									temp = 12 - (tempWinNum - winNum);
								}
								sumCircleNum = 24 + temp;
								if (winNum == 0 || winNum == 4 || winNum == 8) {
									my.setMoney(my.getMoney() + 1000);
								} else if (winNum == 2 || winNum == 6) {
									my.setMoney(my.getMoney() + 2000);
								} else if (winNum == 10) {
									my.setMoney(my.getMoney() + 99999);
								} else if (winNum == 1) {
									Resource.goodsNums[4]++;
								} else if (winNum == 3) {
									Resource.goodsNums[3]++;
								} else if (winNum == 5) {
									Resource.goodsNums[9]++;
								} else if (winNum == 7) {
									Resource.goodsNums[6]++;
								} else if (winNum == 9) {
									Resource.goodsNums[7]++;
								} else if (winNum == 11) {
									Resource.goodsNums[8]++;
								}
							}
						}
						alertSumTime = System.currentTimeMillis() - alertTime;
					} else if (Resource.count_c_t[0] == 1) {
						startAward = true;
						winNum = probability();
						int temp = winNum - tempWinNum;
						if (temp < 0) {
							temp = 12 - (tempWinNum - winNum);
						}
						sumCircleNum = 24 + temp;
						if (winNum == 0 || winNum == 4 || winNum == 8) {
							my.setMoney(my.getMoney() + 1000);
						} else if (winNum == 2 || winNum == 6) {
							my.setMoney(my.getMoney() + 2000);
						} else if (winNum == 10) {
							my.setMoney(my.getMoney() + 99999);
						} else if (winNum == 1) {
							Resource.goodsNums[4]++;
						} else if (winNum == 3) {
							Resource.goodsNums[3]++;
						} else if (winNum == 5) {
							Resource.goodsNums[9]++;
						} else if (winNum == 7) {
							Resource.goodsNums[6]++;
						} else if (winNum == 9) {
							Resource.goodsNums[7]++;
						} else if (winNum == 11) {
							Resource.goodsNums[8]++;
						}
					}
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			if (startAward)
				return;
			if (!isAlertAward) {
				mainIndex = 0;
			}
		}
	}

	public void drawAward() {
		int temp_x = 25;
		int temp_y = 100;
		int i = 0;
		g.drawImage(img[temp_img_distance1 - 6 + 7], 0, 0, 20);
		g.drawImage(img[temp_img_distance1 - 6 + 10], temp_x, temp_y, 20);
		for (i = 0; i < 9; i++) {
			g.drawImage(img[temp_img_distance1 - 6 + 11], temp_x + 46 + i * 30,
					temp_y, 20);
		}
		g.drawImage(img[temp_img_distance1 - 6 + 12], temp_x + 316, temp_y, 20);
		for (i = 0; i < 12; i++) {
			g.drawImage(img[14], p[i].getX(), p[i].getY(), 20);
			if (i == 0) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, p[i].getX() + 6,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 18,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 30,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 42,
						p[i].getY() + 10, 20);
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);// 1000
			} else if (i == 1) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 4 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 双倍金币
			} else if (i == 2) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, p[i].getX() + 0,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 12,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 24,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 36,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 48,
						p[i].getY() + 10, 20);
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);// 10000
			} else if (i == 3) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 3 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 双倍经验
			} else if (i == 4) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, p[i].getX() + 6,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 18,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 30,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 42,
						p[i].getY() + 10, 20);// 1000
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);
			} else if (i == 5) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 9 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 生命谐音
			} else if (i == 6) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, p[i].getX() + 0,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 12,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 24,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 36,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 48,
						p[i].getY() + 10, 20);
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);// 10000
			} else if (i == 7) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 6 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 保护卡
			} else if (i == 8) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, p[i].getX() + 6,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 18,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 30,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, p[i].getX() + 42,
						p[i].getY() + 10, 20);// 1000
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);
			} else if (i == 9) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 7 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 军团之力
			} else if (i == 10) {
				g.drawRegion(img[16], 108, 0, 12, 16, 0, p[i].getX() + 0,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, p[i].getX() + 12,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, p[i].getX() + 24,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, p[i].getX() + 36,
						p[i].getY() + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, p[i].getX() + 48,
						p[i].getY() + 10, 20);
				g.drawImage(img[17], p[i].getX() + 12, p[i].getY() + 30, 20);// 20000
			} else if (i == 11) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 8 * 62, 0, 62,
						62, 0, p[i].getX(), p[i].getY(), 20);// 刚一副护
			}
		}
		if (startAward) {
			if (tempWinNum >= 0 && tempWinNum < 3) {
				weiyiCount++;
				DrawUtil.drawRect(g, p[tempWinNum].getX() + weiyiCount * 80,
						p[tempWinNum].getY(), 61, 61, 3, 0xffff00);
				if (p[tempWinNum].getX() + weiyiCount * 80 == p[tempWinNum + 1]
						.getX()) {
					weiyiCount--;
					stopTime();
				}
			} else if (tempWinNum >= 6 && tempWinNum < 9) {
				weiyiCount--;
				DrawUtil.drawRect(g, p[tempWinNum].getX() + weiyiCount * 80,
						p[tempWinNum].getY(), 61, 61, 3, 0xffff00);
				if (p[tempWinNum].getX() + weiyiCount * 80 == p[tempWinNum + 1]
						.getX()) {
					weiyiCount++;
					stopTime();
				}
			} else if (tempWinNum >= 3 && tempWinNum < 6) {
				weiyiCount++;
				DrawUtil.drawRect(g, p[tempWinNum].getX(), p[tempWinNum].getY()
						+ weiyiCount * 80, 61, 61, 3, 0xffff00);
				if (p[tempWinNum].getY() + weiyiCount * 80 == p[tempWinNum + 1]
						.getY()) {
					weiyiCount--;
					stopTime();
				}
			} else if (tempWinNum >= 9 && tempWinNum < 12) {
				weiyiCount--;
				DrawUtil.drawRect(g, p[tempWinNum].getX(), p[tempWinNum].getY()
						+ weiyiCount * 80, 61, 61, 3, 0xffff00);
				if (tempWinNum != 11
						&& p[tempWinNum].getY() + weiyiCount * 80 == p[tempWinNum + 1]
								.getY()) {
					weiyiCount++;
					stopTime();
				} else if (p[11].getY() + weiyiCount * 80 == p[0].getY()) {
					weiyiCount++;
					stopTime();
				}
			}
		} else {
			DrawUtil.drawRect(g, p[winNum].getX(), p[winNum].getY(), 61, 61, 3,
					0xffff00);
		}
		g.drawImage(img[temp_img_distance1], p[1].getX() + 15,
				p[11].getY() + 15, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 59], 0, 0, 81, 19, 0,
				p[1].getX() + 30, p[11].getY() + 35, 20);
		if (Resource.count_c_t[0] == 1) {
			g.drawRegion(img[temp_img_distance1 - 6 + 59], 0, 19, 81, 19, 0,
					p[1].getX() + 30, p[11].getY() + 75, 20);
		} else {
			g.drawRegion(img[temp_img_distance1 - 6 + 59], 0, 38, 81, 19, 0,
					p[1].getX() + 30, p[11].getY() + 75, 20);
			TextView.showSingleLineText(g, "30", p[1].getX() + 37,
					p[11].getY() + 97);
			g.drawRegion(img[temp_img_distance1 - 6 + 59], 0, 57, 81, 19, 0,
					p[1].getX() + 30, p[11].getY() + 95, 20);
		}
		if (!startAward) {
			arrowAnim(9, p[1].getX() + 70, p[11].getY() + 65, 3, 0, 0);
		}
		setColour(0x000000, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g, "今日免费抽奖次数：" + Resource.count_c_t[0],
				p[1].getX() + 25, p[7].getY() + 70);
		g.drawImage(img[temp_img_distance1 - 6 + 53], temp_x + 380, temp_y, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 27], 0, 108, 85, 18, 0,
				temp_x + 430, temp_y + 20, 20);
		TextView.showMultiLineText(g, "    玩家#R每天#K有#R1#K次免费寻宝的机会。", 5,
				temp_x + 400, temp_y + 50, 180, 30);
		TextView.showMultiLineText(g, "    得到的道具会自动添加到商城个人储物箱中。祝大家好运。", 5,
				temp_x + 400, temp_y + 100, 180, 60);
		if (isAlertAward) {
			g.drawImage(img[temp_img_distance1 - 6 + 39], 180, 150, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 70], 180 + 80, 150 + 15,
					20);
			TextView.showSingleLineText(g, "获得：", 240, 260);
			g.drawImage(img[temp_img_distance2 + 34], 280, 225, 20);
			if (winNum == 0) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, 285 + 6, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 18, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 30, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 42, 230 + 10, 20);
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);// 1000
			} else if (winNum == 1) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 4 * 62, 0, 62,
						62, 0, 285, 230, 20);// 双倍金币
			} else if (winNum == 2) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, 285 + 0, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 12, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 24, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 36, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 48, 230 + 10, 20);
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);// 10000
			} else if (winNum == 3) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 3 * 62, 0, 62,
						62, 0, 285, 230, 20);// 双倍经验
			} else if (winNum == 4) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, 285 + 6, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 18, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 30, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 42, 230 + 10, 20);// 1000
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);
			} else if (winNum == 5) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 9 * 62, 0, 62,
						62, 0, 285, 230, 20);// 生命谐音
			} else if (winNum == 6) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, 285 + 0, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 12, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 24, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 36, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 48, 230 + 10, 20);
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);// 10000
			} else if (winNum == 7) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 6 * 62, 0, 62,
						62, 0, 285, 230, 20);// 保护卡
			} else if (winNum == 8) {
				g.drawRegion(img[16], 12, 0, 12, 16, 0, 285 + 6, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 18, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 30, 230 + 10, 20);
				g.drawRegion(img[16], 0, 0, 12, 16, 0, 285 + 42, 230 + 10, 20);// 1000
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);
			} else if (winNum == 9) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 7 * 62, 0, 62,
						62, 0, 285, 230, 20);// 军团之力
			} else if (winNum == 10) {
				g.drawRegion(img[16], 108, 0, 12, 16, 0, 285 + 0, 230 + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, 285 + 12, 230 + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, 285 + 24, 230 + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, 285 + 36, 230 + 10, 20);
				g.drawRegion(img[16], 108, 0, 12, 16, 0, 285 + 48, 230 + 10, 20);
				g.drawImage(img[17], 285 + 12, 230 + 30, 20);// 20000
			} else if (winNum == 11) {
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 8 * 62, 0, 62,
						62, 0, 285, 230, 20);// 刚一副护
			}
			g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
					287, 320, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 41], 290, 324, 20);
		}
		g.drawImage(img[10], 500, 480, 20);
	}

	private void stopTime() {
		if (circleNum <= sumCircleNum - 7) {
			circleNum++;
			weiyiCount = 0;
			stopCount = -1;
			if (tempWinNum == 11)
				tempWinNum = 0;
			else
				tempWinNum += 1;
		} else if (stopCount == -1) {
			stopCount = RandomValue.getRandInt(0, 2);
		} else if (stopCount == 2) {
			if (tempWinNum == 11)
				tempWinNum = 0;
			else
				tempWinNum += 1;
			circleNum++;
			weiyiCount = 0;
			stopCount = -1;
		} else
			stopCount++;
		if (sumCircleNum == circleNum) {
			isAlertAward = true;
			startAward = false;
			tempWinNum = winNum % 12;
			circleNum = 0;
		}
	}

	public void drawShop() {
		int temp_x = 10;
		int temp_y = 150;
		int i = 0;
		roleInformation();
		g.drawImage(img[temp_img_distance1 - 6 + 45], temp_x, temp_y, 20);
		for (i = 0; i < 35; i++) {
			g.drawImage(img[temp_img_distance1 - 6 + 46], temp_x + 25 + i * 10,
					temp_y, 20);
		}
		g.drawImage(img[temp_img_distance1 - 6 + 47], temp_x + 365, temp_y, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 48], 0, 0, 96, 50, 0, temp_x,
				temp_y - 30, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 49], 0, 0, 80, 20, 0,
				temp_x + 12, temp_y - 10, 20);
		if (shopPage * 6 - 6 >= 0) {
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 0, 0, 23, 54, 0,
					temp_x + 5, temp_y + 117, 20);
		}
		if (shopSum - (shopPage + 1) * 6 > 0)
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 24, 0, 23, 54, 0,
					temp_x + 365, temp_y + 117, 20);

		int temp = (shopSum - shopPage * 6) > 6 ? 6 : (shopSum - shopPage * 6);
		setColour(0xffff00, Font.SIZE_MEDIUM);
		for (i = 0; i < temp; i++) {
			g.drawImage(img[temp_img_distance1 - 6 + 44], temp_x + 33 + (i % 2)
					* 165, temp_y + 40 + i / 2 * 65, 20);
			g.drawRegion(img[temp_img_distance1 - 6 + 59], 0, 57, 81, 19, 0,
					temp_x + 110 + (i % 2) * 165, temp_y + 40 + i / 2 * 65 + 5,
					20);
			drawNum(img[16], g, pm.props[shopPage * 6 + i].getPrice(), temp_x
					+ 100 + (i % 2) * 165, temp_y + 50 + i / 2 * 65, 10);
			g.drawRegion(img[temp_img_distance1 - 6 + 51],
					(shopPage * 6 + i) * 62, 0, 62, 62, 0, temp_x + 33
							+ (i % 2) * 165, temp_y + 40 + i / 2 * 65, 20);
		}
		g.drawImage(img[temp_img_distance1 - 6 + 53], temp_x + 390, temp_y, 20);
		if (shopArea == 1) {
			g.drawRegion(img[temp_img_distance1 - 6 + 51],
					selectShopSmallIndex * 62, 0, 62, 62, 0, temp_x + 400,
					temp_y + 10, 20);
			setColour(0xff0000, Font.SIZE_LARGE);
			TextView.showSingleLineText(g,
					Resource.shopInfo[(selectShopSmallIndex) * 2],
					temp_x + 460, temp_y + 40, 100, 30,
					TextView.STYLE_ALIGN_CENTER);
			setColour(0x000000, Font.SIZE_MEDIUM);
			TextView.showMultiLineText(g,
					Resource.shopInfo[(selectShopSmallIndex) * 2 + 1],
					TextView.STYLE_ALIGN_CENTER, temp_x + 415, temp_y + 100,
					150, 60);
		} else {
			g.drawRegion(img[temp_img_distance1 - 6 + 51], canGoodsIndex * 62,
					0, 62, 62, 0, temp_x + 400, temp_y + 10, 20);
			setColour(0xff0000, Font.SIZE_LARGE);
			TextView.showSingleLineText(g,
					Resource.shopInfo[(canGoodsIndex) * 2], temp_x + 460,
					temp_y + 40, 100, 30, TextView.STYLE_ALIGN_CENTER);
			setColour(0x000000, Font.SIZE_MEDIUM);
			TextView.showMultiLineText(g,
					Resource.shopInfo[(canGoodsIndex) * 2 + 1],
					TextView.STYLE_ALIGN_CENTER, temp_x + 415, temp_y + 100,
					150, 60);
		}
		for (int kl = 0; kl < 5; kl++) {
			g.drawImage(img[temp_img_distance1 - 6 + 52], kl * 144, 420, 20);
		}
		g.drawImage(img[temp_img_distance1 - 6 + 43], 0, 420, 20);
		setColour(0x000000, Font.SIZE_MEDIUM);
		if (canGoodsIndex < 6) {
			for (int kj = 0; kj < 6; kj++) {
				g.drawImage(img[14], 150 + kj * 80, 430, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 62 * kj, 0, 62,
						62, 0, 150 + kj * 80, 430, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 50],
						150 + kj * 80 + 40, 430, 20);
				TextView.showSingleLineText(g, Resource.goodsNums[kj] + "",
						150 + kj * 80 + 40, 430);
				g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
						150 + kj * 80, 492, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 64], 154 + kj * 80,
						497, 20);
			}
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 24, 0, 23, 54, 0,
					615, 430, 20);
		} else {
			for (int kj = 6; kj < Resource.goodsNums.length; kj++) {
				g.drawImage(img[14], 150 + (kj - 6) * 80, 430, 20);
				g.drawRegion(img[temp_img_distance1 - 6 + 51], 62 * kj, 0, 62,
						62, 0, 150 + (kj - 6) * 80, 430, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 50],
						150 + (kj - 6) * 80 + 40, 430, 20);
				TextView.showSingleLineText(g, Resource.goodsNums[kj] + "",
						150 + (kj - 6) * 80 + 40, 430);
				g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
						150 + (kj - 6) * 80, 492, 20);
				g.drawImage(img[temp_img_distance1 - 6 + 64],
						154 + (kj - 6) * 80, 497, 20);
			}
			g.drawRegion(img[temp_img_distance1 - 6 + 31], 0, 0, 23, 54, 0,
					125, 430, 20);
		}
		if (shopArea == 1) {
			if (selectShopSmallIndex < 6)
				arrowAnim(9, temp_x, temp_y, 3,
						155 + selectShopSmallIndex % 2 * 165,
						75 + 62 * (selectShopSmallIndex / 2));
			else {
				arrowAnim(9, temp_x, temp_y, 3,
						155 + (selectShopSmallIndex - 6) % 2 * 165,
						75 + 62 * ((selectShopSmallIndex - 6) / 2));
			}
		} else if (shopArea == 2) {
			arrowAnim(9, 160 + 80 * (canGoodsIndex % 6), 490, 3, 0, 0);
		}
	}

	private void handleMainKey7(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (shopArea == 1) {
				PopupConfirm pc = UIResource.getInstance()
						.buildDefaultPopupConfirm();
				pc.setText("是否花费" + pm.props[selectShopSmallIndex].getPrice()
						+ "TV币购买道具");
				alertTime = System.currentTimeMillis();
				if (pc.popup() == 0) {
					boolean flag = pm.buyProp(135 + selectShopSmallIndex, 1, g);
					if (flag) {
						PlayerProp props = pm
								.getPropById(135 + selectShopSmallIndex);
						props.setNums(props.getNums() + 1);
						Resource.goodsNums[selectShopSmallIndex]++;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			} else if (shopArea == 2) {
				if (canGoodsIndex >= 0 && canGoodsIndex <= 2) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("该物品在战斗中才能使用！");
					alertTimeFn(pt);
				} else if (canGoodsIndex == 3) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (isDoubleMoney) {
						pt.setText("你现在已经拥有双倍经验的状态了，请不要再次使用！");
						alertTimeFn(pt);
					} else {
						if (Resource.goodsNums[3] > 0) {
							pt.setText("你使用了双倍经验卡，在接下来一场战斗中，你将会获得双倍的经验！");
							alertTimeFn(pt);
							Resource.goodsNums[3]--;
							heroStateLength++;
							isDoubleExp = true;
							drawUseProp4();
						} else {
							pt.setText("你还没有该道具，请购买后使用！");
							alertTimeFn(pt);
						}
					}
				} else if (canGoodsIndex == 4) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (isDoubleMoney) {
						pt.setText("你现在已经拥有双倍金币的状态了，请不要再次使用！");
						alertTimeFn(pt);
					} else {
						if (Resource.goodsNums[4] > 0) {
							pt.setText("你使用了双倍金币卡，在接下来一场战斗中，你将会获得双倍的金币！");
							alertTimeFn(pt);
							Resource.goodsNums[4]--;
							heroStateLength++;
							isDoubleMoney = true;
							drawUseProp5();
						} else {
							pt.setText("你还没有该道具，请购买后使用！");
							alertTimeFn(pt);
						}
					}
				} else if (canGoodsIndex == 5) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (Resource.goodsNums[5] > 0) {
						pt.setText("你使用了能量石道具，使你的能量增加，能更好的去战斗！！");
						alertTimeFn(pt);
						Resource.goodsNums[5]--;
						drawUseProp6();
					} else {
						pt.setText("你还没有该道具，请购买后使用！");
						alertTimeFn(pt);
					}
				} else if (canGoodsIndex == 7) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (isDoubleMoney) {
						pt.setText("你已经使用了军团之力，请不要再次使用！");
						alertTimeFn(pt);
					} else {
						if (Resource.goodsNums[7] > 0) {
							pt.setText("你使用了军团之力道具，在接下来一场战斗中，士兵的攻击力将提高20%！");
							alertTimeFn(pt);
							Resource.goodsNums[7]--;
							heroStateLength++;
							isEnhanceSoldierATK = true;
						} else {
							pt.setText("你还没有该道具，请购买后使用！");
							alertTimeFn(pt);
						}
					}
				} else if (canGoodsIndex == 8) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (isDoubleMoney) {
						pt.setText("你已经使用了刚性护虎，请不要再次使用！");
						alertTimeFn(pt);
					} else {
						if (Resource.goodsNums[8] > 0) {
							pt.setText("你使用了刚性护符道具，在接下来一场战斗中，你将会增加20点的防御力！");
							alertTimeFn(pt);
							Resource.goodsNums[8]--;
							heroStateLength++;
							isEnhanceArmor = true;
						} else {
							pt.setText("你还没有该道具，请购买后使用！");
							alertTimeFn(pt);
						}
					}
				} else if (canGoodsIndex == 9) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (isDoubleMoney) {
						pt.setText("你已经使用了生命谐音，请不要再次使用！");
						alertTimeFn(pt);
					} else {
						if (Resource.goodsNums[9] > 0) {
							pt.setText("你使用了生命谐音道具，在接下来一场战斗中，你将会增加20%的生命值！");
							alertTimeFn(pt);
							Resource.goodsNums[9]--;
							heroStateLength++;
							isEnhanceBoold = true;
						} else {
							pt.setText("你还没有该道具，请购买后使用！");
							alertTimeFn(pt);
						}
					}
				} else if (canGoodsIndex == 10) {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					if (Resource.goodsNums[10] > 0) {
						pt.setText("你获得了10000金币！");
						alertTimeFn(pt);
						Resource.goodsNums[10]--;
						drawUseProp11();
					} else {
						pt.setText("你还没有该道具，请购买后使用！");
						alertTimeFn(pt);
					}
				}
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (shopArea == 1) {
				if (selectShopSmallIndex == 1 || selectShopSmallIndex == 3
						|| selectShopSmallIndex == 5
						|| selectShopSmallIndex == 7
						|| selectShopSmallIndex == 9) {
					selectShopSmallIndex--;
					if (selectShopSmallIndex > shopSum - 1) {
						selectShopSmallIndex++;
					}
				} else if (selectShopSmallIndex == 6
						|| selectShopSmallIndex == 8
						|| selectShopSmallIndex == 10) {
					shopPage -= 1;
					selectShopSmallIndex -= 5;
					if (selectShopSmallIndex > shopSum - 1) {
						selectShopSmallIndex += 5;
						shopPage += 1;
					}
				}
			} else if (shopArea == 2) {
				canGoodsIndex--;
				if (canGoodsIndex < 0) {
					canGoodsIndex++;
				}
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (shopArea == 1) {
				if (selectShopSmallIndex == 0 || selectShopSmallIndex == 2
						|| selectShopSmallIndex == 4
						|| selectShopSmallIndex == 6
						|| selectShopSmallIndex == 8) {
					selectShopSmallIndex++;
					if (selectShopSmallIndex > shopSum - 1) {
						selectShopSmallIndex--;
					}
				} else if (selectShopSmallIndex == 1
						|| selectShopSmallIndex == 3
						|| selectShopSmallIndex == 5) {
					shopPage += 1;
					selectShopSmallIndex += 5;
					if (selectShopSmallIndex > shopSum - 1) {
						selectShopSmallIndex -= 5;
						shopPage -= 1;
					}
				}
			} else if (shopArea == 2) {
				canGoodsIndex++;
				if (canGoodsIndex > Resource.goodsNums.length - 1) {
					canGoodsIndex--;
				}
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (shopArea == 1) {
				if (selectShopSmallIndex != 0 && selectShopSmallIndex != 1
						&& selectShopSmallIndex != 6
						&& selectShopSmallIndex != 7) {
					selectShopSmallIndex -= 2;
				}
			} else if (shopArea == 2) {
				shopArea = 1;
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (shopArea == 1) {
				if (selectShopSmallIndex != 4 && selectShopSmallIndex != 5
						&& selectShopSmallIndex != 10
						&& selectShopSmallIndex != 9) {
					selectShopSmallIndex += 2;
					if (selectShopSmallIndex > shopSum - 1) {
						selectShopSmallIndex -= 2;
					}
				} else {
					shopArea = 2;
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			mainIndex = 0;
			shopPage = 0;
		}
	}

	private void arrowAnim(int temp, int leftpointx, int toppointy, int angle,
			int num1, int num2) {
		if (arrowIndex % 16 >= 0 && arrowIndex % 16 < 4)
			g.drawRegion(img[temp], 0, 0, 50, 44, angle, leftpointx + num1,
					toppointy + num2, 20);
		else if (arrowIndex % 16 >= 4 && arrowIndex % 16 < 8)
			g.drawRegion(img[temp], 50, 0, 50, 44, angle, leftpointx + num1,
					toppointy + num2, 20);
		else if (arrowIndex % 16 >= 8 && arrowIndex % 16 < 12)
			g.drawRegion(img[temp], 100, 0, 50, 44, angle, leftpointx + num1,
					toppointy + num2, 20);
		else if (arrowIndex % 16 >= 12 && arrowIndex % 16 < 16)
			g.drawRegion(img[temp], 150, 0, 50, 44, angle, leftpointx + num1,
					toppointy + num2, 20);
	}

	private void drawWin() {
		stopState = true;
		gameIndex = 2;
		g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y, 20);
		int valueClour = 0x000000;
		setColour(valueClour, Font.SIZE_MEDIUM);
		g.drawRegion(img[temp_img_distance2 + 79], 0, 0, 125, 64, 0,
				panle_x + 80, panle_y - 20, 20);
		mayEnterButton = drawStar1(tempStar);
		if (isDoubleExp)
			TextView.showSingleLineText(g, "获得的双倍经验：" + winExp, panle_x + 80,
					panle_y + 70);
		else
			TextView.showSingleLineText(g, "获得的经验：" + winExp, panle_x + 80,
					panle_y + 70);
		if (isDoubleMoney)
			TextView.showSingleLineText(g, "获得的双倍金币：" + winMoney, panle_x + 80,
					panle_y + 90);
		else
			TextView.showSingleLineText(g, "获得的金币：" + winMoney, panle_x + 80,
					panle_y + 90);
		if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1) * 10
				+ tongtiantaAndNormalSmallGuanqia] < tempStar)
			Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1) * 10
					+ tongtiantaAndNormalSmallGuanqia] = (byte) tempStar;
		if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1) * 10
				+ tongtiantaAndNormalSmallGuanqia + 1] == -1)
			Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1) * 10
					+ tongtiantaAndNormalSmallGuanqia + 1] = 0;
		g.drawRegion(img[temp_img_distance1 - 6 + 15], 0, 0, 47, 29, 0,
				panle_x + 117, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 41], 0, 0, 40, 20, 0,
				panle_x + 120, panle_y + 180, 20);
	}

	private void drawTongtiantaWin() {
		stopState = true;
		gameIndex = 8;
		g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y, 20);
		int valueClour = 0x000000;
		setColour(valueClour, Font.SIZE_MEDIUM);
		g.drawRegion(img[temp_img_distance2 + 79], 0, 0, 125, 64, 0,
				panle_x + 80, panle_y - 20, 20);
		TextView.showSingleLineText(g, "获得的经验：" + tongtiantaExp, panle_x + 80,
				panle_y + 70);
		TextView.showSingleLineText(g, "获得的金币：" + tongtiantaMoney,
				panle_x + 80, panle_y + 90);
		TextView.showSingleLineText(g, "继续挑战获得更多经验和金钱！", panle_x + 50,
				panle_y + 110);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 30, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 4, 80, 20, 0,
				panle_x + 38, panle_y + 180, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 155, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 2, 80, 20, 0,
				panle_x + 163, panle_y + 180, 20);
		DrawUtil.drawRect(g, panle_x + 30 + 125 * WinAndFailIndex,
				panle_y + 175, 95, 29, 2, 0xff0000);
	}

	private boolean drawStar1(int count) {
		if (count == 1) {
			if (starIndex == 10) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 100, panle_y - 90, 20);
				return true;
			} else {
				g.drawRegion(img[temp_img_distance2 + 80], starIndex / 2 * 83,
						0, 83, 79, 0, panle_x + 100, panle_y - 90, 20);
			}
			starIndex++;
		} else if (count == 2) {
			if (starIndex >= 10) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 40, panle_y - 75, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 80], starIndex / 2 * 83,
						0, 83, 79, 0, panle_x + 40, panle_y - 75, 20);
			}
			if (starIndex >= 10 && starIndex < 20) {
				g.drawRegion(img[temp_img_distance2 + 80],
						(starIndex - 10) / 2 * 83, 0, 83, 79, 0, panle_x + 160,
						panle_y - 75, 20);
			} else if (starIndex == 20) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 160, panle_y - 75, 20);
				starIndex--;
				return true;
			}
			starIndex++;
		} else if (count == 3) {
			if (starIndex >= 10) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 40, panle_y - 75, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 80], starIndex / 2 * 83,
						0, 83, 79, 0, panle_x + 40, panle_y - 75, 20);
			}
			if (starIndex >= 10 && starIndex < 20) {
				g.drawRegion(img[temp_img_distance2 + 80],
						(starIndex - 10) / 2 * 83, 0, 83, 79, 0, panle_x + 160,
						panle_y - 75, 20);
			} else if (starIndex >= 20) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 160, panle_y - 75, 20);
			}
			if (starIndex >= 20 && starIndex < 30) {
				g.drawRegion(img[temp_img_distance2 + 80],
						(starIndex - 20) / 2 * 83, 0, 83, 79, 0, panle_x + 100,
						panle_y - 90, 20);
			} else if (starIndex == 30) {
				g.drawRegion(img[temp_img_distance2 + 80], 4 * 83, 0, 83, 79,
						0, panle_x + 100, panle_y - 90, 20);
				starIndex--;
				return true;
			}
			starIndex++;
		}
		return false;
	}

	public void drawFail() {
		gameIndex = 1;
		stopState = true;
		g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y, 20);
		int valueClour = 0x000000;
		setColour(valueClour, Font.SIZE_MEDIUM);
		g.drawRegion(img[temp_img_distance2 + 79], 125, 0, 125, 64, 0,
				panle_x + 80, panle_y - 20, 20);
		TextView.showMultiLineText(g, "使用复活可以继续游戏。", 10, panle_x + 50,
				panle_y + 60, 180, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 30, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 4, 80, 20, 0,
				panle_x + 38, panle_y + 180, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 155, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 3, 80, 20, 0,
				panle_x + 163, panle_y + 180, 20);
		DrawUtil.drawRect(g, panle_x + 30 + 125 * WinAndFailIndex,
				panle_y + 175, 95, 29, 2, 0xff0000);
	}

	public void drawTongtiantaFail() {
		gameIndex = 9;
		stopState = true;
		g.drawImage(img[temp_img_distance1 - 6 + 39], panle_x, panle_y, 20);
		int valueClour = 0x000000;
		setColour(valueClour, Font.SIZE_MEDIUM);
		g.drawRegion(img[temp_img_distance2 + 79], 125, 0, 125, 64, 0,
				panle_x + 80, panle_y - 20, 20);
		TextView.showSingleLineText(g, "获得的经验：" + tongtiantaExp, panle_x + 80,
				panle_y + 70);
		TextView.showSingleLineText(g, "获得的金币：" + tongtiantaMoney,
				panle_x + 80, panle_y + 90);
		TextView.showSingleLineText(g, "挑战失败损失一半的奖励。", panle_x + 50,
				panle_y + 110);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 30, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 4, 80, 20, 0,
				panle_x + 38, panle_y + 180, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				panle_x + 155, panle_y + 175, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 68], 0, 20 * 3, 80, 20, 0,
				panle_x + 163, panle_y + 180, 20);
		DrawUtil.drawRect(g, panle_x + 30 + 125 * WinAndFailIndex,
				panle_y + 175, 95, 29, 2, 0xff0000);
	}

	public void ArrayHandle(Vector v, int imgIndex, int block) {
		for (int i = 0; i < v.size();) {
			if (v.elementAt(i) != null) {
				monsterHurtAnim((Monster) v.elementAt(i), i, v, imgIndex, block);
			}
		}
	}

	public void drawSuggest() {
		int temp_x = 170;
		int temp_y = 140;
		g.drawImage(img[18], temp_x, temp_y, 20);
		g.drawRegion(img[19], 0, 25 * 1, 91, 25, 0, temp_x + 109, temp_y + 10,
				20);
		for (int i = 0; i < 4; i++) {
			g.drawImage(img[14], temp_x + 18 + 70 * i, temp_y + 60, 20);
			if (suggestIndex == i) {
				g.drawImage(img[13], temp_x + 18 + 70 * i, temp_y + 60, 20);
				setColour(0xffffff, Font.SIZE_SMALL);
			} else {
				setColour(0x0000ff, Font.SIZE_SMALL);
			}
			g.drawRegion(img[temp_img_distance1 - 6 + 51], 62 * (7 + i), 0, 62,
					62, 0, temp_x + 18 + 70 * i, temp_y + 60, 20);
			TextView.showSingleLineText(g, Resource.shopInfo[(i + 7) * 2],
					temp_x + 18 + 70 * i, temp_y + 122);
		}
		g.drawImage(img[10], temp_x + 200, temp_y + 150, 20);
	}

	public void drawGame() {
		if (stopState || isSuggest) {
			long suggestAndStopEndTimeTemp = System.currentTimeMillis();
			suggestAndStopEndTime = suggestAndStopEndTimeTemp
					- suggestAndStopStartTime;
			suggestAndStopStartTime = suggestAndStopEndTimeTemp;
		} else {
			suggestAndStopEndTime = 0;
			suggestAndStopStartTime = 0;
		}
		g.drawImage(
				img[temp_img_distance2 + tongtiantaAndNormalBigGuanqia - 1], 0,
				0, 20);
		drawMonster();
		drawSoldier();
		drawMoveSoldier();
		if (bossStart) {
			for (int kg = 0; kg < monsterVector.size(); kg++) {
				if (((Monster) monsterVector.elementAt(kg)).getKind() == 14)
					drawBoss1Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 15)
					drawBoss2Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 16)
					drawBoss3Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 17)
					drawBoss4Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 18)
					drawBoss5Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 19)
					drawBoss6Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 20)
					drawBoss7Bullet();
				else if (((Monster) monsterVector.elementAt(kg)).getKind() == 21)
					drawBoss8Bullet();
			}
		}
		ArrayHandle(v1a, temp_img_distance2 + 51, 3);
		ArrayHandle(v2a, temp_img_distance2 + 51, 3);
		ArrayHandle(v3a, temp_img_distance2 + 53, 5);
		ArrayHandle(v4a, temp_img_distance2 + 51, 3);
		ArrayHandle(v5a, temp_img_distance2 + 74, 4);
		ArrayHandle(v6a, temp_img_distance2 + 51, 3);
		ArrayHandle(v7a, temp_img_distance2 + 53, 5);
		ArrayHandle(v8a, temp_img_distance2 + 54, 5);
		ArrayHandle(v9a, temp_img_distance2 + 75, 4);
		for (int i = 0; i < deathArray.size();) {
			if (deathArray.elementAt(i) != null) {
				i = drawDeath((Monster) deathArray.elementAt(i), i);
			}
		}
		for (int i = 0; i < criticalArray.size();) {
			if (criticalArray.elementAt(i) != null) {
				i = showHurtAnim((Critical) criticalArray.elementAt(i), i,
						criticalArray, 0, temp_img_distance2 + 64);
			}
		}
		for (int i = 0; i < criticalArray1.size();) {
			if (criticalArray1.elementAt(i) != null) {
				i = showHurtAnim((Critical) criticalArray1.elementAt(i), i,
						criticalArray1, 1, temp_img_distance2 + 64);
			}
		}
		for (int i = 0; i < criticalArray2.size();) {
			if (criticalArray2.elementAt(i) != null) {
				i = showHurtAnim2((Critical) criticalArray2.elementAt(i), i,
						criticalArray2, 3, temp_img_distance2 + 77,
						temp_img_distance2 + 85);
			}
		}
		for (int kk = 0; kk < IceDrowVector.size();) {
			kk = drawIceDrow((IceDrow) IceDrowVector.elementAt(kk), kk);
		}
		for (int kk = 0; kk < stickVector.size();) {
			kk = drawStick((Bullet) stickVector.elementAt(kk), kk);
		}
		drawMonsterBullet1();
		drawSoldierBullet1();
		drawSoldierBullet2();
		drawSoldierBullet3();
		drawSoldierBullet4();
		// drawSwordScar();
		diaoblood();
		drawHeroInfo1(hero);
		hero.setNegativeTime(hero.getNegativeTime() + suggestAndStopEndTime);
		if (System.currentTimeMillis() - hero.getNegativeTime() > 10000) {// 怪物11给的负面buff
			hero.setDefenceCoefficient(1.0f);
		} else {
			g.drawRegion(img[temp_img_distance2 + 81], 5 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		if (isDoubleExp) {// 经验buff位置
			g.drawRegion(img[temp_img_distance2 + 81], 7 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		if (isDoubleMoney) {// 金币buff位置
			g.drawRegion(img[temp_img_distance2 + 81], 6 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		if (isAddArmor// 英雄2护盾的buff
				&& (System.currentTimeMillis() - addArmorStartTime - suggestAndStopEndTime) < 10000) {
			g.drawRegion(img[temp_img_distance2 + 81], 4 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		} else {
			isAddArmor = false;
		}
		if (isEnhanceBoold) {// 增加血量的buff
			g.drawRegion(img[temp_img_distance2 + 81], 1 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		if (isEnhanceArmor) {// 增加护甲的buff
			g.drawRegion(img[temp_img_distance2 + 81], 2 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		if (isEnhanceSoldierATK) {// 增加士兵攻击力的buff
			g.drawRegion(img[temp_img_distance2 + 81], 0 * 24, 0, 24, 24, 0,
					Hero.booldX + heroStateIndex * 24, Hero.booldY - 25, 20);
			heroStateIndex++;
		}
		drawHeroSkill();
		judgeRemove();
		if (useProp[0] == 1) {
			drawUseProp1(hero);
		}
		if (useProp[1] == 2) {
			drawUseProp2();
		}
		if (useProp[2] == 3) {
			drawUseProp3();
		}
		if (isNowHeroSay) {
			drawHeroSay();
		}
		if (isNowSoldierSay) {
			drawSoldierSay();
		}
		int returnWinValue = judgeWinAndFail();
		heroStateIndex = 0;
		if (returnWinValue != 1 && stopState) {
			drawStopPanel();
			return;
		}
		if (isSuggest)
			drawSuggest();
		arrowIndex++;
		if (arrowIndex == 10000)
			arrowIndex = 0;
	}

	private void diaoblood() {
		hero.setHurtStartTime(hero.getHurtStartTime() + suggestAndStopEndTime);
		if (hero.isLastHurt() && !stopState && !isSuggest) {
			if (System.currentTimeMillis() - hero.getHurtStartTime() < Hero.hurtTime) {
				if (System.currentTimeMillis() - hero.getHurtStartTime() >= 1000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 2000) {
					if (diaobloodIndex == 0) {
						diaobloodIndex = 1;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 2000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 3000) {
					if (diaobloodIndex == 1) {
						diaobloodIndex = 2;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 3000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 4000) {
					if (diaobloodIndex == 2) {
						diaobloodIndex = 3;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 4000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 5000) {
					if (diaobloodIndex == 3) {
						diaobloodIndex = 4;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 5000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 6000) {
					if (diaobloodIndex == 4) {
						diaobloodIndex = 5;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 6000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 7000) {
					if (diaobloodIndex == 5) {
						diaobloodIndex = 6;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 7000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 8000) {
					if (diaobloodIndex == 6) {
						diaobloodIndex = 7;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 8000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 9000) {
					if (diaobloodIndex == 7) {
						diaobloodIndex = 8;
						hero.setBoold(hero.getBoold() - 5);
					}
				} else if (System.currentTimeMillis() - hero.getHurtStartTime() >= 9000
						&& System.currentTimeMillis() - hero.getHurtStartTime() < 10000) {
					if (diaobloodIndex == 8) {
						diaobloodIndex = 9;
						hero.setBoold(hero.getBoold() - 5);
					}
				}
				if (hero.getBoold() <= 0) {
					hero.setBoold(0);
				}
			} else {
				hero.setLastHurt(false);
				hero.setHurtStartTime(0);
			}
		}
	}

	public void auto0Skill() {
		if (monsterVector.size() != 0) {
			int temp = RandomValue.getRandInt(0, monsterVector.size());
			heroSkillmonster.addElement(monsterVector.elementAt(temp));
			for (int i = 0; i < monsterVector.size(); i++) {
				if (((Monster) monsterVector.elementAt(i)).getY() != ((Monster) monsterVector
						.elementAt(temp)).getY()
						&& ((Monster) monsterVector.elementAt(i)).getX() == ((Monster) monsterVector
								.elementAt(temp)).getX()) {
					Monster m = new Monster();
					m = (Monster) monsterVector.elementAt(i);
					heroSkillmonster.addElement(m);
				}
			}
			skill1Hero = new Point(
					250,
					11 + (((Monster) (heroSkillmonster.elementAt(0))).getX() - 1) * 60 + 20,
					0);
			hero.setMagic(0, 0);
		}
	}

	public void auto3Skill() {
		skill1Hero = new Point(hero.getX(), hero.getY(), 0);
		hero.setMagic(0, 0);
		hero.setBoold(hero.getBoold() + 200);
		if (hero.getBoold() > hero.getBoolds())
			hero.setBoold(hero.getBoolds());
	}

	public void auto4Skill() {
		if (monsterVector.size() != 0) {
			for (int i = 0; i < monsterVector.size(); i++) {
				Monster m = new Monster();
				m = (Monster) monsterVector.elementAt(i);
				heroSkillmonster.addElement(m);
			}
			skill1Hero = new Point(180, 30, 0);
			hero.setMagic(0, 0);
		}
	}

	public void auto5Skill() {
		if (monsterVector.size() != 0) {
			for (int i = 0; i < monsterVector.size(); i++) {
				Monster m = new Monster();
				m = (Monster) monsterVector.elementAt(i);
				heroSkillmonster.addElement(m);
			}
			skill1Hero1 = new Point(180, 30, 0);
		}
	}

	public void drawStopPanel() {
		int ttt_x = 212;
		int ttt_y = 130;
		g.drawImage(img[temp_img_distance1 - 6 + 53], ttt_x, ttt_y, 20);
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				ttt_x + 60, ttt_y + 30, 20);
		g.drawRegion(img[temp_img_distance2 + 66], 0, 0, 81, 20, 0,
				ttt_x + 60 + 7, ttt_y + 30 + 4, 20);
		if (!isTongtianta) {
			g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
					ttt_x + 60, ttt_y + 80, 20);
			g.drawRegion(img[temp_img_distance2 + 66], 0, 20, 81, 20, 0,
					ttt_x + 60 + 7, ttt_y + 80 + 4, 20);
		}
		g.drawRegion(img[temp_img_distance1 - 6 + 16], 0, 0, 95, 29, 0,
				ttt_x + 60, ttt_y + 130, 20);
		g.drawRegion(img[temp_img_distance2 + 66], 0, 40, 81, 20, 0,
				ttt_x + 60 + 7, ttt_y + 130 + 4, 20);
		DrawUtil.drawRect(g, ttt_x + 60, ttt_y + 30 + 50 * stopIndex, 95, 29,
				2, 0xff0000);
	}

	public int judgeWinAndFail() {
		for (int ads = 0; ads < monsterVector.size();) {
			Monster m = (Monster) monsterVector.elementAt(ads);
			if (m.getBoold() <= 0) {
				monsterVector.removeElement(m);
			} else {
				ads++;
			}
		}
		if (monsterVector.size() == 0 && deathArray.size() == 0) {
			if (mapIndexOfIndex < 4) {
				getMonster();
				return 0;
			} else {
				if (win1 == 0) {
					winExp = Upgrade
							.guanqiaExp((tongtiantaAndNormalBigGuanqia - 1)
									* 10 + tongtiantaAndNormalSmallGuanqia);
					winMoney = Upgrade
							.guanqiaMoney((tongtiantaAndNormalBigGuanqia - 1)
									* 10 + tongtiantaAndNormalSmallGuanqia);
					if (isDoubleExp)
						winExp = winExp * 2;
					if (isDoubleMoney)
						winMoney = winMoney * 2;
					tongtiantaExp += winExp;
					tongtiantaMoney += winMoney;
					Resource.saveSelectHero = (byte) Resource.saveSelectHero;
					sag.saveData();
					if (!isTongtianta) {
						changeLeaderOfProperty(winMoney, winExp);
						win1 = 1;
						mayEnterButton = false;
						starIndex = 0;
						if ((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
										* 10 + tongtiantaAndNormalSmallGuanqia] < 1) {
							if (tongtiantaAndNormalSmallGuanqia == 4) {
								UnfoldAttainmentIndex = tongtiantaAndNormalBigGuanqia * 2 - 1;
							} else {
								UnfoldAttainmentIndex = tongtiantaAndNormalBigGuanqia * 2 - 1 + 1;
							}
						}
						if (hero.getBoold() >= hero.getBoolds() * 0.8)
							tempStar = 3;
						else if (hero.getBoold() >= hero.getBoolds() * 0.2
								&& hero.getBoold() < hero.getBoolds() * 0.8)
							tempStar = 2;
						else
							tempStar = 1;
						drawWin();
					} else {
						win1 = 1;
						WinAndFailIndex = 1;
						if (tongtiantaIndex == 0) {
							tempFloor++;
						} else {
							Resource.tongtiantafloor++;
						}
						drawTongtiantaWin();
					}
				} else {
					if (!isTongtianta) {
						drawWin();
					} else {
						drawTongtiantaWin();
					}
				}
				return 1;
			}
		}
		if (hero.getBoold() <= 0) {
			mayEnterButton = true;
			if (win1 == 0) {
				WinAndFailIndex = 1;
				win1 = 1;
			}
			if (!isTongtianta) {
				drawFail();
			} else {
				drawTongtiantaFail();
			}
			return 1;
		} else {
			return 0;
		}
	}

	public int drawStick(Bullet b, int kk) {
		g.drawImage(b.getSrc(), b.getX(), b.getY(), 20);
		if (b.getX() < 0) {
			monster10AttackAndAbsorbOfHero();
			stickVector.removeElement(b);
		} else {
			if (!stopState && !isSuggest)
				b.setX(b.getX() - 50);
			kk++;
		}
		return kk;
	}

	private void setColour(int valueClour, int bigSmall) {
		g.setColor(valueClour);
		Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, bigSmall);
		g.setFont(font);
	}

	private void drawHeroSkill() {
		if (skill1Hero != null && hero.getKind() == 0) {
			drawSkill0();
		} else if (skill1Hero != null && hero.getKind() == 1) {
			drawSkill1();
		} else if (skill1Hero != null && hero.getKind() == 2) {
			drawSkill2();
		} else if (skill1Hero != null && hero.getKind() == 3) {
			drawSkill3();
		} else if (skill1Hero != null && hero.getKind() == 4) {
			drawSkill4();
		} else if (skill1Hero != null && hero.getKind() == 5) {
			drawSkill3();
			drawSkill5();
		}
	}

	public int drawDeath(Monster m, int l) {
		int j = m.getAnimDeath();
		if (j % 6 >= 0 && j % 6 < 2) {
			g.drawRegion(img[temp_img_distance2 + 39], 0, 0, 62, 52, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60, 20);
		} else if (j % 6 >= 2 && j % 6 < 4) {
			g.drawRegion(img[temp_img_distance2 + 39], 62, 0, 62, 52, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60, 20);
		} else {
			g.drawRegion(img[temp_img_distance2 + 39], 124, 0, 62, 52, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60, 20);
		}
		if (j % 6 == 5) {
			deathArray.removeElement(m);
			m = null;
		} else {
			l++;
		}
		if (!stopState && !isSuggest && m != null)
			m.setAnimDeath(++j);
		return l;
	}

	public void drawMonster() {
		for (int h = 0; h < monsterVector.size();) {
			Monster m = (Monster) monsterVector.elementAt(h);
			if (m.getBoold() != 0) {
				if (m.getKind() >= 1 && m.getKind() <= 3 || m.getKind() == 5
						|| m.getKind() == 6)
					h = monster12356Attack(h, m);
				else if (m.getKind() == 4)
					h = monster4Attack(h, m);
				else if (m.getKind() == 7)
					h = monster7Attack(h, m);
				else if (m.getKind() >= 8 && m.getKind() <= 13)
					h = monster8_13Attack(h, m);
				else if (m.getKind() == 14)
					h = boss1Attack(h, m);
				else if (m.getKind() == 15)
					h = boss2Attack(h, m);
				else if (m.getKind() == 16)
					h = boss3Attack(h, m);
				else if (m.getKind() == 17)
					h = boss4Attack(h, m);
				else if (m.getKind() == 18)
					h = boss5Attack(h, m);
				else if (m.getKind() == 19)
					h = boss6Attack(h, m);
				else if (m.getKind() == 20)
					h = boss7Attack(h, m);
				else if (m.getKind() == 21)
					h = boss8Attack(h, m);
				else if (m.getKind() == 22)
					h = monster22Attack(h, m);
			} else {
				h++;
			}
		}
	}

	public int showHurtAnim(Critical c, int l, Vector v, int baoji, int imgIndex) {
		c.setTime(c.getTime() + suggestAndStopEndTime);
		long end = System.currentTimeMillis();
		int temp = c.getNum();
		int movePixel = c.getMovePixel();
		if (baoji == 0) {
			g.drawImage(img[temp_img_distance2 + 65], c.getX() - 10, c.getY()
					- 30 - movePixel, 20);
		}
		drawNum(img[imgIndex], g, temp, c.getX() + 20, c.getY() - 20
				- movePixel, 10);
		if (!stopState && !isSuggest)
			c.setMovePixel(c.getMovePixel() + 6);
		if (!stopState && !isSuggest && end - c.getTime() >= Critical.showtime) {
			if (baoji == 3) {
				c.setCount(c.getCount() + 1);
				c.setTime(System.currentTimeMillis());
				c.setMovePixel(0);
				if (c.getCount() == 3) {
					v.removeElement(c);
				}
			} else {
				v.removeElement(c);
			}
		} else {
			l++;
		}
		return l;
	}

	public int showHurtAnim2(Critical c, int l, Vector v, int baoji,
			int imgIndex, int imgIndex1) {
		c.setTime(c.getTime() + suggestAndStopEndTime);
		long end = System.currentTimeMillis();
		int temp = c.getNum();
		int movePixel = c.getMovePixel();
		if (baoji == 0) {
			g.drawImage(img[temp_img_distance2 + 65], c.getX() - 10, c.getY()
					- 30 - movePixel, 20);
		}
		drawNum(img[imgIndex], g, temp, c.getX() + 10, c.getY() - 20
				- movePixel, 11);
		g.drawRegion(img[imgIndex1], c.getIndex() / 2 % 5 * 52, 0, 52, 54, 0,
				c.getX() + 10, c.getY(), 20);
		if (!stopState && !isSuggest) {
			c.setMovePixel(c.getMovePixel() + 6);
			c.setIndex(c.getIndex() + 1);
		}
		if (!stopState && !isSuggest && end - c.getTime() >= Critical.showtime) {
			if (baoji == 3) {
				Monster m = c.getM();
				m.setBoold(m.getBoold() - c.getNum());
				if (m.getBoold() <= 0) {
					m.setBoold(0);
					deathArray.addElement(m);
					monsterVector.removeElement(m);
					v.removeElement(c);
					return l;
				}
				c.setCount(c.getCount() + 1);
				c.setTime(System.currentTimeMillis());
				c.setMovePixel(0);
				c.setIndex(0);
				if (c.getCount() == 3) {
					v.removeElement(c);
				}
			} else {
				v.removeElement(c);
			}
		} else {
			l++;
		}
		return l;
	}

	public void drawSkill0() {
		int j = hero.getSkillIndex();
		if (!stopState && !isSuggest)
			skill1Hero.setX(skill1Hero.getX() + 20);
		for (int i = 0; i < heroSkillmonster.size(); i++) {
			Monster m = ((Monster) heroSkillmonster.elementAt(i));
			if (385 + m.getY() * 60 >= skill1Hero.getX()
					&& 385 + m.getY() * 60 <= skill1Hero.getX() + 15) {
				m.setShowBlood(true);
				m.setStartBlood(System.currentTimeMillis());
				int hurtNum = Upgrade.upgradeHeroAttack(hero.getLevel(),
						hero.getKind());
				m.setBoold(m.getBoold() - hurtNum);
				if (m.getBoold() <= 0) {
					m.setBoold(0);
					deathArray.addElement(m);
					monsterVector.removeElement(m);
				}
				Critical c = new Critical(385 + m.getY() * 60,
						11 + m.getX() * 60, hurtNum, null);
				criticalArray1.addElement(c);
			}
			if (j % 4 >= 0 && j % 4 < 2) {
				g.drawRegion(img[temp_img_distance2 + 63], 0, 0, 120, 88, 0,
						skill1Hero.getX(), skill1Hero.getY(), 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 63], 120, 0, 120, 88, 0,
						skill1Hero.getX(), skill1Hero.getY(), 20);
			}
		}
		if (!stopState && !isSuggest)
			hero.setSkillIndex(hero.getSkillIndex() + 1);
		if (skill1Hero.getX() >= 660) {
			hero.setSkillIndex(0);
			heroSkillmonster.removeAllElements();
			skill1Hero = null;
		}
	}

	public void drawSkill1() {
		int j = hero.getSkillIndex();
		g.drawRegion(img[temp_img_distance2 + 78], j / 2 * 281, 0, 281, 214, 0,
				180, 108, 20);
		if (!stopState && !isSuggest)
			hero.setSkillIndex(hero.getSkillIndex() + 1);
		if (hero.getSkillIndex() == 11) {
			hero.setSkillIndex(0);
			skill1Hero = null;
			heroStateLength++;
			addArmorStartTime = System.currentTimeMillis();
			isAddArmor = true;

		}
	}

	public void drawSkill2() {
		int j = hero.getSkillIndex();
		if (!stopState && !isSuggest)
			skill1Hero.setX(skill1Hero.getX() + 20);
		for (int i = 0; i < heroSkillmonster.size(); i++) {
			Monster m = ((Monster) heroSkillmonster.elementAt(i));
			if (385 + m.getY() * 60 >= skill1Hero.getX()
					&& 385 + m.getY() * 60 <= skill1Hero.getX() + 15) {
				m.setShowBlood(true);
				m.setStartBlood(System.currentTimeMillis());
				int hurtNum = Upgrade.upgradeHeroAttack(hero.getLevel(),
						hero.getKind());
				m.setBoold(m.getBoold() - hurtNum);
				m.setStartTime(System.currentTimeMillis() + alertSumTime);
				if (m.getBoold() <= 0) {
					m.setBoold(0);
					deathArray.addElement(m);
					monsterVector.removeElement(m);
				}
				Critical c = new Critical(385 + m.getY() * 60,
						11 + m.getX() * 60, hurtNum, null);
				criticalArray1.addElement(c);
			}
			if (j % 8 >= 0 && j % 8 < 2) {
				g.drawRegion(img[temp_img_distance2 + 69], 0, 0, 71, 71, 0,
						skill1Hero.getX(), skill1Hero.getY() + 30, 20);
			} else if (j % 8 >= 2 && j % 8 < 4) {
				g.drawRegion(img[temp_img_distance2 + 69], 71, 0, 71, 71, 0,
						skill1Hero.getX(), skill1Hero.getY() + 30, 20);
			} else if (j % 8 >= 4 && j % 8 < 6) {
				g.drawRegion(img[temp_img_distance2 + 69], 71 * 2, 0, 71, 71,
						0, skill1Hero.getX(), skill1Hero.getY() + 30, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 69], 71 * 3, 0, 71, 71,
						0, skill1Hero.getX(), skill1Hero.getY() + 30, 20);
			}
		}
		if (!stopState && !isSuggest)
			hero.setSkillIndex(hero.getSkillIndex() + 1);
		if (skill1Hero.getX() >= 660) {
			hero.setSkillIndex(0);
			heroSkillmonster.removeAllElements();
			skill1Hero = null;
		}
	}

	private void drawSkill3() {
		int dnf = Resource.heroValue[3][6] + (hero.getLevel() - 1)
				* Resource.heroValue[3][7];
		if (!stopState && !isSuggest)
			hero.setSkillIndex(hero.getSkillIndex() + 1);
		int j = hero.getSkillIndex();
		if (j % 10 >= 0 && j % 10 < 2) {
			g.drawRegion(img[temp_img_distance2 + 67], 0, 0, 60, 113, 0,
					skill1Hero.getX(), skill1Hero.getY(), 20);
			if (j == 11) {
				skill1Hero = null;
				if (hero.getKind() == 3) {
					hero.setSkillIndex(0);
				}
			} else if (j == 1) {
				int dnf1 = (hero.getBoold()
						+ Resource.heroValue[hero.getKind()][6] + (hero
						.getLevel() - 1)
						* Resource.heroValue[hero.getKind()][7]) >= hero
						.getBoolds() ? hero.getBoolds() : (hero.getBoold()
						+ Resource.heroValue[hero.getKind()][6] + (hero
						.getLevel() - 1)
						* Resource.heroValue[hero.getKind()][7]);
				hero.setBoold(dnf1);
			}
		} else if (j % 10 >= 2 && j % 10 < 4) {
			g.drawRegion(img[temp_img_distance2 + 67], 60, 0, 60, 113, 0,
					skill1Hero.getX(), skill1Hero.getY(), 20);
		} else if (j % 10 >= 4 && j % 10 < 6) {
			g.drawRegion(img[temp_img_distance2 + 67], 120, 0, 60, 113, 0,
					skill1Hero.getX(), skill1Hero.getY(), 20);
		} else if (j % 10 >= 6 && j % 10 < 8) {
			g.drawRegion(img[temp_img_distance2 + 67], 180, 0, 60, 113, 0,
					skill1Hero.getX(), skill1Hero.getY(), 20);
		} else {
			g.drawRegion(img[temp_img_distance2 + 67], 240, 0, 60, 113, 0,
					skill1Hero.getX(), skill1Hero.getY(), 20);
		}

		g.drawRegion(img[temp_img_distance2 + 77], 20 * 10, 0, 20, 25, 0,
				hero.getX(), hero.getY() + (10 - j) * 2, 20);
		drawNum(img[temp_img_distance2 + 77], g, dnf, hero.getX() + 20,
				hero.getY() + (10 - j) * 2, 11);
	}

	public static void drawNum(Image img, SGraphics g, long n, int x, int y,
			int count) {
		String number = String.valueOf(n);
		int numW = img.getWidth() / count, numH = img.getHeight();
		for (byte i = 0; i < number.length(); i++) {
			g.drawRegion(img, (number.charAt(i) - '0') * numW, 0, numW, numH,
					0, x, y, 0);
			x += numW + 1;
		}
	}

	private void drawUseProp1(Hero hero) {
		if (!stopState && !isSuggest)
			hero.setSkillIndex(hero.getSkillIndex() + 1);
		int jiaxue = hero.getBoolds() * 4 / 10;
		int j = hero.getSkillIndex();
		if (j % 10 >= 0 && j % 10 < 2) {
			g.drawRegion(img[temp_img_distance2 + 67], 0, 0, 60, 113, 0,
					hero.getX(), hero.getY(), 20);
			if (j == 11) {
				useProp[0] = 0;
				hero.setSkillIndex(0);
				if (newGuideIndex == 4) {
					newGuideIndex = 5;
				}
			} else if (j == 1) {
				int dnf = (hero.getBoold() + jiaxue) >= hero.getBoolds() ? hero
						.getBoolds() : (hero.getBoold() + jiaxue);
				hero.setBoold(dnf);
			}
		} else if (j % 10 >= 2 && j % 10 < 4) {
			g.drawRegion(img[temp_img_distance2 + 67], 60, 0, 60, 113, 0,
					hero.getX(), hero.getY(), 20);
		} else if (j % 10 >= 4 && j % 10 < 6) {
			g.drawRegion(img[temp_img_distance2 + 67], 120, 0, 60, 113, 0,
					hero.getX(), hero.getY(), 20);
		} else if (j % 10 >= 6 && j % 10 < 8) {
			g.drawRegion(img[temp_img_distance2 + 67], 180, 0, 60, 113, 0,
					hero.getX(), hero.getY(), 20);
		} else {
			g.drawRegion(img[temp_img_distance2 + 67], 240, 0, 60, 113, 0,
					hero.getX(), hero.getY(), 20);
		}

		g.drawRegion(img[temp_img_distance2 + 77], 20 * 10, 0, 20, 25, 0,
				hero.getX(), hero.getY() + (10 - j) * 2, 20);
		drawNum(img[temp_img_distance2 + 77], g, jiaxue, hero.getX() + 20,
				hero.getY() + (10 - j) * 2, 11);
	}

	private void drawUseProp2() {
		if (!stopState && !isSuggest) {
			prop2Index++;
			if (prop2Index < 6) {
				for (int i = 0; i < Resource.prop2Localtion.length / 4; i++) {
					Resource.prop2Localtion[i * 4 + 2]++;
					Resource.prop2Localtion[i * 4 + 3]++;
				}
			}
		}
		if (prop2Index < 6) {
			for (int i = 0; i < Resource.prop2Localtion.length / 4; i++) {
				g.drawRegion(img[temp_img_distance2 + 76], prop2Index / 2 * 82,
						0, 82, 80, 0, Resource.prop2Localtion[i * 4]
								+ Resource.prop2Localtion[i * 4 + 2] * 40,
						Resource.prop2Localtion[i * 4 + 1]
								+ Resource.prop2Localtion[i * 4 + 3] * 50, 20);
			}
		} else {
			for (int i = 0; i < Resource.prop2Localtion.length / 4; i++) {
				g.drawRegion(img[temp_img_distance2 + 76], prop2Index / 2 * 82,
						0, 82, 80, 0, Resource.prop2Localtion[i * 4]
								+ Resource.prop2Localtion[i * 4 + 2] * 40,
						Resource.prop2Localtion[i * 4 + 1]
								+ Resource.prop2Localtion[i * 4 + 3] * 50, 20);
				if (prop2Index == 15 && i == 4) {
					for (int kl = 0; kl < Resource.prop2Localtion.length / 4; kl++) {
						Resource.prop2Localtion[kl * 4 + 2] = 0;
						Resource.prop2Localtion[kl * 4 + 3] = 0;
						if (newGuideIndex == 6) {
							newGuideIndex = 7;
						}
					}
					for (int jb = 0; jb < monsterVector.size();) {
						Monster m = (Monster) monsterVector.elementAt(jb);
						int num = m.getBloods() * 3 / 10;
						m.setShowBlood(true);
						m.setStartBlood(System.currentTimeMillis());
						Critical c = new Critical(385 + m.getY() * 60,
								11 + m.getX() * 60, num, null);
						criticalArray1.addElement(c);
						m.setBoold(m.getBoold() - num);
						if (m.getBoold() <= 0) {
							m.setBoold(0);
							deathArray.addElement(m);
							monsterVector.removeElement(m);
						} else {
							jb++;
						}
					}
					useProp[1] = 0;
				}
			}
		}
	}

	private void drawUseProp3() {
		if (!stopState && !isSuggest) {
			if (isDoubleAtk
					&& (System.currentTimeMillis() - prop3StartTime - suggestAndStopEndTime) < 30000) {// 狂暴术使士兵攻击力翻倍的buff
				g.drawRegion(img[temp_img_distance2 + 81], 3 * 24, 0, 24, 24,
						0, Hero.booldX + heroStateIndex * 24, Hero.booldY - 25,
						20);
				heroStateIndex++;
			} else {
				soldierATkTimes = 1;
				isDoubleAtk = false;
			}
		}

	}

	private void drawUseProp4() {

	}

	private void drawUseProp5() {

	}

	private void drawUseProp6() {
		my.setNengliang(my.getNengliang() + 10);
		if (my.getNengliang() > Upgrade.upgradeLeaderNengliang((int) my
				.getLevel())) {
			my.setNengliang(Upgrade.upgradeLeaderNengliang((int) my.getLevel()));
		}
	}

	private void addNengliang() {
		if (System.currentTimeMillis() - Resource.resumeNengliangTime > 60 * 15 * 1000) {
			my.setNengliang(my.getNengliang() + 1);
			if (my.getNengliang() > Upgrade.upgradeLeaderNengliang((int) my
					.getLevel())) {
				my.setNengliang(Upgrade.upgradeLeaderNengliang((int) my
						.getLevel()));
			}
			Resource.resumeNengliangTime = System.currentTimeMillis();
		}
	}

	private void drawUseProp8() {
		Soldier.setAtkCoefficient(1.1f);
	}

	private void drawUseProp9() {
		hero.setArmor(hero.getArmor() + 20);
	}

	private void drawUseProp10() {
		hero.setBoold((int) (hero.getBoold() * (1 + 0.2)));
		hero.setBoolds((int) (hero.getBoolds() * (1 + 0.2)));
	}

	private void drawUseProp11() {
		my.setMoney(my.getMoney() + 10000);
	}

	public void drawSkill4() {
		int j = hero.getSkillIndex();
		if (!stopState && !isSuggest) {
			hero.setSkillIndex(hero.getSkillIndex() + 1);
			if (j % 3 == 0) {
				skill1Hero.setX(skill1Hero.getX() + 20);
				skill1Hero.setY(skill1Hero.getY() + 20);
			}
		}
		int temp_x = 0;
		int temp_y = 0;
		for (int i = 0; i < 3; i++) {
			if (i == 1) {
				temp_x = 100;
				temp_y = 50;
			} else if (i == 2) {
				temp_x = 200;
				temp_y = 100;
			}
			if (j % 12 >= 0 && j % 12 < 2) {
				g.drawRegion(img[temp_img_distance2 + 70], 0, 0, 125, 123, 0,
						skill1Hero.getX() + temp_x, skill1Hero.getY() + temp_y,
						20);
			} else if (j % 12 >= 2 && j % 12 < 4) {
				g.drawRegion(img[temp_img_distance2 + 70], 125, 0, 125, 123, 0,
						skill1Hero.getX() + temp_x, skill1Hero.getY() + temp_y,
						20);
			} else if (j % 12 >= 4 && j % 12 < 6) {
				g.drawRegion(img[temp_img_distance2 + 70], 125 * 2, 0, 125,
						123, 0, skill1Hero.getX() + temp_x, skill1Hero.getY()
								+ temp_y, 20);
			} else if (j % 12 >= 6 && j % 12 < 8) {
				g.drawRegion(img[temp_img_distance2 + 70], 125 * 3, 0, 125,
						123, 0, skill1Hero.getX() + temp_x, skill1Hero.getY()
								+ temp_y, 20);
			} else if (j % 12 >= 8 && j % 12 < 10) {
				g.drawRegion(img[temp_img_distance2 + 70], 125 * 4, 0, 125,
						123, 0, skill1Hero.getX() + temp_x, skill1Hero.getY()
								+ temp_y, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 70], 125 * 5, 0, 125,
						123, 0, skill1Hero.getX() + temp_x, skill1Hero.getY()
								+ temp_y, 20);
				if (i == 2) {
					hero.setSkillIndex(0);
					skill1Hero = null;
					for (int count = 0; count < heroSkillmonster.size();) {
						Monster m = ((Monster) heroSkillmonster
								.elementAt(count));
						m.setShowBlood(true);
						m.setStartBlood(System.currentTimeMillis());
						int hurtNum = Upgrade.upgradeHeroAttack(
								hero.getLevel(), hero.getKind());
						m.setBoold(m.getBoold() - hurtNum);
						if (m.getBoold() <= 0) {
							m.setBoold(0);
							deathArray.addElement(m);
							monsterVector.removeElement(m);
						}
						Critical c = new Critical(385 + m.getY() * 60,
								11 + m.getX() * 60, 100, null);
						criticalArray1.addElement(c);
						heroSkillmonster.removeElement(m);
					}
				}
			}
		}
	}

	public void drawSkill5() {
		int j = hero.getSkillIndex();
		for (int i = 0; i < 3; i++) {
			if (j % 12 >= 0 && j % 12 < 3) {
				g.drawRegion(img[temp_img_distance2 + 71], 0, 0, 98, 430, 0,
						385 + i * 98, 0, 20);
			} else if (j % 12 >= 3 && j % 12 < 6) {
				g.drawRegion(img[temp_img_distance2 + 71], 98, 0, 98, 430, 0,
						385 + i * 98, 0, 20);
			} else if (j % 12 >= 6 && j % 12 < 9) {
				g.drawRegion(img[temp_img_distance2 + 71], 98 * 2, 0, 98, 430,
						0, 385 + i * 98, 0, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 71], 98 * 3, 0, 98, 430,
						0, 385 + i * 98, 0, 20);
				if (i == 2 && j == 11) {
					hero.setSkillIndex(0);
					skill1Hero1 = null;
					for (int count = 0; count < heroSkillmonster.size();) {
						Monster m = ((Monster) heroSkillmonster
								.elementAt(count));
						m.setShowBlood(true);
						m.setStartBlood(System.currentTimeMillis());
						int hurtNum = Upgrade.upgradeHeroAttack(
								hero.getLevel(), hero.getKind());
						m.setBoold(m.getBoold() - hurtNum);
						if (m.getBoold() <= 0) {
							m.setBoold(0);
							deathArray.addElement(m);
							monsterVector.removeElement(m);
						}
						Critical c = new Critical(385 + m.getY() * 60,
								11 + m.getX() * 60, 100, null);
						criticalArray1.addElement(c);
						heroSkillmonster.removeElement(m);
					}
				}
			}
		}
	}

	public void monsterHurtAnim(Monster m, int l, Vector v, int imgIndex,
			int block) {
		int j = m.getAnimIndex();
		int i = 0;
		int _width = img[imgIndex].getWidth() / block;
		if (m.getKind() > 14)
			i++;
		g.drawRegion(img[imgIndex], j % block * _width, 0, _width,
				img[imgIndex].getHeight(), 0, 385 + m.getY() * 60,
				11 + (m.getX() + i) * 60, 20);
		if (j % 10 == 9) {
			v.removeElement(m);
		} else {
			l++;
		}
		if (!stopState && !isSuggest)
			m.setAnimIndex(++j);
	}

	private void drawBloodAndMagicB(Monster m) {
		g.drawImage(img[temp_img_distance2 + 61], 385 + m.getY() * 60,
				11 + m.getX() * 60, 20);
		int bloodLength = (int) (m.getBoold() / Math
				.ceil(m.getBloods() * 1.0 / 150));
		g.drawRegion(img[temp_img_distance2 + 62], 0, 0, bloodLength, 7, 0,
				385 + m.getY() * 60 + 1, 11 + m.getX() * 60 + 1, 20);
		g.drawImage(img[temp_img_distance2 + 59], 385 + m.getY() * 60,
				21 + m.getX() * 60, 20);
	}

	private int boss1Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(m.getSrc(), 0, 0, 220, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 220, 0, 220, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 0, 0, 220, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 0, 0, 220, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 0, 0, 220, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss2Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			int moveX = 0;
			if (bossStart) {
				if (bossMoveindex < 3)
					moveX = -bossMoveindex * 60;
				else if (bossMoveindex >= 3 && bossMoveindex < 6)
					moveX = -(6 - bossMoveindex) * 60;
			}
			if (arrowIndex % 10 >= 0 && arrowIndex % 10 < 2) {
				g.drawRegion(m.getSrc(), 0, 0, 125, 180, 0, 385 + m.getY() * 60
						+ moveX, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 10 >= 2 && arrowIndex % 10 < 4) {
				g.drawRegion(m.getSrc(), 125, 0, 125, 180, 0, 385 + m.getY()
						* 60 + moveX, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 10 >= 4 && arrowIndex % 10 < 6) {
				g.drawRegion(m.getSrc(), 250, 0, 125, 180, 0, 385 + m.getY()
						* 60 + moveX, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 10 >= 6 && arrowIndex % 10 < 8) {
				g.drawRegion(m.getSrc(), 375, 0, 125, 180, 0, 385 + m.getY()
						* 60 + moveX, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 500, 0, 125, 180, 0, 385 + m.getY()
						* 60 + moveX, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 5 >= 0 && arrowIndex % 5 < 1) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 0, 0, 125, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 5 >= 1 && arrowIndex % 5 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 125, 0, 125, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 5 >= 2 && arrowIndex % 5 < 3) {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 250, 0, 125, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 5 >= 3 && arrowIndex % 5 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 375, 0, 125, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
				g.drawRegion(m.getSrc(), 500, 0, 125, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss3Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 2) {
				g.drawImage(m.getSrc(), 385 + m.getY() * 60,
						11 + m.getX() * 60 + 5, 20);
			} else if (arrowIndex % 8 >= 2 && arrowIndex % 8 < 4) {
				g.drawImage(m.getSrc(), 385 + m.getY() * 60,
						11 + m.getX() * 60 - 5, 20);
			} else if (arrowIndex % 8 >= 4 && arrowIndex % 8 < 6) {
				g.drawImage(m.getSrc(), 385 + m.getY() * 60 + 5,
						11 + m.getX() * 60, 20);
			} else if (arrowIndex % 8 >= 6 && arrowIndex % 8 < 8) {
				g.drawImage(m.getSrc(), 385 + m.getY() * 60 - 5,
						11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawImage(m.getSrc(), 385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss4Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (bossStart) {
				if (bossMoveindex < 6) {
					g.drawRegion(m.getSrc(), 160 * bossMoveindex, 0, 160, 175,
							0, 385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					bossMoveindex++;
				} else {
					if (arrowIndex % 4 >= 0 && arrowIndex % 4 < 2) {
						g.drawRegion(m.getSrc(), 0, 0, 160, 175, 0,
								385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					} else {
						g.drawRegion(m.getSrc(), 160, 0, 160, 175, 0,
								385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					}
				}
			} else {
				if (arrowIndex % 4 >= 0 && arrowIndex % 4 < 2) {
					g.drawRegion(m.getSrc(), 0, 0, 160, 175, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
				} else {
					g.drawRegion(m.getSrc(), 160, 0, 160, 175, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
				}
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawRegion(m.getSrc(), 0, 0, 160, 175, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss5Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (bossStart) {
				if (bossMoveindex < 6) {
					g.drawRegion(m.getSrc(), 103 * (int) (bossMoveindex / 2),
							0, 103, 148, 0, 385 + m.getY() * 60,
							11 + m.getX() * 60, 20);
					bossMoveindex++;
				} else {
					if (arrowIndex % 4 >= 0 && arrowIndex % 4 < 2) {
						g.drawRegion(m.getSrc(), 0, 0, 103, 148, 0,
								385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					} else {
						g.drawRegion(m.getSrc(), 103, 0, 103, 148, 0,
								385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					}
				}
			} else {
				if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 2) {
					g.drawRegion(m.getSrc(), 0, 0, 103, 148, 0,
							385 + m.getY() * 60 + 8, 11 + m.getX() * 60, 20);
				} else if (arrowIndex % 8 >= 2 && arrowIndex % 8 < 4) {
					g.drawRegion(m.getSrc(), 0, 0, 103, 148, 0,
							385 + m.getY() * 60 - 8, 11 + m.getX() * 60, 20);
				} else if (arrowIndex % 8 >= 4 && arrowIndex % 4 < 6) {
					g.drawRegion(m.getSrc(), 0, 0, 103, 148, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60 + 8, 20);
				} else {
					g.drawRegion(m.getSrc(), 103, 0, 103, 148, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60 - 8, 20);
				}
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawRegion(m.getSrc(), 0, 0, 103, 148, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			boss5Random = RandomValue.getRandInt(0, 3);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss6Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(m.getSrc(), 0, 0, 132, 178, 0,
						385 + m.getY() * 60 + 8, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(m.getSrc(), 132, 0, 132, 178, 0,
						385 + m.getY() * 60 - 8, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 264, 0, 132, 178, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - 8, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawRegion(m.getSrc(), 0, 0, 132, 178, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss7Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(m.getSrc(), 0, 0, 262, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 262, 0, 262, 180, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawRegion(m.getSrc(), 0, 0, 262, 180, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 0, 0, 262, 180, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int boss8Attack(int h, Monster m) {
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		int height = m.getSrc().getHeight();
		int width = m.getSrc().getWidth() / 4;
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(m.getSrc(), 0, 0, width, height, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(m.getSrc(), width, 0, width, height, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), width * 2, 0, width, height, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
			drawBloodAndMagicB(m);
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(img[temp_img_distance2 + 58], 0, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(img[temp_img_distance2 + 58], 183, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 58], 366, 0, 183, 29, 0,
						370 + m.getY() * 60, 11 + m.getX() * 60 + 160, 20);
			}
			g.drawRegion(m.getSrc(), 0, 0, width, height, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			int powerLength = (int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / 100);
			if (powerLength > 0) {
				g.drawRegion(img[temp_img_distance2 + 60], 0, 0, powerLength,
						4, 0, 385 + m.getY() * 60, 21 + m.getX() * 60 + 1, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 0, 0, width, height, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			drawBloodAndMagicB(m);
			bossStart = true;
			bossMoveindex = 0;
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	public void drawBoss1Bullet() {
		if (!stopState && !isSuggest)
			bossMoveindex++;
		for (int j = 0; j < 8; j++) {
			g.drawImage(img[temp_img_distance2 + 41], 520 - 60 * bossMoveindex,
					50 * j, 20);
		}
		if (520 - 60 * bossMoveindex < 10) {
			bossStart = false;
			bossMoveindex = 0;
			hero.setHurtStartTime(System.currentTimeMillis());
			hero.setLastHurt(true);
			calculateHeroBoold(Resource.MonsterAttack[28], 14);
			if (StrikeHero.getInstance().getIndexAnim() == 4) {
				StrikeHero.getInstance().setIndexAnim(0);
			}
		}
	}

	private void calculateHeroBoold(int monsterAttack, int kind) {
		int fangyuli;
		if (kind == 20) {
			fangyuli = 0;
		} else {
			fangyuli = (int) (hero.getDefenceCoefficient() * hero.getArmor());
		}
		int tempBloods;
		if (fangyuli >= monsterAttack) {
			tempBloods = hero.getBoold();
		} else {
			tempBloods = hero.getBoold() + fangyuli > monsterAttack ? (hero
					.getBoold() + fangyuli - monsterAttack) : 0;
		}
		hero.setBoold(tempBloods);
	}

	public void drawBoss2Bullet() {
		if (!stopState && !isSuggest)
			bossMoveindex++;
		if (bossMoveindex >= 5) {
			for (int j = 0; j < 4; j++) {
				if (arrowIndex % 12 >= 0 && arrowIndex % 12 < 4) {
					g.drawRegion(img[temp_img_distance2 + 42], 0, 0, 90, 106,
							0, 520 - 60 * bossMoveindex - 70, 10 + 110 * j, 20);
				} else if (arrowIndex % 12 >= 4 && arrowIndex % 12 < 8) {
					g.drawRegion(img[temp_img_distance2 + 42], 90, 0, 90, 106,
							0, 520 - 60 * bossMoveindex - 70, 10 + 110 * j, 20);
				} else {
					g.drawRegion(img[temp_img_distance2 + 42], 180, 0, 90, 106,
							0, 520 - 60 * bossMoveindex - 70, 10 + 110 * j, 20);
				}
			}
			if (520 - 60 * bossMoveindex - 70 < 10) {
				bossStart = false;
				bossMoveindex = 0;
				calculateHeroBoold(Resource.MonsterAttack[30], 15);
				if (StrikeHero.getInstance().getIndexAnim() == 4) {
					StrikeHero.getInstance().setIndexAnim(0);
				}
			}
		}
	}

	public void drawBoss3Bullet() {
		if (!stopState && !isSuggest)
			bossMoveindex++;
		int stoneLength = Resource.stoneXY.length;
		if (bossMoveindex <= 8) {
			for (int j = 0; j < stoneLength / 3; j++) {
				Resource.stoneXY[j * 3 + 2] += 50;
				g.drawImage(img[temp_img_distance2 + 43],
						Resource.stoneXY[j * 3], Resource.stoneXY[j * 3 + 1]
								+ Resource.stoneXY[j * 3 + 2], 20);
			}
		} else if (bossMoveindex > 8 && bossMoveindex <= 13) {
			for (int j = 0; j < stoneLength / 3; j++) {
				g.drawRegion(img[temp_img_distance2 + 44],
						(bossMoveindex - 9) * 128, 0, 128, 100, 0,
						Resource.stoneXY[j * 3], Resource.stoneXY[j * 3 + 1]
								+ Resource.stoneXY[j * 3 + 2], 20);
				if (bossMoveindex == 13) {
					Resource.stoneXY[j * 3 + 2] = 0;
					if (j == stoneLength / 3 - 1) {
						bossStart = false;
						bossMoveindex = 0;
						calculateHeroBoold(Resource.MonsterAttack[32], 16);
						int tempMagics = hero.getMagic() >= 30 ? (hero
								.getBoold() - 30) : 0;
						hero.setMagic(tempMagics, 0);
						if (StrikeHero.getInstance().getIndexAnim() == 4) {
							StrikeHero.getInstance().setIndexAnim(0);
						}
					}
				}
			}
		}
	}

	public void drawBoss4Bullet() {
		if (bossMoveindex >= 6 && !stopState && !isSuggest)
			bossMoveindex++;
		for (int j = 0; j < 3; j++) {
			g.drawRegion(img[temp_img_distance2 + 45],
					(3 - ((int) (bossMoveindex / 3))) * 112, 0, 112, 120, 0,
					320 - 80 * (int) (bossMoveindex / 3), 20 + 120 * j, 20);
		}
		if (bossMoveindex == 11) {
			bossStart = false;
			bossMoveindex = 0;
			calculateHeroBoold(Resource.MonsterAttack[34], 17);
			if (StrikeHero.getInstance().getIndexAnim() == 4) {
				StrikeHero.getInstance().setIndexAnim(0);
			}
		}
	}

	public void drawBoss5Bullet() {
		if (bossMoveindex >= 6 && !stopState && !isSuggest)
			bossMoveindex++;
		g.drawRegion(img[temp_img_distance2 + 46],
				((int) (bossMoveindex / 3)) * 48, 0, 48, 90, 0,
				320 - 80 * (int) (bossMoveindex / 3 - 2),
				20 + 120 * boss5Random, 20);
		if (bossMoveindex == 11) {
			bossStart = false;
			bossMoveindex = 0;
			hero.setBoold(hero.getBoold() - 100);
			if (hero.getBoold() < 0) {
				hero.setBoold(0);
			}
			for (int oop = 0; oop < 4; oop++) {
				if (idPic[boss5Random][oop].getOffX() == 0) {
					idPic[boss5Random][oop].setIceNoMove(true);
					idPic[boss5Random][oop].setStartTime();
					IceDrow id = new IceDrow(idPic[boss5Random][oop]);
					id.setStartTime(System.currentTimeMillis());
					id.setX(oop * 60 + 17);
					id.setY(boss5Random * 60 + 11);
					IceDrowVector.addElement(id);
				}
			}
			calculateHeroBoold(Resource.MonsterAttack[36], 18);
			if (StrikeHero.getInstance().getIndexAnim() == 4) {
				StrikeHero.getInstance().setIndexAnim(0);
			}
		}
	}

	public void drawBoss6Bullet() {
		// if (!stopState && !isSuggest)
		System.out.println("0*****monsterVector.size" + monsterVector.size());
		int random_x1 = RandomValue.getRandInt(0, 6);
		int random_y1;
		int random_x2 = random_x1 + 1;
		int random_y2;
		if (random_x1 >= 2 && random_x1 <= 4) {
			random_y1 = 0;
		} else {
			random_y1 = RandomValue.getRandInt(0, 4);
		}
		if (random_x2 >= 2 && random_x2 <= 4) {
			random_y2 = 0;
		} else {
			random_y2 = RandomValue.getRandInt(0, 4);
		}
		for (int h = 0; h < monsterVector.size(); h++) {
			Monster m = (Monster) monsterVector.elementAt(h);
			if ((m.getX() == random_x1 && m.getY() == random_y1)
					|| (m.getX() == random_x2 && m.getY() == random_y2)) {
				h--;
				monsterVector.removeElement(m);
			}
		}
		monsterVector.addElement(new Monster(Resource.MonsterSpeed[21],
				Resource.MonsterAttack[42], 22,
				img[Resource.MonsterImgIndex[21]], "zhaohuan",
				Resource.MonsterLevel[21], random_x1, random_y1,
				Resource.MonsterBlood[42], 1, 0, Resource.MonsterBlood[42]));
		monsterVector.addElement(new Monster(Resource.MonsterSpeed[21],
				Resource.MonsterAttack[42], 22,
				img[Resource.MonsterImgIndex[21]], "zhaohuan",
				Resource.MonsterLevel[21], random_x2, random_y2,
				Resource.MonsterBlood[42], 1, 0, Resource.MonsterBlood[42]));
		bossStart = false;
		bossMoveindex = 0;
	}

	public void drawBoss7Bullet() {
		if (!stopState && !isSuggest)
			bossMoveindex++;
		int stoneLength = Resource.stoneXY1.length;
		if (bossMoveindex <= 8) {
			for (int j = 0; j < stoneLength / 3; j++) {
				Resource.stoneXY1[j * 3 + 2] += 50;
				g.drawRegion(img[temp_img_distance2 + 49],
						(7 - (bossMoveindex % 3)) * 164, 0, 164, 159, 0,
						Resource.stoneXY1[j * 3] - Resource.stoneXY1[j * 3 + 2]
								/ 5, Resource.stoneXY1[j * 3 + 1]
								+ Resource.stoneXY1[j * 3 + 2], 20);
			}
		} else if (bossMoveindex > 8 && bossMoveindex <= 13) {
			for (int j = 0; j < stoneLength / 3; j++) {
				g.drawRegion(img[temp_img_distance2 + 49],
						(13 - bossMoveindex) * 164, 0, 164, 159, 0,
						Resource.stoneXY1[j * 3] - Resource.stoneXY1[j * 3 + 2]
								/ 5, Resource.stoneXY1[j * 3 + 1]
								+ Resource.stoneXY1[j * 3 + 2], 20);
				if (bossMoveindex == 13) {
					Resource.stoneXY1[j * 3 + 2] = 0;
					if (j == stoneLength / 3 - 1) {
						bossStart = false;
						bossMoveindex = 0;
						hero.setBoold(hero.getBoold() - 100);
						if (hero.getBoold() < 0) {
							hero.setBoold(0);
						}
						calculateHeroBoold(Resource.MonsterAttack[40], 20);
						if (StrikeHero.getInstance().getIndexAnim() == 4) {
							StrikeHero.getInstance().setIndexAnim(0);
						}
					}
				}
			}
		}
	}

	public void drawBoss8Bullet() {
		if (boss8StoneNum < 3 && Resource.stoneXY2[boss8StoneNum * 3 + 2] < 7) {
			g.drawRegion(img[temp_img_distance2 + 68],
					Resource.stoneXY2[boss8StoneNum * 3 + 2] * 141, 0, 141,
					242, 0, Resource.stoneXY2[boss8StoneNum * 3],
					Resource.stoneXY2[boss8StoneNum * 3 + 1], 20);
			if (!stopState && !isSuggest)
				Resource.stoneXY2[boss8StoneNum * 3 + 2]++;
		} else {
			Resource.stoneXY2[boss8StoneNum * 3 + 2] = 0;// 重新开始游戏的时候要置为0
			boss8StoneNum++;
			if (boss8StoneNum == 3) {
				calculateHeroBoold(Resource.MonsterAttack[42], 21);
				bossStart = false;
				boss8StoneNum = 0;
			}
		}
	}

	private void drawBloodAndMagicM(Monster m, int bm, int speed) {
		m.setStartBlood(m.getStartBlood() + suggestAndStopEndTime);
		if (bm == 1) {
			g.drawImage(img[temp_img_distance2 + 31], 385 + m.getY() * 60,
					4 + m.getX() * 60, 20);
			int tempBlood = m.getBoold() * 50 / m.getBloods();
			if (System.currentTimeMillis() - m.getStartBlood() <= 3000) {
				for (int w = 0; w < tempBlood; w++) {
					g.drawRegion(img[temp_img_distance2 + 30], 1, 0, 1, 4, 0,
							385 + m.getY() * 61 + w, 5 + m.getX() * 60, 0);
				}
			} else {
				m.setShowBlood(false);
			}
		} else if (bm == 2) {
			m.setProgressbar((int) ((m.getEndTime() - m.getStartTime() - m
					.getWaitTime()) / speed));
			g.drawImage(img[temp_img_distance2 + 31], 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			for (int w = 0; w < m.getProgressbar(); w++) {
				g.drawRegion(img[temp_img_distance2 + 30], 0, 0, 1, 4, 0, 385
						+ m.getY() * 61 + w, 12 + m.getX() * 60, 0);
			}
		}
	}

	private int monster12356Attack(int h, Monster m) {
		if (m.isShowBlood()) {
			drawBloodAndMagicM(m, 1, 200);
		}
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 60, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			drawBloodAndMagicM(m, 2, 200);
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(img[temp_img_distance2 + 32], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 32], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			m.setProgressbar(0);
			buttleArray.addElement(new Bullet(385 + m.getY() * 60, 11 + m
					.getX() * 60, img[temp_img_distance2 + 56], m));
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int monster4Attack(int h, Monster m) {
		if (m.isShowBlood()) {
			drawBloodAndMagicM(m, 1, 200);
		}
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 16 >= 0 && arrowIndex % 16 < 4) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60 + 5, 20);
			} else if (arrowIndex % 16 >= 4 && arrowIndex % 16 < 8) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60 - 5, 20);
			} else if (arrowIndex % 16 >= 8 && arrowIndex % 16 < 12) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0,
						385 + m.getY() * 60 + 5, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 16 >= 12 && arrowIndex % 16 < 16) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0,
						385 + m.getY() * 60 - 5, 11 + m.getX() * 60, 20);
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			drawBloodAndMagicM(m, 2, 200);
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(img[temp_img_distance2 + 32], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 32], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60 + 5, 20);
			m.setProgressbar(0);
			buttleArray.addElement(new Bullet(385 + m.getY() * 60, 11 + m
					.getX() * 60, img[temp_img_distance2 + 56], m));
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int monster7Attack(int h, Monster m) {
		if (m.isShowBlood()) {
			drawBloodAndMagicM(m, 1, 200);
		}
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 12 >= 0 && arrowIndex % 12 < 4) {
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
			} else if (arrowIndex % 12 >= 4 && arrowIndex % 12 < 8) {
				g.drawRegion(m.getSrc(), 60, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 120, 0, 60, 60, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			drawBloodAndMagicM(m, 2, 200);
			if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 4) {
				g.drawRegion(img[temp_img_distance2 + 32], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 32], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
						11 + m.getX() * 60, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			m.setProgressbar(0);
			buttleArray.addElement(new Bullet(385 + m.getY() * 60, 11 + m
					.getX() * 60, img[temp_img_distance2 + 56], m));
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private int monster8_13Attack(int h, Monster m) {
		int www = m.getSrc().getWidth();
		int hhh = m.getSrc().getHeight();
		int tigao = 0;
		if (hhh > 60) {
			tigao = hhh - 60;
		}
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 3) {
				g.drawRegion(m.getSrc(), 0, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
			} else {
				g.drawRegion(m.getSrc(), www / 4, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 2 >= 0 && arrowIndex % 2 < 1) {
				g.drawRegion(img[temp_img_distance2 + 32], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 0, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			} else {
				g.drawRegion(img[temp_img_distance2 + 32], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
				g.drawRegion(m.getSrc(), 0, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
				g.drawRegion(img[temp_img_distance2 + 33], 60, 0, 60, 32, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 + 30, 20);
			}
			if (m.getKind() == 13) {
				drawBloodAndMagicM(m, 2, 400);
			} else {
				drawBloodAndMagicM(m, 2, 200);
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				+ m.getSkillWaitTime() * 1000
				&& m.getAnimIndex_attack() < 2) {
			if (m.getAnimIndex_attack() == 0) {
				g.drawRegion(m.getSrc(), www / 4 * 2, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
			} else if (m.getAnimIndex_attack() == 1) {
				g.drawRegion(m.getSrc(), www / 4 * 3, 0, www / 4, hhh, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
			}
			m.setAnimIndex_attack(m.getAnimIndex_attack() + 1);
		} else {
			g.drawRegion(m.getSrc(), 0, 0, www / 4, hhh, 0,
					385 + m.getY() * 60, 11 + m.getX() * 60 - tigao, 20);
			m.setProgressbar(0);
			m.setStartTime(m.getEndTime());
			m.setAnimIndex_attack(0);
			monster8_13Anim(m);
		}
		h++;
		if (m.isShowBlood()) {
			drawBloodAndMagicM(m, 1, 200);
		}
		return h;
	}

	private int monster22Attack(int h, Monster m) {
		if (m.isShowBlood()) {
			drawBloodAndMagicM(m, 1, 200);
		}
		m.setStartTime(m.getStartTime() + suggestAndStopEndTime + alertSumTime);
		if (m.getEndTime() - m.getStartTime() < m.getWaitTime()) {
			if (m.isNewMonster()) {
				if (m.getAnimIndex() % 6 >= 0 && m.getAnimIndex() % 6 < 2) {
					g.drawRegion(m.getSrc(), 0, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					m.setAnimIndex(m.getAnimIndex() + 1);
				} else if (m.getAnimIndex() % 6 >= 2
						&& m.getAnimIndex() % 6 < 4) {
					g.drawRegion(m.getSrc(), 60, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					m.setAnimIndex(m.getAnimIndex() + 1);
				} else {
					g.drawRegion(m.getSrc(), 120, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
					m.setAnimIndex(m.getAnimIndex() + 1);
					m.setNewMonster(false);
				}
			} else {
				if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
					g.drawRegion(m.getSrc(), 120, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
				} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
					g.drawRegion(m.getSrc(), 180, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
				} else {
					g.drawRegion(m.getSrc(), 240, 0, 60, 60, 0,
							385 + m.getY() * 60, 11 + m.getX() * 60, 20);
				}
			}
		} else if (m.getEndTime() - m.getStartTime() >= m.getWaitTime()
				&& m.getEndTime() - m.getStartTime() < m.getWaitTime()
						+ m.getSkillWaitTime() * 1000) {
			if (arrowIndex % 6 >= 0 && arrowIndex % 6 < 2) {
				g.drawRegion(m.getSrc(), 120, 0, 60, 60, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else if (arrowIndex % 6 >= 2 && arrowIndex % 6 < 4) {
				g.drawRegion(m.getSrc(), 180, 0, 60, 60, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			} else {
				g.drawRegion(m.getSrc(), 240, 0, 60, 60, 0,
						385 + m.getY() * 60, 11 + m.getX() * 60, 20);
			}
		} else {
			g.drawRegion(m.getSrc(), 120, 0, 60, 60, 0, 385 + m.getY() * 60,
					11 + m.getX() * 60, 20);
			Bullet tempBullet = new Bullet(385 + m.getY() * 60,
					11 + m.getX() * 60, img[temp_img_distance2 + 48], m);
			tempBullet.setFlag(1);
			buttleArray.addElement(tempBullet);
			m.setStartTime(m.getEndTime());
		}
		h++;
		return h;
	}

	private void monster8_13Anim(Monster m) {
		if (m.getKind() == 8) {
			buttleArray.addElement(new Bullet(385 + m.getY() * 60, 11 + m
					.getX() * 60, img[temp_img_distance2 + 56], m));
		} else if (m.getKind() == 9) {
			addMonster9Hp();
		} else if (m.getKind() == 10) {
			stickVector.addElement(new Bullet(385 + m.getY() * 60, 11 + m
					.getX() * 60, img[temp_img_distance2 + 57], m));
		} else if (m.getKind() == 11) {
			monster11MakeSoldierNoMove();
		} else if (m.getKind() == 12) {
			monster12MakeHeroDefenceDown();
		} else if (m.getKind() == 13) {
			monster13MakeMyselfTimeDecrease();
		}
	}

	public void drawSoldier() {
		if (indexSelect == -1) {
			g.drawImage(img[12], index % 4 * 60 + 17,
					((int) (index / 4)) * 60 + 11, 0);
		} else if (indexSelect != -1) {
			g.drawImage(img[13], index % 4 * 60 + 17,
					((int) (index / 4)) * 60 + 11, 0);
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				if (idPic[i][j] != null) {
					g.drawRegion(img[idPic[i][j].getAuthenticKind()],
							Resource.heroAndSoldierLevel[idPic[i][j]
									.getAuthenticKind()] / 7 * 62, 0, 62, 62,
							0, j * 60 + 17 + idPic[i][j].getOffX(), i * 60
									+ idPic[i][j].getOffY() + 11, 0);
				}
			}
		}
	}

	public void judgeRemove() {
		if (win1 == 1) {
			return;
		}
		if (!isSuggest && !stopState) {
			if (add == 0) {
				if (!startAddState) {
					startAddTime = System.currentTimeMillis();
					startAddState = true;
				} else if (System.currentTimeMillis() - startAddTime > 100
						&& startAddState) {
					boolean bb = mee.start(idPic);
					if (!bb && MoveElementEffect.index == 0) {
						add = -1;
						startAddState = false;
						new AutomaticRemove().start();
					}

				}
			}
		}
	}

	/***
	 * 9.火枪手攻击判断
	 * 
	 * @param soldiers
	 */
	public void hackbuteerAttack(Soldier[] soldiers) {
		int[] idRow = new int[7];
		Monster[] idCol = new Monster[7];
		int idcolMonster = 3;

		for (int i = 0; i < 7; i++) {
			idRow[i] = 0;
		}
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				idRow[soldiers[i].getX()]++;
			}
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				idcolMonster = ((Monster) monsterVector.elementAt(i)).getY() < idcolMonster ? ((Monster) monsterVector
						.elementAt(i)).getY() : idcolMonster;
		}
		for (int i = 0; i < 7; i++) {
			idCol[i] = null;
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				if ((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
						&& mapIndexOfIndex == 4
						&& idcolMonster == 1
						&& ((Monster) monsterVector.elementAt(i)).getX() == 2) {
					idCol[2] = (Monster) monsterVector.elementAt(i);
					idCol[3] = (Monster) monsterVector.elementAt(i);
					idCol[4] = (Monster) monsterVector.elementAt(i);
				} else if (idcolMonster == ((Monster) monsterVector
						.elementAt(i)).getY()) {
					idCol[((Monster) monsterVector.elementAt(i)).getX()] = (Monster) monsterVector
							.elementAt(i);
				}
		}
		for (int i = 0; i < 7; i++) {
			if (idRow[i] != 0) {
				for (int j = 0; j < 7; j++) {
					if (i - j >= 0 && idCol[i - j] != null
							&& idCol[i - j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && ((i - j) == 2
													|| (i - j) == 3 || (i - j) == 4)) || idCol[f]
													.getX() == i - j)) {
										firelockArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 52], i
														- j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					} else if (i + j <= 6 && idCol[i + j] != null
							&& idCol[i + j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && (i
													+ j == 2
													|| i + j == 3 || i + j == 4)) || idCol[f]
													.getX() == i + j)) {
										firelockArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 52], i
														+ j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	/***
	 * 8.刺客攻击判断
	 * 
	 * @param soldiers
	 */
	public void assassinAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				for (int j = 0; j < monsterVector.size();) {
					Monster m = (Monster) monsterVector.elementAt(j);
					if (collision(soldiers[i], m)) {
						int x = m.getX();
						int y = m.getY();
						if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& mapIndexOfIndex == 4 && y == 1 && x == 2 && (x == soldiers[i]
								.getX() || x == soldiers[i].getX() - 1 || x == soldiers[i]
								.getX() - 2)) || x == soldiers[i].getX()) {
							int shanghaiNum = shanghai(soldiers[i].getLevel(),
									soldiers[i].getAuthenticKind() + 1,
									soldiers.length);
							m.setShowBlood(true);
							m.setStartBlood(System.currentTimeMillis());
							Critical c = new Critical(385 + m.getY() * 60,
									11 + m.getX() * 60, shanghaiNum, null);
							Critical c1 = new Critical(385 + m.getY() * 60 + 5,
									11 + m.getX() * 60 - 10, shanghaiNum, null);
							criticalArray1.addElement(c);
							criticalArray1.addElement(c1);
							v8a.addElement(m);
							m.setBoold(m.getBoold() - shanghaiNum * 2);
							if (m.getBoold() <= 0) {
								m.setBoold(0);
								deathArray.addElement(m);
								monsterVector.removeElement(m);
							} else {
								j++;
							}
							soldiers[i] = null;
							break;
						}
					} else {
						j++;
					}
				}
			}
		}
	}

	/***
	 * 7.魔法攻击判断
	 * 
	 * @param soldiers
	 */
	public void magicAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			int randomValue = RandomValue.getRandInt(0, monsterVector.size());
			Monster m = (Monster) monsterVector.elementAt(randomValue);
			magicArray.addElement(new Arrow(m.getX() * 60 + 17 - 210,
					m.getY() * 60 + 85, img[temp_img_distance2 + 76], m.getX(),
					m.getY(), m, soldiers[0].getLevel(), soldiers.length));
		}
	}

	/***
	 * 6.狂战士攻击判断
	 * 
	 * @param soldiers
	 * 
	 */
	public void crazyInfantryAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				for (int j = 0; j < monsterVector.size();) {
					Monster m = (Monster) monsterVector.elementAt(j);
					if (collision(soldiers[i], m)) {
						int x = m.getX();
						int y = m.getY();
						if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& mapIndexOfIndex == 4 && y == 1 && x == 2 && (2 == soldiers[i]
								.getX() || 2 == soldiers[i].getX() - 1 || 2 == soldiers[i]
								.getX() - 2)) || x == soldiers[i].getX()) {
							int shanghaiNum = shanghai(soldiers[i].getLevel(),
									soldiers[i].getAuthenticKind() + 1,
									soldiers.length);
							m.setShowBlood(true);
							m.setStartBlood(System.currentTimeMillis());
							m.setBoold(m.getBoold() - shanghaiNum);
							Critical c = new Critical(385 + m.getY() * 60,
									11 + m.getX() * 60, shanghaiNum, m);
							criticalArray1.addElement(c);
							v6a.addElement(m);
							for (int k = 0; k < monsterVector.size();) {
								Monster m1 = (Monster) monsterVector
										.elementAt(k);
								if ((m.getY() == m1.getY())
										&& (m.getX() == m1.getX() + 1 || m
												.getX() == m1.getX() - 1)) {
									m1.setShowBlood(true);
									m1.setStartBlood(System.currentTimeMillis());
									m1.setBoold(m1.getBoold() - shanghaiNum / 2);
									Critical c1 = new Critical(
											385 + m1.getY() * 60,
											11 + m1.getX() * 60,
											shanghaiNum / 2, m1);
									criticalArray1.addElement(c1);
									v6a.addElement(m1);
									if (m1.getBoold() <= 0) {
										m1.setBoold(0);
										deathArray.addElement(m1);
										monsterVector.removeElement(m1);
									} else {
										k++;
									}
								} else {
									k++;
								}
							}
							if (m.getBoold() <= 0) {
								m.setBoold(0);
								deathArray.addElement(m);
								monsterVector.removeElement(m);
							}
							soldiers[i] = null;
							break;
						}
					} else {
						j++;
					}
				}
			}
		}
	}

	/***
	 * 5.牧师攻击判断
	 * 
	 * @param soldiers
	 */
	public void pastorAttack(Soldier[] soldiers) {
		int[] idRow = new int[7];
		Monster[] idCol = new Monster[7];
		int idcolMonster = 3;

		for (int i = 0; i < 7; i++) {
			idRow[i] = 0;
		}
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				idRow[soldiers[i].getX()]++;
			}
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				idcolMonster = ((Monster) monsterVector.elementAt(i)).getY() < idcolMonster ? ((Monster) monsterVector
						.elementAt(i)).getY() : idcolMonster;
		}
		for (int i = 0; i < 7; i++) {
			idCol[i] = null;
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				if ((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
						&& mapIndexOfIndex == 4
						&& idcolMonster == 1
						&& ((Monster) monsterVector.elementAt(i)).getX() == 2) {
					idCol[2] = (Monster) monsterVector.elementAt(i);
					idCol[3] = (Monster) monsterVector.elementAt(i);
					idCol[4] = (Monster) monsterVector.elementAt(i);
				} else if (idcolMonster == ((Monster) monsterVector
						.elementAt(i)).getY()) {
					idCol[((Monster) monsterVector.elementAt(i)).getX()] = (Monster) monsterVector
							.elementAt(i);
				}
		}
		for (int i = 0; i < 7; i++) {
			if (idRow[i] != 0) {
				for (int j = 0; j < 7; j++) {
					if (i - j >= 0 && idCol[i - j] != null
							&& idCol[i - j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && (i
													- j == 2
													|| i - j == 3 || i - j == 4)) || idCol[f]
													.getX() == i - j)) {
										slickballArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 72], i
														- j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					} else if (i + j <= 6 && idCol[i + j] != null
							&& idCol[i + j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && (i
													+ j == 2
													|| i + j == 3 || i + j == 4)) || idCol[f]
													.getX() == i + j)) {
										slickballArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 72], i
														+ j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	/***
	 * 4.锤兵攻击判断
	 * 
	 * @param soldiers
	 */
	public void hammerAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				for (int j = 0; j < monsterVector.size();) {
					Monster m = (Monster) monsterVector.elementAt(j);
					if (collision(soldiers[i], m)) {
						int x = m.getX();
						int y = m.getY();
						if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& mapIndexOfIndex == 4 && y == 1 && x == 2 && (2 == soldiers[i]
								.getX() || 2 == soldiers[i].getX() - 1 || 2 == soldiers[i]
								.getX() - 2)) || x == soldiers[i].getX()) {
							v4a.addElement(m);
							int shanghaiNum = shanghai(soldiers[i].getLevel(),
									soldiers[i].getAuthenticKind() + 1,
									soldiers.length);
							m.setShowBlood(true);
							m.setStartBlood(System.currentTimeMillis()
									+ alertSumTime);
							m.setStartTime(System.currentTimeMillis()
									+ alertSumTime);
							Critical c = new Critical(385 + m.getY() * 60,
									11 + m.getX() * 60, shanghaiNum, null);
							criticalArray1.addElement(c);
							soldiers[i] = null;
							m.setBoold(m.getBoold() - shanghaiNum);
							if (m.getBoold() <= 0) {
								m.setBoold(0);
								deathArray.addElement(m);
								monsterVector.removeElement(m);
							} else {
								j++;
							}
							soldiers[i] = null;
							break;
						}
					} else {
						j++;
					}
				}
			}
		}
	}

	/***
	 * 3.猎人攻击判断
	 * 
	 * @param soldiers
	 */
	public void hunterAttack(Soldier[] soldiers) {
		int[] idRow = new int[7];
		Monster[] idCol = new Monster[7];
		int idcolMonster = 3;

		for (int i = 0; i < 7; i++) {
			idRow[i] = 0;
		}
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				idRow[soldiers[i].getX()]++;
			}
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				idcolMonster = ((Monster) monsterVector.elementAt(i)).getY() < idcolMonster ? ((Monster) monsterVector
						.elementAt(i)).getY() : idcolMonster;
		}
		for (int i = 0; i < 7; i++) {
			idCol[i] = null;
		}
		for (int i = 0; i < monsterVector.size(); i++) {
			if (((Monster) monsterVector.elementAt(i)).getBoold() != 0)
				if ((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
						&& mapIndexOfIndex == 4
						&& idcolMonster == 1
						&& ((Monster) monsterVector.elementAt(i)).getX() == 2) {
					idCol[2] = (Monster) monsterVector.elementAt(i);
					idCol[3] = (Monster) monsterVector.elementAt(i);
					idCol[4] = (Monster) monsterVector.elementAt(i);
				} else if (idcolMonster == ((Monster) monsterVector
						.elementAt(i)).getY()) {
					idCol[((Monster) monsterVector.elementAt(i)).getX()] = (Monster) monsterVector
							.elementAt(i);
				}
		}
		for (int i = 0; i < 7; i++) {
			if (idRow[i] != 0) {
				for (int j = 0; j < 7; j++) {
					if (i - j >= 0 && idCol[i - j] != null
							&& idCol[i - j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && (i
													- j == 2
													|| i - j == 3 || i - j == 4)) || idCol[f]
													.getX() == i - j)) {
										arrowArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 52], i
														- j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					} else if (i + j <= 6 && idCol[i + j] != null
							&& idCol[i + j].getBoold() != 0) {
						for (int h = 0; h < soldiers.length; h++) {
							if (soldiers[h] != null && soldiers[h].getX() == i) {
								for (int f = 0; f < 7; f++) {
									if ((idCol[f] != null && idCol[f]
											.getBoold() != 0)
											&& (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
													&& mapIndexOfIndex == 4
													&& idcolMonster == 1
													&& idCol[f].getX() == 2 && (i
													+ j == 2
													|| i + j == 3 || i + j == 4)) || idCol[f]
													.getX() == i + j)) {
										arrowArray.addElement(new Arrow(
												soldiers[h].getX() * 60 + 17,
												soldiers[h].getY() * 60 + 11,
												img[temp_img_distance2 + 52], i
														+ j, idcolMonster,
												idCol[f], soldiers[h]
														.getLevel(),
												soldiers.length));
									}
								}
							}
						}
						break;
					}
				}
			}
		}
	}

	/***
	 * 2.骑兵攻击判断
	 * 
	 * @param soldiers
	 */
	public void sowarAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				for (int j = 0; j < monsterVector.size();) {
					Monster m = (Monster) monsterVector.elementAt(j);
					if (collision(soldiers[i], m)) {
						int x = m.getX();
						int y = m.getY();
						if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& mapIndexOfIndex == 4 && y == 1 && x == 2 && (2 == soldiers[i]
								.getX() || 2 == soldiers[i].getX() - 1 || 2 == soldiers[i]
								.getX() - 2)) || x == soldiers[i].getX()) {
							v2a.addElement(m);
							int shanghaiNum = shanghai(soldiers[i].getLevel(),
									soldiers[i].getAuthenticKind() + 1,
									soldiers.length);
							m.setShowBlood(true);
							m.setStartBlood(System.currentTimeMillis());
							Critical c = new Critical(385 + m.getY() * 60,
									11 + m.getX() * 60, shanghaiNum, null);
							criticalArray1.addElement(c);
							m.setBoold(m.getBoold() - shanghaiNum);
							if (m.getBoold() <= 0) {
								m.setBoold(0);
								deathArray.addElement(m);
								monsterVector.removeElement(m);
							} else {
								j++;
							}
						}
					} else {
						j++;
					}
				}
			}
		}
	}

	/***
	 * 1.士兵攻击判断
	 * 
	 * @param soldiers
	 */
	public void infantryAttack(Soldier[] soldiers) {
		for (int i = 0; i < soldiers.length; i++) {
			if (soldiers[i] != null) {
				for (int j = 0; j < monsterVector.size();) {
					Monster m = (Monster) monsterVector.elementAt(j);
					if (collision(soldiers[i], m)) {
						int x = m.getX();
						int y = m.getY();
						if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
								&& mapIndexOfIndex == 4 && y == 1 && x == 2 && (2 == soldiers[i]
								.getX() || 2 == soldiers[i].getX() - 1 || 2 == soldiers[i]
								.getX() - 2)) || x == soldiers[i].getX()) {
							int shanghaiNum = shanghai(soldiers[i].getLevel(),
									soldiers[i].getAuthenticKind() + 1,
									soldiers.length);
							m.setShowBlood(true);
							m.setStartBlood(System.currentTimeMillis());
							Critical c = new Critical(385 + m.getY() * 60,
									11 + m.getX() * 60, shanghaiNum, m);
							criticalArray1.addElement(c);
							v1a.addElement(m);
							m.setBoold(m.getBoold() - shanghaiNum);
							if (m.getBoold() <= 0) {
								m.setBoold(0);
								deathArray.addElement(m);
								monsterVector.removeElement(m);
							} else {
								j++;
							}
							soldiers[i] = null;
							break;
						}
					} else {
						j++;
					}
				}
			}
		}
	}

	public int shanghai(int level, int kind, int count) {
		int atk = (int) (Upgrade.upgradeSoldierAttack(level, kind)
				* Soldier.getAtkCoefficient() * soldierATkTimes);
		if (count == 3) {
			return atk;
		} else if (count == 4) {
			return (int) ((int) atk * 1.25);
		} else if (count == 5) {
			return (int) ((int) atk * 1.5);
		} else {
			return (int) ((int) atk * 2);
		}
	}

	public void drawMoveSoldier() {
		if (ca.getSs() != null) {
			Soldier[][][] ss = ca.getSs();
			int length0 = ss.length;
			for (int f = 0; f < length0; f++) {
				if (ss[f] == null)
					break;
				int length1 = ss[f].length;
				for (int i = 0; i < length1; i++) {
					if (ss[f][i] == null)
						continue;
					for (int h = 0; h < ss[f][i].length; h++) {
						if (ss[f][i][h] != null) {
							for (int ff = 0; ff < ss[f][i].length; ff++) {
								if (ss[f][i][ff] != null) {
									for (int kk = 0; kk < IceDrowVector.size();) {
										if (Soldier.equal(ss[f][i][ff],
												((IceDrow) IceDrowVector
														.elementAt(kk)).getS())) {
											ss[f][i][ff].setIceNoMove(false);
											IceDrowVector.removeElementAt(kk);
										} else {
											kk++;
										}
									}
								}
							}
							if (ss[f][i][h].getAuthenticKind() == 0) {
								if (!stopState && !isSuggest) {
									System.out.println("停止在这里了5577");
									infantryAttack(ss[f][i]);
									System.out.println("停止在这里了5588");
								}
								soldier1Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 1) {
								if (!stopState && !isSuggest)
									sowarAttack(ss[f][i]);
								soldier2Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 2) {
								if (!stopState && !isSuggest)
									hunterAttack(ss[f][i]);
								soldier3Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 3) {
								if (!stopState && !isSuggest)
									hammerAttack(ss[f][i]);
								soldier1Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 4) {
								if (!stopState && !isSuggest)
									pastorAttack(ss[f][i]);
								soldier3Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 5) {
								if (!stopState && !isSuggest)
									crazyInfantryAttack(ss[f][i]);
								soldier1Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 6) {
								if (!stopState && !isSuggest)
									magicAttack(ss[f][i]);
								soldier3Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 7) {
								if (!stopState && !isSuggest)
									assassinAttack(ss[f][i]);
								soldier1Anim(ss[f][i]);
							} else if (ss[f][i][h].getAuthenticKind() == 8) {
								if (!stopState && !isSuggest)
									if (ss[f][i][0].getAnimIndex() == 0) {
										hackbuteerAttack(ss[f][i]);
									}
								soldier9Anim(ss[f][i]);
							}
							break;
						}
					}
				}
			}
		}
	}

	private void soldier9Anim(Soldier[] ss) {
		int length2 = ss.length;
		for (int j = 0; j < length2; j++) {
			if (ss[j] != null) {
				if (ss[j].getAnimIndex() == 4) {
					ss[j] = null;
					continue;
				}
				g.drawRegion(
						img[(ss[j].getAuthenticKind())],
						Resource.heroAndSoldierLevel[ss[j].getAuthenticKind()] / 7 * 62,
						0, 62, 62, 0, ss[j].getY() * 60 + 17 + ss[j].getOffX(),
						ss[j].getX() * 60 + 11 + ss[j].getOffY(), 20);
				g.drawRegion(img[temp_img_distance2 + 55],
						ss[j].getAnimIndex() * 25, 0, 25, 28, 0, ss[j].getY()
								* 60 + 57 + ss[j].getOffX(), ss[j].getX() * 60
								+ 31 + ss[j].getOffY(), 20);
				if (!stopState && !isSuggest) {
					ss[j].setAnimIndex(ss[j].getAnimIndex() + 1);
				}
			}
		}
	}

	private void soldier3Anim(Soldier[] ss) {
		if (!stopState && !isSuggest) {
			for (int kl = 0; kl < ss.length; kl++) {
				ss[kl] = null;
			}
		}
	}

	private void soldier2Anim(Soldier[] ss) {
		int length2 = ss.length;
		for (int j = 0; j < length2; j++) {
			if (ss[j] == null)
				continue;
			if (!stopState && !isSuggest) {
				ss[j].setOffX((ss[j].getOffX() + 65));
			}
			g.drawRegion(
					img[(ss[j].getAuthenticKind())],
					Resource.heroAndSoldierLevel[ss[j].getAuthenticKind()] / 7 * 62,
					0, 62, 62, 0, ss[j].getY() * 60 + 17 + ss[j].getOffX(),
					ss[j].getX() * 60 + 11 + ss[j].getOffY(), 20);
			if (ss[j].getState() == 1) {
				if (arrowIndex % 8 >= 0 && arrowIndex % 8 < 2) {
					g.drawRegion(img[temp_img_distance2 + 50], 0, 0, 53, 53, 0,
							ss[j].getY() * 60 + 38 + ss[j].getOffX(),
							ss[j].getX() * 60 + ss[j].getOffY() + 20, 0);
				} else if (arrowIndex % 8 >= 2 && arrowIndex % 8 < 4) {
					g.drawRegion(img[temp_img_distance2 + 50], 53, 0, 53, 53,
							0, ss[j].getY() * 60 + 38 + ss[j].getOffX(),
							ss[j].getX() * 60 + ss[j].getOffY() + 20, 0);
				} else if (arrowIndex % 8 >= 4 && arrowIndex % 8 < 6) {
					g.drawRegion(img[temp_img_distance2 + 50], 106, 0, 53, 53,
							0, ss[j].getY() * 60 + 38 + ss[j].getOffX(),
							ss[j].getX() * 60 + ss[j].getOffY() + 20, 0);
				} else {
					g.drawRegion(img[temp_img_distance2 + 50], 159, 0, 53, 53,
							0, ss[j].getY() * 60 + 38 + ss[j].getOffX(),
							ss[j].getX() * 60 + ss[j].getOffY() + 20, 0);
				}
			}
			if (j + 1 == length2
					&& ss[j].getY() * 60 + 17 + ss[j].getOffX() > 880) {
				for (int kl = 0; kl < length2; kl++) {
					ss[kl] = null;
				}
			}
		}
	}

	private void soldier1Anim(Soldier[] ss) {
		int length2 = ss.length;
		for (int j = 0; j < length2; j++) {
			if (ss[j] != null) {
				if (!stopState && !isSuggest) {
					ss[j].setOffX((ss[j].getOffX() + 40));
				}
				g.drawRegion(
						img[(ss[j].getAuthenticKind())],
						Resource.heroAndSoldierLevel[ss[j].getAuthenticKind()] / 7 * 62,
						0, 62, 62, 0, ss[j].getY() * 60 + 17 + ss[j].getOffX(),
						ss[j].getX() * 60 + 11 + ss[j].getOffY(), 20);
				if (ss[j].getY() * 60 + 17 + ss[j].getOffX() > 880) {
					for (int k = 0; k < length2; k++) {
						ss[k] = null;
					}
				}
			}
		}
	}

	public void drawHeroInfo1(Hero hero) {
		int temp_x = 5;
		int temp_y = 435;
		setColour(0xffffff, Font.SIZE_MEDIUM);
		g.drawImage(img[temp_img_distance2 + 36], temp_x, temp_y, 20);
		for (int i = 0; i < 58; i++) {
			g.drawImage(img[temp_img_distance2 + 37], temp_x + 25 + i * 10,
					temp_y, 20);
		}
		g.drawImage(img[temp_img_distance2 + 38], temp_x + 605, temp_y, 20);
		g.drawImage(img[temp_img_distance2 + 34], temp_x + 7, temp_y + 9, 20);
		g.drawImage(img[temp_img_distance2 + 29], Hero.booldX - 1,
				Hero.booldY - 1, 20);
		g.drawImage(img[temp_img_distance2 + 29], Hero.magicX - 1,
				Hero.magicY - 1, 20);
		for (int i = 0; i < 3; i++) {
			g.drawImage(img[14], Hero.booldX + 226 + 78 * i, Hero.booldY - 30,
					20);
			g.drawRegion(img[temp_img_distance1 - 6 + 51], i * 62, 0, 62, 62,
					0, Hero.booldX + 226 + 78 * i, Hero.booldY - 30, 20);
			g.drawImage(img[temp_img_distance2 + 35], Hero.booldX + 218 + 78
					* i, Hero.booldY + 23, 20);
			g.drawImage(img[temp_img_distance1 - 6 + 50], Hero.booldX + 265
					+ 78 * i, Hero.booldY - 30, 20);
			setColour(0x000000, Font.SIZE_MEDIUM);
			TextView.showSingleLineText(g, "" + Resource.goodsNums[i],
					Hero.booldX + 272 + 78 * i + 2, Hero.booldY - 30 + 2);
			TextView.showSingleLineText(g, "按键" + (i + 1), Hero.booldX + 218
					+ 78 * i + 2, Hero.booldY + 23 + 2, 76, 26,
					TextView.STYLE_ALIGN_CENTER);
			setColour(0xffffff, Font.SIZE_MEDIUM);
			TextView.showSingleLineText(g, "" + Resource.goodsNums[i],
					Hero.booldX + 272 + 78 * i, Hero.booldY - 30);
			TextView.showSingleLineText(g, "按键" + (i + 1), Hero.booldX + 218
					+ 78 * i, Hero.booldY + 23, 76, 26,
					TextView.STYLE_ALIGN_CENTER);
		}
		g.drawRegion(hero.getSrc(), Resource.saveSelectHero * 62, 0, 62, 62, 0,
				hero.getX() + 1, hero.getY() + 1, 20);// 画英雄图片
		g.drawRegion(hero.getHeroskillSrc(), Resource.saveSelectHero * 35, 0,
				35, 35, 0, hero.getX() + 95, hero.getY() - 5, 20);
		if (hero.getMagic() == 100) {
			g.drawRegion(img[temp_img_distance2 + 84], arrowIndex % 3 * 35, 0,
					35, 35, 0, hero.getX() + 95, hero.getY() - 5, 20);
		}
		setColour(0x000000, Font.SIZE_MEDIUM);
		TextView.showMultiLineText(g, "按'5'键释放技能", TextView.STYLE_ALIGN_CENTER,
				100 + 2, 485 + 2, 70, 35);
		setColour(0xffffff, Font.SIZE_MEDIUM);
		TextView.showMultiLineText(g, "按'5'键释放技能", TextView.STYLE_ALIGN_CENTER,
				100, 485, 70, 35);
		double unit = hero.getBoolds() * 1.0 / 100;
		if (hero.getBoold() >= unit) {// 画英雄血条
			g.drawRegion(img[temp_img_distance2 + 28], 0, 0, 2, 21, 0,
					Hero.booldX, Hero.booldY, 0);
			if (hero.getBoold() == hero.getBoolds()) {
				for (int i = 0; i < (hero.getBoolds() - 2 * unit) / unit; i++)
					g.drawRegion(img[temp_img_distance2 + 28], 2, 0, 2, 21, 0,
							Hero.booldX + 2 * (i + 1), Hero.booldY, 0);
				g.drawRegion(img[temp_img_distance2 + 28], 4, 0, 2, 21, 0,
						Hero.booldX + (int) ((hero.getBoold() / unit - 1) * 2),
						Hero.booldY, 0);
			}
			if (hero.getBoold() < hero.getBoolds()) {
				for (int i = 0; i < (hero.getBoold() - unit) / unit; i++)
					g.drawRegion(img[temp_img_distance2 + 28], 2, 0, 2, 21, 0,
							Hero.booldX + 2 * (i + 1), Hero.booldY, 0);
			}
		}
		setColour(0x000000, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g,
				"HP:" + hero.getBoold() + "/" + hero.getBoolds(),
				Hero.booldX + 2, Hero.booldY + 2, 200, 21,
				TextView.STYLE_ALIGN_CENTER);
		setColour(0xffffff, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g,
				"HP:" + hero.getBoold() + "/" + hero.getBoolds(), Hero.booldX,
				Hero.booldY, 200, 21, TextView.STYLE_ALIGN_CENTER);
		unit = 100 / 100;
		if (hero.getMagic() >= unit) {// 画英雄蓝条
			g.drawRegion(img[temp_img_distance2 + 28], 0, 21, 2, 21, 0,
					Hero.magicX, Hero.magicY, 0);
			if (hero.getMagic() == 2000) {
				for (int i = 0; i < (hero.getMagic() - 2 * unit) / unit; i++)
					g.drawRegion(img[temp_img_distance2 + 28], 2, 21, 2, 21, 0,
							Hero.magicX + 2 * (i + 1), Hero.magicY, 0);
				g.drawRegion(img[temp_img_distance2 + 28], 4, 21, 2, 21, 0,
						Hero.magicX + (int) (hero.getMagic() / unit - 1) * 2,
						Hero.magicY, 0);
			}
			if (hero.getMagic() < 2000) {
				for (int i = 0; i < (hero.getMagic() - unit) / unit; i++)
					g.drawRegion(img[temp_img_distance2 + 28], 2, 21, 2, 21, 0,
							Hero.magicX + 2 * (i + 1), Hero.magicY, 0);
			}
		}
		setColour(0x000000, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g, "MP:" + hero.getMagic() + "/" + 100,
				Hero.magicX + 2, Hero.magicY + 2, 200, 21,
				TextView.STYLE_ALIGN_CENTER);
		setColour(0xffffff, Font.SIZE_MEDIUM);
		TextView.showSingleLineText(g, "MP:" + hero.getMagic() + "/" + 100,
				Hero.magicX, Hero.magicY, 200, 21, TextView.STYLE_ALIGN_CENTER);
	}

	private void drawUnfoldAttainment(int attainmentIndex) {
		attainmentPanelStartTime = attainmentPanelStartTime
				+ suggestAndStopEndTime + alertSumTime;
		if (System.currentTimeMillis() - attainmentPanelStartTime <= 5000) {
			for (int i = 0; i < attainmentPanelIndex; i++) {
				g.drawRegion(img[20], 37, 7, 4, 89, 0, 259, 27, 20);
				g.drawRegion(img[20], 37, 7, 4, 89, 0, 259 - i * 4, 27, 20);
				g.drawRegion(img[20], 37, 7, 4, 89, 0, 259 + i * 4, 27, 20);
			}
			if (attainmentPanelIndex == 0) {
				g.drawRegion(img[20], 1, 0, 27, 103, 0,
						237 - 4 * attainmentPanelIndex, 20, 20);
				g.drawRegion(img[20], 53, 0, 27, 103, 0,
						237 + 4 * attainmentPanelIndex, 20, 20);
			} else if (attainmentPanelIndex != 0) {
				g.drawRegion(img[20], 1, 0, 27, 103, 0,
						237 - 4 * attainmentPanelIndex, 20, 20);
				g.drawRegion(img[20], 53, 0, 27, 103, 0,
						237 + 4 * attainmentPanelIndex, 20, 20);
			}
			if (!stopState && !isSuggest) {
				attainmentPanelIndex += 2;
			}
			if (attainmentPanelIndex >= 30) {
				if (!stopState && !isSuggest) {
					attainmentPanelIndex -= 2;
				}
				g.drawImage(img[temp_img_distance1 - 6 + 66], 150, 29, 20);
				setColour(0xff0000, Font.SIZE_LARGE);
				TextView.showSingleLineText(g,
						Resource.AttainmentName[attainmentIndex], 235, 40, 114,
						20, TextView.STYLE_ALIGN_CENTER);
				setColour(0x000000, Font.SIZE_MEDIUM);

				TextView.showMultiLineText(g,
						Resource.AttainmentCondition[attainmentIndex], 0, 235,
						60, 114, 20);
				setColour(0xff0000, Font.SIZE_MEDIUM);
				TextView.showSingleLineText(g, "奖励"
						+ Resource.AttainmentMoney[attainmentIndex] + "金币",
						235, 80, 114, 20, TextView.STYLE_ALIGN_CENTER);
			}
		} else {
			isUnfoldAttainment = false;
			attainmentPanelStartTime = 0;
			UnfoldAttainmentIndex = -1;
			attainmentPanelIndex = 1;
		}

	}

	public boolean judgeCritical() {
		boolean b = false;
		int i = RandomValue.getRandInt(0, 100);
		if (i <= Resource.soldierValue[8][4] + Resource.soldierValue[8][5]
				* Resource.heroAndSoldierLevel[8]) {
			b = true;
		}
		return b;
	}

	public void drawSoldierBullet4() {
		if (firelockArray != null) {
			Enumeration e = firelockArray.elements();
			g.setColor(0xffffff);
			while (e.hasMoreElements()) {
				Arrow a = (Arrow) e.nextElement();
				if (!stopState && !isSuggest) {
					if (a.isFirst()) {
						int _x = a.getX() - (a.getEnd_x() * 60 + 17 + 30);
						int _y = a.getY() - (a.getEnd_y() * 60 + 385 + 30);
						int _x_ = (int) (_x * 1.0 / 3);
						int _y_ = (int) (_y * 1.0 / 3);
						a.set_x_(-_x_);
						a.set_y_(-_y_);
						a.setFirst(false);
					}
					g.drawLine(a.getY(), a.getX(), a.getY() + a.get_y_(),
							a.getX() + a.get_x_());
					a.setX(a.getX() + a.get_x_());
					a.setY(a.getY() + a.get_y_());
				}
				if (a.getX() >= a.getEnd_x() * 60 + 17
						&& a.getX() <= a.getEnd_x() * 60 + 17 + 60
						&& a.getY() >= a.getEnd_y() * 60 + 385
						&& a.getY() <= a.getEnd_y() * 60 + 385 + 60) {
					Monster m9 = a.getM();
					v9a.addElement(m9);
					m9.setShowBlood(true);
					m9.setStartBlood(System.currentTimeMillis());
					int tempBlood = shanghai(a.getLevel(), 9, a.getCount());
					if (judgeCritical()) {
						m9.setBoold(m9.getBoold() - tempBlood * 2);
						Critical c = new Critical(a.getY(), a.getX(),
								tempBlood * 2, null);
						criticalArray.addElement(c);
					} else {
						m9.setBoold(m9.getBoold() - tempBlood);
						Critical c = new Critical(a.getY(), a.getX(),
								tempBlood, null);
						criticalArray1.addElement(c);
					}
					if (m9.getBoold() <= 0) {
						m9.setBoold(0);
						deathArray.addElement(m9);
						monsterVector.removeElement(m9);
					}
					firelockArray.removeElement(a);
				}
				if (a.getY() > 600) {
					firelockArray.removeElement(a);
				}
			}
		}
	}

	public void drawSoldierBullet3() {
		if (magicArray != null) {
			Enumeration e = magicArray.elements();
			while (e.hasMoreElements()) {
				Arrow a = (Arrow) e.nextElement();
				if (a.getIndex() < 3) {
					g.drawRegion(a.getSrc(), a.getIndex() * 82, 0, 82, 80, 0,
							a.getY(), a.getX(), 20);
					if (!stopState && !isSuggest) {
						a.setX(a.getX() + 70);
						a.setY(a.getY() + 100);
						a.setIndex(a.getIndex() + 1);
					}
				}
				if (Collision
						.checkSquareCollision(a.getY(), a.getX(), 32, 20,
								a.getEnd_y() * 60 + 385,
								a.getEnd_x() * 60 + 17, 60, 60)) {
					if (a.getIndex() < 8) {
						g.drawRegion(a.getSrc(), a.getIndex() * 82, 0, 82, 80,
								0, a.getY() - 20, a.getX() - 20, 20);
						if (!stopState && !isSuggest) {
							a.setIndex(a.getIndex() + 1);
						}
					} else {
						Monster m7 = a.getM();
						v7a.addElement(m7);
						m7.setShowBlood(true);
						m7.setStartBlood(System.currentTimeMillis());
						int tempBlood = shanghai(a.getLevel(), 7, a.getCount());
						Critical c = new Critical(a.getY(), a.getX(),
								tempBlood, m7);
						criticalArray1.addElement(c);
						m7.setBoold(m7.getBoold() - tempBlood);
						if (m7.getBoold() <= 0) {
							m7.setBoold(0);
							deathArray.addElement(m7);
							monsterVector.removeElement(m7);
						}
						magicArray.removeElement(a);
					}
				}
				if (a.getY() > 600) {
					magicArray.removeElement(a);
				}
			}
		}
	}

	public void drawSoldierBullet2() {
		if (slickballArray != null) {
			Enumeration e = slickballArray.elements();
			while (e.hasMoreElements()) {
				Arrow a = (Arrow) e.nextElement();
				if (a.getIndex() < 3) {
					g.drawRegion(a.getSrc(), 29 * a.getIndex(), 0, 29, 60, 0,
							a.getY() + 60, a.getX(), 20);
					if (!stopState && !isSuggest) {
						a.setIndex(a.getIndex() + 1);
					}
				} else {
					a.setSrc(img[temp_img_distance2 + 73]);
					int _x = a.getX() - (a.getEnd_x() * 60 + 17);
					int _y = a.getY() - (a.getEnd_y() * 60 + 385);
					double xielv;
					if (_x == 0) {
						xielv = 0;
					} else {
						xielv = (_x * 1.0) / (_y * 1.0);
					}
					g.drawRegion(a.getSrc(), 38 * ((a.getIndex() - 3) % 5), 0,
							32, 38, 0, a.getY(), a.getX(), 20);
					if (!stopState && !isSuggest) {
						if (xielv == 0) {
							a.setX(a.getX());// 向下跑
						} else {
							a.setX(a.getX() + (int) (xielv * 60));// 向下跑
						}
						a.setY((a.getY() + 60));// 向右跑
						a.setIndex(a.getIndex() + 1);
					}
					if (Collision.checkSquareCollision(a.getY(), a.getX(), 32,
							20, a.getEnd_y() * 60 + 385,
							a.getEnd_x() * 60 + 17, 60, 60)) {
						Monster m5 = a.getM();
						v5a.addElement(m5);
						m5.setShowBlood(true);
						m5.setStartBlood(System.currentTimeMillis());
						int tempBlood = shanghai(a.getLevel(), 5, a.getCount());
						Critical c = new Critical(a.getY(), a.getX(),
								tempBlood, null);
						criticalArray1.addElement(c);
						hero.setBoold(hero.getBoold()
								+ (int) (tempBlood * 6.0 / 100));
						if (hero.getBoold() >= hero.getBoolds()) {
							hero.setBoold(hero.getBoolds());
						}
						m5.setBoold(m5.getBoold() - tempBlood);
						if (m5.getBoold() <= 0) {
							m5.setBoold(0);
							deathArray.addElement(m5);
							monsterVector.removeElement(m5);
						}
						slickballArray.removeElement(a);
					}
					if (a.getY() > 600) {
						slickballArray.removeElement(a);
					}
				}
			}
		}
	}

	public void drawSoldierBullet1() {
		if (arrowArray != null) {
			Enumeration e = arrowArray.elements();
			while (e.hasMoreElements()) {
				Arrow a = (Arrow) e.nextElement();
				int _x = a.getX() - (a.getEnd_x() * 60 + 17);
				int _y = a.getY() - (a.getEnd_y() * 60 + 385);
				double xielv;
				if (_x == 0) {
					xielv = 0;
				} else {
					xielv = (_x * 1.0) / (_y * 1.0);
				}
				if (!stopState && !isSuggest) {
					if (xielv == 0) {
						a.setX(a.getX());// 向下跑
					} else {
						a.setX(a.getX() + (int) (xielv * 60));// 向下跑
					}
					a.setY((a.getY() + 60));// 向右跑
				}
				if (xielv <= -1.0) {
					g.drawRegion(a.getSrc(), 0, 0, 54, 72, 0, a.getY(),
							a.getX(), 20);
				} else if (xielv > -1.0 && xielv < 0.0) {
					g.drawRegion(a.getSrc(), 54, 0, 54, 72, 0, a.getY(),
							a.getX(), 20);
				} else if (xielv == 0.0) {
					g.drawRegion(a.getSrc(), 108, 0, 54, 72, 0, a.getY(),
							a.getX(), 20);
				} else if (xielv > 0.0 && xielv < 1.0) {
					g.drawRegion(a.getSrc(), 162, 0, 54, 72, 0, a.getY(),
							a.getX(), 20);
				} else if (xielv >= 1.0) {
					g.drawRegion(a.getSrc(), 216, 0, 54, 72, 0, a.getY(),
							a.getX(), 20);
				}
				if (Collision
						.checkSquareCollision(a.getY(), a.getX(), 32, 20,
								a.getEnd_y() * 60 + 385,
								a.getEnd_x() * 60 + 17, 60, 60)) {
					Monster m3 = a.getM();
					v3a.addElement(m3);
					m3.setShowBlood(true);
					m3.setStartBlood(System.currentTimeMillis());
					int tempBlood = shanghai(a.getLevel(), 3, a.getCount());
					int tempBlood1 = Resource.soldierValue[2][4]
							+ Resource.soldierValue[2][5]
							* Resource.heroAndSoldierLevel[2];
					Critical c = new Critical(a.getY(), a.getX(), tempBlood, m3);
					Critical c1 = new Critical(a.getY(), a.getX(), tempBlood1,
							m3);
					criticalArray1.addElement(c);
					criticalArray2.addElement(c1);
					m3.setBoold(m3.getBoold() - tempBlood);
					if (m3.getBoold() <= 0) {
						m3.setBoold(0);
						deathArray.addElement(m3);
						monsterVector.removeElement(m3);
					}
					arrowArray.removeElement(a);
				}
				if (a.getY() > 600) {
					arrowArray.removeElement(a);
				}
			}
		}
	}

	public void drawMonsterBullet1() {
		if (buttleArray != null) {
			Enumeration e = buttleArray.elements();
			while (e.hasMoreElements()) {
				Bullet b = (Bullet) e.nextElement();
				if (!stopState && !isSuggest)
					b.setX((b.getX() - 30));
				int imgWidth;
				int imgHeight;
				int imgIndex;
				if (b.getFlag() == 1) {
					imgIndex = b.getIndex();
					imgWidth = b.getSrc().getWidth() / 3;
					imgHeight = b.getSrc().getHeight();
					g.drawRegion(b.getSrc(), imgWidth * (imgIndex % 3), 0,
							imgWidth, imgHeight, 0, b.getX(), b.getY(), 20);
				} else {
					imgIndex = b.getIndex();
					imgWidth = b.getSrc().getWidth() / 4;
					imgHeight = b.getSrc().getHeight();
					g.drawRegion(b.getSrc(), imgWidth * (imgIndex % 4), 0,
							imgWidth, imgHeight, 0, b.getX(), b.getY(), 20);
				}
				b.setIndex(imgIndex + 1);
				if (b.getX() < 0) {
					int fangyuli = (int) (hero.getArmor());
					int ddx;
					int monsterAttack = b.getM().getHurtValue();
					if (fangyuli >= monsterAttack) {
						ddx = hero.getBoold();
					} else {
						ddx = (hero.getBoold() + fangyuli) > monsterAttack ? (hero
								.getBoold() + fangyuli - monsterAttack)
								: 0;
					}
					hero.setBoold(ddx);
					buttleArray.removeElement(b);
					if (StrikeHero.getInstance().getIndexAnim() == 4) {
						StrikeHero.getInstance().setIndexAnim(0);
					}
				}
			}
		}
	}

	public void drawSwordScar() {
		if (StrikeHero.getInstance().getIndexAnim() == 0)
			g.drawRegion(img[temp_img_distance2 + 40], 0, 0, 97, 176, 0, 300,
					100, 20);
		else if (StrikeHero.getInstance().getIndexAnim() == 1)
			g.drawRegion(img[temp_img_distance2 + 40], 97, 0, 97, 176, 0, 300,
					100, 20);
		else if (StrikeHero.getInstance().getIndexAnim() == 2)
			g.drawRegion(img[temp_img_distance2 + 40], 194, 0, 97, 176, 0, 300,
					100, 20);
		else if (StrikeHero.getInstance().getIndexAnim() == 3)
			g.drawRegion(img[temp_img_distance2 + 40], 291, 0, 97, 176, 0, 300,
					100, 20);
		if (!isSuggest && !stopState) {
			StrikeHero.getInstance().setIndexAnim(
					StrikeHero.getInstance().getIndexAnim() + 1);
		}
	}

	public int changeSoldier() {
		int changgeSucceed = 0;
		int i;
		IT: for (i = 0; i < 4; i++) {
			if (Resource.heroAndSoldierLevel[selectSoldierindex] == 0) {
				changgeSucceed = 3;
				break IT;
			}
			if (Resource.savaSelcetSoldier[i] == selectSoldierindex) {
				Resource.savaSelcetSoldier[i] = -1;
				changgeSucceed = 0;
				break IT;
			} else if (i == 3) {
				for (int j = 0; j < 4; j++) {
					if (Resource.savaSelcetSoldier[j] == -1) {
						Resource.savaSelcetSoldier[j] = (byte) selectSoldierindex;
						changgeSucceed = 1;
						isLoadSold = j;
						move_long_x = 320 + 70 * j - 60;
						move_long_y = 410 - 176 - 70 * selectSoldierLocation;
						move_long_count = 1;
						break IT;
					} else if (j == 3) {
						changgeSucceed = 2;
						break IT;
					}
				}
			}
		}
		return changgeSucceed;
	}

	private void drowChangeSoldierAnim(int count) {
		if (move_long_count < count) {
			g.drawRegion(img[selectSoldierindex],
					Resource.heroAndSoldierLevel[selectSoldierindex] / 7 * 62,
					0, 62, 62, 0, 60 + (move_long_x / count) * move_long_count,
					176 + selectSoldierLocation * 70 + (move_long_y / count)
							* move_long_count, 20);
		} else if (move_long_count == count) {
			g.drawRegion(img[selectSoldierindex],
					Resource.heroAndSoldierLevel[selectSoldierindex] / 7 * 62,
					0, 62, 62, 0, 320 + 70 * isLoadSold, 410, 20);
			isLoadSold = -1;
			if (newGuideIndex == 27) {
				newGuideIndex = 28;
			}
		}
		move_long_count++;
	}

	public void addMonster9Hp() {
		Enumeration e = monsterVector.elements();
		while (e.hasMoreElements()) {
			Monster m = (Monster) e.nextElement();
			if (m.getBoold() != 0) {
				m.setBoold(m.getBoold() + 100);
				if (m.getBoold() > m.getBloods()) {
					m.setBoold(m.getBloods());
				}
				m.setShowBlood(true);
				m.setStartBlood(System.currentTimeMillis());
			}
		}
	}

	public void monster10AttackAndAbsorbOfHero() {
		hero.setBoold(hero.getBoold() - 50);
		hero.setMagic(hero.getMagic() - 10, 0);
		if (hero.getBoold() < 0) {
			hero.setBoold(0);
		}
		if (hero.getMagic() < 0) {
			hero.setMagic(0, 0);
		}
	}

	public void monster11MakeSoldierNoMove() {
		boolean b = true;
		int x = 0;
		int y = 0;
		while (b) {
			x = RandomValue.getRandInt(2, 6);
			y = RandomValue.getRandInt(0, 3);
			if (idPic[x][y] != null && idPic[x][y].getOffX() == 0) {
				idPic[x][y].setIceNoMove(true);
				idPic[x][y].setStartTime();
				b = false;
				IceDrow id = new IceDrow(idPic[x][y]);
				id.setStartTime(System.currentTimeMillis());
				IceDrowVector.addElement(id);
			}
		}
	}

	public int drawIceDrow(IceDrow id, int kk) {
		System.out.println("id.getS().getOffX()===" + id.getS().getOffX());
		if (id.getS().getOffX() != 0) {
			System.out.println("offx移动了！！！！！！！！！！！！！！！！！！！！！！");
			id.getS().setIceNoMove(false);
			IceDrowVector.removeElement(id);
			return kk;
		}
		id.setStartTime(id.getStartTime() + suggestAndStopEndTime);
		if (!Collision.checkCircularCollision(id.getX(), id.getY(),
				IceDrow.img1.getWidth() / 4, IceDrow.img1.getHeight(), id
						.getS().getY() * 60 + 17, id.getS().getX() * 60 + 11,
				id.getS().getSrc().getWidth() / 3, id.getS().getSrc()
						.getHeight())
				&& id.getIndex() == 0) {
			if (id.getFirst() == 0) {
				id.set_x(id.getX() - (id.getS().getY() * 60 + 17));
				id.set_y(id.getY() - (id.getS().getX() * 60 + 11));
				id.setFirst(1);
				id.setXx(id.get_x() / 6);
				id.setYy(id.get_y() / 6);
			}
			if (!stopState && !isSuggest) {
				id.setX(id.getX() - id.getXx());
				id.setY(id.getY() - id.getYy());
			}
			g.drawRegion(IceDrow.img1, 0, 0, IceDrow.img1.getWidth() / 4,
					IceDrow.img1.getHeight(), 0, id.getX(), id.getY(), 20);
			kk++;
		} else if (Collision.checkCircularCollision(id.getX(), id.getY(),
				IceDrow.img1.getWidth() / 4, IceDrow.img1.getHeight(), id
						.getS().getY() * 60 + 17, id.getS().getX() * 60 + 11,
				id.getS().getSrc().getWidth() / 3, id.getS().getSrc()
						.getHeight())
				&& id.getIndex() < 4) {
			g.drawRegion(IceDrow.img1,
					IceDrow.img1.getWidth() / 4 * id.getIndex(), 0,
					IceDrow.img1.getWidth() / 4, IceDrow.img1.getHeight(), 0,
					id.getS().getY() * 60 + 19, id.getS().getX() * 60 + 35, 20);
			if (!stopState && !isSuggest) {
				id.setIndex(id.getIndex() + 1);
			}
			kk++;
		} else {
			if (System.currentTimeMillis() - id.getStartTime() < IceDrow.lastTime * 1000) {
				g.drawImage(IceDrow.img2, id.getS().getY() * 60 + 19, id.getS()
						.getX() * 60 + 35, 20);
				kk++;
			} else {
				id.getS().setIceNoMove(false);
				ca.moveArray();
				IceDrowVector.removeElement(id);
			}
		}
		return kk;
	}

	public void monster12MakeHeroDefenceDown() {
		hero.setDefenceCoefficient(0.5f);
		hero.setNegativeTime(System.currentTimeMillis());
	}

	public void monster13MakeMyselfTimeDecrease() {
		Enumeration e = monsterVector.elements();
		while (e.hasMoreElements()) {
			Monster m = (Monster) e.nextElement();
			long addTime;
			if (m.getBoold() != 0) {
				addTime = m.getEndTime() - m.getStartTime() - m.getWaitTime()
						- m.getSkillWaitTime() * 1000;
				if (addTime <= -5000)
					m.setStartTime(m.getStartTime() + alertSumTime - 5000);
				else if (addTime > -5000 & addTime <= 0)
					m.setStartTime(m.getStartTime() + alertSumTime - addTime);
			}
		}
	}

	public void loop() {
		draw();
		alertSumTime = 0;
		handleKey(keyState);
		if (isDebugMode()) {
			addDebugUserMessage("debug模式1键可以加钱！");
		}
	}

	public void draw() {
		g.setColor(0, 0, 0);
		g.fillRect(0, 0, getWidth(), getHeight());
		if (page.equals(Resource.PAGE_INDEX[0])
				|| page.equals(Resource.PAGE_INDEX[1])) {
			if (mainIndex != 20)
				drawMain();
			else
				drawNewGuide();
		} else if (page.equals(Resource.PAGE_INDEX[2])) {
			drawGame();
			addNengliang();
		}
		if (isUnfoldAttainment) {
			drawUnfoldAttainment(UnfoldAttainmentIndex);
		}
	}

	public void recursion(Soldier[] s1, int index, Soldier[] s2, int count,
			int length) {
		if (s1[index].getX() + 1 == s2[count + 1].getX()) {
			for (int k = 0; k < length; k++) {
				if (Soldier.equal(s1[k], s2[count + 1])) { // s1[k].equal(s2[count
															// + 1])
					break;
				} else if (k == length - 1) {
					s1[++index] = s2[count + 1];
					length++;
					break;
				}
			}
		} else if (s1[index].getX() == s2[count + 1].getX()
				&& s1[index].getY() + 1 == s2[count + 1].getY()) {
			for (int k = 0; k < length; k++) {
				if (Soldier.equal(s1[k], s2[count + 1])) {
					break;
				} else if (k == length - 1) {
					s1[++index] = s2[count + 1];
					length++;
					break;
				}
			}
		} else if (s1[index].getX() == s2[count + 1].getX()
				&& s1[index].getY() - 1 == s2[count + 1].getY()) {
			for (int k = 0; k < length; k++) {
				if (Soldier.equal(s1[k], s2[count + 1])) {
					break;
				} else if (k == length - 1) {
					s1[++index] = s2[count + 1];
					length++;
					break;
				}
			}
		} else {

		}
	}

	public void exchange(Soldier idPic1, Soldier idPic2) {
		int x1 = idPic1.getX();
		int y1 = idPic1.getY();
		Image img1 = idPic1.getSrc();
		int x2 = idPic2.getX();
		int y2 = idPic2.getY();
		Image img2 = idPic2.getSrc();
		idPic2.setX(x1);
		idPic2.setY(y1);
		idPic2.setSrc(img1);
		idPic[x1][y1] = idPic2;
		idPic1.setX(x2);
		idPic1.setY(y2);
		idPic1.setSrc(img2);
		idPic[x2][y2] = idPic1;
	}

	public void handleKey(KeyState key) {
		if (page == Resource.PAGE_INDEX[0]) {
			if (key.containsAndRemove(KeyCode.OK)) {
				pm = new PropManager(this);
//				pm.queryProps();
				sag = new SaveAndGet(this);
				my = new Myself();
				sag.readRecord();
				if (SaveAndGet.isFirstGame) {
					mainIndex = 20;
					newGuideIndex = 1;
					page = Resource.PAGE_INDEX[1];
				} else {
					mainIndex = 0;
					isHelp = false;
					page = Resource.PAGE_INDEX[1];
				}
			}
		} else if (page == Resource.PAGE_INDEX[1]) {
			if (mainIndex == 20) {
				handleNewGuide(key);
			} else if (mainIndex == 0)
				handleMainKey0(key);
			else if (mainIndex == 1)
				handleMainKey1(key);
			else if (mainIndex == 2)
				handleMainKey2(key);
			else if (mainIndex == 3)
				handleMainKey3(key);
			else if (mainIndex == 4)
				handleMainKey4(key);
			else if (mainIndex == 6)
				handleRewardKey(key);
			else if (mainIndex == 7)
				handleMainKey7(key);
			else if (mainIndex == 8)
				handleMainKey8(key);
			else if (mainIndex == 12)
				handleMainKey12(key);
		} else if (page == Resource.PAGE_INDEX[2]) {
			if (gameIndex == 0)
				handleGameKey(key);
			else if (gameIndex == 1)
				handeGameOver1(key);
			else if (gameIndex == 2)
				handeGameOver2(key);
			else if (gameIndex == 3)
				handeStop(key);
			else if (gameIndex == 4)
				handeSuggest(key);
			else if (gameIndex == 8)
				handeGameOver8(key);
			else if (gameIndex == 9)
				handeGameOver9(key);
		}
	}

	private void handeGameOver9(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (WinAndFailIndex == 1) {
				PopupConfirm pc = UIResource.getInstance()
						.buildDefaultPopupConfirm();
				pc.setText("是否花费" + pm.props[13].getPrice() + "TV币购买复活道具？");
				alertTime = System.currentTimeMillis();
				if (pc.popup() == 0) {
					boolean flag = pm.buyProp(148, 1, g);
					if (flag) {
						hero.setBoold(hero.getBoolds());
						gameIndex = 0;
						win1 = 0;
						stopState = false;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			} else if (WinAndFailIndex == 0) {
				isTongtianta = false;
				mainIndex = 0;
				gameIndex = 0;
				stopState = false;
				isEnhanceBoold = false;
				isEnhanceArmor = false;
				isEnhanceSoldierATK = false;
				Soldier.setAtkCoefficient(1.0f);
				page = Resource.PAGE_INDEX[1];
				mapIndexOfIndex = 0;
				stopState = false;
				clearGameImg();
				loadMainImg();
				changeLeaderOfProperty(tongtiantaMoney / 2, tongtiantaExp / 2);
				tongtiantaExp = 0;
				tongtiantaMoney = 0;
				Resource.count_c_t[1] = 0;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (WinAndFailIndex == 1) {
				WinAndFailIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (WinAndFailIndex == 0) {
				WinAndFailIndex = 1;
			}
		}
	}

	private void handeGameOver8(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (WinAndFailIndex == 1) {
				tongtiantaAndNormalSmallGuanqia++;
				if (tongtiantaAndNormalSmallGuanqia == 10) {
					tongtiantaAndNormalBigGuanqia++;
					tongtiantaAndNormalSmallGuanqia = 0;
				}
				if (tongtiantaIndex == 0) {
					if (0 < Resource.guanqiaLevel[tempFloor]) {
						if (Resource.tongtiantafloor <= tempFloor) {
							Resource.tongtiantafloor = tempFloor;
						}
						startEnertGame();
					} else {
						PopupText pt = UIResource.getInstance()
								.buildDefaultPopupText();
						pt.setText("更高层还没有解锁,请解锁后再继续冲击！");
						alertTimeFn(pt);
					}
				} else if (tongtiantaIndex == 1) {
					if (Resource.guanqiaLevel[Resource.tongtiantafloor] > 0) {
						startEnertGame();
					} else {
						PopupText pt = UIResource.getInstance()
								.buildDefaultPopupText();
						pt.setText("更高层还没有解锁,请解锁后再继续冲击！");
						alertTimeFn(pt);
					}
				}
			} else if (WinAndFailIndex == 0) {
				isTongtianta = false;
				mainIndex = 0;
				isEnhanceBoold = false;
				isEnhanceArmor = false;
				isEnhanceSoldierATK = false;
				Soldier.setAtkCoefficient(1.0f);
				gameIndex = 0;
				page = Resource.PAGE_INDEX[1];
				mapIndexOfIndex = 0;
				stopState = false;
				clearGameImg();
				loadMainImg();
				changeLeaderOfProperty(tongtiantaMoney, tongtiantaExp);
				tongtiantaExp = 0;
				tongtiantaMoney = 0;
				Resource.count_c_t[1] = 0;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (WinAndFailIndex == 1) {
				WinAndFailIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (WinAndFailIndex == 0) {
				WinAndFailIndex = 1;
			}
		}
	}

	private void handleMainKey12(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)
				|| key.containsAndRemove(KeyCode.NUM0)) {
			isHelp = false;
			mainIndex = 0;
		}
	}

	private void handeGameOver1(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (WinAndFailIndex == 0) {
				mainIndex = 1;
				isEnhanceBoold = false;
				isEnhanceArmor = false;
				isEnhanceSoldierATK = false;
				Soldier.setAtkCoefficient(1.0f);
				gameIndex = 0;
				page = Resource.PAGE_INDEX[1];
				mapIndexOfIndex = 0;
				stopState = false;
				clearGameImg();
				loadMainImg();
			} else {
				PopupConfirm pc = UIResource.getInstance()
						.buildDefaultPopupConfirm();
				pc.setText("是否花费" + pm.props[13].getPrice() + "TV币购买复活道具？");
				alertTime = System.currentTimeMillis();
				if (pc.popup() == 0) {
					boolean flag = pm.buyProp(148, 1, g);
					if (flag) {
						hero.setBoold(hero.getBoolds());
						gameIndex = 0;
						win1 = 0;
						stopState = false;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (WinAndFailIndex == 1) {
				WinAndFailIndex = 0;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (WinAndFailIndex == 0) {
				WinAndFailIndex = 1;
			}
		}
	}

	private void handeGameOver2(KeyState key) {
		if (mayEnterButton && key.containsAndRemove(KeyCode.OK)) {
			win1 = 0;
			mainIndex = 1;
			gameIndex = 0;
			isEnhanceBoold = false;
			isEnhanceArmor = false;
			isEnhanceSoldierATK = false;
			Soldier.setAtkCoefficient(1.0f);
			page = Resource.PAGE_INDEX[1];
			mapIndexOfIndex = 0;
			stopState = false;
			isDoubleExp = false;
			isDoubleMoney = false;
			clearGameImg();
			loadMainImg();
			if (UnfoldAttainmentIndex != -1) {
				if (Resource.isFinishAttainment[UnfoldAttainmentIndex] != 1) {
					attainmentPanelStartTime = System.currentTimeMillis();
					isUnfoldAttainment = true;
					my.setMoney(my.getMoney()
							+ Resource.AttainmentMoney[UnfoldAttainmentIndex]);
					Resource.isFinishAttainment[UnfoldAttainmentIndex] = 1;
				}
				if (tempStar == 3) {
					for (int i = 0; i < 10; i++) {
						if (Resource.guanqiaLevel[(tongtiantaAndNormalBigGuanqia - 1)
								* 10 + i] != 3)
							break;
						else if (i == 9) {
							UnfoldAttainmentIndex = tongtiantaAndNormalBigGuanqia - 1 + 13;
							if (Resource.isFinishAttainment[tongtiantaAndNormalBigGuanqia - 1 + 13] != 1) {
								attainmentPanelStartTime = System
										.currentTimeMillis();
								isUnfoldAttainment = true;
								my.setMoney(my.getMoney()
										+ Resource.AttainmentMoney[UnfoldAttainmentIndex]);
								Resource.isFinishAttainment[UnfoldAttainmentIndex] = 1;
							}
						}
					}
				}
			}
			mainPageIndex[1]++;
			tongtiantaAndNormalSmallGuanqia++;
			if (mainPageIndex[1] == 10) {
				mainPageIndex[0]++;
				tongtiantaAndNormalBigGuanqia++;
				mainPageIndex[1] = 0;
				tongtiantaAndNormalSmallGuanqia = 0;
				if (mainPageIndex[0] == 5) {
					mainPageIndex[0] = 4;
					tongtiantaAndNormalBigGuanqia = 4;
					mainPageIndex[1] = 9;
					tongtiantaAndNormalSmallGuanqia = 9;
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("你已经完成了所有关卡！");
					alertTimeFn(pt);
				}
			}

		}
	}

	private void handeStop(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (stopIndex == 0) {
				stopState = false;
				gameIndex = 0;
			} else if (stopIndex == 1) {
				isEnhanceBoold = false;
				isEnhanceArmor = false;
				isEnhanceSoldierATK = false;
				Soldier.setAtkCoefficient(1.0f);
				startEnertGame();
			} else if (stopIndex == 2) {
				if (isTongtianta) {
					Resource.count_c_t[1] = 0;
					changeLeaderOfProperty(tongtiantaMoney / 2,
							tongtiantaExp / 2);
					tongtiantaExp = 0;
					tongtiantaMoney = 0;
				}
				mainIndex = 1;
				isEnhanceBoold = false;
				isEnhanceArmor = false;
				isEnhanceSoldierATK = false;
				Soldier.setAtkCoefficient(1.0f);
				page = Resource.PAGE_INDEX[1];
				clearGameImg();
				loadMainImg();
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (!isTongtianta) {
				if (stopIndex > 0) {
					stopIndex--;
				}
			} else {
				if (stopIndex == 0) {
					stopIndex = 2;
				} else if (stopIndex == 2) {
					stopIndex = 0;
				}
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (!isTongtianta) {
				if (stopIndex < 2) {
					stopIndex++;
				}
			} else {
				if (stopIndex == 0) {
					stopIndex = 2;
				} else if (stopIndex == 2) {
					stopIndex = 0;
				}
			}
		}
	}

	private void handeSuggest(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (suggestIndex == 0) {
				if (Resource.goodsNums[7] == 0) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否花费" + pm.props[7].getPrice() + "TV币购买道具");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(142, 1, g);
						if (flag) {
							PlayerProp props = pm.getPropById(142);
							props.setNums(props.getNums() + 1);
							heroStateLength++;
							isEnhanceSoldierATK = true;
							if (isEnhanceSoldierATK) {
								drawUseProp8();
							}
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else {
					heroStateLength++;
					isEnhanceSoldierATK = true;
					Resource.goodsNums[7]--;
					if (isEnhanceSoldierATK) {
						drawUseProp8();
					}
				}
			} else if (suggestIndex == 1) {
				if (Resource.goodsNums[8] == 0) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否花费" + pm.props[8].getPrice() + "TV币购买道具");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(143, 1, g);
						if (flag) {
							PlayerProp props = pm.getPropById(143);
							props.setNums(props.getNums() + 1);
							heroStateLength++;
							isEnhanceArmor = true;
							if (isEnhanceArmor) {
								drawUseProp9();
							}
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else {
					heroStateLength++;
					isEnhanceArmor = true;
					Resource.goodsNums[8]--;
					if (isEnhanceArmor) {
						drawUseProp9();
					}
				}
			} else if (suggestIndex == 2) {
				if (Resource.goodsNums[9] == 0) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否花费" + pm.props[9].getPrice() + "TV币购买道具");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(144, 1, g);
						if (flag) {
							PlayerProp props = pm.getPropById(144);
							props.setNums(props.getNums() + 1);
							heroStateLength++;
							isEnhanceBoold = true;
							if (isEnhanceBoold) {
								drawUseProp10();
							}
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else {
					heroStateLength++;
					isEnhanceBoold = true;
					Resource.goodsNums[9]--;
					if (isEnhanceBoold) {
						drawUseProp10();
					}
				}
			} else if (suggestIndex == 3) {
				if (Resource.goodsNums[10] == 0) {
					PopupConfirm pc = UIResource.getInstance()
							.buildDefaultPopupConfirm();
					pc.setText("是否花费" + pm.props[10].getPrice() + "TV币购买道具");
					alertTime = System.currentTimeMillis();
					if (pc.popup() == 0) {
						boolean flag = pm.buyProp(145, 1, g);
						if (flag) {
							PlayerProp props = pm.getPropById(145);
							props.setNums(props.getNums() + 1);
							drawUseProp11();
						}
					}
					alertSumTime = System.currentTimeMillis() - alertTime;
				} else {
					Resource.goodsNums[10]--;
					drawUseProp11();
				}
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (suggestIndex > 0) {
				suggestIndex--;
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (suggestIndex < 3) {
				suggestIndex++;
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			isSuggest = false;
			gameIndex = 0;
			new AutomaticRemove().start();
		}
	}

	PopupConfirm pcGame;

	private void handleGameKey(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK) && state) {
			if (indexSelect == -1) {
				indexSelect = index;
			} else if (indexSelect != -1) {
				indexSelect = -1;
			}
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (indexSelect == -1) {
				if (index % 4 == 0)
					index += 3;
				else
					index--;
			} else if (indexSelect != -1) {
				if (index % 4 == 0) {
					return;
				} else {
					int x = (int) (index / 4);
					int y = (int) (index % 4);
					if (idPic[x][y] == null || idPic[x][y - 1] == null) {
						indexSelect = -1;
						return;
					}
					if (idPic[x][y].isIceNoMove()
							|| idPic[x][y - 1].isIceNoMove()) {
						indexSelect = -1;
						return;
					}
					idPic[x][y].setMove(true);
					indexSelect = -1;
					AnimationThread at = new AnimationThread(KeyCode.LEFT,
							idPic[x][y], idPic[x][y - 1]);
					at.start();
				}
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (indexSelect == -1) {
				if (index % 4 == 3)
					index -= 3;
				else
					index++;
			} else if (indexSelect != -1) {
				if (index % 4 == 3) {
					return;
				} else {
					int x = (int) (index / 4);
					int y = (int) (index % 4);
					if (idPic[x][y] == null || idPic[x][y + 1] == null) {
						indexSelect = -1;
						return;
					}
					if (idPic[x][y].isIceNoMove()
							|| idPic[x][y + 1].isIceNoMove()) {
						indexSelect = -1;
						return;
					}
					idPic[x][y].setMove(true);
					indexSelect = -1;
					AnimationThread at = new AnimationThread(KeyCode.RIGHT,
							idPic[x][y], idPic[x][y + 1]);
					at.start();
				}
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			if (indexSelect == -1) {
				if (index < 4)
					index += 24;
				else
					index -= 4;
			} else if (indexSelect != -1) {
				if (index < 4) {
					return;
				} else {
					int x = (int) (index / 4);
					int y = (int) (index % 4);
					if (idPic[x][y] == null || idPic[x - 1][y] == null) {
						indexSelect = -1;
						return;
					}
					if (idPic[x][y].isIceNoMove()
							|| idPic[x - 1][y].isIceNoMove()) {
						indexSelect = -1;
						return;
					}
					idPic[x][y].setMove(true);
					indexSelect = -1;
					AnimationThread at = new AnimationThread(KeyCode.UP,
							idPic[x][y], idPic[x - 1][y]);
					at.start();
				}
			}
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			if (indexSelect == -1) {
				if (index > 23)
					index -= 24;
				else
					index += 4;
			} else if (indexSelect != -1) {
				if (index > 23) {
					return;
				} else {
					int x = (int) (index / 4);
					int y = (int) (index % 4);
					if (idPic[x][y] == null || idPic[x + 1][y] == null) {
						indexSelect = -1;
						return;
					}
					if ((idPic[x][y].isIceNoMove())
							|| idPic[x + 1][y].isIceNoMove()) {
						indexSelect = -1;
						return;
					}
					idPic[x][y].setMove(true);
					indexSelect = -1;
					AnimationThread at = new AnimationThread(KeyCode.DOWN,
							idPic[x][y], idPic[x + 1][y]);
					at.start();
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			stopState = true;
			gameIndex = 3;
			stopIndex = 0;
			suggestAndStopStartTime = System.currentTimeMillis();
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (Resource.goodsNums[0] > 0) {
				Resource.goodsNums[0]--;
				useProp[0] = 1;
			} else {
				pcGame = UIResource.getInstance().buildDefaultPopupConfirm();
				pcGame.setText("是否花费" + pm.props[0].getPrice() + "TV币购买血瓶道具？");
				alertTime = System.currentTimeMillis();
				if (pcGame.popup() == 0) {
					boolean flag = pm.buyProp(135, 1, g);
					if (flag) {
						useProp[0] = 1;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			}
		} else if (key.containsAndRemove(KeyCode.NUM2)) {
			if (Resource.goodsNums[1] > 0) {
				Resource.goodsNums[1]--;
				useProp[1] = 2;
				prop2Index = 0;
			} else {
				pcGame = UIResource.getInstance().buildDefaultPopupConfirm();
				pcGame.setText("是否花费" + pm.props[1].getPrice() + "TV币购买火球术道具？");
				alertTime = System.currentTimeMillis();
				if (pcGame.popup() == 0) {
					boolean flag = pm.buyProp(136, 1, g);
					if (flag) {
						useProp[1] = 2;
						prop2Index = 0;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			}
		} else if (key.containsAndRemove(KeyCode.NUM3)) {
			if (Resource.goodsNums[2] > 0) {
				Resource.goodsNums[2]--;
				prop3StartTime = System.currentTimeMillis();
				useProp[2] = 3;
				soldierATkTimes = 2;
				heroStateLength++;
				isDoubleAtk = true;
			} else {
				pcGame = UIResource.getInstance().buildDefaultPopupConfirm();
				pcGame.setText("是否花费" + pm.props[2].getPrice() + "TV币购买狂暴术道具？");
				alertTime = System.currentTimeMillis();
				if (pcGame.popup() == 0) {
					boolean flag = pm.buyProp(137, 1, g);
					if (flag) {
						prop3StartTime = System.currentTimeMillis();
						useProp[2] = 3;
						soldierATkTimes = 2;
						heroStateLength++;
						isDoubleAtk = true;
					}
				}
				alertSumTime = System.currentTimeMillis() - alertTime;
			}
		} else if (key.containsAndRemove(KeyCode.NUM5)) {
			if (hero.getMagic() == 100) {
				if (hero.getKind() == 0)
					auto0Skill();
				else if (hero.getKind() == 1)
					auto0Skill();
				else if (hero.getKind() == 2)
					auto0Skill();
				else if (hero.getKind() == 3)
					auto3Skill();
				else if (hero.getKind() == 4)
					auto4Skill();
				else if (hero.getKind() == 5) {
					auto5Skill();
					auto3Skill();
				}
				if (!isNowHeroSay) {
					randomHeroSayIndex = 0;
					randomHeroSayLocaltion = RandomValue.getRandInt(0, 9);
					isNowHeroSay = true;
				}
			}
		} else if (key.containsAndRemove(KeyCode.NUM4)) {
			if (isDebugMode()) {
				hero.setMagic(100, 0);
			}
		}
	}

	private void drawHeroSay() {
		if (randomHeroSayIndex * 10 < 640) {
			if (!stopState && !isSuggest)
				randomHeroSayIndex++;
			g.drawRegion(img[temp_img_distance2 + 82], 0,
					randomHeroSayLocaltion * 22, 359, 22, 0,
					randomHeroSayIndex * 20, 240, 20);
		} else {
			isNowHeroSay = false;
			randomHeroSayIndex = 0;
		}
	}

	private void drawSoldierSay() {
		if (randomSoldierSayIndex * 10 < 640) {
			if (!stopState && !isSuggest)
				randomSoldierSayIndex++;
			g.drawRegion(img[temp_img_distance2 + 83], 0,
					randomSoldierSayLocaltion * 51, 318, 51, 0,
					randomSoldierSayIndex * 20, 160, 20);
		} else {
			isNowSoldierSay = false;
			randomSoldierSayIndex = 0;
		}
	}

	public boolean collision(Soldier s, Monster m) {
		if (((tongtiantaAndNormalSmallGuanqia == 4 || tongtiantaAndNormalSmallGuanqia == 9)
				&& mapIndexOfIndex == 4 && m.getY() == 1 && m.getX() == 2 && (s
				.getX() == 2 || s.getX() - 1 == 2 || s.getX() - 2 == 2))
				|| s.getX() == m.getX()) {
			if (s.getOffX() + s.getY() * 60 + 17 >= 385 + m.getY() * 60
					&& s.getOffX() + s.getY() * 60 + 17 <= 445 + m.getY() * 60) {
				return true;
			}
		}
		return false;
	}

	class AnimationThread extends Thread {

		int exchange = 1;
		int keyCode;
		Soldier idPic1;
		Soldier idPic2;
		int offX1 = 0;
		int offX2 = 0;

		public AnimationThread(int keyCode, Soldier idPic1, Soldier idPic2) {
			this.keyCode = keyCode;
			this.idPic1 = idPic1;
			this.idPic2 = idPic2;
		}

		public void run() {
			while (idPic1.isMove()) {
				if (keyCode == KeyCode.LEFT) {
					if (offX1 == -55 && exchange == 1) {
						moveXElement1();
					} else if (exchange == 1) {
						moveSetXOff1();
					} else if (offX1 == 55 && exchange == 2) {
						moveXElement2();
					} else if (exchange == 2) {
						moveSetXOff2();
					}
					moveSleep();
				} else if (keyCode == KeyCode.RIGHT) {
					if (offX1 == 55 && exchange == 1) {
						moveXElement1();
					} else if (exchange == 1) {
						moveSetXOff2();
					} else if (offX1 == -55 && exchange == 2) {
						moveXElement2();
					} else if (exchange == 2) {
						moveSetXOff1();
					}
					moveSleep();
				} else if (keyCode == KeyCode.UP) {
					if (offX1 == -55 && exchange == 1) {
						moveYElement1();
					} else if (exchange == 1) {
						moveSetYOff1();
					} else if (offX1 == 55 && exchange == 2) {
						moveYElement2();
					} else if (exchange == 2) {
						moveSetYOff2();
					}
					moveSleep();
				} else if (keyCode == KeyCode.DOWN) {
					if (offX1 == 55) {
						moveYElement1();
					} else if (exchange == 1) {
						moveSetYOff2();
					} else if (offX1 == -55 && exchange == 2) {
						moveYElement2();
					} else if (exchange == 2) {
						moveSetYOff1();
					}
					moveSleep();
				}
			}
		}

		private void moveSetYOff2() {
			offX1 += 11;
			offX2 -= 11;
			idPic1.setOffY(offX1);
			idPic2.setOffY(offX2);
		}

		private void moveSetYOff1() {
			offX1 -= 11;
			offX2 += 11;
			idPic1.setOffY(offX1);
			idPic2.setOffY(offX2);
		}

		private void moveYElement2() {
			idPic1.setMove(false);
			idPic1.setOffY(0);
			idPic2.setOffY(0);
			exchange(idPic1, idPic2);
		}

		private void moveSleep() {
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void moveXElement2() {
			idPic1.setMove(false);
			idPic1.setOffX(0);
			idPic2.setOffX(0);
			exchange(idPic1, idPic2);
		}

		private void moveSetXOff2() {
			offX1 += 11;
			offX2 -= 11;
			idPic1.setOffX(offX1);
			idPic2.setOffX(offX2);
		}

		private void moveSetXOff1() {
			offX1 -= 11;
			offX2 += 11;
			idPic1.setOffX(offX1);
			idPic2.setOffX(offX2);
		}

		private void moveYElement1() {
			idPic1.setMove(false);
			offX1 = 0;
			offX2 = 0;
			idPic1.setOffY(offX1);
			idPic2.setOffY(offX2);
			exchange(idPic1, idPic2);
			if (!ca.sss()) {
				idPic1.setMove(true);
				exchange = 2;
			}
		}

		private void moveXElement1() {
			idPic1.setMove(false);
			offX1 = 0;
			offX2 = 0;
			idPic1.setOffX(offX1);
			idPic2.setOffX(offX2);
			exchange(idPic1, idPic2);
			if (!ca.sss()) {
				idPic1.setMove(true);
				exchange = 2;
			}
		}
	}

	class AutomaticRemove extends Thread {

		public void run() {
			ca.sss();
		}

	}

}
