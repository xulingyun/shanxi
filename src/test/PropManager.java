package test;

import cn.ohyeah.itvgame.shanxi.Define;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.DrawPopupText;
import cn.ohyeah.stb.ui.PopupPrompt;

public class PropManager {
	
	public boolean isBuySuccess = false;
	public PlayerProp[] props;
	GameEngine engine;
	private int[] propIds = { 136, 137, 138, 139, 140, 141, 142, 143, 144, 145,
			146, 147, 148, 149, 150 };
	private String[] propCode = { "HJ106", "HJ107", "HJ108", "HJ109", "HJ110",
			"HJ111", "HJ112", "HJ113", "HJ114", "HJ115", "HJ116", "HJ117",
			"HJ118", "HJ119", "HJ120" };
	private int[] price = { 300, 300, 100, 300, 300, 300, 100, 300, 300, 300,
			300, 200, 100, 300, 300 };
	private String name[] = { "治疗药剂", "火球术", "狂暴术", "双倍经验卡", "双倍金币卡", "能量石",
			"保护符文", "军团之力", "刚性护符", "生命谐音", "金币礼包", "抽奖", "加速挂机", "复活", "无尽之匙" };
	private String desc[] = { "恢复英雄40%的HP。（战斗中使用）", "使敌人损失30%的HP。（战斗中使用）",
			"士兵的攻击力翻倍。（30秒）（战斗中使用）", "战斗胜利获得的经验翻倍。", "战斗胜利获得的金币翻倍。",
			"使用后增加20点能量。", "通天塔战斗失败避免损失。", "增加所有士兵10%攻击力。", "增加英雄20点防御力。",
			"增加英雄10%生命。", "兑换10000金币。", "重新抽奖。", "加快挂机的速度", "战斗复活", "可以继续去无极之塔" };

	public PropManager(GameEngine e) {
		this.engine = e;
	}

	/* 查询玩家道具 */
	public void queryProps() {
		initProps(props);
		// try {
		// for (int j = 0; j < props.length; j++) {
		// props[j].setNums(engine.pm.props[j].getNums());
		// }
		// } catch (Exception e) {
		// initProps(props);
		// }
		printInfo();
	}

	public void printInfo() {
		for (int i = 0; i < props.length; i++) {
			System.out.println("道具ID==" + props[i].getPropId());
			System.out.println("道具数量==" + props[i].getNums());
		}
	}

	public void initProps(PlayerProp[] props2) {
		props = new PlayerProp[15];
		System.out.println("创建道具数据并初始化道具信息,size:" + props.length);
		for (int i = 0; i < props.length; i++) {
			PlayerProp prop = new PlayerProp();
			prop.setPropId(propIds[i]);
			prop.setName(name[i]);
			prop.setPrice(price[i]);
			prop.setId(i);
			prop.setNums(0);
			prop.setDesc(desc[i]);
			prop.setFeeCode(0);
			prop.setPropCode(propCode[i]);
			props[i] = prop;
		}

		for (int m = 0; m < props.length; m++) {
			System.out.println("propId:" + props[m].getPropId() + ", price:"
					+ props[m].getPrice() + ", name:" + props[m].getName());
		}
	}

	/* 根据道具ID查询该道具数量 */
	public PlayerProp getPropById(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				return props[i];
			}
		}
		return null;
	}

	public int getPropNumsById(int id) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == id) {
				return props[i].getNums();
			}
		}
		return 0;
	}

	public int getPriceById(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				return props[i].getPrice();
			}
		}
		return 0;
	}

	public String getNameById(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				return props[i].getName();
			}
		}
		return null;
	}

	public void addPropNum(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				props[i].setNums(props[i].getNums() + 1);
			}
		}
	}

	public void reducePropNum(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				props[i].setNums(props[i].getNums() - 1);
			}
		}
	}

	public boolean buyProp(int propId, int propCount, SGraphics g) {
		isBuySuccess = false;
		if (GameCanvasEngine.isConnected) {
			PlayerProp pp = getPropById(propId);
			engine.iptv_link.returnInfo = "";
			engine.iptv_link.result = -1;
			engine.iptv_link.UseMoney(pp.getPrice(), "1", 0);
			DrawPopupText dpt = UIResource.getInstance()
					.buildDefaultDrawPopupText();
			engine.waitTime();
			if (engine.iptv_link.result == 0) {
				addPropNum(propId);
				if (propId == 146) {
					engine.my.setMoney(engine.my.getMoney() + 10000);
					engine.pm.props[10].reduceNums();
				}
				engine.iptv_link.result = -1;
				isBuySuccess = true;
				dpt.setText("购买" + pp.getName() + "成功");
			} else {
				dpt.setText(Define.getErrorInfo(Integer
						.parseInt(engine.iptv_link.returnInfo)));
			}
			dpt.popup();
			return (engine.iptv_link.result == 0);
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
			// disConnected = true;
			return false;
		}
	}

	/* 道具信息 */
	public String setPropDatas() {
		String datas = "";
		for (int i = 0; i < props.length; i++) {
			datas += props[i].getNums();
			if (i != props.length - 1) {
				datas += "|";
			}
		}
		return datas;
	}
}
