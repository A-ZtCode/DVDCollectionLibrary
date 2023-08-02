import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.DVDPojo;
import service.DVDService;
import service.DVDServiceImpl;

// This class is the entry point of the program and provides a menu for user interaction

public class DVDCollectionSystemMain {

    public static void main(String[] args) {

        DVDService dvdService = new DVDServiceImpl();

        Scanner scan = new Scanner(System.in);
        char con = 'n';
        do {
            System.out.println("************************");
            System.out.println("1. Add a new DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Update a DVD");
            System.out.println("4. Fetch all DVDs");
            System.out.println("5. Fetch a DVD by ID");
            System.out.println("6. Fetch DVDs by Title");
            System.out.println("7. Write to a file");
            System.out.println("8. Exit");
            System.out.println("************************");
            System.out.println("Enter your option:");
            int option = scan.nextInt();
            System.out.println("************************");

            // cases for each option will go here
            switch(option) {
                case 1:
                    // Add a new DVD
                    System.out.println("Please enter the details of the DVD: ");
                    System.out.println("Enter DVD Title : ");
                    scan.nextLine();
                    String dvdTitle = scan.nextLine();

                    System.out.println("Enter DVD Release Date (yyyy-mm-dd) : ");
                    String dvdReleaseDate = scan.nextLine();
                    LocalDate releaseDate = LocalDate.parse(dvdReleaseDate);

                    System.out.println("Enter MPAA Rating : ");
                    String mpaaRating = scan.nextLine();

                    System.out.println("Enter Director's Name : ");
                    String directorName = scan.nextLine();

                    System.out.println("Enter Studio : ");
                    String studio = scan.nextLine();

                    System.out.println("Enter User Rating or Note : ");
                    String userRatingOrNote = scan.nextLine();

                    DVDPojo newDVDPojo = new DVDPojo(0, dvdTitle, releaseDate, mpaaRating, directorName, studio, userRatingOrNote);

                    DVDPojo returnedDVDPojo = dvdService.addDVD(newDVDPojo);

                    System.out.println("DVD added successfully!!");
                    System.out.println("New DVD ID is: " + returnedDVDPojo.getDvdId());

                    break;
                case 2:
                    // Remove a DVD
                    System.out.println("Enter the DVD ID to be removed:");
                    int removeDvdId = scan.nextInt();
                    DVDPojo removeFetchedDVD = dvdService.fetchById(removeDvdId);
                    if(removeFetchedDVD == null) {
                        System.out.println("Sorry! DVD with this ID does not exist!!");
                        break;
                    } else {
                        // print the DVD info
                        System.out.println(removeFetchedDVD);
                        System.out.println("Are you sure you want to remove this DVD?(y/n):");
                        char ans = scan.next().charAt(0);
                        if(ans == 'y') {
                            dvdService.removeDVD(removeDvdId);
                            System.out.println("The DVD has been removed!!");
                        }
                    }
                    break;
                case 3:
                    // Update a DVD
                    System.out.println("Enter the DVD ID to be updated:");
                    int updateDvdId = scan.nextInt();
                    DVDPojo updateFetchedDVD = dvdService.fetchById(updateDvdId);
                    if(updateFetchedDVD == null) {
                        System.out.println("Sorry! DVD with this ID does not exist!!");
                        break;
                    } else {
                        // print the DVD info
                        System.out.println(updateFetchedDVD);
                        System.out.println("Please enter the new User Rating or Note:");
                        scan.nextLine();
                        String updateNote = scan.nextLine();

                        updateFetchedDVD.setNote(updateNote);

                        dvdService.updateDVD(updateFetchedDVD);
                        System.out.println("DVD information updated successfully!!");
                    }
                    break;
                case 4:
                    // Fetch all DVDs
                    List<DVDPojo> allDVDs = dvdService.fetchAllDVDs();
                    for(DVDPojo eachDVD: allDVDs) {
                        System.out.println(eachDVD);
                    }
                    break;
                case 5:
                    // Fetch a DVD by ID
                    System.out.println("Enter the DVD ID to fetch the DVD:");
                    int dvdId = scan.nextInt();
                    DVDPojo fetchedDVD = dvdService.fetchById(dvdId);
                    if(fetchedDVD == null) {
                        System.out.println("Sorry! DVD with this ID does not exist!!");
                        break;
                    } else {
                        // print the DVD info
                        System.out.println(fetchedDVD);
                    }

                    break;
                case 6:
                    // Fetch DVDs by title
                    System.out.println("Enter the DVD title to fetch the DVDs:");
                    scan.nextLine();
                    String inputDVDTtitle = scan.nextLine();
                    List<DVDPojo> allDVDTitle = dvdService.fetchByTitle(inputDVDTtitle);
                    if(allDVDTitle.isEmpty()) {
                        System.out.println("Sorry! DVDs with this title do not exist!!");
                        break;
                    } else {
                        // print the all the DVD info
                        for(DVDPojo eachDVD: allDVDTitle) {
                            System.out.println(eachDVD);
                        }
                    }
                    break;
                case 7:
                    // Write to file
                    if(dvdService.writeToFile()) {
                        System.out.println("Successfully written to file!");
                    } else {
                        System.out.println("Error while writing to file!");
                    }
                    break;
                case 8:
                    System.out.println("************************");
                    System.out.println("Thank you for using the DVD management system!");
                    System.out.println("************************");
                    dvdService.writeToFile();
                    System.exit(0);
            }
            System.out.println("Do you want to continue?(y/n)");
            con = scan.next().charAt(0);
        } while(con == 'y');
    }
}
