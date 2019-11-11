import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by johnny on 12.06.17.
 */
public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static HashMap<Integer, Client> clients = new HashMap<>();
    private static HashMap<Integer, Worker> workers = new HashMap<>();
    private static int clientId = 0;
    private static int workerId = 0;

    public static void main(String[] args) throws IOException{
        checker();
        br.close();
    }

    private static void checker() throws IOException {
        System.out.println("Please, choose some operation from list below and type in name of it. Name should be EXACTLY same:\n" +
                "Add Client/Add Worker\n" +
                "Remove Client/Remove Worker\n" +
                "Client Information/Worker Information\n" +
                "Manage Account/Manage Position\n" +
                "Print client list/Print worker list\n" +
                "End - to close application");
        String call = br.readLine();
        switch (call){
            case ("Add Client"): {
                clientMaker();
                break;
            }
            case ("Add Worker"): {
                workerMaker();
                break;
            }
            case ("Remove Client"): {
                clientDeleter();
                break;
            }
            case ("Remove Worker"): {
                workerDeleter();
                break;
            }
            case ("Client Information"):{
                System.out.println("Please, enter client id:");
                int clientID = Integer.parseInt(br.readLine());
                if (clients.containsKey(clientID)) {
                    clientPrinter(clientID);
                    break;
                }
                else{
                    System.out.println("There is no such client with this ID, please choose other operation");
                    checker();
                    break;
                }
            }
            case ("Worker Information"):{
                System.out.println("Please, enter worker id:");
                int workerID = Integer.parseInt(br.readLine());
                if (workers.containsKey(workerID)) {
                    workerPrinter(workerID);
                    break;
                }
                else{
                    System.out.println("There is no such worker with this ID, please choose other operation");
                    checker();
                    break;
                }
            }
            case ("Manage Account"):{
                System.out.println("Please, enter client ID and amount to add. To remove enter amount with \"-\" before the number");
                System.out.println("Enter client id:");
                int id = Integer.parseInt(br.readLine());
                if (clients.containsKey(id)) {
                    System.out.println("Enter amount:");
                    int amount = Integer.parseInt(br.readLine());
                    accountManager(id, amount);
                    break;
                }
                else {
                    System.out.println("There is no such client with this ID, please choose other operation");
                    checker();
                    break;

                }
            }
            case ("Manage Position"):{
                System.out.println("Please, enter worker ID and position to change");
                System.out.println("Enter worker id:");
                int id = Integer.parseInt(br.readLine());
                if (workers.containsKey(id)) {
                    System.out.println("Enter position:");
                    String position = br.readLine();
                    positionManager(id, position);
                    break;
                }
                else{
                    System.out.println("There is no such worker with this ID, please choose other operation");
                    checker();
                    break;
                }
            }
            case ("Print client list"):{
                clientListPrinter();
                break;
            }
            case ("Print worker list"):{
                workerListPrinter();
                break;
            }
            case ("End"):{
                System.out.println("Thank you for using this application");
                break;
            }
            default:{
                System.out.println("Please choose valid operation");
                checker();
            }
        }
    }

    private static void clientMaker() throws IOException {
        Client newClient = new Client();
        clientId += 1;
        clients.put(clientId, newClient);
        System.out.println("Please, enter client's name:");
        clients.get(clientId).setName(br.readLine());
        System.out.println("Please, enter client's surname:");
        clients.get(clientId).setSurname(br.readLine());
        System.out.println("Please, enter client's age:");
        clients.get(clientId).setAge(Integer.parseInt(br.readLine()));
        System.out.println("Please, enter client's address:");
        clients.get(clientId).setAddress(br.readLine());
        System.out.println("Please, enter client's account state:");
        clients.get(clientId).setAccount(Integer.parseInt(br.readLine()));
        System.out.println("Client added successfully, ID of added client is: " + clientId);
        checker();
    }

    private static void workerMaker() throws IOException {
        Worker newWorker = new Worker();
        workerId += 1;
        workers.put(workerId, newWorker);
        System.out.println("Please, enter worker's name:");
        workers.get(workerId).setName(br.readLine());
        System.out.println("Please, enter worker's surname:");
        workers.get(workerId).setSurname(br.readLine());
        System.out.println("Please, enter worker's age:");
        workers.get(workerId).setAge(Integer.parseInt(br.readLine()));
        System.out.println("Please, enter worker's address:");
        workers.get(workerId).setAddress(br.readLine());
        System.out.println("Please, enter worker's position:");
        workers.get(workerId).setPosition(br.readLine());
        System.out.println("Worker added successfully, ID of added worker is: " + workerId);
        checker();
    }


    private static void clientDeleter()throws IOException{
        System.out.println("Enter client's id or enter Menu to return to menu:");
        String word = br.readLine();
        if (word.equals("Menu")) {
            checker();
        } else {
            int clientId = Integer.parseInt(word);
            if (clients.containsKey(clientId)) {
                clients.remove(clientId);
                System.out.println("Operation successful");
                checker();
            } else {
                System.out.println("Client with such key does not exist, please, choose other key");
                clientDeleter();
            }
        }
    }

    private static void workerDeleter() throws IOException {
        System.out.println("Enter client's id or enter Menu to return to menu:");
        String word = br.readLine();
        if (word.equals("Menu")) {
            checker();
        } else {
            System.out.println("Please, enter Worker's id:");
            int workerId = Integer.parseInt(br.readLine());
            if (workers.containsKey(workerId)) {
                workers.remove(workerId);
                System.out.println("Operation successful");
                checker();
            } else {
                System.out.println("Worker with such key does not exist, please, choose other key");
                workerDeleter();
            }
        }
    }

    private static void clientPrinter(int clientId) throws IOException{
        System.out.println("Printing client's information:");
        System.out.println("Name: " + clients.get(clientId).getName());
        System.out.println("Surname: " + clients.get(clientId).getSurname());
        System.out.println("Age: " + clients.get(clientId).getAge());
        System.out.println("Address: " + clients.get(clientId).getAddress());
        System.out.println("Account: " + clients.get(clientId).getAccount());
        checker();
    }

    private static void workerPrinter(int workerId) throws IOException{
        System.out.println("Printing worker's information:");
        System.out.println("Name: " + workers.get(workerId).getName());
        System.out.println("Surname: " + workers.get(workerId).getSurname());
        System.out.println("Age: " + workers.get(workerId).getAge());
        System.out.println("Address: " + workers.get(workerId).getAddress());
        System.out.println("Position: " + workers.get(workerId).getPosition());
        checker();
    }

    private static void accountManager(int clientID, int amount) throws IOException{
        if (clients.get(clientID).getAccount() + amount < 0){
            System.out.println("Account cant go below 0, please enter other amount:");
            accountManager(clientID, Integer.parseInt(br.readLine()));
        }
        else {
            clients.get(clientID).setAccount(clients.get(clientID).getAccount() + amount);
            System.out.println("Operation successful");
            checker();
        }
    }

    private static void positionManager(int workerId, String position) throws IOException{
        workers.get(workerId).setPosition(position);
        System.out.println("Operation successful");
        checker();
    }

    private static void clientListPrinter() throws IOException{
        Iterator it = clients.entrySet().iterator();
        String value;
        System.out.println("Client list:\n");
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            value = clients.get(pair.getKey()).getName();
            System.out.println(pair.getKey() + " - " + value);
        }
        checker();
    }

    private static void workerListPrinter() throws IOException{
        Iterator it = workers.entrySet().iterator();
        String value;
        System.out.println("Worker list:\n");
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            value = workers.get(pair.getKey()).getName();
            System.out.println(pair.getKey() + " - " + value);
        }
        checker();
    }
}