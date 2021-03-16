package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        List<String> names = new ArrayList<>();
        List<Integer> hours = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(file))){
            String line;
            while ((line = br.readLine())!=null){
                String [] parts = line.split(",");

                String name = parts[0];
                int hour = Integer.parseInt(parts[1]);
                String date = parts[2];

                names.add(name);
                hours.add(hour);
                dates.add(date);

            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found");
        }

        int minHours = Integer.MAX_VALUE;
        String minName = "";
        String minDate = "";

        for (int i=0; i<hours.size(); i++){
            if(hours.get(i)<minHours){
                minHours = hours.get(i);
                minName = names.get(i);
                minDate = dates.get(i);
            }
        }

        return minName + ": " + minDate;
    }
}
