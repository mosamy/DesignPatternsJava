package lab1;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;


@SuppressWarnings("unused")
public class ScribbleTool implements Tool
{

	protected ScribbleCanvas canvas; 
	protected Lab1 drawframe;
	Point p ;
	 public ScribbleTool(ScribbleCanvas canvas, Lab1 drawframe) {
		    this.canvas = canvas;
		    this.drawframe=drawframe;
		  }
	 
	@Override
	public void mousePressed(MouseEvent e) {
		p = e.getPoint(); 
		canvas.mouseButtonDown = true;
        canvas.x = p.x; 
        canvas.y = p.y;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point p = e.getPoint(); 
		canvas.mouseButtonDown = false;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint(); 
		if (canvas.mouseButtonDown) {
            canvas.getOffScreenGraphics().drawLine(canvas.x, canvas.y, p.x, p.y); 
            int xs = Math.min(canvas.x, p.x); 
            int ys = Math.min(canvas.y, p.y); 
            int dx = Math.abs(p.x-canvas.x) +1;
            int dy = Math.abs(p.y-canvas.y) +1; 
            canvas.repaint(xs, ys, dx, dy); 
            canvas.x = p.x; 
            canvas.y = p.y; 
            }       
		
	}

}
