package api.endpoinds;

import com.hossain.ebrahim.api.base.BaseAPI;
import io.restassured.response.Response;

public class AuthEndpoint extends BaseAPI {
    private static final String AUTH_ENDPOINT = "/auth";

    public Response createToken(String authBody) {
        return post(AUTH_ENDPOINT, authBody);
    }
}
