import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by johnny on 12.06.17.
 */
public class Client extends Person{

    private int account;

    public int getAccount(){
        return account;
    }

    public void setAccount(int account) throws IOException{
        if (account < 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Cant go below 0, please enter other amount");
            setAccount(Integer.parseInt(br.readLine()));
        }
        else
            this.account = account;
    }
}
