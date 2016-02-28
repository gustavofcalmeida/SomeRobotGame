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
public class DecorationImage {
    
    private final Image image;
    private final String model;

    public DecorationImage(Image image, String model) {
        this.image = image;
        this.model = model;
    }

    public Image getImage() {
        return image;
    }

    public String getModel() {
        return model;
    }
}