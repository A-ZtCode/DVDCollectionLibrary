package service;

import Dao.DVDDao;
import Dao.DVDDaoFileCollectionImpl;
import model.DVDPojo;

import java.util.List;

// The service layer implementation which interacts with the DAO layer
public class DVDServiceImpl implements DVDService {
    DVDDao dvdDao = new DVDDaoFileCollectionImpl();  // Using the File-based DAO implementation

    // Implementation of the other methods
    @Override
    public DVDPojo addDVD(DVDPojo newDVD) {
        return dvdDao.addDVD(newDVD);
    }

    @Override
    public DVDPojo updateDVD(DVDPojo updatedDVD) {
        return dvdDao.updateDVD(updatedDVD);
    }

    @Override
    public void removeDVD(int dvdId) {
        dvdDao.removeDVD(dvdId);
    }

    @Override
    public List<DVDPojo> fetchAllDVDs() {
        return dvdDao.fetchAllDVDs();
    }

    @Override
    public DVDPojo fetchById(int dvdId) {
        return dvdDao.fetchById(dvdId);
    }

    @Override
    public List<DVDPojo> fetchByTitle(String title) {
        return dvdDao.fetchByTitle(title);
    }

    @Override
    public boolean writeToFile() {
        return dvdDao.writeToFile();
    }
}
