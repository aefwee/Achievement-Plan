API第一部分

一.API的使用

API(Application Programming Interface)：应用程序编程接口。

Java API：指的是JDK中提供的各种功能的Java类，这些类将底层的实现封装了起来。

调用方法时，如果方法有明确的返回值，我们用变量接收，可以手动完成，也可以用快捷键（Ctrl+Alt+V）的方式完成。

二.String类

1.String概述：String类在java.lang包下，所以使用的时候不用导包。

String类代表字符串，Java程序中的所有字符串文字（例如“abc”）都被实现为此类的实例，也就是说，Java程序中所有的双引号字符串，都是String类的对象。

字符串的特点：

字符串不可变，它们的值在创建后不能被更改。

虽然String类的值是不可变的，但是它们可以被共享。

字符串效果上相当于字符数组（char[ ]）但是底层原理是字节数组（byte [ ]）。

2.String构造方法

方法名                                说明

public String()                    创建一个空白字符串对象，不含任何内容

public String(char[] chs)       根据字符数组的内容，来创建字符串对象

public String(byte[] bys)       根据字节数组的内容，来创建字符串对象

String s= “abc”                   直接赋值的方式创建字符串对象，内容就是abc

3.String对象的特点

通过new创建的字符串对象，每一次new都会申请一个内存空间，虽然内容相同，但是地址值不同。

以“”方式给出的字符串，只要字符串列相同（顺序和大小写），无论在程序代码中出现几次，

JVM（虚拟机）都只会建立一个String对象，并在字符串池中维护。

4.字符串的比较

使用 == 做比较

基本类型：比较的是数据值是否相同。

引用类型：比较的是地址值是否相同。

字符串是对象，它比较内容是否相同，是通过一个方法equals()来实现的

public boolean equals(Object anObject):将此字符串与指定对象进行比较。由于比较的是字符串对象，所以参数直接传递一个字符串。

5.遍历字符串

首先要能够获取字符串中的每一个字符

public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始的。

遍历字符串，其次要能获取到字符串的长度

public int length()：返回次字符串的长度。

数组的长度：数组名.length

字符串的长度：字符串对象.length()

6.用户登陆

需求：已知用户名和密码，用程序实现模拟用户登陆。共三次机会，登陆后，给出相应的提示。

思路：（1）已知用户名和密码，定义两个字符串即可。

（2）键盘输入要登陆的用户名和密码，用Scanner实现。

（3）拿键盘输入的用户名、密码与已知的用户名、密码进行比较，给出相应提示，字符串内容比较，用equals（）方法实现。

7.统计字符串次数

