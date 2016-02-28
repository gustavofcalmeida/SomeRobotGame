/*
 * BlockPanel.java
 *
 * Created on 4 de Abril de 2007, 19:12
 */

package org.gpp.proj1.map.editor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import org.gpp.proj1.map.GameMap;

/**
 *
 * @author  Gustavo
 */
public class BlockPanel extends javax.swing.JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 3405858353434118775L;

    private Block[][] blocks;
    private int lastLine;
    private int lastColumn;
    private BlockConfigurationHandler handler;

    /** Creates new form BlockPanel */
    public BlockPanel(int width, int length, int height, IndexedImage topTexture, IndexedImage sideTexture, byte modifier, BlockConfigurationHandler handler) {
        initComponents();
        
        this.handler = handler;
        this.lastLine = -1;
        this.lastColumn = -1;
        
        this.setLayout(new GridLayout(width, length));        

        this.blocks = new Block[width][length];
        for (int l = 0; l < this.blocks.length; l++) {
            for (int c = 0; c < this.blocks[l].length; c++) {
                this.blocks[l][c] = new Block(height, topTexture, sideTexture, modifier);
                this.add(this.blocks[l][c]);
            }
        }
        
        int side = EditorProperties.getInstance().block_side;
        this.setSize(length * side, width * side);
        this.setPreferredSize(new Dimension(length * side, width * side));
    }
    
    public BlockPanel(GameMap gameMap, IndexedImage[][] textures, DecorationImage[] decorations, BlockConfigurationHandler handler) {
        initComponents();
        
        HashMap<String, DecorationImage> decorationsMap = createMap(decorations);
        
        this.handler = handler;
        this.lastLine = -1;
        this.lastColumn = -1;
        
        int width = gameMap.getMapWidth();
        int length = gameMap.getMapLength();
        this.setLayout(new GridLayout(width, length));

        this.blocks = new Block[width][length];
        for (int l = 0; l < this.blocks.length; l++) {
            for (int c = 0; c < this.blocks[l].length; c++) {
                this.blocks[l][c] = new Block( gameMap.getHeights()[l][c],
                                               textures[gameMap.getTopTextures()[l][c]][0],
                                               textures[gameMap.getSideTextures()[l][c]][1],
                                               gameMap.getModifiers()[l][c] );
                if (gameMap.getDecorationModels()[l][c] != null) {
                    
                    DecorationDetails details = new DecorationDetails(decorationsMap.get(gameMap.getDecorationModels()[l][c]),
                                                                      gameMap.getDecorationTextures()[l][c],
                                                                      gameMap.getDecorationScales()[l][c],
                                                                      gameMap.getDecorationRotations()[l][c]);
                    
                    this.blocks[l][c].setDecorationDetails(details);
                }
                
                this.add(this.blocks[l][c]);
            }
        }
        
        int side = EditorProperties.getInstance().block_side;
        this.setSize(length * side, width * side);
        this.setPreferredSize(new Dimension(length * side, width * side));
    }
    
    public Block[][] getBlocks() {
        return blocks;
    }
    
    public int getMapWidth() {
        return this.blocks.length;
    }
    
    public int getMapLenght() {
        return this.blocks[0].length;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setRequestFocusEnabled(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
        if (evt.getX() < 0 || evt.getY() < 0 || evt.getX() >= this.getWidth() || evt.getY() >= this.getHeight()) {
            return;
        }
        
        int c = evt.getX() / EditorProperties.getInstance().block_side;
        int l = evt.getY() / EditorProperties.getInstance().block_side;
        
        if (l == this.lastLine && c == this.lastColumn) {
            return;
        }
        
        if (l < this.blocks.length && c < this.blocks[l].length) {
            
            this.handler.setConfiguration(this.blocks[l][c]);
            this.blocks[l][c].repaint();
        }
        
        this.lastLine = l;
        this.lastColumn = c;
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        int c = evt.getX() / EditorProperties.getInstance().block_side;
        int l = evt.getY() / EditorProperties.getInstance().block_side;
        
        if (l < this.blocks.length && c < this.blocks[l].length) {
            
            this.handler.setConfiguration(this.blocks[l][c]);
            this.blocks[l][c].repaint();
        }
    }//GEN-LAST:event_formMousePressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private HashMap<String, DecorationImage> createMap(DecorationImage[] decorations) {
        HashMap<String, DecorationImage> map = new HashMap<String, DecorationImage>(decorations.length);
        
        for (DecorationImage di : decorations) {
            map.put(di.getModel(), di);
        }
        
        return map;
    }

    public void processClick(int x, int y) {
        this.formMousePressed(new MouseEvent(this, 0, System.currentTimeMillis(), MouseEvent.BUTTON1_MASK, x, y, 0, false));
    }
}