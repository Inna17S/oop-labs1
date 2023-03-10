package test;
import main.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StringCalculatorTest {

    StringCalculator calculator;
    /** Крок 1-2 додавання чисел через кому*/
    @Test
    public void test1() {
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        assertEquals(3, calculator.add("1,2"));
    }
    /** Крок 3-4 обробка символа нової строки та задання одного роздільника користувачем*/
    @Test
    public void test2() {
        assertEquals(3, calculator.add("//;\\n1;2"));
        assertEquals(4, calculator.add("//;\\n2;2"));
    }
    /** Крок 5-6 обробка від'ємних чисел,неправильно введенних деліметрів та чисел більше 1000*/
    @Test
    public void test3() {
        assertEquals(1999, calculator.add("1000,999,1001"));
        assertEquals(-1, calculator.add("1,-2,-3,-4,5,6,7,8"));
        assertEquals(-1, calculator.add("1,4,\\n4"));
    }
    /**Крок 7-9 обробка декількох роздільників довільної довжини введенних користувачем*/
    @Test
    public void test4() {
        assertEquals(18, calculator.add("//[*][%]\\n1*2%3*1*2%3*1*2%3"));
        assertEquals(11, calculator.add("//[****][!!!][++]\\n1****2!!!3++5"));
        assertEquals(10, calculator.add("//[???]\\n1???2,3,4"));
        assertEquals(16, calculator.add("//[*][*][*]\\n4*4*4*4"));
    }

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

}