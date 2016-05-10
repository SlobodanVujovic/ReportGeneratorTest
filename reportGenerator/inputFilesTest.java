package reportGenerator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class inputFilesTest {
	private InputFiles inputFiles;

	@Before
	public void setUp() {
		inputFiles = new InputFiles();
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gCommon() {
		inputFiles.setListOfFiles("C:\\RG input test\\3gCommonFull");

		inputFiles.findSiteCodeFromCommissioningReport('U');

		assertEquals("UEU124", inputFiles.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gDistirbute() {
		inputFiles.setListOfFiles("C:\\RG input test\\3gDistributeFull");

		inputFiles.findSiteCodeFromCommissioningReport('U');

		assertEquals("VRU62", inputFiles.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeWhenThereIsNoCommissioningReport() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");

		inputFiles.findSiteCodeFromCommissioningReport('U');

		assertEquals("xxxyy", inputFiles.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver2g() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver2gFull");

		inputFiles.findSiteCodeFromCommissioningReport('L');

		assertEquals("NIL35", inputFiles.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver3g() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gFull");

		inputFiles.findSiteCodeFromCommissioningReport('L');

		assertEquals("BGL100", inputFiles.getSiteCodeStr());
	}

	@Test
	public void testSetSiteCode3g() {
		inputFiles.setListOfFiles("C:\\RG input test\\3gDistributeFull");

		inputFiles.findSiteCodeFromCommissioningReport('U');
		inputFiles.setSiteCode('U');

		assertEquals("xxxyy", inputFiles.getSiteCode2gStr());
		assertEquals("VRU62", inputFiles.getSiteCode3gStr());
		assertEquals("xxxyy", inputFiles.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4g() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gFull");

		inputFiles.findSiteCodeFromCommissioningReport('L');
		inputFiles.setSiteCode('L');

		assertEquals("BG100", inputFiles.getSiteCode2gStr());
		assertEquals("BGU100", inputFiles.getSiteCode3gStr());
		assertEquals("BGL100", inputFiles.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4gWithoutCommissioningReport() {
		InputFilesWithNotificationResponse inputFiles = new InputFilesWithNotificationResponse();
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");

		inputFiles.findSiteCodeFromCommissioningReport('L');
		inputFiles.setSiteCode('L');

		assertEquals("xxxyy", inputFiles.getSiteCode2gStr());
		assertEquals("xxxyy", inputFiles.getSiteCode3gStr());
		assertEquals("xxxyy", inputFiles.getSiteCode4gStr());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables3g() {
		inputFiles.setListOfFiles("C:\\RG input test\\3gDistributeFull");

		inputFiles.findSiteCodeFromCommissioningReport('U');
		inputFiles.setSiteCode('U');
		inputFiles.sortOutInputFilesToAppropriateVariables();

		assertEquals(null, inputFiles.getCrFileGsm());
		assertEquals("C:\\RG input test\\3gDistributeFull\\CommissioningReport_VRU62_20160113.txt",
				inputFiles.getUmtsCrFile().toString());
		assertEquals(null, inputFiles.getLteCrFile());
		assertEquals("C:\\RG input test\\3gDistributeFull\\Commissioning_VRU62_20160113.xml",
				inputFiles.getCommFile().toString());
		assertEquals(null, inputFiles.getSiteInfo());
		assertEquals(null, inputFiles.getBackupCommFile());
		assertEquals("C:\\RG input test\\3gDistributeFull\\UP antenskog sistema VRU62.xlsx",
				inputFiles.getUpFile().toString());
		assertEquals(null, inputFiles.getEngineerFile());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gOver2g() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver2gFull");

		inputFiles.findSiteCodeFromCommissioningReport('L');
		inputFiles.setSiteCode('L');
		inputFiles.sortOutInputFilesToAppropriateVariables();

		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\BCFID1090_04Nov2015_1705_SCF.xml",
				inputFiles.getCrFileGsm().toString());
		assertEquals(null, inputFiles.getUmtsCrFile());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\CommissioningReport_NIL35_20151104.txt",
				inputFiles.getLteCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\Commissioning_NIL35_20151104.xml",
				inputFiles.getCommFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\All_SiteInformation_NIL35_20151104.txt",
				inputFiles.getSiteInfo().toString());
		assertEquals(null, inputFiles.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\UP za 46 LTE NSN stanica.xlsx",
				inputFiles.getUpFile().toString());
		assertEquals(null, inputFiles.getEngineerFile());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gOver3g() {
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gFull");

		inputFiles.findSiteCodeFromCommissioningReport('L');
		inputFiles.setSiteCode('L');
		inputFiles.sortOutInputFilesToAppropriateVariables();

		assertEquals(null, inputFiles.getCrFileGsm());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\CommissioningReport_BGU100_20151201.txt",
				inputFiles.getUmtsCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\CommissioningReport_BGL100_20151201.txt",
				inputFiles.getLteCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\Commissioning_BGL100_20151201.xml",
				inputFiles.getCommFile().toString());
		assertEquals(null, inputFiles.getSiteInfo());
		assertEquals(null, inputFiles.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\UP za 46 LTE NSN stanica.xlsx",
				inputFiles.getUpFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\Engineer.txt",
				inputFiles.getEngineerFile().toString());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gWithoutCommissioningReport() {
		InputFilesWithNotificationResponse inputFiles = new InputFilesWithNotificationResponse();
		inputFiles.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");

		inputFiles.findSiteCodeFromCommissioningReport('L');
		inputFiles.setSiteCode('L');
		inputFiles.sortOutInputFilesToAppropriateVariables();

		assertEquals(null, inputFiles.getCrFileGsm());
		assertEquals(null, inputFiles.getUmtsCrFile());
		assertEquals(null, inputFiles.getLteCrFile());
		assertEquals(
				"C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\Commissioning_BGL100_20151201.xml",
				inputFiles.getCommFile().toString());
		assertEquals(null, inputFiles.getSiteInfo());
		assertEquals(null, inputFiles.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\UP za 46 LTE NSN stanica.xlsx",
				inputFiles.getUpFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\Engineer.txt",
				inputFiles.getEngineerFile().toString());
	}

}
