package models;

import lombok.Data;

@Data
public class CreateTokenBodyModel {
    String username;
    String password;
}
