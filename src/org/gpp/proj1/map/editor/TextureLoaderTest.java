/**
 * 
 */
package org.gpp.proj1.map.editor;

import java.io.File;
import java.util.Map;

import junit.framework.TestCase;

/**
 * @author gustavodfc
 *
 */
public class TextureLoaderTest extends TestCase {

	/**
	 * Test method for {@link org.gpp.proj1.map.editor.TextureLoader#listTextureFiles(java.lang.String)}.
	 */
	public void testListTextureFiles() {
		
		try {
			File[] textures;
			
			textures = TextureLoader.listTextureFiles("test/config/textures1.lst");
			assertEquals(6, textures.length);
			assertEquals("texture1", textures[0].getName());
			assertEquals("texture2", textures[1].getName());
			assertEquals("texture3", textures[2].getName());
			assertEquals("texture4", textures[3].getName());
			assertEquals("texture5", textures[4].getName());
			assertEquals("texture6", textures[5].getName());
			
			textures = TextureLoader.listTextureFiles("test/config/textures2.lst");
			assertEquals(0, textures.length);
			
			textures = TextureLoader.listTextureFiles("test/config/textures3.lst");
			assertEquals(0, textures.length);
		}
		catch (Exception e) {
			fail("Exception thrown: " + e);
		}
	}

	/**
	 * Test method for {@link org.gpp.proj1.map.editor.TextureLoader#listDecorationFiles(java.lang.String)}.
	 */
	public void testListDecorationFiles() {
		try {
			Map<File, String> decorations;
			
			decorations = TextureLoader.listDecorationFiles("test/config/decorations1.lst");
			assertEquals(3, decorations.size());

			assertEquals("model1", decorations.get(new File("image1")));
			assertEquals("model2", decorations.get(new File("image2")));
			assertEquals("model3", decorations.get(new File("image3")));
			
			decorations = TextureLoader.listDecorationFiles("test/config/decorations2.lst");
			assertEquals(0, decorations.size());
			
			decorations = TextureLoader.listDecorationFiles("test/config/decorations3.lst");
			assertEquals(0, decorations.size());
		}
		catch (Exception e) {
			fail("Exception thrown: " + e);
		}
	}
}