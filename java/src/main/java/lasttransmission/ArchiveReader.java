package lasttransmission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Infrastructure supplied for the kata. No reconstruction logic lives here. */
public final class ArchiveReader {
    private ArchiveReader() {
    }

    public static List<String> read(Path path) throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
