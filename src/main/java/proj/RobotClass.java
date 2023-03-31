package proj;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
public class RobotClass {
	
	@SuppressWarnings("deprecation")
	public static void name(String[] args) throws AWTException, InterruptedException {
		
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	r.mousePress(InputEvent.BUTTON1_MASK);
	r.mouseRelease(InputEvent.BUTTON1_MASK);
	
	
}}
