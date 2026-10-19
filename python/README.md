# The Last Transmission — Python starter

The mission briefing is in [`../README.md`](../README.md).

**Requires:** Python 3.10 or later. **Test framework:** pytest.

```bash
python -m venv .venv
source .venv/bin/activate      # macOS / Linux
.venv\Scripts\activate         # Windows
pip install -r requirements.txt
python -m pytest
```

- File-reading helper: `read_archive(path)` in `src/last_transmission/archive_reader.py` returns the raw lines as a `list[str]`.
- Tests live in `tests/`. `pyproject.toml` puts `src/` on the import path, so import with `from last_transmission.archive_reader import read_archive`. Read the archive relative to the test file with `Path(__file__).parent.parent / "data" / "act1.txt"`.
- `tests/test_reconstruction.py` contains one intentionally failing placeholder. Replace it with your first real test.
