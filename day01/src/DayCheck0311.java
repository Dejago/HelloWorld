import java.util.Scanner;

public class DayCheck0311 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请如数年份：");
        int y = sc.nextInt();
        System.out.println("请输入月份：");
        int m = sc.nextInt();
        System.out.println(y+"年"+m+"月有"+monthDayAdvance(y, m)+"天");
    }

    final static int[] DAY_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};

    static int monthDayAdvance(int y, int m) {
        if (m > 12 || m < 0){
            System.out.println("输入的月份不正确！");
            return 0;
        }
        if (m == 2) {
            return isLeapYear(y) ? 29 : 28;
        }
        return DAY_OF_MONTH[m-1];
    }

    static boolean isLeapYear(int y) {
        return y % 400 == 0 || (y % 100 != 0 && y % 4 == 0);
    }

/*    static int monthDay(int m) {
        if (m == 2) {
            return 28;
        } else if (m == 1 | m == 3 | m == 5 | m == 7 | m == 8 | m == 10 | m == 12) {
            return 31;
        } else if (m == 4 | m == 6 | m == 9 | m == 11) {
            return 30;
        } else {
            return 0;
        }
    }*/

}
