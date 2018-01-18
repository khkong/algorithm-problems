package single_300;

import single_500.ABBA;

public class ABBADiv1 {

    private StringBuilder mStrBuilder;

    public ABBADiv1() {
        mStrBuilder = new StringBuilder();
    }

    public String canObtain(String initial, String target){
        return recursion(initial, target) ? "Possible" : "Impossible";
    }

    private boolean recursion(String initial, String target) {
        if(initial.length() == target.length())
            return initial.equals(target);

        int len = target.length();
        char first = target.charAt(0);
        char last = target.charAt(len-1);
        String newTarget;
        if(last == 'A'){
            newTarget=  target.substring(0,len-1);
            if(recursion(initial, newTarget))
                return true;
        }

        if(first =='B'){
            mStrBuilder.setLength(0);
            mStrBuilder.append(target.substring(1, len));
            newTarget=  mStrBuilder.reverse().toString();
            if(recursion(initial, newTarget))
                return true;
        }


        return false;
    }

    public static void main(String[] args) {
        ABBADiv1 abba = new ABBADiv1();
//        System.out.println(abba.canObtain("AB","ABB"));
//        System.out.println(abba.canObtain("BBAB","ABABABABB"));
        System.out.println(abba.canObtain("BAAAAABAA", "BAABAAAAAB"));
//        System.out.println(abba.canObtain("A","BB"));
    }

}
