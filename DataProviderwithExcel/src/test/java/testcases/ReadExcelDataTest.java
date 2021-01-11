package testcases;

import org.testng.annotations.Test;

public class ReadExcelDataTest {
	@Test(dataProvider = "testdata", dataProviderClass = utilities.ExcelDataProvider.class)
	public void getTestData(String... data) {
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println(data[5]);
		System.out.println(data[6]);
		System.out.println(data[7]);
		System.out.println(data[8]);
	}
}
