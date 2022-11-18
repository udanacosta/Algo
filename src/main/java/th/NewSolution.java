package th;


import java.util.*;

public class NewSolution
{
    static class Pump
    {
        public int CountOfFuel  = 0;
        public boolean IsTaken = false;
        public int Time = 0 ;
        public String Name = "" ;
        public int CarDemand = 0 ;

        Pump(int countOfFuel , String name)
        {
            this.CountOfFuel = countOfFuel ;
            this.Name = name ;
        }
    }

    public static void main(String[] args)
    {
        int[] cars = new int[] { 2, 8, 4, 3, 2 };
        int result = solution(cars, 7, 11, 3);

        System.out.println("The longest waiting time"+ result);
        System.out.println();
    }


    public static int solution(int[] A, int X, int Y, int Z)
    {
        Pump x = new Pump (X,"X") ;
        Pump y = new Pump (Y,"Y") ;
        Pump z = new Pump (Z,"Z") ;

        Pump[] station = new Pump[]{ x, y, z };
        List<Integer> queue = new LinkedList<>() ;
        generateObjects(queue , A);
        int  time = 0;
        int index  = 0;
        while (true)
        {
            System.out.println("Current time : " + time);
            Release(station);
            while (true)
            {
                if (queue.size() == 0)
                {
                    return time;
                }
                Integer car = queue.get(index) ;
                Pump pomp = getFistAvaiblePomp(station , car) ;
                if (pomp == null && isAllPomNotTaken(station) )
                {
                    return -1;
                }

                if (pomp == null) break;

                pomp.IsTaken = true;
                pomp.CarDemand = car;
                queue.remove(index);
                System.out.println("Car "+ car + "takes pomp "+pomp.Name+" at " +time);
            }

            time++;
            System.out.println("___________________________________________________");
        }
    }

    private static Pump getFistAvaiblePomp(Pump[] station, Integer car)
    {
        for (int i = 0; i <station.length ; i++)
        {
            Pump pomp = station[i];
            if (!pomp.IsTaken && pomp.CountOfFuel >= car)
            {
                return pomp ;
            }
        }
        return null;
    }

    private static boolean isAllPomNotTaken(Pump[] station)
    {
        for (int i = 0; i <station.length ; i++)
        {
            Pump pomp = station[i];
            if (pomp.IsTaken )
            {
                return false ;
            }
        }
        return true;
    }

    private static void Release(Pump[] station)
    {
        for (int i = 0; i <station.length ; i++)
        {
            Pump pomp =station[i];
            if(station[i].IsTaken)
            {
                pomp.Time++;
                if (pomp.Time != pomp.CarDemand) continue;

                pomp.IsTaken = false;
                pomp.CountOfFuel -= pomp.CarDemand;
                pomp.Time = 0;
                pomp.CarDemand = 0;
                System.out.println("Pomp"+pomp.Name+" is released");
            }

        }
    }

    private static void generateObjects(List<Integer> queue , int[] array)
    {
        for (int i = 0; i <array.length ; i++)
        {
            queue.add(Integer.valueOf(array[i]));
        }
    }
}
