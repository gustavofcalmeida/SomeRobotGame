package org.gpp.proj1.util;

import java.util.Properties;

import junit.framework.TestCase;

/**
 * @author Paolo Victor, paolovictor@gmail.com
 */
public class PropertyLoaderTest extends TestCase {

	/*
	 * Test method for 'org.gpp.proj1.util.PropertyLoader.loadProperties(String)'
	 */
	public void testLoadProperties() {
		try {
			PropertyLoader.loadProperties( null );
		} catch (AssertionError e) {
			// Expected error
		}
		
		try {
			PropertyLoader.loadProperties( "IDONOTEXIST" );
		} catch (AssertionError e) {
			// Expected error
		}
		
		Properties props = PropertyLoader.loadProperties( "test/properties/test.properties" );
		
		assertNotNull( props );
		
		assertEquals( "p1", props.get( "a" ) );
		assertEquals( "p2", props.get( "b" ) );
		assertEquals( "p3", props.get( "c" ) );
		
		assertNull( props.get( "d" ) );
	}

}
