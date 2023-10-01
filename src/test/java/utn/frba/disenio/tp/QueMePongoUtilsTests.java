package utn.frba.disenio.tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import utn.frba.disenio.tp.config.TestConfig;
import utn.frba.disenio.tp.utils.Utils;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
class QueMePongoUtilsTests {

    @BeforeEach
    void init() {
    	
    }

	@Test 
	void parsearFechaOk() throws ParseException {
		Date date = Utils.stringToDate("20200101", "yyyyMMdd");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date2 = dateFormat.parse("20200101");
		assertEquals(date,date2);
	}
	
	@Test
	void parsearFechaMal() {
		assertThrows(RuntimeException.class, ()-> 
		Utils.stringToDate("20200101", "yyyy-MM-dd"));
	}
	
	
}
