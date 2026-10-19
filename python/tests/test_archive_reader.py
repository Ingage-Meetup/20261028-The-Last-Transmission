from pathlib import Path

from last_transmission.archive_reader import read_archive

DATA_DIR = Path(__file__).parent.parent / "data"


def test_supplied_archive_contains_three_recovered_fragments():
    lines = read_archive(DATA_DIR / "act1.txt")

    assert len(lines) == 3
    assert lines[0] == "########|########|001|###|WE"
