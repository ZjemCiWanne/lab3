package lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Set<String> zbiorDni = new TreeSet<>();//treeset sortuje alfabetycznie
        // zbiorDni.add("poniedziałek");
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
        Map<Integer,Product> mapa_productow =new HashMap<>();
        Map<String,List<Product>> mapa_productow1 =new HashMap<>();

        List<Product>slodycze=new ArrayList<>();
        List<Product>narzedzia=new ArrayList<>();
        List<Product>oprogramowanie=new ArrayList<>();
        List<Product>inne=new ArrayList<>();
        List<Product>nowa_kategoria=new ArrayList<>();
        String zmienna_kategorii="";


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
                mapa_productow.put(a,p1);

                switch (pola[2])
                {
                    case "słodycze":
                        slodycze.add(p1);
                        break;
                    case "narzędzia":
                        narzedzia.add(p1);
                        break;
                    case "oprogramowanie":
                        oprogramowanie.add(p1);
                        break;
                    case "inne":
                        inne.add(p1);
                        break;
                        default:
                            nowa_kategoria.add(p1);
                            zmienna_kategorii=pola[2];


                }
                s = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

       // System.out.println(produkciki);
        Product p1 =mapa_productow.get(103);
        System.out.println("  ");
        System.out.println(p1+ "<------Produkt o indexie 103");
        System.out.println("  ");

        Map<String,List<Product>> mapa_categorii =new HashMap<>();
        mapa_categorii.put("słodycze",slodycze);
        mapa_categorii.put("narzędzia",narzedzia);
        mapa_categorii.put("oprogramowanie",oprogramowanie);
        mapa_categorii.put("inne",inne);

        if(zmienna_kategorii !="")
        {
            mapa_categorii.put(zmienna_kategorii,nowa_kategoria);
            List<Product> s3 =mapa_categorii.get(zmienna_kategorii);
            System.out.println(s3+" <------To jest kategoria "+zmienna_kategorii);
        }


        List<Product> s1 =mapa_categorii.get("słodycze");
        System.out.println(s1+" <------To sa słodycze");

        List<Product> s2 =mapa_categorii.get("inne");
        System.out.println(s2+" <------To sa inne");


    }


}
