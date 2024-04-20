import edu.miu.cs.cs489appsd.Lab11.ArrayFlattener;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayFlattenerTest {

    ArrayFlattener arrayFlattener;

    @BeforeEach
    public void setUp(){
        arrayFlattener = new ArrayFlattener();
    }

    @Test
    void testFlattenArray_ValidInput() {

        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] result = arrayFlattener.flattenArray(inputArray);
        assertArrayEquals(expected, result);
    }

    @Test
    void testFlattenArray_NullInput() {

        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] inputArray = null;
        int[] expected = null;
        int[] result = arrayFlattener.flattenArray(inputArray);
        assertArrayEquals(expected, result);
    }

}
