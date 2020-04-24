
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
        exam.nameSize.clear();
        exp = "du [-h] 2.jpg".split(" ");
        exam.parser(exp);
        exam.size();
        Map.Entry<String,Long> entry1 = exam.nameSize.entrySet().iterator().next();
        assertEquals(44407,entry1.getValue());
        exam.nameSize.clear();
        exp = "du [-h] 1.jpg".split(" ");
        exam.parser(exp);
        exam.size();
        Map.Entry<String,Long> entry2 = exam.nameSize.entrySet().iterator().next();
        assertEquals(55183,entry2.getValue());
    }

    @Test
    void output() {

    }
}