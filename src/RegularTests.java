import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class RegularTests
{
    @ParameterizedTest
    @ValueSource(strings = {"255.255.255.0", "131.55.15.0", "107.16.11.30", "191.60.212.255", "127.0.0.1", "197.65.221.228"})
    void validIp(String ip)
    {
        assertTrue(RegularJava.isAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.254.134.1.154", "127.abc.13.22", "55.221.0.-4", "111,55.7.", "1300.6.7.8", "abc.def.gha.bcd"})
    void invalidIp(String ip)
    {
        assertFalse(RegularJava.isAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
                            "3fa64133-487d-4930-ba79-204f7980bb4d",
                            "4edc997d-7e50-4264-8933-7e8c5d40d0f5",
                            "{e02fd0e4-00fd-090A-ca30-0d00a0038ba0}",
                            "{3fa64133-487d-4930-ba79-204f7980bb4d}",
                            "{4edc997d-7e50-4264-8933-7e8c5d40d0f5}"})
    void validGUID(String guid)
    {
        assertTrue(RegularJava.isGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e400fd090Aca300d00a0038ba0",
                            "{e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
                            "3fa64133-487d-4930-ba79204f7980bb4d",
                            "{3fa64133-487d-4930-ba79-204f7980bb4d",
                            "4edc997d-7e50-4264-8933-7e8c5d40d0f5}"})
    void invalidGUID(String guid) {
        assertFalse(RegularJava.isGUID(guid));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com",
                            "https://subdomain.example.com",
                            "http://www.example.com:8080/path/to/resource?param=value#section",
                            "https://example.com/page#section",
                            "http://sub.domain.com",
                            "https://www.example.additional-domain.com:80/folder/chosen_fo?access=administrator&info=full#url5"
    })
    void validUrl(String url) {
        assertTrue(RegularJava.isURL(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://....exam...ple..com",
                            "www.com",
                            "https://-example.com",
                            "http://example.com_underscore",
                            "http://example.com with spaces",
                            "ftp://example.com"
    })
    void invalidUrl(String url)
    {
        assertFalse(RegularJava.isURL(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {"P@ssw0r.d123",
            "MyPas/sword_007",
            "Str0n!gP@ssW0rd",
            "AbcDef_1234",
            "Secu\\re_P@ssw0r]d",
            "P@ssw0rdZz_1"
    })
    void validPassword(String pw) {
        assertTrue(RegularJava.isCoolPassword(pw));
    }

    @ParameterizedTest
    @ValueSource(strings = {"simple",
                            "OnlyLettersNoDigits",
                            "12345678",
                            "NoUppercaseletters",
                            "only_lowercase_no_digits",
                            "LongEnoughButNoSpecialCharacter"
    })
    void invalidPassword(String pw)
    {
        assertFalse(RegularJava.isCoolPassword(pw));
    }
}