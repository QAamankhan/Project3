package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelReader {
	public Object[][] Data() throws Exception, IOException {
		
		String path="D:\\Practice_Excel.xlsx\\";
		
		FileInputStream fis = new FileInputStream(path);
		
		Workbook ws = WorkbookFactory.create(fis);
		
		Sheet sheet= ws.getSheet("Sheet1");
		int rowsnum= sheet.getPhysicalNumberOfRows();
		int cellnum= sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowsnum-1][cellnum];
		
		
		for(int i=1;i<rowsnum;i++) {
			Row row= sheet.getRow(i);
			for(int j=0;j<cellnum;j++) {
				Cell cell= row.getCell(j);				
				if (cell.getStringCellValue().isEmpty()) {
					data[i-1][j]="";
				} else {
					data[i-1][j]=cell.getStringCellValue();
				}

			}
		}
		ws.close();
        fis.close();
		return data;
		
		
	}
	
}
