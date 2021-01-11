package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;

//	public static void main(String[] args) {
//		String projectPath = System.getProperty("user.dir");
//		String excelPath = projectPath + "/testdata.xlsx";
//		ExcelUtils utils = new ExcelUtils(excelPath, "Sheet1");
//		utils.getRowCount();
//		utils.getColumnCount();
//		utils.getCellData(1, 0);
//	}

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getColumnCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(1).getPhysicalNumberOfCells();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}

	public String getCellData(int rowNum, int colNum) {
		XSSFCell cell = null;
		String cellValue = null;
		try { 
			cell = sheet.getRow(rowNum).getCell(colNum);
			DataFormatter dataFormatter  = new DataFormatter();
			cellValue = dataFormatter.formatCellValue(cell);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}
}
