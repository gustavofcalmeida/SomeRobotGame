/*
 * IndexedImage.java
 *
 * Created on 12 de Abril de 2007, 17:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.gpp.proj1.map.editor;

import java.awt.Image;

/**
 *
 * @author Gustavo
 */
public class IndexedImage {
    
    private final Image image;
    private final byte index;

    public IndexedImage(Image image, byte index) {
        this.image = image;
        this.index = index;
    }

    public Image getImage() {
        return image;
    }

    public byte getIndex() {
        return index;
    }
}