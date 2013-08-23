package test;

import javax.microedition.lcdui.Image;

import org.xmlpull.v1.XmlPullParserException;

import test.ItvGame.RespWapper;

import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupText;

public class Recharge {

	private int index;
	public static String price;
	public static final int WIDTH_HALF = 320;
	public static final int HEIGHT_HALF = 265;
	public boolean show = false;
	private int enter = 0;

	public int getEnter() {
		return enter;
	}

	public void setEnter(int enter) {
		this.enter = enter;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void draw(SGraphics g) {
		Image czbj = Resource.loadImage(Resource.IMG_ID_RECHARGE_CZBJ);
		Image czbj_2 = Resource.loadImage(Resource.IMG_ID_RECHARGE_CZBJ_2);
		int h = 55, w = czbj_2.getWidth();
		int mapx = WIDTH_HALF - czbj.getWidth() / 2;
		int mapy = HEIGHT_HALF - czbj.getHeight() / 2;
		g.drawImage(czbj, mapx, mapy, 20);
		g.setColor(0xffff00);
		GameEngine.getInstance().setFont(20, true, g);
		g.drawString(String.valueOf(GameEngine.balance), mapx + 195, mapy + 63,
				20);
		GameEngine.getInstance().setDefaultFont(g);
		g.setColor(0x000000);

		int offy = index * (h + 6);
		int sx = mapx + 39;
		int sy = mapy + 103 + offy;
		g.drawRegion(czbj_2, 0, 8 + offy, w, h, 0, sx, sy, 20);
	}

	private void clear() {
		Resource.releaseImage(Resource.IMG_ID_RECHARGE_CZBJ);
		Resource.releaseImage(Resource.IMG_ID_RECHARGE_CZBJ_2);
	}

	public void update(KeyState key) {
		if (key.containsAndRemove(KeyCode.UP)) {
			index = (index - 1 + 5) % 5;
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			index = (index + 1) % 5;
		} else if (key.containsAndRemove(KeyCode.OK)) {
			if (index == 4) {
				if (GameEngine.enterBuy == 4) {
					GameEngine.mainIndex = 6;// 抽奖
				} else if (GameEngine.enterBuy == 3) {
					GameEngine.mainIndex = 2;// 扫荡
				} else if (GameEngine.enterBuy == 2) {
					GameEngine.mainIndex = 1; // 通天塔机会
				} else if (GameEngine.enterBuy == 5) {
					GameEngine.mainIndex = 3;// 英雄
				} else if (GameEngine.enterBuy == 6) {
					GameEngine.mainIndex = 4; // 士兵
				} else if (GameEngine.enterBuy == 1) {
					GameEngine.mainIndex = 7;// 商店
				} else if (GameEngine.enterBuy == 10) {
					GameEngine.gameIndex = 4;// 引导使用道具
					GameEngine.mainIndex = 0;
				} else if (GameEngine.enterBuy == 11) {
					GameEngine.gameIndex = 0;// 游戏中使用道具
					GameEngine.mainIndex = 0;
				} else if (GameEngine.enterBuy == 12) {
					GameEngine.gameIndex = 1;// 复活 正常
					GameEngine.mainIndex = 0;
				} else if (GameEngine.enterBuy == 13) {
					GameEngine.gameIndex = 9;// 复活 通天塔
					GameEngine.mainIndex = 0;
				}
				clear();
			} else {
				recharge();
			}
		} else if (key.containsAndRemove(KeyCode.NUM0 | KeyCode.BACK)) {
			if (GameEngine.enterBuy == 4) {
				GameEngine.mainIndex = 6;// 抽奖
			} else if (GameEngine.enterBuy == 3) {
				GameEngine.mainIndex = 2;// 扫荡
			} else if (GameEngine.enterBuy == 2) {
				GameEngine.mainIndex = 1; // 通天塔机会
			} else if (GameEngine.enterBuy == 5) {
				GameEngine.mainIndex = 3;// 英雄
			} else if (GameEngine.enterBuy == 6) {
				GameEngine.mainIndex = 4; // 士兵
			} else if (GameEngine.enterBuy == 1) {
				GameEngine.mainIndex = 7;// 商店
			} else if (GameEngine.enterBuy == 10) {
				GameEngine.gameIndex = 4;// 引导使用道具
				GameEngine.mainIndex = 0;
			} else if (GameEngine.enterBuy == 11) {
				GameEngine.gameIndex = 0;// 游戏中使用道具
				GameEngine.mainIndex = 0;
			} else if (GameEngine.enterBuy == 12) {
				GameEngine.gameIndex = 1;// 复活 正常
				GameEngine.mainIndex = 0;
			} else if (GameEngine.enterBuy == 13) {
				GameEngine.gameIndex = 9;// 复活 通天塔
				GameEngine.mainIndex = 0;
			}
			clear();
		}
	}

	private void recharge() {
		Prompt.groupIndex = 0;
		ItvGame itvgame = new ItvGame();
		RespWapper respWapper;
		try {
			price = getRechargeAmount();
			respWapper = itvgame.Recharge("", price,
					Escape.urlEncode("皇家军团充值" + price + "元"));
			if (respWapper.is_ret()) {
				String amount = respWapper.get_goldCount();
				GameEngine.balance = Integer.parseInt(amount);
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("充值成功！");
				pt.popup();
				GameEngine.mainIndex = 21;
			} else {
				if (respWapper.get_code().equals("9103")
				/* || isPasswordError(respWapper.get_message()) */) {
					GameEngine.mainIndex = 22;
				} else {
					PopupText pt = UIResource.getInstance()
							.buildDefaultPopupText();
					pt.setText("充值失败：" + respWapper.get_message());
					pt.popup();
					// GameEngine.mainIndex = 22;
				}
			}
		} catch (XmlPullParserException e) {
			System.out.println("充值失败，原因:" + e.getMessage());
			PopupText pt = UIResource.getInstance().buildDefaultPopupText();
			pt.setText("充值失败：" + e.getMessage());
			pt.popup();
		}
	}

	private boolean isPasswordError(String msg) {
		boolean pwdError = false;
		if (msg.indexOf("没有权限") >= 0) {
			pwdError = true;
		}
		return pwdError;
	}

	private String getRechargeAmount() {
		if (index == 0) {
			return "10";
		} else if (index == 1) {
			return "5";
		} else if (index == 2) {
			return "2";
		} else if (index == 3) {
			return "1";
		}
		return null;
	}
}
