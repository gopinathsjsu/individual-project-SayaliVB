package org.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileFormatFactoryTest {

    @Test
    void csvFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertEquals(CSVFileFormat.class, fileFormatFactory.selectFileFormat("input.csv", "output.csv").getClass());
    }

    @Test
    void csvNullFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertNull(fileFormatFactory.selectFileFormat("input.ccsv", "output.csv"));
        assertNull(fileFormatFactory.selectFileFormat("input.csv", "output.ccsv"));
        assertNull(fileFormatFactory.selectFileFormat("input.v", "output.csv"));
        assertNull(fileFormatFactory.selectFileFormat("input.csv", "output.s"));
    }

    @Test
    void jsonFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertEquals(JSONFileFormat.class, fileFormatFactory.selectFileFormat("input.json", "output.json").getClass());
    }

    @Test
    void jsonNullFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertNull(fileFormatFactory.selectFileFormat("input.json", "output.jjson"));
        assertNull(fileFormatFactory.selectFileFormat("input.jjson", "output.json"));
        assertNull(fileFormatFactory.selectFileFormat("input.v", "output.json"));
        assertNull(fileFormatFactory.selectFileFormat("input.json", "output.s"));
    }

    @Test
    void xmlFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertEquals(XMLFileFormat.class, fileFormatFactory.selectFileFormat("input.xml", "output.xml").getClass());
    }

    @Test
    void xmlNullFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertNull(fileFormatFactory.selectFileFormat("input.xml", "output.xxml"));
        assertNull(fileFormatFactory.selectFileFormat("input.xxml", "output.xml"));
        assertNull(fileFormatFactory.selectFileFormat("input.v", "output.xml"));
        assertNull(fileFormatFactory.selectFileFormat("input.xml", "output.s"));
        assertNull(fileFormatFactory.selectFileFormat("input.xml", "output.s"));
    }

    @Test
    void NullFileFormat() {
        FileFormatFactory fileFormatFactory  = new FileFormatFactory();
        assertNull(fileFormatFactory.selectFileFormat("input", "output.xml"));
        assertNull(fileFormatFactory.selectFileFormat("input.xml", "output"));
        assertNull(fileFormatFactory.selectFileFormat("input", "output"));
        assertNull(fileFormatFactory.selectFileFormat("input.", "output."));
        assertNull(fileFormatFactory.selectFileFormat("input.mp3", "output.png"));
    }

}