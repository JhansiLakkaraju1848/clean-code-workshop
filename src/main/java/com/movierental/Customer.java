package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    for (Rental rental : rentals) {
      result += "\t" + rental.getMovie().getTitle() + "\t" +
          String.valueOf(rental.amount()) + "\n";
    }

    //add footer lines result
    result += "Amount owed is " + totalAmount() + "\n";
    result += "You earned " + totalFrequentRenterPoints()
        + " frequent renter points";
    return result;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.amount();
    }
    return totalAmount;
  }

  private int totalFrequentRenterPoints() {
    int totalFrequentRenterPoints = 0;
    for (Rental rental : rentals) {
      totalFrequentRenterPoints += rental.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
  }
}

