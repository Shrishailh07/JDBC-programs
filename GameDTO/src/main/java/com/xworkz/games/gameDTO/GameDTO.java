package com.xworkz.games.gameDTO;

public class GameDTO 
{
private int gameId;
private String gameName;
private int noOfPlayers;
private String type;

public GameDTO()
{	
}


public GameDTO(int gameId, String gameName, int noOfPlayers, String type) {
	super();
	this.gameId = gameId;
	this.gameName = gameName;
	this.noOfPlayers = noOfPlayers;
	this.type = type;
}


public int getGameId() {
	return gameId;
}
public void setGameId(int gameId) {
	this.gameId = gameId;
}
public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public int getNoOfPlayers() {
	return noOfPlayers;
}
public void setNoOfPlayers(int noOfPlayers) {
	this.noOfPlayers = noOfPlayers;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}
