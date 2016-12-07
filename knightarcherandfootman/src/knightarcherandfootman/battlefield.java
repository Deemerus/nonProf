package knightarcherandfootman;

import java.util.ArrayList;

import troops.Troop;

public interface battlefield {
	ArrayList<Troop> playerLeftFlank = new ArrayList<Troop>();
	ArrayList<Troop> playerMiddleFlank = new ArrayList<Troop>();
	ArrayList<Troop> playerRightFlank = new ArrayList<Troop>();
	ArrayList<Troop> opponentLeftFlank = new ArrayList<Troop>();
	ArrayList<Troop> opponentMiddleFlank = new ArrayList<Troop>();
	ArrayList<Troop> opponentRightFlank = new ArrayList<Troop>();
}
