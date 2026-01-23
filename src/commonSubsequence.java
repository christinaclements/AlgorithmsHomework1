public class commonSubsequence {

    public int findCS(String text1, String text2){
        int result = 0;
        char [] charText1 = text1.toCharArray();
        char [] charText2 = text2.toCharArray();
        int[][] dp = new int[charText1.length + 1][charText2.length + 1];

        for (int i = 0; i < charText1.length; i++) {
            for (int j = 0; j < charText2.length; j++) {
                if(charText1[i] == charText2[j]) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else {
                    if (dp[i][j + 1] > dp[i + 1][j]) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                }
            }
        }
        return dp[charText1.length][charText2.length];
    }

    public static void main(String[] args) {
        commonSubsequence run = new commonSubsequence();

        String text1 = "ace";
        String text2 = "abcde";
        int result = run.findCS(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + "\ntext2 = " + text2 + "\nOutput: " + result);
        System.out.println("---------------------------------------------------");

        text1 = "almanacs";
        text2 = "maniac";
        result = run.findCS(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + "\ntext2 = " + text2 + "\nOutput: " + result);
        System.out.println("---------------------------------------------------");

        text1 = "hammock";
        text2 = "slide";
        result = run.findCS(text1, text2);
        System.out.println("Input:\ntext1 = " + text1 + "\ntext2 = " + text2 + "\nOutput: " + result);
        System.out.println("---------------------------------------------------");

    }
}