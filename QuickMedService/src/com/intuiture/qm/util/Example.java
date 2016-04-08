package com.intuiture.qm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.intuiture.qm.json.Testjson;

public class Example {
	// Read the xls file data using jxl
	// public void readExcel() throws BiffException, IOException {
	// String FilePath = "C:\\Users\\Lenovo\\Desktop\\imp.xls";
	// FileInputStream fs = new FileInputStream(FilePath);
	// Workbook wb = Workbook.getWorkbook(fs);
	//
	// // TO get the access to the sheet
	// Sheet sh = wb.getSheet("Sheet1");
	//
	// // To get the number of rows present in sheet
	// int totalNoOfRows = sh.getRows();
	//
	// // To get the number of columns present in sheet
	// int totalNoOfCols = sh.getColumns();
	//
	// for (int row = 0; row < totalNoOfRows; row++) {
	//
	// for (int col = 0; col < totalNoOfCols; col++) {
	// System.out.print(sh.getCell(col, row).getContents() + "\t");
	// }
	// System.out.println();
	// }
	// }
	//
	// public static void main(String args[]) throws BiffException, IOException
	// {
	// Example DT = new Example();
	// DT.readExcel();
	// }

	public static void main(String[] args) throws IOException {
		Example ex = new Example();
		String excelFilePath = "C:\\Users\\Lenovo\\Desktop\\QuickMed\\QuickMedData.xlsx";
		ex.readBooksFromExcelFile(excelFilePath);
		List<Testjson> listBooks = ex.readBooksFromExcelFile(excelFilePath);
		System.out.println(listBooks);
	}

	public List<Testjson> readBooksFromExcelFile(String excelFilePath)
			throws IOException {
		List<Testjson> listBooks = new ArrayList<Testjson>();
		FileInputStream inputStream = new FileInputStream(new File(
				excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(1);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Testjson json = new Testjson();
			if (nextRow.getRowNum() != 0) {
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						json.setDate((Date) getCellValue(nextCell));
						break;
					case 1:
						json.setActivity((String) getCellValue(nextCell));
						break;
					case 2:
						json.setHours(((Double) getCellValue(nextCell)).intValue());
						break;
					}

				}
				listBooks.add(json);
			}
		}

		workbook.close();
		inputStream.close();

		return listBooks;
	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			}
			return cell.getNumericCellValue();
		}

		return null;
	}

}
