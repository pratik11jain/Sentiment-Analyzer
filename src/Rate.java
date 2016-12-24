import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Rate extends Review {
    int getRate() {
        System.out.println("Enter Rate:- ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rateResult = 0;  //readLine return String & parseInt requires String
        try {
            rateResult = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Please enter a number between 0 to 5 (Inclusive)");
            System.exit(1);
        }
        if (rateResult <= 2) super.rateResult = -1;
        else if (rateResult == 3) super.rateResult = 0;
        else super.rateResult = 1;
        return super.rateResult;  //super to access rateResult of base class
    }
}