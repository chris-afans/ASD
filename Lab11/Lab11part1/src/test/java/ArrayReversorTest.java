import edu.miu.cs.cs489appsd.Lab11.ArrayFlattener;
import edu.miu.cs.cs489appsd.Lab11.ArrayReversor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArrayReversorTest {

    @Mock
    ArrayFlattener arrayFlattener;

    @InjectMocks
    ArrayReversor arrayReversor;

    @Test
    void testReverseArray_ValidInput() {
        arrayFlattener = new ArrayFlattener();
        arrayReversor= new ArrayReversor(arrayFlattener);
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        when(arrayFlattener.flattenArray(inputArray)).thenReturn(new int[]{1, 3, 0, 4, 5, 9});

        int[] reversedArray = arrayReversor.reverseArray(inputArray);

        assertArrayEquals(new int[]{9, 5, 4, 0, 3, 1}, reversedArray);

        verify(arrayFlattener, times(1)).flattenArray(inputArray);



    }

    @Test
    void testReverseArray_NullInput() {
        arrayFlattener = new ArrayFlattener();
        arrayReversor = new ArrayReversor(arrayFlattener);
        int[][] inputArray = null;
        int[] expected = {};
        when(arrayFlattener.flattenArray(inputArray)).thenReturn(expected);
        int[] result = arrayReversor.reverseArray(inputArray);
        assertArrayEquals(expected, result);

    }
}
