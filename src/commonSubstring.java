public class commonSubstring {
    public static String findCommonString(String text1, String text2) {
        int maxLength = 0;
        int startIndex = 0;

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int length = 0;
                while (i + length < text1.length() && j + length < text2.length() &&
                        text1.charAt(i + length) == text2.charAt(j + length)) {
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = i;
                }
            }
        }

        if (maxLength > 0) {
            return text1.substring(startIndex, startIndex + maxLength);
        } else {
            return "";
        }
    }
    public static void main(String args[]){
        commonSubstring run = new commonSubstring();

        String text1 = "spy family";
        String text2 = "jujutzu";
        String result = run.findCommonString(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + " \ntext2 = " + text2 + "\nOutput: " + result);
        System.out.println("---------------------------------------------------");

        text1 = "friends";
        text2 = "fridays";
        result = run.findCommonString(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + " \ntext2 = " + text2 + "\nOutput: " + result);
        System.out.println("---------------------------------------------------");

        text1 = "gears of war";
        text2 = "History of warriors";
        result = run.findCommonString(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + " \n text2 = " + text2 + "\n Output: " + result);
        System.out.println("---------------------------------------------------");

    }
}
