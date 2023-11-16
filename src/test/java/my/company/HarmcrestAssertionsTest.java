package my.company;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertAll;

import static my.company.IsToStringEqual.equalTo;

public class HarmcrestAssertionsTest {
  @Test
  public void testHarmcrestAssertions() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertThat(actual, hasProperty("objectUid", equalTo("1111")))
    );
  }
}
