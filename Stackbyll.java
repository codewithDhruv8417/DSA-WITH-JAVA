class Node
{   int data;
    Node next;
    Node(int data)
    {
        this.data= data;
        next = null;
    }
}
class Stackforll
{
    Node top;
    Stackforll()
    {
        top = null;
    }
    void push(int data)
    {
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
    }
    void pop()
    {
        if(top == null)
        {
            System.out.println("STack underFlow");
        }
        else{
            top = top.next;
        }
    }
    void peek()
    {
        if(top == null)
        {
            System.out.println("Stack is empty");
        }
        else{
            System.out.println(top.data);
        }
    }
    void display()
    {
        if(top == null)
        {
            System.out.println("Stack is empty");
        }
        else {
            Node temp = top;
            while(temp != null)
            {
                System.out.println(temp.data +" ");
                temp = temp.next;
            }
        }
    }
    
    boolean isEmpty() {
        return top == null;
    }

}
public class Stackbyll {
    public static void main(String[] args) {
        Stackforll st = new Stackforll();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        // st.display(); output 40 30 20 10
        st.pop();
        st.peek();
    }
}
