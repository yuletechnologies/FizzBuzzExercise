package com.equalexperts.fb;


public class BasicResultCalculator implements ResultCalculator {

   public String calculateResult(int number) {
        String result = String.valueOf(number);

        result = number % 3 == 0 ? "fizz" : result ;
        result = number % 5 == 0 ? "buzz" : result ;
        result = number % 15 == 0 ? "fizzbuzz" : result ;

       return result;
    }
}
