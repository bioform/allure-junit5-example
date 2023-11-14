package my.company;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareAssertionsTest {

  @Test
  public void testJUnitAssertions() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertEquals("11112", actual.objectUid(), "objectUid"),
        () -> assertEquals("US", actual.country(), "country"),
        () -> assertEquals("Some String1", actual.data().dataId(), "dataId")
    );
  }

  @Test
  public void testAssertJAssertions1() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertThat(actual)
        .extracting("objectUid",
            "country",
            "data.dataId")
        .containsExactly(
            "11112",
            "US",
            "Some String1");
  }

  @Test
  public void testAssertJAssertions2() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertThat(actual.objectUid()).as("objectUid").isEqualTo("11112"),
        () -> assertThat(actual.country()).as("country").isEqualTo("US"),
        () -> assertThat(actual.data().dataId()).as("dataId").isEqualTo("Some String1")
    );
  }

  @Test
  public void testAssertJAssertions2_extra() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    assertAll(
        () -> assertThat(actual).hasFieldOrPropertyWithValue("objectUid", "11112"),
        () -> assertThat(actual).hasFieldOrPropertyWithValue("country", "US"),
        () -> assertThat(actual).hasFieldOrPropertyWithValue("data.dataId", "Some String1")
    );
  }

  @Test
  public void testAssertJAssertions3() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(actual.objectUid()).as("objectUid").isEqualTo("11112");
    softly.assertThat(actual.country()).as("country").isEqualTo("US");
    softly.assertThat(actual.data().dataId()).as("dataId").isEqualTo("Some String1");
    softly.assertAll();
  }
  @Test
  public void testAssertJAssertions3_extra() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(actual).hasFieldOrPropertyWithValue("objectUid", "11112");
    softly.assertThat(actual).hasFieldOrPropertyWithValue("country", "US");
    softly.assertThat(actual).hasFieldOrPropertyWithValue("data.dataId", "Some String1");
    softly.assertAll();
  }


  /**
   * Fail immediately on the first assertion
   */
  @Test
  public void testAssertJAssertions4() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    SoftAssertions.assertSoftly(
        softly -> softly.assertThat(actual)
                    .returns("11112", from(MyMessage::objectUid))
                    .returns("US", from(MyMessage::country))
                    .returns("Some String1", from(msg -> msg.data().dataId()))
    );

  }

  /**
   * Fail immediately on the first assertion
   */
  @Test
  public void testAssertJAssertions5() {
    var actual = new MyMessage("1111", "US", new MessageData("Some String"));

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(actual)
        .isNotNull()
        .hasFieldOrPropertyWithValue("objectUid", "11112")
        .hasFieldOrPropertyWithValue("country", "US")
        .hasFieldOrPropertyWithValue("data.dataId", "Some String1");
    softly.assertAll();
  }
}
