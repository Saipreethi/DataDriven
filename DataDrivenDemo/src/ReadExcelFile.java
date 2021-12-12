import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ReadExcelFile(String excelpath)
	{
		try
		{
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetno,int row,int col) {
		sheet = wb.getSheetAt(sheetno);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetno) {
		int row = wb.getSheetAt(sheetno).getLastRowNum();
		row = row+1;
		return row;
	}
}
