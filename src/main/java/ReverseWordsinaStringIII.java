/**
 * Created by renkai on 2017/4/19.
 */
public class ReverseWordsinaStringIII {

    /**
     * 实现很复杂
     * @return
     */
    public static String soluation(char[] chars){
        int i=0;
        int space=0;
        int spacebefore=0;
        int mid =0 ;
        char temp;
        while ( i < chars.length){
            if(i >= space){
                //前一个空格的位置
                spacebefore = space;
                //后一个空格的位置
                space = nextspace(spacebefore,chars);
                //中间位置
                mid =spacebefore + (space - spacebefore) / 2;
            }
            //替换
            if(chars[i] !=' ' && i < (mid)){
                temp = chars[i];
                chars[i] = chars[2*mid -i];
                chars[2*mid -i] = temp;
            }
            i++;
        }
        return new String(chars);
    }

    /**
     * 查询下个空格的位置
     * @param current
     * @param chars
     * @return
     */
    public static int nextspace(int current,char[] chars){
        for (int i = current+1; i < chars.length; i++) {
            if(chars[i] == ' ') return i;
        }
        return chars.length;
    }

    public static char[] solution2(char[] s){
        // 从头到末尾翻转
//        reverse(s, 0, s.length);
        // 从头到尾遍历
        for (int i = 0, j = 0; j <= s.length; j++) {
            // 如果碰到空格（或者已经是末尾了），则翻转i到j位置的字符串，即一个单词。
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
        return s;
    }
    public static void reverse(char[] chars,int begin,int end){
        char temp ;
        for (int i = 0; i < (end - begin) / 2; i++) {
            temp = chars[begin + i];
            chars[begin + i] = chars[end -1 -i];
            chars[end -1 -i] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(soluation("abc cba ddd".toCharArray()));

        System.out.println(solution2("abc cba ddd".toCharArray()));
    }
}
