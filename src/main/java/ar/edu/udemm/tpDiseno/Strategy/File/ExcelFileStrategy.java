package ar.edu.udemm.tpDiseno.Strategy.File;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.Qualification;

@Service
public class ExcelFileStrategy implements FileStrategy {

    @Override
    public List<Qualification> parse(InputStream inputStream) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        List<Qualification> qualifications = new ArrayList<>();

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // Skip header row
                    continue;
                }

                String name = row.getCell(0).getStringCellValue();
                String subject = row.getCell(1).getStringCellValue();
                double qualificationValue = row.getCell(2).getNumericCellValue();
                float qualification = (float) qualificationValue;

                qualifications.add(new Qualification(name, subject, qualification));
            }
        }
        workbook.close();
        return qualifications;
    }

    @Override
    public FileType getFileType() {
        return FileType.EXCEL;
    }

}
