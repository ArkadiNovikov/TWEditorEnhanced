package app.tweditor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StreamReader extends Thread {

    private final InputStreamReader reader;
    private final StringWriter writer;
    private StringBuffer buffer;
    private int index = 0;

    public StreamReader(InputStream inputStream) {
        this.reader = new InputStreamReader(inputStream);
        this.writer = new StringWriter(1024);
    }

    @Override
    public void run() {
        try {
            try (this.reader) {
                int c;
                while ((c = this.reader.read()) != -1) {
                    this.writer.write(c);
                }
            }
            this.buffer = this.writer.getBuffer();
        } catch (IOException exc) {
            Main.logException("Unable to read from input stream", exc);
        }
    }

    public StringBuffer getBuffer()
            throws IllegalThreadStateException {
        if (this.buffer == null) {
            throw new IllegalThreadStateException("Input stream is still open");
        }
        return this.buffer;
    }

    public String getLine()
            throws IllegalThreadStateException {
        if (this.buffer == null) {
            throw new IllegalThreadStateException("Input stream is still open");
        }
        String line = null;
        int length = this.buffer.length();
        if (this.index < length) {
            int sep = this.buffer.indexOf(Main.lineSeparator, this.index);
            if (sep < 0) {
                line = this.buffer.substring(this.index);
                this.index = length;
            } else {
                line = this.buffer.substring(this.index, sep);
                this.index = (sep + Main.lineSeparator.length());
            }
        }

        return line;
    }
}
