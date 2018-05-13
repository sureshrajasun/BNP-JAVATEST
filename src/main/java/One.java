import java.util.Arrays;
import java.util.stream.IntStream;

public class One {

    public static void main(String[] args) {


        int[] score = new int []{17, 12,  10, 2 , 7, 2, 11, 20, 8};
        int team = 3;
        int m = 4;


/*        int team = 5;
        int[] score = new int []{18, 5,  15, 18 , 11, 15, 9, 7};
        int m = 1;*/

       /* int[] score = new int []{6, 18,  8, 14 , 10, 12, 18, 9};
        int team = 8;
        int m = 3;*/




        System.out.println( "Sum= " +teamFormation(score, team, m));

    }

    static long teamFormation(int[] score, int team, int m) {

        if(score.length == team){
            return Arrays.stream(score).sum();
        }

        int sum = 0;
        for(int K=0; K< team ; K++){
            int[] firstSection = Arrays.copyOfRange(score, 0, m);
            int[] secondSection = Arrays.copyOfRange(score, (score.length)-m, score.length );

            int firstMax = Arrays.stream(firstSection).max().getAsInt();

            int secondMax = Arrays.stream(secondSection).max().getAsInt();

            sum = (firstMax > secondMax ? firstMax : secondMax) + sum;

            if( firstMax > secondMax) {
                score = Arrays.stream(score).filter(array_element -> array_element != firstMax).toArray();
            }else {
                score = Arrays.stream(score).filter(array_element -> array_element != secondMax).toArray();
            }

        }

        return sum;
    }
}
