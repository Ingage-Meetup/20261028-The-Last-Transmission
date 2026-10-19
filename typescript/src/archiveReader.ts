import { readFileSync } from "node:fs";

/** Infrastructure supplied for the kata. No reconstruction logic lives here. */
export function readArchive(path: string): string[] {
  const lines = readFileSync(path, "utf8").split(/\r?\n/);
  if (lines.at(-1) === "") {
    lines.pop();
  }
  return lines;
}
