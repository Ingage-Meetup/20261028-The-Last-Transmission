package lasttransmission

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.deleteIfExists
import kotlin.test.Test
import kotlin.test.assertEquals

class ArchiveReaderTest {
    @Test
    fun suppliedArchiveContainsThreeRecoveredFragments() {
        val path = Path.of("data", "act1.txt")

        val lines = ArchiveReader.read(path)

        assertEquals(3, lines.size)
        assertEquals("########|########|001|###|WE", lines[0])
    }

    @Test
    fun writtenLinesReadBackUnchanged() {
        val path = Files.createTempFile("written", ".txt")
        val lines = listOf("FIRST LINE", "SECOND LINE")

        try {
            ArchiveReader.write(path, lines)

            assertEquals(lines, ArchiveReader.read(path))
        } finally {
            path.deleteIfExists()
        }
    }
}
