/**
 * name of the Package is graphicstilepgm.
 */
package graphicstilepgm;

/**
 * importing necessary packages and classes.
 */
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Name: TileDesignerLayout
 * This is a default class 
 * it extends JPanal class and implements ActionListener interface
 * This class create a tile with 5 images using buttons at the top of the frame
 */
class TileDesignerLayout extends JPanel implements ActionListener
{
public static final String[] imageStringNameA ={"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif"};	//holds names of patches
public static Image[] imageA = new Image[5];	 //image array to hold 5 images that are loaded

//all buttons….
//buttons for the images are created.
JButton patch1btn,
        patch2btn,
        patch3btn,
        patch4btn,
        patch5btn,
        resetBtn;
JPanel bottomPanel = new JPanel();

 /**adding
  * Name: TileDesignerLayout
  * Parameters: none 
  * Return Type: none
  * purpose : Its a Default constructor of the class
  */
public TileDesignerLayout()
{
    setLayout(new BorderLayout());
    final TileCanvas centerTileCanvas1 = new TileCanvas(); //call class to make    center grid
    add(centerTileCanvas1, BorderLayout.CENTER); //Adding centerPanel to outerFrame.
    centerTileCanvas1.ResetGridTile(); //call methods in other class to set stuff up									
    centerTileCanvas1.CreateMouseListener();								
    //also add panel with reset button to SOUTH)
    JToolBar tileToolBar = new JToolBar();	//create a tool bar
    centerTileCanvas1.LoadImageArray();   
    
    //creating new buttons with image icons
    patch1btn = new JButton(new ImageIcon(imageA[0])); 
    patch2btn = new JButton(new ImageIcon(imageA[1])); 
    patch3btn = new JButton(new ImageIcon(imageA[2])); 
    patch4btn = new JButton(new ImageIcon(imageA[3])); 
    patch5btn = new JButton(new ImageIcon(imageA[4])); 
    resetBtn = new JButton("Reset");
    bottomPanel.add(resetBtn);
    
    //adding buttons to toolbar
    tileToolBar.add(patch1btn); 
    tileToolBar.add(patch2btn);
    tileToolBar.add(patch3btn);
    tileToolBar.add(patch4btn);
    tileToolBar.add(patch5btn);
    
    // adding tool bar to the north and panel to the south
    add(tileToolBar,BorderLayout.NORTH);
    add(bottomPanel,BorderLayout.SOUTH);
         
    //ALL BELOW ARE THE ANNONYMOUS METHODS.
    
    //ADDING THE ACTION LISTENER TO BUTTON. 
    //THIS CALLS RESETS THE GRID 
    resetBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent ae) {
             centerTileCanvas1.ResetGridTile();
         }
     });
    //ADDING THE ACTION LISTENER TO PATCH 1 BUTTON. 
    //THIS SETS THE SELECTED TILE TO 0
    patch1btn.addActionListener(new ActionListener() 							
    { 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
          centerTileCanvas1.selectedTile = 0;
        }
    });  
    
    //ADDING THE ACTION LISTENER TO PATCH 2 BUTTON. 
    //THIS SETS THE SELECTED TILE TO 1
    patch2btn.addActionListener(new ActionListener() 							
    { 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
          centerTileCanvas1.selectedTile = 1;
        //System.out.println("Clicked second tile");
        }
    });  
    
    //ADDING THE ACTION LISTENER TO PATCH 3 BUTTON. 
    //THIS SETS THE SELECTED TILE TO 2
    patch3btn.addActionListener(new ActionListener() 							
    { 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
          centerTileCanvas1.selectedTile = 2;}
    });  
    
    //ADDING THE ACTION LISTENER TO PATCH 4 BUTTON. 
    //THIS SETS THE SELECTED TILE TO 3
    patch4btn.addActionListener(new ActionListener() 							
    { 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
          centerTileCanvas1.selectedTile = 3;}
    });  
    
    //ADDING THE ACTION LISTENER TO PATCH 5 BUTTON. 
    //THIS SETS THE SELECTED TILE TO 4
    patch5btn.addActionListener(new ActionListener() 							
    { 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) 
        {
          centerTileCanvas1.selectedTile = 4;}
    });  
}  //END CONSTRUCTOR

//
@Override
public void actionPerformed(java.awt.event.ActionEvent e){}
}//TileLayoutDesigner Class
