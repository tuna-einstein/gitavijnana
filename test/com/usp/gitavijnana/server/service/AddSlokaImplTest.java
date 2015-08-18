package com.usp.gitavijnana.server.service;

import org.slim3.tester.ServletTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AddSlokaImplTest extends ServletTestCase {

    private AddSlokaImpl service = new AddSlokaImpl();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
