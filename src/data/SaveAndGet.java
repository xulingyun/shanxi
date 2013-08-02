package data;

import java.util.Date;

import org.xmlpull.v1.XmlPullParserException;

import cn.ohyeah.stb.util.ConvertUtil;
import cn.ohyeah.stb.util.DateUtil;
import test.GameEngine;
import test.ItvGame;
import test.ItvGame.RespWapper;
import test.Resource;
import upgrade.Upgrade;

public class SaveAndGet {

	GameEngine engine;
	public static boolean result;
	public static boolean isFirstGame = true;

	public SaveAndGet(GameEngine engine) {
		this.engine = engine;
	}

	private String[] joinData() {
		String[] splitString = new String[2];
		splitString[0] = null;
		splitString[1] = null;
		splitString[0] = engine.my.getLevel() + ",";
		splitString[0] += engine.my.getExp() + ",";
		splitString[0] += engine.my.getMoney() + ",";
		splitString[0] += engine.my.getNengliang() + ",";
		int i;
		for (i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
			splitString[0] += Resource.heroAndSoldierLevel[i] + ",";
		}
		for (i = 0; i < Resource.guanqiaLevel.length; i++) {
			splitString[0] += Resource.guanqiaLevel[i] + ",";
		}
		for (i = 0; i < Resource.isBelongMyOfHero.length; i++) {
			splitString[0] += Resource.isBelongMyOfHero[i] + ",";
		}
		for (i = 0; i < Resource.goodsNums.length; i++) {
			splitString[0] += Resource.goodsNums[i] + ",";
		}
		for (i = 0; i < Resource.isFinishAttainment.length; i++) {
			splitString[1] += Resource.isFinishAttainment[i] + ",";
		}
		splitString[1] += Resource.tongtiantafloor + ",";
		if (!GameEngine.online) {
			long nowtime = System.currentTimeMillis();
			Resource.resumeNengliangTime = nowtime;
			splitString[1] += Resource.resumeNengliangTime + ",";
		}
		for (i = 0; i < Resource.count_c_t.length; i++) {
			splitString[1] += Resource.count_c_t[i] + ",";
		}
		if (isFirstGame) {
			splitString[1] += 1 + ",";
		} else {
			splitString[1] += 0 + ",";
		}
		for (i = 0; i < Resource.savaSelcetSoldier.length; i++) {
			splitString[1] += Resource.savaSelcetSoldier[i] + ",";
		}
		splitString[1] += Resource.saveSelectHero + ",";
		print();
		return splitString;
	}

	public void saveData() {
		ItvGame isave = new ItvGame();
		try {
			String[] ss = joinData();
			isave.crossSaveRecordMulty(ss[0], 0);
			isave.crossSaveRecordMulty(ss[1], 1);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	public void readRecord() {
		ItvGame iread = new ItvGame();

		String[] ss = new String[2];
		try {
			RespWapper rw = iread.crossQueryMulty(0);
			ss[0] = rw.get_message();
			rw = iread.crossQueryMulty(1);
			ss[1] = rw.get_message();
			splitData(ss);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	private void splitData(String[] ss) {
		String[][] sss = new String[2][];
		sss[0] = ConvertUtil.split(ss[0], ",");
		int i;
		int j;
		engine.my.setLevel(Integer.parseInt(sss[0][0]));
		engine.my.setExp(Integer.parseInt(sss[0][1]));
		engine.my.setMoney(Integer.parseInt(sss[0][2]));
		engine.my.setNengliang(Integer.parseInt(sss[0][3]));
		j = 4;
		for (i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
			Resource.heroAndSoldierLevel[i] = Byte.parseByte(sss[0][j + i]);
		}
		j += i;
		for (i = 0; i < Resource.guanqiaLevel.length; i++) {
			Resource.guanqiaLevel[i] = Byte.parseByte(sss[0][j + i]);
		}
		j += i;
		for (i = 0; i < Resource.isBelongMyOfHero.length; i++) {
			Resource.isBelongMyOfHero[i] = Byte.parseByte(sss[0][j + i]);
		}
		j += i;
		for (i = 0; i < Resource.goodsNums.length; i++) {
			Resource.goodsNums[i] = Byte.parseByte(sss[0][j + i]);
		}
		j = 0;
		for (i = 0; i < Resource.isFinishAttainment.length; i++) {
			Resource.isFinishAttainment[i] = Byte.parseByte(sss[1][j + i]);
		}
		j += i;
		Resource.tongtiantafloor = Byte.parseByte(sss[1][j++]);
		Resource.resumeNengliangTime = Long.parseLong(sss[1][j++]);
		for (i = 0; i < Resource.count_c_t.length; i++) {
			Resource.count_c_t[i] = Byte.parseByte(sss[1][j + i]);
		}
		j += i;
		if (Byte.parseByte(sss[1][j++]) == 0) {
			isFirstGame = false;
		} else {
			isFirstGame = true;
		}
		for (i = 0; i < Resource.savaSelcetSoldier.length; i++) {
			Resource.savaSelcetSoldier[i] = Byte.parseByte(sss[1][j + i]);
		}
		j += i;
		Resource.saveSelectHero = Byte.parseByte(sss[1][j]);
		long nowTime = System.currentTimeMillis();
		long timeSum = nowTime - Resource.resumeNengliangTime;
		engine.my.setNengliang(engine.my.getNengliang()
				+ (int) (timeSum / 1000 / 60 / 30));
		if (engine.my.getNengliang() > Upgrade.upgradeLeaderNengliang(engine.my
				.getLevel())) {
			engine.my.setNengliang(Upgrade.upgradeLeaderNengliang(engine.my
					.getLevel()));
		}
		if (DateUtil.isSameDay(new Date(Resource.resumeNengliangTime),
				new Date(nowTime))) {
			Resource.count_c_t[0] = 1;
			Resource.count_c_t[1] = 1;
		}
		print();
	}

	public void print() {
		System.out.println("engine.my.getLevel():" + engine.my.getLevel());
		System.out.println("engine.my.getExp():" + engine.my.getExp());
		System.out.println("engine.my.getMoney():" + engine.my.getMoney());
		System.out.println("engine.my.getNengliang():"
				+ engine.my.getNengliang());
		for (int i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
			System.out.println("Resource.heroAndSoldierLevel:"
					+ Resource.heroAndSoldierLevel[i]);
		}
		for (int i = 0; i < Resource.guanqiaLevel.length; i++) {
			System.out.println("Resource.guanqiaLevel:"
					+ Resource.guanqiaLevel[i]);
		}
		for (int i = 0; i < Resource.isBelongMyOfHero.length; i++) {
			System.out.println("Resource.isBelongMyOfHero:"
					+ Resource.isBelongMyOfHero[i]);
		}
		for (int i = 0; i < Resource.goodsNums.length; i++) {
			System.out.println("Resource.goodsNums:" + Resource.goodsNums[i]);
		}
		for (int i = 0; i < Resource.isFinishAttainment.length; i++) {
			System.out.println("Resource.isFinishAttainment:"
					+ Resource.isFinishAttainment[i]);
		}
		System.out.println("Resource.tongtiantafloor:"
				+ Resource.tongtiantafloor);
		System.out.println("Resource.resumeNengliangTime:"
				+ Resource.resumeNengliangTime);
		for (int i = 0; i < Resource.count_c_t.length; i++) {
			System.out.println("Resource.count_c_t:" + Resource.count_c_t[i]);
		}
		System.out.println("isFirstGame:" + isFirstGame);
	}
}
