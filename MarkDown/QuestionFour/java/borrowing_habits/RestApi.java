package java.borrowing_habits;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RestApi {
    private final List<user> userList = new ArrayList<>();

    public RestApi(user... users) {
        userList.addAll(Arrays.asList(users));
        userList.sort(Comparator.comparing(user::name));
    }

    public String get(String url) {
        if ("/users".equals(url)) {
            JSONArray result = new JSONArray();
            userList.forEach(user -> result.put(user.toJSONObject()));
            return new JSONObject().put("users", result).toString();
        }
        throw new IllegalArgumentException();
    }

    public String get(String url, JSONObject payload) {
        if ("/users".equals(url)) {
            JSONArray result = new JSONArray();
            JSONArray users = payload.getJSONArray("users");
            List<String> names = new ArrayList<>();
            for (Object object : users) {
                names.add((String) object);
            }
            names.sort(Comparator.naturalOrder());
            names.stream().map(this::finduserByName).forEach(user -> result.put(user.toJSONObject()));
            return new JSONObject().put("users", result).toString();
        }
        throw new IllegalArgumentException();
    }

    public String post(String url, JSONObject payload) {
        switch (url) {
            case "/add":
                String name = payload.getString("user");
                user user1 = user.builder().setName(name).build();
                userList.add(user1);
                userList.sort(Comparator.comparing(user::name));
                return user1.toJSONObject().toString();
            case "/iou":
                String lender = payload.getString("lender");
                String borrower = payload.getString("borrower");
                double amount = payload.getDouble("amount");
                user lenderuser = finduserByName(lender);
                lenderuser.addOwedBy(new Iou(borrower, amount));
                user borroweruser = finduserByName(borrower);
                borroweruser.addOwe(new Iou(lender, amount));

                JSONObject payloadGet = new JSONObject().put("users", new JSONArray().put(lender).put(borrower));
                return get("/users", payloadGet);
            default:
                throw new IllegalArgumentException();
        }
    }

    private user finduserByName(String name) {
        return userList.parallelStream().filter(user -> user.name().equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
