package generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String ReadDataEx(String sheetName,int row, int cell)throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(row).getCell(cell).getStringCellValue();
	}
}
