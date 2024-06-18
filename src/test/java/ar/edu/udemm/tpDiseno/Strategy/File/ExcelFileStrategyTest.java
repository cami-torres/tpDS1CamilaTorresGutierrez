package ar.edu.udemm.tpDiseno.Strategy.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.udemm.tpDiseno.Entity.Qualification;

public class ExcelFileStrategyTest {
    private ExcelFileStrategy excelFileStrategy;

    @BeforeEach
    public void setUp() {
        excelFileStrategy = new ExcelFileStrategy();
    }

    @Test
    public void testParse() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("name");
        header.createCell(1).setCellValue("subject");
        header.createCell(2).setCellValue("qualification");

        // Data rows
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("John Doe");
        row1.createCell(1).setCellValue("Math");
        row1.createCell(2).setCellValue(95);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("Jane Smith");
        row2.createCell(1).setCellValue("Science");
        row2.createCell(2).setCellValue(89);

        workbook.write(bos);
        workbook.close();

        InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        List<Qualification> qualifications = excelFileStrategy.parse(inputStream);

        assertNotNull(qualifications);
        assertEquals(2, qualifications.size());

        Qualification q1 = qualifications.get(0);
        assertEquals("John Doe", q1.getName());
        assertEquals("Math", q1.getSubject());
        assertEquals(95, q1.getQualification());

        Qualification q2 = qualifications.get(1);
        assertEquals("Jane Smith", q2.getName());
        assertEquals("Science", q2.getSubject());
        assertEquals(89, q2.getQualification());
    }
}
