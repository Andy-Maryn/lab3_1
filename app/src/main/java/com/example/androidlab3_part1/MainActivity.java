package com.example.androidlab3_part1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<Film> data = createList();
        ListView list = findViewById(R.id.list);

        // Создаем объект адаптера
        MyAdapter adapter = new MyAdapter(this, data);

        // Передаем его виджету списка
        list.setAdapter(adapter);

        // clicking on item
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //send data to second activity
                intent.putExtra("title", ((Film)list.getItemAtPosition(i)).getTitle());
                intent.putExtra("date", ((Film)list.getItemAtPosition(i)).getDate());
                intent.putExtra("origin", ((Film)list.getItemAtPosition(i)).getOrigin());
                intent.putExtra("description", ((Film)list.getItemAtPosition(i)).getDescription());
                intent.putExtra("image", ((Film)list.getItemAtPosition(i)).getAvatarId());

                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Film> createList() {

        List<Film> films = new ArrayList<>();

        // putting data to list
        films.add(new Film("Герой СамСам",
                R.drawable.film1,
                "20.10.2020",
                "СамПланета в опасности! На родную обитель знаменитого СамСама напали Мрачуны — инопланетные жуки, которые распространяют по всей Вселенной… грусть.",
                "Украина"));
        films.add(new Film(
                "Капитан Саблезуб и сокровища Лама Рама",
                R.drawable.film2,
                "1.10.2021",
                "Увлекательные приключения отважного и грозного капитана Саблезуба, бороздящего моря и океаны в поисках несметных сокровищ. ",
                "Норвегия"));
        films.add(new Film(
                "Лесси. Возвращение домой",
                R.drawable.film3,
                "20.06.2019",
                "Двенадцатилетний Флориан и его колли Лесси — неразлучные друзья. Они счастливо живут в немецкой деревеньке. Когда отец Флориана лишается работы, семье приходится переезжать в дом поменьше, т. к. с собаками туда нельзя. ",
                "Франция"));
        films.add(new Film(
                "Ненасытная",
                R.drawable.film4,
                "05.01.2019",
                "Сериал посвящён тренеру Роберту Армстронгу (Бобу), который берёт запуганную девушку Пэтти своим клиентом. " +
                        "Девушку травят и даже избивают сверстники из-за её полноты. Она получает травму от удара в челюсть, и на время лечения ей стало необходимым держать рот закрытым[10]",
                "Албания"));
        return films;
    }



    // class for list items
    class Film {
        private String title;
        private String date;
        private String description;
        private int avatarId;
        private String origin;

        public Film(String title,int avatarId, String date, String description, String origin) {
            this.title = title;
            this.date = date;
            this.description = description;
            this.avatarId = avatarId;
            this.origin = origin;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getAvatarId() {
            return avatarId;
        }

        public void setAvatarId(int avatarId) {
            this.avatarId = avatarId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
    }
}


