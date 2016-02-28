/*
 * Block.java
 *
 * Created on 4 de Abril de 2007, 19:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.gpp.proj1.map.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class Block extends JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 7962660739284059680L;
    
    // obligatory
    private int blockHeight;
    private IndexedImage topTexture;
    private IndexedImage sideTexture;
    private byte modifier;
    
    // optional
    private DecorationDetails decorationDetails;
    
    public Block(int blockHeight, IndexedImage topTexture, IndexedImage sideTexture, byte modifier) {
        super();
        
        this.setBlockHeight(blockHeight);
        this.topTexture = topTexture;
        this.sideTexture = sideTexture;  
        this.modifier = modifier;

        int side = EditorProperties.getInstance().block_side;
        this.setSize(side, side);
        this.setPreferredSize(new Dimension(side, side));
        this.setFocusable(false);
        this.setRequestFocusEnabled(false);
        this.setEnabled(false);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int side = EditorProperties.getInstance().block_side;
        int quarterSide = EditorProperties.getInstance().quarter_block_side;
        int originX = 0;
        int originY = 0;
        
        g.setFont(new Font("Serif", Font.PLAIN, EditorProperties.getInstance().font_size));
        
        // clear
        g.setColor(Color.WHITE);
        g.fillRect(originX, originY, this.getWidth(), this.getHeight());
               
        // border
        g.setColor(Color.BLACK);
        g.drawRect(originX, originY, side - 1, side - 1);
        
        // top texture
        g.drawImage(this.getTopTexture().getImage(), originX + 1, originY + 1, side - 2, side - 2, this);
        
        // decoration
        if (this.isDecorated()) {
            
            AffineTransform at = new AffineTransform();
            at.rotate(this.getRotationRadians( this.decorationDetails.getRotation()[1] ), side / 2, side / 2);

            BufferedImage rotated = new BufferedImage(side, side, BufferedImage.TYPE_INT_ARGB);
            rotated.createGraphics().drawImage(this.decorationDetails.getImage().getImage(), at, this);

            g.drawImage(rotated, originX + 1, originY + 1, side - 1, side - 1, this);
        }
                
        // height
        g.setColor(Color.YELLOW);
        g.fillRect(originX + 1, originY - 1 + 3 * quarterSide, quarterSide, quarterSide);
        g.setColor(Color.RED);
        g.drawString("" + this.getBlockHeight(), originX + 1 + EditorProperties.getInstance().font_horizontal_offset, originY - 1 + 3 * quarterSide + EditorProperties.getInstance().font_vertical_offset);
        
        // side texture
        g.drawImage(this.getSideTexture().getImage(), originX -1 + 3 * quarterSide, originY - 1 + 3 * quarterSide, quarterSide, quarterSide, this);

        // accessibility (modifier)
        if (this.modifier == EditorProperties.getInstance().inaccessible_block_index) {
            g.setColor(Color.RED);
            g.drawLine(originX + 1, originY + 1, this.getWidth() - 2, this.getHeight() - 2);
            g.drawLine(originX + 1, this.getWidth() - 2, this.getWidth() - 2, originY + 1);
        }
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int height) {
        
        if (height < 0) {
            height = 0;
        }
        
        if (height > EditorProperties.getInstance().max_block_height) {
            height = EditorProperties.getInstance().max_block_height;
        }
        
        this.blockHeight = height;
    }

    public IndexedImage getTopTexture() {
        return topTexture;
    }

    public IndexedImage getSideTexture() {
        return sideTexture;
    }

    public void setSideTexture(IndexedImage sideTexture) {
        this.sideTexture = sideTexture;
    }

    public void setTopTexture(IndexedImage topTexture) {
        this.topTexture = topTexture;
    }
    
    public boolean isDecorated() {
        return this.decorationDetails != null;
    }

    public byte getModifier() {
        return modifier;
    }

    public void setModifier(byte modifier) {
        this.modifier = modifier;
    }

    public DecorationDetails getDecorationDetails() {
        return decorationDetails;
    }

    public void setDecorationDetails(DecorationDetails decorationDetails) {
        this.decorationDetails = decorationDetails;
    }

    private double getRotationRadians(float f) {
        return f * Math.PI;
    }
}