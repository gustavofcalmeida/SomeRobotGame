package org.gpp.proj1.map.parser;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.gpp.proj1.map.MalformedMapFileException;

/**
 * 
 * @author Gustavo de Farias
 */
public class MapFileParserTest extends TestCase {

	/**
	 * @param arg0
	 */
	public MapFileParserTest(String arg0) {
		super(arg0);
	}

	/**
	 * 
	 */
	public void testParseFile() {
		
		try {
			MapFileParser.parseFile("do_not_exist.map");
			fail();
		} catch(FileNotFoundException fnfe) {
			// ok
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MalformedMapFileException e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/map1.map");
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MalformedMapFileException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/map2.map");
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MalformedMapFileException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/map3.map");
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MalformedMapFileException e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/map4.map");
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MalformedMapFileException e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/invalidMap1.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/invalidMap2.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/invalidMap3.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/invalidMap4.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		try {
			MapFileParser.parseFile("./test/map/invalidMap5.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap6.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap7.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap8.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap9.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap10.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap11.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			MapFileParser.parseFile("./test/map/invalidMap12.map");
			fail();
		} catch (MalformedMapFileException e) {
			// ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}