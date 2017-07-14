package com.principle.vender;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class CoinLoader {
	
	public void persistCoins(){
		// use this method to load coins in machine
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("coin-inventory.properties");
			prop.setProperty("100", "11");
			prop.setProperty("50", "24");
			prop.setProperty("20", "0");
			prop.setProperty("10", "99");
			prop.setProperty("5", "200");
			prop.setProperty("2", "11");
			prop.setProperty("1", "23");
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
	}
	}

	public static CoinReserve loadCoinsFromInventory(){
		Properties prop = new Properties();
		InputStream input = null;
		CoinReserve coinReserve = new CoinReserve();

		try {

			input = new FileInputStream("coin-inventory.properties");

			// load a properties file
			prop.load(input);
			for (Coin c : Coin.values()) {
				coinReserve.put(c, Integer.parseInt(prop.getProperty(""+c.getDenomination())));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return coinReserve;

	  }
	
	public static void saveCoinsToInventory(CoinReserve coinReserve){
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("coin-inventory.properties");
			for (Coin c : Coin.values()) {
				prop.setProperty(c.getDenomination()+"", coinReserve.getTotalCoinsForDenomination(c)+"");
			}
			prop.store(output, null);
			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinLoader cl = new CoinLoader();
		cl.persistCoins();
		cl.loadCoinsFromInventory();
        
	}

}
