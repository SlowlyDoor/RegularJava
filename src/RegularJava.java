import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularJava
{
    public static boolean isAddress(String address)
    {
        //Регулярное выражение
        String pattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";


        //Проверка октетов
        if (Pattern.matches(pattern, address))
        {
            String[] octets = address.split("\\.");

            for (String num : octets)
            {
                if (Integer.parseInt(num) > 255 || Integer.parseInt(num) < 0)
                    return false;
            }
            return true;
        }
        else
            return false;
    }


}