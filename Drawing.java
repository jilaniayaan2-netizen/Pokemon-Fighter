// The Drawing class
// Created by Ayaan Jilani 
// Last Modified: 1/13/2025 
// Allows the user to create drawings 
import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image 

public class Drawing 
{
  private static Console userConsole; // Console to draw the image on
  private String pathway;             // Pathway for where the program can find the file 
  private int xCorodinate;            // X corodinate of the image to draw 
  private int yCorodinate;            // Y corodinate of the image to draw
  private Image image;                // Image to draw
  
  // Constructor - Creates a new drawing 
  // c - the console the user wants to draw the image on 
  // x - the x corodinate of the image 
  // y - the y corodinate of the image 
  // img - the image to draw 
  // path - the pathway of where the to find the image
  public Drawing(Console c, int x, int y, Image img, String path)
  {
    userConsole = c; 
    xCorodinate = x; 
    yCorodinate = y; 
    image = img; 
    pathway = path; 
  }
  
  // A method that draws an image based on the variables the user entered 
  public void drawImage()
  {
    //Try to import the images for the title screen from the files
    try
    {
      image = ImageIO.read(new File(pathway));
    }
    catch(IOException e)  //File not found
    {
      image = null; 
    } 
    
    // Draw the images (Image, x location, y location, null)
    userConsole.drawImage(image,xCorodinate,yCorodinate,null);
  }
}