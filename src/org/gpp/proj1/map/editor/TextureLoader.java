package org.gpp.proj1.map.editor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Loads and caches texture states
 *
 * @author Paolo Victor, paolovictor@gmail.com
 */
public class TextureLoader {
    
    public static File[] listTextureFiles(String textureListFile) {
        InputStream in = null;
        List<File> list = new ArrayList<File>();
        
        try {
            in = new BufferedInputStream( new FileInputStream( textureListFile ) );
            Scanner scanner = new Scanner( in );
            
            int id = 0;
            while( scanner.hasNext() ) {
                String line = scanner.nextLine().trim();
                
                // Ignoring blank and comment lines
                if( line.equals( "" ) || line.startsWith("#") || line.startsWith("//") ) {
                    continue;
                }
                
                StringTokenizer tk = new StringTokenizer( line );
                String textureFile = tk.nextToken();
                list.add(new File(textureFile));
                
                id++;
            }            
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
            if( in != null ) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        
        return list.toArray(new File[0]);
    }
    
    public static Map<File, String> listDecorationFiles(String decorationsListFile) {
        InputStream in = null;
        Map<File, String> map = new HashMap<File, String>();
        
        try {
            in = new BufferedInputStream( new FileInputStream( decorationsListFile ) );
            Scanner scanner = new Scanner( in );
            
            while( scanner.hasNext() ) {
                String line = scanner.nextLine().trim();
                
                // Ignoring blank and comment lines
                if( line.equals( "" ) || line.startsWith("#") || line.startsWith("//") ) {
                    continue;
                }
                
                StringTokenizer tk = new StringTokenizer( line );
                String modelFile = tk.nextToken();
                String imageFile = tk.nextToken();
                map.put(new File(imageFile), modelFile);
            }            
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
            if( in != null ) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        return map;
    }
}