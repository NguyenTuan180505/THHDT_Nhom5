package Service;

import java.text.NumberFormat;
import java.util.Locale;

public class DinhDangTien {
    public static String chuyenDoi(double sotien) {
        NumberFormat currencyFormatter =  NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return currencyFormatter.format(sotien);
    }
}
