// use hash map from https://www.cnblogs.com/evasean/p/7208900.html

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumQuadratic {
    public static int count(int[] a, int target) {
        Arrays.sort(a);// 数组从小到大排序，后面要使用有序数组的性质简化运算
        System.out.println(Arrays.toString(a));
        System.out.println("target="+target);
        int cnt = 0;
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], i); //以数组value为key，index为map值
        }
        for (int i = 0; i < n - 1; i++) {//i不会超过n-2
            for (int j = i + 1; j < n; j++) {//j从i+1开始统计，不会超过n-1
                int smallValue = a[i] + a[j]; //因为排好序了，所以最开始的a[i]+a[j]
                if (smallValue > target) //当a[i]+a[j]>target时没必要计算了，因为后续的查找就会重复
                    break;
                int bigValue = target-smallValue; //计算出对应的数值较大的value
                Integer bigIndex = map.get(bigValue); //查找数值较大的value所在的位置
                if (bigIndex != null && bigIndex > i && bigIndex > j) {
                    System.out.println(
                            "[" + i + "]=" + a[i] + ",[" + j + "]" + a[j] + ",[" + bigIndex + "]" + (bigValue));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = { 30, -40, -20, -10, 40, 0, 10, 5 };
        System.out.println(count(a,0));
    }
}