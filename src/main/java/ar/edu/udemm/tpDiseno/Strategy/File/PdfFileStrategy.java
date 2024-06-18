package ar.edu.udemm.tpDiseno.Strategy.File;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.Qualification;

@Service
public class PdfFileStrategy implements FileStrategy {

    @Override
    public List<Qualification> parse(InputStream inputStream) throws Exception {
        PdfReader reader = new PdfReader(inputStream);
        List<Qualification> qualifications = new ArrayList<>();

        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            String pageContent = PdfTextExtractor.getTextFromPage(reader, i);
            String[] lines = pageContent.split("\n");

            for (int j = 1; j < lines.length; j++) { // Skip header row
                String[] columns = lines[j].split(",");
                if (columns.length >= 3) {
                    String name = columns[0];
                    String subject = columns[1];
                    float qualification = Float.parseFloat(columns[2]);

                    qualifications.add(new Qualification(name, subject, qualification));
                }
            }
        }

        reader.close();
        return qualifications;
    }

    @Override
    public FileType getFileType() {
        return FileType.PDF;
    }

}
