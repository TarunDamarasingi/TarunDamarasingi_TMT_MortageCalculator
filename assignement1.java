package assignement;

import java.util.ArrayList;
import java.util.Scanner;

class assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Data> dataArray = new ArrayList<>();

        System.out.println("Enter the number of data entries:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter id, name, place, and salary for entry " + (i + 1) + ":");
            int id = scanner.nextInt();
            scanner.nextLine();
            String name = scanner.nextLine();
            String place = scanner.nextLine();
            String salary = scanner.nextLine();
            dataArray.add(new Data(id, name, place, salary));
        }

        ArrayList<Data> newArray = new ArrayList<>();
        ArrayList<Data> uniqueArray = new ArrayList<>();

        for (int i = 0; i < dataArray.size(); i++) {
            Data dataIn = dataArray.get(i);
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueArray.size(); j++) {
                Data uniqueData = uniqueArray.get(j);
                if (dataIn.equals(uniqueData)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                newArray.add(dataIn);
            } else {
                uniqueArray.add(dataIn);
            }
        }

        System.out.println("Duplicate Values :-");
        for (Data data : newArray) {
            System.out.println(data);
        }
        System.out.println("--------------------------------------");
        System.out.println("Unique Values :-");
        for (Data data : uniqueArray) {
            System.out.println(data);
        }

        scanner.close();
    }
}

class Data {
    int id;
    String name;
    String place;
    String salary;

    Data(int id, String name, String place, String salary) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Data data = (Data) obj;
        return id == data.id &&
                name.equals(data.name) &&
                place.equals(data.place) &&
                salary.equals(data.salary);
    }

    @Override
    public String toString() {
        return "Data{id=" + id + ", name='" + name + "', place='" + place + "', salary='" + salary + "'}";
    }
}
