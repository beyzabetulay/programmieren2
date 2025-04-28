package lektion17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class WertebereichOSTest {

    private WertebereichOS outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new WertebereichOS(10);
    }

    @Test
    void testNullByteArray() {
        assertThrows(NullPointerException.class, () -> outputStream.write(null, 0, 1));
    }

    @Test
    void testNegativeOffset() {
        byte[] data = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> outputStream.write(data, -1, 3));
    }

    @Test
    void testNegativeLength() {
        byte[] data = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> outputStream.write(data, 0, -2));
    }

    @Test
    void testOffsetExceedsArray() {
        byte[] data = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> outputStream.write(data, 6, 1));
    }

    @Test
    void testOffsetPlusLengthExceedsArray() {
        byte[] data = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> outputStream.write(data, 3, 3));
    }

    @Test
    void testBufferOverflow() {
        byte[] data = new byte[11];
        assertThrows(IOException.class, () -> outputStream.write(data, 0, 11));
    }

    @Test
    void testValidWrite() throws IOException {
        byte[] data = {1, 2, 3, 4, 5};
        outputStream.write(data, 1, 3);
        assertArrayEquals(new byte[]{2, 3, 4}, outputStream.getContent());
    }
}
