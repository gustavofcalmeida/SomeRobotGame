package org.gpp.proj1.map;

public class GameMap {

	public static final byte UNREACHABLE = -1;
	
	private int mapWidth;
	private int mapLength;
	private byte[][] heights;
	private byte[][] modifiers;
	private byte[][] topTextures;
	private byte[][] sideTextures;
	private String[][] decorationModels;
	private byte[][] decorationTextures;
	private float[][] decorationScales;
	private float[][][] decorationRotations;

	public GameMap(int mapWidth, int mapLength, byte[][] heights, byte[][] modifiers, byte[][] topTextures, byte[][] sideTextures, String[][] decorationModels, byte[][] decorationTextures, float[][] decorationScales, float[][][] decorationRotations) {
		this.mapWidth = mapWidth;
		this.mapLength = mapLength;
		this.heights = heights;
		this.modifiers = modifiers;
		this.topTextures = topTextures;
		this.sideTextures = sideTextures;
		this.decorationModels = decorationModels;
		this.decorationTextures = decorationTextures;
		this.decorationScales = decorationScales;
		this.decorationRotations = decorationRotations;
	}

	/**
	 * @return the decorationModels
	 */
	public String[][] getDecorationModels() {
		return decorationModels;
	}

	/**
	 * @return the decorationTextures
	 */
	public byte[][] getDecorationTextures() {
		return decorationTextures;
	}
	
	/**
	 * @return the decorationScales
	 */
	public float[][] getDecorationScales() {
		return decorationScales;
	}
	
	/**
	 * @return the decorationScales
	 */
	public float[][][] getDecorationRotations() {
		return decorationRotations;
	}

	/**
	 * @return the heights
	 */
	public byte[][] getHeights() {
		return heights;
	}

	/**
	 * @return the mapLenght
	 */
	public int getMapLength() {
		return mapLength;
	}

	/**
	 * @return the mapWidth
	 */
	public int getMapWidth() {
		return mapWidth;
	}

	/**
	 * @return the modifiers
	 */
	public byte[][] getModifiers() {
		return modifiers;
	}

	/**
	 * @return the sideTextures
	 */
	public byte[][] getSideTextures() {
		return sideTextures;
	}

	/**
	 * @return the topTextures
	 */
	public byte[][] getTopTextures() {
		return topTextures;
	}	
}