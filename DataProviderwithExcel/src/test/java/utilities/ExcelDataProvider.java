package utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	ExcelUtils excelUtils;
	
	@DataProvider(name = "testdata")
	public static Object[][] provideTestData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/testdata.xlsx";
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] dataForTest = excelDataProvider.getExcelData(excelPath, "Sheet1");
		return dataForTest;
	}
	
	public Object[][] getExcelData(String excelPath, String sheetName) {
		excelUtils = new ExcelUtils(excelPath, sheetName);
		int rowCount = excelUtils.getRowCount();
		int colCount = excelUtils.getColumnCount();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j] = excelUtils.getCellData(i, j);
				// System.out.print(data[i-1][j] + "|");
			}
			// System.out.println();
		}
		return data;
	}
}
