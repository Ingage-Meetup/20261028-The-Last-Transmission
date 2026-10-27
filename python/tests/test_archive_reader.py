from pathlib import Path

from last_transmission.archive_reader import read_archive, write_archive

DATA_DIR = Path(__file__).parent.parent / "data"


def test_supplied_archive_contains_three_recovered_fragments():
    lines = read_archive(DATA_DIR / "act1.txt")

    assert len(lines) == 3
    assert lines[0] == "########|########|001|###|WE"


def test_written_lines_read_back_unchanged(tmp_path):
    path = tmp_path / "written.txt"
    lines = ["FIRST LINE", "SECOND LINE"]

    write_archive(path, lines)

    assert read_archive(path) == lines
