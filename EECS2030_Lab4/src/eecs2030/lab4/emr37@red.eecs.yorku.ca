package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. 
 * A piggy bank owns a collection (or possibly collections) of coins,
 * but does not own the coins themselves. In other words,
 * the piggy bank and its collection of coins form a composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins
 * from the piggy bank. The piggy bank does own its owner.
 * In other words, the piggy bank and its owner form an
 * aggregation.
 */
public class OwnedPiggyBank {
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */
	ArrayList<Coin> coins;

	/**
	 * The owner of this pigyg bank.
	 */
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner
	 * and its collection of coins is empty.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		coins = new ArrayList<>();
		this.owner = owner;		
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy
	 * bank will have the same owner and the same number and type of coins as
	 * the other piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.owner;
		this.coins = new ArrayList<>();

		for (Coin coin : other.coins) {
			this.coins.add(coin);
		}

	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning
	 * the owner of this piggy bank allows any user to remove coins
	 * from the piggy bank (because any user can get the owner
	 * of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}
	
	/**
	 * Allows the current owner of this piggy bank to give this
	 * piggy bank to a new owner.
	 * 
	 * @param currentOwner the current owner of this piggy bank
	 * @param newOwner the new owner of this piggy bank
	 * @throws IllegalArgumentException if currentOwner is not the
	 * current owner of this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) throws IllegalArgumentException {

		if (!currentOwner.equals(this.owner)) {
			throw new IllegalArgumentException();
		} else {
			this.owner = newOwner;
		}
		
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {

		for (Coin coin : coins) {
			this.coins.add(coin);
		}
		
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		return coins.contains(coin);
	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value
	 * of the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank,
	 * then the coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy
	 *         bank, or null if user is not the owner of this piggy bank
	 * @pre. the piggy bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		Coin coinToReturn = null;

		if (!this.owner.equals(user)) {
			return null;
		} else {

			for (Coin c : this.coins) {

				if (c.toString().equals(coin.toString())) {
					coinToReturn = c;
				}

			}

			coins.remove(coinToReturn);
			return coinToReturn;
		}
		
	}

	/**
	 * Allows the owner of this piggy bank to remove
	 * the smallest number of coins whose total value in cents is equal
	 * to the specified value in cents from this piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to
	 * the owner of this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal
	 *         to the specified value in cents from this piggy bank 
	 * @pre. the piggy bank contains a group of coins whose total value is equal
	 *         to specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		
		if (!this.owner.equals(user)) {
			return new ArrayList<>();
		} else {
			ArrayList<Coin> removedCoins = new ArrayList<>();
			int numOfT = 0;
			int numOfL = 0;
			int numOfQ = 0;
			int numOfD = 0;
			int numOfN = 0;
			int numOfP = 0;

			for (Coin c : coins) {

				if (c.toString().equals("toonie")) {
					numOfT++;
				} else if (c.toString().equals("loonie")) {
					numOfL++;
				} else if (c.toString().equals("quarter")) {
					numOfQ++;
				} else if (c.toString().equals("dime")) {
					numOfD++;
				} else if (c.toString().equals("nickel")) {
					numOfN++;
				} else if (c.toString().equals("penny")) {
					numOfP++;
				}

			}

			if (value >= 200) {
				int numOfTNeeded = value / 200;

				while (numOfTNeeded != 0 && numOfT != 0) {
					value -= 200;
					removedCoins.add(this.remove(user, Coin.TOONIE));
					numOfTNeeded--;
					numOfT--;
				}

				if (value >= 100) {
					int numOfLNeeded = value / 100;

					while (numOfLNeeded != 0 && numOfL != 0) {
						value -= 100;
						removedCoins.add(this.remove(user, Coin.LOONIE));
						numOfLNeeded--;
						numOfL--;
					}

					if (value >= 25) {
						int numOfQNeeded = value / 25;

						while (numOfQNeeded != 0 && numOfQ != 0) {
							value -= 25;
							removedCoins.add(this.remove(user, Coin.QUARTER));
							numOfQNeeded--;
							numOfQ--;
						}

						if (value >= 10) {
							int numOfDNeeded = value / 10;

							while (numOfDNeeded != 0 && numOfD != 0) {
								value -= 10;
								removedCoins.add(this.remove(user, Coin.DIME));
								numOfDNeeded--;
								numOfD--;
							}

							if (value >= 5) {
								int numOfNNeeded = value / 5;

								while (numOfNNeeded != 0 && numOfN != 0) {
									value -= 5;
									removedCoins.add(this.remove(user, Coin.NICKEL));
									numOfNNeeded--;
									numOfN--;
								}

								if (value > 0) {
									int numOfPNeeded = value / 1;

									while (numOfPNeeded != 0 && numOfP != 0) {
										value -= 1;
										removedCoins.add(this.remove(user, Coin.PENNY));
										numOfPNeeded--;
										numOfP--;
									}

								}

							} else if (value > 0) {
								int numOfPNeeded = value / 1;

								while (numOfPNeeded != 0 && numOfP != 0) {
									value -= 1;
									removedCoins.add(this.remove(user, Coin.PENNY));
									numOfPNeeded--;
									numOfP--;
								}

							}

						} else if (value >= 5) {
							int numOfNNeeded = value / 5;

							while (numOfNNeeded != 0 && numOfN != 0) {
								value -= 5;
								removedCoins.add(this.remove(user, Coin.NICKEL));
								numOfNNeeded--;
								numOfN--;
							}

							if (value > 0) {
								int numOfPNeeded = value / 1;

								while (numOfPNeeded != 0 && numOfP != 0) {
									value -= 1;
									removedCoins.add(this.remove(user, Coin.PENNY));
									numOfPNeeded--;
									numOfP--;
								}

							}

						} else if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value >= 10) {
						int numOfDNeeded = value / 10;

						while (numOfDNeeded != 0 && numOfD != 0) {
							value -= 10;
							removedCoins.add(this.remove(user, Coin.DIME));
							numOfDNeeded--;
							numOfD--;
						}

						if (value >= 5) {
							int numOfNNeeded = value / 5;

							while (numOfNNeeded != 0 && numOfN != 0) {
								value -= 5;
								removedCoins.add(this.remove(user, Coin.NICKEL));
								numOfNNeeded--;
								numOfN--;
							}

							if (value > 0) {
								int numOfPNeeded = value / 1;

								while (numOfPNeeded != 0 && numOfP != 0) {
									value -= 1;
									removedCoins.add(this.remove(user, Coin.PENNY));
									numOfPNeeded--;
									numOfP--;
								}

							}

						} else if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 25) {
					int numOfQNeeded = value / 25;

					while (numOfQNeeded != 0 && numOfQ != 0) {
						value -= 25;
						removedCoins.add(this.remove(user, Coin.QUARTER));
						numOfQNeeded--;
						numOfQ--;
					}

					if (value >= 10) {
						int numOfDNeeded = value / 10;

						while (numOfDNeeded != 0 && numOfD != 0) {
							value -= 10;
							removedCoins.add(this.remove(user, Coin.DIME));
							numOfDNeeded--;
							numOfD--;
						}

						if (value >= 5) {
							int numOfNNeeded = value / 5;

							while (numOfNNeeded != 0 && numOfN != 0) {
								value -= 5;
								removedCoins.add(this.remove(user, Coin.NICKEL));
								numOfNNeeded--;
								numOfN--;
							}

							if (value > 0) {
								int numOfPNeeded = value / 1;

								while (numOfPNeeded != 0 && numOfP != 0) {
									value -= 1;
									removedCoins.add(this.remove(user, Coin.PENNY));
									numOfPNeeded--;
									numOfP--;
								}

							}

						} else if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 10) {
					int numOfDNeeded = value / 10;

					while (numOfDNeeded != 0 && numOfD != 0) {
						value -= 10;
						removedCoins.add(this.remove(user, Coin.DIME));
						numOfDNeeded--;
						numOfD--;
					}

					if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 5) {
					int numOfNNeeded = value / 5;

					while (numOfNNeeded != 0 && numOfN != 0) {
						value -= 5;
						removedCoins.add(this.remove(user, Coin.NICKEL));
						numOfNNeeded--;
						numOfN--;
					}

					if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value > 0) {
					int numOfPNeeded = value / 1;

					while (numOfPNeeded != 0 && numOfP != 0) {
						value -= 1;
						removedCoins.add(this.remove(user, Coin.PENNY));
						numOfPNeeded--;
						numOfP--;
					}

				}

			} else if (value >= 100) {
				int numOfLNeeded = value / 100;

				while (numOfLNeeded != 0 && numOfL != 0) {
					value -= 100;
					removedCoins.add(this.remove(user, Coin.LOONIE));
					numOfLNeeded--;
					numOfL--;
				}

				if (value >= 25) {
					int numOfQNeeded = value / 25;

					while (numOfQNeeded != 0 && numOfQ != 0) {
						value -= 25;
						removedCoins.add(this.remove(user, Coin.QUARTER));
						numOfQNeeded--;
						numOfQ--;
					}

					if (value >= 10) {
						int numOfDNeeded = value / 10;

						while (numOfDNeeded != 0 && numOfD != 0) {
							value -= 10;
							removedCoins.add(this.remove(user, Coin.DIME));
							numOfDNeeded--;
							numOfD--;
						}

						if (value >= 5) {
							int numOfNNeeded = value / 5;

							while (numOfNNeeded != 0 && numOfN != 0) {
								value -= 5;
								removedCoins.add(this.remove(user, Coin.NICKEL));
								numOfNNeeded--;
								numOfN--;
							}

							if (value > 0) {
								int numOfPNeeded = value / 1;

								while (numOfPNeeded != 0 && numOfP != 0) {
									value -= 1;
									removedCoins.add(this.remove(user, Coin.PENNY));
									numOfPNeeded--;
									numOfP--;
								}

							}

						} else if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 10) {
					int numOfDNeeded = value / 10;

					while (numOfDNeeded != 0 && numOfD != 0) {
						value -= 10;
						removedCoins.add(this.remove(user, Coin.DIME));
						numOfDNeeded--;
						numOfD--;
					}

					if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 5) {
					int numOfNNeeded = value / 5;

					while (numOfNNeeded != 0 && numOfN != 0) {
						value -= 5;
						removedCoins.add(this.remove(user, Coin.NICKEL));
						numOfNNeeded--;
						numOfN--;
					}

					if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value > 0) {
					int numOfPNeeded = value / 1;

					while (numOfPNeeded != 0 && numOfP != 0) {
						value -= 1;
						removedCoins.add(this.remove(user, Coin.PENNY));
						numOfPNeeded--;
						numOfP--;
					}

				}

			} else if (value >= 25) {
				int numOfQNeeded = value / 25;

				while (numOfQNeeded != 0 && numOfQ != 0) {
					value -= 25;
					removedCoins.add(this.remove(user, Coin.QUARTER));
					numOfQNeeded--;
					numOfQ--;
				}

				if (value >= 10) {
					int numOfDNeeded = value / 10;

					while (numOfDNeeded != 0 && numOfD != 0) {
						value -= 10;
						removedCoins.add(this.remove(user, Coin.DIME));
						numOfDNeeded--;
						numOfD--;
					}

					if (value >= 5) {
						int numOfNNeeded = value / 5;

						while (numOfNNeeded != 0 && numOfN != 0) {
							value -= 5;
							removedCoins.add(this.remove(user, Coin.NICKEL));
							numOfNNeeded--;
							numOfN--;
						}

						if (value > 0) {
							int numOfPNeeded = value / 1;

							while (numOfPNeeded != 0 && numOfP != 0) {
								value -= 1;
								removedCoins.add(this.remove(user, Coin.PENNY));
								numOfPNeeded--;
								numOfP--;
							}

						}

					} else if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value >= 5) {
					int numOfNNeeded = value / 5;

					while (numOfNNeeded != 0 && numOfN != 0) {
						value -= 5;
						removedCoins.add(this.remove(user, Coin.NICKEL));
						numOfNNeeded--;
						numOfN--;
					}

					if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value > 0) {
					int numOfPNeeded = value / 1;

					while (numOfPNeeded != 0 && numOfP != 0) {
						value -= 1;
						removedCoins.add(this.remove(user, Coin.PENNY));
						numOfPNeeded--;
						numOfP--;
					}

				}

			} else if (value >= 10) {
				int numOfDNeeded = value / 10;

				while (numOfDNeeded != 0 && numOfD != 0) {
					value -= 10;
					removedCoins.add(this.remove(user, Coin.DIME));
					numOfDNeeded--;
					numOfD--;
				}

				if (value >= 5) {
					int numOfNNeeded = value / 5;

					while (numOfNNeeded != 0 && numOfN != 0) {
						value -= 5;
						removedCoins.add(this.remove(user, Coin.NICKEL));
						numOfNNeeded--;
						numOfN--;
					}

					if (value > 0) {
						int numOfPNeeded = value / 1;

						while (numOfPNeeded != 0 && numOfP != 0) {
							value -= 1;
							removedCoins.add(this.remove(user, Coin.PENNY));
							numOfPNeeded--;
							numOfP--;
						}

					}

				} else if (value > 0) {
					int numOfPNeeded = value / 1;

					while (numOfPNeeded != 0 && numOfP != 0) {
						value -= 1;
						removedCoins.add(this.remove(user, Coin.PENNY));
						numOfPNeeded--;
						numOfP--;
					}

				}

			} else if (value >= 5) {
				int numOfNNeeded = value / 5;

				while (numOfNNeeded != 0 && numOfN != 0) {
					value -= 5;
					removedCoins.add(this.remove(user, Coin.NICKEL));
					numOfNNeeded--;
					numOfN--;
				}

				if (value > 0) {
					int numOfPNeeded = value / 1;

					while (numOfPNeeded != 0 && numOfP != 0) {
						value -= 1;
						removedCoins.add(this.remove(user, Coin.PENNY));
						numOfPNeeded--;
						numOfP--;
					}

				}

			} else if (value > 0) {
				int numOfPNeeded = value / 1;

				while (numOfPNeeded != 0 && numOfP != 0) {
					value -= 1;
					removedCoins.add(this.remove(user, Coin.PENNY));
					numOfPNeeded--;
					numOfP--;
				}

			}

			return removedCoins;
		}			
		
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list
	 * has its coins in sorted order (from smallest value to largest value;
	 * i.e., pennies first, followed by nickels, dimes, quarters, loonies, and
	 * toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		ArrayList<Coin> deepCopiedCoins = new ArrayList<>();

		for (Coin c : coins) {
			deepCopiedCoins.add(new Coin(c));
		}

		Collections.sort(deepCopiedCoins);
		return deepCopiedCoins;
	}
}
