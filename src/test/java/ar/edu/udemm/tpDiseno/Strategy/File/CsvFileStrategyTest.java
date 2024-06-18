package ar.edu.udemm.tpDiseno.Strategy.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.udemm.tpDiseno.Entity.Qualification;

public class CsvFileStrategyTest {

    private CsvFileStrategy csvFileStrategy;

    @BeforeEach
    public void setUp() {
        csvFileStrategy = new CsvFileStrategy();
    }

    @Test
    void testParse() throws Exception {
        String csvContent = "name,subject,qualification\n" +
                "John Doe,Math,95\n" +
                "Jane Smith,Science,89";
        InputStream inputStream = new ByteArrayInputStream(csvContent.getBytes(StandardCharsets.UTF_8));

        List<Qualification> qualifications = csvFileStrategy.parse(inputStream);

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
