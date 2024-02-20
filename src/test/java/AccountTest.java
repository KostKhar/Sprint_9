import org.example.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean isPerhaps;

    public AccountTest(String name, boolean isPerhaps) {
        this.name = name;
        this.isPerhaps = isPerhaps;
    }

    @Parameterized.Parameters(name = "name {0}, isPerhaps {2}")
    public static Object[][] getBooleanData() {
        return new Object[][]{
                {"Sidorov Sidr", true},
                {"SidorovSidr", false},
                {"Sidorov Sidr ", false},
                {"I A", true},
                {"Sindorovichev Aksum", true},
                {" Sindorovichev Aksum", false},
                {"Sindorovichev Aksaam", false},
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        assertEquals(isPerhaps, new Account(name).checkNameToEmboss());
    }

}
