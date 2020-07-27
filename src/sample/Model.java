package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {

    private StringBuilder auxOutput;

    public void executeShellCommand(String command) {

        try {
            Process process = Runtime.getRuntime().exec(command);
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                this.auxOutput = output;
            } else {
                System.out.println("Sorry: something went wrong");
            }

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Model() {

    }

    public StringBuilder getShellOutput(String command){
        executeShellCommand(command);
        return this.auxOutput;
    }

}
