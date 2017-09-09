package cn.vbiso.java8;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;

/**
 * Created by v on 2017/9/9.
 */
public class TestLamada {



    public static void main(String[] args){
        ArrayList<String> alist=new ArrayList<String>();
        alist.add("a");
        alist.add("b");
        alist.add("c");
        alist.forEach(e->{
            System.out.println(e);
        });

        for(int i=0;i<alist.size();i++){
            System.out.println(alist.get(i));
        }


    }
}
