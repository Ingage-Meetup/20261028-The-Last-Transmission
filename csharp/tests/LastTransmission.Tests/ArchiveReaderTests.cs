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
}
