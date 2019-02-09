package expertqa.december12_2018.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener{
	
	private static final int THICKNESS = 10;
	
	private List<Vertex> vertices;
	private ButtonGroup bg;

	public DrawingPanel(ButtonGroup bg) {
		addMouseListener(this);
		this.bg = bg;
		this.vertices = new ArrayList<>();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		for(Vertex v : vertices) {
			g2d.drawOval(v.getX(), v.getY(), THICKNESS, THICKNESS);
			g2d.fillOval(v.getX(), v.getY(), THICKNESS, THICKNESS);
		}
	}
	
	private boolean addVertexSelected() {
		return bg.getSelection() != null && bg.getSelection().getMnemonic() == 1 && bg.getSelection().isSelected();
	}
	
	private boolean addEdgeSelected() {
		return bg.getSelection() != null && bg.getSelection().getMnemonic() == 2 && bg.getSelection().isSelected();
	}
	
	private boolean removeVertexSelected() {
		return bg.getSelection() != null && bg.getSelection().getMnemonic() == 3 && bg.getSelection().isSelected();
	}
	
	private boolean removeEdgeSelected() {
		return bg.getSelection() != null && bg.getSelection().getMnemonic() == 4 && bg.getSelection().isSelected();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			System.out.println("Left click: x=" + e.getX() + ", y=" + e.getY());
			if(addVertexSelected()) {
				Vertex v = new Vertex(e.getX(), e.getY());
				vertices.add(v);
				super.repaint();
			} else if(addEdgeSelected()) {
				
			} else if(removeVertexSelected()) {
				Vertex v = new Vertex(e.getX(), e.getY());
				vertices.remove(v);
				repaint();
			} else if(removeEdgeSelected()) {
				
			}
		} else {
			System.out.println("Other click");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("Pressed: x=" + e.getX() + ", y=" + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Released: x=" + e.getX() + ", y=" + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Entered: x=" + e.getX() + ", y=" + e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("Exited: x=" + e.getX() + ", y=" + e.getY());
	}
	
}
