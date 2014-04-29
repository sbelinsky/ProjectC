import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class Word extends JButton implements MouseListener {
	String text;
	String definition;
	String note;
	boolean displayed;
	File wordListFile;
	JRootPane frame;

	public Word(String ttext) {
		super();
		frame = getRootPane();

		enableInputMethods(true);
		addMouseListener(this);
		setBorder(null);
		setBorderPainted(false);
		text = ttext;
		definition = "";
		note = "";
		displayed = false;
		wordListFile = new File("CWordList.csv");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		String strippedString = "";

		ArrayList<String> dictionaryList = openWordFile(wordListFile);
		System.out.println(text);
		// 0, 3 , 6
		// + 1 = definiton
		// + 2 = note
		displayed = true;
		 strippedString = strippedString.replace(',', ' ');
		 System.out.println(strippedString);

		 strippedString = text.trim();
		for (int i = 0; i < dictionaryList.size(); i++) {
			if ((dictionaryList.get(i).equalsIgnoreCase(text) || dictionaryList.get(i)
					.equals(text.substring(0, text.length()-1)))) {
				definition = dictionaryList.get(i + 1);

				note = dictionaryList.get(i + 2);
				break;
			//	System.out.println(text.substring(0, text.length()-1));
			}

		}
		JOptionPane.showMessageDialog(getRootPane(), definition, "Definition",
				JOptionPane.PLAIN_MESSAGE);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	ArrayList<String> openWordFile(File file) {
		ArrayList<String> dictionaryList = new ArrayList<String>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] libraryItem = line.split(",");
				// Ignore First Line. . .

				// text, definiton, note

				for (int i = 0; i < libraryItem.length; i++) {

					dictionaryList.add(libraryItem[i]);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// inventoryList = items;
		}
		return dictionaryList;

	}

}
