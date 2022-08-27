package GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fin=new FileInputStream(AutoConstants.Excelpath);
		Workbook wb=WorkbookFactory.create(fin);
		return wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
	}
	
}
