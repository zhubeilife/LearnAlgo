// From https://www.cnblogs.com/evasean/p/7273857.html

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class ElemsMoreThanNDivTenTimes {

    private class Element{//辅助空间元素定义，用来记录元素值及其出现次数
        public int element;
        public int count;
        public Element(int e,int c){
            this.element = e;
            this.count = c;
        }
    };
    private Element[] elems = new Element[9]; //申请9个辅助空间


    public ArrayList<Integer> findElements(int[] arrays){
        int n = arrays.length;
        for(int k=0;k<9;k++){
            elems[k] = new Element(0,0); //辅助空间初始化
        }
        for(int i=0;i<n;i++){
            int index = findIndex(arrays[i]);
            if(index >= 0)
                elems[index].count ++;
            else
                addToElems(arrays[i]);
        }
        return verifyElems(arrays);
    }

    private int findIndex(int e){
        for(int k = 0; k<9;k++){
            if(elems[k].element == e)
                return k;
            else if(elems[k].count == 0){
                elems[k].element = e;
                return k;
            }
        }
        return -1;
    }
    private void addToElems(int e){
        boolean insertFlag = false;
        while(!insertFlag){
            for(int k=0; k<9;k++){
                elems[k].count --;
                if(elems[k].count <= 0){
                    elems[k].element = e;
                    elems[k].count = 1;
                    insertFlag = true;
                    break;
                }
            }
        }
    }
    private ArrayList<Integer> verifyElems(int[] arrays){
        int n = arrays.length;
        for(int k = 0; k< 9; k++){
            elems[k].count = 0;
            for(int i = 0; i< n;i++){
                if(arrays[i]==elems[k].element)
                    elems[k].count++;
            }
        }
        ArrayList<Integer> elemList = new ArrayList<Integer>();
        for(int k = 0; k< 9; k++){
            if(elems[k].count > n/10)
                elemList.add(elems[k].element);
        }
        return elemList;
    }

    public static void main(String[] args){
        int n = 20;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = StdRandom.uniform(n);
        }
        System.out.println(Arrays.toString(array));
        ElemsMoreThanNDivTenTimes elems = new ElemsMoreThanNDivTenTimes();
        ArrayList<Integer> elemList =  elems.findElements(array);
        System.out.println(elemList.toString());
    }
}