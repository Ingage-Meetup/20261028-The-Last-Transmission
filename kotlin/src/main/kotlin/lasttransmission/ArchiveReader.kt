package lasttransmission

import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.io.path.writeLines

/** Infrastructure supplied for the kata. No reconstruction logic lives here. */
object ArchiveReader {
    fun read(path: Path): List<String> = path.readLines(Charsets.UTF_8)

    fun write(path: Path, lines: List<String>) {
        path.writeLines(lines, Charsets.UTF_8)
    }
}
