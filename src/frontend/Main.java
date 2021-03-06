package frontend;

import base.Game;
import base.GameDepth;
import base.GameTime;
import base.Point;

public class Main {

	public static void main(String args[]) {

		Game game = null;

		if (args.length < 3) {
			System.out.println("Invalid arguments");
			return;
		}
		try {
			if (args[0].equals("-visual")) {
				if (args[1].equals("-maxtime")) {
					if (Integer.valueOf(args[2]) <= 0) {
						System.out.println("Timer must be greater than 0");
						return;
					}
					game = new GameTime(null, Integer.valueOf(args[2]));
				} else if (args[1].equals("-depth")) {
					game = new GameDepth(null, Integer.valueOf(args[2]));
				} else {
					System.out.println("Invalid arguments");
					return;
				}
				if (args.length == 4) {
					if (args[3].equals("-prune")) {
						game.setPrune(true);
					} else {
						System.out.println("Invalid arguments");
					}
				}

				BoardDrawer board = new BoardDrawer(game);
				board.newGame();
			} else if (args[0].equals("-file")) {
				if (args[4].equals("-maxtime")) {
					if (Integer.valueOf(args[5]) <= 0) {
						System.out.println("Timer must be greater than 0");
						return;
					}
					game = new GameTime(args[1], Integer.valueOf(args[5]));
				} else if (args[4].equals("-depth")) {
					if (Integer.valueOf(args[5]) <= 0) {
						System.out.println("Timer must be greater than 0");
						return;
					}
					game = new GameDepth(args[1], Integer.valueOf(args[5]));
				}
				if (args.length >= 7) {
					if (args[6].equals("-tree")) {
						game.setTreeMode(true);
					} else {
						if (args.length == 8) {
							if (args[6].equals("-prune")) {
								game.setPrune(true);
							}
							if (args[7].equals("-tree")) {
								game.setTreeMode(true);
							} else {
								System.out.println("Invalid arguments");
							}
						}
					}
				}
				game.setPlayer(Integer.valueOf(args[3]));
				Point point = game.miniMax(game.getBoard(), game.getN(), game
						.getCurrentPlayer());
				if (point == null) {
					System.out.println("No existe jugada posible");
				} else {
					System.out.println("El mejor punto a jugar es:"
							+ point.getX() + ", " + point.getY());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid File");
			return;
		}

	}
}
