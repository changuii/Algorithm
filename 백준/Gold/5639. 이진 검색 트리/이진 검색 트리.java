import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer> A = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String value = "";
        while (true){
            value = br.readLine();
            if(value == null || value.equals("")) break;
            A.add(Integer.parseInt(value));
        }

        Node root = new Node(A.get(0));
        for(int i=1; i<A.size(); i++){
            Node now = root;
            int target = A.get(i);
            while (true){
                if(now.value > target){
                    if(now.left == null){
                        now.left = new Node(target);
                        break;
                    }else{
                        now = now.left;
                    }
                }else if(now.value < target){
                    if(now.right == null){
                        now.right = new Node(target);
                        break;
                    }else{
                        now = now.right;
                    }
                }
            }
        }
        postOrder(root);




    }



    public static void postOrder(Node now){
        if(now == null) return;

        postOrder(now.left);
        postOrder(now.right);

        System.out.println(now.value);


    }


    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }

}