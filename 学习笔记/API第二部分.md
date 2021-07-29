一.Math&System&Object类
1.Math类
Math包含执行基本数字运算的方法
没有构造方法，如何使用类中的成员呢?
看类的成员是否都是静态的，如果是，通过类名就可以直接调用。
Math类的常用方法：

方法名	                                  说明
public static int abs(int a)	        返回参数的绝对值
public static double ceil(double a)	返回大于或等于参数的最小double值，等于一个整数
public static double floor(double a)	返回小于或等于参数的最大double值，等于一个整数
public static int round(float a)	按照四舍五入返回最接近参数的int
public static int max(int a,int b)	返回两个int值中的较大值
public static int min(int a,int b)	返回两个int值中的较小值
public static double pow(double a,double b)	返回a的b次幂的值
public static double random(）         	返回值为double的正值，[0.0,1.0)
2.System类
System包含几个有用的类字段和方法，它不能被实例化。
System类的常用方法：

方法名	                                    说明
public static void exit(int status)	终止当前运行的Java虚拟机，非零表示异常终止
public static long currentTimeMillis()	返回当前时间(以毫秒为单位)
3.Object类
Object是类层次结构的根，每个类可以将Object作为超类。所有类都直接或者间接的继承自该类
构造方法: public Object()
回想面向对象中，为什么说子类的构造方法默认访问的父类无参构造方法?
因为它们的顶级父类只有无参构造方法

4.冒泡排序
如果有n个数据进行排序，总共需要比较n-1次。
每一次比较完毕，下一次的比较就会少一个数据参与。
Arrays:
该类包含用于操作数组的各种方法（如排序和搜索）。该类还包含一个静态工厂，可以将数组视为列表。
Arrays类的概述和常用方法
Arrays类包含用于操作数组的各种方法

方法名                          	说明
public static String toString(int[a])	 返回指定数组的内容的字符串表示形式
public static void sort(int] a)	        按照数字顺序排列指定的数组
工具类的设计思想：
构造方法用private修饰；
成员用public static 修饰。

二.基本类型包装类

1.基本类型包装类概述：

将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据。
常用的操作之一：用于基本数据类型与字符串之间的转换。

基本数据类型	包装类
byte	         Byte
short	         Short
int	         Integer
long	         Long
float	         Float
double	         Double
char	         Character
boolean   	 Boolean
2. Integer类的概述和使用

Integer:包装-个对象中的原始类型 int的值

方法名	                              说明
public Integer(int value)	根据int值创建Integer对象(过时)
public Integer(String s)	根据String值创建Integer对象(过时)
public static Integer valueOf(int i)	返回表示指定的int值的Integer实例
public static Integer valueOf(String s)	返回一个保存指定值的Integer对象String
3.int和String的相互转换

基本类型包装类的最见操作就是:基本本类型和字符之间的相互转换

int转换为String
public static String valueOf (int i):返回int参数的字符串表示形式。该方法是String中的方法
String转换为int
public static int parseInt (String s):字符串解析为int类型。该方法是Integer中的方法
4.自动装箱和拆箱

装箱:把基本数据类型转换为对应的包装型
拆箱:把包装类类型转换为对应的基本数据类型
Integer i = 100; //自动装箱
i += 200; //i=i+200; i+200自动拆箱;i=i+200;是自动装箱
注意:在使用包装类类型的时候，如果做操作,最好先判断否为null
我们推荐的是，只要是对象，在使用前就必须进行不为null的判断。

三.Data类

1.Data类概述

Data类代表了一个特定的时间，以毫秒为精度
Data () ：分配一个Data对象并对其进行初始化，以便它表示分配的时间，以最接近的毫秒为单位。
Data (long data)：分配一个Data对象，并将其初始化表示从标准基准时间即1970年1月1日00:00:00GMT起的指定毫秒数。

2.Date类的常用方法

方法名	                        说明
public long getTime()	         获取的是日期对象从1970年1月1日00:00:00到现在的毫秒值
public void setTime(long time)	设置时间，给的是毫秒值
3. SimpleDateFormat 类概述

SimpleDateFormat是一个具体的类 ，用于以区域设置敏感的方式格式化和解析日期。
日期和时间格式由日期和时间模式字符串指定，日期和时间模式字符中,从'A'到Z’以及从'a' 
到'z' 引号的字母被解释为表示日期或时间字符串的组件的模式字母。
SimpleDateFormat的构造方法：
 
方法名	                          说明
public SimpleDateFormat( )	   构造个SimpleDateFormat,使用默认模式和日期格式
public SimpleDateFormat(String pattern)	构造个SimpleDateFormat使用给定的模式和默认的日期格式
SimpleDateFormat格式化和解析日期：
1.格式化(从Date到String )
public final String format(Date date): 将日期格式化成日期/时间字符串

解析(从String 到 Date )
public Date parse(String source): 从给定的字符串的开始解析文本以生成日期
四.Calendar类

1.Calendar概述

Calendar类是一个抽象类， 可以为某一特定时刻和一组之间的转换的方法calendar fields 
如 ：YEAR， MONTH， DAY_ OF _MONTH，HOUR, 等等，
以及用于操纵该日历字段、如获取的日期下个星期。时间上的瞬间可以表示为毫秒值，该值与1970年1月1日oo: oo: oo.000 GMT (格里高利)的Epoch偏移。
该类还提供了用于在包外部实现具体日历系统的其他字段和方法。这些字段和方法定义为protected。
像其他语言环境敏感的类一样，Calendar提供了一个类方法，getInstance ，用于获取这种类型的一般有用的对象。Calendar的getInstance方法返回一个Calendar对象，其日历字段已使用当前日期和时间初始化:

Calendar rightNow = Calendar . getInstance ();
2.Calendar的常用方法

方法名	                                           说明
public int get(int field)	                    返回给定日历字段的值
public abstract void add(int field, int amount)	    根据日历的规则，将指定的时间量添加或减去给定的日历字段
public final void set(int year,int month,int date)	设置当前日历的年月日
