package server;

import java.util.List;

public class Service {

    public boolean saveRFC(BeanRFC person) {
        DaoRFC daoGames = new DaoRFC();
        boolean result = daoGames.saveRFC(person);
        return result;
    };

    public List<BeanRFC> listPerson(BeanRFC curp){
        DaoRFC daoRFC = new DaoRFC();
        List<BeanRFC> listRFC = daoRFC.listPerson(curp);
        return listRFC;
    }

    public boolean updatePerson(BeanRFC rfc) {
        DaoRFC daoRFC = new DaoRFC();
        boolean result = daoRFC.updatePerson(rfc);
        return result;
    }
}
