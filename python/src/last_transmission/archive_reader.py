"""Infrastructure supplied for the kata. No reconstruction logic lives here."""

from collections.abc import Iterable
from pathlib import Path


def read_archive(path: str | Path) -> list[str]:
    return Path(path).read_text(encoding="utf-8").splitlines()


def write_archive(path: str | Path, lines: Iterable[str]) -> None:
    Path(path).write_text("".join(f"{line}\n" for line in lines), encoding="utf-8")
