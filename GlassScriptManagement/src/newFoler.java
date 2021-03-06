import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;


public class newFoler {

	private JFrame frmNewFolder;
	private JTextField folderName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newFoler window = new newFoler();
					window.frmNewFolder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newFoler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewFolder = new JFrame();
		frmNewFolder.setTitle("New Folder");
		frmNewFolder.setBounds(100, 100, 550, 85);
		frmNewFolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblFolderName = new JLabel("Folder Name:");
		lblFolderName.setBounds(10, 14, 65, 14);

		folderName = new JTextField();
		folderName.setBounds(91, 11, 340, 20);
		folderName.setColumns(10);



		final JLabel iconFilePath = new JLabel("");
		iconFilePath.setBounds(95, 49, 0, 0);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newFolder = folderName.getText();
				System.out.println(newFolder);
				System.exit(0);
			}
		});
		btnSubmit.setBounds(441, 10, 83, 23);
		frmNewFolder.getContentPane().setLayout(null);
		frmNewFolder.getContentPane().add(lblFolderName);
		frmNewFolder.getContentPane().add(folderName);
		frmNewFolder.getContentPane().add(iconFilePath);
		frmNewFolder.getContentPane().add(btnSubmit);


	}

}