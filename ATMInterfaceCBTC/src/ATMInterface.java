import java.util.Scanner;

class BankAccount {
    
String name;
String username;
String password;
String accountNo;
float balance = 100000f;
int transaction = 0;
String transactionHistory = "";

public void register() {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your Name: ");
    this.name = sc.nextLine();
    System.out.print("Enter your Username: ");
    this.username = sc.nextLine(); 
    System.out.print("Enter your Password: ");
    this.password = sc.nextLine();
    System.out.print("Enter your Account Number: ");
    this.accountNo = sc.nextLine();
    System.out.print("REGISTRATION COMPLETE --- PLEASE LOG IN!");
}

public boolean login() {

                   boolean isLogin = false;
                   Scanner sc = new Scanner(System.in);
                        while(! isLogin) {
                            System.out.print("Enter your Username: ");
                            String Username = sc.nextLine();
                            if(Username.equals(username)){
                                while(!isLogin){
                                    System.out.print("Enter your Password: ");
                                    String password = sc.nextLine();
                                    if(password.equals(password)){
                                        System.out.print("Log in successfull!");
                                        isLogin = true;
                                } else {
                                        System.out.print("\nIncorrect Password");
                                    }
                            }
                        } else {
                                System.out.print("\nUsername not found!");
                            }
                        } return isLogin;
    }

    public void withdraw() {

        System.out.print("Enter the amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
                if(balance >= amount)
                {
                    transaction++;
                    balance -=amount;
                    System.out.println("\nWithdraw Successfull!!");
                    String str = amount+"Rs Withdrawed\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\n Insufficient Amount!");
                }
        } catch(Exception e) {
        }
    }

    public void deposit() {

        System.out.print("\nEnter the amount to be Deposited: ");
        Scanner sc = new Scanner(System.in);
        float amount=sc.nextFloat();

        try {
            if(amount<=100000f)
            {
                transaction++;
                balance += amount;
                System.out.println("\nSuccessfully deposited");
                String str = amount+"Rs deposited\n";
                transactionHistory=transactionHistory.concat(str);
                } else {
                System.out.println("\nSorry..!! Limit is 100000.00");
            }
        }
        catch (Exception e){
        }
    }

    public void transfer() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent Name: ");
        String receipent=sc.nextLine();
        System.out.print("\nEnter the Amount to be Transferred: ");
        float amount = sc.nextFloat();
        try{
            if (balance >=amount){
                if (amount <= 50000f) {
                    transaction++;
                    
                    balance -=amount;
                    System.out.println("\nSuccessfully transferred to "+receipent);
                    String str = amount+"Rs transferred to "+receipent+"\n";
                    transactionHistory=transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry limit is 50000");
                }
        } else {
                System.out.println("\nInsufficient Balance");
            }
    }
        catch(Exception e) {
        }
    } 
    
    public void checkBalance() {
        System.out.println("\n"+balance+"Rs");
    }
    public void transactionHistory() {

        if(transaction==0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n"+transactionHistory);
        }
    }
}

public class ATMInterface {

    public static int

            takeIntegerInput(int limit){
                int input=0;
                boolean flag=false;
                while(!flag){
                    try {
                        Scanner sc = new Scanner(System.in);
                        input=sc.nextInt();
                        flag=true;
                        if(flag && input > limit || input <1) {
                            System.out.println("Choose the number between 1 to "+limit);
                            flag = false;
                        }
                    }
                    catch(Exception e) {
                    System.out.print("Enter only integer value: ");
                    flag = false;
                    }
                };
                return input;
            }

    public static void main (String[]args) {

        System.out.println("\n**********WELCOME TO THE ATM********");
        System.out.println("1. Register \n2. Exit");
        System.out.print("Enter your choice : ");
        int choice =takeIntegerInput(2);
                
                if(choice==1) {
                    BankAccount b = new BankAccount();
                    b.register();
                    while(true){
                        System.out.println("\n1. Log In \n2. Exit");
                        
                        System.out.print("Enter your choice : ");
                        int ch=takeIntegerInput(2);
                        if(ch==1) {
                            if(b.login()) {
                                System.out.println("\n\n********Welcome Back "+b.name+"********\n");

                                boolean isFinished=false;
                                
                                while(!isFinished) {
                                    
                                    System.out.println("\n1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. Transaction History\n6. Exit");
                                    
                                    System.out.print("Enter your choice : ");
                                    
                                    int c=takeIntegerInput(6);
                                    
                                    switch(c) {

                                        case 1:
                                            b.withdraw();
                                            break;
                                        case 2:
                                            b.deposit();
                                            break;
                                        case 3:
                                            b.transfer();
                                            break;
                                        case 4:
                                            b.checkBalance();
                                            break;
                                        case 5:
                                            b.transactionHistory();
                                            break;
                                        case 6:
                                            isFinished=true;
                                            break;
                                      
                                        }
                                    }
                                }
                        } else {
                                System.exit(0);
                        }
                      
                    }
                } else {
                    System.exit(0);
                }
            }
}