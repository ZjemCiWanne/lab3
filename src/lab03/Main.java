package lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Set<String> zbiorDni = new TreeSet<>();//treeset sortuje alfabetycznie
        // zbiorDni.add("poniedziaĹ‚ek");
        // zbiorDni.add("wtorek");
        // zbiorDni.add("sroda");
        // zbiorDni.add("czwartek");
        // zbiorDni.add("piatek");
        // System.out.println(zbiorDni);
        List<Student>studenci=new ArrayList<>();
        studenci.add(new Student("Jan", "Kowalski"));
        studenci.add(new Student("Janek", "Chybaty"));
        studenci.add(new Student("Jan", "Kowalski"));

        List<Student>studenci1=new ArrayList<>();
        studenci1.add(new Student("Jakubowski", "Kowalski"));
        studenci1.add(new Student("Janusz", "Chybaty"));
        studenci1.add(new Student("Grazynka", "Kowalskeiego"));

        Map< Integer, List<Student> > grupy = new HashMap<>();
        grupy.put(32,studenci);
        grupy.put(33,studenci1);
        List<Student> m1 =grupy.get(32);
        System.out.println(m1+" <------To jest grupa 32");

        System.out.println("  ");
        Map< String,Teacher> grupy_teacherow = new HashMap<>();

        grupy_teacherow.put("programowanie obiektowe",new Teacher("Janek","Taczka"));
        grupy_teacherow.put("przedmiot 1",new Teacher("Jak","Ta"));
        grupy_teacherow.put("przedmiot 2",new Teacher("Jan","Tacz"));

        Teacher t1 =grupy_teacherow.get("programowanie obiektowe");
        System.out.println(t1 + "<----- Nauczyciel od Programowania");

        List<Product> produkciki = new ArrayList<>();
        Map<Integer,Product> mapaProductowId =new HashMap<>();
        Map<String,List<Product>> mapaProductowCategory =new HashMap<>();

        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String s = in.readLine();


            while(s!=null) {
                String[] pola = s.split(";");
                // System.out.println(pola[0]);=====ID
                //  System.out.println(pola[1]);=====Nazwa
                // System.out.println(pola[2]);=====categoria
                // System.out.println(pola[3]);=====Cena

                double c = Double.parseDouble(pola[3]);
                Integer a = Integer.parseInt(pola[0]);

                Product p1 =new Product(a,pola[1],c,pola[2]);

                produkciki.add(p1);

                mapaProductowId.put(a, p1);


                s = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for(Product p:produkciki) {

            String cat=p.getCategory();
            if(!mapaProductowCategory.containsKey(cat)) {

                mapaProductowCategory.put(cat,new ArrayList());
            }

            mapaProductowCategory.get(cat).add(p);

        }

        System.out.println("Wyszukiwanie za pomocą id");
        System.out.println(mapaProductowId.get(103));
        System.out.println("Wyszukiwanie za pomocą kategorii");
        System.out.println(mapaProductowCategory.get("słodycze"));


    }


}
