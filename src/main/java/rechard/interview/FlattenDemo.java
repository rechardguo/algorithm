package rechard.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlattenDemo {

    static class Node <K,V>{
         List<Node> child;
         public K k;
         V v;
         Map<K,Node> m;
        public Node() {
            child=new ArrayList<>();
            m=new HashMap();
        }

        //strNode "a.b.c":22
        public void add(Node node,String strNode){
            String[] pair=strNode.split(":");
            String val=pair[1];
            String[] keys=pair[0].split(":");
            add0(this,keys,0,val);
        }

        private void add0(Node node,String[] keys,int i,String value){
           if(i==keys.length){
               return;
           }
            Node n=null;
            if((n= (Node) node.m.get(k))==null){
                n=new Node();
                m.put((K) n.k,n);
            }
            add0(n,keys,i++,value);
         }

        public String flat(String str){
            FlattenDemo.Node root=new FlattenDemo.Node();

            String[] nodes=str.split(",");
            for(String node:nodes){
                root.add(root,node);
            }

            return root.toString();

        }

        @Override
        public String toString() {
            StringBuffer buffer=new StringBuffer();
            return "";

        }
    }




    public static void main(String[] args) {
        System.out.println(new Node().flat("{A:1,B.A:2,B.B:3,CC.D.E:4,CC.D.F=5}"));
    }
}
