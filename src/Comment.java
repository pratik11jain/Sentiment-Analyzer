import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pratik Jain & Ankit Jain
 */

class Review {

    String comment[]=new String[20];
    String input1;
    int rateResult;
    private int commentResult;
    int pos;
    int neg;
    String negTab[]={"not","no","bad"};  //Table of negative words
    String posTab[]={"good","awesome"}; //Table of positive words

    void calcResult(int r) {
        if(neg==0 && pos>=1)
            commentResult=1;
        else if(neg==1 && pos==1)
            commentResult=-1;
        else if(neg>pos)
            commentResult=-1;
        else if(neg>1)
            commentResult=0;
        else if(neg==1)
            commentResult=-1;
        int result = r + commentResult;
        if(result > 0)
            System.out.println("Positive");
        else if(result < 0)
            System.out.println("Negative");
        else
            System.out.println("Neutral");
    }
}//class ends

public class Comment extends Review{

    private void userInput() throws IOException {
        int i,j,k,flag1,flag2,l;
        System.out.println("Enter Comment:- ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input1=br.readLine();
        j=0;
        for(i=0; i<input1.length(); i++)
        {

            while(i<input1.length() && input1.charAt(i)!=' ')
            {
                if(comment[j]==null)  //String initially has NULL
                    comment[j]=String.valueOf(input1.charAt(i)); // Char to String
                else
                    comment[j]=comment[j]+input1.charAt(i);
                i++;

            }
            // comparing the keywords
            j++;
        } // end of outermost for
        for(j=0;j < input1.length();j++)
        {
            flag1=0;
            for(k=0;k<negTab.length;k++)
            {
                if(j < input1.length() &&  comment[j].equals(negTab[k]))	// if current word is negative no need to check in positive tab
                {
                    flag1=1;
                    flag2=0;
                    for(l=0;l<negTab.length;l++)	//to check if nxt wrd is also -ve,if yes no need to inc neg.
                    {
                        if(j < input1.length()-1 && comment[j+1].equals(negTab[l]))
                        {
                            j=j+1;
                            flag2=1;
                            break;
                        }
                    }
                    if(flag2!=1)
                    {
                        neg=neg+1; // count of negative words
                        System.out.println("neg="+neg);
                    }
                    break;
                }
            }

            if (flag1!=1) //check if in positive table
            {
                for(k=0;k<posTab.length;k++)
                {
                    if(comment[j].equals(posTab[k]))
                    {
                        pos=pos+1;
                        break;
                    }
                }
            }

        }
    }

    public static void main(String args[]) throws IOException {
        Comment c=new Comment();
        c.userInput();
        Rate r=new Rate();
        c.calcResult(r.getRate()); //getRate returns integer

    }// main ends
}// class comment ends

class Rate extends Review {
    int getRate() throws IOException {
        System.out.println("Enter Rate:- ");
        BufferedReader br=new BufferedReader(new InputStreamReader (System.in));
        int rateResult=Integer.parseInt(br.readLine());  //readLine return String & parseInt requires String
        if(rateResult<=2) super.rateResult = -1;
        else if(rateResult==3) super.rateResult=0;
        else super.rateResult=1;
        return super.rateResult;  //super to access rateResult of base class
    }
}

