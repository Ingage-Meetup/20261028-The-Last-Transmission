# The Last Transmission — Kotlin starter

The mission briefing is in [`../README.md`](../README.md).

**Requires:** JDK 17 or later, with `JAVA_HOME` set. **Test framework:** `kotlin.test` on JUnit 5, run by Gradle. The Gradle wrapper is included, so you don't need to install Gradle or Kotlin; the first run downloads both.

```bash
./gradlew test        # macOS / Linux
gradlew.bat test      # Windows
```

- File-reading helper: `ArchiveReader.read(path)` in `src/main/kotlin/lasttransmission/ArchiveReader.kt` returns the raw lines as a `List<String>`.
- Tests live in `src/test/kotlin/lasttransmission/`. Gradle runs tests from this folder, so read the archive with `Path.of("data", "act1.txt")`.
- `ReconstructionTest.kt` contains one intentionally failing placeholder. Replace it with your first real test.
