import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pratik Jain & Ankit Jain
 */

public class Comment extends Review {

    private void userInput() {
        int i, j, k, flag1, flag2, l;
        System.out.println("Enter Comment:- ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input1 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        j = 0;
        for (i = 0; i < input1.length(); i++) {

            while (i < input1.length() && input1.charAt(i) != ' ') {
                if (comment[j] == null)  //String initially has NULL
                    comment[j] = String.valueOf(input1.charAt(i)); // Char to String
                else
                    comment[j] = comment[j] + input1.charAt(i);
                i++;

            }
            // comparing the keywords
            j++;
        } // end of outermost for
        int len = j;
        for (j = 0; j < len; j++) {
            flag1 = 0;
            for (k = 0; k < negTab.length; k++) {
                if (j < len && comment[j].equalsIgnoreCase(negTab[k]))    // if current word is negative no need to check in positive tab
                {
                    flag1 = 1;
                    flag2 = 0;
                    for (l = 0; l < negTab.length; l++)    //to check if nxt wrd is also -ve,if yes no need to inc neg.
                    {
                        if (j < len - 1 && comment[j + 1].equalsIgnoreCase(negTab[l])) {
                            j = j + 1;
                            flag2 = 1;
                            break;
                        }
                    }
                    if (flag2 != 1) {
                        neg = neg + 1; // count of negative words
                    }
                    break;
                }
            }
            if (flag1 != 1) //check if in positive table
            {
                for (k = 0; k < posTab.length; k++) {
                    if (comment[j].equalsIgnoreCase(posTab[k])) {
                        pos = pos + 1;
                        break;
                    }
                }
            }

        }
    }

    public static void main(String args[]) {
        Comment c = new Comment();
        c.userInput();
        Rate r = new Rate();
        c.calcResult(r.getRate()); //getRate returns integer
    }// main ends
}// class comment ends



