package app.camnanglaixe.com.android.models;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taypham on 29/11/2016.
 */
public class SubTopicObject {
    public String id;
    public String title;
    public String type_name;
    public String category_id;
    public List<ContentDetailRule> content;


    public SubTopicObject(String id, String title, String type_name, String category_id, JSONArray contentArray){
        this.id = id;
        this.title = title;
        this.type_name = type_name;
        this.category_id = category_id;
        content = new ArrayList<ContentDetailRule>();
        try {
            for (int i = 0; i < contentArray.length(); i++) {
                String contentDetail = contentArray.getJSONObject(i).optString("detail");
                String contentTitle = contentArray.getJSONObject(i).optString("title");
                String contentImage = contentArray.getJSONObject(i).optString("image");
                ContentDetailRule contentDetailRule = new ContentDetailRule(contentTitle, contentDetail, contentImage);
                content.add(contentDetailRule);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}
