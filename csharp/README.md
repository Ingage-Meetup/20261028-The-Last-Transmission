# The Last Transmission — C# starter

The mission briefing is in [`../README.md`](../README.md).

**Requires:** .NET 10 SDK. **Test framework:** NUnit.

```bash
dotnet test
```

- File-reading helper: `ArchiveReader.Read(path)` in `src/LastTransmission/ArchiveReader.cs` returns the raw lines as a `string[]`.
- File-writing helper: `ArchiveReader.Write(path, lines)` in the same file writes each string as one line. Use it if you want to save output to a file.
- Tests live in `tests/LastTransmission.Tests/`. Every `.txt` file in `data/` is copied to the test output folder as `data/<name>.txt`, so read it with `Path.Combine(TestContext.CurrentContext.TestDirectory, "data", "act1.txt")`.
- `ReconstructionTests.cs` contains one intentionally failing placeholder. Replace it with your first real test.
