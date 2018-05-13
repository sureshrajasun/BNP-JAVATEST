import java.util.Arrays;

public class Two {

    public static void main(String[] args) {

        int array[] = new int[]{4, 9, 2, 3};
        /*int array[] = new int[]{1,2, 3, 4};*/

        System.out.println(helper(array));

    }

    static int helper(int prices[]){

        int[] discounts = new int[prices.length];
        int totalPrice;
        int minDiscount;
        int discountPrice;

        totalPrice = prices[0];
        discounts[0] =  prices[0];

        for (int i=1 ; i< prices.length ;i++){

            minDiscount = Arrays.stream(discounts).filter(a-> a > 0).min().getAsInt();

            if(prices[i] > minDiscount) {
                discountPrice = prices[i] - minDiscount;
            }else{
                discountPrice = 0;
            }

            discounts[i] = prices[i];

            totalPrice = discountPrice + totalPrice;
        }
    return totalPrice;

    }

}
