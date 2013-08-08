package data;

import javax.microedition.lcdui.Image;

import test.Resource;

public class LoadImg {
	public static Image[] img = new Image[177];

	public static void loadLogo() {
		img[0] = Resource.loadImage(Resource.login);
		img[1] = Resource.loadImage(Resource.logintext);
	}

	public static void UnloadLogo() {
		Resource.releaseImage(Resource.login);
		Resource.releaseImage(Resource.logintext);
	}
	

	public static void loadMain() {
		img[0] = Resource.loadImage(Resource.bg10);
		img[1] = Resource.loadImage(Resource.heroinfo);
		

		img[1] = Resource.loadImage(Resource.newcomer);
		
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
		img[1] = Resource.loadImage(Resource.heroinfo);
	}

	public static void UnloadMain() {
		Resource.releaseImage(Resource.bg10);
		Resource.releaseImage(Resource.heroinfo);
	}

}
