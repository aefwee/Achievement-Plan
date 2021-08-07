一.File类

1.File类概述和构造方法

File:它是文件和目录路径名的抽象表示

●文件和目录可以通过File封装成对象的

●对于File而言,其封裝的并不是一个真正存在的文件,仅仅是一个路径名而已。它可以是存在的，可以是不存在的。将来是要通过具体的操作把这个路径的内容转换为具体存在的。

方法名                          	 说明

File(String pathname)	                通过将给定的路径名字符串转换为抽象路径名来创建新的File实例

File(String parent, String child)	从父路径名字符串和子路径名字符串创建新的File实例

File(File parent, String child)	        从父抽象路径名和子路径名字符串创建新的File实例

2. File类创建功能

方法名	                                 说明

public boolean createNewFile()	 当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件

public boolean mkdir()	         创建由此抽象路径名命名的目录

public boolean mkdirs()	          创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录

3. File类判断和获取功能

方法名	                                  说明

public boolean isDirectory()	  测试此抽象路径名表示的File是否为目录

public boolean isFile()	          测试此抽象路径名表示的File是否为文件

public boolean exists()	          测试此抽象路径名表示的File是否存在

public String getAbsolutePath()	  返回此抽象路径名的绝对路径名字符串

public String getPath()	          将此抽象路径名转换为路径名字符串

public String getName()    	  返回由此抽象路径名表示的文件或目录的名称

public String[] list()	          返回此抽象路径名表示的目录中的文件和目录的名称字符串数组

public File[] listFiles()	  返回此抽象路径名表示的目录中的文件和目录的File对象数组

4. File类删除功能

方法名	                      说明

public boolean delete()	   删除由此抽象路径名表示的文件或目录

绝对路径和相对路径的区别:

●绝对路径:完整的路径名，不需要任何其他信息就可以定位它所表示的文件。例如: E:\itcast\java.txt

●相对路径:必须使用取自其他路径名的信息进行解释。例如: myFile\java.txt

删除目录时的注意事项:

●如果一个目录中有内容(目录, 文件),不能直接删除。应该先删除目录中的内容，最后才能删除目录

二.递归

1.递归

递归概述:以编程的角度来看，递归指的是方法定义中调用方法本身的现象

递归解决问题的思路:
把一个复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解
递归策略只需少量的程序就可描述出解题过程所需要的多次重复计算

递归解决问题要找到两个内容:

●递归出口:否则会出现内存溢出

●递归规则: 与原问题相似的规模较小的问题

三.IO字节流

1.IO流概述和分类

IO流概述:

●IO: 输入/输出(Input/Output)

●流: 是一种抽象概念,对数据传输的总称。也就是说数据在设备间的传输称为流，流的本质是数据传输

●IO流就是用来处理设备间数据传输问题的

常见的应用:文件复制;文件上传;文件下载

IO流分类:

●按照数据的流向

输入流:读数据

输出流:写数据

●按照数据类型来分

字节流：

字节输入流;字节输出流

字符流：

字符输入流;字符输出流

一般来说， 我们说IO流的分类是按照数据类型来分的
那么这两种流都在什么情况下使用呢?

●如果数据通过Window自带的记事本软件打开，我们还可以读懂里面的内容，就使用字符流,
否则使用字节流。如果你不知道该使用哪种类型的流，就使用字节流。

2.字节流写数据

字节流抽象基类

●InputStream: 这个抽象类是表示字节输入流的所有类的超类

OutputStream:这个抽象类是表示字节输出流的所有类的超类

●子类名特点:子类名称都是以其父类名作为子类名的后缀

FileOutputStream:文件输出流用于将数据写入File

●FileOutputStream(String name):创建文件输出流以指定的名称写入文件

使用字节输出流写数据的步骤:

●创建字节输出流对象(调用系统功能创建了文件，创建字节输出流对象，字节输出流对象指向文件)
调用字节输出流对象的写数据方法

●释放资源(关闭文件输出流并释放与此流相关联的任何系统资源)

3.字节流写数据的3种方式

