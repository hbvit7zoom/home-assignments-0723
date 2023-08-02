package ru.sberbank.jd.webinar02;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainRuntimeExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testMain() {
        MainRuntimeException.main(null);
    }
}