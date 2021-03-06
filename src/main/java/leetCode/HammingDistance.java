package leetCode; /**
 * Created by renkai on 2017/4/7.
 *
 */
public class HammingDistance {

    /**
     * 最能理解的方法
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if((x & (1 << i)) != (y & (1 << i))){
                ++res;
            }
        }
        System.out.println(res);
        return res;
    }

    /**
     * 先计算x异或y,然后再将每位为1的相加
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if((sum & (1 << i))  == 1 << i){
                ++res;
            }
        }
        System.out.println(res);
        return res;
    }

    /**
     * 上个方法的改进,每次右移i位,与1与计算,结果累加
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance3(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += sum >> i & 1;
        }
        System.out.println(res);
        return res;
    }
    /**
     * 上个方法的改进,每次右移i位,结果为sum,sum&(sum-1),移除最右边的1,每移除1个就+1
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance4(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        while (sum >0){
            res++;
            sum = sum&(sum -1);
        }
        System.out.println(res);
        return res;
    }
    /**
     * 上个方法的改进
     * 递归写法
     * sum%2相当于比较最右边的数,x/2,y/2相当与向右移动一位
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance5(int x, int y) {
        int sum = x ^ y ;

        if(sum == 0) return 0;


        return sum % 2 + hammingDistance5(x/2 ,y/2);
    }

    public static void main(String[] args) {
        hammingDistance(2,5);
        hammingDistance2(2,5);
        hammingDistance3(2,5);
        hammingDistance4(2,5);
        int i = hammingDistance5(2, 5);
        System.out.println(i);

    }
}