方法名	                         说明

void write(int b)	将指定的字节写入此文件输出流，一次写一个字节数据

void write(byte[] b)	将b.length字节从指定的字节数组写入此文件输出流，一次写一个字节数组数据

void write(byte[ b, int off, int len)	将len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流，一次写一个字节数组的部分数据。

4.字节流写数据加异常处理

finally:在异常处理时提供finally块来执行所有清除操作。比如说IO流中的释放资源

特点:被finally控制的语句-定会执行,除非JVM退出

try{

可能出现异常的代码;

}catch(异常类名变量名){

异常的处理代码;

}finally{

执行所有清除操作:

}

5.字节流读数据(一次读一个字节数据)

需求:把文件fos.txt中的内容读取出来在控制台输出

FileInputStream:从文件系统中的文件获取输入字节

●FileInputStream(String name):通过打开与实际文件的连接来创建一个FileInputStream,该文件由
文件系统中的路径名name命名

使用字节输入流读数据的步骤:

①创建字节输入流对象
②调用字节输入流对象的读数据方法
③释放资源

6.字节缓冲流

●BufferOutputStream:类实现缓冲输出流。通过设置这样的输出流，应用程序可以向底层输出流写入字节，而不必为
写入的每个字节导致底层系统的调用

●BufferedInputStream:创健BufferedInputStream将创健一 个内部缓冲区数组。 当从流中读取或跳过字节时，内部缓
冲区将根据需要从所包含的输入流中重新填充，一次很多字节

构造方法:

●字节缓冲输出流: BufferedOutputStream(OutputStream out)

●字节缓冲输入流: BufferedInputStream(InputStream in)

为什么构造方法需要的是字节流，而不是具体的文件或者路径呢?

●字节缓冲流仅仅提供缓冲区，而真正的读写数据还得依据基本的字节流对象进行操作

四.IO字符流

1.为什么会出现字符流

由于字节流操作中不是特别的方便，所以Java就提供字符流

●字符流=字节流+编码表

用字节流复制文本文件时，文本文件也会有中文,但是没有问题，原因是最终底层操作会自动进行字节拼接成
中文,如何识别是中文的呢?

●汉字在存储的时候，无论选择哪种编码存储,第一个字都是负数。

2.编码表

基础知识:

●计算机中储存的信息都是用二进制数表示的;我们在屏幕上看到的英文、汉字等字符是二进制数转换之后的结果

●按照某种规则，将字符存储到计算机中,称为编码。反之存储在计算机中的二进制数按照某种规则解析显示出来，称为解码。这里强调一下: 按照A编码存储,必须按照A编码解析,这样才能显示正确的文本符号。否则就会导致乱码现象

字符编码:就是一套自然语言的字符与二进制数之间的对应规则(A,65)

字符集:

●是一个系统支持的所有字符的集合,包括各国家文字、标点符号、图形符号、数字等

●计算机要准确的存储和识别各种字符集符号，就要进行字符编码，一套字符集必然至少有一套字符编码。
常见字符集有ASCII字符集、GBXXX字符集Unicode字符集等

ASCI字符集:

●ASCII(American Standard Code for Information Interchange,美国信息交换标准代码)：是基于拉丁字母的一套电脑编码系统,用于现代英语，主要包括控制字符(回车键、退格、换行键等)和可显示字符(英文大小写字符、阿拉伯数字和西文符号)。
基本的ASCII字符集,使用7位表示一个字符,共128字符。ASCII的扩展字符集使用8位表示一个字符,共
256字符，方便支持欧洲常用字符。是一个系统支持的所有字符的集合，包括各国家文字标点符号、图形符号、数字等。

GBXXX字符集:

●GB2312:简体中文码表。一个小于127的字符的意义与原来相同,两个大于127的字符连在一起时，就表示一个汉字，这样大约可以组合了包含7000多个简体汉字，此外数学符号、罗马希腊的字母、日文的假名等都编进去了,在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的”全角”字符，而原来在127号以下的那些就叫“半角”字符了。

●GBK:最常用的中文码表。在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了
21003个汉字，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等

●GB18030:最新的中文码表。收录汉字70244个，采用多字节编码,每个字可由1个、2个或4个字节组成。
支持中国国内少数民族的文字,同时支持繁体汉字以及日韩汉字等。

Unicode字符集:

为表达任意语言的任意字符设计，业界的一种标准，也称为统一码、标准万国码。最多使用4个字
节的数字来表达每个字母、符号,或者文字。有三种编码方案, UTF-8、UTF-16和UTF32。最为常用的UTF- 8编码。

●UTF-8编码: 可以来表示Unicode标准中任意字符,它是电子邮件、网页及其他存储或传送文字的应用
中，优先采用的编码。互联网工程工作小组(IETF) 要求所有互联网协议都必需支持UTF -8编码。它使用
一至四个字节为每个字符编码。

编码规则: 

128个US-ASCI字符,只需一个字节编码
拉丁文等字符，需要二个字节编码
大部分常用字(含中文) , 使用三个字节编码
其他极少使用的Unicode辅助字符，使用四字节编码

小结:采用何种规则编码，就要采用对应规则解码，否则就会出现乱码。

3.字符串中的编码解码问题

编码:

●byte[] getBytes():使用平台的默认字符集将该String编码为一系列字节,结果存储到新的字节数组中

●byte[] getBytes(String charsetName):使用指定的字符集将该String编码为一系列字节,将结果存储到新的字节数组中

解码：

●String(byte[] bytes):通过使平台的默认字符集解码指定的字节数组来构造新的String

●String(byte[] bytes, String charsetName):通过指定的字符集解码指定的字节数组来构造新的String

4.字符流中的编码解码问题

字符流抽象基类：

●Reader:字符输入流的抽象类

●Writer: 字符输出流的抽象类

字符流中和编码解码问题相关的两个类:

●InputStreamReader

●OutputStreamWriter

5.字符流写数据的5种方式

方法名	                                    说明

void write(int c)	                       写一个字符

void write(char[] cbuf)                 	写入一个字符数组

void write(char[] cbuf, int off, int len)	写入字符数组的一部分

void write(String str)	                        写一个字符串

void write(String str, int off, int len)	写一个字符串的一部分

方法名	   说明

flush()	刷新流，还可以继续写数据

close()	关闭流，释放资源，但是在关闭之前会先刷新流。一旦关闭，就不能再写数据

6.字符流读数据的两种方式

方法名	                说明

int read()	       一次读一个字符数据

int read(char[] chuff)	一次读一个字符数组数据

7.字符缓冲流

字符缓冲流:

●BufferedWriter：将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入，可
以指定缓冲区大小，或者可以接受默认大小。默认值足够大，可用于大多数用途。

●BufferedReader：从字符输入流读取文本,缓冲字符,以提供字符，数组和行的高效读取，可以指定
缓冲区大小，或者可以使用默认大小。默认值足够大， 可用于大多数用途。

构造方法:

●BufferedWriter(Writer out)

●BufferedReader(Reader in)

8.字符缓冲流特有功能

BufferedWriter:

●void newLine0:写一行分隔符，分隔符字符串由系统属性定义

BufferedReader: 

●public String readLine(): 读一行文字。结果包含行的内容的字符串,不包括任何行终止字符,如果流的结尾已经到达，则为null。

五.标准流和打印流

1.标准输入输出流

System类中有两个静态的成员变量:

public static final InputStreamin:标准输入流。通常该流对应于键盘输入或由主机环境或用户指定的另一个输入源

●public static final PrintStream out:标准输出流。通常该流对应于显示输出或由主机环境或用户指定的另一个输出目标

自己实现键盘录入数据:

oBufferedReader br = new BufferedReader(new InputStreamReader(System.in));

写起来太麻烦，Java就提供了一个类实现键盘录入：

●Scanner sc = new Scanner(System.in);

输出语句的本质:是一个标准的输出流

●PrintStream ps = System.out;

●PrintStream类有的方法，System.ou都可以使用

2.打印流

打印流分类:

●字节打印流: PrintStream

●字符打印流: PrintWriter

打印流的特点:

●只负责输出数据, 不负责读取数据

●有自己的特有方法

字节打印流：

●PrintStream(String fileName):使用指定的文件名创建新的打印流

●使用继承父类的方法写数据, 查看的时候会转码;使用自己的特有方法写数据，查看的数据原样输出

字符打印流PrintWriter的构造方法:

方法名	                                   说明

PrintWriter(String fileName)	           使用指定的文件名创建一个新的PrintWriter, 而不需要自动执行刷新

PrintWriter(Writer out, boolean autoFlush)	创建一个新的PrintWriter 。 out:字符输出流 ， autoFlush:一个布尔值，如果为真，则println, printf，或format方法将刷新输出缓冲区

输出流一般方法：ps.write()

特有方法：ps.print(); ps.println()


六.对象序列化流

1.对象序列化概述

对象序列化:就是将对象保存到磁盘中，或者在网络中传输对象

这种机制就是使用一个字节序列表示一个对象， 该字节序列包含:对象的类型、对象的数据和对象中存储的属性等信息

字节序列写到文件之后，相当于文件中持久保存了一个对象的信息

反之，该字节序列还可以从文件中读取回来，重构对象,对它进行反序列化

要实现序列化和反序列化就要使用对象序列化流和对象反序列化流:

对象序列化流: ObjectOutputStream

对象反序列化流: ObjectInputStream

2.对象序列化流

对象序列化流: ObjectOutputStream

●将Java对象的原始数据类型和图形写入OutputStream。可以使用ObjectInputStream读取 (重构)对象。可以通过使用流的文件来实现对象的持久存储。如果流是网络套接字流,则可以在另一个主机上或另一个进程中重构对象

构造方法:

●ObjectOutputStream(OutputStream out): 创建一个写入指定的OutputStream的ObjectOutputStream

序列化对象的方法:

●void writeObject(Object obj):将指定的对象写入ObjectOutputStream

注意：

一个对象要想被序列化，该对象所属的类必须实现Serializable接口

Serializable是一个标记接口，实现该接口，不需要重写任何方法。

3.对象反序列化流

对象反序列化流: ObjectInputStream

●ObjectInputStream反序列化先前使用ObjectOutputStream编写的原始数据和对象

构造方法:

●ObjectInputStream(InputStreamin): 创建从指定的InputStream读取的ObjectlnputStream

反序列化对象的方法:

●Object readObject0:从ObjectlnputStream读取一个对象

4.serialVersionUID和transient

用对象序列化流序列化了一个对象后,假如我们修改了对象所属的类文件,读取数据会不会出问题呢?

●会出问题， 抛出InvalidClassException异常  

如果出问题了，如何解决呢?

●给对象所属的类加一个serialVersionUID

private static final long serialVersionUID = 42L;

如果一个对象中的某个成员变量的值不想被序列化，又该如何实现呢?

●给该成员变量加transient关键字修饰， 该关键字标记的成员量不参与序列化过程


七.Properties类

1.Properties作为Map集合

Properties概述：

是一个Map体系的集合类

Properties可以保存到流中或从流中加载

Properties作为集合的特有方法:

方法名	                         说明

Object setProperty(String key, String value)，	设置集合的键和值，都是String类型，底层调用Hashtable方法put

String getProperty(String key)，	使用此属性列表中指定的键搜索属性

Set <String> stringPropertyNames()	，从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串

2.Properties和IO流结合的方法:

方法名	说明

void load(InputStream inStream)，	从输入字节流读取属性列表(键和元素对)

void load(Reader reader)，	从输入字符流读取属性列表(键和元素对)

void store(OutputStream out,String comment()，	将此属性列表(键和元素对)写入此Properties表中，以适合于使用load(InputStream)方法的格式写入输出字节流

void store(Writer writer, String comments)	，将此属性列表(键和元素对)写入此Properties表中，以适合使用load(Reader)方法的格式写入输出字符流
