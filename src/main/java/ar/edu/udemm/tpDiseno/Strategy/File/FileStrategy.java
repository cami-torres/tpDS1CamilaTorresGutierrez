package ar.edu.udemm.tpDiseno.Strategy.File;

import java.io.InputStream;
import java.util.List;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.Qualification;

public interface FileStrategy {
    public List<Qualification> parse(InputStream inputStream) throws Exception;

    public FileType getFileType();
}
