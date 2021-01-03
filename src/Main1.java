import java.util.Calendar;
import java.util.Scanner;
public class Main1 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String day = null;
        String month = null;
        String year = null;
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(c<'0' || c>'9') {
                day=s.substring(0,i);
                month=s.substring(i,i+3);
                year=s.substring(i+3);
                break;
            }
        }
        int m = 0;
        if(month.equals("JAN")) m=1;
        else if(month.equals("FEB")) m=2;
        else if(month.equals("MAR")) m=3;
        else if(month.equals("APR")) m=4;
        else if(month.equals("MAY")) m=5;
        else if(month.equals("JUN")) m=6;
        else if(month.equals("JUL")) m=7;
        else if(month.equals("AUG")) m=8;
        else if(month.equals("SEP")) m=9;
        else if(month.equals("OCT")) m=10;
        else if(month.equals("NOV")) m=11;
        else if(month.equals("DEC")) m=12;
        int d=Integer.valueOf(day);
        int y=Integer.valueOf(year);
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        c2.set(y, m-1, d);
        c1.set(1,0,1);
        long t1=c1.getTimeInMillis();
        long t2=c2.getTimeInMillis();
        long da=(t2-t1)/(24*60*60*1000);
        System.out.print(da);
    }
}