/*
Represents a checker piece and cell combined, contains the color and position as well as if a piece has been selected or not
 */
package my.contacteditor;

/**
 *
 * @author KN
 */

public class CheckerPiece {
    
    private char color;// b, w, B, W (Uppercase for Kings), - (can move here), . (cannot move here)
    private int position;
    private boolean selected = false;// is a piece selected or not, by default no
    
    public CheckerPiece(char color, int position){
        
        this.color = color;
        this.position = position;
    }
    
    public void setColor(char color)
    {
        this.color = color;
    }
    
    public void setPosition(int position)
    {
        this.position = position;
    }
    
    public void setSelect(boolean selected)
    {
        this.selected = selected;
    }
   
    public char getColor(){
        return color;
    }
    
    public int getPosition(){
        return position;
    }
    
    public boolean getSelect()
    {
        return selected;   
    }
    
  
    
}
