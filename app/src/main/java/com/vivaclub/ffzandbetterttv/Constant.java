package com.vivaclub.ffzandbetterttv;

public class Constant {
    public static final String IRC_TWITC_URL = "irc.chat.twitch.tv";
    public static final String SAVE_FILE_NAME = "FFZandBetterTTV_Save_Token";

    public static final String URL_TWITCH_HELIX_USERS= "https://api.twitch.tv/helix/users";
    public static final String URL_TWITCH_HELIX= "https://api.twitch.tv/helix";
    public static final String CLIEND_ID= "6x0udfh1ugiitkya8xwrtm8mn4oh4e";


    public static final String GET_TOKEN_TWITCH_URL = "https://id.twitch.tv/oauth2/authorize" +
            "?response_type=token" +
            "&client_id=6x0udfh1ugiitkya8xwrtm8mn4oh4e" +
            "&redirect_uri=http://localhost" +
            "&scope=" +
            "chat:read+" +
            "chat:edit+" +
            "user:read:email+" +
            "user_read";
}
