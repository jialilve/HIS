// 定义了一个名为 "Book" 的包，这个包可能包含了与预约相关的类
package Book;

// 导入了 "java.awt" 包中的 "BorderLayout"、"Color" 和 "EventQueue" 类，这些类用于创建和管理图形用户界面
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

// 导入了 "javax.swing" 包中的 "JFrame"、"JPanel"、"JScrollPane"、"JTable"、"JLabel"、"JOptionPane"、"JTextField" 和 "JButton" 类，这些类用于创建和管理图形用户界面
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

// 导入了 "javax.swing.border" 包中的 "EmptyBorder" 类，这个类用于创建和管理图形用户界面中的边框
import javax.swing.border.EmptyBorder;

// 导入了 "javax.swing.table" 包中的 "DefaultTableCellRenderer" 和 "DefaultTableModel" 类，这些类用于创建和管理图形用户界面中的表格
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

// 导入了 "dao" 包中的 "DoctorDao" 类，这个类可能用于与数据库进行交互
import dao.DoctorDao;

// 导入了 "java.awt" 包中的 "Font" 类，这个类用于设置和管理字体
import java.awt.Font;

// 导入了 "java.awt" 包中的 "Toolkit" 类，这个类提供了许多与系统相关的方法
import java.awt.Toolkit;

// 导入了 "java.util" 包，这个包包含了许多实用的类，如 "ArrayList"、"HashMap" 等
import java.util.*;

// 导入了 "model" 包中的 "Doctor" 类，这个类可能是一个数据模型
import model.Doctor;

// 导入了 "patient" 包中的 "addPatient" 类，这个类可能用于添加病人的信息
import patient.addPatient;

// 导入了 "view" 包中的 "Indexframe" 类，这个类可能是一个图形用户界面的框架
import view.Indexframe;

// 导入了 "java.awt.event" 包中的 "ActionListener"、"ActionEvent"、"MouseAdapter" 和 "MouseEvent" 类，这些类用于处理用户的动作，如点击按钮、鼠标点击等
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 定义了一个公共类 "BookList"，这个类继承了 "JFrame" 类，用于创建一个图形用户界面窗口
public class BookList extends JFrame {

	// 定义了一个私有的 "JPanel" 类型的成员变量 "contentPane"，这个变量可能用于存储窗口的内容面板
	private JPanel contentPane;
	
	// 定义了一个私有的 "JTable" 类型的成员变量 "DoctorList"，这个变量可能用于显示医生的列表
	private JTable DoctorList;
	
	// 定义了一个私有的 "JTextField" 类型的成员变量 "doctor_id"，这个变量可能用于输入或显示医生的 ID
	private JTextField doctor_id;
	
	// 定义了一个私有的 "JTextField" 类型的成员变量 "doctor_name"，这个变量可能用于输入或显示医生的名字
	private JTextField doctor_name;
	
	// 定义了一个私有的 "JTextField" 类型的成员变量 "doctor_level"，这个变量可能用于输入或显示医生的级别
	private JTextField doctor_level;
	
	// 定义了一个私有的 "JTextField" 类型的成员变量 "doctor_de"，这个变量可能用于输入或显示医生的部门
	private JTextField doctor_de;
	
	// 定义了一个私有的 "DefaultTableModel" 类型的成员变量 "dtm"，并初始化为 null，这个变量可能用于管理 "DoctorList" 表格的数据模型
	private DefaultTableModel dtm=null;
	
