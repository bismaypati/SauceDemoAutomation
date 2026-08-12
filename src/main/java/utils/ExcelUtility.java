package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {

	private Workbook workbook;
	private Sheet sheet;

	public ExcelUtility(String filePath, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(filePath);

		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheet(sheetName);
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColumnCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellData(int rowNum, int colNum) {

		Cell cell = sheet.getRow(rowNum).getCell(colNum);

		return cell.toString();
	}

	public void closeWorkbook() throws IOException {
		workbook.close();
	}
}
