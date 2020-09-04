package base.string;

/**
 * @Author: Jeremy
 * @Date: 2018/10/19 17:23
 */
public class ReverseString {
    public static void main(String args[]){
        ReverseString rotation = new ReverseString();
        String res = rotation.reverseSentence("TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB", 47);
        System.out.println(res);

        String a = partReverse("1234", 4);
        System.out.println(a);

        System.out.println(rotation.reverseVowels("aA"));
    }
    public String reverseSentence(String A, int n) {
        // write code here
        A = partReverse(A, n);
        String B = "";
        String[] strings = A.split(" ");
        int len = 0;
        for(String s : strings){
            s = partReverse(s, s.length());
            B += s;
            if (++len < strings.length){
                B += " ";
            }
        }
        return B;
    }

    public static String partReverse(String A, int n){
        char[] c = A.toCharArray();
        for(int i=0; i<n/2; i++){
            char temp = c[i];
            c[i] = c[n-i-1];
            c[n-i-1] = temp;
        }
        return String.valueOf(c);
    }


    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        String[] strings = s.split(" ");
        int len = 0;
        for(String string : strings){
            char[] ch = string.toCharArray();
            for(int i = 0; i < ch.length / 2; i++){
                char temp = ch[i];
                ch[i] = ch[ch.length - i - 1];
                ch[ch.length - i - 1] = temp;
            }
            res.append(String.valueOf(ch));
            if (++len < strings.length){
                res.append(" ");
            }
        }
        return res.toString();
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(isYuanChar(ch[i]) && isYuanChar(ch[j])){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
            if(!isYuanChar(ch[i])){
                i++;
            }
            if(!isYuanChar(ch[j])){
                j--;
            }
        }
        return String.valueOf(ch);
    }

    public boolean isYuanChar(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
