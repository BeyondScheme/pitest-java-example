package com.beyondscheme.pitest;

import java.util.List;

public class TicketPriceCalculator {

    private static int ADULT_AGE = 18;
    private static int FREE_TICKET_AGE_BELOW = 3;
    public static double FAMILY_DISCOUNT = 0.05;

    public double calculatePrice(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPrice = 0;
        int childrenCounter = 0;
        int adultCounter = 0;
        double result;
        for (Passenger passenger : passengers) {
            if (passenger.getAge() > ADULT_AGE) {
                totalPrice += adultTicketPrice;
                adultCounter++;
            } else if (passenger.getAge() > FREE_TICKET_AGE_BELOW) {
                totalPrice += childTicketPrice;
                childrenCounter++;
            }
        }

        if (childrenCounter > 1 && adultCounter > 1) {
            result = (1 - FAMILY_DISCOUNT) * totalPrice;
        } else {
            result = totalPrice;
        }

        return result;
    }
}
