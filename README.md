# CashVendingmachine
Simple Vending machine which gives change for cents given.

Java Programming Assessment
The source code contains program written in java to implement logic for a vending machine that will return the optimal change for a given number of Euro as cents. 
The following denominations of coin available with vending machine for providing change.
o One Euro = 100 
o Fifty cents = 50 
o Twenty cents = 20 
o Ten cents = 10 
o Five cents = 5 
o Two cents = 2 
o One cent = 1 

It has two scenarios, 
Scenario 1
Cash vending machine has infinite number of coins in various denominations, and will dispense change for the given cents, with minimum coins as output.
For example.If users inputs 457 cents, the vending machine will give the following coins as output.
4 coins of 1 Euro
1 coin of 50 cents
1 coin of 5 cents.
1 coin of 2 cents

Solution:
1.Interface VendingProcessor with the method signature for providing change is
public Collection<Coin> getOptimalChangeFor(int cents)
2.Implementation of interface is done by class VendingProcessorImpl.
3.If instance of VendingProcessorImpl is called with argument as false, then the vending machine loads infinite number of coins, and provides change with minimum number of coins as output.
4.To test the code TestUnlimitedVending class is run, with cashToBeChanged variable set as input, that is given number of cents to be changed.




Scenario 2
Cash vending machine has limited number of coins in various denominations,
The machine will load the available coins from coin-inventory.properties
 and will dispense change for the given cents, with available coins as output.

Solution:
1.Interface VendingProcessor with the method signature for providing change is
public Collection<Coin> getOptimalChangeFor(int cents)
2.Implementation of interface is done by class VendingProcessorImpl.
3.If instance of VendingProcessorImpl is called with argument as true, then the vending machine loads the number of coins into a hashMap, and provides change with minimum number of coins as output.
4.After providing the change, the code updates the properties file with remaing coins.
4.To test the code TestLimitedVending class is run, with cashToBeChanged variable set as input, that is given number of cents to be changed.


Java Code details
1.	VendingProcessor - Interface with method signature for getting change.
2.	VendingProcessorImpl – Implementation of method for getting change logic.
3.	CoinLoader – 
Class contains method saveCoinsToInventory to persist the remaining coins into file system after dispesing the change. 
Method loadCoinsFromInventory to read number of coins available for each denomination so that it can be dispensed.
Method persistCoins which can be used to initialise the file system with required denominations.
4.	Enumerator Coin to hold the coin description and coin value.
5.	Class CoinReservce a HashMap datastructure implementation to hold changes dispensed and also to hold coins available.
6.	Class TestLimitedVending to check the code for limited vending machine logic.
7.	Class TestLimitedVending to check the code for vending machine, with continuous supply of coins.

  

