package app.auth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Access_token {
    private String accessToken;
}


/*

private int expiresIn;
    private int refreshExpiresIn;
    private String refreshToken;
    private String tokenType;
    private int notBeforePolicy;
    private String sessionState;
    private String scope;

 */