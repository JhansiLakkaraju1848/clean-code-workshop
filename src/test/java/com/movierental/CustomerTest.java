package com.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void shouldTestStatement(){
        Customer customer = new Customer("Prakash");
        customer.addRental(new Rental(new Movie("Jhansi the Timekeeper", Movie.CHILDRENS), 4));
        customer.addRental(new Rental(new Movie("Movie 2", Movie.REGULAR), 7));
        customer.addRental(new Rental(new Movie("Movie 3", Movie.NEW_RELEASE), 2));

        String statement = customer.statement();

        Assert.assertEquals(statement, "Rental Record for Prakash\n" +
                "\tJhansi the Timekeeper\t3.0\n" +
                "\tMovie 2\t9.5\n" +
                "\tMovie 3\t6.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points");
    }

}