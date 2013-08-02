package test;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import org.xmlpull.v1.XmlPullParserException;

import test.ItvGame.RespWapper;

public class TestG extends MIDlet {

	public static TestG instance;

	public TestG() {
		instance = this;
	}

	public static TestG getInstance() {
		return instance;
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		ItvGame itvgame = new ItvGame();
		try {
			itvgame.init(this);
		} catch (XmlPullParserException e) {
			System.out.println("信息初始化…………");
			// e.printStackTrace();
		}
		GameEngine engine = new GameEngine(instance);
		Display.getDisplay(this).setCurrent(engine);
		new Thread(engine).start();
	}

}
