import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("test")
@SelectClasses({MeetingTimeTest.class, MeetingDateTest.class})
public class MeetingTimeAndDateTestSuite {
}
