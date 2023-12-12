// 定义了一个名为 "dao" 的包，这个包可能包含了与数据访问对象（Data Access Object）相关的类
package dao;

// 导入了 Java AWT 库中的 ActionEvent 类，这个类用于处理 GUI 中的动作事件，例如按钮点击等
import java.awt.event.ActionEvent;

// 导入了 Java SQL 库中的 ResultSet 类，这个类用于存储从数据库查询得到的结果集
import java.sql.ResultSet;

// 导入了 Java SQL 库中的 SQLException 类，这个类用于处理在访问数据库时可能出现的异常
import java.sql.SQLException;

// 导入了 model 包中的 Book 类，这个类可能定义了书籍的属性和方法
import model.Book;

// 导入了 model 包中的 Doctor 类，这个类可能定义了医生的属性和方法，但在这个上下文中，它可能与书籍无关，可能是误导入的
import model.Doctor;

// 定义了一个公共类 "BookDao"，它继承了 "BaseDao" 类
public class BookDao extends BaseDao
{
	 // 定义了一个公共方法 "addBook"，这个方法接收一个 "Book" 类型的参数，并返回一个字符串
	 public String addBook(Book book) 
	 {
		 // 定义了一个字符串 "resultstr"，并初始化为 "添加失败"
		 String resultstr="添加失败";
		 
		 // 定义了一个整数 "sum1"，并初始化为 0，这个变量可能用于存储查询结果的数量
		 int sum1=0;
		 
		 // 定义了一个字符串 "sql"，并初始化为一个 SQL 插入语句，这个语句可能用于向 "booking_form" 表中插入一条记录
		 String sql="insert into booking_form values(?,?,?,?)";
		 
		 // 这是一个被注释掉的 SQL 查询语句，它可能用于查询 "doctor" 表中 "Doid" 字段值与 "tmpdoctor.getId()" 相似的记录的数量
		 // String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
		 
		 // 定义了一个字符串 "sql1"，并初始化为一个 SQL 查询语句，这个语句用于查询 "booking_form" 表中的记录数量
		 String sql1="select count(*) from booking_form";
		// 使用 try-catch 结构来捕获和处理可能出现的 SQLException 异常
		try 
		{
			// 使用已经创建的数据库连接 "con" 来准备 SQL 查询语句 "sql1"
			this.pSatement = this.con.prepareStatement(sql1);
			
			// 执行 SQL 查询语句，并将结果集存储在 "executeQuery" 中
			ResultSet executeQuery = this.pSatement.executeQuery();
			
			// 使用 while 循环遍历结果集
			while(executeQuery.next())
			{
				// 从结果集中获取第一列的值（在这个上下文中，可能是 "count(*)" 的结果），并将这个值赋给 "sum1"
				sum1 = executeQuery.getInt(1);
			}
			
			// 在控制台打印 "sum1" 的值
			System.out.println(sum1);
			
		} 
		catch (SQLException e) 
		{
			// 如果在执行 SQL 查询过程中出现 SQLException 异常，就会执行这个 catch 块
			
			// 打印异常的堆栈跟踪信息
			e.printStackTrace();
		}
    		 
		/*
		 定义了一个字符串 "sql"，并初始化为一个 SQL 插入语句，这个语句可能用于向 "booking_form" 表中插入一条记录
		 String sql="insert into booking_form values(?,?,?,?)";
		 执行该sql插入操作
		 */
		try 
		{
			// 使用已经创建的数据库连接 "con" 来准备 SQL 插入语句 "sql"
			this.pSatement = this.con.prepareStatement(sql);
			
			// 设置 SQL 插入语句的第一个参数为 "sum1+1" 的字符串形式
			this.pSatement.setString(1, String.valueOf(sum1+1));
			
			// 设置 SQL 插入语句的第二个参数为 "book" 对象的 "time" 属性值
			this.pSatement.setString(2, book.getTime());
			
			// 设置 SQL 插入语句的第三个参数为 "book" 对象的 "Doid" 属性值
			this.pSatement.setString(3, book.getDoid());
			
			// 设置 SQL 插入语句的第四个参数为 "book" 对象的 "Pid" 属性值
			this.pSatement.setString(4, book.getPid());
			
			// 在控制台打印 "pSatement" 对象，这可能是为了调试目的
			System.out.println(this.pSatement);
			
			// 执行 SQL 插入语句，如果插入成功，"executeUpdate()" 方法会返回大于 0 的值
			if(this.pSatement.executeUpdate() > 0)
			{
				// 如果插入成功，将 "resultstr" 的值设置为 "添加成功"
				resultstr = "添加成功";
			}
		} 
		catch (SQLException e) 
		{
			// 如果在执行 SQL 插入操作过程中出现 SQLException 异常，就会执行这个 catch 块
			
			// 打印异常的堆栈跟踪信息
			e.printStackTrace();
		}

		// 返回 "resultstr" 的值，这个值表示插入操作的结果
		return resultstr;
     }
}
