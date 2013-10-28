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
	private String name[] = { "����ҩ��", "������", "����", "˫�����鿨", "˫����ҿ�", "����ʯ",
			"��������", "����֮��", "���Ի���", "����г��", "������", "�齱", "���ٹһ�", "����", "�޾�֮��" };
	private String desc[] = { "�ָ�Ӣ��40%��HP����ս����ʹ�ã�", "ʹ������ʧ30%��HP����ս����ʹ�ã�",
			"ʿ���Ĺ�������������30�룩��ս����ʹ�ã�", "ս��ʤ����õľ��鷭����", "ս��ʤ����õĽ�ҷ�����",
			"ʹ�ú�����20��������", "ͨ����ս��ʧ�ܱ�����ʧ��", "��������ʿ��10%��������", "����Ӣ��20���������",
			"����Ӣ��10%������", "�һ�10000��ҡ�", "���³齱��", "�ӿ�һ����ٶ�", "ս������", "���Լ���ȥ�޼�֮��" };

	public PropManager(GameEngine e) {
		this.engine = e;
	}

	/* ��ѯ��ҵ��� */
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
			System.out.println("����ID==" + props[i].getPropId());
			System.out.println("��������==" + props[i].getNums());
		}
	}

	public void initProps(PlayerProp[] props2) {
		props = new PlayerProp[15];
		System.out.println("�����������ݲ���ʼ��������Ϣ,size:" + props.length);
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

	/* ���ݵ���ID��ѯ�õ������� */
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
				dpt.setText("����" + pp.getName() + "�ɹ�");
			} else {
				dpt.setText(Define.getErrorInfo(Integer
						.parseInt(engine.iptv_link.returnInfo)));
			}
			dpt.popup();
			return (engine.iptv_link.result == 0);
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("�������ӳ�ʱ�����Ժ����ԣ�");
			pp.popup();
			// disConnected = true;
			return false;
		}
	}

	/* ������Ϣ */
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
