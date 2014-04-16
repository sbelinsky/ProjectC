import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//create flowlayout pages for text
//create strings for each page
// create string splitting function 
// create button creating function
//create ifSelected function for Word


//For paul:
//Didnt finish the functionality component, but I am very close. I have my data seperated and stored into arrays, aswell as my dicttionary excel file set up / readable.
// I just need to correct on variable scope issue to pass the correct refrences.
public class CClient {

	JFrame frame;
	CHelp help;
	CSplash splash;
	File wordListFile;
	File contentStringFile;

	public static void main(String args[]) {
		CClient client = new CClient();

		client.go();
	}

	public void go() {
		CClient main = new CClient();
		main.buildGUI();

	}

	public void buildGUI() {
		wordListFile = new File("CWordList.csv");
		openWordFile(wordListFile);

		contentStringFile = new File("rawtext.txt");
		openContentFile(contentStringFile);

		help = new CHelp();

		splash = new CSplash();

		frame = new JFrame("Cicero Dictionary 01");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splash);

		frame.pack();
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}

	private void switchInPanel(JPanel panel) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.setSize(1000, 600);
		frame.pack();
	}

	private class CSplash extends JPanel {
		private JTextField textField;

		public CSplash() {
			setLayout(null);

			JLabel lblCiceroDictionary = new JLabel("Cicero Dictionary");
			lblCiceroDictionary.setFont(new Font("Comic Sans MS", Font.PLAIN,
					20));
			lblCiceroDictionary.setBounds(305, 6, 182, 49);
			add(lblCiceroDictionary);
			textField = new JTextField();
			textField.setBounds(327, 307, 116, 28);
			add(textField);
			textField.setColumns(10);

			JButton btnNewButton = new JButton("Go!");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//createPage(masterList, 1);
					// get panel from create page, then switch it into frame
				//	switchInPanel();
				}

			});
			btnNewButton.setBounds(327, 347, 117, 29);
			add(btnNewButton);

			JLabel lblSelectChapter = new JLabel("Select Chapter");
			lblSelectChapter.setBounds(327, 267, 116, 16);
			add(lblSelectChapter);

			JButton btnHelp = new JButton("Help");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchInPanel(help);
				}
			});
			btnHelp.setBounds(77, 347, 117, 29);
			add(btnHelp);

			JButton btnDictionary = new JButton("Dictionary");
			btnDictionary.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// go to dictionary
				}
			});
			btnDictionary.setBounds(567, 347, 117, 29);
			add(btnDictionary);
		}
	}

	ArrayList<String[]> openContentFile(File file) {
		ArrayList<String> lineList = new ArrayList<String>();
		ArrayList<String[]> masterList = new ArrayList<String[]>();
		BufferedReader br = null;
		String line = " ";
		try {

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				lineList.add(line);

			}

			for (int i = 0; i < lineList.size(); i++) {

				String[] tempArray = lineList.get(i).split(" ");

				masterList.add(tempArray);

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
			// System.out.println(inventoryList);
		}
		return masterList;

	}

	void openWordFile(File file) {
		ArrayList<Word> dictionaryList = new ArrayList<Word>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] libraryItem = line.split(",");
				// Ignore First Line. . .

				// text, definiton, note
				if (!libraryItem[0].equals("Word")) {

					String text = libraryItem[0];
					String definition = libraryItem[1];
					String note = libraryItem[2];

					Word word = null;

					word = new Word(text);

					dictionaryList.add(word);

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
			// System.out.println(inventoryList);
		}
	}

	JPanel createPage(ArrayList nlist, int nn) {

		JPanel panel;
		panel = new JPanel();
		FlowLayout layout = new FlowLayout();
		panel.setLayout(layout);
		int n = nn;
		ArrayList list = nlist;

		//tempArray = list.get(n);

	//	for (int i = 0; i < tempArray.size(); i++) {
	//		word = new Word(tempArray.get(i));
		//	panel.add(word);
	//	}

		return panel;

	}

	private class CHelp extends JPanel {

		/**
		 * Create the panel.
		 */
		public CHelp() {
			setLayout(null);

			JLabel lblHelp = new JLabel("Help");
			lblHelp.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
			lblHelp.setBounds(305, 18, 165, 33);
			add(lblHelp);

			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchInPanel(splash);

				}
			});
			btnHome.setBounds(16, 452, 117, 29);
			add(btnHome);

			JTextArea txtrWelcomeToThe = new JTextArea();
			txtrWelcomeToThe
					.setText("\n\n\tWelcome to the Cicero Dictionary. To use this application, enter a chapter\n\tnumber. You can click on words to get their meaning and any context \n\tspecific notes. This applicaiton is meant to be used as a tool for students \n\ttranslating Cicero's First Oration Against Cataline. \n\n\tThere is also a dictionary page containing all the words and their meanings.\n\n\tTo begin, navigate to home and enter a chapter number!\n");
			txtrWelcomeToThe.setBounds(105, 77, 584, 308);
			add(txtrWelcomeToThe);

		}

	}

}
