package junit.exmaples;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTests {
	@Rule
	public TemporaryFolder temporaryFolderRule = new TemporaryFolder();

	@Test
	public void testCreatingTemporaryFileFolder()
			throws IOException {
		File file = temporaryFolderRule.newFile("testFile.txt");
		File folder = temporaryFolderRule.newFolder("testFolder");

		String filePath = file.getAbsolutePath();
		String folderPath = folder.getAbsolutePath();

		File testFile = new File(filePath);
		File testFolder = new File(folderPath);

		assertTrue(testFile.exists());
		assertTrue(testFolder.exists());
		assertTrue(testFolder.isDirectory());
	}
}
