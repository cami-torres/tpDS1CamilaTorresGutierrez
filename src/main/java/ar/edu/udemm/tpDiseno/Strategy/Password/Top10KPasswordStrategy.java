package ar.edu.udemm.tpDiseno.Strategy.Password;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sun.tools.javac.Main;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

@Service
public class Top10KPasswordStrategy implements PasswordStrategy {
    private Map<String, Boolean> top10k = new HashMap<>();

    public Top10KPasswordStrategy() throws Exception {
        InputStream top10kInputStream = Main.class.getClassLoader().getResourceAsStream("top10k.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(top10kInputStream));
        String line;
        while ((line = br.readLine()) != null) {
            top10k.put(line, true);
        }
        br.close();
    }

    @Override
    public boolean validate(UserPasswordDTO userPassword) {
        return top10k.get(userPassword.getPassword()) == null;
    }

}
