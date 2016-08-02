import java.math.BigInteger;

/**
* Find the sum of the digits in the number 100! (i.e. 100 factorial)
*
* In my opinion, in order to solve this task it is more reasonable to use BigInteger class.
*
**/


public class App {
    App(int value) {
        this.value = value;
        fact = factorial(value);
        digitSum = BigInteger.ZERO;
    }

    private BigInteger digitSum; // sum of the digits in the number
    private BigInteger fact; //factorial function1s value
    private int value;

    private BigInteger factorial(int value) { //   factorization

        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    public void getDigitSum() { //    evaluation sum of the digits in the factorial and out to screen
        BigInteger exit_point = new BigInteger("0");

        while (fact.compareTo(exit_point) > 0) {

            digitSum = digitSum.add(fact.mod(BigInteger.TEN));
            fact = fact.divide(BigInteger.TEN);

        }
        System.out.println("Sum of the digits " + value + "! = " + digitSum);
    }

    public static void main(String[] args) {
        int value = 100;
        // get factorial with BigInteger data type
        App app = new App(value);
        app.getDigitSum();

        // get factorial without BigInteger data type
        FactorialWithoutBigInteger factorialWithoutBigInteger = new FactorialWithoutBigInteger(value);
        factorialWithoutBigInteger.getDigitSum();

    }


}



