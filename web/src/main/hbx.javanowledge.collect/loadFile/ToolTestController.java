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
        ToolTestController t = new ToolTestController();
        t.testBloomFilter();
    }

}
