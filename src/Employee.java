import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Employee {

    public void readFile(){
        
        try{
            tryReadFile();
        }
        
        catch(FileNotFoundException e){
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        }
    }
    
    public void tryReadFile() throws FileNotFoundException{

        FileReader fr = new FileReader("dolgozok.txt");
        Scanner sc = new Scanner(fr);
        int salaryTotal = 0;

        while(sc.hasNextLine()){

            String line = sc.nextLine();
            String[] lineArray = line.split(":");
            Emp emp = new Emp();
            emp.id = Integer.parseInt(lineArray[0]);
            emp.name = lineArray[1];
            emp.city = lineArray[2];
            emp.address = lineArray[3];
            emp.salary = Integer.parseInt(lineArray[4]);
            emp.birth = lineArray[5];

            if(lineArray[2].equals("Szolnok")){
                salaryTotal += emp.salary;
            }
        }

        sc.close();

        System.out.println("A szolnokiak összesített fizetése: " + salaryTotal + " Ft");
    }
}
