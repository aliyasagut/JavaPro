package app;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    // 1. Проверяем, действительно ли метод выдаёт ошибку при отриц.значении.
    // 2. Проверим, правильный ли размер массива.
    // 3. Проверим работу метода при граничных значениях (0).
    // 4. Проверим, действительно ли соседние элементы отличаются на 1.
    // 5. Точечно проверим внутренние значения в массиве.
    // 6. Проверим, что метод возвращает не null.

    @Test(expected = IllegalArgumentException.class)
    public void checkExpectedException() {
        Main.getArray(-1);
    }

    @Test
    public void checkIfArraySizeIsCorrect() {
        int[] result = Main.getArray(7);
        int expectedSize = 7;
        int actualSize = result.length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void check0Size() {
        int[] result = Main.getArray(0);
        int expectedSize = 0;
        int actualSize = result.length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void checkDifferenceBetweenElements() {
        int[] result = Main.getArray(2);
        int expectedDifference = 1;
        int actualDifference = result[1] - result[0];
        Assert.assertEquals(expectedDifference, actualDifference);
    }

    @Test
    public void checkSomeElts() {
         int[] result = Main.getArray(5);
        int expected = 4;
        int actual = result[3];
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNotNull(){
        int[] result = Main.getArray(0);
        Assert.assertNotNull(result);
    }
}