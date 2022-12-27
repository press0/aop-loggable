package net.thoughtforge.aspect;

import java.math.BigDecimal;

import net.thoughtforge.bean.SimpleBean;
import net.thoughtforge.bean.SimpleBeanSubclass;
import net.thoughtforge.logger.LogLevel;
import net.thoughtforge.mock.logger.MockLogger;
import net.thoughtforge.mock.logger.MockLogger.LogMessage;

import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;


//TODO: logger null
@ContextConfiguration(locations = {
        "/applicationContext/applicationContext-aspect.xml",
        "/applicationContext/applicationContext-logger.xml",
        "/applicationContext/applicationContext.xml"})
public class LoggingAspectTest {

    @Autowired
    private MockLogger logger;

    @Autowired
    @Qualifier(value = "simpleBean")
    public SimpleBean simpleBean;

    @Autowired
    public SimpleBeanSubclass simpleBeanSubclass;

    @BeforeEach
    public void before() {
        logger.setLogLevel(SimpleBean.class, LogLevel.TRACE);
        logger.setLogLevel(SimpleBeanSubclass.class, LogLevel.TRACE);
        logger.resetLoggers();
    }

    @Test
    public void testSimpleBean_SetDateProperty() throws Exception {
        simpleBean.setDateProperty(
                DateUtils.parseDate("01/01/2010", new String[]{"dd/MM/yyyy"}));

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < setDateProperty > with params Fri Jan 01 00:00:00 GMT 2010 ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setDateProperty > ]");
    }

    @Test
    public void testSimpleBean_SetIntegerProperty() {
        simpleBean.setIntegerProperty(100);

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < setIntegerProperty > with params 100 ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setIntegerProperty > ]");
    }

    @Test
    public void testSimpleBean_SetStringProperty() {
        simpleBean.setStringProperty("stringProperty");

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < setStringProperty > with params stringProperty ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setStringProperty > ]");
    }

    @Test
    public void testSimpleBean_GetDateProperty() {
        simpleBean.getDateProperty();

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < getDateProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getDateProperty > returning Fri Jan 01 00:00:00 GMT 2010 ]");
    }

    @Test
    public void testSimpleBean_GetIntegerProperty() {
        simpleBean.getIntegerProperty();

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < getIntegerProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getIntegerProperty > returning 100 ]");
    }

    @Test
    public void testSimpleBean_GetStringProperty() {
        simpleBean.getStringProperty();

        assertEquals(2, logger.getMessages(SimpleBean.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(0),
                LogLevel.TRACE,
                "[ entering < getStringProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBean.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getStringProperty > returning stringProperty ]");
    }

    @Test
    public void testSimpleBeanSubclass_SetDateProperty() throws Exception {
        simpleBeanSubclass.setDateProperty(
                DateUtils.parseDate("01/01/2010", new String[]{"dd/MM/yyyy"}));

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < setDateProperty > with params Fri Jan 01 00:00:00 GMT 2010 ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setDateProperty > ]");
    }

    @Test
    public void testSimpleBeanSubclass_SetDecimalProperty() {
        simpleBeanSubclass.setDecimalProperty(new BigDecimal("0.25"));

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < setDecimalProperty > with params 0.25 ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setDecimalProperty > ]");
    }

    @Test
    public void testSimpleBeanSubclass_SetIntegerProperty() {
        simpleBeanSubclass.setIntegerProperty(100);

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < setIntegerProperty > with params 100 ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setIntegerProperty > ]");
    }

    @Test
    public void testSimpleBeanSubclass_SetStringProperty() {
        simpleBeanSubclass.setStringProperty("stringProperty");

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < setStringProperty > with params stringProperty ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < setStringProperty > ]");
    }

    @Test
    public void testSimpleBeanSubclass_GetDateProperty() {
        simpleBeanSubclass.getDateProperty();

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < getDateProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getDateProperty > returning Fri Jan 01 00:00:00 GMT 2010 ]");
    }

    @Test
    public void testSimpleBeanSubclass_GetDecimalProperty() {
        simpleBeanSubclass.getDecimalProperty();

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < getDecimalProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getDecimalProperty > returning 0.25 ]");
    }

    @Test
    public void testSimpleBeanSubclass_GetIntegerProperty() {
        simpleBeanSubclass.getIntegerProperty();

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < getIntegerProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getIntegerProperty > returning 100 ]");
    }

    @Test
    public void testSimpleBeanSubclass_GetStringProperty() {
        simpleBeanSubclass.getStringProperty();

        assertEquals(2, logger.getMessages(SimpleBeanSubclass.class).size());
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(0),
                LogLevel.TRACE,
                "[ entering < getStringProperty > ]");
        assertEqualsHelper(logger.getMessages(SimpleBeanSubclass.class).get(1),
                LogLevel.TRACE,
                "[ leaving < getStringProperty > returning stringProperty ]");
    }

    private void assertEqualsHelper(LogMessage logMessage, LogLevel logLevel, String message) {
        assertEquals(logLevel, logMessage.getLogLevel());

        assertEquals(message, logMessage.getMessage());
    }
}
