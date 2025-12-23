class Stackusingjava
{
    int []arr;
    int top;
    int size;
    Stackusingjava(int size)
    {
        this.size = size;
        arr = new int[size];
        top = -1;
    }
    void push(int elements)
    {
        if(size - top > 1)
        {
          top++;
          arr[top] = elements;
        }
        else{
            System.out.println("Stack over flow");
        }
    }
    void pop()
    {
        if(top >= 0)
        {
            top--;
        }
        else{
            System.out.println("Stack underflow");
        }

    }
    void peek()
    {
        if(top>=0)
        {
            System.out.println(arr[top]) ;
        }
        else{
         System.out.println("Stack is empty");
        }
    }
    boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        else{
            return false;
        }
    }
    void display()
    {
        if(top == -1)
        {
            return;
        }
        for(int i = top;i>=0;i--)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
public class Stack {
    public static void main(String[] args) {
        Stackusingjava st = new Stackusingjava(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.display();
    }
}
