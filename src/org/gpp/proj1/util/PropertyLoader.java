package org.gpp.proj1.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Paolo Victor, paolovictor@gmail.com
 */
public class PropertyLoader {

	/**
	 * Loads a Properties from a file
	 * @param filename The file path
	 * @return The Properties object
	 */
	public static Properties loadProperties( String filename ) {
		assert filename != null  : "File name cannot be null";
		assert new File( filename ).exists()  : "Property file does not exist";
		
		Properties partProperties = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream( new FileInputStream( filename ) );
			partProperties.load( in );
		} catch (IOException e) {
		
			return null;
		} finally {
			if( in != null ) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		
		return partProperties;
	}
}
