// ������һ����Ϊ "dao" �İ�����������ܰ����������ݷ��ʶ���Data Access Object����ص���
package dao;

// ������ Java AWT ���е� ActionEvent �࣬��������ڴ��� GUI �еĶ����¼������簴ť�����
import java.awt.event.ActionEvent;

// ������ Java SQL ���е� ResultSet �࣬��������ڴ洢�����ݿ��ѯ�õ��Ľ����
import java.sql.ResultSet;

// ������ Java SQL ���е� SQLException �࣬��������ڴ����ڷ������ݿ�ʱ���ܳ��ֵ��쳣
import java.sql.SQLException;

// ������ model ���е� Book �࣬�������ܶ������鼮�����Ժͷ���
import model.Book;

// ������ model ���е� Doctor �࣬�������ܶ�����ҽ�������Ժͷ�������������������У����������鼮�޹أ������������
import model.Doctor;

// ������һ�������� "BookDao"�����̳��� "BaseDao" ��
public class BookDao extends BaseDao
{
	 // ������һ���������� "addBook"�������������һ�� "Book" ���͵Ĳ�����������һ���ַ���
	 public String addBook(Book book) 
	 {
		 // ������һ���ַ��� "resultstr"������ʼ��Ϊ "���ʧ��"
		 String resultstr="���ʧ��";
		 
		 // ������һ������ "sum1"������ʼ��Ϊ 0����������������ڴ洢��ѯ���������
		 int sum1=0;
		 
		 // ������һ���ַ��� "sql"������ʼ��Ϊһ�� SQL ������䣬��������������� "booking_form" ���в���һ����¼
		 String sql="insert into booking_form values(?,?,?,?)";
		 
		 // ����һ����ע�͵��� SQL ��ѯ��䣬���������ڲ�ѯ "doctor" ���� "Doid" �ֶ�ֵ�� "tmpdoctor.getId()" ���Ƶļ�¼������
		 // String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
		 
		 // ������һ���ַ��� "sql1"������ʼ��Ϊһ�� SQL ��ѯ��䣬���������ڲ�ѯ "booking_form" ���еļ�¼����
		 String sql1="select count(*) from booking_form";
		// ʹ�� try-catch �ṹ������ʹ�����ܳ��ֵ� SQLException �쳣
		try 
		{
			// ʹ���Ѿ����������ݿ����� "con" ��׼�� SQL ��ѯ��� "sql1"
			this.pSatement = this.con.prepareStatement(sql1);
			
			// ִ�� SQL ��ѯ��䣬����������洢�� "executeQuery" ��
			ResultSet executeQuery = this.pSatement.executeQuery();
			
			// ʹ�� while ѭ�����������
			while(executeQuery.next())
			{
				// �ӽ�����л�ȡ��һ�е�ֵ��������������У������� "count(*)" �Ľ�������������ֵ���� "sum1"
				sum1 = executeQuery.getInt(1);
			}
			
			// �ڿ���̨��ӡ "sum1" ��ֵ
			System.out.println(sum1);
			
		} 
		catch (SQLException e) 
		{
			// �����ִ�� SQL ��ѯ�����г��� SQLException �쳣���ͻ�ִ����� catch ��
			
			// ��ӡ�쳣�Ķ�ջ������Ϣ
			e.printStackTrace();
		}
    		 
		/*
		 ������һ���ַ��� "sql"������ʼ��Ϊһ�� SQL ������䣬��������������� "booking_form" ���в���һ����¼
		 String sql="insert into booking_form values(?,?,?,?)";
		 ִ�и�sql�������
		 */
		try 
		{
			// ʹ���Ѿ����������ݿ����� "con" ��׼�� SQL ������� "sql"
			this.pSatement = this.con.prepareStatement(sql);
			
			// ���� SQL �������ĵ�һ������Ϊ "sum1+1" ���ַ�����ʽ
			this.pSatement.setString(1, String.valueOf(sum1+1));
			
			// ���� SQL �������ĵڶ�������Ϊ "book" ����� "time" ����ֵ
			this.pSatement.setString(2, book.getTime());
			
			// ���� SQL �������ĵ���������Ϊ "book" ����� "Doid" ����ֵ
			this.pSatement.setString(3, book.getDoid());
			
			// ���� SQL �������ĵ��ĸ�����Ϊ "book" ����� "Pid" ����ֵ
			this.pSatement.setString(4, book.getPid());
			
			// �ڿ���̨��ӡ "pSatement" �����������Ϊ�˵���Ŀ��
			System.out.println(this.pSatement);
			
			// ִ�� SQL ������䣬�������ɹ���"executeUpdate()" �����᷵�ش��� 0 ��ֵ
			if(this.pSatement.executeUpdate() > 0)
			{
				// �������ɹ����� "resultstr" ��ֵ����Ϊ "��ӳɹ�"
				resultstr = "��ӳɹ�";
			}
		} 
		catch (SQLException e) 
		{
			// �����ִ�� SQL ������������г��� SQLException �쳣���ͻ�ִ����� catch ��
			
			// ��ӡ�쳣�Ķ�ջ������Ϣ
			e.printStackTrace();
		}

		// ���� "resultstr" ��ֵ�����ֵ��ʾ��������Ľ��
		return resultstr;
     }
}
