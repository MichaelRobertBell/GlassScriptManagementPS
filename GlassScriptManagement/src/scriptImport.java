import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class scriptImport {
	
	private JFrame frmImport;
	private JTextField textField;
	private JTextField keyWords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scriptImport window = new scriptImport();
					window.frmImport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public scriptImport() {
		initialize("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String arg) {
		final JFileChooser OpenScript = new JFileChooser();
        OpenScript.showOpenDialog(null);
        final File userScript = OpenScript.getSelectedFile();
        OpenScript.getName(userScript);
		
        //needs to be in the database, and saved on exit if edited
        String[] scriptsArray = {
				"AutoHotKey",
				"AppleScript",
				"AWK",
				"BeanShell",
				"Bash",
				"Candle",
				"Ch",
				"CLIST",
				"ColdFusion",
				"ECMAScript",
				"ActionScript",
				"ECMAScript for XML",
				"JavaScript",
				"JScript",
				"CMS EXEC",
				"EXEC 2",
				"F-Script",
				"Falcon",
				"Fancy",
				"Frink",
				"Game Maker Language (GML)",
				"ICI",
				"Io",
				"JASS",
				"Groovy",
				"Join Java",
				"Julia",
				"Tea",
				"Lua",
				"MAXScript",
				"MEL",
				"Obix",
				"Oriel",
				"Perl",
				"PHP",
				"Pikt",
				"Python",
				"R",
				"REBOL",
				"REXX",
				"Revolution",
				"Ruby",
				"Smalltalk",
				"S-Lang",
				"sed",
				"Tcl",
				"TorqueScript",
				"UNIX shell",
				"VBScript",
				"WebDNA",
				"Windows PowerShell",
				"Winbatch"};
		frmImport = new JFrame();
		frmImport.setResizable(false);
		frmImport.setBackground(SystemColor.desktop);
		frmImport.setTitle("Import");
		frmImport.setBounds(100, 100, 500, 387);
		frmImport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnSubmit = new JButton("Submit");

		btnSubmit.setBounds(263, 284, 115, 23);

		final JCheckBox chckbxGitSupport = new JCheckBox("Git Support");
		chckbxGitSupport.setBounds(163, 262, 79, 23);

		final JComboBox<Object> scriptType = new JComboBox<Object>(scriptsArray);
		scriptType.setEditable(true);
		scriptType.setToolTipText("");
		scriptType.setModel(new DefaultComboBoxModel(new String[] {"AutoHotKey", "AppleScript", "AWK", "BeanShell", "Bash", "Candle", "Ch", "CLIST", "ColdFusion", "ECMAScript", "ActionScript", "ECMAScript for XML", "JavaScript", "JScript", "CMS EXEC", "EXEC 2", "F-Script", "Falcon", "Fancy", "Frink", "Game Maker Language (GML)", "ICI", "Io", "JASS", "Groovy", "Join Java", "Julia", "Tea", "Lua", "MAXScript", "MEL", "Obix", "Oriel", "Perl", "PHP", "Pikt", "Python", "R", "REBOL", "REXX", "Revolution", "Ruby", "Smalltalk", "S-Lang", "sed", "Tcl", "TorqueScript", "UNIX shell", "VBScript", "WebDNA", "Windows PowerShell", "Winbatch"}));
		scriptType.setBounds(168, 195, 306, 20);

		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(168, 66, 306, 75);

		textField = new JTextField();
		textField.setBounds(168, 34, 306, 20);
		final String FileName=OpenScript.getName(userScript).toString();
		
		textField.setText(FileName.substring(0, FileName.lastIndexOf('.')));
		
		FileName.substring(FileName.lastIndexOf('.'),FileName.length());
		
		
		textField.setColumns(10);

		keyWords = new JTextField();
		keyWords.setBounds(168, 159, 306, 20);
		keyWords.setColumns(10);

		JLabel lblScriptName = new JLabel("Script Name:");
		lblScriptName.setBounds(24, 37, 61, 14);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(24, 100, 57, 14);

		JLabel lblType = new JLabel("Key Words:");
		lblType.setBounds(24, 162, 56, 14);

		JLabel lblNewLabel = new JLabel("Scripting Language:");
		lblNewLabel.setBounds(24, 198, 95, 14);

		JLabel lblGitSupport = new JLabel("Git Support:");
		lblGitSupport.setBounds(24, 266, 58, 14);
		
		JLabel lblFilePath = new JLabel("File Path:");
		lblFilePath.setBounds(24, 15, 45, 14);
		
		final JLabel lbFP = new JLabel("");
		lbFP.setBounds(168, 15, 306, 14);
		lbFP.setText(userScript.toString());
		frmImport.getContentPane().setLayout(null);
		frmImport.getContentPane().add(btnSubmit);
		frmImport.getContentPane().add(lblGitSupport);
		frmImport.getContentPane().add(lblNewLabel);
		frmImport.getContentPane().add(chckbxGitSupport);
		frmImport.getContentPane().add(scriptType);
		frmImport.getContentPane().add(lblFilePath);
		frmImport.getContentPane().add(lblDescription);
		frmImport.getContentPane().add(lblScriptName);
		frmImport.getContentPane().add(lblType);
		frmImport.getContentPane().add(lbFP);
		frmImport.getContentPane().add(keyWords);
		frmImport.getContentPane().add(editorPane);
		frmImport.getContentPane().add(textField);
		
		JLabel lblFolder = new JLabel("Folder:");
		lblFolder.setBounds(24, 235, 46, 14);
		frmImport.getContentPane().add(lblFolder);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(new Object[]{});
		comboBox.setToolTipText("");
		comboBox.setEditable(true);
		comboBox.setBounds(168, 235, 306, 20);
		frmImport.getContentPane().add(comboBox);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileExtension = userScript.toString();
				String fileText = textField.getText();
				String fileDes = editorPane.getText();
				String fileKeys = keyWords.getText();
				String fileType = scriptType.getSelectedItem().toString();
				Boolean fileGit = chckbxGitSupport.isSelected();
				
				System.out.println(fileExtension + " " +  fileText + " " + fileDes + " " + fileKeys + " " + fileType + " " + fileGit);
				System.exit(0);
				
			}
			
		});
	}
}