package main;
//1\n2,3

public class Main {
    public static void main(String[] args) {
        StringCalculator calc;
        calc = new StringCalculator();
        //System.out.println(calc.add("1,1\n1"));
//        System.out.println(calc.add("1\n2,2"));
//        System.out.println(calc.add("//;\\n1;2"));
//        //System.out.println(calc.add("//;\\n2;-2,-3"));
//        System.out.println(calc.add("1000,1001,1"));
//        //System.out.println(calc.add("//[]\\n1*2**3"));
//        System.out.println(calc.add("//[*][%]\\n1*2%3"));
        System.out.println(calc.add("//[*][**][***]\\n1,1,1*1**1***1\n1"));

    }
}
