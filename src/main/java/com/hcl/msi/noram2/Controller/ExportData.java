package com.hcl.msi.noram2.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hcl.msi.noram2.Service.TransitionEstiPOJO;
import com.hcl.msi.noram2.Service.TransitionProjPOJO;

public class ExportData {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<TransitionEstiPOJO> listUsers;
	private List<TransitionProjPOJO> quesList;
	int rowCount = 0;

	public ExportData(List<TransitionEstiPOJO> listUsers, List<TransitionProjPOJO> quesList) {
		this.listUsers = listUsers;
		this.quesList = quesList;
		workbook = new XSSFWorkbook();
	}
	private CellStyle headerCellStyle() {
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(10);
		style.setFont(font);
		return style;
	}
	private CellStyle dataCellStyle() {
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(10);
		style.setFont(font);
		return style;
	}
	private void writeHeaderLine() {
		sheet = workbook.createSheet("Report");
		Row row = sheet.createRow(rowCount);
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer Address", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_address(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer Location", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_location(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer Contact", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_contact(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer Phone", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_phone(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Project Name", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getProject_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "USA DC", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getUsa_dc(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "EMEA DC", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getEmea_dc(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "APAC DC", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getApac_dc(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "USA RS", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getUsa_rs(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "EMEA RS", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getEmea_rs(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "APAC RS", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getApac_rs(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Complexity Name", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getComplexity(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Duration", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getDuration(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Cloud", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCloud(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Project Description", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getProject_Description(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Estimate Name", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getEstimate_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Estimate Description", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getEstimate_description(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Project Type", headerCellStyle());
		createCell(row, 1, "Transition", dataCellStyle());
		row = sheet.createRow(rowCount++);
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Service Name", headerCellStyle());
		createCell(row, 1, "Technology Name", headerCellStyle());
		createCell(row, 2, "Resource Unit", headerCellStyle());
		createCell(row, 3, "Effort", headerCellStyle());

	}
	private void writeHeaderLineForQues() {
		sheet = workbook.createSheet("Questionnaire");
		Row row = sheet.createRow(rowCount);
		rowCount = 0;
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Customer", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getCustomer_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Project Name", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getProject_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Estimate Name", headerCellStyle());
		createCell(row, 1, listUsers.get(0).getEstimate_name(), dataCellStyle());
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Project Type", headerCellStyle());
		createCell(row, 1, "Transition", dataCellStyle());
		row = sheet.createRow(rowCount++);
		row = sheet.createRow(rowCount++);
		createCell(row, 0, "Track", headerCellStyle());
		createCell(row, 1, "Queries", headerCellStyle());
		createCell(row, 2, "Answer", headerCellStyle());
	}
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {

		for (TransitionEstiPOJO user : listUsers) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, user.getService_name(), dataCellStyle());
			createCell(row, columnCount++, user.getTechnology_name(), dataCellStyle());
			createCell(row, columnCount++, user.getResource_unit(), dataCellStyle());
			createCell(row, columnCount++, user.getEffort(), dataCellStyle());

		}
	}
	private void writeDataLinesForQues() {

		for (TransitionProjPOJO user : quesList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, user.getQuestion(), dataCellStyle());
			createCell(row, columnCount++, user.getQueries(), dataCellStyle());
			createCell(row, columnCount++, user.getAnswer(), dataCellStyle());

		}
	}
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		writeHeaderLineForQues();
		writeDataLinesForQues();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}
