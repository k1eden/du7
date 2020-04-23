
import com.k1.DuMethods;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DuMethodsTest {
    @Test
    void parser() {
        String[] exp;
        exp = "du [-h] 3.jpg".split(" ");
        DuMethods exam = new DuMethods();
        exam.parser(exp);
        assertTrue(exam.getHFlag());
        assertFalse(exam.getCFlag());
        assertFalse(exam.getSiFlag());
    }

    @Test
    void size() throws URISyntaxException {
        String[] exp;
        exp = "du [-h] 3.jpg".split(" ");
        DuMethods exam = new DuMethods();
        exam.parser(exp);
        exam.size();
        Map.Entry<String,Long> entry = exam.nameSize.entrySet().iterator().next();
        assertEquals(8035,entry.getValue());
    }

    @Test
    void output() {

    }
}