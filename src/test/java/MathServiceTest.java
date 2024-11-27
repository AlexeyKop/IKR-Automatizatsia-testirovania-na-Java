import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {
    MathService mathService = new MathService();

    // Тест на дискриминант
    @Test
    void testGetD() {
        assertEquals(1, mathService.getD(1, -3, 2));
        assertEquals(0, mathService.getD(1, 2, 1));
        assertEquals(-7, mathService.getD(1, 1, 2));
    }

    // Параметризованный тест для случая двух корней
    @ParameterizedTest
    @CsvSource({
        "1, -3, 2, 2.0, 1.0",  // Два корня
        "1, -2, -3, 3.0, -1.0" // Два корня
    })
    void testGetAnswerTwoRoots(int a, int b, int c, double expectedX1, double expectedX2) throws Exception {
        Pair result = mathService.getAnswer(a, b, c);
        assertEquals(expectedX1, result.first);
        assertEquals(expectedX2, result.second);
    }

    // Тест на один корень
    @Test
    void testGetAnswerOneRoot() throws Exception {
        Pair result = mathService.getAnswer(1, 2, 1);
        assertEquals(-1.0, result.first);
        assertEquals(-1.0, result.second);
    }

    // Негативный тест на отсутствие корней
    @Test
    void testGetAnswerNoRoots() {
        assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 1, 2));
    }

    // Негативный тест на некорректный коэффициент a = 0
    @Test
    void testGetAnswerInvalidA() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.getAnswer(0, 2, 1));
        assertEquals("Коэффициент 'a' не может быть равен 0", exception.getMessage());
    }
}
