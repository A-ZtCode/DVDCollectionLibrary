package Dao;
import model.DVDPojo;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

// This class provides a File collection implementation of the DVD DAO
public class DVDDaoFileCollectionImpl implements DVDDao {
    private List<DVDPojo> dvdFileDataStore = new ArrayList<DVDPojo>();
    private static final String FILENAME = "dvd_database.txt";

    public DVDDaoFileCollectionImpl() {
        // Load the DVD data from the file
        try {
            File file = new File(FILENAME);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    LocalDate releaseDate = LocalDate.parse(parts[2]);
                    String mpaaRating = parts[3];
                    String directorName = parts[4];
                    String studio = parts[5];
                    String note = parts[6];
                    dvdFileDataStore.add(new DVDPojo(id, title, releaseDate, mpaaRating, directorName, studio, note));
                }
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implementation of the other methods

    @Override
    public DVDPojo addDVD(DVDPojo newDVD) {
        int newDVDId = dvdFileDataStore.get(dvdFileDataStore.size()-1).getDvdId() + 1;
        newDVD.setDvdId(newDVDId);
        dvdFileDataStore.add(newDVD);
        return newDVD;
    }

    @Override
    public DVDPojo updateDVD(DVDPojo updateDVD) {
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDvdId() == updateDVD.getDvdId()) {
                dvdFileDataStore.set(i, updateDVD);
            }
        }
        return updateDVD;
    }

    @Override
    public void removeDVD(int dvdId) {
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDvdId() == dvdId) {
                dvdFileDataStore.remove(i);
            }
        }
    }

    @Override
    public List<DVDPojo> fetchAllDVDs() {
        return new ArrayList<DVDPojo>(dvdFileDataStore);
    }

    @Override
    public DVDPojo fetchById(int dvdId) {
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDvdId() == dvdId) {
                return dvdFileDataStore.get(i);
            }
        }
        return null;
    }

    @Override
    public List<DVDPojo> fetchByTitle(String dvdTitle) {
        List<DVDPojo> dvdsByTitle = new ArrayList<DVDPojo>();
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getTitle().equals(dvdTitle)) {
                dvdsByTitle.add(dvdFileDataStore.get(i));
            }
        }
        return dvdsByTitle;
    }

    @Override
    public boolean writeToFile() {
        File file = new File("DVDCollection.txt");
        try (FileWriter fw = new FileWriter(file);) {
            for(DVDPojo dvd: dvdFileDataStore) {
                fw.write(dvd.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}