package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int idThem = 1;
    static boolean isChecked = true;
    MenuItem menuItem;
    String[] engines = { "Unity", "Unreal Engine", "GameMaker Studio", "Defold", "Godot" };
    String[] descriptions = {
            "Unity появился аж в 2005 году, и это до сих пор один из любимых движков в инди-среде наравне с более продвинутым Unreal Engine 4.\n"+
            "Главное преимущество движка — большое сообщество и множество официальных и неофициальных «обучалок». Создатели программы даже запустили портал Unity Learn с курсами о разных аспектах работы с движком.\n" +
            "Unity практически не ограничивает пользователя: в движке можно работать с 2D и 3D, VR и любыми жанрами от «три в ряд» до шутеров от первого лица.\n"
            ,"Новая версия движка, Unreal Engine 5, — потенциальный прорыв для всей индустрии. Благодаря системе Nanite художникам больше не нужно беспокоиться об оптимизации ассетов под разные системы: движок сделает это самостоятельно. А технология Lumen автоматически обрабатывает источники света — раньше на подобные системы приходилось тратить немало ресурсов.\n" +
            "В последнее время Epic Games делает все, чтобы у пользователей Unreal Engine был доступ к самым продвинутым технологиям — взять хотя бы конструктор людей MetaHuman, который позволяет за пару секунд создать реалистичную модель человека.\n" +
            "Неудобство UE в том, что он во многом ориентирован на профессионалов. Визуальное программирование Blueprint тратит больше ресурсов системы, чем код на C++, поэтому большой проект совсем без программирования сделать не получится.\n"
           ,"GameMaker Studio — один из самых известных игровых движков наравне с Unity и Unreal Engine. На нем сделаны многие инди-хиты вроде Undertale, а еще у него очень низкий порог вхождения: для GameMaker необязательно умение программировать, и все взаимодействия можно настраивать буквально «перетягиванием».\n" +
            "Впрочем, писать код в нем тоже можно — создатели даже разработали специальный язык, GML (Game Maker Language). У него меньше возможностей, чем у того же C#, а некоторые его особенности не встречаются в других языках, зато он очень прост в освоении и подойдет как опытным программистам, так и новичкам.\n" +
            "GameMaker Studio не просто хорошо оптимизирован — в нем немало инструментов для работы над играми в любых жанрах. Так что это хороший выбор для тех, кто хочет погрузиться в геймдизайн и не тратить время на «математику» и поиск расширений.\n"
           ,"Defold — один из главных конкурентов Unity, но используют его намного реже. Он рассчитан на двухмерные игры, которые программируются на языке Lua и запускаются почти на всех платформах — от HTML5 (веб-страницы) до Nintendo Switch. Поэтому он быстро работает и компилирует маловесные билды, в отличие от того же Unity.\n" +
            "У Defold нет встроенного визуального программирования, но есть фанатский плагин, который его добавляет. Также в сети опубликовано много обучающего материала по нему, но меньше, чем у конкурентов.\n" +
            "Как и любой молодой движок, Defold постоянно развивается, так что все недостатки могут исправить в будущем. Сейчас же это необычная альтернатива Unity для тех, кто хочет попробовать себя в программировании, но не желает погружаться в трудности семейства C, общепринятого в «большой» индустрии."
            ,"Godot — это «выбор на перспективу», который примечателен постоянными обновлениями. Он максимально открыт — за движок не надо платить, а на GitHub лежит его исходный код, в котором может покопаться любой желающий. А еще в Godot большой выбор языков программирования соседствует с визуальным скриптованием: сегодня утилита поддерживает C, C# и собственный GDScript, который напоминает Python.\n" +
            "Открытый исходный код движка позволяет участвовать в его разработке всем желающим: например, исправлять баги или предлагать новые функции.\n" +
            "Главная проблема движка в его «перспективности»: Godot разрабатывают уже 14 лет, но в нем до сих пор не очень удобно работать в 3D, а сообщество намного меньше в сравнении с другими продуктами. Ну и разрабатывать консольные игры в нем сложно из-за того, что там нельзя издавать игры, сделанные на полностью открытом ПО без лицензии. К счастью, сооснователь компании-разработчика движка как раз открыл студию для портирования игр с Godot на консоли."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(idThem == 1) this.setTheme(R.style.them1);
        if(idThem == 2) this.setTheme(R.style.them2);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        if(!isChecked) textView.setVisibility(View.INVISIBLE);
        ImageView imageView = findViewById(R.id.imageView);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, engines);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        imageView.setImageResource(R.drawable.unity);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.unreal_engine);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.gm);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.defold);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.godot);
                        break;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400, 400);
                imageView.setLayoutParams(layoutParams);
                textView.setText(descriptions[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        menuItem = menu.findItem(R.id.vis);
        menuItem.setChecked(isChecked);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        TextView textView = findViewById(R.id.textView);
        if(id == R.id.s1) {
            idThem = 1;
            recreate();
            return true;
        }
        if(id == R.id.s2) {
            idThem = 2;
            recreate();
            return true;
        }
        if (id == R.id.vis){
            if (textView.getVisibility() == View.VISIBLE){
                item.setChecked(false);
                isChecked = false;
                textView.setVisibility(View.INVISIBLE);
            }
            else {
                item.setChecked(true);
                isChecked = true;
                textView.setVisibility(View.VISIBLE);
            }

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setTitle("Отображение состояния!");
            dialog.setContentView(R.layout.dlg);
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}