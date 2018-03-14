package loadFile;

/**
 * Created by huangbaoxian on 2018/3/14.
 */
//并发包
public class Concurrent {
    /**
    *
     *
     *
     *Concurrent包
     *
     *
     Executor
     Executor接口是所有线程执行类的父接口，这个接口可以建立线程池，然后执行线程。
     Executor框架的最核心的类是ThreadPoolExecutor，它是线程池的实现类，创建ThreadPoolExecutor一般使用Executors工厂模式创建，Executors类提供了一系列工厂方法用于创先线程池：
     public static ExecutorService newFixedThreadPool(int nThreads)创建固定数目线程的线程池，表示最多创建nThreads个线程，如果传入的任务数大于nThreads时不会创建新的线程，而是阻塞等待有空闲线程执行。
     public static ExecutorService newCachedThreadPool()创建一个可缓存的线程池，调用execute将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60秒钟未被使用的线程。
     public static ExecutorService newSingleThreadExecutor()创建一个单线程化的Executor。
     public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
     常用方法：
     shutDown():关闭执行器，在关闭前允许执行以前提交的任务执行器执行完。调用shutDown()后，再发送任务给Executor将会被拒绝，抛出RejectExecutionException异常。
     shutdownNow() :立即关闭执行器，阻止等待任务启动，并试图停止当前正在执行的任务。返回等待执行的任务列表。
     isShutdown():调用shutDown()后，返回true。
     isTerminated():调用shutDown()后，并且执行器完成了关闭过程，返回true。
     getPoolSize():获取当前线程池的线程数量
     getActiveCount():获取线程池中活动线程的数量
     getCompleteCount():获取线程池中完成的任务数。
     ExecutorService
     ExecutorService可以帮助我们建立线程池。










     BlockingQueue
     阻塞队列跟信号量差不多，比如生产者消费者问题中，如果不用阻塞队列，采用非阻塞队列存放产品的话，需要用synchronized来对produce()和consume()操作进行同步，而采用阻塞队列就不需要这样了，它自身就带同步功能，当空时自然不能取，满时自然不能继续生产，这就是BlockingQueue的作用。
     阻塞队列使用最经典的场景就是socket客户端数据的读取和解析，读取数据的线程不断将数据放入队列，然后解析线程不断从队列取数据解析。还有其他类似的场景，只要符合生产者-消费者模型的都可以使用阻塞队列。



     Semphore
     信号量Semaphore是一个计数信号量，用来保护一个或多个共享资源的访问，是Java Concurrent包下提供的另一种同步方式，就像synchronized一样的呢，它就是替代synchronized的。 Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。





     Future
     可以得到Callable接口与Runnable接口执行的返回值，也可以调用cancel方法取消线程的执行。
     Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
     也就是说Future提供了三种功能：
     1）判断任务是否完成；
     2）能够中断任务；
     3）能够获取任务执行结果。
     因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask。
     Callable
     Callable接口与Runnable接口实现的功能都是一样的，不过它有返回值的，我们可以知道线程是否执行完毕呢。通常与Future，FutureTask连着用。



     ThreadPoolExecutor


     CylicBarrier
     ThreadLocal


     CountDownLatch
     CountDownLatch是Java Concurrent包下提供的同步辅助类。在完成一组正在其他线程中执行的操作之前，它允许线程一直等待。
     和Semaphore类似，它使用一个整数进行初始化，Semaphore中的计算表示可以同步访问共享数据的线程数，CountDownLatch中的计算表示线程要等待的操作数数目。
     CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
     操作方法

     构造函数CountDownLatch(int count)，count表示要等待的操作数的数目。
     await()方法，阻塞等待，需要其他线程完成期待的操作，直到count为0。
     countDown()方法，当某一个操作完成后，调用此方法，count数减一。
     下面对上面说的三个辅助类进行一个总结：
     1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
     CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
     而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
     另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
     2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。






     ThreadFactory
     ThreadFactory是一个接口，就是一个工厂模式的典型。
     线程工厂（ThreadFactory接口）
     在创建线程的时候，我们当然也能使用工厂模式来生产Thread，ThreadFactory是用来实现创建线程的工厂模式接口，其实它只有一个方法Thread newThread(Runnable r)，所以这个接口没多大用，可以自己编写新接口。
     使用ThreadFactory工厂这样就能替代默认的new Thread，而且在自定义工厂里面，我们能创建自定义化的Thread，并且计数，或则限制创建Thread的数量，给每个Thread设置对应的好听的名字，或则其他的很多很多事情。
     ThreadFactory在并发中的使用
     在Java中使用ThreadFactory最多应该就是Executor框架和Fork\/Join框架了，使用ThreadFactory创建各种线程池中的线程。在Executor框架中，使用Executors创建线程池执行器的时候，也可以传入ThreadFactory对象，执行器将会使用该ThreadFactory对象来创建线程。
     如：newCachedThreadPool(ThreadFactory threadFactory)




     Condition
     发包下的提供Lock锁，Lock可以更好的解决线程同步问题，使之更面向对象，并且ReadWriteLock在处理同步时更强大，那么同样，线程间仅仅互斥是不够的，还需要通信，本篇的内容是基于上篇之上，使用Lock如何处理线程通信。
     那么引入本篇的主角，Condition，Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set （wait-set）。其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。
     在Condition中，用await()替换wait()，用signal()替换notify()，用signalAll()替换notifyAll()，传统线程的通信方式，Condition都可以实现，这里注意，Condition是被绑定到Lock上的，要创建一个Lock的Condition必须用newCondition()方法。
     Condition的强大之处在于它可以为多个线程间建立不同的Condition， 使用synchronized\/wait()只有一个阻塞队列，notifyAll会唤起所有阻塞队列下的线程，而使用lock\/condition，可以实现多个阻塞队列，signalAll只会唤起某个阻塞队列下的阻塞线程。
     ReentrantLock
     可重入锁与synchronized比较？
     由于ReentrantLock是java.util.concurrent包下提供的一套互斥锁，相比Synchronized，ReentrantLock类提供了一些高级功能，主要有以下3项：
     1.等待可中断，持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，这相当于Synchronized来说可以避免出现死锁的情况。
     2.公平锁，多个线程等待同一个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁非公平锁，ReentrantLock默认的构造函数是创建的非公平锁，可以通过参数true设为公平锁，但公平锁表现的性能不是很好。
     3.锁绑定多个条件，一个ReentrantLock对象可以同时绑定对个对象。




     ThreadLocal
     线程私有变量，就是我们在建立类的时候可以把成员变量声明为线程私有的， 最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。 ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
     准确的说，应该是ThreadLocal类型的变量内部的注册表（Map<Thread,T>）发生了变化，但ThreadLocal类型的变量本身的确是一个，这才是本质！
     虽然ThreadLocal变量只有一个，各个线程共享，但是ThreadLocal内部维护一个Map<Thread,T>，通过线程Id每个线程都维护唯一的一个变量。



     一.synchronized的缺陷以及与Lock的区别
     synchronized是java中的一个关键字，也就是说是Java语言内置的特性。那么为什么会出现Lock呢？
     在上面一篇文章中，我们了解到如果一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待，等待获取锁的线程释放锁，而这里获取锁的线程释放锁只会有两种情况：
     1）获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
     2）线程执行发生异常，此时JVM会让线程自动释放锁。
     那么如果这个获取锁的线程由于要等待IO或者其他原因（比如调用sleep方法）被阻塞了，但是又没有释放锁，其他线程便只能干巴巴地等待，试想一下，这多么影响程序执行效率。
     因此就需要有一种机制可以不让等待的线程一直无期限地等待下去（比如只等待一定的时间或者能够响应中断），通过Lock就可以办到。
     再举个例子：当有多个线程读写文件时，读操作和写操作会发生冲突现象，写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
     但是采用synchronized关键字来实现同步的话，就会导致一个问题：
     如果多个线程都只是进行读操作，所以当一个线程在进行读操作时，其他线程只能等待无法进行读操作。
     因此就需要一种机制来使得多个线程都只是进行读操作时，线程之间不会发生冲突，通过Lock就可以办到。
     另外，通过Lock可以知道线程有没有成功获取到锁。这个是synchronized无法办到的。
     总结一下，也就是说Lock提供了比synchronized更多的功能。但是要注意以下几点：
     1）Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。Lock是一个类，通过这个类可以实现同步访问；
     2）Lock和synchronized有一点非常大的不同，采用synchronized不需要用户去手动释放锁，当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；而Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致出现死锁现象。
     3）Lock提供lock(),tryLock(),tryLock(long time, TimeUint uint)，unlock()这些方法，tryLock有返回值，看看返回是否成功。



     Lock和synchronized的选择
     总结来说，Lock和synchronized有以下几点不同：
     1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
     2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
     3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
     4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
     5）Lock可以提高多个线程进行读操作的效率。
     在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock的性能要远远优于synchronized。所以说，在具体使用时要根据适当情况选择。






     二.锁的相关概念介绍
     在前面介绍了Lock的基本使用，这一节来介绍一下与锁相关的几个概念。
     1.可重入锁
     如果锁具备可重入性，则称作为可重入锁。像synchronized和ReentrantLock都是可重入锁，可重入性在我看来实际上表明了锁的分配机制：基于线程的分配，而不是基于方法调用的分配。举个简单的例子，当一个线程执行到某个synchronized方法时，比如说method1，而在method1中会调用另外一个synchronized方法method2，此时线程不必重新去申请锁，而是可以直接执行方法method2。
     看下面这段代码就明白了：
     class MyClass {
     public synchronized void method1() {
     method2();
     }

     public synchronized void method2() {

     }
     }
     上述代码中的两个方法method1和method2都用synchronized修饰了，假如某一时刻，线程A执行到了method1，此时线程A获取了这个对象的锁，而由于method2也是synchronized方法，假如synchronized不具备可重入性，此时线程A需要重新申请锁。但是这就会造成一个问题，因为线程A已经持有了该对象的锁，而又在申请获取该对象的锁，这样就会线程A一直等待永远不会获取到的锁。
     而由于synchronized和Lock都具备可重入性，所以不会发生上述现象。
     2.可中断锁
     可中断锁：顾名思义，就是可以相应中断的锁。
     在Java中，synchronized就不是可中断锁，而Lock是可中断锁。
     如果某一线程A正在执行锁中的代码，另一线程B正在等待获取该锁，可能由于等待时间过长，线程B不想等待了，想先处理其他事情，我们可以让它中断自己或者在别的线程中中断它，这种就是可中断锁。
     在前面演示lockInterruptibly()的用法时已经体现了Lock的可中断性。
     3.公平锁
     公平锁即尽量以请求锁的顺序来获取锁。比如同是有多个线程在等待一个锁，当这个锁被释放时，等待时间最久的线程（最先请求的线程）会获得该所，这种就是公平锁。
     非公平锁即无法保证锁的获取是按照请求锁的顺序进行的。这样就可能导致某个或者一些线程永远获取不到锁。
     在Java中，synchronized就是非公平锁，它无法保证等待的线程获取锁的顺序。
     而对于ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁，但是可以设置为公平锁。
     *
     *
     *
     *
     *
     * */
}
