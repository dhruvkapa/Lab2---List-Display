public class Item {
    private String title;
    private int imageResId;
    private String description;

    // Constructor
    public Item(String title, int imageResId, String description) {
        this.title = title;
        this.imageResId = imageResId;
        this.description = description;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
