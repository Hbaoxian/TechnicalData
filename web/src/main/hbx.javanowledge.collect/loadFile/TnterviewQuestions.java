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



     *
     * */





}
