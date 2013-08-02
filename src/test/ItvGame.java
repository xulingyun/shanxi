package test;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.midlet.MIDlet;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * 安徽海游大厅计费/存档解析文件
 * 
 * @author yorkey
 * 
 */
public class ItvGame {

	/** iTV账号(排行榜界面的那个itv账号) */
	public static String USER_ID = null;

	/** 游戏id */
	private static String GAMEID = null;

	/** 服务器ip地址 */
	private static String SERVERIP = null;

	/** cp商的编号 */
	private static String CPID = null;

	/** 鉴权用户信息接口（游戏初始化的时候调用一次） */
	public static String URL_BSCS_USER_QUERY = null;

	/** 道具购买接口 */
	public static String URL_BSCS_PROPS_ORDER = null;

	/** 存档 */
	public static String URL_BSCS_CROSS_SAVEORUPDATE = null;

	/** 查询取得存档信息 */
	public static String URL_BSCS_CROSS_QUERY = null;

	/** 更新存储积分 */
	public static String URL_BSCS_RANK_SAVEORUPDATE = null;

	/** 查询积分排行榜接口 */
	public static String URL_BSCS_RANK_QUERY = null;

	/** 游戏时间 */
	public static String URL_BSCS_TIME = null;

	/** 多存档 */
	public static String URL_BSCS_CROSS_SAVERECORD_MULTY = null;

	/** 读多档 */
	public static String URL_BSCS_CROSS_QUERY_MULTY = null;

	public ItvGame() {

	}

	/**
	 * 鉴权用户信息接口（游戏初始化的时候调用一次）
	 * 
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper init(MIDlet midlet) throws XmlPullParserException {
		if (midlet == null) {
			return new RespWapper(false, "请传入MIDlet对象", "null", "null");
		}
		USER_ID = midlet.getAppProperty("userid");
		if (USER_ID == null) {
			return new RespWapper(false,
					"获取useid出错，请在jad中加入参数,例如,useid: 10000024", "null", "null");
		}
		GAMEID = midlet.getAppProperty("gameid");
		if (GAMEID == null) {
			return new RespWapper(false, "获取gameid出错，请在jad中加入参数,例如,gameid: 15",
					"null", "null");
		}
		SERVERIP = midlet.getAppProperty("serverip");
		if (SERVERIP == null) {
			return new RespWapper(
					false,
					"获取serverip出错，请在jad中加入参数,例如,serverip: http://61.191.45.166:8080",
					"null", "null");
		}
		CPID = midlet.getAppProperty("cpid");
		if (CPID == null) {
			return new RespWapper(false,
					"获取cpid出错，请在jad中加入参数,例如,cpid: hyCpID00001", "null", "null");
		}

		URL_BSCS_PROPS_ORDER = SERVERIP
				+ "/gameHall/webservice/GameorderAction?requestmethod";
		URL_BSCS_CROSS_SAVEORUPDATE = SERVERIP
				+ "/gameRecord/SaveRecordAction?";
		URL_BSCS_CROSS_QUERY = SERVERIP + "/gameRecord/ReadRecordAction?";
		URL_BSCS_RANK_SAVEORUPDATE = SERVERIP + "/gameRecord/SavePointAction?";
		URL_BSCS_RANK_QUERY = SERVERIP + "/gameRecord/GetRankAction?";
		URL_BSCS_TIME = SERVERIP + "/gameRecord/GetSystimeAction";
		URL_BSCS_CROSS_SAVERECORD_MULTY = SERVERIP
				+ "/gameRecord/SaveRecordMulty?";
		URL_BSCS_CROSS_QUERY_MULTY = SERVERIP + "/gameRecord/ReadRecordMulty?";

		return new RespWapper(true, "游戏参数初始化成功", "0", "null");
	}

	/**
	 * 获取余额
	 * 
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper goldQuery() throws XmlPullParserException {
		String sendURL = URL_BSCS_PROPS_ORDER + "=goldCount&userID=" + USER_ID;
		sendURL = "" + sendURL;
		return http(sendURL, "result", "goldCount", true);
	}

	/**
	 * 得到服务器的时间
	 * 
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper timeQuery() throws XmlPullParserException {
		String sendURL = URL_BSCS_TIME;
		sendURL = "" + sendURL;
		RespWapper r = http(sendURL, "code", "Time", false);
		if (r._ret) {
			String time = r.get_message();
			r.set_time(time);
		}

		return r;
	}

	/**
	 * 充值接口
	 * 
	 * @param password
	 * @param price
	 * @param description
	 *            说明
	 * @return
	 * @throws XmlPullParserException
	 */

