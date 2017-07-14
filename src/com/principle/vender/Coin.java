package com.principle.vender;

public enum Coin {
	ONE_EURO(100),
	FIFTY_CENTS(50),
	TWENTY_CENTS(20),
	TEN_CENTS(10),
	FIVE_CENTS(5),
	TWO_CENTS(2),
	ONE_CENT(1);

	private int denomination;
	private Coin(int denomination){
		this.denomination = denomination; 
	} 

	public int getDenomination(){
		return denomination; }

}
