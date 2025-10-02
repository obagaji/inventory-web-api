package inventory_web_api.appException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartNotFoundException extends Exception {
    private static final Logger logger   = LoggerFactory.getLogger(CartNotFoundException.class);
    public CartNotFoundException(String noValueForCartId)
    {
        logger.atTrace().log(noValueForCartId);
    }
}
