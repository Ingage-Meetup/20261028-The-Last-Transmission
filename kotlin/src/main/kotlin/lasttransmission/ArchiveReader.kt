package lasttransmission

import java.nio.file.Path
import kotlin.io.path.readLines

/** Infrastructure supplied for the kata. No reconstruction logic lives here. */
object ArchiveReader {
    fun read(path: Path): List<String> = path.readLines(Charsets.UTF_8)
}
