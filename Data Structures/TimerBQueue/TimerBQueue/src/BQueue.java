import java.util.NoSuchElementException;
import sun.applet.AppletViewer;



public class BQueue<T> implements Queue<T> { 

    private T[] queueArray;
    private int qFront, qBack;
    private int qCout, qCapacity;

   
    public BQueue() {
        qCapacity = 50;
        queueArray = (T[])new Object[qCapacity];
        qFront = 0;
        qBack = 0;
        qCout = 0;
    }
    
     public BQueue(int size) {
        qCapacity = size;
        queueArray = (T[])new Object[qCapacity];
        qFront = 0;
        qBack = 0;
        qCout = 0;
    }

    public boolean full(){
        return qCout==qCapacity;
    }
    
    
    @Override
    public void push(T item) {
        if (full()){
            throw new IndexOutOfBoundsException("BQueue push: queue full");
        }
        queueArray[qBack]=item;
        qBack = (qBack+1)%qCapacity;
        qCout++;
    }

    @Override
    public T pop() {
        if(qCout==0){
            throw new NoSuchElementException("BQueue pop(): empty queue");
        }
        T queueFront = queueArray[qFront];
        qFront = (qFront+1)%qCapacity;
        qCout--;
        return queueFront;
    }

    @Override
    public T peek() {
        if(qCout==0){
            throw new NoSuchElementException("BQueue pop(): empty queue");
        }
        T queueFront = queueArray[qFront];
        return queueFront;
    }

    @Override
    public boolean isEmpty() {
        return qCout == 0;
    }

    @Override
    public int size() {
        return qCout;
    }


    
}