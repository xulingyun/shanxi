package test;

import javax.microedition.lcdui.Image;

import cn.ohyeah.itvgame.shanxi.Define;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.PopupText;
import cn.ohyeah.stb.ui.TextView;

/**
 * 陕西电信充值界面
 * @author Administrator
 *
 */
public class StateSubscribe{
	
	private final static int STATUS_SELECT_AMOUNT = 0;
	private final static int STATUS_RECHARGE_CONFIRM = 1;
	private final static int STATUS_RECHARGE_RESULT = 2;
	private GameEngine engine;
	private boolean running;
	private int groupIndex;
	private int menuIndex;
	private int state;
	private String resultMsg;
	private int rechargeAmount;
	
	public StateSubscribe(GameEngine e){
		engine = e;
	}
	
	public int processSubscribe(){
		running = true;
		menuIndex = 1;
		KeyState keyState = engine.getKeyState();
		SGraphics g = engine.getSGraphics();
		try {
			init();
			while (running) {
				handleSubscribe(keyState, g);
				if (running) {
					long t1 = System.currentTimeMillis();
					showSubscribe(g);
					engine.flushGraphics();
					System.gc();
					int sleepTime = (int)(125-(System.currentTimeMillis()-t1));
					if (sleepTime <= 0) {
						Thread.sleep(0);
					}
					else {
						Thread.sleep(sleepTime);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			Resource.clearPrompt();
		}
		return menuIndex;
	}

	private void init() {
		//TODO something
	}

	private void showSubscribe(SGraphics g) {
		switch (state){
		case STATUS_SELECT_AMOUNT:
			showSelectAmount(g);
			break;
		case STATUS_RECHARGE_CONFIRM:
			showRechargeConfirm(g);
			break;
		case STATUS_RECHARGE_RESULT:
			showRechargeResult(g);
			break;
		}
	}
	
	private void showRechargeConfirm(SGraphics g) {
		int sw = 370;
		int sh = 270;
		int sx = engine.getScreenWidth()/2 - sw/2;
		int sy = engine.getScreenHeight()/2 - sh/2;
		int offx = sx;
		int offy = sy;
		DrawUtil.drawRect(0xf1db44, g, offx, offy, sw, sh);
		offx += 10;
		offy += 10;
		DrawUtil.drawRect(0x734115, g, offx, offy, sw-20, sh-20);
		
		g.setColor(0xffff00);
		engine.setFont(25, true);
		String s1 = "您选择充值"+rechargeAmount+"元";
		String s2 = "此费用将会从您本月账单中";
		String s3 = "\"代收费\"一栏显示";
		int strx = sx;
		int stry = offy + 40;
		TextView.showSingleLineText(g, s1, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s2, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s3, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		engine.setDefaultFont();
		
		Image btn1 = Resource.loadImage(Resource.Y_btn_ok);
		Image btn2 = Resource.loadImage(Resource.Y_btn_cancel);
		int btx = sx + sw/3 - btn1.getWidth()/2;
		int bty = sy + 170;
		g.drawImage(btn1, btx, bty, 0);
		
		btx += sw/3;
		g.drawImage(btn2, btx, bty, 0);
		
		if(menuIndex == 0){
			DrawUtil.drawRect(g, btx-sw/3, bty, btn1.getWidth(), btn1.getHeight(), 2, 0x5ad0c0);
		}else{
			DrawUtil.drawRect(g, btx, bty, btn1.getWidth(), btn1.getHeight(), 2, 0x5ad0c0);
		}
	}

	private void showRechargeResult(SGraphics g) {
		int sw = 370;
		int sh = 270;
		int sx = engine.getScreenWidth()/2 - sw/2;
		int sy = engine.getScreenHeight()/2 - sh/2;
		int offx = sx;
		int offy = sy;
		DrawUtil.drawRect(0xf1db44, g, offx, offy, sw, sh);
		offx += 10;
		offy += 10;
		DrawUtil.drawRect(0x734115, g, offx, offy, sw-20, sh-20);
		
		g.setColor(0xffff00);
		engine.setFont(25, true);
		int strx = offx;
		int stry = offy + 40;
		TextView.showSingleLineText(g, resultMsg, strx, stry, 350, 90, TextView.STYLE_ALIGN_CENTER);
		engine.setDefaultFont();
		
		Image btn1 = Resource.loadImage(Resource.Y_btn_ok);
		int btx = sx + sw/2 - btn1.getWidth()/2;
		int bty = sy + 170;
		g.drawImage(btn1, btx, bty, 0);
		DrawUtil.drawRect(g, btx, bty, btn1.getWidth(), btn1.getHeight(), 2, 0x5ad0c0);
	}

	private void showSelectAmount(SGraphics g) {
		int sw = 370;
		int sh = 270;
		int sx = engine.getScreenWidth()/2 - sw/2;
		int sy = engine.getScreenHeight()/2 - sh/2;
		int offx = sx;
		int offy = sy;
		DrawUtil.drawRect(0xf1db44, g, offx, offy, sw, sh);
		offx += 10;
		offy += 10;
		DrawUtil.drawRect(0x734115, g, offx, offy, sw-20, sh-20);
		
		offy += 20;
		g.setColor(0xffff00);
		engine.setFont(25, true);
		TextView.showSingleLineText(g, "请选择充值金额：", offx, offy, sw-20, 30, TextView.STYLE_ALIGN_CENTER);
		g.setColor(0xffffff);
		engine.setDefaultFont();
		
		Image cz_1 = Resource.loadImage(Resource.Y_btn_1);
		Image cz_5 = Resource.loadImage(Resource.Y_btn_5);
		Image cz_10 = Resource.loadImage(Resource.Y_btn_10);
		Image cz_20 = Resource.loadImage(Resource.Y_btn_20);
		int czx = offx + ((sw-20)/8 - cz_1.getWidth()/2);
		int czy = offy + 50;
		int vari = (sw-20)/4;
		g.drawImage(cz_1, czx, czy, 0);
		czx += vari;
		g.drawImage(cz_5, czx, czy, 0);
		czx += vari;
		g.drawImage(cz_10, czx, czy, 0);
		czx += vari;
		g.drawImage(cz_20, czx, czy, 0);
		
		offy += cz_1.getHeight() + 65;
		g.setColor(0xffff00);
		engine.setFont(25, true);
		TextView.showSingleLineText(g, "1元=100tv豆", offx, offy, sw-20, 30, TextView.STYLE_ALIGN_CENTER);
		g.setColor(0xffffff);
		engine.setDefaultFont();
		
		Image btn = Resource.loadImage(Resource.Y_btn_cancel);
		int btnx = sx + sw/2 - btn.getWidth()/2;
		int btny = offy + 60;
		g.drawImage(btn, btnx, btny, 0);
		
		if(groupIndex == 0){
			int mx = offx + ((sw-20)/8 - cz_1.getWidth()/2) + menuIndex*(vari);
			DrawUtil.drawRect(g, mx, czy, cz_1.getWidth(), cz_1.getHeight(), 2, 0x5ad0c0);
		}else{
			DrawUtil.drawRect(g, btnx, btny, btn.getWidth(), btn.getHeight(), 2, 0x5ad0c0);
		}
	}

	private void handleSubscribe(KeyState keyState, SGraphics g) {
		switch (state){
		case STATUS_SELECT_AMOUNT:
			handleSelectAmount(keyState);
			break;
		case STATUS_RECHARGE_CONFIRM:
			handleRechargeConfirm(keyState);
			break;
		case STATUS_RECHARGE_RESULT:
			handleRechargeResult(keyState);
			break;
		}
	}

	private void handleRechargeConfirm(KeyState keyState) {
		if(keyState.containsAndRemove(KeyCode.LEFT)){
			menuIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.RIGHT)){
			menuIndex = 1;
		}else if (keyState.containsAndRemove(KeyCode.OK)) {
			if(menuIndex == 0){
				/*PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("正在充值，请稍后...");
				pt.show(engine.getSGraphics());
				engine.flushGraphics();*/
				try {
					engine.iptv_link.Recharge(rechargeAmount, "", 1);
					engine.waitTime();
					if (engine.iptv_link.result == 0) {
						resultMsg = "充值成功";
					}
					else {
						resultMsg =Define.getErrorInfo(Integer.parseInt(engine.iptv_link.returnInfo));
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					resultMsg = "网络连接超时！请重新登录！" ;
				}
				finally {
					state = STATUS_RECHARGE_RESULT;
					//result = engine.iptv_link.result;
					clear();
				}
			}else{
				menuIndex = 0;
				state = STATUS_SELECT_AMOUNT;
			}
		}
	}

	private void handleRechargeResult(KeyState keyState) {
		if(keyState.containsAndRemove(KeyCode.OK)){
			running = false;
			menuIndex = 0;
			clear();
		}
	}

	private void handleSelectAmount(KeyState keyState) {
		if (keyState.containsAndRemove(KeyCode.NUM0 | KeyCode.BACK)) {
			running = false;
			menuIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.LEFT)){
			if(groupIndex == 0){
				menuIndex = (menuIndex + 4 - 1)%4;
			}
		}else if(keyState.containsAndRemove(KeyCode.RIGHT)){
			if(groupIndex == 0){
				menuIndex = (menuIndex + 1)%4;
			}
		}else if(keyState.containsAndRemove(KeyCode.DOWN)){
			groupIndex = 1;
		}else if(keyState.containsAndRemove(KeyCode.UP)){
			groupIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.OK)){
			if(groupIndex == 0){
				rechargeAmount = getAmount();
				menuIndex = 1;
				state = STATUS_RECHARGE_CONFIRM;
			}else{
				running = false;
				clear();
			}
		}
	}
	
	/**
	 * 获取充值金额
	 * @return
	 */
	private int getAmount(){
		switch(menuIndex){
		case 0:
			return 1;
		case 1:
			return 5;
		case 2:
			return 10;
		case 3:
			return 20;
		default: return -1;
		}
	}

	private void clear() {
//		Resource.clearPrompt();
//		Resource.clearSubscribe();
	}
}
