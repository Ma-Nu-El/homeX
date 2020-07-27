package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {

    public void executeShellCommand(String command) {

        try {
            Process process = Runtime.getRuntime().exec(command);
            // command won't expand variables or run relative path binaries.
            // Specify the absolute path to a script. Something like this:
            //Process process = Runtime.getRuntime().exec("/home/ma/bin/test");
            // where '/home/ma/bin/test' is supposed to be a shell script.

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                //System.out.println("Success!");
                System.out.println(output);
                //System.exit(0); // don't want to exit immediately
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
}
