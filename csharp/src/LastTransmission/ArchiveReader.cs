namespace LastTransmission;

/// <summary>Infrastructure supplied for the kata. No reconstruction logic lives here.</summary>
public static class ArchiveReader
{
    public static string[] Read(string path) => File.ReadAllLines(path);

    public static void Write(string path, IEnumerable<string> lines) => File.WriteAllLines(path, lines);
}
