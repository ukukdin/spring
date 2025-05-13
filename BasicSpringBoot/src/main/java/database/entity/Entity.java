package database.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class Entity implements PrimaryKey{

    @Getter
    @Setter
    private Long id;


}
