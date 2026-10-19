import { fileURLToPath } from "node:url";
import { expect, test } from "vitest";
import { readArchive } from "../src/archiveReader.js";

test("supplied archive contains three recovered fragments", () => {
  const path = fileURLToPath(new URL("../data/act1.txt", import.meta.url));

  const lines = readArchive(path);

  expect(lines).toHaveLength(3);
  expect(lines[0]).toBe("########|########|001|###|WE");
});
