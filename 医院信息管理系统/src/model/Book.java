// 定义了一个名为 "model" 的包，这个包可能包含了与数据模型相关的类
package model;

// 定义了一个公共类 "Book"
public class Book 
{
   // 定义了一个私有字符串属性 "time"
   private String time;
   
   // 定义了一个私有字符串属性 "Doid"
   private String Doid;
   
   // 定义了一个私有字符串属性 "Pid"
   private String Pid;
   
   // 定义了一个无参数的公共构造函数，这个构造函数没有做任何操作
   public Book()
   {
      
   }
   
   // 定义了一个带有三个字符串参数的公共构造函数，这个构造函数将传入的参数值赋给相应的属性
   public Book(String time,String Doid,String Pid)
   {
      this.time=time;  // 将传入的 "time" 参数值赋给 "time" 属性
      this.Doid=Doid;  // 将传入的 "Doid" 参数值赋给 "Doid" 属性
      this.Pid=Pid;    // 将传入的 "Pid" 参数值赋给 "Pid" 属性
   }
   
   // 定义了一个公共方法 "getTime"，这个方法返回 "time" 属性的值
   public String getTime() {
   return time;
   }
   
   // 定义了一个公共方法 "setTime"，这个方法接收一个字符串参数，并将这个参数值赋给 "time" 属性
   public void setTime(String time) {
   this.time = time;
   }
   
   // 定义了一个公共方法 "getDoid"，这个方法返回 "Doid" 属性的值
   public String getDoid() {
   return Doid;
   }
   
   // 定义了一个公共方法 "setDoid"，这个方法接收一个字符串参数，并将这个参数值赋给 "Doid" 属性
   public void setDoid(String doid) {
   Doid = doid;
   }
   
   // 定义了一个公共方法 "getPid"，这个方法返回 "Pid" 属性的值
   public String getPid() {
   return Pid;
   }
   
   // 定义了一个公共方法 "setPid"，这个方法接收一个字符串参数，并将这个参数值赋给 "Pid" 属性
   public void setPid(String pid) {
   Pid = pid;
   }
}