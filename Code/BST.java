package brandon_soncarty_00874311_cscd300_prog8.Code;//Brandon Soncarty

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST {
    public static void main(String[] args) throws FileNotFoundException {

        //Scanner for the data file
        Scanner input = new Scanner(new File(args[0]));

        BSTCode temp = new BSTCode();

        //choice variable
        char choice;

        //adding data from file into the BST
        while (input.hasNextLine()) {
            temp.insert(Integer.parseInt(input.nextLine()));
        }

        //sets up the menu and options
        do {
            //repeats the menu if the while check fails
            do {
                Scanner kb = new Scanner(System.in);
                System.out.println("Choose one of the following options: ");
                System.out.println("====================================");
                System.out.println("1) Search for a new key \n" +
                        "2) Insert a new key \n" +
                        "3) Delete an existing key \n" +
                        "4) Inorder traversal of the BST \n" +
                        "5) Preorder traversal of the BST \n" +
                        "6) Postorder traversal of the BST \n" +
                        "7) Level-order traversal of the BST \n" +
                        "8) Find the smallest key \n" +
                        "9) Find the largest key \n" +
                        "a) Find the successor of a given key \n" +
                        "b) Find the predecessor of a given key \n" +
                        "x) Quit \n");

                System.out.println("Your choice:");
                //gets the choice from the user read in as a char
                choice = kb.next().charAt(0);

            } while (choice < '1' || choice > '9' && choice != 'a' && choice != 'b' && choice != 'x');

            //scanner for the user's input
            Scanner in = new Scanner(System.in);
            //switch case for the menu options
            switch (choice) {

                case '1':
                    System.out.println("Input the key:");
                    int key = in.nextInt();
                    if (temp.search(key) == null) {
                        System.out.println("The given key does not exist.");
                    } else {
                        System.out.println("The given key exists.");
                    }
                    break;

                case '2':
                    System.out.println("Input the key:");
                    key = in.nextInt();
                    if (temp.insert(key) != null) {
                        System.out.println("The given key has been inserted successfully.");
                    } else {
                        System.out.println("The given key already exists.");
                    }
                    break;

                case '3':
                    System.out.println("Input the key:");
                    key = in.nextInt();
                    if (temp.delete(key) != null) {
                        System.out.println("The given key has been successfully deleted.");
                    } else {
                        System.out.println("No such key.");
                    }
                    break;

                case '4':
                    temp.InOrder_Traversal(temp.root);
                    System.out.println();
                    break;

                case '5':
                    temp.PreOrder_Traversal(temp.root);
                    System.out.println();
                    break;

                case '6':
                    temp.PostOrder_Traversal(temp.root);
                    System.out.println();
                    break;

                case '7':
                    temp.LevelOrder_Traversal(temp.root);
                    System.out.println();
                    break;

                case '8':
                    if (temp.root == null) {
                        System.out.println("The tree is empty.");
                    } else {
                        BSTNode hold = temp.Min(temp.root);
                        if (hold != null) {
                            System.out.println(hold.key);
                        } else {
                            System.out.println("The tree is empty.");
                        }
                    }
                    break;

                case '9':
                    if (temp.root == null) {
                        System.out.println("The tree is empty.");
                    } else {
                        BSTNode hold = temp.Max(temp.root);
                        if (temp.Max(temp.root) != null) {
                            System.out.println(hold.key);
                        } else {
                            System.out.println("The tree is empty.");
                        }
                    }
                    break;

                case 'a':
                    System.out.println("Input the key:");
                    key = in.nextInt();
                    if (temp.search(key) == null) {
                        System.out.println("No such key.");
                    } else if (temp.Successor(temp.search(key)) != null) {
                        System.out.println(temp.Successor(temp.search(key)).getKey());
                    } else {
                        System.out.println("The given key exists but does not have a successor.");
                    }
                    break;

                case 'b':
                    System.out.println("Input the key:");
                    key = in.nextInt();
                    if (temp.search(key) == null) {
                        System.out.println("No such key.");
                    } else if (temp.Predecessor(temp.search(key)) != null) {
                        System.out.println(temp.Predecessor(temp.search(key)).getKey());
                    } else {
                        System.out.println("The given key exists but does not have a predecessor.");
                    }
                    break;

                case 'x':
                    System.exit(0);
            }
        } while (true);
    }
}

