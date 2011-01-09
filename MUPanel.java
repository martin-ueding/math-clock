package de.martin_ueding.mathematik.matheuhr;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.util.Calendar;

@SuppressWarnings("serial")
public class MUPanel extends JPanel {
	private static int w, h;
	private double f;
	
	protected void paintComponent (Graphics p) {
		
		Graphics2D g = (Graphics2D)p;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		w = getWidth();
		h = getHeight();
		
		f = h/400.0;
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w, h);
		
		Point punkt, punkt2;
		
		for (int i = 0; i < 24; i++) {
			g.setColor(Color.BLUE);
			punkt = getPos(Math.PI*2/24*i, 155*f);
			g.drawString(String.valueOf(i), punkt.x-4, punkt.y+5);
			
			
			g.setColor(i%6==0 ? Color.RED : Color.BLUE);
			punkt = getPos(Math.PI*2/24*i, 140*f);
			punkt2 = getPos(Math.PI*2/24*i, 135*f);
			g.drawLine(punkt.x, punkt.y, punkt2.x, punkt2.y);
		}
		
		Calendar c = Calendar.getInstance();
		
		int st = c.get(Calendar.HOUR_OF_DAY);
		int mi = c.get(Calendar.MINUTE);
		int se = c.get(Calendar.SECOND);
		
		//System.out.println(st+":"+mi+":"+se);
				
		g.setColor(Color.GRAY);
		
		punkt = getPos(se*(Math.PI*2)/60, 120*f);
		g.drawLine(w/2, h/2, punkt.x, punkt.y);
		
		g.setColor(Color.WHITE);
		
		punkt = getPos(mi*(Math.PI*2)/60, 110*f);
		g.drawLine(w/2, h/2, punkt.x, punkt.y);
		
		g.setColor(Color.GREEN);
		
		punkt = getPos(st*(Math.PI*2)/24 + mi*(Math.PI*2)/1440, 95*f);
		g.drawLine(w/2, h/2, punkt.x, punkt.y);
		
		g.setColor(Color.BLACK);
		g.fillOval((int)(w/2-75*f), (int)(h/2-75*f), (int)(150*f), (int)(150*f));
	}
	
	private static Point getPos (double a, double l) {
		return new Point((int)(Math.cos(a)*l+w/2), h/2-(int)(Math.sin(a)*l));
	}
}