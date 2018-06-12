package app.oswaldogh89.marvelhero.Entities;

public class Heroe {
    private String name;
    private String description;
    private thumbnail thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public app.oswaldogh89.marvelhero.Entities.thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(app.oswaldogh89.marvelhero.Entities.thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