	public RespWapper Recharge(String password, String price, String description)
			throws XmlPullParserException {
		if ((null == price || "".equals(price))
				|| (null == description || "".equals(description))) {
			return new RespWapper(false, "请传入充值的价格或说明", "null", "null");
		}
		String sendURL = URL_BSCS_PROPS_ORDER + "=recharge&cpid=" + CPID
				+ "&userID=" + USER_ID + "&password=" + password + "&price="
				+ price + "&description=" + description + "&userIDType=" + "0";
		sendURL = "" + sendURL;
		return http(sendURL, "result", "message", true);
	}

	/**
	 * 道具购买接口
	 * 
	 * @param propID
	 *            道具码
	 * @return
	 * @throws XmlPullParserException
	 */

	public RespWapper propsOrder(String propID) throws XmlPullParserException {
		if ((null == propID || "".equals(propID))) {
			return new RespWapper(false, "请传入道具码", "null", "null");
		}
		String sendURL = URL_BSCS_PROPS_ORDER + "=gameorder&propID=" + propID
				+ "&userID=" + USER_ID;
		sendURL = "" + sendURL;
		return http(sendURL, "result", "message", true);
	}

	/**
	 * 存档
	 * 
	 * @param crossCodePoints
	 *            自定义数组数据(可以存放中文英文。字母。逗号。|)
	 * @return 包装类
	 * @throws XmlPullParserException
	 */
	public RespWapper crossSaveOrUpdate(String crossCodePoints)
			throws XmlPullParserException {
		if ((null == crossCodePoints || "".equals(crossCodePoints))) {
			return new RespWapper(false, "请传入具体的存档信息", "null", "null");
		}
		String sendURL = URL_BSCS_CROSS_SAVEORUPDATE + "userid=" + USER_ID
				+ "&gameid=" + GAMEID + "&crosscodepoints=" + crossCodePoints;
		sendURL = "" + sendURL;
		return http(sendURL, "code", "message", false);
	}

