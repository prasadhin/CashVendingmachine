package com.principle.vender;
import java.util.Collection;

public interface VendingProcessor {
	public Collection<Coin> getOptimalChangeFor(int cents);
}
