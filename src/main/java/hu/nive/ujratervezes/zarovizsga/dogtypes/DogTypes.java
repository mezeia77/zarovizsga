package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DogTypes {
    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("select name from dog_types where country = ? "))
        {
            stmt.setString(1, country);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    result.add(name.toLowerCase());
                }
            } catch (SQLException sqlException) {
                throw new IllegalStateException("Cannot execute", sqlException);
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("No data found", sqlException);
        }
        Collections.sort(result);
        return result;
    }
}
