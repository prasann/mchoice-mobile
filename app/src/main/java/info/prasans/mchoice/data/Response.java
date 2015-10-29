package info.prasans.mchoice.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@DatabaseTable
@Getter
@Setter
public class Response {

    @DatabaseField(foreign = true)
    private TestInfo testInfo;
    @DatabaseField
    private String sender;
    @DatabaseField
    private String content;
    @DatabaseField
    private Time receivedAt;
    @DatabaseField
    private int score;
    @DatabaseField
    private int count;
    @DatabaseField
    private boolean archived;
}
