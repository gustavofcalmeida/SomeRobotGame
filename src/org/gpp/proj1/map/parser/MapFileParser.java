/*
 * 
 */
package org.gpp.proj1.map.parser;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.gpp.proj1.map.GameMap;
import org.gpp.proj1.map.MalformedMapFileException;

/**
 * 
 * @author Gustavo de Farias
 */
public class MapFileParser {

	private static final String IGNORE_COMMENTS_REGEX = "\\s*//.*\\s+|\\s*\\#.*\\s+|\\s+";
	
	public static GameMap parseFile( Scanner scanner ) throws IOException, MalformedMapFileException {
		// Ignore comments
		scanner.useDelimiter( IGNORE_COMMENTS_REGEX );
		
		// And use US locale for reading floats
		scanner.useLocale( Locale.US );
		
		// extract width and length
		int mapWidth;
		int mapLenght;
		try {
			mapWidth = scanner.nextInt();
			mapLenght = scanner.nextInt();
		} catch (RuntimeException e) {
			throw new MalformedMapFileException("Missing map size or wrong format.");
		}

		// extract map heights
		byte[][] heights = new byte[mapWidth][mapLenght];
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapLenght; j++) {
				try {
					heights[i][j] = scanner.nextByte();
				} catch (RuntimeException e) {
					throw new MalformedMapFileException("Missing map heights or wrong format.");
				}
			}
		}
		
		// extract move modifiers
		byte[][] modifiers = new byte[mapWidth][mapLenght];
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapLenght; j++) {
				try {
					modifiers[i][j] = scanner.nextByte();
				} catch (RuntimeException e) {
					throw new MalformedMapFileException("Missing move modifiers or wrong format.");
				}
			}
		}
		
		// extract top textures
		byte[][] topTextures = new byte[mapWidth][mapLenght];
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapLenght; j++) {
				try {
					topTextures[i][j] = scanner.nextByte();
				} catch (RuntimeException e) {
					throw new MalformedMapFileException("Missing texture types or wrong format.");
				}
			}
		}
		
		// extract side textures
		byte[][] sideTextures = new byte[mapWidth][mapLenght];
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapLenght; j++) {
				try {
					sideTextures[i][j] = scanner.nextByte();
				} catch (RuntimeException e) {
					throw new MalformedMapFileException("Missing side texture types or wrong format.");
				}
			}
		}
		
		// extract decorations number
		int decorations = -1;
		try {
			decorations = scanner.nextInt();
		} catch (RuntimeException e) {
			throw new MalformedMapFileException("Wrong format for decorations number.");
		}

		// extract decorations details
		String[][] decorationModels = new String[mapWidth][mapLenght];
		byte[][] decorationTextures = new byte[mapWidth][mapLenght];		
		float[][] decorationScales = new float[mapWidth][mapLenght];
		float[][][] decorationRotations = new float[mapWidth][mapLenght][3];

		for (int i = 0; i < decorations; i++) {

			int l = -1;
			int c = -1;;
			try {
				l = scanner.nextInt();
				c = scanner.nextInt();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing decoration coordinates or wrong format.");
			}
			
			try {
				decorationModels[l][c] = scanner.next();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing model or wrong formats.");
			}
			
			try {
				decorationTextures[l][c] = scanner.nextByte();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing texture or wrong formats.");
			}
			
			try {
				decorationScales[l][c] = scanner.nextFloat();
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new MalformedMapFileException("Missing scale or wrong formats.");
			}
			
			try {
				decorationRotations[l][c][0] = scanner.nextFloat();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing rotation X or wrong formats.");
			}
			
			try {
				decorationRotations[l][c][1] = scanner.nextFloat();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing rotation Y or wrong formats.");
			}
			
			try {
				decorationRotations[l][c][2] = scanner.nextFloat();
			} catch (RuntimeException e) {
				throw new MalformedMapFileException("Missing rotation Z or wrong formats.");
			}
		}
		
		if( scanner.hasNext() ) {
			throw new MalformedMapFileException("Too few attributes");
		}
		
		scanner.close();
		
		GameMap gameMap = new GameMap(mapWidth, mapLenght, heights, modifiers, topTextures, sideTextures, decorationModels, decorationTextures, decorationScales, decorationRotations );
		
		return gameMap;
	}

	public static GameMap parseFile( String file ) throws IOException, MalformedMapFileException {
	
		// stream
		File f = new File(file);
		Scanner scanner = new Scanner( f );

		return parseFile( scanner );
	}	
	
	public static GameMap parseFileFromString( String mapString ) throws IOException, MalformedMapFileException {
		
		Scanner scanner = new Scanner( mapString );
		
		return parseFile( scanner );
	}
}