public class StringOps {
    ////////////////////////////////////////////////////////////
    ////// ///////
    ////// Reminder: ///////
    ////// allowed methods ///////
    ////// ///////
    ////// 1.charAt(int index) ///////
    ////// 2.length() ///////
    ////// 3.substring(int start) ///////
    ////// 4.substring(int start,int ends) ///////
    ////// 5.indexOf(String str) ///////
    ////// ///////
    ////// The rest are not allowed ! ///////
    ////// if you want to use a different ///////
    ////// method, and you can implement ///////
    ////// it using material from the course ///////
    ////// you need to implement a version of ///////
    ////// the function by yourself. ///////
    ////// ///////
    ////// see example for substring ///////
    ////// in Recitation 3 question 5 ///////
    ////// ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String input1 = "OlOnel two tHRee world";
        int[] answer = new int[1000];
        answer = allIndexOf(input1, 'l');
        System.out.print("{ ");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println("}");

        // System.out.println(answer);

        String ans1 = capVowelsLowRest(input1);
        System.out.println(ans1);

        String input2 = "   Intro  to coMPUter sCIEncE";
        String ans2 = camelCase(input2);
        System.out.println(ans2);

    }

    public static String capVowelsLowRest(String string) {
        String LowVowels = "aeiou";
        String CapVowels = "AEIOU";
        String answer = "";
        for (int i = 0; i < string.length(); i++) {
            char cur = string.charAt(i);
            if (cur > 96 && cur < 123) { // lowercase
                for (int u = 0; u < LowVowels.length(); u++) {
                    if (cur == LowVowels.charAt(u)) {
                        cur -= 32; // to up
                        break;
                    }
                }
            } else if (cur < 97 && cur > 64) { // uppercase
                boolean isVowel = false;
                for (int u = 0; u < CapVowels.length(); u++) {
                    if (cur == CapVowels.charAt(u)) {
                        isVowel = true;
                    }
                }
                if (!isVowel) {
                    cur += 32; // to low
                }
            }
            answer += cur;
        }
        return answer;
    }

    public static String camelCase(String string) {
        String Newword = "";
        String Finalword = "";
        for (int i = 0; i < string.length(); i++) {
            char cur = string.charAt(i);
            if (cur < 97 && cur > 64) {
                cur += 32;
                Newword += cur;
            } else if (cur > 96 && cur < 123) {
                Newword += cur;
            }
        }

        for (int u = 0; u < Newword.length(); u++) {
            char curNew = Newword.charAt(u);
            if (u == 0) {
                curNew -= 32;
            }
            Finalword += curNew;
        }

        return Finalword;
    }

    public static int[] allIndexOf(String string, char chr) {
        int arraysizecount = arraysize(string, chr);
        int[] array = new int[arraysizecount];
        int arrayIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }
        return array;
    }

    public static int arraysize(String string, char chr) {
        // computes the array size
        int arraysizecount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                arraysizecount++;
            }
        }
        return arraysizecount;
    }
}