package de.martin_ueding.mathematik.matheuhr;

import javax.swing.JFrame;

import java.util.Timer;
import java.util.TimerTask;

public class Matheuhr extends TimerTask {
	private static JFrame frame;
	
	public static void main (String[] args) {
		frame = new JFrame();
		frame.add(new MUPanel());
		frame.setSize(400, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (args.length >= 2) {
			frame.setLocation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			if (args.length == 3 && args[2].equals("-u"))
				frame.setUndecorated(true);
		}
		
		
		frame.setVisible(true);
		
		Timer timer = new Timer();
		timer.schedule(new Matheuhr(), 0, 250);
	}
	
	public void run () {
		frame.repaint();
	}
}