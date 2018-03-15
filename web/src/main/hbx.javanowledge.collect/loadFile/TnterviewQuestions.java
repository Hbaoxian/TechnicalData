package loadFile;

import java.util.Dictionary;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by huangbaoxian on 2018/3/9.
 */
public class TnterviewQuestions {


    /**
     * 1  java是值传递还是引用传递
     *
     *    基本类型是值传递，引用类型传递的是内存地址
     *
     *
     *
     * 2 java 线程池调度
     *
     *  corePoolSize 核心线程池大小
     *
     *  maxPoolSize  最大线程池
     *  当核心线程池满了之后，并且任务队列是满的，会继续创建线程池，知道达到 maxPoolSize
     *
     *  keepAliveTime
     *
     *   当已经执行过的线程空闲后，空闲时间小于keepAliveTime，又来了新的任务时，会直接启动该线程。

        当线程空闲时间达到keepAliveTime，该线程会退出，直到线程数量等于corePoolSize。

        如果allowCoreThreadTimeout设置为true，则所有线程均会退出直到线程数量为0
     *
     *
     *
     *
     *
     * 3 foreach 和 while的区别，在编译之后
     *
             两者的不同之处在于它们背后的运作方式。
             在while循环里，Perl会读入一行输入，把它存入某个变量并且执行循环主体。然后，它再回头去找其他的输入行。
             在foreach循环中，整行输入操作符会在列表上下文中执行（因为foreach需要逐行处理列表的内容）。在循环开始
             执行之前，它必须先将输入全部读进来。
             当输入大容量的文件时，使用foreach会占用大量的内存。两者的差异会十分明显。因此，最好的做法，通常是尽量
             使用while循环的简写，让它每次处理一行。
     *
     *
     *
     *
     *
     *
     * 4 线程池调优
     *
     *   1 核心线程池最小数 corepoolsize
     *
     *   2 最大线程池数量（一旦服务器成为瓶颈，向服务器增加负载时非常有害的；对于CPU密集型或IO密集型的机器增加线程数实际会降低整体的吞吐量；）
     *
     *   3 线程池任务任务大小
     *
     *   4 修改 ThreadPoolExecutor 线程池任务队列选择
     *
     *       SynchronousQueue
             如果ThreadPoolExecutor搭配的是SynchronousQueue，则线程池的行为和我们预期的一样，它会考虑线程数：如果所有的线程都在忙碌，而且池中的线程数尚未达到最大，则会为新任务启动一个新线程。然而这个队列没办法保存等待的任务：如果来了一个任务，创建的线程数已经达到最大值，而且所有的线程都在忙碌，则新的任务都会被拒绝，所以如果是管理少量的任务，这是个不错的选择，对于其他的情况就不适合了。

             无界队列
             如果ThreadPoolExecutor搭配的是无界队列，如LinkedBlockingQueue，则不会拒绝任何任务（因为队列大小没有限制）。这种情况下，ThreadPoolExecutor最多仅会按照最小线程数创建线程，也就是说最大线程池大小被忽略了。如果最大线程数和最小线程数相同，则这种选择和配置了固定线程数的传统线程池运行机制最为接近。

             有界队列
             搭配了有界队列，如ArrayBlockingQueue的ThreadPoolExecutor会采用一个非常负责的算法。比如假定线程池的最小线程数为4，最大为8所用的ArrayBlockingQueue最大为10。随着任务到达并被放到队列中，线程池中最多运行4个线程（即最小线程数）。即使队列完全填满，也就是说有10个处于等待状态的任务，ThreadPoolExecutor也只会利用4个线程。

            如果队列已满，而又有新任务进来，此时才会启动一个新线程，这里不会因为队列已满而拒接该任务，相反会启动一个新线程。新线程会运行队列中的第一个任务，为新来的任务腾出空间。

            这个算法背后的理念是：该池大部分时间仅使用核心线程（4个），即使有适量的任务在队列中等待运行。这时线程池就可以用作节流阀。如果挤压的请求变得非常多，这时该池就会尝试运行更多的线程来清理；这时第二个节流阀—最大线程数就起作用了。
     *
     *
     *
     *
     *
     *
     *
     * 5  线程池的最大线程数目根据什么确定
     *
     *    目前根据cpu资源来确认
     *
     *
     *
     * 6 动态代理的几种方式
     *
     *
     *
     * 7 HashMap的并发问题
     *
     *  hashMap在扩容的时候多线程操作有可能发生死锁
     *
     *
     *
     * 8 LinkedHashMap
     *  LinkedHashMap 是 HashMap 的一个子类，它保留插入的顺序，如果需要输出的顺序和输入时的相同，那么就选用 LinkedHashMap。
     *  LinkedHashMap 是 Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。此实现提供所有可选的映射操作，并允许使用 null
     *  值和 null 键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。
     *
     *  LinkedHashMap 实现与 HashMap 的不同之处在于，LinkedHashMap 维护着一个运行于所有条目的双重链接列表。此链接列表定义
     *  了迭代顺序，该迭代顺序可以是插入顺序或者是访问顺序。
     *
     *  根据链表中元素的顺序可以分为：按插入顺序的链表，和按访问顺序(调用 get 方法)的链表 那么调用get方法后，会将这次访问的元素
     *  移至链表尾部，不断访问可以形成按访问顺序排序的链表。
     *
     *
     *  9 反射的原理，反射创建类实例的三种方式是什么？
     *
     *  原理：Java反射主要是指程序可以访问、检测和修改它本身状态或行为的一种能力，是Java被视为动态（或准动态）
     *       语言的一个关键性质。这个机制允许程序在运行时透过Reflection APIs取得任何一个已知名称的class的内
     *       部信息，包括其modifiers（诸如public, static 等）、superclass（例如Object）、实现之interfaces
     *       （例如Cloneable），也包括fields和methods的所有信息，并可于运行时改变fields内容或唤起methods。
             Java反射机制容许程序在运行时加载、探知、使用编译期间完全未知的classes。换言之，Java可以加载一个
            运行时才得知名称的class，获得其完整结构。
     *
     *  1 对象的.getClass方法
     *
     *  2 类名.class方法
     *
     *  3 forName 方法，只要知道了类名就可以获取类的成员变量，公共方法，私有方法等
     *
     *   静态编译：在编译时确定类型，绑定对象,即通过。
         动态编译：运行时确定类型，绑定对象。动态编译最大限度发挥了java的灵活性，体现了多态的应用，用以降低类之间的藕合性
     *
     *   我们的源代码经过编译之后变成字节码，然后在JVM中运行时通过类加载器加载字节码在内存中生成Class类对象，这个Class类对
     *   象内包含有field对象（类的成员变量生成）、constructor对象（类的构造方法生成）和method对象（类的方法生成）。当我们
     *   拿到一个类或者对象的时候就可以通过反射对它们进行操作
     *
     *
     *
     *  10  cloneable 实现原理
     *
     *  实现了Cloneable clone接口， clone接口是根对象实现的接口，但是不实现Cloneable的clone的接口，对象调用clone接口的时
     *  候，是直接抛错的。对象实现clone接口的时候活生成一个新的实例对象，针对当前成员变量如果是基础变量，把当前对象值给复用，如
     *  果是针对引用对象，则把当前对象引用地址给复用过去
     *
     *  深浅拷贝：
     *
     *
     *
     *  11 java中NIO的使用
     *
     *
     *  12 hashtable和hashmap
     *
     *       HashMap是基于哈希表实现的，每一个元素是一个key-value对，其内部通过单链表解决冲突问题，
     *       容量不足（超过了阀值）时，同样会自动增长。
             HashMap是非线程安全的，只是用于单线程环境下，多线程环境下可以采用concurrent并发包下的concurrentHashMap。
             HashMap 实现了Serializable接口，因此它支持序列化，实现了Cloneable接口，能被克隆。
             HashMap存数据的过程是：
             HashMap内部维护了一个存储数据的Entry数组，HashMap采用链表解决冲突，每一个Entry本质上是一个单向链表。当准备添
             加一个key-value对时，首先通过hash(key)方法计算hash值，然后通过indexFor(hash,length)求该key-value对的存储
             位置，计算方法是先用hash&0x7FFFFFFF后，再对length取模，这就保证每一个key-value对都能存入HashMap中，当计算出
             的位置相同时，由于存入位置是一个链表，则把这个key-value对插入链表头。
             HashMap中key和value都允许为null。key为null的键值对永远都放在以table[0]为头结点的链表中。
             了解了数据的存储，那么数据的读取也就很容易就明白了


          13  Hashtable同样是基于哈希表实现的，同样每个元素是一个key-value对，其内部也是通过单链表解决冲突问题，
            容量不足（超过了阀值）时，同样会自动增长。
            Hashtable也是JDK1.0引入的类，是线程安全的，能用于多线程环境中。
            Hashtable同样实现了Serializable接口，它支持序列化，实现了Cloneable接口，能被克隆。


            区别：

            1    Hashtable继承自Dictionary类，而HashMap继承自AbstractMap类。但二者都实现了Map接口。
            2    线程安全性不同 Hashtable 中的方法是Synchronize的，而HashMap中的方法在缺省情况下是非Synchronize的。
            3    map是能存储null，table不能
            4    遍历内部实现方式不同 Hashtable、HashMap都使用了 Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。
            5   hash值不同，table是直接使用hashcode， map是自己计算的hash值
            6   内部初始化和和扩容方式不一样
                HashTable在不指定容量的情况下的默认容量为11，而HashMap为16，Hashtable不要求底层数组的容量一定要为2的整数次幂，而HashMap则要求一定为2的整数次幂。
                Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。
                Hashtable和HashMap它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable中hash数组默认大小是11，增加的方式是 old*2+1。
     *
     *
     *
     *   14   arraylist和linkedlist区别及实现原理
     *
     *        LinkedeList和ArrayList都实现了List接口，但是它们的工作原理却不一样。它们之间最主要的区别在于ArrayList是可改变大小的数组，
     *        而LinkedList是双向链接串列(doubly LinkedList)。ArrayList更受欢迎，很多场景下ArrayList比LinkedList更为适用。这篇文章
     *        中我们将会看看LinkedeList和ArrayList的不同，而且我们试图来看看什么场景下更适宜使用LinkedList，而不用ArrayList。
     *
     *


             LinkedList和ArrayList的区别
             LinkedList和ArrayList的差别主要来自于Array和LinkedList数据结构的不同。如果你很熟悉Array和LinkedList，你很容易得出下面的结论：

             1) 因为Array是基于索引(index)的数据结构，它使用索引在数组中搜索和读取数据是很快的。Array获取数据的时间复杂度是O(1),但是要删除数据却是开销很大的，因为这需要重排数组中的所有数据。

             2) 相对于ArrayList，LinkedList插入是更快的。因为LinkedList不像ArrayList一样，不需要改变数组的大小，也不需要在数组装满的时候要将
             所有的数据重新装入一个新的数组，这是ArrayList最坏的一种情况，时间复杂度是O(n)，而LinkedList中插入或删除的时间复杂度仅为O(1)。ArrayList在插入数据时还需要更新索引（除了插入数组的尾部）。

             3) 类似于插入数据，删除数据时，LinkedList也优于ArrayList。

             4) LinkedList需要更多的内存，因为ArrayList的每个索引的位置是实际的数据，而LinkedList中的每个节点中存储的是实际的数据和前后节点的位置。
             *
     *
     *      15   反射中，Class.forName和ClassLoader区别
     *
             *      java中class.forName()和classLoader都可用来对类进行加载。
                    class.forName()前者除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。
                    而classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
                    Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象
             *
             *
     *
     *      16 String，Stringbuffer，StringBuilder的区别？
     *         String 字符串常量
     *         Stringbuffer 字符串变量 线程安全 使用 Synchronous锁
     *         StringBuilder 字符串变量 线程不安全
     *
     *
     *
     *     17  有没有可能2个不相等的对象有相同的hashcode
     *          有hash冲突
     *
     *
     *      18 简述NIO的最佳实践，比如netty，mina
     *
     *
     *
     *
     *      19 TreeMap的实现原理
     *
     *       TreeMap是一个通过红黑树实现有序的key-value集合。
             TreeMap继承AbstractMap，也即实现了Map，它是一个Map集合
             TreeMap实现了NavigableMap接口，它支持一系列的导航方法，
             TreeMap实现了Cloneable接口，它可以被克隆

            TreeMap基于红黑树（Red-Black tree）实现。映射根据其键的自然顺序进行排序，
            或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。
            TreeMap的基本操作containsKey、get、put、remove方法，它的时间复杂度是
            log（n）。--（翻译JDK中关于TeeMap简介）,也是线程非安全的




            20  类的实例化顺序
                静态变量、静态初始化块、变量、初始化块、构造器，它们的初始化顺序依次是
                （静态变量、静态初始化块）>（变量、初始化块）>构造器


            21 JVM中的内存分配：

                1  程序计数器
                     程序计数器可以看做是当前线程所执行的字节码的行号指示器。在JVM的概念模型里，字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令。

                     由于JVM的多线程是通过线程轮流切换并分配处理器执行时间的方式来实现的，为了在线程切换后能恢复到正确的执行位置，每条线程都需要有一个独立的程序计数器，独立存储，互不影响。所以，程序计数器是线程私有的内存区域。

                     如果线程执行的是一个Java方法，计数器记录的是正在执行的虚拟机字节码指令的地址；
                     如果线程执行的是一个Native方法，计数器的值为空。

                     Java虚拟机规范中唯一一个没有规定任何OutOfMemoryError情况的区域。

                2  java虚拟机栈
                     Java虚拟机栈描述的是Java方法执行的内存模型：每个方法执行的同时会创建一个栈帧，
                     栈帧用于存储局部变量表、操作数栈、动态链接、方法出口等信息。每个方法从调用直至
                     执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。

                     Java虚拟机栈是线程私有的，它的生命周期与线程相同。

                     程序员主要关注的stack栈内存，就是虚拟机栈中局部变量表部分。
                     局部变量表存放了编译时期可知的各种基本数据类型和对象引用。
                     局部变量表所需的内存空间在编译时期完成分配，当进入一个方法时，
                     这个方法需要在栈帧中分配多大的局部变量空间是完全确定的，在方法运行期间不会改变局部变量表的大小。

                     Java虚拟机规范对这个区域规定了两种异常情况：

                     如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError 异常；
                     如果虚拟机栈可以动态扩展，如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常；
                     （当前大部分JVM都可以动态扩展，只不过JVM规范也允许固定长度的虚拟机栈）
                3 本地机栈

                     本地方法栈与虚拟机栈所发挥的作用是非常相似的，它们之间的区别不过是虚拟机栈为
                     虚拟机执行Java方法服务（也就是字节码），而本地方法栈为虚拟机使用到的Native方法服务。

                     Java虚拟机规范对本地方法栈使用的语言、使用方法与数据结构并没有强制规定，因此可
                     以由虚拟机自由实现。例如：HotSpot虚拟机直接将本地方法栈和虚拟机栈合二为一。

                     同虚拟机栈相同，Java虚拟机规范对这个区域也规定了两种异常情况StackOverflowErro
                     r 和 OutOfMemoryError异常。

                4 java堆

                     Java堆是被所有的线程共享的一块内存区域，在虚拟机启动时创建。
                     Java堆的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。

                     Java堆是垃圾回收器管理的主要区域，因此也被称为"GC堆"。
                     从内存回收的角度看，由于现在收集器基本都采用分代收集算法，所以Java堆可以细分为：新生代、老生代；
                     从内存分配的角度看，线程共享的Java堆可能划分出多个线程私有的分配缓冲区（TLAB）；
                     不论如何划分，都与存放的内容无关，无论哪个区域，存储的仍然是对象实例。

                     Java虚拟机规范规定，Java堆可以处于物理上不连续的内存空间中，只要逻辑上是连续的即可，就像我们的磁盘空间一样。在实现上，既可以是固定大小的，也可以是可扩展的，不过当前主流JVM都是按照可扩展来实现的。

                     Java虚拟机规范规定，如果在堆上没有内存完成实例分配，并且堆上也无法再扩展时，将会抛出OutOfMemoryError异常。

                     内存泄露和内存溢出
                     Java堆内存的OOM异常是非常常见的异常情况，重点是根据内存中的对象是否是必要的，来弄清楚到底是出现了内存泄露(Memory Leak)还是内存溢出(Memory Overflow).

                     内存泄露：指程序中一些对象不会被GC所回收，它始终占用内存，即被分配的对象引用链可达但已无用。（可用内存减少）
                     内存溢出：程序运行过程中无法申请到足够的内存而导致的一种错误。内存溢出通常发生于OLD段或Perm段垃圾回收后，仍然无内存空间容纳新的Java对象的情况。
                     内存泄露是内存溢出的一种诱因，不是唯一因素。

                5 方法区

                     方法区也是被所有的线程共享的一块内存区域。它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。

                     Java虚拟机规范对方法区的限制非常宽松，除了和Java堆一样 不需要连续的内存和可以选择固定大小或者可扩展之外，还可以选择不实现垃圾回收。
                     这区域的内存回收目标主要是针对常量池的回收和类型的卸载，一般而言，这个区域的内存回收比较难以令人满意，尤其是类型的回收，条件相当苛刻，但是这部分区域的内存回收确实是必要的。

                     Java虚拟机规范规定，当方法区无法满足内存分配的需求时，将抛出OutOfMemoryError异常。

                     运行时常量池
                     运行时常量池是方法区的一部分。CLass文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池，用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存放。
                     运行时常量池相对于CLass文件常量池的另外一个重要特征是具备动态性，Java语言并不要求常量一定只有编译期才能产生，也就是并非预置入CLass文件中常量池的内容才能进入方法区运行时常量池，运行期间也可能将新的常量放入池中，这种特性被开发人员利用比较多的就是String类的intern()方法。

                     String.intern()
                     String.intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含了一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；否则，将此String对象包含的字符串添加到常量池中，并且返回此字符串的引用。

            22 JVM垃圾回收机制，何时触发MinorGC等操作

                gc： 垃圾收集回收 是对jvm的内存进行标记和回收，将内存中不再使用的对象进行回收，以便分配给新的对象使用。
                gc回收哪里的内存： jvm内存模型中堆区内存，分代收集主要是指堆区的内存（新生代和旧生代），但方法区（持久代）也有少部分比例
                gc回收什么样的内存：通过根部搜索算法， gc roots 搜索通过的路径成为引用链，当一个对象没有引用链接的时候，说明对象不可及，
                                    是需要被回收的。
                gc操作的过程/何时回收： 1.当试图为java对象在eden区初始化一块内存区域的时候，如果此时eden区足够，则申请结束。

                                     2.若eden区不足，则触发一次gc操作，将存活的对象复制到s0区，并清理eden区。

                                     3.若此时eden区和s0区不足，进行gc操作，将eden+s0区的存活的对象复制到另一个空闲空间s1，然后清理eden+s0区的内存空间。

                                     4.当两个存活区s0和s1来回切换15次，将存活的对象复制到老年代

                                     5.若老年代的空间不足，则major gc 采用标记整理算法清理老年代对象。
                GC怎么进行回收？回收算法？—现在JVM使用的GC回收算法—-分代回收算法:
                             a.对新生代（存活时间较短） ——采用复制算法进行回收
                                     具体过程：所谓复制是值 eden区到 survior0 或 survior1区之间copy
                                     把存活对象复制到一个空闲的s区
                                     当eden区满的时候，触发gc，将存活的对象复制到s0区，此时回收eden区的内存
                                     ，当eden区再次满了的时候，触发gc，将eden和s0区存活的对象复制到另一个空闲空间s1，
                                     此时回收eden和s1区的内存，这样总会有一个空闲的空间s0/s1，作为下一次minor gc存
                                     放对象的准备空间。始终会有一个10%空闲的survivor区间，作为下一次Minor GC存放对象的准备空间。

                             b.对年老代（存活时间较长，而且没有备用的空闲空间）
                                     —-采用标记-整理算法
                                     将存活下来的对象进行标记，向一端移动，保证内存完整性，然后将最后一个活着的对象地址以后的空间全部清理。

                                     —或采用标记-清除算法
                                     从GC ROOTS开始，遍历堆内存区域的所有根对象，对在引用链上的对象都进行标记。存活的对象标记，不存活的进行就进行清理。





            23 JVM区域总体分两类，heap区和非heap区。
                 heap区又分为：
                 - Eden Space（伊甸园）、
                 - Survivor Space(幸存者区)、
                 - Old Gen（老年代）。

                 非heap区又分：
                 - Code Cache(代码缓存区)；
                 - Perm Gen（永久代）；
                 - Jvm Stack(java虚拟机栈)；
                 - Local Method Statck(本地方法栈)；

                Eden Space字面意思是伊甸园，对象被创建的时候首先放到这个区域，进行垃圾回收后，
                        不能被回收的对象被放入到空的survivor区域。
                Survivor Space幸存者区，用于保存在eden space内存区域中经过垃圾回收后没有被回
                        收的对象。Survivor有两个，分别为To Survivor、 From Survivor，这个两个区域的
                        空间大小是一样的。执行垃圾回收的时候Eden区域不能被回收的对象被放入到空的survivor
                        （也就是To Survivor，同时Eden区域的内存会在垃圾回收的过程中全部释放），另一个sur
                        vivor（即From Survivor）里不能被回收的对象也会被放入这个survivor（即To Survivor）
                        ，然后To Survivor 和 From Survivor的标记会互换，始终保证一个survivor是空的。

                 Eden Space和Survivor Space都属于新生代，新生代中执行的垃圾回收被称之为Minor GC（因为是对新生代进行垃圾回收，所以又被称为Young GC），每一次Young GC后留下来的对象age加1。

               Old Gen老年代，用于存放新生代中经过多次垃圾回收仍然存活的对象，也有可能是新生代分配不了内存的大
                            对象会直接进入老年代。经过多次垃圾回收都没有被回收的对象，这些对象的年代已经足够old了
                            ，就会放入到老年代。当老年代被放满的之后，虚拟机会进行垃圾回收，称之为Major GC。由
                            于Major GC除并发GC外均需对整个堆进行扫描和回收，因此又称为Full GC。

               heap区即堆内存，整个堆大小=年轻代大小 + 老年代大小。堆内存默认为物理内存的1/64(<1GB)；默认空余堆内存小于40%时，
               JVM就会增大堆直到-Xmx的最大限制，可以通过MinHeapFreeRatio参数进行调整；默认空余堆内存大于70%时，JVM会减少堆
               直到-Xms的最小限制，可以通过MaxHeapFreeRatio参数进行调整

               Code Cache代码缓存区，它主要用于存放JIT所编译的代码。CodeCache代码缓冲区的大小在client模式下默认最大是32m，
                在server模式下默认是48m，这个值也是可以设置的，它所对应的JVM参数为ReservedCodeCacheSize 和 InitialCodeCacheSize

             Perm Gen全称是Permanent Generation space，是指内存的永久保存区域，因而称之为永久代。这个内存区域用于存放Class和Meta的信息，
            Class在被 Load的时候被放入这个区域。因为Perm里存储的东西永远不会被JVM垃圾回收的，所以如果你的应用程序LOAD很多CLASS的话，就很可
            能出现PermGen space错误。默认大小为物理内存的1/64。







            24 新生带内存分配比例：
                 -Xms设置堆的最小空间大小。
                 -Xmx设置堆的最大空间大小。
                 -XX:NewSize设置新生代最小空间大小。
                 -XX:MaxNewSize设置新生代最大空间大小。
                 -XX:PermSize设置永久代最小空间大小。
                 -XX:MaxPermSize设置永久代最大空间大小。
                 -Xss设置每个线程的堆栈大小。



            25  深入分析了Classloader，双亲委派机制
                ClassLoader概念：ClassLoader是Java提供的基础的类加载机制，负责将JDK，第三方的类包和用户写的Java代码，
                                根据代码中组织方式和依赖关系，按需将class动态加载到内存中，以便JVM执行java程序。

                ClassLoader：JDK中自带自带有三种类型的classloader，分别是BootStrap ClassLoader, ExtClassLoader，AppClassLoader
                             BootStrapClassLoader，加载JDK的核心类库，它是Java中最顶层的加载器，默认加载JAVA_HOME/jre/lib下的jar包。
                             ExtClassLoader， 扩展加载器，加载JDK中的扩展包，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
                             AppClassLoader，系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。

                ClassLoader 类加载机制
                            默认JDK中使用双亲委派的机制来搜索加载类的，也就是说，每个classloader都有一个父级classloader，
                            当加载一个类时，子classloader会优先委托他的父级classloader加载该类，如果父类未加载到该类，然
                            后自己才搜索加载该类。这个过程是由上至下依次检查的。首先由最顶层的类加载器Bootstrap ClassLoader
                            试图加载，如果没有找到，然后传递Extension ClassLoader搜索加载，如果还没有找到，就会使用System
                            ClassLoader进行搜索查找
                为什么使用双亲委派的规则加载类：是为了安全考虑，class优先被父类加载，这样就能保证核心的JDK类库，不会被替换。想象一下，如果我们经常使用java.lang.String 被替换掉，这样就会造成很大的安全隐患。而这种委派机制可以避免这种情况。因为核心的类库，都在启动时被BootstrapClassloader 加载。我们无法自定义String替代核心库的实现。

            26 JVM的编译优化





            27  对Java内存模型的理解，以及其在并发中的应用?

            28  指令重排序，内存栅栏等？

            29   OOM错误，stackoverflow错误，permgen space错误

                 栈溢出(StackOverflowError)  栈溢出抛出java.lang.StackOverflowError错误，出现此种情况是因为方法运行的时候栈的深度超过了虚拟机容许的最大深度所致。
                 堆溢出(OutOfMemoryError:java heap space)    堆内存溢出的时候，虚拟机会抛出java.lang.OutOfMemoryError:java heap space,出现此种情况的时候，
                                                            我们需要根据内存溢出的时候产生的dump文件来具体分析（需要增加-XX:+HeapDumpOnOutOfMemoryErrorjvm启动参数）。
                                                            出现此种问题的时候有可能是内存泄露，也有可能是内存溢出了。
                                                            如果内存泄露，我们要找出泄露的对象是怎么被GC ROOT引用起来，然后通过引用链来具体分析泄露的原因。
                                                            如果出现了内存溢出问题，这往往是程序本生需要的内存大于了我们给虚拟机配置的内存，这种情况下，我们可以采用调大-Xmx来解决这种问题。

                 持久带溢出(OutOfMemoryError: PermGen space)  Hotspot jvm通过持久带实现了Java虚拟机规范中的方法区，而运行时的常量池就是保存在方法区中的，因此持久带溢出有可能是运行时常量池溢出，
                                                            也有可能是方法区中保存的class对象没有被及时回收掉或者class信息占用的内存超过了我们配置。当持久带溢出的时候抛出
                                                            java.lang.OutOfMemoryError: PermGen space。
                 OOM错误： 内存错误


            30 JVM常用参数 ？ 暂时不用记录



            31 tomcat结构，类加载器流程

            32  volatile的语义，它修饰的变量一定线程安全吗
            33  g1和cms区别,吞吐量优先和响应优先的垃圾收集器选择
            34  说一说你对环境变量classpath的理解？如果一个类不在classpath下，为什么会抛出ClassNotFoundException异常，如果在不改变这个类路径的前期下，怎样才能正确加载这个类？
            35  说一下强引用、软引用、弱引用、虚引用以及他们之间和gc的关系



            36  ThreadLocal
                ThreadLocal是一个关于创建线程局部变量的类。
                 Global 意思是在当前线程中，任何一个点都可以访问到ThreadLocal的值。
                 Local 意思是该线程的ThreadLocal只能被该线程访问，一般情况下其他线程访问不到。
                 为ThreadLocal设置默认的get初始值，需要重写initialValue方法，下面是一段代码，我们将默认值修改成了线程的名字
                 原理：实际上ThreadLocal的值是放入了当前线程的一个ThreadLocalMap实例中，所以只能在本线程中访问，其他线程无法访问。
                 是否在栈上： 其实不是，因为ThreadLocal实例实际上也是被其创建的类持有（更顶端应该是被线程持有）。而ThreadLocal的值其实也是被线程实例持有。
                            它们都是位于堆上，只是通过一些技巧将可见性修改成了线程可见。


            37 Synchronized和Lock的区别

                区别： 1 synchronized 是关键字，在jvm层面控制， 而lock是一个类，需要手动new lock和unlock
                      2 锁的获取，如果A线程占用，或者阻塞，则B线程一直等待  而lock的话则会去尝试获取
                      3 锁的状态， synchronized无法判断， lock可以判断
                      4 类型：synchronized可重入，不可中断，非公平  lock是可重入，可判断，可公平


                lock实现：    1、调用lock方法，会先进行cas操作看下可否设置同步状态1成功，如果成功执行临界区代码
                             2、如果不成功获取同步状态，如果状态是0那么cas设置为1.
                             3、如果同步状态既不是0也不是自身线程持有会把当前线程构造成一个节点。
                             4、把当前线程节点CAS的方式放入队列中，行为上线程阻塞，内部自旋获取状态。
                             5、线程释放锁，唤醒队列第一个节点，参与竞争。重复上述。

            38   synchronized 的原理
                 普通同步方法：锁是当前实例对象
                 静态同步方法：锁是当前类的Class对象
                 同步方法块：锁是Synchronized括号里配置的对象
                 获取对象monitor锁

                 锁的状态： 1 偏向锁： 当一个线程访问同步块并获取锁时，会在对象头和栈帧中的锁记录里存储锁偏向的线程ID，
                                    以后该线程在进入和退出同步块时不需要花费CAS操作来加锁和解锁，而只需简单的测试
                                    一下对象头的Mark Word里是否存储着指向当前线程的偏向锁，如果测试成功，表示线程
                                    已经获得了锁，如果测试失败，则需要再测试下Mark Word中偏向锁的标识是否设置成1
                                    （表示当前是偏向锁），如果没有设置，则使用CAS竞争锁，如果设置了，则尝试使用CAS
                                    将对象头的偏向锁指向当前线程（此时会引发竞争，偏向锁会升级为轻量级锁

             38： synchronized 的原理，什么是自旋锁，偏向锁，轻量级锁，什么叫可重入锁，什么叫公平锁和非公平锁



             39    concurrenthashmap具体实现及其原理

                      ConcurrentHashMap 数据结构为一个 Segment 数组，Segment 的数据结构为 HashEntry 的数组，而 HashEntry 存的是我们的键值对，可以构成链表。

                     在实际的应用中，散列表一般的应用场景是：除了少数插入操作和删除操作外，绝大多数都是读取操作，而且读操作在大多数时候都是成功的。正是基于这个前提，ConcurrentHashMap 针对读操作做了大量的优化。通过 HashEntry 对象的不变性和用 volatile 型变量协调线程间的内存可见性，使得 大多数时候，读操作不需要加锁就可以正确获得值。这个特性使得 ConcurrentHashMap 的并发性能在分离锁的基础上又有了近一步的提高。

                     ConcurrentHashMap 是一个并发散列映射表的实现，它允许完全并发的读取，并且支持给定数量的并发更新。相比于 HashTable 和用同步包装器包装的 HashMap（Collections.synchronizedMap(new HashMap())），ConcurrentHashMap 拥有更高的并发性。在 HashTable 和由同步包装器包装的 HashMap 中，使用一个全局的锁来同步不同线程间的并发访问。同一时间点，只能有一个线程持有锁，也就是说在同一时间点，只能有一个线程能访问容器。这虽然保证多线程间的安全并发访问，但同时也导致对容器的访问变成串行化的了。

                     ConcurrentHashMap 的高并发性主要来自于三个方面：

                     用分离锁实现多个线程间的更深层次的共享访问。
                     用 HashEntery 对象的不变性来降低执行读操作的线程在遍历链表期间对加锁的需求。
                     通过对同一个 Volatile 变量的写 / 读访问，协调不同线程间读 / 写操作的内存可见性。
                     使用分离锁，减小了请求 同一个锁的频率。

                     通过 HashEntery 对象的不变性及对同一个 Volatile 变量的读 / 写来协调内存可见性，使得 读操作大多数时候不需要加锁就能成功获取到需要的值。由于散列映射表在实际应用中大多数操作都是成功的 读操作，所以 2 和 3 既可以减少请求同一个锁的频率，也可以有效减少持有锁的时间。通过减小请求同一个锁的频率和尽量减少持有锁的时间 ，使得 ConcurrentHashMap 的并发性相对于 HashTable 和用同步包装器包装的 HashMap有了质的提高。

            40      用过哪些原子类，他们的参数以及原理是什么

                        基础数据类型原子操作：
                            AtomicBoolean：用来更新布尔型变量；
                            AtomicInteger：用来更新整型变量；
                            AtomicLong：用来更新长整型变量。
                        原子数组更新：
                             AtomicIntegerArray：用来更新整型数组里的元素；
                             AtomicLongArray：用来更新长整型数组里的元素；
                             AtomicReferenceArray：用来更新引用类型数组里的元素。

                        引用更新类型：
                             AtomicReference：用于更新引用类型，可以理解为更新Object；
                             AtomicMarkableReference：用于更新带有标记位的引用类型；
                             AtomicStampedReference：用于更新带有版本号的引用类型，该类将版本号与引用类型关联起来，可以解决使用CAS进行原子更新时可能会出现的ABA问题。

                        属性原子操作：
                             AtomicIntegerFieldUpdater：用于更新Object的整型属性；
                             AtomicLongFieldUpdater：用于更新Object的长整型属性；
                             AtomicReferenceFieldUpdater：用于更新Object的引用类型属性。

            41 cas是什么，他会产生什么问题
                    比较并替换，原子操作大多数都是使用这个方式
                    添加版本号


            42 并发队列ConcurrentLinkedQueue与阻塞队列LinkedBlockingQueue的区别

                  LinkedBlockingQueue
                  由于LinkedBlockingQueue实现是线程安全的，实现了先进先出等特性，是作为生产者消费者的首选，
                  LinkedBlockingQueue 可以指定容量，也可以不指定，不指定的话，默认最大是Integer.MAX_VALUE，
                  其中主要用到put和take方法，put方法在队列满的时候会阻塞直到有队列成员被消费，take方法在队列空
                  的时候会阻塞，直到有队列成员被放进来。


                 ConcurrentLinkedQueue
                 ConcurrentLinkedQueue是Queue的一个安全实现．Queue中元素按FIFO原则进行排序．采用CAS操作，
                 来保证元素的一致性

                 对比锁机制的实现，使用无锁机制的难点在于要充分考虑线程间的协调。简单的说就是多个线程对内部数据结构进
                 行访问时，如果其中一个线程执行的中途因为一些原因出现故障，其他的线程能够检测并帮助完成剩下的操作。这
                 就需要把对数据结构的操作过程精细的划分成多个状态或阶段，考虑每个阶段或状态多线程访问会出现的情况。
                 ConcurrentLinkedQueue有两个volatile的线程共享变量：head，tail。要保证这个队列的线程安全就是
                保证对这两个Node的引用的访问（更新，查看）的原子性和可见性，由于volatile本身能够保证可见性，所以就是对其修改的原子性要被保证。
                 另外还说一下，ConcurrentLinkedQueue的size()是要遍历一遍集合的，所以尽量要避免用size而改用isEmpty()，以免性能过慢。

             43 简述AQS的实现原理



             44 countdowlatch和cyclicbarrier

                countdowlatch： CountDownLatch允许一个或多个线程等待其他线程完成操作。
                CyclicBarrier： 让一组线程到达一个同步点后再一起继续运行，在其中任意一个线程未达到同步点，其他到达的线程均会被阻塞。

                 CountDownLatch：一个或者多个线程，等待其他多个线程完成某件事情之后才能执行；
                 CyclicBarrier：多个线程互相等待，直到到达同一个同步点，再继续一起执行。

                 CountDownLatch是计数器，线程完成一个记录一个，只不过计数不是递增而是递减，而CyclicBarrier更像是一个阀门，需要所有线程都到达，阀门才能打开，然后继续执行。


               45  concurrent包中使用过哪些类？分别说说使用在什么场景？为什么要使用？




               46 LockSupport工具
                    1 阻塞线程
                    2 唤醒线程
                    注：synchronzed致使线程阻塞，线程会进入到BLOCKED状态，而调用LockSupprt方法阻塞线程会致使线程进入到WAITING状态。
                        由synchronzed阻塞的线程加入到同步队列，再次被唤醒的线程是随机从同步队列中选择的，而LockSupport.unpark(thread)可以指定线程对象唤醒指定的线程。





                47 Condition接口及其实现原理
                  Condtion依赖于lock锁，获取其对象只能通过lock的newCondition接口，在满足条件的情况下，当前线程获得锁，进行操作，
                  当条件不满足，condtion.wait进入等待状态， 当前线程释放锁，并且让等待的队列进入同步队列，当condtion释放singal信号
                  的时候，当前线程获取锁，并进去唤醒状态，处理问题
                  常见的生产者消费者模式可以有Condtion的帮助实现


                48 Fork/Join框架的理解



                49 jdk8的parallelStream的理解

                50 分段锁的原理,锁力度减小的思考




                51 Spring AOP与IOC的实现原理
                    IOC：控制反转        beans包实现的核心关注点是BeanFactory，BeanFactory也叫作Bean容器，顾名思义，是用来盛放、管理bean的。
                                       context包实现的核心关注是ApplicationContext，ApplicationContext也是用来获取Bean的，但是它更高层，它的面向用户是Spring的使用者，而BeanFactory面向的用户更多是Spring开发者。BeanFactory定义了Bean初始化的流程，ApplicationContext定义了从XML读取，到Bean初始化，再到使用的过程。
                    AOP：切面编程,AOP（Aspect Orient Programming），我们一般称为面向方面（切面）编程，作为面向对象的一种补充，用于处理系统中分布于各个模块的横切关注点，比如事务管理、日志、缓存等等。AOP实现的关键在于AOP框架自动创建的AOP代理，AOP代理主要分为静态代理和动态代理，静态代理的代表为AspectJ；而动态代理则以Spring AOP为代表。本文会分别对AspectJ和Spring AOP的实现进行分析和介绍。
                         动态代理  Spring的动态代理有两种：一是JDK的动态代理；另一个是cglib动态代理（通过修改字节码来实现代理）。
                         before 目标方法执行前执行，前置通知
                         after 目标方法执行后执行，后置通知
                         after returning 目标方法返回时执行 ，后置返回通知
                         after throwing 目标方法抛出异常时执行 异常通知
                         around 在目标函数执行中执行，可控制目标函数是否执行，环绕通知






                52 Spring的beanFactory和factoryBean的区别
                        beanFactory：是spring的核心容器
                        factoryBean: 是用来获取动态代理bean对象



                53   为什么CGlib方式可以对接口实现代理？
                        一、为什么不直接都使用JDK动态代理：JDK动态代理只能代理接口类，所以很多人设计架构的时候会使用XxxService, XxxServiceImpl的形式设计，一是让接口和实现分离，二是也有助于代理。
                        二、为什么不都使用Cgilb代理：因为JDK动态代理不依赖其他包，Cglib需要导入ASM包，对于简单的有接口的代理使用JDK动态代理可以少导入一个包。
                             CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑

                54   RMI与代理模式

                55   Spring的事务隔离级别，实现原理
                        本质：是数据库对事物的只能，能提高crud的commit回滚
                             配置文件开启注解驱动，在相关的类和方法上通过注解@Transactional标识。
                             spring 在启动的时候会去解析生成相关的bean，这时候会查看拥有相关注解的类和方法，并且为这些类和方法生成代理，并根据@Transaction的相关参数进行相关配置注入，这样就在代理中为我们把相关的事务处理掉了（开启正常提交事务，异常回滚事务）。
                             真正的数据库层的事务提交和回滚是通过binlog或者redo log实现的。
                        隔离级别：
                             ISOLATION_DEFAULT	这是个 PlatfromTransactionManager 默认的隔离级别，使用数据库默认的事务隔离级别。另外四个与 JDBC 的隔离级别相对应。
                             ISOLATION_READ_UNCOMMITTED	这是事务最低的隔离级别，它充许另外一个事务可以看到这个事务未提交的数据。这种隔离级别会产生脏读，不可重复读和幻像读。
                             ISOLATION_READ_COMMITTED	保证一个事务修改的数据提交后才能被另外一个事务读取。另外一个事务不能读取该事务未提交的数据。
                             ISOLATION_REPEATABLE_READ	这种事务隔离级别可以防止脏读，不可重复读。但是可能出现幻像读。
                             ISOLATION_SERIALIZABLE	这是花费最高代价但是最可靠的事务隔离级别。事务被处理为顺序执行。




                56 对Spring的理解，非单例注入的原理？它的生命周期？循环注入的原理，aop的实现原理，说说aop中的几个术语，它们是怎么相互工作的？

                57 Mybatis的底层实现原理
                   1 使用interface面向service交互
                   2 使用接口动态生成一个mapper实例，根据方法和参数，可以获取到statment,底层还是通过sqlsession来与数据库进行交互
                   3 使用传入的参数动态生成sql语句，获取数据并转移成java数据类型
                   4 事物管理机制
                   5 链接池管理机制
                   6 缓存机制
                   7 sql的配置方式，使用xml方式或者注解的方式
                     相关类：
                     SqlSession：作为MyBatis工作的主要顶层API，表示和数据库交互的会话，完成必要数据库增删改查功能；
                     Executor：MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护；
                     StatementHandler：封装了JDBC Statement操作，负责对JDBC statement 的操作，如设置参数、将Statement结果集转换成List集合。
                     ParameterHandler：负责对用户传递的参数转换成JDBC Statement 所需要的参数；
                     ResultSetHandler：负责将JDBC返回的ResultSet结果集对象转换成List类型的集合；
                     TypeHandler：负责java数据类型和jdbc数据类型之间的映射和转换；
                     MappedStatement：MappedStatement维护了一条<select|update|delete|insert>节点的封装；
                     SqlSource：负责根据用户传递的parameterObject，动态地生成SQL语句，将信息封装到BoundSql对象中，并返回；
                     BoundSql：表示动态生成的SQL语句以及相应的参数信息；
                     Configuration：MyBatis所有的配置信息都维持在Configuration对象之中；




                58 MVC框架原理，他们都是怎么做url路由的

                59 spring boot特性，优势，适用场景等
                       场景： SSO，分布式文件系统，微服务使用等等，在企业版应用中，这些都是非常顶用的。如果硬说有坑的话，就是服务多了，服务部署和运维管理必须要上一个档次，否则就会显得混乱起来。
                        特性：（1）遵循“习惯优于配置”的原则，使用Spring Boot只需要很少的配置，大部分的时候我们直接使用默认的配置即可；
                             （2）项目快速搭建，可以无需配置的自动整合第三方的框架；
                             （3）可以完全不使用XML配置文件，只需要自动配置和Java Config；
                             （4）内嵌Servlet容器，降低了对环境的要求，可以使用命令直接执行项目，应用可用jar包执行：java -jar；
                             （5）提供了starter POM, 能够非常方便的进行包管理, 很大程度上减少了jar hell或者dependency hell；
                             （6）运行中应用状态的监控；
                             （7）对主流开发框架的无配置集成；
                             （8）与云计算的天然继承；
                        核心功能：(1)独立运行的项目
                                (2) 内嵌servlet
                                (3) 提供starter简化Manen配置
                                (4) 自动配置Spring
                                (5) 应用监控
                                (6) 无代码生成和XML配置


                 60 quartz和timer对比
                     Timer类的核心是它的两个内部类TaskThread和TaskQueue。
                     TimerThread线程在start方法启动后，就会开始不断轮询，每次轮询都会获取TaskQueue中第一个TimerTask（ 执行时间最小的TimerTask），判断当前是否已到执行时间：
                     如当前时间大于或等于执行时间，则执行TimerTask；
                     如未到，则会休眠一段时间（时长=任务执行时间-当前时间）。
                     执行后，判定该task是否需要重复执行，如需要，则重置该task的执行时间，重新放入TaskQueue中（放入后会自动排序）。
                     Timer工具类
                     优点：JDK本身就自带该工具类，无需第三方依赖，只需实现TimerTask类即可使用Timer进行调度配置，使用起来简单方便。
                     缺点：Timer中所有的任务都一个TaskThread线程来调度和执行，任务的执行方式是串行的，如果前一个任务发生延迟或异常会影响到后续任务的执行。

                    Quartz同ScheduledThreadPoolExecutor一样也是基于线程池进行任务调度的，它默认使用org.quartz.simpl.SimpleThreadPool来作为线程池，在调用scheduleJob()方法会将Job和Trigger存储在JobStore(从存储介质中获取触发器，存储介质可以是内存也可以是数据库)中，然后通知调度线程（QuartzSchedulerThread）从JobStore中获取即将被触发的触发器，到达触发时间后分配线程去执行触发器对应的Job任务。



                61 spring的controller是单例还是多例，怎么保证并发的安全
                    单列， 尽量别使用成员变量，会重复使用


                62 Dubbo的底层实现原理和机制



                63 描述一个服务从发布到被消费的详细过程

                64 分布式系统怎么做服务治理

                65 接口的幂等性的概念

                66 消息中间件如何解决消息丢失问题
                67 Dubbo的服务请求失败怎么处理
                68 重连机制会不会造成错误
                69 对分布式事务的理解
                70 如何实现负载均衡，有哪些算法可以实现？
                    Nginx 1 权限配偶： 根据服务的承载能力，配置权重的流量
                          2 轮询： 追求平均
                          3 随机算法： 请求量越大，越平均



                71    Zookeeper的用途，选举的原理是什么？
                      1 名称管理
                      2 配置管理
                      3 组员管理
                      4 简单互斥锁
                      5 互斥锁
                      6 读写锁
                      7 屏障，双屏障



                72   数据的垂直拆分水平拆分。
                     垂直拆分： 如果表字段过多的话则分为多张表存储
                     水平拆分：

                73  zookeeper原理和适用场景

                74 zookeeper watch机制


                75 redis/zk节点宕机如何处理
                    故障转译，主从切换




                76 分布式集群下如何做到唯一序列号
                        1 数据库自增长： 有点：使用方便，
                                      缺点：数据库迁移，数据库归档的时候容易乱序

                        2 UUDI：优点：数据简单，全球唯一
                                缺点：不支持排序
                        3 redisincrease： 有点： 简单，数字天然排序
                                          缺点： 需要引入redis等操作
                        4 zookeeper的版本唯一id
                        5 mongDB的objectId

                77 如何做一个分布式锁
                    基于redis锁，保证所有节点，所有线程，只有一个能访问当前方法

                78 用过哪些MQ，怎么用的，和其他mq比较有什么优缺点，MQ的连接是线程安全的吗



                79  MQ系统的数据如何保证不丢失
                    数据持久化，持久化消息是会把消息写成文件存储磁盘，对比内存操作是很耗时
                    所以数据持久化与性能与时效性之间的做一个选择




                80  列举出你能想到的数据库分库分表策略；分库分表后，如何解决全表查询的问题。
                    1 业务拆分
                    2 主从复制，读写分离
                    3 数据分库分表
                    4 分表策略 （100张表， 去100取余，根据id来取）
                    5 分表也不能解决i/O问题，进行分库能解决部分i/o



                81   海量url去重类问题（布隆过滤器）
                     数据库中设置unique
                     数据库中设置唯一索引，插入的时候查看是否存在
                     使用map集合或者set集合



                82   数组和链表数据结构描述，各自的时间复杂度




                83   二叉树遍历
                        见 TreeVariable

                84   快速排序
                      见 QuickSorting



                85   BTree相关的操作



                86   在工作中遇到过哪些设计模式，是如何应用的

                87    hash算法的有哪几种，优缺点，使用场景
                         Hash算法有什么特点
                         一个优秀的 hash 算法，将能实现：
                                 正向快速：给定明文和 hash 算法，在有限时间和有限资源内能计算出 hash 值。
                                 逆向困难：给定（若干） hash 值，在有限时间内很难（基本不可能）逆推出明文。
                                 输入敏感：原始输入信息修改一点信息，产生的 hash 值看起来应该都有很大不同。
                                 冲突避免：很难找到两段内容不同的明文，使得它们的 hash 值一致（发生冲突）。即对于任意两个不同的数据块，其hash值相同的可能性极小；对于一个给定的数据块，找到和它hash值相同的数据块极为困难。
                         常见HASH算法： MD5， SHA1， HSA2，但是都不具备强碰撞性，意思hash冲突，散列算法







                88    什么是一致性hash
                        在添加数据或者移动数据存储节点之后，重新计算hash值的时候，与迁移无关的节点值的计算与之前的计算相同


                89    paxos算法


                90    在装饰器模式和代理模式之间，你如何抉择，请结合自身实际情况聊聊



                91    代码重构的步骤和原因，如果理解重构到模式？






                92    MySQL InnoDB存储的文件结构
                         表空间
                         在上一篇《MySQL InnoDB文件介绍》中，我们知道InnoDB有一个默认的表空间，如果我们启用了参数innodb_file_per_table，则针对每张可以单独放在表空间里。这里需要注意的是，即时启用了innodb_file_per_table，也并不是表中所有的数据都单独放在自己的表空间里，单独表空间只存放数据、索引和插入缓冲，其它如Undo、系统事务信息、二次写缓冲等还是存放在默认共享表空间里。
                         段
                         表空间有若干各段组成，常见的有数据段、索引段、回滚段等。前面提到InnoDB中的表是索引组织表，因此数据段也称为leaf node segment，索引段也称为non-leaf node segment。
                         区
                         每64个连续的页组成区，因此区大小正好为1M。
                         页
                         页是InnoDB磁盘管理的最小单位，固定大小为16K，不可以更改（也许通过更改源码可以修改固定大小）。
                         行
                         InnoDB表中数据按行存储。









                93    索引树是如何维护的？
                        B-数b+数据




                94    数据库自增主键可能的问题
                            数据迁移主键冲突



                95     MySQL的几种优化
                             优化Group By语句
                             默认情况下，MySQL 排序所有GROUP BY col1，col2，....。查询的方法如同在查询中指定ORDER BY col1，col2，...。如果显式包括一个包含相同的列的ORDER BY子句，MySQL 可以毫不减速地对它进行优化，尽管仍然进行排序。如果查询包括GROUP BY 但你想要避免排序结果的消耗，你可以指定ORDER BY NULL禁止排序。

                             优化Order by语句
                             在某些情况中，MySQL 可以使用一个索引来满足ORDER BY 子句，而不需要额外的排序。where 条件和order by 使用相同的索引，并且order by 的顺序和索引顺序相同，并且order by 的字段都是升序或者都是降序。

                            优化insert语句
                            如果你同时从同一客户插入很多行，使用多个值表的INSERT 语句。这比使用分开 INSERT 语句快(在一些情况中几倍)。Insert into test values(1,2),(1,3),(1,4)…

                            查询优化
                            1 查询时候尽量不使用函数逻辑
                            2 索引的优化
                                 MySQL只有对以下操作符才使用索引：<，<=，=，>，>=，BETWEEN，IN，以及某些时候的LIKE。

                                 尽量不要写!=或者<>的sql，用between或> and <代替，否则可能用不到索引

                                 Order by 、Group by 、Distinct 最好在需要这个列上建立索引，利于索引排序

                                 尽量利用mysql索引排序

                                 没办法的情况下，使用强制索引Force index(index_name)

                                 尽量避勉innodb用非常大尺寸的字段作为主键

                                 较频繁的作为查询条件的字段应该创建索引;

                                 选择性高的字段比较适合创建索引;

                                 作为表关联字段一般都需要创索引.

                                 更新非常频繁的字段不适合创建索引;

                                 不会出现在 WHERE 子句中的字段不该创建索引.

                                 选择性太低的字段不适合单独创建索引




                96     mysql索引为什么使用B+树
                       mysql的数据不是全部都存在内存的，也要一部分存在文件中，使用B+查询能提示i/O速度




                97    数据库锁表的相关处理
                        数据库中有两种基本的锁类型：排它锁（Exclusive Locks，即X锁）和共享锁（Share Locks，即S锁）。当数据对象被加上排它锁时，其他的事务不能对它读取和修改。加了共享锁的数据对象可以被其他事务读取，但不能修改。数据库利用这两种基本的锁类型来对数据库的事务进行并发控制。
                        表锁死的处理办法： 1 优化代码逻辑  用户A查询一条纪录，然后修改该条纪录；这时用户B修改该条纪录，这时用户A的事务里锁的性质由查询的共享锁企图上升到独占锁，而用户B里的独占锁由于A有共享锁存在所以必须等A释放掉共享锁，而A由于B的独占锁而无法上升的独占锁也就不可能释放共享锁，于是出现了死锁
                                       2  尽量不要是使用太多关联查询


                98    索引失效场景
                     1、当使用or的情况下，如果不是每一列的条件都有索引，索引失效
                     2、当使用多列索引的时候，没有匹配到第一部分，索引失效
                     3、当使用like的时候，以%开头，索引失效
                     4、当数据类型是字符串类型的时候，如果条件数据没有被引号引起来，索引失效
                     5、如果使用全表扫描比索引更快，索引失效



                 99   高并发下如何做到安全的修改同一行数据，乐观锁和悲观锁是什么，INNODB的行级锁有哪2种，解释其含义
                        悲观锁： 在修改数据库的时候加上排他锁，所有其他想访问和修改同意数据的，都的等解锁之后，效率会有些降低
                        乐观锁： 乐观锁，假设一般情况下，数据库事物是不会冲突的，如果在执行修改的时候，发现冲突，这个抛出错误，让用户自己解决，解决方案是将添加版本号，在返回结果中将版本号加上，让用户自己比对当前版本，再决定是否更新数据


                100   数据库会死锁吗，举一个死锁的例子，mysql怎么解决死锁
                         用户A查询一条纪录，然后修改该条纪录；这时用户B修改该条纪录，这时用户A的事务里锁的性质由查询的共享锁企图上升到独占锁，而用户B里的独占锁由于A有共享锁存在所以必须等A释放掉共享锁，而A由于B的独占锁而无法上升的独占锁也就不可能释放共享锁
                         一个用户A 访问表A(锁住了表A),然后又访问表B；另一个用户B 访问表B(锁住了表B)，然后企图访问表A；这时用户A由于用户B已经锁住表B，它必须等待用户B释放表B才能继续，同样用户B要等用户A释放表A才能继续，这就死锁就产生了



                101  Redis的并发竞争问题如何解决了解Redis事务的CAS操作吗


                102 缓存机器增删如何对系统影响最小，一致性哈希的实现


                103    Redis持久化的几种方式，优缺点是什么，怎么实现的
                         RDB持久化方式会在一个特定的间隔保存那个时间点的一个数据快照。
                         AOF持久化方式则会记录每一个服务器收到的写操作。在服务启动时，这些记录的操作会逐条执行从而重建出原来的数据。写操作命令记录的格式跟Redis协议一致，以追加的方式进行保存。
                         Redis的持久化是可以禁用的，就是说你可以让数据的生命周期只存在于服务器的运行时间里。
                         两种方式的持久化是可以同时存在的，但是当Redis重启时，AOF文件会被优先用于重建数据。


                104    Redis的缓存失效策略



                105    缓存穿透的解决办法
                       缓存穿透： 一般的缓存系统，都是按照key去缓存查询，如果不存在对应的value，就应该去后端系统查找（比如DB）。如果key对应的value是一定不存在的，并且对该key并发请求量很大，就会对后端系统造成很大的压力。这就叫做缓存穿透。
                       缓存雪崩： 当缓存服务器重启或者大量缓存集中在某一个时间段失效，这样在失效的时候，也会给后端系统(比如DB)带来很大压力。

                106    redis集群，高可用，原理

                         Redis Sentinel主从高可用方案
                         部署redis主从服务（1个master，多个salve），然后通过redis官方的监控工具Sentinel（哨兵），对每个节点进行监控，实现自动故障迁移，即master死掉，将salve升级为master。基本原理是：心跳机制+投票裁决。





                107    mySQL里有2000w数据，redis中只存20w的数据，如何保证redis中的数据都是热点数据
                       设置20w条数据内存大小，设置ttl，redis会更具数据淘汰策略自动销毁


                108    用Redis和任意语言实现一段恶意登录保护的代码，限制1小时内每用户Id最多只能登录5次



                109    redis的数据淘汰策略
                         volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用 的数据淘汰
                         volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数 据淘汰
                         volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据 淘汰
                         allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰
                         allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰
                         no-enviction（驱逐）：禁止驱逐数据






                110    http1.0和http1.1有什么区别
                            1. Persistent Connection持久连接
                            2.Host域 HTTP1.0则没有这个域。需要指定ip
                            3.date/timestamp (日期时间戳) HTTP1.0要求不能生成第三种asctime格式的date/time stamp；HTTP1.1则要求只生成RFC 1123(第一种)格式的date/time stamp。
                            4 新增Transfer Codings头部域
                            5 Range 和 Content-Range(节约优化) 1.1可以传输部分数据，但是1.0是全部数据重新传输
                            6 100(Continue) Status(节约带宽)   HTTP/1.1加入了一个新的状态码100（Continue）。客户端事先发送一个只带头域的请求，如果服务器因为权限拒绝了请求，就回送响应码401（Unauthorized）；如果服务器接收此请求就回送响应码100，客户端就可以继续发送带实体的完整请求了。注意，HTTP/1.0的客户端不支持100响应码。但可以让客户端在请求消息中加入Expect头域，并将它的值设置为100-continue。
                            7 HTTP1.1增加了OPTIONS,PUT, DELETE, TRACE, CONNECT这些Request方法.
                            8 Status code新增部分状态码



                111     TCP/IP协议
                        基于传输层和网络层的传输协议，实现点对点的网络信息传输


                112     TCP三次握手和四次挥手的流程，为什么断开连接要4次,如果握手只有两次，会出现什么
                        链接处于假死状态

                113    TIME_WAIT和CLOSE_WAIT的区别
                            TIME_WAIT 表示主动关闭，CLOSE_WAIT 表示被动关闭。
                114    说说你知道的几种HTTP响应码
                115    当你用浏览器打开一个链接的时候，计算机做了哪些工作步骤
                       域名解析， cdn解析， 请求头封装
                         DNS解析
                         TCP连接
                         发送HTTP请求
                         服务器处理请求并返回HTTP报文
                         浏览器解析渲染页面
                         连接结束




                 116   TCP/IP如何保证可靠性，数据包有哪些数据组成
                        每次数据传输都与3次握手，如果某一次数据连接没有握手，或者握手失败了，则数据则以丢失处理


                117    长连接与短连接



                118    Http请求get和post的区别以及数据包格式
                         GET在浏览器回退时是无害的，而POST会再次提交请求。
                         GET产生的URL地址可以被Bookmark，而POST不可以。
                         GET请求会被浏览器主动cache，而POST不会，除非手动设置。
                         GET请求只能进行url编码，而POST支持多种编码方式。
                         GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。
                         GET请求在URL中传送的参数是有长度限制的，而POST么有。
                         对参数的数据类型，GET只接受ASCII字符，而POST没有限制。
                         GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。
                         GET参数通过URL传递，POST放在Request body中。
                         于POST，浏览器先发送header，服务器响应100 continue，浏览器再发送data，服务器响应200 ok（返回数据）


                119    简述tcp建立连接3次握手，和断开连接4次握手的过程；关闭连接时，出现TIMEWAIT过多是由什么原因引起，是出现在主动断开方还是被动断开方。

                         TCP协议是有连接的，有连接的意思是开始传输实际数据之前TCP的客户端和服务器端必须通过三次握手建立连接，会话结束之后也要结束连接。而UDP是无连接的
                         TCP协议保证数据按序发送，按序到达，提供超时重传来保证可靠性，但是UDP不保证按序到达，甚至不保证到达，只是努力交付，即便是按序发送的序列，也不保证按序送到。
                         TCP协议所需资源多，TCP首部需20个字节（不算可选项），UDP首部字段只需8个字节。
                         TCP有流量控制和拥塞控制，UDP没有，网络拥堵不会影响发送端的发送速率
                         TCP是一对一的连接，而UDP则可以支持一对一，多对多，一对多的通信。
                         TCP面向的是字节流的服务，UDP面向的是报文的服务。
                         三次握手：
                             (1) 第一次握手：建立连接时，客户端A发送SYN包(SYN=j)到服务器B，并进入SYN_SEND状态，等待服务器B确认。

                             (2) 第二次握手：服务器B收到SYN包，必须确认客户A的SYN(ACK=j+1)，同时自己也发送一个SYN包(SYN=k)，即SYN+ACK包，此时服务器B进入SYN_RECV状态。

                             (3) 第三次握手：客户端A收到服务器B的SYN＋ACK包，向服务器B发送确认包ACK(ACK=k+1)，此包发送完毕，客户端A和服务器B进入ESTABLISHED状态，完成三次握手。

                             完成三次握手，客户端与服务器开始传送数据。

                         四次挥手：
                             （1）客户端A发送一个FIN，用来关闭客户A到服务器B的数据传送(报文段4)。

                             （2）服务器B收到这个FIN，它发回一个ACK，确认序号为收到的序号加1(报文段5)。和SYN一样，一个FIN将占用一个序号。

                             （3）服务器B关闭与客户端A的连接，发送一个FIN给客户端A(报文段6)。

                             （4）客户端A发回ACK报文确认，并将确认序号设置为收到序号加1(报文段7)。


                         为什么TIME_WAIT状态还需要等2MSL后才能返回到CLOSED状态？

                         TIME_WAIT状态由两个存在的理由。

                         （1）可靠的实现TCP全双工链接的终止。

                         这是因为虽然双方都同意关闭连接了，而且握手的4个报文也都协调和发送完毕，按理可以直接回到CLOSED状态（就好比从SYN_SEND状态到ESTABLISH状态那样）；但是因为我们必须要假想网络是不可靠的，你无法保证你最后发送的ACK报文会一定被对方收到，因此对方处于LAST_ACK状态下的SOCKET可能会因为超时未收到ACK报文，而重发FIN报文，所以这个TIME_WAIT状态的作用就是用来重发可能丢失的ACK报文。

                         （2）允许老的重复的分节在网络中消逝。

                         假 设在12.106.32.254的1500端口和206.168.1.112.219的21端口之间有一个TCP连接。我们关闭这个链接，过一段时间后在 相同的IP地址和端口建立另一个连接。后一个链接成为前一个的化身。因为它们的IP地址和端口号都相同。TCP必须防止来自某一个连接的老的重复分组在连 接已经终止后再现，从而被误解成属于同一链接的某一个某一个新的化身。为做到这一点，TCP将不给处于TIME_WAIT状态的链接发起新的化身。既然 TIME_WAIT状态的持续时间是MSL的2倍，这就足以让某个方向上的分组最多存活msl秒即被丢弃，另一个方向上的应答最多存活msl秒也被丢弃。 通过实施这个规则，我们就能保证每成功建立一个TCP连接时。来自该链接先前化身的重复分组都已经在网络中消逝了。

                          从以上TCP连接关闭的状态转换图可以看出，主动关闭的一方在发送完对对方FIN报文的确认(ACK)报文后，会进入TIME_WAIT状态。TIME_WAIT状态也称为2MSL状态。



                120     maven解决依赖冲突,快照版和发行版的区别
                        版本号后面加 SNAPSHOT




                121     Linux下IO模型有几种，各自的含义是什么
                             同步 就是我调用一个功能，该功能没有结束前，我死等结果。只能顺序执行。
                             异步 就是我调用一个功能，不需要知道该功能结果，该功能有结果后通知我（回调通知），往往用回调函数或者其他类方式实现。
                             阻塞 就是调用我（函数），我（函数）没有接收完数据或者没有得到结果之前，我不会返回。
                             非阻塞 就是调用我（函数），我（函数）立即返回，而当我准备完毕时，通过select通知调用者。
                             阻塞式IO（简单迭代型+多进程或者多线程并发型）
                             非阻塞式IO 读写分离
                             IO复用（select / poll） 读写分离，查询到的数据跟自己需求一样，也可以直接获取
                             信号驱动IO（signal）
                             异步IO(async）



                122     实际场景问题，海量登录日志如何排序和处理SQL操作，主要是索引和聚合函数的应用



                123     实际场景问题解决，典型的TOP K问题
                        裁员HashMap


                124     线上bug处理流程




                125     如何从线上日志发现问题
                        1 查找业务日志 ERRPR EXception
                        2 查找NGinx日志，查看ERROR，或者非200状态码请求
                        3 查找Tomcat日志
                        4 前端起手 -> 看代码-> 看日志




                126     linux利用哪些命令，查找哪里出了问题（例如io密集任务，cpu过度）
                        查看LinuxCommand




                127     场景问题，有一个第三方接口，有很多个线程去调用获取数据，现在规定每秒钟最多有10个线程同时调用它，如何做到。
                        redis自然数increase， 然后设置个锁


                128     用三个线程按顺序循环打印abc三个字母，比如abcabcabc。
                        见示例

                129     常见的缓存策略有哪些，你们项目中用到了什么缓存系统，如何设计的
                         1 内存缓存： 不长更新的信息，静态配置
                         2 redis缓存： 单线程缓存服务
                         3 MongoDB缓存：
                         4 meryCache： 内存缓存框架
                         5 文件缓存


                130     设计一个秒杀系统，30分钟没付款就自动关闭交易（并发会很高）




                131     请列出你所了解的性能测试工具
                        1 Spring Insight
                        2

                132     后台系统怎么防止请求重复提交？
                        1 验证码
                        2 使用参数生成唯一指令



                133     有多个相同的接口，我想客户端同时请求，然后只需要在第一个请求返回结果的时候返回给客户端
                134 MyISAM与InnoDB区别
                        InnoDB和MyISAM是许多人在使用MySQL时最常用的两个表类型，这两个表类型各有优劣，视具体应用而定。基本的差别为：MyISAM类型不支持事务处理等高级处理，而InnoDB类型支持。MyISAM类型的表强调的是性能，其执行数度比InnoDB类型更快，但是不提供事务支持，而InnoDB提供事务支持以及外部键等高级数据库功能。
                        1.InnoDB不支持FULLTEXT类型的索引。
                     　　2.InnoDB 中不保存表的具体行数，也就是说，执行select count(*) from table时，InnoDB要扫描一遍整个表来计算有多少行，但是MyISAM只要简单的读出保存好的行数即可。注意的是，当count(*)语句包含 where条件时，两种表的操作是一样的。
                     　　3.对于AUTO_INCREMENT类型的字段，InnoDB中必须包含只有该字段的索引，但是在MyISAM表中，可以和其他字段一起建立联合索引。
                     　　4.DELETE FROM table时，InnoDB不会重新建立表，而是一行一行的删除。
                     　　5.LOAD TABLE FROM MASTER操作对InnoDB是不起作用的，解决方法是首先把InnoDB表改成MyISAM表，导入数据后再改成InnoDB表，但是对于使用的额外的InnoDB特性(例如外键)的表不适用。
                     　　另外，InnoDB表的行锁也不是绝对的，假如在执行一个SQL语句时MySQL不能确定要扫描的范围，InnoDB表同样会锁全表，例如update table set num=1 where name like “%aaa%”




















































     28


     * */





}