	/**
	 * 存档(可存多条)
	 * 
	 * @param crossCodePoints
	 *            自定义数组数据(可以存放中文英文。字母。逗号。|)
	 * @param keyCode
	 *            (存档标识)
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper crossSaveRecordMulty(String crossCodePoints, int keyCode)
			throws XmlPullParserException {
		if ((null == crossCodePoints || "".equals(crossCodePoints))) {
			return new RespWapper(false, "请传入具体的存档信息", "null", "null");
		}
		String sendURL = URL_BSCS_CROSS_SAVERECORD_MULTY + "userid=" + USER_ID
				+ "&gameid=" + GAMEID + "&crosscodepoints=" + crossCodePoints
				+ "&keyCode=" + keyCode;
		sendURL = "" + sendURL;
		return http(sendURL, "code", "message", false);
	}

	/**
	 * 取得存档信息
	 * 
	 * @param account
	 * @param productCode
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper crossquery() throws XmlPullParserException {

		String sendURL = URL_BSCS_CROSS_QUERY + "gameid=" + GAMEID + "&userid="
				+ USER_ID;
		sendURL = "" + sendURL;
		RespWapper r = http(sendURL, "code", "crossCodePoints", false);
		if (r._ret) {
			String crossCodePoints = r.get_message();

			r.setCrossCodePoints(crossCodePoints);
		}

		return r;
	}

	/**
	 * 从多个存档中查询某一个存档
	 * 
	 * @param keyCode
	 *            存档标识
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper crossQueryMulty(int keyCode)
			throws XmlPullParserException {
		String sendURL = URL_BSCS_CROSS_QUERY_MULTY + "gameid=" + GAMEID
				+ "&userid=" + USER_ID + "&keyCode=" + keyCode;
		sendURL = "" + sendURL;
		RespWapper r = http(sendURL, "code", "crossCodePoints", false);
		if (r._ret) {
			String crossCodePoints = r.get_message();

			r.setCrossCodePoints(crossCodePoints);
		}
		return r;
	}

	/**
	 * 更新存储积分
	 * 
	 * @param account
	 * @param productCode
	 * @param rankPoints
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper rankSaveOrUpdate(String rankPoints)
			throws XmlPullParserException {
		if (("".equals(rankPoints) || null == rankPoints)) {
			return new RespWapper(false, "请传入上传的积分", "null", "null");
		}
		if (!(String2Int(rankPoints))) {
			return new RespWapper(false, "积分必须是int类型", "null", "null");
		}
		String sendURL = URL_BSCS_RANK_SAVEORUPDATE + "userid=" + USER_ID
				+ "&gameid=" + GAMEID + "&userscore=" + rankPoints;
		sendURL = "" + sendURL;
		return http(sendURL, "code", "message", false);
	}

	/**
	 * 查询积分排行榜接口
	 * 
	 * @param account
	 * @param productCode
	 * @return
	 * @throws XmlPullParserException
	 */
	public RespWapper rankQuery() throws XmlPullParserException {

		String sendURL = URL_BSCS_RANK_QUERY + "userid=" + USER_ID + "&gameid="
				+ GAMEID;
		sendURL = "" + sendURL;
		RespWapper r = http(sendURL, "code", "rankOwn", false);
		if (r._ret) {
			String myRankNo = r.get_message();
			RankInfo[] list = getRank(httpGetInputStream(sendURL));

			r.setMyRankNo(myRankNo);
			r.setList(list);
		}
		RespWapper r1 = http(sendURL, "code", "rankSelf", false);
		if (r1._ret) {
			String myScore = r1.get_message();

			r.setMyScore(myScore);
		}

		return r;
	}

	private InputStream httpGetInputStream(String sendURL)
			throws XmlPullParserException {

		HttpConnection conn = null;
		InputStream is = null;
		try {
			conn = (HttpConnection) Connector.open(sendURL);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestMethod(HttpConnection.GET);
			is = conn.openInputStream();
		} catch (Exception e) {
		}
		return is;
	}