	// 定义了一个私有的 "String" 类型的成员变量 "id"，这个变量可能用于存储当前选中的医生的 ID
	private String id;
	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the frame.
	 */
	// 定义了一个名为 "BookList" 的构造函数，它接收一个 "id" 参数
	public BookList(String id) 
	{
		// 将传入的 "id" 参数赋值给类的成员变量 "this.id"
		this.id=id;
		
		// 设置窗口的标题为 "医生列表"
		setTitle("\u533B\u5E08\u5217\u8868"); // 医生列表
		
		// 设置窗口的关闭操作为 "DISPOSE_ON_CLOSE"，这意味着当窗口被关闭时，它将被销毁，但不会终止程序
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// 设置窗口的边界，即窗口的位置和大小
		setBounds(100, 100, 867, 493);
		
		// 创建一个新的 "JPanel" 对象，并将其赋值给 "contentPane"
		contentPane = new JPanel();
		
		// 为 "contentPane" 设置一个新的空边框，边框的上、左、下、右边距都是 5
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// 将 "contentPane" 设置为窗口的内容面板
		setContentPane(contentPane);
		
		// 为 "contentPane" 设置布局管理器为 null，这意味着需要手动设置组件的位置和大小
		contentPane.setLayout(null);
		
		// 创建一个新的 "JScrollPane" 对象，并将其赋值给 "scrollPane"
		JScrollPane scrollPane = new JScrollPane();
		
		// 设置 "scrollPane" 的位置和大小
		scrollPane.setBounds(10, 10, 833, 324);
		
		// 将 "scrollPane" 添加到 "contentPane" 中
		contentPane.add(scrollPane);
		
		// 创建一个新的 "JTable" 对象，并将其赋值给 "DoctorList"
		DoctorList = new JTable();
		
		// 为 "DoctorList" 添加一个鼠标点击事件监听器
		DoctorList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				// 当鼠标点击事件发生时，调用 "selectRow" 方法
				selectRow(e);
			}
		});
	}

		DoctorList.setFont(new Font("华文楷体", Font.PLAIN, 15));
		DoctorList.setBackground(new Color(200,210,210));
		DoctorList.getTableHeader().setReorderingAllowed(false);
		DoctorList.setRowHeight(25);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		DoctorList.setDefaultRenderer(Object.class,r);
		
		DoctorList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u533B\u5E08\u5DE5\u53F7", "\u533B\u5E08\u59D3\u540D", "\u6027\u522B", " \u5E74\u9F84", " \u804C\u79F0", "\u7535\u8BDD\u53F7\u7801", "\u6240\u5C5E\u79D1\u5BA4"
			} // 医生工号 医生姓名 性别 年龄 职称 电话号码 所属科室
		));
		DoctorList.getColumnModel().getColumn(0).setPreferredWidth(70);
		DoctorList.getColumnModel().getColumn(1).setPreferredWidth(67);
		DoctorList.getColumnModel().getColumn(2).setPreferredWidth(48);
		DoctorList.getColumnModel().getColumn(3).setPreferredWidth(60);
		DoctorList.getColumnModel().getColumn(4).setPreferredWidth(60);
		DoctorList.getColumnModel().getColumn(5).setPreferredWidth(72);
		scrollPane.setViewportView(DoctorList);
		
		JLabel lblNewLabel = new JLabel("\u533B\u5E08\u7F16\u53F7\uFF1A"); // 医生编号
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 346, 112, 30);
		contentPane.add(lblNewLabel);
		
		doctor_id = new JTextField();
		doctor_id.setBounds(108, 354, 66, 21);
		contentPane.add(doctor_id);
		doctor_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u533B\u5E08\u59D3\u540D:"); // 医生姓名
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(224, 348, 86, 30);
		contentPane.add(lblNewLabel_1);
		
		doctor_name = new JTextField();
		doctor_name.setBounds(320, 355, 66, 21);
		contentPane.add(doctor_name);
		doctor_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u804C  \u79F0\uFF1A"); // 职称
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(10, 397, 72, 21);
		contentPane.add(lblNewLabel_2);
		
		doctor_level = new JTextField();
		doctor_level.setBounds(77, 400, 66, 21);
		contentPane.add(doctor_level);
		doctor_level.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u79D1\u5BA4\uFF1A"); // 所属科室
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(194, 397, 97, 21);
		contentPane.add(lblNewLabel_3);
		
		doctor_de = new JTextField();
		doctor_de.setBounds(301, 400, 85, 21);
		contentPane.add(doctor_de);
		doctor_de.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22"); // 搜索
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				selecSomeoneDoctor(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.setBounds(479, 353, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E"); // 重置
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				reButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(479, 399, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("\u6302\u53F7"); // 挂号
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				bookButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(642, 353, 93, 23);
		contentPane.add(btnNewButton_1);
		this.dtm=(DefaultTableModel) DoctorList.getModel();
		
		queryAlldoctor();
	}
	 
	 
	protected void bookButton(ActionEvent e) { // 挂号
		// TODO Auto-generated method stub
	    AddBook dk=new AddBook(this.id);
	    dk.setVisible(true); // setvisible(true)方法用于显示窗口
	}


	protected void selectRow(MouseEvent e)  // 选中某一行
	{
		// TODO Auto-generated method stub
		this.doctor_id.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 0).toString());
		this.doctor_name.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 1).toString());
		this.doctor_level.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 4).toString());
		this.doctor_de.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 6).toString());
		//this.editButton.setEnabled(true);
		//this.deleteButton.setEnabled(true);
	}
	protected void selecSomeoneDoctor(ActionEvent e) { // 搜索
		// TODO Auto-generated method stub
		String name=this.doctor_name.getText();
		String id=this.doctor_id.getText();
		String Deid=this.doctor_de.getText();
		String Dlevel=this.doctor_level.getText();
		
		Doctor doctor =new Doctor();
		doctor.setId(id);
		doctor.setName(name);
		doctor.setLevel(Dlevel);
		doctor.setDeparment(Deid);
		this.dtm.setRowCount(0);
		DoctorDao doctordao=new DoctorDao();
		List<Doctor> allList=doctordao.querysomeDoctor(doctor);
		for(Doctor st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSex());
			v.add(st.getAge());
			v.add(st.getLevel());
			v.add(st.getTel());
			v.add(st.getDeparment());
			dtm.addRow(v);
		}
		
	}

	protected void reButton(ActionEvent e) { // 重置
		// TODO Auto-generated method stub
		this.doctor_id.setText("");
		this.doctor_de.setText("");
		this.doctor_level.setText("");
		this.doctor_name.setText("");
	}
    
	public void queryAlldoctor() // 查询所有医生
	{
		this.dtm.setRowCount(0);
		DoctorDao doctordao=new DoctorDao();
		List<Doctor> allList=doctordao.queryAlldoctor();
		for(Doctor st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSex());
			v.add(st.getAge());
			v.add(st.getLevel());
			v.add(st.getTel());
			v.add(st.getDeparment());
			dtm.addRow(v);
		}
					
	}
}
