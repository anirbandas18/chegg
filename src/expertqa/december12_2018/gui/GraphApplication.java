package expertqa.december12_2018.gui;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class GraphApplication {

	private JFrame frmGraphpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					GraphApplication window = new GraphApplication();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmGraphpanel = new JFrame();
		frmGraphpanel.setType(Type.NORMAL);
		frmGraphpanel.setResizable(false);
		frmGraphpanel.setTitle("Graph GUI");
		frmGraphpanel.setBounds(100, 100, 936, 668);
		frmGraphpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGraphpanel.getContentPane().setLayout(null);
		frmGraphpanel.setLocationRelativeTo(null);
		
		ButtonGroup bg = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(6, 10, 160, 226);
		frmGraphpanel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnAddVertex = new JRadioButton("Add Vertex");
		rdbtnAddVertex.setBounds(6, 6, 105, 21);
		rdbtnAddVertex.setMnemonic(1);
		panel_1.add(rdbtnAddVertex);
		bg.add(rdbtnAddVertex);
		
		JRadioButton rdbtnAddEdge = new JRadioButton("Add Edge");
		rdbtnAddEdge.setBounds(6, 29, 105, 21);
		rdbtnAddEdge.setMnemonic(2);
		panel_1.add(rdbtnAddEdge);
		bg.add(rdbtnAddEdge);
		
		JRadioButton rdbtnRemoveVertex = new JRadioButton("Remove Vertex");
		rdbtnRemoveVertex.setBounds(6, 52, 105, 21);
		rdbtnRemoveVertex.setMnemonic(3);
		panel_1.add(rdbtnRemoveVertex);
		bg.add(rdbtnRemoveVertex);
		
		JRadioButton rdbtnRemoveEdge = new JRadioButton("Remove Edge");
		rdbtnRemoveEdge.setBounds(6, 75, 105, 21);
		rdbtnRemoveEdge.setMnemonic(4);
		panel_1.add(rdbtnRemoveEdge);
		bg.add(rdbtnRemoveEdge);
		
		JButton btnAdd = new JButton("Add All Edges");
		btnAdd.setBounds(0, 102, 160, 21);
		panel_1.add(btnAdd);
		
		JButton btnConnectedComponents = new JButton("Connected Components");
		btnConnectedComponents.setBounds(0, 132, 160, 21);
		panel_1.add(btnConnectedComponents);
		
		JButton btnNewButton = new JButton("Show Cut Vertices");
		btnNewButton.setBounds(0, 165, 160, 21);
		panel_1.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(0, 194, 160, 21);
		panel_1.add(btnHelp);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new DrawingPanel(bg);
		panel.setBounds(176, 10, 746, 620);
		frmGraphpanel.getContentPane().add(panel);

		frmGraphpanel.setVisible(true);
	}
}
