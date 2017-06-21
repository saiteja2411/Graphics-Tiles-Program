/***************************

CSCI 680/470 - Assignment 4 - Semester - Fall 2016
Programmer: Nitin Vinod Guda 
            SaiTeja Sandela
Section   : 1
Date Due  : 11/08/2016
Purpose   : This program allows the user to do tile design. and a small practice on image, painting
            and some advanced swing component.

**************************/

/**
 * name of the Package is graphicstilepgm.
 */
package graphicstilepgm;

/**
 * importing necessary packages and classes.
 */
import java.awt.*;
import javax.swing.*;

/*
 * This class is Public and the main class in this program. 
 * It extends a java frame so that it can use functionalities of JFrame.
 * Name : GraphicsTilePGM 
 */
public class GraphicsTilePGM extends JFrame{
    
    /**
    * Name: main
    * Parameters: String 
    * Return Type: void
    * purpose: execution starts from here. it just calls createAndShowGUI function.
    */
  public static void main(String args[]){
     createAndShowGUI();     
  }//main
    
    /**
    * Name: createAndShowGUI
    * Parameters: none 
    * Return Type: void
    * purpose: creates an object for the current class and sets up basic frame features.
    */
  public static void createAndShowGUI() {
    GraphicsTilePGM frame = new GraphicsTilePGM();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on pressing  X of frame
    frame.setSize(1200, 800);  // setting the size of frame
    frame.setVisible(true);    // setting visibility to true.
  }//createAndShow
  
  /**
    * Name: GraphicsTilePGM 
    * Parameters: none 
    * Return Type: void
    * purpose: its a default constructor.create the object for TileDesignerLayout.
    */
  public GraphicsTilePGM() {
        super();           //calling Jframe constructor
        setSize(800, 600);
        TileDesignerLayout tiledesign = new TileDesignerLayout();
        setLayout(new BorderLayout());       //sets upa border layout.
        add(tiledesign,BorderLayout.CENTER); // adds the tile design layout to the center of the frame.
 

    }//GraphicsTilesPgmConstructor

}//GraphicsTilePGM


   
