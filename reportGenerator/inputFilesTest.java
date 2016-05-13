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
	public void setUpCommon3gFull() {
		common3gFull = new InputFiles();
		common3gFull.setListOfFiles("C:\\RG input test\\3gCommonFull");
		common3gFull.findSiteCodeFromCommissioningReport('U');
		common3gFull.setSiteCode('U');
		common3gFull.sortOutInputFilesToAppropriateVariables();
	}

	@Before
	public void setUpDistribute3gFull() {
		distribute3gFull = new InputFiles();
		distribute3gFull.setListOfFiles("C:\\RG input test\\3gDistributeFull");
		distribute3gFull.findSiteCodeFromCommissioningReport('U');
		distribute3gFull.setSiteCode('U');
		distribute3gFull.sortOutInputFilesToAppropriateVariables();
	}

	@Before
	public void setUpDistribute4gOver2g() {
		distribute4gOver2g = new InputFiles();
		distribute4gOver2g.setListOfFiles("C:\\RG input test\\4gDistributeOver2gFull");
		distribute4gOver2g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver2g.setSiteCode('L');
		distribute4gOver2g.sortOutInputFilesToAppropriateVariables();
	}

	@Before
	public void setUpDistribute4gOver3g() {
		distribute4gOver3g = new InputFiles();
		distribute4gOver3g.setListOfFiles("C:\\\\RG input test\\\\4gDistributeOver3gFull");
		distribute4gOver3g.findSiteCodeFromCommissioningReport('L');
		distribute4gOver3g.setSiteCode('L');
		distribute4gOver3g.sortOutInputFilesToAppropriateVariables();
	}

	@Before
	public void setUpDistribute4gOver3gWithoutCr() {
		distribute4gOver3gWithoutCr = new InputFiles();
		distribute4gOver3gWithoutCr.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");
		distribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('U');
	}

	@Before
	public void setUpNotCommon3gWithoutCr() {
		notCommon3gWithoutCr = new InputFilesWithNotificationResponse();
		notCommon3gWithoutCr.setListOfFiles("C:\\RG input test\\3gCommonWithoutCommissioningReport");
		notCommon3gWithoutCr.findSiteCodeFromCommissioningReport('U');
		notCommon3gWithoutCr.setSiteCode('U');
		notCommon3gWithoutCr.sortOutInputFilesToAppropriateVariables();
	}

	@Before
	public void setUpNotDistribute4gOver3gWithoutCr() {
		notDistribute4gOver3gWithoutCr = new InputFilesWithNotificationResponse();
		notDistribute4gOver3gWithoutCr
				.setListOfFiles("C:\\RG input test\\4gDistributeOver3gWithoutCommissioningReport");
		notDistribute4gOver3gWithoutCr.findSiteCodeFromCommissioningReport('L');
		notDistribute4gOver3gWithoutCr.setSiteCode('L');
		notDistribute4gOver3gWithoutCr.sortOutInputFilesToAppropriateVariables();
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gCommon() {
		assertEquals("UEU124", common3gFull.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport3gDistirbute() {
		assertEquals("VRU62", distribute3gFull.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeWhenThereIsNoCommissioningReport() {
		assertEquals("xxxyy", distribute4gOver3gWithoutCr.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver2g() {
		assertEquals("NIL35", distribute4gOver2g.getSiteCodeStr());
	}

	@Test
	public void testFindSiteCodeFromCommissioningReport4gOver3g() {
		assertEquals("BGL100", distribute4gOver3g.getSiteCodeStr());
	}

	@Test
	public void testSetSiteCode3g() {
		assertEquals("xxxyy", distribute3gFull.getSiteCode2gStr());
		assertEquals("VRU62", distribute3gFull.getSiteCode3gStr());
		assertEquals("xxxyy", distribute3gFull.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4g() {
		assertEquals("BG100", distribute4gOver3g.getSiteCode2gStr());
		assertEquals("BGU100", distribute4gOver3g.getSiteCode3gStr());
		assertEquals("BGL100", distribute4gOver3g.getSiteCode4gStr());
	}

	@Test
	public void testSetSiteCode4gWithoutCommissioningReport() {
		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode2gStr());
		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode3gStr());
		assertEquals("xxxyy", notDistribute4gOver3gWithoutCr.getSiteCode4gStr());
	}

	@Test
	public void testSortOutInputFilesToAppropriateVariables3g() {
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
		assertEquals("FTIF", common3gFull.readTransportModuleInfoFrom3gCommissionReport());
	}

	@Test
	public void testReadTransportModuleInfoFor3gWithoutCommissionReport() {
		assertEquals("Dummy_Data", notCommon3gWithoutCr.readTransportModuleInfoFrom3gCommissionReport());
	}

	@Test
	public void testReadSystemModuleInfoFromCommissionReport3g() {
		assertEquals("FSMF", common3gFull.readSystemModuleInfoFromCommissionReport(common3gFull.getUmtsCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFor3gWithoutCommissionReport() {
		assertEquals("Dummy_Data",
				notCommon3gWithoutCr.readSystemModuleInfoFromCommissionReport(notCommon3gWithoutCr.getUmtsCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFromCommissionReport4g() {
		assertEquals("FSMF",
				distribute4gOver3g.readSystemModuleInfoFromCommissionReport(distribute4gOver3g.getLteCrFile()));
	}

	@Test
	public void testReadSystemModuleInfoFor4gWithoutCommissionReport() {
		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr
				.readSystemModuleInfoFromCommissionReport(notDistribute4gOver3gWithoutCr.getLteCrFile()));
	}

	@Test
	public void testReadRetInfoFromCommissioningReport3g() {
		assertEquals("86010148V01", common3gFull.readRetInfoFromCommissioningReport(common3gFull.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFor3gWithoutCommissionReport() {
		assertEquals("Dummy_Data",
				notCommon3gWithoutCr.readRetInfoFromCommissioningReport(notCommon3gWithoutCr.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFromCommissioningReport4g() {
		assertEquals("86010153",
				distribute4gOver3g.readRetInfoFromCommissioningReport(distribute4gOver3g.getUmtsCrFile()));
	}

	@Test
	public void testReadRetInfoFor4gWithoutCommissionReport() {
		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr
				.readRetInfoFromCommissioningReport(notDistribute4gOver3gWithoutCr.getLteCrFile()));
	}

	@Test
	public void testReadDateParameterFromCommissioningReport3g() {
		assertEquals("29.12.2015",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "Date:"));
	}

	@Test
	public void testReadMhaParameterFromCommissioningReport3g() {
		assertEquals("WMHD",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "MHA type:"));
	}

	@Test
	public void testReadSiteNameParameterFromCommissioningReport3g() {
		assertEquals("Pilica 2 (Telenor) UMTS",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "Description:"));
	}

	@Test
	public void testReadSwVersionParameterFromCommissioningReport3g() {
		assertEquals("WN9.1_2000_0988_12",
				common3gFull.readParameterFromCommissioningReport(common3gFull.getUmtsCrFile(), "SW package version:"));
	}

	@Test
	public void testReadSwVersionParameterFor4gWithoutCommissionReport() {
		assertEquals("Dummy_Data", notDistribute4gOver3gWithoutCr.readParameterFromCommissioningReport(
				notDistribute4gOver3gWithoutCr.getLteCrFile(), "SW package version:"));
	}

	@Test
	public void testReadCommReportForNoOfIfTranssmisionLines3g() {
		assertEquals(2, common3gFull.readCommReportForNoOfTranssmisionLines(common3gFull.getUmtsCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForZeroIfTranssmisionLines3g() {
		assertEquals(0, distribute3gFull.readCommReportForNoOfTranssmisionLines(distribute3gFull.getUmtsCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForZeroIfTranssmisionLines4g() {
		assertEquals(0, distribute4gOver3g.readCommReportForNoOfTranssmisionLines(distribute4gOver3g.getLteCrFile(),
				"Physical layer configuration", "IF"));
	}

	@Test
	public void testReadCommReportForNoOfEifTranssmisionLines4g() {
		assertEquals(1, distribute4gOver3g.readCommReportForNoOfTranssmisionLines(distribute4gOver3g.getLteCrFile(),
				"Physical layer configuration", "EIF 1"));
	}

	@Test
	public void testReadCommReportForNoOfFtifTranssmisionLines3g() {
		assertEquals(1, distribute3gFull.readCommReportForNoOfTranssmisionLines(distribute3gFull.getUmtsCrFile(),
				"Physical layer configuration", "FTIF 3"));
	}

	@Test
	public void testReadCommReportForRfModuleType3g() {
		String[] rfModules = distribute3gFull.readCommReportForRfModuleType(distribute3gFull.getUmtsCrFile(),
				"Module locations", "F");
		assertEquals("FRGT", rfModules[0]);
	}

	@Test
	public void testReadCommReportForRfModuleType4g() {
		String[] rfModules = distribute4gOver3g.readCommReportForRfModuleType(distribute4gOver3g.getLteCrFile(),
				"Module locations", "F");
		assertEquals("FXEB", rfModules[0]);
		assertEquals("FXEB", rfModules[1]);
	}

	@Test
	public void testReadCommReportForTrsIpAdr3g() {
		assertEquals("172.23.207.10 /  29",
				common3gFull.readCommReportForIpAdr(common3gFull.getUmtsCrFile(), "IP addresses", "TRS:"));
	}

	@Test
	public void testReadCommReportForRncIpAdr3g() {
		assertEquals("172.23.192.9",
				common3gFull.readCommReportForIpAdr(common3gFull.getUmtsCrFile(), "IP addresses", "RNC:"));
	}

	@Test
	public void testRead3gCommReportForCellIdsOf4Digit() {
		common3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");

		assertArrayEquals(new String[] { "2241", "2242", "2243", "2245", "2246", "2247", "0", "0", "0" },
				common3gFull.getResultCellIds());
	}

	@Test
	public void testRead3gCommReportForCellIdsOf5Digits() {
		distribute3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");

		assertArrayEquals(new String[] { "11862", "15962", "21862", "25962", "31862", "35962", "0", "0", "0" },
				distribute3gFull.getResultCellIds());
	}

	@Test
	public void testSet3gCellIdsOf4Digit() {
		common3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");

		String[][] actual = common3gFull.set3gCellIds(common3gFull.getResultCellIds());
		String[][] expected = new String[][] { { "2241", "2245", "0" }, { "2242", "2246", "0" },
				{ "2243", "2247", "0" }, { "0", "0", "0" } };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSet3gCellIdsOf5Digits() {
		distribute3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");

		String[][] actual = distribute3gFull.set3gCellIds(distribute3gFull.getResultCellIds());
		String[][] expected = new String[][] { { "11862", "15962", "0" }, { "21862", "25962", "0" },
				{ "31862", "35962", "0" }, { "0", "0", "0" } };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRead3gCommReportForUarfcnOf4DigitCellId() {
		common3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");
		String[][] cellIdGroup = common3gFull.set3gCellIds(common3gFull.getResultCellIds());

		int[][] actual = common3gFull.read3gCommReportForUarfcn("Local cell group:", "Baseband (BB) allocation",
				cellIdGroup);
		int[][] expected = new int[][] { { 10638, 10663, 0 }, { 10638, 10663, 0 }, { 10638, 10663, 0 }, { 0, 0, 0 } };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRead3gCommReportForUarfcnOf5DigitCellId() {
		distribute3gFull.read3gCommReportForCellIds("Local cell resources", "Local cell settings");
		String[][] cellIdGroup = distribute3gFull.set3gCellIds(distribute3gFull.getResultCellIds());

		int[][] actual = distribute3gFull.read3gCommReportForUarfcn("Local cell group:", "Baseband (BB) allocation",
				cellIdGroup);
		int[][] expected = new int[][] { { 10638, 10663, 0 }, { 10638, 10663, 0 }, { 10638, 10663, 0 }, { 0, 0, 0 } };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRead3gCommReportForExtAlCommon() {
		String[] actualAlarm1 = common3gFull.read3gCommReportForExtAl("External fault lines", "1");
		String[] actualAlarm5 = common3gFull.read3gCommReportForExtAl("External fault lines", "5");
		String[] actualAlarm6 = common3gFull.read3gCommReportForExtAl("External fault lines", "6");
		String[] actualAlarm7 = common3gFull.read3gCommReportForExtAl("External fault lines", "7");

		String[] expectedAlarm1 = new String[] { "Yes", "BS working in battery mode", "Normally closed", "Critical" };
		String[] expectedAlarm5 = new String[] { "Yes", "Door open", "Normally open", "Minor" };
		String[] expectedAlarm6 = new String[] { null, null, null, null };
		String[] expectedAlarm7 = new String[] { "Yes", "Magnetno termicka", "Normally open", "Major" };

		assertArrayEquals(expectedAlarm1, actualAlarm1);
		assertArrayEquals(expectedAlarm5, actualAlarm5);
		assertArrayEquals(expectedAlarm6, actualAlarm6);
		assertArrayEquals(expectedAlarm7, actualAlarm7);
	}

	@Test
	public void testReadUpForSiteChanged4gOver3g() {
		AffectedSite gsm9Affectedsite = distribute4gOver3g.readUpForSiteChanged("",
				distribute4gOver3g.getSiteCode4gStr());
		AffectedSite umtsAffectedsite = distribute4gOver3g.readUpForSiteChanged("U",
				distribute4gOver3g.getSiteCode4gStr());
		AffectedSite lteAffectedsite = distribute4gOver3g.readUpForSiteChanged("L",
				distribute4gOver3g.getSiteCode4gStr());

		assertEquals(30, gsm9Affectedsite.getAzimuthS1());
		assertEquals(120, gsm9Affectedsite.getAzimuthS2());
		assertEquals(220, gsm9Affectedsite.getAzimuthS3());
		assertEquals(0, gsm9Affectedsite.getAzimuthS4());
		assertEquals(2, gsm9Affectedsite.getElectricalTiltS1());
		assertEquals(2, gsm9Affectedsite.getElectricalTiltS2());
		assertEquals(2, gsm9Affectedsite.getElectricalTiltS3());
		assertEquals(0, gsm9Affectedsite.getElectricalTiltS4());
		assertEquals(0, gsm9Affectedsite.getMechanicalTiltS1());
		assertEquals(-4, gsm9Affectedsite.getMechanicalTiltS2());
		assertEquals(0, gsm9Affectedsite.getMechanicalTiltS3());
		assertEquals(0, gsm9Affectedsite.getMechanicalTiltS4());
		assertEquals(18.3, gsm9Affectedsite.getAntHighS1(), 0.01);
		assertEquals(18.3, gsm9Affectedsite.getAntHighS2(), 0.01);
		assertEquals(18.3, gsm9Affectedsite.getAntHighS3(), 0.01);
		assertEquals(0, gsm9Affectedsite.getAntHighS4(), 0.01);
		assertEquals(80010892, gsm9Affectedsite.getAntenaTypeS1());
		assertEquals(80010892, gsm9Affectedsite.getAntenaTypeS2());
		assertEquals(80010892, gsm9Affectedsite.getAntenaTypeS3());
		assertEquals(0, gsm9Affectedsite.getAntenaTypeS4());
		assertEquals(3, gsm9Affectedsite.getNumOfSectors());

		assertEquals(30, umtsAffectedsite.getAzimuthS1());
		assertEquals(120, umtsAffectedsite.getAzimuthS2());
		assertEquals(220, umtsAffectedsite.getAzimuthS3());
		assertEquals(0, umtsAffectedsite.getAzimuthS4());
		assertEquals(2, umtsAffectedsite.getElectricalTiltS1());
		assertEquals(3, umtsAffectedsite.getElectricalTiltS2());
		assertEquals(4, umtsAffectedsite.getElectricalTiltS3());
		assertEquals(0, umtsAffectedsite.getElectricalTiltS4());
		assertEquals(0, umtsAffectedsite.getMechanicalTiltS1());
		assertEquals(-4, umtsAffectedsite.getMechanicalTiltS2());
		assertEquals(0, umtsAffectedsite.getMechanicalTiltS3());
		assertEquals(0, umtsAffectedsite.getMechanicalTiltS4());
		assertEquals(18.3, umtsAffectedsite.getAntHighS1(), 0.01);
		assertEquals(18.3, umtsAffectedsite.getAntHighS2(), 0.01);
		assertEquals(18.3, umtsAffectedsite.getAntHighS3(), 0.01);
		assertEquals(0, umtsAffectedsite.getAntHighS4(), 0.01);
		assertEquals(80010892, umtsAffectedsite.getAntenaTypeS1());
		assertEquals(80010892, umtsAffectedsite.getAntenaTypeS2());
		assertEquals(80010892, umtsAffectedsite.getAntenaTypeS3());
		assertEquals(0, umtsAffectedsite.getAntenaTypeS4());
		assertEquals(3, umtsAffectedsite.getNumOfSectors());

		assertEquals(30, lteAffectedsite.getAzimuthS1());
		assertEquals(120, lteAffectedsite.getAzimuthS2());
		assertEquals(220, lteAffectedsite.getAzimuthS3());
		assertEquals(0, lteAffectedsite.getAzimuthS4());
		assertEquals(2, lteAffectedsite.getElectricalTiltS1());
		assertEquals(2, lteAffectedsite.getElectricalTiltS2());
		assertEquals(2, lteAffectedsite.getElectricalTiltS3());
		assertEquals(0, lteAffectedsite.getElectricalTiltS4());
		assertEquals(0, lteAffectedsite.getMechanicalTiltS1());
		assertEquals(-4, lteAffectedsite.getMechanicalTiltS2());
		assertEquals(0, lteAffectedsite.getMechanicalTiltS3());
		assertEquals(0, lteAffectedsite.getMechanicalTiltS4());
		assertEquals(18.3, lteAffectedsite.getAntHighS1(), 0.01);
		assertEquals(18.3, lteAffectedsite.getAntHighS2(), 0.01);
		assertEquals(18.3, lteAffectedsite.getAntHighS3(), 0.01);
		assertEquals(0, lteAffectedsite.getAntHighS4(), 0.01);
		assertEquals(80010892, lteAffectedsite.getAntenaTypeS1());
		assertEquals(80010892, lteAffectedsite.getAntenaTypeS2());
		assertEquals(80010892, lteAffectedsite.getAntenaTypeS3());
		assertEquals(0, lteAffectedsite.getAntenaTypeS4());
		assertEquals(3, lteAffectedsite.getNumOfSectors());
	}

	@Test
	public void testReadUpForSiteChangedAnntenaTypeAsString() {
		AffectedSite gsm18Affectedsite = distribute4gOver3g.readUpForSiteChanged("H", "CAL05");
		AffectedSite lteAffectedsite = distribute4gOver3g.readUpForSiteChanged("L", "CAL05");

		assertEquals(145, gsm18Affectedsite.getAzimuthS1());
		assertEquals(220, gsm18Affectedsite.getAzimuthS2());
		assertEquals(330, gsm18Affectedsite.getAzimuthS3());
		assertEquals(0, gsm18Affectedsite.getAzimuthS4());
		assertEquals(5, gsm18Affectedsite.getElectricalTiltS1());
		assertEquals(5, gsm18Affectedsite.getElectricalTiltS2());
		assertEquals(5, gsm18Affectedsite.getElectricalTiltS3());
		assertEquals(0, gsm18Affectedsite.getElectricalTiltS4());
		assertEquals(-2, gsm18Affectedsite.getMechanicalTiltS1());
		assertEquals(0, gsm18Affectedsite.getMechanicalTiltS2());
		assertEquals(0, gsm18Affectedsite.getMechanicalTiltS3());
		assertEquals(0, gsm18Affectedsite.getMechanicalTiltS4());
		assertEquals(30, gsm18Affectedsite.getAntHighS1(), 0.01);
		assertEquals(30, gsm18Affectedsite.getAntHighS2(), 0.01);
		assertEquals(30, gsm18Affectedsite.getAntHighS3(), 0.01);
		assertEquals(0, gsm18Affectedsite.getAntHighS4(), 0.01);
		assertEquals("APX186516-T5", gsm18Affectedsite.getAntenaTypeS1Str());
		assertEquals("APX186516-T5", gsm18Affectedsite.getAntenaTypeS2Str());
		assertEquals("APX186516-T5", gsm18Affectedsite.getAntenaTypeS3Str());
		assertEquals("", gsm18Affectedsite.getAntenaTypeS4Str());
		assertEquals(3, gsm18Affectedsite.getNumOfSectors());

		assertEquals(145, lteAffectedsite.getAzimuthS1());
		assertEquals(220, lteAffectedsite.getAzimuthS2());
		assertEquals(330, lteAffectedsite.getAzimuthS3());
		assertEquals(0, lteAffectedsite.getAzimuthS4());
		assertEquals(5, lteAffectedsite.getElectricalTiltS1());
		assertEquals(5, lteAffectedsite.getElectricalTiltS2());
		assertEquals(5, lteAffectedsite.getElectricalTiltS3());
		assertEquals(0, lteAffectedsite.getElectricalTiltS4());
		assertEquals(0, lteAffectedsite.getMechanicalTiltS1());
		assertEquals(10, lteAffectedsite.getMechanicalTiltS2());
		assertEquals(5, lteAffectedsite.getMechanicalTiltS3());
		assertEquals(0, lteAffectedsite.getMechanicalTiltS4());
		assertEquals(30, lteAffectedsite.getAntHighS1(), 0.01);
		assertEquals(30, lteAffectedsite.getAntHighS2(), 0.01);
		assertEquals(30, lteAffectedsite.getAntHighS3(), 0.01);
		assertEquals(0, lteAffectedsite.getAntHighS4(), 0.01);
		assertEquals(80010504, lteAffectedsite.getAntenaTypeS1());
		assertEquals(80010504, lteAffectedsite.getAntenaTypeS2());
		assertEquals(80010504, lteAffectedsite.getAntenaTypeS3());
		assertEquals(0, lteAffectedsite.getAntenaTypeS4());
		assertEquals(3, lteAffectedsite.getNumOfSectors());
	}

	@Test
	public void testSetCrOfTransmissionForLteOver3g() {
		distribute4gOver3g.setCrOfTransmissionForLteOver3g("BGU100");

		String expected = "C:\\RG input test\\4gDistributeOver3gFull\\CommissioningReport_BGU100_20151201.txt";
		assertEquals(expected, distribute4gOver3g.getCrOfTransmissionForLte().toString());
	}

	@Test
	public void testSetCrOfTransmissionForLteOver2g() {
		distribute4gOver2g.setCrOfTransmissionForLteOver2g();

		String expected = "C:\\RG input test\\4gDistributeOver2gFull\\BCFID1090_04Nov2015_1705_SCF.xml";
		assertEquals(expected, distribute4gOver2g.getCrOfTransmissionForLte().toString());
	}
}
