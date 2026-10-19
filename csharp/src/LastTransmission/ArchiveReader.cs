namespace LastTransmission;

/// <summary>Infrastructure supplied for the kata. No reconstruction logic lives here.</summary>
public static class ArchiveReader
{
    public static string[] Read(string path) => File.ReadAllLines(path);
}
