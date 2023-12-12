// 导入 Book 包，这个包可能包含了与书籍相关的其他类
package Book;

// 导入 Java AWT（Abstract Window Toolkit）和 Swing 库，这些库用于构建图形用户界面
import java.awt.BorderLayout;
import java.awt.EventQueue;

// 导入 Swing 库中的 JFrame、JPanel、JLabel、JButton、JTextArea，这些类用于创建窗口、面板、标签、按钮和文本区域
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// 导入 BookDao 类，这个类可能是用于与数据库交互，进行书籍的增删改查操作
import dao.BookDao;

// 导入 Book 类，这个类可能定义了书籍的属性和方法
import model.Book;

// 继续导入 Swing 库中的 JOptionPane，这个类用于创建弹出对话框
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// 导入 Java AWT 库中的 Font 类，这个类用于设置文本的字体
import java.awt.Font;

// 导入 Swing 库中的 JTextField，这个类用于创建文本输入框
import javax.swing.JTextField;

// 导入 Swing 库中的 JButton，这个类用于创建按钮
import javax.swing.JButton;

// 导入 Swing 库中的 JTextArea，这个类用于创建文本区域
import javax.swing.JTextArea;

// 导入 Java AWT 库中的 ActionListener 和 ActionEvent，这些类用于处理按钮点击等事件
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField Doid;
	private JTextField Pid;
	private String id;
	private JTextField time;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public AddBook(String id) 
	{
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u533B\u5E08\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel.setBounds(50, 47, 85, 28);
		contentPane.add(lblNewLabel);
		
		Doid = new JTextField();
		Doid.setBounds(174, 54, 107, 21);
		contentPane.add(Doid);
		Doid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u7F16\u53F7"); // 病人编号
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(50, 111, 85, 28);
		contentPane.add(lblNewLabel_1);
		
		Pid = new JTextField();
		Pid.setBounds(174, 118, 107, 21);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JButton addButton = new JButton("\u786E\u8BA4"); // 确认
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addRecord(e);
			}
		});
		addButton.setFont(new Font("华文楷体", Font.PLAIN, 21));
		addButton.setBounds(50, 277, 85, 28);
		contentPane.add(addButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88"); // 取消
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 21));
		btnNewButton_1.setBounds(228, 277, 93, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u6302\u53F7\u65F6\u95F4"); // 挂号时间
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(50, 183, 85, 21);
		contentPane.add(lblNewLabel_3);
		
		time = new JTextField();
		time.setBounds(174, 186, 113, 21);
		contentPane.add(time);
		time.setColumns(10);
		 this.Pid.setText(this.id);
	}

	protected void addRecord(ActionEvent e) 
	{
		System.out.println(this.id);
	    
	    Book bk=new Book();
	    bk.setPid(this.id);
	    bk.setDoid(this.Doid.getText());
	    bk.setTime(this.time.getText());
		// TODO Auto-generated method stub
		BookDao bd=new BookDao();
		JOptionPane.showMessageDialog(this,bd.addBook(bk));
	}
	public void resetButton(ActionEvent e)
	{
		this.Pid.setText(this.id);
		this.Doid.setText("");
		this.time.setText("");
	}
}
