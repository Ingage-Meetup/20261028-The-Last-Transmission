# THE LAST TRANSMISSION
## Act I — First Contact

> **DEEP SPACE COMMUNICATIONS CENTER**  
> **MISSION FILE: ODYSSEY**  
> **STATUS: SIGNAL RECOVERY IN PROGRESS**

### Mission briefing

In 2086, the *Odyssey* departed Earth to investigate an unexplained signal beyond the heliopause—the boundary of the solar wind's protective bubble. Twelve years later, contact was lost. The final communications recording was badly damaged, and for decades no one could recover a readable message.

It is now 2126. New signal-recovery techniques have yielded the first intelligible fragments of that recording.

You and your partner are software engineers at the Deep Space Communications Center. The Signal Recovery Team recovers fragments from the recording; **your assignment is to reconstruct the message those fragments contain**.

The fate of *Odyssey* remains unknown.

---

### The recovered archive

The Signal Recovery Team has provided `act1.txt`, a UTF-8 text file. Each line is one recovered fragment of the original recording. The archive currently contains:

```text
########|########|001|###|WE
########|########|002|###|ARE
########|########|003|###|NOT
```

Records contain **five pipe-separated fields**. The recovery team can currently identify only two:

| Field position | Status | What we know |
| --- | --- | --- |
| 1 | Unreadable | Represented by `########` |
| 2 | Unreadable | Represented by `########` |
| 3 | Recovered | Positive, three-digit sequence number |
| 4 | Unreadable | Represented by `###` |
| 5 | Recovered | Text contained in the fragment |

The `#` characters are placeholders supplied by the recovery team, **not data you need to decode**. Do not infer any meaning for unreadable fields.

You may assume for this act that:

- All records in the supplied archive belong to the same recovered message.
- Records are presented in ascending sequence-number order, beginning at `001`.
- Sequence numbers are consecutive in this recovered portion.
- The archive contains valid five-field records, and the readable text fields are nonempty.
- A text field may contain spaces; `|` is the field separator.

These assumptions apply to **the evidence available in Act I**. Don't implement behavior for situations you haven't been asked to handle.

### Your mission

Build a small reconstruction component that can:

1. Accept the raw lines of a recovered archive.
2. Extract each fragment's recovered text.
3. Combine the text in sequence order, separating adjacent fragments with a single space.
4. Return the reconstructed text as a string.
5. Return an empty string for an empty archive.

For the supplied archive, the result must be:

```text
WE ARE NOT
```

**This is only the portion recovered so far.** Do not assume that the message ends here.

### Development rules

**Use test-driven development.** Work through repeated **Red → Green → Refactor** cycles:

1. Agree on one observable behavior.
2. Write a small, failing test demonstrating it.
3. Write the minimum production code needed to pass.
4. Refactor while keeping the tests green.
5. Repeat.

Work as a pair. Try **ping-pong TDD**: one partner writes a failing test, the other makes it pass and writes the next failing test. Switch roles frequently and talk through decisions.

You are free to choose your own public API, class names, functions, and internal representation. There is no prescribed design pattern or required object model. Aim for code another developer could understand and extend.

### A suggested starting sequence of tests

These are examples, not tests we have written for you. Write your own tests first.

| Behavior | Example input | Expected reconstruction |
| --- | --- | --- |
| No fragments | No lines | Empty string |
| One fragment | One valid record with text `HELLO` | `HELLO` |
| Two fragments | Two valid records, containing `HELLO` and `EARTH` | `HELLO EARTH` |
| Three fragments | The contents of `act1.txt` | `WE ARE NOT` |
| Text with spaces | One valid record containing `GOOD MORNING` | `GOOD MORNING` |

Here are the complete raw records for the examples above.

**One fragment:**

```text
########|########|001|###|HELLO
```

Expected reconstruction: `HELLO`.

**Two fragments:**

```text
########|########|001|###|HELLO
########|########|002|###|EARTH
```

Expected reconstruction: `HELLO EARTH`.

**Text with spaces:**

```text
########|########|001|###|GOOD MORNING
```

Expected reconstruction: `GOOD MORNING`. The space is part of the fifth field and must be preserved.

### Working with the file

Each starter project provides a simple file-reading helper that returns the raw lines from `act1.txt`, and a matching file-writing helper that saves lines to a file. File access is **not** the focus of this kata. Your code is responsible for interpreting those lines and reconstructing the text.

Keep most tests independent of the file system by passing a small in-memory collection of strings to your reconstruction component. Once those tests pass, exercise your solution against the supplied archive.

See [Starter projects](#starter-projects) below for how to run the tests in your language.

### Before you call Act I complete

- [ ] Each implemented behavior has a corresponding automated test.
- [ ] All tests pass.
- [ ] The supplied archive reconstructs to `WE ARE NOT`.
- [ ] Empty input produces an empty string.
- [ ] The reconstruction logic can be tested without reading a physical file.
- [ ] Your partner can explain the design and why you chose it.

### Engineering notes

The objective is **not** to guess what the unreadable fields contain, predict the rest of the transmission, or build an entire communications framework. Work with what has been recovered and what the requirements establish.

Remember: **The recording does not change. Our understanding of it may.**

When Mission Control has additional recovery results, you will receive a new briefing and a new archive snapshot. Until then, your only task is to reconstruct the evidence in front of you.

---

*End of Act I briefing.*

### Starter projects

Pick the folder for your language. Each one is self-contained, with its own copy of the archive in `data/act1.txt`. Run the commands from inside that folder.

| Language | Folder | Test framework | Run the tests |
| --- | --- | --- | --- |
| C# | `csharp/` | NUnit | `dotnet test` |
| Java | `java/` | JUnit 5 (Gradle) | `./gradlew test` (Windows: `gradlew.bat test`) |
| JavaScript | `javascript/` | Vitest | `npm install`, then `npm test` |
| Kotlin | `kotlin/` | kotlin.test on JUnit 5 (Gradle) | `./gradlew test` (Windows: `gradlew.bat test`) |
| Python | `python/` | pytest | `pip install -r requirements.txt`, then `python -m pytest` |
| TypeScript | `typescript/` | Vitest | `npm install`, then `npm test` |

Every starter contains:

- **A file-reading helper** that returns the archive's raw lines, and **a file-writing helper** that writes lines to a file. Neither contains reconstruction logic.
- **Two passing smoke tests** confirming that the helpers can read `data/act1.txt` and write a file that reads back unchanged.
- **One intentionally failing placeholder test** to begin the TDD cycle. Replace it with your first meaningful reconstruction test.

There is no prescribed reconstruction class or API. The `README.md` in each folder lists that language's requirements, the helpers' names, and how to locate `data/act1.txt` from a test.

When Mission Control sends a new archive snapshot, put it in your starter's `data/` folder next to `act1.txt`.
