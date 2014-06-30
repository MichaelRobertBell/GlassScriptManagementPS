import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import java.io.File;

import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTree;
import java.awt.Button;


public class Glass {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Glass window = new Glass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the application.
	 */
	public Glass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmFolder_1 = new JMenuItem("Folder");
		mnNew.add(mntmFolder_1);
		
		JMenu mnImport = new JMenu("Import");
		mnNew.add(mnImport);
		
		JMenuItem mntmScript = new JMenuItem("Script");
		mnImport.add(mntmScript);
		
		JMenuItem mntmFolder = new JMenuItem("Folder");
		mnImport.add(mntmFolder);
		
		mntmFolder_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				newFoler.main(null);
			}
			
			
			
		});

		
		JMenuItem mntmSchedule = new JMenuItem("Schedule");
		mnNew.add(mntmSchedule);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		JButton btnNewfolder = new JButton("NewFolder");
		btnNewfolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch)
							.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
							.addComponent(btnNewfolder, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewfolder))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		
		JLabel lblPlaceholder = new JLabel("PlaceHolder");
		lblPlaceholder.setBounds(143, 11, 56, 14);
		
		JLabel lblDiscription = new JLabel("Discription:");
		lblDiscription.setBounds(10, 157, 53, 14);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 45, 31, 14);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 70, 44, 14);
		
		JLabel lblKeyTerms = new JLabel("Key Terms:");
		lblKeyTerms.setBounds(9, 120, 54, 14);
		
		JLabel lblScriptType = new JLabel("Script Type:");
		lblScriptType.setBounds(10, 95, 58, 14);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(10, 249, 133, 23);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.setBounds(157, 249, 150, 23);
		
		JButton btnOpenGit = new JButton("Open Git");
		btnOpenGit.setBounds(10, 277, 135, 23);
		
		JButton btnOpenFolderLocation = new JButton("Open Folder Location");
		btnOpenFolderLocation.setBounds(10, 303, 135, 23);
		
		JButton btnEditScript = new JButton("Edit Script");
		btnEditScript.setBounds(10, 330, 135, 23);
		
		JButton btnOpenIn = new JButton("Open In");
		btnOpenIn.setBounds(157, 277, 150, 23);
		
		JButton btnSendTo = new JButton("Send To");
		btnSendTo.setBounds(157, 303, 150, 23);
		
		JButton btnEditGlassContent = new JButton("Edit Glass Content");
		btnEditGlassContent.setBounds(157, 330, 150, 23);
		panel.setLayout(null);
		panel.add(lblPlaceholder);
		panel.add(lblDiscription);
		panel.add(lblName);
		panel.add(lblLocation);
		panel.add(lblKeyTerms);
		panel.add(lblScriptType);
		panel.add(btnRun);
		panel.add(btnSchedule);
		panel.add(btnOpenGit);
		panel.add(btnOpenFolderLocation);
		panel.add(btnEditScript);
		panel.add(btnOpenIn);
		panel.add(btnSendTo);
		panel.add(btnEditGlassContent);
		
		JLabel lblPhname = new JLabel("phName");
		lblPhname.setBounds(78, 45, 46, 14);
		panel.add(lblPhname);
		
		JLabel lblPhlocation = new JLabel("phLocation");
		lblPhlocation.setBounds(78, 70, 46, 14);
		panel.add(lblPhlocation);
		
		JLabel lblPhtype = new JLabel("phType");
		lblPhtype.setBounds(78, 95, 46, 14);
		panel.add(lblPhtype);
		
		JLabel lblPhkeyterms = new JLabel("phKeyTerms");
		lblPhkeyterms.setBounds(78, 120, 46, 14);
		panel.add(lblPhkeyterms);
		
		JLabel lblPhdiscription = new JLabel("phDiscription");
		lblPhdiscription.setBounds(78, 157, 46, 14);
		panel.add(lblPhdiscription);
		
		JTree tree = new JTree();
		tree.setEditable(true);
		scrollPane.setViewportView(tree);
		
		frame.getContentPane().setLayout(groupLayout);
		
		mntmScript.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {     	
	            scriptImport.main(null);
	        }
	    });

		mntmFolder.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            JFileChooser openFolder = new JFileChooser();
	            openFolder.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
	            openFolder.showOpenDialog(null);
	            File userFolder = openFolder.getSelectedFile();
	            scriptImport.main(null);
	            
	        }
	    });
		
	}

	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		
	}
}
