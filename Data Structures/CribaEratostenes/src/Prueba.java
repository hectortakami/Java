/*
Autor: Hector Manuel Takami Flores
A01377647
 */
public class Prueba {
    
    public static void main(String[] args) {
        final int PRIMELIMIT = 500;
        Bag<Integer> bag = new Bag<>();
        bag.sieve(PRIMELIMIT); 
        writePrimes(bag.toArray());
        System.out.println();
        
    }
    
        public static void writePrimes(Object[] arr) {
        {
            String intStr;
            int count = 1, i;
            StringBuffer sb = new StringBuffer("      ");
            for (i = 0; i < arr.length; i++) {
                intStr = arr[i].toString();
               sb.replace(0, intStr.length(), intStr);
                System.out.print(sb.toString());
                if (count % 10 == 0) {
                    System.out.println();
                }
                count++;
            }
        }
    }
    
}



