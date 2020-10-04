package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    ListView countryListView;
    Spinner continentSpinner;
    TextView capitalTextView;
    TextView populationSizeTextView;
    TextView officialLanguageTextView;
    TextView anthemNameTextView;

    final static int ASIA = 1;
    final static int EUROPE = 2;
    final static int AFRICA = 3;
    final static int AMERICA = 4;

    String[] continents = {"Continent", "Asia", "Europe", "Africa", "America"};
    String[][] countries = {
            new String[] {},
            new String[] {"India", "Turkey", "Japan", "Jordan", "Israel", "Lebanon", "China"},
            new String[] {"Austria", "Belgium", "France", "Greece", "Poland", "Russia", "Sweden"},
            new String[] {"Chad", "Egypt", "Ethiopia", "Kenya", "Sudan", "Uganda", "Morocco"},
            new String[] {"Brazil", "Canada", "El Salvador", "Haiti", "Mexico", "Panama", "United States"}
    };


    String[][] asiaCountries = {
            {"New Delhi", "1.353 billion", "Hindi", "Jana Ghana Mana"}, // india
            {"Ankara", "82 million", "Turkish", "İstiklâl Marşı"},// turkey
            {"Tokyo", "126.5 million", "Japanese", "君が代"}, // japan
            {"Amman", "9.956 million", "Arabic", "السلام الملكي الأردني"},
            {"Jerusalem", "8.884 million", "Hebrew", " Hatikva"},
            {"Beirut", "6.849 million", "Arabic", " كلنا للوطن للعلى للعلم"},
            {"Beijing", "1.393 billion", "language", "义勇军进行曲"},
    };

    String[][] europeCountries = {
            {"Vienna", "8.859 million", "German", "Land der Berge, Land am Strome"}, // austria
            {"Brussels", "11.46 million", "Dutch, French and German", "La Brabançonne"},
            {"Paris", "66.99 million", "French", "La Marseillaise"},
            {"Athens", "10.72 million", "Greek", "Ὕμνος εἰς τὴν" +
                    " Ἐλευθερίαν"},
            {"Warsaw", "37.97 million", "Polish", "Mazurek " +
                    "Dąbrowskiego"},
            {"Moscow", "144.5 million", "Russian", "Государственный " +
                    "гимн РФ"},
            {"Stockholm", "10.23 million", "Swedish", "Du gamla, Du fria"},
    };

    String[][] africaCountries = {
            {"Najmana", "15.48 million", "Arabic, French", "La Tchadienne"},
            {"Cairo", "98.42 million", "Arabic", "بلادي بلادي بلادي"},
            {"Addis Ababa", "109.2 million", "Amharic", "ወደፊት ገስግሺ ውድ " +
                    "እናት ኢትዮጵያ"},
            {"Nairobi", "51.39 million", "English, Swahili", "G-d of all " +
                    "beings"},
            {"Prow", "41.8 million", "Arabic, English", "نحن جند الله جند الوطن"},
            {"Kampala", "42.72 million", "English, Swahili", "Oh Uganda, " +
                    "Land of Beauty"},
            {"Rabat", "36.03 million", "Arabic", "النشيد الشريف"},
    };

    String[][] americaCountries = {
            {"Brasilia", "209.5 million", "Portuguese", "Hino Nacional " +
                    "Brasileiro"},
            {"Ottawa", "37.59 million", "English and French", "O Canada"},
            {"San Salvador", "6.421 million", "Spanish", "Himno Nacional " +
                    "de El Salvador"},
            {"Port au Prince", "11.12 million", "French, slow Creole", "La Dessalinienne"},
            {"Mexico City", "126.2 million", "Spanish", "Himno Nacional " +
                    "Mexicano"},
            {"Panama City", "4.177 million", "Spanish", "Himno Istmeño"},
            {"Washington", "328.2 million", "English", "The Star-" +
                    "Spangled Banner"},
    };

    int selectedContinentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryListView = findViewById(R.id.countryListView);
        continentSpinner = findViewById(R.id.continentSpinner);
        capitalTextView = findViewById(R.id.capitalTextView);
        populationSizeTextView = findViewById(R.id.populationSizeTextView);
        officialLanguageTextView = findViewById(R.id.officialLanguageTextView);
        anthemNameTextView = findViewById(R.id.anthemNameTextView);

        countryListView.setOnItemClickListener(this);

        // הגדרת יבשות לספינר
        ArrayAdapter<String> continentAdapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item,
                continents);
        continentSpinner.setAdapter(continentAdapter);
        continentSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // הגדרת מדינות ללליסט וויו
        ArrayAdapter<String> adp = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item,
                countries[position]);
        countryListView.setAdapter(adp);
        selectedContinentIndex = position;
        if(position == 0) {
            capitalTextView.setText("");
            populationSizeTextView.setText("");
            officialLanguageTextView.setText("");
            anthemNameTextView.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[][] contintentCountries;

        switch(selectedContinentIndex) {
            case ASIA:
                contintentCountries = asiaCountries;
                break;
            case EUROPE:
                contintentCountries = europeCountries;
                break;
            case AFRICA:
                contintentCountries = africaCountries;
                break;
            default:
            case AMERICA:
                contintentCountries = americaCountries;
                break;
        }

        capitalTextView.setText(contintentCountries[position][0]);
        populationSizeTextView.setText(contintentCountries[position][1]);
        officialLanguageTextView.setText(contintentCountries[position][2]);
        anthemNameTextView.setText(contintentCountries[position][3]);
    }
}
