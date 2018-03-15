package loadFile;

/**
 * Created by huangbaoxian on 2018/3/15.
 */
public class QuickSorting {

    private static Integer[] originArray = {2,3,4,1,9,5,6,10,8,7};


    int index = 20 ;//定义全局变量，这两个变量需要在子函数中使用



    static void showArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] + " ");
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {


       showArray(originArray);

        sort(originArray, 0 ,originArray.length - 1);
       //sort(0, originArray, originArray.length - 1);

       showArray(originArray);


    }



    static public void sort( Integer[] array, Integer start,Integer end) {

       if (end - start <= 0) return;

        int x = array[start];//标尺
        int p1  = start;
        int p2  = end;
        boolean dr = true;
        L1:  while (p1 < p2) {
            if (dr) {
                for (int i = p2; i >p1; i--) {
                    if (array[i] <= x) {
                        array[p1++] = array[i];
                        p2 = i;
                        dr = !dr;
                        continue L1;
                    }
                }
                p2 = p1;
            }else {

                for (int i = p1 ; i< p2 ; i++) {

                    if (array[i] >= x) {
                        array[p2--] = array[i];
                        p1 = i;
                        dr=!dr;
                        continue L1;
                    }
                }
                p1 = p2;
            }

        }
        array[p1] = x;

        sort(array,start,p1-1);

        sort(array,p1+1,end);
    }

   static void quick_sort(Integer[] s, int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                {
                    j--;

                }

                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                {
                    i++;


                }
                if(i < j)
                    s[j--] = s[i];

            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

}
