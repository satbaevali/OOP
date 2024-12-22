package panel;
import Users.*;

import java.util.Scanner;
import panel.*;



    public class ResearchPanel {
        private Researcher researcher;
        private Scanner scanner;

        public ResearchPanel(Researcher researcher) {
            this.researcher = researcher;
            this.scanner = new Scanner(System.in);
        }

        public void menu() {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n=== Researcher Menu ===");
                System.out.println("1. View Publications");
                System.out.println("2. Calculate H-index");
                System.out.println("3. Add New Publication");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> researcher.viewPapers();
                    case 2 -> System.out.println("H-index: " + researcher.getHIndex());
                    case 3 -> addNewPaper();
                    case 4 -> exit = true;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void addNewPaper() {
            System.out.print("Enter the title of the publication: ");
            String title = scanner.nextLine();
            System.out.print("Enter the number of citations: ");
            int citations = scanner.nextInt();
            scanner.nextLine();

            researcher.addNewPaper(title, citations);
        }
    }
