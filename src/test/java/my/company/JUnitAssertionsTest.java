package my.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitAssertionsTest {
  @Test
  public void testJUnitAssertions() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertEquals("11112", actual.objectUid(), "objectUid"),
        () -> assertEquals("US", actual.country(), "country"),
        () -> assertEquals("Some String1", actual.data().dataId(), "dataId")
    );
  }
}
