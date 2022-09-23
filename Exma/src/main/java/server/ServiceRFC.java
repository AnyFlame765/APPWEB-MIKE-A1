package server;

import java.util.List;

public class ServiceRFC {

    public boolean saveRFC(BeanRFC rfc) {
        DaoRFC daoRFC = new DaoRFC();
        boolean result = daoRFC.saveRFC(rfc);
        return result;
    };


}
