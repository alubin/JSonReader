package runner.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;

import util.Person;
import util.Retrieve;

public class DisplayPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private JTextField addressFld = new JTextField();

	public DisplayPanel()
	{
		setLayout(new GridLayout(5,2));
		JLabel addressLbl = new JLabel("Address: ");
//		JTextField addressFld = new JTextField();
		JLabel idLbl = new JLabel("Id: ");
		JTextField idFld = new JTextField();
		JButton getBtn = new JButton("Get"); 
		add(addressLbl);
		add(addressFld);
		add(idLbl);
		add(idFld);
		add(getBtn);
		getBtn.addActionListener(new getActionButton());

	}

	private class getActionButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			String address = addressFld.getText();
			try {
				if (address != "")
				{
					String results = new Retrieve().httpGet(address);
//					gson.fromJson(results, Person.class);
//					System.out.println(gson.toString());
					gson.fromJson(json, classOfT)
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}


}
