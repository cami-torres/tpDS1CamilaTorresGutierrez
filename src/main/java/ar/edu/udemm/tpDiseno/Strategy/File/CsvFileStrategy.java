package ar.edu.udemm.tpDiseno.Strategy.File;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.Qualification;

@Service
public class CsvFileStrategy implements FileStrategy {

    @Override
    public List<Qualification> parse(InputStream inputStream) throws Exception {
        // Parse CSV data
        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream)).build();
        List<String[]> rows = csvReader.readAll();

        // Ignores fist line that contains the header.
        List<Qualification> qualifications = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (row.length >= 3) {
                String name = row[0];
                String subject = row[1];
                Float qualification = Float.parseFloat(row[2]);
                qualifications.add(new Qualification(name, subject, qualification));
            }
        }

        return qualifications;

    }

    @Override
    public FileType getFileType() {
        return FileType.CSV;
    }

}
