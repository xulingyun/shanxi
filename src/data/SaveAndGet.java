package data;

import java.util.Date;

import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupPrompt;
import cn.ohyeah.stb.util.ConvertUtil;
import cn.ohyeah.stb.util.DateUtil;
import test.GameEngine;
import test.PropManager;
import test.Resource;
import upgrade.Upgrade;

public class SaveAndGet {

	static GameEngine engine;
	static PropManager pm;
	public static boolean result;
	public static boolean isFirstGame = true;

	public SaveAndGet(GameEngine engine, PropManager pm) {
		SaveAndGet.engine = engine;
		SaveAndGet.pm = pm;
	}

	private static SaveAndGet gameRecord;
	long nowtime;

	public static SaveAndGet getInstance() {
		if (gameRecord == null) {
			gameRecord = new SaveAndGet(engine, pm);
		}
		return gameRecord;
	}

	public boolean readRecord() {
		try {
			if (GameCanvasEngine.isConnected) {
				String[] str = { "", "", "", "" };
				engine.iptv_link.GetParamEx("1");
				str[0] = engine.iptv_link.returnSaveInfo[0];
				engine.iptv_link.GetParamEx("2");
				str[1] = engine.iptv_link.returnSaveInfo[1];
				engine.iptv_link.GetParamEx("3");
				str[2] = engine.iptv_link.returnSaveInfo[2];
				engine.iptv_link.GetParamEx("4");
				str[3] = engine.iptv_link.returnSaveInfo[3];
				if (str[0] == null || str[1] == null || str[2] == null
						|| str[3] == null) {
					/**
					 * 多线程模式下，如果接口数据还没返回，让主线程 睡眠3秒，等待数据返回
					 */
					Thread.sleep(3000);
				}
				// for(int i=0;i<4;i++){
				// System.out.println("服务器返回的信息："+engine.iptv_link.returnSaveInfo[i]);
				// }
				str[0] = engine.iptv_link.returnSaveInfo[0].trim();
				str[1] = engine.iptv_link.returnSaveInfo[1].trim();
				str[2] = engine.iptv_link.returnSaveInfo[2].trim();
				str[3] = engine.iptv_link.returnSaveInfo[3].trim();
				if (str[3].length() < 1) {
					return false;
				} else {
					splitData(str);
					return true;
				}
			} else {
				PopupPrompt pp = UIResource.getInstance()
						.buildDefaultPopupPrompt();
				pp.setText("网络连接超时，请稍后重试！");
				pp.popup();
				/**
				 * 连接中断，退出游戏
				 */
				engine.setExit();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取游戏记录异常：" + e.getMessage());
			return false;
		}
	}

	private void splitData(String[] ss) {
		long guoquS;
		long nowTimeS;
		engine.iptv_link.GetSvrTime();
		engine.waitTime();
		nowTimeS = DateUtil.createTime(engine.iptv_link.returnInfo);
		String[][] sss = new String[4][60];
		sss[0] = ConvertUtil.split(ss[0], ",");
		sss[1] = ConvertUtil.split(ss[1], ",");
		sss[2] = ConvertUtil.split(ss[2], ",");
		sss[3] = ConvertUtil.split(ss[3], ",");

		int i = 0;
		int j = 0;
		if (Byte.parseByte(sss[0][i++].trim()) == 0) {
			isFirstGame = false;
		} else {
			isFirstGame = true;
		}
		Resource.tongtiantafloor = Integer.parseInt(sss[0][i++].trim());
		Resource.resumeNengliangTime = Long.parseLong(sss[0][i++].trim());
		engine.my.setLevel(Integer.parseInt(sss[0][i++].trim()));
		engine.my.setExp(Long.parseLong(sss[0][i++].trim()));
		engine.my.setMoney(Long.parseLong(sss[0][i++].trim()));
		engine.my.setNengliang(Integer.parseInt(sss[0][i++].trim()));
		engine.my.setCountAward(Integer.parseInt(sss[0][i++].trim()));
		engine.my.setCountTongtianta(Integer.parseInt(sss[0][i].trim()));

		for (i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
			Resource.heroAndSoldierLevel[i] = Byte.parseByte(sss[1][i].trim());
		}
		j += i;
		for (i = 0; i < Resource.savaSelcetSoldier.length; i++) {
			Resource.savaSelcetSoldier[i] = Byte
					.parseByte(sss[1][j + i].trim());
		}
		j += i;
		for (i = 0; i < Resource.isBelongMyOfHero.length; i++) {
			Resource.isBelongMyOfHero[i] = Byte.parseByte(sss[1][j + i].trim());
		}
		j += i;
		Resource.saveSelectHero = Byte.parseByte(sss[1][j].trim());

		i = 0;
		j = 0;
		for (i = 0; i < Resource.guanqiaLevel.length; i++) {
			Resource.guanqiaLevel[i] = Byte.parseByte(sss[2][i].trim());
		}
		i = 0;
		j = 0;
		for (i = 0; i < pm.props.length; i++) {
			pm.props[i].setNums(Byte.parseByte(sss[3][i].trim()));
		}

		j += i;
		for (i = 0; i < Resource.isFinishAttainment.length; i++) {
			Resource.isFinishAttainment[i] = Byte.parseByte(sss[3][j + i]
					.trim());
		}
		guoquS = Resource.resumeNengliangTime;
		if (DateUtil.isSameDay(new Date(nowTimeS), new Date(guoquS))) {
			engine.my.setCountAward(1);
			engine.my.setCountTongtianta(1);
		}
		int leaveTime = (int) ((nowTimeS - guoquS) / 1000 / 60 / 30);
		engine.my.setNengliang(engine.my.getNengliang() + leaveTime);
		if (engine.my.getNengliang() > Upgrade.upgradeLeaderNengliang(engine.my
				.getLevel())) {
			engine.my.setNengliang(Upgrade.upgradeLeaderNengliang(engine.my
					.getLevel()));
		}
		// print();
	}

	// public void print() {
	// System.out.println("engine.my.getLevel():" + engine.my.getLevel());
	// System.out.println("engine.my.getExp():" + engine.my.getExp());
	// System.out.println("engine.my.getMoney():" + engine.my.getMoney());
	// System.out.println("engine.my.getNengliang():"
	// + engine.my.getNengliang());
	// for (int i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
	// System.out.println("Resource.heroAndSoldierLevel:"
	// + Resource.heroAndSoldierLevel[i]);
	// }
	// for (int i = 0; i < Resource.guanqiaLevel.length; i++) {
	// System.out.println("Resource.guanqiaLevel:"
	// + Resource.guanqiaLevel[i]);
	// }
	// for (int i = 0; i < Resource.isBelongMyOfHero.length; i++) {
	// System.out.println("Resource.isBelongMyOfHero:"
	// + Resource.isBelongMyOfHero[i]);
	// }
	// for (int i = 0; i < Resource.goodsNums.length; i++) {
	// System.out.println("Resource.goodsNums:" + Resource.goodsNums[i]);
	// }
	// for (int i = 0; i < Resource.isFinishAttainment.length; i++) {
	// System.out.println("Resource.isFinishAttainment:"
	// + Resource.isFinishAttainment[i]);
	// }
	// System.out.println("Resource.tongtiantafloor:"
	// + Resource.tongtiantafloor);
	// System.out.println("Resource.resumeNengliangTime:"
	// + Resource.resumeNengliangTime);
	// System.out.println("engine.my.tong:" + engine.my.getCountTongtianta());
	// System.out.println("engine.my.Award:" + engine.my.getCountAward());
	// System.out.println("isFirstGame:" + isFirstGame);
	// }

	// public int queryCoin() {
	// ItvGame itvgame = new ItvGame();
	// try {
	// RespWapper respWapper = itvgame.goldQuery();
	// String balance = respWapper.get_goldCount();
	// if (balance != null && !balance.equals("")) {
	// GameEngine.balance = Integer.parseInt(balance);
	// }
	// System.out.println("balance:" + GameEngine.balance);
	// return GameEngine.balance;
	// } catch (Exception e) {
	// System.out.println("查询余额失败，原因:" + e.getMessage());
	// }
	// return 0;
	// }

	public void queryRankList() {
		// ItvGame itvgame = new ItvGame();
		// try {
		// int score = 0;
		// String rankNo = "";
		// RespWapper respWapper = itvgame.rankQuery();
		// if (respWapper.is_ret()) {
		// System.out.println("获取排行榜成功");
		// for (int i = 0; i < respWapper.getList().length; i++) {
		// System.out.println("用户账号" + respWapper.getList()[i].userId);
		// System.out.println("用户排名" + respWapper.getList()[i].rankNo);
		// System.out.println("用户积分" + respWapper.getList()[i].score);
		// if (respWapper.getList()[i].score == null
		// || respWapper.getList()[i].score.equals(""))
		// respWapper.getList()[i].score = 0 + "";
		// if (i == 0) {
		// score = Integer.parseInt(respWapper.getList()[i].score);
		// rankNo = respWapper.getList()[i].rankNo;
		// } else {
		// if (score < Integer
		// .parseInt(respWapper.getList()[i].score)) {
		// score = Integer
		// .parseInt(respWapper.getList()[i].score);
		// rankNo = respWapper.getList()[i].rankNo;
		// }
		// }
		// }
		// System.out.println("我的账号" + ItvGame.USER_ID);
		// System.out.println("我的排名" + respWapper.getMyRankNo());
		// System.out.println("我的积分" + respWapper.getMyScore());
		// if (respWapper.getMyScore() == null
		// || respWapper.getMyScore().equals(""))
		// respWapper.setMyScore(0 + "");
		//
		// if (score < Integer.parseInt(respWapper.getMyScore())) {
		// score = Integer.parseInt(respWapper.getMyScore());
		// rankNo = respWapper.getMyRankNo();
		// }
		// respWapper.getList()[0].score = score + "";
		// respWapper.getList()[0].rankNo = rankNo + "";
		// respWapper.getList()[1].score = respWapper.getMyScore();
		// respWapper.getList()[1].rankNo = respWapper.getMyRankNo();
		// }
		// return respWapper.getList();
		// } catch (Exception e) {
		// System.out.println("读取排行失败，原因：" + e.getMessage());
		// }
		// return null;
	}

	public void saveRecord() {
		if (GameCanvasEngine.isConnected) {
			String[] data = setRecordData();
			engine.iptv_link.SaveParam("1", data[0]);
			engine.iptv_link.SaveParam("2", data[1]);
			engine.iptv_link.SaveParam("3", data[2]);
			engine.iptv_link.SaveParam("4", data[3]);
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
		}
	}

	private String[] setRecordData() {
		engine.iptv_link.GetSvrTime();
		engine.waitTime();
		nowtime = DateUtil.createTime(engine.iptv_link.returnInfo);
		String[] splitString = new String[4];
		if (isFirstGame) {
			splitString[0] = 1 + ",";
		} else {
			splitString[0] = 0 + ",";
		}
		splitString[0] += Resource.tongtiantafloor + ",";
		splitString[0] += nowtime + ",";
		splitString[0] += engine.my.getLevel() + ",";
		splitString[0] += engine.my.getExp() + ",";
		splitString[0] += engine.my.getMoney() + ",";
		splitString[0] += engine.my.getNengliang() + ",";
		splitString[0] += engine.my.getCountAward() + ",";
		splitString[0] += engine.my.getCountTongtianta();
		int i;
		for (i = 0; i < Resource.heroAndSoldierLevel.length; i++) {
			if (i == 0)
				splitString[1] = Resource.heroAndSoldierLevel[i] + ",";
			else
				splitString[1] += Resource.heroAndSoldierLevel[i] + ",";
		}
		for (i = 0; i < Resource.savaSelcetSoldier.length; i++) {
			splitString[1] += Resource.savaSelcetSoldier[i] + ",";
		}
		for (i = 0; i < Resource.isBelongMyOfHero.length; i++) {
			splitString[1] += Resource.isBelongMyOfHero[i] + ",";
		}
		splitString[1] += Resource.saveSelectHero;

		for (i = 0; i < Resource.guanqiaLevel.length; i++) {
			if (i == 0)
				splitString[2] = Resource.guanqiaLevel[i] + ",";
			else
				splitString[2] += Resource.guanqiaLevel[i] + ",";
		}
		for (i = 0; i < pm.props.length; i++) {
			if (i == 0)
				splitString[3] = pm.props[i].getNums() + ",";
			else
				splitString[3] += pm.props[i].getNums() + ",";
		}
		for (i = 0; i < Resource.isFinishAttainment.length; i++) {
			if (i == Resource.isFinishAttainment.length - 1)
				splitString[3] += Resource.isFinishAttainment[i];
			else
				splitString[3] += Resource.isFinishAttainment[i] + ",";
		}
		return splitString;
	}

	public void queryCoin() {
		if (GameCanvasEngine.isConnected) {
			engine.iptv_link.GetMoney();
			try {
				String str = engine.iptv_link.returnInfo;
				if (str.equals("") || str == null) {
					/**
					 * 多线程模式下，如果接口数据还没返回，让主线程 睡眠3秒，等待数据返回
					 */
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				System.out.println("获取余额时解析出错：" + e.getMessage());
			}
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
		}
	}
}
