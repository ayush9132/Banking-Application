import java.util.HashMap;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BankingApplication {


    int balance;
    HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>();

    public void create_Account(String name)
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        System.out.println("Hi "+ name +" your newly opened bank account number is:");
        int rand = random.nextInt(1, 11);
        System.out.println(rand);
        balance=0;

        hash_map.put(rand,balance);
        System.out.println("Your account balance is"+balance);


    }

    public void deposit_amount(int account_number, int deposit_amount)
    {
        int new_balance=0;
        if(hash_map.containsKey(account_number))
        {
             new_balance= hash_map.get(account_number)+ deposit_amount;
        }
        hash_map.put(account_number,new_balance);

        System.out.println("Your new balance is:"+new_balance);
    }


    public void withdraw_amount(int account_number, int withdraw_amount)
    {
        int new_balance=0;
        if(hash_map.containsKey(account_number))
        {
            new_balance= hash_map.get(account_number)- withdraw_amount;
        }
        hash_map.put(account_number,new_balance);

        System.out.println("Your new balance is:"+new_balance);

    }

    public void show_balance(int account_number)
    {
        System.out.println("Your account balance for account number "+account_number+"is "+hash_map.get(account_number));
    }

    public static void main(String args[]) {
        int account_number;
        BankingApplication obj = new BankingApplication();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi, welcome to Ayush bank");
        System.out.println("Please keep your account number with you for future transactions");

        System.out.println("Are you a customer of Ayush bank?");
        String confirm = sc.nextLine();
        switch (confirm) {

            case "Yes" :
                System.out.println("Do you want to create a new account");

                String choice = sc.nextLine();

                switch (choice) {
                    case "Yes":
                        System.out.println(("Please enter your name"));
                        String name = sc.nextLine();
                        obj.create_Account(name);
                        break;

                    case "No":
                        System.out.println("Thank you for visiting my application");
                        break;

                    default:
                        System.out.println("Invalid output");
                }
            break;

            case "No" :
                System.out.println("Do you want to *deposit* or *withdraw* or *display_balance*?");
                String action = sc.nextLine();

                switch (action) {
                    case " deposit":
                        System.out.println("Enter your acc_no and ");
                        int acc_no = sc.nextInt();
                        System.out.println("Enter deposit amount");
                        int deposit_amount = sc.nextInt();
                        obj.deposit_amount(acc_no,deposit_amount);
                        break;
                    case " withdraw":
                        System.out.println("Enter your acc_no ");
                        int acc_number = sc.nextInt();
                        System.out.println("Enter withdraw amount");
                        int withdraw_amount = sc.nextInt();
                        obj.deposit_amount(acc_number, withdraw_amount);
                        break;
                    case "display balance" :
                        System.out.println("Enter your acc_no ");
                        int acc_numberone = sc.nextInt();
                        obj.show_balance(acc_numberone);
                    default:
                        System.out.println("Invalid input");

                }
            default:
                System.out.println("Invalid input");









                }
    }





}