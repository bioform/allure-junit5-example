package my.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertAll;

public class HarmcrestAssertionsTest {
  @Test
  public void testHarmcrestAssertions() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertThat(actual, hasProperty("objectUid", equalTo("1111")))
    );
  }
}
