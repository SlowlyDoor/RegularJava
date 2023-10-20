import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularJava
{
    /**
     * Метод проверки айпи адрессов
     * @param address - строка айпи адресса
     * @return
     */
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
        return false;
    }

    /**
     * Метод проверки GUID строк
     * @param guid - строка guid
     * @return
     */
    public static boolean isGUID(String guid)
    {
        String pattern = "^\\{?[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\\}?$";

        if (Pattern.matches(pattern, guid))
        {
            if (guid.charAt(0) == '{' && guid.charAt(guid.length()-1) == '}' ||
                    guid.charAt(0) != '{' && guid.charAt(guid.length()-1) != '}')
                return true;
            return false;
        }
        return false;
    }

    /**
     * Метод проверки URL строки
     * @param url - url строка
     * @return
     */
    public static boolean isURL(String url)
    {
        Pattern patternAddress = Pattern.compile("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
        Matcher m = patternAddress.matcher(url);

        // Ищет совпадения с патерном ip-адресса
        if (m.find())
            return false;
        else
        {
            String pattern = "^(https?://)?(www\\.)?((?!www\\b)[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9](\\.[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]+)+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*=.*)?(#.*)?$";


            return Pattern.matches(pattern, url);
        }
    }

    /**
     * Метод проверки корректного пароля
     * @param password - пароль, вводящий пользователем
     * @return
     */
    public static boolean isCoolPassword(String password)
    {
        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$";

        return Pattern.matches(pattern, password);
    }
}