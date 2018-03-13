package loadFile;

/**
 * Created by huangbaoxian on 18/3/12.
 */
public class ToolTestController {



    /**
     *
     * 网址去重测试
     *
    * */
    private final String[] URLS = {
            "http://www.csdn.net/",
            "http://www.baidu.com/",
            "http://www.google.com.hk",
            "http://www.cnblogs.com/",
            "http://www.zhihu.com/",
            "https://www.shiyanlou.com/",
            "http://www.google.com.hk",
            "https://www.shiyanlou.com/",
            "http://www.csdn.net/"
    };


    private void testBloomFilter() {
        URLFilterTool filter = new URLFilterTool();
        for (int i = 0; i < URLS.length; i++) {
            if (filter.contains(URLS[i])) {
                System.out.println("contain: " + URLS[i]);
                continue;
            }

            filter.add(URLS[i]);
        }
    }

    public static void main(String[] args) {

        String version = "8.0.0.5";
        String version2 = "8.0.0.4";
        if(version.compareTo(version2)>0){
            System.out.print("111");
        }else {
            System.out.print("222");
        }





        //测试网址过滤
        //ToolTestController t = new ToolTestController();
        //t.testBloomFilter();


        //测试多线依赖
        /*
        final Integer[] key = {0};
        new Thread(new Runnable() {
            public void run() {
               while (true){
                   try {
                       key.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   if (key[0] %3 == 0){
                       System.out.print("A");
                       Integer count = key[0];
                       key[0] = count + 1;
                   }else {
                       System.out.print("111");
                   }
                   key.notifyAll();
               }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {

                while (true){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (key[0] %3 == 1){
                        System.out.print("B");
                        Integer count = key[0];
                        key[0] = count + 1;

                    }else {
                        System.out.print("222");
                    }
                    key.notifyAll();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (key[0]%3 == 2){
                        System.out.print("C");
                        Integer count = key[0];
                        key[0] = count + 1;

                    }else {
                        System.out.print("333");
                    }
                    key.notifyAll();
                }
            }
        }).start();

        */




    }

}
