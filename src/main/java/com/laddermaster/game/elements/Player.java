package com.laddermaster.game.elements;

/**
 * Represents a Player of the Game.
 * 
 * @author Sameer Bhilare
 *
 */
public class Player {

	private String playerName = null;
	private int currentPosition = 0;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	@Override
	public String toString() {
		
		return " Player (Name = "+playerName+", currentPosition = "+currentPosition+") ";
	}
}
