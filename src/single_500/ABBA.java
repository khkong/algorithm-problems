package single_500;

public class ABBA {

    private StringBuilder mStrBuilder;

    public ABBA() {
        mStrBuilder = new StringBuilder();
    }

    public String canObtain(String initial, String target) {
        return recursion(initial, target) ? "Possible" : "Impossible";
    }

    private boolean recursion2(String initial, String target) {
        if(initial.length() == target.length())
            return initial.equals(target);

        //rule1
        String rule1 = initial + 'A';
        mStrBuilder.setLength(0);
        mStrBuilder.append(rule1);
        String revRule1 = mStrBuilder.reverse().toString();

        if (target.contains(rule1) || target.contains(revRule1)) {
            return recursion(rule1, target);
        }

        //rule2
        mStrBuilder.setLength(0);
        mStrBuilder.append(initial);
        String rule2 = mStrBuilder.reverse().toString() + 'B';
        mStrBuilder.setLength(0);
        mStrBuilder.append(rule2);
        String revRule2 = mStrBuilder.reverse().toString();

        if (target.contains(rule2) || target.contains(revRule2)) {
            return recursion2(rule2, target);
        }

        return false;
    }

    private boolean recursion(String initial, String target) {
        if(initial.length() == target.length())
            return initial.equals(target);

        int len = target.length();
        char last = target.charAt(len-1);
        String newTarget;
        if(last == 'A'){
            newTarget=  target.substring(0,len-1);
        }else{
            mStrBuilder.setLength(0);
            mStrBuilder.append(target);
            mStrBuilder.setLength(len - 1);
            newTarget=  mStrBuilder.reverse().toString();
        }
        return recursion(initial, newTarget);
    }

    public static void main(String[] args) {
        ABBA abba = new ABBA();
//        System.out.println(abba.canObtain("AB","ABB"));
//        System.out.println(abba.canObtain("BBAB","ABABABABB"));
        System.out.println(abba.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"));
//        System.out.println(abba.canObtain("A","BB"));
    }
}
