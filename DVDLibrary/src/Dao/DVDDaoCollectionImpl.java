package Dao;

import model.DVDPojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// This class provides a collection-based implementation of the DVD DAO
public class DVDDaoCollectionImpl implements DVDDao {
    private List<DVDPojo> dvdDataStore = new ArrayList<>();

    // Constructor initializes the data store with some DVD entries
    public DVDDaoCollectionImpl() {
        DVDPojo dvd1 = new DVDPojo(101, "The Matrix", LocalDate.of(1999, 3, 31), "R", "Lana Wachowski, Lilly Wachowski", "Warner Bros.", "Classic movie");
        DVDPojo dvd2 = new DVDPojo(102, "The Lord of the Rings", LocalDate.of(2001, 12, 19), "PG-13", "Peter Jackson", "New Line Cinema", "Awesome");
        dvdDataStore.add(dvd1);
        dvdDataStore.add(dvd2);
    }

    // Implementations of the DVD DAO methods
    @Override
    public DVDPojo addDVD(DVDPojo newDVD) {
        int newDVDId = dvdDataStore.get(dvdDataStore.size()-1).getDvdId() + 1;
        newDVD.setDvdId(newDVDId);
        dvdDataStore.add(newDVD);
        return newDVD;
    }

    @Override
    public DVDPojo updateDVD(DVDPojo updateDVD) {
        for(int i=0; i<dvdDataStore.size(); i++) {
            if(dvdDataStore.get(i).getDvdId() == updateDVD.getDvdId()) {
                dvdDataStore.set(i, updateDVD);
            }
        }
        return updateDVD;
    }

    @Override
    public void removeDVD(int dvdId) {
        for(int i=0; i<dvdDataStore.size(); i++) {
            if(dvdDataStore.get(i).getDvdId() == dvdId) {
                dvdDataStore.remove(i);
            }
        }
    }

    @Override
    public List<DVDPojo> fetchAllDVDs() {
        return new ArrayList<>(dvdDataStore);
    }

    @Override
    public DVDPojo fetchById(int dvdId) {
        for(DVDPojo dvd : dvdDataStore) {
            if(dvd.getDvdId() == dvdId) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public List<DVDPojo> fetchByTitle(String title) {
        List<DVDPojo> fetchedDVDs = new ArrayList<>();
        for(DVDPojo dvd : dvdDataStore) {
            if(dvd.getTitle().equals(title)) {
                fetchedDVDs.add(dvd);
            }
        }
        return fetchedDVDs;
    }

    @Override
    public boolean writeToFile() {
        return false;
    }
}
