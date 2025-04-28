package lektion17;

public class MyExceptions {

    public static void main(String[] args) {
      //  NumberFehlerEx();
       // AIOutofBoundsFehlerEx();
       // NullPointerFehlerEx();
       // OutofMemoryEx();
       //FileNotFoundEx();
        //ArithmeticEx();
    }

    public static void NumberFehlerEx() {

            String fehl = "abc";
            int tryy = Integer.valueOf(fehl);

    }

    public static void AIOutofBoundsFehlerEx() {
            int[] arr = new int[3];
            int tryy = arr[4];

    }

    public static void NullPointerFehlerEx() {
        try {
            String text = null;
            int tryy = text.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException wurde gewirft.=> " + e.getMessage());
        }
    }

    public static void OutofMemoryEx() {
                    int[][] hugearr = new int[100000][100000];
    }

    public static void FileNotFoundEx() {
        try {
            java.io.FileReader file = new java.io.FileReader("nonexistentfile.txt");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("FileNotFoundException wurde gewirft.=> " + e.getMessage());
            ;
        }
    }

    public static void ArithmeticEx() {

            int tryy = 10 / 0;

    }
}

