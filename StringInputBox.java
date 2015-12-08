import java.util.*;
import java.io.*;
import greenfoot.*;
import java.awt.Color;

public class StringInputBox extends Actor
{
    static final int MAX_INPUT_LENGTH = 20;
    String text = "Enter your name";

    public StringInputBox()
    {
        updateImage();
        text = "";
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(15*MAX_INPUT_LENGTH, 30);
        image.setColor(new Color(128, 0, 0));
        image.fill();
        image.setColor(Color.lightGray);
        image.fillRect(3, 3, image.getWidth()-6, 24);
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.black, null);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, 15-textImage.getHeight()/2);
        setImage(image);
    }

    public void act()
    {
        String key = Greenfoot.getKey();
        if (key == null) 
            return;
        if ("backspace".equals(key) && text.length() > 0) 
            text = text.substring(0, text.length() - 1);
        if ("space".equals(key)) 
            key = " ";
        if (key.length() == 1 && text.length() < MAX_INPUT_LENGTH) 
            text += key;
        updateImage();
        if ("enter".equals(key) && text.length() > 0)
        {
            try
            {
                BackDrop world = (BackDrop)getWorld();
                world.recordScore(text);
                world.removeObject(this);
                world.restart();
            }
            catch(IOException ioe)
            {

            }
        }
    }
}