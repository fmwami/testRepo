package models;

import javax.persistence.*;

/**
 * Created by faima on 2/24/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@TableGenerator(name = "Characters")
public class Characters{
    @Id
    @GeneratedValue
    private int characterid;
    private int characterName;

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
    }

    public int getCharacterName() {
        return characterName;
    }

    public void setCharacterName(int characterName) {
        this.characterName = characterName;
    }
}

