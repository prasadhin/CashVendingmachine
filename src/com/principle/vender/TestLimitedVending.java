package com.principle.vender;

import java.util.Collection;

public class TestLimitedVending {

	public static void main(String[] args) {
		//This vending machine has limited number of coins
		// number of coins for each denomination is loaded from
		//file coin-inventory.properties, and then change is dispensed
		// by the vending machine if it has sufficient change.
		int cashToBeChanged = 445;
		
		VendingProcessor vp = new VendingProcessorImpl(true);
		Collection<Coin> changes = vp.getOptimalChangeFor(cashToBeChanged);
		
		//Printing the coins dispensed.
		changes.forEach(System.out::println);

	}

}
