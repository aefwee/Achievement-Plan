一.Lambda表达式

1.体验Lambda表达式

需求:启动一个线程,在控制台输出一句话:多线程程序启动了

方式1:

●定义一个类MyRunnable实现Runnable接口, 写run()方法

●创建MyRunnable类的对象

●创建Thread类的对象，把MyRunnable的对象作为构造参数传递

●启动线程

方式2:

●匿名内部类的方式改进

new Thread(new Runnable() {

@Override

public void run() {

System.out.println(“多线程程序启动了“); 

}

}).start();

方法形式参数为空，说明调用方法时不需要传递参数。

方法返回值类型位void时，说明方法执行没有结果返回。

方法体中的内容，是我们具体要做的事。

方式3:

●Lambda表达式的方式改进

new Thread(()-> {

System.out.println("多线程程序启动了“);

}).start(); 

() ：里面没有内容，可以看成是方法形式参数为空。

->：用箭头指向后面要做的事。

{ }：包含一段代码，称之为代码块，可以看成是方法体中的内容。


组成Lambda表达式的三要素：形式参数，箭头，代码块。

Lambda表达式的格式

●格式: (形式参数)-> {代码块}

●形式参数:如果有多个参数，参数之间用逗号隔开;如果没有参数,留空即可

●->:由英文中画线和大于符号组成，固定写法。代表指向动作

●代码块:是我们具体要做的事情，也就是以前我们写的方法体内容


Llambda表达式的使用前提：

有一个接口；

接口中有且只有一个抽象方法。


2. Lambda表达式的省略模式

省略规则:

●参数类型可省略。 但是有多个参数的情况下，不能只省略一个

●如果参数有且仅有一个，那么小括号可以省略

●如果代码块的语句只有一条，可以省略大括号和分号，甚至是return。


3. Lambda表达式的注意事项

注意事项:

●使用Lambda必须要有接口,并且要求接口中有且仅有一个抽象方法

●必须有上下文环境,能推出Lambda对应的接口

根据局部变量的赋值得知Lambda对应的接口: Runnable r= () -> System.out.println("Lambda表达式");

根据调用方法的参数得知Lambda对应的接口: new Thread(() -> System.out.println("Lambda表达式" ).start();


4. Lambda表达式和匿名内部类的区别

所需类型不同：

●匿名内部类:可以是接口，也可以是抽象类可以具体类

●Lambda表达式:只能是接口

使用限制不同：

●如果接口中有仅有一个抽象方法,可以用Lambda表达式，可以使用匿名内部类

●如果接口中多于一个抽象方法,只能使用匿名内部类，而不能使用Lambda表达式

实现原理不同：

●匿名内部类: 编译之后，产生一个单独的.class字节码文件。

●Lambda表达式:编译之后,没有一个单独的.class字节码文件。对应的字节码在运行的时候动态生成。


二.接口新特性

1.接口组成更新概述

接口的组成：

●常量

public static final

●抽象方法

public abstract

●默认方法(Java 8)

●静态方法(Java 8)

●私有方法(Java9)


2.接口中默认方法

接口中默认方法的定义格式:

●格式: public default 返回值类型 方法名(参数列表){ }

●范例: public default void show3(){ }

接口中默认方法的注意事项:

●默认方法不是抽象方法， 所以不强制被重写。但是可以被重写，写的时候去掉default关键字

●public可以省略, default不能省略


3.接口中静态方法

接口中静态方法的定义格式:

●格式: public static 返回值类型 方法名(参数列表){ }

●范例: public static void show() { }

接口中静态方法的注意事项:

●静态方法只能通过接口名调用，不能通过实现类名或者对象名调用

●public可以省略, static不能省略


4.接口中私有方法

接口中私有方法的定义格式:

●格式1: private 返回值类型 方法名(参数列表){ }

●范例1: private void show(){ }

●格式2: private static 返回类型 方法名名(参数列表){ }

●范例2: private static void method(){ }

接口中私有方法的注意事项:

●默认方法可以调用私有的静态方法和非静态方法

●静态方法只能调用私有的静态方法


三.方法引用

1.方法引用符

方法引用符

●::该符号为引用运算符，而它所在的表达式被称为方法引用。

回顾一下我们在体验方法引用中的代码：

●Lambda表达式: usePrintable(s -> System.out.println(s));

分析:拿到参数s之后通过Lambda表达式，传递给Systerm.out.println方法去处理

●方法引用: usePrintable(System.out::printIn);

分析:直接使用System.out中的 println方法来取代Lambda,代码更加的简洁

推导与省略：

●如果使用Lambda, 那么根据”可推导就是可省略”的原则，无需指定参数类型,也无需指定的重载形式,它们都将被自动推导

●如果使用方法引用，是同样可以根据上文进行推导

●方法引用是Lambda的孪生兄弟


2.引用类方法

引用类方法，其实就是引用类的静态方法

● 格式:类名::静态方法

●范例: Integer::parseInt

Integer类的方法: public static int parselnt(String s)将此String转换为int类型数据

练习:

●定义一个接口(Converter), 里面定义一个抽象方法

int convert(String s);

●定义一个测试类(ConverterDemo), 在测试类中提供两个方法

一个方法是: useConverter(Converter d)

一个方法是主方法,在主方法中调用useConverter方法


3.引用对象的实例方法

引用对象的实例方法,其实就是引用类中的成员方法

●格式: 对象::成员方法

●范例: "HelloWorld"::toUpperCase

String类中的方法: public String toUpperCase()，将此String所有字符转换为大写

练习:

●定义一个类(PrintString), 里面定义一个方法

public void printUpper(String s):把字符串参数变成大写的数据,然后在控制台输出

●定义一个接口(Printer)，里面定义一个抽象方法

void printUpperCase(Strings)

●定义一个测试类(PrinterDemo),在测试类中提供两个方法

一个方法是: usePrinter(Printer p)

一个方法是主方法，在方法中调用usePrinter方法


4.引用类的实例方法

引用类的实例方法，其实就是引用类中的成员方法

●格式: 类名::成员方法

●范例: String::substring

String类中的方法: public String substring(int beginIndex, int endIndex)

从beginIndex开始到endIndex结束，截取字符串。返回一个子串，子串的长度为endIndex-beginIndex

练习：

●定义一个接口(MyString)，里面定义一个抽象方法:

String mySubString(String s, int x, int y);

●定义一个测试类(MyStringDemo), 在测试类中提供两个方法

一个方法是: useMyString(MyString my)

一个方法是主方法,在主方法中调用useMyString方法


5.引用构造器

引用构造器，其实就是引用构造方法

●格式:类名::new

●范例: Student::new

练习：

●定义一个类(Student), 里面有两个成员变量(name,age)

并提供无参构造方法和带参构造方法,以及成员变量对应的get和set方法

●定义一个接口(StudentBuilder), 里面定义一个抽象方法

Student build(String name, int age);

●定义一个测试类(StudentDemo), 在测试中提供两个方法

一个方法是: useStudentBuilder(StudentBuilders)

一个方法是主方法，在主方法中调用useStudentBuilder方法


四.函数式接口

1.函数式接口概述

函数式接口：有且仅有一个抽象方法的接口

Java中的函数式编程体现就是Lambda表达式，所以函数式接口就是可以适用于Lambda使用的接口

只有确保接口中有且仅有一个抽象方法, Java中的Lambda才能顺利地进行推导

如何检测一个接口是不是函数式接口呢?

@Functionallnterface

●放在接口定义的上方:如果接口是函数式接口，编译通过;如果不是，编译失败。

注意：

我们自己定义函数式接口的时候，@Functionallnterface是可选的, 就算我不写这个注解，只要保证满足函数式接口定
义的条件,也照样是函数式接口。 但是，建议加上该注解。


2.函数式接口作为方法的参数

●定义一个类(RunnableDemo), 在类中提供两个方法
一个方法是: startThread(Runnable r) 方法参数Runnable是一个函数式接口
一个方法是主方法，在方法中调用startThread方法
如果方法的参数是一个函数式接口， 我们可以使用Lambda表达式作为参数传递
●startThread(0 -> System.out.println(Thread.currentThread().getName() + "线程启动了));

3.函数式接口作为方法的返回值
需求：
定义一个类(ComparatorDemo),在类中提供两个方法

一个方法是: Comparator <Sting> getComparator() 方法返回值Comparator是一个函数式接口

一个方法是主方法，在方法中调用getComparator方法

如果方法的返回值是一个函数式接口, 我们可以用Lambda表达式作为结果返回

●private static Comparator <String> getComparator(){

return (s1, s2) -> s1.length() - s2.length();

}


4. Supplier接口

Supplier<T>:包含一个无参的方法

●T get():获得结果

●该方法不需要参数， 它会按照某种实现逻辑(由Lambda表达式实现)返回一个数据

●Supplier<T>接口也被称为生产型接口，如果我们指定了接口的范型是什么类型,那么接口中的get方法就会生产什么类
型的数据供我们使用。


5. Consumer接口

Consumer<T>:包含两个方法

●void accept(T t):对给定的参数执行此操作

default Consumer<T> andThen(Consumer after):返回一个组合的Consumer,依次执行此操作,然后执行after操作

●Consumer<T> 接口也被称为消费型接口,它消费的数据的数据类型由泛型指定。


6. Predicate接口

Predicate<T>:常用的四个方法

●boolean test(T t): 对给定的参数进行判断(判断逻辑由Lambda表达式实现)，返回一个布尔值

●default Predicate<T> negate():返回一个逻辑的否定，对应逻辑非

default Predicate<T> and(Predicate other):返回一个组合判断，对应短路与

●default Predicate <T> or(Predicate other):返回一个组合判断，对应短路或

Predicate<T>接口通常用于判断参数是否满足指定的条件 

练习：

●String[] strArray= {"林青霞,30", "柳岩,34", "张曼玉35", "貂蝉,31", "王祖贤,33"};

●字符串数组中有多条信息,请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中,并遍历ArrayList集合

●同时满足如下要求:姓名长度大于2;年龄大于33

public class PredicateTest {

    public static void main(String[] args)[

        String[] strArray = {"林青霞,30", "柳岩,34", 张曼玉,35"，貂蝉,31", "王祖贤,33"};

        ArrayList<String> array = myFilter(strArray, s -> s.split(",")[0]. length() > 2,

            s -> Integer . parseInt(s.split(",")[1]) > 33);

            for (String str : array) {

                System. out . println(str);

            }

    }

//通过Predicate接口的拼装将符合要求的字符串筛选到集合Arraylist中

    private static ArrayList<String> myFilter(String[ ] strArray, Predicate<String> pre1, Predicate<String> pre2){

//定义一个集合

        ArrayList<String> array = new ArrayList<String>();

//遍历数组

        for (String str : strArray) {

            if (pre1. and(pre2).test(str)) {

                array. add(str);

            }

        }

        return array;

    }

} 


7. Function接口

Function<T,R>:常用的两个方法

●R apply(T t):将此函数应用于给定的参数

●default <V> Function andThen(Function after):返回一个组合函数，先将该函数应用于输入，然后将after函数应用于结果

●Function<T,R>接口通常用于对参数进行处理，转换(处理逻辑由Lambda表达式实现),然后返回一个新的值


五.Stream流

1.体验Stream流

需求:按照下面的要求完成集合的创建和遍历

●创建一个集合,存储多个字符串元素

●把集合中所有以"张"开头的元素存储到一个新的集合

●把"张"开头的集合中的长度为3的元素存储到一个新的集合

●遍历上一步得到的集合

使用Stream流的方式完成过滤操作：

●list.stream().filter(s -> s.startsWith(“张”)).filter(s -> s.length() == 3).forEach(System.out::printn);

● 直接阅读代码的字面意思即可完美展示无关逻辑方式的语义:生成流、过滤姓张、过滤长度为3、逐一打印

● Stream流把真正的函数式编程风格引入到Java中


2. Stream流的生成方式

Stream流的使用

●生成流

通过数据源(集合，数组等)生成流

list.stream()

●中间操作

一个流后面可以跟随零个或多个中间操作,其目的主要是打开流，做出某种程度的数据过滤/映射,然后返回一个新的流，
交给下一个操作使用。

filter()

●终结操作

一个流只能有一个终结操作， 当这个操作执行后，流就被使用“光”了,无法再被操作。所以这必定是流的最后一个操作

forEach()

Stream流的常见生成方式

●Collection体系的集合可以使用默认方法stream()生成流

default Stream<E> stream()

●Map体系的集合间接的生成流

●数组可以通过Stream接口的静态方法of(T… values)生成流


3. Stream流的常见中间操作方法

●Stream<T> filter(Predicate predicate):用于对流中的数据进行过滤

Predicate接口中的方法

boolean test(T t):对给定的参数进行判断，返回一个布尔值

●Stream<T> limit(long maxSize):返回此流中的元素组成的流，截取前指定参数个数的数据

●Stream<T> skip(long n):跳过指定参数个数的数据,返回由该流的剩余元素组成的流

●static <T> Stream<T> concat(Stream a, Stream b): 合并a和b两个流为一个流

●Stream<T> distinct():返回由该流的不同元素(根据Object.equals(Object)) 组成的流

●Stream<T> sorted():返回由此流的元素组成的流，根据自然顺序排序

●Stream<T> sorted(Comparator comparator): 返回由该流的元素组成的流，根据提供的Comparator进行排序

●<R> Stream<R> map(Function mapper): 返回由给定函数应用于此流的元素的结果组成的流

Function接口中的方法 R apply(T t)

●IntStream mapTolnt(TolntFunction mapper): 返回一个IntStream其中包括将给定函数应用于此流的元素的结果。


4. Stream流的常见终结操作方法

Stream流的常见终结操作方法

●void forEach(Consumer action)：对此流的每个元素执行操作

Consumer接口中的方法

●void accept(T t)：对给定的参数执行此操作

long count()：返回此流中的元素数


5. Stream流的收集操作

对数据使用Stream流的方式操作完毕后，我想把流中的数据收集到集合中，该怎么办呢?

Stream流的收集方法

●R collect(Collector collector)

●但是这个收集方法的参数是一个Collector 接口

工具类Collectors提供了具体的收集方式

●public static <T> Collector toList():把元素收集到List集合中

●public static <T> Collector toSet():把元素收集到Set集中

●public static Collector toMap(Function keyMapper,Function valueMapper):把元素收集到Map集合中

