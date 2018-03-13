package loadFile;

/**
 * Created by huangbaoxian on 2018/3/13.
 */
public class ThreadDepend2 extends Thread {

    private static int currentCount = 0;

    public ThreadDepend2(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (currentCount < 30) {
            switch (currentCount % 3) {
                case 0:
                    if ("A".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 1:
                    if ("B".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 2:
                    if ("C".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
            }
        }

    }

    private void printAndIncrease() {
        print();
        increase();
    }

    private void print() {
        System.out.println(getName());
        if ("C".equals(getName())) {
            System.out.println();
        }
    }

    private void increase() {
        currentCount++;
    }

    public static void main(String[] args) {
        new ThreadDepend2("A").start();
        new ThreadDepend2("B").start();
        new ThreadDepend2("C").start();
    }


}
