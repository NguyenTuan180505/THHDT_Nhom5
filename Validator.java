

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String PHONE_REGEX = "^\\d{10,11}$";
    private static final String ID_REGEX = "^\\d{12}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);


    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email sai dinh dang");

        }
        else  return  true;

    }
    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        Matcher matcher = PHONE_PATTERN.matcher(phone);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("SDT sai dinh dang");

        }
        return true;
    }
    public static boolean isValidID(String cccd) {
        if (cccd == null) {
            return false;
        }
        Matcher matcher = ID_PATTERN.matcher(cccd);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("CCCD sai dinh dang");

        }
        return true;
    }

}
