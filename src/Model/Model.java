package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {

    // This variable stores the output of the shell
    private StringBuilder auxOutput;

    // Method to execute the command and store its output in the
    // auxOutput variable
    // https://mkyong.com/java/how-to-execute-shell-command-from-java/
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
                this.auxOutput = output; // here's the money
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

    // This method is the one you call from the controller.
    public StringBuilder getShellOutput(String command){
        executeShellCommand(command);
        return this.auxOutput;
    }

}
