using LastTransmission;

namespace LastTransmission.Tests;

public class ArchiveReaderTests
{
    [Test]
    public void SuppliedArchiveContainsThreeRecoveredFragments()
    {
        var path = Path.Combine(TestContext.CurrentContext.TestDirectory, "data", "act1.txt");

        var lines = ArchiveReader.Read(path);

        Assert.That(lines, Has.Length.EqualTo(3));
        Assert.That(lines[0], Is.EqualTo("########|########|001|###|WE"));
    }

    [Test]
    public void WrittenLinesReadBackUnchanged()
    {
        var path = Path.Combine(Path.GetTempPath(), $"{Guid.NewGuid()}.txt");
        string[] lines = ["FIRST LINE", "SECOND LINE"];

        try
        {
            ArchiveReader.Write(path, lines);

            Assert.That(ArchiveReader.Read(path), Is.EqualTo(lines));
        }
        finally
        {
            File.Delete(path);
        }
    }
}
