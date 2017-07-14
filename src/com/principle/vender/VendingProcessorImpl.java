package com.principle.vender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VendingProcessorImpl implements VendingProcessor {
	private CoinReserve coinReserve = new CoinReserve();

	public  VendingProcessorImpl() {
		initialize();
	}

	public  VendingProcessorImpl(boolean loadfromfile) {
		if (loadfromfile) coinReserve = CoinLoader.loadCoinsFromInventory();
	}
	private void initialize() {
		// initialize vendor with 1000000 coins for all the denominations
		//so that coins do not exist soon.
		for (Coin c : Coin.values()) {
			coinReserve.put(c, 1000000);
		}
	}

	@Override
	public Collection<Coin> getOptimalChangeFor(int cents) {
		//cents = cents*100;
		List<Coin> changes = new ArrayList<Coin>();
		int remainingCents = cents;
		if (cents > 0) {

			while (remainingCents > 0) {
				if (remainingCents >= Coin.ONE_EURO.getDenomination() && coinReserve.hasCoin(Coin.ONE_EURO)) {
					changes.add(Coin.ONE_EURO);
					coinReserve.deduct(Coin.ONE_EURO);
					remainingCents = remainingCents - Coin.ONE_EURO.getDenomination();
					continue;
				} else if (remainingCents >= Coin.FIFTY_CENTS.getDenomination()
						&& coinReserve.hasCoin(Coin.FIFTY_CENTS)) {
					changes.add(Coin.FIFTY_CENTS);
					coinReserve.deduct(Coin.FIFTY_CENTS);
					remainingCents = remainingCents - Coin.FIFTY_CENTS.getDenomination();
					continue;
				} else if (remainingCents >= Coin.TWENTY_CENTS.getDenomination()
						&& coinReserve.hasCoin(Coin.TWENTY_CENTS)) {
					changes.add(Coin.TWENTY_CENTS);
					coinReserve.deduct(Coin.TWENTY_CENTS);
					remainingCents = remainingCents - Coin.TWENTY_CENTS.getDenomination();
					continue;
				} else if (remainingCents >= Coin.TEN_CENTS.getDenomination() && coinReserve.hasCoin(Coin.TEN_CENTS)) {
					changes.add(Coin.TEN_CENTS);
					coinReserve.deduct(Coin.TEN_CENTS);
					remainingCents = remainingCents - Coin.TEN_CENTS.getDenomination();
					continue;
				} else if (remainingCents >= Coin.FIVE_CENTS.getDenomination()
						&& coinReserve.hasCoin(Coin.FIVE_CENTS)) {
					changes.add(Coin.FIVE_CENTS);
					coinReserve.deduct(Coin.FIVE_CENTS);
					remainingCents = remainingCents - Coin.FIVE_CENTS.getDenomination();
					continue;
				} else if (remainingCents >= Coin.TWO_CENTS.getDenomination()
						&& coinReserve.hasCoin(Coin.TWO_CENTS)) {
					changes.add(Coin.TWO_CENTS);
					coinReserve.deduct(Coin.TWO_CENTS);
					remainingCents = remainingCents - Coin.TWO_CENTS.getDenomination();
					continue;
				}
				  else if (remainingCents >= Coin.ONE_CENT.getDenomination() && coinReserve.hasCoin(Coin.ONE_CENT)) {
					changes.add(Coin.ONE_CENT);
					coinReserve.deduct(Coin.ONE_CENT);
					remainingCents = remainingCents - Coin.ONE_CENT.getDenomination();
					continue;
				} else {
					throw new NoChangeAvailableException("Not enough change available, Please try lesser value");
				}
			}
		}
		CoinLoader.saveCoinsToInventory(coinReserve);
		return changes;
	}

}
