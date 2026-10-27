package lasttransmission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ArchiveReaderTest {
    @Test
    void suppliedArchiveContainsThreeRecoveredFragments() throws IOException {
        Path path = Path.of("data", "act1.txt");

        List<String> lines = ArchiveReader.read(path);

        assertEquals(3, lines.size());
        assertEquals("########|########|001|###|WE", lines.get(0));
    }

    @Test
    void writtenLinesReadBackUnchanged(@TempDir Path folder) throws IOException {
        Path path = folder.resolve("written.txt");
        List<String> lines = List.of("FIRST LINE", "SECOND LINE");

        ArchiveReader.write(path, lines);

        assertEquals(lines, ArchiveReader.read(path));
    }
}
