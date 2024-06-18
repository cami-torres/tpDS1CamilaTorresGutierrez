package ar.edu.udemm.tpDiseno.Strategy.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ar.edu.udemm.tpDiseno.Entity.Qualification;

public class PdfFileStrategyTest {
    private PdfFileStrategy pdfFileStrategy;

    @BeforeEach
    public void setUp() {
        pdfFileStrategy = new PdfFileStrategy();
    }

    @Test
    public void testParse() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, bos);
        document.open();

        document.add(new Paragraph("name,subject,qualification\n"));
        document.add(new Paragraph("John Doe,Math,95\n"));
        document.add(new Paragraph("Jane Smith,Science,89\n"));

        document.close();

        InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        List<Qualification> qualifications = pdfFileStrategy.parse(inputStream);

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
