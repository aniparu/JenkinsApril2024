package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver;
	public static Actions a;

	// browser launch

	public static WebDriver browserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		return driver;
	}

	// maximize the browser

	public static void maxBrowser() {
		driver.manage().window().maximize();

	}

	// url
	public static void loadUrl(String url) {
		driver.get(url);

	}

	// sendKeys()
	public static void passText(WebElement element, String txt) {
		element.sendKeys(txt);
	}

	public static String pageTitle() {
		String x = driver.getTitle();
		return x;

	}

	public static String pageUrl() {
		String y = driver.getCurrentUrl();
		return y;

	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public static void closeTheBrowser() {
		driver.close();
	}

	// actions
	public static void dragDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}

	public static void moveToPage(WebElement element) {
		a.moveToElement(element).perform();

	}

	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\screenshot\\" + fileName + ".png");
		FileUtils.copyFile(source, des);

	}

	public static String readExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		// to read data from excel

		// 1.mention excel file path
		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\excel\\EveningBatch6pm.xlsx");

		// to read a file
		FileInputStream fis = new FileInputStream(f);

		// to read exact file format
		Workbook w = new XSSFWorkbook(fis);

		// workbook---->sheet---->row---->cell---->data

		// to get the sheet from workbook
		Sheet s = w.getSheet(sheetName);

		// To iterate the row

		Row r = s.getRow(rowNum);

		// to iterate the cell

		Cell c = r.getCell(cellNum);

		// each cell type
		int cellType = c.getCellType();

		// by default whether cell type ==1 ------>String
		// cell type otherthan 1----->numeric or date cell

		String value = "";

		if (cellType == 1) {

			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {

			Date dd = c.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
			value = sdf.format(dd);

		} else {

			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);

		}

		return value;

	}

	public static void excelWrite(String sheetName, int newRow, int newCell, String newValue) throws Exception {

		// to write data from excel

		// workbook --->sheet---->row----->cell---->data

		// mention the path location

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\excel\\newFile.xlsx");

		// to create workbook

		Workbook cw = new XSSFWorkbook();

		// create sheet from workbook
		Sheet cs = cw.getSheet(sheetName);

		// create row from sheet

		Row cr = cs.createRow(newRow);

		// create cell from row

		Cell cc = cr.createCell(newCell);

		// set the data in 0 th row and 3 rd cell

		cc.setCellValue(newValue);

		FileOutputStream fos = new FileOutputStream(f);

		cw.write(fos);

		System.out.println("done");

	}

	public static void createCellOnly(String sheetName, int newRow, int newCell, String newValue) throws Exception {
		// to write data from excel

		// workbook --->sheet---->row----->cell---->data

		// mention the path location

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\excel\\newFile.xlsx");

		FileInputStream fis = new FileInputStream(f);

		// to create workbook

		Workbook cw = new XSSFWorkbook(fis);

		// create sheet from workbook
		Sheet cs = cw.getSheet(sheetName);

		// create row from sheet

		Row cr = cs.getRow(newRow);

		// create cell from row

		Cell cc = cr.createCell(newCell);

		// set the data in 0 th row and 3 rd cell

		cc.setCellValue(newValue);

		FileOutputStream fos = new FileOutputStream(f);

		cw.write(fos);

		System.out.println("done");

	}

	public static void createRowOnly(String sheetName, int newRow, int newCell, String newValue) throws Exception {
		// to write data from excel

		// workbook --->sheet---->row----->cell---->data

		// mention the path location

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\excel\\newFile.xlsx");

		FileInputStream fis = new FileInputStream(f);

		// to create workbook

		Workbook cw = new XSSFWorkbook(fis);

		// create sheet from workbook
		Sheet cs = cw.getSheet(sheetName);

		// create row from sheet

		Row cr = cs.createRow(newRow);

		// create cell from row

		Cell cc = cr.createCell(newCell);

		// set the data in 0 th row and 3 rd cell

		cc.setCellValue(newValue);

		FileOutputStream fos = new FileOutputStream(f);

		cw.write(fos);

		System.out.println("done");

	}

	public static void updateData(String sheetName, int newRow, int newCell, String existingData, String newData)
			throws Exception {
		// to write data from excel

		// workbook --->sheet---->row----->cell---->data

		// mention the path location

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenBatch6Pm\\excel\\newFile.xlsx");

		FileInputStream fis = new FileInputStream(f);

		// to create workbook

		Workbook cw = new XSSFWorkbook(fis);

		// create sheet from workbook
		Sheet cs = cw.getSheet(sheetName);

		// create row from sheet

		Row cr = cs.getRow(newRow);

		// create cell from row

		Cell cc = cr.getCell(newCell);

		// set the data in 0 th row and 3 rd cell
		String value = cc.getStringCellValue();

		if (value.equals(existingData)) {

			cc.setCellValue(newData);

		}

		FileOutputStream fos = new FileOutputStream(f);

		cw.write(fos);

		System.out.println("done");

	}

}
