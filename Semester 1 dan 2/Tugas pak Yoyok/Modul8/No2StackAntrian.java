import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class No2StackAntrian {
    private Stack<String> stack = new Stack<>();
    private String[] nomorAntrian;
    private int index = 0;

    public No2StackAntrian(int capacity) {
        nomorAntrian = new String[capacity];
    }

    public void addNomorAntrian(String nomor) {
        if (index < nomorAntrian.length) {
            nomorAntrian[index] = nomor; // Add the number to the array
            stack.push(nomor); // Push the number onto the stack
            index++;
            System.out.println("Tambahkan Nomor Antrian: " + nomor + " ke dalam Stack");
        } else {
            System.out.println("Array penuh! Tidak dapat menambahkan nomor antrian.");
        }
    }

    public String getNomorAntrian() {
        if (stack.isEmpty()) {
            return "Stack Kosong";
        }

        List<String> sortedList = new ArrayList<>(stack);
        Collections.sort(sortedList);

        String nomorTerkecil = sortedList.get(0);
        Stack<String> tempStack = new Stack<>();
        while(!stack.isEmpty()) {
            String s = stack.pop();
            if (!s.equals(nomorTerkecil)) {
                tempStack.push(s);
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return nomorTerkecil;
    }

    public void printStack() {
        if (stack.isEmpty()) {
            System.out.println("Stack Kosong");
        } else {
            System.out.println("Nomor Antrian dalam Stack: " + stack);
        }
    }

    public static void main(String[] args) {
        No2StackAntrian at = new No2StackAntrian(10);
        at.addNomorAntrian("A001");
        at.addNomorAntrian("A002");
        at.addNomorAntrian("A003");
        at.addNomorAntrian("A004");
        at.addNomorAntrian("A005");
        at.addNomorAntrian("A006");
        at.addNomorAntrian("A007");
        at.addNomorAntrian("A008");
        at.addNomorAntrian("A009");
        at.addNomorAntrian("A010");
        at.printStack();

        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 1");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 2");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 3");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 1");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 2");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 1");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 3");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 2");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 3");
        System.out.println("No. Antrian " + at.getNomorAntrian() + " ke loket 1");
    }
}