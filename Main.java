import java.util.Scanner;

// import org.graalvm.compiler.core.common.Fields.ObjectTransformer;

interface Transport extends ICloneable{
    void Drive();
    void Buy();
}

interface ICloneable extends Cloneable{
    Object DeepClone();
    // Object ShallowClone();
}

class LandTransport implements Transport{
    protected String name = " ";
        public LandTransport()
        {
            name = " ";
        }
        public LandTransport(String name)
        {
            this.name = name;
        }

        public void Buy()
        {
            System.out.println("Водитель купил: "+ name);
        }
        public void Drive()
        {
            System.out.println("Водитель поехал на " +name + "\n");
        }
        public void Display()
        {
            System.out.println("Название транспорта: "+name + "\n");
        }
        public void Read()
        {
            try {
                System.out.println("Введите название транспорта: ");
                Scanner scan = new Scanner(System.in);
                name = scan.nextLine();
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
        public Object DeepClone()
        {
            return new LandTransport(this.name);
        }
        // @Override
        // public Object ShallowClone()
        // {
        //     return this.MemberwiseClone();
        // }
        public Object clone() throws CloneNotSupportedException{
            return (Object) super.clone();
        }
}

class Car extends LandTransport{
    String marka;
        int year;
        int price;
        static int count = 0;

        public Car()
        {
            super();
            marka = "";
            year = 0;
            price = 0;
            count++;
        }
        public Car(String _marka)
        {
            super(_marka);
            marka = _marka;
            year = 0;
            price = 0;
            count++;
        }
        public Car(String _marka, int _year, int _price)
        {
            super(_marka);
            marka = _marka;
            year = _year;
            price = _price;
            count++;
        }
        @Override
        public void Display()
        {
            super.Display();
            System.out.println("Марка : " + marka + "\tГод: " + year + "г.  \tЦена: " + price +"\n");
        }
        public void Add(Car obj)
        {
            count++;
            int sum = price + obj.price;
            if (sum > 350000)
            {
                marka = "Ferrari"; year = 2018; price = 350000;
            }
            else if (sum > 250000)
            {
                marka = "Nissan"; year = 2004; price = 250000;
            }
            else if (sum > 150000)
            {
                marka = "ВАЗ"; year = 1988; price = 150000;
            }
            else
            {
                marka = "ЗАЗ"; year = 1966; price = 0;
            }
        }

        @Override
        public void Read()
        {
            super.Read();
            try {
                System.out.println("Введите название транспорта: ");
                Scanner scan = new Scanner(System.in);
                System.out.println("Марка: ");
                marka = scan.nextLine();
                System.out.println("Год: ");
                year = scan.nextInt();
                System.out.println("Цена: ");
                price = scan.nextInt();
                count++;
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
        public void ClassCar(String classAuto)
        {
            classAuto = "B";
            System.out.println(classAuto);
        }

        public void addTag()
        {
            marka += " (purchased)";
        }
      

        // //Метод ToString
        // public String ToString()
        // {
        //     return name.ToString();
        // }
    }
    class Moto extends LandTransport
    {
        String marka;
        int year;
        int price;

        public Moto()
        {
            super();
            marka = " ";
            year = 0;
            price = 0;
        }
        public Moto(String _marka)
        {
            super(_marka);
            marka = _marka;
            year = 0;
            price = 0;
        }
        public Moto(String _marka, int _year, int _price)
        {
            super(_marka);
            marka = _marka;
            year = _year;
            price = _price;
        }
        @Override
        public void Read()
        {
            super.Read();
            try{
            Scanner scan = new Scanner(System.in);
            System.out.println("Марка: ");
            marka = scan.nextLine();
            System.out.println("Год: ");
            year = scan.nextInt();
            System.out.println("Цена: ");
            price = scan.nextInt();
            }
            catch (Exception error) {
                error.printStackTrace();
            }
        }
        @Override
        public void Display()
        {
            super.Display();
            System.out.println("Марка : " + marka +  "\tГод: " + year +"г." + "\tЦена: " + price + "\n");
        }
    }
    class NumberOfPassengers{
        int amount;
        public NumberOfPassengers(int amount){
            this.amount = amount;
        }
        public void setNumber(int amount){
            this.amount = amount;
        }
    }
    class AirTransport implements Transport //Производный класс
    {
        String name;
        public NumberOfPassengers numberOfPassengers;
        public AirTransport()
        {
            name = " ";
        }
        public AirTransport(String name, int numberOfPassengers)
        {
            this.name = name;
            this.numberOfPassengers = new NumberOfPassengers(numberOfPassengers);
        }
        public void Buy()
        {
            System.out.println("Пилот купил "+ numberOfPassengers.amount + "(Кол-во пассажиров: " + numberOfPassengers.amount +")");
        }
        public void Drive()
        {
            System.out.println("Пилот полетел на " + name + "\n");
        }
        public void Display()
        {
            System.out.println("Название транспорта: " + name + "\tКол-во пассажиров: " + numberOfPassengers.amount);
        }
        public void Read()
        {
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите название транспорта: ");
                name = scan.nextLine();
                System.out.println("Введите максимальное кол-во пассажиров: ");
                numberOfPassengers.setNumber(scan.nextInt());
        }
            catch(Exception error){
                error.printStackTrace();
            }
        }
        public Object DeepClone()
        {
            return new AirTransport(this.name, this.numberOfPassengers.amount);
        }
        // public Object ShallowClone()
        // {
        //     return this.MemberwiseClone();
        // }
        public Object clone() throws CloneNotSupportedException{

            return (Object) super.clone();
        }
    }
    class Plane extends AirTransport
    {
        String name;
        int numberOfPassengers;
        int MaxHeight;

        public Plane()
        {
            super();
            name = " ";
            numberOfPassengers = 0;
            MaxHeight = 0;
        }
        public Plane(String name, int numberOfPassengers, int MaxHeight)
        {
            super(name, numberOfPassengers);
            this.name = name;
            this.numberOfPassengers = numberOfPassengers;
            this.MaxHeight = MaxHeight;
        }
        @Override
        public void Read()
        {
            super.Read();
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Название: ");
                name = scan.nextLine();
                System.out.println("Кол-во пассажирова: ");
                numberOfPassengers = scan.nextInt();
                System.out.println("Максимальная высота: ");
                MaxHeight = scan.nextInt();
            }
            catch(Exception error){
                error.printStackTrace();
            }
        }
        @Override
        public void Display()
        {
            super.Display();
            System.out.println("Название: " + name + "\tКол-во пассажиров: " + numberOfPassengers + "\tМаксимальная высота: " + MaxHeight+ "м.\n");
        }
    }
    class Driver
    {
        public Driver()
        {   
            System.out.println("Человек получил водительское удостоверение\n");
        }
        public void ToDrive(Transport transport)
        {
            transport.Drive();
        }
        public void ToBuy(Transport transport)
        {
            transport.Buy();
        }
    }

public class Main {
    public static void main(String[] args){
        System.setProperty("console.encoding", "1251");
        Car toyota = new Car("Toyota", 1998, 150000);
        toyota.Display();
        Car bmw = new Car("BMW", 2012, 350000);
        bmw.Display();
        Moto bmx = new Moto("BMX", 2020, 120000);
        bmx.Display();
        
        Plane boing = new Plane("Боинг", 120, 11000);
        boing.Display();
        Driver Ilya = new Driver();
        Ilya.ToBuy(boing);
        Ilya.ToBuy(boing);
        Ilya.ToDrive(boing);

        Ilya.ToBuy(bmx);
        Ilya.ToDrive(bmx);

        Ilya.ToBuy(toyota);
        Ilya.ToDrive(toyota);

        Ilya.ToBuy(bmw);
        Ilya.ToDrive(bmw);
    }
}