需求:键盘录入一个字符串,统计该字符串中大写字母字符,小写字姆字符,数字字符出现的次数(不考其他字符）。

思路:

①键盘录入一个字符串,用Scanner实现

②要统计三种类型的字符个数,需定义三个统计变量，初始值都为0

③遍历字符串,得到每个字符

④判断该字符属于哪种类型，然后对应类型的统计量+ 1

    假如ch是一个字符,我要判断它属于大写字母，写字母,还是数字直接判断该字符是否在对应的范围即可

          ●大写母: ch>='A' &&ch<='Z'

          ●小写字母: ch>='a' &&ch<='z'

          ●数字: ch>='0' &&ch<='9'

⑤输出三种类型的字符个数

8.字符串拼接

需求:定义一个方法,把int数组中的数据按照指定的格式拼接成一个字符串返回, 调用该方法,

在控制台输出结果。例如，数组为int[ ]arr= {1,2,3};，执行方法后的输出结果为: [1,2, 3]

思路:

①定义义一个int型的数组,静态初始化完成数组元素的初始化

②定义一个方法,用于把int数组中的数据按照指定格式拼接成一个字符串返回。返回值类型String,参数列表int[] arr。

③方法中遍历数组,按照要求进行拼接

④调用方法,用一个变量接收结果

⑤输出结果

9.字符串反转

需求:定义一个方法,实现字符反转。键盘录入一个字符串，调用该方法后，在控制台输出结果

例如，键盘录入abc,输出结果cba

思路:

①键盘录入一个字符串,用Scanner实现

②定义一个方法，实现字符串反转。返回值类型String，参数String s

③在方法中把字符串倒着遍历，然后把每一个得到的字符拼接成一个字符返回

④调用方法,用一个变量接收结果

⑤输出结果

三.StringBuilder类

1.StringBuilder概述

StringBuilder是一个可变的字符串类，我们可以把它看成一个容器。

这里的可变指的是StringBuilder对象中的内容是可变的。

String和StringBuilder的区别：

String内容是不可变的；StringBuilder内容是可变的。

2.StringBuilder的构造方法

方法名：public StringBuilder()   说明：创建一个空白可变字符串对象，不含任何内容。

方法名：public StringBuilder(String str)    说明：根据字符串的内容，来创建可变字符串对象。

3.StringBuilder的添加和反转方法

方法名：public StringBuilder append(任意类型)   说明：添加数据，并返回对象本身。

方法名：public StringBuilder reverse()    说明：返回相反的字符序列。

例如：StringBuilder sb = new StringBuilder();

         sb.append(“hello”).append(“world”).append(100);

         System.out.println(sb);

         sb.reverse();

         System.out.println(sb);

输出：helloworld100

         001dlrowolleh

4.StringBuildr和String相互转换

（1）StringBuilder转化为String：

public String toString():通过toString()就可以实现把 StringBuilder转化为String

StringBuilder sb= new StringBuilder();

String s = sb.toString();

（2）String转化为StringBuilder：public StringBuilder(String s)

String s=“hello”;

StringBuilder sb = new StringBuilder(s);

四.ArrayList集合

1.集合基础

集合类的特点：提供一种存储空间可变的存储模型，存储的数据容量可以发生改变。

ArrayList<E>：可调整大小的数组实现；  <E>：是一种特殊的数据类型，泛型。

2.ArrayList构造方法和添加方法

方法名                                                            说明

public ArrayList()                                创建一个空的集合对象

public boolean add(E e)                       将指定元素追加到此集合到末尾

public void add(int index, E element)      在此集合中的指定位置插入指定的元素

3.ArrayList集合常用方法

方法名                                                            说明

public boolean remove(Object o)               删除指定的元素，返回删除是否成功

public E remove(int index)                       删除指定索引处的元素,返回被删除的元素

public E set(int index,E element)              修改指定索引处的元素,返回被修改的元素

public E get(int index)                            返回指定索引处的元素

public int size()                                      返回集合中的元素的个数

4.案例：存储字符串并遍历

需求:创建一个存储字符串的集合，存储3个字符串元素，使用程序实现在控制台遍历该集合

思路:

①创建集合对象

②集合中添加字符串对象

③遍历集合,首先要能够获取到集合中的每一 个元素，这个通过get(int index)方法实现

④遍历集合,其次要能够获取到集合的长度,这个通过 size（）方法实现

⑤遍历集合的通用格式

        for(int i=0; i<集合对象.size0;i+ +){
                  集合对象.get(i)   就是指定索引处的元素

           }

5.存储学生对象并遍历

需求:创健一个存储学生对象的集合,存储3个学生对象，使用程序实现在控制台遍历该集合

思路:

①定义学生类

②创建集合对象

③创建学生对象

④添加学生对象到集合中

⑤遍历集合,采用通用遍历格式实现

6.存储学生对象并遍历

需求:创建一个存储学生对象的集合,存储3个学生对象,使用程序实现在控制台遍历该集合

学生的姓名和年龄来自于键盘录入

思路:

①定义学生类，为了键盘录入数据方便，把学生类中的成员变量都定义为String型

②创建集合对象

③键盘录入学生对象所需要的数据

④创键学生对象,把键盘录入的数据赋值给学生对象的成员变量

⑤往集合中添加学生对象

⑥遍历集合,采用通用遍历格式实现
