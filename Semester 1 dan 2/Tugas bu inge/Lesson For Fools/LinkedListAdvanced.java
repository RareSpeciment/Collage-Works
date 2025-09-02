public class LinkedListAdvanced {
    static class Mahasiswa {
        String name;
        String nik;
        Mahasiswa next;
        Mahasiswa prev;

        public Mahasiswa(String name, String nik) {
            this.name = name;
            this.nik = nik;
            this.next = null;
            this.prev = null;
        }
    }

    static Mahasiswa head = null;

    public static void addFirst(String name, String nik) {
        if(head == null) {
            Mahasiswa newMahasiswa = new Mahasiswa(name, nik);
            head = newMahasiswa;
        } else {
            Mahasiswa newMahasiswa = new Mahasiswa(name, nik);
            newMahasiswa.next = head;
            head.prev = newMahasiswa;
            head = newMahasiswa;
        }
    }

    public static void addLast(String name, String nik) {
        if(head == null) {
            Mahasiswa newMahasiswa = new Mahasiswa(name, nik);
            head = newMahasiswa;
        } else {
            Mahasiswa temp = head;
            Mahasiswa newMahasiswa = new Mahasiswa(name, nik);
            do {
                temp = temp.next;
            }while(temp.next != null);

            temp.next = newMahasiswa;
            newMahasiswa.prev = temp;
        }
    }

    public static void print() {
        Mahasiswa temp = head;
        do {
            System.out.print("|" + temp.nik + "|=>");
            temp = temp.next;
        }while(temp != null);
    }

    public static void main(String[] args) {
        addFirst("John", "123");
        addFirst("asd", "321");
        addFirst("asd", "333");
        addLast("John", "444");
        addFirst("xxx","111");

        print();
    }
}
