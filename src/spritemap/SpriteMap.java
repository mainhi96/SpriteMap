/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemap;
import java.io.File;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import java.io.IOException;


/**
 *
 * @author SONY
 */
public class SpriteMap {
        public static void join(String inputPath, String outputPath) throws IOException{
        File dicrectory = new File(inputPath); //mo thu muc
        File[] files = dicrectory.listFiles();//lay cac tap tin trong file vao mang
        int height;
        int width;
        int size=(int) Math.sqrt(files.length);
        BufferedImage sprite=ImageIO.read(files[0]);//doc file dau tien de biet kich thuoc cua 1 file
        width= sprite.getWidth()*size;//chieu dai cua file srpritemap dau ra
        height= sprite.getHeight()*size;                
        BufferedImage spritemap = new BufferedImage (width, height,BufferedImage.TYPE_INT_ARGB);// tao sprite map dau ra
        Graphics2D g2d= spritemap.createGraphics();//tap graphic ve ra spritemap
        int x=0;
	int y=0;
        int count=0;
        
        for(File file:files){
            sprite= ImageIO.read(file);//doc file
            g2d.drawImage(sprite,null,x,y);//ve len 
            count++;
            if (count<size){ 
            x+= sprite.getWidth();//cach ra chieu rong cua 1 sprite de ve ke ben
        }
            else{
                count=0;
                x=0;
                y+=sprite.getHeight();
            }
        }
        ImageIO.write(spritemap,"png",new File(outputPath));//ghi ra o cung
        
    }
    
    public static void main(String[] args) {
        
        try{
            SpriteMap.join("D:\\Pokemon", "D:\\Temp");
        }catch(IOException ex){
            System.err.println(ex.getMessage());
    
    }
    
}
}
