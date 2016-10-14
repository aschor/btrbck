package com.github.ruediste1.btrbck.dom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

public class SnapshotTest {

    // private static final String name = "4_1970-01-06T11:48:17.456+05:00";
    private static final String name = "4_1970-01-06 11h48m17.456s";
    private DateTime date;

    @Before
    public void setup() {
        // date = new DateTime(456497456L, DateTimeZone.forOffsetHours(5));
        DateTimeFormatter f = DateTimeFormat
                .forPattern("yyyy-MM-dd HH'h'mm'm'ss'.'SSS's'");

        date = f.parseDateTime("1970-01-06 11h48m17.456s");

    }

    @Test
    public void testGetSnapshotName() throws Exception {
        Snapshot s = new Snapshot();
        s.nr = 4;
        s.date = date;
        assertEquals(name, s.getSnapshotName());
    }

    @Test
    public void testParse() throws Exception {
        Stream stream = new Stream();
        Snapshot snapshot = Snapshot.parse(stream, name);
        assertEquals(4, snapshot.nr);
        assertEquals(date, snapshot.date);
        assertSame(stream, snapshot.stream);
    }

}
