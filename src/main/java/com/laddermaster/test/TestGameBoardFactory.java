package com.laddermaster.test;

import java.util.ArrayList;
import java.util.List;

import com.laddermaster.game.elements.Dice;
import com.laddermaster.game.elements.GameBoard;
import com.laddermaster.game.elements.Ladder;
import com.laddermaster.game.elements.Player;
import com.laddermaster.game.elements.Snake;

/**
 * Factory class for creating instances of GameBoard objects for Testing purpose.
 * 
 * @author Sameer Bhilare
 *
 */
public class TestGameBoardFactory {

	private TestGameBoardFactory() {

	}

	enum SnakeLadderTestCase {
		VALID_GAME_BOARD, INVALID_SNAKE_POSITIONS, OUT_OF_RANGE_SNAKE, INVALID_LADDER_POSITIONS, OUT_OF_RANGE_LADDER
	}

	public static GameBoard createGameBoard(SnakeLadderTestCase testcase) {

		GameBoard gameBoard = new GameBoard();

		gameBoard.setBoardWidth(10);
		gameBoard.setBoardHeight(10);
		gameBoard.setSnakesList(populateSnakesForGame(testcase));
		gameBoard.setLaddersList(populateLaddersForGame(testcase));
		gameBoard.setDice(new Dice());
		gameBoard.setPlayersList(populatePlayersForGame(testcase));

		return gameBoard;
	}

	private static List<Player> populatePlayersForGame(SnakeLadderTestCase testcase) {

		List<Player> playersList = new ArrayList<Player>();

		Player player1 = new Player();
		player1.setPlayerName("A");
		player1.setCurrentPosition(0);
		playersList.add(player1);

		Player player2 = new Player();
		player2.setPlayerName("B");
		player2.setCurrentPosition(0);
		playersList.add(player2);

		return playersList;
	}

	private static List<Ladder> populateLaddersForGame(SnakeLadderTestCase testcase) {

		List<Ladder> laddersList = new ArrayList<Ladder>();

		Ladder ladder1 = new Ladder();
		ladder1.setBottomPosition(4);
		ladder1.setTopPosition(14);
		laddersList.add(ladder1);

		Ladder ladder2 = new Ladder();
		switch(testcase){
			case INVALID_LADDER_POSITIONS :
				ladder2.setBottomPosition(31);
				ladder2.setTopPosition(9);
				break;
				
			case OUT_OF_RANGE_LADDER :
				ladder2.setBottomPosition(200);
				ladder2.setTopPosition(200);
				break;
				
			default:
				ladder2.setBottomPosition(9);
				ladder2.setTopPosition(31);
				break;
		}
		
		laddersList.add(ladder2);

		Ladder ladder3 = new Ladder();
		ladder3.setBottomPosition(20);
		ladder3.setTopPosition(38);
		laddersList.add(ladder3);

		Ladder ladder4 = new Ladder();
		ladder4.setBottomPosition(28);
		ladder4.setTopPosition(84);
		laddersList.add(ladder4);

		Ladder ladder5 = new Ladder();
		ladder5.setBottomPosition(40);
		ladder5.setTopPosition(59);
		laddersList.add(ladder5);

		Ladder ladder6 = new Ladder();
		ladder6.setBottomPosition(51);
		ladder6.setTopPosition(67);
		laddersList.add(ladder6);

		Ladder ladder7 = new Ladder();
		ladder7.setBottomPosition(63);
		ladder7.setTopPosition(81);
		laddersList.add(ladder7);

		Ladder ladder8 = new Ladder();
		ladder8.setBottomPosition(71);
		ladder8.setTopPosition(91);
		laddersList.add(ladder8);

		return laddersList;
	}

	private static List<Snake> populateSnakesForGame(SnakeLadderTestCase testcase) {

		List<Snake> snakesList = new ArrayList<Snake>();

		Snake snake1 = new Snake();
		snake1.setHeadPosition(17);
		snake1.setTailposition(7);
		snakesList.add(snake1);

		Snake snake2 = new Snake();
		switch(testcase){
			case INVALID_SNAKE_POSITIONS :
				snake2.setHeadPosition(34);
				snake2.setTailposition(54);
				break;
				
			case OUT_OF_RANGE_SNAKE :
				snake2.setHeadPosition(200);
				snake2.setTailposition(200);
				break;
				
			default:
				snake2.setHeadPosition(54);
				snake2.setTailposition(34);
				break;
		}
		
		snakesList.add(snake2);

		Snake snake3 = new Snake();
		snake3.setHeadPosition(62);
		snake3.setTailposition(19);
		snakesList.add(snake3);

		Snake snake4 = new Snake();
		snake4.setHeadPosition(64);
		snake4.setTailposition(60);
		snakesList.add(snake4);

		Snake snake5 = new Snake();
		snake5.setHeadPosition(87);
		snake5.setTailposition(24);
		snakesList.add(snake5);

		Snake snake6 = new Snake();
		snake6.setHeadPosition(93);
		snake6.setTailposition(73);
		snakesList.add(snake6);

		Snake snake7 = new Snake();
		snake7.setHeadPosition(95);
		snake7.setTailposition(75);
		snakesList.add(snake7);

		Snake snake8 = new Snake();
		snake8.setHeadPosition(99);
		snake8.setTailposition(78);
		snakesList.add(snake8);

		return snakesList;
	}
}
