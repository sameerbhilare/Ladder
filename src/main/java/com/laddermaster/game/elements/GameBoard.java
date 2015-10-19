package com.laddermaster.game.elements;

import java.util.List;

/**
 * Represents a Game board instance which composes all the game elements.
 * 
 * @author Sameer Bhilare
 *
 */
public class GameBoard {

	int boardWidth = 0;
	int boardHeight = 0;
	List<Snake> snakesList = null;
	List<Ladder> laddersList = null;
	List<Player> playersList = null;
	Dice dice = null;
		
	public int getBoardWidth() {
		return boardWidth;
	}
	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}
	public int getBoardHeight() {
		return boardHeight;
	}
	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public List<Snake> getSnakesList() {
		return snakesList;
	}
	public void setSnakesList(List<Snake> snakesList) {
		this.snakesList = snakesList;
	}
	public List<Ladder> getLaddersList() {
		return laddersList;
	}
	public void setLaddersList(List<Ladder> laddersList) {
		this.laddersList = laddersList;
	}
	public List<Player> getPlayersList() {
		return playersList;
	}
	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}
	public int getBoardLastPosition() {
		return this.boardWidth * this.boardHeight;
	}
	
	/**
	 * Before we begin the game, we must validate the Game Board.
	 * 
	 * <li> checks if the Snakes' head and tail positions are valid.
	 * <li> checks if the Ladders' bottom and top positions are valid.
	 * 
	 * @return true if board is valid.
	 */
	public boolean validateGameBoard(){
		
		int boardLastPosition = getBoardLastPosition();
		
		// validate snakes.
		if(snakesList != null){
			
			for(Snake snake : snakesList){
				
				if(snake.getHeadPosition() > boardLastPosition || snake.getTailposition() < 1
						|| snake.getTailposition() > boardLastPosition || snake.getTailposition() < 1) {
					throw new RuntimeException("Snake's Head and/or Tail positions are out of board range.");
				}
				if(snake.getHeadPosition() <= snake.getTailposition()) {
					throw new RuntimeException("Snake Head position must not be less than Tail position.");
				}
			}
		} else {
			throw new RuntimeException("There are NO snakes on the board.");
		}
		
		// vaildate Ladders.
		if(laddersList != null){
			
			for(Ladder ladder : laddersList){
				
				if(ladder.getBottomPosition() > boardLastPosition || ladder.getBottomPosition() < 1
						|| ladder.getTopPosition() > boardLastPosition || ladder.getTopPosition() < 1) {
					throw new RuntimeException("Ladder's Bottom and/or Top positions are out of board range.");
				}
				if(ladder.getTopPosition() <= ladder.getBottomPosition()) {
					throw new RuntimeException("Ladder Top position must not be less than Bottom position.");
				}
			}
		} else {
			throw new RuntimeException("There are NO Ladders on the board.");
		}
				
		return true;
	}
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("Game Board => [ ");
		builder.append("\n\tBoard Dimensions = ");
		builder.append(this.boardWidth);
		builder.append(" X ");
		builder.append(this.boardHeight);
		builder.append(", ");
		builder.append("\n\tLadder List = ");
		builder.append(this.laddersList);
		builder.append(", ");
		builder.append("\n\tSnakes List = ");
		builder.append(this.snakesList);
		builder.append(", ");
		builder.append("\n\tPlayers List = ");
		builder.append(this.playersList);
		builder.append(" ]\n");
		
		return builder.toString();
	}
}
