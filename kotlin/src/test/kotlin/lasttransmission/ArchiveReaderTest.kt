package lasttransmission

import java.nio.file.Path
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
}
