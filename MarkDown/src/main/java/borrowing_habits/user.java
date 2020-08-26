package borrowing_habits;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
public class user {
    private final String name;
    private final List<Iou> owes;
    private final List<Iou> owedBy;

    private user(String name, List<Iou> owes, List<Iou> owedBy) {
        this.name = name;
        this.owes = new ArrayList<>(owes);
        this.owedBy = new ArrayList<>(owedBy);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String name() {
        return name;
    }

    /**
     * IOUs this user owes to other users.
     */
    public List<Iou> owes() {
        return unmodifiableList(owes);
    }

    /**
     * IOUs other users owe to this user.
     */
    public List<Iou> owedBy() {
        return unmodifiableList(owedBy);
    }

    public void addOwe(Iou owe) {
        addToList(owe, owes, owedBy);
    }

    public void addOwedBy(Iou owe) {
        addToList(owe, owedBy, owes);
    }

    private void addToList(Iou owe, List<Iou> toList, List<Iou> otherList) {
        Iou iou = getIou(owe, toList);
        if (iou != null) {
            toList.remove(iou);
            toList.add(new Iou(owe.name, owe.amount + iou.amount));
            return;
        }

        iou = getIou(owe, otherList);
        if (iou == null) {
            toList.add(owe);
            return;
        }

        otherList.remove(iou);
        double rest = iou.amount - owe.amount;
        if (rest > 0) {
            otherList.add(new Iou(owe.name, rest));
        } else if (rest < 0) {
            toList.add(new Iou(owe.name, -rest));
        }
    }

    private Iou getIou(Iou owe, List<Iou> iouList) {
        return iouList.stream().filter(o -> o.name.equals(owe.name)).findFirst().orElse(null);
    }

    public double getBalance() {
        return owedBy().stream().mapToDouble(iou -> iou.amount).sum()
                - owes().stream().mapToDouble(iou -> iou.amount).sum();
    }

    public JSONObject toJSONObject() {
        return new JSONObject()
                .put("name", name())
                .put("owes", getOwesJson())
                .put("owedBy", getOwedByJson())
                .put("balance", getBalance());
    }

    private JSONObject getOwesJson() {
        JSONObject jsonObject = new JSONObject();
        owes().forEach(iou -> jsonObject.put(iou.name, iou.amount));
        return jsonObject;
    }

    private JSONObject getOwedByJson() {
        JSONObject jsonObject = new JSONObject();
        owedBy().forEach(iou -> jsonObject.put(iou.name, iou.amount));
        return jsonObject;
    }

    public static class Builder {
        private final List<Iou> owes = new ArrayList<>();
        private final List<Iou> owedBy = new ArrayList<>();
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder owes(String name, double amount) {
            owes.add(new Iou(name, amount));
            return this;
        }

        public Builder owedBy(String name, double amount) {
            owedBy.add(new Iou(name, amount));
            return this;
        }

        public user build() {
            return new user(name, owes, owedBy);
        }
    }

}
