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
    @DatabaseField(unique = true)
    private String code;
    @DatabaseField
    private int count;
    @DatabaseField
    private int wrongScore;
    @DatabaseField
    private int correctScore;
    @DatabaseField
    private boolean active;
}
