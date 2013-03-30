package cn.iaicc.smgk.web.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckCodeUtil {
	
	private static Log logger = LogFactory.getLog(CheckCodeUtil.class);
	
	//设置图形验证码中字符串的字体和大小
	private static Font font = new Font("Arial Black",Font.PLAIN,16);
	//生成随机颜色
	public static Color getRandColor(int fc,int bc){
	   Random random = new Random();
	   if(fc>255) fc=255;
	   if(bc>255) bc=255;
	   int r=fc+random.nextInt(bc-fc);
	   int g=fc+random.nextInt(bc-fc);
	   int b=fc+random.nextInt(bc-fc);
	   return new Color(r,g,b);
   }
	//生成随机字符的方法
	public static String getRandomChar(){
		int rand=(int)Math.round(Math.random()*2);
		long itmp= 0;
		char ctmp='\u0000';
		//根据rand的值来决定生成字符是大写字符、小写字符或数字
		switch (rand) {
			//大写字母
			case 1:
				 itmp=Math.round(Math.random()*25+65);
				 ctmp=(char)itmp;
			     return String.valueOf(ctmp);
			//小写字母
			case 2:
				itmp=Math.round(Math.random()*25+97);
				ctmp=(char)itmp;
				return String.valueOf(ctmp);
			//数字
			default:
				itmp=Math.round(Math.random()*9);
			    return String.valueOf(itmp);
		}
	}
	
	public static String getCodeImage(String title, int width,int height,int show, ByteArrayOutputStream output) {
         //生成一张新的图片
         BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB );
         //在图片中绘制内容
         Graphics g = image.getGraphics();
         Random random = new Random();
         g.setColor(getRandColor(200, 250));
         g.fillRect(1, 1, width-1, height-1);
         g.setColor(new Color(102,102,102));
         g.drawRect(0, 0, width-1, height-1);
         g.setFont(font);
         g.setColor(getRandColor(160, 200));
         //生成随机线条，使图片看起来更加杂乱
         for(int i=0;i<155;i++){
        	 
           int x=random.nextInt(width-1);
           int y=random.nextInt(height-1);
           int x1=random.nextInt(6)+1;
           int y1=random.nextInt(12)+1;
           g.drawLine(x, y, x+x1, y+y1);
         }
         for (int i = 0; i < 70; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			g.drawLine(x, y, x - x1, y - y1);
         }
         //sRand用于保存随机生成的字符串
         String sRand="";
         for (int i = 0; i < 6; i++) {
        	 //随机取得一个字符
			String tmp = getRandomChar();
			sRand += tmp;
			//将系统生成的随机字符添加到图形验证码中
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			g.drawString(tmp,15*i+10,15);
         }  
         try{
     		//输出图形验证码			
             ImageIO.write(image, "JPEG", output);	         	 
         }catch(Exception e) {
        	 logger.error("ImageIO write:"+e.getMessage());
         }

        return sRand;
	}
}
