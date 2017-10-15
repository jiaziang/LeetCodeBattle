import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jiaziang on 2017/8/3.
 */
public class Leet {

    public static void main(String[] args){
        Leet leet = new Leet();
        int result = leet.arrayPairSum(new int[]{1,4,2,3});

        System.out.println("result is "+result);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0;i<nums.length;i+=2){
            result+=nums[i];
        }
        return result;
    }
}
