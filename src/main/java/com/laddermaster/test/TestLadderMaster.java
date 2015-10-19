package com.laddermaster.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.laddermaster.game.elements.GameBoard;
import com.laddermaster.game.elements.Player;
import com.laddermaster.game.runner.GameRunner;
import com.laddermaster.game.runner.GameRunnerImpl;
import com.laddermaster.test.TestGameBoardFactory.SnakeLadderTestCase;

/**
 * Junit test class.
 * 
 * @author Sameer Bhilare
 *
 */

public class TestLadderMaster {

	/**
	 * This test is for valid Game Board scenario.
	 * And the structure of the board (i.e. position of snakes, ladders on the board) 
	 * mimics that of image given in problem statement of the document.  
	 */
	@Test
	public void testValidGameBoard(){
		
		System.out.println("====== TEST testValidGameBoard() START =====");
		
		GameBoard gameBoard = TestGameBoardFactory.createGameBoard(SnakeLadderTestCase.VALID_GAME_BOARD);
		System.out.println(gameBoard);
		GameRunner gameRunner = new GameRunnerImpl();
		Player winner = gameRunner.playSnakeLadderGame(gameBoard);
		Assert.assertNotNull(winner);
		System.out.println("And... The Winner is - "+winner.getPlayerName());
		
		System.out.println("====== TEST testValidGameBoard() END =====\n\n");
	}
	
	/**
	 * Test case - when Snake's head and tail positions are invalid.
	 */
	@Test
	public void testInvalidSnakeGameBoard(){
		
		System.out.println("====== TEST testInvalidSnakeGameBoard() START =====");
		
		GameBoard gameBoard = TestGameBoardFactory.createGameBoard(SnakeLadderTestCase.INVALID_SNAKE_POSITIONS);
		System.out.println(gameBoard);
		GameRunner gameRunner = new GameRunnerImpl();
		Player winner = gameRunner.playSnakeLadderGame(gameBoard);
		Assert.assertNull(winner);
		
		System.out.println("====== TEST testInvalidSnakeGameBoard() END =====\n\n");
	}
	
	/**
	 * Test case - when Ladder's bottom and top positions are invalid.
	 */
	@Test
	public void testInvalidLadderGameBoard(){
		
		System.out.println("====== TEST testInvalidLadderGameBoard() START =====");
		
		GameBoard gameBoard = TestGameBoardFactory.createGameBoard(SnakeLadderTestCase.INVALID_LADDER_POSITIONS);
		System.out.println(gameBoard);
		GameRunner gameRunner = new GameRunnerImpl();
		Player winner = gameRunner.playSnakeLadderGame(gameBoard);
		Assert.assertNull(winner);
		
		System.out.println("====== TEST testInvalidLadderGameBoard() END =====\n\n");
	}
	
	
	/**
	 * Test case - when Ladder's bottom and top positions are out of the board.
	 */
	@Test
	public void testOutOfBoardLadderGameBoard(){
		
		System.out.println("====== TEST testOutOfBoardLadderGameBoard() START =====");
		
		GameBoard gameBoard = TestGameBoardFactory.createGameBoard(SnakeLadderTestCase.OUT_OF_RANGE_LADDER);
		System.out.println(gameBoard);
		GameRunner gameRunner = new GameRunnerImpl();
		Player winner = gameRunner.playSnakeLadderGame(gameBoard);
		Assert.assertNull(winner);
		
		System.out.println("====== TEST testOutOfBoardLadderGameBoard() END =====\n\n");
	}
	
	/**
	 * Test case - when Snake's head and tail positions are out of the board.
	 */
	@Test
	public void testOutOfBoardSnakeGameBoard(){
		
		System.out.println("====== TEST testOutOfBoardSnakeGameBoard() START =====");
		
		GameBoard gameBoard = TestGameBoardFactory.createGameBoard(SnakeLadderTestCase.OUT_OF_RANGE_SNAKE);
		System.out.println(gameBoard);
		GameRunner gameRunner = new GameRunnerImpl();
		Player winner = gameRunner.playSnakeLadderGame(gameBoard);
		Assert.assertNull(winner);
		
		System.out.println("====== TEST testOutOfBoardSnakeGameBoard() END =====\n\n");
	}
	
	
}
