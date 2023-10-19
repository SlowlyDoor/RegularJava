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

}