package kata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider implements DateProviderService {
    @Override
    public Date getNow() {
        return new Date();
    }
}
