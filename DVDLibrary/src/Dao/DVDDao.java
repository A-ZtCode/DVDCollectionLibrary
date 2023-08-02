package Dao;

import model.DVDPojo;

import java.util.List;

// The DAO layer interface defining the operations on a DVD
public interface DVDDao {
    DVDPojo addDVD(DVDPojo newDVD); // Add a new DVD to the collection
    void removeDVD(int dvdId); // Remove a DVD from the collection by ID
    DVDPojo updateDVD(DVDPojo updatedDVD); // Update the information of an existing DVD
    List<DVDPojo> fetchAllDVDs(); // Retrieve all DVDs in the collection
    DVDPojo fetchById(int dvdId); // Fetch a particular DVD by its ID
    List<DVDPojo> fetchByTitle(String title); // Fetch DVDs with a particular title
    boolean writeToFile(); // Write the DVD collection to a file
}

