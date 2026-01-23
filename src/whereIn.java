import java.math.BigInteger;
import java.util.Scanner;

public class whereIn {
    public static BigInteger[] notFibonacciUntil(long targetValue) {
        BigInteger target = BigInteger.valueOf(targetValue);
        BigInteger[] sequence = new BigInteger[100];
        sequence[0] = BigInteger.ZERO;
        sequence[1] = BigInteger.TWO;
        int count = 2;

            // Run sequence until exceed target
            while (sequence[count - 1].compareTo(target) < 0) {
                // n_i = floor(1.5 * n_(i-1) + 2 * n_(i-2))
                // Calculate: floor((3 * n_(i-1) + 4 * n_(i-2)) / 2)
                BigInteger term1 = sequence[count - 1].multiply(BigInteger.valueOf(3));
                BigInteger term2 = sequence[count - 2].multiply(BigInteger.valueOf(4));
                BigInteger sum = term1.add(term2);
                sequence[count] = sum.divide(BigInteger.TWO);

                count++;
            }
            return sequence;
        }

        public static int findPosition(long target) {
            if (target < 0) {
                return -1;
            }
            if (target == 0) {
                return 0;
            }
            BigInteger[] sequence = notFibonacciUntil(target);
            BigInteger targetBig = BigInteger.valueOf(target);

            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i].equals(targetBig)) {
                    return i;
                }
                if (sequence[i].compareTo(targetBig) > 0) {
                    return i - 1;
                }
            }
            return sequence.length - 1;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input: ");
            long userInput = scanner.nextLong();

            while (userInput != -1) {
                int position = findPosition(userInput);
                System.out.println("Output: " + position);
                System.out.print("Input: ");
                userInput = scanner.nextLong();
            }
            scanner.close();
        }
    }
