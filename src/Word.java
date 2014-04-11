import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Word extends JButton implements MouseListener {
	String text;
	String definition;
	String note;
	boolean displayed;
	
	public Word(String ttext, String tdefinition, String tnote) {
		super();
		
		
		
		enableInputMethods(true);
		addMouseListener(this);
		setBorder(null);
		setBorderPainted(false);
		 text = ttext;
		definition = tdefinition;
		 note = tnote;
		 displayed = false;


	}

	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());

	}
	

	public Dimension getMaximumSize() {
		return getPreferredSize();

	}

	public Dimension getMinimumSize() {
		return getPreferredSize();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
