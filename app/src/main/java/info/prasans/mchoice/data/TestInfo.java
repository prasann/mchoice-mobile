package info.prasans.mchoice.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable

public class TestInfo {
    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
