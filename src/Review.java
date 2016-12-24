class Review {
    String comment[] = new String[20];
    String input1;
    int rateResult;
    private int commentResult;
    int pos;
    int neg;
    static final String[] negTab = {"not", "no", "bad"};  //Table of negative words
    static final String posTab[] = {"good"}; //Table of positive words

    void calcResult(int r) {
        if (neg == 0 && pos >= 1)
            commentResult = 1;
        else if (neg == 1 && pos == 1)
            commentResult = -1;
        else if (neg > pos)
            commentResult = -1;
        else if (neg > 1)
            commentResult = 0;
        else if (neg == 1)
            commentResult = -1;
        int result = r + commentResult;
        if (result > 0)
            System.out.println("Positive");
        else if (result < 0)
            System.out.println("Negative");
        else
            System.out.println("Neutral");
    }
}//class ends
