# The Last Transmission — TypeScript starter

The mission briefing is in [`../README.md`](../README.md).

**Requires:** Node.js 20 or later. **Test framework:** Vitest, which runs the TypeScript directly with no build step.

```bash
npm install
npm test              # run once
npm run test:watch    # rerun on every save
npm run typecheck     # check types with tsc
```

- File-reading helper: `readArchive(path)` in `src/archiveReader.ts` returns the raw lines as a `string[]`.
- File-writing helper: `writeArchive(path, lines)` in the same file writes each string as one line. Use it if you want to save output to a file.
- Tests live in `tests/`. Read the archive relative to the test file with `fileURLToPath(new URL("../data/act1.txt", import.meta.url))`.
- `tests/reconstruction.test.ts` contains one intentionally failing placeholder. Replace it with your first real test.
- Vitest doesn't check types, so run `npm run typecheck` as well.
