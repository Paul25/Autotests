import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marchenko on 21.03.2016.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //сортируем методом пузырька, используя метод сверки
        //между собой для каждых 2 строк
        for (int i=0; i<array.length-1;){
            int s = i+1;
            String temp = null;
            //сначала отправляем первое и второе значение на сверку
            if(isGreaterThen(array[i], array[s])){
                temp = array[s];
                array[s]=array[i];
                array[i]=temp;
                if (i>0) i--;
            }
            else i++;

        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {


        //вернёт true если а больше б
        //вернёт false если а меньше б
        return a.compareTo(b) > 0;
    }


}


