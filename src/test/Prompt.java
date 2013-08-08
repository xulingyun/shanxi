package test;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import org.xmlpull.v1.XmlPullParserException;

import test.ItvGame.RespWapper;

import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupText;

public class Prompt {

	private int index;
	public static byte groupIndex;
	private String pwdChars = "";
	private int cursorFrame;
	private int pwdLength = 12;
	private long sTime, eTime;
	private boolean flag;

	public void draw(SGraphics g) {
		Image bg = Resource.loadImage(Resource.IMG_ID_PROMPT_POPUP_BG);
		Image queren_on = Resource.loadImage(Resource.IMG_ID_PROMPT_QUEREN_ON);
		Image queren_off = Resource.loadImage(Resource.IMG_ID_PROMPT_QUEREN);

		int bgx = 320 - bg.getWidth() / 2, bgy = 265 - bg.getHeight() / 2;
		g.drawImage(bg, bgx, bgy, 20);
		int sx = bgx + 10, sy = bgy + 100;
		int sw = queren_on.getWidth() / 2, sh = queren_on.getHeight();
		int strx = bgx + 46, stry = bgy + 35;
		g.drawString("请输入童锁密码", strx, stry, 20);
		g.setColor(0x71f0ff);
		stry += 27;
		g.fillRect(strx, stry, 100, 30);
		g.setColor(0x000000);
		g.drawString("按左键删除", strx + 105, stry + 7, 20);

		if (groupIndex == 0) {
			g.drawRegion(queren_off, 0, 0, sw, sh, 0, sx, sy, 20);
			sx += 130;
			g.drawRegion(queren_off, sw, 0, sw, sh, 0, sx, sy, 20);
		} else {
			if (index == 0) {
				g.drawRegion(queren_on, 0, 0, sw, sh, 0, sx, sy, 20);
				sx += 130;
				g.drawRegion(queren_off, sw, 0, sw, sh, 0, sx, sy, 20);
			} else {
				g.drawRegion(queren_off, 0, 0, sw, sh, 0, sx, sy, 20);
				sx += 130;
				g.drawRegion(queren_on, sw, 0, sw, sh, 0, sx, sy, 20);
			}
		}
		drawPassWord(g, strx, stry);
	}

	private void clear() {
		Resource.releaseImage(Resource.IMG_ID_PROMPT_POPUP_BG);
		Resource.releaseImage(Resource.IMG_ID_PROMPT_QUEREN_ON);
		Resource.releaseImage(Resource.IMG_ID_PROMPT_QUEREN);
	}

	private void drawPassWord(SGraphics g, int strx, int stry) {
		int len = pwdChars.length();
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				g.drawString("*", strx + 3, stry + 4, 20);
				strx += 8;
			}
		}
		if (cursorFrame == 4 && groupIndex == 0) {
			g.drawLine(strx + 2, stry + 1, strx + 2, stry + 28);
			g.setColor(0x000000);
		}
		cursorFrame = (cursorFrame + 1) % 8;
	}

	public void update(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			if (groupIndex == 1) {
				if (index == 1) {
					GameEngine.mainIndex = 21;
					clear();
				} else {
					recharge();// 充值
				}
			} else {
				groupIndex = 1;
				index = 0;
			}
		} else if (key.containsAndRemove(KeyCode.BACK)) {
			GameEngine.mainIndex = 21;
			clear();
		} else if (key.containsAndRemove(KeyCode.LEFT)) {
			if (groupIndex == 1) {
				index = 0;
			} else {
				if (pwdChars.length() > 0) {
					pwdChars = pwdChars.substring(0, pwdChars.length() - 1);
				}
			}
		} else if (key.containsAndRemove(KeyCode.RIGHT)) {
			if (groupIndex == 1) {
				index = 1;
			}
		} else if (key.containsAndRemove(KeyCode.UP)) {
			groupIndex = 0;
		} else if (key.containsAndRemove(KeyCode.DOWN)) {
			groupIndex = 1;
		} else if (key.containsAndRemove(KeyCode.NUM0)) {
			if (groupIndex == 0) {
				if (pwdChars.length() < pwdLength) {
					pwdChars += "0";
				}
			} else if (groupIndex == 1) {
				GameEngine.mainIndex = 21;
				clear();
			}
		} else if (key.containsAndRemove(KeyCode.NUM1)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "1";
			}
		} else if (key.containsAndRemove(KeyCode.NUM2)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "2";
			}
		} else if (key.containsAndRemove(KeyCode.NUM3)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "3";
			}
		} else if (key.containsAndRemove(KeyCode.NUM4)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "4";
			}
		} else if (key.containsAndRemove(KeyCode.NUM5)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "5";
			}
		} else if (key.containsAndRemove(KeyCode.NUM6)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "6";
			}
		} else if (key.containsAndRemove(KeyCode.NUM7)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "7";
			}
		} else if (key.containsAndRemove(KeyCode.NUM8)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "8";
			}
		} else if (key.containsAndRemove(KeyCode.NUM9)) {
			if (groupIndex == 0 && pwdChars.length() < pwdLength) {
				pwdChars += "9";
			}
		}

		eTime = System.currentTimeMillis();
		if (flag && (eTime - sTime) > 3000) {
			// Game.popStack();
			clear();
		}
	}

	private void recharge() {
		ItvGame itvgame = new ItvGame();
		RespWapper respWapper;
		try {
			respWapper = itvgame.Recharge(pwdChars, Recharge.price,
					Escape.urlEncode("皇家军团充值" + Recharge.price + "元"));
			if (respWapper.is_ret()) {
				String amount = respWapper.get_goldCount();
				GameEngine.balance = Integer.parseInt(amount);
				System.out.println("充值成功" + amount);
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("充值成功！");
				pt.popup();
				GameEngine.mainIndex = 21;
			} else {
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("充值失败：" + respWapper.get_message());
				pt.popup();
			}
			pwdChars = "";
			sTime = System.currentTimeMillis();
			flag = true;
		} catch (XmlPullParserException e) {
			PopupText pt = UIResource.getInstance().buildDefaultPopupText();
			pt.setText("充值失败，原因:" + e.getMessage());
			pt.popup();
		}
	}
}
