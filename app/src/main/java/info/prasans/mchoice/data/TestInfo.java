package info.prasans.mchoice.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Getter;
import lombok.Setter;

@DatabaseTable
@Getter
@Setter
public class TestInfo {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(unique = true, index = true)
    private String code;
    @DatabaseField
    private int count;
    @DatabaseField
    private int wrongScore = 0;
    @DatabaseField
    private int correctScore = 1;
    @DatabaseField
    private boolean active = true;
    @DatabaseField
    private String answerString;

    public TestInfo(String name, String code, int count) {
        this.name = name;
        this.code = code;
        this.count = count;
    }
}
