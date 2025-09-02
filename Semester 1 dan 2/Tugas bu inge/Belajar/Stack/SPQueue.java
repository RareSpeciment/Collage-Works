package Belajar.Stack;

public class SPQueue {
    static final int MaxQ = 5;
    static final int MaxPrio = 3;

    static class SQueue {
        int head;
        int tail;
        char [] S = new char[MaxQ - 1];
    }

    SQueue [] PQueue1 = new SQueue[MaxPrio - 1];
    SQueue [] PQueue2 = new SQueue[MaxPrio - 1];

    //initialisasi
    public static void init(SQueue [] queue, int prio){
        queue[prio] = new SQueue();
        queue[prio].head = -1;
        queue[prio].tail = -1;
    }

    //isFull and isEmpty
    public static boolean isFull(SQueue [] queue, int prio){
        return queue[prio].tail == MaxQ -1;
    }

    public static boolean isEmpty(SQueue [] queue, int prio){
        return queue[prio].head == -1;
    }

    //Insert
    public static boolean insert(SQueue [] queue, int prio, char value){
        if(isFull(queue,prio)){
            return false;
        }else{
            if(isEmpty(queue, prio)){
                queue[prio].head = 0;
            }

            queue[prio].tail++;
            queue[prio].S[queue[prio].tail] = value;
            return true;
        }
    }

    //delete
    public static char delete(SQueue [] queue){
        for(int i = 0; i < MaxPrio; i++){
            if(!isEmpty(queue, i)){
                char temp = queue[i].S[queue[i].head];
                if(queue[i].head == queue[i].tail){
                    queue[i].head = -1;
                    queue[i].tail = -1;
                }else{
                    queue[i].head++;
                }
                return temp;
            }
        }
        return '*';
    }

    static void print(SQueue [] queue){
        for(int i = 0; i < MaxPrio; i++){
            for(int j = 0; j < MaxQ; j++){
                if(isEmpty(queue,i)){
                    System.out.println("Kosong");
                }else{
                    System.out.println(queue[i].S[j]);
                }
            }
        }
    }
}
