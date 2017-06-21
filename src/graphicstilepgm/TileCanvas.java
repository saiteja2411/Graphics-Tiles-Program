/**
 * name of the Package is graphicstilepgm.
 */
package graphicstilepgm;

/**
 * importing necessary packages and classes.
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Name: TileCanvas
 * This is a default class 
 * it extends JPanal class and implements Mouse Listener interface
 * This class works with the center grid and accesses the 2 arrays in TileDesignerLayout as well
 */
class TileCanvas extends JPanel implements MouseListener
{
public int selectedTile = -1; //this is set in other class with button clicks
static final int squareSide = 25; // total number of cubes in the grid
static final int GridRow =5,GridCol=5;     //setting grid coloms and rows to count 5
int gridWidth, gridHeight, startX, startY;
int gridRows = 5, gridCols = 5;

//this gets the names of images out off array made above and builds an
//array of type image
Image[][] gif2dArray = new Image[gridRows][gridCols];// drawn on grid when we paint


 /**
  * Name: LoadImageArray
  * Parameters: none 
  * Return Type: void
  * purpose : it loads the tool kit in the frame with images from the image array
  */
public void LoadImageArray(){
    
    for(int i=0;i<TileDesignerLayout.imageA.length;i++)
    {
        TileDesignerLayout.imageA[i]=(Image) Toolkit.getDefaultToolkit().getImage(TileDesignerLayout.imageStringNameA[i]);
    }//for
}//LoadImageArray	


/**
  * Name: ResetGridTile
  * Parameters: none 
  * Return Type: void
  * purpose: resets the grid
  */
public void ResetGridTile(){
    for(int row = 0; row < GridRow; row++)
    {
     for(int col = 0; col < GridCol; col++)
     {
        gif2dArray[row][col]=null;
     }//col for
    }
    this.repaint();  //draw empty grid
}  //use in/out loop 
  

/**
  * Name: CreateMouseListener
  * Parameters: none 
  * Return Type: void
  * purpose: Add mouse listener to Center panel
  */
public void CreateMouseListener(){ 
    addMouseListener(this);
}//CreateMouseListener

//user has clicked a tile on panel, now has clicked in the 5 x 5 grid

/**
  * Name: mouseClicked
  * Parameters: MouseEvent e 
  * Return Type: void
  * purpose: this is called when the mouse is clicked at any position
  */
public void mouseClicked(MouseEvent e) {
 //here we get  a position of the click of mouse –x,y
 int x = e.getX();
 int y = e.getY();
 //if it was a valid click in grid
 if(x >= startX && x <= startX+gridWidth && y >= startY && y <= startY+gridWidth)
 {
   int xIndex = (x-startX)/squareSide; //will be an integer of square clicked
   int yIndex = (y-startY)/squareSide; //wil be an integer of square clicked
   gif2dArray[xIndex][yIndex] = TileDesignerLayout.imageA[selectedTile];
   this.repaint();  //show new grid
 }//if
}//mouse clicked

/**
  * these are other events in Mouse Listener which are not implemented in this program 
  */
@Override
 public void mouseEntered(MouseEvent e) { }
 @Override
 public void mouseExited(MouseEvent e) { }
 @Override
 public void mousePressed(MouseEvent e) { }      
 @Override
 public void mouseReleased(MouseEvent e) { }


 /**
  * Name: paintComponent
  * Parameters: Graphics g
  * Return Type: void
  * purpose: This function draws a 5 X 5 grid with lines
  *          its uses graphic object to do this.
  */
public void paintComponent(Graphics g)	//Implementing paint component
{ 
  super.paintComponent(g);
  gridWidth = GridCol*squareSide;
  gridHeight = GridRow*squareSide;
  int panelWidth = getWidth();
  int panelHeight = getHeight();
  startX = (panelWidth-gridWidth)/2;//get starting point to draw grid based 
  startY = (panelHeight-gridHeight)/2;

 //Drawing empty grid of 5*5 with an inner outer loop
 for(int row = 0; row < GridRow; row++){
     for(int col = 0; col < GridCol; col++){
        g.drawRect(startX+(squareSide*row), startY+(squareSide*col), squareSide, squareSide);
     }//col for
 }//row for

//copy gif image array over to the drawing grid with inner outer loop
for(int row = 0; row < 5; row++){
    for(int col = 0; col < 5; col++){  
        g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
    }//col for
}//row for
  //g.drawImage(gif2dArray[GridRow][GridCol], startX+(squareSide*GridRow), startY+(squareSide*GridCol), this);
}//paintComponent
}//tileCanvas

