package com.principle.vender;

import java.util.Collection;

public class TestUnlimitedVending {

	public static void main(String[] args) {
		// This vending machine has unlimited number of coins, like tree of
		// money
		// number of coins for each denomination is available without any
		// limits.

		int cashToBeChanged = 900;
		VendingProcessor vp = new VendingProcessorImpl();
		Collection<Coin> changes = vp.getOptimalChangeFor(cashToBeChanged);
		changes.forEach(System.out::println);
		

	}

}
