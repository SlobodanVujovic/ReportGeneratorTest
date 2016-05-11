package reportGenerator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class inputFilesTest {
	private InputFiles common3gFull;
	private InputFiles distribute3gFull;
	private InputFiles distribute4gOver2g;
	private InputFiles distribute4gOver3g;
	private InputFiles distribute4gOver3gWithoutCr;
	private InputFilesWithNotificationResponse notDistribute4gOver3gWithoutCr;
	private InputFilesWithNotificationResponse notCommon3gWithoutCr;

	@Before
	public void setUp() {
		common3gFull = new InputFiles();
		distribute3gFull = new InputFiles();
		distribute4gOver3gWithoutCr = new InputFiles();
		distribute4gOver2g = new InputFiles();
		distribute4gOver3g = new InputFiles();
		notDistribute4gOver3gWithoutCr = new InputFilesWithNotificationResponse();
		notCommon3gWithoutCr = new InputFilesWithNotificationResponse();

		common3gFull.setListOfFiles("C:\\RG input test\\3gCommonFull");
		distribute3gFull.setListOfFiles("C:\\RG input test\\3gDistributeFull");
		distribute4gOver2g.setListOfFiles("C:\\RG input test\\4gDistributeOver2gFull");
		distribute4gOver3g.setListOfFiles("C:\\RG input test\\4gDistributeOver3gFull");
		distribute4gOver3gWithoutCr.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");
		notDistribute4gOver3gWithoutCr
				.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");
		notCommon3gWithoutCr.setListOfFiles("C:\\RG input test\\3gCommonWithoutCommissioningReport");
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gCommon() {
		common3gFull.findSiteCodeFromCommissioningReport('U');

		assertEquals("UEU124", common3gFull.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gDistirbute() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');

		assertEquals("VRU62", distribute3gFull.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeWhenThereIsNoCommissioningReport() {
		distribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('U');

		assertEquals("xxxyy", distribute4gOver3gWithoutCr.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver2g() {
		distribute4gOver2g.findSiteCodeFromCommissioningReport('L');

		assertEquals("NIL35", distribute4gOver2g.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver3g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');

		assertEquals("BGL100", distribute4gOver3g.getSiteCodeStr());
	}

	@Test
	public void testSetSiteCode3g() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');

		assertEquals("xxxyy", distribute3gFull.getSiteCode2gStr());
		assertEquals("VRU62", distribute3gFull.getSiteCode3gStr());
		assertEquals("xxxyy", distribute3gFull.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');

		assertEquals("BG100", distribute4gOver3g.getSiteCode2gStr());
		assertEquals("BGU100", distribute4gOver3g.getSiteCode3gStr());
		assertEquals("BGL100", distribute4gOver3g.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4gWithoutCommissioningReport() {
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');

		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode2gStr());
		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode3gStr());
		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode4gStr());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables3g() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');
		distribute3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("C:\\RG output\\dummy_file.txt", distribute3gFull.getCrFileGsm().toString());
		assertEquals("C:\\RG input test\\3gDistributeFull\\CommissioningReport_VRU62_20160113.txt",
				distribute3gFull.getUmtsCrFile().toString());
		assertEquals("C:\\RG output\\dummy_file.txt", distribute3gFull.getLteCrFile().toString());
		assertEquals("C:\\RG input test\\3gDistributeFull\\Commissioning_VRU62_20160113.xml",
				distribute3gFull.getCommFile().toString());
		assertEquals(null, distribute3gFull.getSiteInfo());
		assertEquals(null, distribute3gFull.getBackupCommFile());
		assertEquals("C:\\RG input test\\3gDistributeFull\\UP antenskog sistema VRU62.xlsx",
				distribute3gFull.getUpFile().toString());
		assertEquals(null, distribute3gFull.getEngineerFile());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gOver2g() {
		distribute4gOver2g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver2g.setSiteCode('L');
		distribute4gOver2g.sortOutInputFilesToAppropriateVariables();

		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\BCFID1090_04Nov2015_1705_SCF.xml",
				distribute4gOver2g.getCrFileGsm().toString());
		assertEquals("C:\\RG output\\dummy_file.txt", distribute4gOver2g.getUmtsCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\CommissioningReport_NIL35_20151104.txt",
				distribute4gOver2g.getLteCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\Commissioning_NIL35_20151104.xml",
				distribute4gOver2g.getCommFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\All_SiteInformation_NIL35_20151104.txt",
				distribute4gOver2g.getSiteInfo().toString());
		assertEquals(null, distribute4gOver2g.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver2gFull\\UP za 46 LTE NSN stanica.xlsx",
				distribute4gOver2g.getUpFile().toString());
		assertEquals(null, distribute4gOver2g.getEngineerFile());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gOver3g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		assertEquals("C:\\RG output\\dummy_file.txt", distribute4gOver3g.getCrFileGsm().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\CommissioningReport_BGU100_20151201.txt",
				distribute4gOver3g.getUmtsCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\CommissioningReport_BGL100_20151201.txt",
				distribute4gOver3g.getLteCrFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\Commissioning_BGL100_20151201.xml",
				distribute4gOver3g.getCommFile().toString());
		assertEquals(null, distribute4gOver3g.getSiteInfo());
		assertEquals(null, distribute4gOver3g.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\UP za 46 LTE NSN stanica.xlsx",
				distribute4gOver3g.getUpFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gFull\\Engineer.txt",
				distribute4gOver3g.getEngineerFile().toString());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables4gWithoutCommissioningReport() {
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');
		notDistribute4gOver3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("C:\\RG output\\dummy_file.txt", notDistribute4gOver3gWithoutCr.getCrFileGsm().toString());
		assertEquals("C:\\RG output\\dummy_file.txt", notDistribute4gOver3gWithoutCr.getUmtsCrFile().toString());
		assertEquals("C:\\RG output\\dummy_file.txt", notDistribute4gOver3gWithoutCr.getLteCrFile().toString());
		assertEquals(
				"C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\Commissioning_BGL100_20151201.xml",
				notDistribute4gOver3gWithoutCr.getCommFile().toString());
		assertEquals(null, notDistribute4gOver3gWithoutCr.getSiteInfo());
		assertEquals(null, notDistribute4gOver3gWithoutCr.getBackupCommFile());
		assertEquals("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\UP za 46 LTE NSN stanica.xlsx",
				notDistribute4gOver3gWithoutCr.getUpFile().toString());
		assertEquals("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport\\Engineer.txt",
				notDistribute4gOver3gWithoutCr.getEngineerFile().toString());
	}

	@Test
	public void testReadTransportModuleInfoFrom3gCommissionReport() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("FTIF", common3gFull.readTransportModuleInfoFrom3gCommissionReport());
	}

	@Test
	public void testReadTransportModuleInfoFor3gWithoutCommissionReport() {
		notCommon3gWithoutCr.findSiteCodeFromCommissioningReport('U');
		notCommon3gWithoutCr.setSiteCode('U');
		notCommon3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data", notCommon3gWithoutCr.readTransportModuleInfoFrom3gCommissionReport());
	}

	@Test
	public void testReadSystemModuleInfoFromCommissionReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("FSMF", common3gFull.readSystemModuleInfoFromCommissionReport(common3gFull.getUmtsCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFor3gWithoutCommissionReport() {
		notCommon3gWithoutCr.findSiteCodeFromCommissioningReport('U');
		notCommon3gWithoutCr.setSiteCode('U');
		notCommon3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data",
				notCommon3gWithoutCr.readSystemModuleInfoFromCommissionReport(notCommon3gWithoutCr.getUmtsCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFromCommissionReport4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		assertEquals("FSMF",
				distribute4gOver3g.readSystemModuleInfoFromCommissionReport(distribute4gOver3g.getLteCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFor4gWithoutCommissionReport() {
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');
		notDistribute4gOver3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr
				.readSystemModuleInfoFromCommissionReport(notDistribute4gOver3gWithoutCr.getLteCrFile()));
	}

	@Test
	public void testReadRetInfoFromCommissioningReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("86010148V01", common3gFull.readRetInfoFromCommissioningReport(common3gFull.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFor3gWithoutCommissionReport() {
		notCommon3gWithoutCr.findSiteCodeFromCommissioningReport('U');
		notCommon3gWithoutCr.setSiteCode('U');
		notCommon3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data",
				notCommon3gWithoutCr.readRetInfoFromCommissioningReport(notCommon3gWithoutCr.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFromCommissioningReport4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		assertEquals("86010153",
				distribute4gOver3g.readRetInfoFromCommissioningReport(distribute4gOver3g.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFor4gWithoutCommissionReport() {
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');
		notDistribute4gOver3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr
				.readRetInfoFromCommissioningReport(notDistribute4gOver3gWithoutCr.getLteCrFile()));
	}

	@Test
	public void testReadDateParameterFromCommissioningReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("29.12.2015",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "Date:"));
	}

	@Test
	public void testReadMhaParameterFromCommissioningReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("WMHD",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "MHA type:"));
	}

	@Test
	public void testReadSiteNameParameterFromCommissioningReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("Pilica 2 (Telenor) UMTS",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "Description:"));
	}

	@Test
	public void testReadSwVersionParameterFromCommissioningReport3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("WN9.1_2000_0988_12",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "SW package version:"));
	}

	@Test
	public void testReadSwVersionParameterFor4gWithoutCommissionReport() {
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');
		notDistribute4gOver3gWithoutCr.sortOutInputFilesToAppropriateVariables();

		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr.readParameterFromCommissioningReport(
				notDistribute4gOver3gWithoutCr.getLteCrFile(), "SW package version:"));
	}

	@Test
	public void testReadCommReportForNoOfIfTranssmisionLines3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals(2, common3gFull.readCommReportForNoOfTranssmisionLines(common3gFull.getUmtsCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForZeroIfTranssmisionLines3g() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');
		distribute3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals(0, distribute3gFull.readCommReportForNoOfTranssmisionLines(distribute3gFull.getUmtsCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForZeroIfTranssmisionLines4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		assertEquals(0, distribute4gOver3g.readCommReportForNoOfTranssmisionLines(distribute4gOver3g.getLteCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForNoOfEifTranssmisionLines4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		assertEquals(1, distribute4gOver3g.readCommReportForNoOfTranssmisionLines(distribute4gOver3g.getLteCrFile(),
				"Physical layer configuration", "EIF 1"));
	}

	@Test
	public void testReadCommReportForNoOfFtifTranssmisionLines3g() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');
		distribute3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals(1, distribute3gFull.readCommReportForNoOfTranssmisionLines(distribute3gFull.getUmtsCrFile(),
				"Physical layer configuration", "FTIF 3"));
	}

	@Test
	public void testReadCommReportForRfModuleType3g() {
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');
		distribute3gFull.sortOutInputFilesToAppropriateVariables();

		String[] rfModules = distribute3gFull.readCommReportForRfModuleType(distribute3gFull.getUmtsCrFile(),
				"Module locations", "F");
		assertEquals("FRGT", rfModules[0]);
	}

	@Test
	public void testReadCommReportForRfModuleType4g() {
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();

		String[] rfModules = distribute4gOver3g.readCommReportForRfModuleType(distribute4gOver3g.getLteCrFile(),
				"Module locations", "F");
		assertEquals("FXEB", rfModules[0]);
		assertEquals("FXEB", rfModules[1]);
	}

	@Test
	public void testReadCommReportForTrsIpAdr3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("172.23.207.10 /  29",
				common3gFull.readCommReportForIpAdr(common3gFull.getUmtsCrFile(), "IP addresses", "TRS:"));
	}

	@Test
	public void testReadCommReportForRncIpAdr3g() {
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();

		assertEquals("172.23.192.9",
				common3gFull.readCommReportForIpAdr(common3gFull.getUmtsCrFile(), "IP addresses", "RNC:"));
	}
}
