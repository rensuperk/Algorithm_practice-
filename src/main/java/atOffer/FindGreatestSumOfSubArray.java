package atOffer;

/**
 * 题目描述
 HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    /**
     * 这题我遇到过
     * 计算累加和，如果小于0，就被抛弃，如果当前大于前一个的累加和，那么就保留。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        int res = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(sum <= 0 ){
                sum = array[i];
            }else {
                sum+=array[i];
            }
            if(sum > res){
                res = sum;
            }
        }
        return res;
    }
}
