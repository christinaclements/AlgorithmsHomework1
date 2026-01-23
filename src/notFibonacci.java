import java.math.BigInteger;

public class notFibonacci {
    public BigInteger[] generateNotFibonacci(int numTerms) {
        if (numTerms <= 0) {
            return new BigInteger[0];
        }
        BigInteger[] sequence = new BigInteger[numTerms];
        // Force initial values 0 , 2
        sequence[0] = BigInteger.ZERO;
        if (numTerms > 1) {
            sequence[1] = BigInteger.TWO;
        }

        for (int i = 2; i < numTerms; i++) {
            // n_i = floor(1.5 * n_(i-1) + 2 * n_(i-2))
            // Rewrite: floor((3 * n_(i-1) + 4 * n_(i-2)) / 2)
            BigInteger term1 = sequence[i - 1].multiply(BigInteger.valueOf(3));
            BigInteger term2 = sequence[i - 2].multiply(BigInteger.valueOf(4));
            BigInteger sum = term1.add(term2);
            sequence[i] = sum.divide(BigInteger.TWO);
        }
        return sequence;
    }

    // Print array method
    public static void printArray(BigInteger[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String args[]) {
        notFibonacci run = new notFibonacci();

        int input = 5;
        BigInteger[] output = run.generateNotFibonacci(input);
        System.out.println("Case 1:\nInput = " + input + "\nOutput: ");
        printArray(output);
        System.out.println("---------------------------------------------------");

        input = 10;
        output = run.generateNotFibonacci(input);
        System.out.println("Case 2:\nInput = " + input + "\nOutput: ");
        printArray(output);
        System.out.println("---------------------------------------------------");

        input = 20;
        output = run.generateNotFibonacci(input);
        System.out.println("Case 3:\nInput = " + input + "\nOutput: ");
        printArray(output);
        System.out.println("---------------------------------------------------");
    }
}
