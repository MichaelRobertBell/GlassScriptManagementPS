import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main extends JFrame {
  JComboBox combo = new JComboBox();

  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    combo.addItem("AutoHotKey");
    combo.addItem("AppleScript");
    combo.addItem("UNIX Shell");
    combo.addItem("Windows PowerShell");
    combo.setEditable(true);
    System.out.println("#items=" + combo.getItemCount());

    combo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Selected index=" + combo.getSelectedIndex()
            + " Selected item=" + combo.getSelectedItem());
      }
    });

    getContentPane().add(combo);
    pack();
    setVisible(true);
  }

  public static void main(String arg[]) {
    new Main();
  }
}