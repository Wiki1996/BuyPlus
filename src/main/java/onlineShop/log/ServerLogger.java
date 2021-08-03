package onlineShop.log;

import onlineShop.log.Logger;
import org.springframework.stereotype.Component;
@Component
public class ServerLogger {
    public void log(String info) {
        System.out.println("server log = " + info);
    }
}
