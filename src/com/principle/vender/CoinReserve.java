package com.principle.vender;
import java.util.HashMap;
import java.util.Map;

public class CoinReserve {
	private Map<Coin, Integer> coins = new HashMap<Coin, Integer>();
	public int getTotalCoinsForDenomination(Coin coin){
		Integer totalCoinsForDenomination = coins.get(coin);
		return totalCoinsForDenomination == null? 0 : totalCoinsForDenomination ;
		} 
	
	public void add(Coin coin){ 
		int totalCoinsForDenomination = coins.get(coin);
		coins.put(coin, totalCoinsForDenomination+1);
		} 

	public void deduct(Coin coin) {
		if (hasCoin(coin)) {
			int totalCoinsForDenomination = coins.get(coin);
			coins.put(coin, totalCoinsForDenomination - 1); 
		} 
		}
	public boolean hasCoin(Coin coin){
		return getTotalCoinsForDenomination(coin) > 0;
		} 
	
	public void put(Coin coin, int totalCoinsForDenomination){
	coins.put(coin, totalCoinsForDenomination); 
	} 
	public void clear(){
		coins.clear();
		}
	


}
