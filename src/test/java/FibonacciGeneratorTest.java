import com.beesion.ms.test.util.FibonacciGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase FibonacciGenerator.
 */
public class FibonacciGeneratorTest {

    @Test
    public void testFibonacciWithZeroElements() {
        FibonacciGenerator generator = new FibonacciGenerator();
        List<Integer> result = generator.generateFibonacci(new int[]{0, 1}, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFibonacciWithNineElements() {
        FibonacciGenerator generator = new FibonacciGenerator();
        List<Integer> result = generator.generateFibonacci(new int[]{0, 1}, 9);
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21), result);
    }

    @Test
    public void testFibonacciWithCustomSignature() {
        FibonacciGenerator generator = new FibonacciGenerator();
        List<Integer> result = generator.generateFibonacci(new int[]{2, 3}, 5);
        assertEquals(List.of(2, 3, 5, 8, 13), result);
    }
}