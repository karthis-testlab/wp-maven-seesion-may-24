package wp.week08.session2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String[][] getData(String fileName) {
		String[][] data = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);					
				for (int j = 0; j < row.getLastCellNum(); j++) {
					data[i-1][j] = row.getCell(j).getStringCellValue();
				}
			}		
	        workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}