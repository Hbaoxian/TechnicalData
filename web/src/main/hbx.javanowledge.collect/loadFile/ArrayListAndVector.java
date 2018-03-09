package loadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by huangbaoxian on 2018/3/9.
 */
public class ArrayListAndVector {

    public void showDetailArray(){

        List list = new Vector();
        /**
        *
         * LinkedList概述
         *
         * LinkedList 与 ArrayList 一样实现 List 接口，只是 ArrayList 是 List 接口的大小可变数组的实现，LinkedList 是 List 接口链表的实现。基于链表实现的方式使得 LinkedList 在插入和删除时更优于 ArrayList，而随机访问则比 ArrayList 逊色些。

         LinkedList 实现所有可选的列表操作，并允许所有的元素包括 null。

         除了实现 List 接口外，LinkedList 类还为在列表的开头及结尾 get、remove 和 insert 元素提供了统一的命名方法。这些操作允许将链接列表用作堆栈、队列或双端队列。

         此类实现 Deque 接口，为 add、poll 提供先进先出队列操作，以及其他堆栈和双端队列操作。

         所有操作都是按照双重链接列表的需要执行的。在列表中编索引的操作将从开头或结尾遍历列表（从靠近指定索引的一端）。

         同时，与 ArrayList 一样此实现不是同步的。
         *
        * */


        list = new ArrayList();



        /**
        *
         *Vector是多线程安全的，而ArrayList不是，这个可以从源码中看出，Vector类中的方法很多有
         * synchronized进行修饰，这样就导致了Vector在效率上无法与ArrayList相比;
         *
         *
         *  两个都是采用的线性连续空间存储元素，但是当空间不足的时候，两个类的增加方式是不同的，很多网友
         *  说Vector增加原来空间的一倍，ArrayList增加原来空间的50%，其实也差不多是这个意思，不过还有
         *  一点点问题可以从源码中看出，一会儿从源码中分析。
         *  如果Vector 没有设置容量增量，则每次就是翻遍增长，如果设置了增量因子,则增加增量因子的个数
         *
         *  ArrayList和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，
         * 它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数
         * 据慢，Vector由于使用了synchronized方法(线程安全)，通常性能上较ArrayList差。
         *
         *
         *
         *ArrayList,Vector, LinkedList的存储性能和特性

         ArrayList 和 Vector 都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，
         它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，
         Vector 由于使用了 synchronized 方法（线程安全） ，通常性能上较 ArrayList 差，而 LinkedList
         使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历， 但是插入数据时只需要记录本项的前后项即可，
         所以插入速度较快。LinkedList 也是线程不安全的，LinkedList 提供了一些方法，使得LinkedList 可以
         被当作堆栈和队列来使用。
        * */
        list = new Vector();


    }


}

/**、 java集合添加控制
 * //HashMap  允许null-null键值对
 Map<String,String> hashMap = new HashMap<String,String>();
 hashMap.put("11", "ddd");
 hashMap.put("1233", null);
 hashMap.put(null, "wang");
 hashMap.put(null, null);
 System.out.println("HashMap以上代码运行成功");

 //TreeMap  允许value值为null，不允许key值为null
 TreeMap<String,String> treeMap = new TreeMap<String,String>();

 //Map放入第一个元素时不会调用比较器，所以不会调用比较器，不会出现NullPointerException
 //以下一行代码执行时不会报错，但当treeMapp中放入元素大于1时，就会调用比较器，出现NullPointerException
 // treeMap.put(null, null);
 treeMap.put("ddd", null);
 treeMap.put("sss", null);
 System.out.println("TreeMap以上代码运行成功");


 //HashSet
 Set<String> hashSet = new HashSet<String>();
 hashSet.add(null);
 hashSet.add("ddd");
 System.out.println("HashSet以上代码运行成功");

 //TreeSet
 Set<String> treeSet = new TreeSet<String>();
 //以下两行代码执行时，会报错。理由同TreeMap
 //treeSet.add(null);
 treeSet.add("sss");
 System.out.println("TreeSet以上代码运行成功");

 //ArrayList
 List<String> arrayList = new ArrayList<String>();
 arrayList.add(null);
 arrayList.add("dd");
 System.out.println("ArrayList以上代码运行成功");

 //LinkedList
 List<String> linkedList = new LinkedList<String>();
 linkedList.add(null);
 linkedList.add("ddd");
 System.out.println("LinkedList以上代码运行成功");
 }  */
