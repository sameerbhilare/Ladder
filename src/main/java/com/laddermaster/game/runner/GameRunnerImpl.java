package com.laddermaster.game.runner;

import java.util.List;

import com.laddermaster.game.elements.Dice;
import com.laddermaster.game.elements.GameBoard;
import com.laddermaster.game.elements.Ladder;
import com.laddermaster.game.elements.Player;
import com.laddermaster.game.elements.Snake;

/**
 * Main class from which Game starts.
 * 
 * @author DELL
 *
 */
public class GameRunnerImpl implements GameRunner {

	/**
	 * Play Snake and Ladder Game.
	 * 
	 * <li>Validate the Game board.
	 * <li>For each player, perform below steps.
	 * <li>1. roll dice and as per the number on face of dice, advance the player to current position + number on the dice.
	 * <li>2. if the player's current position = bottom of a ladder, then player's current position = top of that ladder.
	 * <li>3. if the player's current position = head of a snake, then player's current position = tail of that snake.
	 * <li>4. if the player's current position > 100, do not move the player.
	 * <li>5. if the player's current position = 100, the player wins the game. End of Game
	 * <li>Play from step 1, till on of the players wins.
	 * 
	 * returns winner player.
	 */
	@Override
	public Player playSnakeLadderGame(GameBoard gameBoard) {
		
		long startTime = System.currentTimeMillis();
		
		Player winner = null;
		
		try {
			if(gameBoard != null){
				
				// First Validate the Board. 
				boolean isGameBoardValid = gameBoard.validateGameBoard();
				
				if(isGameBoardValid){
					
					Dice dice = gameBoard.getDice();
					List<Player> playersList = gameBoard.getPlayersList();
					int diceFaceValue = 0;
					
					while(winner ==  null) {
						
						for(Player player : playersList) {
							
							diceFaceValue = dice.rollDice();
							System.out.println("Player "+player.getPlayerName()+", current position : "+player.getCurrentPosition() +", Dice Value : "+diceFaceValue);
							int newPosition = player.getCurrentPosition() + diceFaceValue;
							
							// move to the new position.
							if(newPosition <= gameBoard.getBoardLastPosition()) {
								player.setCurrentPosition(newPosition);
							} else{
								continue;
							}
							
							// if new position is head of any snake, then move to the tail of the snake.
							for(Snake snake : gameBoard.getSnakesList()){
								
								if(player.getCurrentPosition() == snake.getHeadPosition()){
									System.out.println("        Damn :( ! Player "+player.getPlayerName()+" eaten by snake at : "+snake.getHeadPosition());
									player.setCurrentPosition(snake.getTailposition());
									break;
								}
							}
							
							// if new position is bottom of any ladder, then move to the top of the snake.
							for(Ladder ladder : gameBoard.getLaddersList()){
								
								if(player.getCurrentPosition() == ladder.getBottomPosition()){
									System.out.println("        Great :) ! Player "+player.getPlayerName()+" climbs ladder at : "+ladder.getBottomPosition());
									player.setCurrentPosition(ladder.getTopPosition());
									break;
								}
							}
							
							if(player.getCurrentPosition() == gameBoard.getBoardLastPosition()){
								winner = player;
								break;
							}
								
						}
						
					}
				}
			}
			System.out.println("Game finished in : "+ (System.currentTimeMillis() - startTime)+" ms.");
		} catch(Exception e){
			System.out.println("Exception while playing Game. "+e);
		}
		
		return winner;
	}

}
