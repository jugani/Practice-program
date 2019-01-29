package com.java.tw;

import  com.java.tw.Rental;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;

    private Vector _rental= new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental args){

        _rental.addElement(args);

    }

    public String getName(){
        return _name;
    }

    public String statement()
    {
     double totalAmount=0;
     int frequentRenterPoints=0;
        Enumeration rentals= _rental.elements();
        String result="Rental records for "+getName()+ "\n";

                while(rentals.hasMoreElements())
                {
                    double thisAmount=0;
                    Rental each = (Rental) rentals.nextElement();

                    thisAmount=each.getCharge();


                    frequentRenterPoints+=each.getFrequentRenterPoints();

                    //bonus for two days new release why is that ?

                    if ((each.get_movie().get_priceCode()==Movie.NEW_RELEASE) && each.get_daysRented()>1)
                        frequentRenterPoints++;

                    result += "\t" + each.get_movie().get_title()+ "\t" +
                            String.valueOf(thisAmount) + "\n";
                    totalAmount += thisAmount;
                }

        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;



    }

    private double amountFor(Rental aRental) {

        return aRental.getCharge();




    }
}
