package loadFile;

/**
 * Created by huangbaoxian on 2018/3/15.
 */

/**
 * 二叉树的变量
 *
 * */
public class TreeVariable {


    /*
        二叉树的遍历

        遍历即将树的所有结点访问且仅访问一次。按照根节点位置的不同分为前序遍历，中序遍历，后序遍历。

        前序遍历：根节点->左子树->右子树

        中序遍历：左子树->根节点->右子树

        后序遍历：左子树->右子树->根节点
    */

    /**
     *
     * 1 定义一个二叉树
     *
     *
     *
     * typedef char datatype;

        typedef struct BinNode{
             datatype data;
             struct BinNode* lchild;
             struct BinNode* rchild;
         }BinNode;

        typedef BinNode* bintree;
     *
     *
     *
     *
     *
     *
     * */



    /**
     *
     * 1 非递归实现变量方式
     *
     *
     * void preorder_dev(bintree t){
                     seqstack s;
                     s.top = -1;     //因为top在这里表示了数组中的位置，所以空为-1
                     if(!t){
                     printf("the tree is empty\n");
                     }else{
                     while(t || s.stop != -1){
                     while(t){    //只要结点不为空就应该入栈保存，与其左右结点无关
                     printf("%c ",t->data);
                     push(&s,t);
                     t= t->lchild;
                     }
                     t=pop(&s);
                    t=t->rchild;
                 }
             }
         }
     *
     * */





}
