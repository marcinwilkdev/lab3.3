import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProgramCPP {
    private String path;
    private String arguments;

    public ProgramCPP(String path, String arguments) {
        this.path = path;
        this.arguments = arguments;
    }

    public ArrayList<String> getOutputLines() {
        ArrayList<String> result = new ArrayList<>();

        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(path + " " + arguments);

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return result;
    }
}
