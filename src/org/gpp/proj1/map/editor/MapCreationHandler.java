/*
 * MapCreationHandler.java
 *
 * Created on 5 de Abril de 2007, 11:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.gpp.proj1.map.editor;

/**
 *
 * @author Gustavo
 */
public interface MapCreationHandler {
    
    public void createMap(int width, int length, int height, int topTextureIndex, int sideTextureIndex, byte modifier);
    
}
