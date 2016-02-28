/*
 * DecorationDetails.java
 *
 * Created on 15 de Maio de 2007, 23:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.gpp.proj1.map.editor;

/**
 *
 * @author Gustavo
 */
public class DecorationDetails {
    
    private DecorationImage image;
    private byte texture;
    private float scale;
    private float[] rotation;
    
    /** Creates a new instance of DecorationDetails */
    public DecorationDetails(DecorationImage image, byte texture, float scale, float[] rotation) {
        
        this.image = image;
        this.texture = texture;
        this.scale = scale;
        this.rotation = rotation;
    }

    public float[] getRotation() {
        return rotation;
    }

    public float getScale() {
        return scale;
    }

    public byte getTexture() {
        return texture;
    }

    public DecorationImage getImage() {
        return image;
    }

    public void setImage(DecorationImage image) {
        this.image = image;
    }
    
    public void setRotation(float[] rotation) {
        this.rotation = rotation;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setTexture(byte texture) {
        this.texture = texture;
    }
}