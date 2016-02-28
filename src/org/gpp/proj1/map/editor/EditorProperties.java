package org.gpp.proj1.map.editor;

import java.util.Properties;

import org.gpp.proj1.util.PropertyLoader;

public class EditorProperties {

	private static EditorProperties instance;
	
	public final int block_side;
	public final int quarter_block_side;
	public final int list_image_side;
	
	public final String texture_list_file;
	public final String decoration_list_file;
        public final String default_save_directory;

	public final int max_block_height;
	public final int max_map_width;
	public final int max_map_length;
	
	public final int font_size;
	public final int font_vertical_offset;
	public final int font_horizontal_offset;
        
        public final byte inaccessible_block_index;
        public final byte default_accessibility_index;
	
	private EditorProperties() {
		
		Properties p = PropertyLoader.loadProperties("res/config/map_editor_properties.cfg");
		
		this.block_side = Integer.parseInt(p.getProperty("block_side"));
		this.quarter_block_side = this.block_side / 4;
		this.list_image_side = Integer.parseInt(p.getProperty("list_image_side"));

		this.texture_list_file = p.getProperty("texture_list_file");
		this.decoration_list_file = p.getProperty("decoration_list_file");
                this.default_save_directory = p.getProperty("default_save_directory");

		this.max_block_height = Integer.parseInt(p.getProperty("max_block_height"));
		this.max_map_width = Integer.parseInt(p.getProperty("max_map_width"));
		this.max_map_length = Integer.parseInt(p.getProperty("max_map_length"));

		this.font_size = Integer.parseInt(p.getProperty("font_size"));
		this.font_vertical_offset = Integer.parseInt(p.getProperty("font_vertical_offset"));
		this.font_horizontal_offset = Integer.parseInt(p.getProperty("font_horizontal_offset"));
                
                this.inaccessible_block_index = Byte.parseByte(p.getProperty("inaccessible_block_index"));
                this.default_accessibility_index = Byte.parseByte(p.getProperty("default_accessibility_index"));
	}
	
	public static EditorProperties getInstance() {
		if (instance == null) {
			instance = new EditorProperties();
		}
		
		return instance;
	}
}
