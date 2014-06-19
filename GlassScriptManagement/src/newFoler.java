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
	private JTextField textField;

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
		frmNewFolder.setBounds(100, 100, 450, 146);
		frmNewFolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblFolderName = new JLabel("Folder Name:");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblUplodadIcon = new JLabel("Uplodad Icon:");

		JButton btnBrowse = new JButton("Browse:");



		final JLabel iconFilePath = new JLabel("");


		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	            JFileChooser openIcon = new JFileChooser();
	            openIcon.showOpenDialog(null);
	            File text = openIcon.getSelectedFile();
	            iconFilePath.setText(text.toString());

			}
	    });

		JButton btnSubmit = new JButton("Submit");
		GroupLayout groupLayout = new GroupLayout(frmNewFolder.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFolderName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUplodadIcon)
							.addGap(18)
							.addComponent(iconFilePath)
							.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
							.addComponent(btnBrowse))
						.addComponent(btnSubmit, Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFolderName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUplodadIcon)
						.addComponent(btnBrowse)
						.addComponent(iconFilePath))
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		frmNewFolder.getContentPane().setLayout(groupLayout);


	}

}