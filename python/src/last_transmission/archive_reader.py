"""Infrastructure supplied for the kata. No reconstruction logic lives here."""

from pathlib import Path


def read_archive(path: str | Path) -> list[str]:
    return Path(path).read_text(encoding="utf-8").splitlines()
