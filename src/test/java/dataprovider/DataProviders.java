package dataprovider;


import java.io.File;
import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DataProviders {
	
 
  @DataProvider (name = "searchItemDataFromXLS")
  public Object[][] readDataFromXLS() {
    return readDataFromXLS("src/test/resources/testdata/dataforsearchavactis.xls","Search", "SerachStartEnd");

  }
  
  public String[][] readDataFromXLS(String xlFilePath, String sheetName, String marker) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			// Workbook class is provied by jxl.jar
			// WebDriver provided by Selenium
			// File is class provided by Java to read a physical file
			Sheet sheet = workbook.getSheet(sheetName);
			Cell tableStart = sheet.findCell(marker);

			int startRow, startCol, endRow, endCol, ci, cj;

			startRow = tableStart.getRow();// 2
			startCol = tableStart.getColumn();// 1

			Cell tableEnd = sheet.findCell(marker, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();// 7
			endCol = tableEnd.getColumn();// 5
//			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
//					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];// 4, 3
			ci = 0; // array row
			// ci=0,i=3, j=3,cj=1
			for (int i = startRow + 1; i < endRow; i++, ci++) {// i represents
																// xls row
				cj = 0;// array column
				for (int j = startCol + 1; j < endCol; j++, cj++) {// j
																	// represents
																	// xls
																	// column
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you specified does not exist");
		} catch (Exception e) {
			System.out.println("Please check if file path, sheet name and tag name are correct");
			e.toString();

		}

		return (tabArray);
		
	}
 
}
