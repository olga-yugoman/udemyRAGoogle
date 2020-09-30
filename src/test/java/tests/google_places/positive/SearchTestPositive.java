package tests.google_places.positive;

import api.models.google_places.GooglePlacesModel;
import base.BaseTest;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.Constants.API_KEY;

public class SearchTestPositive extends BaseTest {

    @Test(description = "search smth", dataProvider = "searchText")
    public void searchPlaceWithText(String key, String input, String inputtype) {
        GooglePlacesModel.RequestModel requestModel = GooglePlacesModel.RequestModel.builder()
                .key(key)
                .input(input)
                .inputtype(inputtype)
                .build();

        apiManager.getGooglePlacesModel().search(requestModel, Method.GET, 200);
    }

    @DataProvider
    public Object[] [] searchText() {
        return new Object[][] {
                {API_KEY, "New York", "textquery"}
        };
    }
}
