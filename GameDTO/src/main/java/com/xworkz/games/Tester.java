package com.xworkz.games;
import java.util.Scanner;

import com.xworkz.games.gameDAO.GameDAO;
import com.xworkz.games.gameDTO.GameDTO;
public class Tester 
{
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a game id");
	int id = scanner.nextInt();
	
	System.out.println("Enter a game name");
	String name = scanner.next();
	
	System.out.println("Enter no of players");
	int Player = scanner.nextInt();
	
	System.out.println("Enter a game type");
	String type = scanner.next();
	
	GameDTO dto = new GameDTO(id,name,Player,type);
	
	boolean SaveStatus = GameDAO.saveGame(dto);
	if(SaveStatus)
	{
		System.out.println("Saved Successfully");
	}
	else
	{
		System.out.println("Saved Unsuccessfully");
	}
}
}
