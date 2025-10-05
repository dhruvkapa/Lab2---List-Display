package com.example.listdisplay;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    public final String title;
    public final int imageResId;
    public final String description;

    public Recipe(String title, int imageResId, String description){
        this.title = title;
        this.imageResId = imageResId;
        this.description = description;
    }

    public static List<Recipe> sample(){
        return Arrays.asList(
                new Recipe("Jollof Rice", R.drawable.jollof, "Ghana - Tomato-spiced rice"),
                new Recipe("Waakye", R.drawable.waakye, "Ghana - Rice & beans with sorghum hue"),
                new Recipe("Banku & Tilapia", R.drawable.banku_tilapia, "Ghana - Fermented corn dough with grilled fish"),
                new Recipe("Kelewele", R.drawable.kelewele, "Ghana - Spiced caramelized plantains"),
                new Recipe("Red-Red", R.drawable.red_red, "Ghana - Bean stew with fried plantain"),
                // Indian dishes
                new Recipe("Chicken Biryani", R.drawable.chicken_biryani, "India - Fragrant layered rice with spiced chicken"),
                new Recipe("Masala Dosa", R.drawable.masala_dosa, "India - Crispy crêpe with spiced potato"),
                new Recipe("Butter Chicken", R.drawable.butter_chicken, "India - Creamy tomato-butter gravy"),
                new Recipe("Chole Bhature", R.drawable.chole_bhature, "India - Spiced chickpeas with fried bread"),
                new Recipe("Paneer Tikka", R.drawable.paneer_tikka, "India - Marinated grilled paneer"),
                //
                new Recipe("Kacchi Biryani", R.drawable.kacchi_biryani, "Bangladesh - Dhaka-style mutton biryani with potatoes"),
                new Recipe("Morog Polao", R.drawable.morog_polao, "Bangladesh - Aromatic chicken pilaf with milk & ghee"),
                new Recipe("Shorshe Ilish", R.drawable.shorshe_ilish, "Bangladesh - Hilsa fish in mustard gravy"),
                new Recipe("Bhuna Khichuri", R.drawable.bhuna_khichuri, "Bangladesh - Spiced rice–lentil one-pot"),
                new Recipe("Begun Bhorta", R.drawable.begun_bhorta, "Bangladesh - Smoky mashed eggplant, mustard oil & chilies")
        );
    }
}
