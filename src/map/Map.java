package map;

public class Map {

	public static void toaString() {
		System.out.println(map.length);
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					for (int g = 0; g < map[i][j][k].length; g++) {
						// System.out.println("**" + map[i].length +
						// "%%"
						// + "&&&&&&&" + map[i][j].length + "##"
						// + map[i][j][k].length + "$$"
						// + map[i][j][k][g].length);
					}
				}
			}
		}
	}

	private static final int[][][][][] map = {
			{
					{
							{ { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 2, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 2, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 2, 0, 1, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 0, 0, 0 } },
							{ { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 0, 1, 0, 0 }, { 0, 0, 9, 0 },
									{ 0, 0, 0, 0 }, { 2, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 2, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 0, 0, 0 } },
							{ { 2, 0, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 } },
							{ { 0, 0, 10, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 0, 10, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 0, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 2, 0, 0, 0 }, { 2, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 0, 1, 0 }, { 2, 0, 0, 0 },
									{ 2, 1, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 10, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 } },
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 1, 12, 0 } },
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 1, 11, 0 } } },

					{
							{ { 2, 0, 0, 0 }, { 2, 1, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 1, 9, 0 }, { 2, 0, 0, 0 } },
							{ { 0, 2, 0, 0 }, { 0, 2, 1, 0 }, { 0, 2, 0, 0 },
									{ 0, 0, 1, 0 }, { 0, 0, 0, 0 },
									{ 0, 2, 1, 0 }, { 0, 2, 0, 0 } },
							{ { 0, 2, 0, 0 }, { 0, 2, 1, 0 }, { 0, 2, 0, 0 },
									{ 0, 0, 1, 0 }, { 0, 0, 0, 0 },
									{ 0, 2, 1, 0 }, { 0, 2, 0, 0 } },
							{ { 0, 1, 1, 1 }, { 0, 0, 0, 0 }, { 2, 14, 0, 0 },
									{ 2, 0, 0, 0 }, { 2, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 10, 10, 0 } } },

					{
							{ { 2, 0, 0, 0 }, { 0, 1, 9, 0 }, { 2, 0, 0, 0 },
									{ 0, 1, 12, 0 }, { 2, 0, 0, 0 },
									{ 0, 1, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 1, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 10, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 10, 0 },
									{ 0, 0, 0, 0 }, { 0, 1, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 2, 1, 0 }, { 0, 0, 0, 0 },
									{ 2, 2, 1, 9 }, { 0, 0, 0, 0 },
									{ 2, 2, 1, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 2, 1, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 1, 9 }, { 0, 0, 0, 0 },
									{ 2, 2, 1, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 2, 1, 0, 0 }, { 2, 1, 0, 0 },
									{ 2, 0, 0, 0 }, { 2, 1, 0, 0 },
									{ 2, 1, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 12, 0, 0 }, { 0, 10, 0, 0 },
									{ 2, 10, 0, 0 }, { 2, 11, 0, 0 },
									{ 2, 12, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 1, 0, 0 }, { 2, 9, 0, 0 },
									{ 0, 9, 0, 0 }, { 2, 11, 0, 0 },
									{ 2, 9, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 2, 1, 0, 0 },
									{ 2, 1, 0, 0 }, { 2, 10, 0, 0 },
									{ 2, 9, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 1, 12, 0 },
									{ 0, 1, 0, 0 }, { 2, 0, 9, 0 },
									{ 2, 1, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 2, 0, 10, 0 }, { 2, 0, 0, 0 }, { 0, 1, 0, 0 },
									{ 0, 1, 0, 0 }, { 0, 1, 0, 0 },
									{ 2, 1, 0, 0 }, { 0, 1, 10, 0 } },
							{ { 2, 1, 0, 11 }, { 2, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 2, 1, 1, 11 } },
							{ { 2, 1, 1, 11 }, { 2, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 2, 0, 1, 11 } } },

					{
							{ { 0, 0, 0, 0 }, { 2, 2, 1, 0 }, { 0, 0, 0, 0 },
									{ 2, 0, 1, 12 }, { 0, 0, 0, 0 },
									{ 2, 2, 1, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 2, 1, 9, 0 }, { 0, 0, 0, 0 },
									{ 2, 1, 0, 12 }, { 0, 0, 0, 0 },
									{ 2, 1, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 },
									{ 2, 1, 1, 11 }, { 2, 1, 1, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 2, 1, 1, 0 },
									{ 2, 1, 1, 11 }, { 0, 1, 1, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 2, 1, 9, 0 }, { 0, 0, 0, 0 }, { 2, 2, 0, 0 },
									{ 2, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 2, 1, 9, 0 } },
							{ { 0, 2, 0, 10 }, { 2, 0, 0, 0 }, { 0, 0, 1, 0 },
									{ 0, 0, 1, 2 }, { 2, 0, 1, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 10 } },
							{ { 0, 2, 0, 11 }, { 2, 0, 0, 0 }, { 0, 0, 1, 0 },
									{ 0, 0, 0, 9 }, { 2, 0, 1, 0 },
									{ 0, 0, 0, 0 }, { 0, 2, 0, 11 } },
							{ { 10, 1, 0, 0 }, { 2, 9, 0, 0 }, { 6, 15, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 0, 0 },
									{ 2, 0, 0, 0 }, { 10, 1, 0, 0 } } } },

			// �ڶ�������

			{

					{
							{ { 4, 3, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 10, 0 },
									{ 0, 0, 10, 0 }, { 0, 0, 10, 0 },
									{ 4, 0, 0, 0 }, { 4, 3, 0, 0 } },
							{ { 4, 4, 9, 13 }, { 0, 0, 0, 0 }, { 0, 3, 9, 0 },
									{ 0, 0, 0, 0 }, { 0, 3, 9, 13 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 0 } },
							{ { 4, 0, 10, 0 }, { 0, 3, 0, 0 }, { 4, 0, 10, 0 },
									{ 0, 3, 0, 0 }, { 4, 0, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 11 } },
							{ { 4, 0, 10, 0 }, { 0, 3, 0, 0 }, { 4, 0, 10, 0 },
									{ 0, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 11 } },

					},

					{
							{ { 4, 3, 12, 0 }, { 4, 3, 0, 0 }, { 4, 0, 0, 0 },
									{ 4, 3, 0, 0 }, { 4, 10, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 4, 3, 0, 0 },
									{ 4, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 4, 0, 0, 0 }, { 4, 10, 11, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 0, 3, 13, 0 }, { 4, 3, 0, 0 },
									{ 4, 12, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 4, 0, 13, 0 }, { 4, 3, 0, 0 },
									{ 4, 12, 0, 0 }, { 0, 0, 10, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 0, 13, 0 },
									{ 4, 0, 0, 0 }, { 4, 0, 11, 0 },
									{ 4, 3, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 10, 0 }, { 4, 0, 10, 0 },
									{ 4, 0, 0, 0 }, { 4, 0, 0, 0 },
									{ 4, 3, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 10, 0 }, { 4, 0, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 0 },
									{ 4, 3, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 10, 0 }, { 4, 0, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 0 },
									{ 4, 3, 10, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 4, 0, 3, 0 }, { 4, 0, 3, 0 }, { 4, 3, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 4, 9, 0 },
									{ 0, 4, 13, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 0, 3, 0 }, { 4, 0, 3, 0 }, { 4, 0, 3, 0 },
									{ 0, 0, 0, 0 }, { 0, 4, 3, 0 },
									{ 0, 4, 9, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 0, 3, 10 }, { 4, 0, 3, 10 }, { 4, 3, 3, 0 },
									{ 0, 0, 0, 0 }, { 0, 4, 3, 0 },
									{ 0, 4, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 0, 3, 11 }, { 4, 0, 3, 10 },
									{ 4, 3, 3, 10 }, { 0, 0, 0, 0 },
									{ 0, 4, 3, 0 }, { 0, 4, 0, 0 },
									{ 0, 0, 0, 0 } } },

					{
							{ { 4, 0, 10, 0 }, { 4, 3, 10, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 10, 0 },
									{ 4, 0, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 0, 11, 12 }, { 4, 3, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 10, 0 },
									{ 4, 0, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 3, 9, 12 }, { 0, 0, 9, 0 }, { 4, 11, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 0, 10 } },
							{ { 4, 3, 9, 12 }, { 0, 0, 0, 0 }, { 4, 16, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 9, 11 } } },

					{
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 9, 0 },
									{ 4, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 4, 3, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 10, 0 },
									{ 4, 3, 0, 0 }, { 4, 3, 10, 0 },
									{ 4, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 10, 0 },
									{ 4, 3, 0, 0 }, { 0, 3, 10, 0 },
									{ 4, 3, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 0, 3, 10, 0 },
									{ 4, 3, 0, 0 }, { 4, 3, 11, 0 },
									{ 4, 3, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 4, 3, 10, 9 }, { 4, 3, 10, 11 },
									{ 4, 3, 0, 9 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 4, 3, 12, 13 },
									{ 4, 3, 12, 10 }, { 4, 3, 0, 11 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 0, 11 },
									{ 4, 3, 10, 12 }, { 4, 3, 10, 11 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 0, 0 }, { 4, 3, 11, 0 },
									{ 4, 3, 0, 0 }, { 4, 0, 10, 0 },
									{ 4, 3, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 4, 3, 11, 0 }, { 0, 0, 0, 0 }, { 4, 3, 12, 0 },
									{ 0, 0, 0, 0 }, { 0, 3, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 13, 0 } },
							{ { 4, 3, 11, 0 }, { 0, 0, 0, 0 }, { 4, 3, 12, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 0, 0 } },
							{ { 4, 3, 13, 0 }, { 0, 0, 0, 0 }, { 4, 3, 11, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 9, 0 } },
							{ { 4, 3, 13, 0 }, { 0, 0, 0, 0 }, { 4, 3, 9, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 10, 0 },
									{ 0, 0, 0, 0 }, { 4, 0, 11, 0 } } },

					{
							{ { 0, 0, 0, 9 }, { 4, 0, 11, 0 }, { 0, 3, 0, 10 },
									{ 4, 0, 0, 0 }, { 0, 3, 0, 12 },
									{ 4, 0, 11, 0 }, { 0, 3, 0, 0 } },
							{ { 0, 0, 0, 10 }, { 4, 0, 11, 0 },
									{ 0, 3, 0, 13 }, { 4, 0, 11, 0 },
									{ 0, 3, 0, 12 }, { 4, 0, 0, 0 },
									{ 0, 3, 0, 0 } },
							{ { 0, 0, 0, 9 }, { 4, 0, 11, 0 }, { 0, 3, 0, 9 },
									{ 4, 0, 11, 0 }, { 0, 3, 0, 10 },
									{ 4, 0, 0, 0 }, { 0, 3, 0, 0 } },
							{ { 0, 0, 0, 9 }, { 4, 0, 11, 0 }, { 0, 3, 0, 9 },
									{ 4, 0, 11, 0 }, { 0, 3, 0, 10 },
									{ 4, 0, 0, 0 }, { 0, 3, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 4, 3, 9, 0 }, { 4, 3, 0, 0 },
									{ 4, 3, 0, 0 }, { 0, 3, 0, 0 },
									{ 4, 3, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 10, 0 }, { 4, 3, 0, 0 },
									{ 4, 3, 0, 0 }, { 4, 3, 0, 0 },
									{ 0, 3, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 4, 3, 11, 0 }, { 4, 3, 0, 0 },
									{ 4, 3, 0, 0 }, { 0, 3, 0, 0 },
									{ 4, 3, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 4, 3, 13, 0 }, { 0, 3, 11, 0 },
									{ 0, 17, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 4, 3, 9, 0 },
									{ 4, 3, 10, 0 } } } },

			{
					{
							{ { 0, 0, 0, 0 }, { 6, 5, 9, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 5, 0, 0 },
									{ 6, 0, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 13, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 5, 0, 0 },
									{ 6, 0, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 11, 0 }, { 6, 5, 0, 0 },
									{ 6, 0, 11, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 0, 5, 13, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 6, 5, 11, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 13, 0 }, { 6, 5, 0, 0 },
									{ 0, 5, 9, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 9, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 9, 0 }, { 6, 5, 0, 0 },
									{ 6, 0, 10, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 13, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 11, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 5, 0, 0 },
									{ 6, 0, 13, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 6, 0, 5, 0 }, { 6, 0, 5, 0 }, { 6, 0, 5, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 5, 0 },
									{ 6, 0, 5, 0 }, { 6, 0, 5, 0 } },
							{ { 6, 0, 5, 0 }, { 6, 0, 5, 0 }, { 6, 0, 5, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 10, 0 },
									{ 6, 0, 5, 0 }, { 6, 0, 11, 0 } },
							{ { 6, 0, 5, 0 }, { 6, 0, 5, 0 }, { 6, 0, 5, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 5, 0 },
									{ 6, 0, 5, 0 }, { 6, 0, 5, 0 } },
							{ { 6, 0, 5, 0 }, { 6, 0, 5, 0 }, { 6, 0, 5, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 5, 0 },
									{ 6, 0, 5, 0 }, { 6, 0, 12, 0 } } },

					{
							{ { 6, 0, 5, 0 }, { 0, 6, 0, 5 }, { 6, 0, 5, 0 },
									{ 0, 6, 0, 5 }, { 6, 0, 5, 0 },
									{ 0, 6, 0, 0 }, { 6, 0, 0, 0 } },
							{ { 6, 0, 9, 0 }, { 0, 5, 0, 11 }, { 6, 0, 9, 0 },
									{ 0, 5, 0, 12 }, { 6, 0, 0, 0 },
									{ 0, 5, 0, 11 }, { 6, 0, 0, 0 } },
							{ { 6, 0, 5, 0 }, { 0, 5, 0, 11 }, { 6, 0, 5, 0 },
									{ 0, 5, 0, 12 }, { 6, 0, 5, 0 },
									{ 0, 5, 0, 13 }, { 0, 0, 0, 0 } },
							{ { 6, 0, 5, 0 }, { 0, 5, 0, 13 }, { 0, 0, 5, 0 },
									{ 0, 5, 0, 11 }, { 6, 0, 5, 0 },
									{ 0, 5, 0, 9 }, { 6, 0, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 6, 5, 9, 0 }, { 6, 5, 0, 0 },
									{ 0, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 9, 0 }, { 6, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 13, 0 }, { 6, 5, 0, 0 },
									{ 0, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 6, 5, 11, 0 }, { 6, 5, 0, 0 },
									{ 0, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 10, 0 }, { 6, 0, 0, 0 } },
							{ { 0, 0, 5, 11 }, { 6, 0, 5, 0 }, { 6, 18, 0, 0 },
									{ 6, 0, 0, 0 }, { 6, 0, 0, 0 },
									{ 6, 0, 5, 0 }, { 6, 0, 5, 11 } } },

					{
							{ { 6, 5, 0, 0 }, { 6, 0, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 0, 0 }, { 6, 5, 0, 0 } },
							{ { 6, 0, 0, 9 }, { 6, 0, 0, 0 }, { 6, 0, 0, 12 },
									{ 6, 0, 0, 11 }, { 6, 0, 0, 9 },
									{ 6, 0, 0, 10 }, { 6, 0, 0, 10 } },
							{ { 6, 0, 0, 11 }, { 6, 0, 0, 11 },
									{ 6, 0, 0, 11 }, { 6, 0, 0, 12 },
									{ 6, 0, 0, 0 }, { 6, 0, 0, 10 },
									{ 6, 0, 0, 13 } },
							{ { 6, 0, 0, 12 }, { 6, 0, 0, 0 }, { 6, 0, 0, 11 },
									{ 6, 0, 0, 11 }, { 6, 0, 0, 9 },
									{ 6, 0, 0, 13 }, { 6, 0, 0, 12 } } },

					{
							{ { 6, 5, 9, 0 }, { 6, 5, 9, 0 }, { 6, 5, 9, 0 },
									{ 6, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 6, 5, 9, 0 }, { 6, 5, 0, 0 }, { 6, 5, 12, 0 },
									{ 6, 5, 10, 0 }, { 6, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 6, 5, 9, 0 }, { 6, 5, 0, 0 }, { 6, 5, 11, 0 },
									{ 6, 5, 10, 0 }, { 6, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 6, 5, 9, 0 }, { 6, 5, 0, 0 }, { 6, 5, 13, 0 },
									{ 6, 5, 11, 0 }, { 6, 0, 0, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 0, 5, 12, 0 }, { 6, 5, 11, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 9, 0 }, { 6, 5, 12, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 5, 11, 0 }, { 6, 5, 10, 0 },
									{ 6, 5, 11, 0 }, { 6, 5, 13, 0 },
									{ 6, 5, 0, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } },
							{ { 0, 5, 10, 0 }, { 6, 5, 12, 0 },
									{ 6, 5, 13, 0 }, { 6, 0, 11, 0 },
									{ 6, 5, 10, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } },
							{ { 0, 5, 13, 0 }, { 6, 5, 12, 0 },
									{ 6, 5, 11, 0 }, { 6, 5, 11, 0 },
									{ 6, 0, 10, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } } },

					{
							{ { 6, 5, 0, 0 }, { 6, 5, 9, 0 }, { 6, 5, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 0, 0 },
									{ 6, 5, 0, 0 }, { 6, 5, 9, 0 } },
							{ { 6, 5, 0, 0 }, { 6, 0, 11, 0 }, { 6, 5, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 11, 0 }, { 6, 5, 0, 0 } },
							{ { 6, 5, 0, 0 }, { 6, 0, 10, 0 }, { 6, 5, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 13, 0 }, { 6, 5, 0, 0 } },
							{ { 6, 5, 0, 0 }, { 6, 5, 0, 0 }, { 6, 5, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 0, 0 },
									{ 6, 5, 13, 0 }, { 6, 5, 0, 0 } } },

					{
							{ { 6, 5, 9, 12 }, { 0, 0, 0, 0 }, { 6, 5, 9, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 9, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 0, 12 } },
							{ { 6, 5, 9, 11 }, { 0, 0, 0, 0 }, { 6, 5, 9, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 10, 0 },
									{ 0, 0, 0, 0 }, { 6, 5, 0, 11 } },
							{ { 6, 5, 12, 10 }, { 0, 0, 0, 0 },
									{ 6, 5, 12, 0 }, { 0, 0, 0, 0 },
									{ 6, 5, 0, 0 }, { 0, 0, 0, 0 },
									{ 6, 5, 13, 10 } },
							{ { 6, 5, 0, 10 }, { 0, 5, 9, 0 }, { 6, 19, 0, 0 },
									{ 0, 0, 0, 0 }, { 6, 0, 0, 0 },
									{ 0, 5, 11, 0 }, { 6, 5, 13, 10 } } } },

			{
					{
							{ { 0, 0, 0, 0 }, { 8, 7, 11, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 12, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 12, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 8, 7, 13, 0 }, { 8, 7, 10, 0 },
									{ 8, 7, 10, 0 }, { 8, 7, 12, 0 },
									{ 8, 7, 11, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 8, 7, 9, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 11, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 9, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 8, 7, 12, 0 }, { 8, 7, 10, 0 },
									{ 8, 7, 9, 0 }, { 8, 7, 12, 0 },
									{ 8, 7, 10, 0 }, { 0, 0, 0, 0 } } },

					{
							{ { 8, 7, 13, 0 }, { 8, 7, 12, 0 },
									{ 8, 7, 12, 0 }, { 0, 0, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 } },
							{ { 8, 7, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 0, 0 },
									{ 0, 0, 0, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 9, 0 }, { 8, 7, 10, 0 } },
							{ { 8, 7, 10, 0 }, { 8, 7, 12, 0 }, { 8, 7, 0, 0 },
									{ 0, 0, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 10, 0 } },
							{ { 8, 7, 10, 0 }, { 8, 7, 9, 0 }, { 8, 7, 0, 0 },
									{ 0, 0, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 11, 0 } } },

					{
							{ { 8, 7, 9, 10 }, { 0, 0, 0, 0 }, { 8, 7, 9, 13 },
									{ 0, 0, 0, 0 }, { 8, 7, 9, 10 },
									{ 0, 0, 0, 0 }, { 8, 7, 9, 13 } },
							{ { 8, 7, 10, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 9 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 13 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 11 } },
							{ { 8, 7, 10, 13 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 13 } },
							{ { 8, 7, 9, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 9, 11 } } },

					{
							{ { 0, 7, 0, 0 }, { 8, 0, 12, 0 }, { 8, 7, 11, 0 },
									{ 8, 0, 13, 0 }, { 8, 7, 13, 0 },
									{ 8, 0, 12, 0 }, { 0, 7, 0, 0 } },
							{ { 0, 7, 0, 0 }, { 8, 0, 12, 0 }, { 8, 7, 10, 0 },
									{ 8, 0, 13, 0 }, { 8, 7, 11, 0 },
									{ 8, 0, 10, 0 }, { 0, 7, 0, 0 } },
							{ { 0, 7, 0, 0 }, { 8, 0, 9, 0 }, { 8, 7, 11, 0 },
									{ 8, 0, 11, 0 }, { 8, 7, 12, 0 },
									{ 8, 0, 9, 0 }, { 0, 7, 0, 0 } },
							{ { 0, 7, 0, 0 }, { 8, 0, 9, 0 }, { 8, 7, 10, 0 },
									{ 8, 0, 13, 0 }, { 8, 7, 11, 0 },
									{ 8, 0, 10, 0 }, { 0, 7, 0, 0 } } },

					{
							{ { 8, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 9, 0 },
									{ 8, 7, 12, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 0, 0 }, { 8, 0, 0, 0 } },
							{ { 8, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 10, 0 },
									{ 8, 7, 10, 0 }, { 8, 7, 13, 0 },
									{ 8, 7, 0, 0 }, { 8, 0, 0, 0 } },
							{ { 8, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 9, 0 },
									{ 8, 7, 9, 0 }, { 8, 7, 13, 0 },
									{ 8, 7, 0, 0 }, { 8, 0, 0, 0 } },
							{ { 8, 7, 11, 0 }, { 8, 7, 9, 0 }, { 8, 20, 0, 0 },
									{ 8, 0, 0, 0 }, { 8, 0, 0, 0 },
									{ 8, 7, 9, 0 }, { 8, 7, 11, 0 } } },

					{
							{ { 8, 7, 10, 12 }, { 0, 0, 0, 0 },
									{ 8, 7, 9, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 9 }, { 0, 0, 0, 0 },
									{ 8, 7, 11, 12 } },
							{ { 8, 7, 11, 9 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 10 }, { 0, 0, 0, 0 },
									{ 8, 7, 12, 9 }, { 0, 0, 0, 0 },
									{ 8, 7, 11, 13 } },
							{ { 8, 7, 9, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 10, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 9, 11 } },
							{ { 8, 7, 13, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 13, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 13, 11 }, { 0, 0, 0, 0 },
									{ 8, 7, 13, 11 } } },

					{
							{ { 8, 8, 7, 7 }, { 8, 8, 7, 0 }, { 8, 8, 7, 0 },
									{ 8, 8, 7, 0 }, { 8, 8, 7, 0 },
									{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 8, 7, 13, 12 }, { 8, 7, 13, 0 },
									{ 8, 7, 11, 0 }, { 8, 7, 12, 0 },
									{ 8, 7, 11, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } },
							{ { 8, 7, 10, 12 }, { 8, 7, 11, 0 },
									{ 8, 7, 10, 0 }, { 8, 7, 11, 0 },
									{ 8, 7, 9, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } },
							{ { 8, 7, 9, 12 }, { 8, 7, 13, 0 },
									{ 8, 7, 11, 0 }, { 8, 7, 12, 0 },
									{ 8, 7, 9, 0 }, { 0, 0, 0, 0 },
									{ 0, 0, 0, 0 } } },

					{
							{ { 8, 7, 13, 0 }, { 8, 7, 103, 0 },
									{ 8, 7, 11, 0 }, { 8, 7, 13, 0 },
									{ 8, 7, 0, 0 }, { 0, 0, 0, 0 },
									{ 8, 7, 0, 0 } },
							{ { 8, 7, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 10, 13 },
									{ 0, 0, 0, 0 }, { 8, 7, 10, 13 } },
							{ { 8, 7, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 10, 11 },
									{ 0, 0, 0, 0 }, { 8, 7, 10, 13 } },
							{ { 8, 7, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 0, 0 },
									{ 8, 7, 0, 0 }, { 8, 7, 12, 11 },
									{ 0, 0, 0, 0 }, { 8, 7, 10, 13 } } },

					{
							{ { 8, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 9, 11 },
									{ 8, 7, 10, 0 }, { 8, 7, 11, 0 },
									{ 0, 7, 10, 0 }, { 0, 0, 0, 9 } },
							{ { 0, 0, 7, 0 }, { 0, 8, 7, 0 }, { 8, 8, 7, 0 },
									{ 8, 8, 7, 0 }, { 8, 8, 7, 0 },
									{ 8, 8, 7, 0 }, { 8, 0, 0, 0 } },
							{ { 0, 0, 7, 0 }, { 0, 8, 7, 0 }, { 8, 9, 7, 0 },
									{ 8, 8, 12, 0 }, { 8, 8, 7, 0 },
									{ 8, 9, 7, 0 }, { 8, 0, 0, 0 } },
							{ { 0, 0, 7, 0 }, { 0, 8, 7, 0 }, { 8, 13, 7, 0 },
									{ 8, 10, 7, 0 }, { 8, 13, 7, 0 },
									{ 8, 8, 7, 0 }, { 8, 0, 0, 0 } } },

					{
							{ { 0, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 10, 13 },
									{ 8, 7, 12, 11 }, { 8, 7, 12, 11 },
									{ 8, 7, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 9, 10 },
									{ 8, 7, 9, 11 }, { 8, 7, 9, 11 },
									{ 8, 7, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 0, 0, 0, 0 }, { 8, 7, 0, 0 }, { 8, 7, 11, 10 },
									{ 8, 7, 9, 10 }, { 8, 7, 11, 10 },
									{ 8, 7, 0, 0 }, { 0, 0, 0, 0 } },
							{ { 8, 7, 7, 13 }, { 8, 7, 0, 11 },
									{ 8, 21, 0, 0 }, { 0, 0, 0, 0 },
									{ 8, 0, 0, 0 }, { 8, 7, 0, 9 },
									{ 8, 7, 7, 11 } } } } };

	public static int[][][][][] getMap() {
		return map;
	}

	public static void setMap() {
		if (map[0][0][0][2][1] == 0)
			map[0][0][0][2][1] = 14;
		else {
			map[0][0][0][2][1]++;
			if (map[0][0][0][2][1] == 22) {
				map[0][0][0][2][1] = 14;
			}
		}
	}
}
