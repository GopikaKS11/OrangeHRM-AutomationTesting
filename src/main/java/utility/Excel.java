package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String cellValues(String filepath, String Sheet, int r, int c) {

		try {
			FileInputStream File = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(File);
			XSSFSheet sh = wb.getSheet(Sheet);
			XSSFCell cell = sh.getRow(r).getCell(c);
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else {
				double v = cell.getNumericCellValue();
				int val = (int) v;
				return String.valueOf(val);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public static int rowcount(String filepath, String Sheet) {
		try {
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sh = wb.getSheet(Sheet);
			return sh.getLastRowNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
