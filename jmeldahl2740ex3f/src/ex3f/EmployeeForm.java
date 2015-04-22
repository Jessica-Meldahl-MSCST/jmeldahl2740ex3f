package ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private DefaultListModel employeeListModel;
	private JComboBox deptComboBox;
	private JButton noArgConstructorButton;
	private JButton twoArgConstructorButton;
	private JButton fourArgConstructorButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("JMeldahl Exercise 3f: Overloaded Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 360, 147);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel();
	//	employeeList = new JList();
		employeeList = new JList(employeeListModel);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setBounds(10, 190, 98, 14);
		contentPane.add(lblNewLabel);
		
		empIdTextField = new JTextField();
		lblNewLabel.setLabelFor(empIdTextField);
		empIdTextField.setText("101");
		empIdTextField.setBounds(118, 187, 130, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 218, 98, 14);
		contentPane.add(lblEmployeeName);
		
		empNameTextField = new JTextField();
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setText("Jessica Meldahl");
		empNameTextField.setBounds(118, 215, 130, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		deptComboBox.setBounds(118, 246, 130, 20);
		contentPane.add(deptComboBox);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setLabelFor(deptComboBox);
		lblDepartment.setBounds(10, 249, 98, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 280, 98, 14);
		contentPane.add(lblPosition);
		
		positionTextField = new JTextField();
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setText("Software Engineer");
		positionTextField.setBounds(118, 277, 130, 20);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		noArgConstructorButton = new JButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(293, 186, 89, 23);
		contentPane.add(noArgConstructorButton);
		
		twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(293, 232, 89, 23);
		contentPane.add(twoArgConstructorButton);
		
		fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(293, 276, 89, 23);
		contentPane.add(fourArgConstructorButton);
	}
	
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		//Call appropriate constructor
		//Add employee to employeeListModel
		
		Employee emp = new Employee();
		employeeListModel.addElement(emp);
	}
	
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get empID from empIdTextField, convert to int
		//Call appropriate constructor
		//Add employee to employeeListModel
		
		int empID = Integer.parseInt(empIdTextField.getText());
		Employee empTwoArg = new Employee(empNameTextField.getText(), empID);
		employeeListModel.addElement(empTwoArg);
	}
	
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get empID from empIdTextField, convert to int
		//Get selected string from deptComboBox:
		// 		String dept = (String) deptComboBox.getSelectedItem();
		//Call appropriate constructor
		//Add employee to employeeListModel:
		//		employeeListModel.addElement(emp);
		
		int empID = Integer.parseInt(empIdTextField.getText());
		String dept = (String) deptComboBox.getSelectedItem();
		Employee empFourArg = new Employee(empNameTextField.getText(), empID, dept, positionTextField.getText());
		employeeListModel.addElement(empFourArg);
	}
}
