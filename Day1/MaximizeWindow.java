package week2.day1;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MaximizeWindow {

	public static void main(String[] args) {
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height = screenSize.getHeight();
		double width = screenSize.getWidth();
		System.out.println(height +","+ width);

	}

}