	/**
	 * 包装基本的http通信方法
	 * 
	 * @param sendURL
	 * @param code
	 * @param unknown
	 *            想要返回的信息
	 * @param isgoldCount
	 *            是否要返回余额
	 * @return
	 * @throws XmlPullParserException
	 */
	private RespWapper http(String sendURL, String code, String unknown,
			boolean isgoldCount) throws XmlPullParserException {

		RespWapper respWapper = new RespWapper();// TODO

		HttpConnection conn = null;
		InputStream is = null;
		try {
			conn = (HttpConnection) Connector.open(sendURL);
			System.out.println("url:" + sendURL);
			if (conn == null) {
				return new RespWapper(false, "不能创建通信请求对象", "null", "null");
			}
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestMethod(HttpConnection.GET);
			is = conn.openInputStream();

			if (conn.getResponseCode() == HttpConnection.HTTP_OK) {
				if (isgoldCount) {
					respWapper = getTextByName(is, code, unknown, true);
				} else {
					respWapper = getTextByName(is, code, unknown, false);
				}

				// String message = this.getTextByName(get(sendURL), _message);
				if (respWapper.get_code().equals("0")) {
					return new RespWapper(true, respWapper.get_unknown(),
							respWapper.get_code(), respWapper.get_goldCount());
				} else {
					return new RespWapper(false, respWapper.get_unknown(),
							respWapper.get_code(), respWapper.get_goldCount());
				}
			} else {
				return new RespWapper(false, "通信失败", "null", "null");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new RespWapper(false, "未知错误", "null", "null");
	}

	private boolean String2Int(String value) {

		try {
			Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private RespWapper getTextByName(InputStream is, String param1,
			String param2, boolean isgoldCount) throws XmlPullParserException {
		RespWapper respWapper = new RespWapper();
		try {

			boolean isParam1Run = false;
			boolean isParam2Run = false;
			boolean isParam3Run = false;
			// 1实例化
			KXmlParser parser = new KXmlParser();
			parser.setInput(is, "utf-8");

			// 2接收事件类型
			int eventType = parser.getEventType();

			while (eventType != XmlPullParser.END_DOCUMENT) {// 当事件类型不为文档末尾时
				if (isgoldCount) {
					switch (eventType) {// 判断事件类型
					case XmlPullParser.START_TAG:// 为开始标记时-闭合标签开始S
						// System.out.print("<" + parser.getName()+">");//
						// 输出开始标记
						if (param1.equals(parser.getName())) {
							parser.next();
							respWapper.set_code(parser.getText());
							isParam1Run = true;
							if (isParam2Run && isParam3Run) {
								return respWapper;
							}
						}
						if (param2.equals(parser.getName())) {
							if ("goldCount".equals(param2)) {
								parser.next();
								respWapper.set_goldCount(parser.getText());
								isParam2Run = true;
								if (isParam1Run && isParam3Run) {
									return respWapper;
								}
							} else {
								parser.next();
								respWapper.set_unknown(parser.getText());
								isParam2Run = true;
								if (isParam1Run && isParam3Run) {
									return respWapper;
								}
							}

						}
						if ("goldCount".equals(parser.getName())) {
							parser.next();
							respWapper.set_goldCount(parser.getText());
							isParam3Run = true;
							if (isParam2Run && isParam1Run) {
								return respWapper;
							}
						}
						break;

					case XmlPullParser.END_TAG: // 为结束标记时-闭合标签结束E
						// System.out.print("</" + parser.getName() + ">");
						break;

					case XmlPullParser.TEXT:// 为文档正文时
						// System.out.print(parser.getText());
						break;

					case XmlPullParser.END_DOCUMENT:
						return respWapper;
					}
				} else {
					switch (eventType) {// 判断事件类型
					case XmlPullParser.START_TAG:// 为开始标记时-闭合标签开始S
						// System.out.print("<" + parser.getName()+">");//
						// 输出开始标记
						if (param1.equals(parser.getName())) {
							parser.next();
							respWapper.set_code(parser.getText());
							isParam1Run = true;
							if (isParam2Run) {
								return respWapper;
							}
						}
						if (param2.equals(parser.getName())) {
							parser.next();
							respWapper.set_unknown(parser.getText());
							isParam2Run = true;
							if (isParam1Run) {
								return respWapper;
							}
						}
						break;

					case XmlPullParser.END_TAG: // 为结束标记时-闭合标签结束E
						// System.out.print("</" + parser.getName() + ">");
						break;

					case XmlPullParser.TEXT:// 为文档正文时
						// System.out.print(parser.getText());
						break;

					case XmlPullParser.END_DOCUMENT:
						return respWapper;
					}
				}

				eventType = parser.next();
			}
			// System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return respWapper;
	}

	private RankInfo[] getRank(InputStream is) throws XmlPullParserException {// 接口默认返回10条数据
		int arrIndex = 0;
		int temp = 0;
		RankInfo[] rankInfo = new RankInfo[10];
		for (int i = 0; i < rankInfo.length; i++) {
			rankInfo[i] = new RankInfo();
			rankInfo[i].rankNo = i + 1 + "";
		}
		try {
			// 1实例化
			KXmlParser parser = new KXmlParser();
			parser.setInput(is, "utf-8");

			// 2接收事件类型
			int eventType = parser.getEventType();

			while (eventType != XmlPullParser.END_DOCUMENT) {// 当事件类型不为文档末尾时
				switch (eventType) {// 判断事件类型
				case XmlPullParser.START_TAG:// 为开始标记时-闭合标签开始S
					// System.out.print("<" + parser.getName()+">");
					if ("rankItv".equals(parser.getName())) {// rankItv账号,rank积分
						parser.next();
						rankInfo[arrIndex].userId = parser.getText();
						temp++;
					}
					if ("rank".equals(parser.getName())) {// rankItv账号,rank积分
						parser.next();
						rankInfo[arrIndex].score = parser.getText();
						temp++;
					}
					if (temp != 0 && temp % 2 == 0) {
						arrIndex++;
					}
					break;

				case XmlPullParser.END_TAG: // 为结束标记时-闭合标签结束E
					// System.out.print("</" + parser.getName() + ">");
					break;

				case XmlPullParser.TEXT:// 为文档正文时
					// System.out.print(parser.getText());
					break;

				case XmlPullParser.END_DOCUMENT:
					return rankInfo;
				}
				eventType = parser.next();
			}
			// System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rankInfo;
	}

	public class RankInfo {
		public String userId;
		public String rankNo;
		public String score;
	}

	/**
	 * HTTP Response包装类
	 */
	public class RespWapper {
		String _code;
		/** 金币数目 */
		String _goldCount;

		public String get_goldCount() {
			return _goldCount;
		}

		public void set_goldCount(String _goldCount) {
			this._goldCount = _goldCount;
		}

		String _unknown;

		public String get_unknown() {
			return _unknown;
		}

		public void set_unknown(String _unknown) {
			this._unknown = _unknown;
		}

		public String get_code() {
			return _code;
		}

		public void set_code(String _code) {
			this._code = _code;
		}

		String crossCodePoints;
		String levels;
		/** 返回结果，true代表成功，false代表失败 */
		boolean _ret;

		/** 具体消息内容 */
		String _message;

		/** 游戏时间 */
		String _time;

		public String get_time() {
			return _time;
		}

		public void set_time(String _time) {
			this._time = _time;
		}

		/** 数据流，暂时不用 */
		InputStream _is;

		/** 排行榜列表，最大是10 */
		RankInfo[] list;

		/** 我的排行 */
		String myRankNo;

		/** 我的积分 */
		String myScore;

		public boolean is_ret() {
			return _ret;
		}

		public void set_ret(boolean _ret) {
			this._ret = _ret;
		}

		public String get_message() {
			return _message;
		}

		public void set_message(String _message) {
			this._message = _message;
		}

		public InputStream get_is() {
			return _is;
		}

		public void set_is(InputStream _is) {
			this._is = _is;
		}

		public RankInfo[] getList() {
			return list;
		}

		public void setList(RankInfo[] list) {
			this.list = list;
		}

		public String getCrossCodePoints() {
			return crossCodePoints;
		}

		public void setCrossCodePoints(String crossCodePoints) {
			this.crossCodePoints = crossCodePoints;
		}

		public String getLevels() {
			return levels;
		}

		public void setLevels(String levels) {
			this.levels = levels;
		}

		public String getMyRankNo() {
			return myRankNo;
		}

		public void setMyRankNo(String myRankNo) {
			this.myRankNo = myRankNo;
		}

		public String getMyScore() {
			return myScore;
		}

		public void setMyScore(String myScore) {
			this.myScore = myScore;
		}

		RespWapper() {
		}

		RespWapper(boolean ret, String message, String code, String goldCount) {
			_ret = ret;
			_code = code;
			_message = message;
			_goldCount = goldCount;
			if (false == ret) {
				System.out.println("message:" + message);
			}
		}

		RespWapper(boolean ret, String message, InputStream is) {
			_ret = ret;
			_message = message;
			_is = is;
		}
	}
}
