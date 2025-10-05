package inventory_web_api.exceptPackage;

import inventory_web_api.webInEntity.Sales;

import java.util.HashSet;
import java.util.function.Supplier;

public class EmptySalesException implements Supplier<Sales>
{


    @Override
    public Sales get() {
        return new Sales(0L,0.0,0.0,null,null);
    }
}
