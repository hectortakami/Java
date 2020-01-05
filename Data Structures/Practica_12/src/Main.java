
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Main {
    
     public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> setUnion = new TreeSet<>();
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            setUnion.add(iterA.next());
        }
        Iterator<T> iterB = setB.iterator();
        while (iterB.hasNext()) {
            setUnion.add(iterB.next());
        }
        return setUnion;

    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {

        Set<T> setIntersection = new TreeSet<>();
        T item;

        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            item = iterA.next();
            if (setB.contains(item)) {
                setIntersection.add(item);
            }
        }
        return setIntersection;

    }
    
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {

        Set<T> setDifference = new TreeSet<>();
        T item;
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            item = iterA.next();
            if (!setB.contains(item)) {
                setDifference.add(item);
            }
        }
        return setDifference;

    }
    
    public static <T> boolean subSet(Set<T> setA, Set<T> setB) {
        return intersection(setA, setB).size() == setA.size();
    }
    
    private static void output(Set<?> s){
        Iterator iter = s.iterator();
        int counter = 0;
        String str = "";
        while (iter.hasNext()){
            
            if (counter<5){
                str+= iter.next() + ", ";
                counter++;
                
            }else{
                str+= "\n";
                counter = 0;
            }            
        }
        System.out.println(str.substring(0, str.length()-2) + "\n");
    }
 
  public static void main(String[] args){
      
      System.out.println("(A)");
      System.out.println("1. Respuestas.txt");
      
      System.out.println("**************************************************");
      
      System.out.println("2.");
      
      String strA = "DORMAMMU";
      String strB = "AGAMOTTO";
      String vowels = "AEIOU";
      
      Set<Character> setA = new TreeSet<>(),setB = new TreeSet<>(),setC = new TreeSet<>(),
                     setD = new TreeSet<>(),setE = new TreeSet<>(),setF = new TreeSet<>(),
                     setVowels = new TreeSet<>();
      
      char[] charA = strA.toCharArray();
      char[] charB = strB.toCharArray();
      char[] charVowels = vowels.toCharArray();
      
      for (int i = 0; i < charA.length; i++) {
          setA.add(charA[i]);          
      }
      for (int i = 0; i < charB.length; i++) {
          setB.add(charB[i]);          
      }      
      for (int i = 0; i < charVowels.length; i++) {
          setVowels.add(charVowels[i]);
      }
      
      System.out.println("-SetA: " + setA.toString());
      System.out.println("-SetB: " + setB.toString());
      System.out.println("-SetVowels: " + setVowels.toString() + "\n");
      
   
      setC = union(difference(setA, setB), difference(setB, setA));
      System.out.println("\ta)SetC: " + setC.toString());
      
      setD = difference(setVowels, setA);
      System.out.println("\tb)SetD: " + setD.toString());
      
      setE = union(intersection(setVowels, setA), intersection(setVowels, setB));
      System.out.println("\tb)SetE: " + setE.toString());
      
      setF = difference(union(setA, setB), setE);
      System.out.println("\tb)SetF: " + setF.toString());
      
      System.out.println("**************************************************");
      
      System.out.println("3.");
      
      String[] mensActivities = {"football", "baseball", "basketball", "golf", "swimming", "tennis", "volleyball","waterpolo"};
      String[] womensActivities = {"softball", "basketball", "soccer", "swimming", "waterpolo", "volleyball", "cross country", "field hockey"};
      Set<String> menSet = new TreeSet<>(), womenSet = new TreeSet<>(), bothSet = new TreeSet<>();
      for (int i = 0; i < mensActivities.length; i++) {
         menSet.add(mensActivities[i]);
      }
      for (int i = 0; i < womensActivities.length; i++) {
          womenSet.add(womensActivities[i]);
      }
      bothSet = intersection(menSet, womenSet);
     
      System.out.println("-Mens Activities: ");
      output(menSet);  
      
      System.out.println("-Womens Activities: ");
      output(womenSet);
      
      System.out.println("-Activities than can do both: ");
      output(bothSet);
      
      System.out.println("**************************************************");
      
      System.out.println("4.");
      
      String[] cities = {"San Francisco","Chicago","Denver","Seattle","Miami","Detroit"};
      String[] teamNames = {"Forty-niners","Bears","Broncos","Seahawks","Dolphins","Lions"};

      TreeMap<String, String> NFLteamUp = new TreeMap<>();
      for (int i = 0; i < cities.length; i++) {
          NFLteamUp.put(cities[i], teamNames[i]);
      }
      
      System.out.println(" a) MapSize: " + NFLteamUp.size());
      System.out.println(" b)" + NFLteamUp.values() );
      NFLteamUp.put("San Francisco", "Niners");
      System.out.println(" ---> " + NFLteamUp.values());
      System.out.println(" c) San Diego has a team?: " + NFLteamUp.containsKey("San Diego"));
      System.out.println(" d)" + NFLteamUp.values());
      NFLteamUp.remove("Denver");
      System.out.println(" ---> " + NFLteamUp.values());
      System.out.println("e) Add Dallas-Cowboys:" );
      NFLteamUp.put("Dallas", "Cowboys");
      System.out.println(" ---> " + NFLteamUp.values());
      System.out.println("f) EntrySet() removing keys starting with 'M' or 'Z' ");
      Set<Map.Entry<String,String>> values = NFLteamUp.entrySet();
      Iterator<Map.Entry<String,String>> iter = values.iterator();
      ArrayList<String> a = new ArrayList<>();
      while(iter.hasNext()){
          Map.Entry<String,String> n = iter.next();         
          if (n.getKey().startsWith("M")){
              a.add(n.getKey());
          }
      }
      for (int i = 0; i < a.size(); i++) {
          NFLteamUp.remove(a.get(i));
      }      
      System.out.println("g)" + NFLteamUp.entrySet());
      
      System.out.println("**************************************************");
      System.out.println("**************************************************");

      System.out.println("(B)");
      System.out.println("1. Respuestas.txt");
      
      System.out.println("2. Respuestas.txt");
      
      
      int[] num = {7, 12, 15, 19, 53, 68, 3, 33, 57, 45, 25};
      LinearProbingHash lP = new LinearProbingHash(num.length);
    
  }
  

      
 
      
  
     
      
  
  
}
