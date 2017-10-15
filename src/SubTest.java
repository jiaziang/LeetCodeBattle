/**
 * Created by jiaziang on 2017/8/3.
 */
public class SubTest {

    public static void main(String[] args){
        new SubTest().test();
    }


    public void test(){
        String a = "❶";
        System.out.println(stringToUnicode(a));
    }

    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += s.charAt(i) + ": " + "\\u" + Integer.toHexString(ch)
                        + "\n";
            else
                str += s.charAt(i) + ": " + "\\u00" + Integer.toHexString(ch)
                        + "\n";
        }
        return str;
    }
}
