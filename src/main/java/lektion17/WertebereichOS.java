package lektion17;

import java.io.IOException;
import java.io.OutputStream;

public class WertebereichOS extends OutputStream {

        private final byte[] buffer;
        private int position;

        public WertebereichOS(int size) {
            if (size <= 0) throw new IllegalArgumentException("Size must be positive");
            this.buffer = new byte[size];
            this.position = 0;
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            // Null kontrolü
            if (b == null) {
                throw new NullPointerException("byte array is null");
            }
            // Offset kontrolü
            if (off < 0 || len < 0 || off > b.length || (off + len) > b.length) {
                throw new IndexOutOfBoundsException("Offset and/or length out of bounds");
            }
            // Buffer doluluk kontrolü
            if (position + len > buffer.length) {
                throw new IOException("Buffer is full");
            }
            // Yazma işlemi
            System.arraycopy(b, off, buffer, position, len);
            position += len;
        }

        @Override
        public void write(int b) throws IOException {
            if (position >= buffer.length) {
                throw new IOException("Buffer is full");
            }
            buffer[position++] = (byte) b;
        }

        public byte[] getContent() {
            byte[] ret = new byte[position];
            System.arraycopy(buffer, 0, ret, 0, position);
            return ret;
        }
    }